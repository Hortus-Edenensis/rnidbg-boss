package com.opos.mobad.template.e.c.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.e.b.g;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends com.opos.mobad.template.e.c.a implements e.a {
    private com.opos.mobad.template.e.c.b c;
    private RelativeLayout d;
    private TextView e;
    private x f;
    private Animator g;
    private AnimatorSet h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private e n;
    private int o;
    private int p;

    public c(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = com.opos.mobad.template.e.b.a.r;
        this.p = com.opos.mobad.template.e.b.a.s;
        a();
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.i;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.i && !this.l) {
            this.l = true;
            if (this.j) {
                Animator animatorB = ae.b((View) this.d);
                this.g = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.b.c.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        c.this.h.start();
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
            this.n.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("NatTempInteractiveTiltView", "mDestroy:" + this.k + " mIsViewVisible:" + this.m);
        if (!this.k && this.m && this.i) {
            this.n.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.i) {
            this.n.d();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.k = true;
        if (this.i) {
            h.a(this.g);
            h.a(this.h);
            e eVar = this.n;
            if (eVar != null) {
                eVar.d();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.j = h.a();
        this.i = h.b(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        c cVar;
        if (this.i) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.d = relativeLayout;
            relativeLayout.setVisibility(4);
            this.d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.d.setClipChildren(false);
            x xVar = new x(this.b);
            this.f = xVar;
            xVar.setVisibility(4);
            this.f.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
            this.f.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
            layoutParams.addRule(13);
            this.f.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0);
            this.f.setBackgroundColor(Color.argb(138, 66, 70, 76));
            this.d.addView(this.f, layoutParams);
            RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams2.gravity = 16;
            this.f.addView(relativeLayout2, layoutParams2);
            RelativeLayout relativeLayout3 = new RelativeLayout(this.b);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 12.5f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams3.addRule(14);
            relativeLayout2.addView(relativeLayout3, layoutParams3);
            ImageView imageView = new ImageView(this.b);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 12.5f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams4.addRule(14);
            imageView.setImageResource(R.drawable.opos_mobad_phone_nt);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout3.addView(imageView, layoutParams4);
            w wVar = new w(this.b);
            wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 10.0f));
            wVar.setBackgroundColor(Color.argb(153, 255, 255, 255));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 1.0f), com.opos.cmn.an.h.f.a.a(this.b, 18.0f));
            layoutParams5.addRule(15);
            layoutParams5.addRule(9);
            relativeLayout3.addView(wVar, layoutParams5);
            w wVar2 = new w(this.b);
            wVar2.a(com.opos.cmn.an.h.f.a.a(this.b, 10.0f));
            wVar2.setBackgroundColor(Color.argb(153, 255, 255, 255));
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 1.0f), com.opos.cmn.an.h.f.a.a(this.b, 18.0f));
            layoutParams6.addRule(15);
            layoutParams6.addRule(11);
            relativeLayout3.addView(wVar2, layoutParams6);
            TextView textView = new TextView(this.b);
            this.e = textView;
            textView.setTextSize(1, 12.0f);
            this.e.setText("翻转");
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
            layoutParams7.gravity = 16;
            this.e.setTextColor(-436207617);
            h.a(this.e);
            this.f.addView(this.e, layoutParams7);
            this.n = new e(this.b, this);
            if (this.j) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(relativeLayout3, "rotationY", 0.0f, 45.0f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(wVar, "scaleX", 1.0f, 25.0f);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(wVar, "alpha", 0.0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(400L);
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(relativeLayout2, "translationX", 0.0f, 0.0f);
                objectAnimatorOfFloat4.setDuration(500L);
                ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(relativeLayout3, "rotationY", 45.0f, 0.0f);
                ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(wVar, "scaleX", 25.0f, 1.0f);
                ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(wVar, "alpha", 1.0f, 0.0f);
                ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(wVar2, "scaleX", 1.0f, 12.5f);
                ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(wVar2, "alpha", 0.0f, 0.5f);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(200L);
                animatorSet2.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
                ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(relativeLayout3, "rotationY", 360.0f, 320.0f);
                ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(wVar2, "scaleX", 12.5f, 25.0f);
                ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(wVar2, "alpha", 0.5f, 1.0f);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.setDuration(200L);
                animatorSet3.playTogether(objectAnimatorOfFloat10, objectAnimatorOfFloat11, objectAnimatorOfFloat12);
                ObjectAnimator objectAnimatorOfFloat13 = ObjectAnimator.ofFloat(relativeLayout2, "translationX", 0.0f, 0.0f);
                objectAnimatorOfFloat4.setDuration(500L);
                ObjectAnimator objectAnimatorOfFloat14 = ObjectAnimator.ofFloat(relativeLayout3, "rotationY", 320.0f, 360.0f);
                ObjectAnimator objectAnimatorOfFloat15 = ObjectAnimator.ofFloat(wVar2, "scaleX", 25.0f, 1.0f);
                ObjectAnimator objectAnimatorOfFloat16 = ObjectAnimator.ofFloat(wVar2, "alpha", 1.0f, 0.0f);
                AnimatorSet animatorSet4 = new AnimatorSet();
                animatorSet4.setDuration(200L);
                animatorSet4.playTogether(objectAnimatorOfFloat14, objectAnimatorOfFloat15, objectAnimatorOfFloat16);
                ObjectAnimator objectAnimatorOfFloat17 = ObjectAnimator.ofFloat(relativeLayout2, "translationX", 0.0f, 0.0f);
                objectAnimatorOfFloat4.setDuration(200L);
                AnimatorSet animatorSet5 = new AnimatorSet();
                cVar = this;
                cVar.h = animatorSet5;
                animatorSet5.playSequentially(animatorSet, objectAnimatorOfFloat4, animatorSet2, animatorSet3, objectAnimatorOfFloat13, animatorSet4, objectAnimatorOfFloat17);
                cVar.h.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.e.c.b.c.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        c.this.h.start();
                    }
                });
            } else {
                cVar = this;
            }
            cVar.a(cVar.b);
        }
    }

    @Override // com.opos.mobad.template.k.e.a
    public void a(float f, float f2) {
    }

    @Override // com.opos.mobad.template.k.e.a
    public void a(int i, int[] iArr) {
        com.opos.mobad.template.e.c.b bVar;
        if (this.k || !this.m || (bVar = this.c) == null) {
            return;
        }
        bVar.a(i, iArr);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.n != null) {
                    c.this.i();
                    c.this.n.c();
                    c.this.h();
                }
            }
        }, com.igexin.push.config.c.j);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.b.c.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                c.this.m = z;
                if (!z) {
                    c.this.i();
                    return;
                }
                if (c.this.f != null && c.this.f.getVisibility() != 0) {
                    c.this.f.setVisibility(0);
                }
                c.this.g();
                c.this.h();
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        e eVar;
        TextView textView;
        String str = aVar.b;
        if (!TextUtils.isEmpty(str) && (textView = this.e) != null) {
            textView.setText("翻转" + str);
        }
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            int i = gVar.D;
            if (i > 0) {
                this.p = i;
            }
            int i2 = gVar.E;
            if (i2 > 0) {
                this.o = i2;
            }
            if (!this.i || (eVar = this.n) == null) {
                return;
            }
            eVar.a(this.o, this.p, gVar.F);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.c = bVar;
    }
}
