package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.g.ai;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ah extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9676a;
    private com.opos.mobad.d.a b;
    private com.opos.mobad.template.cmn.aa c;
    private ag g;
    private com.opos.mobad.template.d.b h;
    private int i;
    private int j;
    private am k;
    private com.opos.mobad.d.d.a l;
    private com.opos.mobad.template.d.c m;
    private int n;
    private boolean o;
    private com.opos.mobad.d.e.a p;
    private com.opos.mobad.d.d.b q;
    private com.opos.mobad.template.cmn.p r;
    private com.opos.mobad.template.cmn.p s;
    private com.opos.mobad.template.cmn.q t;
    private com.opos.mobad.template.cmn.q u;
    private com.opos.mobad.template.cmn.baseview.f v;

    private ah(Context context, int i, am amVar, int i2, com.opos.mobad.d.a aVar) {
        this(context, i, amVar, i2, null, aVar);
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new ah(context, 2, amVar, i, aVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            this.g.a(this.e).a(this.r).b(this.s).a(bVar.f9413a).a(bVar.u).a(bVar).b(bVar).b(bVar.j).a(bVar.b, bVar.u);
            this.g.a(this.v);
            c(bVar);
        }
    }

    private RelativeLayout d(int i) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f9676a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, i));
        relativeLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.template.g.ah.9
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.opos.cmn.an.h.f.a.a(ah.this.f9676a, 16.0f));
            }
        });
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.p == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f9676a);
            this.p = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.ah.12
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (ah.this.m == null) {
                        return;
                    }
                    if (!z) {
                        ah.this.l();
                    } else {
                        ah.this.a((Map<String, String>) null);
                        ah.this.k();
                    }
                }
            });
            this.p.a(new a.c() { // from class: com.opos.mobad.template.g.ah.13
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    if (ah.this.m == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    ah.this.b(map);
                }
            }, c());
        }
        if (this.c.indexOfChild(this.p) < 0) {
            this.c.addView(this.p, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return n() == 8;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.f9676a = null;
        this.h = null;
        this.m = null;
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar != null) {
            aVar.f();
            this.l.h();
        }
        com.opos.mobad.template.cmn.aa aaVar = this.c;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        ag agVar = this.g;
        if (agVar != null) {
            agVar.b();
        }
        com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "doEnd()");
    }

    private ah(Context context, int i, am amVar, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i2);
        this.o = false;
        this.q = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.g.ah.8
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (ah.this.q()) {
                    return;
                }
                ah.this.c(map);
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.a(new Callable() { // from class: com.opos.mobad.template.g.ah.8.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        ah.this.p();
                        return Boolean.TRUE;
                    }
                });
                ah ahVar = ah.this;
                ahVar.c(0L, ahVar.l.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.START);
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                ah.this.o = true;
                ah.this.o();
                ah.this.g.a(com.opos.mobad.template.cmn.t.COMPLETE);
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.RESUME);
                if (ah.this.l != null) {
                    ah ahVar = ah.this;
                    ahVar.b(ahVar.l.d(), ah.this.l.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.PAUSE);
                if (ah.this.l != null) {
                    ah ahVar = ah.this;
                    ahVar.a(ahVar.l.d(), ah.this.l.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.BUFFERINGSTART);
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.BUFFERINGEND);
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
            }
        };
        this.r = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ah.14
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ah.this.q()) {
                    return;
                }
                ah.this.a(view, iArr);
            }
        };
        this.s = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ah.15
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.i(view, iArr);
            }
        };
        this.t = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.g.ah.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.g(view, iArr);
            }
        };
        this.u = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.g.ah.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.h(view, iArr);
            }
        };
        this.v = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.ah.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z) {
                com.opos.cmn.an.f.a.a("BottomLeftImg1Template", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                ah.this.a(view, i3, z);
            }
        };
        if (context == null) {
            return;
        }
        this.f9676a = context.getApplicationContext();
        this.n = i;
        this.l = aVar;
        if (aVar != null) {
            aVar.a(this.q);
        }
        this.b = aVar2;
        this.k = amVar;
        c(i2);
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ah(context, 1, amVar, i, aVar, aVar2);
    }

    private void i() {
        if (this.k == null) {
            int iA = com.opos.cmn.an.h.f.a.a(this.f9676a, 312.0f);
            this.k = new am(iA, (int) (((double) iA) * 0.6d));
        }
        this.i = this.k.f9704a;
        this.j = com.opos.cmn.an.h.f.a.a(this.f9676a, 218.0f);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar == null) {
            return true;
        }
        if (this.o) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "do nothing for has complete");
            return false;
        }
        aVar.g();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar == null) {
            return true;
        }
        if (this.o) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "do nothing for has complete");
            return false;
        }
        aVar.f();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.7
            @Override // java.lang.Runnable
            public void run() {
                if (ah.this.g == null || ah.this.q()) {
                    return;
                }
                ah.this.g.b(bitmap);
            }
        });
    }

    private void c(int i) {
        ag agVar;
        i();
        Context context = this.f9676a;
        am amVar = this.k;
        this.c = new com.opos.mobad.template.cmn.aa(context, new aa.a(amVar.f9704a, amVar.b, this.i / this.j));
        int i2 = this.n;
        if (i2 != 1) {
            if (i2 != 2) {
                agVar = new ag(this.f9676a, this.n, this.b, i);
            } else {
                this.i = com.opos.cmn.an.h.f.a.a(this.f9676a, 328.0f);
                agVar = new ag(this.f9676a, this.n, this.b, i);
            }
            this.g = agVar;
        } else {
            this.g = new ai(this.f9676a, this.n, this.b, this.l);
        }
        RelativeLayout relativeLayoutD = d(25);
        relativeLayoutD.addView(this.g);
        this.c.addView(relativeLayoutD);
        this.c.setVisibility(8);
        this.g.a(com.opos.cmn.an.h.f.a.a(this.f9676a, 16.0f));
        this.g.a(new ai.a() { // from class: com.opos.mobad.template.g.ah.1
            @Override // com.opos.mobad.template.g.ai.a
            public void a(long j, long j2) {
                ah.this.c(j, j2);
            }
        });
        this.c.setOnClickListener(this.u);
        this.c.setOnTouchListener(this.u);
        this.c.a(this.v);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.b == null || bVar == null || (eVar = bVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a((Bitmap) null);
            return;
        }
        com.opos.mobad.d.a aVar = this.b;
        com.opos.mobad.template.d.e eVar2 = bVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.ah.6
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (ah.this.q()) {
                    com.opos.cmn.an.f.a.d("BottomLeftImg1Template", "state end");
                    return;
                }
                if (i == 0 || i == 1) {
                    if (i == 1 && ((com.opos.mobad.template.j.a) ah.this).e != null) {
                        ah.this.b(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled() || ah.this.q()) {
                                return;
                            }
                            ah.this.a(bitmap);
                        }
                    });
                    return;
                }
                ah.this.a((Bitmap) null);
                if (((com.opos.mobad.template.j.a) ah.this).e != null) {
                    ah.this.b(i);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, a.InterfaceC0778a interfaceC0778a) {
        if (viewGroup == null || interfaceC0778a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.ah.10
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "visible change:" + z);
                if (z) {
                    ah.this.a(com.opos.mobad.template.h.a(ah.this.g.d));
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.ah.11
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                Map<String, String> mapA = com.opos.mobad.template.h.a(ah.this.g.d);
                mapA.put("isVisibleRect", String.valueOf(z));
                mapA.put("isAttached", String.valueOf(z2));
                ah.this.b(mapA);
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        ag agVar = this.g;
        if (agVar != null) {
            agVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        List<com.opos.mobad.template.d.e> list;
        if (bVar != null && (list = bVar.c) != null) {
            this.b.a(list.get(0).f9414a, bVar.c.get(0).b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.ah.5
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (ah.this.q()) {
                        com.opos.cmn.an.f.a.d("BottomLeftImg1Template", "state end");
                        return;
                    }
                    if (i != 0 && i != 1) {
                        ah.this.b(i);
                        return;
                    }
                    if (i == 1 && ((com.opos.mobad.template.j.a) ah.this).e != null) {
                        ah.this.b(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled() || ah.this.q()) {
                                return;
                            }
                            ah.this.g.a(bitmap);
                        }
                    });
                }
            });
        }
        b(bVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.e eVar;
        com.opos.mobad.template.cmn.aa aaVar;
        String str = "BottomLeftImg1Template";
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "data is null");
        } else if (this.n == 2) {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            str = "";
            if (bVarA == null) {
                com.opos.cmn.an.f.a.d(str, "render with data null");
            } else {
                List<com.opos.mobad.template.d.e> list = bVarA.c;
                if (list != null && list.size() > 0) {
                    a(bVarA);
                    if (this.h == null && this.e != null) {
                        m();
                        a(this.c, this.e);
                    }
                    this.h = bVarA;
                    aaVar = this.c;
                    if (aaVar != null || aaVar.getVisibility() == 0) {
                        return;
                    }
                    this.c.setVisibility(0);
                    return;
                }
                com.opos.cmn.an.f.a.d("", "render with imgList null");
            }
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null && (eVar = cVarB.N) != null && !TextUtils.isEmpty(eVar.f9414a)) {
                b(cVarB);
                if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.m == null) {
                    this.l.a(cVarB.N.f9414a, false);
                    this.l.a(cVarB.A == 1 ? 1.0f : 0.0f);
                }
                this.m = cVarB;
                aaVar = this.c;
                if (aaVar != null) {
                    return;
                } else {
                    return;
                }
            }
            com.opos.cmn.an.f.a.d(str, "render with data null");
        }
        a(1);
    }
}
