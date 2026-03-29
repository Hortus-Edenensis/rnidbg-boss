package com.zenmen.palmchat.utils.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.igexin.push.core.b;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import defpackage.ac1;
import defpackage.iu1;
import defpackage.sk5;
import defpackage.v4;
import defpackage.vs0;
import defpackage.zs1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LogUtil {
    private static boolean DDBG = false;
    private static boolean EDBG = false;
    private static boolean IDBG = false;
    public static final boolean IS_WTF = false;
    public static final String KEY_ACTION = "action";
    public static final String KEY_COMPONENT = "comp";
    public static final String KEY_DETAIL = "detail";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ERROR = "error";
    public static final String KEY_IP_ADDRESS = "ip_address";
    public static final String KEY_STATUS = "status";
    public static final int LOG_FLAG_FILE = 1;
    public static final int LOG_FLAG_NORMAL = 0;
    public static final int LOG_FLAG_STATS = 2;
    public static final String NETWORK_LOG = "net_log";
    public static final String VALUE_ACTION_PARSE_ENCRYPT_RESPONSE = "parse_encrypt_response";
    public static final String VALUE_DO_HTTP_REQUEST = "do_http_request";
    public static final String VALUE_END = "end";
    public static final String VALUE_FAIL = "fail";
    public static final String VALUE_FILE_UPLOAD = "msg_file_upload";
    public static final String VALUE_INSERTDB = "insertDb";
    public static final String VALUE_MSG_SEND = "msg_send";
    public static final String VALUE_REPLY = "reply";
    public static final String VALUE_SEND = "send";
    public static final String VALUE_START = "start";
    public static final String VALUE_SUCCESS = "success";
    public static final String VALUE_UPDATE_HTTP_DNS = "update_http_dns";
    private static boolean VDBG;
    private static boolean WDBG;
    private static boolean XDBG;
    private static int logCount;
    private static int pid;
    private static boolean sClientErrorLog;

    /* JADX INFO: compiled from: SearchBox */
    public enum LogType {
        LOG_TYPE_USER_ACTION(1000),
        LOG_TYPE_BACKGROUP(2000),
        LOG_TYPE_BACKGROUP_FAIL(2100),
        LOG_TYPE_BACKGROUND_NETWORK(3000),
        LOG_TYPE_CRASH(4000),
        LOG_TYPE_USER_ACTION_IMMEDIATE(5000),
        LOG_TYPE_ANR(6000),
        LOG_TYPE_QA_IMPORTANT(7000),
        LOG_TYPE_QA_NORMAL(8000),
        LOG_TYPE_QA_SOCKET(9000),
        LOG_TYPE_MESSAGE_NOTIFY(9100),
        LOG_TYPE_MESSAGE_COMMON(9200),
        LOG_TYPE_MESSAGE_EXPRESSION(9300),
        LOG_TYPE_KEEPALIVE(AVMDLDataLoader.KeyIsIgnorePlayInfo),
        LOG_TYPE_ANR_NEW(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec),
        LOG_TYPE_IMG_LOAD_EXPIRE(AVMDLDataLoader.KeyIsLiveGetCurrentBitRate),
        LOG_TYPE_THIRD_PUSH(8001);

        public int value;

        LogType(int i) {
            this.value = i;
        }
    }

    static {
        boolean z = c.b;
        VDBG = z;
        DDBG = z;
        IDBG = z;
        WDBG = z;
        EDBG = z;
        XDBG = z;
        sClientErrorLog = false;
        logCount = 0;
    }

    public static void d(String str, int i, HashMap<String, Object> map, Throwable th) {
        d(str, LogType.LOG_TYPE_BACKGROUP, i, map, th);
    }

    public static void e(String str, int i, HashMap<String, Object> map, Throwable th) {
        e(str, LogType.LOG_TYPE_BACKGROUP, i, map, th);
    }

    private static String genLog(LogType logType, int i, String str, String str2, String str3, Throwable th) {
        if (needPrintFileLog(i) || needPrintStatsLog(logType, i)) {
            return a.c(logType, str, str2, str3, th);
        }
        return null;
    }

    public static String getExceptionString(Throwable th) {
        if (th == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                th.printStackTrace(new PrintStream(byteArrayOutputStream));
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }

    public static void i(String str, int i, HashMap<String, Object> map, Throwable th) {
        i(str, LogType.LOG_TYPE_BACKGROUP, i, map, th);
    }

    public static boolean isDDBG() {
        return isLogEnable();
    }

    public static boolean isEDBG() {
        return isLogEnable();
    }

    public static boolean isIDBG() {
        return isLogEnable();
    }

    public static boolean isLogEnable() {
        return c.b;
    }

    public static boolean isVDBG() {
        return isLogEnable();
    }

    public static boolean isWDBG() {
        return isLogEnable();
    }

    public static boolean isXDBG() {
        return isLogEnable();
    }

    public static void json(String str, String str2, String str3) {
        if (isDDBG()) {
            synchronized (LogUtil.class) {
                if (str2 != null) {
                    try {
                        if (str2.startsWith("{")) {
                            str2 = new JSONObject(str2).toString(4);
                        } else if (str2.startsWith("[")) {
                            str2 = new JSONArray(str2).toString(4);
                        }
                    } catch (JSONException unused) {
                    }
                } else {
                    str2 = "";
                }
                d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
                for (String str4 : (str3 + "\n" + str2).split("\n")) {
                    d(str, "║ " + str4);
                }
                d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
            }
        }
    }

    public static void log4ClientError(String str, Throwable th) {
        log4ClientError(str, null, th);
    }

    public static void logCurrentStack(String str) {
        i(str, "logCurrentStack:" + getExceptionString(new Throwable("test").fillInStackTrace()));
    }

    private static void logMessageByFlag(LogType logType, int i, String str, String str2, String str3, Throwable th) {
        String strGenLog = genLog(logType, i, str, str2, str3, th);
        if (needPrintFileLog(i)) {
            iu1.d(strGenLog);
        }
        if (needPrintStatsLog(logType, i)) {
            sk5.b(logType, strGenLog, th != null);
        }
    }

    public static void logStack(String str) {
        if (isEDBG()) {
            Exception exc = new Exception(str);
            exc.fillInStackTrace().printStackTrace();
            i(str, str, exc);
        }
    }

    private static boolean needPrintFileLog(int i) {
        return (i & 1) > 0;
    }

    private static boolean needPrintStatsLog(LogType logType, int i) {
        return (i & 2) > 0 && logType != LogType.LOG_TYPE_BACKGROUP;
    }

    private static boolean needUploadForClientError() {
        int i;
        JSONObject config = vs0.a().getConfig("clientErrorLog");
        if (config == null) {
            return false;
        }
        try {
            int iOptInt = config.optInt("rate", 1000);
            int iOptInt2 = config.optInt("maxCount", 200);
            String strOptString = config.optString("uidWhiteList");
            String str = ac1.h;
            String strE = v4.e(c.b());
            if ((Long.parseLong(TextUtils.isEmpty(strE) ? str.substring(4) : strE) % ((long) iOptInt) != 0 && !strOptString.contains(strE) && !sClientErrorLog) || (i = logCount) >= iOptInt2) {
                return false;
            }
            logCount = i + 1;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean needUploadWithRateCheck() {
        JSONObject config = vs0.a().getConfig("clientErrorLog");
        if (config == null) {
            return false;
        }
        try {
            int iOptInt = config.optInt("rate", 1000);
            String str = ac1.h;
            String strE = v4.e(c.b());
            if (TextUtils.isEmpty(strE)) {
                strE = str.substring(4);
            }
            return Long.parseLong(strE) % ((long) iOptInt) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void onClickEvent(String str, String str2, String str3) {
        onEvent(str, "1", str2, str3);
    }

    public static void onEvent(String str, String str2, String str3, String str4) {
        onEvent(LogType.LOG_TYPE_USER_ACTION, null, str, str2, str3, str4);
    }

    public static void onImmediateClickEvent(String str, String str2, String str3) {
        uploadInfoImmediate(str, "1", str2, str3);
    }

    public static void onNotifyClickEvent(String str, String str2, String str3) {
        onNotifyEvent(str, "1", str2, str3);
    }

    public static void onNotifyEvent(String str, String str2, String str3, String str4) {
        onEvent(LogType.LOG_TYPE_MESSAGE_NOTIFY, null, str, str2, str3, str4);
    }

    public static void setClientErrorLogOpen(boolean z) {
        sClientErrorLog = z;
    }

    public static void uploadInfoImmediate(String str, String str2, String str3, String str4) {
        onEvent(LogType.LOG_TYPE_USER_ACTION_IMMEDIATE, null, str, str2, str3, str4);
    }

    public static void uploadInfoImmediateWithRateCheck(String str, HashMap<String, Object> map) {
        if (needUploadWithRateCheck()) {
            uploadInfoImmediate(str, map);
        }
    }

    public static void v(String str, int i, HashMap<String, Object> map, Throwable th) {
        v(str, LogType.LOG_TYPE_BACKGROUP, i, map, th);
    }

    public static void w(String str, int i, HashMap<String, Object> map, Throwable th) {
        w(str, LogType.LOG_TYPE_BACKGROUP, i, map, th);
    }

    public static void x(String str, String str2) {
        if (isXDBG()) {
            d(str, str2);
        }
    }

    public static void d(String str, LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (isDDBG()) {
            Log.d(str, a.g(map), th);
        }
        logMessageByFlag(logType, i, map, th);
    }

    public static void e(String str, LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (isEDBG()) {
            Log.e(str, a.g(map), th);
        }
        logMessageByFlag(logType, i, map, th);
    }

    public static void i(String str, LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (isIDBG()) {
            Log.i(str, a.g(map), th);
        }
        logMessageByFlag(logType, i, map, th);
    }

    public static void log4ClientError(String str, HashMap<String, Object> map, Throwable th) {
        log4ClientError(str, map, th, false);
    }

    public static void onEvent(LogType logType, String str, String str2, String str3, String str4, String str5) {
        if (isIDBG()) {
            Log.i("onEvent", "component:" + str2 + " action:" + str3 + " result:" + str4 + " extra:" + str5);
        }
        HashMap map = new HashMap();
        map.put(KEY_COMPONENT, str2);
        map.put("action", str3);
        map.put("stt", str4);
        map.put(BaseConstants.EVENT_LABEL_EXTRA, str5);
        if (!TextUtils.isEmpty(str)) {
            map.put(DeviceInfoUtil.UID_TAG, str);
        }
        String strA = zs1.a();
        if (strA != null) {
            map.put("pth", strA);
        }
        logMessageByFlag(logType, 3, map, null);
    }

    public static void uploadInfoImmediate(String str, HashMap<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof JSONObject) {
                        jSONObject.put(key, value.toString());
                    } else if (value instanceof JSONArray) {
                        jSONObject.put(key, value.toString());
                    } else {
                        jSONObject.put(key, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        uploadInfoImmediate(str, "1", null, jSONObject.toString());
    }

    public static void v(String str, LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (isVDBG()) {
            Log.v(str, a.g(map), th);
        }
        logMessageByFlag(logType, i, map, th);
    }

    public static void w(String str, LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (isWDBG()) {
            Log.w(str, a.g(map), th);
        }
        logMessageByFlag(logType, i, map, th);
    }

    private static String genLog(LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (needPrintFileLog(i) || needPrintStatsLog(logType, i)) {
            return a.d(logType, map, th);
        }
        return null;
    }

    public static void log4ClientError(String str, HashMap<String, Object> map, Throwable th, boolean z) {
        if (isIDBG()) {
            StringBuilder sb = new StringBuilder();
            sb.append("component:");
            sb.append(str);
            sb.append(" throwable:");
            sb.append(th);
            sb.append(" extra=");
            sb.append(map == null ? b.m : new JSONObject(map));
            Log.i("log4ClientError", sb.toString());
        }
        HashMap<String, Object> map2 = new HashMap<>();
        if (map == null) {
            map = map2;
        }
        map.put("action", "ClientError");
        map.put("detail", str);
        String strA = zs1.a();
        if (strA != null) {
            map.put("pth", strA);
        }
        logMessageByFlag(z || needUploadForClientError() ? LogType.LOG_TYPE_ANR_NEW : LogType.LOG_TYPE_BACKGROUP, 3, map, th);
    }

    public static void d(String str, String str2) {
        d(str, str2, (Throwable) null, 0);
    }

    public static void e(String str, String str2) {
        e(str, str2, (Throwable) null, 0);
    }

    public static void i(String str, String str2) {
        i(str, str2, (Throwable) null, 0);
    }

    public static void v(String str, String str2) {
        v(str, str2, (Throwable) null, 0);
    }

    public static void w(String str, String str2) {
        w(str, str2, (Throwable) null, 0);
    }

    public static void d(String str, String str2, Throwable th) {
        d(str, str2, th, 0);
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2, th, 0);
    }

    public static void i(String str, String str2, Throwable th) {
        i(str, str2, th, 0);
    }

    private static void logMessageByFlag(LogType logType, int i, String str, String str2, Throwable th) {
        String strGenLog = genLog(logType, i, str, str2, null, th);
        if (needPrintFileLog(i)) {
            iu1.d(strGenLog);
        }
        if (needPrintStatsLog(logType, i)) {
            sk5.b(logType, strGenLog, th != null);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        v(str, str2, th, 0);
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, str2, th, 0);
    }

    public static void d(String str, String str2, int i) {
        d(str, str2, (Throwable) null, i);
    }

    public static void e(String str, String str2, int i) {
        e(str, str2, (Throwable) null, i);
    }

    public static void i(String str, String str2, int i) {
        i(str, str2, (Throwable) null, i);
    }

    public static void v(String str, String str2, int i) {
        v(str, str2, (Throwable) null, i);
    }

    public static void w(String str, String str2, int i) {
        w(str, str2, (Throwable) null, i);
    }

    public static void d(String str, String str2, Throwable th, int i) {
        d(str, str2, th, LogType.LOG_TYPE_BACKGROUP, i);
    }

    public static void e(String str, String str2, Throwable th, int i) {
        e(str, str2, th, LogType.LOG_TYPE_BACKGROUP, i);
    }

    public static void i(String str, String str2, Throwable th, int i) {
        i(str, str2, th, LogType.LOG_TYPE_BACKGROUP, i);
    }

    public static void v(String str, String str2, Throwable th, int i) {
        v(str, str2, th, LogType.LOG_TYPE_BACKGROUP, i);
    }

    public static void w(String str, String str2, Throwable th, int i) {
        w(str, str2, th, LogType.LOG_TYPE_BACKGROUP, i);
    }

    public static void d(String str, String str2, Throwable th, LogType logType, int i) {
        if (isDDBG()) {
            if (th == null) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, th);
            }
        }
        logMessageByFlag(logType, i, "D", str, str2, th);
    }

    public static void e(String str, String str2, Throwable th, LogType logType, int i) {
        if (isEDBG()) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
        logMessageByFlag(logType, i, ExifInterface.LONGITUDE_EAST, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th, LogType logType, int i) {
        if (isIDBG()) {
            if (th == null) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, th);
            }
        }
        logMessageByFlag(logType, i, "I", str, str2, th);
    }

    public static void v(String str, String str2, Throwable th, LogType logType, int i) {
        if (isVDBG()) {
            if (th == null) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, th);
            }
        }
        logMessageByFlag(logType, i, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th, LogType logType, int i) {
        if (isWDBG()) {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
        }
        logMessageByFlag(logType, i, "W", str, str2, th);
    }

    private static void logMessageByFlag(LogType logType, int i, HashMap<String, Object> map, Throwable th) {
        if (c.b() == null) {
            return;
        }
        String strGenLog = genLog(logType, i, map, th);
        if (needPrintFileLog(i)) {
            iu1.d(strGenLog);
        }
        if (needPrintStatsLog(logType, i)) {
            sk5.b(logType, strGenLog, th != null);
        }
    }

    public static void e(String str, Throwable th) {
        e(str, th, 1);
    }

    public static void e(String str, Throwable th, int i) {
        if (isEDBG() && th != null) {
            th.printStackTrace();
            Log.e(str, th.toString());
        }
        logMessageByFlag(LogType.LOG_TYPE_BACKGROUP, i, ExifInterface.LONGITUDE_EAST, str, th);
    }

    public static void json(String str, JSONObject jSONObject, String str2) {
        if (isEDBG()) {
            synchronized (LogUtil.class) {
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.toString(4);
                        d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
                        for (String str3 : (str2 + "\n" + string).split("\n")) {
                            d(str, "║ " + str3);
                        }
                        d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void uploadInfoImmediate(String str, String str2, String str3, String str4, String str5) {
        onEvent(LogType.LOG_TYPE_USER_ACTION_IMMEDIATE, str, str2, str3, str4, str5);
    }
}
