package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.cmn.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j extends com.opos.mobad.template.j.c {
    private int A;
    private ViewTreeObserver.OnPreDrawListener B;
    private j.b C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9778a;
    private int b;
    private int c;
    private Context g;
    private int h;
    private com.opos.mobad.template.d.b i;
    private com.opos.mobad.template.cmn.w j;
    private com.opos.mobad.template.cmn.n k;
    private com.opos.mobad.template.cmn.w l;
    private com.opos.mobad.template.cmn.w m;
    private aj n;
    private com.opos.mobad.template.cmn.aa o;
    private com.opos.mobad.template.k.c p;
    private RelativeLayout q;
    private RelativeLayout r;
    private v s;
    private LinearLayout t;
    private TextView u;
    private com.opos.mobad.d.a v;
    private com.opos.mobad.template.cmn.w w;
    private Animator x;
    private ad y;
    private int z;

    private j(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        super(i);
        this.f9778a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
        this.b = 89;
        this.z = 0;
        this.A = 0;
        this.C = new j.b() { // from class: com.opos.mobad.template.g.j.6
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return j.this.n() == 8;
            }
        };
        this.g = context;
        this.h = i2;
        this.v = aVar;
        p();
        a(amVar);
    }

    private void p() {
        int i = this.h;
        if (i == 0 || i == 1) {
            this.f9778a = com.opos.cmn.an.h.f.a.a(this.g, 328.0f);
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 89.0f);
        }
        this.c = this.b + com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
    }

    private void q() {
        a((View) this.m);
        a((com.opos.mobad.template.cmn.baseview.e) this.m);
        b(this.s);
        a((com.opos.mobad.template.cmn.baseview.e) this.s);
    }

    private void r() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f9778a, this.b);
        layoutParams.addRule(15);
        this.l.addView(this.m, layoutParams);
        y();
    }

    private void s() {
        this.y = ad.a(this.g, 10, this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.y.setId(View.generateViewId());
        this.m.addView(this.y, layoutParams);
    }

    private void t() {
        this.q = new RelativeLayout(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.j.getId());
        layoutParams.addRule(2, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        this.m.addView(this.q, layoutParams);
        v();
    }

    private void u() {
        this.r = new RelativeLayout(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(1, this.q.getId());
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        x();
        this.m.addView(this.r, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() {
        int iA;
        Context context;
        float f;
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.t = linearLayout;
        linearLayout.setOrientation(0);
        int i = this.h;
        if (i == 0) {
            context = this.g;
            f = 107.0f;
        } else {
            if (i != 1) {
                iA = -1;
                this.A = iA;
                this.q.addView(this.t, new RelativeLayout.LayoutParams(iA, -1));
                TextView textView = new TextView(this.g);
                this.u = textView;
                textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
                this.u.setTextSize(1, 14.0f);
                this.u.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.u.setSingleLine(true);
                TextPaint paint = this.u.getPaint();
                paint.setStrokeWidth(1.0f);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                this.t.addView(this.u, layoutParams);
                w();
                if (this.B != null) {
                    this.B = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.g.j.1
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            if (j.this.n() != 8 && j.this.t != null && j.this.u != null && j.this.p != null && j.this.A != 0) {
                                try {
                                    if (j.this.t.getWidth() <= j.this.u.getWidth() + j.this.p.getWidth() + ((int) ((j.this.t.getWidth() / j.this.A) * j.this.z))) {
                                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) j.this.u.getLayoutParams();
                                        layoutParams2.weight = 1.0f;
                                        if (j.this.u.getParent() != null && j.this.u.getParent() == j.this.t) {
                                            j.this.t.updateViewLayout(j.this.u, layoutParams2);
                                            if (j.this.t != null && j.this.B != null && j.this.t.getViewTreeObserver().isAlive()) {
                                                j.this.t.getViewTreeObserver().removeOnPreDrawListener(j.this.B);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.d("BlockBigImage8", "preDrawListener->Exception:" + e);
                                }
                            }
                            return true;
                        }
                    };
                    LinearLayout linearLayout2 = this.t;
                    if (linearLayout2 == null || !linearLayout2.getViewTreeObserver().isAlive()) {
                        return;
                    }
                    this.t.getViewTreeObserver().addOnPreDrawListener(this.B);
                    return;
                }
                return;
            }
            context = this.g;
            f = 121.0f;
        }
        iA = com.opos.cmn.an.h.f.a.a(context, f);
        this.A = iA;
        this.q.addView(this.t, new RelativeLayout.LayoutParams(iA, -1));
        TextView textView2 = new TextView(this.g);
        this.u = textView2;
        textView2.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
        this.u.setTextSize(1, 14.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.u.setSingleLine(true);
        TextPaint paint2 = this.u.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.t.addView(this.u, layoutParams2);
        w();
        if (this.B != null) {
        }
    }

    private void w() {
        this.z = com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = this.z;
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.g, 1, 0, this.v);
        this.p = cVarA;
        this.t.addView(cVarA, layoutParams);
        if (this.h == 0) {
            this.p.a(5);
        }
    }

    private void x() {
        v vVarB = v.b(this.g, "");
        this.s = vVarB;
        vVarB.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 28.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        if (this.h != 0) {
            this.r.addView(this.s, layoutParams);
            return;
        }
        this.w = new com.opos.mobad.template.cmn.w(this.g);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 28.0f));
        layoutParams2.addRule(5, this.s.getId());
        layoutParams2.addRule(7, this.s.getId());
        layoutParams2.addRule(6, this.s.getId());
        layoutParams2.addRule(8, this.s.getId());
        layoutParams2.addRule(13);
        this.w.setId(View.generateViewId());
        this.w.a(com.opos.cmn.an.h.f.a.a(this.g, 36.0f));
        Animator animatorB = com.opos.mobad.template.cmn.ae.b((RelativeLayout) this.w);
        this.x = animatorB;
        animatorB.start();
        this.w.setVisibility(4);
        this.r.addView(this.s, layoutParams);
        this.r.addView(this.w, layoutParams2);
    }

    private void y() {
        RelativeLayout.LayoutParams layoutParams;
        com.opos.mobad.template.cmn.n nVar;
        com.opos.mobad.template.cmn.w wVar;
        RelativeLayout.LayoutParams layoutParams2;
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.g);
        this.j = wVar2;
        wVar2.setId(View.generateViewId());
        if (this.h == 1) {
            this.j.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 87.0f), com.opos.cmn.an.h.f.a.a(this.g, 57.0f));
            layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 8.0f), 0);
            nVar = new com.opos.mobad.template.cmn.n(this.g, com.opos.cmn.an.h.f.a.a(r2, 10.0f));
            this.k = nVar;
            wVar = this.j;
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            this.j.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 101.0f), com.opos.cmn.an.h.f.a.a(this.g, 57.0f));
            layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 8.0f), 0);
            nVar = new com.opos.mobad.template.cmn.n(this.g, com.opos.cmn.an.h.f.a.a(r2, 10.0f));
            this.k = nVar;
            wVar = this.j;
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        }
        wVar.addView(nVar, layoutParams2);
        layoutParams.addRule(15);
        com.opos.cmn.an.f.a.b("BlockBigImage8", "imgType " + this.h);
        this.m.addView(this.j, layoutParams);
    }

    private void z() {
        aj ajVarA = aj.a(this.g, this.h);
        this.n = ajVarA;
        ajVarA.a(new al() { // from class: com.opos.mobad.template.g.j.2
            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                j.this.m(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                j.this.l(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
                j.this.n(view, iArr);
            }
        });
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(1, this.j.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("BlockBigImage8", "doEnd");
        this.i = null;
        com.opos.mobad.template.cmn.aa aaVar = this.o;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    public static j a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new j(context, amVar, i, 0, aVar);
    }

    public static j b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new j(context, amVar, i, 1, aVar);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        aj ajVar = this.n;
        if (ajVar != null) {
            ajVar.setVisibility(0);
            this.n.a(aVar.f9412a, aVar.b);
        }
        com.opos.mobad.template.cmn.w wVar = this.w;
        if (wVar != null) {
            wVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void b() {
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || this.k == null) {
            return;
        }
        String str = bVar.c.get(0).f9414a;
        String str2 = bVar.c.get(0).b;
        int i = this.f9778a;
        int i2 = this.b;
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.j.a(str, str2, i, i2, this.v, new j.a() { // from class: com.opos.mobad.template.g.j.5
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i3, Bitmap bitmap) {
                if (i3 == 1) {
                    j.this.k.setImageBitmap(bitmap);
                }
                j.this.b(i3);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                if (j.this.n() == 8) {
                    return;
                }
                j.this.k.setImageBitmap(bitmap);
            }
        }, this.C);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.j.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.n() == 8) {
                                return;
                            }
                            j.this.a((Map<String, String>) null);
                        }
                    });
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.j.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.n() == 8) {
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("isVisibleRect", String.valueOf(z));
                        map.put("isAttached", String.valueOf(z2));
                        j.this.b(map);
                    }
                });
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.p.a(i());
        ad adVar = this.y;
        if (adVar != null) {
            adVar.a(i());
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        b(bVar);
        c(bVar);
        this.p.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
        this.s.a(bVar.j);
        if (TextUtils.isEmpty(bVar.b)) {
            return;
        }
        this.u.setText(bVar.b);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA != null) {
                com.opos.cmn.an.f.a.b("BlockBigImage8", "render");
                if (this.i == null) {
                    m();
                    a((ViewGroup) this.l);
                }
                this.i = bVarA;
                com.opos.mobad.template.cmn.aa aaVar = this.o;
                if (aaVar != null && aaVar.getVisibility() != 0) {
                    this.o.setVisibility(0);
                }
                com.opos.mobad.template.cmn.w wVar = this.l;
                if (wVar != null && wVar.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
                a(bVarA);
                return;
            }
            str = "adShowData is null";
        }
        com.opos.cmn.an.f.a.b("BlockBigImage8", str);
        a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.g);
        }
        Context context = this.g;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.f9778a;
        this.o = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.c));
        this.l = new com.opos.mobad.template.cmn.w(this.g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f9778a, -2);
        layoutParams.width = this.f9778a;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f9778a, -2);
        layoutParams2.addRule(13);
        this.o.addView(this.l, layoutParams2);
        this.o.setLayoutParams(layoutParams);
        r();
        z();
        t();
        u();
        s();
        q();
    }
}
