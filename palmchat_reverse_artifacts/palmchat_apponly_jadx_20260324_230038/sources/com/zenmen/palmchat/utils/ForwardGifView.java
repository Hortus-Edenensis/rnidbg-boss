package com.zenmen.palmchat.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.AutoResizeGifImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardGifView extends AutoResizeGifImageView {
    private boolean isGif;
    private float mHeight;
    private float mRatio;
    private float mWidth;
    int maxHeight;
    int maxWidth;
    private float whratio;

    public ForwardGifView(Context context) {
        super(context);
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.whratio = -1.0f;
    }

    @Override // com.zenmen.palmchat.widget.AutoResizeGifImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.whratio;
        if (f == -1.0f) {
            if (!this.isGif) {
                float f2 = this.mRatio;
                if (f2 < 1.0f) {
                    int i3 = this.maxHeight;
                    setMeasuredDimension((int) (i3 * f2), i3);
                    return;
                } else {
                    int i4 = this.maxWidth;
                    setMeasuredDimension(i4, (int) (i4 / f2));
                    return;
                }
            }
            float f3 = this.mWidth;
            float f4 = f3 * 2.0f;
            int i5 = this.maxWidth;
            if (f4 < i5) {
                int i6 = (int) (f3 * 2.0f);
                this.maxWidth = i6;
                setMeasuredDimension(i6, (int) (i6 / this.mRatio));
                return;
            } else {
                int i7 = (int) (i5 / this.mRatio);
                this.maxHeight = i7;
                setMeasuredDimension(i5, i7);
                return;
            }
        }
        if (f > 0.0f) {
            if (f > 1.0f) {
                int i8 = this.maxWidth;
                setMeasuredDimension(i8, (int) (i8 / f));
                return;
            } else {
                int i9 = this.maxHeight;
                setMeasuredDimension((int) (i9 * f), i9);
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
        float f5 = width / height;
        if (f5 > 1.0f) {
            int i10 = this.maxWidth;
            setMeasuredDimension(i10, (int) (i10 / f5));
        } else {
            int i11 = this.maxHeight;
            setMeasuredDimension((int) (i11 * f5), i11);
        }
    }

    @Override // com.zenmen.palmchat.widget.AutoResizeGifImageView
    public void setDisplaySize(int i, int i2, boolean z) {
        float f = i;
        this.mWidth = f;
        float f2 = i2;
        this.mHeight = f2;
        this.isGif = z;
        this.mRatio = f / f2;
    }

    @Override // com.zenmen.palmchat.widget.AutoResizeGifImageView
    public void setRatio(float f) {
        this.whratio = f;
        requestLayout();
    }

    public ForwardGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.whratio = -1.0f;
    }

    public ForwardGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.list_item_location_height);
        this.whratio = -1.0f;
    }
}
