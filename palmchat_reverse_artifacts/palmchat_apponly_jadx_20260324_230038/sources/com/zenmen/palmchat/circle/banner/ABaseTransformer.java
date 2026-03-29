package com.zenmen.palmchat.circle.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ABaseTransformer implements ViewPager.PageTransformer {
    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void d(View view, float f) {
        float width = view.getWidth();
        float f2 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(b() ? 0.0f : (-width) * f);
        if (!a()) {
            view.setAlpha(1.0f);
            return;
        }
        if (f > -1.0f && f < 1.0f) {
            f2 = 1.0f;
        }
        view.setAlpha(f2);
    }

    public abstract void e(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        d(view, f);
        e(view, f);
        c(view, f);
    }

    public void c(View view, float f) {
    }
}
