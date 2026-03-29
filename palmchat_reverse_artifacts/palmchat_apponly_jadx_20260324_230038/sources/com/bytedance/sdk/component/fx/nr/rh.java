package com.bytedance.sdk.component.fx.nr;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class rh implements Closeable {
    public static rh u(dw dwVar, byte[] bArr) {
        return u(dwVar, bArr.length, new com.bytedance.sdk.component.fx.u.fx().fx(bArr));
    }

    private Charset x() {
        dw dwVarU = u();
        return dwVarU != null ? dwVarU.u(com.bytedance.sdk.component.fx.nr.u.fx.pn) : com.bytedance.sdk.component.fx.nr.u.fx.pn;
    }

    public final InputStream b() {
        return fx().iz();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.fx.nr.u.fx.u(fx());
    }

    public abstract com.bytedance.sdk.component.fx.u.pn fx();

    public final String iz() throws IOException {
        com.bytedance.sdk.component.fx.u.pn pnVarFx = fx();
        try {
            String strU = pnVarFx.u(com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx, x()));
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx);
            return strU;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx);
            throw th;
        }
    }

    public abstract long nr();

    public final byte[] pn() throws IOException {
        long jNr = nr();
        if (jNr > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jNr)));
        }
        com.bytedance.sdk.component.fx.u.pn pnVarFx = fx();
        try {
            byte[] bArrO = pnVarFx.o();
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx);
            if (jNr == -1 || jNr == bArrO.length) {
                return bArrO;
            }
            throw new IOException("Content-Length (" + jNr + ") and stream length (" + bArrO.length + ") disagree");
        } catch (Throwable th) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarFx);
            throw th;
        }
    }

    public abstract dw u();

    public static rh u(final dw dwVar, final long j, final com.bytedance.sdk.component.fx.u.pn pnVar) {
        if (pnVar != null) {
            return new rh() { // from class: com.bytedance.sdk.component.fx.nr.rh.1
                @Override // com.bytedance.sdk.component.fx.nr.rh
                public com.bytedance.sdk.component.fx.u.pn fx() {
                    return pnVar;
                }

                @Override // com.bytedance.sdk.component.fx.nr.rh
                public long nr() {
                    return j;
                }

                @Override // com.bytedance.sdk.component.fx.nr.rh
                public dw u() {
                    return dwVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
