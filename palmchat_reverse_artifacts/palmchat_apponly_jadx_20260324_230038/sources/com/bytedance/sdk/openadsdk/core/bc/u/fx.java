package com.bytedance.sdk.openadsdk.core.bc.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static Boolean u;

    private static boolean u() {
        if (u == null) {
            try {
                TTAdConstant.RitScenes ritScenes = TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
                u = Boolean.TRUE;
            } catch (Throwable unused) {
                u = Boolean.FALSE;
            }
        }
        return u.booleanValue();
    }

    public static String u(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? u(str) : str;
        }
        if (u()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
