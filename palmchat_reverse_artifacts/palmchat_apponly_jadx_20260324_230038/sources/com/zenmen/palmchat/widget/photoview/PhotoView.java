package com.zenmen.palmchat.widget.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.zenmen.palmchat.widget.photoview.a;
import defpackage.or2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PhotoView extends ImageView {
    public static final int HOR_SCROLL = 1;
    public static final int NONE_SCROLL = 2;
    public static final int VER_SCROLL = 0;
    public static or2 sImageSize;
    private boolean isNeedClear;
    private final a mAttacher;
    private Context mCxt;
    private ImageView.ScaleType mPendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
        this.mCxt = context;
    }

    public static float getMaxScaleSize(or2 or2Var, Bitmap bitmap) {
        return getMaxScaleSize(or2Var, bitmap.getWidth(), bitmap.getHeight());
    }

    public static ImageView.ScaleType getPhotoViewScaleType(or2 or2Var, Bitmap bitmap) {
        return getPhotoViewScaleType(or2Var, bitmap.getWidth(), bitmap.getHeight());
    }

    public static ImageView.ScaleType getSquarePhotoViewScaleType(or2 or2Var, int i, int i2) {
        return ((float) or2Var.b()) / ((float) or2Var.a()) > ((float) i) / ((float) i2) ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER;
    }

    public boolean canZoom() {
        return this.mAttacher.f();
    }

    public RectF getDisplayRect() {
        return this.mAttacher.n();
    }

    public float getMaxScale() {
        return this.mAttacher.q();
    }

    public float getMidScale() {
        return this.mAttacher.t();
    }

    public float getMinScale() {
        return this.mAttacher.u();
    }

    public float getScale() {
        return this.mAttacher.v();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mAttacher.w();
    }

    public boolean isScaled() {
        return this.mAttacher.z();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.isNeedClear) {
            this.mAttacher.l();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        sImageSize = new or2(i, i2);
        this.mAttacher.B();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAttacher.D(z);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.S();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.S();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.S();
        }
    }

    public void setMaxScale(float f) {
        this.mAttacher.H(f);
    }

    public void setMaxSizeStatusEnable(boolean z) {
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.I(z);
        }
    }

    public void setMidScale(float f) {
        this.mAttacher.J(f);
    }

    public void setMinScale(float f) {
        this.mAttacher.K(f);
    }

    public void setNeedClear(boolean z) {
        this.isNeedClear = z;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.E(onDoubleTapListener);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mAttacher.L(onLongClickListener);
    }

    public void setOnMatrixChangeListener(a.e eVar) {
        this.mAttacher.M(eVar);
    }

    public void setOnPhotoTapListener(a.f fVar) {
        this.mAttacher.N(fVar);
    }

    public void setOnViewTapListener(a.g gVar) {
        this.mAttacher.O(gVar);
    }

    public void setOriScale(float f) {
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.P(f);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        a aVar = this.mAttacher;
        if (aVar != null) {
            aVar.Q(scaleType);
        } else {
            this.mPendingScaleType = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.mAttacher.R(z);
    }

    public void zoomTo(float f, float f2, float f3) {
        this.mAttacher.U(f, f2, f3);
    }

    public static float getMaxScaleSize(or2 or2Var, int i, int i2) {
        int iB = or2Var.b();
        int iA = or2Var.a();
        if (iB != 0 && iA != 0 && i != 0 && i2 != 0 && iB < iA) {
            float f = iA / iB;
            float f2 = i / i2;
            if (f2 >= 1.0f && f2 <= 3.0f) {
                return Math.max(f2 * f, f);
            }
        }
        return 1.8f;
    }

    public static ImageView.ScaleType getPhotoViewScaleType(or2 or2Var, int i, int i2) {
        int iB = or2Var.b();
        int iA = or2Var.a();
        return (i > iB || i2 > iA) ? (i <= iB || i2 <= iA) ? (i <= iB || i2 > iA) ? (i > iB || i2 <= iA) ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_CENTER : ((float) iB) / ((float) iA) > ((float) i) / ((float) i2) ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER;
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mCxt = context;
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNeedClear = true;
        this.mCxt = context;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.mAttacher = new a(this);
        ImageView.ScaleType scaleType = this.mPendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.mPendingScaleType = null;
        }
    }

    public static ImageView.ScaleType getPhotoViewScaleType(or2 or2Var, Bitmap bitmap, boolean z) {
        int iB = or2Var.b();
        int iA = or2Var.a();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = iB / iA;
        float f2 = width / height;
        if (width <= iB && height <= iA) {
            if (z) {
                return ImageView.ScaleType.CENTER_CROP;
            }
            if (f > f2) {
                return ImageView.ScaleType.CENTER_CROP;
            }
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (width > iB && height > iA) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (width > iB && height <= iA) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (width <= iB && height > iA) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return ImageView.ScaleType.CENTER_CROP;
    }

    public static int getPhotoViewScaleType(ImageView imageView, int i, int i2) {
        int measuredWidth = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        if (i < measuredWidth && i2 < measuredHeight) {
            return 2;
        }
        if (i2 > measuredHeight) {
            return 0;
        }
        return i > measuredWidth ? 1 : 2;
    }
}
