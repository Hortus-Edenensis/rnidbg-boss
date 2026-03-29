package com.opos.mobad.template.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.cmn.o;
import com.opos.mobad.template.cmn.y;
import com.opos.mobad.template.cmn.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t extends com.opos.mobad.template.j.a {
    private Context A;
    private com.opos.mobad.d.a B;
    private boolean C;
    private com.opos.mobad.template.d.b D;
    private boolean E;
    private boolean F;
    private com.opos.mobad.template.cmn.p G;
    private com.opos.mobad.template.cmn.p H;
    private com.opos.mobad.template.cmn.q I;
    private com.opos.mobad.template.cmn.p J;
    private com.opos.mobad.template.cmn.baseview.f K;
    private j.b L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f9612a;
    private z b;
    private RelativeLayout c;
    private RelativeLayout g;
    private LinearLayout h;
    private View i;
    private View j;
    private y k;
    private com.opos.mobad.template.cmn.baseview.b l;
    private BaseTextView m;
    private int n;
    private ViewTreeObserver.OnPreDrawListener o;
    private RelativeLayout p;
    private com.opos.mobad.template.cmn.n q;
    private BaseTextView r;
    private TextView s;
    private TextView t;
    private com.opos.mobad.template.k.c u;
    private com.opos.mobad.template.a.c v;
    private com.opos.mobad.template.cmn.o w;
    private boolean x;
    private boolean y;
    private boolean z;

    public t(Context context, int i, boolean z, com.opos.mobad.d.a aVar) {
        super(i);
        this.x = false;
        this.y = false;
        this.z = false;
        this.E = false;
        this.F = false;
        this.G = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.t.11
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.h(view, iArr);
            }
        };
        this.H = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.t.12
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.a(4, iArr);
            }

            @Override // com.opos.mobad.template.cmn.p, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setBackgroundColor(t.this.A.getResources().getColor(R.color.opos_mobad_retain_split_color));
                } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                    view.setBackgroundColor(0);
                }
                return super.onTouch(view, motionEvent);
            }
        };
        this.I = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.f.t.13
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.cmn.q, com.opos.mobad.template.cmn.p, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    t.this.m.setBackgroundColor(t.this.A.getResources().getColor(R.color.opos_mobad_retain_split_color));
                } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                    t.this.m.setBackgroundColor(0);
                }
                return super.onTouch(view, motionEvent);
            }
        };
        this.J = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.t.14
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.cmn.p, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setBackgroundColor(t.this.A.getResources().getColor(R.color.opos_mobad_retain_split_color));
                } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                    view.setBackgroundColor(0);
                }
                return super.onTouch(view, motionEvent);
            }
        };
        this.K = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.t.15
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("InterRetainEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                t.this.a(view, i2, z2);
            }
        };
        this.L = new j.b() { // from class: com.opos.mobad.template.f.t.7
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return t.this.n() == 8;
            }
        };
        this.A = context.getApplicationContext();
        this.B = aVar;
        this.C = z;
        i();
    }

    private void p() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A);
        this.c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.c.setPadding(0, com.opos.cmn.an.h.f.a.a(this.A, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.A, 6.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.c.setGravity(1);
        this.b.addView(this.c, layoutParams);
        TextView textView = new TextView(this.A);
        textView.setId(View.generateViewId());
        textView.setTextSize(1, 18.0f);
        textView.setText("确定退出吗？");
        com.opos.mobad.template.h.a(textView);
        textView.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.c.addView(textView);
    }

    private void q() {
        LinearLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.A);
        this.g = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.c.getId());
        this.b.addView(this.g, layoutParams2);
        com.opos.mobad.template.cmn.o oVar = new com.opos.mobad.template.cmn.o(this.A);
        this.w = oVar;
        oVar.setVerticalScrollBarEnabled(false);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        this.w.setFillViewport(true);
        this.g.addView(this.w, layoutParams3);
        this.w.a(new o.a() { // from class: com.opos.mobad.template.f.t.10
            @Override // com.opos.mobad.template.cmn.o.a
            public void a(int i, int i2, int i3, int i4) {
                if (!t.this.x || t.this.i == null || t.this.j == null) {
                    return;
                }
                if (i2 == 0) {
                    t.this.i.setVisibility(8);
                } else {
                    if (t.this.r()) {
                        t.this.i.setVisibility(0);
                        t.this.j.setVisibility(8);
                        return;
                    }
                    t.this.i.setVisibility(0);
                }
                t.this.j.setVisibility(0);
            }
        });
        LinearLayout linearLayout = new LinearLayout(this.A);
        this.h = linearLayout;
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
        this.h.setPadding(0, com.opos.cmn.an.h.f.a.a(this.A, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.A, 8.0f));
        this.w.addView(this.h, layoutParams4);
        com.opos.mobad.template.cmn.p.a(this.h, this.G);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 12.0f);
        layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 12.0f);
        layoutParams5.bottomMargin = com.opos.cmn.an.h.f.a.a(this.A, 10.0f);
        layoutParams5.gravity = 1;
        TextView textView = new TextView(this.A);
        textView.setTextSize(1, 14.0f);
        textView.setText("为你推荐更多精彩内容");
        com.opos.mobad.template.h.a(textView);
        textView.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.h.addView(textView, layoutParams5);
        if (this.C) {
            int iB = com.opos.cmn.an.h.f.a.b(this.A);
            int iA = (iB <= 0 || iB > com.opos.cmn.an.h.f.a.a(this.A, 360.0f)) ? com.opos.cmn.an.h.f.a.a(this.A, 280.0f) : iB - com.opos.cmn.an.h.f.a.a(this.A, 80.0f);
            layoutParams = new LinearLayout.LayoutParams(iA, (iA * 9) / 16);
        } else {
            layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.A, 312.0f), com.opos.cmn.an.h.f.a.a(this.A, 175.0f));
        }
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 24.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 24.0f);
        layoutParams.gravity = 1;
        RelativeLayout relativeLayout2 = new RelativeLayout(this.A);
        this.p = relativeLayout2;
        relativeLayout2.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.A);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.A, 12.0f));
        gradientDrawable.setColor(this.A.getResources().getColor(R.color.opos_mobad_inter_quit_bg_color));
        relativeLayout3.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.A, com.opos.cmn.an.h.f.a.a(r6, 12.0f));
        this.k = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout3.addView(this.k, new RelativeLayout.LayoutParams(-1, -1));
        this.p.addView(relativeLayout3, layoutParams6);
        View view = new View(this.A);
        this.i = view;
        view.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
        layoutParams7.addRule(10);
        int[] iArr = {this.A.getResources().getColor(R.color.opos_mobad_retain_text_mark_startcolor), this.A.getResources().getColor(R.color.opos_mobad_retain_text_mark_endcolor)};
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        gradientDrawable2.setShape(0);
        this.i.setBackground(gradientDrawable2);
        this.g.addView(this.i, layoutParams7);
        View view2 = new View(this.A);
        this.j = view2;
        view2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
        layoutParams8.addRule(12);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        gradientDrawable3.setShape(0);
        this.j.setBackground(gradientDrawable3);
        this.g.addView(this.j, layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        com.opos.mobad.template.cmn.o oVar = this.w;
        if (oVar == null) {
            return false;
        }
        return (oVar.getScrollY() + this.w.getHeight()) + (this.w.getPaddingBottom() + this.w.getPaddingTop()) >= this.w.getChildAt(0).getHeight();
    }

    private void s() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.A);
        this.l = bVar;
        bVar.setId(View.generateViewId());
        if (this.C) {
            this.l.setOrientation(1);
            this.l.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, this.g.getId());
            this.b.addView(this.l, layoutParams);
            this.l.setPadding(com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 8.0f), com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f));
            com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.A);
            wVar.setBackgroundColor(this.A.getResources().getColor(R.color.opos_mobad_install_button_color));
            wVar.a(com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
            int iA = com.opos.cmn.an.h.f.a.a(this.A, 4.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 44.0f));
            layoutParams2.topMargin = iA;
            layoutParams2.bottomMargin = iA;
            this.l.addView(wVar, layoutParams2);
            BaseTextView baseTextView = new BaseTextView(this.A);
            this.m = baseTextView;
            baseTextView.setId(View.generateViewId());
            this.m.setTextSize(1, 16.0f);
            this.m.setTextColor(-1);
            this.m.setGravity(17);
            this.m.setSingleLine();
            this.m.setEllipsize(TextUtils.TruncateAt.END);
            com.opos.mobad.template.h.a(this.m);
            wVar.addView(this.m, new RelativeLayout.LayoutParams(-1, -1));
            com.opos.mobad.template.cmn.p.a(wVar, this.I);
            com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.A);
            wVar2.a(com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 44.0f));
            layoutParams3.topMargin = iA;
            layoutParams3.bottomMargin = iA;
            this.l.addView(wVar2, layoutParams3);
            BaseTextView baseTextView2 = new BaseTextView(this.A);
            baseTextView2.setText("退出");
            baseTextView2.setTextSize(1, 16.0f);
            baseTextView2.setGravity(17);
            baseTextView2.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_retain_btn_color));
            com.opos.mobad.template.h.a(baseTextView2);
            wVar2.addView(baseTextView2, new RelativeLayout.LayoutParams(-1, -1));
            com.opos.mobad.template.cmn.p.a(wVar2, this.H);
            return;
        }
        this.l.setOrientation(0);
        this.l.setWeightSum(2.0f);
        this.l.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, this.g.getId());
        this.b.addView(this.l, layoutParams4);
        this.l.a(this.K);
        LinearLayout linearLayout = new LinearLayout(this.A);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = 17;
        linearLayout.setPadding(com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
        this.l.addView(linearLayout, layoutParams5);
        com.opos.mobad.template.cmn.p.a(linearLayout, this.H);
        TextView textView = new TextView(this.A);
        textView.setText("退出");
        textView.setTextSize(1, 16.0f);
        textView.setGravity(17);
        Resources resources = this.A.getResources();
        int i = R.color.opos_mobad_retain_btn_color;
        textView.setTextColor(resources.getColor(i));
        textView.setMinHeight(com.opos.cmn.an.h.f.a.a(this.A, 24.0f));
        com.opos.mobad.template.h.a(textView);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 1;
        linearLayout.addView(textView, layoutParams6);
        LinearLayout linearLayout2 = new LinearLayout(this.A);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 17;
        linearLayout2.setPadding(0, com.opos.cmn.an.h.f.a.a(this.A, 14.0f), 0, com.opos.cmn.an.h.f.a.a(this.A, 24.0f));
        this.l.addView(linearLayout2, layoutParams7);
        LinearLayout linearLayout3 = new LinearLayout(this.A);
        linearLayout3.setBackgroundColor(this.A.getResources().getColor(R.color.opos_mobad_retain_split_color));
        linearLayout3.setGravity(17);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.A, 1.0f), com.opos.cmn.an.h.f.a.a(this.A, 20.0f)));
        LinearLayout linearLayout4 = new LinearLayout(this.A);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.weight = 1.0f;
        layoutParams8.gravity = 17;
        linearLayout4.setPadding(com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 24.0f), com.opos.cmn.an.h.f.a.a(this.A, 22.0f));
        this.l.addView(linearLayout4, layoutParams8);
        com.opos.mobad.template.cmn.p.a(linearLayout4, this.J);
        BaseTextView baseTextView3 = new BaseTextView(this.A);
        this.m = baseTextView3;
        baseTextView3.setText("退出");
        this.m.setTextSize(1, 16.0f);
        this.m.setTextColor(this.A.getResources().getColor(i));
        this.m.setMaxLines(2);
        this.m.setGravity(17);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setMinHeight(com.opos.cmn.an.h.f.a.a(this.A, 24.0f));
        com.opos.mobad.template.h.a(this.m);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.gravity = 1;
        linearLayout4.addView(this.m, layoutParams9);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f9612a;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        RelativeLayout relativeLayout = this.f9612a;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f9612a.removeAllViews();
        }
    }

    public static t b(Context context, int i, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return null;
        }
        return new t(context, i, true, aVar);
    }

    private void i() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.A);
        this.f9612a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f9612a.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.A, 24.0f));
        this.f9612a.setBackgroundColor(this.A.getResources().getColor(R.color.opos_mobad_retain_mark_color));
        this.f9612a.setVisibility(8);
        View view = new View(this.A);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f9612a.addView(view);
        com.opos.mobad.template.cmn.p.a(this.f9612a, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.t.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
                t.this.a(view2, iArr);
            }
        });
        z zVar = new z(this.A);
        this.b = zVar;
        zVar.a(com.opos.cmn.an.h.f.a.a(this.A, 24.0f));
        this.b.setBackgroundColor(this.A.getResources().getColor(R.color.opos_mobad_retain_bg_color));
        if (this.C) {
            this.n = com.opos.cmn.an.h.f.a.a(this.A, 600.0f);
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
        } else {
            int iB = com.opos.cmn.an.h.f.a.b(this.A);
            this.n = iB > 0 ? iB - com.opos.cmn.an.h.f.a.a(this.A, 64.0f) : com.opos.cmn.an.h.f.a.a(this.A, 296.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.A, 360.0f), -2);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 40.0f);
        }
        this.b.b(com.opos.cmn.an.h.f.a.a(this.A, 360.0f));
        this.b.a(this.n);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f9612a.addView(this.b, layoutParams);
        com.opos.mobad.template.cmn.p.a(this.b, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.t.8
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
            }
        });
        if (this.o == null) {
            this.o = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.f.t.9
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (t.this.n() != 8 && t.this.b != null && t.this.l != null && t.this.g != null) {
                        try {
                            if (t.this.b.getHeight() == t.this.n) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) t.this.l.getLayoutParams();
                                layoutParams2.removeRule(3);
                                layoutParams2.addRule(12);
                                t.this.b.updateViewLayout(t.this.l, layoutParams2);
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) t.this.g.getLayoutParams();
                                layoutParams3.addRule(2, t.this.l.getId());
                                t.this.b.updateViewLayout(t.this.g, layoutParams3);
                                if (t.this.j != null && t.this.j.getVisibility() != 0 && !t.this.x) {
                                    t.this.j.setVisibility(0);
                                }
                                t.this.x = true;
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("InterRetainEndPage", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            z zVar2 = this.b;
            if (zVar2 != null && zVar2.getViewTreeObserver().isAlive()) {
                this.b.getViewTreeObserver().addOnPreDrawListener(this.o);
            }
        }
        p();
        q();
        s();
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    public static t a(Context context, int i, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return null;
        }
        return new t(context, i, false, aVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            this.s.setVisibility(0);
            return;
        }
        com.opos.mobad.template.a.c cVar = this.v;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.v.a(aVar.f9412a, aVar.b);
            this.v.a(this.e);
        }
    }

    private void b(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.B, new j.c() { // from class: com.opos.mobad.template.f.t.4
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (t.this.n() == 8) {
                    return;
                }
                t.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                if (t.this.n() == 8 || bitmap == null) {
                    return;
                }
                t.this.k.setImageBitmap(bitmap);
            }
        }, this.L);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.t.5
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.t.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (t.this.n() == 8) {
                                return;
                            }
                            t.this.a((Map<String, String>) null);
                        }
                    });
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.f.t.6
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.t.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (t.this.n() == 8) {
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("isVisibleRect", String.valueOf(z));
                        map.put("isAttached", String.valueOf(z2));
                        t.this.b(map);
                    }
                });
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        boolean z;
        BaseTextView baseTextView;
        TextView textView;
        TextView textView2;
        BaseTextView baseTextView2;
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            a(false);
            z = false;
        } else {
            z = true;
            a(true);
        }
        if (z) {
            a(bVar.k);
        }
        b(bVar.c.get(0));
        if (!TextUtils.isEmpty(bVar.j) && (baseTextView2 = this.m) != null) {
            baseTextView2.setText(bVar.j);
        }
        if (!TextUtils.isEmpty(bVar.f9413a) && (textView = this.s) != null) {
            textView.setText(bVar.f9413a);
            if (z && (textView2 = this.t) != null) {
                textView2.setText(bVar.f9413a);
            }
        }
        if (!TextUtils.isEmpty(bVar.b) && (baseTextView = this.r) != null) {
            baseTextView.setText(bVar.b);
        }
        a(z, bVar);
        b(bVar);
    }

    private void a(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.B, new j.c() { // from class: com.opos.mobad.template.f.t.3
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (t.this.n() == 8) {
                    return;
                }
                t.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                if (t.this.n() == 8 || bitmap == null) {
                    return;
                }
                t.this.q.setImageBitmap(bitmap);
            }
        }, this.L);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("InterRetainEndPage", "data is null");
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA == null) {
                str = "render with data null";
            } else {
                List<com.opos.mobad.template.d.e> list = bVarA.c;
                if (list != null && list.size() > 0) {
                    if (com.opos.mobad.template.h.d(this.A) && !this.C && !this.F) {
                        this.E = true;
                        int iE = this.n - com.opos.mobad.template.h.e(this.A);
                        this.n = iE;
                        this.b.a(iE);
                        this.F = true;
                        com.opos.cmn.an.f.a.b("InterRetainEndPage", "  isGestureNavMode " + this.E + "  mMaxHeight " + this.n + "  getNavBarHeightRes " + com.opos.mobad.template.h.e(this.A));
                        this.f9612a.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.opos.mobad.template.f.t.2
                            @Override // android.view.View.OnApplyWindowInsetsListener
                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                if (Build.VERSION.SDK_INT >= 30) {
                                    boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.navigationBars());
                                    com.opos.cmn.an.f.a.b("InterRetainEndPage", zIsVisible + "  isNavBarVisible  ");
                                    if (!zIsVisible) {
                                        t.this.n += com.opos.mobad.template.h.e(t.this.A);
                                        t.this.b.a(t.this.n);
                                        com.opos.cmn.an.f.a.b("InterRetainEndPage", "onApplyWindowInsets  mMaxHeight" + t.this.n);
                                    }
                                }
                                return windowInsets;
                            }
                        });
                    }
                    if (bVarA.J.containsKey("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR") && "1".equals(bVarA.J.get("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR")) && !this.C && !this.z) {
                        int iC = this.n - com.opos.mobad.template.h.c(this.A);
                        this.n = iC;
                        this.b.a(iC);
                        this.z = true;
                    }
                    a(bVarA);
                    if (this.D == null && this.f9612a != null) {
                        m();
                        a((ViewGroup) this.f9612a);
                        if (this.f9612a.getVisibility() != 0) {
                            this.f9612a.setVisibility(0);
                        }
                    }
                    this.D = bVarA;
                    return;
                }
                str = "render with imgList null";
            }
            com.opos.cmn.an.f.a.d("InterRetainEndPage", str);
        }
        a(1);
    }

    private void a(boolean z) {
        if (this.y) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.A);
        relativeLayout.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(this.A);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.A);
        linearLayout2.setOrientation(0);
        BaseTextView baseTextView = new BaseTextView(this.A);
        this.r = baseTextView;
        baseTextView.setTextSize(1, 14.0f);
        this.r.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.r.setSingleLine(true);
        com.opos.mobad.template.h.a(this.r);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 16;
        linearLayout2.addView(this.r, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 4.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 4.0f);
        TextView textView = new TextView(this.A);
        this.s = textView;
        textView.setTextSize(1, 10.0f);
        this.s.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.s.setSingleLine(true);
        this.s.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 4.0f);
        if (z) {
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 42.0f));
            layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 24.0f);
            layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 24.0f);
            if (this.C) {
                layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 12.0f);
            } else {
                layoutParams5.bottomMargin = com.opos.cmn.an.h.f.a.a(this.A, 12.0f);
            }
            RelativeLayout relativeLayout2 = new RelativeLayout(this.A);
            relativeLayout2.setId(View.generateViewId());
            int iA = com.opos.cmn.an.h.f.a.a(this.A, 0.33f);
            relativeLayout2.setPadding(iA, iA, iA, iA);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(this.A, 0.33f), this.A.getResources().getColor(R.color.opos_mobad_inter_quit_stroke_color));
            gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.A, 8.0f));
            gradientDrawable.setColor(this.A.getResources().getColor(R.color.opos_mobad_inter_quit_bg_color));
            relativeLayout2.setBackground(gradientDrawable);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.A, 42.0f), com.opos.cmn.an.h.f.a.a(this.A, 42.0f));
            layoutParams6.addRule(15);
            relativeLayout.addView(relativeLayout2, layoutParams6);
            com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.A, com.opos.cmn.an.h.f.a.a(r9, 8.0f));
            this.q = nVar;
            nVar.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout2.addView(this.q, new RelativeLayout.LayoutParams(-1, -1));
            this.r.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_native_template_title_color));
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.A, 1, 0, this.B);
            this.u = cVarA;
            linearLayout2.addView(cVarA, layoutParams2);
            Context context = this.A;
            com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(context, context.getResources().getColor(R.color.opos_mobad_version_company_color));
            this.v = cVar;
            cVar.setVisibility(8);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(this.v, layoutParams3);
            this.s.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_des_color));
            linearLayout.addView(this.s, layoutParams4);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams7.addRule(15);
            layoutParams7.addRule(1, relativeLayout2.getId());
            layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 8.0f);
            relativeLayout.addView(linearLayout, layoutParams7);
            RelativeLayout relativeLayout3 = new RelativeLayout(this.A);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 48.0f));
            layoutParams8.addRule(12);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1291845632});
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f)});
            gradientDrawable2.setShape(0);
            relativeLayout3.setBackground(gradientDrawable2);
            this.p.addView(relativeLayout3, layoutParams8);
            TextView textView2 = new TextView(this.A);
            this.t = textView2;
            textView2.setTextColor(Color.argb(229, 255, 255, 255));
            this.t.setTextSize(1, 12.0f);
            this.t.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.t.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            layoutParams9.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            relativeLayout3.addView(this.t, layoutParams9);
            if (this.C) {
                this.h.addView(this.p);
                this.h.addView(relativeLayout, layoutParams5);
            } else {
                this.h.addView(relativeLayout, layoutParams5);
                this.h.addView(this.p);
            }
        } else {
            this.r.setTextColor(this.A.getResources().getColor(R.color.opos_mobad_banner_close_normal_color));
            com.opos.mobad.template.k.c cVarA2 = com.opos.mobad.template.k.c.a(this.A, 0, 0, this.B);
            this.u = cVarA2;
            linearLayout2.addView(cVarA2, layoutParams2);
            com.opos.mobad.template.a.c cVar2 = new com.opos.mobad.template.a.c(this.A, Color.argb(138, 255, 255, 255));
            this.v = cVar2;
            cVar2.setVisibility(8);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(this.v, layoutParams3);
            this.s.setTextColor(Color.argb(138, 255, 255, 255));
            linearLayout.addView(this.s, layoutParams4);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams10.addRule(15);
            layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            layoutParams10.rightMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            relativeLayout.addView(linearLayout, layoutParams10);
            View view = new View(this.A);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 66.0f));
            layoutParams11.addRule(12);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1291845632});
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f), com.opos.cmn.an.h.f.a.a(this.A, 12.0f)});
            gradientDrawable3.setShape(0);
            view.setBackground(gradientDrawable3);
            this.p.addView(view, layoutParams11);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.A, 66.0f));
            layoutParams12.topMargin = com.opos.cmn.an.h.f.a.a(this.A, 16.0f);
            layoutParams12.addRule(12);
            this.h.addView(this.p);
            this.p.addView(relativeLayout, layoutParams12);
        }
        this.y = true;
    }

    private void a(boolean z, com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.k.c cVar = this.u;
        if (cVar != null) {
            if (z) {
                cVar.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
            } else {
                cVar.a(bVar.p, bVar.e, bVar.g, bVar.i);
            }
            this.u.a(this.e);
        }
    }
}
