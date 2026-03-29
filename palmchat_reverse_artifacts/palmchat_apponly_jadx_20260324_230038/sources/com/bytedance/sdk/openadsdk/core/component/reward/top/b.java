package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends fx {
    public b(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, nrVar, pnVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void fx(View view) {
        super.fx(view);
        this.iz.fx(this.b.m());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void iz(View view) {
        super.iz(view);
        u(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void nr(View view) {
        super.nr(view);
        this.iz.pb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.fx, com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void u(View view) {
        super.u(view);
        if (u()) {
            return;
        }
        this.iz.mh().nr();
        if (this.b.y()) {
            this.iz.nr();
        } else if (this.iz.yd().yd()) {
            nr();
        } else {
            fx();
        }
    }

    private void nr() {
        jk jkVar = new jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.b.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                b.this.iz.nr();
            }
        };
        if (u(jkVar)) {
            this.x--;
        } else {
            jkVar.nr();
        }
    }

    private void fx() {
        this.iz.nr();
    }
}
