package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.core.dw;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTCountdownViewForCircle extends View implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5257a;
    private int b;
    private Paint bg;
    private float bq;
    private RectF c;
    private boolean d;
    private float dw;
    private int fx;
    private ValueAnimator gi;
    private AtomicBoolean h;
    private float iz;
    private float jk;
    private boolean k;
    private ValueAnimator kj;
    private float l;
    private String mv;
    private Paint my;
    private int n;
    private int nr;
    private Paint o;
    private float pn;
    private u q;
    private AnimatorSet qq;
    private boolean s;
    private Paint sx;
    private float t;
    private int u;
    private float x;
    private ValueAnimator z;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    private void b() {
        Paint paint = new Paint(1);
        this.my = paint;
        paint.setColor(this.u);
        this.my.setStrokeWidth(this.pn);
        this.my.setAntiAlias(true);
        this.my.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.o = paint2;
        paint2.setColor(this.fx);
        this.o.setAntiAlias(true);
        this.o.setStrokeWidth(this.pn);
        this.o.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.sx = paint3;
        paint3.setColor(this.nr);
        this.sx.setAntiAlias(true);
        this.sx.setStrokeWidth(this.pn / 2.0f);
        this.sx.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.bg = paint4;
        paint4.setColor(this.b);
        this.sx.setAntiAlias(true);
        this.bg.setTextSize(this.iz);
        this.bg.setTextAlign(Paint.Align.CENTER);
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.bq, 0.0f);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.z.setDuration((long) (u(this.bq, this.jk) * 1000.0f));
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.bq = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.z;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.kj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.kj = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.dw, 0.0f);
        this.kj = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.kj.setDuration((long) (u(this.dw, this.t) * 1000.0f));
        this.kj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.dw = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.kj;
    }

    private int iz() {
        return (int) ((((this.pn / 2.0f) + this.x) * 2.0f) + u(4.0f));
    }

    private void pn() {
        float f = this.x;
        this.c = new RectF(-f, -f, f, f);
    }

    private void x() {
        try {
            AnimatorSet animatorSet = this.qq;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.qq = null;
            }
            ValueAnimator valueAnimator = this.gi;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.gi = null;
            }
            ValueAnimator valueAnimator2 = this.kj;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.kj = null;
            }
            ValueAnimator valueAnimator3 = this.z;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.z = null;
            }
            this.bq = 1.0f;
            this.dw = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    public void fx() {
        AnimatorSet animatorSet;
        try {
            if (this.k || (animatorSet = this.qq) == null) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    public u getCountdownListener() {
        return this.q;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        x();
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
            size = iz();
        }
        if (mode2 != 1073741824) {
            size2 = iz();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.h.set(z);
        if (this.k) {
            return;
        }
        if (this.h.get()) {
            fx();
        } else {
            nr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void setCountDownTime(int i) {
        float f = i;
        this.t = f;
        this.jk = f;
        x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void setCountdownListener(u uVar) {
        this.q = uVar;
        this.h.get();
    }

    public float u(float f, float f2) {
        return f * f2;
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float u(float f, int i) {
        return i * f;
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = Color.parseColor("#fce8b6");
        this.nr = Color.parseColor("#f0f0f0");
        this.fx = Color.parseColor("#ffffff");
        this.b = Color.parseColor("#7c7c7c");
        this.pn = 2.0f;
        this.iz = 12.0f;
        this.x = 18.0f;
        this.n = 270;
        this.f5257a = false;
        this.jk = 5.0f;
        this.t = 5.0f;
        this.l = 0.8f;
        this.mv = "跳过";
        this.s = false;
        this.k = false;
        this.bq = 1.0f;
        this.dw = 1.0f;
        this.d = false;
        this.h = new AtomicBoolean(true);
        this.pn = u(2.0f);
        this.x = u(18.0f);
        this.iz = nr(12.0f);
        this.n %= 360;
        b();
        pn();
    }

    private void nr(Canvas canvas) {
        float f;
        canvas.save();
        float fU = u(this.bq, 360);
        if (this.f5257a) {
            f = this.n - fU;
        } else {
            f = this.n;
        }
        canvas.drawCircle(0.0f, 0.0f, this.x, this.o);
        canvas.drawCircle(0.0f, 0.0f, this.x, this.sx);
        canvas.drawArc(this.c, f, fU, false, this.my);
        canvas.restore();
    }

    private void u(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.bg.getFontMetrics();
        String strGb = dw.nr().gb();
        this.mv = strGb;
        if (TextUtils.isEmpty(strGb)) {
            this.mv = "跳过";
        }
        canvas.drawText(this.mv, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.bg);
        canvas.restore();
    }

    private float nr(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void u() {
        if (this.k) {
            return;
        }
        AnimatorSet animatorSet = this.qq;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.qq.cancel();
            this.qq = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.qq = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.qq.setInterpolator(new LinearInterpolator());
        this.qq.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.d = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.d) {
                    TTCountdownViewForCircle.this.d = false;
                } else if (TTCountdownViewForCircle.this.q != null) {
                    TTCountdownViewForCircle.this.q.u();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.qq.start();
        if (this.h.get()) {
            return;
        }
        nr();
    }

    public void nr() {
        try {
            AnimatorSet animatorSet = this.qq;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void u(boolean z) {
        this.k = z;
        if (z) {
            x();
        }
    }

    private float u(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
