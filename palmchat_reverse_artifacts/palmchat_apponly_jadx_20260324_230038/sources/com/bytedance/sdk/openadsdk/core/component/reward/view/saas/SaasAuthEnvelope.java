package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.n.fx;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.n.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SaasAuthEnvelope extends RelativeLayout {
    private ImageView fx;
    private ImageView nr;
    private AnimationSet u;

    public SaasAuthEnvelope(@NonNull Context context) {
        super(context);
        u(context);
        setVisibility(8);
    }

    private void u(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.fx = new ImageView(context);
        try {
            nr.u(fx.u("saas_red_envelope.webp")).to(this.fx);
        } catch (Error unused) {
        }
        linearLayout.addView(this.fx, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.nr = imageView;
        try {
            imageView.setImageResource(q.pn(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = y.fx(context, 25.0f);
        linearLayout.addView(this.nr, layoutParams2);
    }

    public void nr() {
        AnimationSet animationSet = this.u;
        if (animationSet != null) {
            animationSet.cancel();
            this.u = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nr();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.nr;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void u() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.u = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.u.addAnimation(scaleAnimation);
        startAnimation(this.u);
    }
}
