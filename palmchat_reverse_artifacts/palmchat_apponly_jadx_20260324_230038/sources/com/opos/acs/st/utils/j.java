package com.opos.acs.st.utils;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f7724a;
    private final ConcurrentHashMap<Integer, c> c = new ConcurrentHashMap<>();
    private final b b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f7725a;

        private a() {
            this.f7725a = new long[]{120000, 900000, 3600000, 10800000, 36000000};
        }

        @Override // com.opos.acs.st.utils.j.b
        public long a(int i) {
            int length = i - 1;
            long[] jArr = this.f7725a;
            if (length >= jArr.length) {
                length = jArr.length - 1;
            } else if (length < 0) {
                length = 0;
            }
            return jArr[length];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        long a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7726a = new AtomicInteger(0);
        private long b = System.currentTimeMillis();

        public int a() {
            return this.f7726a.get();
        }

        public void b() {
            this.f7726a.incrementAndGet();
            this.b = System.currentTimeMillis();
        }

        public long c() {
            return this.b;
        }

        public String toString() {
            return "RetryValue{mFailTimes=" + this.f7726a + ", mLastReportTime=" + this.b + '}';
        }
    }

    private j() {
    }

    public static j a() {
        if (f7724a == null) {
            synchronized (j.class) {
                if (f7724a == null) {
                    f7724a = new j();
                }
            }
        }
        return f7724a;
    }

    public void b(String str, String str2) {
        com.opos.cmn.an.f.a.b("TimerRetryManager", "removeRetry,value=" + this.c.remove(Integer.valueOf(Objects.hash(str, str2))) + ",dataType=" + str + ",url" + str2);
    }

    public boolean c(String str, String str2) {
        return this.c.get(Integer.valueOf(Objects.hash(str, str2))) != null;
    }

    public boolean d(String str, String str2) {
        c cVar = this.c.get(Integer.valueOf(Objects.hash(str, str2)));
        if (cVar == null) {
            return false;
        }
        int iA = cVar.a();
        long jC = cVar.c();
        long jA = this.b.a(iA);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - jC < jA;
        com.opos.cmn.an.f.a.a("TimerRetryManager", "needLimitRetry=" + z + ",dataType=" + str + ",url=" + str2 + ",nextPeriod=" + jA + ",lastReportTime=" + jC + ",curTime=" + jCurrentTimeMillis);
        return z;
    }

    public void a(String str, String str2) {
        int iHash = Objects.hash(str, str2);
        c cVar = this.c.get(Integer.valueOf(iHash));
        if (cVar == null) {
            cVar = new c();
            this.c.put(Integer.valueOf(iHash), cVar);
        }
        cVar.b();
        com.opos.cmn.an.f.a.a("TimerRetryManager", "addRetry,value=" + cVar + ",size=" + this.c.size() + ",dataType=" + str + ",url" + str2);
    }

    public boolean a(String str) {
        try {
            int iIntValue = Integer.valueOf(str).intValue();
            return iIntValue == 403 || iIntValue == 408 || iIntValue == 413 || iIntValue == 429 || iIntValue == 500 || iIntValue == 502 || iIntValue == 503 || iIntValue == 504;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TimerRetryManager", "isRetryCode error", th);
            return false;
        }
    }
}
