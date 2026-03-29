package com.opos.mobad.video.player.h.a;

import android.content.Context;
import android.graphics.Color;
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
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends a {
    private LinearLayout x;

    public d(Context context, int i, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar) {
        super(context, i, interfaceC0778a, aVar);
    }

    private void a(LinearLayout linearLayout) {
        if (this.s != null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 68.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 68.0f));
        layoutParams.gravity = 1;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 32.0f);
        linearLayout.addView(this.f, layoutParams);
    }

    private void b(LinearLayout linearLayout, com.opos.mobad.template.d.d dVar, boolean z) {
        if (this.s == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 8);
            linearLayout.addView(this.h, layoutParams);
        }
        a(this.h, dVar.R);
        this.h.setVisibility(0);
    }

    @Override // com.opos.mobad.video.player.h.a.a, com.opos.mobad.template.a
    public void d() {
        try {
            super.d();
            a(this.g, "");
            a(this.h, "");
            a((View) this.d);
            a((View) this.e);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("PortModelAFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.video.player.h.a.a
    public void g() {
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.setClipChildren(false);
            this.b.setBackgroundColor(Color.parseColor("#66000000"));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#8A42464C"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f10366a, 24.0f));
        h.a(this.i, gradientDrawable);
        this.i.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 328.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 254.0f));
        layoutParams.addRule(13);
        a(this.i);
        b(this.i);
        RelativeLayout relativeLayout2 = this.b;
        if (relativeLayout2 != null) {
            relativeLayout2.addView(this.i, layoutParams);
        }
        TextView textView = new TextView(this.f10366a);
        this.g = textView;
        textView.setGravity(17);
        this.g.setTextColor(-1);
        this.g.setTextSize(1, 16.0f);
        this.g.setMaxEms(9);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        this.g.setVisibility(8);
        a(this.g);
        TextView textView2 = new TextView(this.f10366a);
        this.h = textView2;
        textView2.setGravity(17);
        this.h.setTextColor(Color.parseColor("#66FFFFFF"));
        this.h.setTextSize(1, 14.0f);
        this.h.setMaxEms(13);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setVisibility(8);
        this.h.setSingleLine();
        com.opos.cmn.module.ui.a.c cVar = new com.opos.cmn.module.ui.a.c(this.f10366a, 28.0f);
        this.f = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.opos.mobad.video.player.h.a.a
    public void h() {
        super.h();
        h.a(this.e, com.opos.cmn.an.e.a.a.c(this.f10366a, "opos_module_biz_ui_reward_video_float_layer_close_bn_new.png"));
    }

    @Override // com.opos.mobad.video.player.h.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 44.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 28.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 32.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 24.0f);
        return layoutParams;
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.b;
    }

    private void a(LinearLayout linearLayout, com.opos.mobad.template.d.d dVar, boolean z) {
        if (this.s == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, z ? 12 : 68);
            linearLayout.addView(this.g, layoutParams);
        }
        a(this.g, dVar.Q);
        this.g.setVisibility(0);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f10366a);
        this.d = textView;
        textView.setGravity(17);
        this.d.setTextColor(Color.parseColor("#ffffff"));
        this.d.setTextSize(1, 16.0f);
        a(this.d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#0066FF"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f10366a, 22.0f));
        h.a(this.d, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 220.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 44.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 24.0f);
        relativeLayout.addView(this.d, layoutParams);
        this.n = new e(this.d, 1.0f, 1.05f, com.igexin.push.config.c.j);
    }

    private void c(com.opos.mobad.template.d.d dVar) {
        List<com.opos.mobad.template.d.e> list;
        if (this.s == null && (list = dVar.d) != null && list.size() > 0 && dVar.d.get(0) != null) {
            com.opos.mobad.template.d.e eVar = dVar.d.get(0);
            if (TextUtils.isEmpty(eVar.f9414a)) {
                return;
            }
            com.opos.mobad.ui.c.e.a(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.b(this.f10366a), com.opos.cmn.an.h.f.a.c(this.f10366a), this.t, this.b, this.l, this.w);
        }
    }

    private boolean d(com.opos.mobad.template.d.d dVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.s != null || dVar == null || (eVar = dVar.O) == null || TextUtils.isEmpty(eVar.f9414a)) {
            return false;
        }
        com.opos.mobad.template.d.e eVar2 = dVar.O;
        com.opos.mobad.ui.c.e.a(eVar2.f9414a, eVar2.b, com.opos.cmn.an.h.f.a.a(this.f10366a, 68.0f), com.opos.cmn.an.h.f.a.a(this.f10366a, 68.0f), this.t, this.f, this.l, this.w);
        return true;
    }

    private void a(RelativeLayout relativeLayout) {
        LinearLayout linearLayout = new LinearLayout(this.f10366a);
        this.x = linearLayout;
        linearLayout.setClipChildren(false);
        this.x.setOrientation(1);
        relativeLayout.addView(this.x, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(com.opos.mobad.template.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 36);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 24);
        this.k = com.opos.mobad.template.k.c.a(dVar, this.b, layoutParams, this.t, this.l);
    }

    public void a(com.opos.mobad.template.d.d dVar) {
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.f10366a);
        this.j = cVar;
        cVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10366a, 220.0f), -2);
        layoutParams.addRule(12);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 66);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f10366a, 36);
        com.opos.mobad.template.d.a aVar = dVar.u;
        com.opos.mobad.template.a.c cVar2 = this.j;
        if (cVar2 == null || aVar == null) {
            return;
        }
        cVar2.a(aVar.f9412a, aVar.b);
        this.j.setVisibility(0);
        this.j.a(this.l);
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.addView(this.j, layoutParams);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            return;
        }
        h();
        j();
        c(dVarC);
        a(dVarC);
        b(dVarC);
        boolean zD = d(dVarC);
        if (zD) {
            a(this.x);
        }
        a(this.x, dVarC, zD);
        b(this.x, dVarC, zD);
        a(dVarC.S);
        a(this.d, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
        a(this.b, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
        this.s = dVarC;
    }
}
