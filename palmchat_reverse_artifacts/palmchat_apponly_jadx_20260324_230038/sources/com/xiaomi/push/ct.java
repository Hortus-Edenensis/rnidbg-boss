package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cl f11484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cm f223a;

    public static void a(Context context, fa faVar) {
        if (m277b(context)) {
            if (f11484a == null) {
                f11484a = new cl(context);
            }
            if (f223a == null) {
                f223a = new cm(context);
            }
            cl clVar = f11484a;
            faVar.a(clVar, clVar);
            cm cmVar = f223a;
            faVar.b(cmVar, cmVar);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cl clVar = f11484a;
        if (clVar != null) {
            faVar.a(clVar);
            f11484a = null;
        }
        cm cmVar = f223a;
        if (cmVar != null) {
            faVar.b(cmVar);
            f223a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (m277b(context)) {
            cw.c(context, System.currentTimeMillis(), m276a(context));
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (m277b(context)) {
            cw.d(context, System.currentTimeMillis(), m276a(context));
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m277b(Context context) {
        return ck.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (m277b(context)) {
            cw.a(context, System.currentTimeMillis(), m276a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (m277b(context)) {
            cw.b(context, System.currentTimeMillis(), m276a(context));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m276a(Context context) {
        return i.m644b(context);
    }

    public static void a(String str) {
        ck.a("Push-PowerStats", str);
    }
}
