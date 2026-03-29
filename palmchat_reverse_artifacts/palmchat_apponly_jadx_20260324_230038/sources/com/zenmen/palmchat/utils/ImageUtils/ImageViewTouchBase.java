package com.zenmen.palmchat.utils.ImageUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import defpackage.uy4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
abstract class ImageViewTouchBase extends ImageView {
    private static final float SCALE_RATE = 1.25f;
    protected Matrix baseMatrix;
    protected final uy4 bitmapDisplayed;
    private final Matrix displayMatrix;
    protected Handler handler;
    private final float[] matrixValues;
    float maxZoom;
    private Runnable onLayoutRunnable;
    private c recycler;
    protected Matrix suppMatrix;
    int thisHeight;
    int thisWidth;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uy4 f15701a;
        public final /* synthetic */ boolean b;

        public a(uy4 uy4Var, boolean z) {
            this.f15701a = uy4Var;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.setImageRotateBitmapResetBase(this.f15701a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f15702a;
        public final /* synthetic */ long b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;

        public b(float f, long j, float f2, float f3, float f4, float f5) {
            this.f15702a = f;
            this.b = j;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(this.f15702a, System.currentTimeMillis() - this.b);
            ImageViewTouchBase.this.zoomTo(this.c + (this.d * fMin), this.e, this.f);
            if (fMin < this.f15702a) {
                ImageViewTouchBase.this.handler.post(this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new uy4(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    private void getProperBaseMatrix(uy4 uy4Var, Matrix matrix, boolean z) {
        float width = getWidth();
        float height = getHeight();
        float fE = uy4Var.e();
        float fB = uy4Var.b();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fE, 3.0f), Math.min(height / fB, 3.0f));
        if (z) {
            matrix.postConcat(uy4Var.c());
        }
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fE * fMin)) / 2.0f, (height - (fB * fMin)) / 2.0f);
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float calculateMaxZoom() {
        if (this.bitmapDisplayed.a() == null) {
            return 1.0f;
        }
        return Math.max(this.bitmapDisplayed.e() / this.thisWidth, this.bitmapDisplayed.b() / this.thisHeight) * 4.0f;
    }

    public void center(boolean z, boolean z2) {
        float f;
        float f2;
        float height;
        float f3;
        if (this.bitmapDisplayed.a() == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f4 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        float fWidth = rectF.width();
        if (z2) {
            float height2 = getHeight();
            if (fHeight < height2) {
                height = (height2 - fHeight) / 2.0f;
                f3 = rectF.top;
            } else {
                float f5 = rectF.top;
                if (f5 > 0.0f) {
                    f = -f5;
                } else {
                    if (rectF.bottom < height2) {
                        height = getHeight();
                        f3 = rectF.bottom;
                    }
                    f = 0.0f;
                }
            }
            f = height - f3;
        } else {
            f = 0.0f;
        }
        if (z) {
            float width = getWidth();
            if (fWidth < width) {
                width = (width - fWidth) / 2.0f;
                f2 = rectF.left;
            } else {
                float f6 = rectF.left;
                if (f6 > 0.0f) {
                    f4 = -f6;
                } else {
                    f2 = rectF.right;
                    if (f2 < width) {
                    }
                }
            }
            f4 = width - f2;
        }
        postTranslate(f4, f);
        setImageMatrix(getImageViewMatrix());
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    public Matrix getImageViewMatrix() {
        this.displayMatrix.set(this.baseMatrix);
        this.displayMatrix.postConcat(this.suppMatrix);
        return this.displayMatrix;
    }

    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        getProperBaseMatrix(this.bitmapDisplayed, matrix, false);
        matrix.postConcat(this.suppMatrix);
        return matrix;
    }

    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.matrixValues);
        return this.matrixValues[i];
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        zoomTo(1.0f);
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.thisWidth = i3 - i;
        this.thisHeight = i4 - i2;
        Runnable runnable = this.onLayoutRunnable;
        if (runnable != null) {
            this.onLayoutRunnable = null;
            runnable.run();
        }
        if (this.bitmapDisplayed.a() != null) {
            getProperBaseMatrix(this.bitmapDisplayed, this.baseMatrix, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public void postTranslate(float f, float f2) {
        this.suppMatrix.postTranslate(f, f2);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new uy4(bitmap, 0), z);
    }

    public void setImageRotateBitmapResetBase(uy4 uy4Var, boolean z) {
        if (getWidth() <= 0) {
            this.onLayoutRunnable = new a(uy4Var, z);
            return;
        }
        if (uy4Var.a() != null) {
            getProperBaseMatrix(uy4Var, this.baseMatrix, true);
            setImageBitmap(uy4Var.a(), uy4Var.d());
        } else {
            this.baseMatrix.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.suppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.maxZoom = calculateMaxZoom();
    }

    public void setRecycler(c cVar) {
        this.recycler = cVar;
    }

    public void zoomIn() {
        zoomIn(SCALE_RATE);
    }

    public void zoomOut() {
        zoomOut(SCALE_RATE);
    }

    public void zoomTo(float f, float f2, float f3) {
        float f4 = this.maxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.suppMatrix.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    private void setImageBitmap(Bitmap bitmap, int i) {
        c cVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapA = this.bitmapDisplayed.a();
        this.bitmapDisplayed.h(bitmap);
        this.bitmapDisplayed.i(i);
        if (bitmapA == null || bitmapA == bitmap || (cVar = this.recycler) == null) {
            return;
        }
        cVar.a(bitmapA);
    }

    public float getScale() {
        return getScale(this.suppMatrix);
    }

    public void zoomIn(float f) {
        if (getScale() < this.maxZoom && this.bitmapDisplayed.a() != null) {
            this.suppMatrix.postScale(f, f, getWidth() / 2.0f, getHeight() / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void zoomOut(float f) {
        if (this.bitmapDisplayed.a() == null) {
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        Matrix matrix = new Matrix(this.suppMatrix);
        float f2 = 1.0f / f;
        matrix.postScale(f2, f2, width, height);
        if (getScale(matrix) < 1.0f) {
            this.suppMatrix.setScale(1.0f, 1.0f, width, height);
        } else {
            this.suppMatrix.postScale(f2, f2, width, height);
        }
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    public void zoomTo(float f, float f2, float f3, float f4) {
        float scale = (f - getScale()) / f4;
        float scale2 = getScale();
        this.handler.post(new b(f4, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public void zoomTo(float f) {
        zoomTo(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new uy4(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new uy4(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }
}
