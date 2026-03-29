package com.opos.mobad.template.h;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.h.z;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends com.opos.mobad.template.j.b {
    private com.opos.mobad.template.cmn.w A;
    private TextView B;
    private BaseTextView C;
    private u D;
    private z E;
    private boolean F;
    private com.opos.mobad.template.cmn.w G;
    private com.opos.mobad.template.cmn.g H;
    private ProgressBar I;
    private RelativeLayout.LayoutParams J;
    private View K;
    private com.opos.mobad.template.k.c L;
    private f M;
    private com.opos.mobad.template.cmn.baseview.c N;
    private RelativeLayout O;
    private TextView P;
    private com.opos.mobad.template.cmn.baseview.c Q;
    private com.opos.mobad.template.e.c.a R;
    private boolean S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private Runnable Y;
    private com.opos.mobad.template.cmn.q Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f9980a;
    private com.opos.mobad.template.cmn.q aa;
    private com.opos.mobad.template.cmn.p ab;
    private com.opos.mobad.template.cmn.q ac;
    private com.opos.mobad.template.cmn.baseview.f ad;
    private com.opos.mobad.d.d.b ae;
    private j.b af;
    com.opos.mobad.template.cmn.p b;
    private com.opos.mobad.template.cmn.baseview.c c;
    private Context g;
    private com.opos.mobad.d.d.a h;
    private com.opos.mobad.d.a i;
    private com.opos.mobad.template.d.c j;
    private int k;
    private boolean l;
    private com.opos.mobad.d.e.a m;
    private Bitmap n;
    private Handler o;
    private RelativeLayout p;
    private RelativeLayout q;
    private View r;
    private RelativeLayout s;
    private com.opos.mobad.template.cmn.baseview.c t;
    private com.opos.mobad.template.a.c u;
    private RelativeLayout v;
    private com.opos.mobad.template.cmn.n w;
    private TextView x;
    private TextView y;
    private com.opos.mobad.template.cmn.w z;

    private c(Context context, int i, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        Context context2;
        float f;
        super(i);
        this.n = null;
        this.F = false;
        this.S = false;
        this.W = 0;
        this.X = true;
        this.Y = new Runnable() { // from class: com.opos.mobad.template.h.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.n() == 8) {
                    return;
                }
                long jD = c.this.h.d();
                c.this.c(jD, c.this.h.c());
                c.this.a(jD);
                if (c.this.I != null) {
                    c.this.I.setProgress(c.this.p());
                }
                c.d(c.this);
                if (c.this.W == 2 && c.this.k == 0 && c.this.O != null && c.this.O.getVisibility() != 0 && c.this.P != null && !TextUtils.isEmpty(c.this.P.getText())) {
                    c.this.O.setVisibility(0);
                }
                if (c.this.W == 3 && c.this.k == 1) {
                    c.this.D();
                }
                if (c.this.W == 7 && c.this.k == 0 && c.this.O != null && c.this.O.getVisibility() != 8) {
                    c.this.O.setVisibility(8);
                }
                c.this.o.postDelayed(this, 1000L);
            }
        };
        this.Z = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.c.14
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.O == null || c.this.O.getVisibility() == 8) {
                    return;
                }
                c.this.O.setVisibility(8);
            }
        };
        this.aa = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.c.15
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.l) {
                    return;
                }
                c.this.E();
            }
        };
        this.b = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.c.16
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                c.this.h(view, iArr);
            }
        };
        this.ab = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.c.17
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                c.this.i(view, iArr);
            }
        };
        this.ac = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.c.18
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                c.this.g(view, iArr);
            }
        };
        this.ad = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.c.19
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z) {
                com.opos.cmn.an.f.a.a("RewardOPTVideoTemplate", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                c.this.a(view, i3, z);
            }
        };
        this.ae = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.h.c.2
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (c.this.A()) {
                    return;
                }
                if (c.this.n() != 8) {
                    c.this.o.removeCallbacks(c.this.Y);
                }
                c.this.c(map);
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                if (c.this.A()) {
                    return;
                }
                c.this.a(new Callable() { // from class: com.opos.mobad.template.h.c.2.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        c.this.B();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                if (c.this.I != null) {
                    c.this.I.setProgress(0);
                    c.this.I.setVisibility(0);
                }
                c.this.o.removeCallbacks(c.this.Y);
                c.this.o.postDelayed(c.this.Y, 10L);
                c cVar = c.this;
                cVar.c(0L, cVar.h.c());
                c.this.v();
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                c.this.l = true;
                c.this.o();
                if (c.this.R != null && c.this.R.e() && c.this.j.J.containsKey("EXT_PARAM_KEY_SHOW_ENDPAGE")) {
                    String str = c.this.j.J.get("EXT_PARAM_KEY_SHOW_ENDPAGE");
                    if (!TextUtils.isEmpty(str) && "1".equals(str)) {
                        c.this.R.f();
                    }
                }
                c.this.o.removeCallbacks(c.this.Y);
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                if (c.this.A()) {
                    return;
                }
                c.this.v();
                if (c.this.h != null) {
                    c cVar = c.this;
                    cVar.b(cVar.h.d(), c.this.h.c());
                }
                if (c.this.n() != 8) {
                    c.this.o.removeCallbacks(c.this.Y);
                    c.this.o.post(c.this.Y);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                if (c.this.A()) {
                    return;
                }
                if (c.this.h != null) {
                    c cVar = c.this;
                    cVar.a(cVar.h.d(), c.this.h.c());
                }
                if (c.this.n() != 8) {
                    c.this.o.removeCallbacks(c.this.Y);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                if (c.this.A()) {
                    return;
                }
                c.this.w();
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                if (c.this.A()) {
                    return;
                }
                c.this.v();
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
                if (c.this.A() || c.this.j == null) {
                    return;
                }
                c cVar = c.this;
                cVar.a(cVar.j, c.this.h);
            }
        };
        this.af = new j.b() { // from class: com.opos.mobad.template.h.c.7
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return c.this.A();
            }
        };
        this.g = context.getApplicationContext();
        this.o = new Handler(Looper.getMainLooper());
        this.T = com.opos.cmn.an.h.f.a.c(this.g);
        this.k = i2;
        Context context3 = this.g;
        if (i2 == 0) {
            this.U = com.opos.cmn.an.h.f.a.a(context3, 506.0f);
            context2 = this.g;
            f = 284.0f;
        } else {
            this.U = com.opos.cmn.an.h.f.a.a(context3, 527.0f);
            context2 = this.g;
            f = 296.0f;
        }
        this.V = com.opos.cmn.an.h.f.a.a(context2, f);
        this.h = aVar;
        this.i = aVar2;
        if (aVar != null) {
            aVar.a(this.ae);
        }
        q();
    }

    private void C() {
        if (this.G == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.p, "translationX", 0.0f, H() * I());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.p, "scaleY", 1.0f, I());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.p, "scaleX", 1.0f, I());
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.t, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.N, "alpha", 0.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        animatorSet.setDuration(0L);
        animatorSet.start();
        this.X = true;
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.G == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.p, "translationX", H() * I(), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.p, "scaleY", I(), 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.p, "scaleX", I(), 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.t, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.t, "translationX", r9.getWidth(), 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.D, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat5, objectAnimatorOfFloat4);
        animatorSet.setDuration(1000L);
        animatorSet.start();
        this.X = false;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.h.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.A()) {
                    return;
                }
                c.this.a(false);
                c.this.G();
            }
        }, 550L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        ProgressBar progressBar = this.I;
        if (progressBar != null) {
            if (progressBar.getParent() != null) {
                ((ViewGroup) this.I.getParent()).removeView(this.I);
            }
            (this.X ? this.q : this.G).addView(this.I, this.J);
        }
    }

    private int H() {
        return (this.T / 2) - (com.opos.cmn.an.h.f.a.a(this.g, 24.0f) + (this.U / 2));
    }

    private float I() {
        return new BigDecimal(this.T).divide(new BigDecimal(this.U - com.opos.cmn.an.h.f.a.a(this.g, 2.0f)), 6, RoundingMode.HALF_UP).floatValue();
    }

    public static /* synthetic */ int d(c cVar) {
        int i = cVar.W;
        cVar.W = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        if (0 == this.h.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.h.d() * 100) / this.h.c()));
    }

    private void q() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.g);
        this.c = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.q = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c.addView(this.q);
        this.q.setVisibility(8);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.g);
        this.p = relativeLayout2;
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(this.g);
        this.r = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.p.addView(this.r);
        View view2 = new View(this.g);
        view2.setBackgroundColor(Color.argb(204, 0, 0, 0));
        view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.p.addView(view2);
        x();
        s();
        u();
        this.q.addView(this.p);
        y();
        r();
        z();
        if (Build.VERSION.SDK_INT >= 29) {
            this.c.setForceDarkAllowed(false);
        }
        if (this.k == 1) {
            C();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.h.c.12
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.A() || c.this.q == null || c.this.q.getVisibility() == 0) {
                    return;
                }
                c.this.q.setVisibility(0);
            }
        }, 10L);
    }

    private void t() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.O = relativeLayout;
        relativeLayout.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 54.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.z.getId());
        layoutParams.bottomMargin = -com.opos.cmn.an.h.f.a.a(this.g, 3.0f);
        this.s.addView(this.O, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.g);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.g, 12.0f));
        gradientDrawable.setColor(Color.argb(255, 36, 124, 255));
        linearLayout.setBackground(gradientDrawable);
        this.O.addView(linearLayout, new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 44.0f)));
        View view = new View(this.g);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 20.0f), com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
        view.setBackgroundResource(R.drawable.opos_mobad_tips_bn);
        layoutParams2.addRule(3, linearLayout.getId());
        layoutParams2.addRule(14);
        this.O.addView(view, layoutParams2);
        TextView textView = new TextView(this.g);
        this.P = textView;
        textView.setTextSize(1, 14.0f);
        this.P.setTextColor(-1);
        this.P.setLines(1);
        this.P.setSingleLine(true);
        this.P.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        layoutParams3.weight = 1.0f;
        linearLayout.addView(this.P, layoutParams3);
        this.Q = new com.opos.mobad.template.cmn.baseview.c(this.g);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 22.0f), com.opos.cmn.an.h.f.a.a(this.g, 22.0f));
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
        linearLayout.addView(this.Q, layoutParams4);
        View view2 = new View(this.g);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 18.0f), com.opos.cmn.an.h.f.a.a(this.g, 18.0f));
        layoutParams5.addRule(13);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.g, 18.0f));
        gradientDrawable2.setColor(Color.argb(77, 255, 255, 255));
        view2.setBackground(gradientDrawable2);
        this.Q.addView(view2, layoutParams5);
        ImageView imageView = new ImageView(this.g);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_tips_close_inter);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 8.0f), com.opos.cmn.an.h.f.a.a(this.g, 8.0f));
        layoutParams6.addRule(13);
        this.Q.addView(imageView, layoutParams6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        return n() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.m == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
            this.m = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.c.5
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (c.this.j == null) {
                        return;
                    }
                    if (!z) {
                        c.this.l();
                        return;
                    }
                    c.this.a(com.opos.mobad.template.h.a(c.this.R));
                    c.this.k();
                    if (c.this.R == null || c.this.R.c() == null || c.this.R.c().getVisibility() == 0) {
                        return;
                    }
                    c.this.R.c().setVisibility(0);
                }
            });
            this.m.a(new a.c() { // from class: com.opos.mobad.template.h.c.6
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "onViewVisibleWithoutFocus: " + z + ", " + z2);
                    if (c.this.j == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.template.h.a(c.this.R);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    c.this.b(mapA);
                }
            }, c());
        }
        if (this.c.indexOfChild(this.m) < 0) {
            this.c.addView(this.m, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.G == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.p, "translationX", 0.0f, H() * I());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.p, "scaleY", 1.0f, I());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.p, "scaleX", 1.0f, I());
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.D, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.t, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.t, "translationX", 0.0f, r10.getWidth());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat4, objectAnimatorOfFloat6, objectAnimatorOfFloat5);
        animatorSet.setDuration(1000L);
        com.opos.mobad.template.e.c.a aVar = this.R;
        if (aVar != null && aVar.c() != null) {
            this.G.removeView(this.R.c());
        }
        animatorSet.start();
        this.X = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.h.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.A()) {
                    return;
                }
                c.this.F();
                c.this.a(true);
                c.this.G();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.N, "translationY", com.opos.cmn.an.h.f.a.a(this.g, 80.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.N, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        com.opos.mobad.template.e.c.a aVar = this.R;
        if (aVar == null || aVar.c() == null) {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, ObjectAnimator.ofFloat(this.R.c(), "translationY", com.opos.cmn.an.h.f.a.a(this.g, 138.0f), 0.0f), ObjectAnimator.ofFloat(this.R.c(), "alpha", 0.0f, 1.0f));
        }
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public static com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new c(context, i, 1, aVar, aVar2);
    }

    private void r() {
        if (this.k == 0) {
            return;
        }
        this.N = new com.opos.mobad.template.cmn.baseview.c(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.N.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        this.q.addView(this.N, layoutParams);
        this.M = f.a(this.g, this.i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 360.0f), com.opos.cmn.an.h.f.a.a(this.g, 64.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        this.N.addView(this.M, layoutParams2);
    }

    private void s() {
        int iA;
        int iA2;
        this.t = new com.opos.mobad.template.cmn.baseview.c(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(1, this.G.getId());
        layoutParams.addRule(6, this.G.getId());
        layoutParams.addRule(8, this.G.getId());
        layoutParams.addRule(15);
        this.p.addView(this.t, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.s = relativeLayout;
        relativeLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        if (this.k == 0) {
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 26.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        } else {
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 15.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        }
        layoutParams3.topMargin = iA;
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        this.t.addView(this.s, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.g);
        this.v = relativeLayout2;
        relativeLayout2.setId(View.generateViewId());
        int iA3 = com.opos.cmn.an.h.f.a.a(this.g, 0.33f);
        this.v.setPadding(iA3, iA3, iA3, iA3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 68.0f), com.opos.cmn.an.h.f.a.a(this.g, 68.0f));
        layoutParams4.addRule(14);
        this.s.addView(this.v, layoutParams4);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.g, com.opos.cmn.an.h.f.a.a(r10, 12.0f));
        this.w = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(14);
        this.v.addView(this.w, layoutParams5);
        TextView textView = new TextView(this.g);
        this.x = textView;
        textView.setId(View.generateViewId());
        this.x.setGravity(1);
        this.x.setTextSize(1, 16.0f);
        this.x.setTextColor(Color.argb(229, 255, 255, 255));
        this.x.setMaxEms(10);
        this.x.setLines(1);
        this.x.setSingleLine(true);
        this.x.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.x);
        layoutParams3.addRule(3, this.v.getId());
        layoutParams3.addRule(14);
        this.s.addView(this.x, layoutParams3);
        int iA4 = com.opos.cmn.an.h.f.a.a(this.g, 209.0f);
        int iA5 = com.opos.cmn.an.h.f.a.a(this.g, 44.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iA4, iA5);
        if (this.k == 0) {
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
            layoutParams7.addRule(3, this.x.getId());
            TextView textView2 = new TextView(this.g);
            this.y = textView2;
            textView2.setId(View.generateViewId());
            this.y.setTextSize(1, 14.0f);
            this.y.setTextColor(Color.argb(102, 255, 255, 255));
            this.y.setMaxLines(2);
            this.y.setEllipsize(TextUtils.TruncateAt.END);
            this.s.addView(this.y, layoutParams7);
            layoutParams6.addRule(3, this.y.getId());
            iA2 = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        } else {
            layoutParams6.addRule(3, this.x.getId());
            iA2 = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        }
        layoutParams6.topMargin = iA2;
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.z = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 50.0f));
        this.z.setId(View.generateViewId());
        this.z.setBackgroundResource(R.drawable.opos_mobad_btn_bg_blue);
        layoutParams6.addRule(14);
        this.s.addView(this.z, layoutParams6);
        this.B = new TextView(this.g);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        this.B.setTextSize(1, 16.0f);
        this.B.setTextColor(-1);
        this.B.setLines(1);
        this.B.setSingleLine(true);
        this.B.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.B);
        this.z.addView(this.B, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        if (this.k == 0) {
            layoutParams9.addRule(3, this.z.getId());
            t();
        } else {
            com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.g);
            this.A = wVar2;
            wVar2.setId(View.generateViewId());
            this.A.a(com.opos.cmn.an.h.f.a.a(this.g, 50.0f));
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(iA4, iA5);
            layoutParams10.addRule(3, this.z.getId());
            layoutParams10.addRule(14);
            layoutParams10.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
            this.A.setBackgroundResource(R.drawable.opos_mobad_btn_bg_black);
            this.s.addView(this.A, layoutParams10);
            this.C = new BaseTextView(this.g);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams11.addRule(13);
            this.C.setTextSize(1, 16.0f);
            this.C.setTextColor(-1);
            this.C.setLines(1);
            this.C.setSingleLine(true);
            this.C.setEllipsize(TextUtils.TruncateAt.END);
            com.opos.mobad.template.h.a(this.C);
            this.A.addView(this.C, layoutParams11);
            layoutParams9.addRule(3, this.A.getId());
        }
        layoutParams9.addRule(14);
        layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.g);
        this.u = cVar;
        cVar.setVisibility(8);
        this.s.addView(this.u, layoutParams9);
    }

    private void u() {
        this.K = new ProgressBar(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 20.0f), com.opos.cmn.an.h.f.a.a(this.g, 29.0f));
        layoutParams.addRule(13);
        this.K.setVisibility(8);
        this.p.addView(this.K, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        View view = this.K;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        View view = this.K;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void x() {
        int i = this.U;
        int i2 = this.V;
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 0.5f);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.G = wVar;
        wVar.setId(View.generateViewId());
        this.G.a(com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        if (this.k == 0) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 52.0f);
        } else {
            layoutParams.addRule(15);
        }
        this.p.addView(this.G, layoutParams);
        com.opos.mobad.d.d.a aVar = this.h;
        if (aVar != null) {
            this.f9980a = aVar.b();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            this.f9980a.setPadding(iA, iA, iA, iA);
            this.G.addView(this.f9980a, layoutParams2);
        }
        this.H = new com.opos.mobad.template.cmn.g(this.g, new int[]{DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR}, new float[]{0.0f, 1.0f}).a(com.opos.cmn.an.h.f.a.a(this.g, 16.0f)).b(com.opos.cmn.an.h.f.a.a(this.g, 0.5f)).a(Paint.Style.STROKE);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i2);
        layoutParams3.addRule(14);
        this.G.addView(this.H, layoutParams3);
        this.L = com.opos.mobad.template.k.c.a(this.g, 0, 0, this.i);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        layoutParams4.addRule(11);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.G.addView(this.L, layoutParams4);
        ProgressBar progressBar = new ProgressBar(this.g);
        this.I = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.template.cmn.af.a(this.I, "mOnlyIndeterminate", new Boolean(false));
        this.I.setIndeterminate(false);
        this.I.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.I.setBackgroundColor(Color.argb(77, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 2.0f));
        this.J = layoutParams5;
        layoutParams5.addRule(12);
        this.I.setVisibility(0);
        this.G.addView(this.I, this.J);
    }

    private void y() {
        LinearLayout linearLayout = new LinearLayout(this.g);
        linearLayout.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 28.0f);
        LinearLayout linearLayout2 = new LinearLayout(this.g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        layoutParams.weight = 1.0f;
        u uVarA = u.a(this.g, 2);
        this.D = uVarA;
        uVarA.setId(View.generateViewId());
        linearLayout2.addView(this.D, new LinearLayout.LayoutParams(-2, iA));
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout linearLayout3 = new LinearLayout(this.g);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
        z zVarA = z.a(this.g, 1);
        this.E = zVarA;
        zVarA.setId(View.generateViewId());
        linearLayout3.addView(this.E, new RelativeLayout.LayoutParams(-2, iA));
        linearLayout.addView(linearLayout3, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.q.addView(linearLayout, layoutParams3);
    }

    private void z() {
        com.opos.mobad.template.cmn.p.a(this.z, this.ac);
        this.z.a(this.ad);
        com.opos.mobad.template.cmn.p.a(this.t, this.b);
        this.t.a(this.ad);
        com.opos.mobad.template.cmn.p.a(this.G, this.ab);
        this.G.a(this.ad);
        com.opos.mobad.template.cmn.w wVar = this.A;
        if (wVar != null) {
            com.opos.mobad.template.cmn.p.a(wVar, this.aa);
            this.A.a(this.ad);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.Q;
        if (cVar != null) {
            com.opos.mobad.template.cmn.p.a(cVar, this.Z);
            this.Q.a(this.ad);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.d.d.a aVar = this.h;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            if (aVar.i() != 5) {
                this.h.g();
            }
        }
        com.opos.mobad.template.e.c.a aVar2 = this.R;
        if (aVar2 == null || !aVar2.e()) {
            return true;
        }
        this.R.h();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.d.d.a aVar = this.h;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            if (aVar.i() == 2) {
                this.h.f();
            }
        }
        com.opos.mobad.template.e.c.a aVar2 = this.R;
        if (aVar2 == null || !aVar2.e()) {
            return true;
        }
        this.R.i();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.j = null;
        com.opos.mobad.d.d.a aVar = this.h;
        if (aVar != null) {
            aVar.f();
            this.h.h();
        }
        f fVar = this.M;
        if (fVar != null) {
            fVar.a();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.R;
        if (aVar2 != null) {
            aVar2.j();
        }
        this.o.removeCallbacks(this.Y);
        com.opos.mobad.template.cmn.baseview.c cVar = this.c;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    public static com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new c(context, i, 0, aVar, aVar2);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.i == null || cVar == null || (eVar = cVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a((Bitmap) null);
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 68.0f);
        com.opos.mobad.template.d.e eVar2 = cVar.k;
        com.opos.mobad.template.cmn.j.a(eVar2.f9414a, eVar2.b, iA, iA, this.i, new j.c() { // from class: com.opos.mobad.template.h.c.8
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (i != 1) {
                    c.this.a((Bitmap) null);
                }
                c.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                c.this.a(bitmap);
            }
        }, this.af);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.c cVar = this.j;
        if (cVar == null || this.F) {
            return;
        }
        long j2 = cVar.C;
        if (j2 <= 0 || j >= j2) {
            this.F = true;
            this.E.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.A()) {
                    return;
                }
                if (bitmap != null) {
                    c.this.w.setImageBitmap(bitmap);
                    return;
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(c.this.g, 0.33f), Color.parseColor("#1FFFFFFF"));
                gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(c.this.g, 12.0f));
                gradientDrawable.setColor(Color.parseColor("#14FFFFFF"));
                c.this.v.setBackground(gradientDrawable);
            }
        });
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.E.a(this.e);
        this.D.a(this.e);
        this.u.a(this.e);
        this.L.a(this.e);
        f fVar = this.M;
        if (fVar != null) {
            fVar.a(this.e);
        }
        this.E.a(new z.a() { // from class: com.opos.mobad.template.h.c.13
            @Override // com.opos.mobad.template.h.z.a
            public void a(int i) {
                if (c.this.h == null) {
                    return;
                }
                c.this.h.a(i == 1 ? 1.0f : 0.0f);
            }
        });
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.S) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.g, e(), bVar.L);
            this.R = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.h.c.4
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    c.this.i().a(i, iArr);
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    c.this.i().g(view, iArr);
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    c.this.i().h(view, iArr);
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    c.this.i().a(iArr);
                }
            });
            if (this.k == 0 && this.R.e() && this.R.c() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 46.0f));
                View view = new View(this.g);
                view.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 0);
                layoutParams2.addRule(12);
                layoutParams.addRule(14);
                layoutParams.addRule(2, view.getId());
                this.G.addView(view, layoutParams2);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
                this.G.addView(this.R.c(), layoutParams);
            }
            this.S = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.R;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.a.c cVar2;
        String str;
        if (cVar != null) {
            b(cVar);
            a((com.opos.mobad.template.d.b) cVar);
            if (this.x != null && !TextUtils.isEmpty(cVar.b)) {
                this.x.setText(cVar.b);
            }
            if (this.y != null && !TextUtils.isEmpty(cVar.f9413a)) {
                this.y.setText(cVar.f9413a);
            }
            if (this.B != null && !TextUtils.isEmpty(cVar.j)) {
                this.B.setText(cVar.j);
            }
            if (this.C != null && cVar.J.containsKey("EXT_PARAM_KEY_COUNTDOWN")) {
                String str2 = cVar.J.get("EXT_PARAM_KEY_COUNTDOWN");
                if (!TextUtils.isEmpty(str2)) {
                    if ("0".equals(str2)) {
                        this.C.setTextColor(Color.argb(102, 255, 255, 255));
                        str = "已获得奖励";
                    } else {
                        str = str2 + "S 后领取";
                    }
                    this.C.setText(str);
                }
            }
            u uVar = this.D;
            if (uVar != null) {
                uVar.a(cVar.q, cVar.B);
            }
            z zVar = this.E;
            if (zVar != null) {
                zVar.a(cVar.A);
            }
            if (this.P != null && !TextUtils.isEmpty(cVar.r)) {
                this.P.setText(cVar.r);
            }
            com.opos.mobad.template.k.c cVar3 = this.L;
            if (cVar3 != null) {
                cVar3.a(cVar.p, cVar.e, cVar.g, cVar.i);
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.a(cVar, this.i);
            }
            com.opos.mobad.template.d.a aVar = cVar.u;
            if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(cVar.u.b) || (cVar2 = this.u) == null) {
                return;
            }
            com.opos.mobad.template.d.a aVar2 = cVar.u;
            cVar2.a(aVar2.f9412a, aVar2.b);
            this.u.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.c cVar, com.opos.mobad.d.d.a aVar) {
        if (this.n == null) {
            com.opos.mobad.template.cmn.af.a(aVar, cVar.N.f9414a, new af.a() { // from class: com.opos.mobad.template.h.c.3
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(Bitmap bitmap) {
                    if (c.this.n() == 8) {
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.n = com.opos.mobad.template.cmn.f.a(cVar2.g, bitmap, 75, 0.25f, 60.0f);
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.n() == 8) {
                                return;
                            }
                            c.this.p.setBackground(new BitmapDrawable(c.this.n));
                            c.this.r.setBackground(new BitmapDrawable(c.this.n));
                        }
                    });
                }
            });
        } else {
            this.p.setBackground(new BitmapDrawable(this.n));
            this.r.setBackground(new BitmapDrawable(this.n));
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
                if (this.j == null) {
                    this.h.a(cVarB.N.f9414a, false);
                    this.h.a(cVarB.A == 1 ? 1.0f : 0.0f);
                }
                this.j = cVarB;
                return;
            }
            com.opos.cmn.an.f.a.d("RewardOPTVideoTemplate", "render with data null");
        }
        a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.opos.mobad.template.e.c.a aVar;
        ViewGroup viewGroup;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 46.0f));
        View view = new View(this.g);
        view.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams2.addRule(12);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        if (this.k != 1 || (aVar = this.R) == null || !aVar.e() || this.R.c() == null) {
            return;
        }
        if (z) {
            this.q.addView(view, layoutParams2);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 92.0f);
            viewGroup = this.q;
        } else {
            this.G.addView(view, layoutParams2);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 24.0f);
            viewGroup = this.G;
        }
        viewGroup.addView(this.R.c(), layoutParams);
    }
}
