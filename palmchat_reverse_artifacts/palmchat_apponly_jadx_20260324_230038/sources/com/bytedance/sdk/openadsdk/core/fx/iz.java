package com.bytedance.sdk.openadsdk.core.fx;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.mv;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static volatile iz u;

    private Pair<Integer, JSONObject> iz(String str) {
        return b(str);
    }

    public static iz u() {
        if (u == null) {
            synchronized (iz.class) {
                if (u == null) {
                    u = new iz();
                }
            }
        }
        return u;
    }

    public Pair<Integer, JSONObject> b(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.u.u(str));
    }

    public Pair<Integer, ?> fx(String str) {
        try {
            if (!TextUtils.isEmpty(str) && dw.nr().fn()) {
                return u(str, "get_ad");
            }
        } catch (Throwable th) {
            k.u(th.getMessage());
        }
        return b(str);
    }

    public com.bytedance.sdk.openadsdk.core.wq.nr nr(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.wq.nr nrVar = new com.bytedance.sdk.openadsdk.core.wq.nr();
        HashMap map = new HashMap();
        try {
            nrVar.u(str.length());
            Pair<Integer, JSONObject> pairU = u().u(str, false);
            if (pairU != null) {
                JSONObject jSONObject2 = (JSONObject) pairU.second;
                try {
                    Object obj = pairU.first;
                    iIntValue = obj != null ? ((Integer) obj).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                iIntValue = 3;
            }
            jSONObject.put("ad_sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", d.b);
                map.put("x-plugin-version", "7.2.3.2");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable unused2) {
        }
        nrVar.u(map);
        nrVar.nr(jSONObject);
        return nrVar;
    }

    public JSONObject pn(String str) {
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        if (TextUtils.isEmpty(str) || uVarNr == null || !uVarNr.getArmorLoadStatus()) {
            return null;
        }
        try {
            byte[] bArrEncrypt = uVarNr.encrypt(str.getBytes(StandardCharsets.UTF_8));
            if (bArrEncrypt == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrEncrypt, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public com.bytedance.sdk.openadsdk.core.wq.nr u(String str) {
        Object obj;
        com.bytedance.sdk.openadsdk.core.wq.nr nrVar = new com.bytedance.sdk.openadsdk.core.wq.nr();
        HashMap map = new HashMap();
        try {
            nrVar.u(str.length());
            Pair<Integer, ?> pairFx = u().fx(str);
            int iIntValue = 3;
            if (pairFx != null) {
                obj = pairFx.second;
                Object obj2 = pairFx.first;
                if (obj2 != null) {
                    iIntValue = ((Integer) obj2).intValue();
                }
            } else {
                obj = null;
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", d.b);
                map.put("x-plugin-version", "7.2.3.2");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put("Content-Type", "application/octet-stream");
                nrVar.u((byte[]) obj);
                nrVar.u(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", d.b);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
                nrVar.nr(jSONObject);
                nrVar.u(map);
            }
        } catch (Throwable unused) {
        }
        return nrVar;
    }

    private Pair<Integer, JSONObject> nr(String str, boolean z) {
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        JSONObject jSONObjectPn = (TextUtils.isEmpty(str) || uVarNr == null || !uVarNr.getArmorLoadStatus()) ? null : pn(str);
        if (jSONObjectPn != null && !TextUtils.isEmpty(jSONObjectPn.optString("message"))) {
            return new Pair<>(4, jSONObjectPn);
        }
        if (uVarNr != null && uVarNr.getArmorLoadStatus() && z) {
            s.u().u(3, -1L, (String) null);
        }
        return iz(str);
    }

    private static String nr(byte[] bArr, String str) {
        com.bytedance.sdk.component.b.u uVarNr;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (uVarNr = kj.nr()) == null) {
                    return null;
                }
                byte[] bArrDecrypt = uVarNr.decrypt(bArr);
                String strNr = mv.nr(bArrDecrypt);
                if (!TextUtils.isEmpty(strNr)) {
                    return strNr;
                }
                s.u().u((bArrDecrypt == null || bArrDecrypt.length == 0) ? 1 : 2, -1L, str);
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> u(String str, boolean z) {
        try {
            if (dw.nr().fn()) {
                return nr(str, z);
            }
        } catch (Throwable th) {
            k.u(th.getMessage());
        }
        return b(str);
    }

    public Pair<Integer, ?> u(String str, String str2) {
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        if (TextUtils.isEmpty(str)) {
            return iz(str);
        }
        byte[] bArrEncrypt = (uVarNr == null || !uVarNr.getArmorLoadStatus()) ? null : uVarNr.encrypt(mv.u(str.getBytes(StandardCharsets.UTF_8)));
        if (bArrEncrypt != null && bArrEncrypt.length != 0) {
            return new Pair<>(4, bArrEncrypt);
        }
        if (uVarNr != null && uVarNr.getArmorLoadStatus()) {
            s.u().u(3, -1L, str2);
        }
        return iz(str);
    }

    public static Pair<Boolean, JSONObject> u(com.bytedance.sdk.component.a.nr nrVar, String str, boolean z) {
        if (com.bytedance.sdk.component.a.b.u.u(nrVar.b())) {
            return new Pair<>(Boolean.FALSE, u(nrVar.t(), str));
        }
        String strPn = nrVar.pn();
        if (strPn != null && !strPn.startsWith("{") && !strPn.endsWith("}") && !strPn.contains("message") && !strPn.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, u(nrVar.t(), str));
        }
        JSONObject jSONObject = null;
        if (strPn != null) {
            try {
                jSONObject = new JSONObject(strPn);
            } catch (JSONException unused) {
            }
        }
        return new Pair<>(Boolean.TRUE, u(jSONObject, true, z));
    }

    public static JSONObject u(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strU = u(jSONObject, z);
            String strOptString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(strU)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strU);
            if (z2) {
                try {
                    jSONObject2.put("auction_price", strOptString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String u(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            com.bytedance.sdk.component.b.u uVarNr = kj.nr();
            if (iOptInt == 3) {
                return com.bytedance.sdk.component.utils.u.fx(strOptString);
            }
            if (iOptInt != 4 || uVarNr == null) {
                return strOptString;
            }
            String strDecryptWithCBC = uVarNr.decryptWithCBC(strOptString);
            if (!TextUtils.isEmpty(strDecryptWithCBC) || !z) {
                return strDecryptWithCBC;
            }
            s.u().u(1, -1L, (String) null);
            return strDecryptWithCBC;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(byte[] bArr, String str) {
        try {
            String strNr = nr(bArr, str);
            if (TextUtils.isEmpty(strNr)) {
                return null;
            }
            return new JSONObject(strNr);
        } catch (Exception unused) {
            return null;
        }
    }
}
