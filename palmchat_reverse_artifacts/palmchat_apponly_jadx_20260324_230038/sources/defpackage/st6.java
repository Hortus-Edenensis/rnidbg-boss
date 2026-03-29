package defpackage;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.ICrashFilter;
import com.apm.lite.IOOMCallback;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.NativeImpl;
import defpackage.aa7;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class st6 implements Thread.UncaughtExceptionHandler {
    public static st6 l = null;
    public static volatile boolean m = false;
    public static volatile ThreadLocal<Boolean> n = new ThreadLocal<>();
    public static ArrayList<t07> o = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f20845a;
    public r37 b;
    public r37 c;
    public volatile int d = 0;
    public volatile int e = 0;
    public ConcurrentHashMap<String, Object> f = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    public Stack<Thread.UncaughtExceptionHandler> h = new Stack<>();
    public HashMap<Thread, Throwable> i = new HashMap<>();
    public volatile int j = 0;
    public Runnable k = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends aa7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20846a = false;

        public a() {
        }

        @Override // aa7.a
        public boolean a(String str) {
            if (!this.f20846a && str.contains("android.os.Looper.loop")) {
                this.f20846a = true;
            }
            return !this.f20846a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kj7.a("Recheck uncaught exception handler.");
            if (st6.this.j < 3) {
                st6.k(st6.this);
                st6.this.v();
                ih7.b().f(st6.this.k, 30000L);
            }
        }
    }

    public st6() {
        v();
        if (Npth.getConfigManager().isRegisterJavaCrashEnable()) {
            f(5000L);
        }
    }

    public static int b(Throwable th, Thread thread) {
        int iA = 0;
        for (int i = 0; i < o.size(); i++) {
            try {
                try {
                    iA |= o.get(i).a(th, thread);
                } catch (Throwable th2) {
                    n37.a();
                    n37.b("NPTH_CATCH", th2);
                }
            } catch (Throwable unused) {
            }
        }
        return iA;
    }

    public static st6 c() {
        if (l == null) {
            l = new st6();
        }
        return l;
    }

    public static /* synthetic */ int k(st6 st6Var) {
        int i = st6Var.j;
        st6Var.j = i + 1;
        return i;
    }

    public static Throwable l(Throwable th, Thread thread) {
        for (int i = 0; i < o.size(); i++) {
            try {
                try {
                    o.get(i).b(th, thread);
                } catch (Throwable th2) {
                    return th2;
                }
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th3) {
            return th3;
        }
    }

    public static boolean n() {
        return m;
    }

    public static boolean o(long j) {
        return z97.a(j);
    }

    public static boolean t() {
        Boolean bool = n.get();
        return bool != null && bool.booleanValue();
    }

    public final String d(File file, boolean z, Throwable th, String str, Thread thread, boolean z2) {
        String absolutePath = file.getAbsolutePath();
        this.g.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.doLock(absolutePath);
        } catch (Throwable unused) {
        }
        String strC = null;
        if (z2) {
            int iOpenFile = NativeImpl.openFile(absolutePath);
            if (iOpenFile > 0) {
                try {
                    NativeImpl.writeFile(iOpenFile, kv6.m(x97.m()));
                    NativeImpl.writeFile(iOpenFile, "\n");
                    NativeImpl.writeFile(iOpenFile, th.getMessage());
                    NativeImpl.writeFile(iOpenFile, "\n");
                    NativeImpl.writeFile(iOpenFile, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.writeFile(iOpenFile, ": ");
                        NativeImpl.writeFile(iOpenFile, th.getMessage());
                    }
                    NativeImpl.writeFile(iOpenFile, "\n");
                    NativeImpl.writeFile(iOpenFile, thread.getName());
                    NativeImpl.writeFile(iOpenFile, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.writeFile(iOpenFile, "stack:");
                    NativeImpl.writeFile(iOpenFile, "\n");
                } catch (Throwable unused3) {
                }
                yl7.k(th, iOpenFile);
                NativeImpl.closeFile(iOpenFile);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                if (nj7.c(32768)) {
                    throw new RuntimeException("test exception before write stack");
                }
                fileOutputStream.write((kv6.m(x97.m()) + "\n").getBytes());
                fileOutputStream.write((th.getMessage() + "\n").getBytes());
                fileOutputStream.write((th + "\n").getBytes());
                fileOutputStream.write((thread.getName() + "\n").getBytes());
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused4) {
                }
                try {
                } catch (Throwable th2) {
                    try {
                        if (nj7.c(16384)) {
                            throw new RuntimeException("test exception system write stack");
                        }
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused5) {
                        }
                    }
                }
                if (nj7.c(8192)) {
                    throw new RuntimeException("test exception npth write stack");
                }
                strC = yl7.c(th, thread, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new a() : new aa7.a());
                wf7.a(fileOutputStream);
                wf7.a(fileOutputStream);
            } catch (Throwable unused6) {
            }
        }
        return strC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0216 A[Catch: all -> 0x0241, TRY_LEAVE, TryCatch #0 {all -> 0x0241, blocks: (B:115:0x0210, B:117:0x0216), top: B:152:0x0210 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4 A[Catch: all -> 0x01fd, TryCatch #13 {all -> 0x01fd, blocks: (B:36:0x00b1, B:48:0x00e6, B:45:0x00c4, B:47:0x00c9, B:46:0x00c7), top: B:177:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[Catch: all -> 0x01fd, TryCatch #13 {all -> 0x01fd, blocks: (B:36:0x00b1, B:48:0x00e6, B:45:0x00c4, B:47:0x00c9, B:46:0x00c7), top: B:177:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[Catch: all -> 0x01f6, TryCatch #7 {all -> 0x01f6, blocks: (B:52:0x0100, B:53:0x0103, B:55:0x0109, B:57:0x0110, B:59:0x0115, B:58:0x0113), top: B:165:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0110 A[Catch: all -> 0x01f6, TryCatch #7 {all -> 0x01f6, blocks: (B:52:0x0100, B:53:0x0103, B:55:0x0109, B:57:0x0110, B:59:0x0115, B:58:0x0113), top: B:165:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0113 A[Catch: all -> 0x01f6, TryCatch #7 {all -> 0x01f6, blocks: (B:52:0x0100, B:53:0x0103, B:55:0x0109, B:57:0x0110, B:59:0x0115, B:58:0x0113), top: B:165:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c4  */
    /* JADX WARN: Type inference failed for: r1v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32, types: [r37] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [zu6] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Throwable e(Thread thread, Throwable th) {
        boolean zW;
        boolean z;
        long j;
        boolean z2;
        ?? r9;
        ?? r7;
        ?? r2;
        boolean z3;
        boolean z4;
        String strB;
        File file;
        Throwable th2;
        File file2;
        String str;
        String strD;
        String strB2;
        long j2;
        boolean z5;
        ?? r3;
        ?? A;
        ?? Q;
        r37 r37Var;
        String str2;
        long j3;
        boolean z6;
        ?? r32;
        ?? r22;
        ?? r1;
        ?? r12;
        if (this.d >= 3 && !nj7.c(65536)) {
            return null;
        }
        if (this.i.remove(thread) == th) {
            kj7.a("Jump this uncaught exception.");
            w(thread, th);
            return null;
        }
        this.i.put(thread, th);
        this.d++;
        this.e++;
        if (m) {
            n.set(Boolean.TRUE);
        }
        m = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zO = o(jCurrentTimeMillis);
        try {
            zW = yl7.w(th);
            if (zW) {
                try {
                    boolean z7 = yl7.x(th);
                    z = z7;
                } catch (Throwable unused) {
                    z = false;
                }
            }
        } catch (Throwable unused2) {
            zW = false;
        }
        try {
            try {
                strB = x97.b(jCurrentTimeMillis, zO ? CrashType.LAUNCH : CrashType.JAVA, zW, false);
                file = new File(wi7.b(x97.m()), strB);
                File file3 = new File(file, "logEventStack");
                th2 = th;
                file2 = file3;
                str = strB;
                strD = d(file3, zW, th2, str, thread, z);
            } catch (Throwable th3) {
                th = th3;
                j = jCurrentTimeMillis;
                z2 = zO;
                r9 = th;
                r7 = thread;
                r2 = 1;
                z3 = false;
                z4 = false;
            }
            if ((b(th, thread) & 1) != 0) {
                z4 = true;
                try {
                    if ((s07.f(th, thread, file) == null) || z4) {
                        strB2 = x97.b(jCurrentTimeMillis, !zO ? CrashType.LAUNCH : CrashType.JAVA, zW, true);
                        File file4 = new File(wi7.b(x97.m()), strB2);
                        file.renameTo(file4);
                        file2 = new File(file4, "logEventStack");
                    } else {
                        strB2 = strB;
                    }
                    vb7.b();
                    qz6.a().m();
                    z3 = z();
                    z5 = th2;
                    z5 = th2;
                    j2 = str;
                    j2 = str;
                    if (z && z3) {
                        boolean z8 = zO;
                        long j4 = jCurrentTimeMillis;
                        try {
                            i(thread, th, z8, j4);
                            z5 = z8;
                            j2 = j4;
                        } catch (Throwable th4) {
                            th = th4;
                            j = jCurrentTimeMillis;
                            z2 = zO;
                            r9 = th;
                            r7 = thread;
                            r2 = 1;
                            try {
                                if (!yl7.w(th)) {
                                }
                                if (!z4) {
                                }
                            } catch (Throwable th5) {
                                if (z4) {
                                    synchronized (this) {
                                        this.e -= r2;
                                        this.d -= r2;
                                        return l(r9, r7);
                                    }
                                }
                                if (z && !z3) {
                                    try {
                                        i(thread, th, z2, j);
                                    } catch (Throwable unused3) {
                                        throw th5;
                                    }
                                }
                                y();
                                x();
                                s(thread, th);
                                throw th5;
                            }
                        }
                    }
                    if (nj7.c(1)) {
                        this.g.clear();
                    }
                    CrashType crashType = !zO ? CrashType.LAUNCH : CrashType.JAVA;
                    StringBuilder sb = new StringBuilder();
                    r3 = "[uncaughtException] isLaunchCrash=";
                    sb.append("[uncaughtException] isLaunchCrash=");
                    sb.append(zO);
                    kj7.a(sb.toString());
                    A = zu6.a();
                    A.b(crashType, jCurrentTimeMillis, strB2);
                    Q = q(thread, th);
                    try {
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    j = jCurrentTimeMillis;
                    z2 = zO;
                    r9 = th;
                    r7 = thread;
                    r2 = 1;
                    z3 = false;
                }
                if (Q == 0) {
                    try {
                        r37Var = this.b;
                    } catch (Throwable th8) {
                        th = th8;
                        j = jCurrentTimeMillis;
                        z2 = zO;
                        r2 = 1;
                        r9 = th;
                        r7 = thread;
                        if (!yl7.w(th)) {
                        }
                        if (!z4) {
                        }
                    }
                    if (r37Var == null || !zO) {
                        j2 = jCurrentTimeMillis;
                        z5 = zO;
                        r3 = th;
                        A = 1;
                        r22 = 1;
                        A = 1;
                        if (Q != 0) {
                            try {
                                r12 = this.c;
                            } catch (Throwable th9) {
                                th = th9;
                                Q = thread;
                                r7 = Q;
                                r9 = r3;
                                r2 = A;
                                z2 = z5;
                                j = j2;
                                if (!yl7.w(th)) {
                                }
                                if (!z4) {
                                }
                            }
                            if (r12 != 0 && r12.a(r3)) {
                                Q = thread;
                                this.c.a(j2, thread, th, strB2, file2, strD, z4);
                                str2 = "[uncaughtException] mLaunchCrashDisposer " + th.toString();
                                r3 = r3;
                                z5 = z5;
                                j2 = j2;
                                kj7.a(str2);
                                r1 = Q;
                                r22 = A;
                                r32 = r3;
                                z6 = z5;
                                j3 = j2;
                                if (z4) {
                                    ?? r72 = r1;
                                    ?? r92 = r32;
                                    synchronized (this) {
                                        this.e -= r22;
                                        this.d -= r22;
                                    }
                                    return l(r92, r72);
                                }
                                if (z && !z3) {
                                    i(thread, th, z6, j3);
                                }
                                y();
                                x();
                                s(thread, th);
                            }
                        }
                        r1 = thread;
                        r32 = r3;
                        z6 = z5;
                        j3 = j2;
                        if (z4) {
                        }
                    } else {
                        if (r37Var.a(th)) {
                            try {
                                j2 = jCurrentTimeMillis;
                                z5 = zO;
                                A = 1;
                                r3 = th;
                                Q = thread;
                                this.b.a(jCurrentTimeMillis, thread, th, strB2, file2, strD, z4);
                                str2 = "[uncaughtException] mLaunchCrashDisposer " + th.toString();
                                kj7.a(str2);
                                r1 = Q;
                                r22 = A;
                                r32 = r3;
                                z6 = z5;
                                j3 = j2;
                                if (z4) {
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                j2 = jCurrentTimeMillis;
                                z5 = zO;
                                r3 = th;
                                Q = thread;
                                A = 1;
                                r7 = Q;
                                r9 = r3;
                                r2 = A;
                                z2 = z5;
                                j = j2;
                                if (!yl7.w(th)) {
                                    kj7.f(th);
                                }
                                if (!z4) {
                                    synchronized (this) {
                                        this.e -= r2;
                                        this.d -= r2;
                                    }
                                    return l(r9, r7);
                                }
                                if (z && !z3) {
                                    i(thread, th, z2, j);
                                }
                                y();
                            }
                        }
                        x();
                        s(thread, th);
                    }
                }
            } else {
                if (strD != null) {
                    if (x97.o().isCrashIgnored(strD)) {
                    }
                    if (s07.f(th, thread, file) == null) {
                        strB2 = x97.b(jCurrentTimeMillis, !zO ? CrashType.LAUNCH : CrashType.JAVA, zW, true);
                        File file42 = new File(wi7.b(x97.m()), strB2);
                        file.renameTo(file42);
                        file2 = new File(file42, "logEventStack");
                        vb7.b();
                        qz6.a().m();
                        z3 = z();
                        z5 = th2;
                        z5 = th2;
                        j2 = str;
                        j2 = str;
                        if (z) {
                            boolean z82 = zO;
                            long j42 = jCurrentTimeMillis;
                            i(thread, th, z82, j42);
                            z5 = z82;
                            j2 = j42;
                        }
                        if (nj7.c(1)) {
                        }
                        if (!zO) {
                        }
                        StringBuilder sb2 = new StringBuilder();
                        r3 = "[uncaughtException] isLaunchCrash=";
                        sb2.append("[uncaughtException] isLaunchCrash=");
                        sb2.append(zO);
                        kj7.a(sb2.toString());
                        A = zu6.a();
                        A.b(crashType, jCurrentTimeMillis, strB2);
                        Q = q(thread, th);
                        if (Q == 0) {
                        }
                    }
                }
                z4 = false;
                if (s07.f(th, thread, file) == null) {
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    public void f(long j) {
        ih7.b().j(this.k);
        ih7.b().f(this.k, j);
    }

    public void g(r37 r37Var) {
        this.b = r37Var;
    }

    public void h(String str) {
        this.f.put(str, new Object());
    }

    public final void i(Thread thread, Throwable th, boolean z, long j) {
        List<IOOMCallback> listA = cg7.a().a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        Iterator<IOOMCallback> it = listA.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(crashType, th, thread, j);
            } catch (Throwable th2) {
                kj7.g(th2);
            }
        }
    }

    public void j(Thread thread, Throwable th, boolean z, ev6 ev6Var) {
        List<ICrashCallback> listG;
        CrashType crashType;
        if (z) {
            listG = cg7.a().d();
            crashType = CrashType.LAUNCH;
        } else {
            listG = cg7.a().g();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : listG) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                iCrashCallback.onCrash(crashType, yl7.b(th), thread);
                ev6Var.q("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            } catch (Throwable th2) {
                kj7.g(th2);
                ev6Var.q("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public void m(r37 r37Var) {
        this.c = r37Var;
    }

    public boolean p(String str) {
        return this.f.containsKey(str);
    }

    public final boolean q(Thread thread, Throwable th) {
        ICrashFilter iCrashFilterC = x97.f().c();
        if (iCrashFilterC == null) {
            return true;
        }
        try {
            return iCrashFilterC.onJavaCrashFilter(th, thread);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void s(Thread thread, Throwable th) {
        if (nj7.c(512)) {
            return;
        }
        w(thread, th);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        do {
            th = e(thread, th);
        } while (th != null);
    }

    public final void v() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            if (defaultUncaughtExceptionHandler != null) {
                kj7.a("Put this uncaught exception handler to stack. " + defaultUncaughtExceptionHandler.getClass().getName());
                this.h.push(defaultUncaughtExceptionHandler);
            }
            this.f20845a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final void w(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandlerPop;
        try {
            if (!this.h.isEmpty() && (uncaughtExceptionHandlerPop = this.h.pop()) != null) {
                this.f20845a = uncaughtExceptionHandlerPop;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f20845a;
            if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
                kj7.a("mDefaultHandler != null, call mDefaultHandler.");
                this.f20845a.uncaughtException(thread, th);
                return;
            }
        } catch (Throwable unused) {
        }
        kj7.a("Uncaught exception handler null, kill process.");
        Process.killProcess(Process.myPid());
    }

    public final void x() {
        synchronized (this) {
            this.e--;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (this.e != 0 && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            SystemClock.sleep(50L);
        }
    }

    public final void y() {
        File fileB = wi7.b(x97.m());
        File fileA = wi7.a();
        if (re7.x(fileB) && re7.x(fileA)) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!de7.c() && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean z() {
        return nv6.b("exception_modules", "oom_callback") == 1;
    }
}
