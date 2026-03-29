package com.opos.mobad.template.e.c.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.template.e.c.a implements b.a {
    private com.opos.mobad.template.e.c.b c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private x g;
    private Animator h;
    private AnimatorSet i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private com.opos.mobad.template.k.b o;
    private int p;
    private int q;

    public a(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = com.opos.mobad.template.e.b.a.u;
        this.q = com.opos.mobad.template.e.b.a.v;
        a();
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.j;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.j && !this.m) {
            this.m = true;
            if (this.k) {
                Animator animatorB = ae.b((View) this.d);
                this.h = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.b.a.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        a.this.i.start();
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
            this.o.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("NatTempInteractiveForwardView", "mDestroy:" + this.l + " mIsViewVisible:" + this.n);
        if (!this.l && this.n && this.j) {
            this.o.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.j) {
            this.o.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.l = true;
        if (this.j) {
            h.a(this.h);
            h.a(this.i);
            com.opos.mobad.template.k.b bVar = this.o;
            if (bVar != null) {
                bVar.c();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.k = h.a();
        this.j = h.b(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        if (this.j) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.d = relativeLayout;
            relativeLayout.setVisibility(4);
            this.d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.d.setClipChildren(false);
            x xVar = new x(this.b);
            this.g = xVar;
            xVar.setVisibility(4);
            this.g.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
            this.g.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
            layoutParams.addRule(13);
            this.g.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0);
            this.g.setBackgroundColor(Color.argb(138, 66, 70, 76));
            this.d.addView(this.g, layoutParams);
            this.e = new ImageView(this.b);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams2.gravity = 16;
            this.e.setImageResource(R.drawable.opos_mobad_template_phone);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.g.addView(this.e, layoutParams2);
            TextView textView = new TextView(this.b);
            this.f = textView;
            textView.setTextSize(1, 12.0f);
            this.f.setText("前倾");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
            layoutParams3.gravity = 16;
            this.f.setTextColor(-436207617);
            h.a(this.f);
            this.g.addView(this.f, layoutParams3);
            this.o = new com.opos.mobad.template.k.b(this.b, this);
            if (this.k) {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("rotationX", 0.0f, 40.0f), PropertyValuesHolder.ofFloat("translationY", 0.0f, -com.opos.cmn.an.h.f.a.a(this.b, 2.0f)));
                objectAnimatorOfPropertyValuesHolder.setDuration(600L);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[0]);
                objectAnimatorOfPropertyValuesHolder2.setDuration(900L);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("rotationX", 40.0f, 0.0f), PropertyValuesHolder.ofFloat("translationY", -com.opos.cmn.an.h.f.a.a(this.b, 2.0f), 0.0f));
                objectAnimatorOfPropertyValuesHolder3.setDuration(600L);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[0]);
                objectAnimatorOfPropertyValuesHolder4.setDuration(900L);
                AnimatorSet animatorSet = new AnimatorSet();
                this.i = animatorSet;
                animatorSet.playSequentially(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4);
                this.i.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.b.a.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        a.this.i.start();
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
            a(this.b);
        }
    }

    @Override // com.opos.mobad.template.k.b.a
    public void a(float f, float f2) {
    }

    @Override // com.opos.mobad.template.k.b.a
    public void a(int i, int[] iArr) {
        com.opos.mobad.template.e.c.b bVar;
        if (this.l || !this.n || (bVar = this.c) == null) {
            return;
        }
        bVar.a(i, iArr);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o != null) {
                    a.this.i();
                    a.this.o.b();
                    a.this.h();
                }
            }
        }, com.igexin.push.config.c.j);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.b.a.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                a.this.n = z;
                if (!z) {
                    a.this.i();
                    return;
                }
                if (a.this.g != null && a.this.g.getVisibility() != 0) {
                    a.this.g.setVisibility(0);
                }
                a.this.g();
                a.this.h();
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        com.opos.mobad.template.k.b bVar;
        TextView textView;
        String str = aVar.b;
        if (aVar instanceof com.opos.mobad.template.e.b.b) {
            com.opos.mobad.template.e.b.b bVar2 = (com.opos.mobad.template.e.b.b) aVar;
            this.p = bVar2.E;
            this.q = bVar2.D;
        }
        if (!TextUtils.isEmpty(str) && (textView = this.f) != null) {
            textView.setText("前倾" + str);
        }
        if (!this.j || (bVar = this.o) == null) {
            return;
        }
        bVar.a(this.p, this.q);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.c = bVar;
    }
}
