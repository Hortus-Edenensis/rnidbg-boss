package defpackage;

import android.content.Context;
import com.apm.lite.b;
import com.apm.lite.nativecrash.NativeImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class de7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17037a;

    public de7(Context context) {
        this.f17037a = context;
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i) {
        ih7.b().f(new de7(context), i);
    }

    public static boolean c() {
        return qz6.a().s() || !kv6.k(x97.m());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u77.f();
        } catch (Throwable unused) {
        }
        try {
            if (kv6.k(this.f17037a)) {
                qz6.a().k(yi7.c(this.f17037a));
            } else {
                NativeImpl.setUploadEnd();
            }
            xi7.d().f(x97.a().d(), s07.j());
            if (ih7.b().a() == null || b.b() == null) {
            }
        } catch (Throwable th) {
            try {
                kj7.g(th);
            } finally {
                xi7.d().f(x97.a().d(), s07.j());
                if (ih7.b().a() != null && b.b() != null) {
                    x77.a(ih7.b().a(), this.f17037a).b();
                }
            }
        }
    }
}
