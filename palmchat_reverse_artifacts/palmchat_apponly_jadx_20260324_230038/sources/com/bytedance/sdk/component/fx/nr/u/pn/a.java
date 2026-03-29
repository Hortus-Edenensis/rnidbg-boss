package com.bytedance.sdk.component.fx.nr.u.pn;

import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.bq;
import com.bytedance.sdk.component.fx.u.sx;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5133a = true;
    final x b;
    final int fx;
    private final List<com.bytedance.sdk.component.fx.nr.u.pn.fx> jk;
    private boolean l;
    private final nr mv;
    long nr;
    final u pn;
    private List<com.bytedance.sdk.component.fx.nr.u.pn.fx> t;
    long u = 0;
    final fx iz = new fx();
    final fx x = new fx();
    com.bytedance.sdk.component.fx.nr.u.pn.nr n = null;

    /* JADX INFO: compiled from: SearchBox */
    public class fx extends com.bytedance.sdk.component.fx.u.u {
        public fx() {
        }

        @Override // com.bytedance.sdk.component.fx.u.u
        public void e_() {
            a.this.nr(com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
        }

        public void n() throws IOException {
            if (nr()) {
                throw nr((IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.u
        public IOException nr(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(WkAdConfigModel.TAG_TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public a(int i, x xVar, boolean z, boolean z2, List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list) {
        if (xVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.fx = i;
        this.b = xVar;
        this.nr = xVar.mv.b();
        nr nrVar = new nr(xVar.l.b());
        this.mv = nrVar;
        u uVar = new u();
        this.pn = uVar;
        nrVar.nr = z2;
        uVar.nr = z;
        this.jk = list;
    }

    public void a() {
        boolean zNr;
        if (!f5133a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.mv.nr = true;
            zNr = nr();
            notifyAll();
        }
        if (zNr) {
            return;
        }
        this.b.nr(this.fx);
    }

    public synchronized List<com.bytedance.sdk.component.fx.nr.u.pn.fx> b() throws IOException {
        List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list;
        if (!fx()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.iz.u();
        while (this.t == null && this.n == null) {
            try {
                l();
            } catch (Throwable th) {
                this.iz.n();
                throw th;
            }
        }
        this.iz.n();
        list = this.t;
        if (list == null) {
            throw new k(this.n);
        }
        this.t = null;
        return list;
    }

    public boolean fx() {
        return this.b.nr == ((this.fx & 1) == 1);
    }

    public bq iz() {
        return this.x;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jk() throws IOException {
        boolean z;
        boolean zNr;
        if (!f5133a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            nr nrVar = this.mv;
            if (nrVar.nr || !nrVar.u) {
                z = false;
                zNr = nr();
            } else {
                u uVar = this.pn;
                if (uVar.nr || uVar.u) {
                    z = true;
                }
                zNr = nr();
            }
        }
        if (z) {
            u(com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
        } else {
            if (zNr) {
                return;
            }
            this.b.nr(this.fx);
        }
    }

    public void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public sx n() {
        synchronized (this) {
            if (!this.l && !fx()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.pn;
    }

    public synchronized boolean nr() {
        if (this.n != null) {
            return false;
        }
        nr nrVar = this.mv;
        if (nrVar.nr || nrVar.u) {
            u uVar = this.pn;
            if (uVar.nr || uVar.u) {
                if (this.l) {
                    return false;
                }
            }
        }
        return true;
    }

    public bq pn() {
        return this.iz;
    }

    public void t() throws IOException {
        u uVar = this.pn;
        if (uVar.u) {
            throw new IOException("stream closed");
        }
        if (uVar.nr) {
            throw new IOException("stream finished");
        }
        if (this.n != null) {
            throw new k(this.n);
        }
    }

    public int u() {
        return this.fx;
    }

    public bg x() {
        return this.mv;
    }

    public void u(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) throws IOException {
        if (b(nrVar)) {
            this.b.nr(this.fx, nrVar);
        }
    }

    public synchronized void fx(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
        if (this.n == null) {
            this.n = nrVar;
            notifyAll();
        }
    }

    public void u(List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list) {
        boolean zNr;
        if (!f5133a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zNr = true;
            this.l = true;
            if (this.t == null) {
                this.t = list;
                zNr = nr();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.t);
                arrayList.add(null);
                arrayList.addAll(list);
                this.t = arrayList;
            }
        }
        if (zNr) {
            return;
        }
        this.b.nr(this.fx);
    }

    public void nr(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
        if (b(nrVar)) {
            this.b.u(this.fx, nrVar);
        }
    }

    private boolean b(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
        if (!f5133a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.n != null) {
                return false;
            }
            if (this.mv.nr && this.pn.nr) {
                return false;
            }
            this.n = nrVar;
            notifyAll();
            this.b.nr(this.fx);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class u implements sx {
        static final /* synthetic */ boolean fx = true;
        boolean nr;
        private final com.bytedance.sdk.component.fx.u.fx pn = new com.bytedance.sdk.component.fx.u.fx();
        boolean u;

        public u() {
        }

        private void u(boolean z) throws IOException {
            a aVar;
            long jMin;
            a aVar2;
            synchronized (a.this) {
                a.this.x.u();
                while (true) {
                    try {
                        aVar = a.this;
                        if (aVar.nr > 0 || this.nr || this.u || aVar.n != null) {
                            break;
                        } else {
                            aVar.l();
                        }
                    } finally {
                    }
                }
                aVar.x.n();
                a.this.t();
                jMin = Math.min(a.this.nr, this.pn.nr());
                aVar2 = a.this;
                aVar2.nr -= jMin;
            }
            aVar2.x.u();
            try {
                a aVar3 = a.this;
                aVar3.b.u(aVar3.fx, z && jMin == this.pn.nr(), this.pn, jMin);
            } finally {
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public void a_(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (!fx && Thread.holdsLock(a.this)) {
                throw new AssertionError();
            }
            this.pn.a_(fxVar, j);
            while (this.pn.nr() >= 16384) {
                u(false);
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!fx && Thread.holdsLock(a.this)) {
                throw new AssertionError();
            }
            synchronized (a.this) {
                if (this.u) {
                    return;
                }
                if (!a.this.pn.nr) {
                    if (this.pn.nr() > 0) {
                        while (this.pn.nr() > 0) {
                            u(true);
                        }
                    } else {
                        a aVar = a.this;
                        aVar.b.u(aVar.fx, true, (com.bytedance.sdk.component.fx.u.fx) null, 0L);
                    }
                }
                synchronized (a.this) {
                    this.u = true;
                }
                a.this.b.nr();
                a.this.jk();
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
        public void flush() throws IOException {
            if (!fx && Thread.holdsLock(a.this)) {
                throw new AssertionError();
            }
            synchronized (a.this) {
                a.this.t();
            }
            while (this.pn.nr() > 0) {
                u(false);
                a.this.b.nr();
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public bq u() {
            return a.this.x;
        }
    }

    public void u(com.bytedance.sdk.component.fx.u.pn pnVar, int i) throws IOException {
        if (!f5133a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.mv.u(pnVar, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class nr implements bg {
        static final /* synthetic */ boolean fx = true;
        boolean nr;
        boolean u;
        private final long x;
        private final com.bytedance.sdk.component.fx.u.fx pn = new com.bytedance.sdk.component.fx.u.fx();
        private final com.bytedance.sdk.component.fx.u.fx iz = new com.bytedance.sdk.component.fx.u.fx();

        public nr(long j) {
            this.x = j;
        }

        private void fx() throws IOException {
            if (this.u) {
                throw new IOException("stream closed");
            }
            if (a.this.n != null) {
                throw new k(a.this.n);
            }
        }

        private void nr() throws IOException {
            a.this.iz.u();
            while (this.iz.nr() == 0 && !this.nr && !this.u) {
                try {
                    a aVar = a.this;
                    if (aVar.n != null) {
                        break;
                    } else {
                        aVar.l();
                    }
                } finally {
                    a.this.iz.n();
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (a.this) {
                this.u = true;
                this.iz.sx();
                a.this.notifyAll();
            }
            a.this.jk();
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (a.this) {
                nr();
                fx();
                if (this.iz.nr() == 0) {
                    return -1L;
                }
                com.bytedance.sdk.component.fx.u.fx fxVar2 = this.iz;
                long jU = fxVar2.u(fxVar, Math.min(j, fxVar2.nr()));
                a aVar = a.this;
                long j2 = aVar.u + jU;
                aVar.u = j2;
                if (j2 >= aVar.b.l.b() / 2) {
                    a aVar2 = a.this;
                    aVar2.b.u(aVar2.fx, aVar2.u);
                    a.this.u = 0L;
                }
                synchronized (a.this.b) {
                    x xVar = a.this.b;
                    long j3 = xVar.jk + jU;
                    xVar.jk = j3;
                    if (j3 >= xVar.l.b() / 2) {
                        x xVar2 = a.this.b;
                        xVar2.u(0, xVar2.jk);
                        a.this.b.jk = 0L;
                    }
                }
                return jU;
            }
        }

        public void u(com.bytedance.sdk.component.fx.u.pn pnVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!fx && Thread.holdsLock(a.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (a.this) {
                    z = this.nr;
                    z2 = true;
                    z3 = this.iz.nr() + j > this.x;
                }
                if (z3) {
                    pnVar.n(j);
                    a.this.nr(com.bytedance.sdk.component.fx.nr.u.pn.nr.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    pnVar.n(j);
                    return;
                }
                long jU = pnVar.u(this.pn, j);
                if (jU != -1) {
                    j -= jU;
                    synchronized (a.this) {
                        if (this.iz.nr() != 0) {
                            z2 = false;
                        }
                        this.iz.u(this.pn);
                        if (z2) {
                            a.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public bq u() {
            return a.this.iz;
        }
    }

    public void u(long j) {
        this.nr += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
