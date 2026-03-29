package com.huawei.hms.ads.uiengineloader;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6614a = "ppsuiengineloader.";

    public static void a(String str, String str2) {
        Log.d(f6614a.concat(String.valueOf(str)), str2);
    }

    public static void b(String str, String str2) {
        Log.i(f6614a.concat(String.valueOf(str)), str2);
    }

    public static void c(String str, String str2) {
        Log.w(f6614a.concat(String.valueOf(str)), str2);
    }

    public static void d(String str, String str2) {
        Log.e(f6614a.concat(String.valueOf(str)), str2);
    }
}
