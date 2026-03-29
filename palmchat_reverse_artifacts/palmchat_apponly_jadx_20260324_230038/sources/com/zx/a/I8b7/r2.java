package com.zx.a.I8b7;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f16854a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r2 f16855a = new r2();
    }

    public r2() {
        Context context = m3.f16830a;
        r0 r0Var = new r0();
        this.f16854a = r0Var;
        r0Var.b("zx_tag");
        r0Var.a(false);
        r0Var.a(1);
    }

    public static void a(String str) {
        try {
            a.f16855a.f16854a.f16852a.a(2, null, str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            a.f16855a.f16854a.f16852a.a(5, null, str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Throwable th) {
        try {
            a.f16855a.f16854a.f16852a.a(5, null, str, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Throwable th) {
        try {
            a.f16855a.f16854a.f16852a.a(5, null, null, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
