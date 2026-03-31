/**
 * rustFrida script for Palmchat new SMS chain only.
 *
 * Scope:
 * 1. Watch libmsaoaidsec.so load and neutralize known anti-hook worker threads.
 * 2. Capture new SMS send flow and captcha pre-TLS Java evidence.
 * 3. Track EncryptUtils native registration points for follow-up native evidence.
 *
 * Compatible with kkkbbb/rustFrida QuickJS API:
 * - hook()/Module/Jni/Java.ready
 * - no Interceptor/Process/NativeCallback
 */

var TARGET_SO_NAME = "libmsaoaidsec.so";
var KNOWN_THREAD_OFFSETS = [0x1c544, 0x1b8d4, 0x26e5c];
var NEW_SEND_SMS_PATH = "/one/ax/auth.login.by.sendsms";
var CAPTCHA_REGISTER_PATH = "/ca/v1/register";
var CAPTCHA_VERIFY_PATH = "/ca/v2/fverify";
// Prioritize request/response observability over native recovery to reduce callback drops.
var MODE_REQRESP_PRIORITY = true;
var ENABLE_THREAD_RET_PATCH = false;
var TARGET_CLASS_NAME = "com.zenmen.palmchat.utils.EncryptUtils";
var PTHREAD_HOOK_MODE = (typeof Hook !== "undefined") ? Hook.NORMAL : 0;
var NATIVE_HOOK_MODE = PTHREAD_HOOK_MODE;
var ALLOW_PTHREAD_HOOK_FALLBACK = true;
var JAVA_STEALTH_MODE = (typeof Hook !== "undefined") ? Hook.NORMAL : 0;
var PASSIVE_OBSERVE_ONLY = true;
var ENABLE_GLOBAL_JSON_PROBES = false;
var ENABLE_SW4_REFLECTION = true;
var ENABLE_UPSTREAM_BUILDER_HOOKS = true;
var ENABLE_NETWORK_HELPER_HOOKS = true;
var ENABLE_JAVA_OBSERVE = true;
var ENABLE_STACK_CAPTURE = false;
var ENABLE_CTOR_HOOK = true;
var ENABLE_ENCRYPT_HOOK = true;
var ENABLE_HEADER_HOOK = true;
var ENABLE_BODY_PRODUCE_HOOK = true;
var ENABLE_REQUESTQUEUE_HOOK = true;
var ENABLE_BASICNETWORK_HOOK = true;
var ENABLE_FULL_HEX_CHUNKS = false;
var ENABLE_REGISTER_NATIVES_HOOK = MODE_REQRESP_PRIORITY ? false : true;
var ENABLE_FINDCLASS_RECOVERY_HOOK = MODE_REQRESP_PRIORITY ? false : true;
var ENABLE_ENCRYPT_NATIVE_BUFFER_HOOK = MODE_REQRESP_PRIORITY ? false : true;
var ENABLE_DLOPEN_TRACE = false;
var ENABLE_TRACKED_JSON_PROBES = false;
var HEX_INLINE_MAX = 256;
var HEX_CHUNK_SIZE = 512;
var NATIVE_BUFFER_PREVIEW_MAX = 96;
var NATIVE_CALL_LIMIT_PER_METHOD = 80;
var NATIVE_TARGET_MODULE_KEYWORDS = ["zhangxin", "wksec", "msaoaidsec", "native-lib"];
var ENABLE_JNI_TABLE_RECOVERY = MODE_REQRESP_PRIORITY ? false : true;
var JNI_TABLE_SCAN_MODULE = "libzhangxin.2.so";
var ENABLE_PASSIVE_RECOVERY_RETRY = MODE_REQRESP_PRIORITY ? false : true;
var PASSIVE_RECOVERY_INTERVAL_MS = 1000;
var PASSIVE_RECOVERY_MAX_ATTEMPTS = 30;
var KNOWN_ENCRYPT_JNI_TARGETS = [
    { name: "setLxData", sig: "(Ljava/lang/String;)V" },
    { name: "createCKey", sig: "()Ljava/lang/String;" },
    { name: "getEncryptedCKey", sig: "(Ljava/lang/String;)Ljava/lang/String;" },
    { name: "cipherWithHashKey", sig: "(Lorg/json/JSONObject;IZ)[B" }
];

var patchedOffsets = {};
var javaHooksInstalled = false;
var registerNativesHookInstalled = false;
var findClassHookInstalled = false;
var findClassHookAddr = null;
var encryptNativeHooksInstalled = {};
var dummyThreadRoutine = null;
var trackedRequests = {};
var trackedJsonObjects = {};
var jsonObjectDrafts = {};
var jsonStringifiedBodies = {};
var recentSetLxDataEvents = [];
var jsonToStringSeenCount = 0;
var builderReflectCount = 0;
var traceByRequestPtr = {};
var traceByBodyObj = {};
var traceBySw4Obj = {};
var traceByUrl = {};
var binaryShaByTrace = {};
var binaryOriginBySha256 = {};
var binaryEventSeen = {};
var pthreadCreateAddr = null;
var threadHookRetired = false;
var nativeCallCountByMethod = {};
var jniTableScanDone = false;
var passiveRecoveryRunning = false;
var passiveRecoveryFinished = false;
var dlopenHookedByAddr = {};
var lastDlopenRecoveryTs = 0;
var javaJsonBridge = null;
var javaSystemClass = null;
var throwableClass = null;
var threadClass = null;
var javaStringClass = null;
var javaBase64Class = null;
var javaMessageDigestClass = null;

function log(msg) {
    console.log("[rustfrida:new_sms] " + msg);
}

function now() {
    try {
        return Date.now();
    } catch (_) {
        return 0;
    }
}

function emitEvidence(obj) {
    try {
        console.log("PC_EVIDENCE " + JSON.stringify(obj));
    } catch (e) {
        log("emitEvidence error: " + e);
    }
}

function modePrefersStealth(mode) {
    try {
        if (typeof Hook !== "undefined" && Hook) {
            if (mode === Hook.WXSHADOW) {
                return true;
            }
            if (mode === Hook.NORMAL) {
                return false;
            }
        }
    } catch (_) {}
    return mode === 1;
}

function hookCompat(targetAddr, callback, mode) {
    var addr = ptrOrNull(targetAddr);
    if (isNullPtr(addr)) {
        throw new Error("hookCompat target is null");
    }
    var useStealth = modePrefersStealth(mode);
    try {
        if (typeof qbd !== "undefined" && qbd && typeof qbd.call === "function") {
            qbd.call(addr, callback, useStealth);
            return "qbd.call";
        }
    } catch (qErr) {
        log("[-] qbd.call failed, fallback to hook(): " + qErr);
    }
    hook(addr, callback, mode);
    return "hook";
}

function ptrOrNull(value) {
    try {
        return ptr(value);
    } catch (_) {
        return ptr(0);
    }
}

function isNullPtr(value) {
    return ptrOrNull(value).toString() === "0x0";
}

function safeReadCString(value) {
    try {
        var p = ptrOrNull(value);
        if (p.toString() === "0x0") {
            return "";
        }
        return Memory.readCString(p) || "";
    } catch (_) {
        return "";
    }
}

function safeToString(value) {
    try {
        if (value === null || value === undefined) {
            return "null";
        }
        return String(value);
    } catch (_) {
        return "<toString-error>";
    }
}

function ptrToString(value) {
    try {
        return ptrOrNull(value).toString();
    } catch (_) {
        return "0x0";
    }
}

function toNumberSafe(value) {
    try {
        var n = Number(value);
        if (!isNaN(n)) {
            return n;
        }
    } catch (_) {}
    try {
        var s = safeToString(value);
        if (s.indexOf("0x") === 0) {
            var n2 = parseInt(s, 16);
            if (!isNaN(n2)) {
                return n2;
            }
        }
        var n3 = parseInt(s, 10);
        if (!isNaN(n3)) {
            return n3;
        }
    } catch (_) {}
    return null;
}

function readBytesPreview(addressValue, maxLen) {
    var p = ptrOrNull(addressValue);
    if (isNullPtr(p)) {
        return null;
    }
    var size = maxLen || NATIVE_BUFFER_PREVIEW_MAX;
    if (size <= 0) {
        return null;
    }
    try {
        var raw = Memory.readByteArray(p, size);
        if (!raw) {
            return null;
        }
        var u8 = new Uint8Array(raw);
        var hexParts = [];
        var asciiParts = [];
        for (var i = 0; i < u8.length; i++) {
            var b = u8[i] & 0xff;
            var h = b.toString(16);
            hexParts.push(h.length === 1 ? "0" + h : h);
            asciiParts.push(b >= 32 && b <= 126 ? String.fromCharCode(b) : ".");
        }
        return {
            ptr: p.toString(),
            size: u8.length,
            hex: hexParts.join(""),
            ascii: asciiParts.join("")
        };
    } catch (_) {
        return null;
    }
}

function parseJniParamTypes(sig) {
    var out = [];
    var s = String(sig || "");
    var lp = s.indexOf("(");
    var rp = s.indexOf(")");
    if (lp < 0 || rp <= lp) {
        return out;
    }
    var i = lp + 1;
    while (i < rp) {
        var arrPrefix = "";
        while (i < rp && s.charAt(i) === "[") {
            arrPrefix += "[";
            i++;
        }
        if (i >= rp) {
            break;
        }
        var c = s.charAt(i);
        if (c === "L") {
            var end = s.indexOf(";", i);
            if (end < 0 || end > rp) {
                break;
            }
            out.push(arrPrefix + s.substring(i, end + 1));
            i = end + 1;
            continue;
        }
        out.push(arrPrefix + c);
        i++;
    }
    return out;
}

function parseJniRetType(sig) {
    var s = String(sig || "");
    var rp = s.indexOf(")");
    if (rp < 0 || rp + 1 >= s.length) {
        return "";
    }
    return s.substring(rp + 1);
}

function getCtxArgRegister(ctx, argIndexFromJniParam) {
    var regIndex = argIndexFromJniParam + 2;
    if (regIndex < 0 || regIndex > 7) {
        return ptr(0);
    }
    var key = "x" + regIndex;
    if (!(key in ctx)) {
        return ptr(0);
    }
    return ptrOrNull(ctx[key]);
}

function tryReadJString(envPtr, jstrPtr) {
    var env = ptrOrNull(envPtr);
    var jstr = ptrOrNull(jstrPtr);
    if (isNullPtr(env) || isNullPtr(jstr)) {
        return null;
    }
    try {
        return Jni.helper.env.readJString(env, jstr);
    } catch (_) {
        return null;
    }
}

function tryGetObjectClassName(envPtr, objPtr) {
    var env = ptrOrNull(envPtr);
    var obj = ptrOrNull(objPtr);
    if (isNullPtr(env) || isNullPtr(obj)) {
        return null;
    }
    try {
        return Jni.helper.env.getObjectClassName(env, obj);
    } catch (_) {
        return null;
    }
}

function tryGetArrayLength(envPtr, arrPtr) {
    var env = ptrOrNull(envPtr);
    var arr = ptrOrNull(arrPtr);
    if (isNullPtr(env) || isNullPtr(arr)) {
        return null;
    }
    try {
        var addr = Jni.addr(env, "GetArrayLength");
        if (!addr || isNullPtr(addr)) {
            return null;
        }
        var out = callNative(addr, env, arr);
        var len = toNumberSafe(out);
        if (len === null || !isFinite(len) || len < 0) {
            return null;
        }
        return Math.floor(len);
    } catch (_) {
        return null;
    }
}

function summarizeJniArgByType(envPtr, argPtr, jniType) {
    var type = String(jniType || "");
    var arg = ptrOrNull(argPtr);
    var summary = {
        jni_type: type,
        ptr: arg.toString(),
        value: null,
        object_class: null,
        buffer_preview: null
    };

    if (isNullPtr(arg)) {
        return summary;
    }

    if (type === "Ljava/lang/String;") {
        var s = tryReadJString(envPtr, arg);
        if (s !== null) {
            summary.value = s;
        }
        return summary;
    }

    if (type === "Z") {
        var bv = toNumberSafe(arg);
        summary.value = bv !== null ? (bv !== 0) : null;
        return summary;
    }

    if (
        type === "I" ||
        type === "J" ||
        type === "S" ||
        type === "B" ||
        type === "F" ||
        type === "D"
    ) {
        summary.value = toNumberSafe(arg);
        return summary;
    }

    if (type === "[B") {
        summary.object_class = tryGetObjectClassName(envPtr, arg);
        summary.value = {
            length: tryGetArrayLength(envPtr, arg)
        };
        return summary;
    }

    if (type.indexOf("L") === 0 || type.indexOf("[") === 0) {
        summary.object_class = tryGetObjectClassName(envPtr, arg);
        summary.buffer_preview = readBytesPreview(arg, NATIVE_BUFFER_PREVIEW_MAX);
        return summary;
    }

    summary.value = toNumberSafe(arg);
    return summary;
}

function summarizeJniRetValue(envPtr, retVal, retType) {
    var type = String(retType || "");
    var ret = ptrOrNull(retVal);
    var out = {
        jni_ret_type: type,
        ptr: ret.toString(),
        value: null,
        object_class: null,
        buffer_preview: null
    };

    if (isNullPtr(ret)) {
        return out;
    }

    if (type === "Ljava/lang/String;") {
        out.value = tryReadJString(envPtr, ret);
        return out;
    }

    if (type === "[B") {
        out.object_class = tryGetObjectClassName(envPtr, ret);
        out.value = {
            length: tryGetArrayLength(envPtr, ret)
        };
        return out;
    }

    if (type.indexOf("L") === 0 || type.indexOf("[") === 0) {
        out.object_class = tryGetObjectClassName(envPtr, ret);
        out.buffer_preview = readBytesPreview(ret, NATIVE_BUFFER_PREVIEW_MAX);
        return out;
    }

    out.value = toNumberSafe(ret);
    return out;
}

function nativeMethodWithinLimit(name) {
    var key = String(name || "unknown");
    var n = nativeCallCountByMethod[key] || 0;
    if (n >= NATIVE_CALL_LIMIT_PER_METHOD) {
        return false;
    }
    nativeCallCountByMethod[key] = n + 1;
    return true;
}

function getJavaThreadName() {
    if (!ENABLE_STACK_CAPTURE) {
        return "";
    }
    try {
        if (!threadClass) {
            threadClass = Java.use("java.lang.Thread");
        }
        return safeToString(threadClass.currentThread().getName());
    } catch (_) {
        return "";
    }
}

function getJavaStackTop(depth) {
    if (!ENABLE_STACK_CAPTURE) {
        return [];
    }
    depth = depth || 6;
    try {
        if (!throwableClass) {
            throwableClass = Java.use("java.lang.Throwable");
        }
        var frames = throwableClass.$new().getStackTrace();
        var out = [];
        for (var i = 1; i < frames.length && out.length < depth; i++) {
            out.push(safeToString(frames[i]));
        }
        return out;
    } catch (_) {
        return [];
    }
}

function tryParseJsonText(text) {
    if (text === null || text === undefined) {
        return null;
    }
    try {
        return JSON.parse(text);
    } catch (_) {
        return null;
    }
}

function getJavaJsonBridge() {
    if (javaJsonBridge) {
        return javaJsonBridge;
    }
    try {
        var bridge = {};
        bridge.JSONObjectCls = Java.use("org.json.JSONObject");
        bridge.JSONArrayCls = Java.use("org.json.JSONArray");
        bridge.StringCls = Java.use("java.lang.String");
        bridge.BooleanCls = Java.use("java.lang.Boolean");
        bridge.IntegerCls = Java.use("java.lang.Integer");
        bridge.LongCls = Java.use("java.lang.Long");
        bridge.FloatCls = Java.use("java.lang.Float");
        bridge.DoubleCls = Java.use("java.lang.Double");
        bridge.GsonCls = null;
        bridge.GsonInst = null;
        bridge.FastJsonCls = null;

        javaJsonBridge = bridge;
        return javaJsonBridge;
    } catch (e) {
        log("[-] getJavaJsonBridge failed: " + e);
        return null;
    }
}

function tryLoadJavaClass(className) {
    try {
        return Java.use(className);
    } catch (_) {
        return null;
    }
}

function looksLikeWrapperString(text) {
    if (text === null || text === undefined) {
        return true;
    }
    var s = String(text);
    if (s === "[object Object]") {
        return true;
    }
    return s.indexOf("[JavaObject:") === 0;
}

function trySerializeWithJava(value) {
    if (value === null || value === undefined) {
        return null;
    }
    var bridge = getJavaJsonBridge();
    if (!bridge) {
        return null;
    }

    try {
        var byValueOf = bridge.StringCls.valueOf(value);
        var t0 = byValueOf === null || byValueOf === undefined ? null : String(byValueOf);
        if (t0 && !looksLikeWrapperString(t0)) {
            return t0;
        }
    } catch (_) {}

    try {
        if (!bridge.GsonCls) {
            bridge.GsonCls = tryLoadJavaClass("com.google.gson.Gson");
        }
        if (bridge.GsonCls) {
            if (!bridge.GsonInst) {
                bridge.GsonInst = bridge.GsonCls.$new();
            }
            var t1 = String(bridge.GsonInst.toJson(value));
            if (t1 && t1 !== "null" && !looksLikeWrapperString(t1)) {
                return t1;
            }
        }
    } catch (_) {}

    try {
        if (!bridge.FastJsonCls) {
            bridge.FastJsonCls = tryLoadJavaClass("com.alibaba.fastjson.JSON");
        }
        if (bridge.FastJsonCls) {
            var t2 = String(bridge.FastJsonCls.toJSONString(value));
            if (t2 && t2 !== "null" && !looksLikeWrapperString(t2)) {
                return t2;
            }
        }
    } catch (_) {}

    try {
        var t3 = String(value.toString());
        if (t3 && !looksLikeWrapperString(t3)) {
            return t3;
        }
    } catch (_) {}

    return null;
}

function tryCastTo(value, classWrapper) {
    if (value === null || value === undefined || !classWrapper) {
        return null;
    }
    try {
        return Java.cast(value, classWrapper);
    } catch (_) {
        return null;
    }
}

function getJavaClassName(value) {
    if (value === null || value === undefined) {
        return null;
    }
    try {
        if (value.$className) {
            return String(value.$className);
        }
    } catch (_) {}
    try {
        if (value.getClass && typeof value.getClass === "function") {
            var cls = value.getClass();
            if (cls && cls.getName) {
                return String(cls.getName());
            }
        }
    } catch (_) {}
    return null;
}

function stringifyJavaObject(value) {
    if (value === null || value === undefined) {
        return null;
    }
    var t = typeof value;
    if (t === "string" || t === "number" || t === "boolean") {
        return String(value);
    }

    var bridge = getJavaJsonBridge();
    if (bridge) {
        try {
            var serialized = trySerializeWithJava(value);
            if (serialized && !looksLikeWrapperString(serialized)) {
                return serialized;
            }
        } catch (_) {}
        try {
            var byValueOf = bridge.StringCls.valueOf(value);
            if (byValueOf !== null && byValueOf !== undefined) {
                var vText = String(byValueOf);
                if (vText && !looksLikeWrapperString(vText)) {
                    return vText;
                }
            }
        } catch (_) {}
        try {
            var strObj = tryCastTo(value, bridge.StringCls);
            if (strObj !== null) {
                return String(strObj);
            }
        } catch (_) {}
        try {
            var text = value.toString();
            if (text !== null && text !== undefined) {
                return String(text);
            }
        } catch (_) {}
    }
    return safeToString(value);
}

function coerceJavaScalar(value) {
    if (value === null || value === undefined) {
        return null;
    }
    var t = typeof value;
    if (t === "string" || t === "number" || t === "boolean") {
        return value;
    }

    var className = getJavaClassName(value);
    if (className && className.indexOf("org.json.JSONObject$Null") !== -1) {
        return null;
    }

    var bridge = getJavaJsonBridge();
    if (bridge) {
        try {
            if (tryCastTo(value, bridge.BooleanCls) !== null) {
                return stringifyJavaObject(value) === "true";
            }
        } catch (_) {}
        try {
            if (
                tryCastTo(value, bridge.IntegerCls) !== null ||
                tryCastTo(value, bridge.LongCls) !== null ||
                tryCastTo(value, bridge.FloatCls) !== null ||
                tryCastTo(value, bridge.DoubleCls) !== null
            ) {
                var n = Number(stringifyJavaObject(value));
                if (!isNaN(n)) {
                    return n;
                }
            }
        } catch (_) {}
    }

    return stringifyJavaObject(value);
}

function javaValueToText(value) {
    return stringifyJavaObject(value);
}

function tryDecodeJsonByToString(value) {
    if (PASSIVE_OBSERVE_ONLY) {
        return null;
    }
    if (value === null || value === undefined) {
        return null;
    }
    var bridge = getJavaJsonBridge();
    if (!bridge) {
        return null;
    }

    try {
        var bySerializer = trySerializeWithJava(value);
        if (bySerializer && !looksLikeWrapperString(bySerializer)) {
            var parsedBySerializer = tryParseJsonText(bySerializer);
            if (parsedBySerializer !== null) {
                return parsedBySerializer;
            }
        }
    } catch (_) {}

    try {
        var byValueOf = bridge.StringCls.valueOf(value);
        var byValueOfText = byValueOf === null || byValueOf === undefined ? null : String(byValueOf);
        if (byValueOfText && !looksLikeWrapperString(byValueOfText)) {
            var parsedByValueOf = tryParseJsonText(byValueOfText);
            if (parsedByValueOf !== null) {
                return parsedByValueOf;
            }
        }
    } catch (_) {}

    try {
        var obj = tryCastTo(value, bridge.JSONObjectCls);
        if (obj !== null) {
            return tryParseJsonText(String(obj.toString()));
        }
    } catch (_) {}

    try {
        var arr = tryCastTo(value, bridge.JSONArrayCls);
        if (arr !== null) {
            return tryParseJsonText(String(arr.toString()));
        }
    } catch (_) {}

    return null;
}

