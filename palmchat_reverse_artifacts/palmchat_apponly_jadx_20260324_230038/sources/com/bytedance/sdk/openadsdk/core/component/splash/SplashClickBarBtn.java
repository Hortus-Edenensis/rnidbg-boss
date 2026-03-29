package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.y.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SplashClickBarBtn extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SplashClickBarArrow f5253a;
    private TextView b;
    private bc bf;
    private LinearGradient bg;
    private int[] bq;
    private qq c;
    private JSONObject d;
    private boolean dw;
    private TextView fx;
    private JSONObject gi;
    private JSONObject h;
    private RelativeLayout iz;
    private int ja;
    private SlideUpView jk;
    private Paint k;
    private float kj;
    private AnimatorSet l;
    private Path mv;
    private final AnimatorSet my;
    private LinearLayout n;
    private mk nr;
    private final ValueAnimator o;
    private LottieAnimationView pn;
    private com.bytedance.sdk.openadsdk.core.nr.u q;
    private float qq;
    private int rh;
    private Rect s;
    private final ValueAnimator sx;
    private RockView t;
    private GradientDrawable u;
    private RelativeLayout x;
    private float z;

    public SplashClickBarBtn(Context context, bc bcVar) {
        super(context);
        this.nr = new mk();
        this.my = new AnimatorSet();
        this.o = new ValueAnimator();
        this.sx = new ValueAnimator();
        this.bq = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.dw = false;
        this.qq = 13.0f;
        this.z = 50.0f;
        this.bf = bcVar;
        pn();
    }

    private void jk() {
        mk mkVar = this.nr;
        if (mkVar == null || mkVar.a() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.jk == null) {
                    return;
                }
                SplashClickBarBtn.this.jk.u();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.jk.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }, 500L);
    }

    public Animator getAnimator() {
        return this.my;
    }

    public qq getShakeUtils() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.u();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qq qqVar = this.c;
        if (qqVar != null) {
            bc bcVar = this.bf;
            qqVar.nr(bcVar != null ? bcVar.n() : 0);
        }
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.my;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.jk;
        if (slideUpView != null) {
            slideUpView.nr();
        }
        LottieAnimationView lottieAnimationView = this.pn;
        if (lottieAnimationView != null) {
            lottieAnimationView.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        iz();
        super.onDraw(canvas);
        if (this.o.isRunning()) {
            this.k.setShader(this.bg);
            canvas.drawRoundRect(new RectF(this.s), y.fx(getContext(), 50.0f), y.fx(getContext(), 50.0f), this.k);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        qq qqVar = this.c;
        if (qqVar != null) {
            if (z) {
                bc bcVar = this.bf;
                qqVar.u(bcVar != null ? bcVar.n() : 0);
            } else {
                bc bcVar2 = this.bf;
                qqVar.nr(bcVar2 != null ? bcVar2.n() : 0);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.u.setColor(i);
        setBackgroundDrawable(this.u);
    }

    public void setCalculationMethod(int i) {
        this.rh = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.ja = i;
    }

    public void setDeepShakeValue(float f) {
        this.kj = f;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void setShakeValue(float f) {
        this.qq = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.gi = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void setWriggleValue(float f) {
        this.z = f;
    }

    private void a() {
        if (this.nr != null && isShown()) {
            if (this.nr.a() == 4 || this.nr.a() == 7) {
                if (this.c == null) {
                    if (this.nr.a() == 4) {
                        this.c = new qq(dw.getContext(), 1, com.bytedance.sdk.openadsdk.core.n.o().pn(), dw.nr().jk());
                    } else if (this.nr.a() == 7) {
                        this.c = new qq(dw.getContext(), 2, com.bytedance.sdk.openadsdk.core.n.o().pn(), dw.nr().jk());
                    }
                }
                this.c.u(this.qq);
                this.c.fx(this.kj);
                this.c.nr(this.z);
                this.c.u(this.gi);
                this.c.fx(this.d);
                this.c.nr(this.h);
                this.c.pn(this.rh);
                this.c.iz(this.ja);
                this.c.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.qq.u
                    public void u(int i) {
                        if (SplashClickBarBtn.this.q == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.c.u() && SplashClickBarBtn.this.bf != null) {
                            com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.b = true;
                        }
                        if (i == 1) {
                            if (SplashClickBarBtn.this.nr.a() == 4) {
                                ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) SplashClickBarBtn.this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u();
                                SplashClickBarBtn.this.q.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (i == 2 && SplashClickBarBtn.this.nr.a() == 7) {
                            ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) SplashClickBarBtn.this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).nr();
                            SplashClickBarBtn.this.q.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                qq qqVar = this.c;
                bc bcVar = this.bf;
                qqVar.u(bcVar != null ? bcVar.n() : 0);
            }
        }
    }

    private void iz() {
        if (this.dw) {
            return;
        }
        this.dw = true;
        int iA = this.nr.a();
        if (iA == 1 || iA == 2) {
            n();
            x();
        }
    }

    private void n() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.mv.moveTo(point.x, point.y);
        this.mv.lineTo(point2.x, point2.y);
        this.mv.lineTo(point3.x, point3.y);
        this.mv.lineTo(point4.x, point4.y);
        this.mv.close();
        this.s = getBackground().getBounds();
        final int iFx = y.fx(getContext(), 36.0f);
        final int iFx2 = y.fx(getContext(), 45.0f);
        this.o.setIntValues(point.x - iFx, point2.x + iFx);
        this.o.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.o.setDuration(1600L);
        this.o.setStartDelay(1300L);
        this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.bg = new LinearGradient(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0.0f, r11 + iFx, iFx2, SplashClickBarBtn.this.bq, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.my.playTogether(this.o);
    }

    private void pn() {
        View viewU = u(getContext());
        if (viewU == null) {
            return;
        }
        addView(viewU);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.f5253a = splashClickBarArrow;
        this.iz.addView(splashClickBarArrow);
        this.f5253a.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5253a.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.x.getId());
        this.u = u(Color.parseColor("#57000000"));
        this.mv = new Path();
        Paint paint = new Paint();
        this.k = paint;
        paint.isAntiAlias();
    }

    private void x() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.nr.jk());
        this.u.setColor(color);
        this.sx.setIntValues(color, color2);
        this.sx.setEvaluator(new ArgbEvaluator());
        this.sx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.u.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.u);
            }
        });
        this.sx.setDuration(300L);
        this.sx.setStartDelay(800L);
        this.sx.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.my.playTogether(this.sx);
    }

    public void b() {
        if (this.nr.a() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.pn != null) {
                        SplashClickBarBtn.this.pn.u();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    public void fx() {
        RockView rockView;
        if (this.nr.a() == 4 && (rockView = this.t) != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.t != null) {
                        SplashClickBarBtn.this.t.u();
                    }
                }
            }, 500L);
        }
    }

    public void nr() {
        if (this.nr.a() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    private View u(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.iz = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.iz.setId(2114387576);
        this.iz.setClipChildren(false);
        layoutParams2.addRule(13);
        this.iz.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.iz);
        this.t = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.t.setId(2114387575);
        layoutParams3.addRule(14);
        this.t.setLayoutParams(layoutParams3);
        y.u((View) this.t, 8);
        this.iz.addView(this.t);
        this.x = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.x.setId(2114387574);
        this.x.setClipChildren(false);
        layoutParams4.addRule(13);
        this.x.setGravity(17);
        this.x.setLayoutParams(layoutParams4);
        this.iz.addView(this.x);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.x.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.pn = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.pn.setAnimation("lottie_json/twist_multi_angle.json");
        this.pn.setImageAssetsFolder("images/");
        this.pn.u(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = y.fx(context, 4.0f);
        layoutParams6.gravity = 17;
        this.pn.setLayoutParams(layoutParams6);
        linearLayout.addView(this.pn);
        y.u((View) this.pn, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.jk = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = y.fx(context, -140.0f);
        this.jk.setLayoutParams(layoutParams7);
        linearLayout.addView(this.jk);
        y.u((View) this.jk, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.n = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.n.setGravity(17);
        this.n.setOrientation(1);
        this.n.setLayoutParams(layoutParams8);
        this.x.addView(this.n);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.b.setSingleLine();
        this.b.setText(q.u(context, "tt_splash_click_bar_text"));
        this.b.setTextColor(-1);
        this.b.setTextSize(20.0f);
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.b.setLayoutParams(layoutParams9);
        this.n.addView(this.b);
        y.u((View) this.b, 8);
        TextView textView2 = new TextView(context);
        this.fx = textView2;
        textView2.setId(2114387567);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.fx.setShadowLayer(2.0f, 0.0f, 0.5f, q.a(context, "tt_splash_click_bar_text_shadow"));
        this.fx.setSingleLine();
        this.fx.setText(q.u(context, "tt_splash_click_bar_text"));
        this.fx.setTextColor(-1);
        this.fx.setTextSize(15.0f);
        this.fx.setTypeface(Typeface.defaultFromStyle(1));
        this.fx.setLayoutParams(layoutParams10);
        this.n.addView(this.fx);
        y.u((View) this.fx, 8);
        return relativeLayout;
    }

    private GradientDrawable u(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(y.fx(dw.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void u(mk mkVar) {
        if (mkVar == null) {
            return;
        }
        this.nr = mkVar;
        if (mkVar.a() == 4) {
            this.t.u(this.nr);
            return;
        }
        TextView textView = this.fx;
        if (textView != null) {
            textView.setVisibility(0);
            this.fx.setText(TextUtils.isEmpty(this.nr.nr()) ? "点击跳转至详情页或第三方应用" : this.nr.nr());
            if (this.nr.l() != null) {
                this.fx.setTextSize(2, this.nr.l().nr());
            }
        }
        if (this.b != null && this.nr.mv() != null) {
            this.b.setTextSize(2, this.nr.mv().nr());
        }
        this.u.setColor(Color.parseColor("#57000000"));
        this.f5253a.u(this.nr.a());
        int iA = this.nr.a();
        if (iA == 1 || iA == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            animatorSet.playTogether(getAnimator(), this.f5253a.getAnimator());
        } else if (iA == 3) {
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.b.setText(this.nr.t());
            }
            TextView textView3 = this.fx;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.u = u(Color.parseColor(this.nr.jk()));
        } else {
            if (iA == 4) {
                return;
            }
            if (iA == 5) {
                SlideUpView slideUpView = this.jk;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.n;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.n.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.b;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.b.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.nr.t())) {
                        this.b.setText("向上滑动");
                    } else {
                        this.b.setText(this.nr.t());
                    }
                }
                TextView textView5 = this.fx;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.nr.nr()) ? "滑动查看详情" : this.nr.nr());
                    this.fx.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (iA != 7) {
                this.u.setStroke(0, -16777216);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.l = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.f5253a.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.nr.jk()));
                } catch (Throwable unused) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
            } else {
                TextView textView6 = this.b;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.b.setText(this.nr.t());
                    this.b.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.fx;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.fx.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.pn;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        setBackgroundDrawable(this.u);
    }

    public void u() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.start();
        }
        nr();
        fx();
        b();
        jk();
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.q = uVar;
        if (this.nr.a() == 4 || this.nr.a() == 7 || this.nr.a() == 5 || uVar == null) {
            return;
        }
        uVar.u(this);
        setOnClickListener(uVar);
        setOnTouchListener(uVar);
        setId(2114387633);
    }
}
