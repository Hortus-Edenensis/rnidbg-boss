package com.zenmen.palmchat.conversations.threadsnew.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ScrollListView extends ListView {
    private static final String TAG = "MyListView";
    float down;
    float y;

    public ScrollListView(Context context) {
        this(context, null);
    }

    private int measureHight(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            LogUtil.i(TAG, "exactly");
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            i = Math.min(i, size);
        }
        LogUtil.i(TAG, "specMode:" + mode + "--result:" + i);
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.down = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            this.y = motionEvent.getRawY();
            if (isTop()) {
                if (this.y - this.down > 1.0f) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            if (isBottom()) {
                if (this.y - this.down > 1.0f) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean isBottom() {
        return getFirstVisiblePosition() + getChildCount() >= getCount();
    }

    public boolean isTop() {
        return getFirstVisiblePosition() == 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measureHight(536870911, i2), Integer.MIN_VALUE));
    }

    public ScrollListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.down = 0.0f;
    }
}
