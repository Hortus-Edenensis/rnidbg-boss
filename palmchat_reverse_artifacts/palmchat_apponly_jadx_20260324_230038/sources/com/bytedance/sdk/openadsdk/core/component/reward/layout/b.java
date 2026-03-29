package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardDrawRecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends nr {
    private float bg;
    private float bq;
    private boolean c;
    private boolean dw;
    private RewardGuideSlideUp k;
    private RewardDrawRecyclerView my;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.u o;
    private boolean s;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.fx sx;

    public b(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
        this.dw = true;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.fx b() {
        return this.sx;
    }

    public void iz() {
        if (this.s) {
            this.dw = false;
            if (this.c) {
                y.u((View) this.k, 8);
                RewardGuideSlideUp rewardGuideSlideUp = this.k;
                if (rewardGuideSlideUp != null) {
                    rewardGuideSlideUp.nr();
                }
                this.c = false;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void jk() {
        super.jk();
        iz();
    }

    public void pn() {
        if (this.s && this.dw) {
            this.x.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.s && b.this.dw) {
                        b.this.dw = false;
                        y.u((View) b.this.k, 0);
                        b.this.k.getSlideUpAnimatorSet().start();
                        b.this.c = true;
                        b.this.x.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.iz();
                            }
                        }, 3000L);
                    }
                }
            }, 0L);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.u fx() {
        return this.o;
    }

    public RecyclerView nr() {
        return this.my;
    }

    public void u(float[] fArr) {
        this.bg = fArr[0];
        this.bq = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.my = (RewardDrawRecyclerView) this.x.findViewById(2114387885);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.fx(this.nr, 0, false);
        this.sx = fxVar;
        this.my.setLayoutManager(fxVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.u(this.nr, this.bg, this.bq);
        this.o = uVar;
        this.my.setAdapter(uVar);
        if (this.s) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.x.findViewById(2114387966);
            this.k = rewardGuideSlideUp;
            rewardGuideSlideUp.u();
        }
    }

    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.fx fxVar = this.sx;
        if (fxVar == null) {
            return;
        }
        fxVar.nr(false);
    }
}
