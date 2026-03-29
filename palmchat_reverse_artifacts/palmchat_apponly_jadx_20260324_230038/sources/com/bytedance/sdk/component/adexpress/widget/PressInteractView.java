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
public class PressInteractView extends FrameLayout {
    private AnimatorSet b;
    private SplashDiffuseView fx;
    private TextView iz;
    private ImageView nr;
    private boolean pn;
    private Context u;

    public PressInteractView(Context context) {
        super(context);
        this.pn = true;
        this.u = context;
        this.b = new AnimatorSet();
        fx();
        b();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iU = (int) n.u(PressInteractView.this.u, 50.0f);
                int iU2 = (int) n.u(PressInteractView.this.u, 50.0f);
                if (PressInteractView.this.fx.getMeasuredHeight() > 0) {
                    iU = PressInteractView.this.fx.getMeasuredHeight();
                }
                if (PressInteractView.this.fx.getMeasuredWidth() > 0) {
                    iU2 = PressInteractView.this.fx.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.nr.getLayoutParams();
                layoutParams.topMargin = ((int) ((iU / 2.0f) - n.u(PressInteractView.this.getContext(), 5.0f))) + ((int) n.u(PressInteractView.this.u, 40.0f));
                layoutParams.leftMargin = ((int) ((iU2 / 2.0f) - n.u(PressInteractView.this.getContext(), 5.0f))) + ((int) n.u(PressInteractView.this.u, 20.0f));
                layoutParams.bottomMargin = (int) (((-iU) / 2.0f) + n.u(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iU2) / 2.0f) + n.u(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.nr.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.iz.setVisibility(0);
        this.iz.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.iz.setTextColor(i);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.pn) {
                    PressInteractView.this.fx.u();
                }
                PressInteractView.this.pn = !r2.pn;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.nr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.nr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.nr, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void fx() {
        this.fx = new SplashDiffuseView(this.u);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) n.u(this.u, 50.0f), (int) n.u(this.u, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) n.u(this.u, 40.0f);
        int iU = (int) n.u(this.u, 20.0f);
        layoutParams.leftMargin = iU;
        layoutParams.setMarginStart(iU);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.fx, layoutParams);
        this.nr = new ImageView(this.u);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) n.u(this.u, 78.0f), (int) n.u(this.u, 78.0f));
        this.nr.setImageResource(q.pn(this.u, "tt_splash_hand"));
        addView(this.nr, layoutParams2);
        TextView textView = new TextView(this.u);
        this.iz = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) n.u(this.u, 10.0f);
        addView(this.iz, layoutParams3);
        this.iz.setVisibility(8);
    }

    public void nr() {
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.fx;
        if (splashDiffuseView != null) {
            splashDiffuseView.nr();
        }
        ImageView imageView = this.nr;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void u() {
        this.b.start();
    }
}
