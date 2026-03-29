package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.jk;
import com.bytedance.sdk.component.utils.qq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ShakeAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f5111a;
    private ImageView b;
    private TextView fx;
    private TextView iz;
    private jk jk;
    private boolean l;
    private u n;
    private TextView nr;
    private qq pn;
    private boolean t;
    public int u;
    private TextView x;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.b != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new nr(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.b.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                ShakeAnimationView.this.b.startAnimation(rotateAnimation);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements Interpolator {
        private nr() {
        }

        public /* synthetic */ nr(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(boolean z);
    }

    public ShakeAnimationView(Context context, View view, jk jkVar, boolean z, int i, boolean z2) {
        super(context);
        this.jk = jkVar;
        this.t = z;
        this.u = i;
        this.l = z2;
        u(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.f5111a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.pn == null) {
                this.pn = new qq(getContext().getApplicationContext(), 1, this.t, this.l);
            }
            this.pn.u(new qq.u() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.qq.u
                public void u(int i) {
                    boolean zU = ShakeAnimationView.this.pn != null ? ShakeAnimationView.this.pn.u() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.n != null) {
                        ShakeAnimationView.this.n.u(zU);
                    }
                }
            });
            if (this.jk != null) {
                this.pn.u(r0.u());
                this.pn.fx(this.jk.x());
                this.pn.fx(this.jk.nr());
                this.pn.pn(this.jk.b());
                this.pn.nr(this.jk.fx());
                this.pn.iz(this.jk.pn());
                this.pn.u(this.jk.iz());
                this.pn.nr(this.jk.n());
                this.pn.u(this.u);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qq qqVar = this.pn;
        if (qqVar != null) {
            qqVar.nr(this.u);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        qq qqVar = this.pn;
        if (qqVar != null) {
            if (z) {
                qqVar.u(this.u);
            } else {
                qqVar.nr(this.u);
            }
        }
    }

    public void setOnShakeViewListener(u uVar) {
        this.n = uVar;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iz.setText(str);
        } else {
            this.iz.setVisibility(8);
            this.x.setVisibility(8);
        }
    }

    public void u(Context context, View view) {
        addView(view);
        this.f5111a = (LinearLayout) findViewById(2097610727);
        this.b = (ImageView) findViewById(2097610725);
        this.nr = (TextView) findViewById(2097610724);
        this.fx = (TextView) findViewById(2097610726);
        this.iz = (TextView) findViewById(2097610723);
        this.x = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f5111a.setBackground(gradientDrawable);
    }

    public void u() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}
