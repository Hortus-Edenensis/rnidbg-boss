package com.opos.mobad.template.e.c.b;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.k;
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends com.opos.mobad.template.e.c.a implements d.a {
    private int c;
    private int d;
    private int e;
    private com.opos.mobad.template.e.c.b f;
    private RelativeLayout g;
    private ImageView h;
    private TextView i;
    private k j;
    private x k;
    private Animator l;
    private Animator m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private d u;

    public b(Context context, com.opos.mobad.template.e.a aVar, int i, boolean z, String str) {
        super(context, aVar);
        this.c = 4;
        this.q = false;
        this.r = false;
        this.s = false;
        this.p = z;
        this.t = str;
        k();
        b(i);
        a();
        a(i);
    }

    private void k() {
        Context context = this.b;
        if (context == null || context.getResources() == null || this.b.getResources().getConfiguration() == null) {
            return;
        }
        this.p = this.b.getResources().getConfiguration().orientation != 2;
    }

    private void l() {
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        layoutParams.height = com.opos.cmn.an.h.f.a.a(this.b, 20.0f);
        layoutParams.width = com.opos.cmn.an.h.f.a.a(this.b, 20.0f);
        this.h.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        x xVar = this.k;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.k.getWidth() - com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        int height = this.k.getHeight() - com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        this.j = new k(this.b, this.p, width, height, this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f) / 2;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f) / 2;
        this.g.addView(this.j, layoutParams);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        TextView textView;
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.g = relativeLayout;
        relativeLayout.setVisibility(4);
        this.g.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.g.setClipChildren(false);
        x xVar = new x(this.b);
        this.k = xVar;
        xVar.setVisibility(4);
        this.k.a(this.e);
        this.k.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.d);
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0);
        x xVar2 = this.k;
        String str = this.t;
        xVar2.setBackgroundColor(str != null ? Color.parseColor(str) : Color.argb(138, 66, 70, 76));
        this.g.addView(this.k, layoutParams);
        this.h = new ImageView(this.b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
        layoutParams2.gravity = 16;
        this.h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.k.addView(this.h, layoutParams2);
        TextView textView2 = new TextView(this.b);
        this.i = textView2;
        textView2.setTextSize(1, 18.0f);
        this.i.setText("摇一摇");
        this.i.setMaxEms(12);
        this.i.setMaxLines(1);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, this.c);
        layoutParams3.gravity = 16;
        h.a(this.i);
        this.k.addView(this.i, layoutParams3);
        if (this.t != null) {
            this.h.setImageResource(R.drawable.opos_mobad_icon_hand_nt_btn);
            textView = this.i;
            i = -1;
        } else {
            this.h.setImageResource(R.drawable.opos_mobad_icon_hand_nt);
            textView = this.i;
            i = -436207617;
        }
        textView.setTextColor(i);
        l();
        this.u = new d(this.b, true, this);
        if (this.n) {
            this.m = ae.f(this.h);
        }
        a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.o;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void f() {
        i();
        this.q = true;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.o && !this.s) {
            this.s = true;
            if (this.n) {
                Animator animatorB = ae.b((View) this.g);
                this.l = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.b.b.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.m.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.l.start();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("NatTempInteractiveShakeView", "isEnd:" + this.q + " mIsViewVisible:" + this.r);
        if (!this.q && this.r && this.o) {
            this.u.b();
            k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.o) {
            this.u.c();
        }
        k kVar = this.j;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.l);
        h.a(this.m);
        f();
        d dVar = this.u;
        if (dVar != null) {
            dVar.d();
        }
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    private void b(int i) {
        Context context;
        float f;
        if (i == 0) {
            context = this.b;
            f = 28.0f;
        } else {
            if (i != 1) {
                return;
            }
            context = this.b;
            f = 44.0f;
        }
        this.d = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = com.opos.cmn.an.h.f.a.a(this.b, f);
    }

    private void d(int i) {
        int i2;
        int i3;
        if (i == 0) {
            i2 = 8;
            i3 = 10;
        } else if (i != 1) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = 18;
            i3 = 18;
        }
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.b, i2), com.opos.cmn.an.h.f.a.a(this.b, 0.0f), com.opos.cmn.an.h.f.a.a(this.b, i3), com.opos.cmn.an.h.f.a.a(this.b, 0.0f));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.n = h.a();
        this.o = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.g;
    }

    private void a(int i) {
        if (this.o) {
            b();
            d(i);
            c(i);
        }
    }

    private void c(int i) {
        TextView textView;
        float f;
        if (i == 0) {
            textView = this.i;
            f = 12.0f;
        } else {
            if (i != 1) {
                return;
            }
            textView = this.i;
            f = 16.0f;
        }
        textView.setTextSize(1, f);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.b.b.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                b.this.r = z;
                if (!z) {
                    b.this.i();
                    return;
                }
                if (b.this.k != null && b.this.k.getVisibility() != 0) {
                    b.this.k.setVisibility(0);
                    b.this.m();
                }
                b.this.g();
                b.this.h();
            }
        });
        this.g.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.o || aVar == null) {
            return;
        }
        d dVar = this.u;
        if (dVar != null) {
            dVar.a(aVar);
        }
        if (TextUtils.isEmpty(aVar.b)) {
            return;
        }
        this.i.setText("摇一摇" + aVar.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.f = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        com.opos.mobad.template.e.c.b bVar;
        if (this.q || !this.r || !this.o || (bVar = this.f) == null) {
            return;
        }
        bVar.a(iArr);
        i();
        k kVar = this.j;
        if (kVar != null) {
            kVar.c();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.u != null) {
                    b.this.u.a();
                    b.this.h();
                }
            }
        }, com.igexin.push.config.c.j);
    }
}
