package com.opos.mobad.template.e.c;

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
public class d extends a implements d.a {
    private b c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private k g;
    private x h;
    private Animator i;
    private Animator j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private com.opos.mobad.template.k.d r;
    private boolean s;

    public d(Context context, com.opos.mobad.template.e.a aVar, int i, boolean z) {
        this(context, aVar, i, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        x xVar = this.h;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.h.getWidth();
        this.g = new k(this.b, this.n, width);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
        layoutParams.addRule(13);
        this.d.addView(this.g, layoutParams);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        if (this.m) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.d = relativeLayout;
            relativeLayout.setVisibility(4);
            this.d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.d.setClipChildren(false);
            x xVar = new x(this.b);
            this.h = xVar;
            xVar.setVisibility(4);
            this.h.a(com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
            this.h.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
            layoutParams.addRule(13);
            this.h.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 15.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 16.0f), 0);
            this.h.setBackgroundColor(Color.argb(138, 66, 70, 76));
            this.d.addView(this.h, layoutParams);
            this.e = new ImageView(this.b);
            LinearLayout.LayoutParams layoutParams2 = this.k == 1 ? new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 21.0f), com.opos.cmn.an.h.f.a.a(this.b, 21.0f)) : new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 27.0f), com.opos.cmn.an.h.f.a.a(this.b, 27.0f));
            layoutParams2.gravity = 16;
            this.e.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.h.addView(this.e, layoutParams2);
            TextView textView = new TextView(this.b);
            this.f = textView;
            textView.setTextSize(1, this.k == 1 ? 14.0f : 18.0f);
            this.f.setText("摇一摇");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 9.0f);
            layoutParams3.gravity = 16;
            this.f.setTextColor(-1);
            h.a(this.f);
            this.h.addView(this.f, layoutParams3);
            this.r = new com.opos.mobad.template.k.d(this.b, this.s, this);
            if (this.l) {
                this.j = ae.e(this.e);
            }
            a(this.b);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.m;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void f() {
        i();
        this.o = true;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.m && !this.q) {
            this.q = true;
            if (this.l) {
                Animator animatorB = ae.b((View) this.d);
                this.i = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.j.start();
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
                this.i.start();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("InteractiveShakeView", "isEnd:" + this.o + " mIsViewVisible:" + this.p);
        if (!this.o && this.p && this.m) {
            this.r.b();
            k kVar = this.g;
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.m) {
            this.r.c();
        }
        k kVar = this.g;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.i);
        h.a(this.j);
        f();
        com.opos.mobad.template.k.d dVar = this.r;
        if (dVar != null) {
            dVar.d();
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public d(Context context, com.opos.mobad.template.e.a aVar, int i, boolean z, boolean z2) {
        super(context, aVar);
        this.o = false;
        this.p = false;
        this.q = false;
        this.n = z;
        this.k = i;
        this.s = z2;
        a();
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.l = h.a();
        this.m = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.d.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                d.this.p = z;
                if (!z) {
                    d.this.i();
                    return;
                }
                if (d.this.h != null && d.this.h.getVisibility() != 0) {
                    d.this.h.setVisibility(0);
                    d.this.k();
                }
                d.this.g();
                d.this.h();
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.m || aVar == null) {
            return;
        }
        com.opos.mobad.template.k.d dVar = this.r;
        if (dVar != null) {
            dVar.a(aVar);
        }
        if (TextUtils.isEmpty(aVar.b)) {
            return;
        }
        this.f.setText("摇一摇" + aVar.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(b bVar) {
        this.c = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        b bVar;
        if (this.o || !this.p || !this.m || (bVar = this.c) == null) {
            return;
        }
        bVar.a(iArr);
        i();
        k kVar = this.g;
        if (kVar != null) {
            kVar.c();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.r != null) {
                    d.this.r.a();
                    d.this.h();
                }
            }
        }, com.igexin.push.config.c.j);
    }
}
