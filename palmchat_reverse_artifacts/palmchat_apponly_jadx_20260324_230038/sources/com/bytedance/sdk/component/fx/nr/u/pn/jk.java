package com.bytedance.sdk.component.fx.nr.u.pn;

import com.bytedance.sdk.component.fx.nr.u.pn.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class jk implements Closeable {
    private static final Logger nr = Logger.getLogger(pn.class.getName());
    private final boolean b;
    private final com.bytedance.sdk.component.fx.u.b fx;
    private int iz;
    private final com.bytedance.sdk.component.fx.u.fx pn;
    final b.nr u;
    private boolean x;

    public jk(com.bytedance.sdk.component.fx.u.b bVar, boolean z) {
        this.fx = bVar;
        this.b = z;
        com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
        this.pn = fxVar;
        this.u = new b.nr(fxVar);
        this.iz = 16384;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.x = true;
        this.fx.close();
    }

    public int fx() {
        return this.iz;
    }

    public synchronized void nr() throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        this.fx.flush();
    }

    public synchronized void u() throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (this.b) {
            Logger logger = nr;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.bytedance.sdk.component.fx.nr.u.fx.u(">> CONNECTION %s", pn.u.pn()));
            }
            this.fx.fx(pn.u.n());
            this.fx.flush();
        }
    }

    public synchronized void nr(s sVar) throws IOException {
        if (!this.x) {
            int i = 0;
            u(0, sVar.nr() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (sVar.u(i)) {
                    this.fx.n(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.fx.x(sVar.nr(i));
                }
                i++;
            }
            this.fx.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(s sVar) throws IOException {
        if (!this.x) {
            this.iz = sVar.b(this.iz);
            if (sVar.fx() != -1) {
                this.u.u(sVar.fx());
            }
            u(0, 0, (byte) 4, (byte) 1);
            this.fx.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void nr(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.iz, j);
            long j2 = iMin;
            j -= j2;
            u(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.fx.a_(this.pn, j2);
        }
    }

    public synchronized void u(int i, int i2, List<fx> list) throws IOException {
        if (!this.x) {
            this.u.u(list);
            long jNr = this.pn.nr();
            int iMin = (int) Math.min(this.iz - 4, jNr);
            long j = iMin;
            u(i, iMin + 4, (byte) 5, jNr == j ? (byte) 4 : (byte) 0);
            this.fx.x(i2 & Integer.MAX_VALUE);
            this.fx.a_(this.pn, j);
            if (jNr > j) {
                nr(i, jNr - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(boolean z, int i, int i2, List<fx> list) throws IOException {
        if (!this.x) {
            u(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(int i, nr nrVar) throws IOException {
        if (!this.x) {
            if (nrVar.x != -1) {
                u(i, 4, (byte) 3, (byte) 0);
                this.fx.x(nrVar.x);
                this.fx.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(boolean z, int i, com.bytedance.sdk.component.fx.u.fx fxVar, int i2) throws IOException {
        if (!this.x) {
            u(i, z ? (byte) 1 : (byte) 0, fxVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void u(int i, byte b, com.bytedance.sdk.component.fx.u.fx fxVar, int i2) throws IOException {
        u(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.fx.a_(fxVar, i2);
        }
    }

    public synchronized void u(boolean z, int i, int i2) throws IOException {
        if (!this.x) {
            u(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.fx.x(i);
            this.fx.x(i2);
            this.fx.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(int i, nr nrVar, byte[] bArr) throws IOException {
        if (!this.x) {
            if (nrVar.x != -1) {
                u(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.fx.x(i);
                this.fx.x(nrVar.x);
                if (bArr.length > 0) {
                    this.fx.fx(bArr);
                }
                this.fx.flush();
            } else {
                throw pn.u("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(int i, long j) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            u(i, 4, (byte) 8, (byte) 0);
            this.fx.x((int) j);
            this.fx.flush();
        } else {
            throw pn.u("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }

    public void u(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = nr;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(pn.u(false, i, i2, b, b2));
        }
        int i3 = this.iz;
        if (i2 > i3) {
            throw pn.u("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw pn.u("reserved bit set: %s", Integer.valueOf(i));
        }
        u(this.fx, i2);
        this.fx.a(b & UByte.MAX_VALUE);
        this.fx.a(b2 & UByte.MAX_VALUE);
        this.fx.x(i & Integer.MAX_VALUE);
    }

    private static void u(com.bytedance.sdk.component.fx.u.b bVar, int i) throws IOException {
        bVar.a((i >>> 16) & 255);
        bVar.a((i >>> 8) & 255);
        bVar.a(i & 255);
    }

    public void u(boolean z, int i, List<fx> list) throws IOException {
        if (!this.x) {
            this.u.u(list);
            long jNr = this.pn.nr();
            int iMin = (int) Math.min(this.iz, jNr);
            long j = iMin;
            byte b = jNr == j ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            u(i, iMin, (byte) 1, b);
            this.fx.a_(this.pn, j);
            if (jNr > j) {
                nr(i, jNr - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
