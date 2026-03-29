package com.bytedance.sdk.component.fx.nr;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class kj implements pn {
    final boolean b;
    final z fx;
    private boolean iz;
    final com.bytedance.sdk.component.fx.nr.u.fx.jk nr;
    private my pn;
    final q u;

    /* JADX INFO: compiled from: SearchBox */
    public final class u extends com.bytedance.sdk.component.fx.nr.u.nr {
        private final iz fx;

        public u(iz izVar) {
            super("OkHttp %s", kj.this.n());
            this.fx = izVar;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.nr
        public void fx() {
            h hVarA;
            d dVar;
            boolean z = false;
            try {
                try {
                    try {
                        z zVar = kj.this.fx;
                        if (zVar != null && (dVar = zVar.iz) != null) {
                            dVar.u();
                        }
                        hVarA = kj.this.a();
                    } finally {
                        kj.this.u.bg().nr(this);
                    }
                } catch (IOException e) {
                    e = e;
                }
                try {
                    if (kj.this.nr.nr()) {
                        this.fx.u(kj.this, new IOException("Canceled"));
                    } else {
                        this.fx.u(kj.this, hVarA);
                    }
                    if (hVarA.fx == 0) {
                        throw new IOException(hVarA.b);
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = true;
                    if (z) {
                        com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(4, "Callback failure for " + kj.this.x(), e);
                    } else {
                        kj.this.pn.u(kj.this, e);
                        this.fx.u(kj.this, e);
                    }
                }
            } catch (Exception e3) {
                kj.this.pn.u(kj.this, new IOException(e3));
                this.fx.u(kj.this, new IOException(e3));
            }
        }

        public void nr() {
            d dVar;
            z zVar = kj.this.fx;
            if (zVar == null || (dVar = zVar.iz) == null) {
                return;
            }
            dVar.t();
        }

        public String u() {
            return kj.this.fx.u().x();
        }
    }

    private kj(q qVar, z zVar, boolean z) {
        this.u = qVar;
        this.fx = zVar;
        this.b = z;
        this.nr = new com.bytedance.sdk.component.fx.nr.u.fx.jk(qVar, z);
    }

    private void jk() {
        this.nr.u(com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u("response.body().close()"));
    }

    public h a() throws IOException {
        ArrayList arrayList = new ArrayList(this.u.c());
        arrayList.add(this.nr);
        arrayList.add(new com.bytedance.sdk.component.fx.nr.u.fx.u(this.u.iz()));
        arrayList.add(new com.bytedance.sdk.component.fx.nr.u.u.u(this.u.x()));
        arrayList.add(new com.bytedance.sdk.component.fx.nr.u.nr.u(this.u));
        if (!this.b) {
            arrayList.addAll(this.u.q());
        }
        arrayList.add(new com.bytedance.sdk.component.fx.nr.u.fx.nr(this.b));
        return new com.bytedance.sdk.component.fx.nr.u.fx.x(arrayList, null, null, null, 0, this.fx, this, this.pn, this.u.u(), this.u.nr(), this.u.fx()).u(this.fx);
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    public boolean b() {
        return this.nr.nr();
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    public void fx() {
        this.nr.u();
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    /* JADX INFO: renamed from: iz, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kj pn() {
        return u(this.u, this.fx, this.b);
    }

    public String n() {
        return this.fx.u().mv();
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    public h nr() throws IOException {
        synchronized (this) {
            if (this.iz) {
                throw new IllegalStateException("Already Executed");
            }
            this.iz = true;
        }
        jk();
        try {
            try {
                d dVar = this.fx.iz;
                if (dVar != null) {
                    dVar.u();
                }
                this.u.bg().u(this);
                h hVarA = a();
                if (hVarA == null) {
                    throw new IOException("Canceled");
                }
                if (hVarA.fx != 0) {
                    return hVarA;
                }
                throw new IOException(hVarA.b);
            } catch (IOException e) {
                this.pn.u(this, e);
                return null;
            } catch (Exception e2) {
                this.pn.u(this, new IOException(e2));
                return null;
            }
        } finally {
            this.u.bg().nr(this);
        }
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.b ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(n());
        return sb.toString();
    }

    public static kj u(q qVar, z zVar, boolean z) {
        kj kjVar = new kj(qVar, zVar, z);
        kjVar.pn = qVar.qq().u(kjVar);
        return kjVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    public z u() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.fx.nr.pn
    public void u(iz izVar) {
        try {
            synchronized (this) {
                if (!this.iz) {
                    this.iz = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            jk();
            this.u.bg().u(new u(izVar));
        } catch (Throwable th) {
            if (izVar != null) {
                izVar.u(this, new IOException(th.getMessage()));
            }
        }
    }
}
