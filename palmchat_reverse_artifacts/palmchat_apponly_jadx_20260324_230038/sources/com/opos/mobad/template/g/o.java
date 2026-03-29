package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.g.ab;
import com.opos.mobad.template.g.ae;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class o implements com.opos.mobad.template.a {
    private int b;
    private int e;
    private int f;
    private af g;
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
    private com.opos.mobad.template.e.c.a v;
    private com.opos.mobad.template.cmn.w x;
    private boolean y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9823a = false;
    private int c = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
    private int d = MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
    private boolean u = false;
    private boolean w = false;
    private Runnable z = new Runnable() { // from class: com.opos.mobad.template.g.o.1
        @Override // java.lang.Runnable
        public void run() {
            if (o.this.f9823a) {
                return;
            }
            int iG = o.this.p.g();
            int iH = o.this.p.h();
            if (o.this.j != null) {
                o.this.j.d(iG, iH);
            }
            o.this.p.f();
            o.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    private o(Context context, am amVar, int i, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.i = context;
        this.k = i2;
        this.r = aVar2;
        this.b = i;
        f();
        a(amVar, aVar);
        k();
        j();
    }

    public static o a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new o(context, amVar, 2, i, aVar, aVar2);
    }

    private void g() {
        TextView textView = new TextView(this.i);
        this.h = textView;
        textView.setTextColor(this.i.getResources().getColor(R.color.opos_mobad_description_color));
        this.h.setTextSize(1, 12.0f);
        this.h.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.h.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.h.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.i, 48.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
        layoutParams.addRule(12);
        this.h.setVisibility(4);
        this.n.addView(this.h, layoutParams);
    }

    private void i() {
        this.o = this.b == 2 ? s.a(this.i, 2, true, this.r, true) : s.a(this.i, 2, false, this.r, true);
        this.o.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f, com.opos.cmn.an.h.f.a.a(this.i, 74.0f));
        this.o.setVisibility(4);
        this.m.addView(this.o, layoutParams);
    }

    private void j() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.o.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (o.this.t == null) {
                    return;
                }
                if (z && !o.this.u) {
                    o.this.u = true;
                    if (o.this.j != null) {
                        o.this.j.a(com.opos.mobad.template.h.a(o.this.v));
                    }
                    if (o.this.v != null && o.this.v.c() != null) {
                        o.this.v.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "BlockBigImageVideo2 onWindowVisibilityChanged：" + z);
                if (o.this.y) {
                    if (z) {
                        o.this.p.d();
                    } else {
                        o.this.p.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.o.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (o.this.t == null) {
                    return;
                }
                if (o.this.j != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(o.this.v);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    o.this.j.a(mapA);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "BlockBigImageVideo2 onViewVisibleWithoutFocus：" + z + ", " + z2);
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
        af afVar = this.g;
        if (afVar != null) {
            afVar.setVisibility(0);
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private boolean l() {
        return this.b == 3;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.q;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.k;
    }

    public static o b(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new o(context, amVar, 3, i, aVar, aVar2);
    }

    private void f() {
        this.c = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.i, 258.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.i, 258.0f);
        this.f = this.c;
    }

    private void h() {
        this.g = af.a(this.i, 15);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.g.setVisibility(4);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.x = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        this.x.setId(View.generateViewId());
        this.x.setBackgroundColor(Color.parseColor("#8A42464C"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 44.0f), com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        this.x.addView(this.g, layoutParams);
        this.x.setLayoutParams(layoutParams2);
        this.n.addView(this.x);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.f9823a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "current state has stop mDestroy = " + this.f9823a);
            return;
        }
        this.p.a();
        com.opos.mobad.template.e.c.a aVar = this.v;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "destroy");
        this.f9823a = true;
        this.p.c();
        this.t = null;
        this.s.removeCallbacks(this.z);
        com.opos.mobad.template.e.c.a aVar = this.v;
        if (aVar != null) {
            aVar.j();
        }
        com.opos.mobad.template.cmn.aa aaVar = this.q;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.n = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        this.n.setVisibility(4);
        if (this.n != null) {
            layoutParams.addRule(3, this.o.getId());
        }
        this.m.addView(this.n, layoutParams);
        b(aVar);
        g();
        h();
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        a(wVar);
        this.n.addView(wVar, layoutParams2);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "start countdown...");
        if (this.f9823a) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo2", "error state mDestroy " + this.f9823a);
            return;
        }
        this.p.b();
        com.opos.mobad.template.e.c.a aVar = this.v;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.p = ae.a(this.i, this.c, this.d, aVar);
        this.n.addView(this.p, new RelativeLayout.LayoutParams(this.c, this.d));
        this.p.a(new ae.a() { // from class: com.opos.mobad.template.g.o.6
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                o.this.s.removeCallbacks(o.this.z);
                o.this.s.postDelayed(o.this.z, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                o.this.s.removeCallbacks(o.this.z);
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        this.o.a(interfaceC0778a);
        this.p.a(interfaceC0778a);
        this.g.a(interfaceC0778a);
        this.g.a(new ab.a() { // from class: com.opos.mobad.template.g.o.3
            @Override // com.opos.mobad.template.g.ab.a
            public void a(int i) {
                o.this.p.a(i);
            }
        });
        ad adVar = this.l;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.l = ad.a(this.i, 9, this.r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        this.l.setId(View.generateViewId());
        this.l.setVisibility(4);
        wVar.addView(this.l, layoutParams);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        s sVar = this.o;
        if (sVar != null) {
            sVar.a(cVar, this.r, this.f9823a);
        }
        af afVar = this.g;
        if (afVar != null) {
            afVar.a(cVar.A);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007f A[PHI: r0 r3
      0x007f: PHI (r0v14 android.widget.RelativeLayout$LayoutParams) = (r0v5 android.widget.RelativeLayout$LayoutParams), (r0v15 android.widget.RelativeLayout$LayoutParams) binds: [B:17:0x007d, B:12:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x007f: PHI (r3v10 android.widget.RelativeLayout) = (r3v8 android.widget.RelativeLayout), (r3v17 android.widget.RelativeLayout) binds: [B:17:0x007d, B:12:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.opos.mobad.template.d.b bVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout;
        if (!this.w) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.i, e(), bVar.L);
            this.v = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.o.2
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (o.this.j != null) {
                        o.this.j.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (o.this.j != null) {
                        o.this.j.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (o.this.j != null) {
                        o.this.j.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (o.this.j != null) {
                        o.this.j.a(iArr);
                    }
                }
            });
            if (l()) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                if (this.v.c() != null && (relativeLayout = this.n) != null) {
                    relativeLayout.addView(this.v.c(), layoutParams);
                }
                if (this.v.c() != null && this.x != null) {
                    this.v.c().setId(View.generateViewId());
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                    layoutParams2.removeRule(9);
                    layoutParams2.removeRule(10);
                    layoutParams2.addRule(1, this.v.c().getId());
                    layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
                    layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                    this.x.setLayoutParams(layoutParams2);
                }
                this.w = true;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                if (this.v.c() != null && (relativeLayout = this.n) != null) {
                }
                if (this.v.c() != null) {
                    this.v.c().setId(View.generateViewId());
                    RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                    layoutParams22.removeRule(9);
                    layoutParams22.removeRule(10);
                    layoutParams22.addRule(1, this.v.c().getId());
                    layoutParams22.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
                    layoutParams22.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                    this.x.setLayoutParams(layoutParams22);
                }
                this.w = true;
            }
        }
        com.opos.mobad.template.e.c.a aVar = this.v;
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
        this.y = ak.a(cVarB);
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
        i();
        a(aVar);
        com.opos.mobad.template.cmn.p.a(this.m, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.o.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (o.this.j != null) {
                    o.this.j.h(view, iArr);
                }
            }
        });
        this.m.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.o.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                Log.e("BlockBigImageVideo2", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (o.this.j != null) {
                    o.this.j.a(view, i4, z);
                }
            }
        });
    }
}
