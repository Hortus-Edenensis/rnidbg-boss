package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DoubleClickView extends View implements GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    private GestureDetector mGestureDetector;
    private GestureDetector.OnDoubleTapListener mOnDoubleClickListener;

    public DoubleClickView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnTouchListener(this);
        setClickable(true);
        setLongClickable(true);
        GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener());
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.mOnDoubleClickListener;
        if (onDoubleTapListener != null) {
            return onDoubleTapListener.onDoubleTap(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.mOnDoubleClickListener;
        if (onDoubleTapListener != null) {
            return onDoubleTapListener.onDoubleTapEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.mOnDoubleClickListener;
        if (onDoubleTapListener != null) {
            return onDoubleTapListener.onSingleTapConfirmed(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnDoubleTabListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mOnDoubleClickListener = onDoubleTapListener;
    }

    public DoubleClickView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleClickView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
