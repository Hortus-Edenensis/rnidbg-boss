package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BigTextViewPager extends ViewPager {
    private boolean isPagingEnabled;

    public BigTextViewPager(Context context) {
        super(context);
        this.isPagingEnabled = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.isPagingEnabled = z;
    }

    public BigTextViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPagingEnabled = true;
    }
}
