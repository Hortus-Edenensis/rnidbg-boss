package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RockView extends LinearLayout {
    private TextView fx;
    private TextView nr;
    private ImageView u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Interpolator {
        private u() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }
    }

    public RockView(Context context) {
        super(context);
        nr(context);
    }

    private void nr(Context context) {
        if (context == null) {
            context = dw.getContext();
        }
        View viewU = u(context);
        if (viewU == null) {
            return;
        }
        addView(viewU);
    }

    private View u(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int iFx = y.fx(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(iFx);
        shapeDrawable.setIntrinsicWidth(iFx);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.u = imageView;
        imageView.setId(2114387566);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        Drawable drawableFx = q.fx(context, "tt_splash_rock");
        if (drawableFx != null) {
            this.u.setImageDrawable(drawableFx);
        } else {
            com.bytedance.sdk.openadsdk.n.nr.u(com.bytedance.sdk.openadsdk.core.n.fx.u("splash_rock.png")).to(this.u);
        }
        this.u.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.u);
        TextView textView = new TextView(context);
        this.nr = textView;
        textView.setId(2114387564);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.nr.setSingleLine();
        this.nr.setText(q.u(context, "tt_splash_rock_top"));
        this.nr.setTextColor(-1);
        this.nr.setTextSize(14.0f);
        this.nr.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.nr);
        TextView textView2 = new TextView(context);
        this.fx = textView2;
        textView2.setId(2114387563);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = y.fx(context, 12.0f);
        this.fx.setLayoutParams(layoutParams5);
        this.fx.setText(q.u(context, "tt_splash_rock_desc"));
        this.fx.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.fx.setTextColor(-1);
        linearLayout.addView(this.fx);
        return linearLayout;
    }

    public void u(mk mkVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.nr;
        if (textView != null) {
            textView.setText(mkVar.t());
            this.nr.setTextSize(2, mkVar.mv().nr());
        }
        TextView textView2 = this.fx;
        if (textView2 != null) {
            textView2.setText(mkVar.nr());
            this.fx.setTextSize(2, mkVar.l().nr());
            this.fx.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void u() {
        if (this.u != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new u());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.u.startAnimation(rotateAnimation);
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
            this.u.startAnimation(rotateAnimation);
        }
    }
}
