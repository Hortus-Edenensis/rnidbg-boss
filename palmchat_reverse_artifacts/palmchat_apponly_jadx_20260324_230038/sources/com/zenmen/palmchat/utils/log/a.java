package com.zenmen.palmchat.utils.log;

import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.time.FastDateFormat;
import defpackage.ac1;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.v4;
import defpackage.xn3;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FastDateFormat f15743a;
    public FastDateFormat b;
    public FastDateFormat c;

    public a() {
        this.f15743a = null;
        this.b = null;
        this.c = null;
        Locale locale = Locale.US;
        this.f15743a = FastDateFormat.getInstance("yyyy-MM-dd-HH-mm-ss-SSS", locale);
        this.c = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale);
        this.b = FastDateFormat.getInstance("yyyy.MM.dd", locale);
    }

    public static String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].toString());
            if (i < stackTrace.length - 1) {
                sb.append("\n");
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append("Caused by:\n");
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            for (int i2 = 0; i2 < stackTrace2.length; i2++) {
                sb.append(stackTrace2[i2].toString());
                if (i2 < stackTrace2.length - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static String b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\nat " + stackTraceElement.toString());
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append("Caused by:" + cause + "\n");
            for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                sb.append("\nat " + stackTraceElement2.toString());
            }
        }
        return sb.toString();
    }

    public static String c(LogUtil.LogType logType, String str, String str2, String str3, Throwable th) {
        HashMap map = new HashMap();
        map.put("tag", str2);
        map.put("message", str3);
        map.put("log_type", str);
        return d(logType, map, th);
    }

    public static String d(LogUtil.LogType logType, Map<String, Object> map, Throwable th) {
        return f() + "\n" + e(logType, map, th) + "\n";
    }

    public static String e(LogUtil.LogType logType, Map<String, Object> map, Throwable th) {
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObject = new JSONObject();
        try {
            if (logType == LogUtil.LogType.LOG_TYPE_USER_ACTION || logType == LogUtil.LogType.LOG_TYPE_USER_ACTION_IMMEDIATE) {
                jSONObject.put("pfm", ac1.c);
                jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
                jSONObject.put("ver", ac1.f);
                jSONObject.put("ts", ir5.b());
                jSONObject.put("@timestamp", h());
                jSONObject.put("did", ac1.h);
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, hx3.e());
                jSONObject.put(WkParams.MODEL, ac1.b);
                jSONObject.put("manufacturer", ac1.f1194a);
            } else {
                jSONObject.put("deviceId", ac1.h);
                jSONObject.put("clientVersionCode", ac1.f);
                jSONObject.put("@timestamp", h());
                jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
                jSONObject.put("platform", ac1.c);
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, hx3.e());
                if (logType == LogUtil.LogType.LOG_TYPE_QA_IMPORTANT || logType == LogUtil.LogType.LOG_TYPE_QA_NORMAL) {
                    jSONObject.put("clientVersionName", ac1.g);
                    jSONObject.put("osVersion", ac1.e);
                    jSONObject.put(WkParams.MODEL, ac1.b);
                    jSONObject.put("manufacturer", ac1.f1194a);
                }
            }
            jSONObject.put("log_code", logType.value);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("mac", ac1.k);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("uiType", 1);
            if (map != null) {
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
            }
            if (th != null) {
                jSONObject.put("error", th.toString());
                jSONObject.put("error_stack", a(th));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append(jSONObject.toString());
        return sb.toString();
    }

    public static String f() {
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("_index", "zhangxin-client-" + j().b.format(ir5.b()));
            jSONObject2.put("_type", "log");
            jSONObject2.put("_id", xn3.a());
            jSONObject.put("index", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append(jSONObject.toString());
        return sb.toString();
    }

    public static String g(HashMap<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            sb.append(key);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(value);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String h() {
        return j().c.format(ir5.b());
    }

    public static a j() {
        a aVar = d;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = d;
                if (aVar == null) {
                    aVar = new a();
                    d = aVar;
                }
            }
        }
        return aVar;
    }

    public FastDateFormat i() {
        return this.f15743a;
    }
}
