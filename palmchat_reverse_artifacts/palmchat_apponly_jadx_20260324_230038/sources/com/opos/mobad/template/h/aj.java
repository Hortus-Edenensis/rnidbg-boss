package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.a;
import com.opos.mobad.template.h.ai;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class aj extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.cmn.baseview.c f9977a;
    private ai b;
    private com.opos.mobad.template.h.a.c c;
    private Context g;
    private View h;
    private View i;
    private LinearLayout j;
    private TextView k;
    private ImageView l;
    private boolean m;
    private boolean n;
    private int o;
    private com.opos.mobad.d.d.a p;
    private com.opos.mobad.template.d.c q;
    private boolean r;
    private a s;
    private com.opos.mobad.d.a t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ai.a {
    }

    private void p() {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 50.0f);
            context = this.g;
            f = 16.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 20.0f);
            context = this.g;
            f = 34.0f;
        }
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, f);
    }

    private void q() {
        ImageView imageView;
        int i;
        if (this.m) {
            imageView = this.l;
            i = 0;
        } else {
            imageView = this.l;
            i = 8;
        }
        imageView.setVisibility(i);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f9977a;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.d.d.a aVar = this.p;
        if (aVar == null) {
            return false;
        }
        aVar.g();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.d.d.a aVar = this.p;
        if (aVar == null) {
            return false;
        }
        aVar.f();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.f9977a.removeAllViews();
        final com.opos.mobad.d.d.a aVar = this.p;
        if (aVar != null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.template.h.aj.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.d.d.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.f();
                        aVar.h();
                    }
                }
            });
        }
    }

    public void i() {
        p();
        c(this.j);
    }

    private RelativeLayout.LayoutParams a(com.opos.mobad.template.d.b bVar) {
        boolean zD = com.opos.cmn.an.h.f.a.d(this.g);
        boolean zA = com.opos.mobad.template.h.a.a.a(bVar);
        if (zD) {
            if (zA) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 85.0f));
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                return layoutParams;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 92.0f), com.opos.cmn.an.h.f.a.a(this.g, 30.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 13.0f);
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 13.0f);
            return layoutParams2;
        }
        if (zA) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 85.0f));
            layoutParams3.addRule(12);
            layoutParams3.addRule(14);
            return layoutParams3;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 92.0f), com.opos.cmn.an.h.f.a.a(this.g, 30.0f));
        layoutParams4.addRule(12);
        layoutParams4.addRule(11);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 17.0f);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 15.0f);
        return layoutParams4;
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        this.c.a(bVar);
        View view = this.h;
        if (view == null || this.f9977a.indexOfChild(view) >= 0) {
            return;
        }
        this.f9977a.addView(this.h, a(bVar));
    }

    private void c(View view) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 110.0f);
            context = this.g;
            f = 15.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 61.0f);
            context = this.g;
            f = 31.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
    }

    private void a(int i, String str) {
        this.o = i;
        this.b.a(i, this.n, str);
    }

    private void b(boolean z) {
        this.r = z;
        this.p.a(z ? 1.0f : 0.0f);
        this.b.a(z);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.b.a(this.s);
        this.c.a(interfaceC0778a);
    }

    public void a(final com.opos.mobad.template.d.b bVar, com.opos.mobad.d.a aVar, a.InterfaceC0778a interfaceC0778a) {
        String str;
        if (bVar == null) {
            return;
        }
        com.opos.mobad.template.d.e eVar = bVar.f;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            if (TextUtils.isEmpty(bVar.i)) {
                return;
            }
            this.k.setText(bVar.i);
            return;
        }
        com.opos.mobad.template.d.c cVar = this.q;
        if (cVar != null && (str = cVar.f.f9414a) != null && !TextUtils.isEmpty(str) && this.q.f.f9414a.equals(bVar.f.f9414a)) {
            com.opos.cmn.an.f.a.b("VideoTemplate", "logo not change, not need to reload");
        } else {
            com.opos.mobad.template.d.e eVar2 = bVar.f;
            com.opos.mobad.template.h.a(interfaceC0778a, eVar2.f9414a, aVar, eVar2.b, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.h.aj.1
                @Override // com.opos.mobad.template.b
                public void a(Bitmap bitmap) {
                    BitmapDrawable bitmapDrawableA = bitmap != null ? com.opos.mobad.template.h.a(aj.this.g, bitmap) : null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("getLogoDrawable=");
                    sb.append(bitmapDrawableA != null ? bitmapDrawableA : com.igexin.push.core.b.m);
                    com.opos.cmn.an.f.a.b("VideoTemplate", sb.toString());
                    if (bitmapDrawableA != null) {
                        com.opos.mobad.template.h.a(aj.this.k, bitmapDrawableA);
                    } else {
                        if (TextUtils.isEmpty(bVar.i)) {
                            return;
                        }
                        aj.this.k.setText(bVar.i);
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("VideoTemplate", "data is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("VideoTemplate", "render with data null");
            a(1);
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.q == null) {
            this.p.a(cVarB.N.f9414a, false);
        }
        a(cVarB, this.t, this.e);
        this.q = cVarB;
        b(cVarB.A == 1);
        a(cVarB.B, cVarB.q);
        a(cVarB.p);
        b(cVarB);
    }

    public void a(boolean z) {
        this.m = z;
        q();
    }
}
