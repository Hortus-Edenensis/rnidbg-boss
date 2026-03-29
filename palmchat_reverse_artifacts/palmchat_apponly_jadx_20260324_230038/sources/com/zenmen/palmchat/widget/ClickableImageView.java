package com.zenmen.palmchat.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.daasuu.ei.Ease;
import defpackage.wj1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ClickableImageView extends ImageView {
    private static final float SCALE_PRESSED = 0.7f;
    private AnimatorSet animatorSet;

    public ClickableImageView(Context context) {
        super(context);
    }

    private void startAnimation(boolean z) {
        stopAnimation();
        float[] fArr = new float[2];
        fArr[0] = getScaleX();
        fArr[1] = z ? 0.7f : 1.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = getScaleY();
        fArr2[1] = z ? 0.7f : 1.0f;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", fArr2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        if (z) {
            this.animatorSet.setInterpolator(new DecelerateInterpolator());
            this.animatorSet.setDuration(100L);
        } else {
            this.animatorSet.setInterpolator(new wj1(Ease.BACK_OUT));
            this.animatorSet.setDuration(300L);
        }
        this.animatorSet.start();
    }

    private void stopAnimation() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        startAnimation(z);
    }

    public ClickableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
