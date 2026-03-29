package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends nr {
    private float k;
    private FullSwiperView my;
    private float s;

    public jk(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
    }

    public void b() {
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            fullSwiperView.b();
        }
    }

    public void fx() {
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            fullSwiperView.fx();
        }
    }

    public void iz() {
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            fullSwiperView.x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void jk() {
        super.jk();
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            fullSwiperView.pn();
        }
    }

    public void nr() {
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            fullSwiperView.nr();
        }
    }

    public int pn() {
        FullSwiperView fullSwiperView = this.my;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void u(float[] fArr) {
        this.s = fArr[0];
        this.k = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.x.setBackgroundColor(0);
        this.my = new FullSwiperView(this.nr);
    }

    public void u(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.u> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.my.u(list).u(this.s).nr(this.k).u(String.valueOf(jp.t(this.fx))).u();
        this.x.addView(this.my, new FrameLayout.LayoutParams(-1, -1));
    }
}
