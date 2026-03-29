package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import com.apm.lite.nativecrash.NativeImpl;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class cg7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1973a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static x37 e = new x37();
    public static volatile boolean f = false;
    public static boolean g = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1974a;

        /* JADX INFO: renamed from: cg7$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0030a implements Runnable {
            public RunnableC0030a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean unused = cg7.f = true;
                NativeImpl.registerSignalMainThread();
            }
        }

        public a(boolean z) {
            this.f1974a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1974a && !cg7.f) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0030a());
            }
            cg7.v(this.f1974a);
        }
    }

    public static boolean A() {
        return g;
    }

    public static void B() {
        g = true;
    }

    public static boolean D() {
        return false;
    }

    public static x37 a() {
        return e;
    }

    public static synchronized void b(Application application, Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (f1973a) {
            return;
        }
        f1973a = true;
        if (context == null || application == null) {
            throw new IllegalArgumentException("context or Application must be not null.");
        }
        if (x97.x() && (h(application) || l(application) || D())) {
            Log.e("apminsight", "Inner npth checked.");
            return;
        }
        x97.c(application, context);
        if (z || z2) {
            st6 st6VarC = st6.c();
            if (z2) {
                st6VarC.g(new lz6(context));
            }
            if (z) {
                st6VarC.m(new m77(context));
            }
            b = true;
        }
        NativeImpl.loadLibrary();
        if (z3) {
            d = NativeImpl.startMonitorNativeCrash(context);
        }
        if (z4 && Looper.myLooper() == Looper.getMainLooper()) {
            f = true;
            NativeImpl.registerSignalMainThread();
        }
        t(z4);
        kj7.a("Npth.init takes " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
    }

    public static synchronized void c(Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Application applicationN;
        if (x97.n() != null) {
            applicationN = x97.n();
        } else if (context instanceof Application) {
            applicationN = (Application) context;
            if (applicationN.getBaseContext() == null) {
                throw new IllegalArgumentException("Application not attach.");
            }
        } else {
            applicationN = (Application) context.getApplicationContext();
            if (applicationN == null) {
                throw new IllegalArgumentException("no Application.");
            }
            if (applicationN.getBaseContext() != null) {
                context = applicationN.getBaseContext();
            }
        }
        b(applicationN, context, z, z2, z3, z4, j);
    }

    public static void d(ICrashCallback iCrashCallback, CrashType crashType) {
        a().b(iCrashCallback, crashType);
    }

    public static void e(IOOMCallback iOOMCallback) {
        a().c(iOOMCallback);
    }

    public static void f(IOOMCallback iOOMCallback, CrashType crashType) {
        a().f(iOOMCallback);
    }

    public static void g(boolean z) {
        x97.e(z);
    }

    public static boolean h(Context context) {
        try {
            return new File(wi7.E(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void i(ICrashCallback iCrashCallback, CrashType crashType) {
        a().e(iCrashCallback, crashType);
    }

    public static void j(boolean z) {
        x97.g(z);
    }

    public static boolean k() {
        return b;
    }

    public static boolean l(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libnpth.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void m(boolean z) {
        x97.i(z);
    }

    public static boolean n() {
        return c;
    }

    public static boolean o() {
        return d;
    }

    public static boolean r() {
        return f1973a;
    }

    public static void s() {
        if (!f1973a || b) {
            return;
        }
        Context contextM = x97.m();
        st6 st6VarC = st6.c();
        st6VarC.g(new lz6(contextM));
        st6VarC.m(new m77(contextM));
    }

    public static void t(boolean z) {
        ih7.b().f(new a(z), 0L);
    }

    public static void u() {
        if (f1973a) {
            u77.a(x97.m()).d();
            c = true;
        }
    }

    public static void v(boolean z) {
        Context contextM = x97.m();
        da7.d();
        NativeImpl.createCallbackThread();
        av6.a().c(contextM);
        de7.a(contextM);
        if (z) {
            u77.a(contextM).d();
            c = z;
            NativeImpl.startThreadForAnrMonitor();
        }
        ef7.g();
        NativeImpl.initPThreadDump();
        vi7.d("afterNpthInitAsync", "noValue");
    }

    public static boolean w() {
        if (f1973a && !d) {
            d = NativeImpl.startMonitorNativeCrash(x97.m());
        }
        return d;
    }

    public static boolean x() {
        return st6.n() || NativeImpl.duringNativeCrash();
    }

    public static boolean y() {
        return st6.t() || NativeImpl.duringNativeCrash();
    }

    public static boolean z() {
        return st6.n();
    }
}
