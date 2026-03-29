package com.zenmen.media.crop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.zenmen.palmchat.R;
import defpackage.wv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RangeBar extends View {
    private static final int DEFAULT_BAR_COLOR = -65536;
    private static final float DEFAULT_BAR_WEIGHT_PX = 2.0f;
    private static final int DEFAULT_CONNECTING_LINE_COLOR = -13388315;
    private static final float DEFAULT_CONNECTING_LINE_WEIGHT_PX = 4.0f;
    private static final int DEFAULT_THUMB_COLOR_NORMAL = -1;
    private static final int DEFAULT_THUMB_COLOR_PRESSED = -1;
    private static final int DEFAULT_THUMB_IMAGE_NORMAL = 2131231319;
    private static final int DEFAULT_THUMB_IMAGE_PRESSED = 2131231319;
    private static final float DEFAULT_THUMB_RADIUS_DP = -1.0f;
    private static final int DEFAULT_TICK_COUNT = 10;
    private static final float DEFAULT_TICK_HEIGHT_DP = 24.0f;
    private static final String TAG = "RangeBar";
    private Bar mBar;
    private int mBarColor;
    private float mBarWeight;
    private ConnectingLine mConnectingLine;
    private int mConnectingLineColor;
    private float mConnectingLineWeight;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private boolean mFirstSetTickCount;
    private int mFullDuration;
    private int mLeftIndex;
    private Thumb mLeftThumb;
    private OnRangeBarChangeListener mListener;
    private int mRightIndex;
    private Thumb mRightThumb;
    private int mThumbColorNormal;
    private int mThumbColorPressed;
    private int mThumbImageNormal;
    private int mThumbImagePressed;
    private float mThumbRadiusDP;
    private int mTickCount;
    private float mTickHeightDP;
    private Paint outPaint;
    private boolean outRectVisible;
    private Paint shadowPaint;
    private Paint shadowPaintRect;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnRangeBarChangeListener {
        void onIndexChangeListener(RangeBar rangeBar, int i, int i2);

        void onIndexFixedListener(RangeBar rangeBar, int i, int i2);
    }

    public RangeBar(Context context) {
        this(context, null);
    }

    private void createBar() {
        this.mBar = new Bar(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.mTickCount, this.mTickHeightDP, this.mBarWeight, this.mBarColor);
        invalidate();
    }

    private void createConnectingLine() {
        this.mConnectingLine = new ConnectingLine(getContext(), getYPos(), this.mConnectingLineWeight, this.mConnectingLineColor);
        invalidate();
    }

    private void createThumbs() {
        Context context = getContext();
        getYPos();
        this.mLeftThumb = new Thumb(context, getMeasuredHeight() / 2.0f, this.mThumbColorNormal, this.mThumbColorPressed, this.mThumbRadiusDP, this.mThumbImageNormal, this.mThumbImagePressed);
        this.mRightThumb = new Thumb(context, getMeasuredHeight() / 2.0f, this.mThumbColorNormal, this.mThumbColorPressed, this.mThumbRadiusDP, this.mThumbImageNormal, this.mThumbImagePressed);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        this.mLeftThumb.setX(((this.mLeftIndex / (this.mTickCount - 1)) * barLength) + marginLeft);
        this.mRightThumb.setX(marginLeft + ((this.mRightIndex / (this.mTickCount - 1)) * barLength));
        invalidate();
    }

    private float getBarLength() {
        return getWidth() - (getMarginLeft() * 2.0f);
    }

    private float getMarginLeft() {
        Thumb thumb = this.mLeftThumb;
        if (thumb != null) {
            return thumb.getHalfWidth();
        }
        return 0.0f;
    }

    private float getYPos() {
        return getHeight() / 2.0f;
    }

    private boolean indexOutOfRange(int i, int i2) {
        int i3;
        return i < 0 || i >= (i3 = this.mTickCount) || i2 < 0 || i2 >= i3;
    }

    private boolean isValidTickCount(int i) {
        return i > 1;
    }

    private void moveThumb(Thumb thumb, float f, boolean z) {
        if (z) {
            if (f < this.mBar.getLeftX() || f > this.mBar.getRightX() || thumb.getX() + (getMeasuredWidth() / this.mTickCount) >= this.mRightThumb.getX()) {
                return;
            }
            if ((getMeasuredWidth() / this.mFullDuration) + f > this.mRightThumb.getX()) {
                thumb.setX(this.mRightThumb.getX() - (getMeasuredWidth() / this.mFullDuration));
            } else {
                thumb.setX(f);
            }
            invalidate();
            return;
        }
        if (f < this.mBar.getLeftX() || f > this.mBar.getRightX() || thumb.getX() - (getMeasuredWidth() / this.mTickCount) <= this.mLeftThumb.getX()) {
            return;
        }
        if (f - (getMeasuredWidth() / this.mFullDuration) < this.mLeftThumb.getX()) {
            thumb.setX(this.mLeftThumb.getX() + (getMeasuredWidth() / this.mFullDuration));
        } else {
            thumb.setX(f);
        }
        invalidate();
    }

    private void onActionDown(float f, float f2) {
        if (!this.mLeftThumb.isPressed() && this.mLeftThumb.isInTargetZone(f, f2)) {
            pressThumb(this.mLeftThumb);
        } else {
            if (this.mLeftThumb.isPressed() || !this.mRightThumb.isInTargetZone(f, f2)) {
                return;
            }
            pressThumb(this.mRightThumb);
        }
    }

    private void onActionMove(float f) {
        if (this.mLeftThumb.isPressed()) {
            moveThumb(this.mLeftThumb, f, true);
        } else if (this.mRightThumb.isPressed()) {
            moveThumb(this.mRightThumb, f, false);
        }
        if (this.mLeftThumb.getX() > this.mRightThumb.getX()) {
            Thumb thumb = this.mLeftThumb;
            this.mLeftThumb = this.mRightThumb;
            this.mRightThumb = thumb;
        }
        int nearestTickIndex = this.mBar.getNearestTickIndex(this.mLeftThumb);
        int nearestTickIndex2 = this.mBar.getNearestTickIndex(this.mRightThumb);
        if (nearestTickIndex == this.mLeftIndex && nearestTickIndex2 == this.mRightIndex) {
            return;
        }
        this.mLeftIndex = nearestTickIndex;
        this.mRightIndex = nearestTickIndex2;
        OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
        if (onRangeBarChangeListener != null) {
            onRangeBarChangeListener.onIndexChangeListener(this, nearestTickIndex, nearestTickIndex2);
        }
    }

    private void onActionUp() {
        OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
        if (onRangeBarChangeListener != null) {
            onRangeBarChangeListener.onIndexFixedListener(this, this.mLeftIndex, this.mRightIndex);
        }
        if (this.mLeftThumb.isPressed()) {
            releaseThumb(this.mLeftThumb);
        } else if (this.mRightThumb.isPressed()) {
            releaseThumb(this.mRightThumb);
        }
    }

    private void pressThumb(Thumb thumb) {
        if (this.mFirstSetTickCount) {
            this.mFirstSetTickCount = false;
        }
        thumb.press();
        invalidate();
    }

    private void rangeBarInit(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RangeBar, 0, 0);
        try {
            Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(9, 10));
            if (isValidTickCount(numValueOf.intValue())) {
                int iIntValue = numValueOf.intValue();
                this.mTickCount = iIntValue;
                this.mLeftIndex = 0;
                int i = iIntValue - 1;
                this.mRightIndex = i;
                OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
                if (onRangeBarChangeListener != null) {
                    onRangeBarChangeListener.onIndexChangeListener(this, 0, i);
                }
            } else {
                Log.e(TAG, "tickCount less than 2; invalid tickCount. XML input ignored.");
            }
            this.mTickHeightDP = typedArrayObtainStyledAttributes.getDimension(10, DEFAULT_TICK_HEIGHT_DP);
            this.mBarWeight = typedArrayObtainStyledAttributes.getDimension(1, 2.0f);
            this.mBarColor = typedArrayObtainStyledAttributes.getColor(0, -65536);
            this.mConnectingLineWeight = typedArrayObtainStyledAttributes.getDimension(3, 4.0f);
            this.mConnectingLineColor = typedArrayObtainStyledAttributes.getColor(2, DEFAULT_CONNECTING_LINE_COLOR);
            this.mThumbRadiusDP = typedArrayObtainStyledAttributes.getDimension(8, -1.0f);
            this.mThumbImageNormal = typedArrayObtainStyledAttributes.getResourceId(6, R.drawable.crop_handle_left);
            this.mThumbImagePressed = typedArrayObtainStyledAttributes.getResourceId(7, R.drawable.crop_handle_left);
            this.mThumbColorNormal = typedArrayObtainStyledAttributes.getColor(4, -1);
            this.mThumbColorPressed = typedArrayObtainStyledAttributes.getColor(5, -1);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.outPaint = paint;
            paint.setAntiAlias(true);
            this.outPaint.setStrokeJoin(Paint.Join.MITER);
            this.outPaint.setStrokeWidth(20.0f);
            this.outPaint.setARGB(255, 255, 255, 255);
            this.outPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.outPaint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.shadowPaint = paint2;
            paint2.setARGB(100, 0, 0, 0);
            this.shadowPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.shadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            Paint paint3 = new Paint();
            this.shadowPaintRect = paint3;
            paint3.setAntiAlias(true);
            this.shadowPaintRect.setStrokeJoin(Paint.Join.MITER);
            this.shadowPaintRect.setStrokeWidth(20.0f);
            this.shadowPaintRect.setARGB(100, 255, 255, 255);
            this.shadowPaintRect.setStrokeCap(Paint.Cap.SQUARE);
            this.shadowPaintRect.setStyle(Paint.Style.STROKE);
            setTickCount(300);
            setmTickCount(300);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void releaseThumb(Thumb thumb) {
        thumb.setX(this.mBar.getNearestTickCoordinate(thumb));
        thumb.release();
        invalidate();
    }

    private boolean shouldMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        if (this.mLeftThumb.getX() + (this.mLeftThumb.getHalfWidth() * 2.0f) <= x || x <= this.mLeftThumb.getX() - this.mLeftThumb.getHalfWidth()) {
            return this.mRightThumb.getX() - this.mRightThumb.getHalfWidth() < x && this.mRightThumb.getX() + (this.mRightThumb.getHalfWidth() * 2.0f) > x;
        }
        return true;
    }

    public int getLeftIndex() {
        return this.mLeftIndex;
    }

    public float getLeftThumbStartX() {
        return this.mLeftThumb.getmX() - this.mLeftThumb.getHalfWidth();
    }

    public int getRightIndex() {
        return this.mRightIndex;
    }

    public float getRightThumbEndX() {
        return this.mRightThumb.getmX() + this.mRightThumb.getHalfWidth();
    }

    public int getmTickCount() {
        return this.mTickCount;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.mLeftThumb.getX(), 0.0f, this.mRightThumb.getX(), getMeasuredHeight(), this.outPaint);
        canvas.drawRect(0.0f, 0.0f, this.mLeftThumb.getX() - this.mLeftThumb.getHalfWidth(), getMeasuredHeight(), this.shadowPaint);
        canvas.drawRect(this.mRightThumb.getX(), 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.shadowPaint);
        if (this.outRectVisible) {
            canvas.drawRect(0.0f, 0.0f, this.mLeftThumb.getX(), getMeasuredHeight(), this.shadowPaintRect);
            canvas.drawRect(this.mRightThumb.getX(), 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.shadowPaintRect);
        }
        this.mLeftThumb.draw(canvas);
        this.mRightThumb.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            size = this.mDefaultWidth;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.mDefaultHeight, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.mDefaultHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.mTickCount = bundle.getInt("TICK_COUNT");
        this.mTickHeightDP = bundle.getFloat("TICK_HEIGHT_DP");
        this.mBarWeight = bundle.getFloat("BAR_WEIGHT");
        this.mBarColor = bundle.getInt("BAR_COLOR");
        this.mConnectingLineWeight = bundle.getFloat("CONNECTING_LINE_WEIGHT");
        this.mConnectingLineColor = bundle.getInt("CONNECTING_LINE_COLOR");
        this.mThumbImageNormal = bundle.getInt("THUMB_IMAGE_NORMAL");
        this.mThumbImagePressed = bundle.getInt("THUMB_IMAGE_PRESSED");
        this.mThumbRadiusDP = bundle.getFloat("THUMB_RADIUS_DP");
        this.mThumbColorNormal = bundle.getInt("THUMB_COLOR_NORMAL");
        this.mThumbColorPressed = bundle.getInt("THUMB_COLOR_PRESSED");
        this.mLeftIndex = bundle.getInt("LEFT_INDEX");
        this.mRightIndex = bundle.getInt("RIGHT_INDEX");
        this.mFirstSetTickCount = bundle.getBoolean("FIRST_SET_TICK_COUNT");
        setThumbIndices(this.mLeftIndex, this.mRightIndex);
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.mTickCount);
        bundle.putFloat("TICK_HEIGHT_DP", this.mTickHeightDP);
        bundle.putFloat("BAR_WEIGHT", this.mBarWeight);
        bundle.putInt("BAR_COLOR", this.mBarColor);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.mConnectingLineWeight);
        bundle.putInt("CONNECTING_LINE_COLOR", this.mConnectingLineColor);
        bundle.putInt("THUMB_IMAGE_NORMAL", this.mThumbImageNormal);
        bundle.putInt("THUMB_IMAGE_PRESSED", this.mThumbImagePressed);
        bundle.putFloat("THUMB_RADIUS_DP", this.mThumbRadiusDP);
        bundle.putInt("THUMB_COLOR_NORMAL", this.mThumbColorNormal);
        bundle.putInt("THUMB_COLOR_PRESSED", this.mThumbColorPressed);
        bundle.putInt("LEFT_INDEX", this.mLeftIndex);
        bundle.putInt("RIGHT_INDEX", this.mRightIndex);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.mFirstSetTickCount);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Log.e(TAG, "onSizeChanged");
        super.onSizeChanged(i, i2, i3, i4);
        Context context = getContext();
        float f = i2 / 2.0f;
        this.mLeftThumb = new Thumb(context, f, this.mThumbColorNormal, this.mThumbColorPressed, this.mThumbRadiusDP, this.mThumbImageNormal, this.mThumbImagePressed);
        this.mRightThumb = new Thumb(context, f, this.mThumbColorNormal, this.mThumbColorPressed, this.mThumbRadiusDP, this.mThumbImageNormal, this.mThumbImagePressed);
        float halfWidth = this.mLeftThumb.getHalfWidth();
        float f2 = i - (2.0f * halfWidth);
        this.mBar = new Bar(context, halfWidth, f, f2, this.mTickCount, this.mTickHeightDP, this.mBarWeight, this.mBarColor);
        this.mLeftThumb.setX(((this.mLeftIndex / (this.mTickCount - 1)) * f2) + halfWidth);
        this.mRightThumb.setX(halfWidth + ((this.mRightIndex / (this.mTickCount - 1)) * f2));
        int nearestTickIndex = this.mBar.getNearestTickIndex(this.mLeftThumb);
        int nearestTickIndex2 = this.mBar.getNearestTickIndex(this.mRightThumb);
        if (nearestTickIndex != this.mLeftIndex || nearestTickIndex2 != this.mRightIndex) {
            this.mLeftIndex = nearestTickIndex;
            this.mRightIndex = nearestTickIndex2;
            OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
            if (onRangeBarChangeListener != null) {
                onRangeBarChangeListener.onIndexChangeListener(this, nearestTickIndex, nearestTickIndex2);
            }
        }
        this.mConnectingLine = new ConnectingLine(context, f, this.mConnectingLineWeight, this.mConnectingLineColor);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.outRectVisible = true;
            if (!shouldMove(motionEvent)) {
                return false;
            }
            onActionDown(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                this.outRectVisible = true;
                onActionMove(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        this.outRectVisible = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        onActionUp();
        return true;
    }

    public void setBarColor(int i) {
        this.mBarColor = i;
        createBar();
    }

    public void setBarWeight(float f) {
        this.mBarWeight = f;
        createBar();
    }

    public void setConnectingLineColor(int i) {
        this.mConnectingLineColor = i;
        createConnectingLine();
    }

    public void setConnectingLineWeight(float f) {
        this.mConnectingLineWeight = f;
        createConnectingLine();
    }

    public void setFullDuration(int i) {
        if (i < 1 || i > 300) {
            throw new IllegalArgumentException("illegal video file duration, argument should between 1 and 300");
        }
        if (i < 10) {
            this.mFullDuration = i;
        } else {
            this.mFullDuration = 10;
        }
    }

    public void setOnRangeBarChangeListener(OnRangeBarChangeListener onRangeBarChangeListener) {
        this.mListener = onRangeBarChangeListener;
    }

    public void setThumbColorNormal(int i) {
        this.mThumbColorNormal = i;
        createThumbs();
    }

    public void setThumbColorPressed(int i) {
        this.mThumbColorPressed = i;
        createThumbs();
    }

    public void setThumbImageNormal(int i) {
        this.mThumbImageNormal = i;
        createThumbs();
    }

    public void setThumbImagePressed(int i) {
        this.mThumbImagePressed = i;
        createThumbs();
    }

    public void setThumbIndices(int i, int i2) {
        if (indexOutOfRange(i, i2)) {
            Log.e(TAG, "A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
            throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
        }
        if (this.mFirstSetTickCount) {
            this.mFirstSetTickCount = false;
        }
        this.mLeftIndex = i;
        this.mRightIndex = i2;
        createThumbs();
        OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
        if (onRangeBarChangeListener != null) {
            onRangeBarChangeListener.onIndexChangeListener(this, this.mLeftIndex, this.mRightIndex);
            this.mListener.onIndexFixedListener(this, this.mLeftIndex, this.mRightIndex);
        }
        invalidate();
        requestLayout();
    }

    public void setThumbRadius(float f) {
        this.mThumbRadiusDP = f;
        createThumbs();
    }

    public void setTickCount(int i) {
        if (!isValidTickCount(i)) {
            Log.e(TAG, "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.mTickCount = i;
        if (this.mFirstSetTickCount) {
            this.mLeftIndex = 0;
            int i2 = i - 1;
            this.mRightIndex = i2;
            OnRangeBarChangeListener onRangeBarChangeListener = this.mListener;
            if (onRangeBarChangeListener != null) {
                onRangeBarChangeListener.onIndexChangeListener(this, 0, i2);
            }
        }
        if (indexOutOfRange(this.mLeftIndex, this.mRightIndex)) {
            this.mLeftIndex = 0;
            int i3 = this.mTickCount - 1;
            this.mRightIndex = i3;
            OnRangeBarChangeListener onRangeBarChangeListener2 = this.mListener;
            if (onRangeBarChangeListener2 != null) {
                onRangeBarChangeListener2.onIndexChangeListener(this, 0, i3);
            }
        }
        createBar();
        createThumbs();
    }

    public void setTickHeight(float f) {
        this.mTickHeightDP = f;
        createBar();
    }

    public void setmTickCount(int i) {
        this.mTickCount = i;
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTickCount = 10;
        this.mTickHeightDP = DEFAULT_TICK_HEIGHT_DP;
        this.mBarWeight = 2.0f;
        this.mBarColor = -65536;
        this.mConnectingLineWeight = 4.0f;
        this.mConnectingLineColor = DEFAULT_CONNECTING_LINE_COLOR;
        this.mThumbImageNormal = R.drawable.crop_handle_left;
        this.mThumbImagePressed = R.drawable.crop_handle_left;
        this.mThumbRadiusDP = -1.0f;
        this.mThumbColorNormal = -1;
        this.mThumbColorPressed = -1;
        this.mFirstSetTickCount = true;
        this.mDefaultWidth = 500;
        this.mDefaultHeight = 100;
        this.mLeftIndex = 0;
        this.mRightIndex = 10 - 1;
        this.mFullDuration = wv.a();
        this.outRectVisible = false;
        rangeBarInit(context, attributeSet);
    }
}