function javaObjectToJsonValue(value, depth) {
    if (PASSIVE_OBSERVE_ONLY) {
        return null;
    }
    var d = depth || 0;
    if (d > 8) {
        return coerceJavaScalar(value);
    }
    if (value === null || value === undefined) {
        return null;
    }

    var valueType = typeof value;
    if (valueType === "string" || valueType === "number" || valueType === "boolean") {
        return value;
    }

    var className = getJavaClassName(value);
    if (className && className.indexOf("org.json.JSONObject$Null") !== -1) {
        return null;
    }

    var bridge = getJavaJsonBridge();
    if (!bridge) {
        return coerceJavaScalar(value);
    }

    if (tryCastTo(value, bridge.JSONObjectCls) !== null || className === "org.json.JSONObject") {
        try {
            var parsedObjByString = tryDecodeJsonByToString(value);
            if (parsedObjByString !== null) {
                return parsedObjByString;
            }

            var obj = tryCastTo(value, bridge.JSONObjectCls);
            if (obj === null) {
                return coerceJavaScalar(value);
            }
            var out = {};
            var keys = obj.keys();
            while (keys && keys.hasNext()) {
                var k = javaValueToText(keys.next());
                if (k === null) {
                    continue;
                }
                out[k] = javaObjectToJsonValue(obj.get(String(k)), d + 1);
            }
            return out;
        } catch (_) {
            return coerceJavaScalar(value);
        }
    }

    if (tryCastTo(value, bridge.JSONArrayCls) !== null || className === "org.json.JSONArray") {
        try {
            var parsedArrByString = tryDecodeJsonByToString(value);
            if (parsedArrByString !== null) {
                return parsedArrByString;
            }

            var arrObj = tryCastTo(value, bridge.JSONArrayCls);
            if (arrObj === null) {
                return coerceJavaScalar(value);
            }
            var arr = [];
            var len = Number(arrObj.length());
            for (var i = 0; i < len; i++) {
                arr.push(javaObjectToJsonValue(arrObj.get(i), d + 1));
            }
            return arr;
        } catch (_) {
            return coerceJavaScalar(value);
        }
    }

    return coerceJavaScalar(value);
}

function parseJavaMapPassive(mapObj, depth) {
    if (mapObj === null || mapObj === undefined) {
        return {};
    }
    var d = depth || 0;
    if (d > 8) {
        return {};
    }
    var out = {};
    try {
        var it = mapObj.entrySet().iterator();
        while (it && it.hasNext()) {
            var entry = it.next();
            var k = safeToString(entry.getKey());
            out[k] = parseOrgJsonPassive(entry.getValue(), d + 1);
        }
        if (hasMeaningfulJson(out)) {
            return out;
        }
    } catch (_) {
    }
    try {
        var keyIt = mapObj.keySet().iterator();
        while (keyIt && keyIt.hasNext()) {
            var keyObj = keyIt.next();
            var keyText = safeToString(keyObj);
            out[keyText] = parseOrgJsonPassive(mapObj.get(keyObj), d + 1);
        }
        if (hasMeaningfulJson(out)) {
            return out;
        }
    } catch (_) {}
    try {
        var mapText = safeToString(mapObj.toString());
        if (mapText && !looksLikeWrapperString(mapText)) {
            return {
                __java_map_text__: mapText
            };
        }
    } catch (_) {}
    return out;
}

function tryJsonifyJavaMap(mapObj) {
    if (mapObj === null || mapObj === undefined) {
        return null;
    }
    var bridge = getJavaJsonBridge();
    if (!bridge || !bridge.JSONObjectCls) {
        return null;
    }
    try {
        var jsonObj = bridge.JSONObjectCls.$new(mapObj);
        if (!jsonObj) {
            return null;
        }
        var jsonText = safeToString(jsonObj.toString());
        var parsed = tryParseJsonText(jsonText);
        if (parsed !== null) {
            return {
                text: jsonText,
                json: parsed,
                decode_mode: "java_jsonobject_ctor"
            };
        }
        if (jsonText && !looksLikeWrapperString(jsonText)) {
            return {
                text: jsonText,
                json: {
                    __json_text__: jsonText
                },
                decode_mode: "java_jsonobject_ctor_text"
            };
        }
    } catch (_) {}
    return null;
}

function parseJavaListPassive(listObj, depth) {
    if (listObj === null || listObj === undefined) {
        return [];
    }
    var d = depth || 0;
    if (d > 8) {
        return [];
    }
    var out = [];
    try {
        var size = Number(listObj.size());
        if (!isFinite(size) || size < 0) {
            size = 0;
        }
        for (var i = 0; i < size; i++) {
            out.push(parseOrgJsonPassive(listObj.get(i), d + 1));
        }
        return out;
    } catch (_) {
        return out;
    }
}

function parseOrgJsonPassive(value, depth) {
    if (value === null || value === undefined) {
        return null;
    }
    var d = depth || 0;
    if (d > 8) {
        return safeToString(value);
    }

    var t = typeof value;
    if (t === "string" || t === "number" || t === "boolean") {
        return value;
    }

    var cls = getJavaClassName(value) || "";
    if (cls.indexOf("org.json.JSONObject$Null") !== -1) {
        return null;
    }
    if (cls === "java.lang.Boolean") {
        return safeToString(value) === "true";
    }
    if (
        cls === "java.lang.Integer" ||
        cls === "java.lang.Long" ||
        cls === "java.lang.Float" ||
        cls === "java.lang.Double"
    ) {
        var n = Number(safeToString(value));
        return isNaN(n) ? safeToString(value) : n;
    }
    if (cls === "java.lang.String") {
        return safeToString(value);
    }

    if (cls === "org.json.JSONObject") {
        try {
            var cObj = value.getClass();
            var fObj = cObj.getDeclaredField("nameValuePairs");
            fObj.setAccessible(true);
            var mapObj = fObj.get(value);
            return parseJavaMapPassive(mapObj, d + 1);
        } catch (_) {
            try {
                var outObj = {};
                var it = value.keys();
                var maxObj = 256;
                var guardObj = 0;
                while (it && it.hasNext() && guardObj < maxObj) {
                    guardObj += 1;
                    var k = safeToString(it.next());
                    if (!k || k === "null") {
                        continue;
                    }
                    var vv = null;
                    try {
                        vv = value.opt(k);
                    } catch (_) {
                        try {
                            vv = value.get(k);
                        } catch (_) {
                            vv = null;
                        }
                    }
                    outObj[String(k)] = parseOrgJsonPassive(vv, d + 1);
                }
                return outObj;
            } catch (_) {
                return null;
            }
        }
    }

    if (cls === "org.json.JSONArray") {
        try {
            var cArr = value.getClass();
            var fArr = cArr.getDeclaredField("values");
            fArr.setAccessible(true);
            var listObj = fArr.get(value);
            return parseJavaListPassive(listObj, d + 1);
        } catch (_) {
            try {
                var outArr = [];
                var len = Number(value.length());
                if (!isFinite(len) || len < 0) {
                    len = 0;
                }
                if (len > 256) {
                    len = 256;
                }
                for (var ai = 0; ai < len; ai++) {
                    var av = null;
                    try {
                        av = value.opt(ai);
                    } catch (_) {
                        try {
                            av = value.get(ai);
                        } catch (_) {
                            av = null;
                        }
                    }
                    outArr.push(parseOrgJsonPassive(av, d + 1));
                }
                return outArr;
            } catch (_) {
                return null;
            }
        }
    }

    return safeToString(value);
}

function summarizeJavaValue(value) {
    var className = getJavaClassName(value);

    var summary = {
        text: javaValueToText(value),
        class_name: className,
        json: null,
        decode_mode: null
    };

    if (PASSIVE_OBSERVE_ONLY) {
        if (className === "org.json.JSONObject" || className === "org.json.JSONArray") {
            try {
                var passiveJson = parseOrgJsonPassive(value, 0);
                if (passiveJson !== null) {
                    summary.json = passiveJson;
                    summary.decode_mode = "passive_reflect";
                    if (looksLikeWrapperString(summary.text)) {
                        try {
                            summary.text = JSON.stringify(passiveJson);
                        } catch (_) {}
                    }
                }
            } catch (_) {}
        }
        return summary;
    }

    if (looksLikeWrapperString(summary.text)) {
        try {
            var serializedText = trySerializeWithJava(value);
            if (serializedText && !looksLikeWrapperString(serializedText)) {
                summary.text = serializedText;
            }
        } catch (_) {}
    }

    try {
        var jsonByString = tryDecodeJsonByToString(value);
        if (jsonByString !== null) {
            summary.json = jsonByString;
            summary.decode_mode = "java_toString";
            return summary;
        }
    } catch (_) {}

    if (summary.text !== null && summary.text.indexOf("[JavaObject:") !== 0) {
        var parsedText = tryParseJsonText(summary.text);
        if (parsedText !== null) {
            summary.json = parsedText;
            summary.decode_mode = "text_parse";
            return summary;
        }
    }

    try {
        var jsonByWalk = javaObjectToJsonValue(value, 0);
        if (jsonByWalk !== null && typeof jsonByWalk !== "string") {
            summary.json = jsonByWalk;
            summary.decode_mode = "java_walk";
        }
    } catch (_) {}

    if (summary.json === null && summary.text !== null) {
        var fallback = tryParseJsonText(summary.text);
        if (fallback !== null) {
            summary.json = fallback;
            summary.decode_mode = "fallback_text_parse";
        }
    }

    return summary;
}

function reflectJavaObjectFields(obj, maxFields) {
    if (obj === null || obj === undefined) {
        return null;
    }
    var limit = maxFields || 32;
    var out = [];
    var seen = {};
    try {
        var cls = obj.getClass();
        var depth = 0;
        while (cls && depth < 8 && out.length < limit) {
            var declaringClass = safeToString(cls.getName());
            var fields = cls.getDeclaredFields();
            for (var i = 0; i < fields.length && out.length < limit; i++) {
                try {
                    var f = fields[i];
                    f.setAccessible(true);
                    var fName = String(f.getName() || "");
                    var fType = String(f.getType().getName() || "");
                    var seenKey = declaringClass + "#" + fName;
                    if (seen[seenKey]) {
                        continue;
                    }
                    seen[seenKey] = true;
                    var fValue = f.get(obj);
                    var fSummary = summarizeJavaValue(fValue);
                    out.push({
                        declaring_class: declaringClass,
                        name: fName,
                        type: fType,
                        object_key: getStableObjectKey(fValue),
                        value_text: fSummary.text,
                        value_class: fSummary.class_name,
                        value_json: fSummary.json,
                        value_decode_mode: fSummary.decode_mode
                    });
                } catch (_) {}
            }
            depth += 1;
            try {
                cls = cls.getSuperclass();
            } catch (_) {
                break;
            }
        }
    } catch (_) {}
    return out;
}

function reflectJavaClassChain(obj, maxDepth) {
    if (obj === null || obj === undefined) {
        return null;
    }
    var limit = maxDepth || 8;
    var out = [];
    try {
        var cls = obj.getClass();
        var depth = 0;
        while (cls && depth < limit) {
            out.push(safeToString(cls.getName()));
            depth += 1;
            try {
                cls = cls.getSuperclass();
            } catch (_) {
                break;
            }
        }
    } catch (_) {}
    return out;
}

function reflectJavaObjectNoArgMethods(obj, maxMethods) {
    if (obj === null || obj === undefined) {
        return null;
    }
    var limit = maxMethods || 24;
    var out = [];
    var seen = {};
    var errorCount = 0;
    try {
        var cls = obj.getClass();
        var invokeArgs = Java.array("java.lang.Object", []);
        var depth = 0;
        while (cls && depth < 8 && out.length < limit) {
            var declaringClass = safeToString(cls.getName());
            var methods = cls.getDeclaredMethods();
            for (var i = 0; i < methods.length && out.length < limit; i++) {
                try {
                    var m = methods[i];
                    var name = String(m.getName() || "");
                    var rt = String(m.getReturnType().getName() || "");
                    var seenKey = declaringClass + "#" + name + "->" + rt;
                    if (seen[seenKey]) {
                        continue;
                    }
                    seen[seenKey] = true;
                    if (
                        name === "wait" ||
                        name === "notify" ||
                        name === "notifyAll" ||
                        name === "hashCode" ||
                        name === "getClass" ||
                        name === "clone" ||
                        name === "finalize"
                    ) {
                        continue;
                    }
                    if (m.getParameterTypes().length !== 0) {
                        continue;
                    }
                    if (rt === "void") {
                        continue;
                    }
                    try {
                        m.setAccessible(true);
                    } catch (_) {}
                    try {
                        var v = m.invoke(obj, invokeArgs);
                        var s = summarizeJavaValue(v);
                        out.push({
                            declaring_class: declaringClass,
                            name: name,
                            return_type: rt,
                            object_key: getStableObjectKey(v),
                            value_text: s.text,
                            value_class: s.class_name,
                            value_json: s.json,
                            value_decode_mode: s.decode_mode
                        });
                    } catch (invokeErr) {
                        if (errorCount < 8) {
                            out.push({
                                declaring_class: declaringClass,
                                name: name,
                                return_type: rt,
                                invoke_error: safeToString(invokeErr)
                            });
                            errorCount += 1;
                        }
                    }
                } catch (_) {}
            }
            depth += 1;
            try {
                cls = cls.getSuperclass();
            } catch (_) {
                break;
            }
        }
    } catch (_) {}
    return out;
}

function strip0x(value) {
    if (!value) {
        return "";
    }
    return value.indexOf("0x") === 0 ? value.substring(2) : value;
}

function isKnownOffset(offsetHex) {
    for (var i = 0; i < KNOWN_THREAD_OFFSETS.length; i++) {
        if (offsetHex === KNOWN_THREAD_OFFSETS[i].toString(16)) {
            return true;
        }
    }
    return false;
}

function allKnownOffsetsPatched() {
    for (var i = 0; i < KNOWN_THREAD_OFFSETS.length; i++) {
        if (!patchedOffsets[KNOWN_THREAD_OFFSETS[i].toString(16)]) {
            return false;
        }
    }
    return true;
}

function findExportCompat(moduleName, symbolName) {
    try {
        return Module.findExportByName(moduleName, symbolName);
    } catch (_) {
        return null;
    }
}

function findModuleByNameContains(nameLike) {
    var needle = String(nameLike || "").toLowerCase();
    if (!needle) {
        return null;
    }
    try {
        var mods = Module.enumerateModules();
        for (var i = 0; i < mods.length; i++) {
            var m = mods[i];
            var n = String(m.name || "").toLowerCase();
            var p = String(m.path || "").toLowerCase();
            if (n === needle || n.indexOf(needle) !== -1 || p.indexOf(needle) !== -1) {
                return m;
            }
        }
    } catch (_) {}
    return null;
}

function countEncryptNativeHooksInstalled() {
    var n = 0;
    for (var key in encryptNativeHooksInstalled) {
        if (encryptNativeHooksInstalled[key]) {
            n += 1;
        }
    }
    return n;
}

function enumerateModuleSymbolsCompat(mod) {
    if (!mod) {
        return [];
    }
    try {
        return mod.enumerateSymbols() || [];
    } catch (_) {}
    try {
        return mod.enumerateExports() || [];
    } catch (_) {}
    return [];
}

function findPassiveRecoveryModule() {
    var mod = findModuleByNameContains(JNI_TABLE_SCAN_MODULE);
    if (mod) {
        return mod;
    }
    for (var i = 0; i < NATIVE_TARGET_MODULE_KEYWORDS.length; i++) {
        mod = findModuleByNameContains(NATIVE_TARGET_MODULE_KEYWORDS[i]);
        if (mod) {
            return mod;
        }
    }
    return null;
}

function schedulePassiveRecoveryTick(callback, delayMs) {
    try {
        if (typeof setTimeout === "function") {
            setTimeout(callback, delayMs);
            return true;
        }
    } catch (_) {}
    try {
        if (typeof os !== "undefined" && os && typeof os.setTimeout === "function") {
            os.setTimeout(callback, delayMs);
            return true;
        }
    } catch (_) {}
    return false;
}

function runPassiveRecoveryTick(attempt, sourceTag, allowReschedule) {
    if (!ENABLE_PASSIVE_RECOVERY_RETRY) {
        passiveRecoveryRunning = false;
        return;
    }

    if (passiveRecoveryFinished) {
        passiveRecoveryRunning = false;
        return;
    }

    var module = findPassiveRecoveryModule();
    var before = countEncryptNativeHooksInstalled();
    emitEvidence({
        event_type: "passive_recovery_tick",
        attempt: attempt,
        source: sourceTag || "unknown",
        module_present: !!module,
        module_name: module ? String(module.name || "") : null,
        module_path: module ? String(module.path || "") : null,
        hook_count_before: before,
        jni_table_scan_done: !!jniTableScanDone,
        ts: now()
    });

    try {
        installEncryptNativeHooksFromExports();
    } catch (e) {
        log("[-] passive recovery tick install error: " + e);
    }

    var after = countEncryptNativeHooksInstalled();
    if (after > 0) {
        passiveRecoveryFinished = true;
        passiveRecoveryRunning = false;
        emitEvidence({
            event_type: "passive_recovery_ready",
            attempt: attempt,
            source: sourceTag || "unknown",
            module_present: !!module,
            module_name: module ? String(module.name || "") : null,
            hook_count_after: after,
            ts: now()
        });
        log("[*] passive recovery ready after attempt=" + attempt + " hooks=" + after);
        return;
    }

    if (attempt >= PASSIVE_RECOVERY_MAX_ATTEMPTS) {
        passiveRecoveryFinished = true;
        passiveRecoveryRunning = false;
        emitEvidence({
            event_type: "passive_recovery_timeout",
            attempt: attempt,
            source: sourceTag || "unknown",
            module_present: !!module,
            module_name: module ? String(module.name || "") : null,
            ts: now()
        });
        log("[-] passive recovery timed out after attempts=" + attempt);
        return;
    }

    if (allowReschedule === false) {
        return;
    }

    if (!schedulePassiveRecoveryTick(function() {
        runPassiveRecoveryTick(attempt + 1, sourceTag || "unknown", true);
    }, PASSIVE_RECOVERY_INTERVAL_MS)) {
        passiveRecoveryRunning = false;
        emitEvidence({
            event_type: "passive_recovery_schedule_error",
            attempt: attempt,
            source: sourceTag || "unknown",
            error: "timer_api_unavailable",
            ts: now()
        });
        log("[-] passive recovery scheduling unavailable");
    }
}

function startPassiveRecoveryJavaWorker(sourceTag) {
    try {
        if (typeof Java.registerClass !== "function") {
            emitEvidence({
                event_type: "passive_recovery_worker_unsupported",
                source: sourceTag || "java_worker",
                reason: "Java.registerClass_unavailable",
                ts: now()
            });
            log("[*] passive recovery Java worker unsupported: Java.registerClass unavailable");
            return false;
        }
        var Runnable = Java.use("java.lang.Runnable");
        if (!threadClass) {
            threadClass = Java.use("java.lang.Thread");
        }
        var workerName = "PalmchatPassiveRecovery" + String(now());
        var Worker = Java.registerClass({
            name: "com.codex.pc." + workerName,
            implements: [Runnable],
            methods: {
                run: function() {
                    try {
                        for (var attempt = 0; attempt <= PASSIVE_RECOVERY_MAX_ATTEMPTS; attempt++) {
                            if (passiveRecoveryFinished) {
                                break;
                            }
                            runPassiveRecoveryTick(attempt, sourceTag || "java_worker", false);
                            if (passiveRecoveryFinished) {
                                break;
                            }
                            try {
                                threadClass.sleep(PASSIVE_RECOVERY_INTERVAL_MS);
                            } catch (_) {}
                        }
                    } catch (e) {
                        log("[-] passive recovery worker error: " + e);
                    }
                    passiveRecoveryRunning = false;
                }
            }
        });
        var t = threadClass.$new(Worker.$new());
        t.setDaemon(true);
        try {
            t.setName("pc-recovery");
        } catch (_) {}
        try {
            t.setPriority(1);
        } catch (_) {}
        t.start();
        passiveRecoveryRunning = true;
        log("[*] passive recovery Java worker started source=" + sourceTag);
        emitEvidence({
            event_type: "passive_recovery_worker_started",
            source: sourceTag || "java_worker",
            ts: now()
        });
        return true;
    } catch (e) {
        passiveRecoveryRunning = false;
        log("[-] passive recovery Java worker start failed: " + e);
        emitEvidence({
            event_type: "passive_recovery_worker_error",
            source: sourceTag || "java_worker",
            error: String(e),
            ts: now()
        });
        return false;
    }
}

