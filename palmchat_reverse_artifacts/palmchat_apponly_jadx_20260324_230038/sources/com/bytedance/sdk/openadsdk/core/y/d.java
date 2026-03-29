package com.bytedance.sdk.openadsdk.core.y;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static AtomicBoolean nr = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> u = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private static final com.bytedance.sdk.component.b.nr.fx u = com.bytedance.sdk.openadsdk.ats.b.u("tt_scheme_check_list_cache");
    }

    private d() {
    }

    public static Map<String, Boolean> nr(long j) {
        HashMap map = new HashMap();
        try {
            Map all = u.u.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String str = (String) entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        u(str);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get(ActionUtils.PAYMENT_AMOUNT).toString())));
                    }
                }
                if (u == null) {
                    u = new ConcurrentHashMap();
                } else {
                    u.clear();
                }
                u.putAll(map);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static void u(String str, Boolean bool) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            string = "";
        } else {
            try {
                string = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ActionUtils.PAYMENT_AMOUNT, string);
        jSONObject.put("time", System.currentTimeMillis());
        u.u.put(str, jSONObject.toString());
        nr.set(true);
    }

    public static Map<String, Boolean> u(long j) {
        try {
            if (nr.get()) {
                synchronized (d.class) {
                    if (nr.get()) {
                        Map<String, Boolean> mapNr = nr(j);
                        nr.set(false);
                        return mapNr;
                    }
                }
            }
            return new HashMap(u);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    private static JSONObject nr(String str) {
        String str2 = u.u.get(str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean u(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectNr = nr(str);
            if (jSONObjectNr == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectNr.getLong("time") <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectNr.getString(ActionUtils.PAYMENT_AMOUNT)));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void u(String str) {
        u.u.remove(str);
    }

    public static String u(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme());
        sb.append("://");
        sb.append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(":");
            sb.append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
