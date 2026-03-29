package com.opos.mobad.template.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.cmn.y;
import com.opos.mobad.template.cmn.z;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m extends com.opos.mobad.template.j.a {
    private com.opos.mobad.d.a A;
    private boolean B;
    private int C;
    private Bitmap D;
    private ViewTreeObserver.OnPreDrawListener E;
    private boolean F;
    private boolean G;
    private boolean H;
    private com.opos.mobad.template.cmn.p I;
    private com.opos.mobad.template.cmn.p J;
    private com.opos.mobad.template.cmn.baseview.f K;
    private j.b L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.d.d.a f9555a;
    private RelativeLayout b;
    private z c;
    private RelativeLayout g;
    private RelativeLayout h;
    private LinearLayout i;
    private View j;
    private View k;
    private y l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private y v;
    private TextView w;
    private com.opos.mobad.template.cmn.baseview.b x;
    private TextView y;
    private Context z;

    public m(Context context, int i, boolean z, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i);
        this.D = null;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                m.this.a(2, iArr);
            }
        };
        this.J = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                m.this.a(3, iArr);
            }
        };
        this.K = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.m.7
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("InterRetainEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                m.this.a(view, i2, z2);
            }
        };
        this.L = new j.b() { // from class: com.opos.mobad.template.f.m.3
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return m.this.n() == 8;
            }
        };
        this.z = context.getApplicationContext();
        this.A = aVar2;
        this.B = z;
        this.f9555a = aVar;
        i();
    }

    private void p() {
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        this.g = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.g.setPadding(0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 6.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.g.setGravity(1);
        this.c.addView(this.g, layoutParams);
        TextView textView = new TextView(this.z);
        textView.setTextSize(1, 18.0f);
        textView.setText("是否要关闭这条广告？");
        com.opos.mobad.template.h.a(textView);
        textView.setTextColor(this.z.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.g.addView(textView);
    }

    private void q() {
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        this.h = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.g.getId());
        this.c.addView(this.h, layoutParams);
        ScrollView scrollView = new ScrollView(this.z);
        scrollView.setVerticalScrollBarEnabled(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        scrollView.setFillViewport(true);
        this.h.addView(scrollView, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.z);
        this.i = linearLayout;
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
        this.i.setPadding(0, com.opos.cmn.an.h.f.a.a(this.z, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 8.0f));
        scrollView.addView(this.i, layoutParams3);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.z, com.opos.cmn.an.h.f.a.a(r5, 12.0f));
        this.l = nVar;
        nVar.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.z, 60.0f), com.opos.cmn.an.h.f.a.a(this.z, 60.0f));
        layoutParams4.gravity = 1;
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 8.0f);
        this.i.addView(this.l, layoutParams4);
        TextView textView = new TextView(this.z);
        this.m = textView;
        textView.setVisibility(8);
        this.m.setTextSize(1, 16.0f);
        this.m.setLines(1);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.m;
        Resources resources = this.z.getResources();
        int i = R.color.opos_mobad_retain_title_color;
        textView2.setTextColor(resources.getColor(i));
        this.m.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 8.0f);
        layoutParams5.gravity = 1;
        com.opos.mobad.template.h.a(this.m);
        this.i.addView(this.m, layoutParams5);
        TextView textView3 = new TextView(this.z);
        this.n = textView3;
        textView3.setVisibility(8);
        this.n.setTextSize(1, 12.0f);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = this.n;
        Resources resources2 = this.z.getResources();
        int i2 = R.color.opos_mobad_retain_des_color;
        textView4.setTextColor(resources2.getColor(i2));
        this.n.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 1;
        layoutParams6.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 8.0f);
        this.i.addView(this.n, layoutParams6);
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        this.o = linearLayout2;
        linearLayout2.setVisibility(8);
        this.o.setOrientation(0);
        this.o.setWeightSum(3.0f);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.z, 48.0f));
        this.o.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 20.0f), com.opos.cmn.an.h.f.a.a(this.z, 8.0f), com.opos.cmn.an.h.f.a.a(this.z, 20.0f), 0);
        this.i.addView(this.o, layoutParams7);
        LinearLayout linearLayout3 = new LinearLayout(this.z);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams8.weight = 1.0f;
        this.o.addView(linearLayout3, layoutParams8);
        TextView textView5 = new TextView(this.z);
        this.p = textView5;
        textView5.setTextSize(1, 16.0f);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.p);
        this.p.setTextColor(this.z.getResources().getColor(i));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 2.0f);
        layoutParams9.gravity = 1;
        linearLayout3.addView(this.p, layoutParams9);
        TextView textView6 = new TextView(this.z);
        this.q = textView6;
        textView6.setTextSize(1, 12.0f);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextColor(this.z.getResources().getColor(i2));
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.gravity = 1;
        linearLayout3.addView(this.q, layoutParams10);
        LinearLayout linearLayout4 = new LinearLayout(this.z);
        linearLayout4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams11.weight = 1.0f;
        this.o.addView(linearLayout4, layoutParams11);
        TextView textView7 = new TextView(this.z);
        this.r = textView7;
        textView7.setTextSize(1, 16.0f);
        this.r.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.r);
        this.r.setTextColor(this.z.getResources().getColor(i));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 2.0f);
        layoutParams12.gravity = 1;
        linearLayout4.addView(this.r, layoutParams12);
        TextView textView8 = new TextView(this.z);
        this.s = textView8;
        textView8.setTextSize(1, 12.0f);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setTextColor(this.z.getResources().getColor(i2));
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 1;
        linearLayout4.addView(this.s, layoutParams13);
        LinearLayout linearLayout5 = new LinearLayout(this.z);
        linearLayout5.setOrientation(1);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams14.weight = 1.0f;
        this.o.addView(linearLayout5, layoutParams14);
        TextView textView9 = new TextView(this.z);
        this.t = textView9;
        textView9.setTextSize(1, 16.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.t);
        this.t.setTextColor(this.z.getResources().getColor(i));
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 2.0f);
        layoutParams15.gravity = 1;
        linearLayout5.addView(this.t, layoutParams15);
        TextView textView10 = new TextView(this.z);
        this.u = textView10;
        textView10.setTextSize(1, 12.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.END);
        this.u.setTextColor(this.z.getResources().getColor(i2));
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams16.gravity = 1;
        linearLayout5.addView(this.u, layoutParams16);
        com.opos.mobad.template.cmn.n nVar2 = new com.opos.mobad.template.cmn.n(this.z, com.opos.cmn.an.h.f.a.a(r7, 16.0f));
        this.v = nVar2;
        nVar2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.setVisibility(8);
        this.i.addView(this.v);
        TextView textView11 = new TextView(this.z);
        this.w = textView11;
        textView11.setVisibility(8);
        this.w.setTextSize(1, 14.0f);
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setTextColor(this.z.getResources().getColor(i));
        this.w.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f), 0);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams17.gravity = 1;
        this.i.addView(this.w, layoutParams17);
        View view = new View(this.z);
        this.k = view;
        view.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.z, 36.0f));
        layoutParams18.addRule(10);
        int[] iArr = {this.z.getResources().getColor(R.color.opos_mobad_retain_text_mark_startcolor), this.z.getResources().getColor(R.color.opos_mobad_retain_text_mark_endcolor)};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        gradientDrawable.setShape(0);
        this.k.setBackground(gradientDrawable);
        this.h.addView(this.k, layoutParams18);
        View view2 = new View(this.z);
        this.j = view2;
        view2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.z, 36.0f));
        layoutParams19.addRule(12);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        gradientDrawable2.setShape(0);
        this.j.setBackground(gradientDrawable2);
        this.h.addView(this.j, layoutParams19);
    }

    private void r() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.z);
        this.x = bVar;
        bVar.setId(View.generateViewId());
        this.x.setOrientation(0);
        this.x.setWeightSum(2.0f);
        this.x.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.h.getId());
        this.c.addView(this.x, layoutParams);
        this.x.a(this.K);
        LinearLayout linearLayout = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        linearLayout.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 24.0f), com.opos.cmn.an.h.f.a.a(this.z, 12.0f), com.opos.cmn.an.h.f.a.a(this.z, 24.0f), com.opos.cmn.an.h.f.a.a(this.z, 22.0f));
        this.x.addView(linearLayout, layoutParams2);
        com.opos.mobad.template.cmn.p.a(linearLayout, this.J);
        TextView textView = new TextView(this.z);
        this.y = textView;
        textView.setText("确认关闭");
        this.y.setTextSize(1, 16.0f);
        TextView textView2 = this.y;
        Resources resources = this.z.getResources();
        int i = R.color.opos_mobad_retain_btn_color;
        textView2.setTextColor(resources.getColor(i));
        this.y.setMaxLines(2);
        this.y.setGravity(17);
        this.y.setEllipsize(TextUtils.TruncateAt.END);
        this.y.setMinHeight(com.opos.cmn.an.h.f.a.a(this.z, 24.0f));
        com.opos.mobad.template.h.a(this.y);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.y, layoutParams3);
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        linearLayout2.setPadding(0, com.opos.cmn.an.h.f.a.a(this.z, 14.0f), 0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f));
        this.x.addView(linearLayout2, layoutParams4);
        LinearLayout linearLayout3 = new LinearLayout(this.z);
        linearLayout3.setBackgroundColor(this.z.getResources().getColor(R.color.opos_mobad_retain_split_color));
        linearLayout3.setGravity(17);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.z, 1.0f), com.opos.cmn.an.h.f.a.a(this.z, 20.0f)));
        LinearLayout linearLayout4 = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = 17;
        linearLayout4.setPadding(com.opos.cmn.an.h.f.a.a(this.z, 24.0f), com.opos.cmn.an.h.f.a.a(this.z, 12.0f), com.opos.cmn.an.h.f.a.a(this.z, 24.0f), com.opos.cmn.an.h.f.a.a(this.z, 22.0f));
        this.x.addView(linearLayout4, layoutParams5);
        TextView textView3 = new TextView(this.z);
        textView3.setText("确认关闭");
        textView3.setTextSize(1, 16.0f);
        textView3.setGravity(17);
        textView3.setTextColor(this.z.getResources().getColor(i));
        textView3.setMinHeight(com.opos.cmn.an.h.f.a.a(this.z, 24.0f));
        com.opos.mobad.template.h.a(textView3);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 1;
        linearLayout4.addView(textView3, layoutParams6);
        com.opos.mobad.template.cmn.p.a(linearLayout4, this.I);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.b;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.f9555a = null;
        try {
            RelativeLayout relativeLayout = this.b;
            if (relativeLayout != null) {
                relativeLayout.clearAnimation();
                this.b.removeAllViews();
                this.b = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterRetainEndPage", "doEnd() fail", e);
        }
    }

    public static m b(Context context, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, int i) {
        if (context == null) {
            return null;
        }
        return new m(context, i, true, aVar, aVar2);
    }

    private void i() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        this.b = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.b.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.z, 24.0f));
        this.b.setBackgroundColor(this.z.getResources().getColor(R.color.opos_mobad_retain_mark_color));
        View view = new View(this.z);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.b.addView(view);
        com.opos.mobad.template.cmn.p.a(this.b, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
            }
        });
        z zVar = new z(this.z);
        this.c = zVar;
        zVar.a(com.opos.cmn.an.h.f.a.a(this.z, 24.0f));
        this.c.setBackgroundColor(this.z.getResources().getColor(R.color.opos_mobad_retain_bg_color));
        if (this.B) {
            this.C = com.opos.cmn.an.h.f.a.a(this.z, 600.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.z, 328.0f), -2);
        } else {
            int iB = com.opos.cmn.an.h.f.a.b(this.z);
            this.C = iB > 0 ? iB - com.opos.cmn.an.h.f.a.a(this.z, 64.0f) : com.opos.cmn.an.h.f.a.a(this.z, 280.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.z, 360.0f), -2);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.z, 40.0f);
        }
        this.c.a(this.C);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.b.addView(this.c, layoutParams);
        if (this.E == null) {
            this.E = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.f.m.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (m.this.n() != 8 && m.this.c != null && m.this.x != null && m.this.h != null) {
                        try {
                            if (m.this.c.getHeight() == m.this.C) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) m.this.x.getLayoutParams();
                                layoutParams2.removeRule(3);
                                layoutParams2.addRule(12);
                                m.this.c.updateViewLayout(m.this.x, layoutParams2);
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) m.this.h.getLayoutParams();
                                layoutParams3.addRule(2, m.this.x.getId());
                                m.this.c.updateViewLayout(m.this.h, layoutParams3);
                                if (m.this.j != null && m.this.j.getVisibility() != 0) {
                                    m.this.j.setVisibility(0);
                                }
                                if (m.this.k != null && m.this.k.getVisibility() != 0) {
                                    m.this.k.setVisibility(0);
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("InterRetainEndPage", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            z zVar2 = this.c;
            if (zVar2 != null && zVar2.getViewTreeObserver().isAlive()) {
                this.c.getViewTreeObserver().addOnPreDrawListener(this.E);
            }
        }
        p();
        q();
        r();
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    private void b(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.A, new j.c() { // from class: com.opos.mobad.template.f.m.2
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (m.this.n() == 8) {
                    return;
                }
                m.this.b(i);
                m mVar = m.this;
                mVar.a(mVar.B, (Bitmap) null, (BitmapDrawable) null, m.this.B);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                m mVar;
                boolean z;
                if (m.this.n() == 8) {
                    return;
                }
                if (bitmap == null) {
                    m mVar2 = m.this;
                    mVar2.a(mVar2.B, (Bitmap) null, (BitmapDrawable) null, m.this.B);
                    return;
                }
                if (bitmap.getHeight() > bitmap.getWidth()) {
                    mVar = m.this;
                    z = true;
                } else {
                    mVar = m.this;
                    z = false;
                }
                mVar.a(z, bitmap, (BitmapDrawable) null, mVar.B);
            }
        }, this.L);
    }

    public static m a(Context context, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, int i) {
        if (context == null) {
            return null;
        }
        return new m(context, i, false, aVar, aVar2);
    }

    private void a(final TextView textView) {
        if (textView == null) {
            return;
        }
        try {
            textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.f.m.10
                /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[PHI: r1
                  0x0028: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:11:0x0026, B:8:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onPreDraw() {
                    int i;
                    if (m.this.n() == 8) {
                        return true;
                    }
                    if (textView.getLineCount() > 1) {
                        i = 3;
                        if (textView.getGravity() != 3) {
                            textView.setGravity(i);
                        }
                    } else {
                        i = 17;
                        if (textView.getGravity() != 17) {
                        }
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("InterRetainEndPage", "preDrawListener->setLineStyle->Exception:" + e);
        }
    }

    private void a(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.A, new j.c() { // from class: com.opos.mobad.template.f.m.11
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (m.this.n() == 8) {
                    return;
                }
                m.this.b(i);
                com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(m.this.z, 60.0f), com.opos.cmn.an.h.f.a.a(m.this.z, 60.0f), m.this.l);
                m.this.l.setVisibility(0);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                if (m.this.n() == 8) {
                    return;
                }
                if (bitmap != null) {
                    m.this.l.setImageBitmap(bitmap);
                } else {
                    com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(m.this.z, 60.0f), com.opos.cmn.an.h.f.a.a(m.this.z, 60.0f), m.this.l);
                }
                m.this.l.setVisibility(0);
            }
        }, this.L);
    }

    private void a(com.opos.mobad.template.d.e eVar, String str, String str2) {
        if (this.D != null) {
            this.v.setBackground(new BitmapDrawable(this.D));
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            af.a(this.f9555a, eVar.f9414a, new af.a() { // from class: com.opos.mobad.template.f.m.9
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                    m.this.b(2);
                    m mVar = m.this;
                    mVar.a(mVar.B, (Bitmap) null, (BitmapDrawable) null, m.this.B);
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(final Bitmap bitmap) {
                    if (m.this.n() == 8) {
                        return;
                    }
                    m.this.D = bitmap;
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.m.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m mVar;
                            BitmapDrawable bitmapDrawable;
                            boolean z;
                            boolean z2;
                            if (m.this.n() == 8) {
                                return;
                            }
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null) {
                                m mVar2 = m.this;
                                mVar2.a(mVar2.B, (Bitmap) null, (BitmapDrawable) null, m.this.B);
                                return;
                            }
                            if (bitmap.getHeight() > bitmap2.getWidth()) {
                                mVar = m.this;
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                z = m.this.B;
                                z2 = true;
                            } else {
                                mVar = m.this;
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                z = m.this.B;
                                z2 = false;
                            }
                            mVar.a(z2, (Bitmap) null, bitmapDrawable, z);
                        }
                    });
                }
            });
        }
        if (!TextUtils.isEmpty(str)) {
            this.w.setText(str);
            this.w.setVisibility(0);
            a(this.w);
            this.w.setVisibility(0);
        }
        a(str2);
    }

    private void a(com.opos.mobad.template.d.e eVar, String str, String str2, List<Pair<String, String>> list, String str3) {
        boolean z;
        boolean z2;
        a(eVar);
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
            this.m.setVisibility(0);
        }
        if (list != null && list.size() == 3) {
            Pair<String, String> pair = list.get(0);
            boolean z3 = true;
            if (pair == null || TextUtils.isEmpty(pair.first.toString()) || TextUtils.isEmpty(pair.second.toString())) {
                z = false;
            } else {
                this.p.setText(pair.first.toString());
                this.q.setText(pair.second.toString());
                z = true;
            }
            Pair<String, String> pair2 = list.get(1);
            if (pair2 == null || TextUtils.isEmpty(pair2.first.toString()) || TextUtils.isEmpty(pair2.second.toString())) {
                z2 = false;
            } else {
                this.r.setText(pair2.first.toString());
                this.s.setText(pair2.second.toString());
                z2 = true;
            }
            Pair<String, String> pair3 = list.get(2);
            if (pair3 == null || TextUtils.isEmpty(pair3.first.toString()) || TextUtils.isEmpty(pair3.second.toString())) {
                z3 = false;
            } else {
                this.t.setText(pair3.first.toString());
                this.u.setText(pair3.second.toString());
            }
            if (z && z2 && z3) {
                this.o.setVisibility(0);
                if (!TextUtils.isEmpty(str2)) {
                    this.n.setText(str2);
                    this.n.setVisibility(0);
                    a(this.n);
                }
            }
        }
        a(str3);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("InterRetainEndPage", "data is null");
        } else {
            com.opos.mobad.template.d.d dVarC = fVar.c();
            if (dVarC != null) {
                if (com.opos.mobad.template.h.d(this.z) && !this.B && !this.H) {
                    this.G = true;
                    int iE = this.C - com.opos.mobad.template.h.e(this.z);
                    this.C = iE;
                    this.c.a(iE);
                    this.H = true;
                    com.opos.cmn.an.f.a.b("InterRetainEndPage", "  isGestureNavMode " + this.G + "  mMaxHeight " + this.C + "  getNavBarHeightRes " + com.opos.mobad.template.h.e(this.z));
                    RelativeLayout relativeLayout = this.b;
                    if (relativeLayout != null) {
                        relativeLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.opos.mobad.template.f.m.8
                            @Override // android.view.View.OnApplyWindowInsetsListener
                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                if (Build.VERSION.SDK_INT >= 30) {
                                    boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.navigationBars());
                                    com.opos.cmn.an.f.a.b("InterRetainEndPage", zIsVisible + "  isNavBarVisible  ");
                                    if (!zIsVisible) {
                                        m.this.C += com.opos.mobad.template.h.e(m.this.z);
                                        m.this.c.a(m.this.C);
                                        com.opos.cmn.an.f.a.b("InterRetainEndPage", "onApplyWindowInsets  mMaxHeight" + m.this.C);
                                    }
                                }
                                return windowInsets;
                            }
                        });
                    }
                }
                if (dVarC.J.containsKey("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR") && "1".equals(dVarC.J.get("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR")) && !this.B && !this.F) {
                    int iC = this.C - com.opos.mobad.template.h.c(this.z);
                    this.C = iC;
                    this.c.a(iC);
                    this.F = true;
                }
                if ("0".equals(dVarC.J.containsKey("EXT_PARAM_KEY_TYPE_LINK") ? dVarC.J.get("EXT_PARAM_KEY_TYPE_LINK") : null)) {
                    a(dVarC.O, dVarC.Q, dVarC.R, dVarC.K, dVarC.S);
                    return;
                }
                List<com.opos.mobad.template.d.e> list = dVarC.d;
                if (list == null || list.size() <= 0) {
                    a(dVarC.N, dVarC.R, dVarC.S);
                    return;
                } else {
                    a(dVarC.d, dVarC.R, dVarC.S);
                    return;
                }
            }
            com.opos.cmn.an.f.a.d("InterRetainEndPage", "render with data null");
        }
        a(1);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.y.setText(str);
    }

    private void a(List<com.opos.mobad.template.d.e> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            b(list.get(0));
        }
        if (!TextUtils.isEmpty(str)) {
            this.w.setText(str);
            this.w.setVisibility(0);
            a(this.w);
            this.w.setVisibility(0);
        }
        a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, Bitmap bitmap, BitmapDrawable bitmapDrawable, boolean z2) {
        int iA;
        Context context;
        float f;
        Context context2 = this.z;
        if (z) {
            iA = com.opos.cmn.an.h.f.a.a(context2, 200.0f);
            context = this.z;
            f = 112.0f;
        } else {
            iA = com.opos.cmn.an.h.f.a.a(context2, 90.0f);
            context = this.z;
            f = 160.0f;
        }
        int iA2 = com.opos.cmn.an.h.f.a.a(context, f);
        y yVar = this.v;
        if (yVar != null) {
            if (bitmap != null) {
                if (!z2 && z) {
                    iA = com.opos.cmn.an.h.f.a.a(this.z, 90.0f);
                    iA2 = com.opos.cmn.an.h.f.a.a(this.z, 50.0f);
                }
                this.v.setImageBitmap(bitmap);
            } else if (bitmapDrawable != null) {
                if (!z2 && z) {
                    iA = com.opos.cmn.an.h.f.a.a(this.z, 90.0f);
                    iA2 = com.opos.cmn.an.h.f.a.a(this.z, 50.0f);
                }
                this.v.setBackground(bitmapDrawable);
            } else {
                com.opos.mobad.template.h.a(iA, iA2, yVar);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA);
            layoutParams.gravity = 1;
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.z, 8.0f);
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(0);
        }
    }
}
