package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.n;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends fx {
    public iz(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, nrVar, pnVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void fx(View view) {
        super.fx(view);
        this.iz.fx("video_player");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void iz(View view) {
        super.iz(view);
        u(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void nr(View view) {
        super.nr(view);
        if (this.iz.yd() instanceof n) {
            this.iz.pb();
        }
        this.iz.wq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void u(View view) {
        super.u(view);
        if (u()) {
            return;
        }
        this.iz.mh().u();
        if (this.iz.yd().yd()) {
            nr();
        } else {
            fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void x(View view) {
        super.x(view);
        this.iz.p();
    }

    private void fx() {
        jk jkVar = new jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.iz.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                iz.this.iz.fx();
            }
        };
        if (u(jkVar)) {
            return;
        }
        jkVar.nr();
    }

    private void nr() {
        jk jkVar = new jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.iz.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                iz.this.iz.s();
                iz.this.iz.xg().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.iz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iz.this.iz.nr();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iPn = this.iz.pn(2);
        if (this.nr.mf() == 7) {
            if (this.nr.cb() && !this.iz.ay()) {
                i = 1;
            }
            iPn = i;
        }
        if (iPn == 1) {
            if (u(jkVar)) {
                return;
            }
            jkVar.nr();
            return;
        }
        this.iz.fx();
    }
}
