package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ClickInteractView extends FrameLayout {
    private AnimatorSet nr;
    private ImageView u;

    public ClickInteractView(Context context) {
        super(context);
        fx();
        b();
    }

    private void b() {
        this.nr = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.u, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.u, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.nr.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void fx() {
        ImageView imageView = new ImageView(getContext());
        this.u = imageView;
        imageView.setImageResource(q.pn(getContext(), "tt_white_hand"));
        int iU = (int) n.u(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iU, iU);
        layoutParams.gravity = 17;
        addView(this.u, layoutParams);
    }

    public void nr() {
        AnimatorSet animatorSet = this.nr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void u() {
        AnimatorSet animatorSet = this.nr;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }
}
