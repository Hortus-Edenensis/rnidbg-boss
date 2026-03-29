package com.bytedance.adsdk.ugeno.swiper.u;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u implements ViewPager.pn {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.pn
    public void u(View view, float f) {
        view.setPivotX(f < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}
