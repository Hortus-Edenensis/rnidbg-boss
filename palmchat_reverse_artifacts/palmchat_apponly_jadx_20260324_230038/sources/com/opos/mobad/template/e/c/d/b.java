package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.b;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends com.opos.mobad.template.e.c.a implements b.a {
    private boolean c;
    private boolean d;
    private boolean e;
    private com.opos.mobad.template.cmn.baseview.c f;
    private RelativeLayout g;
    private RelativeLayout h;
    private ImageView i;
    private w j;
    private RelativeLayout k;
    private TextView l;
    private LinearLayout m;
    private ImageView n;
    private ImageView o;
    private com.opos.mobad.template.e.c.b p;
    private AnimatorSet q;
    private Animator r;
    private com.opos.mobad.template.k.b s;
    private boolean t;
    private int u;
    private int v;

    public b(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.e = false;
        this.t = false;
        this.u = com.opos.mobad.template.e.b.a.u;
        this.v = com.opos.mobad.template.e.b.a.v;
        a();
        b();
    }

    private void k() {
        this.q = new AnimatorSet();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("translationY", 0.0f, com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1800L);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(167L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.n, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.39f, 1.0f, 0.39f, 1.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(2000L);
        objectAnimatorOfPropertyValuesHolder2.setStartDelay(167L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.o, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.39f, 1.0f, 0.39f, 1.0f));
        objectAnimatorOfPropertyValuesHolder3.setDuration(2500L);
        objectAnimatorOfPropertyValuesHolder3.setStartDelay(517L);
        this.q.setInterpolator(new LinearInterpolator());
        this.q.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3);
        this.q.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.b.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.q.start();
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
    }

    private void l() {
        if (this.t) {
            return;
        }
        this.j.setAlpha(1.0f);
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = com.opos.cmn.an.h.f.a.a(this.b, com.opos.cmn.an.h.f.a.a(r1, 48.0f));
        this.h.updateViewLayout(this.j, layoutParams);
        this.h.setTranslationY(-com.opos.cmn.an.h.f.a.a(this.b, 3.0f));
        this.h.setRotationX(40.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.t) {
            return;
        }
        this.j.setAlpha(0.0f);
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = com.opos.cmn.an.h.f.a.a(this.b, com.opos.cmn.an.h.f.a.a(r2, 0.0f));
        this.h.updateViewLayout(this.j, layoutParams);
        this.h.setTranslationY(0.0f);
        this.h.setRotationX(0.0f);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        this.f = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.g = new RelativeLayout(this.b);
        this.f.addView(this.g, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 176.0f)));
        this.f.setVisibility(4);
        TextView textView = new TextView(this.b);
        this.l = textView;
        textView.setId(View.generateViewId());
        this.l.setTextSize(1, 18.0f);
        this.l.setText("前倾手机");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.l.setTextColor(-1);
        h.a(this.l);
        this.l.setVisibility(4);
        this.g.addView(this.l, layoutParams);
        this.k = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, this.l.getId());
        this.g.addView(this.k, layoutParams2);
        this.k.setVisibility(4);
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.m = linearLayout;
        linearLayout.setClipChildren(false);
        this.m.setOrientation(1);
        this.m.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 22.0f));
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 3.0f);
        layoutParams3.addRule(14);
        this.k.addView(this.m, layoutParams3);
        ImageView imageView = new ImageView(this.b);
        this.n = imageView;
        imageView.setBackgroundResource(R.drawable.opos_mobad_triangle_1);
        this.m.addView(this.n, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 18.0f), com.opos.cmn.an.h.f.a.a(this.b, 10.0f)));
        ImageView imageView2 = new ImageView(this.b);
        this.o = imageView2;
        imageView2.setBackgroundResource(R.drawable.opos_mobad_triangle_2);
        this.m.addView(this.o, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 18.0f), com.opos.cmn.an.h.f.a.a(this.b, 10.0f)));
        this.h = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        this.h.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, 2.0f));
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        this.k.addView(this.h, layoutParams4);
        this.i = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams5.addRule(14);
        this.i.setImageResource(R.drawable.opos_mobad_phone);
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h.addView(this.i, layoutParams5);
        w wVar = new w(this.b);
        this.j = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 10.0f));
        this.j.setBackgroundColor(Color.argb(153, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 28.0f), com.opos.cmn.an.h.f.a.a(this.b, 0.0f));
        layoutParams6.addRule(14);
        layoutParams6.addRule(12);
        this.h.addView(this.j, layoutParams6);
        if (this.c) {
            k();
        }
        if (this.d) {
            this.s = new com.opos.mobad.template.k.b(this.b, this);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.d;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.c && !this.e) {
            this.e = true;
            Animator animatorB = ae.b((View) this.f);
            this.r = animatorB;
            animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    b.this.q.start();
                    if (b.this.d) {
                        b.this.s.a();
                    }
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
            this.r.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.d) {
            this.s.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.d) {
            this.s.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.t = true;
        h.a(this.r);
        h.a(this.q);
        com.opos.mobad.template.k.b bVar = this.s;
        if (bVar != null) {
            bVar.c();
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.f;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.c = h.a();
        this.d = h.b(this.b);
    }

    @Override // com.opos.mobad.template.k.b.a
    public void a(float f, float f2) {
        if (this.t) {
            return;
        }
        float fFloatValue = new BigDecimal(Math.abs(f2 - f)).divide(new BigDecimal(this.u), 6, RoundingMode.HALF_UP).floatValue();
        if (fFloatValue <= 1.0f) {
            this.j.setAlpha(fFloatValue);
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            layoutParams.height = com.opos.cmn.an.h.f.a.a(this.b, 48.0f * fFloatValue);
            this.h.updateViewLayout(this.j, layoutParams);
            this.h.setTranslationY(-com.opos.cmn.an.h.f.a.a(this.b, 3.0f * fFloatValue));
            this.h.setRotationX(fFloatValue * 40.0f);
        }
    }

    @Override // com.opos.mobad.template.k.b.a
    public void a(int i, int[] iArr) {
        if (this.t || this.p == null) {
            return;
        }
        l();
        this.p.a(i, iArr);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.d.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.m();
            }
        }, 1000L);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        String str = aVar.b;
        if (aVar instanceof com.opos.mobad.template.e.b.b) {
            com.opos.mobad.template.e.b.b bVar = (com.opos.mobad.template.e.b.b) aVar;
            this.u = bVar.E;
            this.v = bVar.D;
        }
        if (this.d) {
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.s.a(this.u, this.v);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.p = bVar;
    }
}
