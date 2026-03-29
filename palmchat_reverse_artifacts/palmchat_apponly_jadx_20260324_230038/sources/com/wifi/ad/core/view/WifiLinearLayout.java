package com.wifi.ad.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.wifi.ad.core.utils.ScreenUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiLinearLayout extends LinearLayout {
    float currentX;
    private Context mContext;
    private OnCustomTouchEventListener onCustomTouchEventListener;
    float startX;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnCustomTouchEventListener {
        void onTouchEvent(int i);
    }

    public WifiLinearLayout(Context context) {
        super(context);
        this.startX = 0.0f;
        this.mContext = context;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnCustomTouchEventListener onCustomTouchEventListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startX = motionEvent.getX();
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        float x = motionEvent.getX();
        this.currentX = x;
        float f = x - this.startX;
        if (Math.abs(f) <= ScreenUtil.INSTANCE.dp2px(this.mContext, 10.0f)) {
            return false;
        }
        if (f > 0.0f) {
            OnCustomTouchEventListener onCustomTouchEventListener2 = this.onCustomTouchEventListener;
            if (onCustomTouchEventListener2 != null) {
                onCustomTouchEventListener2.onTouchEvent(4);
            }
        } else if (f < 0.0f && (onCustomTouchEventListener = this.onCustomTouchEventListener) != null) {
            onCustomTouchEventListener.onTouchEvent(3);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnCustomTouchEventListener onCustomTouchEventListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startX = motionEvent.getX();
            return true;
        }
        if (action != 1 && action != 3) {
            return true;
        }
        float x = motionEvent.getX();
        this.currentX = x;
        float f = x - this.startX;
        if (Math.abs(f) <= ScreenUtil.INSTANCE.dp2px(this.mContext, 10.0f)) {
            return true;
        }
        if (f > 0.0f) {
            OnCustomTouchEventListener onCustomTouchEventListener2 = this.onCustomTouchEventListener;
            if (onCustomTouchEventListener2 != null) {
                onCustomTouchEventListener2.onTouchEvent(4);
            }
        } else if (f < 0.0f && (onCustomTouchEventListener = this.onCustomTouchEventListener) != null) {
            onCustomTouchEventListener.onTouchEvent(3);
        }
        return false;
    }

    public void setOnCustomTouchEventListener(OnCustomTouchEventListener onCustomTouchEventListener) {
        this.onCustomTouchEventListener = onCustomTouchEventListener;
    }

    public WifiLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startX = 0.0f;
        this.mContext = context;
    }

    public WifiLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.startX = 0.0f;
        this.mContext = context;
    }
}
