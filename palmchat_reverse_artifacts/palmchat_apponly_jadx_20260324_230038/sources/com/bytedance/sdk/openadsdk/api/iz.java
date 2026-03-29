package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static int nr = 4;
    private static boolean u = false;

    public static void b(String str, String str2) {
    }

    public static void fx(String str, String str2) {
    }

    public static void nr(String str) {
    }

    public static void pn(String str, String str2) {
        if (u && str2 != null && nr <= 6) {
            k.nr(str, str2);
        }
    }

    public static void u(String str) {
    }

    public static void b(String str, String str2, Throwable th) {
    }

    public static void fx(String str, String str2, Throwable th) {
    }

    public static void nr(String str, String str2) {
    }

    public static void u(String str, String str2) {
    }

    public static void fx(String str) {
        if (u) {
            pn("TTLogger", str);
        }
    }

    public static void nr(String str, String str2, Throwable th) {
    }

    public static void u(String str, String str2, Throwable th) {
    }

    public static void nr(String str, Object... objArr) {
        if (u && objArr != null && nr <= 5) {
            u(objArr);
        }
    }

    public static void pn(String str, String str2, Throwable th) {
        if (u) {
            if (!(str2 == null && th == null) && nr <= 6) {
                k.u(str, str2, th);
            }
        }
    }

    public static void u(Throwable th) {
    }

    public static void u(int i) {
        nr = i;
    }

    public static void u() {
        u = true;
        u(3);
    }

    public static void u(String str, Object... objArr) {
        if (u && objArr != null && nr <= 3) {
            u(objArr);
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
