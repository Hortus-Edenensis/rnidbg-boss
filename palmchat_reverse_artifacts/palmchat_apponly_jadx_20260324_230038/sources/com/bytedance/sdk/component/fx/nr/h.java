package com.bytedance.sdk.component.fx.nr;

import com.bytedance.sdk.component.fx.nr.sx;
import java.io.Closeable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h f5121a;
    final String b;
    final int fx;
    final sx iz;
    final h jk;
    final long l;
    private volatile b mv;
    final h n;
    final qq nr;
    final o pn;
    final long t;
    final z u;
    final rh x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f5122a;
        String b;
        int fx;
        sx.u iz;
        h jk;
        long l;
        h n;
        qq nr;
        o pn;
        long t;
        z u;
        rh x;

        public u() {
            this.fx = -1;
            this.iz = new sx.u();
        }

        private void b(h hVar) {
            if (hVar.x != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public u fx(h hVar) {
            if (hVar != null) {
                b(hVar);
            }
            this.jk = hVar;
            return this;
        }

        public u nr(h hVar) {
            if (hVar != null) {
                u("cacheResponse", hVar);
            }
            this.f5122a = hVar;
            return this;
        }

        public u u(z zVar) {
            this.u = zVar;
            return this;
        }

        public u u(qq qqVar) {
            this.nr = qqVar;
            return this;
        }

        public u nr(long j) {
            this.l = j;
            return this;
        }

        public u u(int i) {
            this.fx = i;
            return this;
        }

        public u(h hVar) {
            this.fx = -1;
            this.u = hVar.u;
            this.nr = hVar.nr;
            this.fx = hVar.fx;
            this.b = hVar.b;
            this.pn = hVar.pn;
            this.iz = hVar.iz.nr();
            this.x = hVar.x;
            this.n = hVar.n;
            this.f5122a = hVar.f5121a;
            this.jk = hVar.jk;
            this.t = hVar.t;
            this.l = hVar.l;
        }

        public u u(String str) {
            this.b = str;
            return this;
        }

        public u u(o oVar) {
            this.pn = oVar;
            return this;
        }

        public u u(String str, String str2) {
            this.iz.u(str, str2);
            return this;
        }

        public u u(sx sxVar) {
            this.iz = sxVar.nr();
            return this;
        }

        public u u(rh rhVar) {
            this.x = rhVar;
            return this;
        }

        public u u(h hVar) {
            if (hVar != null) {
                u("networkResponse", hVar);
            }
            this.n = hVar;
            return this;
        }

        private void u(String str, h hVar) {
            if (hVar.x == null) {
                if (hVar.n == null) {
                    if (hVar.f5121a == null) {
                        if (hVar.jk == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public u u(long j) {
            this.t = j;
            return this;
        }

        public h u() {
            if (this.u != null) {
                if (this.nr != null) {
                    if (this.fx >= 0) {
                        if (this.b != null) {
                            return new h(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.fx);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public h(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz.u();
        this.x = uVar.x;
        this.n = uVar.n;
        this.f5121a = uVar.f5122a;
        this.jk = uVar.jk;
        this.t = uVar.t;
        this.l = uVar.l;
    }

    public u a() {
        return new u(this);
    }

    public boolean b() {
        int i = this.fx;
        return i >= 200 && i < 300;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rh rhVar = this.x;
        if (rhVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        rhVar.close();
    }

    public int fx() {
        return this.fx;
    }

    public o iz() {
        return this.pn;
    }

    public h jk() {
        return this.n;
    }

    public d k() {
        z zVar = this.u;
        if (zVar == null) {
            return null;
        }
        return zVar.iz;
    }

    public b l() {
        b bVar = this.mv;
        if (bVar != null) {
            return bVar;
        }
        b bVarU = b.u(this.iz);
        this.mv = bVarU;
        return bVarU;
    }

    public long mv() {
        return this.t;
    }

    public rh n() {
        return this.x;
    }

    public qq nr() {
        return this.nr;
    }

    public String pn() {
        return this.b;
    }

    public long s() {
        return this.l;
    }

    public h t() {
        return this.jk;
    }

    public String toString() {
        return "Response{protocol=" + this.nr + ", code=" + this.fx + ", message=" + this.b + ", url=" + this.u.u() + '}';
    }

    public z u() {
        return this.u;
    }

    public sx x() {
        return this.iz;
    }

    public String u(String str) {
        return u(str, null);
    }

    public String u(String str, String str2) {
        String strU = this.iz.u(str);
        return strU != null ? strU : str2;
    }
}
