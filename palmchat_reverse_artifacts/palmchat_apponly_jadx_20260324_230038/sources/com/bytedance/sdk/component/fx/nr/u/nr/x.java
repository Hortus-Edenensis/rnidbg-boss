package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.ja;
import com.bytedance.sdk.component.fx.nr.jk;
import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.u.nr.iz;
import com.bytedance.sdk.component.fx.nr.u.pn.k;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    static final /* synthetic */ boolean b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iz f5132a;
    public final my fx;
    private ja iz;
    private int jk;
    private com.bytedance.sdk.component.fx.nr.u.fx.fx k;
    private boolean l;
    private boolean mv;
    private final Object n;
    public final com.bytedance.sdk.component.fx.nr.pn nr;
    private iz.u pn;
    private boolean s;
    private fx t;
    public final com.bytedance.sdk.component.fx.nr.u u;
    private final jk x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends WeakReference<x> {
        public final Object u;

        public u(x xVar, Object obj) {
            super(xVar);
            this.u = obj;
        }
    }

    public x(jk jkVar, com.bytedance.sdk.component.fx.nr.u uVar, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar, Object obj) throws IOException {
        this.x = jkVar;
        this.u = uVar;
        this.nr = pnVar;
        this.fx = myVar;
        this.f5132a = new iz(uVar, n(), pnVar, myVar);
        this.n = obj;
    }

    private b n() {
        return com.bytedance.sdk.component.fx.nr.u.u.u.u(this.x);
    }

    private Socket x() {
        if (!b && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        fx fxVar = this.t;
        if (fxVar == null || !fxVar.u) {
            return null;
        }
        return u(false, false, true);
    }

    public void b() {
        Socket socketU;
        synchronized (this.x) {
            socketU = u(true, false, false);
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketU);
    }

    public void fx() {
        Socket socketU;
        synchronized (this.x) {
            socketU = u(false, true, false);
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketU);
    }

    public boolean iz() {
        if (this.iz != null) {
            return true;
        }
        iz.u uVar = this.pn;
        return (uVar != null && uVar.u()) || this.f5132a.u();
    }

    public synchronized fx nr() {
        return this.t;
    }

    public void pn() {
        com.bytedance.sdk.component.fx.nr.u.fx.fx fxVar;
        fx fxVar2;
        synchronized (this.x) {
            this.s = true;
            fxVar = this.k;
            fxVar2 = this.t;
        }
        if (fxVar != null) {
            fxVar.fx();
        } else if (fxVar2 != null) {
            fxVar2.nr();
        }
    }

    public String toString() {
        fx fxVarNr = nr();
        return fxVarNr != null ? fxVarNr.toString() : this.u.toString();
    }

    public com.bytedance.sdk.component.fx.nr.u.fx.fx u(q qVar, bq.u uVar, boolean z) {
        try {
            com.bytedance.sdk.component.fx.nr.u.fx.fx fxVarU = u(uVar.nr(), uVar.fx(), uVar.b(), qVar.sx(), z).u(qVar, uVar, this);
            synchronized (this.x) {
                this.k = fxVarU;
            }
            return fxVarU;
        } catch (IOException e) {
            throw new pn(e);
        }
    }

    private void nr(fx fxVar) {
        int size = fxVar.b.size();
        for (int i = 0; i < size; i++) {
            if (fxVar.b.get(i).get() == this) {
                fxVar.b.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private fx u(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            fx fxVarU = u(i, i2, i3, z);
            synchronized (this.x) {
                if (fxVarU.nr == 0) {
                    return fxVarU;
                }
                if (fxVarU.u(z2)) {
                    return fxVarU;
                }
                b();
            }
        }
    }

    private fx u(int i, int i2, int i3, boolean z) throws Throwable {
        Socket socketX;
        fx fxVar;
        Socket socketU;
        ja jaVarNr;
        boolean z2;
        boolean z3;
        iz.u uVar;
        synchronized (this.x) {
            if (!this.mv) {
                if (this.k == null) {
                    if (!this.s) {
                        socketX = x();
                        fxVar = this.t;
                        socketU = null;
                        if (fxVar == null) {
                            fxVar = null;
                        }
                        if (fxVar == null) {
                            com.bytedance.sdk.component.fx.nr.u.u.u.u(this.x, this.u, this, null);
                            fx fxVar2 = this.t;
                            if (fxVar2 != null) {
                                fxVar = fxVar2;
                                z2 = true;
                                jaVarNr = null;
                            } else {
                                jaVarNr = this.iz;
                            }
                        } else {
                            jaVarNr = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketX);
        if (fxVar != null) {
            return fxVar;
        }
        if (jaVarNr != null || ((uVar = this.pn) != null && uVar.u())) {
            z3 = false;
        } else {
            this.pn = this.f5132a.nr();
            z3 = true;
        }
        synchronized (this.x) {
            if (this.s) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ja> listFx = this.pn.fx();
                int size = listFx.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    ja jaVar = listFx.get(i4);
                    com.bytedance.sdk.component.fx.nr.u.u.u.u(this.x, this.u, this, jaVar);
                    fx fxVar3 = this.t;
                    if (fxVar3 != null) {
                        this.iz = jaVar;
                        fxVar = fxVar3;
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z2) {
                if (jaVarNr == null) {
                    jaVarNr = this.pn.nr();
                }
                this.iz = jaVarNr;
                this.jk = 0;
                fxVar = new fx(this.x, jaVarNr);
                u(fxVar, false);
            }
        }
        if (z2) {
            return fxVar;
        }
        fxVar.u(i, i2, i3, z, this.nr, this.fx);
        n().nr(fxVar.u());
        synchronized (this.x) {
            this.l = true;
            com.bytedance.sdk.component.fx.nr.u.u.u.nr(this.x, fxVar);
            if (fxVar.pn()) {
                socketU = com.bytedance.sdk.component.fx.nr.u.u.u.u(this.x, this.u, this);
                fxVar = this.t;
            }
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketU);
        return fxVar;
    }

    public void u(boolean z, com.bytedance.sdk.component.fx.nr.u.fx.fx fxVar, long j, IOException iOException) {
        Socket socketU;
        synchronized (this.x) {
            if (fxVar != null) {
                if (fxVar == this.k) {
                    if (!z) {
                        this.t.nr++;
                    }
                    socketU = u(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.k + " but was " + fxVar);
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketU);
        if (iOException != null) {
            this.fx.u(this.nr, iOException);
        }
    }

    public com.bytedance.sdk.component.fx.nr.u.fx.fx u() {
        com.bytedance.sdk.component.fx.nr.u.fx.fx fxVar;
        synchronized (this.x) {
            fxVar = this.k;
        }
        return fxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Socket u(boolean z, boolean z2, boolean z3) {
        Socket socketFx;
        if (!b && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (z3) {
            this.k = null;
        }
        if (z2) {
            this.mv = true;
        }
        fx fxVar = this.t;
        if (fxVar == null) {
            return null;
        }
        if (z) {
            fxVar.u = true;
        }
        if (this.k != null) {
            return null;
        }
        if (!this.mv && !fxVar.u) {
            return null;
        }
        nr(fxVar);
        if (this.t.b.isEmpty()) {
            this.t.pn = System.nanoTime();
            socketFx = com.bytedance.sdk.component.fx.nr.u.u.u.u(this.x, this.t) ? this.t.fx() : null;
        }
        this.t = null;
        return socketFx;
    }

    public void u(IOException iOException) {
        boolean z;
        Socket socketU;
        synchronized (this.x) {
            if (iOException instanceof k) {
                com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar = ((k) iOException).u;
                com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar2 = com.bytedance.sdk.component.fx.nr.u.pn.nr.REFUSED_STREAM;
                if (nrVar == nrVar2) {
                    this.jk++;
                }
                if (nrVar != nrVar2 || this.jk > 1) {
                    this.iz = null;
                    z = true;
                }
                z = false;
            } else {
                fx fxVar = this.t;
                if (fxVar != null && (!fxVar.pn() || (iOException instanceof com.bytedance.sdk.component.fx.nr.u.pn.u))) {
                    if (this.t.nr == 0) {
                        ja jaVar = this.iz;
                        if (jaVar != null && iOException != null) {
                            this.f5132a.u(jaVar, iOException);
                        }
                        this.iz = null;
                    }
                    z = true;
                }
                z = false;
            }
            socketU = u(z, false, true);
        }
        com.bytedance.sdk.component.fx.nr.u.fx.u(socketU);
    }

    public void u(fx fxVar, boolean z) {
        if (!b && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (this.t == null) {
            this.t = fxVar;
            this.l = z;
            fxVar.b.add(new u(this, this.n));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket u(fx fxVar) {
        if (!b && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (this.k == null && this.t.b.size() == 1) {
            Reference<x> reference = this.t.b.get(0);
            Socket socketU = u(true, false, false);
            this.t = fxVar;
            fxVar.b.add(reference);
            return socketU;
        }
        throw new IllegalStateException();
    }
}
