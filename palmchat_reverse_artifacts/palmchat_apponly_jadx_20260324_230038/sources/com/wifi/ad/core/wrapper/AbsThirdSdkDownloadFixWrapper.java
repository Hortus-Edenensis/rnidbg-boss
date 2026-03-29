package com.wifi.ad.core.wrapper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.WifiLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbsThirdSdkDownloadFixWrapper<DATA> extends FrameLayout {
    private float mLastX;
    private float mLastY;
    private int mMoveX;
    private int mMoveY;
    private NestAdData nestAdData;

    public AbsThirdSdkDownloadFixWrapper(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    private void onInterceptClick() {
        if (canPause()) {
            pause();
        } else if (canResume()) {
            resume();
        }
    }

    private void resetTouchPoint() {
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mMoveX = 0;
        this.mMoveY = 0;
    }

    public abstract boolean canPause();

    public abstract boolean canResume();

    public NestAdData getNestAdData() {
        return this.nestAdData;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (shouldIntercept()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!shouldIntercept()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            resetTouchPoint();
            this.mLastX = motionEvent.getRawX();
            this.mLastY = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 1) {
            if (action == 2) {
                this.mMoveX = (int) (motionEvent.getRawX() - this.mLastX);
                this.mMoveY = (int) (motionEvent.getRawY() - this.mLastY);
            }
        } else {
            if (Math.abs(this.mMoveY) > 100) {
                resetTouchPoint();
                return false;
            }
            if (Math.abs(this.mMoveX) > 100) {
                resetTouchPoint();
                return false;
            }
            resetTouchPoint();
            onInterceptClick();
        }
        return true;
    }

    public abstract void pause();

    public abstract void resume();

    public void setNestAdData(NestAdData nestAdData) {
        this.nestAdData = nestAdData;
    }

    public abstract boolean shouldIntercept();

    public abstract void wrap(DATA data);

    public void wrapData(DATA data) {
        wrap(data);
    }

    public void wrapView(View view) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        if (viewGroup instanceof LinearLayout) {
            iIndexOfChild = viewGroup.indexOfChild(view);
            WifiLog.d("AbsThirdSdkDownloadFixWrapper childIndexInLinearLayout = " + iIndexOfChild);
        } else {
            iIndexOfChild = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        viewGroup.removeView(view);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        addView(view, layoutParams2);
        if (iIndexOfChild != -1) {
            viewGroup.addView(this, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(this, layoutParams);
        }
    }

    public AbsThirdSdkDownloadFixWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AbsThirdSdkDownloadFixWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
