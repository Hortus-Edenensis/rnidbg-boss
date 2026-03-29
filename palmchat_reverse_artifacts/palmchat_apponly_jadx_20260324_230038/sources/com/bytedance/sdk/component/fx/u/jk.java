package com.bytedance.sdk.component.fx.u;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class jk implements bg {
    private final t b;
    private final Inflater fx;
    private final pn nr;
    private int u = 0;
    private final CRC32 pn = new CRC32();

    public jk(bg bgVar) {
        if (bgVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.fx = inflater;
        pn pnVarU = l.u(bgVar);
        this.nr = pnVarU;
        this.b = new t(pnVarU, inflater);
    }

    private void fx() throws IOException {
        u("CRC", this.nr.l(), (int) this.pn.getValue());
        u("ISIZE", this.nr.l(), (int) this.fx.getBytesWritten());
    }

    private void nr() throws IOException {
        this.nr.u(10L);
        byte bNr = this.nr.fx().nr(3L);
        boolean z = ((bNr >> 1) & 1) == 1;
        if (z) {
            u(this.nr.fx(), 0L, 10L);
        }
        u("ID1ID2", 8075, this.nr.a());
        this.nr.n(8L);
        if (((bNr >> 2) & 1) == 1) {
            this.nr.u(2L);
            if (z) {
                u(this.nr.fx(), 0L, 2L);
            }
            long jT = this.nr.fx().t();
            this.nr.u(jT);
            if (z) {
                u(this.nr.fx(), 0L, jT);
            }
            this.nr.n(jT);
        }
        if (((bNr >> 3) & 1) == 1) {
            long jU = this.nr.u((byte) 0);
            if (jU == -1) {
                throw new EOFException();
            }
            if (z) {
                u(this.nr.fx(), 0L, jU + 1);
            }
            this.nr.n(jU + 1);
        }
        if (((bNr >> 4) & 1) == 1) {
            long jU2 = this.nr.u((byte) 0);
            if (jU2 == -1) {
                throw new EOFException();
            }
            if (z) {
                u(this.nr.fx(), 0L, jU2 + 1);
            }
            this.nr.n(jU2 + 1);
        }
        if (z) {
            u("FHCRC", this.nr.t(), (short) this.pn.getValue());
            this.pn.reset();
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public long u(fx fxVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.u == 0) {
            nr();
            this.u = 1;
        }
        if (this.u == 1) {
            long j2 = fxVar.nr;
            long jU = this.b.u(fxVar, j);
            if (jU != -1) {
                u(fxVar, j2, jU);
                return jU;
            }
            this.u = 2;
        }
        if (this.u == 2) {
            fx();
            this.u = 3;
            if (!this.nr.pn()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public bq u() {
        return this.nr.u();
    }

    private void u(fx fxVar, long j, long j2) {
        k kVar = fxVar.u;
        while (true) {
            int i = kVar.fx;
            int i2 = kVar.nr;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            kVar = kVar.iz;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) kVar.nr) + j);
            int iMin = (int) Math.min(kVar.fx - i3, j2);
            this.pn.update(kVar.u, i3, iMin);
            j2 -= (long) iMin;
            kVar = kVar.iz;
            j = 0;
        }
    }

    private void u(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
