package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends fx {
    public pn(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, nrVar, pnVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void fx(View view) {
        super.fx(view);
        this.iz.fx("playable");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void iz(View view) {
        super.iz(view);
        if (jk.pn(this.nr) || jk.b(this.nr)) {
            this.iz.jk();
        } else {
            u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void nr(View view) {
        super.nr(view);
        if (bg.b(this.nr)) {
            this.iz.wq();
        } else {
            this.iz.pb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void u(View view) {
        super.u(view);
        if (u()) {
            return;
        }
        this.iz.mh().u();
        if (bg.t(this.nr) || jk.pn(this.nr) || jk.b(this.nr)) {
            this.iz.jk();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                pn.this.iz.s();
                pn.this.iz.nr();
            }
        };
        if (u(jkVar)) {
            this.x--;
        } else {
            jkVar.nr();
        }
    }
}
