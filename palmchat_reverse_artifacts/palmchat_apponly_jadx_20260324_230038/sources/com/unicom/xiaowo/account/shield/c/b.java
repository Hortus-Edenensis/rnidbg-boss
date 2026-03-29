package com.unicom.xiaowo.account.shield.c;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11187a = true;

    public static void a(String str) {
        if (f11187a) {
            Log.i("uniaccount", com.unicom.xiaowo.account.shield.b.e.b() + " " + str);
        }
    }

    public static void b(String str) {
        if (f11187a) {
            Log.e("uniaccount", com.unicom.xiaowo.account.shield.b.e.b() + " " + str);
        }
    }

    public static void a(boolean z) {
        f11187a = z;
    }
}
