package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.component.splash.n;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.nb;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class b extends fx implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f5255a;
    private TextView bg;
    private RelativeLayout bq;
    private qq c;
    private TextView dw;
    private RelativeLayout iz;
    private RelativeLayout jk;
    private TextView k;
    private TextView l;
    private TextView mv;
    private View my;
    private View n;
    private RelativeLayout o;
    protected com.bytedance.sdk.openadsdk.my.fx.nr.x pn;
    private View.OnClickListener q;
    private TextView s;
    private TextView sx;
    private ImageView t;
    private ImageView x;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = view.getId() == 2114387553 ? 0 : view.getId() == 2114387561 ? 1 : view.getId() == 2114387556 ? 2 : view.getId() == 2114387555 ? 3 : view.getId() == 2114387554 ? 4 : 5;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_card_click", jSONObject);
        } catch (JSONException unused) {
        }
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public String u() {
        return "splash_card_show";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable iz() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.8
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.x.getWidth() == 0 || b.this.x.getHeight() == 0) {
                    return;
                }
                b.this.x.animate().scaleX(b.this.iz.getWidth() / b.this.x.getWidth()).scaleY(b.this.iz.getHeight() / b.this.x.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.8.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.x.setVisibility(8);
                        b.this.iz.setVisibility(0);
                        b.this.f5255a.setScaleX(0.0f);
                        b.this.f5255a.setScaleY(0.0f);
                        b.this.f5255a.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        b.this.l.setScaleX(0.0f);
                        b.this.l.setScaleY(0.0f);
                        b.this.l.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        b.this.mv.setScaleX(0.0f);
                        b.this.mv.setScaleY(0.0f);
                        b.this.mv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        b.this.o.setScaleX(0.0f);
                        b.this.o.setScaleY(0.0f);
                        b.this.o.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        n.u uVar = b.this.b;
                        if (uVar != null) {
                            uVar.u(nb.iz(r5.fx));
                        }
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
        };
    }

    public String b() {
        bc bcVar = this.fx;
        return (bcVar == null || TextUtils.isEmpty(bcVar.wf())) ? "" : this.fx.wf();
    }

    public String fx() {
        bc bcVar = this.fx;
        return bcVar == null ? "" : !TextUtils.isEmpty(bcVar.j()) ? this.fx.j() : (this.fx.pu() == null || TextUtils.isEmpty(this.fx.pu().fx())) ? "" : this.fx.pu().fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public void nr() {
        if (nb.n(this.fx)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_card_close", jSONObject);
                n.u uVar = this.b;
                if (uVar != null) {
                    uVar.nr();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void pn() {
        n.u uVar = this.b;
        if (uVar == null) {
            return;
        }
        if (this.pn == null) {
            this.pn = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(uVar.getActivity(), this.fx.vz(), WifiNestConst.NestTypeConst.NEST_SPLASH_AD, true, com.bytedance.sdk.openadsdk.n.nr.u());
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.b.getActivity(), this.fx, (com.bytedance.sdk.openadsdk.core.dislike.ui.nr) this.pn);
        }
        this.pn.u("splash_card");
        this.pn.u();
    }

    private View u(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.iz = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.iz.setClipChildren(false);
        this.iz.setVisibility(4);
        this.iz.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.iz);
        ImageView imageView = new ImageView(context);
        this.n = imageView;
        imageView.setId(2114387561);
        this.n.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.iz.addView(this.n);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.iz.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.s = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = y.fx(context, 8.0f);
        layoutParams3.bottomMargin = y.fx(context, 10.0f);
        layoutParams3.rightMargin = y.fx(context, 4.0f);
        this.s.setLayoutParams(layoutParams3);
        q.u(this.u, "tt_splash_card_feedback_bg", this.s);
        this.s.setGravity(17);
        this.s.setText(q.u(this.u, "tt_feedback"));
        this.s.setTextColor(Color.parseColor("#99FFFFFF"));
        this.s.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.s);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.jk = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.jk.setLayoutParams(layoutParams4);
        this.jk.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.iz.addView(this.jk);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f5255a = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = y.fx(context, -42.0f);
        this.f5255a.setElevation(y.fx(context, 3.0f));
        this.f5255a.setLayoutParams(layoutParams5);
        this.jk.addView(this.f5255a);
        ImageView imageView2 = new ImageView(context);
        this.t = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(y.fx(context, 2.0f), y.fx(context, 2.0f), y.fx(context, 2.0f), y.fx(context, 2.0f));
        this.t.setLayoutParams(layoutParams6);
        this.f5255a.addView(this.t);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iFx = y.fx(context, 6.0f);
        gradientDrawable.setCornerRadius(iFx);
        gradientDrawable.setStroke(iFx / 3, -1);
        view.setBackground(gradientDrawable);
        this.f5255a.addView(view);
        TextView textView2 = new TextView(context);
        this.l = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = y.fx(context, 16.0f);
        this.l.setLayoutParams(layoutParams7);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setMaxLines(1);
        this.l.setTextColor(Color.parseColor("#161823"));
        this.l.setTextSize(2, 20.0f);
        this.jk.addView(this.l);
        TextView textView3 = new TextView(context);
        this.mv = textView3;
        textView3.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(y.fx(context, 42.0f));
        layoutParams8.setMarginEnd(y.fx(context, 42.0f));
        layoutParams8.topMargin = y.fx(context, 8.0f);
        this.mv.setLayoutParams(layoutParams8);
        this.mv.setEllipsize(TextUtils.TruncateAt.END);
        this.mv.setGravity(1);
        this.mv.setMaxLines(2);
        this.mv.setTextColor(Color.parseColor("#90161823"));
        this.mv.setTextSize(2, 14.0f);
        this.jk.addView(this.mv);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.o = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = y.fx(context, 36.0f);
        this.o.setLayoutParams(layoutParams9);
        q.u(this.u, "tt_splash_card_btn_bg", this.o);
        this.o.setGravity(17);
        this.jk.addView(this.o);
        TextView textView4 = new TextView(context);
        this.sx = textView4;
        textView4.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.sx.setLayoutParams(layoutParams10);
        this.sx.setEllipsize(TextUtils.TruncateAt.END);
        this.sx.setMaxLines(1);
        this.sx.setTextColor(Color.parseColor("#FFFFFF"));
        this.sx.setTextSize(2, 14.0f);
        this.sx.setTypeface(Typeface.defaultFromStyle(1));
        this.o.addView(this.sx);
        TextView textView5 = new TextView(context);
        this.bg = textView5;
        textView5.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.bg.setLayoutParams(layoutParams11);
        this.bg.setEllipsize(TextUtils.TruncateAt.END);
        this.bg.setMaxLines(1);
        this.bg.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.bg.setTextSize(2, 11.0f);
        this.o.addView(this.bg);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.bq = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = y.fx(context, 36.0f);
        this.bq.setLayoutParams(layoutParams12);
        q.u(this.u, "tt_splash_card_btn_bg", this.bq);
        this.bq.setVisibility(8);
        this.jk.addView(this.bq);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.bq.addView(relativeLayout7);
        View imageView3 = new ImageView(context);
        imageView3.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        q.u(this.u, "tt_splash_card_shake", imageView3);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.dw = textView6;
        textView6.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = y.fx(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.dw.setLayoutParams(layoutParams15);
        this.dw.setEllipsize(TextUtils.TruncateAt.END);
        this.dw.setTypeface(Typeface.defaultFromStyle(1));
        this.dw.setMaxLines(1);
        this.dw.setTextColor(Color.parseColor("#FFFFFF"));
        this.dw.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.dw);
        TextView textView7 = new TextView(context);
        this.k = textView7;
        textView7.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(y.fx(context, 8.0f));
        layoutParams16.bottomMargin = y.fx(context, 8.0f);
        this.k.setLayoutParams(layoutParams16);
        q.u(this.u, "tt_ad_logo_new", this.k);
        this.jk.addView(this.k);
        ImageView imageView4 = new ImageView(context);
        this.my = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = y.fx(context, 48.0f);
        this.my.setLayoutParams(layoutParams17);
        q.u(this.u, "tt_splash_card_close", this.my);
        relativeLayout.addView(this.my);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.x = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.x.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.x);
        return relativeLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public void u(Context context, ViewGroup viewGroup, bc bcVar) {
        super.u(context, viewGroup, bcVar);
        View viewU = u(this.u);
        if (viewU == null) {
            return;
        }
        this.nr.addView(viewU);
        this.iz.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), y.fx(dw.getContext(), 18.0f));
            }
        });
        this.iz.setClipToOutline(true);
        this.x.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), y.fx(dw.getContext(), 28.0f));
            }
        });
        this.x.setClipToOutline(true);
        y.u(this.k, this.fx);
        List<rh> listZu = this.fx.zu();
        if (listZu != null && listZu.size() > 0) {
            com.bytedance.sdk.openadsdk.n.nr.u(listZu.get(0)).type(2).config(Bitmap.Config.ARGB_8888).to(new com.bytedance.sdk.component.iz.qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.3
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap result = myVar.getResult();
                    if (result == null) {
                        return;
                    }
                    try {
                        if (result.getConfig() == Bitmap.Config.RGB_565) {
                            result = result.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(b.this.u, result, 10);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(b.this.u.getResources(), bitmapU);
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.n != null) {
                                b.this.n.setBackground(bitmapDrawable);
                            }
                            if (b.this.x != null) {
                                b.this.x.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        }
        com.bytedance.sdk.openadsdk.n.nr.u(this.fx.dd()).to(this.t);
        this.l.setText(fx());
        this.mv.setText(b());
        this.s.setVisibility(this.fx.uo() ? 0 : 8);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.pn();
            }
        });
        this.sx.setText(nb.b(this.fx));
        this.bg.setText(nb.fx(this.fx));
        u(this.fx);
    }

    private void u(bc bcVar) {
        if (bcVar == null || this.iz == null || nb.pn(bcVar) != 1) {
            return;
        }
        y.u((View) this.bq, 0);
        y.u((View) this.o, 8);
        TextView textView = this.dw;
        if (textView != null) {
            textView.setText(nb.b(bcVar));
        }
        if (this.c == null) {
            this.c = new qq(dw.getContext(), 1, com.bytedance.sdk.openadsdk.core.n.o().pn(), dw.nr().jk());
        }
        this.c.nr(this.fx.qv());
        this.c.u(this.fx.xs());
        this.c.nr(this.fx.bi());
        this.c.iz(this.fx.ki());
        this.c.u(bcVar.gz());
        this.c.fx(bcVar.or());
        this.c.pn(bcVar.zq());
        this.c.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.5
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i) {
                if (b.this.q == null || !b.this.iz.isShown() || i != 1 || b.this.q == null) {
                    return;
                }
                if (b.this.q instanceof com.bytedance.sdk.openadsdk.core.nr.u) {
                    ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) ((com.bytedance.sdk.openadsdk.core.nr.u) b.this.q).u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u();
                }
                b.this.q.onClick(b.this.iz);
            }
        });
        qq qqVar = this.c;
        bc bcVar2 = this.fx;
        qqVar.u(bcVar2 != null ? bcVar2.n() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public void u(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        if (uVar == null) {
            return;
        }
        this.q = uVar;
        if (nb.x(this.fx)) {
            this.iz.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.mv.setOnClickListener(this);
            this.jk.setOnClickListener(this);
        }
        this.o.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public void u(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, n.u uVar) {
        super.u(bVar, uVar);
        this.nr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.iz.isAttachedToWindow()) {
                    b.this.iz().run();
                } else {
                    b bVar2 = b.this;
                    bVar2.nr.postDelayed(bVar2.iz(), 20L);
                }
            }
        });
        if (this.b != null) {
            this.my.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.s.b.nr(b.this.fx, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_card_close", jSONObject);
                    } catch (JSONException unused) {
                    }
                    b.this.b.nr();
                }
            });
        }
        nb.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx
    public void u(boolean z) {
        super.u(z);
        n.u uVar = this.b;
        if (uVar == null) {
            return;
        }
        if (z) {
            uVar.u(-1L);
        } else {
            uVar.u();
        }
        qq qqVar = this.c;
        if (qqVar != null) {
            if (z) {
                bc bcVar = this.fx;
                qqVar.u(bcVar != null ? bcVar.n() : 0);
            } else {
                bc bcVar2 = this.fx;
                qqVar.nr(bcVar2 != null ? bcVar2.n() : 0);
            }
        }
    }
}
