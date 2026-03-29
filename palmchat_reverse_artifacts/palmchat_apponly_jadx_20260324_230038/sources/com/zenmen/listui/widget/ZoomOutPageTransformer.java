package com.zenmen.listui.widget;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    @SuppressLint({"NewApi"})
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        Log.e("TAG", view + " , " + f + "");
        if (f < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float fMax = Math.max(0.85f, 1.0f - Math.abs(f));
        float f2 = 1.0f - fMax;
        float f3 = (height * f2) / 2.0f;
        float f4 = (width * f2) / 2.0f;
        if (f < 0.0f) {
            view.setTranslationX(f4 - (f3 / 2.0f));
        } else {
            view.setTranslationX((-f4) + (f3 / 2.0f));
        }
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.setAlpha((((fMax - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
    }
}
