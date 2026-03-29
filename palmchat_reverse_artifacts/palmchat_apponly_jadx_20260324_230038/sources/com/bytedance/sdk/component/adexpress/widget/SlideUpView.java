package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.k;
import com.igexin.push.config.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SlideUpView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f5113a;
    private TextView b;
    private ImageView fx;
    private AnimatorSet iz;
    private String jk;
    private AnimatorSet n;
    private ImageView nr;
    private TextView pn;
    private int t;
    private ImageView u;
    private AnimatorSet x;

    public SlideUpView(Context context) {
        super(context);
        this.iz = new AnimatorSet();
        this.x = new AnimatorSet();
        this.n = new AnimatorSet();
        this.f5113a = new AnimatorSet();
        this.t = 100;
        u(context);
    }

    public void fx() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.u, "translationY", 0.0f, n.u(getContext(), -this.t));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) n.u(getContext(), this.t));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.fx != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.fx.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.fx.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.fx, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.fx, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.nr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.nr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.nr, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.nr, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.nr, "translationY", 0.0f, n.u(getContext(), -this.t));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.x.setDuration(50L);
        this.f5113a.setDuration(c.j);
        this.n.setDuration(50L);
        this.x.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.n.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.f5113a.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.iz.playSequentially(this.n, this.f5113a, this.x);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.iz;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nr();
    }

    public void setGuideText(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.pn != null) {
            if (TextUtils.isEmpty(str)) {
                this.pn.setText("");
            } else {
                this.pn.setText(str);
            }
        }
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
            AnimatorSet animatorSet3 = this.x;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f5113a;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            k.u(e.getMessage());
        }
    }

    public void u(Context context) {
        if (context == null) {
            context = b.getContext();
        }
        if ("5".equals(this.jk)) {
            addView(com.bytedance.sdk.component.adexpress.fx.u.iz(context));
            this.t = (int) (((double) this.t) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.fx.u.pn(context));
        }
        this.u = (ImageView) findViewById(2097610734);
        this.nr = (ImageView) findViewById(2097610735);
        this.b = (TextView) findViewById(2097610730);
        this.fx = (ImageView) findViewById(2097610733);
        this.pn = (TextView) findViewById(2097610731);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.iz = new AnimatorSet();
        this.x = new AnimatorSet();
        this.n = new AnimatorSet();
        this.f5113a = new AnimatorSet();
        this.t = 100;
        setClipChildren(false);
        this.jk = str;
        u(context);
    }

    public void u() {
        fx();
        this.iz.start();
        this.iz.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.iz.start();
                    }
                }, 200L);
            }
        });
    }
}
