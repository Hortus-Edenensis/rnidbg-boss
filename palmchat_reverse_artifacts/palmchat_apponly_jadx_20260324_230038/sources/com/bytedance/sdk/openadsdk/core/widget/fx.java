package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.UgenLottieView;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.huawei.hms.ads.ex;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f5397a;
    private TTRoundRectImageView b;
    private String bf;
    private String bg;
    private String bq;
    private String c;
    private float d;
    private String dw;
    private ImageView fx;
    private JSONArray gi;
    private RelativeLayout h;
    private TextView iz;
    private u ja;
    private TTRatingBar2 jk;
    private TextView k;
    private String kj;
    private TextView l;
    private TextView mv;
    private TextView my;
    private LinearLayout n;
    Stack<View> nr;
    private Button o;
    private TextView pn;
    private String q;
    private String qq;
    private View rh;
    private TextView s;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr sx;
    private TextView t;
    protected Context u;
    private TextView x;
    private String z;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void b(Dialog dialog);

        void fx(Dialog dialog);

        void iz(Dialog dialog);

        void nr(Dialog dialog);

        void pn(Dialog dialog);

        void u(Dialog dialog);
    }

    public fx(Context context) {
        super(context, q.x(context, "tt_dialog_full"));
        this.nr = new Stack<>();
        this.u = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(int i) {
        try {
            Rect rect = new Rect();
            if (this.u.getResources().getConfiguration().orientation == 1) {
                this.l.getGlobalVisibleRect(rect);
            } else {
                this.o.getGlobalVisibleRect(rect);
            }
            while (!this.nr.isEmpty()) {
                Rect rect2 = new Rect();
                View viewPop = this.nr.pop();
                if (viewPop != null && viewPop.getVisibility() != 8) {
                    viewPop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (viewPop == this.pn) {
                        View viewPop2 = this.nr.pop();
                        if (viewPop2 != null) {
                            viewPop2.setVisibility(8);
                        }
                    } else {
                        viewPop.setVisibility(8);
                    }
                }
            }
            if (this.nr.isEmpty()) {
                n();
            }
        } catch (Throwable unused) {
        }
        this.h.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.h.getChildAt(i2).setVisibility(0);
        }
    }

    private View iz() {
        RelativeLayout relativeLayout = new RelativeLayout(this.u);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.u);
        this.fx = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iFx = y.fx(this.u, 46.0f);
        this.fx.setMaxHeight(iFx);
        this.fx.setMaxWidth(iFx);
        this.fx.setMinimumHeight(iFx);
        this.fx.setMinimumWidth(iFx);
        com.bytedance.sdk.openadsdk.res.fx fxVar = new com.bytedance.sdk.openadsdk.res.fx(y.fx(this.u, 14.0f));
        fxVar.u(-16777216);
        fxVar.u(y.fx(this.u, 2.0f));
        this.fx.setImageDrawable(fxVar);
        relativeLayout.addView(this.fx);
        TextView textView = new TextView(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("应用详情");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.h.addView(relativeLayout);
        return u(relativeLayout);
    }

    private void n() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.o;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.o.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.o.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr nrVar = this.sx;
        if (nrVar != null) {
            UgenLottieView ugenLottieViewA = nrVar.a();
            if (ugenLottieViewA != null) {
                layoutParams = (RelativeLayout.LayoutParams) ugenLottieViewA.getLayoutParams();
            } else {
                int iFx = y.fx(this.u, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(iFx, iFx);
            }
            layoutParams.topMargin = -y.fx(this.u, 53.0f);
            this.sx.u(layoutParams);
        }
    }

    private LinearLayout nr(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.n = new LinearLayout(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = y.fx(this.u, 10.0f);
        this.n.setLayoutParams(layoutParams);
        this.n.setOrientation(0);
        linearLayout2.addView(this.n);
        this.f5397a = new LinearLayout(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = y.fx(this.u, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = y.fx(this.u, 16.0f);
        } else {
            layoutParams2.topMargin = y.fx(this.u, 10.0f);
        }
        this.f5397a.setLayoutParams(layoutParams2);
        this.f5397a.setOrientation(0);
        this.jk = new TTRatingBar2(this.u, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.jk.setLayoutParams(layoutParams3);
        this.f5397a.addView(this.jk);
        this.t = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = y.fx(this.u, 3.0f);
        this.t.setTextSize(16.0f);
        this.t.setTextColor(Color.parseColor("#161823"));
        this.t.setLayoutParams(layoutParams4);
        this.f5397a.addView(this.t);
        linearLayout2.addView(this.f5397a);
        return u(i, linearLayout, i2);
    }

    private ImageView pn() {
        ImageView imageView = new ImageView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(y.fx(this.u, 0.5f), y.fx(this.u, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private void x() {
        RelativeLayout relativeLayout;
        if (this.rh == null || (relativeLayout = this.h) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.h.getChildAt(i).setVisibility(4);
        }
        this.rh.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.7
            @Override // java.lang.Runnable
            public void run() {
                fx.this.fx(childCount);
            }
        }, 10L);
    }

    public fx a(String str) {
        this.bf = str;
        return this;
    }

    public fx b(String str) {
        this.dw = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        u uVar = this.ja;
        if (uVar != null) {
            uVar.fx(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u();
        setCanceledOnTouchOutside(false);
        nr();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        fx();
    }

    public String b() {
        return this.bf;
    }

    public void u() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        if (this.u.getResources().getConfiguration().orientation == 1) {
            this.rh = u(1);
        } else {
            this.rh = u(0);
        }
        setContentView(this.rh);
    }

    public fx pn(String str) {
        this.c = str;
        return this;
    }

    public fx x(String str) {
        this.qq = str;
        return this;
    }

    private View u(int i) {
        int iFx;
        LinearLayout linearLayoutNr = nr(i);
        LinearLayout linearLayout = new LinearLayout(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            iFx = y.fx(this.u, 40.0f);
        } else {
            layoutParams.addRule(3, iz().getId());
            iFx = y.fx(this.u, 16.0f);
        }
        layoutParams.leftMargin = iFx;
        layoutParams.rightMargin = iFx;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.h.addView(linearLayout);
        this.b = new TTRoundRectImageView(this.u);
        int iFx2 = y.fx(this.u, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iFx2, iFx2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = y.fx(this.u, 40.0f);
        } else {
            layoutParams2.topMargin = y.fx(this.u, 36.0f);
        }
        this.b.setMaxHeight(iFx2);
        this.b.setMaxWidth(iFx2);
        this.b.setMinimumHeight(iFx2);
        this.b.setMinimumWidth(iFx2);
        this.b.setLayoutParams(layoutParams2);
        linearLayout.addView(this.b);
        return u(i, linearLayoutNr, linearLayout, iFx);
    }

    public fx n(String str) {
        this.kj = str;
        return this;
    }

    public void fx() {
        String str;
        int iB;
        if (this.u == null) {
            this.u = dw.getContext();
        }
        int i = this.u.getResources().getConfiguration().orientation;
        TextView textView = this.pn;
        if (textView != null) {
            textView.setText(this.bg);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.b;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.b != null && !TextUtils.isEmpty(this.bq)) {
            com.bytedance.sdk.openadsdk.n.nr.u(this.bq).to(this.b);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.b;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.iz != null) {
            if (TextUtils.isEmpty(this.dw)) {
                this.iz.setVisibility(8);
            } else {
                this.iz.setText(this.dw);
            }
        }
        if (this.n != null) {
            JSONArray jSONArray = this.gi;
            if (jSONArray != null && jSONArray.length() > 0) {
                WindowManager windowManager = (WindowManager) this.u.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double dB = y.b(this.u, width);
                        iB = ((int) (dB - (0.38d * dB))) - 80;
                    } else {
                        iB = y.b(this.u, width) - 36;
                    }
                } else {
                    iB = 0;
                }
                int length = this.gi.length() <= 3 ? this.gi.length() : 3;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String strOptString = this.gi.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        TextView textView2 = new TextView(this.u);
                        textView2.setText(strOptString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int iFx = y.fx(this.u, 6.0f);
                        textView2.setPadding(iFx, 0, iFx, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int iFx2 = y.fx(this.u, 3.0f);
                        layoutParams.leftMargin = iFx2;
                        layoutParams.rightMargin = iFx2;
                        textView2.setLayoutParams(layoutParams);
                        textView2.getPaint().getTextBounds(strOptString, 0, strOptString.length(), new Rect());
                        iB -= y.b(this.u, r10.width()) + 20;
                        if (iB >= 0) {
                            this.n.addView(textView2);
                        } else if (this.n.getChildCount() <= 0) {
                            this.n.setVisibility(8);
                        }
                    }
                    i2++;
                }
            } else {
                this.n.setVisibility(8);
            }
        }
        if (this.jk != null && this.t != null) {
            float f = this.d;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.f5397a;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.jk.setVisibility(8);
                this.t.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.d = f;
                this.t.setText(new DecimalFormat(".0").format(this.d));
                this.jk.setRating(this.d);
                this.jk.u(y.fx(this.u, 16.0f), y.fx(this.u, 15.0f));
                this.jk.u(y.fx(this.u, 3.0f), 0, y.fx(this.u, 3.0f), 0);
                this.jk.u();
            }
        }
        if (this.l != null) {
            str = TextUtils.isEmpty(this.c) ? String.format("版本号：%1$s", "暂无") : String.format("版本号：%1$s", this.c);
            if (i == 2) {
                TextPaint paint = this.l.getPaint();
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                double dJk = y.jk(this.u);
                int iWidth = (((int) (dJk - (0.4d * dJk))) - rect.width()) - y.fx(this.u, 106.0f);
                TextView textView3 = this.s;
                if (textView3 != null) {
                    TextPaint paint2 = textView3.getPaint();
                    String string = this.s.getText().toString();
                    paint2.getTextBounds(string, 0, string.length(), rect);
                    iWidth -= rect.width();
                }
                TextView textView4 = this.x;
                if (textView4 != null) {
                    TextPaint paint3 = textView4.getPaint();
                    String string2 = this.x.getText().toString();
                    paint3.getTextBounds(string2, 0, string2.length(), rect);
                    iWidth -= rect.width();
                }
                TextView textView5 = this.my;
                if (textView5 != null) {
                    TextPaint paint4 = textView5.getPaint();
                    String string3 = this.my.getText().toString();
                    paint4.getTextBounds(string3, 0, string3.length(), rect);
                    iWidth -= rect.width();
                }
                if (this.k != null && !TextUtils.isEmpty(this.qq)) {
                    TextPaint paint5 = this.k.getPaint();
                    String string4 = this.k.getText().toString();
                    paint5.getTextBounds(string4, 0, TextUtils.isEmpty(string4) ? 0 : string4.length(), rect);
                    iWidth -= rect.width();
                }
                if (iWidth <= 0) {
                    ((LinearLayout.LayoutParams) this.l.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i == 1) {
                this.l.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.mv;
        if (textView6 != null) {
            textView6.setSelected(true);
            String str2 = TextUtils.isEmpty(this.kj) ? String.format("开发者：%1$s", "补充中，可于应用官网查看") : String.format("开发者：%1$s", this.kj);
            if (i == 2) {
                str2 = str2 + "  " + str;
            }
            this.mv.setText(str2);
        }
    }

    public fx iz(String str) {
        this.q = str;
        return this;
    }

    private LinearLayout nr(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            u(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.q)) {
                View imageView = new ImageView(this.u);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(y.fx(this.u, 0.5f), y.fx(this.u, 9.0f));
                layoutParams.leftMargin = y.fx(this.u, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int iFx = y.fx(this.u, 8.0f);
        u(linearLayout2, iFx);
        nr(linearLayout2, iFx);
        return u(i, linearLayout, i2, linearLayout2, view, iFx);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.pn = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i == 0) {
            layoutParams.topMargin = y.fx(this.u, 16.0f);
            int iFx = y.fx(this.u, 25.0f);
            layoutParams.leftMargin = iFx;
            layoutParams.rightMargin = iFx;
        } else {
            layoutParams.topMargin = y.fx(this.u, 14.0f);
        }
        this.pn.setLayoutParams(layoutParams);
        this.pn.setEllipsize(TextUtils.TruncateAt.END);
        this.pn.setTextColor(Color.parseColor("#161823"));
        this.pn.setTextSize(18.0f);
        this.pn.setGravity(17);
        this.pn.setTypeface(null, 1);
        linearLayout2.addView(this.pn);
        this.iz = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = y.fx(this.u, 5.0f);
        this.iz.setLayoutParams(layoutParams2);
        this.iz.setEllipsize(TextUtils.TruncateAt.END);
        this.iz.setSingleLine(true);
        this.iz.setAlpha(0.5f);
        this.iz.setTextColor(Color.parseColor("#161823"));
        this.iz.setTextSize(14.0f);
        this.iz.setGravity(17);
        linearLayout2.addView(this.iz);
        return nr(i, linearLayout, linearLayout2, i2);
    }

    private void nr(LinearLayout linearLayout, int i) {
        linearLayout.addView(pn());
        this.x = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.x.setLayoutParams(layoutParams);
        this.x.setAlpha(0.75f);
        this.x.setTextColor(Color.parseColor("#66161823"));
        if (this.u.getResources().getConfiguration().orientation == 2) {
            this.x.setTextSize(10.0f);
        } else {
            this.x.setTextSize(12.0f);
        }
        this.x.setText("权限");
        linearLayout.addView(this.x);
    }

    private LinearLayout nr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.u);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.u);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.h = new RelativeLayout(this.u);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.u, 8.0f));
        this.h.setBackground(gradientDrawable);
        this.h.setLayoutParams(layoutParams2);
        linearLayout.addView(this.h);
        return u(i, linearLayout);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, int i2) {
        int iIc = dw.nr().ic();
        boolean zJe = dw.nr().je();
        if (zJe && iIc == 1) {
            this.o = new ShakeButton(this.u);
        } else if (zJe && iIc == 2) {
            this.o = new ShineButton(this.u);
        } else {
            this.o = new Button(this.u);
        }
        this.o.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.u);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.u);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.u);
        this.mv = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            u(i, this.h);
        } else {
            u(y.fx(this.u, 89.0f), i);
        }
        return u(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i == 1) {
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            int iFx = y.fx(this.u, 16.0f);
            layoutParams.leftMargin = iFx;
            layoutParams.rightMargin = iFx;
        }
        layoutParams.topMargin = y.fx(this.u, 3.0f);
        this.mv.setEllipsize(TextUtils.TruncateAt.END);
        this.mv.setGravity(17);
        this.mv.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.mv.setTextSize(10.0f);
        } else {
            this.mv.setTextSize(12.0f);
        }
        this.mv.setLayoutParams(layoutParams);
        this.h.addView(this.mv);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        if (i == 1) {
            layoutParams2.topMargin = y.fx(this.u, 9.0f);
        } else {
            layoutParams2.topMargin = y.fx(this.u, 2.0f);
            layoutParams2.bottomMargin = y.fx(this.u, 20.0f);
        }
        if (i == 1) {
            layoutParams2.addRule(2, view.getId());
        } else {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        return nr(i, linearLayout, i2, linearLayout2, view);
    }

    public void nr() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        this.nr.clear();
        this.nr.push(this.b);
        this.nr.push(this.pn);
        this.nr.push(this.iz);
        this.nr.push(this.n);
        this.nr.push(this.f5397a);
        x();
        this.my.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fx.this.ja == null) {
                    return;
                }
                fx.this.ja.pn(fx.this);
            }
        });
        if (this.k != null && !TextUtils.isEmpty(this.qq)) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fx.this.ja != null) {
                        fx.this.ja.iz(fx.this);
                    }
                }
            });
        }
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fx.this.ja != null) {
                    fx.this.ja.nr(fx.this);
                }
            }
        });
        this.fx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fx.this.ja != null) {
                    fx.this.ja.fx(fx.this);
                }
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fx.this.ja != null) {
                    fx.this.ja.b(fx.this);
                }
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fx.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fx.this.ja != null) {
                    fx.this.ja.u(fx.this);
                }
            }
        });
    }

    public fx nr(String str) {
        this.bq = str;
        return this;
    }

    private void u(LinearLayout linearLayout, int i) {
        this.my = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.my.setLayoutParams(layoutParams);
        this.my.setAlpha(0.75f);
        this.my.setTextColor(Color.parseColor("#66161823"));
        if (this.u.getResources().getConfiguration().orientation == 2) {
            this.my.setTextSize(10.0f);
        } else {
            this.my.setTextSize(12.0f);
        }
        this.my.setText("功能");
        linearLayout.addView(this.my);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(pn());
        this.s = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.s.setLayoutParams(layoutParams);
        this.s.setAlpha(0.75f);
        this.s.setTextColor(Color.parseColor("#66161823"));
        if (this.u.getResources().getConfiguration().orientation == 2) {
            this.s.setTextSize(10.0f);
        } else {
            this.s.setTextSize(12.0f);
        }
        this.s.setText("隐私");
        linearLayout2.addView(this.s);
        if (!TextUtils.isEmpty(this.qq)) {
            linearLayout2.addView(pn());
            this.k = new TextView(this.u);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.k.setLayoutParams(layoutParams2);
            this.k.setAlpha(0.75f);
            this.k.setTextColor(Color.parseColor("#66161823"));
            if (this.u.getResources().getConfiguration().orientation == 2) {
                this.k.setTextSize(10.0f);
            } else {
                this.k.setTextSize(12.0f);
            }
            this.k.setText("备案");
            linearLayout2.addView(this.k);
        }
        this.h.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, y.fx(this.u, 1.0f));
        layoutParams3.topMargin = y.fx(this.u, 12.0f);
        layoutParams3.addRule(2, this.o.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.h.addView(view);
        u(i2, i);
        return linearLayout;
    }

    public fx fx(String str) {
        this.z = str;
        return this;
    }

    private LinearLayout u(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.fx = new ImageView(this.u);
            int iFx = y.fx(this.u, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iFx, iFx);
            int iFx2 = y.fx(this.u, 36.0f);
            layoutParams.topMargin = iFx2;
            layoutParams.rightMargin = iFx2;
            layoutParams.leftMargin = iFx2;
            layoutParams.bottomMargin = iFx2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.fx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fx.setLayoutParams(layoutParams);
            this.fx.setMaxHeight(iFx);
            this.fx.setMaxWidth(iFx);
            this.fx.setMinimumHeight(iFx);
            this.fx.setMinimumWidth(iFx);
            com.bytedance.sdk.openadsdk.res.nr nrVar = new com.bytedance.sdk.openadsdk.res.nr(y.fx(this.u, 28.0f));
            nrVar.u(Color.parseColor("#66161823"));
            float fFx = y.fx(this.u, 2.0f);
            nrVar.u(fFx);
            com.bytedance.sdk.openadsdk.res.fx fxVar = new com.bytedance.sdk.openadsdk.res.fx(y.fx(this.u, 12.0f));
            fxVar.u(-1);
            fxVar.u(fFx);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{nrVar, fxVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int iFx3 = y.fx(this.u, 8.0f);
            layerDrawable.setLayerInset(1, iFx3, iFx3, iFx3, iFx3);
            this.fx.setImageDrawable(layerDrawable);
            this.h.addView(this.fx);
        }
        return linearLayout;
    }

    private void u(int i, ViewGroup viewGroup) {
        this.l = new TextView(this.u);
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.mv.getId());
            int iFx = y.fx(this.u, 16.0f);
            layoutParams.leftMargin = iFx;
            layoutParams.rightMargin = iFx;
            layoutParams.topMargin = y.fx(this.u, 30.0f);
            this.l.setLayoutParams(layoutParams);
            this.l.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.l.setLayoutParams(layoutParams2);
        }
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.l.setTextSize(10.0f);
        } else {
            this.l.setTextSize(12.0f);
        }
        viewGroup.addView(this.l);
    }

    private void u(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = y.fx(this.u, 14.0f);
            layoutParams.bottomMargin = y.fx(this.u, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = y.fx(this.u, 10.0f);
            layoutParams.bottomMargin = y.fx(this.u, 24.0f);
            layoutParams.addRule(2, this.mv.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(y.fx(this.u, 3.0f));
        this.o.setBackground(gradientDrawable);
        this.o.setGravity(17);
        this.o.setText("立即下载");
        int iFx = y.fx(this.u, 13.0f);
        this.o.setPadding(0, iFx, 0, iFx);
        this.o.setTextColor(-1);
        this.o.setLayoutParams(layoutParams);
        this.o.setTextSize(15.0f);
        this.h.addView(this.o);
        if (i2 != 1 || TextUtils.isEmpty(this.z)) {
            return;
        }
        int iFx2 = y.fx(this.u, 60.0f);
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr nrVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr(this.u);
        this.sx = nrVar;
        nrVar.u("src", this.z);
        this.sx.u("loop", ex.Code);
        this.sx.u("autoPlay", ex.Code);
        this.sx.u("width", String.valueOf(iFx2));
        this.sx.u("height", String.valueOf(iFx2));
        this.sx.u("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iFx2, iFx2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.o.getId());
        layoutParams2.rightMargin = y.fx(this.u, 73.0f);
        layoutParams2.topMargin = -y.fx(this.u, 85.0f);
        this.sx.u(layoutParams2);
        UgenLottieView ugenLottieViewA = this.sx.a();
        if (ugenLottieViewA == null) {
            return;
        }
        this.sx.nr();
        this.h.addView(ugenLottieViewA);
    }

    private View u(RelativeLayout relativeLayout) {
        View view = new View(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, y.fx(this.u, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.h.addView(view);
        return view;
    }

    public fx u(String str) {
        this.bg = str;
        return this;
    }

    public fx u(JSONArray jSONArray) {
        this.gi = jSONArray;
        return this;
    }

    public fx u(float f) {
        this.d = f;
        return this;
    }

    public fx u(u uVar) {
        this.ja = uVar;
        return this;
    }
}
