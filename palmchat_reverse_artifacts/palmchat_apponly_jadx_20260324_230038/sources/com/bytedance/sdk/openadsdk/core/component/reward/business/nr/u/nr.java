package com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;

import android.app.Activity;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.widget.iz;
import com.bytedance.sdk.openadsdk.res.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private iz nr;

    public nr(Activity activity, bc bcVar) {
        super(activity, bcVar);
        this.nr = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void b() {
        iz izVar = this.nr;
        if (izVar != null) {
            izVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void fx() {
        iz izVar = this.nr;
        if (izVar != null) {
            izVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean nr() {
        iz izVar = this.nr;
        return izVar != null && izVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void pn() {
        iz izVar = this.nr;
        if (izVar != null) {
            izVar.nr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u u(final jk jkVar) {
        nr.u uVarU = super.u(jkVar);
        if (uVarU.fx()) {
            return uVarU;
        }
        final iz izVar = new iz(this.n);
        this.nr = izVar;
        izVar.u(q.fx(this.n, "tt_retain_gift")).u(u()).fx(w.u(this.x, this.t, this.l)).b("坚持退出");
        izVar.u(pn.a(this.n));
        this.nr.u(new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.iz.u
            public void nr() {
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.iz.u
            public void u() {
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
            }
        });
        this.nr.show();
        return new nr.u(true, 0, "", this.nr);
    }
}
