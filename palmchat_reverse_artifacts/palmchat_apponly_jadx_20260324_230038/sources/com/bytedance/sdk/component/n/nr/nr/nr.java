package com.bytedance.sdk.component.n.nr.nr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.n.nr.fx.fx;
import com.bytedance.sdk.component.n.u.a;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.pn;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements a {
    private volatile Handler iz;
    private volatile com.bytedance.sdk.component.n.nr.nr.fx.nr pn;
    private pn x;
    public static final com.bytedance.sdk.component.n.nr.nr.u.u u = new com.bytedance.sdk.component.n.nr.nr.u.u();
    public static final long fx = System.currentTimeMillis();
    public static long b = 0;
    public volatile int nr = 0;
    private final Comparator<com.bytedance.sdk.component.n.u.nr> n = new Comparator<com.bytedance.sdk.component.n.u.nr>() { // from class: com.bytedance.sdk.component.n.nr.nr.nr.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.n.u.nr nrVar, com.bytedance.sdk.component.n.u.nr nrVar2) {
            return nr.this.u(nrVar, nrVar2);
        }
    };

    public nr(pn pnVar) {
        this.x = pnVar;
    }

    public boolean b() {
        return this.nr == 2;
    }

    public boolean fx() {
        return this.nr == 1;
    }

    @Override // com.bytedance.sdk.component.n.u.a
    public void nr() {
        pn pnVar = this.x;
        if (pnVar == null || pnVar.b() == null) {
            return;
        }
        b bVarB = pnVar.b();
        final com.bytedance.sdk.component.n.nr.nr.fx.nr nrVar = this.pn;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (nrVar != null) {
                nrVar.u(72, "start_child2");
            }
        } else {
            Executor executorIz = bVarB.iz();
            if (executorIz == null) {
                executorIz = bVarB.x();
            }
            if (executorIz == null) {
                return;
            }
            executorIz.execute(new com.bytedance.sdk.component.n.nr.pn.nr("flush") { // from class: com.bytedance.sdk.component.n.nr.nr.nr.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.n.nr.nr.fx.nr nrVar2 = nrVar;
                    if (nrVar2 != null) {
                        nrVar2.u(72, "start_child1");
                    }
                }
            });
        }
    }

    public com.bytedance.sdk.component.n.nr.nr.fx.nr pn() {
        return this.pn;
    }

    public void u(int i) {
        this.nr = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(com.bytedance.sdk.component.n.u.nr nrVar, com.bytedance.sdk.component.n.u.nr nrVar2) {
        long jU;
        long jNr;
        long jNr2;
        long jU2;
        if (nrVar == null) {
            return nrVar2 == null ? 0 : -1;
        }
        if (nrVar2 == null) {
            return 1;
        }
        if (nrVar.pn() == nrVar2.pn()) {
            if (nrVar.u() != null) {
                jU = nrVar.u().u();
                jNr = nrVar.u().nr();
            } else {
                jU = 0;
                jNr = 0;
            }
            if (nrVar2.u() != null) {
                jU2 = nrVar2.u().u();
                jNr2 = nrVar2.u().nr();
            } else {
                jNr2 = 0;
                jU2 = 0;
            }
            if (jU == 0 || jU2 == 0) {
                return 0;
            }
            long j = jU - jU2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jNr == 0 || jNr2 == 0) {
                return 0;
            }
            return (int) (jNr - jNr2);
        }
        return nrVar.pn() - nrVar2.pn();
    }

    @Override // com.bytedance.sdk.component.n.u.a
    public void u() {
        pn pnVar = this.x;
        if (pnVar == null) {
            return;
        }
        u(pnVar.pn());
        nr();
    }

    public void u(Handler handler) {
        this.iz = handler;
    }

    public boolean u(String str) {
        try {
            if (this.pn != null || com.bytedance.sdk.component.n.nr.u.u(str) || this.x == null) {
                return false;
            }
            synchronized (this) {
                if (this.pn != null) {
                    return false;
                }
                this.pn = new com.bytedance.sdk.component.n.nr.nr.fx.nr(this.x, this);
                this.pn.iz();
                return true;
            }
        } catch (Throwable th) {
            fx.u(th.getMessage(), this.x);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.n.u.a
    public void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        pn pnVar;
        if (nrVar != null && (pnVar = this.x) != null) {
            String strPn = pnVar.pn();
            nrVar.u(System.currentTimeMillis());
            u(strPn);
            b bVarB = this.x.b();
            com.bytedance.sdk.component.n.nr.nr.fx.nr nrVar2 = this.pn;
            if (nrVar2 != null) {
                u(bVarB, nrVar);
                nrVar2.u(nrVar, nrVar.pn() == 4);
                return;
            }
            return;
        }
        fx.nr("error : log config is null", this.x);
    }

    private void u(final b bVar, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (bVar != null) {
            try {
                if (bVar.a()) {
                    final long jNr = (nrVar == null || nrVar.u() == null) ? 0L : nrVar.u().nr();
                    if (jNr == 1) {
                        b = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongO = u.o();
                    com.bytedance.sdk.component.n.nr.fx.nr.u(atomicLongO, 1, this.x);
                    if (atomicLongO.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorIz = bVar.iz();
                            if (executorIz == null) {
                                executorIz = bVar.x();
                            }
                            if (executorIz != null) {
                                executorIz.execute(new com.bytedance.sdk.component.n.nr.pn.nr("report") { // from class: com.bytedance.sdk.component.n.nr.nr.nr.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        nr.this.u(bVar, jNr);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        u(bVar, jNr);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(b bVar, long j) {
        com.bytedance.sdk.component.n.nr.nr.fx.nr nrVar = this.pn;
        if (bVar == null || nrVar == null) {
            return;
        }
        com.bytedance.sdk.component.n.nr.nr.u.u uVar = u;
        nrVar.u(bVar.u(uVar.u(j, this.x)), true);
        uVar.iz();
    }
}
