package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
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
public class e extends com.opos.mobad.template.e.c.a implements d.a {
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private com.opos.mobad.template.c f;
    private Animator g;
    private Animator h;
    private Animator i;
    private l j;
    private RelativeLayout k;
    private boolean l;
    private boolean m;
    private int n;
    private boolean o;
    private com.opos.mobad.template.k.d p;

    public e(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.n = 2;
        this.o = false;
        a();
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.c = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, this.n));
        this.k = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams.addRule(14);
        this.c.addView(this.k, layoutParams);
        this.k.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        this.k.addView(imageView, layoutParams2);
        this.j = new l(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams3.addRule(13);
        this.j.setScaleType(ImageView.ScaleType.FIT_XY);
        this.j.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.j.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        this.j.b(com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        this.k.addView(this.j, layoutParams3);
        ImageView imageView2 = new ImageView(this.b);
        this.d = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.d.setScaleType(ImageView.ScaleType.CENTER);
        this.k.addView(this.d, layoutParams2);
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, this.k.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        h.a(textView);
        this.c.addView(textView, layoutParams4);
        TextView textView2 = new TextView(this.b);
        this.e = textView2;
        textView2.setTextSize(1, 14.0f);
        this.e.setTextColor(-1);
        h.a(this.e);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, textView.getId());
        this.e.setVisibility(8);
        this.c.addView(this.e, layoutParams5);
        this.c.setVisibility(4);
        if (this.m) {
            this.p = new com.opos.mobad.template.k.d(this.b, false, this);
        }
        if (this.l) {
            this.h = ae.d(this.d);
            this.i = ae.b(this.j);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void d() {
        Animator animator;
        if (this.m && this.l && (animator = this.i) != null) {
            animator.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.m;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.m && !this.o) {
            this.o = true;
            if (this.l) {
                Animator animatorB = ae.b((View) this.c);
                this.g = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.e.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        e.this.h.start();
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
            if (this.m) {
                this.p.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.m) {
            this.p.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.m) {
            this.p.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.i);
        h.a(this.g);
        h.a(this.h);
        com.opos.mobad.template.k.d dVar = this.p;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.l = h.a();
        this.m = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.m || aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.b)) {
            this.e.setText(aVar.b);
            this.e.setVisibility(0);
        }
        com.opos.mobad.template.k.d dVar = this.p;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.f = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        com.opos.mobad.template.c cVar = this.f;
        if (cVar != null) {
            cVar.a(iArr);
            this.p.c();
        }
    }
}
