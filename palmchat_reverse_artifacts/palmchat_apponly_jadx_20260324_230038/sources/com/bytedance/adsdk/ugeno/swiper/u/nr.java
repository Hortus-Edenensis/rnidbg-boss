package com.bytedance.adsdk.ugeno.swiper.u;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr implements ViewPager.pn {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.pn
    public void u(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f < 0.0f) {
            view.setTranslationX((-width) * f);
        } else {
            view.setTranslationX(width);
            view.setTranslationX((-width) * f);
        }
        view.setAlpha(Math.max(0.0f, 1.0f - Math.abs(f)));
    }
}
