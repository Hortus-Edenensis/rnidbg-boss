package com.bytedance.sdk.component.fx.nr.u.pn;

import android.os.SystemClock;
import com.bytedance.sdk.component.fx.nr.u.pn.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements Closeable {
    static final /* synthetic */ boolean bg = true;
    static final ExecutorService u = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.fx.nr.u.fx.u("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final mv f5137a;
    private final ExecutorService bq;
    private int c;
    private Map<Integer, l> dw;
    final nr fx;
    int iz;
    final Socket k;
    final s mv;
    final jk my;
    boolean n;
    final boolean nr;
    final fx o;
    final String pn;
    boolean s;
    final Set<Integer> sx;
    long t;
    int x;
    final Map<Integer, a> b = new LinkedHashMap();
    long jk = 0;
    s l = new s();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class nr {
        public static final nr iz = new nr() { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.nr.1
            @Override // com.bytedance.sdk.component.fx.nr.u.pn.x.nr
            public void u(a aVar) throws IOException {
                aVar.u(com.bytedance.sdk.component.fx.nr.u.pn.nr.REFUSED_STREAM);
            }
        };

        public abstract void u(a aVar) throws IOException;

        public void u(x xVar) {
        }
    }

    public x(u uVar) {
        s sVar = new s();
        this.mv = sVar;
        this.s = false;
        this.sx = new LinkedHashSet();
        this.f5137a = uVar.iz;
        boolean z = uVar.x;
        this.nr = z;
        this.fx = uVar.pn;
        int i = z ? 1 : 2;
        this.x = i;
        if (z) {
            this.x = i + 2;
        }
        this.c = z ? 1 : 2;
        if (z) {
            this.l.u(7, 16777216);
        }
        String str = uVar.nr;
        this.pn = str;
        this.bq = new com.bytedance.sdk.component.jk.b.b(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.fx.nr.u.fx.u(com.bytedance.sdk.component.fx.nr.u.fx.u("OkHttp %s Push Observer", str), true));
        sVar.u(7, 65535);
        sVar.u(5, 16384);
        this.t = sVar.b();
        this.k = uVar.u;
        this.my = new jk(uVar.b, z);
        this.o = new fx(new n(uVar.fx, z));
    }

    public boolean b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u(com.bytedance.sdk.component.fx.nr.u.pn.nr.NO_ERROR, com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
    }

    public synchronized l fx(int i) {
        Map<Integer, l> map = this.dw;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public synchronized a nr(int i) {
        a aVarRemove;
        aVarRemove = this.b.remove(Integer.valueOf(i));
        notifyAll();
        return aVarRemove;
    }

    public synchronized a u(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public synchronized boolean b() {
        return this.n;
    }

    public void fx() throws IOException {
        u(true);
    }

    public synchronized int u() {
        return this.mv.fx(Integer.MAX_VALUE);
    }

    public void fx(final int i, final com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
        this.bq.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s Push Reset[%s]", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.7
            @Override // com.bytedance.sdk.component.fx.nr.u.nr
            public void fx() {
                synchronized (x.this) {
                    x.this.sx.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public a u(List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list, boolean z) throws IOException {
        return nr(0, list, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        com.bytedance.sdk.component.fx.u.b b;
        com.bytedance.sdk.component.fx.u.pn fx;
        String nr;
        Socket u;
        boolean x;
        nr pn = nr.iz;
        mv iz = mv.u;

        public u(boolean z) {
            this.x = z;
        }

        public u u(Socket socket, String str, com.bytedance.sdk.component.fx.u.pn pnVar, com.bytedance.sdk.component.fx.u.b bVar) {
            this.u = socket;
            this.nr = str;
            this.fx = pnVar;
            this.b = bVar;
            return this;
        }

        public u u(nr nrVar) {
            this.pn = nrVar;
            return this;
        }

        public x u() {
            return new x(this);
        }
    }

    private a nr(int i, List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list, boolean z) throws IOException {
        int i2;
        a aVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.my) {
            synchronized (this) {
                if (!this.n) {
                    i2 = this.x;
                    this.x = i2 + 2;
                    aVar = new a(i2, this, z3, false, list);
                    z2 = !z || this.t == 0 || aVar.nr == 0;
                    if (aVar.nr()) {
                        this.b.put(Integer.valueOf(i2), aVar);
                    }
                } else {
                    throw new com.bytedance.sdk.component.fx.nr.u.pn.u();
                }
            }
            if (i == 0) {
                this.my.u(z3, i2, i, list);
            } else if (!this.nr) {
                this.my.u(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.my.nr();
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.my.fx());
        r6 = r3;
        r8.t -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i, boolean z, com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
        int iMin;
        long j2;
        if (j == 0) {
            this.my.u(z, i, fxVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j3 = this.t;
                        if (j3 > 0) {
                            break;
                        } else if (this.b.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
            }
            j -= j2;
            this.my.u(z && j == 0, i, fxVar, iMin);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class fx extends com.bytedance.sdk.component.fx.nr.u.nr implements n.nr {
        final n u;

        public fx(n nVar) {
            super("OkHttp %s", x.this.pn);
            this.u = nVar;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.nr
        public void fx() throws Throwable {
            com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar;
            x xVar;
            com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar2 = com.bytedance.sdk.component.fx.nr.u.pn.nr.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.u.u(this);
                        while (this.u.u(false, (n.nr) this)) {
                        }
                        try {
                            x.this.u(com.bytedance.sdk.component.fx.nr.u.pn.nr.NO_ERROR, com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
                        } catch (IOException unused) {
                            nrVar = com.bytedance.sdk.component.fx.nr.u.pn.nr.PROTOCOL_ERROR;
                            xVar = x.this;
                            xVar.u(nrVar, nrVar);
                        } catch (NullPointerException unused2) {
                            nrVar = com.bytedance.sdk.component.fx.nr.u.pn.nr.PROTOCOL_ERROR;
                            xVar = x.this;
                            xVar.u(nrVar, nrVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            x.this.u(nrVar2, nrVar2);
                        } catch (Exception unused3) {
                        }
                        com.bytedance.sdk.component.fx.nr.u.fx.u(this.u);
                        throw th;
                    }
                } catch (IOException unused4) {
                } catch (NullPointerException unused5) {
                } catch (Throwable th2) {
                    th = th2;
                    x.this.u(nrVar2, nrVar2);
                    com.bytedance.sdk.component.fx.nr.u.fx.u(this.u);
                    throw th;
                }
            } catch (Exception unused6) {
            }
            com.bytedance.sdk.component.fx.nr.u.fx.u(this.u);
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(boolean z, int i, com.bytedance.sdk.component.fx.u.pn pnVar, int i2) throws IOException {
            if (x.this.b(i)) {
                x.this.u(i, pnVar, i2, z);
                return;
            }
            a aVarU = x.this.u(i);
            if (aVarU == null) {
                x.this.u(i, com.bytedance.sdk.component.fx.nr.u.pn.nr.PROTOCOL_ERROR);
                pnVar.n(i2);
            } else {
                aVarU.u(pnVar, i2);
                if (z) {
                    aVarU.a();
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(boolean z, int i, int i2, List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list) {
            if (x.this.b(i)) {
                x.this.u(i, list, z);
                return;
            }
            synchronized (x.this) {
                a aVarU = x.this.u(i);
                if (aVarU == null) {
                    x xVar = x.this;
                    if (xVar.n) {
                        return;
                    }
                    if (i <= xVar.iz) {
                        return;
                    }
                    if (i % 2 == xVar.x % 2) {
                        return;
                    }
                    final a aVar = new a(i, x.this, false, z, list);
                    x xVar2 = x.this;
                    xVar2.iz = i;
                    xVar2.b.put(Integer.valueOf(i), aVar);
                    try {
                        x.u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s stream %d", new Object[]{x.this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.fx.1
                            @Override // com.bytedance.sdk.component.fx.nr.u.nr
                            public void fx() {
                                try {
                                    x.this.fx.u(aVar);
                                } catch (IOException e) {
                                    com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(4, "Http2Connection.Listener failure for " + x.this.pn, e);
                                    try {
                                        aVar.u(com.bytedance.sdk.component.fx.nr.u.pn.nr.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                aVarU.u(list);
                if (z) {
                    aVarU.a();
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(int i, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
            if (x.this.b(i)) {
                x.this.fx(i, nrVar);
                return;
            }
            a aVarNr = x.this.nr(i);
            if (aVarNr != null) {
                aVarNr.fx(nrVar);
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(boolean z, s sVar) {
            a[] aVarArr;
            long j;
            int i;
            synchronized (x.this) {
                int iB = x.this.mv.b();
                if (z) {
                    x.this.mv.u();
                }
                x.this.mv.u(sVar);
                u(sVar);
                int iB2 = x.this.mv.b();
                aVarArr = null;
                if (iB2 == -1 || iB2 == iB) {
                    j = 0;
                } else {
                    j = iB2 - iB;
                    x xVar = x.this;
                    if (!xVar.s) {
                        xVar.u(j);
                        x.this.s = true;
                    }
                    if (!x.this.b.isEmpty()) {
                        aVarArr = (a[]) x.this.b.values().toArray(new a[x.this.b.size()]);
                    }
                }
                try {
                    x.u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s settings", x.this.pn) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.fx.2
                        @Override // com.bytedance.sdk.component.fx.nr.u.nr
                        public void fx() {
                            x xVar2 = x.this;
                            xVar2.fx.u(xVar2);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (aVarArr == null || j == 0) {
                return;
            }
            for (a aVar : aVarArr) {
                synchronized (aVar) {
                    aVar.u(j);
                }
            }
        }

        private void u(final s sVar) {
            try {
                x.u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s ACK Settings", new Object[]{x.this.pn}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.fx.3
                    @Override // com.bytedance.sdk.component.fx.nr.u.nr
                    public void fx() {
                        try {
                            x.this.my.u(sVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(boolean z, int i, int i2) {
            if (z) {
                l lVarFx = x.this.fx(i);
                if (lVarFx != null) {
                    lVarFx.nr();
                    return;
                }
                return;
            }
            x.this.u(true, i, i2, (l) null);
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(int i, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar, com.bytedance.sdk.component.fx.u.iz izVar) {
            a[] aVarArr;
            synchronized (x.this) {
                aVarArr = (a[]) x.this.b.values().toArray(new a[x.this.b.size()]);
                x.this.n = true;
            }
            for (a aVar : aVarArr) {
                if (aVar.u() > i && aVar.fx()) {
                    aVar.fx(com.bytedance.sdk.component.fx.nr.u.pn.nr.REFUSED_STREAM);
                    x.this.nr(aVar.u());
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(int i, long j) {
            if (i == 0) {
                synchronized (x.this) {
                    x xVar = x.this;
                    xVar.t += j;
                    xVar.notifyAll();
                }
                return;
            }
            a aVarU = x.this.u(i);
            if (aVarU != null) {
                synchronized (aVarU) {
                    aVarU.u(j);
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.n.nr
        public void u(int i, int i2, List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list) {
            x.this.u(i2, list);
        }
    }

    public void u(long j) {
        this.t += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void u(final int i, final com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) {
        try {
            u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s stream %d", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.1
                @Override // com.bytedance.sdk.component.fx.nr.u.nr
                public void fx() {
                    try {
                        x.this.nr(i, nrVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void u(final int i, final long j) {
        try {
            u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp Window Update %s stream %d", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.2
                @Override // com.bytedance.sdk.component.fx.nr.u.nr
                public void fx() {
                    try {
                        x.this.my.u(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void u(final boolean z, final int i, final int i2, final l lVar) {
        try {
            u.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s ping %08x%08x", new Object[]{this.pn, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.3
                @Override // com.bytedance.sdk.component.fx.nr.u.nr
                public void fx() {
                    try {
                        x.this.nr(z, i, i2, lVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void nr(int i, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) throws IOException {
        this.my.u(i, nrVar);
    }

    public void nr(boolean z, int i, int i2, l lVar) throws IOException {
        synchronized (this.my) {
            if (lVar != null) {
                lVar.u();
                this.my.u(z, i, i2);
            } else {
                this.my.u(z, i, i2);
            }
        }
    }

    public void u(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar) throws IOException {
        synchronized (this.my) {
            synchronized (this) {
                if (this.n) {
                    return;
                }
                this.n = true;
                this.my.u(this.iz, nrVar, com.bytedance.sdk.component.fx.nr.u.fx.u);
            }
        }
    }

    public void nr() throws IOException {
        this.my.nr();
    }

    public void u(com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar2) throws IOException {
        a[] aVarArr;
        if (!bg && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            u(nrVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.b.isEmpty()) {
                aVarArr = null;
            } else {
                aVarArr = (a[]) this.b.values().toArray(new a[this.b.size()]);
                this.b.clear();
            }
            Map<Integer, l> map = this.dw;
            if (map != null) {
                l[] lVarArr2 = (l[]) map.values().toArray(new l[this.dw.size()]);
                this.dw = null;
                lVarArr = lVarArr2;
            }
        }
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                try {
                    aVar.u(nrVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.fx();
            }
        }
        try {
            this.my.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.k.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void u(boolean z) throws IOException {
        if (z) {
            this.my.u();
            this.my.nr(this.l);
            if (this.l.b() != 65535) {
                this.my.u(0, r5 - 65535);
            }
        }
        com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(this.o, "Http2Connection");
        fxVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        fxVar.start();
    }

    public void u(final int i, final List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list) {
        synchronized (this) {
            if (this.sx.contains(Integer.valueOf(i))) {
                u(i, com.bytedance.sdk.component.fx.nr.u.pn.nr.PROTOCOL_ERROR);
            } else {
                this.sx.add(Integer.valueOf(i));
                this.bq.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s Push Request[%s]", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.4
                    @Override // com.bytedance.sdk.component.fx.nr.u.nr
                    public void fx() {
                        if (x.this.f5137a.u(i, list)) {
                            try {
                                x.this.my.u(i, com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
                                synchronized (x.this) {
                                    x.this.sx.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void u(final int i, final List<com.bytedance.sdk.component.fx.nr.u.pn.fx> list, final boolean z) {
        this.bq.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s Push Headers[%s]", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.5
            @Override // com.bytedance.sdk.component.fx.nr.u.nr
            public void fx() {
                boolean zU = x.this.f5137a.u(i, list, z);
                if (zU) {
                    try {
                        x.this.my.u(i, com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!zU && !z) {
                    return;
                }
                synchronized (x.this) {
                    x.this.sx.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public void u(final int i, com.bytedance.sdk.component.fx.u.pn pnVar, final int i2, final boolean z) throws IOException {
        final com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
        long j = i2;
        pnVar.u(j);
        pnVar.u(fxVar, j);
        if (fxVar.nr() == j) {
            this.bq.execute(new com.bytedance.sdk.component.fx.nr.u.nr("OkHttp %s Push Data[%s]", new Object[]{this.pn, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.fx.nr.u.pn.x.6
                @Override // com.bytedance.sdk.component.fx.nr.u.nr
                public void fx() {
                    try {
                        boolean zU = x.this.f5137a.u(i, fxVar, i2, z);
                        if (zU) {
                            x.this.my.u(i, com.bytedance.sdk.component.fx.nr.u.pn.nr.CANCEL);
                        }
                        if (!zU && !z) {
                            return;
                        }
                        synchronized (x.this) {
                            x.this.sx.remove(Integer.valueOf(i));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(fxVar.nr() + " != " + i2);
    }
}
