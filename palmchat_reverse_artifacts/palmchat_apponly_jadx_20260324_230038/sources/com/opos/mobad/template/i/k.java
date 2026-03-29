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
public class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10127a = false;
    private w b;
    private com.opos.mobad.template.cmn.l c;
    private Context d;
    private RelativeLayout e;
    private BaseTextView f;
    private Animator g;
    private Animator h;
    private Animator i;
    private Animator j;
    private j k;
    private com.opos.mobad.template.cmn.baseview.c l;

    public k(Context context, j jVar) {
        this.d = context;
        this.k = jVar;
        this.l = new com.opos.mobad.template.cmn.baseview.c(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 96.0f));
        this.e = new RelativeLayout(context);
        layoutParams.addRule(13);
        this.l.addView(this.e, layoutParams);
        this.l.setVisibility(4);
        g();
        h();
    }

    private void g() {
        BaseTextView baseTextViewA = com.opos.mobad.template.i.a.b.a(this.d);
        this.f = baseTextViewA;
        baseTextViewA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 324.0f), com.opos.cmn.an.h.f.a.a(this.d, 66.0f));
        layoutParams.addRule(13);
        this.e.addView(this.f, layoutParams);
        if (this.k == j.BREATH) {
            this.c = new com.opos.mobad.template.cmn.l(this.d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 346.0f), com.opos.cmn.an.h.f.a.a(this.d, 88.0f));
            layoutParams2.addRule(13);
            this.c.setImageResource(R.drawable.opos_mobad_btn_fading);
            this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.c.b(com.opos.cmn.an.h.f.a.a(this.d, 88.0f));
            this.c.a(com.opos.cmn.an.h.f.a.a(this.d, 30.0f));
            this.e.addView(this.c, layoutParams2);
        }
    }

    @TargetApi(21)
    private void h() {
        this.b = new w(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.f.getId());
        layoutParams.addRule(7, this.f.getId());
        layoutParams.addRule(6, this.f.getId());
        layoutParams.addRule(8, this.f.getId());
        layoutParams.addRule(13);
        this.b.setBackgroundColor(0);
        this.b.a(com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        this.e.addView(this.b, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == null) {
            Animator animatorA = ae.a(this.c);
            this.i = animatorA;
            animatorA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.h == null) {
            Animator animatorA = ae.a((RelativeLayout) this.b);
            this.h = animatorA;
            animatorA.start();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public View a() {
        return this.l;
    }

    @Override // com.opos.mobad.template.i.d
    public void b() {
        if (this.k == j.NONE) {
            return;
        }
        Animator animator = this.g;
        if (animator == null || !animator.isRunning()) {
            if (this.j == null) {
                this.j = ae.c((View) this.l);
            }
            this.j.start();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void c() {
        if (this.k == j.NONE || this.f10127a) {
            return;
        }
        this.f10127a = true;
        Animator animatorA = ae.a((View) this.l);
        this.g = animatorA;
        animatorA.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.i.k.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (k.this.k == j.BREATH) {
                    k.this.i();
                } else if (k.this.k == j.SPLASH) {
                    k.this.j();
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
        this.g.start();
    }

    @Override // com.opos.mobad.template.i.d
    public void d() {
        Animator animator = this.i;
        if (animator != null) {
            animator.pause();
        }
        Animator animator2 = this.h;
        if (animator2 != null) {
            animator2.pause();
        }
        Animator animator3 = this.j;
        if (animator3 != null) {
            animator3.pause();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void e() {
        Animator animator = this.i;
        if (animator != null) {
            animator.resume();
        }
        Animator animator2 = this.h;
        if (animator2 != null) {
            animator2.resume();
        }
        Animator animator3 = this.j;
        if (animator3 != null) {
            animator3.resume();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void f() {
        Animator animator = this.g;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.i;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.h;
        if (animator3 != null) {
            animator3.end();
        }
        Animator animator4 = this.j;
        if (animator4 != null) {
            animator4.end();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.f.a(fVar);
    }

    @Override // com.opos.mobad.template.i.d
    public void a(c cVar) {
        this.f.setOnTouchListener(cVar);
        this.f.setOnClickListener(cVar);
    }

    @Override // com.opos.mobad.template.i.d
    public void a(String str, int i, int i2, Map<String, String> map) {
        this.f.setText(str);
    }
}
