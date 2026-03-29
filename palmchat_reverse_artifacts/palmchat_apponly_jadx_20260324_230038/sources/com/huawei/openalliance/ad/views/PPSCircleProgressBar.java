package com.huawei.openalliance.ad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSCircleProgressBar extends View {
    private static final int B = 2;
    private static final int C = 100;
    private static final String Code = "PPSCircleProgressBar";
    private static final String F = "...";
    private static final int I = 18;
    private static final int S = 1000;
    private static final int V = 10;
    private final byte[] D;
    private int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6971a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private int g;
    private float h;
    private int i;
    private Paint j;
    private String k;
    private Rect l;
    private int m;
    private ValueAnimator n;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        LEFT(0, 180.0f),
        TOP(1, 270.0f),
        RIGHT(2, 0.0f),
        BOTTOM(3, 90.0f);

        private final int B;
        private final float C;

        a(int i, float f) {
            this.B = i;
            this.C = f;
        }

        public static float I(int i) {
            a aVarV = V(i);
            if (aVarV == null) {
                return 0.0f;
            }
            return aVarV.V();
        }

        public int Code() {
            return this.B;
        }

        public float V() {
            return this.C;
        }

        public static a V(int i) {
            for (a aVar : values()) {
                if (aVar.Code(i)) {
                    return aVar;
                }
            }
            return RIGHT;
        }

        public boolean Code(int i) {
            return this.B == i;
        }
    }

    public PPSCircleProgressBar(Context context) {
        this(context, null);
    }

    private void I(float f) {
        synchronized (this.D) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.h, f);
            this.n = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSCircleProgressBar.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PPSCircleProgressBar.this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PPSCircleProgressBar.this.postInvalidate();
                }
            });
            this.n.setDuration(1000L);
            this.n.setInterpolator(new LinearInterpolator());
            this.n.start();
        }
    }

    private void V(float f) {
        synchronized (this.D) {
            I(f);
        }
    }

    private int getPaddingSize() {
        int paddingStart = getPaddingStart();
        if (paddingStart <= 0) {
            paddingStart = getPaddingLeft();
        }
        int paddingEnd = getPaddingEnd();
        if (paddingEnd <= 0) {
            paddingEnd = getPaddingRight();
        }
        return paddingStart + paddingEnd;
    }

    private int getProgressBarSize() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    public String getCurrentText() {
        String str;
        synchronized (this.D) {
            str = TextUtils.isEmpty(this.k) ? "" : this.k;
        }
        return str;
    }

    public int getInnerColor() {
        int i;
        synchronized (this.D) {
            i = this.b;
        }
        return i;
    }

    public int getMaxProgress() {
        int i;
        synchronized (this.D) {
            i = this.g;
        }
        return i;
    }

    public int getOuterColor() {
        int i;
        synchronized (this.D) {
            i = this.L;
        }
        return i;
    }

    public float getOuterRadius() {
        float f;
        synchronized (this.D) {
            f = this.f6971a;
        }
        return f;
    }

    public float getProgress() {
        float f;
        synchronized (this.D) {
            f = this.h;
        }
        return f;
    }

    public float getProgressWidth() {
        float f;
        synchronized (this.D) {
            f = this.f;
        }
        return f;
    }

    public int getStartPoint() {
        int i;
        synchronized (this.D) {
            i = this.i;
        }
        return i;
    }

    public int getTextColor() {
        int i;
        synchronized (this.D) {
            i = this.d;
        }
        return i;
    }

    public float getTextSize() {
        float f;
        synchronized (this.D) {
            f = this.e;
        }
        return f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.D) {
            try {
                super.onDraw(canvas);
                int width = getWidth() / 2;
                this.j.setColor(this.c);
                this.j.setStyle(Paint.Style.FILL);
                this.j.setAntiAlias(true);
                float f = width;
                canvas.drawCircle(f, f, this.f6971a, this.j);
                this.j.setColor(this.b);
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setStrokeWidth(this.f);
                this.j.setAntiAlias(true);
                canvas.drawCircle(f, f, this.f6971a, this.j);
                this.j.setColor(this.L);
                float f2 = this.f6971a;
                canvas.drawArc(new RectF(f - f2, f - f2, f + f2, f + f2), a.I(this.i), (this.h / this.g) * 360.0f, false, this.j);
                this.l = new Rect();
                this.j.setColor(this.d);
                this.j.setStyle(Paint.Style.FILL);
                this.j.setTextSize(Code(this.k, this.e));
                this.j.setStrokeWidth(0.0f);
                String currentText = getCurrentText();
                this.k = currentText;
                this.j.getTextBounds(currentText, 0, currentText.length(), this.l);
                this.j.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetricsInt fontMetricsInt = this.j.getFontMetricsInt();
                int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
                int i = fontMetricsInt.top;
                canvas.drawText(this.k, (getMeasuredWidth() / 2) - (this.l.width() / 2), ((measuredHeight + i) / 2) - i, this.j);
            } catch (Throwable unused) {
                fh.I(Code, "onDraw error.");
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        synchronized (this.D) {
            try {
                int size = View.MeasureSpec.getSize(i);
                if (View.MeasureSpec.getMode(i) != 1073741824) {
                    size = (int) ((this.f6971a * 2.0f) + this.f);
                }
                int size2 = View.MeasureSpec.getSize(i2);
                if (View.MeasureSpec.getMode(i2) != 1073741824) {
                    size2 = (int) ((this.f6971a * 2.0f) + this.f);
                }
                setMeasuredDimension(size, size2);
            } catch (Throwable unused) {
                fh.I(Code, "onMeasure error.");
            }
        }
    }

    public void setCurrentText(String str) {
        synchronized (this.D) {
            this.k = str;
        }
    }

    public void setInnerColor(int i) {
        synchronized (this.D) {
            this.b = i;
        }
    }

    public void setMaxProgress(int i) {
        synchronized (this.D) {
            this.g = i;
        }
    }

    public void setOuterColor(int i) {
        synchronized (this.D) {
            this.L = i;
        }
    }

    public void setOuterRadius(float f) {
        synchronized (this.D) {
            this.f6971a = f;
        }
    }

    public void setProgress(float f) {
        synchronized (this.D) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            int i = this.g;
            if (f > i) {
                f = i;
            }
            V(f);
        }
    }

    public void setProgressWidth(float f) {
        synchronized (this.D) {
            this.f = f;
        }
    }

    public void setStartPoint(int i) {
        synchronized (this.D) {
            this.i = i;
        }
    }

    public void setTextColor(int i) {
        synchronized (this.D) {
            this.d = i;
        }
    }

    public void setTextSize(float f) {
        synchronized (this.D) {
            this.e = f;
        }
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new byte[0];
        Code(context, attributeSet);
        Code();
    }

    private float Code(CharSequence charSequence, float f) {
        int paddingSize = getPaddingSize();
        int progressBarSize = getProgressBarSize();
        int iCode = z.Code(getContext(), f);
        while (iCode > 10 && !Code(charSequence, iCode, paddingSize, progressBarSize)) {
            iCode--;
        }
        if (iCode <= 10 && !Code(charSequence, iCode, paddingSize, progressBarSize)) {
            this.k = (String) Code(this.k, this.l.width() + getPaddingSize(), getProgressBarSize());
            this.j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.l);
        }
        float fZ = z.Z(getContext(), iCode);
        Code(fZ);
        return fZ;
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    private CharSequence Code(CharSequence charSequence, int i, int i2) {
        int length = getCurrentText().length();
        int iCeil = (int) Math.ceil((((double) (i - i2)) / ((double) this.l.width())) * ((double) length));
        int iCeil2 = (int) Math.ceil(((double) (this.m * length)) / ((double) this.l.width()));
        int i3 = length - iCeil;
        if (i3 - iCeil2 <= 0) {
            return i3 > 0 ? charSequence.toString().substring(0, i3) : charSequence;
        }
        return charSequence.toString().substring(0, length - (iCeil + iCeil2)) + F;
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    private void Code() {
        Code(this.e);
    }

    private void Code(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Rect rect = new Rect();
        paint.getTextBounds(F, 0, 3, rect);
        this.m = rect.width();
    }

    public void Code(float f, String str) {
        setCurrentText(str);
        setProgress(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.res.TypedArray] */
    private void Code(Context context, AttributeSet attributeSet) {
        Resources resources;
        synchronized (this.D) {
            if (attributeSet != 0) {
                try {
                    attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_circle);
                    try {
                        try {
                            resources = getResources();
                        } catch (UnsupportedOperationException unused) {
                            fh.I(Code, "initButtonAttr UnsupportedOperationException");
                        }
                    } catch (RuntimeException unused2) {
                        fh.I(Code, "initButtonAttr RuntimeException");
                    } catch (Throwable th) {
                        fh.I(Code, "initButtonAttr error: " + th.getClass().getSimpleName());
                    }
                    if (resources == null) {
                        fh.I(Code, "init attr, resource is null");
                        return;
                    }
                    this.L = attributeSet.getColor(R.styleable.hiad_circle_progress_outerColor, resources.getColor(R.color.hiad_circle_outer));
                    this.f6971a = attributeSet.getDimension(R.styleable.hiad_circle_progress_outerRadius, resources.getDimension(R.dimen.hiad_24_dp));
                    this.b = attributeSet.getColor(R.styleable.hiad_circle_progress_innerColor, resources.getColor(R.color.hiad_circle_inner));
                    this.d = attributeSet.getColor(R.styleable.hiad_circle_progress_textColor, resources.getColor(R.color.hiad_circle_text));
                    this.c = attributeSet.getColor(R.styleable.hiad_circle_progress_fillColor, resources.getColor(R.color.hiad_circle_fill));
                    this.e = attributeSet.getDimension(R.styleable.hiad_circle_progress_textSize, z.Z(context, 18.0f));
                    this.f = attributeSet.getDimension(R.styleable.hiad_circle_progress_progressWidth, z.V(context, 2.0f));
                    this.h = attributeSet.getFloat(R.styleable.hiad_circle_progress_progress, 0.0f);
                    this.g = attributeSet.getInt(R.styleable.hiad_circle_progress_maxProgress, 100);
                    this.i = attributeSet.getInt(R.styleable.hiad_circle_progress_startPoint, a.BOTTOM.Code());
                    this.j = new Paint();
                } finally {
                    attributeSet.recycle();
                }
            }
        }
    }

    private boolean Code(CharSequence charSequence, int i, int i2, int i3) {
        float fZ = z.Z(getContext(), i);
        if (i3 < 0) {
            return true;
        }
        this.j.setTextSize(fZ);
        this.j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.l);
        return this.l.width() + i2 <= i3;
    }
}
