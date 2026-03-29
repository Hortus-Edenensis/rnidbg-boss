package com.zenmen.palmchat.widget.picker.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.zenmen.palmchat.framework.R$dimen;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WheelPicker extends View implements Runnable {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SCROLLING = 2;
    private static final String TAG = "WheelPicker";
    private String fontPath;
    private boolean hasAtmospheric;
    private boolean hasCurtain;
    private boolean hasIndicator;
    private boolean hasSameWidth;
    private boolean isClick;
    private boolean isCurved;
    private boolean isCyclic;
    private boolean isDebug;
    private boolean isForceFinishScroll;
    private boolean isTouchTriggered;
    private Camera mCamera;
    private int mCurrentItemPosition;
    private int mCurtainColor;
    private List<? extends PickerData> mData;
    private int mDownPointY;
    private int mDrawnCenterX;
    private int mDrawnCenterY;
    private int mDrawnItemCount;
    private int mFocusHalfItemHeight;
    private int mHalfDrawnItemCount;
    private int mHalfItemHeight;
    private int mHalfWheelHeight;
    private final Handler mHandler;
    private int mIndicatorColor;
    private int mIndicatorSize;
    private int mItemAlign;
    private int mItemHeight;
    private int mItemSpace;
    private int mItemTextColor;
    private int mItemTextSize;
    private int mLastPointY;
    private Matrix mMatrixDepth;
    private Matrix mMatrixRotate;
    private int mMaxFlingY;
    private String mMaxWidthText;
    private int mMaximumVelocity;
    private int mMinFlingY;
    private int mMinimumVelocity;
    private a mOnItemSelectedListener;
    private b mOnWheelChangeListener;
    private Paint mPaint;
    private Rect mRectCurrentItem;
    private Rect mRectDrawn;
    private Rect mRectIndicatorFoot;
    private Rect mRectIndicatorHead;
    private int mScrollOffsetY;
    private Scroller mScroller;
    private int mSelectedItemPosition;
    private int mSelectedItemTextColor;
    private int mSelectedItemTextSize;
    private int mTextMaxHeight;
    private int mTextMaxWidth;
    private int mTextMaxWidthPosition;
    private int mTouchSlop;
    private VelocityTracker mTracker;
    private int mVisibleItemCount;
    private int mWheelCenterX;
    private int mWheelCenterY;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(WheelPicker wheelPicker, PickerData pickerData, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public WheelPicker(Context context) {
        this(context, null);
    }

    private void computeCurrentItemRect() {
        if (this.hasCurtain || this.mSelectedItemTextColor != -1) {
            Rect rect = this.mRectCurrentItem;
            Rect rect2 = this.mRectDrawn;
            int i = rect2.left;
            int i2 = this.mWheelCenterY;
            int i3 = this.mFocusHalfItemHeight;
            rect.set(i, i2 - i3, rect2.right, i2 + i3);
        }
    }

    private int computeDepth(int i) {
        return (int) (((double) this.mHalfWheelHeight) - (Math.cos(Math.toRadians(i)) * ((double) this.mHalfWheelHeight)));
    }

    private int computeDistanceToEndPoint(int i) {
        if (Math.abs(i) > this.mHalfItemHeight) {
            return (this.mScrollOffsetY < 0 ? -this.mItemHeight : this.mItemHeight) - i;
        }
        return -i;
    }

    private void computeDrawnCenter() {
        int i = this.mItemAlign;
        if (i == 1) {
            this.mDrawnCenterX = this.mRectDrawn.left;
        } else if (i != 2) {
            this.mDrawnCenterX = this.mWheelCenterX;
        } else {
            this.mDrawnCenterX = this.mRectDrawn.right;
        }
        this.mDrawnCenterY = (int) (this.mWheelCenterY - ((this.mPaint.ascent() + this.mPaint.descent()) / 2.0f));
    }

    private void computeFlingLimitY() {
        int i = this.mSelectedItemPosition;
        int i2 = this.mItemHeight;
        int i3 = i * i2;
        this.mMinFlingY = this.isCyclic ? Integer.MIN_VALUE : ((-i2) * (this.mData.size() - 1)) + i3;
        if (this.isCyclic) {
            i3 = Integer.MAX_VALUE;
        }
        this.mMaxFlingY = i3;
    }

    private void computeIndicatorRect() {
        if (this.hasIndicator) {
            int i = this.mIndicatorSize / 2;
            int i2 = this.mWheelCenterY;
            int i3 = this.mHalfItemHeight;
            int i4 = i2 + i3;
            int i5 = i2 - i3;
            Rect rect = this.mRectIndicatorHead;
            Rect rect2 = this.mRectDrawn;
            rect.set(rect2.left, i4 - i, rect2.right, i4 + i);
            Rect rect3 = this.mRectIndicatorFoot;
            Rect rect4 = this.mRectDrawn;
            rect3.set(rect4.left, i5 - i, rect4.right, i5 + i);
        }
    }

    private int computeSpace(int i) {
        return (int) (Math.sin(Math.toRadians(i)) * ((double) this.mHalfWheelHeight));
    }

    private void computeTextSize() {
        this.mTextMaxHeight = 0;
        this.mTextMaxWidth = 0;
        if (this.hasSameWidth) {
            this.mTextMaxWidth = (int) this.mPaint.measureText(this.mData.get(0).name);
        } else if (isPosInRang(this.mTextMaxWidthPosition)) {
            this.mTextMaxWidth = (int) this.mPaint.measureText(this.mData.get(this.mTextMaxWidthPosition).name);
        } else if (TextUtils.isEmpty(this.mMaxWidthText)) {
            Iterator<? extends PickerData> it = this.mData.iterator();
            while (it.hasNext()) {
                this.mTextMaxWidth = Math.max(this.mTextMaxWidth, (int) this.mPaint.measureText(String.valueOf(it.next().name)));
            }
        } else {
            this.mTextMaxWidth = (int) this.mPaint.measureText(this.mMaxWidthText);
        }
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        this.mTextMaxHeight = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private boolean isPosInRang(int i) {
        return i >= 0 && i < this.mData.size();
    }

    private int measureSize(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    private void updateItemTextAlign() {
        int i = this.mItemAlign;
        if (i == 1) {
            this.mPaint.setTextAlign(Paint.Align.LEFT);
        } else if (i != 2) {
            this.mPaint.setTextAlign(Paint.Align.CENTER);
        } else {
            this.mPaint.setTextAlign(Paint.Align.RIGHT);
        }
    }

    private void updateVisibleItemCount() {
        int i = this.mVisibleItemCount;
        if (i < 2) {
            throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
        }
        if (i % 2 == 0) {
            this.mVisibleItemCount = i + 1;
        }
        int i2 = this.mVisibleItemCount + 2;
        this.mDrawnItemCount = i2;
        this.mHalfDrawnItemCount = i2 / 2;
    }

    public int getCurrentItemPosition() {
        return this.mCurrentItemPosition;
    }

    public int getCurtainColor() {
        return this.mCurtainColor;
    }

    public List<? extends PickerData> getData() {
        return this.mData;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public int getIndicatorSize() {
        return this.mIndicatorSize;
    }

    public int getItemAlign() {
        return this.mItemAlign;
    }

    public int getItemSpace() {
        return this.mItemSpace;
    }

    public int getItemTextColor() {
        return this.mItemTextColor;
    }

    public int getItemTextSize() {
        return this.mItemTextSize;
    }

    public String getMaximumWidthText() {
        return this.mMaxWidthText;
    }

    public int getMaximumWidthTextPosition() {
        return this.mTextMaxWidthPosition;
    }

    public int getSelectedItemPosition() {
        return this.mSelectedItemPosition;
    }

    public int getSelectedItemTextColor() {
        return this.mSelectedItemTextColor;
    }

    public int getSelectedItemTextSize() {
        return this.mSelectedItemTextSize;
    }

    public Typeface getTypeface() {
        Paint paint = this.mPaint;
        if (paint != null) {
            return paint.getTypeface();
        }
        return null;
    }

    public int getVisibleItemCount() {
        return this.mVisibleItemCount;
    }

    public boolean hasAtmospheric() {
        return this.hasAtmospheric;
    }

    public boolean hasCurtain() {
        return this.hasCurtain;
    }

    public boolean hasIndicator() {
        return this.hasIndicator;
    }

    public boolean hasSameWidth() {
        return this.hasSameWidth;
    }

    public boolean isCurved() {
        return this.isCurved;
    }

    public boolean isCyclic() {
        return this.isCyclic;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String strValueOf;
        int iComputeSpace;
        if (this.mData.size() == 0) {
            return;
        }
        int i = (-this.mScrollOffsetY) / this.mItemHeight;
        int i2 = this.mHalfDrawnItemCount;
        int i3 = i - i2;
        int i4 = this.mSelectedItemPosition + i3;
        int i5 = -i2;
        while (i4 < this.mSelectedItemPosition + i3 + this.mDrawnItemCount) {
            if (this.isCyclic) {
                int size = i4 % this.mData.size();
                if (size < 0) {
                    size += this.mData.size();
                }
                strValueOf = String.valueOf(this.mData.get(size).name);
            } else {
                strValueOf = isPosInRang(i4) ? this.mData.get(i4).name : "";
            }
            this.mPaint.setColor(this.mItemTextColor);
            this.mPaint.setFakeBoldText(false);
            this.mPaint.setStyle(Paint.Style.FILL);
            int i6 = this.mDrawnCenterY;
            int i7 = this.mItemHeight;
            int i8 = (i5 * i7) + i6 + (this.mScrollOffsetY % i7);
            if (this.isCurved) {
                int iAbs = i6 - Math.abs(i6 - i8);
                int i9 = this.mRectDrawn.top;
                int i10 = this.mDrawnCenterY;
                float f = (-(1.0f - (((iAbs - i9) * 1.0f) / (i10 - i9)))) * 90.0f * (i8 > i10 ? 1 : i8 < i10 ? -1 : 0);
                if (f < -90.0f) {
                    f = -90.0f;
                }
                float f2 = f <= 90.0f ? f : 90.0f;
                iComputeSpace = computeSpace((int) f2);
                int i11 = this.mWheelCenterX;
                int i12 = this.mItemAlign;
                if (i12 == 1) {
                    i11 = this.mRectDrawn.left;
                } else if (i12 == 2) {
                    i11 = this.mRectDrawn.right;
                }
                int i13 = this.mWheelCenterY - iComputeSpace;
                this.mCamera.save();
                this.mCamera.rotateX(f2);
                this.mCamera.getMatrix(this.mMatrixRotate);
                this.mCamera.restore();
                float f3 = -i11;
                float f4 = -i13;
                this.mMatrixRotate.preTranslate(f3, f4);
                float f5 = i11;
                float f6 = i13;
                this.mMatrixRotate.postTranslate(f5, f6);
                this.mCamera.save();
                this.mCamera.translate(0.0f, 0.0f, computeDepth(r2));
                this.mCamera.getMatrix(this.mMatrixDepth);
                this.mCamera.restore();
                this.mMatrixDepth.preTranslate(f3, f4);
                this.mMatrixDepth.postTranslate(f5, f6);
                this.mMatrixRotate.postConcat(this.mMatrixDepth);
            } else {
                iComputeSpace = 0;
            }
            if (this.hasAtmospheric) {
                int i14 = this.mDrawnCenterY;
                int iAbs2 = (int) ((((i14 - Math.abs(i14 - i8)) * 1.0f) / this.mDrawnCenterY) * 255.0f);
                this.mPaint.setAlpha(iAbs2 < 0 ? 0 : iAbs2);
            }
            if (this.isCurved) {
                i8 = this.mDrawnCenterY - iComputeSpace;
            }
            if (this.mSelectedItemTextColor != -1) {
                canvas.save();
                if (this.isCurved) {
                    canvas.concat(this.mMatrixRotate);
                }
                canvas.clipRect(this.mRectCurrentItem, Region.Op.DIFFERENCE);
                float f7 = i8;
                canvas.drawText(strValueOf, this.mDrawnCenterX, f7, this.mPaint);
                canvas.restore();
                this.mPaint.setFakeBoldText(true);
                this.mPaint.setColor(this.mSelectedItemTextColor);
                canvas.save();
                if (this.isCurved) {
                    canvas.concat(this.mMatrixRotate);
                }
                canvas.clipRect(this.mRectCurrentItem);
                canvas.drawText(strValueOf, this.mDrawnCenterX, f7, this.mPaint);
                canvas.restore();
            } else {
                canvas.save();
                canvas.clipRect(this.mRectDrawn);
                if (this.isCurved) {
                    canvas.concat(this.mMatrixRotate);
                }
                canvas.drawText(strValueOf, this.mDrawnCenterX, i8, this.mPaint);
                canvas.restore();
            }
            if (this.isDebug) {
                canvas.save();
                canvas.clipRect(this.mRectDrawn);
                this.mPaint.setColor(-1166541);
                int i15 = this.mWheelCenterY + (this.mItemHeight * i5);
                Rect rect = this.mRectDrawn;
                float f8 = i15;
                canvas.drawLine(rect.left, f8, rect.right, f8, this.mPaint);
                this.mPaint.setColor(-13421586);
                this.mPaint.setStyle(Paint.Style.STROKE);
                int i16 = i15 - this.mHalfItemHeight;
                Rect rect2 = this.mRectDrawn;
                canvas.drawRect(rect2.left, i16, rect2.right, i16 + this.mItemHeight, this.mPaint);
                canvas.restore();
            }
            i4++;
            i5++;
        }
        if (this.hasCurtain) {
            this.mPaint.setColor(this.mCurtainColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.mRectCurrentItem, this.mPaint);
        }
        if (this.hasIndicator) {
            this.mPaint.setColor(this.mIndicatorColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.mRectIndicatorHead, this.mPaint);
            canvas.drawRect(this.mRectIndicatorFoot, this.mPaint);
        }
        if (this.isDebug) {
            this.mPaint.setColor(1144254003);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getHeight(), this.mPaint);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getPaddingTop(), this.mPaint);
            canvas.drawRect(getWidth() - getPaddingRight(), 0.0f, getWidth(), getHeight(), this.mPaint);
            canvas.drawRect(0.0f, getHeight() - getPaddingBottom(), getWidth(), getHeight(), this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mTextMaxWidth;
        int i4 = this.mTextMaxHeight;
        int i5 = this.mVisibleItemCount;
        int i6 = (i4 * i5) + (this.mItemSpace * (i5 - 1));
        if (this.isCurved) {
            i6 = (int) (((double) (i6 * 2)) / 3.141592653589793d);
        }
        if (this.isDebug) {
            Log.i(TAG, "Wheel's content size is (" + i3 + ":" + i6 + ")");
        }
        int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = i6 + getPaddingTop() + getPaddingBottom();
        if (this.isDebug) {
            Log.i(TAG, "Wheel's size is (" + paddingLeft + ":" + paddingTop + ")");
        }
        setMeasuredDimension(measureSize(mode, size, paddingLeft), measureSize(mode2, size2, paddingTop));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mRectDrawn.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.isDebug) {
            Log.i(TAG, "Wheel's drawn rect size is (" + this.mRectDrawn.width() + ":" + this.mRectDrawn.height() + ") and location is (" + this.mRectDrawn.left + ":" + this.mRectDrawn.top + ")");
        }
        this.mWheelCenterX = this.mRectDrawn.centerX();
        this.mWheelCenterY = this.mRectDrawn.centerY();
        computeDrawnCenter();
        this.mHalfWheelHeight = this.mRectDrawn.height() / 2;
        int iHeight = this.mRectDrawn.height() / this.mVisibleItemCount;
        this.mItemHeight = iHeight;
        int i5 = iHeight / 2;
        this.mHalfItemHeight = i5;
        if (this.mFocusHalfItemHeight <= 0) {
            this.mFocusHalfItemHeight = i5;
        }
        computeFlingLimitY();
        computeIndicatorRect();
        computeCurrentItemRect();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isTouchTriggered = true;
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker == null) {
                this.mTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.mTracker.addMovement(motionEvent);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                this.isForceFinishScroll = true;
            }
            int y = (int) motionEvent.getY();
            this.mLastPointY = y;
            this.mDownPointY = y;
        } else if (action == 1) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!this.isClick || this.isForceFinishScroll) {
                this.mTracker.addMovement(motionEvent);
                this.mTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.isForceFinishScroll = false;
                int yVelocity = (int) this.mTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                    this.mScroller.fling(0, this.mScrollOffsetY, 0, yVelocity, 0, 0, this.mMinFlingY, this.mMaxFlingY);
                    Scroller scroller = this.mScroller;
                    scroller.setFinalY(scroller.getFinalY() + computeDistanceToEndPoint(this.mScroller.getFinalY() % this.mItemHeight));
                } else {
                    Scroller scroller2 = this.mScroller;
                    int i = this.mScrollOffsetY;
                    scroller2.startScroll(0, i, 0, computeDistanceToEndPoint(i % this.mItemHeight));
                }
                if (!this.isCyclic) {
                    int finalY = this.mScroller.getFinalY();
                    int i2 = this.mMaxFlingY;
                    if (finalY > i2) {
                        this.mScroller.setFinalY(i2);
                    } else {
                        int finalY2 = this.mScroller.getFinalY();
                        int i3 = this.mMinFlingY;
                        if (finalY2 < i3) {
                            this.mScroller.setFinalY(i3);
                        }
                    }
                }
                this.mHandler.post(this);
                VelocityTracker velocityTracker2 = this.mTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.mTracker = null;
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                VelocityTracker velocityTracker3 = this.mTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mTracker = null;
                }
            }
        } else if (Math.abs(this.mDownPointY - motionEvent.getY()) < this.mTouchSlop) {
            this.isClick = true;
        } else {
            this.isClick = false;
            this.mTracker.addMovement(motionEvent);
            float y2 = motionEvent.getY() - this.mLastPointY;
            if (Math.abs(y2) >= 1.0f) {
                this.mScrollOffsetY = (int) (this.mScrollOffsetY + y2);
                this.mLastPointY = (int) motionEvent.getY();
                invalidate();
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends PickerData> list = this.mData;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.mScroller.isFinished() && !this.isForceFinishScroll) {
            int i = this.mItemHeight;
            if (i == 0) {
                return;
            }
            int size = (((-this.mScrollOffsetY) / i) + this.mSelectedItemPosition) % this.mData.size();
            if (size < 0) {
                size += this.mData.size();
            }
            if (this.isDebug) {
                Log.i(TAG, size + ":" + this.mData.get(size).name + ":" + this.mScrollOffsetY);
            }
            this.mCurrentItemPosition = size;
            a aVar = this.mOnItemSelectedListener;
            if (aVar != null && this.isTouchTriggered) {
                aVar.a(this, this.mData.get(size), size);
            }
        }
        if (this.mScroller.computeScrollOffset()) {
            this.mScrollOffsetY = this.mScroller.getCurrY();
            postInvalidate();
            this.mHandler.postDelayed(this, 16L);
        }
    }

    public void setAtmospheric(boolean z) {
        this.hasAtmospheric = z;
        invalidate();
    }

    public void setCurtain(boolean z) {
        this.hasCurtain = z;
        computeCurrentItemRect();
        invalidate();
    }

    public void setCurtainColor(int i) {
        this.mCurtainColor = i;
        invalidate();
    }

    public void setCurved(boolean z) {
        this.isCurved = z;
        requestLayout();
        invalidate();
    }

    public void setCyclic(boolean z) {
        this.isCyclic = z;
        computeFlingLimitY();
        invalidate();
    }

    public void setData(List<? extends PickerData> list) {
        if (list == null) {
            throw new NullPointerException("WheelPicker's data can not be null!");
        }
        this.mData = list;
        if (this.mSelectedItemPosition > list.size() - 1 || this.mCurrentItemPosition > list.size() - 1) {
            int size = list.size() - 1;
            this.mCurrentItemPosition = size;
            this.mSelectedItemPosition = size;
        } else {
            this.mSelectedItemPosition = this.mCurrentItemPosition;
        }
        this.mScrollOffsetY = 0;
        computeTextSize();
        computeFlingLimitY();
        requestLayout();
        invalidate();
    }

    public void setIndicator(boolean z) {
        this.hasIndicator = z;
        computeIndicatorRect();
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        invalidate();
    }

    public void setIndicatorSize(int i) {
        this.mIndicatorSize = i;
        computeIndicatorRect();
        invalidate();
    }

    public void setItemAlign(int i) {
        this.mItemAlign = i;
        updateItemTextAlign();
        computeDrawnCenter();
        invalidate();
    }

    public void setItemSpace(int i) {
        this.mItemSpace = i;
        requestLayout();
        invalidate();
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = i;
        invalidate();
    }

    public void setItemTextSize(int i) {
        this.mItemTextSize = i;
        this.mPaint.setTextSize(i);
        computeTextSize();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthText(String str) {
        if (str == null) {
            throw new NullPointerException("Maximum width text can not be null!");
        }
        this.mMaxWidthText = str;
        computeTextSize();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthTextPosition(int i) {
        if (isPosInRang(i)) {
            this.mTextMaxWidthPosition = i;
            computeTextSize();
            requestLayout();
            invalidate();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.mData.size() + "), but current is " + i);
    }

    public void setOnItemSelectedListener(a aVar) {
        this.mOnItemSelectedListener = aVar;
    }

    public void setSameWidth(boolean z) {
        this.hasSameWidth = z;
        computeTextSize();
        requestLayout();
        invalidate();
    }

    public void setSelectedItemPosition(int i) {
        setSelectedItemPosition(i, true);
    }

    public void setSelectedItemTextColor(int i) {
        this.mSelectedItemTextColor = i;
        computeCurrentItemRect();
        invalidate();
    }

    public void setSelectedItemTextSize(int i) {
        this.mSelectedItemTextSize = i;
        computeCurrentItemRect();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        computeTextSize();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(int i) {
        this.mVisibleItemCount = i;
        updateVisibleItemCount();
        requestLayout();
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.mMinimumVelocity = 50;
        this.mMaximumVelocity = 8000;
        this.mTouchSlop = 8;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WheelPicker);
        typedArrayObtainStyledAttributes.getResourceId(R$styleable.WheelPicker_wheel_data, 0);
        this.mData = new ArrayList();
        int i = R$styleable.WheelPicker_wheel_item_text_size;
        Resources resources = getResources();
        int i2 = R$dimen.WheelItemTextSize;
        this.mItemTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i, resources.getDimensionPixelSize(i2));
        this.mSelectedItemTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_wheel_selected_item_text_size, getResources().getDimensionPixelSize(i2));
        this.mVisibleItemCount = typedArrayObtainStyledAttributes.getInt(R$styleable.WheelPicker_wheel_visible_item_count, 7);
        this.mSelectedItemPosition = typedArrayObtainStyledAttributes.getInt(R$styleable.WheelPicker_wheel_selected_item_position, 0);
        this.hasSameWidth = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_same_width, false);
        this.mTextMaxWidthPosition = typedArrayObtainStyledAttributes.getInt(R$styleable.WheelPicker_wheel_maximum_width_text_position, -1);
        this.mMaxWidthText = typedArrayObtainStyledAttributes.getString(R$styleable.WheelPicker_wheel_maximum_width_text);
        this.mSelectedItemTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheel_selected_item_text_color, -1);
        this.mItemTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheel_item_text_color, -7829368);
        this.mItemSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_wheel_item_space, getResources().getDimensionPixelSize(R$dimen.WheelItemSpace));
        this.isCyclic = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_cyclic, false);
        this.hasIndicator = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_indicator, false);
        this.mIndicatorColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheel_indicator_color, -1166541);
        this.mIndicatorSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_wheel_indicator_size, getResources().getDimensionPixelSize(R$dimen.WheelIndicatorSize));
        this.hasCurtain = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_curtain, false);
        this.mCurtainColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheel_curtain_color, -1996488705);
        this.hasAtmospheric = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_atmospheric, false);
        this.isCurved = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheel_curved, false);
        this.mItemAlign = typedArrayObtainStyledAttributes.getInt(R$styleable.WheelPicker_wheel_item_align, 0);
        this.fontPath = typedArrayObtainStyledAttributes.getString(R$styleable.WheelPicker_wheel_font_path);
        this.mFocusHalfItemHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_wheel_focus_item_half_height, 0);
        typedArrayObtainStyledAttributes.recycle();
        updateVisibleItemCount();
        Paint paint = new Paint(69);
        this.mPaint = paint;
        paint.setTextSize(this.mItemTextSize);
        if (this.fontPath != null) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), this.fontPath));
        }
        updateItemTextAlign();
        computeTextSize();
        this.mScroller = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mRectDrawn = new Rect();
        this.mRectIndicatorHead = new Rect();
        this.mRectIndicatorFoot = new Rect();
        this.mRectCurrentItem = new Rect();
        this.mCamera = new Camera();
        this.mMatrixRotate = new Matrix();
        this.mMatrixDepth = new Matrix();
    }

    public void setSelectedItemPosition(int i, boolean z) {
        this.isTouchTriggered = false;
        if (!z || !this.mScroller.isFinished()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            int iMax = Math.max(Math.min(i, this.mData.size() - 1), 0);
            this.mSelectedItemPosition = iMax;
            this.mCurrentItemPosition = iMax;
            this.mScrollOffsetY = 0;
            computeFlingLimitY();
            requestLayout();
            invalidate();
            return;
        }
        int size = getData().size();
        int i2 = i - this.mCurrentItemPosition;
        if (i2 == 0) {
            return;
        }
        if (this.isCyclic && Math.abs(i2) > size / 2) {
            if (i2 > 0) {
                size = -size;
            }
            i2 += size;
        }
        Scroller scroller = this.mScroller;
        scroller.startScroll(0, scroller.getCurrY(), 0, (-i2) * this.mItemHeight);
        this.mHandler.post(this);
    }

    public void setOnWheelChangeListener(b bVar) {
    }
}
