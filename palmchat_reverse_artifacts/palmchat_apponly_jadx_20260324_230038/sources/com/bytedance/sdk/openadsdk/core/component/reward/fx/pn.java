package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.widget.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    private com.bytedance.sdk.openadsdk.core.widget.iz o;

    public pn(Activity activity, bc bcVar) {
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
        final com.bytedance.sdk.openadsdk.core.widget.iz izVar = new com.bytedance.sdk.openadsdk.core.widget.iz(this.n);
        this.o = izVar;
        izVar.u(q.fx(this.n, "tt_retain_gift")).u(a()).fx("继续观看").b("坚持退出");
        izVar.u(com.bytedance.sdk.openadsdk.res.pn.mv(this.n));
        this.o.u(new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.pn.1
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
        this.o.u(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.pn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.fx();
                }
            }
        });
        this.o.show();
        return new nr.u(true, 0, "", this.o);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        return "继续观看" + this.u + "秒可获得奖励\n确定要退出吗？";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean nr() {
        com.bytedance.sdk.openadsdk.core.widget.iz izVar = this.o;
        return izVar != null && izVar.isShowing();
    }
}
