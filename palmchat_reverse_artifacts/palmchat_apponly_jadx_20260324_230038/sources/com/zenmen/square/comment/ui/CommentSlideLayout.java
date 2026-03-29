package com.zenmen.square.comment.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import defpackage.tn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentSlideLayout extends FrameLayout {
    private static final int SLIDE_STATUS_NONE = 0;
    private static final int SLIDE_STATUS_PENDING = 1;
    private static final int SLIDE_STATUS_SLIDE = 2;
    private boolean isFinish;
    private RectF mChildInitPosition;
    private View mChildScrollView;
    private int mMaxMoveDistance;
    private a mOnSlideFinishListener;
    private Scroller mScroller;
    private float mSlideDownY;
    private boolean mSlideEnable;
    private int mSlideStatus;
    private float mStartY;
    private float mTempX;
    private float mTempY;
    private int mTouchSlop;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public CommentSlideLayout(Context context) {
        super(context);
        this.mSlideEnable = true;
        init(context);
    }

    private boolean canScrollHorizontally(View view) {
        return view.canScrollHorizontally(-1) || view.canScrollHorizontally(1);
    }

    private RectF getChildViewPosition() {
        RectF rectF = new RectF();
        if (this.mChildScrollView != null) {
            rectF.top = 0.0f;
            rectF.left = 0.0f;
            rectF.right = r1.getWidth();
            rectF.bottom = this.mChildScrollView.getHeight();
        }
        return rectF;
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScroller = new Scroller(context, new AccelerateInterpolator());
    }

    private boolean interceptTouchEvent(MotionEvent motionEvent) {
        if (this.mSlideStatus == 2) {
            return true;
        }
        if (this.mChildScrollView == null) {
            return false;
        }
        makeMaxMoveDistance();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mStartY = motionEvent.getRawY();
            this.mSlideDownY = 0.0f;
            if (canScrollHorizontally(this.mChildScrollView)) {
                this.mSlideStatus = 0;
            } else {
                this.mSlideStatus = 1;
            }
        } else if (action == 2) {
            if (this.mSlideStatus == 1) {
                float rawY = motionEvent.getRawY();
                if (rawY > this.mStartY && !this.mChildScrollView.canScrollVertically(-1)) {
                    if (this.mSlideDownY == 0.0f) {
                        this.mSlideDownY = this.mStartY;
                        this.mTempY = rawY;
                        this.mTempX = motionEvent.getRawX();
                        this.mChildInitPosition = getChildViewPosition();
                    }
                    if (rawY - this.mSlideDownY > this.mTouchSlop) {
                        this.mSlideStatus = 2;
                    }
                }
            }
            if (this.mSlideStatus == 2) {
                return true;
            }
        } else if (action == 5 && this.mSlideStatus == 1) {
            this.mSlideStatus = 0;
            return false;
        }
        return false;
    }

    private void makeMaxMoveDistance() {
        if (this.mMaxMoveDistance == 0) {
            Point pointH = tn.h(getContext());
            if (pointH == null) {
                this.mMaxMoveDistance = getHeight() / 7;
                return;
            }
            int i = pointH.y;
            float f = i / pointH.x;
            if (f < 1.8f) {
                this.mMaxMoveDistance = (int) (i * 0.168f);
            } else if (f < 2.1111112f) {
                this.mMaxMoveDistance = (int) (i * 0.15f);
            } else {
                this.mMaxMoveDistance = (int) (i * 0.142f);
            }
        }
    }

    private void scrollBottom() {
        this.mScroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -((int) ((getHeight() - this.mChildInitPosition.top) + getScrollY())), 150);
        invalidate();
    }

    private void scrollOrigin() {
        this.mScroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -getScrollY(), 150);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            invalidate();
            if (this.mScroller.isFinished() && this.isFinish) {
                this.isFinish = false;
                scrollOrigin();
            }
        }
    }

    public boolean isSlideEnable() {
        return this.mSlideEnable;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mSlideEnable && interceptTouchEvent(motionEvent)) {
            return true;
        }
        return zOnInterceptTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mSlideStatus != 2) {
            return zOnTouchEvent;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            int scrollY = getScrollY();
            this.mSlideStatus = 0;
            if (scrollY <= (-this.mMaxMoveDistance)) {
                this.isFinish = true;
                scrollBottom();
            } else {
                this.isFinish = false;
                scrollOrigin();
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY();
            float rawX = motionEvent.getRawX();
            float f = this.mTempY - rawY;
            this.mTempY = rawY;
            this.mTempX = rawX;
            if (getScrollY() + f < 0.0f) {
                scrollBy(0, (int) f);
            }
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public void setChildScrollView(View view) {
        this.mChildScrollView = view;
    }

    public void setSlideEnable(boolean z) {
        this.mSlideEnable = z;
    }

    public CommentSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSlideEnable = true;
        init(context);
    }

    public CommentSlideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSlideEnable = true;
        init(context);
    }

    public void setOnSlideFinishListener(a aVar) {
    }
}
