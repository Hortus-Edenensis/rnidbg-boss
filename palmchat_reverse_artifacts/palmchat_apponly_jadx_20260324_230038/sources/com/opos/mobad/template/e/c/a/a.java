package com.opos.mobad.template.e.c.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.d.c.d;
import com.opos.mobad.template.cmn.baseview.c;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.e.b.h;
import com.opos.mobad.template.e.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.template.e.c.a {
    public b c;
    private c d;
    private c e;
    private TextView f;
    private c g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private d n;
    private AnimatorSet o;
    private View p;
    private View q;
    private boolean r;
    private final long s;
    private final long t;
    private final long u;
    private f v;
    private double w;
    private final View.OnTouchListener x;
    private final Runnable y;

    public a(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.r = false;
        this.s = 500L;
        this.t = 1000L;
        this.u = 500L;
        this.w = com.opos.mobad.template.e.b.a.w;
        this.x = new View.OnTouchListener() { // from class: com.opos.mobad.template.e.c.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.h = (int) motionEvent.getX();
                    a.this.i = (int) motionEvent.getY();
                    a.this.m = false;
                } else if (2 == motionEvent.getAction()) {
                    int y = (int) motionEvent.getY();
                    int x = (int) motionEvent.getX();
                    if (y <= 0 && !a.this.m) {
                        a.this.a(x, y);
                    }
                } else if (1 == motionEvent.getAction()) {
                    a.this.j = (int) motionEvent.getX();
                    a.this.k = (int) motionEvent.getY();
                    if ((a.this.h == a.this.j && a.this.i == a.this.k) || (a.this.i - a.this.k > a.this.w && !a.this.m)) {
                        a aVar2 = a.this;
                        aVar2.a(aVar2.j, a.this.k);
                    }
                }
                return true;
            }
        };
        this.y = new Runnable() { // from class: com.opos.mobad.template.e.c.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.r) {
                    return;
                }
                a.this.o.start();
                a.this.n.a(2500L);
            }
        };
        a();
        b();
    }

    private void k() {
        TextView textView = new TextView(this.b);
        this.f = textView;
        textView.setId(View.generateViewId());
        this.f.setTextSize(1, 14.0f);
        this.f.setTextColor(-1);
        this.f.setText("上滑看详情");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.d.addView(this.f, layoutParams);
        a(this.f);
    }

    private void l() {
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 30.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 82.0f);
        c cVar = new c(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.f.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        this.d.addView(cVar, layoutParams);
        this.g = new c(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.addRule(14);
        cVar.addView(this.g, layoutParams2);
        this.p = new com.opos.mobad.template.cmn.c(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams3.addRule(12);
        this.p.setAlpha(0.0f);
        this.g.addView(this.p, layoutParams3);
        this.q = new View(this.b);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        gradientDrawable.setSize(com.opos.cmn.an.h.f.a.a(this.b, 26.0f), com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        this.q.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 26.0f), com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        this.g.addView(this.q, layoutParams4);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.r) {
            return;
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.a();
            this.n.b();
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.q, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.p, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.q, "translationY", 0.0f, -com.opos.cmn.an.h.f.a.a(this.b, 54.0f));
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorA = a(this.p, com.opos.cmn.an.h.f.a.a(this.b, 28.0f), com.opos.cmn.an.h.f.a.a(this.b, 82.0f));
        valueAnimatorA.setInterpolator(interpolatorCreate);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorA);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat4.setDuration(500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.o = animatorSet2;
        animatorSet2.playSequentially(objectAnimatorOfFloat, animatorSet, objectAnimatorOfFloat4);
        d dVar2 = new d(com.opos.mobad.d.c.c.a(), this.y);
        this.n = dVar2;
        dVar2.a(0L);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        com.opos.cmn.an.f.a.b("SplashSlidePointView", "destroy");
        this.r = true;
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.end();
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.a();
            this.n.b();
        }
    }

    private ValueAnimator a(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.e.c.a.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (a.this.r) {
                    return;
                }
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = iIntValue;
                view.setLayoutParams(layoutParams);
            }
        });
        return valueAnimatorOfInt;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        d dVar;
        if (this.r || (dVar = this.n) == null) {
            return;
        }
        dVar.a(0L);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.r) {
            return;
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.a();
            this.n.b();
        }
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.l = com.opos.cmn.an.h.f.a.a(this.b, 128.0f);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        this.e = new c(this.b);
        this.d = new c(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.l);
        this.d.setPadding(0, 0, 0, 0);
        layoutParams.addRule(13);
        this.e.addView(this.d, layoutParams);
        k();
        l();
        this.d.setOnTouchListener(this.x);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int[] iArr = {this.h, this.i, i, i2};
        this.m = true;
        b bVar = this.c;
        if (bVar != null) {
            bVar.b(this.e, iArr);
        }
    }

    private void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
        this.v = fVar;
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(fVar);
        }
        c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.a(this.v);
        }
        c cVar3 = this.g;
        if (cVar3 != null) {
            cVar3.a(this.v);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (aVar instanceof h) {
            this.w = com.opos.cmn.an.h.f.a.a(this.b, ((h) aVar).E);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(b bVar) {
        this.c = bVar;
    }
}
