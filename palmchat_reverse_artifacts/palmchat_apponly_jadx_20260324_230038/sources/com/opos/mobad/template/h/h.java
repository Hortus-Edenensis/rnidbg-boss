package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends d {
    private com.opos.mobad.d.a f;
    private Context g;
    private com.opos.mobad.template.cmn.w h;
    private LinearLayout i;
    private com.opos.mobad.template.a.c j;
    private com.opos.mobad.template.cmn.y l;
    private LinearLayout m;
    private TextView n;
    private com.opos.mobad.template.k.c o;
    private TextView p;
    private com.opos.mobad.template.cmn.w q;
    private TextView r;

    public h(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = context.getApplicationContext();
        this.f = aVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 254.0f), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 30.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        setLayoutParams(layoutParams);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.h = wVar;
        wVar.setId(View.generateViewId());
        this.h.a(com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        this.h.setBackgroundColor(getResources().getColor(R.color.opos_mobad_white_color));
        this.h.setPadding(com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        addView(this.h, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.i = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.i.setOrientation(0);
        this.i.setGravity(16);
        this.h.addView(this.i, new RelativeLayout.LayoutParams(-1, -2));
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(this.g, 12.0f));
        this.l = nVar;
        nVar.setId(View.generateViewId());
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(context, 52.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(15);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.g);
        wVar2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar2.addView(this.l, layoutParams2);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.g, 12.0f));
        this.i.addView(wVar2);
        LinearLayout linearLayout2 = new LinearLayout(this.g);
        this.m = linearLayout2;
        linearLayout2.setGravity(16);
        this.m.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        this.i.addView(this.m, layoutParams3);
        LinearLayout linearLayout3 = new LinearLayout(this.g);
        linearLayout3.setGravity(16);
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        this.m.addView(linearLayout3, layoutParams4);
        TextView textView = new TextView(this.g);
        this.n = textView;
        com.opos.mobad.template.h.a(textView);
        this.n.setTextSize(1, 14.0f);
        this.n.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.n.setLines(1);
        this.n.setSingleLine(true);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout3.addView(this.n);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 1, 0, this.f);
        this.o = cVarA;
        linearLayout3.addView(cVarA, layoutParams5);
        this.p = new TextView(this.g);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 2.0f);
        this.p.setTextSize(1, 12.0f);
        this.p.setMaxLines(2);
        this.p.setGravity(16);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextColor(getResources().getColor(R.color.opos_mobad_retain_des_color));
        this.m.addView(this.p, layoutParams6);
        com.opos.mobad.template.cmn.w wVar3 = new com.opos.mobad.template.cmn.w(this.g);
        this.q = wVar3;
        wVar3.setBackgroundColor(getResources().getColor(R.color.opos_mobad_install_button_color));
        this.q.a(90.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 44.0f));
        layoutParams7.addRule(3, this.i.getId());
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        this.h.addView(this.q, layoutParams7);
        TextView textView2 = new TextView(this.g);
        this.r = textView2;
        textView2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.r.setTextColor(-1);
        this.r.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.r);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        this.q.addView(this.r, layoutParams8);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.g);
        this.j = cVar;
        cVar.setGravity(3);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.addRule(3, this.h.getId());
        layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        addView(this.j, layoutParams9);
    }

    @Override // com.opos.mobad.template.h.d
    public void a() {
    }

    @Override // com.opos.mobad.template.h.d
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.l.setVisibility(0);
            this.l.setImageBitmap(bitmap);
            return;
        }
        this.l.setVisibility(8);
        LinearLayout linearLayout = this.m;
        if (linearLayout == null || this.i == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.i.updateViewLayout(this.m, layoutParams);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.o.a(interfaceC0778a);
        this.j.a(interfaceC0778a);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.cmn.q qVar) {
        com.opos.mobad.template.cmn.w wVar;
        if (qVar == null || (wVar = this.q) == null) {
            return;
        }
        com.opos.mobad.template.cmn.p.a(wVar, qVar);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            this.n.setText(bVar.b);
            this.p.setText(bVar.f9413a);
            this.r.setText(bVar.j);
            this.o.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
            com.opos.mobad.template.d.a aVar = bVar.u;
            if (aVar != null) {
                this.j.a(aVar.f9412a, aVar.b);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void b() {
    }

    @Override // com.opos.mobad.template.h.d
    public void c() {
    }
}
