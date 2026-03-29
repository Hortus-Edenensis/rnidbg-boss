package com.opos.mobad.template.e.c.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.e.b.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends com.opos.mobad.template.e.c.a {
    private final Runnable A;
    private com.opos.mobad.template.cmn.baseview.c c;
    private com.opos.mobad.template.cmn.baseview.c d;
    private p e;
    private com.opos.mobad.template.e.c.b f;
    private BaseTextView g;
    private TextView h;
    private RelativeLayout i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private com.opos.mobad.d.c.d p;
    private AnimatorSet q;
    private View r;
    private ImageView s;
    private int[] t;
    private boolean u;
    private final long v;
    private final long w;
    private int x;
    private double y;
    private final View.OnTouchListener z;

    public g(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.v = 1000L;
        this.w = 500L;
        this.y = com.opos.mobad.template.e.b.a.w;
        this.z = new View.OnTouchListener() { // from class: com.opos.mobad.template.e.c.d.g.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    g.this.j = (int) motionEvent.getX();
                    g.this.k = (int) motionEvent.getY();
                    g.this.o = false;
                } else if (2 == motionEvent.getAction()) {
                    int y = (int) motionEvent.getY();
                    int x = (int) motionEvent.getX();
                    if (y <= 0 && !g.this.o) {
                        g.this.a(x, y);
                    }
                } else if (1 == motionEvent.getAction()) {
                    g.this.l = (int) motionEvent.getX();
                    g.this.m = (int) motionEvent.getY();
                    if ((g.this.j == g.this.l && g.this.k == g.this.m) || (g.this.k - g.this.m > g.this.y && !g.this.o)) {
                        g gVar = g.this;
                        gVar.a(gVar.l, g.this.m);
                    }
                }
                return true;
            }
        };
        this.A = new Runnable() { // from class: com.opos.mobad.template.e.c.d.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.u) {
                    return;
                }
                g.this.q.start();
                g.this.p.a(2000L);
            }
        };
        a();
        b();
    }

    private void k() {
        this.c.setOnTouchListener(this.z);
    }

    private void l() {
        BaseTextView baseTextView = new BaseTextView(this.b);
        this.g = baseTextView;
        baseTextView.setId(View.generateViewId());
        this.g.setTextSize(1, 14.0f);
        this.g.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.c.addView(this.g, layoutParams);
        a(this.g);
    }

    private void m() {
        TextView textView = new TextView(this.b);
        this.h = textView;
        textView.setId(View.generateViewId());
        this.h.setText("向上滑动");
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 18.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.g.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        this.c.addView(this.h, layoutParams);
        a(this.h);
    }

    private void n() {
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 60.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 41.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.i = new RelativeLayout(this.b);
        this.r = new View(this.b);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.t);
        gradientDrawable.setShape(0);
        this.r.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (iA * 0.7f), -1);
        layoutParams.addRule(12);
        layoutParams.topMargin = (iA2 / 2) - com.opos.cmn.an.h.f.a.a(this.b, 2.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        layoutParams.addRule(11);
        ImageView imageView = new ImageView(this.b);
        this.s = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.addRule(14);
        this.s.setImageResource(R.drawable.opos_mobad_slide_up);
        this.i.addView(this.s, layoutParams2);
        this.i.addView(this.r, layoutParams);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, com.opos.cmn.an.h.f.a.a(this.b, 138.0f));
        layoutParams3.addRule(14);
        relativeLayout.addView(this.i, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(2, this.h.getId());
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        this.c.addView(relativeLayout, layoutParams4);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        this.u = false;
        com.opos.mobad.d.c.d dVar = this.p;
        if (dVar != null) {
            dVar.a();
            this.p.b();
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.i, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.s, "translationY", com.opos.cmn.an.h.f.a.a(this.b, 98.0f), 0.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorA = a(this.r, com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 118.0f));
        valueAnimatorA.setInterpolator(interpolatorCreate);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorA);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.i, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.q = animatorSet2;
        animatorSet2.playSequentially(animatorSet, objectAnimatorOfFloat3);
        com.opos.mobad.d.c.d dVar2 = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), this.A);
        this.p = dVar2;
        dVar2.a(0L);
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        com.opos.cmn.an.f.a.b("SplashSlideView", "destroy");
        this.u = true;
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.end();
        }
        com.opos.mobad.d.c.d dVar = this.p;
        if (dVar != null) {
            dVar.a();
            this.p.b();
        }
    }

    private ValueAnimator a(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.e.c.d.g.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.u) {
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
        com.opos.mobad.d.c.d dVar = this.p;
        if (dVar != null) {
            dVar.a(0L);
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        com.opos.mobad.d.c.d dVar = this.p;
        if (dVar != null) {
            dVar.a();
            this.p.b();
        }
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void a(int i) {
        this.x = i;
        this.c.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, i));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        this.t = new int[]{1728053247, 16777215};
        this.d = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.n = com.opos.cmn.an.h.f.a.a(this.b, 290.0f);
        this.c = new com.opos.mobad.template.cmn.baseview.c(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.n);
        this.c.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, this.x));
        layoutParams.addRule(13);
        this.d.addView(this.c, layoutParams);
        this.d.setVisibility(4);
        l();
        m();
        n();
        k();
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int[] iArr = {this.j, this.k, i, i2};
        this.o = true;
        p pVar = this.e;
        if (pVar != null) {
            pVar.b(this.d, iArr);
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
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.d.a(fVar);
        this.c.a(fVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!TextUtils.isEmpty(aVar.b)) {
            this.g.setText(aVar.b);
        }
        if (aVar instanceof h) {
            this.y = com.opos.cmn.an.h.f.a.a(this.b, ((h) aVar).E);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.f = bVar;
        this.e = bVar;
    }
}