function findDlopenCandidates() {
    var out = [];
    try {
        var mods = Module.enumerateModules();
        for (var i = 0; i < mods.length; i++) {
            var mod = mods[i];
            var modName = String(mod.name || "");
            var modNameLower = modName.toLowerCase();
            if (
                modNameLower.indexOf("linker") === -1 &&
                modNameLower.indexOf("libdl") === -1
            ) {
                continue;
            }
            var syms = enumerateModuleSymbolsCompat(mod);
            for (var j = 0; j < syms.length; j++) {
                var sym = syms[j];
                var symName = String(sym.name || "");
                var symLower = symName.toLowerCase();
                if (
                    symLower.indexOf("dlopen") === -1 &&
                    symLower.indexOf("do_dlopen") === -1
                ) {
                    continue;
                }
                if (symLower.indexOf("checkjni") !== -1) {
                    continue;
                }
                var addr = ptrOrNull(sym.address);
                if (isNullPtr(addr)) {
                    continue;
                }
                out.push({
                    module: modName,
                    symbol: symName,
                    address: addr
                });
            }
        }
    } catch (e) {
        log("[-] findDlopenCandidates failed: " + e);
    }
    return out;
}

function keywordMatched(text, keywords) {
    var s = String(text || "").toLowerCase();
    for (var i = 0; i < keywords.length; i++) {
        if (s.indexOf(String(keywords[i] || "").toLowerCase()) !== -1) {
            return true;
        }
    }
    return false;
}

function currentTargetModuleSnapshot() {
    var primary = findModuleByNameContains(JNI_TABLE_SCAN_MODULE);
    if (primary) {
        return primary;
    }
    for (var i = 0; i < NATIVE_TARGET_MODULE_KEYWORDS.length; i++) {
        var mod = findModuleByNameContains(NATIVE_TARGET_MODULE_KEYWORDS[i]);
        if (mod) {
            return mod;
        }
    }
    return null;
}

function maybeRecoverFromDlopen(path, hookName) {
    if (passiveRecoveryFinished) {
        return;
    }
    var ts = now();
    if (ts - lastDlopenRecoveryTs < 400) {
        return;
    }
    lastDlopenRecoveryTs = ts;

    var targetModule = currentTargetModuleSnapshot();
    var pathHit = keywordMatched(path, NATIVE_TARGET_MODULE_KEYWORDS);
    var pathText = String(path || "");
    if (!targetModule && pathText.length === 0) {
        return;
    }

    emitEvidence({
        event_type: "dlopen_recovery_probe",
        hook: hookName,
        path: pathText,
        path_keyword_hit: pathHit,
        target_module_present: !!targetModule,
        target_module_name: targetModule ? String(targetModule.name || "") : null,
        target_module_path: targetModule ? String(targetModule.path || "") : null,
        hook_count_before: countEncryptNativeHooksInstalled(),
        ts: ts
    });
    installEncryptNativeHooksFromExports();
}

function startPassiveRecoveryLoop(sourceTag, allowJavaWorker) {
    if (!ENABLE_PASSIVE_RECOVERY_RETRY) {
        return;
    }
    if (passiveRecoveryRunning || passiveRecoveryFinished) {
        return;
    }
    log("[*] start passive recovery loop source=" + sourceTag);
    passiveRecoveryRunning = true;
    runPassiveRecoveryTick(0, sourceTag || "startup", true);
    if (passiveRecoveryRunning || passiveRecoveryFinished) {
        return;
    }
    if (allowJavaWorker) {
        startPassiveRecoveryJavaWorker(sourceTag || "java_worker");
    }
}

function toAsciiBytes(text) {
    var s = String(text || "");
    var out = [];
    for (var i = 0; i < s.length; i++) {
        out.push(s.charCodeAt(i) & 0xff);
    }
    return out;
}

function findBytesIndex(haystack, needle) {
    if (!haystack || !needle || needle.length === 0 || haystack.length < needle.length) {
        return -1;
    }
    var max = haystack.length - needle.length;
    for (var i = 0; i <= max; i++) {
        var matched = true;
        for (var j = 0; j < needle.length; j++) {
            if (haystack[i + j] !== needle[j]) {
                matched = false;
                break;
            }
        }
        if (matched) {
            return i;
        }
    }
    return -1;
}

function findStringAddressInModule(mod, text) {
    if (!mod || !mod.base || !mod.size) {
        return ptr(0);
    }
    try {
        var raw = Memory.readByteArray(mod.base, Number(mod.size));
        if (!raw) {
            return ptr(0);
        }
        var bytes = new Uint8Array(raw);
        var n1 = toAsciiBytes(text + "\u0000");
        var off = findBytesIndex(bytes, n1);
        if (off < 0) {
            var n2 = toAsciiBytes(text);
            off = findBytesIndex(bytes, n2);
        }
        if (off < 0) {
            return ptr(0);
        }
        return ptrOrNull(mod.base).add(off);
    } catch (_) {
        return ptr(0);
    }
}

function recoverEncryptMethodsFromJniTable(mod) {
    var out = [];
    if (!mod || !mod.base || !mod.size) {
        return out;
    }

    var base = ptrOrNull(mod.base);
    var size = toNumberSafe(mod.size);
    if (isNullPtr(base) || size === null || size < 32) {
        return out;
    }

    var targetAddrs = {};
    for (var i = 0; i < KNOWN_ENCRYPT_JNI_TARGETS.length; i++) {
        var t = KNOWN_ENCRYPT_JNI_TARGETS[i];
        var namePtr = findStringAddressInModule(mod, t.name);
        var sigPtr = findStringAddressInModule(mod, t.sig);
        targetAddrs[t.name + "|" + t.sig] = {
            name: t.name,
            sig: t.sig,
            name_ptr: namePtr,
            sig_ptr: sigPtr
        };
    }

    var end = size - 24;
    if (end <= 0) {
        return out;
    }

    for (var key in targetAddrs) {
        var row = targetAddrs[key];
        if (!row || isNullPtr(row.name_ptr) || isNullPtr(row.sig_ptr)) {
            continue;
        }

        for (var off = 0; off <= end; off += 8) {
            try {
                var itemPtr = base.add(off);
                var namePtrAt = ptrOrNull(Memory.readPointer(itemPtr));
                if (namePtrAt.toString() !== row.name_ptr.toString()) {
                    continue;
                }
                var sigPtrAt = ptrOrNull(Memory.readPointer(itemPtr.add(8)));
                if (sigPtrAt.toString() !== row.sig_ptr.toString()) {
                    continue;
                }
                var fnPtr = ptrOrNull(Memory.readPointer(itemPtr.add(16)));
                if (isNullPtr(fnPtr)) {
                    continue;
                }
                var fnMod = Module.findByAddress(fnPtr);
                if (!fnMod || String(fnMod.name) !== String(mod.name)) {
                    continue;
                }
                out.push({
                    name: row.name,
                    sig: row.sig,
                    fnPtr: fnPtr,
                    recovered_by: "jni_table_scan",
                    table_ptr: itemPtr.toString()
                });
                break;
            } catch (_) {}
        }
    }

    return out;
}

function installEncryptNativeHooksFromJniTable() {
    if (!ENABLE_JNI_TABLE_RECOVERY || jniTableScanDone) {
        return;
    }
    try {
        var mod = findModuleByNameContains(JNI_TABLE_SCAN_MODULE);
        if (!mod) {
            mod = findModuleByNameContains("zhangxin.2.so");
        }
        if (!mod) {
            log("[*] jni table scan skipped: module not found (" + JNI_TABLE_SCAN_MODULE + ")");
            return;
        }
        var recovered = recoverEncryptMethodsFromJniTable(mod);
        if (recovered.length <= 0) {
            log("[*] jni table scan found 0 encrypt methods");
            return;
        }
        log("[*] jni table scan recovered methods: " + recovered.length);
        for (var i = 0; i < recovered.length; i++) {
            emitEvidence({
                event_type: "jni_table_recovered",
                module: mod.name,
                method: recovered[i].name,
                sig: recovered[i].sig,
                fn_ptr: recovered[i].fnPtr.toString(),
                table_ptr: recovered[i].table_ptr,
                ts: now()
            });
        }
        installEncryptNativeHooks(recovered);
        jniTableScanDone = true;
    } catch (e) {
        log("[-] installEncryptNativeHooksFromJniTable failed: " + e);
    }
}

function findDummyThreadRoutine() {
    var names = ["getpid", "gettid", "sched_yield"];
    var modules = ["libc.so", null];
    for (var i = 0; i < modules.length; i++) {
        for (var j = 0; j < names.length; j++) {
            var addr = findExportCompat(modules[i], names[j]);
            if (addr && !isNullPtr(addr)) {
                log("[*] dummy thread routine -> " + names[j] + " @ " + addr);
                return addr;
            }
        }
    }
    log("[-] failed to resolve dummy thread routine");
    return null;
}

function parseQueryFromUrl(url) {
    var out = {};
    if (!url) {
        return out;
    }
    var qIndex = url.indexOf("?");
    if (qIndex < 0 || qIndex >= url.length - 1) {
        return out;
    }
    var raw = url.substring(qIndex + 1);
    var parts = raw.split("&");
    for (var i = 0; i < parts.length; i++) {
        var part = parts[i];
        if (!part) {
            continue;
        }
        var eq = part.indexOf("=");
        var key = eq < 0 ? part : part.substring(0, eq);
        var value = eq < 0 ? "" : part.substring(eq + 1);
        try {
            key = decodeURIComponent(key);
        } catch (_) {}
        try {
            value = decodeURIComponent(value);
        } catch (_) {}
        out[key] = value;
    }
    return out;
}

function getTrackedRequestKey(obj) {
    try {
        if (obj && obj.__jptr !== undefined) {
            return ptrOrNull(obj.__jptr).toString();
        }
    } catch (_) {}
    return null;
}

function getStableObjectKey(obj) {
    if (obj === null || obj === undefined) {
        return null;
    }
    try {
        if (!javaSystemClass) {
            javaSystemClass = Java.use("java.lang.System");
        }
        var raw = Number(javaSystemClass.identityHashCode(obj));
        if (isFinite(raw)) {
            return "id:" + ((raw >>> 0).toString(16));
        }
    } catch (_) {}

    var ptrKey = getTrackedRequestKey(obj);
    if (ptrKey) {
        return "ptr:" + ptrKey;
    }
    return null;
}

function getUrlKind(url) {
    if (!url) {
        return null;
    }
    if (url.indexOf(NEW_SEND_SMS_PATH) !== -1) {
        return "new_send_sms";
    }
    if (url.indexOf(CAPTCHA_REGISTER_PATH) !== -1) {
        return "captcha_register";
    }
    if (url.indexOf(CAPTCHA_VERIFY_PATH) !== -1) {
        return "captcha_verify";
    }
    return null;
}

function getFlowTag(urlKind, url) {
    if (urlKind) {
        return urlKind;
    }
    var u = String(url || "");
    if (!u) {
        return "unknown";
    }
    if (u.indexOf("/one/ax/menu.get.v1") !== -1) {
        return "menu_get";
    }
    if (u.indexOf("/outerchannel/qryAdContent") !== -1) {
        return "ad_query";
    }
    return "other";
}

function isEmptyPlainObject(value) {
    if (!value || typeof value !== "object" || Array.isArray(value)) {
        return false;
    }
    for (var k in value) {
        return false;
    }
    return true;
}

function hasMeaningfulJson(value) {
    if (value === null || value === undefined) {
        return false;
    }
    var t = typeof value;
    if (t === "string") {
        return value.length > 0;
    }
    if (t === "number" || t === "boolean") {
        return true;
    }
    if (Array.isArray(value)) {
        return value.length > 0;
    }
    if (t === "object") {
        return !isEmptyPlainObject(value);
    }
    return false;
}

function getTraceIdFromUrl(url) {
    var query = parseQueryFromUrl(url || "");
    if (query.requestId) {
        return String(query.requestId);
    }
    return null;
}

function safeTraceId(value) {
    if (value === null || value === undefined) {
        return null;
    }
    return String(value);
}

function resolveTraceIdForUrl(url) {
    var fromUrl = getTraceIdFromUrl(url || "");
    if (fromUrl) {
        return fromUrl;
    }
    var key = String(url || "");
    if (key && traceByUrl[key]) {
        return String(traceByUrl[key]);
    }
    return null;
}

function lookupTrackedByUrl(url) {
    var needle = String(url || "");
    if (!needle) {
        return null;
    }
    for (var key in trackedRequests) {
        var row = trackedRequests[key];
        if (row && String(row.url || "") === needle) {
            return row;
        }
    }
    return null;
}

function lookupTrackedByTraceId(traceId) {
    var tid = safeTraceId(traceId);
    if (!tid) {
        return null;
    }
    for (var key in trackedRequests) {
        var row = trackedRequests[key];
        if (row && safeTraceId(row.trace_id) === tid) {
            return row;
        }
    }
    return null;
}

function ensureTrackedRequestRow(urlText, urlKind, flowTag, traceId) {
    var canonicalUrl = String(urlText || "");
    var tracked = lookupTrackedByUrl(canonicalUrl);
    var requestKey = tracked && tracked.request_key ? String(tracked.request_key) : "url:" + canonicalUrl;
    if (!tracked) {
        tracked = {
            request_key: requestKey,
            url: canonicalUrl,
            flow_tag: flowTag,
            url_kind: urlKind,
            query: parseQueryFromUrl(canonicalUrl),
            request_body_text: null,
            request_body_json: null,
            request_body_decode_mode: null,
            request_headers: {},
            request_body_sha256: null,
            trace_id: safeTraceId(traceId)
        };
    } else if (!tracked.request_key) {
        tracked.request_key = requestKey;
    }
    tracked.url = canonicalUrl;
    tracked.flow_tag = tracked.flow_tag || flowTag;
    tracked.url_kind = tracked.url_kind || urlKind;
    tracked.query = tracked.query || parseQueryFromUrl(canonicalUrl);
    if (traceId) {
        tracked.trace_id = safeTraceId(traceId);
        if (canonicalUrl) {
            traceByUrl[canonicalUrl] = safeTraceId(traceId);
        }
    }
    trackedRequests[requestKey] = tracked;
    return tracked;
}

function rememberTrackedJsonBodyObject(bodyObjKey, tracked, traceId) {
    if (!bodyObjKey || !tracked) {
        return;
    }
    if (traceId) {
        traceByBodyObj[bodyObjKey] = safeTraceId(traceId);
    }
    trackedJsonObjects[bodyObjKey] = {
        request_key: tracked.request_key,
        url: tracked.url,
        url_kind: tracked.url_kind,
        ts: now()
    };
}

function updateTrackedRequestBodyFromSummary(tracked, bodySummary) {
    if (!tracked || !bodySummary) {
        return false;
    }
    var parsed = hasMeaningfulJson(bodySummary.json) ? bodySummary.json : null;
    var decodeMode = bodySummary.decode_mode || null;
    var bodyText = bodySummary.text || null;
    if (!parsed && bodyText) {
        var parsedFromText = tryParseJsonText(bodyText);
        if (hasMeaningfulJson(parsedFromText)) {
            parsed = parsedFromText;
            if (!decodeMode) {
                decodeMode = "request_text_parse";
            }
        }
    }

    var changed = false;
    if (
        parsed &&
        (!hasMeaningfulJson(tracked.request_body_json) || tracked.request_body_decode_mode === "ctor_empty_placeholder")
    ) {
        tracked.request_body_json = parsed;
        changed = true;
    }
    if (decodeMode && tracked.request_body_decode_mode !== decodeMode) {
        tracked.request_body_decode_mode = decodeMode;
        changed = true;
    }
    if (bodyText && (!tracked.request_body_text || looksLikeWrapperString(tracked.request_body_text))) {
        tracked.request_body_text = bodyText;
        changed = true;
    }
    if ((!tracked.request_body_text || looksLikeWrapperString(tracked.request_body_text)) && hasMeaningfulJson(tracked.request_body_json)) {
        try {
            tracked.request_body_text = JSON.stringify(tracked.request_body_json);
            changed = true;
        } catch (_) {}
    }
    return changed;
}

function looksLikeNewSmsBodyJson(value) {
    if (!value || typeof value !== "object" || Array.isArray(value)) {
        return false;
    }
    return !!(
        value.mobile ||
        value.countryCode ||
        value.paramNum !== undefined ||
        value.dfp ||
        value.appList ||
        value.channelId
    );
}

function rememberRecentSetLxData(summary, hookName) {
    if (!summary) {
        return;
    }
    var parsed = hasMeaningfulJson(summary.json) ? summary.json : null;
    var text = summary.text || null;
    if (!parsed && (!text || looksLikeWrapperString(text))) {
        return;
    }
    recentSetLxDataEvents.push({
        hook: hookName || "EncryptUtils.setLxData",
        text: text,
        json: parsed,
        decode_mode: summary.decode_mode || null,
        ts: now()
    });
    if (recentSetLxDataEvents.length > 8) {
        recentSetLxDataEvents.splice(0, recentSetLxDataEvents.length - 8);
    }
}

function findRecentSetLxData(maxAgeMs) {
    var nowTs = now();
    var maxAge = maxAgeMs || 3000;
    for (var i = recentSetLxDataEvents.length - 1; i >= 0; i--) {
        var row = recentSetLxDataEvents[i];
        if (!row) {
            continue;
        }
        if (nowTs - Number(row.ts || 0) > maxAge) {
            continue;
        }
        if (row.json && looksLikeNewSmsBodyJson(row.json)) {
            return row;
        }
        if (row.text && !looksLikeWrapperString(row.text)) {
            return row;
        }
    }
    return null;
}

function maybeEmitNewSmsPlaintextEvent(hook, flowStage, traceId, tracked, bodyDigest, bodyOrigin, requestHeaders) {
    if (!tracked || tracked.url_kind !== "new_send_sms" || !hasMeaningfulJson(tracked.request_body_json)) {
        return;
    }
    var effectiveTraceId = safeTraceId(traceId || tracked.trace_id || resolveTraceIdForUrl(tracked.url || ""));
    var effectiveSha = tracked.request_body_sha256 || (bodyDigest ? bodyDigest.sha256 : null);
    if (!tracked.request_body_sha256 && effectiveSha) {
        tracked.request_body_sha256 = effectiveSha;
    }
    var dedupeToken = effectiveSha;
    if (!dedupeToken || isUnknownDigest(dedupeToken)) {
        dedupeToken = String(tracked.request_body_decode_mode || "plaintext") + "|" + String(tracked.url || "");
    }
    if (!shouldEmitBinaryEvent("new_sms_request_plaintext", effectiveTraceId, dedupeToken, "plaintext_resolved")) {
        return;
    }
    var bodyText = tracked.request_body_text;
    if ((!bodyText || looksLikeWrapperString(bodyText)) && tracked.request_body_json) {
        try {
            bodyText = JSON.stringify(tracked.request_body_json);
        } catch (_) {}
    }
    emitEvidence({
        event_type: "new_sms_request_plaintext",
        flow_stage: flowStage,
        hook: hook,
        flow_tag: tracked.flow_tag || "new_send_sms",
        trace_id: effectiveTraceId,
        url_kind: tracked.url_kind,
        url: tracked.url,
        query: tracked.query || parseQueryFromUrl(tracked.url || ""),
        request_headers: requestHeaders || tracked.request_headers || {},
        request_body: bodyText,
        request_body_json: tracked.request_body_json,
        request_body_decode_mode: tracked.request_body_decode_mode || null,
        request_body_sha256: effectiveSha,
        request_body_origin: bodyOrigin ? bodyOrigin.source_event : null,
        request_body_origin_stage: bodyOrigin ? bodyOrigin.flow_stage : null,
        request_body_origin_ts: bodyOrigin ? bodyOrigin.ts : null,
        ts: now()
    });
}

function isFallbackDigest(digestText) {
    var s = String(digestText || "");
    return s.indexOf("fallback:") === 0 || s.indexOf("fb:") === 0;
}

function isUnknownDigest(digestText) {
    var s = String(digestText || "");
    if (!s) {
        return true;
    }
    if (s === "fallback:?:" || s === "fallback:?") {
        return true;
    }
    if (s === "fb:?:" || s === "fb:?") {
        return true;
    }
    return /^fallback:\?:/.test(s) || /^fb:\?:/.test(s);
}

function readJavaInstanceFieldRecursive(obj, fieldName, maxDepth) {
    if (!obj) {
        return null;
    }
    var depthLeft = maxDepth;
    if (!isFinite(depthLeft) || depthLeft <= 0) {
        depthLeft = 8;
    }
    try {
        var cls = obj.getClass();
        while (cls && depthLeft > 0) {
            try {
                var f = cls.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f.get(obj);
            } catch (_) {}
            depthLeft -= 1;
            try {
                cls = cls.getSuperclass();
            } catch (_) {
                break;
            }
        }
    } catch (_) {
    }
    return null;
}

function readJavaInstanceField(obj, fieldName) {
    return readJavaInstanceFieldRecursive(obj, fieldName, 8);
}

