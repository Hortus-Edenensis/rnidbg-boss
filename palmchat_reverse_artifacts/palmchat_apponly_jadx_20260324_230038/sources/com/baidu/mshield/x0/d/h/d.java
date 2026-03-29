package com.baidu.mshield.x0.d.h;

import com.baidu.mshield.x0.EngineImpl;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f4062a = null;
    public static int b = Integer.MAX_VALUE;
    public static long c = 120;
    public ThreadPoolExecutor d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FileFilter {
        public a(d dVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public d() {
        int iA = (a() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iA > 5 ? 5 : iA, b, c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new c());
    }

    public static d b() {
        synchronized (d.class) {
            if (f4062a == null) {
                f4062a = new d();
            }
        }
        return f4062a;
    }

    public void a(com.baidu.mshield.x0.d.h.a aVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.d.execute(aVar);
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
        }
    }

    public void c() {
        try {
            this.d.shutdownNow();
            f4062a = null;
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
        }
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
