package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.zenmen.palmchat.R;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AutoResizeGifImageView extends GifImageView {
    private boolean isGif;
    private float mHeight;
    private float mRatio;
    private float mWidth;
    private int maxHeight;
    private int maxWidth;
    private boolean showOriginSize;
    private float whratio;

    public AutoResizeGifImageView(Context context) {
        super(context);
        this.whratio = -1.0f;
        init();
    }

    private void init() {
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_max_width);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_max_height);
        this.mRatio = this.maxWidth / r0;
        this.showOriginSize = false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.whratio;
        if (f != -1.0f) {
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
                return;
            } else {
                int i6 = this.maxHeight;
                setMeasuredDimension((int) (i6 * f2), i6);
                return;
            }
        }
        if (this.isGif) {
            this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_max_width);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_min_width);
            float f3 = this.mRatio;
            if (f3 < 1.0f) {
                int i7 = this.maxHeight;
                int i8 = (int) (i7 * f3);
                if (i8 >= dimension) {
                    dimension = i8;
                }
                setMeasuredDimension(dimension, i7);
                return;
            }
            int i9 = this.maxWidth;
            int i10 = (int) (i9 / f3);
            if (i10 >= dimension) {
                dimension = i10;
            }
            setMeasuredDimension(i9, dimension);
            return;
        }
        this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_max_width);
        int dimension2 = (int) getContext().getResources().getDimension(R.dimen.chat_static_expression_max_height);
        this.maxHeight = dimension2;
        if (this.showOriginSize) {
            float f4 = this.mHeight;
            if (f4 > dimension2 || this.mWidth > this.maxWidth) {
                setMeasuredDimension((int) this.mWidth, (int) f4);
                return;
            }
        }
        float f5 = this.mRatio;
        if (f5 < 1.0f) {
            setMeasuredDimension((int) (dimension2 * f5), dimension2);
        } else {
            int i11 = this.maxWidth;
            setMeasuredDimension(i11, (int) (i11 / f5));
        }
    }

    public void setDisplaySize(int i, int i2) {
        setDisplaySize(i, i2, false);
    }

    public void setRatio(float f) {
        this.whratio = f;
        requestLayout();
    }

    public void setShowOriginSize(boolean z) {
        this.showOriginSize = z;
    }

    public void setDisplaySize(int i, int i2, boolean z) {
        float f = i;
        this.mWidth = f;
        float f2 = i2;
        this.mHeight = f2;
        this.isGif = z;
        this.mRatio = f / f2;
    }

    public AutoResizeGifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.whratio = -1.0f;
        init();
    }

    public AutoResizeGifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.whratio = -1.0f;
        init();
    }
}
