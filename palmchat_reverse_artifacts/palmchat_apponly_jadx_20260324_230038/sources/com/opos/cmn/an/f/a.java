package com.opos.cmn.an.f;

import android.content.Context;
import com.opos.cmn.an.f.b.b;
import com.opos.cmn.an.f.b.c;
import com.opos.cmn.an.f.b.f;
import com.opos.cmn.an.f.b.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7743a;
    private static final byte[] b = new byte[0];

    public static void a() {
        c.a();
    }

    public static void b() {
        if (f7743a != null) {
            f7743a.a();
        }
    }

    public static void c(String str, String str2) {
        if (f7743a != null) {
            f7743a.c(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f7743a != null) {
            f7743a.d(str, str2);
        }
    }

    public static void a(Context context, boolean z) {
        g.a(context, z);
    }

    public static void b(String str, Object obj) {
        if (f7743a != null) {
            f7743a.b(str, obj);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f7743a != null) {
            f7743a.c(str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f7743a != null) {
            f7743a.d(str, str2, th);
        }
    }

    public static void a(com.opos.cmn.an.f.a.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("initParams is null.");
        }
        if (f7743a == null) {
            synchronized (b) {
                if (f7743a == null) {
                    f7743a = new f();
                    f7743a.a(bVar);
                }
            }
        }
    }

    public static void b(String str, String str2) {
        if (f7743a != null) {
            f7743a.b(str, str2);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f7743a != null) {
            f7743a.c(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (f7743a != null) {
            f7743a.d(str, objArr);
        }
    }

    public static void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (f7743a != null) {
            f7743a.a(cVar, aVar);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f7743a != null) {
            f7743a.b(str, str2, th);
        }
    }

    public static void a(String str, Object obj) {
        if (f7743a != null) {
            f7743a.a(str, obj);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f7743a != null) {
            f7743a.b(str, objArr);
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (f7743a != null) {
            f7743a.a(str, obj, th);
        }
    }

    public static synchronized boolean b(Context context) {
        return g.a(context);
    }

    public static void a(String str, String str2) {
        if (f7743a != null) {
            f7743a.a(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7743a != null) {
            f7743a.a(str, str2, th);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f7743a != null) {
            f7743a.a(str, objArr);
        }
    }

    public static void a(boolean z) {
        com.opos.cmn.an.f.b.a.a(z);
    }

    public static boolean a(Context context) {
        return com.opos.cmn.an.f.b.a.a(context);
    }
}
