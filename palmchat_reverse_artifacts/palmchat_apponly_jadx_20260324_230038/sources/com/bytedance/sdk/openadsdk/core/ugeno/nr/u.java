package com.bytedance.sdk.openadsdk.core.ugeno.nr;

import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements nr {
    private int b(bc bcVar) {
        if (bcVar == null) {
            return -1;
        }
        return bcVar.ol();
    }

    public static boolean fx(bc bcVar) {
        return pn(bcVar) == 5;
    }

    public static boolean nr(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return (tk.fx(bcVar) == 2) && fx(bcVar);
    }

    private static int pn(bc bcVar) {
        int iJk;
        if (bcVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = bcVar.tm();
        int iBq = nrVarTm != null ? nrVarTm.bq() : -1;
        return ((iBq <= 0 || iBq >= 10) && (iJk = jp.jk(bcVar)) > 0 && iJk < 10) ? iJk : iBq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.nr.nr
    public String u(bc bcVar) {
        int iPn = pn(bcVar);
        int iB = b(bcVar);
        if (iPn <= 0 || iPn > 9 || iB == -1) {
            return null;
        }
        return u(bcVar, iPn, iB);
    }

    public abstract String u(bc bcVar, int i, int i2);

    public static nr u(bc bcVar, mv mvVar) {
        if (bcVar == null || pn(bcVar) != 5) {
            return null;
        }
        if ((mvVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.nr) && ((com.bytedance.sdk.openadsdk.core.ugeno.express.nr) mvVar).xg()) {
            return new com.bytedance.sdk.openadsdk.core.ugeno.nr.nr.u();
        }
        return new com.bytedance.sdk.openadsdk.core.ugeno.nr.u.u();
    }
}
