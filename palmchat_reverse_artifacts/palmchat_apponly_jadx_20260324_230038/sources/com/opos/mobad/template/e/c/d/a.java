package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.template.e.c.a {
    private double c;
    private com.opos.mobad.template.cmn.baseview.c d;
    private RelativeLayout e;
    private com.opos.mobad.template.cmn.baseview.c f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private com.opos.mobad.template.e.c.b j;
    private com.opos.mobad.template.e.c.b k;
    private Boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private AnimatorSet q;
    private AnimatorSet r;
    private int s;
    private final View.OnTouchListener t;

    public a(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.t = new View.OnTouchListener() { // from class: com.opos.mobad.template.e.c.d.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.m = (int) motionEvent.getX();
                    a.this.n = (int) motionEvent.getY();
                    a.this.l = Boolean.FALSE;
                } else if (2 == motionEvent.getAction()) {
                    int rawY = (int) motionEvent.getRawY();
                    int rawX = (int) motionEvent.getRawX();
                    int y = (int) motionEvent.getY();
                    int x = (int) motionEvent.getX();
                    Rect rect = new Rect();
                    a.this.e.getHitRect(rect);
                    if (!rect.contains(rawX, rawY) && !a.this.l.booleanValue()) {
                        a.this.a(x, y);
                    }
                } else if (1 == motionEvent.getAction()) {
                    a.this.o = (int) motionEvent.getX();
                    a.this.p = (int) motionEvent.getY();
                    int i = a.this.p - a.this.n;
                    int i2 = a.this.o - a.this.m;
                    if (((a.this.n == a.this.p && a.this.m == a.this.o) || Math.pow(i, 2.0d) + Math.pow(i2, 2.0d) > Math.pow(a.this.c, 2.0d)) && !a.this.l.booleanValue()) {
                        a aVar2 = a.this;
                        aVar2.a(aVar2.o, a.this.p);
                    }
                }
                return true;
            }
        };
        a();
        b();
        this.c = com.opos.mobad.template.e.b.a.x;
        k();
    }

    private void k() {
        this.e.setOnTouchListener(this.t);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.resume();
        }
        AnimatorSet animatorSet2 = this.r;
        if (animatorSet2 != null) {
            animatorSet2.resume();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.pause();
        }
        AnimatorSet animatorSet2 = this.r;
        if (animatorSet2 != null) {
            animatorSet2.pause();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.q);
        h.a(this.r);
    }

    private AnimatorSet a(View view, float f, PathInterpolator pathInterpolator, PathInterpolator pathInterpolator2) {
        float f2 = -f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
        objectAnimatorOfFloat.setDuration(483L);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", f2, f2);
        objectAnimatorOfFloat2.setDuration(184L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", f2, 0.0f), PropertyValuesHolder.ofFloat("translationY", 0.0f, f2));
        objectAnimatorOfPropertyValuesHolder.setDuration(483L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(pathInterpolator2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(184L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", 0.0f, f), PropertyValuesHolder.ofFloat("translationY", f2, 0.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(483L);
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(pathInterpolator2);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationX", f, f);
        objectAnimatorOfFloat4.setDuration(184L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", f, 0.0f), PropertyValuesHolder.ofFloat("translationY", 0.0f, f));
        objectAnimatorOfPropertyValuesHolder3.setDuration(483L);
        objectAnimatorOfPropertyValuesHolder3.setInterpolator(pathInterpolator2);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 0.0f);
        objectAnimatorOfFloat5.setDuration(184L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "translationY", f, 0.0f);
        objectAnimatorOfFloat6.setDuration(483L);
        objectAnimatorOfFloat6.setInterpolator(pathInterpolator);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfPropertyValuesHolder, objectAnimatorOfFloat3, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfFloat4, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.e.c.d.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animatorSet.start();
            }
        });
        return animatorSet;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (h.a()) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.17f, 0.0f, 0.1f, 1.0f);
            PathInterpolator pathInterpolator2 = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
            this.q = a(this.h, 60.0f, pathInterpolator, pathInterpolator2);
            this.r = a(this.g, 26.0f, pathInterpolator2, pathInterpolator2);
            this.q.start();
            this.r.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.d = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 14.0f);
        this.d.setPadding(iA2, iA, iA2, 0);
        this.e = new RelativeLayout(this.b);
        this.d.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
        this.d.setVisibility(4);
        TextView textView = new TextView(this.b);
        this.i = textView;
        textView.setId(View.generateViewId());
        this.i.setText("滑动手机");
        this.i.setTextSize(1, 18.0f);
        this.i.setTextColor(-1);
        h.a(this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.e.addView(this.i, layoutParams);
        this.f = new com.opos.mobad.template.cmn.baseview.c(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(2, this.i.getId());
        layoutParams2.addRule(14);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.f.setBackground(this.b.getDrawable(R.drawable.opos_mobad_bg_cricle_black));
        this.f.setId(View.generateViewId());
        this.e.addView(this.f, layoutParams2);
        ImageView imageView = new ImageView(this.b);
        this.g = imageView;
        imageView.setBackgroundResource(R.drawable.opos_mobad_splash_slide_arrow_ring);
        this.g.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams3.addRule(13);
        this.f.addView(this.g, layoutParams3);
        ImageView imageView2 = new ImageView(this.b);
        this.h = imageView2;
        imageView2.setBackgroundResource(R.drawable.opos_mobad_splash_slide_dot);
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 12.0f), com.opos.cmn.an.h.f.a.a(this.b, 12.0f));
        layoutParams4.addRule(13);
        this.f.addView(this.h, layoutParams4);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    public void a(int i) {
        this.s = i;
        TextView textView = this.i;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, this.s);
            }
            this.i.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int i3 = this.m;
        int i4 = this.n;
        int[] iArr = {i3, i4, i, i2};
        this.l = Boolean.TRUE;
        com.opos.mobad.template.e.c.b bVar = this.j;
        if (bVar != null) {
            if (i3 == i && i4 == i2) {
                bVar.a(this.d, iArr);
            } else {
                bVar.b(this.d, iArr);
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (aVar instanceof com.opos.mobad.template.e.b.c) {
            this.c = com.opos.cmn.an.h.f.a.a(this.b, ((com.opos.mobad.template.e.b.c) aVar).D);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.k = bVar;
        this.j = bVar;
    }
}
