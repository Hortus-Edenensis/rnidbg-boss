package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
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
import com.opos.mobad.template.g.ae;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class q implements com.opos.mobad.template.a {
    private int d;
    private af e;
    private Context f;
    private a.InterfaceC0778a g;
    private int h;
    private ad i;
    private com.opos.mobad.template.cmn.baseview.c j;
    private com.opos.mobad.template.cmn.w k;
    private u l;
    private ae m;
    private com.opos.mobad.template.cmn.aa n;
    private com.opos.mobad.d.a o;
    private com.opos.mobad.template.d.c q;
    private boolean s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9842a = false;
    private int b = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
    private int c = MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO;
    private boolean r = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.template.g.q.1
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f9842a) {
                return;
            }
            int iG = q.this.m.g();
            int iH = q.this.m.h();
            if (q.this.g != null) {
                q.this.g.d(iG, iH);
            }
            q.this.m.f();
            q.this.p.postDelayed(this, 500L);
        }
    };
    private Handler p = new Handler(Looper.getMainLooper());

    private q(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.f = context;
        this.h = i;
        this.o = aVar2;
        f();
        a(amVar, aVar);
        i();
        h();
    }

    public static q a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new q(context, amVar, i, aVar, aVar2);
    }

    private void g() {
        u uVarA = u.a(this.f, 2, this.o, false, true);
        this.l = uVarA;
        uVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, com.opos.cmn.an.h.f.a.a(this.f, 66.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
    }

    private void h() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.q.6
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (q.this.q == null) {
                    return;
                }
                if (z && !q.this.r) {
                    q.this.r = true;
                    if (q.this.g != null) {
                        q.this.g.a((Map<String, String>) null);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "BlockBigImageVideo4 onWindowVisibilityChanged：" + z);
                if (q.this.s) {
                    if (z) {
                        q.this.m.d();
                    } else {
                        q.this.m.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.q.7
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (q.this.q == null) {
                    return;
                }
                if (q.this.g != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    q.this.g.a(map);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "BlockBigImageVideo4 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.j.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void i() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        ad adVar = this.i;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
        af afVar = this.e;
        if (afVar != null) {
            afVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.h;
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 328.0f);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 184.0f);
        this.c = iA;
        this.d = iA + com.opos.cmn.an.h.f.a.a(this.f, 24.0f);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (!this.f9842a) {
            this.m.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "current state has stop mDestroy =" + this.f9842a);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "start countdown...");
        if (!this.f9842a) {
            this.m.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "error state mDestroy " + this.f9842a);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "destroy");
        this.f9842a = true;
        this.m.c();
        this.q = null;
        this.p.removeCallbacks(this.t);
        com.opos.mobad.template.cmn.aa aaVar = this.n;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.k = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.f, 16.0f));
        this.k.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.k.setVisibility(4);
        this.j.addView(this.k, layoutParams);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.f);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        wVar2.setId(View.generateViewId());
        wVar2.setBackgroundColor(Color.parseColor("#8C42464C"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 44.0f), com.opos.cmn.an.h.f.a.a(this.f, 28.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        com.opos.mobad.template.cmn.w wVar3 = new com.opos.mobad.template.cmn.w(this.f);
        wVar3.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        b(aVar);
        b(wVar2);
        a(wVar3);
        this.k.addView(wVar2, layoutParams2);
        this.k.addView(wVar3, layoutParams3);
        g();
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.m = ae.a(this.f, this.b, this.c, aVar);
        this.k.addView(this.m, new RelativeLayout.LayoutParams(this.b, this.c));
        this.m.a(new ae.a() { // from class: com.opos.mobad.template.g.q.5
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                q.this.p.removeCallbacks(q.this.t);
                q.this.p.postDelayed(q.this.t, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                q.this.p.removeCallbacks(q.this.t);
            }
        });
    }

    private void b(com.opos.mobad.template.cmn.w wVar) {
        this.e = af.a(this.f, 15);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.e.setVisibility(4);
        wVar.addView(this.e, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.g = interfaceC0778a;
        this.m.a(interfaceC0778a);
        this.l.a(interfaceC0778a);
        af afVar = this.e;
        if (afVar != null) {
            afVar.a(interfaceC0778a);
            this.e.a(new ab.a() { // from class: com.opos.mobad.template.g.q.2
                @Override // com.opos.mobad.template.g.ab.a
                public void a(int i) {
                    q.this.m.a(i);
                }
            });
        }
        ad adVar = this.i;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.i = ad.a(this.f, 9, this.o);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.i.setId(View.generateViewId());
        this.i.setVisibility(4);
        wVar.addView(this.i, layoutParams);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        u uVar = this.l;
        if (uVar != null) {
            uVar.a(cVar);
        }
        af afVar = this.e;
        if (afVar != null) {
            afVar.a(cVar.A);
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        b(cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.g;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.q == null) {
            this.m.a(cVarB);
        }
        if (this.q == null && (interfaceC0778a = this.g) != null) {
            interfaceC0778a.f();
        }
        this.q = cVarB;
        this.s = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.n;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.j;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        a(cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.f);
        }
        Context context = this.f;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.n = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        this.j = new com.opos.mobad.template.cmn.baseview.c(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.j.setId(View.generateViewId());
        this.j.setLayoutParams(layoutParams);
        this.j.setVisibility(8);
        this.n.addView(this.j, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.q.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (q.this.g != null) {
                    q.this.g.h(view, iArr);
                }
            }
        };
        this.j.setOnClickListener(pVar);
        this.j.setOnTouchListener(pVar);
        this.j.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.q.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo4", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (q.this.g != null) {
                    q.this.g.a(view, i4, z);
                }
            }
        });
    }
}
