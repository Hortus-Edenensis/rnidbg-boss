package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.e;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s implements com.opos.mobad.template.a {
    private long A;
    private d C;
    private j D;
    private com.opos.mobad.d.a E;
    private com.opos.mobad.template.e.c.a G;
    private com.opos.mobad.template.i.b.a I;
    private Context b;
    private a.InterfaceC0778a c;
    private com.opos.mobad.template.d.c d;
    private com.opos.mobad.d.d.a e;
    private int f;
    private int g;
    private RelativeLayout i;
    private com.opos.mobad.template.cmn.baseview.c j;
    private View k;
    private ImageView l;
    private View m;
    private View n;
    private View o;
    private com.opos.mobad.template.a.b p;
    private com.opos.mobad.template.a.c q;
    private View r;
    private com.opos.mobad.template.e s;
    private Drawable u;
    private Drawable v;
    private long z;
    private boolean h = false;
    private long t = -1;
    private volatile int w = 0;
    private volatile int x = 0;
    private boolean B = false;
    private boolean F = false;
    private boolean H = false;
    private Runnable J = new Runnable() { // from class: com.opos.mobad.template.i.s.1
        @Override // java.lang.Runnable
        public void run() {
            if (s.this.w == 6) {
                return;
            }
            if (s.this.t <= 0) {
                s.this.c.d(s.this.z - s.this.t, s.this.A);
                s.this.y.a();
                s.this.a();
                s.this.z();
                s.this.B();
                return;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "countdown=" + s.this.t);
            s.this.y.a(1000L);
            if (s.this.s != null) {
                s.this.s.a((int) (s.this.t / 1000));
            }
            s.this.c.d(s.this.z - s.this.t, s.this.A);
            s.this.t -= 1000;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10149a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.s.6
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            s.this.p();
            if (s.this.c != null) {
                s.this.c.g(view, iArr);
            }
        }
    };
    private com.opos.mobad.d.d.b K = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.i.s.4
        private void a(long j) {
            String str;
            if (j <= 0) {
                str = "error video duration";
            } else {
                s sVar = s.this;
                sVar.t = Math.min(j, sVar.t);
                s sVar2 = s.this;
                sVar2.z = sVar2.t;
                str = "resetVideoDurationIfNeed ori = " + j + ",after =" + s.this.z;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        }

        @Override // com.opos.mobad.d.d.b
        public void d() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onStart");
            s.this.w = 2;
            s.this.x = 0;
            s sVar = s.this;
            sVar.A = sVar.e.c();
            a(s.this.A);
            s.this.y.a(0L);
            s.this.y();
        }

        @Override // com.opos.mobad.d.d.b
        public void e() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video complete");
        }

        @Override // com.opos.mobad.d.d.b
        public void f() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onResume");
            s.this.w = 2;
            s.this.x = 0;
        }

        @Override // com.opos.mobad.d.d.b
        public void g() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onPause");
            s.this.w = 3;
        }

        @Override // com.opos.mobad.d.d.b
        public void a(Map<String, String> map) {
            s.this.w = 4;
            s.this.a();
            s.this.z();
            if (s.this.c != null) {
                s.this.c.b(map);
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void c() {
        }

        @Override // com.opos.mobad.d.d.b
        public void h() {
        }

        @Override // com.opos.mobad.d.d.b
        public void i() {
        }

        @Override // com.opos.mobad.d.d.b
        public void j() {
        }
    };
    private com.opos.mobad.d.c.d y = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), this.J);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.d.e.a {
        public a(Context context) {
            super(context);
        }

        @Override // com.opos.mobad.d.e.a, android.view.View
        public void onWindowVisibilityChanged(int i) {
            super.onWindowVisibilityChanged(i);
            s.this.b(i == 0);
        }
    }

    public s(Context context, int i, com.opos.mobad.d.d.a aVar, int i2, j jVar, com.opos.mobad.d.a aVar2) {
        this.D = j.NONE;
        this.b = context;
        this.D = a(jVar);
        this.g = i2;
        this.f = i;
        this.e = aVar;
        aVar.a(this.K);
        this.e.d(0);
        this.e.c(3);
        this.e.a(0.0f);
        this.E = aVar2;
        h();
        g();
    }

    private boolean A() {
        return this.w == 5 || this.w == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (C()) {
            com.opos.cmn.an.f.a.b("SplashVideo", "handleAdClosed");
            a.InterfaceC0778a interfaceC0778a = this.c;
            if (interfaceC0778a != null) {
                long j = this.z;
                interfaceC0778a.a(j, j);
            }
        }
    }

    private boolean C() {
        View viewC = c();
        return viewC != null && viewC.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.opos.mobad.template.d.e eVar;
        com.opos.cmn.an.f.a.b("SplashVideo", "start to play video");
        com.opos.mobad.template.d.c cVar = this.d;
        if (cVar == null || (eVar = cVar.N) == null) {
            return;
        }
        this.e.a(eVar.f9414a);
        this.e.e();
    }

    private boolean E() {
        return this.g == 0;
    }

    private void h() {
        GradientDrawable gradientDrawable;
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.i = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.i.setVisibility(4);
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.j = cVar;
        cVar.setBackgroundColor(-1);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.s.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                s.this.p();
                if (s.this.c != null) {
                    s.this.c.f(view, iArr);
                }
            }
        };
        this.j.setOnTouchListener(pVar);
        this.j.setOnClickListener(pVar);
        this.j.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.i.s.10
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("SplashVideo", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (s.this.c != null) {
                    s.this.c.a(view, i, z);
                }
            }
        });
        View viewB = this.e.b();
        this.k = viewB;
        viewB.setVisibility(0);
        if (E()) {
            com.opos.mobad.template.a.c cVar2 = new com.opos.mobad.template.a.c(this.b);
            this.q = cVar2;
            cVar2.setVisibility(4);
            this.r = new FrameLayout(this.b);
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 855638016});
        } else {
            com.opos.mobad.template.a.b bVar = new com.opos.mobad.template.a.b(this.b);
            this.p = bVar;
            bVar.setVisibility(4);
            this.r = new FrameLayout(this.b);
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        }
        gradientDrawable.setGradientType(0);
        this.r.setBackground(gradientDrawable);
        this.r.setVisibility(4);
        i();
        j();
    }

    private void i() {
        int i = this.g;
        int i2 = i != 1 ? i != 2 ? 6 : 8 : 7;
        com.opos.mobad.template.i.b.a aVar = new com.opos.mobad.template.i.b.a(this.b, e());
        this.I = aVar;
        aVar.setId(View.generateViewId());
        this.I.setVisibility(4);
        this.C = E() ? i.b(this.b, this.D, i2) : i.a(this.b, this.D, i2);
        this.C.a(new c() { // from class: com.opos.mobad.template.i.s.11
            @Override // com.opos.mobad.template.c
            public void a(int[] iArr) {
                if (s.this.c != null) {
                    s.this.c.a(iArr);
                }
            }

            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (s.this.c != null) {
                    s.this.c.g(view, iArr);
                }
            }
        });
        this.C.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.i.s.12
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z) {
                com.opos.cmn.an.f.a.a("SplashVideo", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (s.this.c != null) {
                    s.this.c.a(view, i3, z);
                }
            }
        });
    }

    private void j() {
        ImageView imageView = new ImageView(this.b);
        this.l = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u = this.b.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off);
        this.v = this.b.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_on);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 7.0f);
        this.l.setPadding(iA, iA2, iA, iA2);
        this.l.setImageDrawable(this.u);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.template.i.s.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.this.f();
            }
        });
        this.l.setVisibility(4);
    }

    private void l() {
        d dVar = this.C;
        if (dVar == null || dVar.a() == null) {
            return;
        }
        View viewA = this.C.a();
        viewA.setVisibility(8);
        this.j.removeView(viewA);
    }

    private RelativeLayout.LayoutParams m() {
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 26.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 33.0f);
        int iA3 = com.opos.cmn.an.h.f.a.a(this.b, 22.0f);
        if (this.d.m == 0) {
            iA3 = ((iA3 * 5) / 3) + com.opos.cmn.an.h.f.a.a(this.b, 64.0f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA3;
        return layoutParams;
    }

    private int n() {
        int i = this.g;
        return com.opos.cmn.an.h.f.a.a(this.b, i != 1 ? i != 2 ? 16 : 15 : 30);
    }

    private int o() {
        return this.g == 2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar != null) {
            aVar.i();
            return;
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.G != null) {
            if (this.I != null && com.opos.mobad.template.i.a.a.e(this.f)) {
                this.I.g();
            }
            this.G.g();
            return;
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.c();
        }
    }

    private void u() {
        if (this.G != null) {
            v();
            return;
        }
        d dVar = this.C;
        if (dVar == null || dVar.a() == null) {
            return;
        }
        this.C.a().setVisibility(0);
    }

    private void v() {
        boolean zC = com.opos.mobad.template.i.a.a.c(this.f);
        boolean zE = this.G.e();
        if (zC && !zE) {
            w();
            if (this.G.c() != null) {
                this.G.c().setVisibility(8);
                return;
            }
            return;
        }
        if (zE) {
            if (this.G.c() != null) {
                this.G.c().setVisibility(0);
            }
            if (zC) {
                x();
            } else {
                w();
            }
        }
    }

    private void w() {
        com.opos.mobad.template.i.b.a aVar = this.I;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(0);
        com.opos.mobad.template.cmn.p.a(this.I.a(), this.f10149a);
    }

    private void x() {
        com.opos.mobad.template.i.b.a aVar = this.I;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.k.setVisibility(0);
        this.r.setVisibility(0);
        u();
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        (E() ? this.q : this.p).setVisibility(0);
        this.l.setVisibility(0);
        this.j.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            if (A()) {
                com.opos.cmn.an.f.a.b("SplashVideo", "video player has release");
                return;
            }
            final com.opos.mobad.d.d.a aVar = this.e;
            if (aVar != null) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.i.s.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
                            aVar.h();
                        }
                    }
                });
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
            this.w = 5;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SplashVideo", "releaseVideoPlayer", e);
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.f;
    }

    private void g() {
        final a aVar = new a(this.b);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.i.s.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("SplashVideo", "isViewVisible = " + z);
                if (s.this.d == null) {
                    return;
                }
                s sVar = s.this;
                if (z) {
                    if (sVar.F) {
                        s.this.q();
                    }
                    if (s.this.w == 0) {
                        s.this.F = true;
                        s.this.w = 1;
                        s.this.D();
                        s.this.t();
                        if (s.this.c != null) {
                            s.this.c.a(com.opos.mobad.template.h.a(s.this.G));
                        }
                    } else if (s.this.w == 3 && com.opos.mobad.template.i.a.b.f(s.this.b)) {
                        s.this.b(z);
                    }
                } else {
                    if (sVar.w == 2 && !com.opos.mobad.template.i.a.b.f(s.this.b)) {
                        s.this.x = 0;
                        s.this.b(z);
                    }
                    s.this.r();
                }
                com.opos.cmn.an.f.a.b("SplashVideo", "splashView onWindowVisibilityChanged：" + z);
                boolean z2 = s.this.t <= 0 || s.this.w == 4;
                if (z && z2) {
                    s.this.B();
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.i.s.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (s.this.c != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(s.this.G);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    s.this.c.a(mapA);
                    com.opos.cmn.an.f.a.b("SplashVideo", "splashView onViewVisibleWithoutFocus：" + z + ", " + z2);
                    if (s.this.t <= 0 || s.this.w == 4) {
                        aVar.a((a.c) null, (View) null);
                    }
                }
            }
        }, c());
        this.i.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int i = this.g;
        int i2 = i != 1 ? i != 2 ? 78 : 37 : 79;
        if (this.D != j.SLIDE_UP) {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, i2);
        }
        if (this.j.indexOfChild(this.C.a()) < 0) {
            this.j.addView(this.C.a(), layoutParams);
        } else {
            this.j.updateViewLayout(this.C.a(), layoutParams);
        }
        if (this.G != null) {
            l();
            if (!com.opos.mobad.template.i.a.a.c(this.f)) {
                if (this.G.e()) {
                    a(b(i2), i2);
                }
            } else if (this.G.e()) {
                a(layoutParams);
            } else {
                a(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar == null) {
            d dVar = this.C;
            if (dVar != null) {
                dVar.b();
                return;
            }
            return;
        }
        aVar.d();
        if (this.I == null || !com.opos.mobad.template.i.a.a.f(this.f)) {
            return;
        }
        this.I.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar != null) {
            aVar.h();
            return;
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.e();
        }
    }

    private void s() {
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar != null) {
            aVar.j();
            return;
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.i;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("SplashVideo", "destroy");
        s();
        a();
        z();
        this.d = null;
        this.w = 6;
        this.y.a();
        this.y.b();
    }

    public void f() {
        this.h = !this.h;
        com.opos.cmn.an.f.a.b("SplashVideo", "VolumeSwitchIconClicked: " + this.h);
        a(this.h);
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, j jVar, com.opos.mobad.d.a aVar2) {
        return new s(context, i, aVar, 0, jVar, aVar2);
    }

    private RelativeLayout.LayoutParams b(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, i);
        return layoutParams;
    }

    public static final com.opos.mobad.template.a c(Context context, int i, com.opos.mobad.d.d.a aVar, j jVar, com.opos.mobad.d.a aVar2) {
        return new s(context, i, aVar, 2, jVar, aVar2);
    }

    private j a(j jVar) {
        j jVar2 = j.NONE;
        return (jVar == jVar2 || com.opos.mobad.template.h.a()) ? jVar : jVar2;
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, j jVar, com.opos.mobad.d.a aVar2) {
        return new s(context, i, aVar, 1, jVar, aVar2);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.cmn.an.f.a.b("SplashVideo", "stop countdown...");
        if (this.w == 3 || A() || this.w == 4) {
            com.opos.cmn.an.f.a.b("SplashVideo", "current state has stop =" + this.w);
            return;
        }
        this.y.a();
        this.e.f();
        this.x = 1;
        r();
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("SplashVideo", "start countdown...");
        if (this.w != 1 && this.w != 2 && !A() && this.w != 4) {
            this.y.a(0L);
            this.e.g();
            q();
        } else {
            com.opos.cmn.an.f.a.b("SplashVideo", "error state" + this.w);
        }
    }

    private void a(int i) {
        if (this.I != null) {
            RelativeLayout.LayoutParams layoutParamsB = b(i);
            layoutParamsB.addRule(12);
            if (this.I.getParent() != null) {
                ((ViewGroup) this.I.getParent()).removeView(this.I);
            }
            this.j.addView(this.I, layoutParamsB);
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.H) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.b, e(), bVar.L);
            this.G = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.i.s.3
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (s.this.c != null) {
                        s.this.c.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (s.this.c != null) {
                        s.this.c.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (s.this.c != null) {
                        s.this.c.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (s.this.c != null) {
                        s.this.c.a(iArr);
                    }
                }
            });
            this.H = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.j.indexOfChild(view) < 0) {
            this.j.addView(view, layoutParams);
        } else {
            this.j.updateViewLayout(view, layoutParams);
        }
    }

    private void a(RelativeLayout.LayoutParams layoutParams) {
        View viewC = this.G.c();
        if (viewC != null) {
            a(viewC, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.B == z) {
            com.opos.cmn.an.f.a.b("SplashVideo", "view visbile not change");
            return;
        }
        this.B = z;
        try {
            com.opos.cmn.an.f.a.b("SplashVideo", "onWindowVisibilityChanged isViewVisible= " + z + "," + this.w + "," + this.x);
            if (this.w != 0 && !A()) {
                if (!z) {
                    if (this.w != 3 && this.w != 4) {
                        this.e.f();
                        return;
                    }
                    com.opos.cmn.an.f.a.b("SplashVideo", "resetVideoPlayerByVisible current state has stop =" + this.w);
                    return;
                }
                if (this.w != 1 && this.w != 2 && this.w != 4) {
                    if (this.x == 1) {
                        com.opos.cmn.an.f.a.b("SplashVideo", "resetVideoPlayerByVisible but is user stop");
                        return;
                    } else {
                        this.e.g();
                        return;
                    }
                }
                com.opos.cmn.an.f.a.b("SplashVideo", "resetVideoPlayerByVisible error state" + this.w);
                return;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "resetVideoPlayerByVisible but no action " + this.w);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("SplashVideo", "reset video fail", e);
        }
    }

    private void a(RelativeLayout.LayoutParams layoutParams, int i) {
        a(i);
        layoutParams.addRule(2, this.I.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        View viewC = this.G.c();
        if (viewC != null) {
            a(viewC, layoutParams);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        if (E()) {
            this.q.a(interfaceC0778a);
        } else {
            this.p.a(interfaceC0778a);
        }
        this.c = interfaceC0778a;
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.e.c.a aVar = this.G;
        if (aVar != null) {
            this.I.a(com.opos.mobad.template.i.a.a.a(bVar, aVar.e()));
        } else {
            this.I.setVisibility(4);
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        RelativeLayout.LayoutParams layoutParams;
        View viewA;
        com.opos.mobad.template.d dVar;
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (E()) {
            if (o() == 0) {
                context = this.b;
                f = 280.0f;
            } else {
                context = this.b;
                f = 142.0f;
            }
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, f));
            layoutParams.addRule(12);
        } else {
            layoutParams = layoutParams2;
        }
        if (this.j.indexOfChild(this.k) < 0) {
            this.j.addView(this.k, layoutParams2);
            this.j.addView(this.r, layoutParams);
        } else {
            this.j.updateViewLayout(this.k, layoutParams2);
            this.j.updateViewLayout(this.r, layoutParams);
        }
        b(cVar);
        k();
        this.C.a(cVar.j, cVar.D, cVar.E, null);
        a((com.opos.mobad.template.d.b) cVar);
        if (this.g == 0 && (dVar = cVar.s) != null) {
            View viewA2 = dVar.a();
            this.m = viewA2;
            if (viewA2 != null && viewA2.getParent() != null) {
                ((ViewGroup) this.m.getParent()).removeView(this.m);
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        View view = this.m;
        if (view != null) {
            view.setId(View.generateViewId());
            this.i.addView(this.m, com.opos.mobad.template.i.a.b.c(this.b));
            this.m.setVisibility(0);
            layoutParams3.addRule(2, this.m.getId());
        }
        if (this.i.indexOfChild(this.j) < 0) {
            this.i.addView(this.j, layoutParams3);
        } else {
            this.i.updateViewLayout(this.j, layoutParams3);
        }
        com.opos.mobad.template.d.a aVar = cVar.u;
        if (aVar != null) {
            a(aVar.f9412a, aVar.b);
        }
        if (this.n == null) {
            this.n = com.opos.mobad.template.i.a.b.a(cVar, this.i);
        }
        cVar.t.a(new e.a() { // from class: com.opos.mobad.template.i.s.2
            @Override // com.opos.mobad.template.e.a
            public void a(View view2, int[] iArr) {
                if (s.this.c != null) {
                    s.this.a();
                    s.this.z();
                    s.this.c.e(view2, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(12);
        layoutParams4.addRule(11);
        layoutParams4.bottomMargin = n();
        boolean z = this.D == j.SLIDE_UP;
        if (this.j.indexOfChild(this.l) < 0) {
            this.j.addView(this.l, m());
        } else {
            this.j.updateViewLayout(this.l, m());
        }
        if (this.o != null) {
            return;
        }
        if (E()) {
            layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 24.0f);
            viewA = com.opos.mobad.template.k.c.a(this.d, this.j, layoutParams4, this.E, this.c);
        } else {
            layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 22.0f);
            viewA = com.opos.mobad.template.h.a(this.d, this.j, layoutParams4, this.E, this.c, !z);
        }
        this.o = viewA;
        this.o.setVisibility(4);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null || cVarB.t == null) {
            this.c.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("SplashVideo", "render");
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
        this.s = cVarB.t;
        long j = cVarB.v;
        this.z = j;
        if (j <= 0) {
            this.z = 3000L;
        }
        if (this.d == null) {
            this.t = this.z;
        }
        boolean z = cVarB.A == 1;
        this.h = z;
        a(z);
        this.d = cVarB;
        a(cVarB);
        if (this.d != null || (interfaceC0778a = this.c) == null) {
            return;
        }
        interfaceC0778a.f();
    }

    private void a(String str, String str2) {
        RelativeLayout.LayoutParams layoutParams = (o() == 0 && E()) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 220.0f), -2) : new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = n();
        if (!E()) {
            if (this.j.indexOfChild(this.p) < 0) {
                this.j.addView(this.p, layoutParams);
            } else {
                this.j.updateViewLayout(this.p, layoutParams);
            }
            this.p.a(o(), str, str2);
            return;
        }
        if (this.j.indexOfChild(this.q) < 0) {
            this.j.addView(this.q, layoutParams);
        } else {
            this.j.updateViewLayout(this.q, layoutParams);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.q.a(str, str2);
    }

    private void a(boolean z) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar != null) {
            aVar.a(z ? 1.0f : 0.0f);
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.v : this.u);
        }
    }
}
