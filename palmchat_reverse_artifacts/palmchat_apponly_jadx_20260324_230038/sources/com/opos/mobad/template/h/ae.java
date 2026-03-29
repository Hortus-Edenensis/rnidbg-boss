package com.opos.mobad.template.h;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.h.a;
import com.opos.mobad.template.h.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ae extends com.opos.mobad.template.cmn.baseview.c implements a {
    private boolean A;
    private View B;
    private Bitmap C;
    private View D;
    private AnimatorSet E;
    private ProgressBar F;
    private com.opos.mobad.template.cmn.q G;
    private Runnable H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f9939a;
    protected com.opos.mobad.d.a b;
    protected a.InterfaceC0778a c;
    protected a.InterfaceC0795a d;
    protected com.opos.mobad.d.d.a e;
    protected com.opos.mobad.template.cmn.baseview.b f;
    protected RelativeLayout g;
    protected com.opos.mobad.template.d.c h;
    protected View i;
    protected u j;
    protected LinearLayout.LayoutParams l;
    protected LinearLayout m;
    protected z n;
    protected LinearLayout.LayoutParams o;
    protected d p;
    protected RelativeLayout q;
    protected boolean r;
    public boolean s;
    protected w t;
    protected int u;
    protected RelativeLayout v;
    protected View w;
    protected boolean x;
    protected com.opos.mobad.template.cmn.p y;
    private Handler z;

    /* JADX INFO: renamed from: com.opos.mobad.template.h.ae$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9944a;

        static {
            int[] iArr = new int[com.opos.mobad.template.cmn.t.values().length];
            f9944a = iArr;
            try {
                iArr[com.opos.mobad.template.cmn.t.RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.RENDERFIRSTFRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.BUFFERINGSTART.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9944a[com.opos.mobad.template.cmn.t.BUFFERINGEND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ae(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z) {
        this(context, aVar, aVar2, z, 0);
    }

    private void h() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(this.f9939a);
        this.D = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.D);
        this.g = new RelativeLayout(this.f9939a);
        this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        f();
        b();
        this.q = new RelativeLayout(this.f9939a);
        addView(this.q, new RelativeLayout.LayoutParams(-1, -1));
        i();
        d();
        int i = this.u;
        if (i == 2 || i == 3) {
            e();
        }
        if (this.u == 3) {
            a((RelativeLayout) this);
        }
    }

    private void i() {
        this.B = new ProgressBar(this.f9939a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f9939a, 20.0f), com.opos.cmn.an.h.f.a.a(this.f9939a, 29.0f));
        layoutParams.addRule(13);
        this.B.setVisibility(0);
        addView(this.B, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        if (0 == this.e.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.e.d() * 100) / this.e.c()));
    }

    @Override // com.opos.mobad.template.h.a
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.template.h.a
    public a b_(com.opos.mobad.template.cmn.baseview.f fVar) {
        a(fVar);
        return this;
    }

    public void e() {
        com.opos.mobad.template.cmn.m.a(this.f9939a, this, true);
    }

    public void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f9939a);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(this.f9939a);
        this.w = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        int alphaComponent = ColorUtils.setAlphaComponent(-16777216, 76);
        this.w.setBackgroundColor(alphaComponent);
        this.g.addView(this.w);
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar != null) {
            this.i = aVar.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(13);
            layoutParams.addRule(12);
            this.i.setBackgroundColor(alphaComponent);
            this.g.addView(this.i, layoutParams);
        }
        addView(this.g);
    }

    public void g() {
        com.opos.mobad.template.d.c cVar = this.h;
        if (cVar == null || cVar.F != 1) {
            this.E = new AnimatorSet();
            Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
            this.E.setDuration(500L);
            this.E.setInterpolator(interpolatorCreate);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.p, "alpha", 1.0f, 0.0f);
            this.E.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(ObjectAnimator.ofFloat(this.f, "alpha", 1.0f, 0.0f));
            this.E.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.r = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Bitmap bitmap = this.C;
        if (bitmap != null) {
            bitmap.recycle();
            this.C = null;
        }
        AnimatorSet animatorSet = this.E;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.z.removeCallbacks(this.H);
        this.r = true;
        super.onDetachedFromWindow();
    }

    public ae(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z, int i) {
        super(context);
        this.u = 0;
        this.x = false;
        this.H = new Runnable() { // from class: com.opos.mobad.template.h.ae.4
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.d.d.a aVar3;
                ae aeVar = ae.this;
                if (aeVar.r || aeVar.d == null || (aVar3 = aeVar.e) == null) {
                    return;
                }
                long jD = aVar3.d();
                long jC = ae.this.e.c();
                ae.this.d.a(jD, jC);
                ae.this.a(jD);
                ae.this.a(jD, jC);
                if (ae.this.F != null) {
                    ae.this.F.setProgress(ae.this.j());
                }
                ae.this.z.postDelayed(this, 1000L);
            }
        };
        this.f9939a = context.getApplicationContext();
        this.b = aVar;
        this.s = z;
        this.e = aVar2;
        this.u = i;
        this.z = new Handler(Looper.getMainLooper());
        h();
    }

    @Override // com.opos.mobad.template.h.a
    public a b(com.opos.mobad.template.cmn.p pVar) {
        View view = this.i;
        if (view != null) {
            com.opos.mobad.template.cmn.p.a(view, pVar);
        }
        return this;
    }

    @Override // com.opos.mobad.template.h.a
    public a c(com.opos.mobad.template.cmn.p pVar) {
        int i;
        RelativeLayout relativeLayout = this.v;
        if (relativeLayout != null && ((i = this.u) == 1 || i == 2 || i == 3)) {
            com.opos.mobad.template.cmn.p.a(relativeLayout, pVar);
        }
        return this;
    }

    public void d() {
        w wVarA = w.a(this.f9939a);
        this.t = wVarA;
        addView(wVarA);
    }

    @Override // com.opos.mobad.template.h.a
    public a a(Bitmap bitmap) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a(bitmap);
        }
        return this;
    }

    public void b() {
        z zVarA;
        int i = this.u;
        if (i == 1 || i == 2 || i == 3) {
            this.v = new RelativeLayout(this.f9939a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f9939a, 56.0f), com.opos.cmn.an.h.f.a.a(this.f9939a, 94.0f));
            layoutParams.addRule(11);
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
            addView(this.v);
        }
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.f9939a);
        this.f = bVar;
        bVar.setBackgroundColor(-16777216);
        this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f9939a, 94.0f)));
        this.f.setId(View.generateViewId());
        if (this.u == 3) {
            this.j = u.a(this.f9939a, 1);
            zVarA = z.a(this.f9939a, 1);
        } else {
            this.j = u.a(this.f9939a);
            zVarA = z.a(this.f9939a);
        }
        this.n = zVarA;
        int iA = com.opos.cmn.an.h.f.a.a(this.f9939a, 28.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.f9939a, 16.0f);
        this.m = new LinearLayout(this.f9939a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        this.l = layoutParams2;
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = iA2;
        layoutParams2.bottomMargin = iA2;
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(this.f9939a, 12.0f);
        this.l.weight = 1.0f;
        this.m.addView(this.j, new LinearLayout.LayoutParams(-2, iA));
        this.n.setId(View.generateViewId());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, iA);
        this.o = layoutParams3;
        layoutParams3.gravity = 80;
        layoutParams3.rightMargin = iA2;
        layoutParams3.bottomMargin = iA2;
        this.n.a(new z.a() { // from class: com.opos.mobad.template.h.ae.1
            @Override // com.opos.mobad.template.h.z.a
            public void a(int i2) {
                com.opos.mobad.d.d.a aVar = ae.this.e;
                if (aVar == null) {
                    return;
                }
                aVar.a(i2 == 1 ? 1.0f : 0.0f);
            }
        });
        this.f.addView(this.m, this.l);
        this.f.addView(this.n, this.o);
        addView(this.f);
    }

    public void c() {
        d kVar;
        if (this.s) {
            kVar = this.u == 3 ? new l(this.f9939a, this.b) : new m(this.f9939a, this.b);
        } else {
            kVar = this.u == 0 && com.opos.mobad.template.h.a(this.h) ? new k(this.f9939a, this.b) : new j(this.f9939a, this.b);
        }
        this.p = kVar;
        this.q.addView(this.p);
        this.x = true;
    }

    @Override // com.opos.mobad.template.h.a
    public a a(a.InterfaceC0778a interfaceC0778a) {
        if (interfaceC0778a != null) {
            this.c = interfaceC0778a;
            this.n.a(interfaceC0778a);
            this.j.a(this.c);
            d dVar = this.p;
            if (dVar != null) {
                dVar.a(interfaceC0778a);
            }
            w wVar = this.t;
            if (wVar != null) {
                wVar.a(interfaceC0778a);
            }
        }
        return this;
    }

    public void b(Bitmap bitmap) {
        this.C = bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        final Bitmap bitmapA = com.opos.mobad.template.cmn.f.a(this.f9939a, this.C, 75, 0.25f, 60.0f);
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.ae.3
            @Override // java.lang.Runnable
            public void run() {
                ae aeVar = ae.this;
                if (aeVar.r) {
                    return;
                }
                aeVar.D.setBackground(new BitmapDrawable(bitmapA));
            }
        });
    }

    public a a(com.opos.mobad.template.cmn.p pVar) {
        this.y = pVar;
        return this;
    }

    @Override // com.opos.mobad.template.h.a
    public a a(com.opos.mobad.template.cmn.q qVar) {
        this.G = qVar;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.opos.mobad.template.h.a
    public a a(com.opos.mobad.template.cmn.t tVar) {
        View view;
        com.opos.mobad.template.d.e eVar;
        switch (AnonymousClass5.f9944a[tVar.ordinal()]) {
            case 1:
                ProgressBar progressBar = this.F;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                this.z.post(this.H);
                return this;
            case 2:
                ProgressBar progressBar2 = this.F;
                if (progressBar2 != null) {
                    progressBar2.setProgress(0);
                    this.F.setVisibility(0);
                }
                this.z.removeCallbacks(this.H);
                this.z.post(this.H);
                this.d.a(0L, this.e.c());
                a(this.e.c() < 5000);
                this.B.setVisibility(8);
                view = this.t;
                if (view != null) {
                    view.setVisibility(8);
                }
                return this;
            case 3:
                ProgressBar progressBar3 = this.F;
                if (progressBar3 != null) {
                    progressBar3.setVisibility(0);
                }
                this.z.removeCallbacks(this.H);
                return this;
            case 4:
                ProgressBar progressBar4 = this.F;
                if (progressBar4 != null) {
                    progressBar4.setVisibility(8);
                }
                this.z.removeCallbacks(this.H);
                g();
                return this;
            case 5:
                com.opos.mobad.template.d.c cVar = this.h;
                if (cVar != null && (eVar = cVar.N) != null) {
                    a(eVar.f9414a);
                }
                return this;
            case 6:
                this.B.setVisibility(0);
                return this;
            case 7:
                view = this.B;
                view.setVisibility(8);
                return this;
            default:
                return this;
        }
    }

    @Override // com.opos.mobad.template.h.a
    public a a(com.opos.mobad.template.d.c cVar) {
        this.h = cVar;
        if (cVar != null) {
            this.j.a(cVar.q, cVar.B);
            this.n.a(cVar.A);
            if (!this.x) {
                c();
            }
            d dVar = this.p;
            if (dVar != null) {
                dVar.a(cVar);
                a.InterfaceC0778a interfaceC0778a = this.c;
                if (interfaceC0778a != null) {
                    this.p.a(interfaceC0778a);
                }
                com.opos.mobad.template.cmn.p pVar = this.y;
                if (pVar != null) {
                    this.p.a(pVar);
                }
                com.opos.mobad.template.cmn.q qVar = this.G;
                if (qVar != null) {
                    this.p.a(qVar);
                }
                com.opos.mobad.template.cmn.baseview.f fVar = this.k;
                if (fVar != null) {
                    this.p.a(fVar);
                }
            }
        }
        return this;
    }

    @Override // com.opos.mobad.template.h.a
    public a a(a.InterfaceC0795a interfaceC0795a) {
        this.d = interfaceC0795a;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.c cVar = this.h;
        if (cVar == null || this.A) {
            return;
        }
        long j2 = cVar.C;
        if (j2 <= 0 || j >= j2) {
            this.A = true;
            this.n.a();
            RelativeLayout relativeLayout = this.v;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public void a(long j, long j2) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a(j, j2);
        }
    }

    private void a(RelativeLayout relativeLayout) {
        ProgressBar progressBar = new ProgressBar(this.f9939a);
        this.F = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.template.cmn.af.a(this.F, "mOnlyIndeterminate", new Boolean(false));
        this.F.setIndeterminate(false);
        this.F.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.F.setBackgroundColor(Color.argb(77, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f9939a, 2.0f));
        layoutParams.addRule(12);
        this.F.setVisibility(0);
        if (relativeLayout != null) {
            relativeLayout.addView(this.F, layoutParams);
        }
    }

    private void a(String str) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.e) == null) {
            return;
        }
        com.opos.mobad.template.cmn.af.a(aVar, str, new af.a() { // from class: com.opos.mobad.template.h.ae.2
            @Override // com.opos.mobad.template.cmn.af.a
            public void a() {
            }

            @Override // com.opos.mobad.template.cmn.af.a
            public void a(Bitmap bitmap) {
                ae.this.b(bitmap);
            }
        });
    }

    public void a(boolean z) {
        d dVar;
        if (this.e == null || (dVar = this.p) == null) {
            return;
        }
        dVar.a(z);
    }
}
