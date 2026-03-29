package com.baidu.bdhttpdns;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3365a = false;

    public static void a(String str, Object... objArr) {
        if (f3365a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    public static void a(boolean z) {
        f3365a = z;
    }
}
