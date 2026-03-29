package com.bytedance.sdk.component.fx.nr;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.fx.nr.u.nr.x;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class jk {
    private static final Executor b = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.fx.nr.u.fx.u("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean fx = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f5123a;
    private long iz;
    private final Deque<com.bytedance.sdk.component.fx.nr.u.nr.fx> jk;
    private long n;
    boolean nr;
    private int pn;
    final com.bytedance.sdk.component.fx.nr.u.nr.b u;
    private List<String> x;

    public jk() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private boolean fx(com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar) {
        try {
            List<String> list = this.x;
            if (list != null && !list.isEmpty() && fxVar.u() != null && fxVar.u().u() != null && fxVar.u().u().u() != null && fxVar.u().u().u().x() != null) {
                String strX = fxVar.u().u().u().x();
                if (!TextUtils.isEmpty(strX)) {
                    if (this.x.contains(strX)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public boolean nr(com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar) {
        if (!fx && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (fxVar.u || this.pn == 0) {
            this.jk.remove(fxVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.pn;
                    }
                    this.pn = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.iz = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.iz;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.x = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.n = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public jk(int i, long j, TimeUnit timeUnit) {
        this.f5123a = new Runnable() { // from class: com.bytedance.sdk.component.fx.nr.jk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jU = jk.this.u(System.nanoTime());
                    if (jU == -1) {
                        return;
                    }
                    if (jU > 0) {
                        long j2 = jU / 1000000;
                        long j3 = jU - (1000000 * j2);
                        synchronized (jk.this) {
                            try {
                                jk.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.jk = new ArrayDeque();
        this.u = new com.bytedance.sdk.component.fx.nr.u.nr.b();
        this.pn = i;
        this.iz = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public com.bytedance.sdk.component.fx.nr.u.nr.fx u(u uVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar, ja jaVar) {
        if (!fx && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar : this.jk) {
            if (fxVar.u(uVar, jaVar)) {
                if (xVar != null) {
                    xVar.u(fxVar, true);
                }
                return fxVar;
            }
        }
        return null;
    }

    public Socket u(u uVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar) {
        if (!fx && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar : this.jk) {
            if (fxVar.u(uVar, null) && fxVar.pn() && fxVar != xVar.nr()) {
                return xVar.u(fxVar);
            }
        }
        return null;
    }

    public void u(com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar) {
        if (!fx && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.nr) {
            this.nr = true;
            b.execute(this.f5123a);
        }
        this.jk.add(fxVar);
    }

    public long u(long j) {
        try {
            synchronized (this) {
                com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar2 : this.jk) {
                    if (u(fxVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - fxVar2.pn;
                        com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar3 = fxVar;
                        if (this.n > 0 && fx(fxVar2)) {
                            j3 -= this.n;
                        }
                        if (j3 > j2) {
                            fxVar = fxVar2;
                            j2 = j3;
                        } else {
                            fxVar = fxVar3;
                        }
                    }
                }
                com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar4 = fxVar;
                long j4 = this.iz;
                if (j2 < j4 && i <= this.pn) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.nr = false;
                    return -1L;
                }
                this.jk.remove(fxVar4);
                com.bytedance.sdk.component.fx.nr.u.fx.u(fxVar4.fx());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.iz;
        }
    }

    private int u(com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar, long j) {
        List<Reference<com.bytedance.sdk.component.fx.nr.u.nr.x>> list = fxVar.b;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.component.fx.nr.u.nr.x> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u("A connection to " + fxVar.u().u().u() + " was leaked. Did you forget to close a response body?", ((x.u) reference).u);
                list.remove(i);
                fxVar.u = true;
                if (list.isEmpty()) {
                    fxVar.pn = j - this.iz;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
