package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.l;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends com.opos.mobad.template.e.c.a implements d.a {
    private RelativeLayout c;
    private ImageView d;
    private com.opos.mobad.template.c e;
    private Animator f;
    private Animator g;
    private l h;
    private RelativeLayout i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private com.opos.mobad.template.k.d n;

    public d(Context context, com.opos.mobad.template.e.a aVar, int i) {
        super(context, aVar);
        this.m = false;
        a();
        this.l = i;
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        this.c = new RelativeLayout(this.b);
        if (this.k) {
            this.n = new com.opos.mobad.template.k.d(this.b, false, this);
        }
        if (this.l == 1) {
            this.d = new ImageView(this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams.addRule(15);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
            this.d.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addView(this.d, layoutParams);
            this.c.setVisibility(4);
            if (this.j) {
                this.g = ae.g(this.d);
                return;
            }
            return;
        }
        this.i = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams2.addRule(14);
        this.c.addView(this.i, layoutParams2);
        this.i.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams3.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        this.i.addView(imageView, layoutParams3);
        this.h = new l(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams4.addRule(13);
        this.h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.h.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        this.h.b(com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        this.i.addView(this.h, layoutParams4);
        ImageView imageView2 = new ImageView(this.b);
        this.d = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.d.setScaleType(ImageView.ScaleType.CENTER);
        this.i.addView(this.d, layoutParams3);
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, this.i.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        h.a(textView);
        this.c.addView(textView, layoutParams5);
        this.c.setVisibility(4);
        if (this.j) {
            this.g = ae.d(this.d);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.k;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.k && !this.m) {
            this.m = true;
            if (this.j) {
                Animator animatorB = ae.b((View) this.c);
                this.f = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.d.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.g.start();
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
                this.f.start();
            }
            if (this.k) {
                this.n.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.k) {
            this.n.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.k) {
            this.n.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.f);
        h.a(this.g);
        com.opos.mobad.template.k.d dVar = this.n;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.j = h.a();
        this.k = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        com.opos.mobad.template.k.d dVar;
        if (!this.k || aVar == null || (dVar = this.n) == null) {
            return;
        }
        dVar.a(aVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.e = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        com.opos.mobad.template.c cVar = this.e;
        if (cVar != null) {
            cVar.a(iArr);
            this.n.c();
        }
    }
}
