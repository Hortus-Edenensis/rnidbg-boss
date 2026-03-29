package com.bytedance.sdk.component.jk.u;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.t;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Comparable<fx>, Runnable {
    private iz b;
    public final Runnable fx;
    private long n;
    public static final AtomicInteger u = new AtomicInteger(0);
    public static boolean nr = false;
    private boolean pn = true;
    private boolean iz = true;
    private final long x = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5149a = 0;
    private int jk = 0;

    public fx(Runnable runnable) {
        this.fx = runnable;
    }

    private void fx(boolean z) {
        iz izVar = this.b;
        if (izVar != null) {
            izVar.u(this, z);
        }
    }

    public int b() {
        return this.f5149a;
    }

    public void nr() {
        this.n = System.currentTimeMillis() - this.x;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(12:4|37|5|6|10|(1:12)(1:13)|14|(1:18)|39|19|22|(1:24)(2:25|(3:(1:33)(1:34)|35|36)(1:31)))(1:8)|9|10|(0)(0)|14|(2:16|18)|39|19|22|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        a aVar;
        int i;
        boolean zBq;
        long j;
        long j2;
        int activeCount;
        int i2;
        com.bytedance.sdk.component.b.x xVar;
        Thread threadCurrentThread = Thread.currentThread();
        int priority = threadCurrentThread.getPriority();
        Runnable runnable = this.fx;
        if (runnable instanceof a) {
            aVar = (a) runnable;
            int iMin = Math.min(aVar.getPriority(), 10);
            try {
                threadCurrentThread.setPriority(iMin);
                i = iMin;
            } catch (Throwable unused) {
                i = priority;
            }
            t tVar = t.nr;
            zBq = tVar.bq();
            if (zBq) {
                j = 0;
                j2 = 0;
                activeCount = 0;
                i2 = 0;
            } else {
                activeCount = tVar.a().getActiveCount();
                int activeCount2 = tVar.jk().getActiveCount();
                long jCurrentTimeMillis = System.currentTimeMillis();
                i2 = activeCount2;
                j = (jCurrentTimeMillis - this.n) - this.x;
                j2 = jCurrentTimeMillis;
            }
            this.fx.run();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
            if (!this.pn && this.f5149a == 2) {
                u.decrementAndGet();
            }
            threadCurrentThread.setPriority(priority);
            fx(false);
            if (zBq) {
                return;
            }
            if ((u(j) || jCurrentTimeMillis2 > t.nr.bg()) && (xVar = (com.bytedance.sdk.component.b.x) com.bytedance.sdk.openadsdk.ats.fx.u("event")) != null) {
                u(j, jCurrentTimeMillis2, aVar != null ? aVar.getName() : this.fx.getClass().getName(), i, activeCount, i2, xVar);
                return;
            }
            return;
        }
        aVar = null;
        i = priority;
        t tVar2 = t.nr;
        zBq = tVar2.bq();
        if (zBq) {
        }
        this.fx.run();
        long jCurrentTimeMillis22 = System.currentTimeMillis() - j2;
        if (!this.pn) {
            u.decrementAndGet();
        }
        threadCurrentThread.setPriority(priority);
        fx(false);
        if (zBq) {
        }
    }

    public void u(iz izVar) {
        this.b = izVar;
    }

    public void nr(boolean z) {
        this.iz = z;
    }

    public Runnable u() {
        return this.fx;
    }

    private boolean u(long j) {
        return this.jk == 1 ? j > t.nr.o() : j > t.nr.sx();
    }

    public boolean fx() {
        return this.iz;
    }

    private void u(long j, long j2, String str, int i, int i2, int i3, com.bytedance.sdk.component.b.x xVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.x);
            jSONObject.put("is_wrap", this.fx instanceof fx);
            jSONObject.put("is_oom", nr);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.n);
            jSONObject.put("pool_type", this.f5149a);
            jSONObject.put("origin_pool_type", this.jk);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, Thread.currentThread().getName());
            t tVar = t.nr;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", tVar.s());
            jSONObject.put("auto_size", com.bytedance.sdk.component.jk.x.pn());
            jSONObject.put("pri_task_in_little", u.get());
            jSONObject.put("core_count", tVar.n());
            jSONObject.put("max_pool_size", tVar.t());
            jSONObject.put("use_little_pool", tVar.my());
        } catch (Exception unused) {
        }
        xVar.onStatsEvent("task_run_cost", jSONObject);
    }

    public fx(Runnable runnable, iz izVar) {
        this.fx = runnable;
        this.b = izVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(fx fxVar) {
        Class<?> cls = this.fx.getClass();
        Class<?> cls2 = fxVar.fx.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.fx;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = fxVar.fx;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void u(boolean z) {
        this.pn = z;
    }

    public void u(int i) {
        int i2 = this.f5149a;
        if (i2 == 0) {
            this.jk = i;
        } else {
            this.jk = i2;
        }
        this.f5149a = i;
    }
}
