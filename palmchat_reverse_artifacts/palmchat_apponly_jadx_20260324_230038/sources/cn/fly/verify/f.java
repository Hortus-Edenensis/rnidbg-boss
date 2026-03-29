package cn.fly.verify;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f2345a = new f();
    private static fe b;

    private f() {
        try {
            b = fe.a(FlyVerify.sdkTag);
            dw.a().a(FlyVerify.sdkTag, FlyVerify.SDK_VERSION_CODE);
        } catch (Throwable th) {
            Log.d("[FlyVerify] ==>%s", "SLog init error", th);
        }
    }

    public static f a() {
        if (f2345a == null) {
            synchronized (f.class) {
                if (f2345a == null) {
                    f2345a = new f();
                }
            }
        }
        return f2345a;
    }

    public void b(String str, String str2) {
        fe feVar = b;
        if (feVar != null) {
            feVar.a(str, str2);
        }
    }

    public void c(String str, String str2) {
        fe feVar = b;
        if (feVar != null) {
            feVar.d(str, str2);
        }
    }

    public void a(String str) {
        fe feVar = b;
        if (feVar != null) {
            feVar.a("[FlyVerify] ==>%s", str);
        }
    }

    public void b(Throwable th) {
        fe feVar = b;
        if (feVar != null) {
            feVar.a("[FlyVerify] ==>%s", th);
        }
    }

    public void c(Throwable th) {
        fe feVar = b;
        if (feVar != null) {
            feVar.b("[FlyVerify] ==>%s", th);
        }
    }

    public void a(String str, String str2) {
        fe feVar = b;
        if (feVar != null) {
            feVar.c(str, str2);
        }
    }

    public void b(Throwable th, String str, String str2, String str3, String str4) {
    }

    public void a(Throwable th) {
        fe feVar = b;
        if (feVar != null) {
            feVar.d("[FlyVerify] ==>%s", th);
        }
    }

    public void a(Throwable th, String str, String str2) {
        fe feVar = b;
        if (feVar != null) {
            feVar.a(th, str, str2);
        }
    }

    public void a(Throwable th, String str, String str2, String str3, String str4) {
    }
}
