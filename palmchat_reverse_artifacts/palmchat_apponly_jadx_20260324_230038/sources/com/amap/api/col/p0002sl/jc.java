package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.jb;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jc extends je {
    private static Thread.UncaughtExceptionHandler c = new Thread.UncaughtExceptionHandler() { // from class: com.amap.api.col.2sl.jc.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            hd.c(th, "TPool", "ThreadPool");
        }
    };
    private static jc d = new jc(new jb.a().a(c).a("amap-global-threadPool").a());

    private jc(jb jbVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(jbVar.a(), jbVar.b(), jbVar.d(), TimeUnit.SECONDS, jbVar.c(), jbVar);
            this.f2926a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            hd.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static jc a() {
        return d;
    }
}
