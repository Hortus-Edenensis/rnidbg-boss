package com.opos.cmn.an.c;

import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static String a() {
        String str = Build.MODEL;
        return str != null ? str : "";
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String c() {
        String str = Build.VERSION.RELEASE;
        return str != null ? str : "";
    }

    public static String d() {
        String str = Build.BRAND;
        return str != null ? str : "";
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        return str != null ? str : "";
    }
}
