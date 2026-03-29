package com.bykv.vk.openvk.component.video.api.iz;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private static String fx = "";
    private static int nr = 4;
    private static boolean u = false;

    public static boolean nr() {
        return u;
    }

    public static void u(int i) {
        nr = i;
    }

    private static String nr(String str) {
        if (TextUtils.isEmpty(fx)) {
            return str;
        }
        return u("[" + fx + "]-[" + str + "]");
    }

    public static void u() {
        u = true;
        u(3);
    }

    public static void u(String str) {
        if (u) {
            u("Logger", str);
        }
    }

    public static void u(String str, String str2) {
        if (u && str2 != null && nr <= 6) {
            k.nr(nr(str), str2);
        }
    }

    public static void u(String str, String str2, Throwable th) {
        if (u) {
            if (!(str2 == null && th == null) && nr <= 6) {
                k.u(nr(str), str2, th);
            }
        }
    }

    private static String u(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
