package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.e;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements com.opos.mobad.template.a {
    private com.opos.mobad.template.e A;
    private long B;
    private j C;
    private com.opos.mobad.d.a d;
    private final Context e;
    private com.opos.mobad.template.a.a f;
    private ImageView g;
    private e h;
    private int i;
    private long k;
    private com.opos.mobad.template.d.b l;
    private int m;
    private int n;
    private com.opos.mobad.template.cmn.baseview.c o;
    private RelativeLayout p;
    private d q;
    private a.InterfaceC0778a r;
    private com.opos.mobad.template.e.c.a s;
    private com.opos.mobad.template.i.b.a u;
    private ViewGroup v;
    private View w;
    private View x;
    private com.opos.mobad.template.a.b y;
    private com.opos.mobad.template.a.c z;
    private volatile int c = 0;
    private boolean t = false;
    private boolean D = false;
    private Runnable E = new Runnable() { // from class: com.opos.mobad.template.i.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                return;
            }
            long j = f.this.B;
            f fVar = f.this;
            if (j <= 0) {
                fVar.r.d(f.this.k - f.this.B, f.this.k);
                f.this.j.a();
                f.this.a();
                f.this.D();
                return;
            }
            fVar.j.a(1000L);
            if (f.this.A != null) {
                f.this.A.a((int) (f.this.B / 1000));
            }
            f.this.r.d(f.this.k - f.this.B, f.this.k);
            f.this.B -= 1000;
            com.opos.cmn.an.f.a.b("LogoSplash", "mTimerRunnable mCountdownSeconds=", Long.valueOf(f.this.B));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j.b f10104a = new j.b() { // from class: com.opos.mobad.template.i.f.14
        @Override // com.opos.mobad.template.cmn.j.b
        public boolean a() {
            return f.this.c == 4;
        }
    };
    com.opos.mobad.template.cmn.p b = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.f.6
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (f.this.r != null) {
                f.this.r.g(view, iArr);
            }
        }
    };
    private com.opos.mobad.d.c.d j = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), this.E);

    /* JADX INFO: renamed from: com.opos.mobad.template.i.f$13, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass13 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f10109a;
        final /* synthetic */ int b;

        public AnonymousClass13(com.opos.mobad.template.d.b bVar, int i) {
            this.f10109a = bVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                com.opos.cmn.an.f.a.a("LogoSplash", "renderMediaIcon() load image but has destroyed");
            } else {
                com.opos.mobad.template.d.e eVar = this.f10109a.k;
                com.opos.mobad.template.h.b(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(f.this.e, 85.0f), com.opos.cmn.an.h.f.a.a(f.this.e, 85.0f), f.this.d, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.i.f.13.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        Bitmap bitmapCreateBitmap;
                        final Bitmap bitmap2;
                        if (bitmap == null) {
                            int i = AnonymousClass13.this.b;
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap2.eraseColor(Color.parseColor("#14000000"));
                            int i2 = AnonymousClass13.this.b;
                            bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap.eraseColor(Color.parseColor("#33000000"));
                            bitmap2 = bitmapCreateBitmap2;
                        } else {
                            bitmapCreateBitmap = null;
                            bitmap2 = bitmap;
                        }
                        final Bitmap bitmap3 = bitmapCreateBitmap;
                        final Bitmap bitmapA = com.opos.mobad.template.cmn.f.a(f.this.e, bitmap2, 75, 0.25f, 56.0f);
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.i.f.13.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView imageView;
                                Bitmap bitmap4;
                                String str;
                                if (f.this.c != 4) {
                                    com.opos.mobad.template.a.a aVar = f.this.f;
                                    int iB = f.this.B();
                                    Bitmap bitmap5 = bitmap2;
                                    com.opos.mobad.template.d.b bVar = AnonymousClass13.this.f10109a;
                                    aVar.a(iB, bitmap5, bVar.b, bVar.f9413a);
                                    f.this.f.setVisibility(0);
                                    if (bitmap == null) {
                                        imageView = f.this.g;
                                        bitmap4 = bitmap3;
                                    } else if (bitmapA == null) {
                                        str = "renderMediaIcon() load bitmap but blur bitmap is null";
                                    } else {
                                        imageView = f.this.g;
                                        bitmap4 = bitmapA;
                                    }
                                    imageView.setImageBitmap(bitmap4);
                                    return;
                                }
                                str = "renderMediaIcon() load bitmap but has destroy";
                                com.opos.cmn.an.f.a.a("LogoSplash", str);
                            }
                        });
                    }
                }, f.this.r);
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.template.i.f$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f10116a;

        public AnonymousClass4(com.opos.mobad.template.d.b bVar) {
            this.f10116a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                com.opos.cmn.an.f.a.a("LogoSplash", "load ima but has destroyed");
            } else if (this.f10116a.c.get(0) == null) {
                com.opos.cmn.an.f.a.a("LogoSplash", "null imgList");
            } else {
                com.opos.mobad.template.h.a(this.f10116a.c.get(0).f9414a, this.f10116a.c.get(0).b, com.opos.cmn.an.h.f.a.b(f.this.e), f.this.i, f.this.d, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.i.f.4.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        if (bitmap == null) {
                            com.opos.cmn.an.f.a.a("LogoSplash", "null bitmap");
                            com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.b(f.this.e), f.this.i, f.this.g);
                        } else {
                            f fVar = f.this;
                            final boolean zA = fVar.a(fVar.i, com.opos.cmn.an.h.f.a.b(f.this.e), bitmap.getHeight(), bitmap.getWidth());
                            com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.i.f.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (f.this.c == 4) {
                                        com.opos.cmn.an.f.a.a("LogoSplash", "load ima but has destroyed");
                                        return;
                                    }
                                    if (zA) {
                                        f.this.g.setScaleType(ImageView.ScaleType.MATRIX);
                                    }
                                    f.this.g.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                }, f.this.r);
            }
        }
    }

    private f(Context context, int i, int i2, j jVar, com.opos.mobad.d.a aVar) {
        this.C = j.NONE;
        this.e = context;
        this.C = a(jVar);
        this.n = i2;
        this.m = i;
        this.d = aVar;
        g();
        f();
    }

    private int A() {
        int i = 15;
        switch (this.n) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
            case 12:
                i = 16;
                break;
            case 2:
                i = 30;
                break;
        }
        return com.opos.cmn.an.h.f.a.a(this.e, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        return G() ? 1 : 0;
    }

    private void C() {
        this.p.setVisibility(0);
        u();
        this.w.setVisibility(0);
        this.x.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (E()) {
            a.InterfaceC0778a interfaceC0778a = this.r;
            if (interfaceC0778a != null) {
                long j = this.k;
                interfaceC0778a.a(j, j);
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "handleAdClosed");
        }
    }

    private boolean E() {
        View viewC = c();
        return viewC != null && viewC.isShown();
    }

    private boolean F() {
        int i = this.n;
        return i == 1 || i == 4;
    }

    private boolean G() {
        int i = this.n;
        return i == 4 || i == 3 || i == 11 || i == 12;
    }

    private boolean H() {
        int i = this.n;
        return i == 9 || i == 10;
    }

    private boolean I() {
        return this.n == 11;
    }

    private boolean J() {
        return F() || H() || I();
    }

    private boolean K() {
        int i = this.n;
        return i == 11 || i == 12 || i == 10 || i == 9 || i == 4 || i == 5 || i == 0 || i == 3 || i == 1;
    }

    private boolean L() {
        return this.n == 5 || H() || I() || this.n == 12;
    }

    public static f g(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 10, jVar, aVar);
    }

    public static f i(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 11, jVar, aVar);
    }

    public static f j(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 12, jVar, aVar);
    }

    private void k() {
        if (L()) {
            return;
        }
        if (K()) {
            com.opos.mobad.template.h.a(this.e, B(), this.p);
            return;
        }
        View frameLayout = new FrameLayout(this.e);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        gradientDrawable.setGradientType(0);
        frameLayout.setBackground(gradientDrawable);
        this.p.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        this.q = K() ? i.b(this.e, this.C, this.n) : i.a(this.e, this.C, this.n);
        this.q.a(new c() { // from class: com.opos.mobad.template.i.f.11
            @Override // com.opos.mobad.template.c
            public void a(int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.a(iArr);
                }
            }

            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.g(view, iArr);
                }
            }
        });
        this.p.addView(this.q.a(), n());
    }

    private RelativeLayout.LayoutParams n() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int iB = com.opos.mobad.template.i.a.a.b(this.n);
        if (this.C != j.SLIDE_UP) {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.e, iB);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.d();
            p();
        } else {
            d dVar = this.q;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    private void w() {
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(8);
    }

    private void x() {
        l();
        m();
        y();
    }

    private void y() {
        RelativeLayout relativeLayout;
        View view;
        RelativeLayout.LayoutParams layoutParams = (B() == 0 && K()) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.e, 220.0f), -2) : new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = A();
        if (K()) {
            if (this.z == null) {
                this.z = new com.opos.mobad.template.a.c(this.e);
            }
            this.z.setVisibility(8);
            if (this.z.getParent() != null && (this.z.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.z.getParent()).removeView(this.z);
            }
            relativeLayout = this.p;
            view = this.z;
        } else {
            if (this.y == null) {
                this.y = new com.opos.mobad.template.a.b(this.e);
            }
            if (this.y.getParent() != null && (this.y.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.y.getParent()).removeView(this.y);
            }
            relativeLayout = this.p;
            view = this.y;
        }
        relativeLayout.addView(view, layoutParams);
    }

    private void z() {
        FrameLayout frameLayout = new FrameLayout(this.e);
        this.v = frameLayout;
        frameLayout.setId(View.generateViewId());
        this.o.addView(this.v, com.opos.mobad.template.i.a.b.c(this.e));
        this.v.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.m;
    }

    public static f b(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 4, jVar, aVar);
    }

    public static f d(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 2, jVar, aVar);
    }

    public static f f(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 5, jVar, aVar);
    }

    private void g() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.e);
        this.o = cVar;
        cVar.setBackgroundColor(-1);
        z();
        h();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.f.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                f.this.o();
                if (f.this.r != null) {
                    f.this.r.h(view, iArr);
                }
            }
        };
        this.o.setOnClickListener(pVar);
        this.o.setOnTouchListener(pVar);
        this.o.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.i.f.10
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("LogoSplash", "onMockEventIntercepted() mockEvent=", Integer.valueOf(i), "disAllowClick=", Boolean.valueOf(z), "view=", view);
                if (f.this.r != null) {
                    f.this.r.a(view, i, z);
                }
            }
        });
        this.o.setVisibility(4);
    }

    public static f h(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 9, jVar, aVar);
    }

    private void i() {
        e pVar;
        if (this.n == 5) {
            pVar = new m(this.e);
        } else if (H()) {
            pVar = new n(this.e, this.n);
        } else if (I()) {
            pVar = new o(this.e);
        } else {
            if (this.n != 12) {
                this.g = new ImageView(this.e);
                this.p.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
                return;
            }
            pVar = new p(this.e);
        }
        this.h = pVar;
        this.p.addView(pVar.a());
    }

    private void j() {
        this.f = new com.opos.mobad.template.a.a(this.e, 1);
        this.g = new ImageView(this.e);
        this.p.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        this.p.addView(this.f);
    }

    private void m() {
        if (this.u == null) {
            com.opos.mobad.template.i.b.a aVar = new com.opos.mobad.template.i.b.a(this.e, e());
            this.u = aVar;
            aVar.setId(View.generateViewId());
        }
        this.u.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.e, com.opos.mobad.template.i.a.a.a(this.n));
        if (this.u.getParent() != null && (this.u.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.u.getParent()).removeView(this.u);
        }
        this.p.addView(this.u, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.u == null || !com.opos.mobad.template.i.a.a.f(this.m)) {
            return;
        }
        this.u.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.h();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.i();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.d();
        }
    }

    private void s() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.j();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.s == null) {
            d dVar = this.q;
            if (dVar != null) {
                dVar.c();
                return;
            }
            return;
        }
        if (this.u != null && com.opos.mobad.template.i.a.a.e(this.m)) {
            this.u.g();
        } else if (this.u != null && com.opos.mobad.template.i.a.a.g(this.m)) {
            this.u.c();
        }
        this.s.g();
    }

    private void u() {
        View viewC;
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar == null || aVar.c() == null) {
            d dVar = this.q;
            if (dVar == null || dVar.a() == null) {
                return;
            }
            this.q.a().setVisibility(0);
            return;
        }
        boolean zE = this.s.e();
        com.opos.mobad.template.e.c.a aVar2 = this.s;
        if (!(aVar2 instanceof com.opos.mobad.template.e.c.d.c)) {
            if (aVar2 instanceof com.opos.mobad.template.e.c.d.g) {
                aVar2.c().setVisibility(0);
                if (com.opos.mobad.template.i.a.a.c(this.m)) {
                    w();
                    return;
                }
            } else if (zE) {
                aVar2.c().setVisibility(0);
            } else {
                v();
                viewC = this.s.c();
            }
            v();
            return;
        }
        aVar2.c().setVisibility(0);
        viewC = this.u;
        if (viewC == null) {
            return;
        }
        viewC.setVisibility(8);
    }

    private void v() {
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(0);
        com.opos.mobad.template.cmn.p.a(this.u.a(), this.b);
    }

    public static f a(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 1, jVar, aVar);
    }

    public static f c(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 0, jVar, aVar);
    }

    public static f e(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 3, jVar, aVar);
    }

    private void f() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.e);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.i.f.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (f.this.l == null) {
                    return;
                }
                if (z && f.this.D) {
                    f.this.q();
                } else {
                    f.this.r();
                }
                if (z && f.this.c == 0) {
                    f.this.D = true;
                    f.this.b();
                    f.this.t();
                    if (f.this.r != null) {
                        f.this.r.a(com.opos.mobad.template.h.a(f.this.s));
                    }
                }
                boolean z2 = f.this.B <= 0 || f.this.c == 3;
                if (z && z2) {
                    f.this.D();
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "onViewVisibile() isViewVisible=" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.i.f.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (f.this.l == null) {
                    return;
                }
                if (f.this.r != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(f.this.s);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    f.this.r.a(mapA);
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "onViewVisibleWithoutFocus() isVisibleRect=", Boolean.valueOf(z), "isAttachedToWindow=", Boolean.valueOf(z2));
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        this.o.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        this.g.setScaleType(ImageView.ScaleType.FIT_XY);
        this.i = this.v != null ? com.opos.cmn.an.h.f.a.c(this.e) - com.opos.mobad.template.i.a.b.d(this.e) : com.opos.cmn.an.h.f.a.c(this.e);
        com.opos.cmn.an.j.b.c(new AnonymousClass4(bVar));
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.e);
        this.p = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.v;
        if (viewGroup != null) {
            layoutParams.addRule(2, viewGroup.getId());
        }
        this.o.addView(this.p, layoutParams);
        if (F()) {
            j();
        } else {
            i();
        }
        k();
        x();
    }

    private void i(com.opos.mobad.template.d.b bVar) {
        Context context;
        float f;
        d(bVar);
        if (F()) {
            e(bVar);
        } else if (L()) {
            f(bVar);
        } else {
            g(bVar);
        }
        h(bVar);
        if (this.w == null) {
            this.w = com.opos.mobad.template.i.a.b.a(bVar, this.o);
        }
        bVar.t.a(new e.a() { // from class: com.opos.mobad.template.i.f.5
            @Override // com.opos.mobad.template.e.a
            public void a(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.a();
                    f.this.r.e(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        if (K()) {
            context = this.e;
            f = 24.0f;
        } else {
            context = this.e;
            f = 22.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams.bottomMargin = A();
        if (this.x != null) {
            return;
        }
        this.x = K() ? com.opos.mobad.template.k.c.a(this.l, this.p, layoutParams, this.d, this.r) : (L() || this.C == j.SLIDE_UP) ? com.opos.mobad.template.h.a(this.l, this.p, layoutParams, this.d, this.r, false) : com.opos.mobad.template.h.a(this.l, this.p, layoutParams, this.d, this.r);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        C();
        if (this.c == 1 || this.c == 4) {
            com.opos.cmn.an.f.a.a("LogoSplash", "start() mCurrentState=", Integer.valueOf(this.c));
            return;
        }
        this.c = 1;
        this.j.a(0L);
        q();
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar != null) {
            aVar.h();
        }
        com.opos.cmn.an.f.a.b("LogoSplash", "start()");
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        s();
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar != null) {
            aVar.j();
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.b();
        }
        a();
        this.l = null;
        this.c = 4;
        this.j.a();
        this.j.b();
        com.opos.cmn.an.f.a.b("LogoSplash", "destroy");
    }

    private j a(j jVar) {
        j jVar2 = j.NONE;
        return (jVar == jVar2 || com.opos.mobad.template.h.a()) ? jVar : jVar2;
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        a(bVar);
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            this.u.a(com.opos.mobad.template.i.a.a.a(bVar, aVar.e()));
        } else {
            this.u.setVisibility(4);
        }
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d dVar;
        ViewGroup viewGroup;
        int i;
        int i2 = this.n;
        if ((i2 == 0 || i2 == 1 || i2 == 5 || H()) && (dVar = bVar.s) != null) {
            View viewA = dVar.a();
            if (viewA == null) {
                return;
            }
            if (viewA.getParent() != null) {
                ((ViewGroup) viewA.getParent()).removeView(viewA);
            }
            this.v.addView(viewA);
            viewGroup = this.v;
            i = 0;
        } else {
            viewGroup = this.v;
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    private void e(com.opos.mobad.template.d.b bVar) {
        if (bVar.k != null) {
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            com.opos.cmn.an.j.b.c(new AnonymousClass13(bVar, com.opos.cmn.an.h.f.a.a(this.e, 106.0f)));
        }
    }

    private void f(final com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.h.a(bVar, null);
        } else {
            com.opos.mobad.template.d.e eVar2 = bVar.k;
            com.opos.mobad.template.cmn.j.a(eVar2.f9414a, eVar2.b, this.d, new j.c() { // from class: com.opos.mobad.template.i.f.2
                @Override // com.opos.mobad.template.cmn.j.c
                public void a(int i) {
                    if (f.this.c == 4) {
                        return;
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.i.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.c == 4) {
                                return;
                            }
                            f.this.h.a(bVar, null);
                        }
                    });
                }

                @Override // com.opos.mobad.template.cmn.j.c
                public void a(Bitmap bitmap) {
                    f.this.h.a(bVar, bitmap);
                }
            }, this.f10104a);
        }
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("LogoSplash", "Image loads but resource is empty");
        } else {
            if (J()) {
                return;
            }
            com.opos.mobad.template.cmn.j.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.d, new j.c() { // from class: com.opos.mobad.template.i.f.3
                @Override // com.opos.mobad.template.cmn.j.c
                public void a(int i) {
                    if (i != 1) {
                        f.this.h.a(null);
                    }
                    f.this.r.c(i);
                }

                @Override // com.opos.mobad.template.cmn.j.c
                public void a(Bitmap bitmap) {
                    f.this.h.a(bitmap);
                }
            }, this.f10104a);
        }
    }

    private void h(com.opos.mobad.template.d.b bVar) {
        b(bVar);
        c(bVar);
        if (bVar.u != null) {
            if (!K()) {
                com.opos.mobad.template.a.b bVar2 = this.y;
                int iB = B();
                com.opos.mobad.template.d.a aVar = bVar.u;
                bVar2.a(iB, aVar.f9412a, aVar.b);
            } else {
                if (TextUtils.isEmpty(bVar.u.f9412a) || TextUtils.isEmpty(bVar.u.b)) {
                    return;
                }
                com.opos.mobad.template.a.c cVar = this.z;
                com.opos.mobad.template.d.a aVar2 = bVar.u;
                cVar.a(aVar2.f9412a, aVar2.b);
                this.z.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(bVar.j)) {
            return;
        }
        this.q.a(bVar.j, bVar.D, bVar.E, null);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.c == 2 || this.c == 4) {
            com.opos.cmn.an.f.a.a("LogoSplash", "stop() mCurrentState=", Integer.valueOf(this.c));
            return;
        }
        this.c = 2;
        this.j.a();
        r();
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar != null) {
            aVar.i();
        }
        com.opos.cmn.an.f.a.b("LogoSplash", "stop()");
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        if (K()) {
            this.z.a(interfaceC0778a);
        } else {
            this.y.a(interfaceC0778a);
        }
        this.r = interfaceC0778a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.opos.mobad.template.d.b bVar) {
        int iA;
        int iB;
        if (this.t) {
            return;
        }
        com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.e, e(), bVar.L);
        this.s = aVarA;
        if (aVarA == null) {
            return;
        }
        aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.i.f.12
            @Override // com.opos.mobad.template.e.c.b
            public void a(int i, int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.a(i, iArr);
                }
            }

            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.g(view, iArr);
                }
            }

            @Override // com.opos.mobad.template.e.c.b
            public void a(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.h(view, iArr);
                }
                f.this.p();
            }

            @Override // com.opos.mobad.template.c
            public void a(int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.a(iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(14);
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar instanceof com.opos.mobad.template.e.c.d.c) {
            layoutParams.addRule(12);
        } else if (aVar instanceof com.opos.mobad.template.e.c.d.g) {
            if (com.opos.mobad.template.i.a.a.d(this.m)) {
                ((com.opos.mobad.template.e.c.d.g) this.s).a(com.opos.mobad.template.i.a.a.a(K(), this.n));
            }
            if (com.opos.mobad.template.i.a.a.c(this.m)) {
                layoutParams.addRule(12);
                if (this.m == 2041) {
                    ((com.opos.mobad.template.e.c.d.g) this.s).a(com.opos.mobad.template.i.a.a.b(this.n) + 8);
                    iB = 0;
                } else {
                    iB = com.opos.mobad.template.i.a.a.b(this.n) + 8;
                }
                iA = com.opos.cmn.an.h.f.a.a(this.e, iB);
            } else {
                layoutParams.addRule(2, this.u.getId());
                iA = com.opos.cmn.an.h.f.a.a(this.e, 12.0f);
            }
            layoutParams.bottomMargin = iA;
        } else {
            if ((aVar instanceof com.opos.mobad.template.e.c.d.a) && this.m != 2058) {
                ((com.opos.mobad.template.e.c.d.a) aVar).a(122);
                iA = A() * 2;
            }
            layoutParams.bottomMargin = iA;
        }
        if (this.p != null && this.s.c() != null) {
            this.p.addView(this.s.c(), layoutParams);
            m();
            y();
        }
        if (this.s.e()) {
            com.opos.mobad.template.e.c.a aVar2 = this.s;
            if ((aVar2 instanceof com.opos.mobad.template.e.c.d.d) && this.m == 59) {
                this.u.a(aVar2);
            }
        }
        View viewA = this.q.a();
        if (viewA != null) {
            viewA.setVisibility(8);
            this.p.removeView(viewA);
        }
        this.t = true;
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        List<com.opos.mobad.template.d.e> list;
        com.opos.mobad.template.d.e eVar;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null || bVarA.t == null) {
            com.opos.cmn.an.f.a.a("LogoSplash", "render() but adShowData is null");
            this.r.a(1);
            return;
        }
        if (J() && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.a("LogoSplash", "render() but iconUrl is null");
            this.r.a(1);
            return;
        }
        if (!J() && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.a("LogoSplash", "render() but imgList is null");
            this.r.a(1);
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.o;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
        if (this.l == null && (interfaceC0778a = this.r) != null) {
            interfaceC0778a.f();
            com.opos.cmn.an.f.a.b("LogoSplash", "render() onRenderSuccess");
        }
        this.A = bVarA.t;
        long j = bVarA.v;
        this.k = j;
        if (j <= 0) {
            this.k = 3000L;
        }
        if (this.l == null) {
            this.B = this.k;
        }
        this.l = bVarA;
        i(bVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2, int i3, int i4) {
        return i * i4 < i2 * i3;
    }
}
