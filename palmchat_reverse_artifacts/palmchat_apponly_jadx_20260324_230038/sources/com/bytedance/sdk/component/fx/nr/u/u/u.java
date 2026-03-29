package com.bytedance.sdk.component.fx.nr.u.u;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.fx.nr.sx;
import com.bytedance.sdk.component.fx.nr.u.fx.n;
import com.bytedance.sdk.component.fx.nr.u.u.fx;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.l;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements bq {
    final iz u;

    public u(iz izVar) {
        this.u = izVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq
    public h u(bq.u uVar) throws IOException {
        iz izVar = this.u;
        h hVarU = izVar != null ? izVar.u(uVar.u()) : null;
        fx fxVarU = new fx.u(System.currentTimeMillis(), uVar.u(), hVarU).u();
        z zVar = fxVarU.u;
        h hVar = fxVarU.nr;
        if (hVarU != null && hVar == null) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(hVarU.n());
        }
        if (zVar == null && hVar == null) {
            return new h.u().u(uVar.u()).u(qq.HTTP_1_1).u(504).u("Unsatisfiable Request (only-if-cached)").u(com.bytedance.sdk.component.fx.nr.u.fx.fx).u(-1L).nr(System.currentTimeMillis()).u();
        }
        if (zVar == null) {
            return hVar.a().nr(u(hVar)).u();
        }
        try {
            h hVarU2 = uVar.u(zVar);
            if (hVarU2 == null && hVarU != null) {
            }
            if (hVar != null) {
                if (hVarU2.fx() == 304) {
                    h hVarU3 = hVar.a().u(u(hVar.x(), hVarU2.x())).u(hVarU2.mv()).nr(hVarU2.s()).nr(u(hVar)).u(u(hVarU2)).u();
                    hVarU2.n().close();
                    this.u.update(hVar, hVarU3);
                    return hVarU3;
                }
                com.bytedance.sdk.component.fx.nr.u.fx.u(hVar.n());
            }
            h hVarU4 = hVarU2.a().nr(u(hVar)).u(u(hVarU2)).u();
            if (this.u != null) {
                if (com.bytedance.sdk.component.fx.nr.u.fx.pn.fx(hVarU4) && fx.u(hVarU4, zVar)) {
                    return u(this.u.u(hVarU4), hVarU4);
                }
                com.bytedance.sdk.component.fx.nr.u.fx.iz.u(zVar.nr());
            }
            return hVarU4;
        } finally {
            if (hVarU != null) {
                com.bytedance.sdk.component.fx.nr.u.fx.u(hVarU.n());
            }
        }
    }

    private static h u(h hVar) {
        return (hVar == null || hVar.n() == null) ? hVar : hVar.a().u((rh) null).u();
    }

    private h u(final nr nrVar, h hVar) throws IOException {
        sx sxVarU;
        if (nrVar == null || (sxVarU = nrVar.u()) == null) {
            return hVar;
        }
        final com.bytedance.sdk.component.fx.u.pn pnVarFx = hVar.n().fx();
        final com.bytedance.sdk.component.fx.u.b bVarU = l.u(sxVarU);
        return hVar.a().u(new n(hVar.u("Content-Type"), hVar.n().nr(), l.u(new bg() { // from class: com.bytedance.sdk.component.fx.nr.u.u.u.1
            boolean u;

            @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.u && !com.bytedance.sdk.component.fx.nr.u.fx.u(this, 100, TimeUnit.MILLISECONDS)) {
                    this.u = true;
                }
                pnVarFx.close();
            }

            @Override // com.bytedance.sdk.component.fx.u.bg
            public long u(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
                try {
                    long jU = pnVarFx.u(fxVar, j);
                    if (jU != -1) {
                        fxVar.u(bVarU.fx(), fxVar.nr() - jU, jU);
                        bVarU.dw();
                        return jU;
                    }
                    if (!this.u) {
                        this.u = true;
                        bVarU.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.u) {
                        this.u = true;
                    }
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.component.fx.u.bg
            public com.bytedance.sdk.component.fx.u.bq u() {
                return pnVarFx.u();
            }
        }))).u();
    }

    private static com.bytedance.sdk.component.fx.nr.sx u(com.bytedance.sdk.component.fx.nr.sx sxVar, com.bytedance.sdk.component.fx.nr.sx sxVar2) {
        sx.u uVar = new sx.u();
        int iU = sxVar.u();
        for (int i = 0; i < iU; i++) {
            String strU = sxVar.u(i);
            String strNr = sxVar.nr(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(strU) || !strNr.startsWith("1")) && (!u(strU) || sxVar2.u(strU) == null)) {
                com.bytedance.sdk.component.fx.nr.u.u.u.u(uVar, strU, strNr);
            }
        }
        int iU2 = sxVar2.u();
        for (int i2 = 0; i2 < iU2; i2++) {
            String strU2 = sxVar2.u(i2);
            if (!"Content-Length".equalsIgnoreCase(strU2) && u(strU2)) {
                com.bytedance.sdk.component.fx.nr.u.u.u.u(uVar, strU2, sxVar2.nr(i2));
            }
        }
        return uVar.u();
    }

    public static boolean u(String str) {
        return ("Connection".equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }
}
