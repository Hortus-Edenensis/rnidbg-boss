package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RangeSeekBar extends View {
    private static final int INVALID_POINTER_ID = 255;
    private final float NO_FIXED_GAP;
    private final float NO_STEP;
    private float _barHeight;
    private Paint _bmpPaint;
    private Paint _paint;
    private RectF _rect;
    private float absoluteMaxStartValue;
    private float absoluteMaxValue;
    private float absoluteMinStartValue;
    private float absoluteMinValue;
    private int barColor;
    private int barColorMode;
    private int barGradientEnd;
    private int barGradientStart;
    private float barHeight;
    private int barHighlightColor;
    private int barHighlightColorMode;
    private int barHighlightGradientEnd;
    private int barHighlightGradientStart;
    private float cornerRadius;
    private int dataType;
    private float fixGap;
    private float gap;
    private Bitmap leftThumb;
    private int leftThumbColor;
    private int leftThumbColorNormal;
    private int leftThumbColorPressed;
    private Bitmap leftThumbPressed;
    private int mActivePointerId;
    private boolean mIsDragging;
    private float maxStartValue;
    private float maxValue;
    private float minStartValue;
    private float minValue;
    private double normalizedMaxValue;
    private double normalizedMinValue;
    private a onRangeSeekBarChangeListener;
    private b onRangeSeekBarFinalValueListener;
    private int pointerIndex;
    private Thumb pressedThumb;
    private RectF rectLeftThumb;
    private RectF rectRightThumb;
    private Bitmap rightThumb;
    private int rightThumbColor;
    private int rightThumbColorNormal;
    private int rightThumbColorPressed;
    private Bitmap rightThumbPressed;
    private boolean seekBarTouchEnabled;
    private float steps;
    private float thumbDiameter;
    private float thumbHeight;
    private float thumbWidth;

    /* JADX INFO: compiled from: SearchBox */
    public enum Thumb {
        MIN,
        MAX
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    private void addFixGap(boolean z) {
        if (z) {
            double d = this.normalizedMinValue;
            float f = this.fixGap;
            double d2 = d + ((double) f);
            this.normalizedMaxValue = d2;
            if (d2 >= 100.0d) {
                this.normalizedMaxValue = 100.0d;
                this.normalizedMinValue = 100.0d - ((double) f);
                return;
            }
            return;
        }
        double d3 = this.normalizedMaxValue;
        float f2 = this.fixGap;
        double d4 = d3 - ((double) f2);
        this.normalizedMinValue = d4;
        if (d4 <= 0.0d) {
            this.normalizedMinValue = 0.0d;
            this.normalizedMaxValue = 0.0d + ((double) f2);
        }
    }

    private void addMaxGap() {
        double d = this.normalizedMaxValue;
        float f = this.gap;
        if (d - ((double) f) < this.normalizedMinValue) {
            double d2 = d - ((double) f);
            this.normalizedMinValue = d2;
            double dMax = Math.max(0.0d, Math.min(100.0d, Math.min(d2, d)));
            this.normalizedMinValue = dMax;
            double d3 = this.normalizedMaxValue;
            float f2 = this.gap;
            if (d3 <= ((double) f2) + dMax) {
                this.normalizedMaxValue = dMax + ((double) f2);
            }
        }
    }

    private void addMinGap() {
        double d = this.normalizedMinValue;
        float f = this.gap;
        if (((double) f) + d > this.normalizedMaxValue) {
            double d2 = ((double) f) + d;
            this.normalizedMaxValue = d2;
            double dMax = Math.max(0.0d, Math.min(100.0d, Math.max(d2, d)));
            this.normalizedMaxValue = dMax;
            double d3 = this.normalizedMinValue;
            float f2 = this.gap;
            if (d3 >= dMax - ((double) f2)) {
                this.normalizedMinValue = dMax - ((double) f2);
            }
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private Thumb evalPressedThumb(float f) {
        boolean zIsInThumbRange = isInThumbRange(f, this.normalizedMinValue);
        boolean zIsInThumbRange2 = isInThumbRange(f, this.normalizedMaxValue);
        Thumb thumb = (zIsInThumbRange && zIsInThumbRange2 && getWidth() > 0) ? f / ((float) getWidth()) > 0.5f ? Thumb.MIN : Thumb.MAX : zIsInThumbRange ? Thumb.MIN : zIsInThumbRange2 ? Thumb.MAX : null;
        return (this.seekBarTouchEnabled && thumb == null) ? findClosestThumb(f) : thumb;
    }

    private Thumb findClosestThumb(float f) {
        float fNormalizedToScreen = normalizedToScreen(this.normalizedMinValue);
        float fNormalizedToScreen2 = normalizedToScreen(this.normalizedMaxValue);
        return f >= fNormalizedToScreen2 ? Thumb.MAX : f <= fNormalizedToScreen ? Thumb.MIN : ((double) Math.abs(fNormalizedToScreen - f)) < ((double) Math.abs(fNormalizedToScreen2 - f)) ? Thumb.MIN : Thumb.MAX;
    }

    private <T extends Number> Number formatValue(T t) throws IllegalArgumentException {
        Double d = (Double) t;
        int i = this.dataType;
        if (i == 0) {
            return Long.valueOf(d.longValue());
        }
        if (i == 1) {
            return d;
        }
        if (i == 2) {
            return Long.valueOf(Math.round(d.doubleValue()));
        }
        if (i == 3) {
            return Float.valueOf(d.floatValue());
        }
        if (i == 4) {
            return Short.valueOf(d.shortValue());
        }
        if (i == 5) {
            return Byte.valueOf(d.byteValue());
        }
        throw new IllegalArgumentException("Number class '" + t.getClass().getName() + "' is not supported");
    }

    private boolean isInThumbRange(float f, double d) {
        float fNormalizedToScreen = normalizedToScreen(d) - (getThumbWidth() / 2.0f);
        return f >= fNormalizedToScreen && f <= getThumbWidth() + fNormalizedToScreen;
    }

    private float normalizedToScreen(double d) {
        return ((((float) d) / 100.0f) * ((getWidth() - getPaddingLeft()) - getPaddingRight())) + getPaddingLeft();
    }

    private double normalizedToValue(double d) {
        float f = this.maxValue;
        float f2 = this.minValue;
        return ((d / 100.0d) * ((double) (f - f2))) + ((double) f2);
    }

    private void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    private void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    private double screenToNormalized(float f) {
        float paddingLeft = f - getPaddingLeft();
        double width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width <= 0.0d) {
            return 0.0d;
        }
        return Math.min(100.0d, Math.max(0.0d, (((double) paddingLeft) / width) * 100.0d));
    }

    private void setNormalizedMaxValue(double d) {
        this.normalizedMaxValue = Math.max(0.0d, Math.min(100.0d, Math.max(d, this.normalizedMinValue)));
        float f = this.fixGap;
        if (f == -1.0f || f <= 0.0f) {
            addMaxGap();
        } else {
            addFixGap(false);
        }
        invalidate();
    }

    private void setNormalizedMinValue(double d) {
        this.normalizedMinValue = Math.max(0.0d, Math.min(100.0d, Math.min(d, this.normalizedMaxValue)));
        float f = this.fixGap;
        if (f == -1.0f || f <= 0.0f) {
            addMinGap();
        } else {
            addFixGap(true);
        }
        invalidate();
    }

    public void apply() {
        this.normalizedMinValue = 0.0d;
        this.normalizedMaxValue = 100.0d;
        float fMax = Math.max(0.0f, Math.min(this.gap, this.absoluteMaxValue - this.absoluteMinValue));
        float f = this.absoluteMaxValue;
        this.gap = (fMax / (f - this.absoluteMinValue)) * 100.0f;
        float f2 = this.fixGap;
        if (f2 != -1.0f) {
            this.fixGap = (Math.min(f2, f) / (this.absoluteMaxValue - this.absoluteMinValue)) * 100.0f;
            addFixGap(true);
        }
        this.thumbWidth = getThumbWidth();
        this.thumbHeight = getThumbHeight();
        this.barHeight = getBarHeight();
        float f3 = this.minStartValue;
        if (f3 <= this.absoluteMinValue) {
            this.minStartValue = 0.0f;
            setNormalizedMinValue(0.0f);
        } else {
            float f4 = this.absoluteMaxValue;
            if (f3 >= f4) {
                this.minStartValue = f4;
                setMinStartValue();
            } else {
                setMinStartValue();
            }
        }
        float f5 = this.maxStartValue;
        if (f5 < this.absoluteMinStartValue || f5 <= this.absoluteMinValue) {
            this.maxStartValue = 0.0f;
            setNormalizedMaxValue(0.0f);
        } else {
            float f6 = this.absoluteMaxValue;
            if (f5 >= f6) {
                this.maxStartValue = f6;
                setMaxStartValue();
            } else {
                setMaxStartValue();
            }
        }
        invalidate();
    }

    public void drawBar(Canvas canvas, Paint paint, RectF rectF) {
        float f = this.cornerRadius;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    public void drawHighlightBar(Canvas canvas, Paint paint, RectF rectF) {
        float f = this.cornerRadius;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    public void drawLeftThumbWithColor(Canvas canvas, Paint paint, RectF rectF) {
        canvas.drawOval(rectF, paint);
    }

    public void drawLeftThumbWithImage(Canvas canvas, Paint paint, RectF rectF, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, rectF.left, rectF.top, paint);
    }

    public void drawRightThumbWithColor(Canvas canvas, Paint paint, RectF rectF) {
        canvas.drawOval(rectF, paint);
    }

    public void drawRightThumbWithImage(Canvas canvas, Paint paint, RectF rectF, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, rectF.left, rectF.top, paint);
    }

    public float getBarHeight() {
        float f = this._barHeight;
        return f > 0.0f ? f : this.thumbHeight * 0.5f * 0.3f;
    }

    public float getBarPadding() {
        return this.thumbWidth * 0.5f;
    }

    public Bitmap getBitmap(Drawable drawable) {
        if (drawable != null) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public RectF getLeftThumbRect() {
        return this.rectLeftThumb;
    }

    public int getMeasureSpecHeight(int i) {
        int iRound = Math.round(this.thumbHeight);
        return View.MeasureSpec.getMode(i) != 0 ? Math.min(iRound, View.MeasureSpec.getSize(i)) : iRound;
    }

    public int getMeasureSpecWith(int i) {
        if (View.MeasureSpec.getMode(i) != 0) {
            return View.MeasureSpec.getSize(i);
        }
        return 200;
    }

    public Thumb getPressedThumb() {
        return this.pressedThumb;
    }

    public RectF getRightThumbRect() {
        return this.rectRightThumb;
    }

    public Number getSelectedMaxValue() {
        double d = this.normalizedMaxValue;
        float f = this.steps;
        if (f > 0.0f && f <= Math.abs(this.absoluteMaxValue) / 2.0f) {
            float f2 = this.absoluteMaxValue;
            float f3 = this.absoluteMinValue;
            if (f2 - f3 > 0.0f) {
                float f4 = (this.steps / (f2 - f3)) * 100.0f;
                double d2 = f4;
                double d3 = d % d2;
                d = d3 > ((double) (f4 / 2.0f)) ? (d - d3) + d2 : d - d3;
            }
        }
        return formatValue(Double.valueOf(normalizedToValue(d)));
    }

    public Number getSelectedMinValue() {
        double d = this.normalizedMinValue;
        float f = this.steps;
        if (f > 0.0f && f <= Math.abs(this.absoluteMaxValue) / 2.0f) {
            float f2 = this.absoluteMaxValue;
            float f3 = this.absoluteMinValue;
            if (f2 - f3 > 0.0f) {
                float f4 = (this.steps / (f2 - f3)) * 100.0f;
                double d2 = f4;
                double d3 = d % d2;
                d = d3 > ((double) (f4 / 2.0f)) ? (d - d3) + d2 : d - d3;
            }
        }
        return formatValue(Double.valueOf(normalizedToValue(d)));
    }

    public float getThumbDiameter() {
        return this.thumbDiameter;
    }

    public float getThumbHeight() {
        return this.leftThumb != null ? r0.getHeight() : getThumbDiameter();
    }

    public float getThumbWidth() {
        return this.leftThumb != null ? r0.getWidth() : getThumbDiameter();
    }

    public void init() {
        this._paint = new Paint(1);
        this._bmpPaint = new Paint(1);
        this._rect = new RectF();
        this.rectLeftThumb = new RectF();
        this.rectRightThumb = new RectF();
        this.pressedThumb = null;
        setWillNotDraw(false);
    }

    public final void log(Object obj) {
        Log.d("CRS=>", String.valueOf(obj));
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        setupBar(canvas, this._paint, this._rect);
        setupHighlightBar(canvas, this._paint, this._rect);
        setupLeftThumb(canvas, this._paint, this._rect);
        setupRightThumb(canvas, this._paint, this._rect);
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(getMeasureSpecWith(i), getMeasureSpecHeight(i2));
    }

    @Override // android.view.View
    public synchronized boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.mActivePointerId = pointerId;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            this.pointerIndex = iFindPointerIndex;
            Thumb thumbEvalPressedThumb = evalPressedThumb(motionEvent.getX(iFindPointerIndex));
            this.pressedThumb = thumbEvalPressedThumb;
            if (thumbEvalPressedThumb == null) {
                return super.onTouchEvent(motionEvent);
            }
            touchDown(motionEvent.getX(this.pointerIndex), motionEvent.getY(this.pointerIndex));
            setPressed(true);
            invalidate();
            onStartTrackingTouch();
            trackTouchEvent(motionEvent);
            attemptClaimDrag();
        } else if (action == 1) {
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
                setPressed(false);
                touchUp(motionEvent.getX(this.pointerIndex), motionEvent.getY(this.pointerIndex));
            } else {
                onStartTrackingTouch();
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
            }
            this.pressedThumb = null;
            invalidate();
        } else if (action != 2) {
            if (action == 3) {
                if (this.mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                    touchUp(motionEvent.getX(this.pointerIndex), motionEvent.getY(this.pointerIndex));
                }
                invalidate();
            } else if (action == 6) {
                invalidate();
            }
        } else if (this.pressedThumb != null && this.mIsDragging) {
            touchMove(motionEvent.getX(this.pointerIndex), motionEvent.getY(this.pointerIndex));
            trackTouchEvent(motionEvent);
        }
        return true;
    }

    public RangeSeekBar setBarColor(int i) {
        this.barColor = i;
        return this;
    }

    public RangeSeekBar setBarColorMode(int i) {
        this.barColorMode = i;
        return this;
    }

    public RangeSeekBar setBarGradientEnd(int i) {
        this.barGradientEnd = i;
        return this;
    }

    public RangeSeekBar setBarGradientStart(int i) {
        this.barGradientStart = i;
        return this;
    }

    public RangeSeekBar setBarHeight(float f) {
        this._barHeight = f;
        return this;
    }

    public RangeSeekBar setBarHighlightColor(int i) {
        this.barHighlightColor = i;
        return this;
    }

    public RangeSeekBar setBarHighlightColorMode(int i) {
        this.barHighlightColorMode = i;
        return this;
    }

    public RangeSeekBar setBarHighlightGradientEnd(int i) {
        this.barHighlightGradientEnd = i;
        return this;
    }

    public RangeSeekBar setBarHighlightGradientStart(int i) {
        this.barHighlightGradientStart = i;
        return this;
    }

    public void setBeginValue(float f) {
        this.minStartValue = f;
        this.absoluteMinStartValue = f;
        setMinStartValue();
    }

    public RangeSeekBar setCornerRadius(float f) {
        this.cornerRadius = f;
        return this;
    }

    public RangeSeekBar setDataType(int i) {
        this.dataType = i;
        return this;
    }

    public void setEndValue(float f) {
        this.maxStartValue = f;
        this.absoluteMaxStartValue = f;
        setMaxStartValue();
    }

    public RangeSeekBar setFixGap(float f) {
        this.fixGap = f;
        return this;
    }

    public RangeSeekBar setGap(float f) {
        this.gap = f;
        return this;
    }

    public RangeSeekBar setLeftThumbBitmap(Bitmap bitmap) {
        this.leftThumb = bitmap;
        return this;
    }

    public RangeSeekBar setLeftThumbColor(int i) {
        this.leftThumbColorNormal = i;
        return this;
    }

    public RangeSeekBar setLeftThumbDrawable(int i) {
        setLeftThumbDrawable(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public RangeSeekBar setLeftThumbHighlightBitmap(Bitmap bitmap) {
        this.leftThumbPressed = bitmap;
        return this;
    }

    public RangeSeekBar setLeftThumbHighlightColor(int i) {
        this.leftThumbColorPressed = i;
        return this;
    }

    public RangeSeekBar setLeftThumbHighlightDrawable(int i) {
        setLeftThumbHighlightDrawable(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public RangeSeekBar setMaxStartValue(float f) {
        this.maxStartValue = f;
        this.absoluteMaxStartValue = f;
        return this;
    }

    public RangeSeekBar setMaxValue(float f) {
        this.maxValue = f;
        this.absoluteMaxValue = f;
        return this;
    }

    public RangeSeekBar setMinStartValue(float f) {
        this.minStartValue = f;
        this.absoluteMinStartValue = f;
        return this;
    }

    public RangeSeekBar setMinValue(float f) {
        this.minValue = f;
        this.absoluteMinValue = f;
        return this;
    }

    public RangeSeekBar setRightThumbBitmap(Bitmap bitmap) {
        this.rightThumb = bitmap;
        return this;
    }

    public RangeSeekBar setRightThumbColor(int i) {
        this.rightThumbColorNormal = i;
        return this;
    }

    public RangeSeekBar setRightThumbDrawable(int i) {
        setRightThumbDrawable(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public RangeSeekBar setRightThumbHighlightBitmap(Bitmap bitmap) {
        this.rightThumbPressed = bitmap;
        return this;
    }

    public RangeSeekBar setRightThumbHighlightColor(int i) {
        this.rightThumbColorPressed = i;
        return this;
    }

    public RangeSeekBar setRightThumbHighlightDrawable(int i) {
        setRightThumbHighlightDrawable(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public RangeSeekBar setSteps(float f) {
        this.steps = f;
        return this;
    }

    public void setupBar(Canvas canvas, Paint paint, RectF rectF) {
        rectF.left = getPaddingLeft();
        rectF.top = (getHeight() - this.barHeight) * 0.5f;
        rectF.right = getWidth() - getPaddingRight();
        rectF.bottom = (getHeight() + this.barHeight) * 0.5f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        if (this.barColorMode == 0) {
            paint.setColor(this.barColor);
            drawBar(canvas, paint, rectF);
        } else {
            paint.setShader(new LinearGradient(rectF.left, rectF.bottom, rectF.right, rectF.top, this.barGradientStart, this.barGradientEnd, Shader.TileMode.MIRROR));
            drawBar(canvas, paint, rectF);
            paint.setShader(null);
        }
    }

    public void setupHighlightBar(Canvas canvas, Paint paint, RectF rectF) {
        rectF.left = normalizedToScreen(this.normalizedMinValue);
        rectF.right = normalizedToScreen(this.normalizedMaxValue);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        if (this.barHighlightColorMode == 0) {
            paint.setColor(this.barHighlightColor);
            drawHighlightBar(canvas, paint, rectF);
        } else {
            paint.setShader(new LinearGradient(rectF.left, rectF.bottom, rectF.right, rectF.top, this.barHighlightGradientStart, this.barHighlightGradientEnd, Shader.TileMode.MIRROR));
            drawHighlightBar(canvas, paint, rectF);
            paint.setShader(null);
        }
    }

    public void setupLeftThumb(Canvas canvas, Paint paint, RectF rectF) {
        Thumb thumb = Thumb.MIN;
        this.leftThumbColor = thumb.equals(this.pressedThumb) ? this.leftThumbColorPressed : this.leftThumbColorNormal;
        this.rectLeftThumb.left = normalizedToScreen(this.normalizedMinValue) - (getThumbWidth() / 2.0f);
        RectF rectF2 = this.rectLeftThumb;
        rectF2.right = Math.min(rectF2.left + getThumbWidth(), getWidth());
        RectF rectF3 = this.rectLeftThumb;
        rectF3.top = 0.0f;
        rectF3.bottom = this.thumbHeight;
        if (this.leftThumb != null) {
            drawLeftThumbWithImage(canvas, this._bmpPaint, this.rectLeftThumb, thumb.equals(this.pressedThumb) ? this.leftThumbPressed : this.leftThumb);
        } else {
            paint.setColor(this.leftThumbColor);
            drawLeftThumbWithColor(canvas, paint, this.rectLeftThumb);
        }
    }

    public void setupRightThumb(Canvas canvas, Paint paint, RectF rectF) {
        Thumb thumb = Thumb.MAX;
        this.rightThumbColor = thumb.equals(this.pressedThumb) ? this.rightThumbColorPressed : this.rightThumbColorNormal;
        this.rectRightThumb.left = normalizedToScreen(this.normalizedMaxValue) - (getThumbWidth() / 2.0f);
        RectF rectF2 = this.rectRightThumb;
        rectF2.right = Math.min(rectF2.left + getThumbWidth(), getWidth());
        RectF rectF3 = this.rectRightThumb;
        rectF3.top = 0.0f;
        rectF3.bottom = this.thumbHeight;
        if (this.rightThumb != null) {
            drawRightThumbWithImage(canvas, this._bmpPaint, this.rectRightThumb, thumb.equals(this.pressedThumb) ? this.rightThumbPressed : this.rightThumb);
        } else {
            paint.setColor(this.rightThumbColor);
            drawRightThumbWithColor(canvas, paint, this.rectRightThumb);
        }
    }

    public void trackTouchEvent(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
            if (Thumb.MIN.equals(this.pressedThumb)) {
                setNormalizedMinValue(screenToNormalized(x));
            } else if (Thumb.MAX.equals(this.pressedThumb)) {
                setNormalizedMaxValue(screenToNormalized(x));
            }
        } catch (Exception unused) {
        }
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeSeekBar setLeftThumbDrawable(Drawable drawable) {
        setLeftThumbBitmap(getBitmap(drawable));
        return this;
    }

    public RangeSeekBar setLeftThumbHighlightDrawable(Drawable drawable) {
        setLeftThumbHighlightBitmap(getBitmap(drawable));
        return this;
    }

    public RangeSeekBar setRightThumbDrawable(Drawable drawable) {
        setRightThumbBitmap(getBitmap(drawable));
        return this;
    }

    public RangeSeekBar setRightThumbHighlightDrawable(Drawable drawable) {
        setRightThumbHighlightBitmap(getBitmap(drawable));
        return this;
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NO_STEP = -1.0f;
        this.NO_FIXED_GAP = -1.0f;
        this.fixGap = -1.0f;
        this.mActivePointerId = 255;
        this.normalizedMinValue = 0.0d;
        this.normalizedMaxValue = 100.0d;
        if (isInEditMode()) {
            return;
        }
        init();
    }

    private void setMaxStartValue() {
        float f = this.maxStartValue;
        if (f <= this.absoluteMaxValue) {
            float f2 = this.absoluteMinValue;
            if (f <= f2 || f < this.absoluteMinStartValue) {
                return;
            }
            float fMax = Math.max(this.absoluteMaxStartValue, f2);
            float f3 = this.absoluteMinValue;
            float f4 = ((fMax - f3) / (this.absoluteMaxValue - f3)) * 100.0f;
            this.maxStartValue = f4;
            setNormalizedMaxValue(f4);
        }
    }

    private void setMinStartValue() {
        float f = this.minStartValue;
        if (f <= this.minValue || f > this.maxValue) {
            return;
        }
        float fMin = Math.min(f, this.absoluteMaxValue);
        float f2 = this.absoluteMinValue;
        float f3 = ((fMin - f2) / (this.absoluteMaxValue - f2)) * 100.0f;
        this.minStartValue = f3;
        setNormalizedMinValue(f3);
    }

    public void setOnRangeSeekBarChangeListener(a aVar) {
    }

    public void setOnRangeSeekBarFinalValueListener(b bVar) {
    }

    public void touchDown(float f, float f2) {
    }

    public void touchMove(float f, float f2) {
    }

    public void touchUp(float f, float f2) {
    }
}
