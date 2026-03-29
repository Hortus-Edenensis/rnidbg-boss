package com.bytedance.sdk.openadsdk.core.k;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Comparable {
    public static int b = 0;
    public static int fx = 3;
    public static int iz = 2;
    private static long k = 0;
    private static long my = 0;
    public static int nr = 2;
    private static int o = 0;
    public static int pn = 1;
    public static int u = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5292a;
    private long jk;
    private long l;
    private int mv;
    private long n;
    private long s;
    private long t;
    private long x;

    public static long b() {
        return my + x();
    }

    public static long fx() {
        return k + iz();
    }

    public static long iz() {
        long jJk = fx.pn().jk();
        long jCurrentTimeMillis = System.currentTimeMillis() - jJk;
        if (fx.pn().t() > jJk) {
            return 0L;
        }
        return jJk == 0 ? System.currentTimeMillis() - fx.pn().fx() : jCurrentTimeMillis;
    }

    public static int pn() {
        int i = o;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static long x() {
        long jT = fx.pn().t();
        if (fx.pn().jk() > jT) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jT;
        if (jT == 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    public long a() {
        return this.x;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        u uVar = (u) obj;
        return (this.x <= uVar.x && this.f5292a <= uVar.f5292a && this.jk <= uVar.jk) ? 0 : 1;
    }

    public long jk() {
        return this.n;
    }

    public long l() {
        return this.jk;
    }

    public int mv() {
        return this.mv;
    }

    public long n() {
        return this.s;
    }

    public long nr() {
        return this.l;
    }

    public long t() {
        return this.f5292a;
    }

    public long u() {
        return this.t;
    }

    public void nr(long j) {
        this.l = j;
    }

    public void pn(long j) {
        this.n = j;
    }

    public void u(long j) {
        this.t = j;
    }

    public static void u(int i) {
        nr nrVar = new nr();
        long jA = fx.pn().a();
        List<u> listU = nrVar.u(jA);
        Collections.sort(listU);
        HashSet hashSet = new HashSet();
        if (listU != null && !listU.isEmpty()) {
            k = 0L;
            my = 0L;
            o = 0;
            for (u uVar : listU) {
                if (uVar.mv() == nr) {
                    my += u(uVar, jA);
                } else if (uVar.mv() == fx) {
                    k += uVar.u();
                } else if (uVar.mv() == u && uVar.x == jA) {
                    hashSet.add(Long.valueOf(uVar.jk()));
                }
            }
        }
        o = hashSet.size();
        if (i == pn) {
            o = 1;
        }
        nrVar.u();
    }

    public void b(long j) {
        this.x = j;
    }

    public void fx(long j) {
        this.s = j;
    }

    public void nr(int i) {
        this.mv = i;
    }

    public void x(long j) {
        this.jk = j;
    }

    public void iz(long j) {
        this.f5292a = j;
    }

    private static long u(u uVar, long j) {
        long j2 = j - 518400000;
        long jN = uVar.n();
        if (jN - uVar.nr() >= j2) {
            return uVar.nr();
        }
        long j3 = jN - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static void u(int i, long j, long j2) {
        u uVar = new u();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jFx = fx.pn().fx();
        uVar.b(fx.pn().a());
        uVar.pn(jFx);
        uVar.nr(i);
        uVar.fx(jCurrentTimeMillis);
        if (i == u) {
            uVar.u(0L);
            uVar.nr(0L);
            uVar.x(0L);
            uVar.iz(0L);
        } else if (i == nr) {
            uVar.u(0L);
            uVar.nr(j2);
            uVar.x(0L);
            uVar.iz(jCurrentTimeMillis);
        } else if (i == fx) {
            uVar.u(j);
            uVar.nr(0L);
            uVar.x(jCurrentTimeMillis);
            uVar.iz(0L);
        }
        new nr().insert(uVar);
    }
}
