package com.bytedance.sdk.component.fx.nr;

import com.bytedance.sdk.component.fx.nr.u.u.b;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements Closeable, Flushable {
    final com.bytedance.sdk.component.fx.nr.u.u.b nr;
    final com.bytedance.sdk.component.fx.nr.u.u.iz u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends rh {
        private final String b;
        private final String fx;
        private final com.bytedance.sdk.component.fx.u.pn nr;
        final b.fx u;

        @Override // com.bytedance.sdk.component.fx.nr.rh
        public com.bytedance.sdk.component.fx.u.pn fx() {
            return this.nr;
        }

        @Override // com.bytedance.sdk.component.fx.nr.rh
        public long nr() {
            try {
                String str = this.b;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.rh
        public dw u() {
            String str = this.fx;
            if (str != null) {
                return dw.u(str);
            }
            return null;
        }
    }

    private void u(b.u uVar) {
        if (uVar != null) {
            try {
                uVar.fx();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nr.close();
    }

    public void delete() throws IOException {
        this.nr.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.nr.flush();
    }

    public void update(h hVar, h hVar2) {
        b.u uVarU;
        nr nrVar = new nr(hVar2);
        try {
            uVarU = ((u) hVar.n()).u.u();
            if (uVarU != null) {
                try {
                    nrVar.u(uVarU);
                    uVarU.nr();
                } catch (IOException unused) {
                    u(uVarU);
                }
            }
        } catch (IOException unused2) {
            uVarU = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final sx f5120a;
        private final sx b;
        private final String fx;
        private final qq iz;
        private final o jk;
        private final long l;
        private final String n;
        private final String pn;
        private final long t;
        private final int x;
        private static final String u = com.bytedance.sdk.component.fx.nr.u.x.pn.nr().fx() + "-Sent-Millis";
        private static final String nr = com.bytedance.sdk.component.fx.nr.u.x.pn.nr().fx() + "-Received-Millis";

        public nr(h hVar) {
            this.fx = hVar.u().u().toString();
            this.b = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(hVar);
            this.pn = hVar.u().nr();
            this.iz = hVar.nr();
            this.x = hVar.fx();
            this.n = hVar.pn();
            this.f5120a = hVar.x();
            this.jk = hVar.iz();
            this.t = hVar.mv();
            this.l = hVar.s();
        }

        public void u(b.u uVar) throws IOException {
            com.bytedance.sdk.component.fx.u.b bVarU = com.bytedance.sdk.component.fx.u.l.u(uVar.u(0));
            bVarU.nr(this.fx).a(10);
            bVarU.nr(this.pn).a(10);
            bVarU.l(this.b.u()).a(10);
            int iU = this.b.u();
            for (int i = 0; i < iU; i++) {
                bVarU.nr(this.b.u(i)).nr(": ").nr(this.b.nr(i)).a(10);
            }
            bVarU.nr(new com.bytedance.sdk.component.fx.nr.u.fx.t(this.iz, this.x, this.n).toString()).a(10);
            bVarU.l(this.f5120a.u() + 2).a(10);
            int iU2 = this.f5120a.u();
            for (int i2 = 0; i2 < iU2; i2++) {
                bVarU.nr(this.f5120a.u(i2)).nr(": ").nr(this.f5120a.nr(i2)).a(10);
            }
            bVarU.nr(u).nr(": ").l(this.t).a(10);
            bVarU.nr(nr).nr(": ").l(this.l).a(10);
            if (u()) {
                bVarU.a(10);
                bVarU.nr(this.jk.nr().u()).a(10);
                u(bVarU, this.jk.fx());
                u(bVarU, this.jk.b());
                bVarU.nr(this.jk.u().u()).a(10);
            }
            bVarU.close();
        }

        private boolean u() {
            return this.fx.startsWith("https://");
        }

        private void u(com.bytedance.sdk.component.fx.u.b bVar, List<Certificate> list) throws IOException {
            try {
                bVar.l(list.size()).a(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bVar.nr(com.bytedance.sdk.component.fx.u.iz.u(list.get(i).getEncoded()).nr()).a(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