function summarizeSw4State(sw4Obj) {
    if (!sw4Obj) {
        return null;
    }
    var mapValue = readJavaInstanceField(sw4Obj, "a");
    var headerValue = readJavaInstanceField(sw4Obj, "b");
    var jsonValue = readJavaInstanceField(sw4Obj, "e");
    var mapJson = parseJavaMapPassive(mapValue, 0);
    var headerJson = parseJavaMapPassive(headerValue, 0);
    var mapText = javaValueToText(mapValue);
    var headerText = javaValueToText(headerValue);
    var mapJsonified = tryJsonifyJavaMap(mapValue);
    var headerJsonified = tryJsonifyJavaMap(headerValue);
    try {
        if ((!mapText || looksLikeWrapperString(mapText)) && mapValue) {
            mapText = safeToString(mapValue.toString());
        }
    } catch (_) {}
    try {
        if ((!headerText || looksLikeWrapperString(headerText)) && headerValue) {
            headerText = safeToString(headerValue.toString());
        }
    } catch (_) {}
    return {
        body_map_text: mapText,
        body_map_json: hasMeaningfulJson(mapJson) ? mapJson : (mapJsonified ? mapJsonified.json : summarizeJavaValue(mapValue).json),
        body_map_decode_mode: hasMeaningfulJson(mapJson) ? "java_map_passive" : (mapJsonified ? mapJsonified.decode_mode : summarizeJavaValue(mapValue).decode_mode),
        header_map_text: headerText,
        header_map_json: hasMeaningfulJson(headerJson) ? headerJson : (headerJsonified ? headerJsonified.json : summarizeJavaValue(headerValue).json),
        header_map_decode_mode: hasMeaningfulJson(headerJson) ? "java_map_passive" : (headerJsonified ? headerJsonified.decode_mode : summarizeJavaValue(headerValue).decode_mode),
        body_json_field_text: javaValueToText(jsonValue),
        body_json_field_json: summarizeJavaValue(jsonValue).json,
        body_json_field_decode_mode: summarizeJavaValue(jsonValue).decode_mode,
        url_text: javaValueToText(readJavaInstanceField(sw4Obj, "f")),
        key_type: toNumberSafe(readJavaInstanceField(sw4Obj, "c")),
        use_new_key: !!readJavaInstanceField(sw4Obj, "d"),
        method: toNumberSafe(readJavaInstanceField(sw4Obj, "j")),
        encrypt_enabled: !!readJavaInstanceField(sw4Obj, "h")
    };
}

function invokeNoArgMethodSafe(obj, methodName) {
    if (!obj) {
        return null;
    }
    try {
        var m = obj[methodName];
        if (typeof m === "function") {
            return m.call(obj);
        }
    } catch (_) {}
    try {
        var cls = obj.getClass();
        var method = cls.getMethod(methodName, []);
        method.setAccessible(true);
        return method.invoke(obj, []);
    } catch (_) {}
    return null;
}

function mergeHeaderMaps(dst, src) {
    if (!src || typeof src !== "object") {
        return dst;
    }
    if (!dst || typeof dst !== "object") {
        dst = {};
    }
    for (var k in src) {
        if (src[k] !== null && src[k] !== undefined) {
            dst[String(k)] = String(src[k]);
        }
    }
    return dst;
}

function parseJavaHeaderList(listObj) {
    var out = {};
    if (!listObj) {
        return out;
    }
    function addHeaderItem(item) {
        if (!item) {
            return;
        }
        var name = null;
        var value = null;
        try {
            name = javaValueToText(item.getName());
        } catch (_) {}
        try {
            value = javaValueToText(item.getValue());
        } catch (_) {}
        if (name === null) {
            name = javaValueToText(readJavaInstanceField(item, "mName"));
        }
        if (value === null) {
            value = javaValueToText(readJavaInstanceField(item, "mValue"));
        }
        if (name !== null) {
            out[String(name)] = value === null ? "" : String(value);
        }
    }
    try {
        var it = listObj.iterator();
        while (it && it.hasNext()) {
            addHeaderItem(it.next());
        }
    } catch (_) {}
    try {
        var size = Number(listObj.size());
        if (isFinite(size) && size > 0) {
            var max = size < 64 ? size : 64;
            for (var i = 0; i < max; i++) {
                addHeaderItem(listObj.get(i));
            }
        }
    } catch (_) {}
    try {
        var len = Number(listObj.length);
        if (isFinite(len) && len > 0) {
            var maxLen = len < 64 ? len : 64;
            for (var j = 0; j < maxLen; j++) {
                addHeaderItem(listObj[j]);
            }
        }
    } catch (_) {}
    return out;
}

function mergeHeaderEvidence(dst, value) {
    var out = dst || {};
    if (!value) {
        return out;
    }
    out = mergeHeaderMaps(out, parseJavaMapPassive(value, 0));
    out = mergeHeaderMaps(out, parseJavaHeaderList(value));
    return out;
}

function extractRequestHeadersDeep(reqObj) {
    var out = {};
    if (!reqObj) {
        return out;
    }
    try {
        out = mergeHeaderEvidence(out, reqObj.getHeaders());
    } catch (_) {}

    var methods = ["getHeaders", "getOriginHeaders", "getRequestHeaders", "getAdditionalHeaders"];
    for (var mi = 0; mi < methods.length; mi++) {
        try {
            out = mergeHeaderEvidence(out, invokeNoArgMethodSafe(reqObj, methods[mi]));
        } catch (_) {}
    }

    var candidates = ["mHeaders", "headers", "mRequestHeaders", "requestHeaders", "mAdditionalHeaders", "additionalHeaders"];
    for (var i = 0; i < candidates.length; i++) {
        try {
            var v = readJavaInstanceField(reqObj, candidates[i]);
            out = mergeHeaderEvidence(out, v);
        } catch (_) {}
    }

    try {
        var cls = reqObj.getClass();
        var clsDepth = 0;
        while (cls && clsDepth < 4) {
            var fields = cls.getDeclaredFields();
            var max = fields.length < 40 ? fields.length : 40;
            for (var j = 0; j < max; j++) {
                try {
                    var f = fields[j];
                    var fn = safeToString(f.getName()).toLowerCase();
                    if (fn.indexOf("header") === -1 && fn.indexOf("auth") === -1 && fn.indexOf("token") === -1) {
                        continue;
                    }
                    f.setAccessible(true);
                    out = mergeHeaderEvidence(out, f.get(reqObj));
                } catch (_) {}
            }
            clsDepth += 1;
            cls = cls.getSuperclass();
        }
    } catch (_) {}
    return out;
}

function extractResponseHeadersDeep(respObj) {
    var out = {};
    if (!respObj) {
        return out;
    }
    var methods = ["getHeaders", "getAllHeaders"];
    for (var mi = 0; mi < methods.length; mi++) {
        try {
            out = mergeHeaderEvidence(out, invokeNoArgMethodSafe(respObj, methods[mi]));
        } catch (_) {}
    }
    var candidates = ["headers", "mHeaders", "allHeaders", "mAllHeaders", "responseHeaders", "mResponseHeaders"];
    for (var i = 0; i < candidates.length; i++) {
        try {
            var v = readJavaInstanceField(respObj, candidates[i]);
            out = mergeHeaderEvidence(out, v);
        } catch (_) {}
    }
    try {
        var networkResponse = readJavaInstanceField(respObj, "networkResponse");
        out = mergeHeaderEvidence(out, readJavaInstanceField(networkResponse, "headers"));
        out = mergeHeaderEvidence(out, readJavaInstanceField(networkResponse, "allHeaders"));
    } catch (_) {}
    return out;
}

function normalizeByteNumber(x) {
    var n = Number(x);
    if (isNaN(n)) {
        return null;
    }
    if (n < 0) {
        n += 256;
    }
    n = n & 0xff;
    return n;
}

function collectByteList(bytesVal, cap) {
    var out = [];
    if (!bytesVal) {
        return out;
    }
    var len = 0;
    try {
        len = Number(bytesVal.length);
    } catch (_) {
        len = 0;
    }
    if (!isFinite(len) || len < 0) {
        len = 0;
    }
    var max = cap;
    if (!max || max <= 0 || max > len) {
        max = len;
    }
    for (var i = 0; i < max; i++) {
        var b = normalizeByteNumber(bytesVal[i]);
        if (b === null) {
            break;
        }
        out.push(b);
    }
    return out;
}

function tryParseRequestJsonCandidate(value) {
    if (value === null || value === undefined) {
        return null;
    }
    var cls = getJavaClassName(value) || "";
    try {
        if (cls === "org.json.JSONObject" || cls === "org.json.JSONArray") {
            var parsed = parseOrgJsonPassive(value, 0);
            if (hasMeaningfulJson(parsed)) {
                return {
                    json: parsed,
                    text: safeToString(value.toString()),
                    decode_mode: "req_obj_reflect",
                    source: cls
                };
            }
        }
    } catch (_) {}
    try {
        if (cls.indexOf("java.util.") === 0) {
            var mapped = parseJavaMapPassive(value, 0);
            if (hasMeaningfulJson(mapped)) {
                return {
                    json: mapped,
                    text: null,
                    decode_mode: "req_map_reflect",
                    source: cls
                };
            }
        }
    } catch (_) {}
    try {
        var txt = javaValueToText(value);
        if (txt !== null && txt !== undefined) {
            var parsedTxt = tryParseJsonText(txt);
            if (hasMeaningfulJson(parsedTxt)) {
                return {
                    json: parsedTxt,
                    text: txt,
                    decode_mode: "req_text_parse",
                    source: cls || "text"
                };
            }
        }
    } catch (_) {}
    return null;
}

function extractRequestJsonSnapshot(reqObj) {
    var out = {
        json: null,
        text: null,
        decode_mode: null,
        source: null
    };
    if (!reqObj) {
        return out;
    }

    function acceptCandidate(candidate) {
        if (!candidate || !hasMeaningfulJson(candidate.json)) {
            return false;
        }
        out.json = candidate.json;
        out.text = candidate.text;
        out.decode_mode = candidate.decode_mode;
        out.source = candidate.source;
        return true;
    }

    var methodCandidates = ["getBodyParams", "getParams", "getRequestArgs", "getJsonBody"];
    for (var i = 0; i < methodCandidates.length; i++) {
        try {
            if (acceptCandidate(tryParseRequestJsonCandidate(invokeNoArgMethodSafe(reqObj, methodCandidates[i])))) {
                return out;
            }
        } catch (_) {}
    }

    var fieldCandidates = [
        "mJsonRequest",
        "jsonRequest",
        "mBody",
        "body",
        "mParams",
        "params",
        "requestArgs",
        "mRequestArgs",
        "mPostBody",
        "postBody",
        "mOriginBody",
        "originBody"
    ];
    for (var fi = 0; fi < fieldCandidates.length; fi++) {
        try {
            if (acceptCandidate(tryParseRequestJsonCandidate(readJavaInstanceField(reqObj, fieldCandidates[fi])))) {
                return out;
            }
        } catch (_) {}
    }

    try {
        var cls = reqObj.getClass();
        var clsDepth = 0;
        while (cls && clsDepth < 4) {
            try {
                var methods = cls.getDeclaredMethods();
                var methodMax = methods.length < 40 ? methods.length : 40;
                for (var mi = 0; mi < methodMax; mi++) {
                    try {
                        var methodObj = methods[mi];
                        var methodName = safeToString(methodObj.getName()).toLowerCase();
                        if (
                            methodName.indexOf("json") === -1 &&
                            methodName.indexOf("param") === -1 &&
                            methodName.indexOf("body") === -1 &&
                            methodName.indexOf("arg") === -1
                        ) {
                            continue;
                        }
                        var paramTypes = methodObj.getParameterTypes();
                        if (!paramTypes || Number(paramTypes.length) !== 0) {
                            continue;
                        }
                        methodObj.setAccessible(true);
                        if (acceptCandidate(tryParseRequestJsonCandidate(methodObj.invoke(reqObj)))) {
                            return out;
                        }
                    } catch (_) {}
                }
            } catch (_) {}
            var fields = cls.getDeclaredFields();
            var max = fields.length < 40 ? fields.length : 40;
            for (var j = 0; j < max; j++) {
                try {
                    var f = fields[j];
                    var fn = safeToString(f.getName()).toLowerCase();
                    if (
                        fn.indexOf("json") === -1 &&
                        fn.indexOf("param") === -1 &&
                        fn.indexOf("body") === -1 &&
                        fn.indexOf("arg") === -1
                    ) {
                        continue;
                    }
                    f.setAccessible(true);
                    if (acceptCandidate(tryParseRequestJsonCandidate(f.get(reqObj)))) {
                        return out;
                    }
                } catch (_) {}
            }
            clsDepth += 1;
            cls = cls.getSuperclass();
        }
    } catch (_) {}

    return out;
}

function decodeUtf8FromBytes(bytes) {
    if (!bytes || bytes.length === 0) {
        return "";
    }
    var out = [];
    for (var i = 0; i < bytes.length; ) {
        var b0 = bytes[i++];
        if (b0 < 0x80) {
            out.push(String.fromCharCode(b0));
            continue;
        }
        if (b0 >= 0xc0 && b0 < 0xe0 && i < bytes.length) {
            var b1 = bytes[i++] & 0x3f;
            out.push(String.fromCharCode(((b0 & 0x1f) << 6) | b1));
            continue;
        }
        if (b0 >= 0xe0 && b0 < 0xf0 && i + 1 < bytes.length) {
            var b2 = bytes[i++] & 0x3f;
            var b3 = bytes[i++] & 0x3f;
            out.push(String.fromCharCode(((b0 & 0x0f) << 12) | (b2 << 6) | b3));
            continue;
        }
        if (b0 >= 0xf0 && b0 < 0xf8 && i + 2 < bytes.length) {
            var c1 = bytes[i++] & 0x3f;
            var c2 = bytes[i++] & 0x3f;
            var c3 = bytes[i++] & 0x3f;
            var cp = ((b0 & 0x07) << 18) | (c1 << 12) | (c2 << 6) | c3;
            cp -= 0x10000;
            out.push(String.fromCharCode(0xd800 | ((cp >> 10) & 0x3ff)));
            out.push(String.fromCharCode(0xdc00 | (cp & 0x3ff)));
            continue;
        }
        out.push("\uFFFD");
    }
    return out.join("");
}

function encodeBase64FromBytes(bytes) {
    var table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    if (!bytes || bytes.length === 0) {
        return "";
    }
    var out = [];
    for (var i = 0; i < bytes.length; i += 3) {
        var b0 = bytes[i];
        var b1 = i + 1 < bytes.length ? bytes[i + 1] : 0;
        var b2 = i + 2 < bytes.length ? bytes[i + 2] : 0;
        var n = (b0 << 16) | (b1 << 8) | b2;
        out.push(table.charAt((n >> 18) & 63));
        out.push(table.charAt((n >> 12) & 63));
        out.push(i + 1 < bytes.length ? table.charAt((n >> 6) & 63) : "=");
        out.push(i + 2 < bytes.length ? table.charAt(n & 63) : "=");
    }
    return out.join("");
}

function encodeHexFromBytes(bytes) {
    if (!bytes || bytes.length === 0) {
        return "";
    }
    var out = [];
    for (var i = 0; i < bytes.length; i++) {
        var h = (bytes[i] & 0xff).toString(16);
        out.push(h.length === 1 ? "0" + h : h);
    }
    return out.join("");
}

function sanitizeUtf16String(text) {
    if (text === null || text === undefined) {
        return text;
    }
    var s = String(text);
    var out = [];
    for (var i = 0; i < s.length; i++) {
        var code = s.charCodeAt(i);
        if (code >= 0xd800 && code <= 0xdbff) {
            if (i + 1 < s.length) {
                var low = s.charCodeAt(i + 1);
                if (low >= 0xdc00 && low <= 0xdfff) {
                    out.push(s.charAt(i));
                    out.push(s.charAt(i + 1));
                    i += 1;
                    continue;
                }
            }
            out.push("\uFFFD");
            continue;
        }
        if (code >= 0xdc00 && code <= 0xdfff) {
            out.push("\uFFFD");
            continue;
        }
        out.push(s.charAt(i));
    }
    return out.join("");
}

function isLikelyBinaryUtf8(text) {
    if (text === null || text === undefined) {
        return false;
    }
    var s = String(text);
    if (s.length === 0) {
        return false;
    }
    var printable = 0;
    var weird = 0;
    var control = 0;
    var replacement = 0;
    var nonAscii = 0;
    var max = s.length < 512 ? s.length : 512;
    for (var i = 0; i < max; i++) {
        var c = s.charCodeAt(i);
        if (c === 0xfffd) {
            replacement += 1;
        }
        if (c < 32 && c !== 9 && c !== 10 && c !== 13) {
            control += 1;
        }
        if (c > 126) {
            nonAscii += 1;
        }
        if (c === 9 || c === 10 || c === 13 || (c >= 32 && c <= 126) || c > 159) {
            printable += 1;
        } else {
            weird += 1;
        }
    }
    if (control > 0 || replacement > 0) {
        return true;
    }
    var lead = s.charAt(0);
    if (lead !== "{" && lead !== "[" && nonAscii > max * 0.45) {
        return true;
    }
    return weird > printable;
}

function decodeJavaByteArray(bytesObj) {
    var out = {
        length: null,
        utf8: null,
        base64: null,
        base64_preview: null,
        hex_full: null,
        hex_preview: null,
        ascii_preview: null,
        is_binary: null
    };
    if (!bytesObj) {
        return out;
    }
    var bytesVal = bytesObj;
    try {
        if (typeof Java !== "undefined" && Java && typeof Java.array === "function") {
            bytesVal = Java.array("byte", bytesObj);
        }
    } catch (_) {
        bytesVal = bytesObj;
    }
    try {
        var len = Number(bytesVal.length);
        if (!isNaN(len)) {
            out.length = len;
        }
    } catch (_) {}
    try {
        if (!javaStringClass) {
            javaStringClass = Java.use("java.lang.String");
        }
        out.utf8 = sanitizeUtf16String(safeToString(javaStringClass.$new(bytesVal, "UTF-8")));
    } catch (_) {}
    try {
        if (!javaBase64Class) {
            javaBase64Class = Java.use("android.util.Base64");
        }
        out.base64 = safeToString(javaBase64Class.encodeToString(bytesObj, 2));
    } catch (_) {}
    var bytesForDecode = collectByteList(bytesVal, out.length !== null ? out.length : 32768);
    if ((out.utf8 === null || out.utf8 === "") && bytesForDecode.length > 0) {
        try {
            out.utf8 = sanitizeUtf16String(decodeUtf8FromBytes(bytesForDecode));
        } catch (_) {}
    }
    if ((out.base64 === null || out.base64 === "") && bytesForDecode.length > 0) {
        try {
            out.base64 = encodeBase64FromBytes(bytesForDecode);
        } catch (_) {}
    }
    if (out.base64) {
        out.base64_preview = out.base64.length > 256 ? out.base64.substring(0, 256) : out.base64;
        out.base64 = null;
    }
    if (bytesForDecode.length > 0) {
        try {
            out.hex_full = encodeHexFromBytes(bytesForDecode);
        } catch (_) {}
    }
    if (out.hex_preview === null) {
        try {
            var n = bytesForDecode.length < 64 ? bytesForDecode.length : 64;
            if (n > 0) {
                var hexParts = [];
                var asciiParts = [];
                for (var i = 0; i < n; i++) {
                    var b = bytesForDecode[i];
                    var h = b.toString(16);
                    hexParts.push(h.length === 1 ? "0" + h : h);
                    asciiParts.push(b >= 32 && b <= 126 ? String.fromCharCode(b) : ".");
                }
                if (hexParts.length > 0) {
                    out.hex_preview = hexParts.join("");
                    out.ascii_preview = asciiParts.join("");
                }
            }
        } catch (_) {}
    }
    out.is_binary = isLikelyBinaryUtf8(out.utf8);
    if (out.is_binary) {
        out.utf8 = null;
        out.base64 = null;
    }
    return out;
}

function sha256HexFromByteArray(bytesObj) {
    if (!bytesObj) {
        return null;
    }
    try {
        if (!javaMessageDigestClass) {
            javaMessageDigestClass = Java.use("java.security.MessageDigest");
        }
        var md = javaMessageDigestClass.getInstance("SHA-256");
        var digestInput = bytesObj;
        try {
            digestInput = Java.array("byte", bytesObj);
        } catch (_) {}
        if (!digestInput || digestInput === bytesObj) {
            try {
                var len = Number(bytesObj.length);
                if (isFinite(len) && len > 0) {
                    var raw = collectByteList(bytesObj, len);
                    if (raw.length > 0) {
                        var signed = [];
                        for (var i = 0; i < raw.length; i++) {
                            var b = raw[i];
                            signed.push(b > 127 ? b - 256 : b);
                        }
                        digestInput = Java.array("byte", signed);
                    }
                }
            } catch (_) {}
        }
        var digestObj = md.digest(digestInput);
        var digestArr = digestObj;
        try {
            digestArr = Java.array("byte", digestObj);
        } catch (_) {
            digestArr = digestObj;
        }
        var parts = [];
        var len = 0;
        try {
            len = Number(digestArr.length);
        } catch (_) {
            len = 0;
        }
        for (var i = 0; i < len; i++) {
            var b = normalizeByteNumber(digestArr[i]);
            if (b === null) {
                break;
            }
            var h = b.toString(16);
            parts.push(h.length === 1 ? "0" + h : h);
        }
        if (parts.length > 0) {
            return parts.join("");
        }
    } catch (_) {}
    return null;
}

function buildBinaryDigest(bytesObj, decoded) {
    var out = {
        sha256: null,
        length: decoded ? decoded.length : null,
        hex_preview: decoded ? decoded.hex_preview : null
    };
    try {
        out.sha256 = sha256HexFromByteArray(bytesObj);
    } catch (_) {}
    if (!out.sha256) {
        var lenText = out.length === null || out.length === undefined ? "?" : String(out.length);
        var basis = lenText + "|" + String(out.hex_preview || "");
        var h = 2166136261;
        for (var i = 0; i < basis.length; i++) {
            h ^= basis.charCodeAt(i) & 0xff;
            h = (h * 16777619) >>> 0;
        }
        var hv = h.toString(16);
        while (hv.length < 8) {
            hv = "0" + hv;
        }
        out.sha256 = "fb:" + lenText + ":" + hv;
    }
    return out;
}

function rememberBinaryOrigin(digest, row) {
    if (!digest || !digest.sha256 || isUnknownDigest(digest.sha256)) {
        return;
    }
    binaryOriginBySha256[digest.sha256] = row;
}

function lookupBinaryOrigin(digest) {
    if (!digest || !digest.sha256 || isUnknownDigest(digest.sha256)) {
        return null;
    }
    return binaryOriginBySha256[digest.sha256] || null;
}

