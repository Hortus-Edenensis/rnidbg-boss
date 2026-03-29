package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CycleSkipView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f5382a;
    protected float b;
    private ValueAnimator bg;
    private boolean bq;
    private float c;
    private final RectF dw;
    protected int fx;
    protected int iz;
    protected int jk;
    private float k;
    private Paint l;
    private Paint mv;
    private AnimatorSet my;
    protected float n;
    protected int nr;
    private ValueAnimator o;
    protected float pn;
    private Paint s;
    private ValueAnimator sx;
    protected boolean t;
    protected int u;
    protected boolean x;

    public CycleSkipView(Context context) {
        super(context);
        this.u = Color.parseColor("#f9e8b9");
        this.nr = Color.parseColor("#ffffff");
        this.fx = Color.parseColor("#7b7b7b");
        this.iz = 270;
        this.x = false;
        this.n = 5.0f;
        this.f5382a = 0.0f;
        this.jk = 0;
        this.t = true;
        this.k = 0.0f;
        this.bq = false;
        this.dw = new RectF();
        this.c = 1.0f;
        this.b = u(2.0f);
        this.pn = u(10.0f);
        this.iz %= 360;
        nr();
        setBackgroundColor(-16711681);
    }

    private int fx() {
        return (int) ((((this.b / 2.0f) + this.pn) * 2.0f) + u(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.sx;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.sx = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.k, this.c);
        this.sx = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.sx.setDuration(1000L);
        this.sx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.k = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.sx;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    private void nr() {
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setColor(this.u);
        this.l.setStrokeWidth(this.b);
        this.l.setAntiAlias(true);
        this.l.setStrokeCap(Paint.Cap.ROUND);
        this.l.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.mv = paint2;
        paint2.setColor(this.nr);
        this.mv.setAntiAlias(true);
        this.mv.setStrokeWidth(this.b);
        this.mv.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.s = paint3;
        paint3.setColor(this.fx);
        this.s.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.my;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.my = null;
            }
            ValueAnimator valueAnimator = this.bg;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.bg = null;
            }
            ValueAnimator valueAnimator2 = this.o;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.o = null;
            }
            ValueAnimator valueAnimator3 = this.sx;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.sx = null;
            }
            this.k = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        nr(canvas);
        u(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = fx();
        }
        if (mode2 != 1073741824) {
            size2 = fx();
        }
        nr(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.dw;
        float f = this.pn;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        this.s.setTextSize(getMinLine() / 3.0f);
    }

    private void u(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.s);
        canvas.restore();
    }

    private float u(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void u() {
        AnimatorSet animatorSet = this.my;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.my.cancel();
            this.my = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.my = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.my.setInterpolator(new LinearInterpolator());
        this.my.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.bq = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.bq) {
                    CycleSkipView.this.bq = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.my.start();
    }

    private void nr(int i, int i2) {
        this.pn = (Math.min(i, i2) / 2.0f) - this.b;
    }

    private void nr(Canvas canvas) {
        float f;
        float fMax;
        float f2;
        canvas.save();
        float f3 = this.k * 360.0f;
        if (this.x) {
            if (this.t) {
                f = this.iz;
                f3 = -f3;
            } else {
                f = this.iz - f3;
            }
        } else {
            if (this.t) {
                float f4 = this.iz + 360;
                fMax = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
                canvas.drawCircle(0.0f, 0.0f, this.pn, this.mv);
                canvas.drawArc(this.dw, f2, fMax, false, this.l);
                canvas.restore();
            }
            f = this.iz;
        }
        fMax = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.pn, this.mv);
        canvas.drawArc(this.dw, f2, fMax, false, this.l);
        canvas.restore();
    }

    public void u(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.n = f;
        float f2 = i2;
        this.f5382a = f2;
        this.jk = i - i2;
        this.c = f2 / f;
        u();
    }
}
