package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.e;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f extends com.opos.mobad.template.e.c.a implements e.a {
    float c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private RelativeLayout h;
    private RelativeLayout i;
    private RelativeLayout j;
    private ImageView k;
    private w l;
    private w m;
    private RelativeLayout n;
    private TextView o;
    private com.opos.mobad.template.e.c.b p;
    private AnimatorSet q;
    private com.opos.mobad.template.k.e r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;

    public f(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.f = false;
        this.g = false;
        this.s = false;
        this.t = com.opos.mobad.template.e.b.a.r;
        this.u = com.opos.mobad.template.e.b.a.s;
        this.v = true;
        a();
        b();
    }

    private void k() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.j, "rotationY", 0.0f, 30.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.l, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        animatorSet.setStartDelay(500L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.j, "rotationY", 30.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.l, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 0.8f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.8f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(300L);
        animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfPropertyValuesHolder2);
        animatorSet2.setStartDelay(500L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.j, "rotationY", 360.0f, 330.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("scaleX", 0.8f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.8f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(200L);
        animatorSet3.playTogether(objectAnimatorOfFloat4, objectAnimatorOfPropertyValuesHolder3);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.j, "rotationY", 330.0f, 360.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.m, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.setDuration(200L);
        animatorSet4.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        animatorSet4.setStartDelay(500L);
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.q = animatorSet5;
        animatorSet5.playSequentially(animatorSet, animatorSet2, animatorSet3, animatorSet4);
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.e.c.d.f.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.q.start();
            }
        });
    }

    private void l() {
        RelativeLayout relativeLayout;
        float f;
        if (this.s) {
            return;
        }
        if (this.c > 0.0f) {
            this.m.setAlpha(0.0f);
            this.l.setAlpha(1.0f);
            this.l.setScaleX(1.0f);
            relativeLayout = this.j;
            f = 30.0f;
        } else {
            this.l.setAlpha(0.0f);
            this.m.setAlpha(1.0f);
            this.m.setScaleX(1.0f);
            relativeLayout = this.j;
            f = 330.0f;
        }
        relativeLayout.setRotationY(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.s) {
            return;
        }
        this.l.setAlpha(0.0f);
        this.m.setAlpha(0.0f);
        this.j.setRotationY(0.0f);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        this.h = new RelativeLayout(this.b);
        this.i = new RelativeLayout(this.b);
        this.h.addView(this.i, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 176.0f)));
        this.h.setVisibility(4);
        TextView textView = new TextView(this.b);
        this.o = textView;
        textView.setId(View.generateViewId());
        this.o.setTextSize(1, 18.0f);
        this.o.setText("倾斜手机");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.o.setTextColor(-1);
        h.a(this.o);
        this.o.setVisibility(4);
        this.i.addView(this.o, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.n = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, 4.0f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, this.o.getId());
        this.i.addView(this.n, layoutParams2);
        this.n.setVisibility(4);
        this.j = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.n.addView(this.j, layoutParams3);
        this.k = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams4.addRule(14);
        this.k.setImageResource(R.drawable.opos_mobad_phone);
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.j.addView(this.k, layoutParams4);
        w wVar = new w(this.b);
        this.l = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 6.0f));
        this.l.setBackgroundColor(Color.argb(153, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams5.addRule(15);
        this.l.setPivotX(0.0f);
        this.l.setAlpha(0.0f);
        this.j.addView(this.l, layoutParams5);
        w wVar2 = new w(this.b);
        this.m = wVar2;
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.b, 6.0f));
        this.m.setBackgroundColor(Color.argb(153, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams6.addRule(15);
        this.m.setPivotX(com.opos.cmn.an.h.f.a.a(this.b, 30.0f));
        this.m.setAlpha(0.0f);
        this.j.addView(this.m, layoutParams6);
        if (this.e) {
            this.r = new com.opos.mobad.template.k.e(this.b, this);
            if (this.d) {
                k();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.h;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.d && !this.f) {
            this.f = true;
            if (this.e) {
                this.r.b();
                if (this.d) {
                    if (this.v || !this.r.a()) {
                        this.q.start();
                    }
                }
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.e) {
            this.r.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.e) {
            this.r.d();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.s = true;
        h.a(this.q);
        com.opos.mobad.template.k.e eVar = this.r;
        if (eVar != null) {
            eVar.d();
        }
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.d = h.a();
        this.e = h.b(this.b);
    }

    @Override // com.opos.mobad.template.k.e.a
    public void a(float f, float f2) {
        if (this.s || this.v) {
            return;
        }
        if (!this.e || this.r.a()) {
            float fFloatValue = new BigDecimal(Math.abs(f2 - f)).divide(new BigDecimal(this.t), 6, RoundingMode.HALF_UP).floatValue();
            if (fFloatValue <= 1.0f) {
                this.c = f2;
                if (f2 > 0.0f) {
                    this.m.setAlpha(0.0f);
                    this.l.setAlpha(fFloatValue);
                    this.l.setScaleX(fFloatValue);
                    this.j.setRotationY(fFloatValue * 30.0f);
                    return;
                }
                this.l.setAlpha(0.0f);
                this.m.setAlpha(fFloatValue);
                this.m.setScaleX(fFloatValue);
                this.j.setRotationY(360.0f - (fFloatValue * 30.0f));
            }
        }
    }

    @Override // com.opos.mobad.template.k.e.a
    public void a(int i, int[] iArr) {
        if (this.s || this.p == null) {
            return;
        }
        l();
        this.p.a(i, iArr);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.d.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.m();
            }
        }, 1000L);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        com.opos.mobad.template.k.e eVar;
        if (aVar instanceof com.opos.mobad.template.e.b.g) {
            com.opos.mobad.template.e.b.g gVar = (com.opos.mobad.template.e.b.g) aVar;
            int i = gVar.D;
            if (i > 0) {
                this.u = i;
            }
            int i2 = gVar.E;
            if (i2 > 0) {
                this.t = i2;
            }
            this.v = gVar.F;
        }
        if (this.e) {
            this.n.setVisibility(0);
            this.o.setVisibility(0);
            com.opos.mobad.template.k.e eVar2 = this.r;
            if (eVar2 != null) {
                eVar2.a(this.t, this.u, this.v);
            }
            if (this.d && this.f && !this.g) {
                this.g = true;
                if (this.v || !((eVar = this.r) == null || eVar.a())) {
                    if (this.q.isStarted()) {
                        return;
                    }
                    this.q.start();
                } else if (this.q.isStarted()) {
                    this.q.cancel();
                }
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.p = bVar;
    }
}