function resolveBodyLength(decoded, origin) {
    if (decoded && decoded.length !== null && decoded.length !== undefined) {
        return decoded.length;
    }
    if (origin && origin.length !== null && origin.length !== undefined) {
        return origin.length;
    }
    return null;
}

function resolveBodyIsBinary(decoded, origin) {
    if (decoded && decoded.is_binary !== null && decoded.is_binary !== undefined) {
        return decoded.is_binary;
    }
    if (!origin) {
        return null;
    }
    if (origin.is_binary !== null && origin.is_binary !== undefined) {
        return origin.is_binary;
    }
    if (origin.source_event === "java_encrypt_entry" || origin.source_event === "java_encrypt_compact") {
        return true;
    }
    return null;
}

function shouldEmitBinaryEvent(eventType, traceId, sha256, flowStage) {
    var key = String(eventType || "") + "|" + String(traceId || "") + "|" + String(sha256 || "") + "|" + String(flowStage || "");
    if (binaryEventSeen[key]) {
        return false;
    }
    binaryEventSeen[key] = now();
    return true;
}

function compactHexForEvent(hexText) {
    var s = String(hexText || "");
    if (!s) {
        return null;
    }
    if (s.length <= HEX_INLINE_MAX) {
        return s;
    }
    return s.substring(0, HEX_INLINE_MAX);
}

function emitBinaryHexChunks(payloadType, flowTag, flowStage, traceId, sha256, hexText, extra) {
    if (!ENABLE_FULL_HEX_CHUNKS) {
        return;
    }
    var hex = String(hexText || "");
    if (!hex) {
        return;
    }
    var chunkSize = HEX_CHUNK_SIZE;
    if (!chunkSize || chunkSize < 256) {
        chunkSize = 2048;
    }
    var total = Math.ceil(hex.length / chunkSize);
    if (!isFinite(total) || total <= 0) {
        return;
    }
    var tsNow = now();
    for (var i = 0; i < total; i++) {
        var start = i * chunkSize;
        var end = start + chunkSize;
        if (end > hex.length) {
            end = hex.length;
        }
        var row = {
            event_type: "binary_payload_chunk",
            flow_tag: flowTag || null,
            flow_stage: flowStage || null,
            trace_id: safeTraceId(traceId),
            payload_type: payloadType || null,
            sha256: sha256 || null,
            hex_total_len: hex.length,
            chunk_index: i,
            chunk_total: total,
            chunk_hex: hex.substring(start, end),
            ts: tsNow
        };
        if (extra && typeof extra === "object") {
            if (extra.url !== undefined) {
                row.url = extra.url;
            }
            if (extra.url_kind !== undefined) {
                row.url_kind = extra.url_kind;
            }
            if (extra.hook !== undefined) {
                row.hook = extra.hook;
            }
        }
        emitEvidence(row);
    }
}

function patchThreadEntry(realFunc, sourceTag, applyRoutine) {
    if (!ENABLE_THREAD_RET_PATCH || !dummyThreadRoutine || isNullPtr(dummyThreadRoutine)) {
        return;
    }
    try {
        var realPtr = ptrOrNull(realFunc);
        if (isNullPtr(realPtr)) {
            return;
        }

        var module = Module.findByAddress(realPtr);
        if (!module || module.name !== TARGET_SO_NAME) {
            return;
        }

        var offsetHex = strip0x(realPtr.sub(module.base).toString());
        if (!isKnownOffset(offsetHex)) {
            return;
        }

        applyRoutine(dummyThreadRoutine);

        if (!patchedOffsets[offsetHex]) {
            patchedOffsets[offsetHex] = true;
            log("[+] redirected " + sourceTag + " thread entry: " + TARGET_SO_NAME + "+0x" + offsetHex);
            emitEvidence({
                event_type: "native_thread_redirect",
                source: sourceTag,
                module: TARGET_SO_NAME,
                offset_hex: "0x" + offsetHex,
                replacement: dummyThreadRoutine.toString(),
                ts: now()
            });
            if (!threadHookRetired && allKnownOffsetsPatched() && pthreadCreateAddr) {
                try {
                    unhook(pthreadCreateAddr);
                    threadHookRetired = true;
                    log("[*] retired pthread_create hook after all known offsets were redirected");
                } catch (unhookError) {
                    log("[-] retire pthread_create hook failed: " + unhookError);
                }
            }
        }
    } catch (e) {
        log("[-] patchThreadEntry error: " + e);
    }
}

function hookClone() {
    if (!ENABLE_THREAD_RET_PATCH) {
        return;
    }
    var cloneAddr = findExportCompat(null, "clone");
    if (!cloneAddr || isNullPtr(cloneAddr)) {
        log("[-] clone not found");
        return;
    }
    log("[*] hook clone @ " + cloneAddr);
    try {
        hookCompat(cloneAddr, function(ctx) {
            try {
                var childStack = ptrOrNull(ctx.x3);
                if (isNullPtr(childStack)) {
                    return ctx.orig();
                }
                var entrySlot = childStack.add(96);
                var realFunc = Memory.readPointer(entrySlot);
                patchThreadEntry(realFunc, "clone", function(routine) {
                    Memory.writePointer(entrySlot, routine);
                });
            } catch (e) {
                log("[-] clone hook error: " + e);
            }
            return ctx.orig();
        }, PTHREAD_HOOK_MODE);
    } catch (e) {
        log("[-] install clone hook failed: " + e);
    }
}

function hookPthreadCreate() {
    if (!ENABLE_THREAD_RET_PATCH) {
        return;
    }
    pthreadCreateAddr = findExportCompat("libc.so", "pthread_create");
    if (!pthreadCreateAddr || isNullPtr(pthreadCreateAddr)) {
        pthreadCreateAddr = findExportCompat(null, "pthread_create");
    }
    if (!pthreadCreateAddr || isNullPtr(pthreadCreateAddr)) {
        log("[-] pthread_create not found");
        return;
    }
    log("[*] hook pthread_create @ " + pthreadCreateAddr);
    try {
        hookCompat(pthreadCreateAddr, function(ctx) {
            try {
                var startRoutine = ptrOrNull(ctx.x2);
                if (!isNullPtr(startRoutine)) {
                    patchThreadEntry(startRoutine, "pthread_create", function(routine) {
                        ctx.x2 = routine;
                    });
                }
            } catch (e) {
                log("[-] pthread_create hook error: " + e);
            }
            return ctx.orig();
        }, PTHREAD_HOOK_MODE);
    } catch (e) {
        log("[-] install pthread_create hook failed: " + e);
        if (ALLOW_PTHREAD_HOOK_FALLBACK && typeof Hook !== "undefined") {
            try {
                hookCompat(pthreadCreateAddr, function(ctx) {
                    try {
                        var startRoutine = ptrOrNull(ctx.x2);
                        if (!isNullPtr(startRoutine)) {
                            patchThreadEntry(startRoutine, "pthread_create_fallback", function(routine) {
                                ctx.x2 = routine;
                            });
                        }
                    } catch (fallbackError) {
                        log("[-] pthread_create fallback hook error: " + fallbackError);
                    }
                    return ctx.orig();
                }, Hook.NORMAL);
                log("[*] pthread_create fallback hook installed with Hook.NORMAL");
            } catch (fallbackInstallError) {
                log("[-] install pthread_create fallback hook failed: " + fallbackInstallError);
            }
        }
    }
}

function hookDlopenLike(symbolName) {
    var installed = false;
    var candidates = [
        { module: "libdl.so", address: findExportCompat("libdl.so", symbolName) },
        { module: null, address: findExportCompat(null, symbolName) },
        { module: "libc.so", address: findExportCompat("libc.so", symbolName) }
    ];
    var seen = {};
    for (var i = 0; i < candidates.length; i++) {
        var row = candidates[i];
        var addr = ptrOrNull(row.address);
        if (isNullPtr(addr)) {
            continue;
        }
        var key = addr.toString();
        if (seen[key]) {
            continue;
        }
        seen[key] = true;
        if (hookDlopenAddress(addr, symbolName, row.module || symbolName)) {
            installed = true;
        }
    }
    if (!installed) {
        log("[-] no installable address for " + symbolName);
    }
}

function hookDlopenAddress(addr, symbolName, moduleName) {
    var targetAddr = ptrOrNull(addr);
    if (isNullPtr(targetAddr)) {
        return false;
    }
    var addrKey = targetAddr.toString();
    if (dlopenHookedByAddr[addrKey]) {
        return true;
    }
    log("[*] hook " + symbolName + " @ " + targetAddr + " module=" + moduleName);
    function dlopenCallback(ctx) {
        var path = safeReadCString(ctx.x0);
        var ret = ctx.orig();
        var matched = keywordMatched(path, NATIVE_TARGET_MODULE_KEYWORDS);
        // In no-timer environments, use each dlopen edge as passive recovery trigger.
        maybeRecoverFromDlopen(path, symbolName);
        if (matched) {
            log("[dlopen] " + symbolName + " loaded target path=" + path);
            emitEvidence({
                event_type: "module_load",
                hook: symbolName,
                hook_module: moduleName || null,
                module: path,
                path: path,
                base: safeToString(Module.findBaseAddress(path)),
                ts: now()
            });
            installEncryptNativeHooksFromExports();
        }
        return ret;
    }

    function tryInstall(mode, tag) {
        try {
            hookCompat(targetAddr, dlopenCallback, mode);
            dlopenHookedByAddr[addrKey] = {
                hook: symbolName,
                module: moduleName || null,
                mode: tag
            };
            log("[+] " + symbolName + " hook installed (" + tag + ")");
            return true;
        } catch (e) {
            log("[-] install " + symbolName + " hook failed (" + tag + "): " + e);
            return false;
        }
    }

    if (tryInstall(NATIVE_HOOK_MODE, "preferred")) {
        return true;
    }
    if (typeof Hook !== "undefined" && Hook.RECOMP !== undefined) {
        if (tryInstall(Hook.RECOMP, "recomp")) {
            return true;
        }
    }
    if (typeof Hook !== "undefined") {
        return tryInstall(Hook.NORMAL, "fallback");
    }
    return false;
}

function hookDlopenCandidates() {
    var rows = findDlopenCandidates();
    if (rows.length <= 0) {
        log("[*] dlopen candidate scan found 0 symbols");
        return;
    }
    log("[*] dlopen candidate scan found " + rows.length + " symbols");
    for (var i = 0; i < rows.length; i++) {
        hookDlopenAddress(rows[i].address, rows[i].symbol, rows[i].module);
    }
}

function summarizeNativeMethod(method) {
    var module = Module.findByAddress(method.fnPtr);
    return {
        name: method.name || null,
        sig: method.sig || null,
        fn_ptr: method.fnPtr ? method.fnPtr.toString() : null,
        module: module ? module.name : null,
        module_offset: module ? method.fnPtr.sub(module.base).toString() : null
    };
}

function canonicalEncryptMethodName(name, sig, allowSigFallback) {
    var n = String(name || "");
    var s = String(sig || "");
    if (n === "setLxData" || n === "createCKey" || n === "getEncryptedCKey" || n === "cipherWithHashKey") {
        return n;
    }
    if (!allowSigFallback) {
        return null;
    }
    if (s === "(Ljava/lang/String;)V") {
        return "setLxData";
    }
    if (s === "()Ljava/lang/String;") {
        return "createCKey";
    }
    if (s === "(Ljava/lang/String;)Ljava/lang/String;") {
        return "getEncryptedCKey";
    }
    if (s === "(Lorg/json/JSONObject;IZ)[B") {
        return "cipherWithHashKey";
    }
    return null;
}

function installEncryptNativeHooks(methods) {
    if (!ENABLE_ENCRYPT_NATIVE_BUFFER_HOOK) {
        return;
    }
    for (var i = 0; i < methods.length; i++) {
        var method = methods[i];
        if (!method) {
            continue;
        }
        var allowSigFallback = !!method.allow_sig_fallback;
        var canonicalName = canonicalEncryptMethodName(method.name, method.sig, allowSigFallback);
        if (!canonicalName || encryptNativeHooksInstalled[canonicalName]) {
            continue;
        }

        encryptNativeHooksInstalled[canonicalName] = true;
        (function(nativeMethod) {
            var fnPtr = ptrOrNull(nativeMethod.fnPtr);
            if (isNullPtr(fnPtr)) {
                return;
            }
            var sig = String(nativeMethod.sig || "");
            var allowSigFallback = !!nativeMethod.allow_sig_fallback;
            var methodName = canonicalEncryptMethodName(nativeMethod.name, nativeMethod.sig, allowSigFallback) || String(nativeMethod.name || "unknown");
            var paramTypes = parseJniParamTypes(sig);
            var retType = parseJniRetType(sig);
            var module = Module.findByAddress(fnPtr);
            var moduleName = module ? module.name : null;
            var moduleOffset = module ? fnPtr.sub(module.base).toString() : null;
            log("[*] hook encrypt native: " + methodName + " sig=" + sig + " @ " + fnPtr + " raw_name=" + String(nativeMethod.name || ""));
            try {
                hookCompat(fnPtr, function(ctx) {
                    var ret = ctx.orig();
                    try {
                        if (!nativeMethodWithinLimit(methodName)) {
                            return ret;
                        }
                        var envPtr = ptrOrNull(ctx.x0);
                        var args = [];
                        if (paramTypes.length > 0) {
                            for (var pi = 0; pi < paramTypes.length; pi++) {
                                var argPtr = getCtxArgRegister(ctx, pi);
                                var argSummary = summarizeJniArgByType(envPtr, argPtr, paramTypes[pi]);
                                argSummary.arg_index = pi;
                                args.push(argSummary);
                            }
                        } else {
                            for (var ri = 2; ri <= 5; ri++) {
                                var regKey = "x" + ri;
                                var regPtr = ptrOrNull(ctx[regKey]);
                                args.push({
                                    arg_index: ri - 2,
                                    jni_type: "unknown",
                                    ptr: regPtr.toString(),
                                    value: safeReadCString(regPtr),
                                    object_class: tryGetObjectClassName(envPtr, regPtr),
                                    buffer_preview: readBytesPreview(regPtr, NATIVE_BUFFER_PREVIEW_MAX)
                                });
                            }
                        }

                        var regSnapshot = {
                            x0: ptrToString(ctx.x0),
                            x1: ptrToString(ctx.x1),
                            x2: ptrToString(ctx.x2),
                            x3: ptrToString(ctx.x3),
                            x4: ptrToString(ctx.x4),
                            x5: ptrToString(ctx.x5),
                            x6: ptrToString(ctx.x6),
                            x7: ptrToString(ctx.x7)
                        };

                        var retSummary = summarizeJniRetValue(envPtr, ret, retType);
                        emitEvidence({
                            event_type: "native_encrypt_buffer",
                            hook: "native." + methodName,
                            native_method: methodName,
                            native_method_raw: String(nativeMethod.name || ""),
                            sig: sig,
                            fn_ptr: fnPtr.toString(),
                            module: moduleName,
                            module_offset: moduleOffset,
                            registers: regSnapshot,
                            args: args,
                            ret: retSummary,
                            ts: now()
                        });
                    } catch (innerError) {
                        log("[-] native hook emit error (" + methodName + "): " + innerError);
                    }
                    return ret;
                }, NATIVE_HOOK_MODE);
            } catch (installError) {
                log("[-] install native encrypt hook failed (" + methodName + "): " + installError);
            }
        })(method);
    }
}

function installEncryptNativeHooksFromExports() {
    if (!ENABLE_ENCRYPT_NATIVE_BUFFER_HOOK) {
        return;
    }
    var directTargets = [
        {
            name: "setLxData",
            sym: "Java_com_zenmen_palmchat_utils_EncryptUtils_setLxData",
            sig: "(Ljava/lang/String;)V"
        },
        {
            name: "createCKey",
            sym: "Java_com_zenmen_palmchat_utils_EncryptUtils_createCKey",
            sig: "()Ljava/lang/String;"
        },
        {
            name: "getEncryptedCKey",
            sym: "Java_com_zenmen_palmchat_utils_EncryptUtils_getEncryptedCKey",
            sig: "(Ljava/lang/String;)Ljava/lang/String;"
        },
        {
            name: "cipherWithHashKey",
            sym: "Java_com_zenmen_palmchat_utils_EncryptUtils_cipherWithHashKey",
            sig: "(Lorg/json/JSONObject;IZ)[B"
        }
    ];

    var synthetic = [];
    for (var i = 0; i < directTargets.length; i++) {
        var t = directTargets[i];
        var addr = findExportCompat(null, t.sym);
        if (!addr || isNullPtr(addr)) {
            continue;
        }
        synthetic.push({
            name: t.name,
            sig: t.sig,
            fnPtr: ptrOrNull(addr)
        });
    }

    if (synthetic.length > 0) {
        log("[*] direct JNI export fallback hit: " + synthetic.length + " symbols");
        installEncryptNativeHooks(synthetic);
    } else {
        log("[*] direct JNI export fallback found 0 symbols");
    }

    // rnidbg-boss style fallback: recover JNINativeMethod triplets from runtime module memory.
    installEncryptNativeHooksFromJniTable();
}

function hookRegisterNatives() {
    if (!ENABLE_REGISTER_NATIVES_HOOK) {
        return;
    }
    if (registerNativesHookInstalled) {
        return;
    }
    var addr = Jni.addr("RegisterNatives");
    if (!addr || isNullPtr(addr)) {
        log("[-] RegisterNatives not found");
        return;
    }
    log("[*] hook RegisterNatives @ " + addr);
    function registerNativesCallback(ctx) {
        try {
            var className = Jni.helper.env.getClassName(ctx.x1);
            var count = Number(ctx.x3);
            var methods = Jni.helper.structs.JNINativeMethod.readArray(ptr(ctx.x2), count);
            var summary = [];
            var targetHit = false;
            var classText = String(className || "");
            var classLikelyTarget =
                classText === TARGET_CLASS_NAME ||
                classText.indexOf("EncryptUtils") !== -1 ||
                classText.indexOf("encryptutils") !== -1;
            for (var i = 0; i < methods.length; i++) {
                var sm = summarizeNativeMethod(methods[i]);
                sm.allow_sig_fallback = classLikelyTarget;
                sm.canonical_name = canonicalEncryptMethodName(sm.name, sm.sig, classLikelyTarget);
                if (sm.canonical_name) {
                    targetHit = true;
                }
                methods[i].allow_sig_fallback = classLikelyTarget;
                summary.push(sm);
            }
            if (targetHit || classLikelyTarget) {
                emitEvidence({
                    event_type: "jni_register_natives",
                    class_name: className,
                    target_hit: targetHit,
                    methods: summary,
                    ts: now()
                });
                installEncryptNativeHooks(methods);
            }
        } catch (e) {
            log("[-] RegisterNatives hook error: " + e);
        }
        return ctx.orig();
    }

    function tryInstall(mode, tag) {
        try {
            hookCompat(addr, registerNativesCallback, mode);
            registerNativesHookInstalled = true;
            log("[+] RegisterNatives hook installed (" + tag + ")");
            return true;
        } catch (e) {
            log("[-] install RegisterNatives hook failed (" + tag + "): " + e);
            return false;
        }
    }

    if (tryInstall(PTHREAD_HOOK_MODE, "preferred")) {
        return;
    }
    if (typeof Hook !== "undefined") {
        tryInstall(Hook.NORMAL, "fallback");
    }
}

function hookFindClassRecovery() {
    if (!ENABLE_FINDCLASS_RECOVERY_HOOK || findClassHookInstalled) {
        return;
    }
    var addr = Jni.addr("FindClass");
    if (!addr || isNullPtr(addr)) {
        log("[-] FindClass not found");
        return;
    }
    log("[*] hook FindClass @ " + addr);
    findClassHookAddr = addr;
    function findClassCallback(ctx) {
        var className = safeReadCString(ctx.x1);
        var ret = ctx.orig();
        try {
            if (passiveRecoveryFinished || countEncryptNativeHooksInstalled() > 0) {
                return ret;
            }
            var lowered = String(className || "").toLowerCase();
            var shouldProbe =
                lowered.indexOf("encryptutils") !== -1 ||
                lowered.indexOf("com/zenmen/palmchat") !== -1;
            if (!shouldProbe) {
                return ret;
            }
            emitEvidence({
                event_type: "jni_findclass_probe",
                class_name: className || "",
                ts: now()
            });
            installEncryptNativeHooksFromExports();
            if (lowered.indexOf("encryptutils") !== -1 && findClassHookAddr && !isNullPtr(findClassHookAddr)) {
                try {
                    unhook(findClassHookAddr);
                    findClassHookInstalled = false;
                    log("[*] FindClass hook retired after EncryptUtils probe");
                    emitEvidence({
                        event_type: "jni_findclass_retired",
                        reason: "encryptutils_seen",
                        ts: now()
                    });
                } catch (unhookErr) {
                    log("[-] FindClass unhook failed: " + unhookErr);
                }
            }
        } catch (e) {
            log("[-] FindClass callback error: " + e);
        }
        return ret;
    }

    function tryInstall(mode, tag) {
        try {
            hookCompat(addr, findClassCallback, mode);
            findClassHookInstalled = true;
            log("[+] FindClass hook installed (" + tag + ")");
            return true;
        } catch (e) {
            log("[-] install FindClass hook failed (" + tag + "): " + e);
            return false;
        }
    }

    if (tryInstall(NATIVE_HOOK_MODE, "preferred")) {
        return;
    }
    if (typeof Hook !== "undefined") {
        tryInstall(Hook.NORMAL, "fallback");
    }
}

