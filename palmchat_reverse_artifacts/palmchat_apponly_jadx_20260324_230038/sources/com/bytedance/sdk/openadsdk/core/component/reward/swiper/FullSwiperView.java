package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.my.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FullSwiperView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f5244a;
    private float b;
    private TTBaseVideoActivity fx;
    private String iz;
    private List<Long> jk;
    private AtomicBoolean k;
    private int l;
    private boolean mv;
    private List<Integer> n;
    private List<u> nr;
    private float pn;
    private boolean s;
    private List<FullSwiperItemView> t;
    private BaseSwiper<ViewGroup> u;
    private boolean x;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.x = false;
        this.mv = true;
        this.s = true;
        this.k = new AtomicBoolean(false);
        this.fx = tTBaseVideoActivity;
        this.n = new ArrayList();
        this.f5244a = new ArrayList();
        this.jk = new ArrayList();
        this.u = new SwiperView(tTBaseVideoActivity);
        this.t = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.u, layoutParams);
    }

    public int getCurrentPosition() {
        return this.l;
    }

    public void b() {
        iz();
    }

    public void iz() {
        BaseSwiper<ViewGroup> baseSwiper = this.u;
        if (baseSwiper != null) {
            baseSwiper.iz();
        }
    }

    public void pn() {
        for (FullSwiperItemView fullSwiperItemView : this.t) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.bg();
            }
        }
    }

    public void x() {
        BaseSwiper<ViewGroup> baseSwiper = this.u;
        if (baseSwiper != null) {
            baseSwiper.jk(this.l + 1);
        }
    }

    public void fx() {
        FullSwiperItemView fullSwiperItemViewFx = fx(this.l);
        if (fullSwiperItemViewFx != null) {
            fullSwiperItemViewFx.o();
        }
        if (this.l == this.t.size() - 1) {
            return;
        }
        this.u.jk(this.l);
        List<Integer> list = this.f5244a;
        if (list == null || this.l >= list.size()) {
            return;
        }
        if (!this.mv && (!this.k.get() || ja.s() == 1)) {
            u(this.f5244a.get(this.l).intValue());
        }
        this.mv = false;
    }

    public FullSwiperView nr(float f) {
        this.pn = f;
        return this;
    }

    public FullSwiperView u(List<u> list) {
        this.nr = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i) {
        FullSwiperItemView fullSwiperItemViewFx = fx(i);
        if (fullSwiperItemViewFx != null) {
            fullSwiperItemViewFx.s();
        }
    }

    public FullSwiperView u(float f) {
        this.b = f;
        return this;
    }

    public FullSwiperView u(String str) {
        this.iz = str;
        return this;
    }

    public void nr() {
        FullSwiperItemView fullSwiperItemViewFx = fx(this.l);
        if (fullSwiperItemViewFx != null) {
            fullSwiperItemViewFx.my();
        }
        List<Long> list = this.jk;
        if (list != null && this.l < list.size()) {
            this.f5244a.add(this.l, Integer.valueOf(this.n.get(this.l).intValue() - ((int) (System.currentTimeMillis() - this.jk.get(this.l).longValue()))));
        }
        iz();
    }

    public void u() {
        gi giVarTw;
        List<u> list = this.nr;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.u.u(false).u(TtmlNode.TEXT_EMPHASIS_MARK_DOT).b(false).fx(false).nr(false);
        this.u.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.swiper.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.swiper.u
            public void u(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (FullSwiperView.this.s && i == 1) {
                    return;
                }
                FullSwiperView.this.s = false;
                FullSwiperView.this.l = i;
                FullSwiperItemView fullSwiperItemViewFx = FullSwiperView.this.fx(i);
                if (fullSwiperItemViewFx != null && FullSwiperView.this.l != 0) {
                    fullSwiperItemViewFx.nr(false);
                }
                FullSwiperItemView fullSwiperItemViewFx2 = FullSwiperView.this.fx(i - 1);
                if (fullSwiperItemViewFx2 != null) {
                    fullSwiperItemViewFx2.my();
                    fullSwiperItemViewFx2.sx();
                }
                FullSwiperView.this.nr(i + 1);
                if (!FullSwiperView.this.x && i > 0) {
                    FullSwiperView.this.x = true;
                    b.nr(FullSwiperView.this.iz);
                }
                int iIntValue = ((Integer) FullSwiperView.this.n.get(i)).intValue();
                if (iIntValue > 0 && i != FullSwiperView.this.t.size() - 1) {
                    FullSwiperView.this.jk.add(i, Long.valueOf(System.currentTimeMillis()));
                    int i3 = iIntValue / 1000;
                    int iMin = Math.min(ja.nr(false), i3);
                    int iMax = Math.max(i3 - ja.nr(false), 0);
                    if (iMin > 0) {
                        FullSwiperView.this.k.set(false);
                        FullSwiperView.this.fx.u(-1, iMin, iMax);
                    } else if (ja.s() == 1) {
                        FullSwiperView.this.u(iIntValue);
                    } else {
                        if (FullSwiperView.this.k.get()) {
                            return;
                        }
                        FullSwiperView.this.u(iIntValue);
                    }
                }
            }
        });
        for (u uVar : this.nr) {
            bc bcVarU = uVar.u();
            if (bcVarU != null && (giVarTw = bcVarU.tw()) != null) {
                this.n.add(Integer.valueOf((int) giVarTw.nr()));
                this.f5244a.add(0);
                this.jk.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.fx, uVar, this.b, this.pn);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.u
                    public void u() {
                        if (ja.s() == 0) {
                            FullSwiperView.this.iz();
                            FullSwiperView.this.fx.mk();
                        }
                        FullSwiperView.this.k.set(true);
                    }
                });
                this.u.u(fullSwiperItemView);
                this.t.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.t.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.nr
            public void u(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.n.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.u.pn();
                } else {
                    FullSwiperView.this.jk.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.u.pn();
                    if (FullSwiperView.this.t.size() > 1) {
                        int i = iIntValue / 1000;
                        int iMin = Math.min(ja.nr(false), i);
                        int iMax = Math.max(i - ja.nr(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.fx.u(-1, iMin, iMax);
                        } else {
                            FullSwiperView.this.u(iIntValue);
                        }
                    }
                }
                fullSwiperItemView2.nr(true);
                FullSwiperView.this.nr(1);
            }
        });
        fullSwiperItemView2.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView fx(int i) {
        List<FullSwiperItemView> list = this.t;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.t.get(i);
    }

    public void u(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(ja.nr(false), i / 1000) <= 0 && (baseSwiper = this.u) != null) {
            baseSwiper.t(i);
        }
    }
}
