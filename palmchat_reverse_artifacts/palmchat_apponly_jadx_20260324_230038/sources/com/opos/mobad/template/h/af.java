package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.h.z;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class af extends com.opos.mobad.template.j.b {
    private int A;
    private com.opos.mobad.template.a.c B;
    private g C;
    private Runnable D;
    private com.opos.mobad.d.e.a E;
    private b F;
    private com.opos.mobad.template.cmn.baseview.f G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f9945a;
    private int b;
    private int c;
    private int g;
    private Context h;
    private com.opos.mobad.d.a i;
    private com.opos.mobad.template.cmn.baseview.c j;
    private e k;
    private ah l;
    private z m;
    private u n;
    private w o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private com.opos.mobad.template.cmn.baseview.c q;
    private Handler r;
    private com.opos.mobad.template.d.c s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private com.opos.mobad.template.e.c.a x;
    private boolean y;
    private boolean z;

    private af(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, boolean z) {
        super(i);
        this.f9945a = null;
        this.g = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.D = new Runnable() { // from class: com.opos.mobad.template.h.af.1
            @Override // java.lang.Runnable
            public void run() {
                if (af.this.n() == 8) {
                    return;
                }
                long jF = af.this.l.f();
                af.this.c(jF, af.this.l.g());
                af.this.a(jF);
                if (af.this.x != null && (af.this.x instanceof com.opos.mobad.template.e.c.e)) {
                    if (af.this.A == 3 && af.this.x.e() && af.this.x.c() != null && af.this.x.c().getVisibility() != 0) {
                        af.this.x.c().setVisibility(0);
                    }
                    if (af.this.A == 13 && af.this.x.e() && af.this.x.c() != null && af.this.x.c().getVisibility() != 8) {
                        af.this.x.c().setVisibility(8);
                    }
                    af.d(af.this);
                }
                af.this.r.postDelayed(this, 1000L);
            }
        };
        this.F = new b() { // from class: com.opos.mobad.template.h.af.10
            @Override // com.opos.mobad.template.h.b
            public void a() {
                if (af.this.s == null) {
                    return;
                }
                af afVar = af.this;
                afVar.a(afVar.s, af.this.l.b());
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(long j, long j2) {
                af.this.b(j, j2);
                if (af.this.n() != 8) {
                    af.this.r.removeCallbacks(af.this.D);
                    af.this.r.post(af.this.D);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(int i2) {
                af.this.b(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(long j, long j2) {
                if (j == 0) {
                    af.this.r.removeCallbacks(af.this.D);
                    af.this.r.postDelayed(af.this.D, 10L);
                    af.this.c(0L, r3.l.g());
                    af.this.r();
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void e(View view, int[] iArr) {
                af.this.a(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f() {
                af.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.template.h.af.10.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        af.this.u();
                        af.this.t();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void g(View view, int[] iArr) {
                af.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void h(View view, int[] iArr) {
                af.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void l(View view, int[] iArr) {
                af.this.k(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2) {
                af.this.a(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                af.this.e(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(long j, long j2) {
                af.this.a(j, j2);
                if (af.this.n() != 8) {
                    af.this.r.removeCallbacks(af.this.D);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
                af.this.f(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f(View view, int[] iArr) {
                af.this.i(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2, int[] iArr) {
                af.this.a(i2, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(Map<String, String> map) {
                if (af.this.n() != 8) {
                    af.this.r.removeCallbacks(af.this.D);
                }
                af.this.c(map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                af.this.d(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(long j, long j2) {
                af.this.o();
                af.this.r.removeCallbacks(af.this.D);
                af.this.s();
                if (af.this.x == null || !af.this.x.e()) {
                    return;
                }
                if (af.this.x instanceof com.opos.mobad.template.e.c.d) {
                    if (af.this.s.J.containsKey("EXT_PARAM_KEY_SHOW_ENDPAGE")) {
                        String str = af.this.s.J.get("EXT_PARAM_KEY_SHOW_ENDPAGE");
                        if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                            return;
                        }
                        af.this.x.f();
                        return;
                    }
                    return;
                }
                if (!(af.this.x instanceof com.opos.mobad.template.e.c.e) || af.this.x.c() == null || af.this.x.c().getVisibility() == 8) {
                    return;
                }
                af.this.x.c().setVisibility(8);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int i2, boolean z2) {
                af.this.a(view, i2, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr) {
                af.this.j(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr, boolean z2) {
                af.this.a(view, iArr, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(a.b bVar, Map<String, String> map) {
                af.this.a(bVar, map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(Map<String, String> map) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int[] iArr) {
                af.this.b(iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void j(View view, int[] iArr) {
            }
        };
        this.G = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.af.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardVideoTemplate", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                af.this.a(view, i2, z2);
            }
        };
        this.h = context;
        this.r = new Handler(Looper.getMainLooper());
        this.i = aVar2;
        boolean zA = com.opos.mobad.d.c.b.a(this.h);
        this.v = zA;
        z = zA ? true : z;
        this.w = z;
        a(z);
        a(aVar, z);
    }

    public static /* synthetic */ int d(af afVar) {
        int i = afVar.A;
        afVar.A = i + 1;
        return i;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        this.l.a();
        com.opos.mobad.template.e.c.a aVar = this.x;
        if (aVar == null || !(aVar instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar.i();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "do End");
        this.l.d();
        e eVar = this.k;
        if (eVar != null) {
            eVar.a();
        }
        g gVar = this.C;
        if (gVar != null) {
            gVar.a();
        }
        this.r.removeCallbacks(this.D);
        com.opos.mobad.template.e.c.a aVar = this.x;
        if (aVar != null) {
            aVar.j();
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.j;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    public static af a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new af(context, i, aVar, aVar2, true);
    }

    public static af b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new af(context, i, aVar, aVar2, false);
    }

    private void p() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.h);
        int iA = com.opos.cmn.an.h.f.a.a(this.h, 28.0f);
        LinearLayout linearLayout = new LinearLayout(this.h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
        layoutParams.weight = 1.0f;
        bVar.addView(linearLayout, layoutParams);
        u uVarA = u.a(this.h);
        this.n = uVarA;
        uVarA.setId(View.generateViewId());
        linearLayout.addView(this.n, new LinearLayout.LayoutParams(-2, iA));
        this.m = z.a(this.h);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        layoutParams2.rightMargin = this.c;
        bVar.addView(this.m, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.b;
        this.j.addView(bVar, layoutParams3);
    }

    private void q() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.h);
        this.q = cVar;
        cVar.setId(View.generateViewId());
        this.j.addView(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        w wVar = this.o;
        if (wVar == null) {
            return;
        }
        wVar.removeAllViews();
        this.j.removeView(this.o);
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.opos.mobad.template.d.c cVar = this.s;
        if (cVar != null && cVar.F == 1) {
            this.m.c();
            return;
        }
        this.n.setVisibility(8);
        this.m.setVisibility(4);
        e eVar = this.k;
        if (eVar != null) {
            eVar.setVisibility(8);
        }
        g gVar = this.C;
        if (gVar != null) {
            gVar.setVisibility(8);
        }
        com.opos.mobad.template.a.c cVar2 = this.B;
        if (cVar2 != null) {
            cVar2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.E == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.h);
            this.E = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.af.6
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (af.this.s == null) {
                        return;
                    }
                    if (!z) {
                        af.this.l();
                        return;
                    }
                    af.this.a(af.this.w ? com.opos.mobad.template.h.a(af.this.x, af.this.s) : com.opos.mobad.template.h.a(af.this.x));
                    af.this.k();
                    if (af.this.x == null || !(af.this.x instanceof com.opos.mobad.template.e.c.d) || af.this.x.c() == null || af.this.x.c().getVisibility() == 0) {
                        return;
                    }
                    af.this.x.c().setVisibility(0);
                }
            });
            this.E.a(new a.c() { // from class: com.opos.mobad.template.h.af.7
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardVideoTemplate", "onViewVisibleWithoutFocus: " + z + ", " + z2);
                    Map<String, String> mapA = com.opos.mobad.template.h.a(af.this.x);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    af.this.b(mapA);
                }
            }, c());
        }
        if (this.j.indexOfChild(this.E) < 0) {
            this.j.addView(this.E, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.setVisibility(0);
        }
        g gVar = this.C;
        if (gVar != null) {
            gVar.setVisibility(0);
        }
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.j;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "start countdown...");
        this.l.c();
        com.opos.mobad.template.e.c.a aVar = this.x;
        if (aVar == null || !(aVar instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar.h();
        return true;
    }

    private void b(com.opos.mobad.d.d.a aVar, boolean z) {
        c(aVar, z);
        p();
    }

    private void c(int i) {
        int iA;
        int i2;
        if (!this.z) {
            if (i == 2) {
                com.opos.mobad.template.d.a aVar = this.s.u;
                boolean z = (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) ? false : true;
                if (z) {
                    com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.h, Color.parseColor("#66FFFFFF"));
                    this.B = cVar;
                    cVar.setId(View.generateViewId());
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(5);
                    layoutParams.addRule(12);
                    layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
                    this.B.setGravity(3);
                    this.q.addView(this.B, layoutParams);
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS;
                } else {
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD;
                }
                this.C = g.a(this.h, this.i);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, 144.0f));
                if (z) {
                    layoutParams2.addRule(2, this.B.getId());
                } else {
                    layoutParams2.addRule(12);
                }
                this.q.addView(this.C, layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, i2));
                layoutParams3.addRule(12);
                layoutParams3.addRule(14);
                int iA2 = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
                this.q.setPadding(iA2, 0, iA2, iA2 * 2);
                this.j.updateViewLayout(this.q, layoutParams3);
            } else {
                this.k = e.a(this.h, this.w, this.i);
                int iA3 = this.w ? -1 : com.opos.cmn.an.h.f.a.a(this.h, 360.0f);
                this.q.addView(this.k, new RelativeLayout.LayoutParams(iA3, -1));
                int iA4 = com.opos.cmn.an.h.f.a.a(this.h, 62.0f);
                if (this.v || this.w) {
                    this.k.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_no_radius_bottom_bg);
                    iA = 0;
                } else {
                    iA = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
                    iA4 = iA4 + iA + com.opos.cmn.an.h.f.a.a(this.h, 4.0f);
                }
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA3, iA4);
                layoutParams4.addRule(12);
                layoutParams4.addRule(14);
                this.q.setPadding(0, 0, 0, iA);
                this.j.updateViewLayout(this.q, layoutParams4);
            }
            this.z = true;
        }
        com.opos.mobad.template.a.c cVar2 = this.B;
        if (cVar2 != null) {
            com.opos.mobad.template.d.a aVar2 = this.s.u;
            cVar2.a(aVar2.f9412a, aVar2.b);
            this.B.a(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.c cVar = this.s;
        if (cVar == null || this.u) {
            return;
        }
        long j2 = cVar.C;
        if (j2 <= 0 || j >= j2) {
            this.u = true;
            this.m.a();
        }
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        this.k.a(cVar.k, cVar.j, cVar.b, cVar.f9413a, this.i);
        this.k.a(cVar.p, cVar.e, cVar.g, cVar.f, cVar.h, cVar.i);
        this.k.a(cVar);
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (this.w) {
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.h, 66.0f);
                layoutParams2.height = com.opos.cmn.an.h.f.a.a(this.h, 66.0f);
                return;
            }
            layoutParams2.height = com.opos.cmn.an.h.f.a.a(this.h, 82.0f);
            com.opos.mobad.template.e.c.a aVar = this.x;
            if (aVar == null || !(aVar instanceof com.opos.mobad.template.e.c.e) || !aVar.e() || this.x.c() == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.x.c().getLayoutParams();
            int iB = com.opos.cmn.an.h.f.a.b(this.h);
            if (iB > 0) {
                layoutParams3.height = iB - layoutParams2.height;
            } else {
                layoutParams3.height = -2;
                layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 13.0f);
            }
        }
    }

    private void c(com.opos.mobad.d.d.a aVar, boolean z) {
        this.p = new com.opos.mobad.template.cmn.baseview.c(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.l = ah.a(this.h, aVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (z) {
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.h, 62.0f);
        }
        if (z && !this.v) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 94.0f);
            aVar.c(1);
        }
        this.p.addView(this.l, layoutParams2);
        this.j.addView(this.p, layoutParams);
    }

    private void a(com.opos.mobad.d.d.a aVar, boolean z) {
        this.j = new com.opos.mobad.template.cmn.baseview.c(this.h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.j.setId(View.generateViewId());
        this.j.setBackgroundColor(Color.parseColor("#000000"));
        this.j.setLayoutParams(layoutParams);
        this.j.setVisibility(8);
        b(aVar, z);
        q();
        b(z);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.af.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                af.this.h(view, iArr);
            }
        };
        this.j.setOnClickListener(pVar);
        this.j.setOnTouchListener(pVar);
        this.j.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.af.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardVideoTemplate", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                af.this.a(view, i, z2);
            }
        });
        if (Build.VERSION.SDK_INT >= 29) {
            this.j.setForceDarkAllowed(false);
        }
    }

    private void b(boolean z) {
        this.o = z ? w.a(this.h) : w.b(this.h);
        this.j.addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        this.n.a(cVar.q, cVar.B);
        this.m.a(cVar.A);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.m.a(this.F);
        this.l.a(this.F);
        this.n.a(this.F);
        w wVar = this.o;
        if (wVar != null) {
            wVar.a(this.F);
        }
        this.m.a(new z.a() { // from class: com.opos.mobad.template.h.af.3
            @Override // com.opos.mobad.template.h.z.a
            public void a(int i) {
                af.this.l.a(i);
            }
        });
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        RelativeLayout.LayoutParams layoutParams;
        Context context;
        float f;
        if (!this.y) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.h, e(), bVar.L);
            this.x = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.h.af.8
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) af.this).e != null) {
                        ((com.opos.mobad.template.j.a) af.this).e.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) af.this).e != null) {
                        ((com.opos.mobad.template.j.a) af.this).e.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) af.this).e != null) {
                        ((com.opos.mobad.template.j.a) af.this).e.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (((com.opos.mobad.template.j.a) af.this).e != null) {
                        ((com.opos.mobad.template.j.a) af.this).e.a(iArr);
                    }
                }
            });
            com.opos.mobad.template.e.c.a aVar = this.x;
            if (aVar instanceof com.opos.mobad.template.e.c.e) {
                if (this.w) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                } else {
                    int iB = com.opos.cmn.an.h.f.a.b(this.h);
                    if (iB > 0) {
                        layoutParams = new RelativeLayout.LayoutParams(-2, iB - com.opos.cmn.an.h.f.a.a(this.h, 92.0f));
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
                    }
                    layoutParams.addRule(14);
                }
                if (this.x.e() && this.x.c() != null) {
                    this.x.a(this.G);
                    this.j.addView(this.x.c(), layoutParams);
                }
                this.y = true;
            } else {
                if (aVar instanceof com.opos.mobad.template.e.c.d) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, 46.0f));
                    if (this.w) {
                        context = this.h;
                        f = 23.0f;
                    } else {
                        context = this.h;
                        f = 11.0f;
                    }
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, f);
                    layoutParams.addRule(2, this.q.getId());
                    layoutParams.addRule(14);
                    if (this.x.e() && this.x.c() != null) {
                        this.j.addView(this.x.c(), layoutParams);
                    }
                }
                this.y = true;
            }
        }
        com.opos.mobad.template.e.c.a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        c(cVar);
        if (this.g == 2) {
            this.C.a(cVar);
            this.C.a(this.F);
        } else {
            e eVar = this.k;
            if (eVar != null) {
                eVar.a(this.F);
                b(cVar);
            }
        }
        a((com.opos.mobad.template.d.b) cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.c cVar, com.opos.mobad.d.d.a aVar) {
        if (this.f9945a != null) {
            this.p.setBackground(new BitmapDrawable(this.f9945a));
        } else {
            com.opos.mobad.template.cmn.af.a(aVar, cVar.N.f9414a, new af.a() { // from class: com.opos.mobad.template.h.af.9
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(Bitmap bitmap) {
                    if (af.this.n() == 8) {
                        return;
                    }
                    af afVar = af.this;
                    afVar.f9945a = com.opos.mobad.template.cmn.f.a(afVar.h, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.af.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (af.this.n() == 8) {
                                return;
                            }
                            af.this.p.setBackground(new BitmapDrawable(af.this.f9945a));
                        }
                    });
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("RewardVideoTemplate", "data is null");
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null) {
                if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.s == null) {
                    this.l.a(cVarB);
                }
                this.s = cVarB;
                com.opos.mobad.template.cmn.baseview.c cVar = this.j;
                if (cVar != null && cVar.getVisibility() != 0) {
                    this.j.setVisibility(0);
                }
                if (this.w && com.opos.mobad.template.h.a(cVarB)) {
                    this.g = 2;
                    c(2);
                } else {
                    c(0);
                }
                a(cVarB);
                return;
            }
            com.opos.cmn.an.f.a.d("RewardVideoTemplate", "render with data null");
        }
        a(1);
    }

    private void a(boolean z) {
        Context context;
        float f = 16.0f;
        if (z) {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 49.0f);
            context = this.h;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
            context = this.h;
            f = 24.0f;
        }
        this.c = com.opos.cmn.an.h.f.a.a(context, f);
    }
}
