package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g implements com.opos.mobad.template.a {
    private int f;
    private com.opos.mobad.template.e.c.a g;
    private Context i;
    private a.InterfaceC0778a j;
    private int k;
    private int l;
    private com.opos.mobad.template.d.b m;
    private ImageView n;
    private ad o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private com.opos.mobad.template.cmn.w q;
    private u r;
    private y s;
    private x t;
    private RelativeLayout u;
    private com.opos.mobad.template.cmn.aa w;
    private com.opos.mobad.d.a x;
    private com.opos.mobad.template.a.c y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9755a = false;
    private int b = 66;
    private int c = 256;
    private int d = 144;
    private int e = 66;
    private boolean h = false;
    private boolean v = false;

    private g(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.i = context;
        this.l = i2;
        this.k = i;
        this.x = aVar;
        f();
        a(amVar);
        s();
        r();
    }

    public static g d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new g(context, amVar, i, 6, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 != 6) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        int iA;
        this.e = com.opos.cmn.an.h.f.a.a(this.i, 66.0f);
        int i = this.l;
        if (i == 0) {
            this.c = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.i, 184.0f);
            this.d = iA;
        } else if (i == 2) {
            this.c = com.opos.cmn.an.h.f.a.a(this.i, 256.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.i, 216.0f);
            this.v = true;
        } else if (i == 5) {
            this.c = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.i, 216.0f);
            this.d = iA;
        }
        this.f = this.d + com.opos.cmn.an.h.f.a.a(this.i, 24.0f);
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.y) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.y.a(aVar.f9412a, aVar.b);
    }

    private boolean h() {
        return this.l == 6;
    }

    private void i() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.q = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 16.0f));
        this.q.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        this.q.setVisibility(4);
        this.p.addView(this.q, layoutParams);
        if (this.v) {
            o();
        } else {
            p();
        }
        if (g()) {
            k();
            j();
        } else {
            q();
            l();
        }
        if (this.l == 5) {
            m();
        }
    }

    private void j() {
        this.o = ad.a(this.i, 9, this.x);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        this.o.setId(View.generateViewId());
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    private void k() {
        n();
        if (this.l == 5) {
            this.r = u.a(this.i, 3, this.x, true, true);
            this.b = 52;
        } else {
            this.r = u.a(this.i, 2, this.x, false, true);
        }
        this.r.setId(View.generateViewId());
        this.r.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, com.opos.cmn.an.h.f.a.a(this.i, this.b));
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        this.q.addView(this.r, layoutParams);
    }

    private void l() {
        Context context;
        float f;
        n();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, com.opos.cmn.an.h.f.a.a(this.i, 26.0f));
        if (this.l == 6) {
            this.r = u.a(this.i, 1);
            context = this.i;
            f = 10.0f;
        } else {
            this.r = u.a(this.i);
            context = this.i;
            f = 12.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f);
        this.r.setId(View.generateViewId());
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.y = new com.opos.mobad.template.a.c(this.i, Color.parseColor("#66000000"));
        layoutParams.addRule(3, this.q.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
        this.y.setVisibility(4);
        this.p.addView(this.y, layoutParams);
    }

    private void n() {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.u = relativeLayout;
        if (this.l == 6) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, -1979711488});
            gradientDrawable.setShape(0);
            this.u.setBackground(gradientDrawable);
        } else {
            relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient_top);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.e);
        this.u.setVisibility(0);
        this.q.addView(this.u, layoutParams);
    }

    private void o() {
        this.t = x.a(this.i, this.c, this.d, true);
        this.q.addView(this.t, new RelativeLayout.LayoutParams(this.c, this.d));
    }

    private void p() {
        this.n = new ImageView(this.i);
        this.q.addView(this.n, new RelativeLayout.LayoutParams(this.c, this.d));
    }

    private void q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, -2);
        if (this.l == 6) {
            this.o = ad.a(this.i, 3, this.x);
        } else {
            this.o = ad.a(this.i, false, this.x);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        }
        layoutParams.addRule(12);
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    private void r() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.g.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (g.this.m == null) {
                    return;
                }
                if (z) {
                    if (g.this.j != null) {
                        g.this.j.a(com.opos.mobad.template.h.a(g.this.g));
                    }
                    aVar.a((a.InterfaceC0735a) null);
                    if (g.this.g != null && g.this.g.c() != null) {
                        g.this.g.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImage4", "blockBigImage4 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.g.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (g.this.m == null) {
                    return;
                }
                if (g.this.j != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(g.this.g);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    g.this.j.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage4", "blockBigImage4 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.p.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void s() {
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        ad adVar = this.o;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.w;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.k;
    }

    public static g a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new g(context, amVar, i, 0, aVar);
    }

    public static g b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new g(context, amVar, i, 2, aVar);
    }

    private void f(com.opos.mobad.template.d.b bVar) {
        this.o.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
    }

    private boolean g() {
        int i = this.l;
        return i == 5 || i == 6;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage4", "destroy");
        this.m = null;
        this.f9755a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.w;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.t;
        if (xVar != null) {
            xVar.a();
        }
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
            this.g.j();
        }
        u uVar = this.r;
        if (uVar != null) {
            uVar.a();
        }
    }

    public static g c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new g(context, amVar, i, 5, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.r.a(bVar);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.n) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.x.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.c, this.d, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.g.6
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (g.this.f9755a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage4", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (g.this.j != null) {
                        g.this.j.c(i);
                    }
                } else {
                    if (i == 1 && g.this.j != null) {
                        g.this.j.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.g.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (g.this.f9755a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            g.this.n.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        if (this.v) {
            c(bVar);
        } else {
            e(bVar);
        }
        if (!g()) {
            f(bVar);
        }
        g(bVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        x xVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (xVar = this.t) == null) {
            return;
        }
        xVar.a(bVar, this.x, this.f9755a, bVar.y);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0778a);
        }
        u uVar = this.r;
        if (uVar != null) {
            uVar.a(interfaceC0778a);
        }
        ad adVar = this.o;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.t;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.a.c cVar = this.y;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        RelativeLayout.LayoutParams layoutParams;
        if (!this.h) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.i, e(), bVar.L);
            this.g = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.g.1
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (g.this.j != null) {
                        g.this.j.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (g.this.j != null) {
                        g.this.j.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (g.this.j != null) {
                        g.this.j.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (g.this.j != null) {
                        g.this.j.a(iArr);
                    }
                }
            });
            if (h()) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.addRule(12);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
            }
            if (this.q != null && this.g.c() != null) {
                this.q.addView(this.g.c(), layoutParams);
            }
            this.h = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage4", "data is null");
            this.j.a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage4", "adShowData is null");
            this.j.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage4", "render");
        if (this.m == null && (interfaceC0778a = this.j) != null) {
            interfaceC0778a.f();
        }
        this.m = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.w;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.p;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        b(bVarA);
        a(bVarA);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.i);
        }
        Context context = this.i;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.c;
        this.w = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.f));
        this.p = new com.opos.mobad.template.cmn.baseview.c(this.i);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.c, -2);
        layoutParams.width = this.c;
        layoutParams.height = -2;
        this.p.setId(View.generateViewId());
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.c, -2);
        layoutParams2.addRule(13);
        this.w.addView(this.p, layoutParams2);
        this.w.setLayoutParams(layoutParams);
        i();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.g.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (g.this.j != null) {
                    g.this.j.h(view, iArr);
                }
            }
        };
        this.p.setOnClickListener(pVar);
        this.p.setOnTouchListener(pVar);
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.g.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage4", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (g.this.j != null) {
                    g.this.j.a(view, i4, z);
                }
            }
        });
    }
}
