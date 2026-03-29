package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.d;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr implements bq {
    private final boolean u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends com.bytedance.sdk.component.fx.u.x {
        long u;

        public u(sx sxVar) {
            super(sxVar);
        }

        @Override // com.bytedance.sdk.component.fx.u.x, com.bytedance.sdk.component.fx.u.sx
        public void a_(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
            super.a_(fxVar, j);
            this.u += j;
        }
    }

    public nr(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq
    public h u(bq.u uVar) throws IOException {
        d dVar;
        x xVar = (x) uVar;
        fx fxVarX = xVar.x();
        com.bytedance.sdk.component.fx.nr.u.nr.x xVarIz = xVar.iz();
        com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar = (com.bytedance.sdk.component.fx.nr.u.nr.fx) xVar.pn();
        z zVarU = xVar.u();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zVarU != null && (dVar = zVarU.iz) != null) {
            dVar.u(jCurrentTimeMillis);
        }
        xVar.call();
        fxVarX.u(zVarU);
        xVar.call();
        h.u uVarU = null;
        if (iz.fx(zVarU.nr()) && zVarU.b() != null) {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(zVarU.u("Expect"))) {
                fxVarX.u();
                xVar.call();
                uVarU = fxVarX.u(true);
            }
            if (uVarU == null) {
                xVar.call();
                com.bytedance.sdk.component.fx.u.b bVarU = com.bytedance.sdk.component.fx.u.l.u(new u(fxVarX.u(zVarU, zVarU.b().nr())));
                zVarU.b().u(bVarU);
                bVarU.close();
                xVar.call();
            } else if (!fxVar.pn()) {
                xVarIz.b();
            }
        }
        fxVarX.nr();
        if (uVarU == null) {
            xVar.call();
            uVarU = fxVarX.u(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        d dVar2 = zVarU.iz;
        if (dVar2 != null) {
            dVar2.nr(jCurrentTimeMillis2);
        }
        h hVarU = uVarU.u(zVarU).u(xVarIz.nr().b()).u(jCurrentTimeMillis).nr(jCurrentTimeMillis2).u();
        xVar.call();
        int iFx = hVarU.fx();
        h hVarU2 = (this.u && iFx == 101) ? hVarU.a().u(com.bytedance.sdk.component.fx.nr.u.fx.fx).u() : hVarU.a().u(fxVarX.u(hVarU)).u();
        if ("close".equalsIgnoreCase(hVarU2.u().u("Connection")) || "close".equalsIgnoreCase(hVarU2.u("Connection"))) {
            xVarIz.b();
        }
        if ((iFx != 204 && iFx != 205) || hVarU2.n().nr() <= 0) {
            return hVarU2;
        }
        throw new ProtocolException("HTTP " + iFx + " had non-zero Content-Length: " + hVarU2.n().nr());
    }
}
