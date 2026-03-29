package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.widget.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    private com.bytedance.sdk.openadsdk.core.widget.iz o;

    public fx(Activity activity, bc bcVar) {
        super(activity, bcVar);
        this.o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void fx() {
        com.bytedance.sdk.openadsdk.core.widget.iz izVar = this.o;
        if (izVar != null) {
            izVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(final jk jkVar) {
        nr.u uVarNr = super.nr(jkVar);
        if (uVarNr.fx()) {
            return uVarNr;
        }
        final com.bytedance.sdk.openadsdk.core.widget.iz izVar = new com.bytedance.sdk.openadsdk.core.widget.iz(this.n);
        this.o = izVar;
        izVar.u(q.fx(this.n, "tt_retain_gift")).u(a()).fx("继续观看").b("坚持退出");
        this.o.u(com.bytedance.sdk.openadsdk.res.pn.a(this.n));
        this.o.u(new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.fx.1
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
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
            }
        });
        this.o.show();
        return new nr.u(true, 0, "", this.o);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        if (!(this.u <= 0) && this.pn) {
            return "再看" + this.u + "s，并点击一下广告可领取奖励";
        }
        if (this.pn) {
            return "忘记点击广告领取奖励啦～";
        }
        return "再看" + this.u + "s可领取奖励";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean nr() {
        com.bytedance.sdk.openadsdk.core.widget.iz izVar = this.o;
        return izVar != null && izVar.isShowing();
    }
}
