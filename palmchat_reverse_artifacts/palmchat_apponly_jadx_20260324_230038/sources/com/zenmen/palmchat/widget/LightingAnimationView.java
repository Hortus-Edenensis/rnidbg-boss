package com.zenmen.palmchat.widget;

import android.animation.Animator;
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
import androidx.annotation.NonNull;
import com.zenmen.palmchat.framework.R$styleable;
import defpackage.ir5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LightingAnimationView extends View {
    private Animator.AnimatorListener animatorListener;
    private int[] colors;
    private Runnable finishRunnable;
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
    private boolean removeCancelAnim;
    private long startAnimationTime;

    public LightingAnimationView(Context context) {
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
                valueAnimator.removeListener(this.animatorListener);
                this.mValueAnimator.cancel();
            }
            float f5 = 2.0f * f4;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f - f5, f + f5);
            this.mValueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setRepeatCount(i3);
            this.mValueAnimator.setInterpolator(new LinearInterpolator());
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addListener(this.animatorListener);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: i23
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f18090a.lambda$showAnimation$0(f3, f4, valueAnimator2);
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

    public int getmDuration() {
        return this.mDuration;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.removeCancelAnim) {
            return;
        }
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

    public void setRemoveCancelAnim(boolean z) {
        this.removeCancelAnim = z;
    }

    public void setmDuration(int i) {
        this.mDuration = i;
    }

    public void startLightingAnimation(int i) {
        startLightingAnimation(i, null);
    }

    public LightingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void startLightingAnimation(int i, Runnable runnable) {
        this.finishRunnable = runnable;
        this.startAnimationTime = ir5.b();
        showAnimation(getWidth(), getHeight(), i, this.mDuration);
    }

    public LightingAnimationView(Context context, AttributeSet attributeSet, int i) {
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
        this.finishRunnable = null;
        this.startAnimationTime = 0L;
        this.animatorListener = new a();
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LightingAnimationView);
                String string = typedArrayObtainStyledAttributes.getString(R$styleable.LightingAnimationView_la_colors);
                String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.LightingAnimationView_la_positions);
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
                this.playMode = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView_la_play_mode, this.playMode);
                int i3 = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView_la_repeat, this.mRepeatCount);
                this.mRepeatCount = i3;
                if (i3 < 0 && i3 != -1) {
                    this.mRepeatCount = -1;
                }
                this.mDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.LightingAnimationView_la_duration, this.mDuration);
                this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.LightingAnimationView_la_radius, this.mRadius);
                this.mk = typedArrayObtainStyledAttributes.getFloat(R$styleable.LightingAnimationView_la_k, this.mk);
                this.mw = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.LightingAnimationView_la_w, this.mw);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            if (LightingAnimationView.this.finishRunnable == null || ir5.e(LightingAnimationView.this.startAnimationTime) <= LightingAnimationView.this.mDuration) {
                return;
            }
            LightingAnimationView.this.finishRunnable.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
        }
    }
}
