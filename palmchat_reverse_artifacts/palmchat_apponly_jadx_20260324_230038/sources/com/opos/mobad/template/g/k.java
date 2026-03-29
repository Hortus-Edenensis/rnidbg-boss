package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.g.ab;
import com.opos.mobad.template.g.ae;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k implements com.opos.mobad.template.a {
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private TextView h;
    private Context i;
    private a.InterfaceC0778a j;
    private int k;
    private ad l;
    private com.opos.mobad.template.cmn.w m;
    private RelativeLayout n;
    private s o;
    private ae p;
    private com.opos.mobad.template.cmn.aa q;
    private com.opos.mobad.d.a r;
    private com.opos.mobad.template.d.c t;
    private af u;
    private com.opos.mobad.template.e.c.a w;
    private com.opos.mobad.template.cmn.w y;
    private boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9787a = false;
    private int g = 64;
    private boolean v = false;
    private boolean x = false;
    private Runnable A = new Runnable() { // from class: com.opos.mobad.template.g.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f9787a) {
                return;
            }
            int iG = k.this.p.g();
            int iH = k.this.p.h();
            if (k.this.j != null) {
                k.this.j.d(iG, iH);
            }
            k.this.p.f();
            k.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    private k(Context context, am amVar, int i, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.i = context;
        this.k = i2;
        this.r = aVar2;
        this.b = i;
        f();
        a(amVar, aVar);
        k();
        j();
    }

    public static k a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new k(context, amVar, 2, i, aVar, aVar2);
    }

    private void g() {
        this.u = af.a(this.i, 15);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.u.setVisibility(4);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.y = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        this.y.setId(View.generateViewId());
        this.y.setBackgroundColor(Color.parseColor("#8A42464C"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 44.0f), com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        this.y.addView(this.u, layoutParams);
        this.y.setLayoutParams(layoutParams2);
        this.n.addView(this.y);
    }

    private void i() {
        s sVarA = s.a(this.i, 2, true, this.r, true);
        this.o = sVarA;
        sVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f, com.opos.cmn.an.h.f.a.a(this.i, 74.0f));
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.o.setVisibility(4);
        this.m.addView(this.o, layoutParams);
    }

    private void j() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.k.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (k.this.t == null) {
                    return;
                }
                if (z && !k.this.v) {
                    k.this.v = true;
                    if (k.this.j != null) {
                        k.this.j.a(com.opos.mobad.template.h.a(k.this.w));
                    }
                    if (k.this.w != null && k.this.w.c() != null) {
                        k.this.w.c().setVisibility(0);
                    }
                }
                if (k.this.z) {
                    if (z) {
                        k.this.p.d();
                    } else {
                        k.this.p.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.k.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (k.this.t == null || k.this.j == null) {
                    return;
                }
                Map<String, String> mapA = com.opos.mobad.template.h.a(k.this.w);
                mapA.put("isVisibleRect", String.valueOf(z));
                mapA.put("isAttached", String.valueOf(z2));
                k.this.j.a(mapA);
            }
        }, c());
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void k() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        ad adVar = this.l;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
        af afVar = this.u;
        if (afVar != null) {
            afVar.setVisibility(0);
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.q;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.k;
    }

    private void f() {
        this.c = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.i, 184.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.i, 258.0f);
        this.f = this.c;
        this.g = com.opos.cmn.an.h.f.a.a(this.i, 64.0f);
    }

    private void h() {
        TextView textView = new TextView(this.i);
        this.h = textView;
        textView.setTextColor(this.i.getResources().getColor(R.color.opos_mobad_description_color));
        this.h.setTextSize(1, 12.0f);
        this.h.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.h.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.h.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
        layoutParams.addRule(12);
        this.h.setVisibility(4);
        this.n.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.f9787a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "current state has stop mDestroy = " + this.f9787a);
            return;
        }
        this.p.a();
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "start countdown...");
        if (this.f9787a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "error state mDestroy " + this.f9787a);
            return;
        }
        this.p.b();
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "destroy");
        this.f9787a = true;
        this.p.c();
        this.t = null;
        this.s.removeCallbacks(this.A);
        com.opos.mobad.template.cmn.aa aaVar = this.q;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.j();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.n = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        b(aVar);
        h();
        g();
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        a(wVar);
        this.n.addView(wVar, layoutParams2);
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.p = ae.a(this.i, this.c, this.d, aVar);
        this.n.addView(this.p, new RelativeLayout.LayoutParams(this.c, this.d));
        this.p.a(new ae.a() { // from class: com.opos.mobad.template.g.k.6
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                k.this.s.removeCallbacks(k.this.A);
                k.this.s.postDelayed(k.this.A, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                k.this.s.removeCallbacks(k.this.A);
            }
        });
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        s sVar = this.o;
        if (sVar != null) {
            sVar.a(cVar, this.r, this.f9787a);
        }
        af afVar = this.u;
        if (afVar != null) {
            afVar.a(cVar.A);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        this.o.a(interfaceC0778a);
        this.p.a(interfaceC0778a);
        af afVar = this.u;
        if (afVar != null) {
            afVar.a(interfaceC0778a);
            this.u.a(new ab.a() { // from class: com.opos.mobad.template.g.k.3
                @Override // com.opos.mobad.template.g.ab.a
                public void a(int i) {
                    k.this.p.a(i);
                }
            });
        }
        ad adVar = this.l;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.l = ad.a(this.i, 8, this.r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.l.setId(View.generateViewId());
        this.l.setVisibility(4);
        wVar.addView(this.l, layoutParams);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.x) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.i, e(), bVar.L);
            this.w = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.k.2
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (k.this.j != null) {
                        k.this.j.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (k.this.j != null) {
                        k.this.j.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (k.this.j != null) {
                        k.this.j.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (k.this.j != null) {
                        k.this.j.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
            if (this.w.c() != null && this.n != null) {
                this.w.c().setId(View.generateViewId());
                this.n.addView(this.w.c(), layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                layoutParams2.removeRule(9);
                layoutParams2.removeRule(10);
                layoutParams2.addRule(1, this.w.c().getId());
                layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                this.y.setLayoutParams(layoutParams2);
            }
            this.x = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        b(cVar);
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(cVar.f9413a);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.j;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.t == null) {
            this.p.a(cVarB);
        }
        if (this.t == null && (interfaceC0778a = this.j) != null) {
            interfaceC0778a.f();
        }
        this.t = cVarB;
        this.z = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.q;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.q.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.m;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        a(cVarB);
        a((com.opos.mobad.template.d.b) cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.i);
        }
        Context context = this.i;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.c;
        this.q = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.e));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.c, this.e);
        layoutParams.width = this.c;
        layoutParams.height = this.e;
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.i.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.q.addView(this.m, layoutParams);
        this.q.setLayoutParams(layoutParams);
        a(aVar);
        i();
        com.opos.mobad.template.cmn.p.a(this.m, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.k.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (k.this.j != null) {
                    k.this.j.h(view, iArr);
                }
            }
        });
        this.m.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.k.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo1", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (k.this.j != null) {
                    k.this.j.a(view, i4, z);
                }
            }
        });
    }
}
