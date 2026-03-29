package defpackage;

import android.os.SystemClock;
import com.bytedance.u.nr.fx;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pl7 implements Thread.UncaughtExceptionHandler {
    public static pl7 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f20050a;
    public ni7 c;
    public HashSet<Thread.UncaughtExceptionHandler> b = new HashSet<>();
    public long d = -1;
    public volatile boolean e = true;

    public pl7() {
        a();
    }

    public static void c() {
        try {
            pl7 pl7Var = f;
            if (pl7Var == null) {
                mf7.b("CrashCatchDispatcher id not init.");
                return;
            }
            pl7Var.e = false;
            ni7 xc7Var = f.c;
            f = new pl7();
            if (xc7Var == null) {
                xc7Var = new xc7(uh7.b());
            }
            f.f(xc7Var);
        } catch (Throwable th) {
            mf7.c("CrashCatchDispatcher reRegister", th);
        }
    }

    public static pl7 e() {
        if (f == null) {
            f = new pl7();
        }
        return f;
    }

    public final void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.f20050a == null) {
                this.f20050a = defaultUncaughtExceptionHandler;
            } else {
                this.b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public final void b(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f20050a.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public final void d(Thread thread, Throwable th) {
        List<Object> listC = uh7.g().c();
        fx fxVar = fx.LAUNCH;
        Iterator<Object> it = listC.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                tj7.d(th);
            } catch (Throwable th2) {
                mf7.a(th2);
            }
        }
    }

    public void f(ni7 ni7Var) {
        this.c = ni7Var;
    }

    public final boolean g(Thread thread, Throwable th) {
        cf7 cf7VarA = uh7.g().a();
        if (cf7VarA != null) {
            try {
                if (!cf7VarA.u(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ni7 ni7Var;
        if (SystemClock.uptimeMillis() - this.d < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.d = SystemClock.uptimeMillis();
            if (!this.e) {
                mf7.b("This CrashCatchDispatcher is disable");
                return;
            }
            boolean zG = g(thread, th);
            if (zG) {
                fx fxVar = fx.LAUNCH;
                d(thread, th);
                if (zG && (ni7Var = this.c) != null && ni7Var.u(th)) {
                    this.c.a(jCurrentTimeMillis, thread, th);
                }
            }
        } catch (Throwable th2) {
            try {
                mf7.d(th2);
            } finally {
                b(thread, th);
            }
        }
    }
}
