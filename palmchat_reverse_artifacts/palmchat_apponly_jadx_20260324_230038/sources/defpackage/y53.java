package defpackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class y53 {

    @GuardedBy("lock")
    public static int b = 0;

    @GuardedBy("lock")
    public static boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f22124a = new Object();

    @GuardedBy("lock")
    public static a d = a.f22125a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22125a = new C1290a();

        /* JADX INFO: renamed from: y53$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1290a implements a {
            @Override // y53.a
            public void d(String str, String str2) {
                Log.d(str, str2);
            }

            @Override // y53.a
            public void e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // y53.a
            public void i(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // y53.a
            public void w(String str, String str2) {
                Log.w(str, str2);
            }
        }

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static String a(String str, @Nullable Throwable th) {
        String strE = e(th);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace("\n", "\n  ") + '\n';
    }

    public static void b(@Size(max = 23) String str, String str2) {
        synchronized (f22124a) {
            if (b == 0) {
                d.d(str, str2);
            }
        }
    }

    public static void c(@Size(max = 23) String str, String str2) {
        synchronized (f22124a) {
            if (b <= 3) {
                d.e(str, str2);
            }
        }
    }

    public static void d(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        c(str, a(str2, th));
    }

    @Nullable
    public static String e(@Nullable Throwable th) {
        synchronized (f22124a) {
            if (th == null) {
                return null;
            }
            if (h(th)) {
                return "UnknownHostException (no network)";
            }
            if (c) {
                return Log.getStackTraceString(th).trim().replace("\t", "    ");
            }
            return th.getMessage();
        }
    }

    public static void f(@Size(max = 23) String str, String str2) {
        synchronized (f22124a) {
            if (b <= 1) {
                d.i(str, str2);
            }
        }
    }

    public static void g(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        f(str, a(str2, th));
    }

    public static boolean h(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void i(@Size(max = 23) String str, String str2) {
        synchronized (f22124a) {
            if (b <= 2) {
                d.w(str, str2);
            }
        }
    }

    public static void j(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        i(str, a(str2, th));
    }
}
