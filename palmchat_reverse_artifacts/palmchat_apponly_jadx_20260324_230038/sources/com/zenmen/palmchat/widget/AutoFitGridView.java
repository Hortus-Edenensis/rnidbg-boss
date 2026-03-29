package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AutoFitGridView extends GridView {
    private a listener;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public AutoFitGridView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == -1) {
            motionEvent.getAction();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public AutoFitGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoFitGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnNoItemClickListener(a aVar) {
    }
}
