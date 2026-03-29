package com.opos.mobad.video.player.h.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.template.a;
import com.opos.mobad.template.d.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends a {
    public b(Context context, int i, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar) {
        super(context, i, interfaceC0778a, aVar);
    }

    private void a(LinearLayout linearLayout) {
        com.opos.cmn.module.ui.a.c cVar = new com.opos.cmn.module.ui.a.c(this.f10366a, 33.0f);
        this.f = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 50.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 13.0f);
        linearLayout.addView(this.f, layoutParams);
    }

    private void b(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f10366a);
        this.g = textView;
        textView.setGravity(17);
        this.g.setTextColor(Color.parseColor("#000000"));
        this.g.setTextSize(1, 15.0f);
        this.g.setTypeface(Typeface.defaultFromStyle(1));
        this.g.setMaxEms(9);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        this.g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 5.0f);
        linearLayout.addView(this.g, layoutParams);
    }

    @Override // com.opos.mobad.video.player.h.a.a, com.opos.mobad.template.a
    public void d() {
        try {
            super.d();
            a(this.g, "");
            a(this.h, "");
            a((View) this.d);
            a((View) this.e);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GraphicMixFloatLayer", "destroy() fail", e);
        }
    }

    @Override // com.opos.mobad.video.player.h.a.a
    public void g() {
        h.a(this.i, new ColorDrawable(Color.parseColor("#cfffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f10366a), com.opos.cmn.an.h.f.a.c(this.f10366a) / 3);
        layoutParams.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f10366a);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 144.0f), -2);
        layoutParams2.addRule(13);
        a(linearLayout);
        b(linearLayout);
        c(linearLayout);
        d(linearLayout);
        this.i.addView(linearLayout, layoutParams2);
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.addView(this.i, layoutParams);
        }
    }

    @Override // com.opos.mobad.video.player.h.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        boolean zD = com.opos.cmn.an.h.f.a.d(this.f10366a);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, zD ? 54 : 11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, zD ? 24 : 11);
        return layoutParams;
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.b;
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f10366a);
        this.h = textView;
        textView.setGravity(17);
        this.h.setTextColor(Color.parseColor("#000000"));
        this.h.setTextSize(1, 13.0f);
        this.h.setMaxEms(13);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setSingleLine();
        this.h.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 52.0f);
        linearLayout.addView(this.h, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        TextView textView = new TextView(this.f10366a);
        this.d = textView;
        textView.setGravity(17);
        this.d.setTextColor(Color.parseColor("#ffffff"));
        this.d.setTextSize(1, 15.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f10366a, 22.0f));
        h.a(this.d, gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 120.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 30.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 3.0f);
        linearLayout.addView(this.d, layoutParams);
        this.n = new e(this.d, 1.0f, 1.2f, com.igexin.push.config.c.j);
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.mobad.template.d.e eVar;
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            return;
        }
        h();
        j();
        if (this.s == null && (eVar = dVarC.O) != null && !TextUtils.isEmpty(eVar.f9414a)) {
            com.opos.mobad.template.d.e eVar2 = dVarC.O;
            com.opos.mobad.ui.c.e.a(eVar2.f9414a, eVar2.b, com.opos.cmn.an.h.f.a.a(this.f10366a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 50.0f), this.t, this.f, this.l, this.w);
        }
        if (this.g != null && !TextUtils.isEmpty(dVarC.Q)) {
            a(this.g, dVarC.Q);
            this.g.setVisibility(0);
        }
        if (this.h != null && !TextUtils.isEmpty(dVarC.R)) {
            a(this.h, dVarC.R);
            this.h.setVisibility(0);
        }
        a(dVarC.S);
        a(this.d, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
        a(this.b, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
        this.s = dVarC;
    }
}
