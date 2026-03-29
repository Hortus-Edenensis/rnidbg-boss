package com.bytedance.sdk.component.u;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class qq {
    private static boolean u;

    public static String u() {
        return "";
    }

    public static String u(Throwable th) {
        StringBuilder sb = new StringBuilder("{\"code\":");
        sb.append(th instanceof sx ? ((sx) th).u : 0);
        sb.append("}");
        return sb.toString();
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = u ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + "}";
        }
        return str2 + "}";
    }

    public static void u(boolean z) {
        u = z;
    }
}
