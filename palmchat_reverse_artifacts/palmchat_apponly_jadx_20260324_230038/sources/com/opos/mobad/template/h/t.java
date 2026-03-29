package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.g.am;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10057a;
    private TextView b;
    private TextView c;
    private com.opos.mobad.d.a g;
    private TextView h;
    private com.opos.mobad.template.cmn.w i;
    private Context j;
    private RelativeLayout k;
    private RelativeLayout l;
    private com.opos.mobad.template.d.d m;
    private boolean n;
    private ImageView o;
    private boolean p;
    private com.opos.mobad.template.cmn.y q;
    private s r;
    private com.opos.mobad.template.k.c s;
    private ImageView t;
    private com.opos.mobad.template.cmn.q u;
    private com.opos.mobad.template.cmn.baseview.f v;
    private j.b w;

    public t(Context context, boolean z, com.opos.mobad.d.a aVar, int i) {
        super(i);
        this.f10057a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.t.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.b(view, iArr);
            }
        };
        this.u = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.t.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                t.this.c(view, iArr);
            }
        };
        this.v = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.t.6
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardGameEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                t.this.a(view, i2, z2);
            }
        };
        this.w = new j.b() { // from class: com.opos.mobad.template.h.t.7
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return t.this.n() == 8;
            }
        };
        this.g = aVar;
        this.j = context;
        this.p = z;
        p();
    }

    private void p() {
        RelativeLayout relativeLayout = new RelativeLayout(this.j);
        this.k = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 29) {
            this.k.setForceDarkAllowed(false);
        }
        ImageView imageView = new ImageView(this.j);
        this.t = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(this.j);
        view.setBackgroundColor(Color.parseColor("#66000000"));
        this.k.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        this.l = new RelativeLayout(this.j);
        this.k.addView(this.l, new RelativeLayout.LayoutParams(-1, -1));
        q();
        com.opos.mobad.template.cmn.m.a(this.j, this.l, this.p);
        com.opos.mobad.template.cmn.p.a(this.l, this.f10057a);
    }

    private void q() {
        int iA;
        int iA2;
        this.s = com.opos.mobad.template.k.c.a(this.j, 3, 0, this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.j, 28.0f));
        layoutParams.addRule(9);
        if (this.p) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 49.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.j, 24.0f);
        }
        layoutParams.leftMargin = iA;
        this.r = s.a(this.j);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        if (this.p) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 49.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.j, 24.0f);
        }
        layoutParams2.rightMargin = iA2;
        if (!this.p) {
            this.l.addView(this.s, layoutParams);
            this.l.addView(this.r, layoutParams2);
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.j);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.j, 94.0f));
        layoutParams3.addRule(10);
        cVar.setLayoutParams(layoutParams3);
        cVar.addView(this.s, layoutParams);
        cVar.addView(this.r, layoutParams2);
        this.l.addView(cVar);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.k;
    }

    public static t a(Context context, com.opos.mobad.d.a aVar, int i) {
        return new t(context, true, aVar, i);
    }

    public static t b(Context context, com.opos.mobad.d.a aVar, int i) {
        return new t(context, false, aVar, i);
    }

    private void a(int i, int i2) {
        am amVarA = am.a(this.j);
        com.opos.mobad.template.cmn.aa aaVar = new com.opos.mobad.template.cmn.aa(this.j, new aa.a(amVarA.f9704a, amVarA.b, i, i / i2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(13);
        this.l.addView(aaVar, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.j);
        aaVar.addView(relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.j);
        wVar.setId(View.generateViewId());
        wVar.a(com.opos.cmn.an.h.f.a.a(this.j, 16.0f));
        relativeLayout.addView(wVar, new RelativeLayout.LayoutParams(i, com.opos.cmn.an.h.f.a.a(this.j, 322.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(this.j, 184.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.j);
        relativeLayout2.setId(View.generateViewId());
        wVar.addView(relativeLayout2, new RelativeLayout.LayoutParams(i, iA));
        ImageView imageView = new ImageView(this.j);
        this.o = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout2.addView(this.o, new RelativeLayout.LayoutParams(i, iA));
        int iA2 = com.opos.cmn.an.h.f.a.a(this.j, 138.0f);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.j);
        relativeLayout3.setId(View.generateViewId());
        relativeLayout3.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, iA2);
        layoutParams2.addRule(3, relativeLayout2.getId());
        wVar.addView(relativeLayout3, layoutParams2);
        int iA3 = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        int iA4 = com.opos.cmn.an.h.f.a.a(this.j, 50.0f);
        RelativeLayout relativeLayout4 = new RelativeLayout(this.j);
        relativeLayout4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, iA4);
        layoutParams3.topMargin = iA3;
        layoutParams3.leftMargin = iA3;
        layoutParams3.rightMargin = iA3;
        relativeLayout3.addView(relativeLayout4, layoutParams3);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.j, com.opos.cmn.an.h.f.a.a(r12, 12.0f));
        this.q = nVar;
        nVar.setId(View.generateViewId());
        this.q.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout4.addView(this.q, new RelativeLayout.LayoutParams(iA4, iA4));
        LinearLayout linearLayout = new LinearLayout(this.j);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, 234.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, this.q.getId());
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        relativeLayout4.addView(linearLayout, layoutParams4);
        TextView textView = new TextView(this.j);
        this.b = textView;
        textView.setTextColor(Color.argb(229, 0, 0, 0));
        this.b.setTextSize(1, 16.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        com.opos.mobad.template.h.a(this.b);
        linearLayout.addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.j);
        this.c = textView2;
        textView2.setTextColor(Color.argb(138, 0, 0, 0));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 2.0f);
        linearLayout.addView(this.c, layoutParams5);
        this.i = new com.opos.mobad.template.cmn.w(this.j);
        TextView textView3 = new TextView(this.j);
        this.h = textView3;
        textView3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.h);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(13);
        this.i.a(90.0f);
        this.i.addView(this.h, layoutParams6);
        this.i.setBackgroundColor(Color.argb(255, 0, 102, 255));
        com.opos.mobad.template.cmn.p.a(this.i, this.u);
        this.i.a(this.v);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, 296.0f), com.opos.cmn.an.h.f.a.a(this.j, 44.0f));
        layoutParams7.addRule(3, relativeLayout4.getId());
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        layoutParams7.addRule(14);
        relativeLayout3.addView(this.i, layoutParams7);
        TextView textView4 = new TextView(this.j);
        textView4.setTextColor(-1);
        textView4.setTextSize(1, 18.0f);
        textView4.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView4.setSingleLine(true);
        com.opos.mobad.template.h.a(textView4);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        layoutParams8.addRule(3, wVar.getId());
        layoutParams8.addRule(14);
        textView4.setText("试玩已结束，前往继续体验");
        relativeLayout.addView(textView4, layoutParams8);
    }

    private void b(int i, int i2) {
        am amVarA = am.a(this.j);
        com.opos.mobad.template.cmn.aa aaVar = new com.opos.mobad.template.cmn.aa(this.j, new aa.a(amVarA.f9704a, amVarA.b, i, i / i2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(13);
        this.l.addView(aaVar, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.j);
        aaVar.addView(relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.j);
        wVar.setId(View.generateViewId());
        wVar.a(com.opos.cmn.an.h.f.a.a(this.j, 16.0f));
        relativeLayout.addView(wVar, new RelativeLayout.LayoutParams(i, com.opos.cmn.an.h.f.a.a(this.j, 266.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(this.j, 184.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.j);
        relativeLayout2.setId(View.generateViewId());
        wVar.addView(relativeLayout2, new RelativeLayout.LayoutParams(i, iA));
        ImageView imageView = new ImageView(this.j);
        this.o = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout2.addView(this.o, new RelativeLayout.LayoutParams(i, iA));
        int iA2 = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        int iA3 = com.opos.cmn.an.h.f.a.a(this.j, 82.0f);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.j);
        relativeLayout3.setId(View.generateViewId());
        relativeLayout3.setBackgroundColor(-1);
        relativeLayout3.setPadding(iA2, iA2, iA2, iA2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, iA3);
        layoutParams2.addRule(3, relativeLayout2.getId());
        wVar.addView(relativeLayout3, layoutParams2);
        int iA4 = com.opos.cmn.an.h.f.a.a(this.j, 50.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.j, com.opos.cmn.an.h.f.a.a(r6, 12.0f));
        this.q = nVar;
        nVar.setId(View.generateViewId());
        this.q.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout3.addView(this.q, new RelativeLayout.LayoutParams(iA4, iA4));
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.j);
        this.i = wVar2;
        wVar2.setId(View.generateViewId());
        TextView textView = new TextView(this.j);
        this.h = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.h);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.i.a(90.0f);
        this.i.addView(this.h, layoutParams3);
        this.i.setBackgroundColor(Color.argb(255, 0, 102, 255));
        com.opos.mobad.template.cmn.p.a(this.i, this.u);
        this.i.a(this.v);
        int iA5 = com.opos.cmn.an.h.f.a.a(this.j, 94.0f);
        int iA6 = com.opos.cmn.an.h.f.a.a(this.j, 8.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA5, com.opos.cmn.an.h.f.a.a(this.j, 28.0f));
        layoutParams4.setMarginStart(iA6);
        layoutParams4.addRule(15);
        layoutParams4.addRule(11);
        relativeLayout3.addView(this.i, layoutParams4);
        LinearLayout linearLayout = new LinearLayout(this.j);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.q.getId());
        layoutParams5.addRule(0, this.i.getId());
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        relativeLayout3.addView(linearLayout, layoutParams5);
        TextView textView2 = new TextView(this.j);
        this.b = textView2;
        textView2.setTextColor(Color.argb(229, 0, 0, 0));
        this.b.setTextSize(1, 16.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        com.opos.mobad.template.h.a(this.b);
        linearLayout.addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(this.j);
        this.c = textView3;
        textView3.setTextColor(Color.argb(138, 0, 0, 0));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 2.0f);
        linearLayout.addView(this.c, layoutParams6);
        TextView textView4 = new TextView(this.j);
        textView4.setTextColor(-1);
        textView4.setTextSize(1, 18.0f);
        textView4.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView4.setSingleLine(true);
        com.opos.mobad.template.h.a(textView4);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        layoutParams7.addRule(3, wVar.getId());
        textView4.setText("试玩已结束，前往继续体验");
        layoutParams7.addRule(14);
        relativeLayout.addView(textView4, layoutParams7);
    }

    private void c(int i, int i2) {
        am amVarA = am.a(this.j);
        com.opos.mobad.template.cmn.aa aaVar = new com.opos.mobad.template.cmn.aa(this.j, new aa.a(amVarA.f9704a, amVarA.b, i, i / i2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(13);
        this.l.addView(aaVar, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.j);
        aaVar.addView(relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.j);
        wVar.setId(View.generateViewId());
        wVar.a(com.opos.cmn.an.h.f.a.a(this.j, 16.0f));
        wVar.setBackgroundColor(-1);
        int iA = com.opos.cmn.an.h.f.a.a(this.j, 82.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, iA);
        wVar.setPadding(iA2, iA2, iA2, iA2);
        relativeLayout.addView(wVar, layoutParams2);
        int iA3 = com.opos.cmn.an.h.f.a.a(this.j, 50.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.j, com.opos.cmn.an.h.f.a.a(r6, 12.0f));
        this.q = nVar;
        nVar.setId(View.generateViewId());
        this.q.setScaleType(ImageView.ScaleType.FIT_XY);
        wVar.addView(this.q, new RelativeLayout.LayoutParams(iA3, iA3));
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.j);
        this.i = wVar2;
        wVar2.setId(View.generateViewId());
        TextView textView = new TextView(this.j);
        this.h = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.h);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.i.a(90.0f);
        this.i.addView(this.h, layoutParams3);
        this.i.setBackgroundColor(Color.argb(255, 0, 102, 255));
        com.opos.mobad.template.cmn.p.a(this.i, this.u);
        this.i.a(this.v);
        int iA4 = com.opos.cmn.an.h.f.a.a(this.j, 94.0f);
        int iA5 = com.opos.cmn.an.h.f.a.a(this.j, 8.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA4, com.opos.cmn.an.h.f.a.a(this.j, 28.0f));
        layoutParams4.setMarginStart(iA5);
        layoutParams4.addRule(15);
        layoutParams4.addRule(11);
        wVar.addView(this.i, layoutParams4);
        LinearLayout linearLayout = new LinearLayout(this.j);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.q.getId());
        layoutParams5.addRule(0, this.i.getId());
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        wVar.addView(linearLayout, layoutParams5);
        TextView textView2 = new TextView(this.j);
        this.b = textView2;
        textView2.setTextColor(Color.argb(229, 0, 0, 0));
        this.b.setTextSize(1, 16.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        com.opos.mobad.template.h.a(this.b);
        linearLayout.addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(this.j);
        this.c = textView3;
        textView3.setTextColor(Color.argb(138, 0, 0, 0));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 2.0f);
        linearLayout.addView(this.c, layoutParams6);
        TextView textView4 = new TextView(this.j);
        textView4.setTextColor(-1);
        textView4.setTextSize(1, 18.0f);
        textView4.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView4.setSingleLine(true);
        com.opos.mobad.template.h.a(textView4);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        layoutParams7.addRule(3, wVar.getId());
        textView4.setText("试玩已结束，前往继续体验");
        layoutParams7.addRule(14);
        relativeLayout.addView(textView4, layoutParams7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.t.3
            @Override // java.lang.Runnable
            public void run() {
                if (t.this.n() == 8) {
                    return;
                }
                if (t.this.q != null) {
                    t.this.q.setImageBitmap(bitmap);
                }
                if (t.this.t != null) {
                    t.this.t.setImageBitmap(com.opos.mobad.template.cmn.f.a(t.this.j, bitmap, 100, 1.0f, 60.0f));
                }
            }
        });
    }

    private void b(com.opos.mobad.template.d.d dVar) {
        com.opos.mobad.d.a aVar = this.g;
        if (aVar == null) {
            return;
        }
        com.opos.mobad.template.d.e eVar = dVar.O;
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, aVar, new j.a() { // from class: com.opos.mobad.template.h.t.1
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i, Bitmap bitmap) {
                if (i == 1) {
                    t.this.a(bitmap);
                }
                t.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                if (t.this.n() == 8) {
                    return;
                }
                t.this.a(bitmap);
            }
        }, this.w);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        a.InterfaceC0778a interfaceC0778a2 = this.e;
        if (interfaceC0778a2 != null) {
            com.opos.mobad.template.k.c cVar = this.s;
            if (cVar != null) {
                cVar.a(interfaceC0778a2);
            }
            s sVar = this.r;
            if (sVar != null) {
                sVar.a(this.e);
            }
        }
    }

    private void a(com.opos.mobad.template.d.d dVar) {
        List<com.opos.mobad.template.d.e> list = dVar.d;
        this.n = (list == null || list.size() <= 0 || TextUtils.isEmpty(dVar.d.get(0).f9414a)) ? false : true;
        int iA = com.opos.cmn.an.h.f.a.a(this.j, 328.0f);
        if (!this.n) {
            c(iA, com.opos.cmn.an.h.f.a.a(this.j, 120.0f));
            return;
        }
        if (this.p) {
            a(iA, com.opos.cmn.an.h.f.a.a(this.j, 360.0f));
        } else {
            b(iA, com.opos.cmn.an.h.f.a.a(this.j, 304.0f));
        }
        a(dVar.d.get(0), this.o);
    }

    private void a(com.opos.mobad.template.d.e eVar, final ImageView imageView) {
        String str = eVar.f9414a;
        if (str == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("RewardGameEndPage", "url is null");
        } else {
            com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.g, new j.a() { // from class: com.opos.mobad.template.h.t.2
                @Override // com.opos.mobad.template.cmn.j.a
                public void a(int i, Bitmap bitmap) {
                    if (i == 1) {
                        imageView.setImageBitmap(bitmap);
                    }
                    t.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.a
                public void a(Bitmap bitmap) {
                    if (t.this.n() == 8) {
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }
            }, this.w);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.d dVarC = fVar.c();
            if (dVarC == null) {
                com.opos.cmn.an.f.a.d("", "render with data null");
                a(1);
            }
            com.opos.mobad.template.d.e eVar = dVarC.k;
            if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
                com.opos.cmn.an.f.a.b("RewardGameEndPage", "render");
                if (this.m == null) {
                    a(dVarC);
                    this.l.setVisibility(0);
                }
                a(dVarC.S, dVarC.Q, dVarC.R);
                b(dVarC);
                com.opos.mobad.template.k.c cVar = this.s;
                if (cVar != null) {
                    cVar.a(dVarC.p, dVarC.q, dVarC.e, dVarC.g, dVarC.i);
                }
                this.m = dVarC;
                return;
            }
            str = "icon is null";
        }
        com.opos.cmn.an.f.a.b("RewardGameEndPage", str);
        a(1);
    }

    private void a(String str, String str2, String str3) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.c.setText(str3);
    }
}
