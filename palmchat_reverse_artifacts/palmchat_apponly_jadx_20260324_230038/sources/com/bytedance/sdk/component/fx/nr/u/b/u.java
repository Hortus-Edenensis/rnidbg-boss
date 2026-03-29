package com.bytedance.sdk.component.fx.nr.u.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.fx.nr.sx;
import com.bytedance.sdk.component.fx.nr.u.fx.n;
import com.bytedance.sdk.component.fx.nr.u.fx.t;
import com.bytedance.sdk.component.fx.nr.u.nr.x;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.fx.u.a;
import com.bytedance.sdk.component.fx.u.bq;
import com.bytedance.sdk.component.fx.u.l;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.bytedance.sdk.component.fx.nr.u.fx.fx {
    final com.bytedance.sdk.component.fx.u.b b;
    final com.bytedance.sdk.component.fx.u.pn fx;
    final x nr;
    final q u;
    int pn = 0;
    private long iz = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements sx {
        private long b;
        private boolean fx;
        private final a nr;

        public b(long j) {
            this.nr = new a(u.this.b.u());
            this.b = j;
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public void a_(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (this.fx) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.fx.nr.u.fx.u(fxVar.nr(), 0L, j);
            if (j <= this.b) {
                u.this.b.a_(fxVar, j);
                this.b -= j;
            } else {
                throw new ProtocolException("expected " + this.b + " bytes but received " + j);
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fx) {
                return;
            }
            this.fx = true;
            if (this.b > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            u.this.u(this.nr);
            u.this.pn = 3;
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
        public void flush() throws IOException {
            if (this.fx) {
                return;
            }
            u.this.b.flush();
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public bq u() {
            return this.nr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class fx extends AbstractC0216u {
        private final bg iz;
        private boolean n;
        private long x;

        public fx(bg bgVar) {
            super();
            this.x = -1L;
            this.n = true;
            this.iz = bgVar;
        }

        private void nr() throws IOException {
            if (this.x != -1) {
                u.this.fx.my();
            }
            try {
                this.x = u.this.fx.mv();
                String strTrim = u.this.fx.my().trim();
                if (this.x < 0 || !(strTrim.isEmpty() || strTrim.startsWith(com.huawei.openalliance.ad.constant.x.aQ))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.x + strTrim + "\"");
                }
                if (this.x == 0) {
                    this.n = false;
                    com.bytedance.sdk.component.fx.nr.u.fx.pn.u(u.this.u.iz(), this.iz, u.this.b());
                    u(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.nr) {
                return;
            }
            if (this.n && !com.bytedance.sdk.component.fx.nr.u.fx.u(this, 100, TimeUnit.MILLISECONDS)) {
                u(false, (IOException) null);
            }
            this.nr = true;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.b.u.AbstractC0216u, com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.nr) {
                throw new IllegalStateException("closed");
            }
            if (!this.n) {
                return -1L;
            }
            long j2 = this.x;
            if (j2 == 0 || j2 == -1) {
                nr();
                if (!this.n) {
                    return -1L;
                }
            }
            long jU = super.u(fxVar, Math.min(j, this.x));
            if (jU != -1) {
                this.x -= jU;
                return jU;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            u(false, (IOException) protocolException);
            throw protocolException;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class iz extends AbstractC0216u {
        private boolean iz;

        public iz() {
            super();
        }

        @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.nr) {
                return;
            }
            if (!this.iz) {
                u(false, (IOException) null);
            }
            this.nr = true;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.b.u.AbstractC0216u, com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.nr) {
                throw new IllegalStateException("closed");
            }
            if (this.iz) {
                return -1L;
            }
            long jU = super.u(fxVar, j);
            if (jU != -1) {
                return jU;
            }
            this.iz = true;
            u(true, (IOException) null);
            return -1L;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class nr implements sx {
        private boolean fx;
        private final a nr;

        public nr() {
            this.nr = new a(u.this.b.u());
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public void a_(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (this.fx) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            u.this.b.t(j);
            u.this.b.nr(HttpClient.NEWLINE);
            u.this.b.a_(fxVar, j);
            u.this.b.nr(HttpClient.NEWLINE);
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.fx) {
                return;
            }
            this.fx = true;
            u.this.b.nr("0\r\n\r\n");
            u.this.u(this.nr);
            u.this.pn = 3;
        }

        @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.fx) {
                return;
            }
            u.this.b.flush();
        }

        @Override // com.bytedance.sdk.component.fx.u.sx
        public bq u() {
            return this.nr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pn extends AbstractC0216u {
        private long iz;

        public pn(long j) throws IOException {
            super();
            this.iz = j;
            if (j == 0) {
                u(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.nr) {
                return;
            }
            if (this.iz != 0 && !com.bytedance.sdk.component.fx.nr.u.fx.u(this, 100, TimeUnit.MILLISECONDS)) {
                u(false, (IOException) null);
            }
            this.nr = true;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.b.u.AbstractC0216u, com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.nr) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.iz;
            if (j2 == 0) {
                return -1L;
            }
            long jU = super.u(fxVar, Math.min(j2, j));
            if (jU == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                u(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.iz - jU;
            this.iz = j3;
            if (j3 == 0) {
                u(true, (IOException) null);
            }
            return jU;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.fx.nr.u.b.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public abstract class AbstractC0216u implements com.bytedance.sdk.component.fx.u.bg {
        protected long fx;
        protected boolean nr;
        protected final a u;

        private AbstractC0216u() {
            this.u = new a(u.this.fx.u());
            this.fx = 0L;
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public bq u() {
            return this.u;
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            try {
                long jU = u.this.fx.u(fxVar, j);
                if (jU > 0) {
                    this.fx += jU;
                }
                return jU;
            } catch (IOException e) {
                u(false, e);
                throw e;
            }
        }

        public final void u(boolean z, IOException iOException) throws IOException {
            u uVar = u.this;
            int i = uVar.pn;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                uVar.u(this.u);
                u uVar2 = u.this;
                uVar2.pn = 6;
                x xVar = uVar2.nr;
                if (xVar != null) {
                    xVar.u(!z, uVar2, this.fx, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + u.this.pn);
        }
    }

    public u(q qVar, x xVar, com.bytedance.sdk.component.fx.u.pn pnVar, com.bytedance.sdk.component.fx.u.b bVar) {
        this.u = qVar;
        this.nr = xVar;
        this.fx = pnVar;
        this.b = bVar;
    }

    private String x() throws IOException {
        String strPn = this.fx.pn(this.iz);
        this.iz -= (long) strPn.length();
        return strPn;
    }

    public com.bytedance.sdk.component.fx.nr.sx b() throws IOException {
        sx.u uVar = new sx.u();
        while (true) {
            String strX = x();
            if (strX.length() == 0) {
                return uVar.u();
            }
            com.bytedance.sdk.component.fx.nr.u.u.u.u(uVar, strX);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void fx() {
        com.bytedance.sdk.component.fx.nr.u.nr.fx fxVarNr = this.nr.nr();
        if (fxVarNr != null) {
            fxVarNr.nr();
        }
    }

    public com.bytedance.sdk.component.fx.u.bg iz() throws IOException {
        if (this.pn != 4) {
            throw new IllegalStateException("state: " + this.pn);
        }
        x xVar = this.nr;
        if (xVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.pn = 5;
        xVar.b();
        return new iz();
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void nr() throws IOException {
        this.b.flush();
    }

    public com.bytedance.sdk.component.fx.u.sx pn() {
        if (this.pn == 1) {
            this.pn = 2;
            return new nr();
        }
        throw new IllegalStateException("state: " + this.pn);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public com.bytedance.sdk.component.fx.u.sx u(z zVar, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(zVar.u("Transfer-Encoding"))) {
            return pn();
        }
        if (j != -1) {
            return u(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public com.bytedance.sdk.component.fx.u.bg nr(long j) throws IOException {
        if (this.pn == 4) {
            this.pn = 5;
            return new pn(j);
        }
        throw new IllegalStateException("state: " + this.pn);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void u(z zVar) throws IOException {
        u(zVar.fx(), com.bytedance.sdk.component.fx.nr.u.fx.a.u(zVar, this.nr.nr().u().nr().type()));
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public rh u(h hVar) throws IOException {
        String strU = hVar.u("Content-Type");
        if (!com.bytedance.sdk.component.fx.nr.u.fx.pn.fx(hVar)) {
            return new n(strU, 0L, l.u(nr(0L)));
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(hVar.u("Transfer-Encoding"))) {
            return new n(strU, -1L, l.u(u(hVar.u().u())));
        }
        long jU = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(hVar);
        if (jU != -1) {
            return new n(strU, jU, l.u(nr(jU)));
        }
        return new n(strU, -1L, l.u(iz()));
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public void u() throws IOException {
        this.b.flush();
    }

    public void u(com.bytedance.sdk.component.fx.nr.sx sxVar, String str) throws IOException {
        if (this.pn == 0) {
            this.b.nr(str).nr(HttpClient.NEWLINE);
            int iU = sxVar.u();
            for (int i = 0; i < iU; i++) {
                this.b.nr(sxVar.u(i)).nr(": ").nr(sxVar.nr(i)).nr(HttpClient.NEWLINE);
            }
            this.b.nr(HttpClient.NEWLINE);
            this.pn = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.pn);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.fx.fx
    public h.u u(boolean z) throws IOException {
        int i = this.pn;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.pn);
        }
        try {
            t tVarU = t.u(x());
            h.u uVarU = new h.u().u(tVarU.u).u(tVarU.nr).u(tVarU.fx).u(b());
            if (z && tVarU.nr == 100) {
                return null;
            }
            this.pn = 4;
            return uVarU;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.nr);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public com.bytedance.sdk.component.fx.u.sx u(long j) {
        if (this.pn == 1) {
            this.pn = 2;
            return new b(j);
        }
        throw new IllegalStateException("state: " + this.pn);
    }

    public com.bytedance.sdk.component.fx.u.bg u(bg bgVar) throws IOException {
        if (this.pn == 4) {
            this.pn = 5;
            return new fx(bgVar);
        }
        throw new IllegalStateException("state: " + this.pn);
    }

    public void u(a aVar) {
        bq bqVarU = aVar.u();
        aVar.u(bq.fx);
        bqVarU.iz();
        bqVarU.pn();
    }
}
