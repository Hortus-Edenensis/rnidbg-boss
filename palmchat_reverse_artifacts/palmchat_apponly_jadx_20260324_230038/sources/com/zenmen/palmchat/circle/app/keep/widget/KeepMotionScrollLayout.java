package com.zenmen.palmchat.circle.app.keep.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionScrollLayout extends ViewGroup {
    private int leftBorder;
    private int rightBorder;
    private Scroller scroller;
    private int touchSlop;
    private float wordsSize;
    private float xDown;
    private float xLastMove;
    private float xMove;

    public KeepMotionScrollLayout(Context context) {
        super(context);
        init(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            invalidate();
        }
    }

    public void init(Context context) {
        this.scroller = new Scroller(context);
        this.touchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        Log.d("MyScrollLayout", "touchSlop:" + this.touchSlop);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.xDown = rawX;
            this.xLastMove = rawX;
        } else if (action == 2) {
            float rawX2 = motionEvent.getRawX();
            this.xMove = rawX2;
            float fAbs = Math.abs(rawX2 - this.xDown);
            this.xLastMove = this.xMove;
            if (fAbs > this.touchSlop) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                int measuredWidth = childAt.getMeasuredWidth() * i5;
                i5++;
                childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() * i5, childAt.getMeasuredHeight());
            }
            this.leftBorder = getChildAt(0).getLeft();
            Log.d("MyScrollLayout", "leftBorder:" + this.leftBorder);
            this.rightBorder = getChildAt(childCount + (-1)).getRight();
            Log.d("MyScrollLayout", "rightBorder:" + this.rightBorder);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3), i, i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            Log.d("MyScrollLayout", "getWidth():" + getWidth());
            Log.d("MyScrollLayout", "getScrollX():" + getScrollX());
            Log.d("MyScrollLayout", "targetIndex PX:" + (getScrollX() + (getWidth() / 2)));
            if (getScrollX() >= 0 || Math.abs(getScrollX()) + this.wordsSize <= getWidth() / 2.0f) {
                int scrollX = (getScrollX() + (getWidth() / 2)) / getWidth();
                Log.d("MyScrollLayout", "targetIndex:" + scrollX);
                this.scroller.startScroll(getScrollX(), 0, (scrollX * getWidth()) - getScrollX(), 0);
            } else {
                int i = -(getWidth() - Math.abs(getScrollX()));
                Log.d("MyScrollLayout", "dx:" + i);
                this.scroller.startScroll(getScrollX(), 0, i, 0);
            }
            invalidate();
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            this.xMove = rawX;
            int i2 = (int) (this.xLastMove - rawX);
            if (getScrollX() + i2 >= this.leftBorder) {
                int scrollX2 = getScrollX() + getWidth() + i2;
                int i3 = this.rightBorder;
                if (scrollX2 > i3) {
                    scrollTo(i3 - getWidth(), 0);
                    return true;
                }
            }
            scrollBy(i2, 0);
            this.xLastMove = this.xMove;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setWordsSize(float f) {
        Log.d("MyScrollLayout", "my text size:" + f);
        this.wordsSize = f;
    }

    public KeepMotionScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KeepMotionScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
