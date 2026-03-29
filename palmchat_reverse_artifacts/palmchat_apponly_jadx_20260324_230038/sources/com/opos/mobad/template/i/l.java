package com.opos.mobad.template.i;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.w;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10129a = false;
    private w b;
    private com.opos.mobad.template.cmn.l c;
    private Context d;
    private RelativeLayout e;
    private BaseTextView f;
    private com.opos.mobad.template.cmn.baseview.c g;
    private Animator h;
    private Animator i;
    private Animator j;
    private Animator k;
    private j l;
    private com.opos.mobad.template.cmn.baseview.c m;

    public l(Context context, j jVar) {
        this.d = context;
        this.l = jVar;
        this.m = new com.opos.mobad.template.cmn.baseview.c(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 96.0f));
        this.e = new RelativeLayout(context);
        layoutParams.addRule(13);
        this.m.addView(this.e, layoutParams);
        this.m.setVisibility(4);
        g();
        h();
    }

    private void g() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.d);
        this.g = cVar;
        cVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 312.0f), com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        layoutParams.addRule(13);
        this.g.setBackground(this.d.getResources().getDrawable(R.drawable.opos_mobad_drawable_splash_click));
        this.e.addView(this.g, layoutParams);
        this.f = com.opos.mobad.template.i.a.b.b(this.d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.g.addView(this.f, layoutParams2);
        if (this.l == j.BREATH) {
            this.c = new com.opos.mobad.template.cmn.l(this.d);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 334.0f), com.opos.cmn.an.h.f.a.a(this.d, 80.0f));
            layoutParams3.addRule(13);
            this.c.setImageResource(R.drawable.opos_mobad_btn_fading);
            this.c.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.b(com.opos.cmn.an.h.f.a.a(this.d, 80.0f));
            this.c.a(com.opos.cmn.an.h.f.a.a(this.d, 30.0f));
            this.e.addView(this.c, layoutParams3);
        }
    }

    @TargetApi(21)
    private void h() {
        this.b = new w(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.g.getId());
        layoutParams.addRule(7, this.g.getId());
        layoutParams.addRule(6, this.g.getId());
        layoutParams.addRule(8, this.g.getId());
        layoutParams.addRule(13);
        this.b.setBackgroundColor(0);
        this.b.a(com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        this.e.addView(this.b, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.j == null) {
            Animator animatorA = ae.a(this.c);
            this.j = animatorA;
            animatorA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.i == null) {
            Animator animatorA = ae.a((RelativeLayout) this.b);
            this.i = animatorA;
            animatorA.start();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public View a() {
        return this.m;
    }

    @Override // com.opos.mobad.template.i.d
    public void b() {
        if (this.l == j.NONE) {
            return;
        }
        Animator animator = this.h;
        if (animator == null || !animator.isRunning()) {
            if (this.k == null) {
                this.k = ae.c((View) this.m);
            }
            this.k.start();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void c() {
        if (this.l == j.NONE || this.f10129a) {
            return;
        }
        this.f10129a = true;
        Animator animatorA = ae.a((View) this.m);
        this.h = animatorA;
        animatorA.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.i.l.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (l.this.l == j.BREATH) {
                    l.this.i();
                } else if (l.this.l == j.SPLASH) {
                    l.this.j();
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
        this.h.start();
    }

    @Override // com.opos.mobad.template.i.d
    public void d() {
        Animator animator = this.j;
        if (animator != null) {
            animator.pause();
        }
        Animator animator2 = this.i;
        if (animator2 != null) {
            animator2.pause();
        }
        Animator animator3 = this.k;
        if (animator3 != null) {
            animator3.pause();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void e() {
        Animator animator = this.j;
        if (animator != null) {
            animator.resume();
        }
        Animator animator2 = this.i;
        if (animator2 != null) {
            animator2.resume();
        }
        Animator animator3 = this.k;
        if (animator3 != null) {
            animator3.resume();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void f() {
        Animator animator = this.h;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.j;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.i;
        if (animator3 != null) {
            animator3.end();
        }
        Animator animator4 = this.k;
        if (animator4 != null) {
            animator4.end();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.g.a(fVar);
    }

    @Override // com.opos.mobad.template.i.d
    public void a(c cVar) {
        this.g.setOnTouchListener(cVar);
        this.g.setOnClickListener(cVar);
    }

    @Override // com.opos.mobad.template.i.d
    public void a(String str, int i, int i2, Map<String, String> map) {
        this.f.setText(str);
    }
}
