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
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.h.z;
import com.wifi.adsdk.utils.LxAdSystemBarTintManager;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ab extends com.opos.mobad.template.j.b {
    private boolean A;
    private Runnable B;
    private com.opos.mobad.d.e.a C;
    private b D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f9920a;
    private int b;
    private int c;
    private Context g;
    private com.opos.mobad.d.a h;
    private com.opos.mobad.template.cmn.baseview.c i;
    private e j;
    private ah k;
    private z l;
    private u m;
    private w n;
    private com.opos.mobad.template.cmn.baseview.c o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private com.opos.mobad.template.cmn.baseview.c q;
    private Handler r;
    private com.opos.mobad.template.d.c s;
    private boolean t;
    private boolean u;
    private boolean v;
    private com.opos.mobad.template.a.e w;
    private boolean x;
    private boolean y;
    private com.opos.mobad.template.e.c.a z;

    private ab(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, boolean z) {
        super(i);
        this.f9920a = null;
        this.t = false;
        this.u = false;
        this.v = true;
        this.x = false;
        this.y = false;
        this.A = false;
        this.B = new Runnable() { // from class: com.opos.mobad.template.h.ab.1
            @Override // java.lang.Runnable
            public void run() {
                if (ab.this.n() == 8) {
                    return;
                }
                int iF = ab.this.k.f();
                long j = iF;
                ab.this.c(j, ab.this.k.g());
                ab.this.a(j);
                if (ab.this.w == null || ab.this.y || Math.round(((double) iF) / 1000.0d) < 3 || ab.this.w.c() == null) {
                    ab.this.r.postDelayed(this, 1000L);
                } else {
                    ab.this.y();
                }
            }
        };
        this.D = new b() { // from class: com.opos.mobad.template.h.ab.9
            @Override // com.opos.mobad.template.h.b
            public void a() {
                if (ab.this.s == null) {
                    return;
                }
                ab abVar = ab.this;
                abVar.a(abVar.s, ab.this.k.b());
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(long j, long j2) {
                ab.this.b(j, j2);
                if (ab.this.n() != 8) {
                    ab.this.r.removeCallbacks(ab.this.B);
                    ab.this.r.post(ab.this.B);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(int i2) {
                ab.this.b(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(long j, long j2) {
                if (j == 0) {
                    ab.this.r.removeCallbacks(ab.this.B);
                    ab.this.r.postDelayed(ab.this.B, 10L);
                    ab.this.c(0L, r3.k.g());
                    ab.this.u();
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void e(View view, int[] iArr) {
                ab.this.a(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f() {
                ab.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.template.h.ab.9.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        ab.this.x();
                        ab.this.w();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void g(View view, int[] iArr) {
                ab.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void h(View view, int[] iArr) {
                ab.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void l(View view, int[] iArr) {
                ab.this.k(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2) {
                ab.this.a(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                ab.this.e(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(long j, long j2) {
                ab.this.a(j, j2);
                if (ab.this.n() != 8) {
                    ab.this.r.removeCallbacks(ab.this.B);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
                ab.this.f(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f(View view, int[] iArr) {
                ab.this.i(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2, int[] iArr) {
                ab.this.a(i2, iArr);
                if (i2 == 7) {
                    ab.this.z();
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(Map<String, String> map) {
                if (ab.this.n() != 8) {
                    ab.this.r.removeCallbacks(ab.this.B);
                }
                ab.this.c(map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                ab.this.d(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(long j, long j2) {
                ab.this.o();
                ab.this.r.removeCallbacks(ab.this.B);
                ab.this.v();
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int i2, boolean z2) {
                ab.this.a(view, i2, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr) {
                ab.this.j(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr, boolean z2) {
                ab.this.a(view, iArr, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(a.b bVar, Map<String, String> map) {
                ab.this.a(bVar, map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(Map<String, String> map) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int[] iArr) {
                ab.this.b(iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void j(View view, int[] iArr) {
            }
        };
        this.g = context;
        this.r = new Handler(Looper.getMainLooper());
        this.h = aVar2;
        boolean zA = com.opos.mobad.d.c.b.a(this.g);
        this.u = zA;
        z = zA ? true : z;
        this.v = z;
        a(z);
        a(aVar, z);
    }

    private void r() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.g);
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 28.0f);
        LinearLayout linearLayout = new LinearLayout(this.g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        layoutParams.weight = 1.0f;
        bVar.addView(linearLayout, layoutParams);
        u uVarA = u.a(this.g);
        this.m = uVarA;
        uVarA.setId(View.generateViewId());
        linearLayout.addView(this.m, new LinearLayout.LayoutParams(-2, iA));
        this.l = z.a(this.g);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        layoutParams2.rightMargin = this.c;
        bVar.addView(this.l, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.b;
        this.i.addView(bVar, layoutParams3);
    }

    private void s() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.g);
        this.p = cVar;
        cVar.setId(View.generateViewId());
        this.i.addView(this.p);
    }

    private void t() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.g);
        this.q = cVar;
        cVar.setBackgroundColor(LxAdSystemBarTintManager.DEFAULT_TINT_COLOR);
        this.q.setVisibility(4);
        this.q.setClickable(true);
        this.i.addView(this.q, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        w wVar = this.n;
        if (wVar == null) {
            return;
        }
        wVar.removeAllViews();
        this.i.removeView(this.n);
        this.n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.opos.mobad.template.d.c cVar = this.s;
        if (cVar != null && cVar.F == 1) {
            this.l.c();
            return;
        }
        this.m.setVisibility(8);
        this.l.setVisibility(4);
        e eVar = this.j;
        if (eVar != null) {
            eVar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.C == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
            this.C = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.ab.5
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    com.opos.cmn.an.f.a.b("RewardVideoEcTemplate", "onViewVisibile() isViewVisible=", Boolean.valueOf(z));
                    if (ab.this.s == null) {
                        return;
                    }
                    if (!z) {
                        ab.this.l();
                        return;
                    }
                    ab.this.a(com.opos.mobad.template.h.a(ab.this.z));
                    if (ab.this.w.c().getVisibility() != 0) {
                        ab.this.k();
                    }
                }
            });
            this.C.a(new a.c() { // from class: com.opos.mobad.template.h.ab.6
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardVideoEcTemplate", "onViewVisibleWithoutFocus() isVisibleRect=", Boolean.valueOf(z), "isAttachedToWindow=", Boolean.valueOf(z2));
                    if (ab.this.s == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.template.h.a(ab.this.z);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    ab.this.b(mapA);
                }
            }, c());
        }
        if (this.i.indexOfChild(this.C) < 0) {
            this.i.addView(this.C, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        e eVar = this.j;
        if (eVar != null) {
            eVar.setVisibility(0);
        }
        this.m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Map<String, String> map;
        com.opos.mobad.template.d.c cVar = this.s;
        if (cVar != null && (map = cVar.J) != null && TextUtils.equals(map.get("EXT_PARAM_KEY_COUNTDOWN"), "0")) {
            this.y = true;
            this.w.c().setVisibility(4);
            com.opos.mobad.template.e.c.a aVar = this.z;
            if (aVar != null && aVar.e() && this.z.c() != null) {
                this.z.c().setVisibility(4);
            }
            this.q.setVisibility(4);
            this.l.b(0);
            return;
        }
        if (this.w.c().getVisibility() != 0) {
            this.y = true;
            this.q.setVisibility(0);
            this.w.c().setVisibility(0);
            com.opos.mobad.template.e.c.a aVar2 = this.z;
            if (aVar2 != null && aVar2.e() && this.z.c() != null && this.z.c().getVisibility() != 0) {
                this.z.c().setVisibility(0);
            }
            this.l.a();
            this.l.b(1);
            l();
            this.D.a(a.b.E_COMMERCE_DIALOG_SHOW, (Map<String, String>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.w.c().getVisibility() == 0) {
            k();
            this.w.c().setVisibility(4);
            com.opos.mobad.template.e.c.a aVar = this.z;
            if (aVar != null && aVar.e() && this.z.c() != null) {
                this.z.c().setVisibility(4);
            }
            this.q.setVisibility(4);
            this.l.b(0);
            this.D.a(a.b.E_COMMERCE_DIALOG_CLOSE, (Map<String, String>) null);
            if (this.t) {
                return;
            }
            this.l.b();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.i;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("RewardVideoEcTemplate", "doEnd()");
        this.k.d();
        e eVar = this.j;
        if (eVar != null) {
            eVar.a();
        }
        com.opos.mobad.template.a.e eVar2 = this.w;
        if (eVar2 != null) {
            eVar2.g();
        }
        this.r.removeCallbacks(this.B);
        com.opos.mobad.template.cmn.baseview.c cVar = this.i;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    public static ab a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ab(context, i, aVar, aVar2, true);
    }

    public static ab b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ab(context, i, aVar, aVar2, false);
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        this.m.a(cVar.q, cVar.B);
        this.l.a(cVar.A);
    }

    private void p() {
        int iA;
        if (this.x) {
            return;
        }
        this.j = e.a(this.g, this.v, this.h);
        int iA2 = this.v ? -1 : com.opos.cmn.an.h.f.a.a(this.g, 360.0f);
        this.p.addView(this.j, new RelativeLayout.LayoutParams(iA2, -1));
        int iA3 = com.opos.cmn.an.h.f.a.a(this.g, 62.0f);
        if (this.u || this.v) {
            this.j.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_no_radius_bottom_bg);
            iA = 0;
        } else {
            iA = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
            iA3 = iA3 + iA + com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA2, iA3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.p.setPadding(0, 0, 0, iA);
        this.i.updateViewLayout(this.p, layoutParams);
        this.x = true;
    }

    private void q() {
        this.w = new com.opos.mobad.template.a.e(this.g, this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (this.w.c() != null) {
            this.i.addView(this.w.c(), layoutParams);
        }
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.cmn.an.f.a.b("RewardVideoEcTemplate", "doStart()");
        this.k.c();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.cmn.an.f.a.b("RewardVideoEcTemplate", "doStop()");
        this.k.a();
        return true;
    }

    private void b(com.opos.mobad.d.d.a aVar, boolean z) {
        this.o = new com.opos.mobad.template.cmn.baseview.c(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.k = ah.a(this.g, aVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (z) {
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 62.0f);
        }
        if (z && !this.u) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 94.0f);
            aVar.c(1);
        }
        this.o.addView(this.k, layoutParams2);
        this.i.addView(this.o, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.c cVar = this.s;
        if (cVar == null || this.t) {
            return;
        }
        long j2 = cVar.C;
        if (j2 <= 0 || j >= j2) {
            this.t = true;
            this.l.a();
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.A) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.g, e(), bVar.L);
            this.z = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.h.ab.7
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    ab.this.i().a(i, iArr);
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    ab.this.i().g(view, iArr);
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    ab.this.i().h(view, iArr);
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    ab.this.i().a(iArr);
                }
            });
            this.A = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.z;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.d.d.a aVar, boolean z) {
        this.i = new com.opos.mobad.template.cmn.baseview.c(this.g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.i.setId(View.generateViewId());
        this.i.setBackgroundColor(Color.parseColor("#000000"));
        this.i.setLayoutParams(layoutParams);
        this.i.setVisibility(8);
        b(aVar, z);
        s();
        t();
        r();
        b(z);
        q();
        com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.ab.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ab.this.h(view, iArr);
            }
        });
        this.i.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.ab.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardVideoEcTemplate", "onMockEventIntercepted->mockEvent=", Integer.valueOf(i), "disAllowClick=", Boolean.valueOf(z2), "view=", view.getClass().getName());
                ab.this.a(view, i, z2);
            }
        });
        if (Build.VERSION.SDK_INT >= 29) {
            this.i.setForceDarkAllowed(false);
        }
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        int iA;
        this.j.a(cVar.k, cVar.j, cVar.b, cVar.f9413a, this.h);
        this.j.a(cVar.p, cVar.e, cVar.g, cVar.f, cVar.h, cVar.i);
        this.j.a(cVar);
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (this.v) {
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 66.0f);
                iA = com.opos.cmn.an.h.f.a.a(this.g, 66.0f);
            } else {
                iA = com.opos.cmn.an.h.f.a.a(this.g, 82.0f);
            }
            layoutParams2.height = iA;
        }
    }

    private void b(boolean z) {
        this.n = z ? w.a(this.g) : w.b(this.g);
        this.i.addView(this.n, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.l.a(this.D);
        this.k.a(this.D);
        this.m.a(this.D);
        this.w.a(this.D);
        w wVar = this.n;
        if (wVar != null) {
            wVar.a(this.D);
        }
        this.l.a(new z.a() { // from class: com.opos.mobad.template.h.ab.2
            @Override // com.opos.mobad.template.h.z.a
            public void a(int i) {
                ab.this.k.a(i);
            }
        });
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (this.w != null) {
            if (bVar.J.containsKey("EXT_PARAM_KEY_E_COMMERCE_DIALOG_CLOSE") && TextUtils.equals(bVar.J.get("EXT_PARAM_KEY_E_COMMERCE_DIALOG_CLOSE"), "1")) {
                z();
            }
            b(bVar);
            this.w.a(this.z);
            if (this.w.c().getVisibility() != 0) {
                return;
            }
            String str = bVar.J.containsKey("EXT_PARAM_KEY_E_COMMERCE_DIALOG_COUNTDOWN") ? bVar.J.get("EXT_PARAM_KEY_E_COMMERCE_DIALOG_COUNTDOWN") : "0";
            if (str.equals("0")) {
                this.l.b(2);
            }
            this.w.a(str, bVar.k, bVar.b, bVar.f9413a, this.h);
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        c(cVar);
        e eVar = this.j;
        if (eVar != null) {
            eVar.a(this.D);
            b(cVar);
        }
        a((com.opos.mobad.template.d.b) cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.c cVar, com.opos.mobad.d.d.a aVar) {
        if (this.f9920a != null) {
            this.o.setBackground(new BitmapDrawable(this.f9920a));
        } else {
            com.opos.mobad.template.cmn.af.a(aVar, cVar.N.f9414a, new af.a() { // from class: com.opos.mobad.template.h.ab.8
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(Bitmap bitmap) {
                    if (ab.this.n() == 8) {
                        return;
                    }
                    ab abVar = ab.this;
                    abVar.f9920a = com.opos.mobad.template.cmn.f.a(abVar.g, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.ab.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ab.this.n() == 8) {
                                return;
                            }
                            ab.this.o.setBackground(new BitmapDrawable(ab.this.f9920a));
                        }
                    });
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("RewardVideoEcTemplate", "render() but adShowData is null.");
            a(1);
            return;
        }
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.a("RewardVideoEcTemplate", "render() but adVideoShowData is null.");
            a(1);
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.s == null) {
            this.k.a(cVarB);
        }
        this.s = cVarB;
        com.opos.mobad.template.cmn.baseview.c cVar = this.i;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
        p();
        a(cVarB);
    }

    private void a(boolean z) {
        Context context;
        float f = 16.0f;
        if (z) {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 49.0f);
            context = this.g;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
            context = this.g;
            f = 24.0f;
        }
        this.c = com.opos.cmn.an.h.f.a.a(context, f);
    }
}
