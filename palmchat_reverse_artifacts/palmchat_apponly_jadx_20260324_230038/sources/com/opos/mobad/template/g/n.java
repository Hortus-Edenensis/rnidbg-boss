package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
public class n implements com.opos.mobad.template.a {
    private boolean A;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private TextView h;
    private com.opos.mobad.template.e.c.a i;
    private Context k;
    private a.InterfaceC0778a l;
    private int m;
    private ad n;
    private com.opos.mobad.template.cmn.w o;
    private RelativeLayout p;
    private t q;
    private RelativeLayout r;
    private ae s;
    private com.opos.mobad.template.cmn.aa t;
    private com.opos.mobad.d.a u;
    private com.opos.mobad.template.d.c w;
    private af x;
    private com.opos.mobad.template.cmn.w y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9814a = false;
    private int g = 58;
    private boolean j = false;
    private boolean z = false;
    private Runnable B = new Runnable() { // from class: com.opos.mobad.template.g.n.1
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f9814a) {
                return;
            }
            int iG = n.this.s.g();
            int iH = n.this.s.h();
            if (n.this.l != null) {
                n.this.l.d(iG, iH);
            }
            n.this.s.f();
            n.this.v.postDelayed(this, 500L);
        }
    };
    private Handler v = new Handler(Looper.getMainLooper());

    private n(Context context, am amVar, int i, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.k = context;
        this.m = i2;
        this.u = aVar2;
        this.b = i;
        f();
        a(amVar, aVar);
    }

    public static n a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new n(context, amVar, 0, i, aVar, aVar2);
    }

    private void g() {
        this.x = af.a(this.k, 15);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.k);
        this.y = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.k, 14.0f));
        this.y.setId(View.generateViewId());
        this.y.setBackgroundColor(Color.parseColor("#8A42464C"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 44.0f), com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
        this.y.addView(this.x, layoutParams);
        this.y.setLayoutParams(layoutParams2);
        this.p.addView(this.y);
    }

    private void i() {
        this.r = new RelativeLayout(this.k);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1291845632});
        gradientDrawable.setShape(0);
        this.r.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.g);
        layoutParams.addRule(12);
        this.p.addView(this.r, layoutParams);
    }

    private void j() {
        t tVarA = t.a(this.k, this.u);
        this.q = tVarA;
        tVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f, com.opos.cmn.an.h.f.a.a(this.k, 130.0f));
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.o.addView(this.q, layoutParams);
    }

    private void k() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.k);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.n.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (n.this.w == null) {
                    return;
                }
                if (z && !n.this.z) {
                    n.this.z = true;
                    if (n.this.l != null) {
                        n.this.l.a(com.opos.mobad.template.h.a(n.this.i));
                    }
                    if (n.this.i != null && n.this.i.c() != null) {
                        n.this.i.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "BlockBigImageVideo14 onWindowVisibilityChanged：" + z);
                if (n.this.A) {
                    if (z) {
                        n.this.s.d();
                    } else {
                        n.this.s.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.n.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (n.this.w == null) {
                    return;
                }
                if (n.this.l != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(n.this.i);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    n.this.l.a(mapA);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "BlockBigImageVideo14 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.o.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.m;
    }

    public static n b(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new n(context, amVar, 1, i, aVar, aVar2);
    }

    private void f() {
        this.c = com.opos.cmn.an.h.f.a.a(this.k, 328.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.k, 184.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.k, 314.0f);
        this.f = this.c;
        this.g = com.opos.cmn.an.h.f.a.a(this.k, 58.0f);
    }

    private void h() {
        TextView textView = new TextView(this.k);
        this.h = textView;
        textView.setTextColor(this.k.getResources().getColor(R.color.opos_mobad_description_color));
        this.h.setTextSize(1, 12.0f);
        this.h.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.h.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.h.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.k, 8.0f);
        layoutParams.addRule(12);
        this.p.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.f9814a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "current state has stop mDestroy =" + this.f9814a);
            return;
        }
        this.s.a();
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "destroy");
        this.f9814a = true;
        ae aeVar = this.s;
        if (aeVar != null) {
            aeVar.c();
        }
        this.w = null;
        this.v.removeCallbacks(this.B);
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.j();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.p = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.o.addView(this.p, new RelativeLayout.LayoutParams(this.c, this.d));
        b(aVar);
        i();
        h();
        g();
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.k);
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        a(wVar);
        this.p.addView(wVar, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "start countdown...");
        if (this.f9814a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo14", "error state mDestroy " + this.f9814a);
            return;
        }
        this.s.b();
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.s = ae.a(this.k, this.c, this.d, aVar);
        this.p.addView(this.s, new RelativeLayout.LayoutParams(this.c, this.d));
        this.s.a(new ae.a() { // from class: com.opos.mobad.template.g.n.6
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                n.this.v.removeCallbacks(n.this.B);
                n.this.v.postDelayed(n.this.B, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                n.this.v.removeCallbacks(n.this.B);
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.l = interfaceC0778a;
        this.q.a(interfaceC0778a);
        this.s.a(interfaceC0778a);
        af afVar = this.x;
        if (afVar != null) {
            afVar.a(interfaceC0778a);
            this.x.a(new ab.a() { // from class: com.opos.mobad.template.g.n.3
                @Override // com.opos.mobad.template.g.ab.a
                public void a(int i) {
                    n.this.s.a(i);
                }
            });
        }
        ad adVar = this.n;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.n = ad.a(this.k, 8, this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.n.setId(View.generateViewId());
        wVar.addView(this.n, layoutParams);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.j) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.k, e(), bVar.L);
            this.i = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.n.2
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (n.this.l != null) {
                        n.this.l.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (n.this.l != null) {
                        n.this.l.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (n.this.l != null) {
                        n.this.l.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (n.this.l != null) {
                        n.this.l.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
            if (this.i.c() != null && this.p != null) {
                this.i.c().setId(View.generateViewId());
                this.p.addView(this.i.c(), layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                layoutParams2.removeRule(9);
                layoutParams2.removeRule(10);
                layoutParams2.addRule(1, this.i.c().getId());
                layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 8.0f);
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
                this.y.setLayoutParams(layoutParams2);
            }
            this.j = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        t tVar = this.q;
        if (tVar != null) {
            tVar.a(cVar, this.u, this.f9814a);
        }
        af afVar = this.x;
        if (afVar != null) {
            afVar.a(cVar.A);
        }
        TextView textView = this.h;
        if (textView != null) {
            com.opos.mobad.template.d.a aVar = cVar.u;
            if (aVar == null) {
                textView.setVisibility(8);
                return;
            } else {
                if (TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
                    this.h.setVisibility(8);
                    return;
                }
                this.h.setText(cVar.f9413a);
            }
        }
        a((com.opos.mobad.template.d.b) cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.l;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.w == null) {
            this.s.a(cVarB);
        }
        if (this.w == null && (interfaceC0778a = this.l) != null) {
            interfaceC0778a.f();
        }
        this.w = cVarB;
        this.A = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.o;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
        a(cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.k);
        }
        Context context = this.k;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.c;
        this.t = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.e));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.k);
        this.o = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.k, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.c, this.e);
        layoutParams.width = this.c;
        layoutParams.height = this.e;
        this.o.setId(View.generateViewId());
        this.o.setBackgroundColor(this.k.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.o.setLayoutParams(layoutParams);
        this.o.setVisibility(8);
        this.t.addView(this.o, layoutParams);
        this.t.setLayoutParams(layoutParams);
        a(aVar);
        j();
        k();
        com.opos.mobad.template.cmn.p.a(this.o, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.n.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (n.this.l != null) {
                    n.this.l.h(view, iArr);
                }
            }
        });
        this.o.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.n.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo14", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (n.this.l != null) {
                    n.this.l.a(view, i4, z);
                }
            }
        });
    }
}
