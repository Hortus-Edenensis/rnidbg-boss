package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NoneClickableSeekBar extends AppCompatSeekBar {
    private boolean mInterceptClick;
    private Rect mRect;

    public NoneClickableSeekBar(Context context) {
        super(context);
        this.mInterceptClick = false;
    }

    private boolean interceptAction(float f, float f2) {
        if (this.mRect == null) {
            return true;
        }
        Rect rect = this.mRect;
        return new Rect(rect.left + (-50), rect.top, rect.right + 50, rect.bottom).contains((int) f, (int) f2);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable thumb;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() != 0 || !this.mInterceptClick || (thumb = getThumb()) == null) {
            return super.onTouchEvent(motionEvent);
        }
        this.mRect = thumb.getBounds();
        return interceptAction(x, y);
    }

    public NoneClickableSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterceptClick = false;
    }

    public void interceptAction(boolean z) {
        this.mInterceptClick = z;
    }

    public NoneClickableSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterceptClick = false;
    }
}