function hookNetworkLogger() {
    try {
        var d54 = Java.use("d54");
        var reqOv = d54.c.overload("java.lang.String", "int", "org.json.JSONObject");
        var respOv = d54.d.overload("java.lang.String", "int", "java.lang.Object");

        reqOv.impl = function(ctx) {
            var urlText = safeToString(ctx.args[0]);
            var urlKind = getUrlKind(urlText);
            if (urlKind) {
                var query = parseQueryFromUrl(urlText);
                var traceId = getTraceIdFromUrl(urlText);
                emitEvidence({
                    event_type: "java_network_pre_encrypt",
                    hook: "d54.c",
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    method: Number(ctx.args[1]),
                    json_body: safeToString(ctx.args[2]),
                    callback: query.callback || null,
                    captchaUuid: query.captchaUuid || null,
                    ts: now()
                });
                log("[req] " + urlText + " method=" + safeToString(ctx.args[1]));
            }
            return ctx.orig();
        };

        respOv.impl = function(ctx) {
            var urlText = safeToString(ctx.args[0]);
            var urlKind = getUrlKind(urlText);
            if (urlKind) {
                var traceId = getTraceIdFromUrl(urlText);
                emitEvidence({
                    event_type: "java_network_response",
                    hook: "d54.d",
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    code: Number(ctx.args[1]),
                    data: safeToString(ctx.args[2]),
                    ts: now()
                });
                log("[resp] " + urlText + " code=" + safeToString(ctx.args[1]));
            }
            return ctx.orig();
        };

        log("[+] d54 hooks installed");
    } catch (e) {
        log("[-] d54 hook failed: " + e);
    }
}

function hookEncryptEntry() {
    try {
        var EncryptUtils = Java.use(TARGET_CLASS_NAME);
        var cipherOv = EncryptUtils.cipherWithHashKey.overload("org.json.JSONObject", "int", "boolean");
        cipherOv.impl = function(ctx) {
            var bodySummary = summarizeJavaValue(ctx.args[0]);
            var bodyObjKey = getStableObjectKey(ctx.args[0]);
            var traceId = bodyObjKey ? traceByBodyObj[bodyObjKey] : null;
            var ret = ctx.orig();
            var outDecoded = decodeJavaByteArray(ret);
            var outDigest = buildBinaryDigest(ret, outDecoded);
            var row = {
                source_event: "java_encrypt_entry",
                source_hook: "EncryptUtils.cipherWithHashKey",
                flow_stage: "request_encrypt_produce",
                flow_tag: "new_send_sms",
                trace_id: safeTraceId(traceId),
                ts: now(),
                method: Number(ctx.args[1]),
                flag: !!ctx.args[2],
                sha256: outDigest.sha256,
                length: outDecoded ? outDecoded.length : null,
                is_binary: outDecoded ? outDecoded.is_binary : null
            };
            rememberBinaryOrigin(outDigest, row);
            if (traceId && outDigest && outDigest.sha256) {
                binaryShaByTrace[String(traceId)] = outDigest.sha256;
                var trackedByTrace = lookupTrackedByTraceId(traceId);
                if (trackedByTrace) {
                    trackedByTrace.request_body_sha256 = outDigest.sha256;
                }
            }
            if (row.flow_tag === "new_send_sms") {
                emitBinaryHexChunks(
                    "java_encrypt_output",
                    "new_send_sms",
                    "request_encrypt_produce",
                    traceId,
                    outDigest.sha256,
                    outDecoded ? outDecoded.hex_full : null,
                    {
                        hook: "EncryptUtils.cipherWithHashKey"
                    }
                );
            }
            emitEvidence({
                event_type: "java_encrypt_compact",
                hook: "EncryptUtils.cipherWithHashKey",
                flow_stage: "request_encrypt_produce",
                flow_tag: "new_send_sms",
                trace_id: safeTraceId(traceId),
                json_body_class: bodySummary.class_name,
                json_body_decode_mode: bodySummary.decode_mode,
                json_body_object_key: bodyObjKey,
                json_body_keys: bodySummary.json && typeof bodySummary.json === "object" && !Array.isArray(bodySummary.json) ? Object.keys(bodySummary.json) : null,
                method: Number(ctx.args[1]),
                flag: !!ctx.args[2],
                output_sha256: outDigest.sha256,
                output_is_binary: outDecoded ? outDecoded.is_binary : null,
                output_length: outDecoded ? outDecoded.length : null,
                output_hex_inline: compactHexForEvent(outDecoded ? outDecoded.hex_full : null),
                output_hex_total_len: outDecoded && outDecoded.hex_full ? outDecoded.hex_full.length : null,
                output_hex_chunked: outDecoded && outDecoded.hex_full ? outDecoded.hex_full.length > HEX_INLINE_MAX : false,
                ts: now()
            });
            emitEvidence({
                event_type: "java_encrypt_entry",
                hook: "EncryptUtils.cipherWithHashKey",
                flow_stage: "request_encrypt_produce",
                flow_tag: "new_send_sms",
                trace_id: safeTraceId(traceId),
                method: Number(ctx.args[1]),
                flag: !!ctx.args[2],
                output_sha256: outDigest.sha256,
                output_is_binary: outDecoded ? outDecoded.is_binary : null,
                output_length: outDecoded ? outDecoded.length : null,
                ts: now()
            });
            return ret;
        };
        log("[+] EncryptUtils.cipherWithHashKey hook installed");
    } catch (e) {
        log("[-] EncryptUtils hook failed: " + e);
    }
}

function hookEncryptSupportEntry() {
    try {
        var EncryptUtils = Java.use(TARGET_CLASS_NAME);
        var installedAny = false;

        function summarizeSetLxDataArg(value) {
            var bodySummary = summarizeJavaValue(value);
            if (
                (!hasMeaningfulJson(bodySummary.json) || looksLikeWrapperString(bodySummary.text)) &&
                bodySummary.text
            ) {
                var parsed = tryParseJsonText(bodySummary.text);
                if (hasMeaningfulJson(parsed)) {
                    bodySummary.json = parsed;
                    bodySummary.decode_mode = "setLxData_string_json";
                }
            }
            return bodySummary;
        }

        function installSetLxData(sig, tag) {
            try {
                var ov = EncryptUtils.setLxData.overload.apply(EncryptUtils.setLxData, sig);
                ov.impl = function(ctx) {
                    var bodySummary = summarizeSetLxDataArg(ctx.args[0]);
                    rememberRecentSetLxData(bodySummary, "EncryptUtils.setLxData");
                    emitEvidence({
                        event_type: "encryptutils_setLxData",
                        hook: "EncryptUtils.setLxData",
                        variant: tag,
                        json_body: bodySummary.text,
                        json_body_json: bodySummary.json,
                        json_body_class: bodySummary.class_name,
                        json_body_decode_mode: bodySummary.decode_mode,
                        ts: now()
                    });
                    return ctx.orig();
                };
                log("[+] EncryptUtils.setLxData hook installed: " + tag);
                return true;
            } catch (_) {
                return false;
            }
        }

        function emitMethodProbe() {
            try {
                var rows = [];
                var declared = EncryptUtils.class.getDeclaredMethods();
                for (var i = 0; i < declared.length; i++) {
                    try {
                        var row = String(declared[i].toString() || "");
                        if (row.indexOf("setLxData") !== -1) {
                            rows.push(row);
                        }
                    } catch (_) {}
                }
                emitEvidence({
                    event_type: "encryptutils_method_probe",
                    method_rows: rows,
                    ts: now()
                });
            } catch (_) {}
        }

        installedAny = installSetLxData(["org.json.JSONObject"], "JSONObject") || installedAny;
        installedAny = installSetLxData(["java.lang.String"], "String") || installedAny;
        if (!installedAny) {
            emitMethodProbe();
            log("[-] EncryptUtils.setLxData hook not installed");
        }
    } catch (e) {
        log("[-] hookEncryptSupportEntry failed: " + e);
    }
}

function hookBuilderArgSources() {
    var targets = [
        { class_name: "o92", method_name: "getRequestArgs" },
        { class_name: "ui0", method_name: "getRequestArgs" },
        { class_name: "mh", method_name: "a" },
        { class_name: "u63", method_name: "a" }
    ];

    function installOne(className, methodName) {
        try {
            var Cls = Java.use(className);
            var method = Cls[methodName];
            if (!method) {
                return false;
            }
            method.impl = function(ctx) {
                var traceId = null;
                var sourceUrl = null;
                if (className === "mh" && methodName === "a" && ctx.args.length > 0) {
                    sourceUrl = javaValueToText(ctx.args[0]);
                    traceId = getTraceIdFromUrl(sourceUrl);
                }

                var argSummary = [];
                for (var i = 0; i < ctx.args.length; i++) {
                    var s = summarizeJavaValue(ctx.args[i]);
                    var fieldSnapshot = null;
                    var methodSnapshot = null;
                    if (ENABLE_SW4_REFLECTION && s.class_name === "sw4" && builderReflectCount < 30) {
                        fieldSnapshot = reflectJavaObjectFields(ctx.args[i], 64);
                        methodSnapshot = reflectJavaObjectNoArgMethods(ctx.args[i], 24);
                        builderReflectCount += 1;
                    }
                    argSummary.push({
                        index: i,
                        text: s.text,
                        class_name: s.class_name,
                        class_chain: ENABLE_SW4_REFLECTION && s.class_name === "sw4" ? reflectJavaClassChain(ctx.args[i], 8) : null,
                        json: s.json,
                        decode_mode: s.decode_mode,
                        object_key: getStableObjectKey(ctx.args[i]),
                        fields: fieldSnapshot,
                        methods: methodSnapshot
                    });
                }
                var ret = ctx.orig();
                var retSummary = summarizeJavaValue(ret);
                var retObjectKey = getStableObjectKey(ret);
                var resultFields = null;
                var resultMethods = null;
                if (ENABLE_SW4_REFLECTION && retSummary.class_name === "sw4" && builderReflectCount < 30) {
                    resultFields = reflectJavaObjectFields(ret, 64);
                    resultMethods = reflectJavaObjectNoArgMethods(ret, 24);
                    builderReflectCount += 1;
                }

                if (className === "u63" && methodName === "a" && argSummary.length > 0) {
                    var sw4Key = argSummary[0].object_key;
                    if (sw4Key && traceBySw4Obj[sw4Key]) {
                        traceId = traceBySw4Obj[sw4Key];
                    }
                }

                if (retSummary.class_name === "sw4" && retObjectKey && traceId) {
                    traceBySw4Obj[retObjectKey] = traceId;
                }

                if (retSummary.class_name === "sw4" && retObjectKey && !traceId && traceBySw4Obj[retObjectKey]) {
                    traceId = traceBySw4Obj[retObjectKey];
                }

                if (traceId && retSummary.class_name === "com.zenmen.palmchat.utils.EncryptedJsonRequest") {
                    var reqPtr = getTrackedRequestKey(ret);
                    if (reqPtr) {
                        traceByRequestPtr[reqPtr] = traceId;
                    }
                }

                var builderFlowTag = sourceUrl ? getFlowTag(getUrlKind(sourceUrl), sourceUrl) : null;
                if (!builderFlowTag && className === "o92") {
                    builderFlowTag = "new_send_sms";
                }
                if (!builderFlowTag && traceId) {
                    var trackedByTrace = lookupTrackedByTraceId(traceId);
                    if (trackedByTrace) {
                        builderFlowTag = trackedByTrace.flow_tag || getFlowTag(trackedByTrace.url_kind, trackedByTrace.url);
                    }
                }
                var sw4State = retSummary.class_name === "sw4" ? summarizeSw4State(ret) : null;
                if (builderFlowTag === "new_send_sms") {
                    emitEvidence({
                        event_type: "java_builder_call",
                        hook: className + "." + methodName,
                        trace_id: safeTraceId(traceId),
                        flow_tag: builderFlowTag,
                        source_url: sourceUrl,
                        args: argSummary,
                        result_text: retSummary.text,
                        result_json: retSummary.json,
                        result_class: retSummary.class_name,
                        result_class_chain: ENABLE_SW4_REFLECTION && retSummary.class_name === "sw4" ? reflectJavaClassChain(ret, 8) : null,
                        result_decode_mode: retSummary.decode_mode,
                        result_object_key: retObjectKey,
                        result_fields: resultFields,
                        result_methods: resultMethods,
                        sw4_state: sw4State,
                        ts: now()
                    });
                } else if (MODE_REQRESP_PRIORITY) {
                    emitEvidence({
                        event_type: "sw4_bridge_compact",
                        hook: className + "." + methodName,
                        trace_id: safeTraceId(traceId),
                        flow_tag: builderFlowTag,
                        source_url: sourceUrl,
                        arg0_class: argSummary.length > 0 ? argSummary[0].class_name : null,
                        arg0_key: argSummary.length > 0 ? argSummary[0].object_key : null,
                        result_class: retSummary.class_name,
                        result_object_key: retObjectKey,
                        sw4_state: sw4State,
                        ts: now()
                    });
                } else {
                    emitEvidence({
                        event_type: builderFlowTag === "new_send_sms" ? "java_builder_compact" : "java_builder_call",
                        hook: className + "." + methodName,
                        trace_id: safeTraceId(traceId),
                        flow_tag: builderFlowTag,
                        source_url: sourceUrl,
                        arg_count: argSummary.length,
                        arg_classes: argSummary.map(function(x) { return x.class_name; }),
                        arg_object_keys: argSummary.map(function(x) { return x.object_key; }),
                        result_class: retSummary.class_name,
                        result_decode_mode: retSummary.decode_mode,
                        result_object_key: retObjectKey,
                        result_json_keys: retSummary.json && typeof retSummary.json === "object" && !Array.isArray(retSummary.json) ? Object.keys(retSummary.json) : null,
                        sw4_state: sw4State,
                        ts: now()
                    });
                }
                if (!MODE_REQRESP_PRIORITY && builderFlowTag !== "new_send_sms") {
                    emitEvidence({
                        event_type: "java_builder_call",
                        hook: className + "." + methodName,
                        trace_id: safeTraceId(traceId),
                        source_url: sourceUrl,
                        args: argSummary,
                        result_text: retSummary.text,
                        result_json: retSummary.json,
                        result_class: retSummary.class_name,
                        result_decode_mode: retSummary.decode_mode,
                        result_object_key: retObjectKey,
                        result_fields: resultFields,
                        result_methods: resultMethods,
                        ts: now()
                    });
                }
                return ret;
            };
            log("[+] " + className + "." + methodName + " direct hook installed");
            return true;
        } catch (_) {
            return false;
        }
    }

    for (var i = 0; i < targets.length; i++) {
        var t = targets[i];
        if (!installOne(t.class_name, t.method_name)) {
            log("[-] builder hook failed: " + t.class_name + "." + t.method_name);
        }
    }
}

function hookSw4Producer() {
    try {
        var Sw4 = Java.use("sw4");
        var dOv = Sw4.d.overload();
        dOv.impl = function(ctx) {
            var urlText = javaValueToText(readJavaInstanceField(ctx.thisObj, "f"));
            var urlKind = getUrlKind(urlText || "");
            var flowTag = getFlowTag(urlKind, urlText || "");
            var traceId = getTraceIdFromUrl(urlText || "");
            var keyType = null;
            var useNewKey = null;
            var methodNo = null;
            var encryptEnabled = null;
            try {
                keyType = toNumberSafe(readJavaInstanceField(ctx.thisObj, "c"));
            } catch (_) {}
            try {
                useNewKey = !!readJavaInstanceField(ctx.thisObj, "d");
            } catch (_) {}
            try {
                methodNo = toNumberSafe(readJavaInstanceField(ctx.thisObj, "j"));
            } catch (_) {}
            try {
                encryptEnabled = !!readJavaInstanceField(ctx.thisObj, "h");
            } catch (_) {}

            var sw4State = summarizeSw4State(ctx.thisObj);
            var fieldSnapshot = null;
            if (builderReflectCount < 30) {
                fieldSnapshot = reflectJavaObjectFields(ctx.thisObj, 24);
                builderReflectCount += 1;
            }

            var ret = ctx.orig();
            if (!urlKind) {
                return ret;
            }

            var bodySummary = summarizeJavaValue(ret);
            var bodyObjKey = getStableObjectKey(ret);
            var tracked = ensureTrackedRequestRow(urlText, urlKind, flowTag, traceId);
            updateTrackedRequestBodyFromSummary(tracked, bodySummary);
            rememberTrackedJsonBodyObject(bodyObjKey, tracked, traceId);
            rememberRecentSetLxData(bodySummary, "sw4.d");
            maybeEmitNewSmsPlaintextEvent(
                "sw4.d",
                "request_produce",
                traceId,
                tracked,
                null,
                null,
                tracked.request_headers || {}
            );

            emitEvidence({
                event_type: urlKind === "new_send_sms" ? "sw4_request_body" : "sw4_body_compact",
                hook: "sw4.d",
                flow_stage: "request_produce",
                flow_tag: flowTag,
                trace_id: safeTraceId(traceId),
                url_kind: urlKind,
                url: urlText,
                query: parseQueryFromUrl(urlText || ""),
                method: methodNo,
                encrypt_enabled: encryptEnabled,
                key_type: keyType,
                use_new_key: useNewKey,
                body_map_text: sw4State ? sw4State.body_map_text : null,
                body_map_json: sw4State ? sw4State.body_map_json : null,
                body_map_decode_mode: sw4State ? sw4State.body_map_decode_mode : null,
                header_map_text: sw4State ? sw4State.header_map_text : null,
                header_map_json: sw4State ? sw4State.header_map_json : null,
                header_map_decode_mode: sw4State ? sw4State.header_map_decode_mode : null,
                body_json_field_text: sw4State ? sw4State.body_json_field_text : null,
                body_json_field_json: sw4State ? sw4State.body_json_field_json : null,
                body_json_field_decode_mode: sw4State ? sw4State.body_json_field_decode_mode : null,
                sw4_fields: fieldSnapshot,
                json_body: bodySummary.text,
                json_body_json: bodySummary.json,
                json_body_class: bodySummary.class_name,
                json_body_decode_mode: bodySummary.decode_mode,
                json_body_object_key: bodyObjKey,
                ts: now()
            });
            return ret;
        };
        log("[+] sw4.d hook installed");
    } catch (e) {
        log("[-] sw4.d hook failed: " + e);
    }
}

function shouldTrackJsonObjectKey(objKey) {
    if (!objKey) {
        return false;
    }
    if (ENABLE_GLOBAL_JSON_PROBES) {
        return true;
    }
    if (trackedJsonObjects[objKey]) {
        return true;
    }
    if (traceByBodyObj[objKey]) {
        return true;
    }
    if (jsonObjectDrafts[objKey]) {
        return true;
    }
    return false;
}

function hookJsonStringify() {
    try {
        var JSONObject = Java.use("org.json.JSONObject");
        JSONObject.toString.impl = function(ctx) {
            var out = ctx.orig();
            try {
                var objKey = getStableObjectKey(ctx.thisObj);
                if (!shouldTrackJsonObjectKey(objKey)) {
                    return out;
                }
                var text = safeToString(out);
                var parsed = tryParseJsonText(text);
                if (objKey) {
                    var traceIdForObj = traceByBodyObj[objKey] || null;
                    jsonStringifiedBodies[objKey] = {
                        text: text,
                        parsed: parsed,
                        ts: now()
                    };
                    if (parsed !== null && jsonToStringSeenCount < 10) {
                        jsonToStringSeenCount += 1;
                        emitEvidence({
                            event_type: "json_toString_seen",
                            hook: "org.json.JSONObject.toString",
                            trace_id: safeTraceId(traceIdForObj),
                            object_key: objKey,
                            json_body: text,
                            json_body_json: parsed,
                            ts: now()
                        });
                    }
                }
                if (objKey && trackedJsonObjects[objKey]) {
                    var tracked = trackedJsonObjects[objKey];
                    if (tracked && tracked.request_key && trackedRequests[tracked.request_key]) {
                        trackedRequests[tracked.request_key].request_body_text = text;
                        trackedRequests[tracked.request_key].request_body_json = parsed;
                        trackedRequests[tracked.request_key].request_body_decode_mode = "json_toString_hook";
                    }
                    emitEvidence({
                        event_type: "json_body_resolved",
                        hook: "org.json.JSONObject.toString",
                        trace_id: safeTraceId(traceByBodyObj[objKey] || null),
                        flow_tag: tracked ? getFlowTag(tracked.url_kind, tracked.url) : null,
                        url_kind: tracked ? tracked.url_kind : null,
                        url: tracked ? tracked.url : null,
                        object_key: objKey,
                        json_body: text,
                        json_body_json: parsed,
                        json_body_decode_mode: "json_toString_hook",
                        ts: now()
                    });
                    delete trackedJsonObjects[objKey];
                }
            } catch (_) {}
            return out;
        };
        log("[+] org.json.JSONObject.toString direct hook installed");
    } catch (e) {
        log("[-] org.json.JSONObject.toString hook failed: " + e);
    }
}

function normalizeDraftValue(value) {
    if (value === null || value === undefined) {
        return null;
    }
    var t = typeof value;
    if (t === "string" || t === "number" || t === "boolean") {
        return value;
    }

    var text = javaValueToText(value);
    if (text === null || text === undefined) {
        return null;
    }
    if (text === "true") {
        return true;
    }
    if (text === "false") {
        return false;
    }
    var parsed = tryParseJsonText(text);
    if (parsed !== null) {
        return parsed;
    }
    var num = Number(text);
    if (!isNaN(num) && String(num) === String(text)) {
        return num;
    }
    return text;
}

