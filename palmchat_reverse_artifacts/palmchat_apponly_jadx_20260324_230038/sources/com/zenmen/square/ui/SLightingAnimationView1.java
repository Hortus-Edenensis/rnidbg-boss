package com.zenmen.square.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.zenmen.square.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SLightingAnimationView1 extends View {
    private int[] colors;
    private final Path mClipPath;
    private int mDuration;
    private final Paint mPaint;
    private final Path mPath;
    private int mRadius;
    private final RectF mRect;
    private int mRepeatCount;
    private ValueAnimator mValueAnimator;
    private float mk;
    private int mw;
    private int playMode;
    private float[] positions;

    public SLightingAnimationView1(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAnimation$0(float f, float f2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = fFloatValue + f2;
        this.mPaint.setShader(new LinearGradient(fFloatValue, f * fFloatValue, f3, f * f3, this.colors, this.positions, Shader.TileMode.CLAMP));
        invalidate();
    }

    private void showAnimation(int i, int i2, int i3, long j) {
        try {
            this.mPath.moveTo(0.0f, 0.0f);
            float f = i;
            this.mPath.lineTo(f, 0.0f);
            float f2 = i2;
            this.mPath.lineTo(f, f2);
            this.mPath.lineTo(0.0f, f2);
            this.mPath.close();
            final float f3 = this.mk;
            if (this.mw < 0) {
                this.mw = i / 6;
            }
            final float f4 = this.mw;
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            float f5 = 2.0f * f4;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f - f5, f + f5);
            this.mValueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setRepeatCount(i3);
            this.mValueAnimator.setInterpolator(new LinearInterpolator());
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a05
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f1131a.lambda$showAnimation$0(f3, f4, valueAnimator2);
                }
            });
            this.mValueAnimator.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float getMk() {
        return this.mk;
    }

    public int getMw() {
        return this.mw;
    }

    public int getRadius() {
        return this.mRadius;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mValueAnimator = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            this.mClipPath.reset();
            if (this.mRadius < 0) {
                this.mRadius = getHeight() / 2;
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            Path path = this.mClipPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
            canvas.clipPath(this.mClipPath);
            canvas.drawPath(this.mPath, this.mPaint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
    }

    public void setMk(float f) {
        this.mk = f;
    }

    public void setMw(int i) {
        this.mw = i;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public void startLightingAnimation(int i) {
        showAnimation(getWidth(), getHeight(), i, this.mDuration);
    }

    public SLightingAnimationView1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SLightingAnimationView1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mValueAnimator = null;
        this.mRadius = -1;
        this.mClipPath = new Path();
        this.mRect = new RectF();
        this.colors = new int[]{Color.parseColor("#00FFF7CC"), Color.parseColor("#E6FFF7CC"), Color.parseColor("#E6FFF7CC"), Color.parseColor("#00FFF7CC")};
        this.positions = new float[]{0.0f, 0.4f, 0.5f, 1.0f};
        this.playMode = 1;
        this.mDuration = 1600;
        this.mRepeatCount = -1;
        this.mk = 0.45f;
        this.mw = -1;
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LightingAnimationView1);
                String string = typedArrayObtainStyledAttributes.getString(R$styleable.LightingAnimationView1_la_colors1);
                String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.LightingAnimationView1_la_positions1);
                if (string != null && string2 != null) {
                    String[] strArrSplit = string.split(",");
                    String[] strArrSplit2 = string2.split(",");
                    int length = strArrSplit.length;
                    if (length == strArrSplit2.length) {
                        this.colors = new int[length];
                        this.positions = new float[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            this.colors[i2] = Color.parseColor(strArrSplit[i2]);
                            this.positions[i2] = Float.parseFloat(strArrSplit2[i2]);
                        }
                    }
                }
                this.playMode = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView1_la_play_mode1, this.playMode);
                int i3 = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView1_la_repeat1, this.mRepeatCount);
                this.mRepeatCount = i3;
                if (i3 < 0 && i3 != -1) {
                    this.mRepeatCount = -1;
                }
                this.mDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView1_la_duration1, this.mDuration);
                this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.LightingAnimationView1_la_radius1, this.mRadius);
                this.mk = typedArrayObtainStyledAttributes.getFloat(R$styleable.LightingAnimationView1_la_k1, this.mk);
                this.mw = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.LightingAnimationView1_la_w1, this.mw);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
