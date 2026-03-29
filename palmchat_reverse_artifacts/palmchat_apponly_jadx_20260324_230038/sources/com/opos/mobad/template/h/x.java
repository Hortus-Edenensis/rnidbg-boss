package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.h.a;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x extends com.opos.mobad.template.j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10076a;
    private com.opos.mobad.template.cmn.baseview.c b;
    private Context c;
    private com.opos.mobad.d.d.a g;
    private com.opos.mobad.d.a h;
    private com.opos.mobad.template.d.c i;
    private a j;
    private int k;
    private boolean l;
    private com.opos.mobad.d.e.a m;
    private boolean n;
    private int o;
    private com.opos.mobad.template.e.c.a p;
    private boolean q;
    private com.opos.mobad.template.cmn.p r;
    private com.opos.mobad.template.cmn.p s;
    private com.opos.mobad.template.cmn.q t;
    private com.opos.mobad.template.cmn.baseview.f u;
    private com.opos.mobad.template.cmn.p v;
    private com.opos.mobad.d.d.b w;
    private j.b x;

    private x(Context context, int i, int i2, boolean z, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i);
        this.o = 0;
        this.q = false;
        this.f10076a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.7
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                x.this.h(view, iArr);
            }
        };
        this.r = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.8
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                x.this.h(view, iArr);
            }
        };
        this.s = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                x.this.i(view, iArr);
            }
        };
        this.t = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.x.10
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                x.this.g(view, iArr);
            }
        };
        this.u = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.x.11
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardOPTVideoTemplate", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                x.this.a(view, i3, z2);
            }
        };
        this.v = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.12
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                x.this.a(view, iArr);
            }
        };
        this.w = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.h.x.13
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (x.this.r()) {
                    return;
                }
                x.this.c(map);
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                if (x.this.r()) {
                    return;
                }
                x.this.a(new Callable() { // from class: com.opos.mobad.template.h.x.13.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        x.this.s();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                x xVar = x.this;
                xVar.c(0L, xVar.g.c());
                x.this.j.a(com.opos.mobad.template.cmn.t.START);
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                x.this.l = true;
                x.this.o();
                x.this.j.a(com.opos.mobad.template.cmn.t.COMPLETE);
                if (x.this.p == null || !x.this.p.e()) {
                    return;
                }
                if (!(x.this.p instanceof com.opos.mobad.template.e.c.d)) {
                    if (!(x.this.p instanceof com.opos.mobad.template.e.c.e) || x.this.p.c() == null || x.this.p.c().getVisibility() == 8) {
                        return;
                    }
                    x.this.p.c().setVisibility(8);
                    return;
                }
                if (x.this.i.J.containsKey("EXT_PARAM_KEY_SHOW_ENDPAGE")) {
                    String str = x.this.i.J.get("EXT_PARAM_KEY_SHOW_ENDPAGE");
                    if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                        return;
                    }
                    x.this.p.f();
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(com.opos.mobad.template.cmn.t.RESUME);
                if (x.this.g != null) {
                    x xVar = x.this;
                    xVar.b(xVar.g.d(), x.this.g.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(com.opos.mobad.template.cmn.t.PAUSE);
                if (x.this.g != null) {
                    x xVar = x.this;
                    xVar.a(xVar.g.d(), x.this.g.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(com.opos.mobad.template.cmn.t.BUFFERINGSTART);
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(com.opos.mobad.template.cmn.t.BUFFERINGEND);
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(com.opos.mobad.template.cmn.t.RENDERFIRSTFRAME);
            }
        };
        this.x = new j.b() { // from class: com.opos.mobad.template.h.x.4
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return x.this.r();
            }
        };
        this.c = context.getApplicationContext();
        this.k = i2;
        this.n = z;
        this.g = aVar;
        this.h = aVar2;
        if (aVar != null) {
            aVar.a(this.w);
        }
        p();
    }

    public static com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 0, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 1, true, aVar, aVar2);
    }

    public static /* synthetic */ int d(x xVar) {
        int i = xVar.o;
        xVar.o = i + 1;
        return i;
    }

    public static com.opos.mobad.template.a e(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 4, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a g(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 7, false, aVar, aVar2);
    }

    public static com.opos.mobad.template.a h(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 8, true, aVar, aVar2);
    }

    private void p() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.c);
        this.b = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a aVarC = c(this.k);
        this.j = aVarC;
        this.b.addView(aVarC.a());
        q();
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.setForceDarkAllowed(false);
        }
    }

    private void q() {
        this.j.a(this.r).b(this.s).a(this.t).b_(this.u).c(this.v).a(new a.InterfaceC0795a() { // from class: com.opos.mobad.template.h.x.1
            @Override // com.opos.mobad.template.h.a.InterfaceC0795a
            public void a(long j, long j2) {
                if (x.this.r()) {
                    return;
                }
                x.this.c(j, j2);
                if (x.this.p == null || !(x.this.p instanceof com.opos.mobad.template.e.c.e)) {
                    return;
                }
                if (x.this.o == 3 && x.this.p.e() && x.this.p.c() != null && x.this.p.c().getVisibility() != 0) {
                    x.this.p.c().setVisibility(0);
                }
                if (x.this.o == 13 && x.this.p.e() && x.this.p.c() != null && x.this.p.c().getVisibility() != 8) {
                    x.this.p.c().setVisibility(8);
                }
                x.d(x.this);
            }
        });
        com.opos.mobad.template.cmn.p.a(this.b, this.f10076a);
        this.b.a(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return n() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.m == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.c);
            this.m = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.x.2
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (x.this.i == null) {
                        return;
                    }
                    if (!z) {
                        x.this.l();
                        return;
                    }
                    x.this.a(x.this.k == 1 ? com.opos.mobad.template.h.a(x.this.p, x.this.i) : com.opos.mobad.template.h.a(x.this.p));
                    x.this.k();
                    if (x.this.p == null || !(x.this.p instanceof com.opos.mobad.template.e.c.d) || x.this.p.c() == null || !x.this.p.e() || x.this.p.c().getVisibility() == 0) {
                        return;
                    }
                    x.this.p.c().setVisibility(0);
                }
            });
            this.m.a(new a.c() { // from class: com.opos.mobad.template.h.x.3
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "onViewVisibleWithoutFocus: " + z + ", " + z2);
                    if (x.this.i == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.template.h.a(x.this.p);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    x.this.b(mapA);
                }
            }, c());
        }
        if (this.b.indexOfChild(this.m) < 0) {
            this.b.addView(this.m, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.x.6
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.r()) {
                    return;
                }
                x.this.j.a(bitmap);
            }
        });
    }

    public static com.opos.mobad.template.a d(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 3, false, aVar, aVar2);
    }

    public static com.opos.mobad.template.a f(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 5, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a i(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 9, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a j(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 12, true, aVar, aVar2);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.b;
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.h == null || cVar == null || (eVar = cVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a((Bitmap) null);
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.c, 42.0f);
        com.opos.mobad.template.d.e eVar2 = cVar.k;
        com.opos.mobad.template.cmn.j.a(eVar2.f9414a, eVar2.b, iA, iA, this.h, new j.c() { // from class: com.opos.mobad.template.h.x.5
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (i != 1) {
                    x.this.a((Bitmap) null);
                }
                x.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                x.this.a(bitmap);
            }
        }, this.x);
    }

    public static com.opos.mobad.template.a c(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new x(context, i, 2, false, aVar, aVar2);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.j.a(i());
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            aVar.g();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 == null || !(aVar2 instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar2.h();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            aVar.f();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 == null || !(aVar2 instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar2.i();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.i = null;
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
            this.g.h();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.j();
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.b;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.opos.mobad.template.d.b bVar) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams;
        if (!this.q) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.c, e(), bVar.L);
            this.p = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.h.x.14
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    x.this.i().a(i, iArr);
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    x.this.i().g(view, iArr);
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    x.this.i().h(view, iArr);
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    x.this.i().a(iArr);
                }
            });
            com.opos.mobad.template.e.c.a aVar = this.p;
            if (aVar instanceof com.opos.mobad.template.e.c.e) {
                aVar.a(this.u);
                if (this.n) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                } else {
                    int iB = com.opos.cmn.an.h.f.a.b(this.c);
                    if (iB > 0) {
                        layoutParams = new RelativeLayout.LayoutParams(-2, iB - com.opos.cmn.an.h.f.a.a(this.c, 80.0f));
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 14.0f);
                    }
                    layoutParams.addRule(14);
                }
                if (this.p.e() && this.p.c() != null) {
                    this.b.addView(this.p.c(), layoutParams);
                }
            } else if (aVar instanceof com.opos.mobad.template.e.c.d) {
                View view = new View(this.c);
                view.setId(View.generateViewId());
                int iA = 0;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 0);
                layoutParams2.addRule(12);
                this.b.addView(view, layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 46.0f));
                int i = this.k;
                if (i == 0) {
                    iA = com.opos.cmn.an.h.f.a.a(this.c, 209.0f);
                    layoutParams3.bottomMargin = iA;
                    if (this.p.e() && this.p.c() != null) {
                        layoutParams3.addRule(14);
                        layoutParams3.addRule(2, view.getId());
                        this.b.addView(this.p.c(), layoutParams3);
                    }
                } else {
                    if (i == 1) {
                        if (com.opos.mobad.template.h.a(bVar)) {
                            context = this.c;
                            f = 268.0f;
                        }
                        iA = com.opos.cmn.an.h.f.a.a(this.c, 209.0f);
                        layoutParams3.bottomMargin = iA;
                        if (this.p.e()) {
                        }
                    } else if (i != 2) {
                        if (i == 3 || i == 7) {
                            context = this.c;
                            f = 30.0f;
                        }
                        layoutParams3.bottomMargin = iA;
                        if (this.p.e()) {
                            layoutParams3.addRule(14);
                            layoutParams3.addRule(2, view.getId());
                            this.b.addView(this.p.c(), layoutParams3);
                        }
                    } else {
                        context = this.c;
                        f = 92.0f;
                    }
                    iA = com.opos.cmn.an.h.f.a.a(context, f);
                    layoutParams3.bottomMargin = iA;
                    if (this.p.e()) {
                    }
                }
            }
            this.q = true;
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private a c(int i) {
        switch (i) {
        }
        return new ae(this.c, this.h, this.g, true);
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        if (cVar != null) {
            this.j.a(cVar);
            b(cVar);
            a((com.opos.mobad.template.d.b) cVar);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("RewardOPTVideoTemplate", "data is null");
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null && !TextUtils.isEmpty(cVarB.N.f9414a)) {
                a(cVarB);
                if (this.i == null) {
                    this.g.a(cVarB.N.f9414a, false);
                    this.g.a(cVarB.A == 1 ? 1.0f : 0.0f);
                }
                this.i = cVarB;
                return;
            }
            com.opos.cmn.an.f.a.d("RewardOPTVideoTemplate", "render with data null");
        }
        a(1);
    }
}
