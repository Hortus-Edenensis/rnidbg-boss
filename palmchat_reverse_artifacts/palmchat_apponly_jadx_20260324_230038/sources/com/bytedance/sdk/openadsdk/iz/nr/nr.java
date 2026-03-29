package com.bytedance.sdk.openadsdk.iz.nr;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static Map<String, Map<String, Map<String, Integer>>> u = new HashMap();

    private static void a(String str, String str2) {
        u(str, str2, "lvsu_c");
    }

    private static void b(String str, String str2) {
        u(str, str2, "fo_c");
    }

    private static void fx(String str, String str2) {
        u(str, str2, "fpl_c");
    }

    private static void iz(String str, String str2) {
        u(str, str2, "fb_c");
    }

    private static void jk(String str, String str2) {
        u(str, str2, "lve_c");
    }

    private static void n(String str, String str2) {
        u(str, str2, "lvs_c");
    }

    private static void nr(String str, String str2) {
        u(str, str2, "ps_c");
    }

    private static void pn(String str, String str2) {
        u(str, str2, "fpu_c");
    }

    private static void t(String str, String str2) {
        u(str, str2, "lvc_c");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void u(String str, bc bcVar) {
        String strValueOf;
        String strU;
        if (TextUtils.isEmpty(str)) {
        }
        com.bytedance.sdk.openadsdk.core.rh.fx fxVar = (com.bytedance.sdk.openadsdk.core.rh.fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya");
        if (fxVar == null || fxVar.isPitayaEnvAvailable()) {
            try {
                strValueOf = String.valueOf(jp.jk(bcVar));
                strU = jp.u(bcVar, "-1");
                switch (str) {
                    case "load_video_start":
                        n(strValueOf, strU);
                        break;
                    case "load_video_cancel":
                        t(strValueOf, strU);
                        break;
                    case "load_video_success":
                        a(strValueOf, strU);
                        break;
                    case "load_video_error":
                        jk(strValueOf, strU);
                        break;
                    case "play_start":
                        nr(strValueOf, strU);
                        break;
                    case "feed_play":
                        fx(strValueOf, strU);
                        break;
                    case "feed_break":
                        iz(strValueOf, strU);
                        break;
                    case "feed_pause":
                        pn(strValueOf, strU);
                        break;
                    case "feed_over":
                        b(strValueOf, strU);
                        break;
                    case "play_error":
                        x(strValueOf, strU);
                        break;
                    case "show":
                        u(strValueOf, strU);
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void x(String str, String str2) {
        u(str, str2, "pe_c");
    }

    private static void u(String str, String str2) {
        u(str, str2, "show_c");
    }

    private static void u(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = u.get(str);
        if (map == null) {
            map = new HashMap<>();
            u.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        if (u.isEmpty()) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : u.entrySet()) {
                String key = entry.getKey();
                Map<String, Map<String, Integer>> value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                if (value != null) {
                    for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                        String key2 = entry2.getKey();
                        Map<String, Integer> value2 = entry2.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        if (value2 != null) {
                            for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                jSONObject3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        jSONObject2.put(key2, jSONObject3);
                    }
                }
                jSONObject.put(key, jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