function hookJsonObjectPut() {
    function installPutOverload(JSONObject, sig, valueIndex) {
        try {
            var ov = JSONObject.put.overload.apply(JSONObject.put, sig);
            ov.impl = function(ctx) {
                try {
                    var objKey = getStableObjectKey(ctx.thisObj);
                    if (objKey && shouldTrackJsonObjectKey(objKey)) {
                        var keyName = javaValueToText(ctx.args[0]);
                        if (keyName !== null) {
                            if (!jsonObjectDrafts[objKey]) {
                                jsonObjectDrafts[objKey] = {};
                            }
                            jsonObjectDrafts[objKey][String(keyName)] = normalizeDraftValue(ctx.args[valueIndex]);
                        }
                    }
                } catch (_) {}
                return ctx.orig();
            };
            log("[+] JSONObject.put hook installed: (" + sig.join(",") + ")");
            return true;
        } catch (_) {
            return false;
        }
    }

    try {
        var JSONObject = Java.use("org.json.JSONObject");
        var installed = false;
        try {
            JSONObject.put.impl = function(ctx) {
                try {
                    var objKey = getStableObjectKey(ctx.thisObj);
                    if (objKey && shouldTrackJsonObjectKey(objKey) && ctx.args && ctx.args.length >= 2) {
                        var keyName = javaValueToText(ctx.args[0]);
                        if (keyName !== null) {
                            if (!jsonObjectDrafts[objKey]) {
                                jsonObjectDrafts[objKey] = {};
                            }
                            jsonObjectDrafts[objKey][String(keyName)] = normalizeDraftValue(ctx.args[1]);
                        }
                    }
                } catch (_) {}
                return ctx.orig();
            };
            installed = true;
            log("[+] JSONObject.put direct hook installed");
        } catch (directErr) {
            log("[-] JSONObject.put direct hook failed: " + directErr);
        }

        installed = installPutOverload(JSONObject, ["java.lang.String", "java.lang.Object"], 1) || installed;
        installed = installPutOverload(JSONObject, ["java.lang.String", "boolean"], 1) || installed;
        installed = installPutOverload(JSONObject, ["java.lang.String", "int"], 1) || installed;
        installed = installPutOverload(JSONObject, ["java.lang.String", "long"], 1) || installed;
        installed = installPutOverload(JSONObject, ["java.lang.String", "double"], 1) || installed;

        if (!installed) {
            log("[-] JSONObject.put hooks not installed");
        }
    } catch (e) {
        log("[-] hookJsonObjectPut failed: " + e);
    }
}

function probeJSONObjectMethods() {
    try {
        var JSONObject = Java.use("org.json.JSONObject");
        var methodRows = [];
        try {
            var declared = JSONObject.class.getDeclaredMethods();
            for (var i = 0; i < declared.length; i++) {
                try {
                    var m = declared[i];
                    var name = String(m.getName());
                    if (
                        name === "put" ||
                        name === "toString" ||
                        name === "keys" ||
                        name === "opt" ||
                        name === "optString" ||
                        name === "get"
                    ) {
                        methodRows.push(String(m.toString()));
                    }
                } catch (_) {}
            }
        } catch (_) {}

        emitEvidence({
            event_type: "json_object_method_probe",
            put_type: typeof JSONObject.put,
            toString_type: typeof JSONObject.toString,
            keys_type: typeof JSONObject.keys,
            method_rows: methodRows,
            ts: now()
        });
    } catch (e) {
        log("[-] probeJSONObjectMethods failed: " + e);
    }
}

function hookEncryptedRequestCtor() {
    try {
        var EncryptedJsonRequest = Java.use("com.zenmen.palmchat.utils.EncryptedJsonRequest");

        function installCtorHook(overloadObj, tag, extraFieldsBuilder) {
            overloadObj.impl = function(ctx) {
                var method = Number(ctx.args[0]);
                var urlText = safeToString(ctx.args[1]);
                var urlKind = getUrlKind(urlText);
                if (urlKind === "new_send_sms") {
                    var flowTag = getFlowTag(urlKind, urlText);
                    var bodySummary = summarizeJavaValue(ctx.args[2]);
                    var key = getTrackedRequestKey(ctx.thisObj);
                    var bodyObjKey = getStableObjectKey(ctx.args[2]);
                    var traceId = getTraceIdFromUrl(urlText);
                    if (isEmptyPlainObject(bodySummary.json) && bodySummary.text === "{}") {
                        bodySummary.decode_mode = "ctor_empty_placeholder";
                    }
                    if (bodySummary.json === null && bodyObjKey && jsonStringifiedBodies[bodyObjKey]) {
                        var cachedBody = jsonStringifiedBodies[bodyObjKey];
                        if (cachedBody.parsed !== null) {
                            bodySummary.json = cachedBody.parsed;
                            bodySummary.decode_mode = "json_toString_cache";
                            bodySummary.text = cachedBody.text;
                        } else if (looksLikeWrapperString(bodySummary.text) && cachedBody.text) {
                            bodySummary.text = cachedBody.text;
                        }
                    }
                    if (bodySummary.json === null && bodyObjKey && jsonObjectDrafts[bodyObjKey]) {
                        bodySummary.json = jsonObjectDrafts[bodyObjKey];
                        bodySummary.decode_mode = "json_put_trace";
                        if (looksLikeWrapperString(bodySummary.text)) {
                            try {
                                bodySummary.text = JSON.stringify(bodySummary.json);
                            } catch (_) {}
                        }
                    }
                    if (!hasMeaningfulJson(bodySummary.json) || bodySummary.decode_mode === "ctor_empty_placeholder") {
                        var recentLxData = findRecentSetLxData(4000);
                        if (recentLxData) {
                            if (recentLxData.json && looksLikeNewSmsBodyJson(recentLxData.json)) {
                                bodySummary.json = recentLxData.json;
                            }
                            if (recentLxData.text && !looksLikeWrapperString(recentLxData.text)) {
                                bodySummary.text = recentLxData.text;
                            }
                            bodySummary.decode_mode = "setLxData_hook";
                        }
                    }
                    if (key) {
                        if (traceId) {
                            traceByRequestPtr[key] = traceId;
                            traceByUrl[urlText] = traceId;
                        }
                        trackedRequests[key] = {
                            url: urlText,
                            flow_tag: flowTag,
                            url_kind: urlKind,
                            query: parseQueryFromUrl(urlText),
                            request_body_text: bodySummary.text,
                            request_body_json: bodySummary.json,
                            request_body_decode_mode: bodySummary.decode_mode,
                            request_headers: {},
                            trace_id: safeTraceId(traceId)
                        };
                    }
                    if (traceId && bodyObjKey) {
                        traceByBodyObj[bodyObjKey] = traceId;
                    }
                    if (bodyObjKey && bodySummary.json === null) {
                        trackedJsonObjects[bodyObjKey] = {
                            request_key: key,
                            url: urlText,
                            url_kind: urlKind,
                            ts: now()
                        };
                    }
                    if (key && trackedRequests[key]) {
                        updateTrackedRequestBodyFromSummary(trackedRequests[key], bodySummary);
                        maybeEmitNewSmsPlaintextEvent(
                            "EncryptedJsonRequest.$init",
                            "request_produce",
                            traceId,
                            trackedRequests[key],
                            null,
                            null,
                            {}
                        );
                    }
                    var eventObj = {
                        event_type: "encrypted_request_ctor",
                        hook: "EncryptedJsonRequest.$init",
                        flow_stage: "request_produce",
                        flow_tag: flowTag,
                        trace_id: safeTraceId(traceId),
                        thread: getJavaThreadName(),
                        stack_top: getJavaStackTop(8),
                        ctor_variant: tag,
                        url_kind: urlKind,
                        method: method,
                        url: urlText,
                        query: parseQueryFromUrl(urlText),
                        json_body: bodySummary.text,
                        json_body_json: bodySummary.json,
                        json_body_class: bodySummary.class_name,
                        json_body_decode_mode: bodySummary.decode_mode,
                        json_body_object_key: bodyObjKey,
                        ts: now()
                    };
                    if (extraFieldsBuilder) {
                        extraFieldsBuilder(eventObj, ctx);
                    }
                    emitEvidence(eventObj);
                    log("[EncryptedJsonRequest/" + tag + "] " + method + " " + urlText);
                }
                return ctx.orig();
            };
        }

        var installedAny = false;
        try {
            var initV7 = EncryptedJsonRequest.$init.overload(
                "int",
                "java.lang.String",
                "org.json.JSONObject",
                "int",
                "boolean",
                "com.android.volley.Response$Listener",
                "com.android.volley.Response$ErrorListener"
            );
            installCtorHook(initV7, "v7", function(eventObj, ctx) {
                eventObj.i2 = Number(ctx.args[3]);
                eventObj.z = !!ctx.args[4];
            });
            installedAny = true;
            log("[+] EncryptedJsonRequest.$init v7 hook installed");
        } catch (eV7) {
            log("[-] EncryptedJsonRequest.$init v7 hook failed: " + eV7);
        }

        if (!installedAny) {
            log("[-] EncryptedJsonRequest.$init v7 overload not installed");
        }
    } catch (e) {
        log("[-] EncryptedJsonRequest hook failed: " + e);
    }
}

function hookEncryptedRequestHeaders() {
    try {
        var EncryptedJsonRequest = Java.use("com.zenmen.palmchat.utils.EncryptedJsonRequest");
        var addHeaderOv = EncryptedJsonRequest.addHeader.overload("java.lang.String", "java.lang.String");
        addHeaderOv.impl = function(ctx) {
            var key = getTrackedRequestKey(ctx.thisObj);
            var tracked = key ? trackedRequests[key] : null;
            if (tracked) {
                var traceId = tracked.trace_id || (key ? traceByRequestPtr[key] : null) || getTraceIdFromUrl(tracked.url);
                var headerName = javaValueToText(ctx.args[0]);
                var headerValue = javaValueToText(ctx.args[1]);
                if (!tracked.request_headers) {
                    tracked.request_headers = {};
                }
                if (headerName !== null) {
                    tracked.request_headers[String(headerName)] = headerValue;
                }
                emitEvidence({
                    event_type: "encrypted_request_header",
                    hook: "EncryptedJsonRequest.addHeader",
                    flow_stage: "request_finalize_headers",
                    flow_tag: tracked.flow_tag || getFlowTag(tracked.url_kind, tracked.url),
                    trace_id: safeTraceId(traceId),
                    thread: getJavaThreadName(),
                    stack_top: getJavaStackTop(8),
                    url_kind: tracked.url_kind,
                    url: tracked.url,
                    query: tracked.query || parseQueryFromUrl(tracked.url),
                    request_body: tracked.request_body_text || null,
                    request_body_json: tracked.request_body_json || null,
                    request_body_decode_mode: tracked.request_body_decode_mode || null,
                    request_headers: tracked.request_headers || {},
                    header_name: headerName,
                    header_value: headerValue,
                    ts: now()
                });
            }
            return ctx.orig();
        };
        log("[+] EncryptedJsonRequest.addHeader hook installed");
    } catch (e) {
        log("[-] EncryptedJsonRequest.addHeader hook failed: " + e);
    }
}

function hookEncryptedRequestBody() {
    try {
        var EncryptedJsonRequest = Java.use("com.zenmen.palmchat.utils.EncryptedJsonRequest");
        var getBodyOv = EncryptedJsonRequest.getBody.overload();
        getBodyOv.impl = function(ctx) {
            var ret = ctx.orig();
            var key = getTrackedRequestKey(ctx.thisObj);
            var tracked = key ? trackedRequests[key] : null;
            var traceId = tracked ? tracked.trace_id : (key && traceByRequestPtr[key] ? traceByRequestPtr[key] : null);
            if (!tracked && traceId) {
                tracked = lookupTrackedByTraceId(traceId);
            }
            var urlText = tracked ? tracked.url : null;
            if (!urlText) {
                try {
                    urlText = javaValueToText(ctx.thisObj.getUrl());
                } catch (_) {
                    urlText = null;
                }
            }
            if (!traceId && urlText) {
                traceId = getTraceIdFromUrl(urlText) || resolveTraceIdForUrl(urlText);
            }
            var actualUrlKind = getUrlKind(urlText || "");
            var urlKind = tracked && tracked.url_kind ? tracked.url_kind : actualUrlKind;
            if (actualUrlKind && urlKind !== actualUrlKind) {
                urlKind = actualUrlKind;
            }
            var flowTag = tracked && tracked.flow_tag ? tracked.flow_tag : getFlowTag(urlKind, urlText || "");
            if (actualUrlKind) {
                flowTag = getFlowTag(actualUrlKind, urlText || "");
            }

            var decoded = decodeJavaByteArray(ret);
            var digest = buildBinaryDigest(ret, decoded);
            var originRow = {
                source_event: "encrypted_request_get_body",
                source_hook: "EncryptedJsonRequest.getBody",
                flow_stage: "request_body_produce",
                flow_tag: flowTag,
                trace_id: safeTraceId(traceId),
                ts: now(),
                url: urlText,
                url_kind: urlKind,
                length: decoded ? decoded.length : null,
                is_binary: decoded ? decoded.is_binary : null,
                sha256: digest.sha256
            };
            rememberBinaryOrigin(digest, originRow);
            if (traceId && digest && digest.sha256) {
                if (!isUnknownDigest(digest.sha256)) {
                    binaryShaByTrace[String(traceId)] = digest.sha256;
                }
                if (tracked) {
                    tracked.request_body_sha256 = digest.sha256;
                }
            }
            if (isUnknownDigest(digest.sha256) && traceId && binaryShaByTrace[String(traceId)]) {
                digest.sha256 = binaryShaByTrace[String(traceId)];
            }
            var bodyOrigin = lookupBinaryOrigin(digest) || originRow;
            if (flowTag === "new_send_sms") {
                emitBinaryHexChunks(
                    "encrypted_request_body",
                    flowTag,
                    "request_body_produce",
                    traceId,
                    digest.sha256,
                    decoded ? decoded.hex_full : null,
                    {
                        hook: "EncryptedJsonRequest.getBody",
                        url: urlText,
                        url_kind: urlKind
                    }
                );
            }

            if (!isUnknownDigest(digest.sha256) && shouldEmitBinaryEvent("encrypted_request_get_body", traceId, digest.sha256, "request_body_produce")) {
                emitEvidence({
                    event_type: "encrypted_request_get_body",
                    hook: "EncryptedJsonRequest.getBody",
                    flow_stage: "request_body_produce",
                    flow_tag: flowTag,
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    query: parseQueryFromUrl(urlText || ""),
                    request_body_sha256: digest.sha256,
                    request_body_is_binary: resolveBodyIsBinary(decoded, bodyOrigin),
                    request_body_length: resolveBodyLength(decoded, bodyOrigin),
                    request_body_hex_inline: compactHexForEvent(decoded ? decoded.hex_full : null),
                    request_body_hex_total_len: decoded && decoded.hex_full ? decoded.hex_full.length : null,
                    request_body_hex_chunked: decoded && decoded.hex_full ? decoded.hex_full.length > HEX_INLINE_MAX : false,
                    request_body_hex_preview: decoded ? decoded.hex_preview : null,
                    request_body_base64_preview: decoded ? decoded.base64_preview : null,
                    ts: now()
                });
            }
            return ret;
        };
        log("[+] EncryptedJsonRequest.getBody hook installed");
    } catch (e) {
        log("[-] EncryptedJsonRequest.getBody hook failed: " + e);
    }
}

function hookNetworkResponse() {
    function installResponseHook(className, methodName) {
        try {
            var clazz = Java.use(className);
            var method = clazz[methodName];
            if (!method) {
                log("[-] " + className + "." + methodName + " not found");
                return false;
            }

            try {
                method.impl = function(ctx) {
                    var urlText = javaValueToText(ctx.args[0]);
                    var urlKind = getUrlKind(urlText);
                    if (urlKind) {
                        var tracked = lookupTrackedByUrl(urlText);
                        var traceId = resolveTraceIdForUrl(urlText) || (tracked ? tracked.trace_id : null);
                        var respSummary = summarizeJavaValue(ctx.args[2]);
                        emitEvidence({
                            event_type: "java_network_response",
                            hook: className + "." + methodName,
                            flow_stage: "response_consume",
                            variant: "direct",
                            flow_tag: getFlowTag(urlKind, urlText),
                            trace_id: safeTraceId(traceId),
                            url_kind: urlKind,
                            url: urlText,
                            query: parseQueryFromUrl(urlText),
                            code: Number(ctx.args[1]),
                            request_body: tracked ? tracked.request_body_text : null,
                            request_body_json: tracked ? tracked.request_body_json : null,
                            request_headers: tracked && tracked.request_headers ? tracked.request_headers : {},
                            response_text: respSummary.text,
                            response_json: respSummary.json,
                            response_class: respSummary.class_name,
                            response_decode_mode: respSummary.decode_mode,
                            ts: now()
                        });
                    }
                    return ctx.orig();
                };
                log("[+] " + className + "." + methodName + " direct hook installed");
                return true;
            } catch (directErr) {
                log("[-] " + className + "." + methodName + " direct hook failed: " + directErr);
            }

            try {
                var ov = method.overload("java.lang.String", "int", "java.lang.Object");
                ov.impl = function(ctx) {
                    var urlText = javaValueToText(ctx.args[0]);
                    var urlKind = getUrlKind(urlText);
                    if (urlKind) {
                        var tracked = lookupTrackedByUrl(urlText);
                        var traceId = resolveTraceIdForUrl(urlText) || (tracked ? tracked.trace_id : null);
                        var respSummary = summarizeJavaValue(ctx.args[2]);
                        emitEvidence({
                            event_type: "java_network_response",
                            hook: className + "." + methodName,
                            flow_stage: "response_consume",
                            variant: "v3",
                            flow_tag: getFlowTag(urlKind, urlText),
                            trace_id: safeTraceId(traceId),
                            url_kind: urlKind,
                            url: urlText,
                            query: parseQueryFromUrl(urlText),
                            code: Number(ctx.args[1]),
                            request_body: tracked ? tracked.request_body_text : null,
                            request_body_json: tracked ? tracked.request_body_json : null,
                            request_headers: tracked && tracked.request_headers ? tracked.request_headers : {},
                            response_text: respSummary.text,
                            response_json: respSummary.json,
                            response_class: respSummary.class_name,
                            response_decode_mode: respSummary.decode_mode,
                            ts: now()
                        });
                    }
                    return ctx.orig();
                };
                log("[+] " + className + "." + methodName + " v3 hook installed");
                return true;
            } catch (ovErr) {
                log("[-] " + className + "." + methodName + " v3 hook failed: " + ovErr);
            }
        } catch (e) {
            log("[-] response hook class failed (" + className + "): " + e);
        }
        return false;
    }

    var installedAny = false;
    if (installResponseHook("rg3", "d")) {
        installedAny = true;
    }
    if (installResponseHook("d54", "d")) {
        installedAny = true;
    }
    if (!installedAny) {
        log("[-] no response hook installed");
    }
}

function hookNetworkRequestFallback() {
    function installRequestHook(className, methodName) {
        try {
            var clazz = Java.use(className);
            var method = clazz[methodName];
            if (!method) {
                return false;
            }

            try {
                method.impl = function(ctx) {
                    var urlText = javaValueToText(ctx.args[0]);
                    var urlKind = getUrlKind(urlText);
                    if (urlKind) {
                        var flowTag = getFlowTag(urlKind, urlText);
                        var trackedSeed = lookupTrackedByUrl(urlText);
                        var traceId = resolveTraceIdForUrl(urlText) || (trackedSeed ? trackedSeed.trace_id : null);
                        var bodySummary = summarizeJavaValue(ctx.args[2]);
                        var bodyObjKey = getStableObjectKey(ctx.args[2]);
                        var tracked = ensureTrackedRequestRow(urlText, urlKind, flowTag, traceId);
                        updateTrackedRequestBodyFromSummary(tracked, bodySummary);
                        rememberTrackedJsonBodyObject(bodyObjKey, tracked, traceId);
                        maybeEmitNewSmsPlaintextEvent(
                            className + "." + methodName,
                            "request_send",
                            traceId,
                            tracked,
                            null,
                            null,
                            tracked.request_headers || {}
                        );
                        emitEvidence({
                            event_type: "java_network_pre_encrypt",
                            hook: className + "." + methodName,
                            flow_stage: "request_send",
                            variant: "direct",
                            flow_tag: flowTag,
                            trace_id: safeTraceId(traceId),
                            url_kind: urlKind,
                            url: urlText,
                            query: parseQueryFromUrl(urlText),
                            method: Number(ctx.args[1]),
                            request_headers: tracked && tracked.request_headers ? tracked.request_headers : {},
                            json_body: bodySummary.text,
                            json_body_json: bodySummary.json,
                            json_body_class: bodySummary.class_name,
                            json_body_decode_mode: bodySummary.decode_mode,
                            ts: now()
                        });
                    }
                    return ctx.orig();
                };
                log("[+] " + className + "." + methodName + " direct hook installed");
                return true;
            } catch (_) {}
        } catch (_) {}
        return false;
    }

    installRequestHook("d54", "c");
}

