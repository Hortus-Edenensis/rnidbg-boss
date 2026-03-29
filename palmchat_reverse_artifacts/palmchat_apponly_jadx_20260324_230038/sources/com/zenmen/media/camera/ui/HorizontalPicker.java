package com.zenmen.media.camera.ui;

import android.R;
import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.zenmen.palmchat.AppContext;
import defpackage.a46;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HorizontalPicker extends View {
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 4;
    public static final String TAG = "HorizontalTimePicker";
    private OverScroller adjustScrollerX;
    private BoringLayout.Metrics boringMetrics;
    private float dividerSize;
    private Map<Integer, Boolean> dotInfo;
    private int dotLeft;
    private Paint dotPaint;
    private int dotRadius;
    private TextUtils.TruncateAt ellipsize;
    private OverScroller flingScrollerX;
    private RectF itemClipBounds;
    private RectF itemClipBoundsOffset;
    private int itemWidth;
    private float lastDownEventX;
    private BoringLayout[] layouts;
    private EdgeEffect leftEdgeEffect;
    private int mMinimumFlingVelocity;
    private VelocityTracker mVelocityTracker;
    private Marquee marquee;
    private int marqueeRepeatLimit;
    private int maximumFlingVelocity;
    private OnItemClicked onItemClicked;
    private OnItemSelected onItemSelected;
    private final int overscrollDistance;
    private int pressedItem;
    private int previousScrollerX;
    private EdgeEffect rightEdgeEffect;
    private boolean scrollingX;
    private int selectedItem;
    private int sideItems;
    private ColorStateList textColor;
    private TextDirectionHeuristicCompat textDir;
    private TextPaint textPaint;
    private int touchSlop;
    private CharSequence[] values;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Marquee extends Handler {
        private static final int MARQUEE_DELAY = 1200;
        private static final float MARQUEE_DELTA_MAX = 0.07f;
        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        private static final int MARQUEE_RESOLUTION = 33;
        private static final int MARQUEE_RESTART_DELAY = 1200;
        private static final byte MARQUEE_RUNNING = 2;
        private static final byte MARQUEE_STARTING = 1;
        private static final byte MARQUEE_STOPPED = 0;
        private static final int MESSAGE_RESTART = 3;
        private static final int MESSAGE_START = 1;
        private static final int MESSAGE_TICK = 2;
        private float mFadeStop;
        private float mGhostOffset;
        private float mGhostStart;
        private final WeakReference<Layout> mLayout;
        private float mMaxFadeScroll;
        private float mMaxScroll;
        private int mRepeatLimit;
        private boolean mRtl;
        private float mScroll;
        private final float mScrollUnit;
        private byte mStatus = 0;
        private final WeakReference<HorizontalPicker> mView;

        public Marquee(HorizontalPicker horizontalPicker, Layout layout, boolean z) {
            float f = (horizontalPicker.getContext().getResources().getDisplayMetrics().density * 30.0f) / 33.0f;
            if (z) {
                this.mScrollUnit = -f;
            } else {
                this.mScrollUnit = f;
            }
            this.mView = new WeakReference<>(horizontalPicker);
            this.mLayout = new WeakReference<>(layout);
            this.mRtl = z;
        }

        private void resetScroll() {
            this.mScroll = 0.0f;
            HorizontalPicker horizontalPicker = this.mView.get();
            if (horizontalPicker != null) {
                horizontalPicker.invalidate();
            }
        }

        public float getGhostOffset() {
            return this.mGhostOffset;
        }

        public float getMaxFadeScroll() {
            return this.mMaxFadeScroll;
        }

        public float getScroll() {
            return this.mScroll;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.mStatus = (byte) 2;
                tick();
            } else {
                if (i == 2) {
                    tick();
                    return;
                }
                if (i == 3 && this.mStatus == 2) {
                    int i2 = this.mRepeatLimit;
                    if (i2 >= 0) {
                        this.mRepeatLimit = i2 - 1;
                    }
                    start(this.mRepeatLimit);
                }
            }
        }

        public boolean isRunning() {
            return this.mStatus == 2;
        }

        public boolean isStopped() {
            return this.mStatus == 0;
        }

        public boolean shouldDrawGhost() {
            return this.mStatus == 2 && Math.abs(this.mScroll) > this.mGhostStart;
        }

        public boolean shouldDrawLeftFade() {
            return this.mScroll <= this.mFadeStop;
        }

        public void start(int i) {
            if (i == 0) {
                stop();
                return;
            }
            this.mRepeatLimit = i;
            HorizontalPicker horizontalPicker = this.mView.get();
            Layout layout = this.mLayout.get();
            if (horizontalPicker == null || layout == null) {
                return;
            }
            this.mStatus = (byte) 1;
            this.mScroll = 0.0f;
            int i2 = horizontalPicker.itemWidth;
            float lineWidth = layout.getLineWidth(0);
            float f = i2;
            float f2 = f / 3.0f;
            float f3 = (lineWidth - f) + f2;
            this.mGhostStart = f3;
            this.mMaxScroll = f3 + f;
            float f4 = f2 + lineWidth;
            this.mGhostOffset = f4;
            this.mFadeStop = (f / 6.0f) + lineWidth;
            this.mMaxFadeScroll = f3 + lineWidth + lineWidth;
            if (this.mRtl) {
                this.mGhostOffset = f4 * (-1.0f);
            }
            horizontalPicker.invalidate();
            sendEmptyMessageDelayed(1, 1200L);
        }

        public void stop() {
            this.mStatus = (byte) 0;
            removeMessages(1);
            removeMessages(3);
            removeMessages(2);
            resetScroll();
        }

        public void tick() {
            if (this.mStatus != 2) {
                return;
            }
            removeMessages(2);
            HorizontalPicker horizontalPicker = this.mView.get();
            Layout layout = this.mLayout.get();
            if (horizontalPicker == null || layout == null) {
                return;
            }
            if (horizontalPicker.isFocused() || horizontalPicker.isSelected()) {
                float f = this.mScroll + this.mScrollUnit;
                this.mScroll = f;
                float fAbs = Math.abs(f);
                float f2 = this.mMaxScroll;
                if (fAbs > f2) {
                    this.mScroll = f2;
                    if (this.mRtl) {
                        this.mScroll = f2 * (-1.0f);
                    }
                    sendEmptyMessageDelayed(3, 1200L);
                } else {
                    sendEmptyMessageDelayed(2, 33L);
                }
                horizontalPicker.invalidate();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnItemClicked {
        void onItemClicked(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnItemSelected {
        void onItemSelected(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PickerTouchHelper extends ExploreByTouchHelper {
        private HorizontalPicker mPicker;

        public PickerTouchHelper(HorizontalPicker horizontalPicker) {
            super(horizontalPicker);
            this.mPicker = horizontalPicker;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            float f3 = this.mPicker.itemWidth + this.mPicker.dividerSize;
            float scrollX = ((this.mPicker.getScrollX() + f) - (this.mPicker.sideItems * f3)) / f3;
            if (scrollX < 0.0f || scrollX > this.mPicker.values.length) {
                return Integer.MIN_VALUE;
            }
            return (int) scrollX;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            float f = this.mPicker.itemWidth + this.mPicker.dividerSize;
            float scrollX = this.mPicker.getScrollX() - (this.mPicker.sideItems * f);
            int i = (int) (scrollX / f);
            int length = (this.mPicker.sideItems * 2) + 1;
            if (scrollX % f != 0.0f) {
                length++;
            }
            if (i < 0) {
                length += i;
                i = 0;
            } else if (i + length > this.mPicker.values.length) {
                length = this.mPicker.values.length - i;
            }
            for (int i2 = 0; i2 < length; i2++) {
                list.add(Integer.valueOf(i + i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(this.mPicker.values[i]);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            float f = this.mPicker.itemWidth + this.mPicker.dividerSize;
            int scrollX = (int) ((i * f) - (this.mPicker.getScrollX() - (this.mPicker.sideItems * f)));
            int i2 = this.mPicker.itemWidth + scrollX;
            accessibilityNodeInfoCompat.setContentDescription(this.mPicker.values[i]);
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(scrollX, 0, i2, this.mPicker.getHeight()));
            accessibilityNodeInfoCompat.addAction(16);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.zenmen.media.camera.ui.HorizontalPicker.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int mSelItem;

        public String toString() {
            return "HorizontalPicker.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selItem=" + this.mSelItem + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSelItem);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSelItem = parcel.readInt();
        }
    }

    public HorizontalPicker(Context context) {
        this(context, null);
    }

    private void adjustToNearestItemX() {
        int scrollX = getScrollX();
        int iRound = Math.round(scrollX / (this.itemWidth + (this.dividerSize * 1.0f)));
        if (iRound < 0) {
            iRound = 0;
        } else {
            CharSequence[] charSequenceArr = this.values;
            if (iRound > charSequenceArr.length) {
                iRound = charSequenceArr.length;
            }
        }
        this.selectedItem = iRound;
        int i = ((this.itemWidth + ((int) this.dividerSize)) * iRound) - scrollX;
        this.previousScrollerX = Integer.MIN_VALUE;
        this.adjustScrollerX.startScroll(scrollX, 0, i, 0, 800);
        invalidate();
    }

    private void calculateItemSize(int i, int i2) {
        int i3 = (this.sideItems * 2) + 1;
        this.itemWidth = (i - (((int) this.dividerSize) * (i3 - 1))) / i3;
        this.itemClipBounds = new RectF(0.0f, 0.0f, this.itemWidth, i2);
        this.itemClipBoundsOffset = new RectF(this.itemClipBounds);
        scrollToItem(this.selectedItem);
        remakeLayout();
        startMarqueeIfNeeded();
    }

    private void computeScrollX() {
        OverScroller overScroller = this.flingScrollerX;
        if (overScroller.isFinished()) {
            overScroller = this.adjustScrollerX;
            if (overScroller.isFinished()) {
                return;
            }
        }
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            if (this.previousScrollerX == Integer.MIN_VALUE) {
                this.previousScrollerX = overScroller.getStartX();
            }
            int scrollRange = getScrollRange();
            int i = this.previousScrollerX;
            if (i >= 0 && currX < 0) {
                this.leftEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
            } else if (i <= scrollRange && currX > scrollRange) {
                this.rightEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
            }
            int i2 = this.previousScrollerX;
            overScrollBy(currX - i2, 0, i2, getScrollY(), getScrollRange(), 0, this.overscrollDistance, 0, false);
            this.previousScrollerX = currX;
            if (overScroller.isFinished()) {
                onScrollerFinishedX(overScroller);
            }
            postInvalidate();
        }
    }

    private void drawEdgeEffect(Canvas canvas, EdgeEffect edgeEffect, int i) {
        if (canvas == null || edgeEffect == null) {
            return;
        }
        if ((i == 90 || i == 270) && !edgeEffect.isFinished()) {
            int saveCount = canvas.getSaveCount();
            int width = getWidth();
            int height = getHeight();
            canvas.rotate(i);
            if (i == 270) {
                canvas.translate(-height, Math.max(0, getScrollX()));
            } else {
                canvas.translate(0.0f, -(Math.max(getScrollRange(), getScaleX()) + width));
            }
            edgeEffect.setSize(height, width);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(saveCount);
        }
    }

    private void finishScrolling() {
        adjustToNearestItemX();
        this.scrollingX = false;
        startMarqueeIfNeeded();
        if (this.onItemSelected != null) {
            post(new Runnable() { // from class: com.zenmen.media.camera.ui.HorizontalPicker.2
                @Override // java.lang.Runnable
                public void run() {
                    OnItemSelected onItemSelected = HorizontalPicker.this.onItemSelected;
                    HorizontalPicker horizontalPicker = HorizontalPicker.this;
                    onItemSelected.onItemSelected(horizontalPicker.getPositionFromCoordinates(horizontalPicker.getScrollX()));
                }
            });
        }
    }

    private void flingX(int i) {
        this.previousScrollerX = Integer.MIN_VALUE;
        this.flingScrollerX.fling(getScrollX(), getScrollY(), -i, 0, 0, ((int) (this.itemWidth + this.dividerSize)) * (this.values.length - 1), 0, 0, getWidth() / 2, 0);
        invalidate();
    }

    private int getColor(int i, int i2) {
        int defaultColor;
        int colorForState;
        float f = (int) (this.itemWidth + this.dividerSize);
        float fAbs = Math.abs((((i * 1.0f) % f) / 2.0f) / (f / 2.0f));
        float f2 = (((double) fAbs) > 0.5d ? fAbs - 0.5f : 0.5f - fAbs) * 2.0f;
        if (this.pressedItem == i2) {
            ColorStateList colorStateList = this.textColor;
            defaultColor = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, colorStateList.getDefaultColor());
            colorForState = this.textColor.getColorForState(new int[]{R.attr.state_pressed, R.attr.state_selected}, defaultColor);
        } else {
            defaultColor = this.textColor.getDefaultColor();
            colorForState = this.textColor.getColorForState(new int[]{R.attr.state_selected}, defaultColor);
        }
        return ((Integer) new ArgbEvaluator().evaluate(f2, Integer.valueOf(colorForState), Integer.valueOf(defaultColor))).intValue();
    }

    private int getInBoundsX(int i) {
        if (i < 0) {
            return 0;
        }
        int i2 = this.itemWidth;
        float f = this.dividerSize;
        CharSequence[] charSequenceArr = this.values;
        if (i <= (((int) f) + i2) * (charSequenceArr.length - 1)) {
            return i;
        }
        return (charSequenceArr.length - 1) * (i2 + ((int) f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPositionFromCoordinates(int i) {
        return Math.round(i / (this.itemWidth + this.dividerSize));
    }

    private int getPositionFromTouch(float f) {
        return getPositionFromCoordinates((int) ((getScrollX() - ((this.itemWidth + this.dividerSize) * (this.sideItems + 0.5f))) + f));
    }

    private int getPositionOnScreen(float f) {
        return (int) (f / (this.itemWidth + this.dividerSize));
    }

    private int getRelativeInBound(int i) {
        int scrollX = getScrollX();
        return getInBoundsX(i + scrollX) - scrollX;
    }

    private int getScrollRange() {
        CharSequence[] charSequenceArr = this.values;
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return 0;
        }
        return Math.max(0, (this.itemWidth + ((int) this.dividerSize)) * (charSequenceArr.length - 1));
    }

    private int getTextColor(int i) {
        int scrollX = getScrollX();
        int defaultColor = this.textColor.getDefaultColor();
        int i2 = (int) (this.itemWidth + this.dividerSize);
        int i3 = i2 / 2;
        return (scrollX <= (i2 * i) - i3 || scrollX >= (i2 * (i + 1)) - i3) ? i == this.pressedItem ? this.textColor.getColorForState(new int[]{R.attr.state_pressed}, defaultColor) : defaultColor : getColor(scrollX - i3, i);
    }

    private TextDirectionHeuristicCompat getTextDirectionHeuristic() {
        boolean z = getLayoutDirection() == 1;
        int textDirection = getTextDirection();
        return textDirection != 2 ? textDirection != 3 ? textDirection != 4 ? textDirection != 5 ? z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR : TextDirectionHeuristicsCompat.LOCALE : TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR : TextDirectionHeuristicsCompat.ANYRTL_LTR;
    }

    private boolean isRtl(CharSequence charSequence) {
        if (this.textDir == null) {
            this.textDir = getTextDirectionHeuristic();
        }
        return this.textDir.isRtl(charSequence, 0, charSequence.length());
    }

    private void onScrollerFinishedX(OverScroller overScroller) {
        if (overScroller == this.flingScrollerX) {
            finishScrolling();
        }
    }

    private void remakeLayout() {
        BoringLayout[] boringLayoutArr = this.layouts;
        if (boringLayoutArr == null || boringLayoutArr.length <= 0 || getWidth() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            BoringLayout[] boringLayoutArr2 = this.layouts;
            if (i >= boringLayoutArr2.length) {
                return;
            }
            BoringLayout boringLayout = boringLayoutArr2[i];
            CharSequence charSequence = this.values[i];
            TextPaint textPaint = this.textPaint;
            int i2 = this.itemWidth;
            boringLayout.replaceOrMake(charSequence, textPaint, i2, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, this.boringMetrics, false, this.ellipsize, i2);
            i++;
        }
    }

    private void scrollToItem(int i) {
        scrollTo((this.itemWidth + ((int) this.dividerSize)) * i, 0);
    }

    private void selectItem() {
        if (this.onItemClicked != null) {
            post(new Runnable() { // from class: com.zenmen.media.camera.ui.HorizontalPicker.1
                @Override // java.lang.Runnable
                public void run() {
                    HorizontalPicker.this.onItemClicked.onItemClicked(HorizontalPicker.this.getSelectedItem());
                }
            });
        }
        adjustToNearestItemX();
    }

    private void setTextSize(float f) {
        if (f != this.textPaint.getTextSize()) {
            this.textPaint.setTextSize(f);
            this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            requestLayout();
            invalidate();
        }
    }

    private void startMarqueeIfNeeded() {
        stopMarqueeIfNeeded();
        int selectedItem = getSelectedItem();
        BoringLayout[] boringLayoutArr = this.layouts;
        if (boringLayoutArr == null || boringLayoutArr.length <= selectedItem) {
            return;
        }
        BoringLayout boringLayout = boringLayoutArr[selectedItem];
        if (this.ellipsize != TextUtils.TruncateAt.MARQUEE || this.itemWidth >= boringLayout.getLineWidth(0)) {
            return;
        }
        Marquee marquee = new Marquee(this, boringLayout, isRtl(this.values[selectedItem]));
        this.marquee = marquee;
        marquee.start(this.marqueeRepeatLimit);
    }

    private void stopMarqueeIfNeeded() {
        Marquee marquee = this.marquee;
        if (marquee != null) {
            marquee.stop();
            this.marquee = null;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        computeScrollX();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
    }

    public int getMarqueeRepeatLimit() {
        return this.marqueeRepeatLimit;
    }

    public int getSelectedItem() {
        return getPositionFromCoordinates(getScrollX());
    }

    public int getSideItems() {
        return this.sideItems;
    }

    public CharSequence[] getValues() {
        return this.values;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        super.onDraw(canvas);
        if (this.dotPaint == null) {
            Paint paint = new Paint();
            this.dotPaint = paint;
            paint.setAntiAlias(true);
            this.dotPaint.setColor(Color.parseColor("#FF463C"));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int i = this.selectedItem;
        float f = this.itemWidth + this.dividerSize;
        canvas.translate(this.sideItems * f, 0.0f);
        if (this.values != null) {
            for (int i2 = 0; i2 < this.values.length; i2++) {
                this.textPaint.setColor(getTextColor(i2));
                BoringLayout boringLayout = this.layouts[i2];
                int saveCount2 = canvas.getSaveCount();
                canvas.save();
                float lineWidth = boringLayout.getLineWidth(0);
                float scroll = lineWidth > ((float) this.itemWidth) ? isRtl(this.values[i2]) ? ((lineWidth - this.itemWidth) / 2.0f) + 0.0f : 0.0f - ((lineWidth - this.itemWidth) / 2.0f) : 0.0f;
                Marquee marquee = this.marquee;
                if (marquee != null && i2 == i) {
                    scroll += marquee.getScroll();
                }
                canvas.translate(-scroll, (canvas.getHeight() - boringLayout.getHeight()) / 2);
                if (scroll == 0.0f) {
                    rectF = this.itemClipBounds;
                } else {
                    RectF rectF2 = this.itemClipBoundsOffset;
                    rectF2.set(this.itemClipBounds);
                    rectF2.offset(scroll, 0.0f);
                    rectF = rectF2;
                }
                canvas.clipRect(rectF);
                boringLayout.draw(canvas);
                Marquee marquee2 = this.marquee;
                if (marquee2 != null && i2 == i && marquee2.shouldDrawGhost()) {
                    canvas.translate(this.marquee.getGhostOffset(), 0.0f);
                    boringLayout.draw(canvas);
                }
                canvas.restoreToCount(saveCount2);
                canvas.translate(f, 0.0f);
                if (this.dotInfo.containsKey(Integer.valueOf(i2)) && this.dotInfo.get(Integer.valueOf(i2)).booleanValue()) {
                    float f2 = -this.dotLeft;
                    int i3 = this.dotRadius;
                    canvas.drawCircle(f2, i3, i3, this.dotPaint);
                }
            }
        }
        canvas.restoreToCount(saveCount);
        drawEdgeEffect(canvas, this.leftEdgeEffect, 270);
        drawEdgeEffect(canvas, this.rightEdgeEffect, 90);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (i != 66) {
            switch (i) {
                case 21:
                    smoothScrollBy(-1);
                    break;
                case 22:
                    smoothScrollBy(1);
                    break;
            }
            return super.onKeyDown(i, keyEvent);
        }
        selectItem();
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            int iAbs = ((int) (Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent))) + getPaddingTop() + getPaddingBottom();
            size2 = mode == Integer.MIN_VALUE ? Math.min(size2, iAbs) : iAbs;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
        if (this.flingScrollerX.isFinished() || !z) {
            return;
        }
        this.flingScrollerX.springBack(i, i2, 0, getScrollRange(), 0, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setSelectedItem(savedState.mSelItem);
    }

    @Override // android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        this.textDir = getTextDirectionHeuristic();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mSelItem = this.selectedItem;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        calculateItemSize(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CharSequence[] charSequenceArr;
        int i = 0;
        if (!isEnabled()) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.maximumFlingVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (this.scrollingX && Math.abs(xVelocity) > this.mMinimumFlingVelocity) {
                    flingX(xVelocity);
                } else if (this.values != null) {
                    float x = motionEvent.getX();
                    boolean z = this.scrollingX;
                    if (!z) {
                        int positionOnScreen = getPositionOnScreen(x) - this.sideItems;
                        if (positionOnScreen == 0) {
                            selectItem();
                        } else {
                            smoothScrollBy(positionOnScreen);
                        }
                    } else if (z) {
                        finishScrolling();
                    }
                }
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                EdgeEffect edgeEffect = this.leftEdgeEffect;
                if (edgeEffect != null) {
                    edgeEffect.onRelease();
                    this.rightEdgeEffect.onRelease();
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                int i2 = (int) (this.lastDownEventX - x2);
                if (this.scrollingX || (Math.abs(i2) > this.touchSlop && (charSequenceArr = this.values) != null && charSequenceArr.length > 0)) {
                    if (this.scrollingX) {
                        i = i2;
                    } else {
                        this.pressedItem = -1;
                        this.scrollingX = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        stopMarqueeIfNeeded();
                    }
                    int scrollRange = getScrollRange();
                    if (overScrollBy(i, 0, getScrollX(), 0, scrollRange, 0, this.overscrollDistance, 0, true)) {
                        this.mVelocityTracker.clear();
                    }
                    float scrollX = getScrollX() + i;
                    if (scrollX < 0.0f) {
                        this.leftEdgeEffect.onPull(i / getWidth());
                        if (!this.rightEdgeEffect.isFinished()) {
                            this.rightEdgeEffect.onRelease();
                        }
                    } else if (scrollX > scrollRange) {
                        this.rightEdgeEffect.onPull(i / getWidth());
                        if (!this.leftEdgeEffect.isFinished()) {
                            this.leftEdgeEffect.onRelease();
                        }
                    }
                    this.lastDownEventX = x2;
                    invalidate();
                }
            } else if (actionMasked == 3) {
            }
            this.pressedItem = -1;
            invalidate();
            EdgeEffect edgeEffect2 = this.leftEdgeEffect;
            if (edgeEffect2 != null) {
                edgeEffect2.onRelease();
                this.rightEdgeEffect.onRelease();
            }
        } else {
            if (!this.adjustScrollerX.isFinished()) {
                this.adjustScrollerX.forceFinished(true);
            } else if (this.flingScrollerX.isFinished()) {
                this.scrollingX = false;
            } else {
                this.flingScrollerX.forceFinished(true);
            }
            this.lastDownEventX = motionEvent.getX();
            if (!this.scrollingX) {
                this.pressedItem = getPositionFromTouch(motionEvent.getX());
            }
            invalidate();
        }
        return true;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.ellipsize != truncateAt) {
            this.ellipsize = truncateAt;
            remakeLayout();
            invalidate();
        }
    }

    public void setItemDot(int i, boolean z) {
        this.dotInfo.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public void setMarqueeRepeatLimit(int i) {
        this.marqueeRepeatLimit = i;
    }

    public void setOnItemClickedListener(OnItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    public void setOnItemSelectedListener(OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (i != 2) {
            Context context = getContext();
            this.leftEdgeEffect = new EdgeEffect(context);
            this.rightEdgeEffect = new EdgeEffect(context);
        } else {
            this.leftEdgeEffect = null;
            this.rightEdgeEffect = null;
        }
        super.setOverScrollMode(i);
    }

    public void setSelectedItem(int i) {
        this.selectedItem = i;
        scrollToItem(i);
    }

    public void setSideItems(int i) {
        int i2 = this.sideItems;
        if (i2 < 0) {
            throw new IllegalArgumentException("Number of items on each side must be grater or equal to 0.");
        }
        if (i2 != i) {
            this.sideItems = i;
            calculateItemSize(getWidth(), getHeight());
        }
    }

    public void setValues(CharSequence[] charSequenceArr) {
        if (this.values != charSequenceArr) {
            this.values = charSequenceArr;
            int i = 0;
            if (charSequenceArr != null) {
                this.layouts = new BoringLayout[charSequenceArr.length];
                while (true) {
                    BoringLayout[] boringLayoutArr = this.layouts;
                    if (i >= boringLayoutArr.length) {
                        break;
                    }
                    CharSequence charSequence = this.values[i];
                    TextPaint textPaint = this.textPaint;
                    int i2 = this.itemWidth;
                    boringLayoutArr[i] = new BoringLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, this.boringMetrics, false, this.ellipsize, i2);
                    i++;
                }
            } else {
                this.layouts = new BoringLayout[0];
            }
            if (getWidth() > 0) {
                startMarqueeIfNeeded();
            }
            requestLayout();
            invalidate();
        }
    }

    public void smoothScrollBy(int i) {
        int relativeInBound = getRelativeInBound((this.itemWidth + ((int) this.dividerSize)) * i);
        this.previousScrollerX = Integer.MIN_VALUE;
        this.flingScrollerX.startScroll(getScrollX(), 0, relativeInBound, 0);
        stopMarqueeIfNeeded();
        invalidate();
    }

    public HorizontalPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.zenmen.palmchat.R.attr.horizontalPickerStyle);
    }

    public HorizontalPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pressedItem = -1;
        this.marqueeRepeatLimit = 3;
        this.dividerSize = 0.0f;
        this.sideItems = 1;
        this.dotInfo = new HashMap();
        this.dotPaint = null;
        this.dotRadius = a46.b(AppContext.getContext(), 4.0f);
        this.dotLeft = a46.b(AppContext.getContext(), 8.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        this.textPaint = textPaint;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.zenmen.palmchat.R.styleable.HorizontalPicker, i, 0);
        int i2 = this.sideItems;
        try {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(1);
            this.textColor = colorStateList;
            if (colorStateList == null) {
                this.textColor = ColorStateList.valueOf(-16777216);
            }
            CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(6);
            int i3 = typedArrayObtainStyledAttributes.getInt(2, 3);
            this.marqueeRepeatLimit = typedArrayObtainStyledAttributes.getInt(3, this.marqueeRepeatLimit);
            this.dividerSize = typedArrayObtainStyledAttributes.getDimension(4, this.dividerSize);
            int i4 = typedArrayObtainStyledAttributes.getInt(5, i2);
            float dimension = typedArrayObtainStyledAttributes.getDimension(0, -1.0f);
            if (dimension > -1.0f) {
                setTextSize(dimension);
            }
            if (i3 == 1) {
                setEllipsize(TextUtils.TruncateAt.START);
            } else if (i3 == 2) {
                setEllipsize(TextUtils.TruncateAt.MIDDLE);
            } else if (i3 == 3) {
                setEllipsize(TextUtils.TruncateAt.END);
            } else if (i3 == 4) {
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
            }
            Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
            BoringLayout.Metrics metrics = new BoringLayout.Metrics();
            this.boringMetrics = metrics;
            metrics.ascent = fontMetricsInt.ascent;
            metrics.bottom = fontMetricsInt.bottom;
            metrics.descent = fontMetricsInt.descent;
            metrics.leading = fontMetricsInt.leading;
            metrics.top = fontMetricsInt.top;
            metrics.width = this.itemWidth;
            setWillNotDraw(false);
            this.flingScrollerX = new OverScroller(context);
            this.adjustScrollerX = new OverScroller(context, new DecelerateInterpolator(2.5f));
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.touchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.maximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 4;
            this.overscrollDistance = viewConfiguration.getScaledOverscrollDistance();
            this.previousScrollerX = Integer.MIN_VALUE;
            setValues(textArray);
            setSideItems(i4);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
