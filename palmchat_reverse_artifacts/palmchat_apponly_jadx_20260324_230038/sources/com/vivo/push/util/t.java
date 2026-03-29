package com.vivo.push.util;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f11309a = new r();
    private static boolean b = ag.b("persist.sys.log.ctrl", "no").equals("yes");
    private static boolean c;

    public static boolean a() {
        return b;
    }

    public static boolean b() {
        return b && c;
    }

    public static int c(String str, String str2) {
        return f11309a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f11309a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f11309a.e(str, str2);
    }

    public static int a(String str, String str2) {
        return f11309a.a(str, str2);
    }

    public static void c(Context context, String str) {
        f11309a.c(context, str);
    }

    public static int a(String str, Throwable th) {
        return f11309a.a(str, th);
    }

    public static int b(String str, String str2) {
        return f11309a.b(str, str2);
    }

    public static int a(String str, String str2, Throwable th) {
        return f11309a.a(str, str2, th);
    }

    public static int b(String str, String str2, Throwable th) {
        return f11309a.b(str, str2, th);
    }

    public static void a(Context context, String str) {
        f11309a.a(context, str);
    }

    public static void b(Context context, String str) {
        f11309a.b(context, str);
    }

    public static void a(String str) {
        if (b) {
            f11309a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void b(String str) {
        if (b) {
            f11309a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static void a(int i, String str) {
        a("RunTimeException", "code: " + i + ", exceptionMsg: " + str);
    }
}
