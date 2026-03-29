package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.q;
import com.igexin.push.config.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SlideRightView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f5112a;
    private ImageView b;
    private ImageView fx;
    private AnimatorSet iz;
    private AnimatorSet n;
    private ImageView nr;
    private TextView pn;
    private Context u;
    private AnimatorSet x;

    public SlideRightView(Context context) {
        super(context);
        this.iz = new AnimatorSet();
        this.x = new AnimatorSet();
        this.n = new AnimatorSet();
        this.f5112a = new AnimatorSet();
        this.u = context;
        fx();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setGuideText(String str) {
        this.pn.setText(str);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.fx, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.fx, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f);
        this.n.setDuration(300L);
        this.n.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.nr, "translationX", 0.0f, n.u(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) n.u(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.b.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.b.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.fx, "translationX", 0.0f, n.u(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f5112a.setDuration(c.j);
        this.f5112a.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.nr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.fx, "alpha", 1.0f, 0.0f);
        this.x.setDuration(50L);
        this.x.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.iz.playSequentially(this.n, this.f5112a, this.x);
    }

    private void fx() {
        ImageView imageView = new ImageView(this.u);
        this.b = imageView;
        imageView.setBackgroundResource(q.pn(this.u, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) n.u(this.u, 30.0f);
        addView(this.b, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.u);
        this.fx = imageView2;
        imageView2.setImageResource(q.pn(this.u, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) n.u(this.u, 50.0f), (int) n.u(this.u, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) n.u(this.u, 30.0f);
        addView(this.fx, layoutParams2);
        ImageView imageView3 = new ImageView(this.u);
        this.nr = imageView3;
        imageView3.setImageResource(q.pn(this.u, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) n.u(this.u, 80.0f), (int) n.u(this.u, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) n.u(this.u, 30.0f);
        addView(this.nr, layoutParams3);
        TextView textView = new TextView(this.u);
        this.pn = textView;
        textView.setTextColor(-1);
        this.pn.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.pn, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.nr.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.fx.getMeasuredHeight() / 2.0f) - n.u(SlideRightView.this.getContext(), 7.0f));
                int iU = (-SlideRightView.this.fx.getMeasuredWidth()) + ((int) n.u(SlideRightView.this.u, 30.0f));
                layoutParams5.leftMargin = iU;
                layoutParams5.setMarginStart(iU);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.nr.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.b.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.fx.getMeasuredHeight() / 2.0f) - n.u(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.fx.getMeasuredWidth() / 2.0f) + ((int) n.u(SlideRightView.this.u, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.b.setLayoutParams(layoutParams6);
            }
        });
    }

    public void nr() {
        try {
            AnimatorSet animatorSet = this.iz;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.n;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.f5112a;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.x;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void u() {
        b();
        this.iz.start();
        this.iz.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.iz.start();
                    }
                }, 200L);
            }
        });
    }
}
