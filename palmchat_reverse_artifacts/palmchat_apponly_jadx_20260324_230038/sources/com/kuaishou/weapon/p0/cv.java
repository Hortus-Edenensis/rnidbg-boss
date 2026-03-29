package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.config.EventParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7452a = "appkey";
    public static String b = "secretkey";
    public static String c = "pver";
    public static String d = "sdkver";
    public static String e = "ksid";
    public static String f = "timestamp";
    public static String g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.9");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.f7496a, bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String strB = h.a(context, "re_po_rt").b(df.i, bq.e);
                if (TextUtils.isEmpty(strB)) {
                    strB = bq.e;
                }
                jSONObject.put("pver", strB);
            } catch (Exception unused) {
                jSONObject.put("pver", bq.e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bq.g);
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.9");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap map = new HashMap();
            map.put(f7452a, str);
            map.put(b, str2);
            map.put(f, String.valueOf(System.currentTimeMillis() / 1000));
            map.put(g, b(map));
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map mapD = d(context);
        if (mapD == null || mapD.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : mapD.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f7452a));
            sb.append(map.get(b));
            sb.append(map.get(f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(t.f7496a, bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(df.g, bq.e));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bq.g);
        } catch (Exception unused) {
        }
    }
}
