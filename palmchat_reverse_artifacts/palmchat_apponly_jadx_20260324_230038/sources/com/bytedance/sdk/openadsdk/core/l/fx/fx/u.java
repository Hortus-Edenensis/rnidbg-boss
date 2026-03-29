package com.bytedance.sdk.openadsdk.core.l.fx.fx;

import android.content.Context;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.n;
import com.oplus.tblplayer.config.PreCacheConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    protected boolean b = true;
    protected int fx;
    protected bc nr;
    protected Context u;

    public boolean b() {
        int iFx = o.fx(this.u);
        bc bcVar = this.nr;
        if (bcVar == null) {
            return false;
        }
        int iK = bq.k(bcVar);
        if (iK == -1) {
            return !n.o().fx(iFx);
        }
        if (iK == 0) {
            return false;
        }
        if (iK != 2) {
            if (iK != 3) {
                if (n.o().fx(iFx)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = this.nr.pu();
                if (((pnVarPu == null || pnVarPu.x() <= 0) ? PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE : pnVarPu.x()) <= bq.my(this.nr)) {
                    return false;
                }
            }
        } else if (iFx == 4) {
            return false;
        }
        return true;
    }

    public abstract boolean fx();

    public int nr() {
        return this.fx;
    }

    public void u(Context context) {
        this.u = context;
    }

    public void u(bc bcVar) {
        this.nr = bcVar;
    }

    public void u(boolean z) {
        this.b = z;
    }

    public boolean u() {
        Context context;
        if (this.nr == null || (context = this.u) == null) {
            return true;
        }
        if (!this.b) {
            return false;
        }
        if (o.fx(context) == 0) {
            try {
                Context context2 = this.u;
                h.u(context2, q.u(context2, "tt_no_network"), 0);
            } catch (Throwable unused) {
            }
        }
        boolean zFx = fx();
        if (zFx) {
            iz.u = true;
            iz.fx = true;
        }
        return zFx;
    }
}
