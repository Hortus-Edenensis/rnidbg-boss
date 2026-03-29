package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.dw;
import com.bytedance.sdk.component.fx.nr.gi;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.mv;
import com.bytedance.sdk.component.fx.nr.z;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements bq {
    private final mv u;

    public u(mv mvVar) {
        this.u = mvVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq
    public h u(bq.u uVar) throws IOException {
        z zVarU = uVar.u();
        z.u uVarIz = zVarU.iz();
        gi giVarB = zVarU.b();
        if (giVarB != null) {
            dw dwVarU = giVarB.u();
            if (dwVarU != null) {
                uVarIz.u("Content-Type", dwVarU.toString());
            }
            long jNr = giVarB.nr();
            if (jNr != -1) {
                uVarIz.u("Content-Length", Long.toString(jNr));
                uVarIz.u("Transfer-Encoding");
            } else {
                uVarIz.u("Transfer-Encoding", HTTP.CHUNK_CODING);
                uVarIz.u("Content-Length");
            }
        }
        boolean z = false;
        if (zVarU.u("Host") == null) {
            uVarIz.u("Host", com.bytedance.sdk.component.fx.nr.u.fx.u(zVarU.u(), false));
        }
        if (zVarU.u("Connection") == null) {
            uVarIz.u("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (zVarU.u(HttpHeaders.ACCEPT_ENCODING) == null && zVarU.u(HttpHeaders.RANGE) == null) {
            uVarIz.u(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            z = true;
        }
        List<com.bytedance.sdk.component.fx.nr.l> listU = this.u.u(zVarU.u());
        if (!listU.isEmpty()) {
            uVarIz.u("Cookie", u(listU));
        }
        if (zVarU.u("User-Agent") == null) {
            uVarIz.u("User-Agent", com.bytedance.sdk.component.fx.nr.u.b.u());
        }
        h hVarU = uVar.u(uVarIz.u());
        pn.u(this.u, zVarU.u(), hVarU.x());
        h.u uVarU = hVarU.a().u(zVarU);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(hVarU.u("Content-Encoding")) && pn.fx(hVarU)) {
            com.bytedance.sdk.component.fx.u.jk jkVar = new com.bytedance.sdk.component.fx.u.jk(hVarU.n().fx());
            uVarU.u(hVarU.x().nr().nr("Content-Encoding").nr("Content-Length").u());
            uVarU.u(new n(hVarU.u("Content-Type"), -1L, com.bytedance.sdk.component.fx.u.l.u(jkVar)));
        }
        return uVarU.u();
    }

    private String u(List<com.bytedance.sdk.component.fx.nr.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.fx.nr.l lVar = list.get(i);
            sb.append(lVar.u());
            sb.append('=');
            sb.append(lVar.nr());
        }
        return sb.toString();
    }
}
