package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    private static String b = "";
    private static com.bytedance.sdk.component.u fx = null;
    private static int nr = 4;
    private static boolean u = false;

    public static boolean fx() {
        return u;
    }

    public static void nr() {
        u = true;
        u(3);
    }

    public static void u(com.bytedance.sdk.component.u uVar) {
        fx = uVar;
    }

    public static void u(int i) {
        nr = i;
    }

    public static void nr(String str, String str2) {
        com.bytedance.sdk.component.u uVar = fx;
        if (uVar != null) {
            uVar.nr(nr(str), str2);
        }
        if (u && str2 != null && nr <= 6) {
            Log.e(nr(str), str2);
        }
    }

    public static boolean u() {
        return nr <= 3;
    }

    public static void u(String str, String str2) {
        com.bytedance.sdk.component.u uVar = fx;
        if (uVar != null) {
            uVar.u(nr(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        nr(str);
    }

    public static void u(String str) {
        if (u) {
            nr("Logger", str);
        }
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        return u("[" + b + "]-[" + str + "]");
    }

    public static void u(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.u uVar = fx;
        if (uVar != null) {
            uVar.u(nr(str), str2, th);
        }
        if (u) {
            if (!(str2 == null && th == null) && nr <= 6) {
                Log.e(nr(str), str2, th);
            }
        }
    }

    public static void u(String str, Object... objArr) {
        com.bytedance.sdk.component.u uVar = fx;
        if (uVar != null) {
            uVar.nr(nr(str), u(objArr));
        }
        if (u && objArr != null && nr <= 6) {
            Log.e(nr(str), u(objArr));
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
