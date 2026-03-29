package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.d;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.z;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements bq {
    public final q u;

    public u(q qVar) {
        this.u = qVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq
    public h u(bq.u uVar) throws IOException {
        d dVar;
        com.bytedance.sdk.component.fx.nr.u.fx.x xVar = (com.bytedance.sdk.component.fx.nr.u.fx.x) uVar;
        z zVarU = xVar.u();
        if (zVarU != null && (dVar = zVarU.iz) != null) {
            dVar.nr();
        }
        x xVarIz = xVar.iz();
        com.bytedance.sdk.component.fx.nr.u.fx.fx fxVarU = xVarIz.u(this.u, uVar, !zVarU.nr().equals("GET"));
        fx fxVarNr = xVarIz.nr();
        d dVar2 = zVarU.iz;
        if (dVar2 != null) {
            dVar2.fx();
        }
        return xVar.u(zVarU, xVarIz, fxVarU, fxVarNr);
    }
}
