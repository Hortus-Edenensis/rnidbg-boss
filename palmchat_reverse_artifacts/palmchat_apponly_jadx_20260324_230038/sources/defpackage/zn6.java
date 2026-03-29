package defpackage;

import android.text.TextUtils;
import com.lantern.core.MobEvent;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22461a = "zn6";

    public static void a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(jSONObject.optString(DeviceInfoUtil.UID_TAG))) {
                String strE = v4.e(c.b());
                if (strE == null) {
                    strE = "";
                }
                jSONObject.put(DeviceInfoUtil.UID_TAG, strE);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("report_type", str);
            }
            jSONObject.put("deviceId", ac1.h);
        } catch (Exception unused) {
        }
    }

    public static void b(String str) {
        f(str, null, new JSONObject());
    }

    public static void c(String str, String str2) {
        f(str, str2, new JSONObject());
    }

    public static void d(String str, String str2, String str3) {
        e(null, str, str2, str3);
    }

    public static void e(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = null;
        try {
            jSONObject = !TextUtils.isEmpty(str4) ? new JSONObject(str4) : new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(DeviceInfoUtil.UID_TAG, str);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("stt", str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        g(str2, jSONObject);
    }

    public static void f(String str, String str2, JSONObject jSONObject) {
        a(jSONObject, str2);
        if (LogUtil.isLogEnable()) {
            String str3 = f22461a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": extra = ");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            LogUtil.i(str3, sb.toString());
        }
        if (TextUtils.isEmpty(str) || (!(str.contains("lx_client_nestad") || "splash_inventory".equals(str) || str.contains("nest_sdk_ad")) || i6.a(str))) {
            MobEvent.onEventExtra(str, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    public static void g(String str, JSONObject jSONObject) {
        f(str, null, jSONObject);
    }

    public static void h(String str, String str2, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        if (str2 != null) {
            map.put("report_type", str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    if (value == null) {
                        value = "";
                    }
                    jSONObject.put(key, value);
                }
            }
            g(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    public static void i(String str, Map<String, String> map) {
        h(str, null, map);
    }

    public static void j(String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        if (str2 != null) {
            map.put("report_type", str2);
        }
        try {
            g(str, new JSONObject(map));
        } catch (Exception unused) {
        }
    }
}
