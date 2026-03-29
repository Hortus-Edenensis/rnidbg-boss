package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.ugeno.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UgenLottieView extends LottieAnimationView {
    private fx u;

    public UgenLottieView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    public void u(fx fxVar) {
        this.u = fxVar;
    }
}
