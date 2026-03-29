package com.bytedance.sdk.component.fx.nr.u.pn;

import com.bytedance.sdk.component.fx.nr.u.pn.b;
import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.bq;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class n implements Closeable {
    static final Logger u = Logger.getLogger(pn.class.getName());
    private final u b;
    private final com.bytedance.sdk.component.fx.u.pn fx;
    final b.u nr;
    private final boolean pn;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(int i, int i2, List<fx> list) throws IOException;

        void u(int i, long j);

        void u(int i, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar);

        void u(int i, com.bytedance.sdk.component.fx.nr.u.pn.nr nrVar, com.bytedance.sdk.component.fx.u.iz izVar);

        void u(boolean z, int i, int i2);

        void u(boolean z, int i, int i2, List<fx> list);

        void u(boolean z, int i, com.bytedance.sdk.component.fx.u.pn pnVar, int i2) throws IOException;

        void u(boolean z, s sVar);
    }

    public n(com.bytedance.sdk.component.fx.u.pn pnVar, boolean z) {
        this.fx = pnVar;
        this.pn = z;
        u uVar = new u(pnVar);
        this.b = uVar;
        this.nr = new b.u(4096, uVar);
    }

    private void a(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw pn.nr("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jJk = ((long) this.fx.jk()) & 2147483647L;
        if (jJk == 0) {
            throw pn.nr("windowSizeIncrement was 0", Long.valueOf(jJk));
        }
        nrVar.u(i2, jJk);
    }

    private void b(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw pn.nr("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw pn.nr("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iJk = this.fx.jk();
        com.bytedance.sdk.component.fx.nr.u.pn.nr nrVarU = com.bytedance.sdk.component.fx.nr.u.pn.nr.u(iJk);
        if (nrVarU == null) {
            throw pn.nr("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iJk));
        }
        nrVar.u(i2, nrVarU);
    }

    private void fx(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw pn.nr("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw pn.nr("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        u(nrVar, i2);
    }

    private void iz(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw pn.nr("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sN = (b & 8) != 0 ? (short) (this.fx.n() & UByte.MAX_VALUE) : (short) 0;
        nrVar.u(i2, this.fx.jk() & Integer.MAX_VALUE, u(u(i - 4, b, sN), sN, b, i2));
    }

    private void n(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw pn.nr("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw pn.nr("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iJk = this.fx.jk();
        int iJk2 = this.fx.jk();
        int i3 = i - 8;
        com.bytedance.sdk.component.fx.nr.u.pn.nr nrVarU = com.bytedance.sdk.component.fx.nr.u.pn.nr.u(iJk2);
        if (nrVarU == null) {
            throw pn.nr("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iJk2));
        }
        com.bytedance.sdk.component.fx.u.iz izVarFx = com.bytedance.sdk.component.fx.u.iz.nr;
        if (i3 > 0) {
            izVarFx = this.fx.fx(i3);
        }
        nrVar.u(iJk, nrVarU, izVarFx);
    }

    private void nr(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw pn.nr("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw pn.nr("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sN = (b & 8) != 0 ? (short) (this.fx.n() & UByte.MAX_VALUE) : (short) 0;
        nrVar.u(z, i2, this.fx, u(i, b, sN));
        this.fx.n(sN);
    }

    private void pn(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw pn.nr("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw pn.nr("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw pn.nr("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        s sVar = new s();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sA = this.fx.a();
            int iJk = this.fx.jk();
            if (sA == 2) {
                if (iJk != 0 && iJk != 1) {
                    throw pn.nr("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sA == 3) {
                sA = 4;
            } else if (sA != 4) {
                if (sA == 5 && (iJk < 16384 || iJk > 16777215)) {
                    throw pn.nr("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iJk));
                }
            } else {
                if (iJk < 0) {
                    throw pn.nr("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                sA = 7;
            }
            sVar.u(sA, iJk);
        }
        nrVar.u(false, sVar);
    }

    private void x(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw pn.nr("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw pn.nr("TYPE_PING streamId != 0", new Object[0]);
        }
        nrVar.u((b & 1) != 0, this.fx.jk(), this.fx.jk());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fx.close();
    }

    public void u(nr nrVar) throws IOException {
        if (this.pn) {
            if (!u(true, nrVar)) {
                throw pn.nr("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.fx.u.pn pnVar = this.fx;
        com.bytedance.sdk.component.fx.u.iz izVar = pn.u;
        com.bytedance.sdk.component.fx.u.iz izVarFx = pnVar.fx(izVar.x());
        Logger logger = u;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.fx.nr.u.fx.u("<< CONNECTION %s", izVarFx.pn()));
        }
        if (!izVar.equals(izVarFx)) {
            throw pn.nr("Expected a connection header but was %s", izVarFx.u());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u implements bg {
        int b;
        int fx;
        private final com.bytedance.sdk.component.fx.u.pn iz;
        byte nr;
        short pn;
        int u;

        public u(com.bytedance.sdk.component.fx.u.pn pnVar) {
            this.iz = pnVar;
        }

        private void nr() throws IOException {
            int i = this.fx;
            int iU = n.u(this.iz);
            this.b = iU;
            this.u = iU;
            byte bN = (byte) (this.iz.n() & UByte.MAX_VALUE);
            this.nr = (byte) (this.iz.n() & UByte.MAX_VALUE);
            Logger logger = n.u;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(pn.u(true, this.fx, this.u, bN, this.nr));
            }
            int iJk = this.iz.jk() & Integer.MAX_VALUE;
            this.fx = iJk;
            if (bN != 9) {
                throw pn.nr("%s != TYPE_CONTINUATION", Byte.valueOf(bN));
            }
            if (iJk != i) {
                throw pn.nr("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            while (true) {
                int i = this.b;
                if (i != 0) {
                    long jU = this.iz.u(fxVar, Math.min(j, i));
                    if (jU == -1) {
                        return -1L;
                    }
                    this.b = (int) (((long) this.b) - jU);
                    return jU;
                }
                this.iz.n(this.pn);
                this.pn = (short) 0;
                if ((this.nr & 4) != 0) {
                    return -1L;
                }
                nr();
            }
        }

        @Override // com.bytedance.sdk.component.fx.u.bg
        public bq u() {
            return this.iz.u();
        }

        @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    public boolean u(boolean z, nr nrVar) throws IOException {
        try {
            this.fx.u(9L);
            int iU = u(this.fx);
            if (iU < 0 || iU > 16384) {
                throw pn.nr("FRAME_SIZE_ERROR: %s", Integer.valueOf(iU));
            }
            byte bN = (byte) (this.fx.n() & UByte.MAX_VALUE);
            if (z && bN != 4) {
                throw pn.nr("Expected a SETTINGS frame but was %s", Byte.valueOf(bN));
            }
            byte bN2 = (byte) (this.fx.n() & UByte.MAX_VALUE);
            int iJk = this.fx.jk() & Integer.MAX_VALUE;
            Logger logger = u;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(pn.u(true, iJk, iU, bN, bN2));
            }
            switch (bN) {
                case 0:
                    nr(nrVar, iU, bN2, iJk);
                    return true;
                case 1:
                    u(nrVar, iU, bN2, iJk);
                    return true;
                case 2:
                    fx(nrVar, iU, bN2, iJk);
                    return true;
                case 3:
                    b(nrVar, iU, bN2, iJk);
                    return true;
                case 4:
                    pn(nrVar, iU, bN2, iJk);
                    return true;
                case 5:
                    iz(nrVar, iU, bN2, iJk);
                    return true;
                case 6:
                    x(nrVar, iU, bN2, iJk);
                    return true;
                case 7:
                    n(nrVar, iU, bN2, iJk);
                    return true;
                case 8:
                    a(nrVar, iU, bN2, iJk);
                    return true;
                default:
                    this.fx.n(iU);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void u(nr nrVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            short sN = (b & 8) != 0 ? (short) (this.fx.n() & UByte.MAX_VALUE) : (short) 0;
            if ((b & 32) != 0) {
                u(nrVar, i2);
                i -= 5;
            }
            nrVar.u(z, i2, -1, u(u(i, b, sN), sN, b, i2));
            return;
        }
        throw pn.nr("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<fx> u(int i, short s, byte b, int i2) throws IOException {
        u uVar = this.b;
        uVar.b = i;
        uVar.u = i;
        uVar.pn = s;
        uVar.nr = b;
        uVar.fx = i2;
        this.nr.u();
        return this.nr.nr();
    }

    private void u(nr nrVar, int i) throws IOException {
        this.fx.jk();
        this.fx.n();
    }

    public static int u(com.bytedance.sdk.component.fx.u.pn pnVar) throws IOException {
        return (pnVar.n() & UByte.MAX_VALUE) | ((pnVar.n() & UByte.MAX_VALUE) << 16) | ((pnVar.n() & UByte.MAX_VALUE) << 8);
    }

    public static int u(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw pn.nr("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
