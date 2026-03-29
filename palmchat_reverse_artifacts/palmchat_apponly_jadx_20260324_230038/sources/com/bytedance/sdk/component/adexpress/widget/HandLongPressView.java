package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class HandLongPressView extends FrameLayout {
    private AnimatorSet b;
    private CircleRippleView fx;
    private TextView iz;
    private ImageView nr;
    private boolean pn;
    private Context u;

    public HandLongPressView(Context context) {
        super(context);
        this.pn = true;
        this.u = context;
        this.b = new AnimatorSet();
        fx();
        b();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.nr.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.fx.getMeasuredHeight() / 2.0f) - n.u(HandLongPressView.this.getContext(), 5.0f))) + ((int) n.u(HandLongPressView.this.u, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.fx.getMeasuredWidth() / 2.0f) - n.u(HandLongPressView.this.getContext(), 5.0f))) + ((int) n.u(HandLongPressView.this.u, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.fx.getMeasuredHeight()) / 2.0f) + n.u(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.fx.getMeasuredWidth()) / 2.0f) + n.u(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.nr.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.iz.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.iz.setTextColor(i);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.pn) {
                    HandLongPressView.this.fx.u();
                    HandLongPressView.this.fx.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.fx.nr();
                    HandLongPressView.this.fx.setAlpha(0.0f);
                }
                HandLongPressView.this.pn = !r2.pn;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.nr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                HandLongPressView.this.nr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.nr, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void fx() {
        this.fx = new CircleRippleView(this.u);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) n.u(this.u, 80.0f), (int) n.u(this.u, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) n.u(this.u, 20.0f);
        int iU = (int) n.u(this.u, 20.0f);
        layoutParams.leftMargin = iU;
        layoutParams.setMarginStart(iU);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.fx, layoutParams);
        this.fx.u();
        this.nr = new ImageView(this.u);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) n.u(this.u, 80.0f), (int) n.u(this.u, 80.0f));
        this.nr.setImageResource(q.pn(this.u, "tt_splash_hand"));
        addView(this.nr, layoutParams2);
        TextView textView = new TextView(this.u);
        this.iz = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) n.u(this.u, 10.0f);
        addView(this.iz, layoutParams3);
    }

    public void nr() {
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.fx;
        if (circleRippleView != null) {
            circleRippleView.nr();
        }
    }

    public void u() {
        this.b.start();
    }
}
