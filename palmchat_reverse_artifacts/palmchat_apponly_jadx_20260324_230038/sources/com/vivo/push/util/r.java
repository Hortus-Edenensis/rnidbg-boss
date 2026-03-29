package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class r implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11308a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.s
    public final int a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int d(String str, String str2) {
        if (!t.a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int e(String str, String str2) {
        if (!t.a()) {
            return -1;
        }
        return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.s
    public final int b(String str, String str2, Throwable th) {
        if (!t.a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2, th);
    }

    @Override // com.vivo.push.util.s
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.s
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.s
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f11308a + str2, th);
    }

    @Override // com.vivo.push.util.s
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        nVar.g();
        com.vivo.push.a.a.a(context, nVar, context.getPackageName());
    }

    private static boolean a() {
        t.a();
        return com.vivo.push.h.a.a().b();
    }
}
