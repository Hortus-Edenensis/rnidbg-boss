package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PressButtonInteractView extends FrameLayout {
    private AnimatorSet b;
    private SplashDiffuseView fx;
    private ImageView nr;
    private boolean pn;
    private Context u;

    public PressButtonInteractView(Context context) {
        super(context);
        this.pn = true;
        this.u = context;
        this.b = new AnimatorSet();
        fx();
        b();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.nr.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.fx.getMeasuredHeight() / 2.0f) - n.u(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.fx.getMeasuredWidth() / 2.0f) - n.u(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.fx.getMeasuredHeight()) / 2.0f) + n.u(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.fx.getMeasuredWidth()) / 2.0f) + n.u(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.nr.setLayoutParams(layoutParams);
            }
        });
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.pn) {
                    PressButtonInteractView.this.fx.u();
                }
                PressButtonInteractView.this.pn = !r2.pn;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.nr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.nr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.nr, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void fx() {
        this.fx = new SplashDiffuseView(this.u);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) n.u(this.u, 40.0f), (int) n.u(this.u, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.fx, layoutParams);
        this.nr = new ImageView(this.u);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) n.u(this.u, 62.0f), (int) n.u(this.u, 62.0f));
        layoutParams2.gravity = 16;
        this.nr.setImageResource(q.pn(this.u, "tt_splash_hand"));
        addView(this.nr, layoutParams2);
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
