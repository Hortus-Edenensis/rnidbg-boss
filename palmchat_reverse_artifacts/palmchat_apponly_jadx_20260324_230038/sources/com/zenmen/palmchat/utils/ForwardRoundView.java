package com.zenmen.palmchat.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardRoundView extends EffectiveShapeView {
    int maxHeight;
    int maxWidth;
    private float whratio;

    public ForwardRoundView(Context context) {
        super(context);
        this.whratio = -1.0f;
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.whratio;
        if (f > 0.0f) {
            if (f > 1.0f) {
                int i3 = this.maxWidth;
                setMeasuredDimension(i3, (int) (i3 / f));
                return;
            } else {
                int i4 = this.maxHeight;
                setMeasuredDimension((int) (i4 * f), i4);
                return;
            }
        }
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        float f2 = width / height;
        if (f2 > 1.0f) {
            int i5 = this.maxWidth;
            setMeasuredDimension(i5, (int) (i5 / f2));
        } else {
            int i6 = this.maxHeight;
            setMeasuredDimension((int) (i6 * f2), i6);
        }
    }

    public void setRatio(float f) {
        this.whratio = f;
        requestLayout();
    }

    public ForwardRoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.whratio = -1.0f;
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
    }

    public ForwardRoundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.whratio = -1.0f;
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.forward_img_size);
    }
}
