package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.umeng.analytics.pro.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx {
    private final com.bytedance.sdk.openadsdk.core.pn.pn.b nr;
    protected Context u;

    public fx(Context context) {
        this.u = context == null ? dw.getContext() : context.getApplicationContext();
        this.nr = new com.bytedance.sdk.openadsdk.core.pn.pn.b(nr());
    }

    public abstract int nr();

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i, bc bcVar, b bVar) {
        String strL = jp.l(bcVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn pnVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn();
        pnVar.u(i);
        pnVar.u(strL);
        u(nrVar, bVar, (com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx) null, pnVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.fx.b.u(bcVar, true, i, 0);
    }

    public void u(final String str) {
        com.bytedance.sdk.openadsdk.gi.x.u(new a("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.fx.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().u(str);
                if (nrVarU == null || TextUtils.isEmpty(nrVarU.b())) {
                    return;
                }
                bc bcVarU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(fx.this.nr()).u(nrVarU.b(), false, 0L);
                if (dw.nr().nr(nrVarU.b()) && bcVarU != null) {
                    if (bcVarU.bc() + bcVarU.gi() < System.currentTimeMillis()) {
                        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(fx.this.nr()).u(nrVarU.b());
                    }
                }
                if (bcVarU == null) {
                    fx.this.u(nrVarU);
                }
            }
        });
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (this.nr != null) {
            this.nr.u(nrVar, u(true, System.currentTimeMillis(), (com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx) null, (com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn) null));
        }
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, b bVar) {
        if (nrVar != null) {
            nrVar.b();
        }
        u(nrVar, bVar, (com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx) null, (com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn) null);
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final b bVar, com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx fxVar, com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn pnVar) {
        boolean z = (fxVar == null || !fxVar.fx()) && com.bytedance.sdk.openadsdk.core.live.pn.b.u(nrVar.c());
        if (pnVar != null && pnVar.fx()) {
            z = false;
        }
        final oa oaVarU = u(false, bVar != null ? bVar.u() : System.currentTimeMillis(), fxVar, pnVar);
        oaVarU.u(nr(), nrVar != null ? nrVar.b() : "", nrVar != null ? nrVar.l() : 1);
        com.bytedance.sdk.openadsdk.core.pn.pn.b bVar2 = this.nr;
        if (bVar2 != null) {
            bVar2.u(nrVar, oaVarU, z ? -1 : 0, new com.bytedance.sdk.openadsdk.core.pn.pn.pn() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.fx.2
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(Object obj, boolean z2) {
                    oaVarU.u(obj, z2 ? 3 : 2);
                    nrVar.b();
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.u(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(Object obj) {
                    nrVar.b();
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.nr(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(int i, String str) {
                    oaVarU.u((Object) null, 1);
                    nrVar.b();
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.u(i, str);
                    }
                }
            });
        }
    }

    private oa u(boolean z, long j, com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx fxVar, com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn pnVar) {
        boolean z2;
        oa oaVar = new oa();
        oaVar.n = j;
        if (z) {
            oaVar.u = 2;
        }
        oaVar.iz = 2;
        boolean z3 = false;
        if (fxVar == null || !fxVar.fx()) {
            z2 = false;
        } else {
            oaVar.nr = fxVar.u();
            oaVar.fx = fxVar.nr();
            oaVar.b = 1;
            z2 = true;
        }
        if (pnVar != null && pnVar.fx()) {
            oaVar.my = pnVar.u();
            oaVar.o = pnVar.nr();
            z3 = true;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean("is_second_page_ad", z3);
        bundle.putBoolean("is_preload", z);
        bundle.putLong(f.p, oaVar.n);
        oaVar.k = bundle;
        return oaVar;
    }
}
