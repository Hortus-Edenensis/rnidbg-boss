package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ae f11399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f88a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f91a = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f90a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f89a = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements Runnable {
        /* JADX INFO: renamed from: a */
        public abstract String mo207a();
    }

    private ae(Context context) {
        this.f88a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.f91a.schedule(new b(aVar) { // from class: com.xiaomi.push.ae.2
            @Override // com.xiaomi.push.ae.b
            public void b() {
                synchronized (ae.this.f89a) {
                    ae.this.f90a.remove(super.f11402a.mo207a());
                }
            }
        }, i, TimeUnit.SECONDS);
        synchronized (this.f89a) {
            this.f90a.put(aVar.mo207a(), scheduledFutureSchedule);
        }
        return true;
    }

    public static ae a(Context context) {
        if (f11399a == null) {
            synchronized (ae.class) {
                if (f11399a == null) {
                    f11399a = new ae(context);
                }
            }
        }
        return f11399a;
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, final boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String strA = a(aVar.mo207a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ae.1
            @Override // com.xiaomi.push.ae.b
            public void a() {
                super.a();
            }

            @Override // com.xiaomi.push.ae.b
            public void b() {
                if (z) {
                    return;
                }
                ae.this.f88a.edit().putLong(strA, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long jAbs = Math.abs(System.currentTimeMillis() - this.f88a.getLong(strA, 0L)) / 1000;
            if (jAbs < i - i2) {
                i2 = (int) (((long) i) - jAbs);
            }
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.f91a.scheduleAtFixedRate(bVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f89a) {
                this.f90a.put(aVar.mo207a(), scheduledFutureScheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f91a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m154a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f89a) {
            scheduledFuture = this.f90a.get(aVar.mo207a());
        }
        return scheduledFuture;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m155a(String str) {
        synchronized (this.f89a) {
            ScheduledFuture scheduledFuture = this.f90a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f90a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f11402a;

        public b(a aVar) {
            this.f11402a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f11402a.run();
            b();
        }

        public void a() {
        }

        public void b() {
        }
    }
}