function hookVolleyTransport() {
    if (ENABLE_REQUESTQUEUE_HOOK) {
        try {
            var RequestQueue = Java.use("com.android.volley.RequestQueue");
            try {
                var addOv = RequestQueue.add.overload("com.android.volley.Request");
                addOv.impl = function(ctx) {
                var reqObj = ctx.args[0];
                var urlText = null;
                var urlKind = null;
                var flowTag = null;
                var methodNo = null;
                var reqHeaders = {};
                var bodyBytesObj = null;
                var bodyDecoded = null;
                var bodyDigest = null;
                var bodyOrigin = null;
                try {
                    urlText = javaValueToText(reqObj.getUrl());
                } catch (_) {
                    urlText = null;
                }
                urlKind = getUrlKind(urlText || "");
                flowTag = getFlowTag(urlKind, urlText || "");
                try {
                    methodNo = Number(reqObj.getMethod());
                } catch (_) {
                    methodNo = null;
                }
                reqHeaders = extractRequestHeadersDeep(reqObj);
                try {
                    bodyBytesObj = reqObj.getBody();
                    bodyDecoded = decodeJavaByteArray(bodyBytesObj);
                    bodyDigest = buildBinaryDigest(bodyBytesObj, bodyDecoded);
                    bodyOrigin = lookupBinaryOrigin(bodyDigest);
                    if (flowTag === "new_send_sms") {
                        emitBinaryHexChunks(
                            "volley_request_body",
                            flowTag,
                            "request_enqueue",
                            traceId,
                            bodyDigest ? bodyDigest.sha256 : null,
                            bodyDecoded ? bodyDecoded.hex_full : null,
                            {
                                hook: "RequestQueue.add",
                                url: urlText,
                                url_kind: urlKind
                            }
                        );
                    }
                } catch (_) {}

                var traceId = resolveTraceIdForUrl(urlText);
                var tracked = lookupTrackedByUrl(urlText);
                if (!traceId && tracked && tracked.trace_id) {
                    traceId = tracked.trace_id;
                }
                if (!tracked && traceId) {
                    tracked = lookupTrackedByTraceId(traceId);
                }
                if (!tracked && urlKind === "new_send_sms") {
                    tracked = ensureTrackedRequestRow(urlText, urlKind, flowTag, traceId);
                    tracked.request_body_sha256 = bodyDigest ? bodyDigest.sha256 : null;
                }
                if (tracked) {
                    tracked.flow_tag = tracked.flow_tag || flowTag;
                    tracked.request_headers = mergeHeaderMaps(reqHeaders, tracked.request_headers || {});
                    reqHeaders = tracked.request_headers;
                    if (bodyDigest && bodyDigest.sha256) {
                        if (isUnknownDigest(bodyDigest.sha256)) {
                            if (tracked.request_body_sha256) {
                                bodyDigest.sha256 = tracked.request_body_sha256;
                            } else if (traceId && binaryShaByTrace[String(traceId)]) {
                                bodyDigest.sha256 = binaryShaByTrace[String(traceId)];
                            }
                            bodyOrigin = lookupBinaryOrigin(bodyDigest) || bodyOrigin;
                        } else if (isFallbackDigest(bodyDigest.sha256)) {
                            if (tracked.request_body_sha256 && !isFallbackDigest(tracked.request_body_sha256)) {
                                bodyDigest.sha256 = tracked.request_body_sha256;
                            } else if (traceId && binaryShaByTrace[String(traceId)] && !isFallbackDigest(binaryShaByTrace[String(traceId)])) {
                                bodyDigest.sha256 = binaryShaByTrace[String(traceId)];
                            }
                            bodyOrigin = lookupBinaryOrigin(bodyDigest) || bodyOrigin;
                        }
                        tracked.request_body_sha256 = bodyDigest.sha256;
                        if (bodyDigest.sha256 && !isUnknownDigest(bodyDigest.sha256)) {
                            binaryShaByTrace[String(traceId || tracked.trace_id || "")] = bodyDigest.sha256;
                        }
                    } else if (tracked.request_body_sha256) {
                        bodyDigest = {
                            sha256: tracked.request_body_sha256,
                            length: bodyDecoded ? bodyDecoded.length : null,
                            hex_preview: bodyDecoded ? bodyDecoded.hex_preview : null
                        };
                    } else if (traceId && binaryShaByTrace[String(traceId)]) {
                        bodyDigest = {
                            sha256: binaryShaByTrace[String(traceId)],
                            length: bodyDecoded ? bodyDecoded.length : null,
                            hex_preview: bodyDecoded ? bodyDecoded.hex_preview : null
                        };
                        bodyOrigin = lookupBinaryOrigin(bodyDigest) || bodyOrigin;
                    }
                    if (
                        urlKind === "new_send_sms" &&
                        (!hasMeaningfulJson(tracked.request_body_json) || tracked.request_body_decode_mode === "ctor_empty_placeholder")
                    ) {
                        var reqJsonSnapshot = extractRequestJsonSnapshot(reqObj);
                        if (hasMeaningfulJson(reqJsonSnapshot.json)) {
                            tracked.request_body_json = reqJsonSnapshot.json;
                            tracked.request_body_decode_mode = reqJsonSnapshot.decode_mode;
                            if (reqJsonSnapshot.text) {
                                tracked.request_body_text = reqJsonSnapshot.text;
                            }
                        }
                    }
                    maybeEmitNewSmsPlaintextEvent(
                        "RequestQueue.add",
                        "request_enqueue",
                        traceId,
                        tracked,
                        bodyDigest,
                        bodyOrigin,
                        reqHeaders
                    );
                }

                emitEvidence({
                    event_type: flowTag === "new_send_sms" ? "new_sms_request_compact" : "request_compact",
                    flow_stage: "request_enqueue",
                    hook: "RequestQueue.add",
                    flow_tag: flowTag,
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    request_body_sha256: bodyDigest ? bodyDigest.sha256 : (traceId ? binaryShaByTrace[String(traceId)] || null : null),
                    request_body_origin: bodyOrigin ? bodyOrigin.source_event : null,
                    request_body_origin_stage: bodyOrigin ? bodyOrigin.flow_stage : null,
                    request_body_length: resolveBodyLength(bodyDecoded, bodyOrigin),
                    request_body_is_binary: resolveBodyIsBinary(bodyDecoded, bodyOrigin),
                    request_body_decode_mode: tracked ? tracked.request_body_decode_mode : null,
                    ts: now()
                });

                if (flowTag !== "new_send_sms") {
                    emitEvidence({
                        event_type: "volley_request_enqueue",
                        flow_stage: "request_enqueue",
                        hook: "RequestQueue.add",
                        flow_tag: flowTag,
                        trace_id: safeTraceId(traceId),
                        url_kind: urlKind,
                        url: urlText,
                        query: parseQueryFromUrl(urlText || ""),
                        method: methodNo,
                        request_headers: reqHeaders,
                        request_body: tracked ? tracked.request_body_text : null,
                        request_body_json: tracked ? tracked.request_body_json : null,
                        request_body_decode_mode: tracked ? tracked.request_body_decode_mode : null,
                        request_body_sha256: bodyDigest ? bodyDigest.sha256 : (traceId ? binaryShaByTrace[String(traceId)] || null : null),
                        request_body_origin: bodyOrigin ? bodyOrigin.source_event : null,
                        request_body_origin_stage: bodyOrigin ? bodyOrigin.flow_stage : null,
                        request_body_origin_ts: bodyOrigin ? bodyOrigin.ts : null,
                        request_body_is_binary: resolveBodyIsBinary(bodyDecoded, bodyOrigin),
                        request_body_utf8: bodyDecoded ? bodyDecoded.utf8 : null,
                        request_body_base64: bodyDecoded ? bodyDecoded.base64 : null,
                        request_body_base64_preview: bodyDecoded ? bodyDecoded.base64_preview : null,
                        request_body_hex_inline: compactHexForEvent(bodyDecoded ? bodyDecoded.hex_full : null),
                        request_body_hex_total_len: bodyDecoded && bodyDecoded.hex_full ? bodyDecoded.hex_full.length : null,
                        request_body_hex_chunked: bodyDecoded && bodyDecoded.hex_full ? bodyDecoded.hex_full.length > HEX_INLINE_MAX : false,
                        request_body_length: resolveBodyLength(bodyDecoded, bodyOrigin),
                        request_body_hex_preview: bodyDecoded ? bodyDecoded.hex_preview : null,
                        request_body_ascii_preview: bodyDecoded ? bodyDecoded.ascii_preview : null,
                        ts: now()
                    });
                }
                    return ctx.orig();
                };
                log("[+] RequestQueue.add hook installed");
            } catch (eAdd) {
                log("[-] RequestQueue.add hook failed: " + eAdd);
            }
        } catch (eRQ) {
            log("[-] hookVolleyTransport(RequestQueue) failed: " + eRQ);
        }
    }

    if (ENABLE_BASICNETWORK_HOOK) {
        try {
            var BasicNetwork = Java.use("com.android.volley.toolbox.BasicNetwork");
            try {
                var perfOv = BasicNetwork.performRequest.overload("com.android.volley.Request");
                perfOv.impl = function(ctx) {
                var reqObj = ctx.args[0];
                var urlText = null;
                var urlKind = null;
                var flowTag = null;
                var reqBodyBytesObj = null;
                var reqBodyDecoded = null;
                var reqBodyDigest = null;
                var reqBodyOrigin = null;
                try {
                    urlText = javaValueToText(reqObj.getUrl());
                } catch (_) {
                    urlText = null;
                }
                urlKind = getUrlKind(urlText || "");
                flowTag = getFlowTag(urlKind, urlText || "");
                var traceId = resolveTraceIdForUrl(urlText);
                var tracked = lookupTrackedByUrl(urlText);
                if (!traceId && tracked && tracked.trace_id) {
                    traceId = tracked.trace_id;
                }
                if (!tracked && traceId) {
                    tracked = lookupTrackedByTraceId(traceId);
                }
                try {
                    reqBodyBytesObj = reqObj.getBody();
                    reqBodyDecoded = decodeJavaByteArray(reqBodyBytesObj);
                    reqBodyDigest = buildBinaryDigest(reqBodyBytesObj, reqBodyDecoded);
                    reqBodyOrigin = lookupBinaryOrigin(reqBodyDigest);
                } catch (_) {}

                var ret = ctx.orig();
                var statusCode = null;
                var responseHeaders = {};
                var responseBody = null;
                var responseJson = null;
                var responseDigest = null;
                var reqHeaders = extractRequestHeadersDeep(reqObj);
                if (tracked) {
                    tracked.flow_tag = tracked.flow_tag || flowTag;
                    tracked.request_headers = mergeHeaderMaps(reqHeaders, tracked.request_headers || {});
                    reqHeaders = tracked.request_headers;
                    if (reqBodyDigest && reqBodyDigest.sha256) {
                        if (isUnknownDigest(reqBodyDigest.sha256)) {
                            if (tracked.request_body_sha256) {
                                reqBodyDigest.sha256 = tracked.request_body_sha256;
                            } else if (traceId && binaryShaByTrace[String(traceId)]) {
                                reqBodyDigest.sha256 = binaryShaByTrace[String(traceId)];
                            }
                            reqBodyOrigin = lookupBinaryOrigin(reqBodyDigest) || reqBodyOrigin;
                        } else if (isFallbackDigest(reqBodyDigest.sha256)) {
                            if (tracked.request_body_sha256 && !isFallbackDigest(tracked.request_body_sha256)) {
                                reqBodyDigest.sha256 = tracked.request_body_sha256;
                            } else if (traceId && binaryShaByTrace[String(traceId)] && !isFallbackDigest(binaryShaByTrace[String(traceId)])) {
                                reqBodyDigest.sha256 = binaryShaByTrace[String(traceId)];
                            }
                            reqBodyOrigin = lookupBinaryOrigin(reqBodyDigest) || reqBodyOrigin;
                        }
                        tracked.request_body_sha256 = reqBodyDigest.sha256;
                        if (reqBodyDigest.sha256 && !isUnknownDigest(reqBodyDigest.sha256)) {
                            binaryShaByTrace[String(traceId || tracked.trace_id || "")] = reqBodyDigest.sha256;
                        }
                    } else if (tracked.request_body_sha256) {
                        reqBodyDigest = {
                            sha256: tracked.request_body_sha256,
                            length: reqBodyDecoded ? reqBodyDecoded.length : null,
                            hex_preview: reqBodyDecoded ? reqBodyDecoded.hex_preview : null
                        };
                        reqBodyOrigin = lookupBinaryOrigin(reqBodyDigest) || reqBodyOrigin;
                    } else if (traceId && binaryShaByTrace[String(traceId)]) {
                        reqBodyDigest = {
                            sha256: binaryShaByTrace[String(traceId)],
                            length: reqBodyDecoded ? reqBodyDecoded.length : null,
                            hex_preview: reqBodyDecoded ? reqBodyDecoded.hex_preview : null
                        };
                        reqBodyOrigin = lookupBinaryOrigin(reqBodyDigest) || reqBodyOrigin;
                    }
                    if (
                        urlKind === "new_send_sms" &&
                        (!hasMeaningfulJson(tracked.request_body_json) || tracked.request_body_decode_mode === "ctor_empty_placeholder")
                    ) {
                        var reqJson = extractRequestJsonSnapshot(reqObj);
                        if (hasMeaningfulJson(reqJson.json)) {
                            tracked.request_body_json = reqJson.json;
                            tracked.request_body_decode_mode = reqJson.decode_mode;
                            if (reqJson.text) {
                                tracked.request_body_text = reqJson.text;
                            }
                        }
                    }
                    maybeEmitNewSmsPlaintextEvent(
                        "BasicNetwork.performRequest",
                        "request_transport",
                        traceId,
                        tracked,
                        reqBodyDigest,
                        reqBodyOrigin,
                        reqHeaders
                    );
                }
                try {
                    var statusObj = readJavaInstanceField(ret, "statusCode");
                    if (statusObj !== null && statusObj !== undefined) {
                        statusCode = Number(safeToString(statusObj));
                        if (isNaN(statusCode)) {
                            statusCode = safeToString(statusObj);
                        }
                    }
                } catch (_) {}
                responseHeaders = extractResponseHeadersDeep(ret);
                try {
                    var respBytes = readJavaInstanceField(ret, "data");
                    responseBody = decodeJavaByteArray(respBytes);
                    responseDigest = buildBinaryDigest(respBytes, responseBody);
                    if (flowTag === "new_send_sms") {
                        emitBinaryHexChunks(
                            "volley_response_body",
                            flowTag,
                            "response_consume",
                            traceId,
                            responseDigest ? responseDigest.sha256 : null,
                            responseBody ? responseBody.hex_full : null,
                            {
                                hook: "BasicNetwork.performRequest",
                                url: urlText,
                                url_kind: urlKind
                            }
                        );
                    }
                } catch (_) {}
                if (responseBody && responseBody.utf8) {
                    responseJson = tryParseJsonText(responseBody.utf8);
                }

                var responseResultCode = null;
                var responseErrorMsg = null;
                if (responseJson && typeof responseJson === "object") {
                    if (responseJson.resultCode !== undefined && responseJson.resultCode !== null) {
                        responseResultCode = Number(responseJson.resultCode);
                        if (isNaN(responseResultCode)) {
                            responseResultCode = responseJson.resultCode;
                        }
                    }
                    if (responseJson.errorMsg !== undefined && responseJson.errorMsg !== null) {
                        responseErrorMsg = String(responseJson.errorMsg);
                    }
                }
                emitEvidence({
                    event_type: flowTag === "new_send_sms" ? "new_sms_response_compact" : "response_compact",
                    flow_stage: "response_consume",
                    hook: "BasicNetwork.performRequest",
                    flow_tag: flowTag,
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    status_code: statusCode,
                    request_body_sha256: reqBodyDigest ? reqBodyDigest.sha256 : (tracked ? tracked.request_body_sha256 : (traceId ? binaryShaByTrace[String(traceId)] || null : null)),
                    request_body_origin: reqBodyOrigin ? reqBodyOrigin.source_event : null,
                    response_body_sha256: responseDigest ? responseDigest.sha256 : null,
                    response_result_code: responseResultCode,
                    response_error_msg: responseErrorMsg,
                    ts: now()
                });

                emitEvidence({
                    event_type: flowTag === "new_send_sms" ? "new_sms_response_full" : "volley_network_response",
                    flow_stage: "response_consume",
                    hook: "BasicNetwork.performRequest",
                    flow_tag: flowTag,
                    trace_id: safeTraceId(traceId),
                    url_kind: urlKind,
                    url: urlText,
                    query: parseQueryFromUrl(urlText || ""),
                    status_code: statusCode,
                    request_body: tracked ? tracked.request_body_text : null,
                    request_body_json: tracked ? tracked.request_body_json : null,
                    request_body_decode_mode: tracked ? tracked.request_body_decode_mode : null,
                    request_body_sha256: reqBodyDigest ? reqBodyDigest.sha256 : (tracked ? tracked.request_body_sha256 : (traceId ? binaryShaByTrace[String(traceId)] || null : null)),
                    request_body_origin: reqBodyOrigin ? reqBodyOrigin.source_event : null,
                    request_body_origin_stage: reqBodyOrigin ? reqBodyOrigin.flow_stage : null,
                    request_body_origin_ts: reqBodyOrigin ? reqBodyOrigin.ts : null,
                    request_headers: reqHeaders || {},
                    response_headers: responseHeaders,
                    response_body_sha256: responseDigest ? responseDigest.sha256 : null,
                    response_body_is_binary: responseBody ? responseBody.is_binary : null,
                    response_body_utf8: responseBody ? responseBody.utf8 : null,
                    response_body_json: responseJson,
                    response_body_base64: responseBody ? responseBody.base64 : null,
                    response_body_base64_preview: responseBody ? responseBody.base64_preview : null,
                    response_body_hex_inline: compactHexForEvent(responseBody ? responseBody.hex_full : null),
                    response_body_hex_total_len: responseBody && responseBody.hex_full ? responseBody.hex_full.length : null,
                    response_body_hex_chunked: responseBody && responseBody.hex_full ? responseBody.hex_full.length > HEX_INLINE_MAX : false,
                    response_body_length: responseBody ? responseBody.length : null,
                    response_body_hex_preview: responseBody ? responseBody.hex_preview : null,
                    response_body_ascii_preview: responseBody ? responseBody.ascii_preview : null,
                    ts: now()
                });
                    return ret;
                };
                log("[+] BasicNetwork.performRequest hook installed");
            } catch (ePerf) {
                log("[-] BasicNetwork.performRequest hook failed: " + ePerf);
            }
        } catch (eBN) {
            log("[-] hookVolleyTransport(BasicNetwork) failed: " + eBN);
        }
    }
}

function installJavaHooks() {
    if (javaHooksInstalled) {
        return;
    }
    try {
        Java.setStealth(JAVA_STEALTH_MODE);
    } catch (eStealth) {
        try {
            Java.setStealth(false);
        } catch (_) {}
        log("[-] Java.setStealth preferred mode failed: " + eStealth);
    }
    if (ENABLE_GLOBAL_JSON_PROBES) {
        probeJSONObjectMethods();
    }
    if (ENABLE_GLOBAL_JSON_PROBES || ENABLE_TRACKED_JSON_PROBES) {
        hookJsonObjectPut();
        hookJsonStringify();
    }
    if (ENABLE_UPSTREAM_BUILDER_HOOKS) {
        hookSw4Producer();
        hookBuilderArgSources();
    }
    if (ENABLE_ENCRYPT_HOOK) {
        hookEncryptSupportEntry();
        hookEncryptEntry();
    }
    if (ENABLE_CTOR_HOOK) {
        hookEncryptedRequestCtor();
    }
    if (ENABLE_HEADER_HOOK) {
        hookEncryptedRequestHeaders();
    }
    if (ENABLE_BODY_PRODUCE_HOOK) {
        hookEncryptedRequestBody();
    }
    if (ENABLE_NETWORK_HELPER_HOOKS) {
        hookNetworkRequestFallback();
        hookNetworkResponse();
        hookVolleyTransport();
    }
    javaHooksInstalled = true;
    log("[*] Java hooks active");
}

log("[*] start rustFrida Palmchat new SMS capture");
log("[*] thread_ret_patch=" + ENABLE_THREAD_RET_PATCH + " pthread_hook_mode=" + PTHREAD_HOOK_MODE + " java_stealth=" + JAVA_STEALTH_MODE);
log("[*] passive_mode java_ctor=" + ENABLE_CTOR_HOOK + " reg_natives=" + ENABLE_REGISTER_NATIVES_HOOK + " native_buffer=" + ENABLE_ENCRYPT_NATIVE_BUFFER_HOOK + " dlopen_trace=" + ENABLE_DLOPEN_TRACE + " recovery_retry=" + ENABLE_PASSIVE_RECOVERY_RETRY);

dummyThreadRoutine = findDummyThreadRoutine();
hookPthreadCreate();
hookRegisterNatives();
hookFindClassRecovery();
startPassiveRecoveryLoop("startup");
if (ENABLE_DLOPEN_TRACE) {
    hookDlopenLike("__loader_dlopen");
    hookDlopenLike("android_dlopen_ext");
    hookDlopenLike("dlopen");
    hookDlopenCandidates();
}

var loadedBase = Module.findBaseAddress(TARGET_SO_NAME);
if (loadedBase && !isNullPtr(loadedBase)) {
    log("[*] " + TARGET_SO_NAME + " already loaded @ " + loadedBase);
}

if (ENABLE_JAVA_OBSERVE) {
    Java.ready(function() {
        try {
            startPassiveRecoveryLoop("java_ready", true);
            installJavaHooks();
        } catch (e) {
            log("[-] Java.ready install error: " + e);
        }
    });
} else {
    Java.ready(function() {
        try {
            startPassiveRecoveryLoop("java_ready", true);
        } catch (e) {
            log("[-] Java.ready passive recovery error: " + e);
        }
    });
    log("[*] Java observe disabled; native-only passive mode");
}
