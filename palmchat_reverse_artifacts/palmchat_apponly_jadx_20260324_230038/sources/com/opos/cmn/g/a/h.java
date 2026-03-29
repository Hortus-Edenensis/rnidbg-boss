package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8017a = "d";
    private static final byte[] b = new byte[0];
    private static final byte[] c = new byte[0];
    private static volatile long d = 0;
    private static volatile String e = "";
    private static volatile String f = "";
    private static volatile boolean g = false;
    private static volatile boolean h = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8018a;

        public a(Context context) {
            this.f8018a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.b) {
                    String strA = g.a(this.f8018a);
                    String strB = g.b(this.f8018a);
                    if (!TextUtils.isEmpty(strA)) {
                        String unused = h.e = strA;
                        i.a(this.f8018a, h.e);
                    }
                    if (!TextUtils.isEmpty(strB)) {
                        String unused2 = h.f = strB;
                        i.b(this.f8018a, h.f);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(h.f8017a, "", e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8019a;

        public b(Context context) {
            this.f8019a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.c) {
                    boolean unused = h.g = g.d(this.f8019a);
                    i.a(this.f8019a, h.g);
                    long unused2 = h.d = System.currentTimeMillis();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(h.f8017a, "", e);
            }
        }
    }

    public static String e(Context context) {
        return "";
    }

    public static String c(Context context) {
        if (context != null && TextUtils.isEmpty(e)) {
            e = i.a(context);
        }
        if (!h) {
            a(context);
        }
        return e;
    }

    public static String d(Context context) {
        if (context != null && TextUtils.isEmpty(f)) {
            f = i.b(context);
        }
        if (!h) {
            a(context);
        }
        return f;
    }

    public static boolean f(Context context) {
        if (context != null) {
            g = i.d(context);
        }
        return g;
    }

    public static synchronized void a(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            h = true;
            new Thread(new a(applicationContext)).start();
        }
    }

    public static void b(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (System.currentTimeMillis() >= d + 5000) {
                new Thread(new b(applicationContext)).start();
            }
        }
    }
}
