package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.square.R$color;
import com.zenmen.square.R$styleable;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CircleProgressView extends View {
    private int bgColor;
    private Paint bgPaint;
    private int max;
    private int progress;
    private int ringProgressColor;
    private Paint ringProgressPaint;
    private float ringWidth;

    public CircleProgressView(Context context) {
        this(context, null);
        initPaint();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressBarView);
        this.bgColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ProgressBarView_ringColor, context.getResources().getColor(R$color.color_eafff4));
        this.ringProgressColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ProgressBarView_ringProgressColor, context.getResources().getColor(R$color.color_222222));
        this.ringWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.ProgressBarView_ringWidth, a46.b(context, 3.0f));
        this.max = typedArrayObtainStyledAttributes.getInteger(R$styleable.ProgressBarView_max, 100);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setColor(this.bgColor);
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeWidth(this.ringWidth);
        this.bgPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.ringProgressPaint = paint2;
        paint2.setColor(this.ringProgressColor);
        this.ringProgressPaint.setStrokeWidth(this.ringWidth);
        this.ringProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.ringProgressPaint.setAntiAlias(true);
        this.ringProgressPaint.setStyle(Paint.Style.STROKE);
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public Paint getBgPaint() {
        return this.bgPaint;
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public int getRingProgressColor() {
        return this.ringProgressColor;
    }

    public Paint getRingProgressPaint() {
        return this.ringProgressPaint;
    }

    public float getRingWidth() {
        return this.ringWidth;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        canvas.drawCircle(f, getHeight() / 2, (int) (f - (this.ringWidth / 2.0f)), this.bgPaint);
        canvas.drawArc(new RectF(width - r3, r1 - r3, width + r3, r1 + r3), -90.0f, (this.progress * 360) / this.max, false, this.ringProgressPaint);
    }

    public void setBgColor(int i) {
        this.bgColor = i;
    }

    public void setBgPaint(Paint paint) {
        this.bgPaint = paint;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = i;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.progress = i;
            postInvalidate();
        }
    }

    public void setRingProgressColor(int i) {
        this.ringProgressColor = i;
    }

    public void setRingProgressPaint(Paint paint) {
        this.ringProgressPaint = paint;
    }

    public void setRingWidth(float f) {
        this.ringWidth = f;
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initAttrs(context, attributeSet);
        initPaint();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        initPaint();
    }
}
