package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.b
    public void a(int i) {
        super.a(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.b
    public void n(int i) {
        super.n(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View u(int i, int i2) {
        if (this.u.isEmpty()) {
            return new View(getContext());
        }
        View viewX = x(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewX instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewX.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewX.getParent()).removeView(viewX);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewX, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View x(int i) {
        return (ViewGroup) this.u.get(i);
    }
}
