package com.bytedance.sdk.openadsdk.core.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.bg;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gc;
import com.bytedance.sdk.openadsdk.core.kj.kw;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f5254a;
    private FrameLayout b;
    private ImageView fx;
    private SplashClickBar iz;
    private FrameLayout jk;
    private FrameLayout k;
    private boolean l;
    private u mv;
    private String n;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.b nr;
    private TextView pn;
    private boolean s;
    private bc t;
    private final Context u;
    private NativeExpressView x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void iz();

        void u(boolean z);

        void x();
    }

    public TsView(Context context, String str, bc bcVar) {
        super(context);
        this.l = false;
        this.s = false;
        this.u = context;
        this.n = str;
        this.t = bcVar;
        fx();
    }

    private void fx() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View viewU = u(this.u);
            if (viewU == null) {
                return;
            }
            addView(viewU);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.t);
            this.iz = splashClickBar;
            addView(splashClickBar);
            FrameLayout frameLayoutNr = nr(this.t);
            this.jk = frameLayoutNr;
            if (frameLayoutNr != null) {
                addView(frameLayoutNr);
            }
        } catch (Throwable unused) {
        }
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b bVar = this.nr;
        if (bVar == null) {
            return null;
        }
        return bVar.getView();
    }

    private boolean pn() {
        bc bcVar = this.t;
        return bcVar != null && bcVar.sv() == 2;
    }

    private void setComplianceBarLayout(bc bcVar) {
        gc gcVarDx;
        if (this.f5254a == null || !fx(bcVar) || (gcVarDx = bcVar.dx()) == null) {
            return;
        }
        int iU = gcVarDx.u();
        int iNr = gcVarDx.nr();
        int iFx = gcVarDx.fx();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = y.fx(dw.getContext(), 25.0f);
        layoutParams.rightMargin = y.fx(dw.getContext(), 25.0f);
        this.f5254a.setPadding(20, 20, 20, 20);
        this.f5254a.setHighlightColor(0);
        if (iU == 2) {
            layoutParams.gravity = 80;
            if (b()) {
                layoutParams.bottomMargin = y.fx(dw.getContext(), iFx);
            } else {
                layoutParams.bottomMargin = y.fx(dw.getContext(), iNr);
            }
        } else {
            layoutParams.gravity = 48;
            if (b()) {
                layoutParams.topMargin = y.fx(dw.getContext(), iFx);
            } else {
                layoutParams.topMargin = y.fx(dw.getContext(), iNr);
            }
        }
        this.jk.setLayoutParams(layoutParams);
    }

    public void b(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.nr(bcVar, context, str);
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.b getCountDownView() {
        return this.nr;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.k;
    }

    public NativeExpressView getNativeExpressView() {
        return this.x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!pn() && !this.s) {
            y.u(this, getCountDownLayout());
            y.u(this, this.fx);
        }
        u uVar = this.mv;
        if (uVar != null) {
            uVar.iz();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.mv;
        if (uVar != null) {
            uVar.x();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.l) {
            return;
        }
        SplashClickBar splashClickBar = this.iz;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!b());
        }
        setComplianceBarLayout(this.t);
        this.l = true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        u uVar = this.mv;
        if (uVar != null) {
            uVar.u(z);
        }
    }

    public void setAdlogoViewVisibility(int i) {
        y.u((View) this.pn, i);
    }

    public void setAttachedToWindowListener(u uVar) {
        this.mv = uVar;
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            y.u((View) this.iz, i);
        }
        y.u((View) this.jk, i);
    }

    public void setCountDownTime(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b bVar = this.nr;
        if (bVar != null) {
            bVar.setCountDownTime(i);
        }
    }

    public void setCountDownViewPosition(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b bVar = this.nr;
        if (bVar == null || bVar.getView() == null || bcVar == null) {
            return;
        }
        View view = this.nr.getView();
        kw kwVarKp = bcVar.kp();
        if (kwVarKp == null) {
            return;
        }
        int iU = kwVarKp.u();
        int iFx = y.fx(this.u, kwVarKp.nr());
        int iFx2 = y.fx(this.u, kwVarKp.fx());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iU == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = iFx;
            layoutParams.topMargin = iFx2;
        } else if (iU == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = iFx;
            layoutParams.bottomMargin = iFx2;
        } else if (iU != 4) {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = iFx;
            layoutParams.topMargin = iFx2;
        } else {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = iFx;
            layoutParams.bottomMargin = iFx2;
        }
        view.setLayoutParams(layoutParams);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.x = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.x.getParent()).removeView(this.x);
        }
        this.b.addView(this.x);
        setExpressViewVisibility(0);
    }

    public void setExpressViewVisibility(int i) {
        y.u((View) this.b, i);
    }

    public void setIsShowSuccess(boolean z) {
        this.s = z;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        bg.u("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        bg.u("不允许在Splash广告中注册OnTouchListener");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i) {
        y.u(getCountDownLayout(), i);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b bVar = this.nr;
        if (bVar == null || bVar.getView() == null) {
            return;
        }
        this.nr.getView().setOnClickListener(onClickListener);
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setVideoViewVisibility(int i) {
        y.u((View) this.fx, i);
    }

    public void setVideoVoiceVisibility(int i) {
        y.u((View) this.fx, i);
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.fx;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.fx;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    private View u(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.b = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.b.setId(2114387581);
        this.b.setLayoutParams(layoutParams);
        frameLayout.addView(this.b);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.k = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.fx = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = y.fx(this.u, 16.0f);
        layoutParams2.leftMargin = y.fx(this.u, 16.0f);
        this.fx.setId(2114387580);
        this.fx.setLayoutParams(layoutParams2);
        q.u(this.u, "tt_splash_mute", this.fx);
        y.u((View) this.fx, 8);
        frameLayout.addView(this.fx);
        this.nr = u(frameLayout, context);
        this.pn = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.pn.setId(2114387578);
        this.pn.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = y.fx(this.u, 40.0f);
        layoutParams3.leftMargin = y.fx(this.u, 20.0f);
        q.u(this.u, "tt_ad_logo_new", this.pn);
        this.pn.setLayoutParams(layoutParams3);
        frameLayout.addView(this.pn);
        return frameLayout;
    }

    public FrameLayout nr(final bc bcVar) {
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm;
        gc gcVarDx;
        if (bcVar == null || bcVar.qf() != 4 || (izVarHm = bcVar.hm()) == null || (gcVarDx = bcVar.dx()) == null || gcVarDx.u() == 0) {
            return null;
        }
        String strS = izVarHm.s();
        if (TextUtils.isEmpty(strS)) {
            strS = "暂无";
        }
        String strPn = izVarHm.pn();
        if (TextUtils.isEmpty(strPn)) {
            strPn = "补充中，可于应用官网查看";
        }
        String strX = izVarHm.x();
        String str = TextUtils.isEmpty(strX) ? "补充中，可于应用官网查看" : strX;
        StringBuilder sb = new StringBuilder();
        sb.append("应用名：");
        sb.append(strS);
        sb.append("；版本号：");
        sb.append(strPn);
        sb.append("；开发者：");
        sb.append(str);
        String strT = izVarHm.t();
        if (TextUtils.isEmpty(strT)) {
            sb.append("；功能 | 权限 | 隐私  ");
        } else {
            sb.append("；功能 | 权限 | 隐私 | 备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i2 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i3 = iIndexOf3 + 2;
        if (!TextUtils.isEmpty(strT)) {
            int iIndexOf4 = sb.indexOf("备案");
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    TsView tsView = TsView.this;
                    tsView.u(bcVar, tsView.u, TsView.this.n);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(-1);
                    }
                }
            }, iIndexOf4, iIndexOf4 + 2, 34);
        }
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.nr(bcVar, tsView.u, TsView.this.n);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf, i, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.b(bcVar, tsView.u, TsView.this.n);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf2, i2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.fx(bcVar, tsView.u, TsView.this.n);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf3, i3, 34);
        this.f5254a = new TextView(this.u);
        this.jk = new FrameLayout(this.u);
        this.f5254a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5254a.setTextColor(-1);
        this.f5254a.setTextSize(11.0f);
        this.f5254a.setText(spannableString);
        this.jk.addView(this.f5254a);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(y.fx(this.u, 6.0f));
        this.jk.setBackground(gradientDrawable);
        return this.jk;
    }

    private boolean b() {
        return getHeight() < y.nr(dw.getContext())[1];
    }

    private boolean fx(bc bcVar) {
        gc gcVarDx;
        return (bcVar == null || bcVar.qf() != 4 || bcVar.hm() == null || (gcVarDx = bcVar.dx()) == null || gcVarDx.u() == 0) ? false : true;
    }

    public void fx(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.fx(bcVar, context, str);
    }

    public void u(bc bcVar) {
        SplashClickBar splashClickBar = this.iz;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.u(bcVar);
            y.u(this.pn, bcVar);
        } catch (Throwable unused) {
        }
    }

    public void u(int i, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        SplashClickBar splashClickBar = this.iz;
        if (splashClickBar != null) {
            splashClickBar.u(uVar);
        }
        if (i == 1) {
            uVar.u(this);
            setOnClickListenerInternal(uVar);
            setOnTouchListenerInternal(uVar);
        }
    }

    public void nr(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(context, bcVar, str);
    }

    public void nr() {
        TextView textView = this.pn;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b bVar = this.nr;
        if (bVar == null || bVar.getView() == null) {
            return;
        }
        this.nr.u(true);
        this.nr.getView().setVisibility(8);
    }

    public void u(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(bcVar, context, str);
    }

    public void u() {
        TextView textView = this.pn;
        if (textView != null) {
            q.u(this.u, "tt_ad_logo_backup", textView);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.b u(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        bc bcVar = this.t;
        kw kwVarKp = bcVar == null ? null : bcVar.kp();
        if ((kwVarKp == null ? 1 : kwVarKp.b()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = y.fx(this.u, 16.0f);
            layoutParams.rightMargin = y.fx(this.u, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }
}
