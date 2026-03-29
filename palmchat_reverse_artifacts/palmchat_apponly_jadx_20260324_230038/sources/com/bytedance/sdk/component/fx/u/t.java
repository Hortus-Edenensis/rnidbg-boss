package com.bytedance.sdk.component.fx.u;

import com.oplus.tblplayer.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements bg {
    private boolean b;
    private int fx;
    private final Inflater nr;
    private final pn u;

    public t(pn pnVar, Inflater inflater) {
        if (pnVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.u = pnVar;
        this.nr = inflater;
    }

    private void fx() throws IOException {
        int i = this.fx;
        if (i == 0) {
            return;
        }
        int remaining = i - this.nr.getRemaining();
        this.fx -= remaining;
        this.u.n(remaining);
    }

    @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.b) {
            return;
        }
        this.nr.end();
        this.b = true;
        this.u.close();
    }

    public final boolean nr() throws IOException {
        if (!this.nr.needsInput()) {
            return false;
        }
        fx();
        if (this.nr.getRemaining() != 0) {
            throw new IllegalStateException(Constants.STRING_VALUE_UNSET);
        }
        if (this.u.pn()) {
            return true;
        }
        k kVar = this.u.fx().u;
        int i = kVar.fx;
        int i2 = kVar.nr;
        int i3 = i - i2;
        this.fx = i3;
        this.nr.setInput(kVar.u, i2, i3);
        return false;
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public long u(fx fxVar, long j) throws IOException {
        boolean zNr;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zNr = nr();
            try {
                k kVarPn = fxVar.pn(1);
                int iInflate = this.nr.inflate(kVarPn.u, kVarPn.fx, (int) Math.min(j, 8192 - kVarPn.fx));
                if (iInflate > 0) {
                    kVarPn.fx += iInflate;
                    long j2 = iInflate;
                    fxVar.nr += j2;
                    return j2;
                }
                if (!this.nr.finished() && !this.nr.needsDictionary()) {
                }
                fx();
                if (kVarPn.nr != kVarPn.fx) {
                    return -1L;
                }
                fxVar.u = kVarPn.nr();
                my.u(kVarPn);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zNr);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public bq u() {
        return this.u.u();
    }
}
