package com.bytedance.sdk.component.fx.nr.u.pn;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.fx.nr.sx;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class iz implements com.bytedance.sdk.component.fx.nr.u.fx.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.sdk.component.fx.u.iz f5136a;
    private static final com.bytedance.sdk.component.fx.u.iz b;
    private static final com.bytedance.sdk.component.fx.u.iz fx;
    private static final com.bytedance.sdk.component.fx.u.iz iz;
    private static final List<com.bytedance.sdk.component.fx.u.iz> jk;
    private static final com.bytedance.sdk.component.fx.u.iz n;
    private static final com.bytedance.sdk.component.fx.u.iz nr;
    private static final com.bytedance.sdk.component.fx.u.iz pn;
    private static final List<com.bytedance.sdk.component.fx.u.iz> t;
    private static final com.bytedance.sdk.component.fx.u.iz x;
    private a k;
    private final q l;
    private final bq.u mv;
    private final x s;
    final com.bytedance.sdk.component.fx.nr.u.nr.x u;

    static {
        com.bytedance.sdk.component.fx.u.iz izVarU = com.bytedance.sdk.component.fx.u.iz.u("connection");
        nr = izVarU;
        com.bytedance.sdk.component.fx.u.iz izVarU2 = com.bytedance.sdk.component.fx.u.iz.u("host");
        fx = izVarU2;
        com.bytedance.sdk.component.fx.u.iz izVarU3 = com.bytedance.sdk.component.fx.u.iz.u("keep-alive");
        b = izVarU3;
        com.bytedance.sdk.component.fx.u.iz izVarU4 = com.bytedance.sdk.component.fx.u.iz.u("proxy-connection");
        pn = izVarU4;
        com.bytedance.sdk.component.fx.u.iz izVarU5 = com.bytedance.sdk.component.fx.u.iz.u("transfer-encoding");
        iz = izVarU5;
        com.bytedance.sdk.component.fx.u.iz izVarU6 = com.bytedance.sdk.component.fx.u.iz.u("te");
        x = izVarU6;
        com.bytedance.sdk.component.fx.u.iz izVarU7 = com.bytedance.sdk.component.fx.u.iz.u("encoding");
        n = izVarU7;
        com.bytedance.sdk.component.fx.u.iz izVarU8 = com.bytedance.sdk.component.fx.u.iz.u("upgrade");
        f5136a = izVarU8;
        jk = com.bytedance.sdk.component.fx.nr.u.fx.u(izVarU, izVarU2, izVarU3, izVarU4, izVarU6, izVarU5, izVarU7, izVarU8, fx.fx, fx.b, fx.pn, fx.iz);
        t = com.bytedance.sdk.component.fx.nr.u.fx.u(izVarU, izVarU2, izVarU3, izVarU4, izVarU6, izVarU5, izVarU7, izVarU8);
    }

    public iz(q qVar, bq.u uVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar, x xVar2) {
        this.l = qVar;
        this.mv = uVar;
        this.u = xVar;
        this.s = xVar2;
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void fx() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.nr(nr.CANCEL);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void nr() throws IOException {
        this.k.n().close();
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public sx u(z zVar, long j) {
        return this.k.n();
    }

    public static List<fx> nr(z zVar) {
        com.bytedance.sdk.component.fx.nr.sx sxVarFx = zVar.fx();
        ArrayList arrayList = new ArrayList(sxVarFx.u() + 4);
        arrayList.add(new fx(fx.fx, zVar.nr()));
        arrayList.add(new fx(fx.b, com.bytedance.sdk.component.fx.nr.u.fx.a.u(zVar.u())));
        String strU = zVar.u("Host");
        if (strU != null) {
            arrayList.add(new fx(fx.iz, strU));
        }
        arrayList.add(new fx(fx.pn, zVar.u().fx()));
        int iU = sxVarFx.u();
        for (int i = 0; i < iU; i++) {
            com.bytedance.sdk.component.fx.u.iz izVarU = com.bytedance.sdk.component.fx.u.iz.u(sxVarFx.u(i).toLowerCase(Locale.US));
            if (!jk.contains(izVarU)) {
                arrayList.add(new fx(izVarU, sxVarFx.nr(i)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void u(z zVar) throws IOException {
        if (this.k != null) {
            return;
        }
        a aVarU = this.s.u(nr(zVar), zVar.b() != null);
        this.k = aVarU;
        com.bytedance.sdk.component.fx.u.bq bqVarPn = aVarU.pn();
        long jFx = this.mv.fx();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bqVarPn.u(jFx, timeUnit);
        this.k.iz().u(this.mv.b(), timeUnit);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends com.bytedance.sdk.component.fx.u.n {
        long nr;
        boolean u;

        public u(bg bgVar) {
            super(bgVar);
            this.u = false;
            this.nr = 0L;
        }

        @Override // com.bytedance.sdk.component.fx.u.n, com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            u(null);
        }

        @Override // com.bytedance.sdk.component.fx.u.n, com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            try {
                long jU = nr().u(fxVar, j);
                if (jU > 0) {
                    this.nr += jU;
                }
                return jU;
            } catch (IOException e) {
                u(e);
                throw e;
            }
        }

        private void u(IOException iOException) {
            if (this.u) {
                return;
            }
            this.u = true;
            iz izVar = iz.this;
            izVar.u.u(false, (com.bytedance.sdk.component.fx.nr.u.fx.fx) izVar, this.nr, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void u() throws IOException {
        this.s.nr();
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public h.u u(boolean z) throws IOException {
        h.u uVarU = u(this.k.b());
        if (z && com.bytedance.sdk.component.fx.nr.u.u.u.u(uVarU) == 100) {
            return null;
        }
        return uVarU;
    }

    public static h.u u(List<fx> list) throws IOException {
        sx.u uVar = new sx.u();
        int size = list.size();
        com.bytedance.sdk.component.fx.nr.u.fx.t tVarU = null;
        for (int i = 0; i < size; i++) {
            fx fxVar = list.get(i);
            if (fxVar == null) {
                if (tVarU != null && tVarU.nr == 100) {
                    uVar = new sx.u();
                    tVarU = null;
                }
            } else {
                com.bytedance.sdk.component.fx.u.iz izVar = fxVar.x;
                String strU = fxVar.n.u();
                if (izVar.equals(fx.nr)) {
                    tVarU = com.bytedance.sdk.component.fx.nr.u.fx.t.u("HTTP/1.1 ".concat(String.valueOf(strU)));
                } else if (!t.contains(izVar)) {
                    com.bytedance.sdk.component.fx.nr.u.u.u.u(uVar, izVar.u(), strU);
                }
            }
        }
        if (tVarU != null) {
            return new h.u().u(qq.HTTP_2).u(tVarU.nr).u(tVarU.fx).u(uVar.u());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public rh u(h hVar) throws IOException {
        return new com.bytedance.sdk.component.fx.nr.u.fx.n(hVar.u("Content-Type"), com.bytedance.sdk.component.fx.nr.u.fx.pn.u(hVar), com.bytedance.sdk.component.fx.u.l.u(new u(this.k.x())));
    }
}
