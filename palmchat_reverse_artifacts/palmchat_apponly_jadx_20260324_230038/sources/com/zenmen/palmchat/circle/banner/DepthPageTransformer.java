package com.zenmen.palmchat.circle.banner;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DepthPageTransformer extends ABaseTransformer {
    @Override // com.zenmen.palmchat.circle.banner.ABaseTransformer
    public boolean b() {
        return true;
    }

    @Override // com.zenmen.palmchat.circle.banner.ABaseTransformer
    public void e(View view, float f) {
        if (f <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            float fAbs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
            view.setAlpha(1.0f - f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
        }
    }
}
