package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ad extends ae {
    public ad(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z) {
        super(context, aVar, aVar2, z);
    }

    @Override // com.opos.mobad.template.h.ae, com.opos.mobad.template.h.a
    public a a(com.opos.mobad.template.cmn.p pVar) {
        this.y = pVar;
        return this;
    }

    @Override // com.opos.mobad.template.h.ae
    public void b() {
        super.b();
        this.f.setBackgroundColor(Color.parseColor("#00000000"));
        this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(((ae) this).f9939a, 44.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(((ae) this).f9939a, 24.0f);
        LinearLayout.LayoutParams layoutParams = this.l;
        layoutParams.leftMargin = iA;
        LinearLayout.LayoutParams layoutParams2 = this.o;
        layoutParams2.rightMargin = iA;
        layoutParams.bottomMargin = 0;
        layoutParams2.bottomMargin = 0;
        this.m.setLayoutParams(layoutParams);
        this.n.setLayoutParams(this.o);
        if (this.v != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(((ae) this).f9939a, 82.0f), com.opos.cmn.an.h.f.a.a(((ae) this).f9939a, 60.0f));
            layoutParams3.addRule(11);
            this.v.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.opos.mobad.template.h.ae
    public void c() {
        if (this.x) {
            return;
        }
        this.p = this.s ? new i(((ae) this).f9939a, this.b) : new h(((ae) this).f9939a, this.b);
        this.q.addView(this.p);
        this.x = true;
    }

    @Override // com.opos.mobad.template.h.ae
    public void d() {
        w wVarB = w.b(((ae) this).f9939a);
        this.t = wVarB;
        addView(wVarB);
    }

    @Override // com.opos.mobad.template.h.ae
    public void e() {
        com.opos.mobad.template.cmn.m.a(((ae) this).f9939a, this, false);
    }

    public ad(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z, int i) {
        super(context, aVar, aVar2, z, i);
    }
}
