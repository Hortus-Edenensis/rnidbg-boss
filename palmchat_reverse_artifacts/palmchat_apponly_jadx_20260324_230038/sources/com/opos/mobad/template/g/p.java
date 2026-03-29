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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.g.ab;
import com.opos.mobad.template.g.ad;
import com.opos.mobad.template.g.ae;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class p implements com.opos.mobad.template.a {
    private int b;
    private RelativeLayout c;
    private int g;
    private af i;
    private com.opos.mobad.template.a.c j;
    private boolean k;
    private Context l;
    private a.InterfaceC0778a m;
    private int n;
    private ad o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private com.opos.mobad.template.cmn.w q;
    private u r;
    private ae s;
    private com.opos.mobad.template.cmn.aa t;
    private com.opos.mobad.d.a u;
    private com.opos.mobad.template.d.c w;
    private com.opos.mobad.template.cmn.w x;
    private com.opos.mobad.template.e.c.a z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9832a = false;
    private int d = 60;
    private int e = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
    private int f = MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO;
    private int h = 64;
    private boolean y = false;
    private boolean A = false;
    private Runnable B = new Runnable() { // from class: com.opos.mobad.template.g.p.1
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f9832a) {
                return;
            }
            int iG = p.this.s.g();
            int iH = p.this.s.h();
            if (p.this.m != null) {
                p.this.m.d(iG, iH);
            }
            p.this.s.f();
            p.this.v.postDelayed(this, 500L);
        }
    };
    private Handler v = new Handler(Looper.getMainLooper());

    private p(Context context, am amVar, int i, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.l = context;
        this.n = i2;
        this.u = aVar2;
        this.b = i;
        f();
        a(amVar, aVar);
        l();
        k();
    }

    public static p a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new p(context, amVar, 2, i, aVar, aVar2);
    }

    private void g() {
        this.i = af.a(this.l, 15);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.i.setVisibility(4);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.l);
        this.x = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.l, 14.0f));
        this.x.setId(View.generateViewId());
        this.x.setBackgroundColor(Color.parseColor("#8A42464C"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.l, 44.0f), com.opos.cmn.an.h.f.a.a(this.l, 28.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.l, 12.0f);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.l, 12.0f);
        this.x.addView(this.i, layoutParams);
        this.x.setLayoutParams(layoutParams2);
        this.q.addView(this.x);
    }

    private void i() {
        int i = this.b;
        if (i == 3) {
            this.r = u.a(this.l, 2, this.u, true, true);
        } else if (i == 2) {
            this.r = u.a(this.l, 3, this.u, true, true);
            this.d = 56;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.l, this.d));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.r.setId(View.generateViewId());
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
    }

    private void j() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.j = new com.opos.mobad.template.a.c(this.l, Color.parseColor("#66000000"));
        layoutParams.addRule(3, this.q.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.l, 8.0f);
        this.j.setVisibility(4);
        this.p.addView(this.j, layoutParams);
    }

    private void k() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.l);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.p.8
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (p.this.w == null) {
                    return;
                }
                if (z && !p.this.y) {
                    p.this.y = true;
                    if (p.this.m != null) {
                        p.this.m.a(com.opos.mobad.template.h.a(p.this.z));
                    }
                    if (p.this.z != null && p.this.z.c() != null) {
                        p.this.z.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "BlockBigImageVideo3 onWindowVisibilityChanged：" + z);
                if (p.this.k) {
                    if (z) {
                        p.this.s.d();
                    } else {
                        p.this.s.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.p.9
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (p.this.w == null) {
                    return;
                }
                if (p.this.m != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(p.this.z);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    p.this.m.a(mapA);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "BlockBigImageVideo3 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.p.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void l() {
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        ad adVar = this.o;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
        af afVar = this.i;
        if (afVar != null) {
            afVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.n;
    }

    public static p b(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new p(context, amVar, 3, i, aVar, aVar2);
    }

    private void f() {
        this.e = com.opos.cmn.an.h.f.a.a(this.l, 328.0f);
        this.f = com.opos.cmn.an.h.f.a.a(this.l, 184.0f);
        this.h = com.opos.cmn.an.h.f.a.a(this.l, 64.0f);
        this.g = this.b == 3 ? this.f : this.f + com.opos.cmn.an.h.f.a.a(this.l, 24.0f);
    }

    private void h() {
        if (this.b == 3) {
            this.c = new RelativeLayout(this.l);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1979711488});
            gradientDrawable.setShape(0);
            this.c.setBackground(gradientDrawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.h);
            this.c.setVisibility(0);
            layoutParams.addRule(12);
            this.q.addView(this.c, layoutParams);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.f9832a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "current state has stop mDestroy = " + this.f9832a);
            return;
        }
        this.s.a();
        com.opos.mobad.template.e.c.a aVar = this.z;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "destroy");
        this.f9832a = true;
        this.s.c();
        this.w = null;
        this.v.removeCallbacks(this.B);
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.z;
        if (aVar != null) {
            aVar.j();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.l);
        this.q = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.l, 14.0f));
        this.q.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
        this.q.setVisibility(4);
        this.p.addView(this.q, layoutParams);
        b(aVar);
        h();
        g();
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.l);
        wVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        a(wVar2);
        this.q.addView(wVar2, layoutParams2);
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.a.c cVar2;
        com.opos.mobad.template.d.a aVar = cVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar2 = this.j) == null) {
            return;
        }
        cVar2.setVisibility(0);
        this.j.a(aVar.f9412a, aVar.b);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "start countdown...");
        if (this.f9832a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "error state mDestroy " + this.f9832a);
            return;
        }
        this.s.b();
        com.opos.mobad.template.e.c.a aVar = this.z;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.s = ae.a(this.l, this.e, this.f, aVar);
        this.q.addView(this.s, new RelativeLayout.LayoutParams(this.e, this.f));
        this.s.a(new ae.a() { // from class: com.opos.mobad.template.g.p.7
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                p.this.v.removeCallbacks(p.this.B);
                p.this.v.postDelayed(p.this.B, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                p.this.v.removeCallbacks(p.this.B);
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.m = interfaceC0778a;
        this.r.a(interfaceC0778a);
        this.s.a(interfaceC0778a);
        ad adVar = this.o;
        if (adVar != null) {
            adVar.a(new ad.a() { // from class: com.opos.mobad.template.g.p.3
                @Override // com.opos.mobad.template.g.ad.a
                public void a(int i) {
                    p.this.s.a(i);
                }
            });
        }
        af afVar = this.i;
        if (afVar != null) {
            afVar.a(interfaceC0778a);
            this.i.a(new ab.a() { // from class: com.opos.mobad.template.g.p.4
                @Override // com.opos.mobad.template.g.ab.a
                public void a(int i) {
                    p.this.s.a(i);
                }
            });
        }
        com.opos.mobad.template.a.c cVar = this.j;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
        ad adVar2 = this.o;
        if (adVar2 != null) {
            adVar2.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.o = ad.a(this.l, 8, this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.o.setId(View.generateViewId());
        this.o.setVisibility(4);
        wVar.addView(this.o, layoutParams);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        u uVar = this.r;
        if (uVar != null) {
            uVar.a(cVar);
        }
        af afVar = this.i;
        if (afVar != null) {
            afVar.a(cVar.A);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.A) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.l, e(), bVar.L);
            this.z = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.p.2
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (p.this.m != null) {
                        p.this.m.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (p.this.m != null) {
                        p.this.m.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (p.this.m != null) {
                        p.this.m.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (p.this.m != null) {
                        p.this.m.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.l, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.l, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.l, 12.0f);
            if (this.z.c() != null && this.q != null) {
                this.z.c().setId(View.generateViewId());
                this.q.addView(this.z.c(), layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams2.removeRule(9);
                layoutParams2.removeRule(10);
                layoutParams2.addRule(1, this.z.c().getId());
                layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.l, 8.0f);
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.l, 12.0f);
                this.x.setLayoutParams(layoutParams2);
            }
            this.A = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.z;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        b(cVar);
        c(cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.m;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.w == null) {
            this.s.a(cVarB);
        }
        if (this.w == null && (interfaceC0778a = this.m) != null) {
            interfaceC0778a.f();
        }
        this.w = cVarB;
        this.k = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.p;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        a(cVarB);
        a((com.opos.mobad.template.d.b) cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.l);
        }
        Context context = this.l;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.e;
        this.t = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.g));
        this.p = new com.opos.mobad.template.cmn.baseview.c(this.l);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.e, -2);
        layoutParams.width = this.e;
        layoutParams.height = -2;
        this.p.setId(View.generateViewId());
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        this.t.addView(this.p, layoutParams);
        this.t.setLayoutParams(layoutParams);
        a(aVar);
        i();
        if (this.b == 2) {
            j();
        }
        com.opos.mobad.template.cmn.p.a(this.p, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.p.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (p.this.m != null) {
                    p.this.m.h(view, iArr);
                }
            }
        });
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.p.6
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo3", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (p.this.m != null) {
                    p.this.m.a(view, i4, z);
                }
            }
        });
    }
}
