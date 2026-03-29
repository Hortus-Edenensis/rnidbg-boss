package com.bytedance.sdk.openadsdk.core.jp.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.jk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static final List<String> u = new ArrayList(Arrays.asList("1", "3", "2"));

    public static String u(String str) {
        str.hashCode();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return "0";
        }
    }

    public static String u() {
        String strB = jk.b();
        String strPn = jk.pn();
        String strS = sx.s();
        String strMy = sx.my();
        if (!sx.l()) {
            return "5";
        }
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strPn)) {
            if (TextUtils.isEmpty(strS) || TextUtils.isEmpty(strMy)) {
                return "4";
            }
            return u(strS + strMy);
        }
        if (TextUtils.isEmpty(strS) || TextUtils.isEmpty(strMy)) {
            return u(strB + strPn);
        }
        String strU = u(strB + strPn);
        String strU2 = u(strS + strMy);
        List<String> list = u;
        return (list.contains(strU) && list.contains(strU2) && !strU2.equals(strU)) ? "6" : list.contains(strU) ? strU : list.contains(strU2) ? strU2 : "0";
    }
}
