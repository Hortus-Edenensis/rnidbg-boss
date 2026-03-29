package com.zenmen.palmchat.conversations.threadsnew.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.media3.common.C;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.no2;
import defpackage.z35;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NRStickyLayout extends LinearLayout implements NestedScrollingParent {
    public static final int SCROLL_DOWN = 2;
    public static final int SCROLL_UP = 1;
    private static final String TAG = "NRStickyLayout";
    private static final int mMaxVelocity = 10000;
    Handler handler;
    private boolean isPreFling;
    private int lastY;
    private int mCurDirection;
    private FrameLayout mFrameLayout;
    private int mMaxScrollY;
    private int mMaxViewPagerHeight;
    private int mMinScrollY;
    private int mScrollY;
    private no2 mScrollable;
    private Scroller mScroller;
    private View mStickyView;
    private int mStickyViewMarginTop;
    private ThreadHeaderViewV5 mTopView;
    private b mTopViewScrollCallback;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (NRStickyLayout.this.lastY == NRStickyLayout.this.mScrollY) {
                return;
            }
            NRStickyLayout.this.handler.sendEmptyMessageDelayed(0, 50L);
            NRStickyLayout nRStickyLayout = NRStickyLayout.this;
            nRStickyLayout.lastY = nRStickyLayout.mScrollY;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public NRStickyLayout(Context context) {
        this(context, null);
    }

    private boolean isSticked() {
        return this.mScrollY >= this.mMaxScrollY;
    }

    @Override // android.view.View
    public void computeScroll() {
        int i;
        LogUtil.d(TAG, "computeScroll");
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (this.mCurDirection != 1) {
                if (this.mScrollable.c()) {
                    scrollTo(0, getScrollY() + (currY - this.mScrollY));
                    if (this.mScrollY <= this.mMinScrollY) {
                        this.mScroller.abortAnimation();
                    }
                } else {
                    int currY2 = this.mScroller.getCurrY() - this.mScrollY;
                    int duration = this.mScroller.getDuration() - this.mScroller.timePassed();
                    int currVelocity = (int) this.mScroller.getCurrVelocity();
                    i = currVelocity <= 10000 ? currVelocity : 10000;
                    if (this.isPreFling) {
                        this.mScrollable.a(-i, currY2, duration);
                        this.isPreFling = false;
                    }
                }
                invalidate();
                return;
            }
            if (!isSticked()) {
                scrollTo(0, getScrollY() + (this.mScroller.getCurrY() - this.mScrollY));
                invalidate();
                return;
            }
            int finalY = this.mScroller.getFinalY() - currY;
            if (finalY > 0) {
                int duration2 = this.mScroller.getDuration() - this.mScroller.timePassed();
                int currVelocity2 = (int) this.mScroller.getCurrVelocity();
                i = currVelocity2 <= 10000 ? currVelocity2 : 10000;
                this.mScroller.abortAnimation();
                this.mScrollable.a(i, finalY, duration2);
            }
            LogUtil.d(TAG, "upup---dy" + finalY);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        LogUtil.d(TAG, "dispatchTouchEvent--" + motionEvent.getAction() + " , " + this.mScrollY);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mScroller.abortAnimation();
        } else if (action == 1) {
            this.handler.sendEmptyMessageDelayed(0, 10L);
            this.lastY = this.mScrollY;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTopView = (ThreadHeaderViewV5) findViewById(R.id.id_nr_stickylayout_top_view);
        this.mStickyView = findViewById(R.id.id_nr_stickylayout_sticky_view);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - this.mStickyViewMarginTop, View.MeasureSpec.getMode(i2)));
        ThreadHeaderViewV5 threadHeaderViewV5 = this.mTopView;
        if (threadHeaderViewV5 != null) {
            threadHeaderViewV5.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            ViewGroup.LayoutParams layoutParams = this.mFrameLayout.getLayoutParams();
            this.mMaxViewPagerHeight = Math.max(this.mMaxViewPagerHeight, getMeasuredHeight() - this.mStickyView.getMeasuredHeight());
            layoutParams.height = getMeasuredHeight() - this.mStickyView.getMeasuredHeight();
            setMeasuredDimension(getMeasuredWidth(), this.mTopView.getMeasuredHeight() + this.mStickyView.getMeasuredHeight() + this.mFrameLayout.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        LogUtil.d(TAG, "onNestedFling");
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        LogUtil.d(TAG, "onNestedPreFling");
        if (f2 == 0.0f) {
            return false;
        }
        this.mCurDirection = f2 < 0.0f ? 2 : 1;
        if (this.mScrollY <= 0) {
            return false;
        }
        this.isPreFling = true;
        this.mScroller.fling(0, getScrollY(), (int) f, (int) f2, 0, 0, C.RATE_UNSET_INT, Integer.MAX_VALUE);
        invalidate();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        LogUtil.d(TAG, "onNestedPreScroll dy = " + i2);
        boolean z = i2 > 0 && getScrollY() < this.mMaxScrollY;
        boolean z2 = i2 < 0 && getScrollY() > 0 && this.mScrollable.c();
        if (z || z2) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        LogUtil.d(TAG, "onNestedScroll");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        LogUtil.d(TAG, "onNestedScrollAccepted--");
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mMaxScrollY = this.mTopView.getMeasuredHeight() - this.mStickyViewMarginTop;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        LogUtil.d(TAG, "onStartNestedScroll--ViewCompat.SCROLL_AXIS_VERTICAL = 2; nestedScrollAxes= " + i);
        this.mScrollable.b(view2);
        return (getNestedScrollAxes() & i) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        LogUtil.d(TAG, "onStopNestedScroll");
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        LogUtil.d(TAG, "scrollTo x = " + i + " , y = " + i2);
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.mMaxScrollY;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 != getScrollY()) {
            super.scrollTo(i, i2);
            this.mScrollY = getScrollY();
        } else {
            int scrollY = getScrollY();
            if (this.mScrollY != scrollY) {
                this.mScrollY = scrollY;
            }
        }
    }

    public void setStickyViewMarginTop(int i) {
        if (i < 0) {
            return;
        }
        this.mStickyViewMarginTop = i;
    }

    public NRStickyLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NRStickyLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStickyViewMarginTop = 0;
        this.mMaxViewPagerHeight = 0;
        this.isPreFling = false;
        this.lastY = 0;
        this.handler = new a();
        setOrientation(1);
        this.mScroller = new Scroller(context);
        this.mScrollable = new z35();
    }

    public void setTopViewScrollCallback(b bVar) {
    }
}
