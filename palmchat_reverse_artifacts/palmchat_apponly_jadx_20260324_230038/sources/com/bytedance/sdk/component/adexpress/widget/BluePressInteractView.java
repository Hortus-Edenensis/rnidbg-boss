package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.component.utils.q;
import com.igexin.push.config.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BluePressInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5105a;
    private View b;
    private boolean fx;
    private View iz;
    private Context jk;
    private int n;
    private ObjectAnimator nr;
    private View pn;
    private AnimatorSet u;
    private ImageView x;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.fx = false;
        this.u = new AnimatorSet();
        this.n = i;
        this.f5105a = i2;
        this.jk = context;
        fx();
        b();
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.pn, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.pn, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.iz, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.iz, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.x, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, -20.0f, 0.0f);
        this.nr = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.u.setDuration(c.j);
        this.u.setInterpolator(new AccelerateDecelerateInterpolator());
        this.u.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.u.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.fx = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.fx) {
                    return;
                }
                BluePressInteractView.this.nr.start();
                BluePressInteractView.this.u.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void fx() {
        View view = new View(this.jk);
        this.b = view;
        view.setBackground(u("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.n) * 0.45d), (int) (((double) this.f5105a) * 0.45d));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        View view2 = new View(this.jk);
        this.pn = view2;
        view2.setBackground(u("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.n) * 0.25d), (int) (((double) this.f5105a) * 0.25d));
        layoutParams2.gravity = 17;
        this.pn.setLayoutParams(layoutParams2);
        addView(this.pn);
        View view3 = new View(this.jk);
        this.iz = view3;
        view3.setBackground(u("#807BBEFF", "#FF7BBEFF"));
        int i = this.n;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.iz.setLayoutParams(layoutParams3);
        addView(this.iz);
        ImageView imageView = new ImageView(this.jk);
        this.x = imageView;
        imageView.setImageResource(q.pn(getContext(), "tt_blue_hand"));
        this.x.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.n) * 0.62d), (int) (((double) this.f5105a) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.x.setLayoutParams(layoutParams4);
        addView(this.x);
    }

    public void nr() {
        this.fx = true;
        ObjectAnimator objectAnimator = this.nr;
        if (objectAnimator == null || this.u == null) {
            return;
        }
        objectAnimator.cancel();
        this.u.cancel();
    }

    private GradientDrawable u(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void u() {
        this.fx = false;
        ObjectAnimator objectAnimator = this.nr;
        if (objectAnimator == null || this.u == null) {
            return;
        }
        objectAnimator.start();
        this.u.start();
    }
}
