package com.zenmen.palmchat.ui.widget.photo.newui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class RatioImageViewNew extends ImageView {
    public RatioImageViewNew(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setColorFilter(Color.parseColor("#77000000"));
        } else if (action == 1 || action == 3) {
            clearColorFilter();
        }
        return super.onTouchEvent(motionEvent);
    }

    public RatioImageViewNew(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioImageViewNew(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
