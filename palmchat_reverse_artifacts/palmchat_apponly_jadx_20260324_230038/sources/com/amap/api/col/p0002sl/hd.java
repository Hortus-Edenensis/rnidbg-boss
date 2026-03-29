package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hd extends ha implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static WeakReference<Context> g;
    private Context d;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory h = new ThreadFactory() { // from class: com.amap.api.col.2sl.hd.2

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2860a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f2860a.getAndIncrement()) { // from class: com.amap.api.col.2sl.hd.2.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                    }
                }
            };
        }
    };

    private hd(Context context) {
        this.d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String string = defaultUncaughtExceptionHandler.toString();
            if (!string.startsWith("com.amap.apis.utils.core.dynamiccore") && (string.indexOf("com.amap.api") != -1 || string.indexOf("com.loc") != -1)) {
                this.c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void b() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            ExecutorService executorService = e;
            if (executorService != null) {
                executorService.shutdown();
            }
            hu.a();
        } finally {
        }
        try {
            if (ha.f2855a != null) {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                ha haVar = ha.f2855a;
                if (defaultUncaughtExceptionHandler == haVar && (uncaughtExceptionHandler = haVar.b) != null) {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
            }
            ha.f2855a = null;
        } catch (Throwable th) {
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            hb.a(g.get());
            return;
        }
        ha haVar = ha.f2855a;
        if (haVar != null) {
            haVar.a();
        }
    }

    public static synchronized hd d() {
        return (hd) ha.f2855a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.b.uncaughtException(thread, th);
        }
    }

    public static synchronized hd a(Context context, gd gdVar) throws fq {
        try {
            if (gdVar == null) {
                throw new fq("sdk info is null");
            }
            if (gdVar.a() == null || "".equals(gdVar.a())) {
                throw new fq("sdk name is invalid");
            }
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!f.add(Integer.valueOf(gdVar.hashCode()))) {
                return (hd) ha.f2855a;
            }
            ha haVar = ha.f2855a;
            if (haVar == null) {
                ha.f2855a = new hd(context);
            } else {
                haVar.c = false;
            }
            ha haVar2 = ha.f2855a;
            haVar2.a(gdVar, haVar2.c);
            return (hd) ha.f2855a;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            ha haVar = ha.f2855a;
            if (haVar != null) {
                haVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0002sl.ha
    public final void a(gd gdVar, String str, String str2) {
        he.a(gdVar, this.d, str2, str);
    }

    public final void b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0002sl.ha
    public final void a(Throwable th, int i, String str, String str2) {
        he.a(this.d, th, i, str, str2);
    }

    public static void b(gd gdVar, String str, String str2) {
        try {
            ha haVar = ha.f2855a;
            if (haVar != null) {
                haVar.a(gdVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0002sl.ha
    public final void a() {
        hb.a(this.d);
    }

    @Override // com.amap.api.col.p0002sl.ha
    public final void a(final gd gdVar, final boolean z) {
        try {
            jc.a().b(new jd() { // from class: com.amap.api.col.2sl.hd.1
                @Override // com.amap.api.col.p0002sl.jd
                public final void a() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            hb.a(gdVar);
                        }
                        if (z) {
                            he.a(hd.this.d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(gd gdVar, String str, String str2, String str3, String str4) {
        a(gdVar, str, str2, str3, "", str4);
    }

    public static void a(gd gdVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (ha.f2855a != null) {
                ha.f2855a.a(gdVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(gd gdVar, String str, fq fqVar) {
        if (fqVar != null) {
            a(gdVar, str, fqVar.c(), fqVar.d(), fqVar.e(), fqVar.b());
        }
    }
}
