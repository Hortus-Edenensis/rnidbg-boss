package com.bytedance.pangle.res.u;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends jk {
    private long u;

    public pn(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized long nr() {
        return this.u;
    }

    @Override // com.bytedance.pangle.res.u.jk, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.u += jSkip;
        return jSkip;
    }

    @Override // com.bytedance.pangle.res.u.jk
    public synchronized void u(int i) {
        if (i != -1) {
            this.u += (long) i;
        }
    }

    public int u() {
        long jNr = nr();
        if (jNr <= 2147483647L) {
            return (int) jNr;
        }
        throw new ArithmeticException("The byte count " + jNr + " is too large to be converted to an int");
    }
}
