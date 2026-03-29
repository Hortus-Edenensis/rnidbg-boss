package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SplashClickBarArrow extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f5252a;
    private ImageView b;
    private ImageView fx;
    private FrameLayout iz;
    private boolean jk;
    private AnimatorSet l;
    private SplashDiffuseView n;
    private RelativeLayout nr;
    private ImageView pn;
    private int t;
    private ImageView u;
    private ImageView x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Interpolator {
        private u() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SplashClickBarArrow(Context context) {
        super(context);
        this.jk = true;
        this.l = new AnimatorSet();
        nr(context);
    }

    public Animator getAnimator() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.l;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            k.u(e.getMessage());
        }
    }

    private void fx() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.jk) {
                    SplashClickBarArrow.this.n.u();
                }
                SplashClickBarArrow.this.jk = !r2.jk;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.x, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.x.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.x, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.l.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.l.setStartDelay(1000L);
    }

    private void nr(Context context) {
        View viewU = u(getContext());
        if (viewU == null) {
            return;
        }
        addView(viewU);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.n = splashDiffuseView;
        this.iz.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.n.setVisibility(4);
    }

    public void u(int i) {
        this.t = i;
        u();
    }

    private View u(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.u = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.u.setId(2114387592);
        layoutParams2.gravity = 16;
        u(context, "tt_splash_click_bar_go", this.u, true);
        this.u.setLayoutParams(layoutParams2);
        frameLayout.addView(this.u);
        y.u((View) this.u, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.nr = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.nr.setPadding(y.fx(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.nr);
        y.u((View) this.nr, 8);
        ImageView imageView = new ImageView(context);
        this.fx = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.fx.setAlpha(0.0f);
        u(context, "tt_splash_arrow", this.fx, false);
        this.fx.setLayoutParams(layoutParams3);
        this.nr.addView(this.fx);
        ImageView imageView2 = new ImageView(context);
        this.b = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.b.setAlpha(0.0f);
        u(context, "tt_splash_arrow", this.b, true);
        this.b.setLayoutParams(layoutParams4);
        this.nr.addView(this.b);
        ImageView imageView3 = new ImageView(context);
        this.pn = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.pn.setAlpha(0.0f);
        u(context, "tt_splash_arrow", this.pn, true);
        this.pn.setLayoutParams(layoutParams5);
        this.nr.addView(this.pn);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.nr.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.iz = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.iz.setClipChildren(false);
        this.iz.setLayoutParams(layoutParams6);
        frameLayout.addView(this.iz);
        y.u((View) this.iz, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f5252a = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.f5252a.setClipChildren(false);
        this.f5252a.setLayoutParams(layoutParams7);
        this.iz.addView(this.f5252a);
        ImageView imageView4 = new ImageView(context);
        this.x = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        u(context, "tt_splash_hand", this.x, false);
        this.x.setLayoutParams(layoutParams8);
        this.f5252a.addView(this.x);
        y.u((View) this.x, 4);
        return frameLayout;
    }

    private void nr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fx, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new u());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.fx, "translationX", 0.0f, y.fx(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new u());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.b, "translationX", y.fx(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.pn, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new u());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.pn, "translationX", y.fx(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.l.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void u() {
        this.u.setVisibility(8);
        this.nr.setVisibility(8);
        int i = this.t;
        if (i == 1) {
            this.nr.setVisibility(0);
            nr();
            return;
        }
        if (i == 2) {
            this.iz.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.f5252a.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.n.getMeasuredHeight() / 2.0f) - y.fx(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.n.getMeasuredWidth() / 2.0f) - y.fx(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.n.getMeasuredHeight()) / 2.0f) + y.fx(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.n.getMeasuredWidth()) / 2.0f) + y.fx(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.f5252a.setLayoutParams(layoutParams);
                }
            });
            fx();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.u.setVisibility(0);
        }
    }

    private void u(final Context context, final String str, final ImageView imageView, final boolean z) {
        jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableFx = q.fx(context, str);
                jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        try {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ImageView imageView2 = imageView;
                            if (imageView2 == null || (drawable = drawableFx) == null) {
                                return;
                            }
                            if (z) {
                                imageView2.setBackground(drawable);
                            } else {
                                imageView2.setImageDrawable(drawable);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }
}
