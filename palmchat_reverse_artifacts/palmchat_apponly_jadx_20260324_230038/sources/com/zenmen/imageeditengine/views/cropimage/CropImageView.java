package com.zenmen.imageeditengine.views.cropimage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.zenmen.imageeditengine.R$id;
import com.zenmen.imageeditengine.R$layout;
import com.zenmen.imageeditengine.R$styleable;
import com.zenmen.imageeditengine.views.cropimage.CropOverlayView;
import com.zenmen.imageeditengine.views.cropimage.a;
import com.zenmen.imageeditengine.views.cropimage.b;
import com.zenmen.imageeditengine.views.cropimage.c;
import defpackage.gr0;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CropImageView extends FrameLayout implements CropOverlayView.c {
    private gr0 mAnimation;
    private boolean mAutoZoomEnabled;
    private Bitmap mBitmap;
    private WeakReference<com.zenmen.imageeditengine.views.cropimage.a> mBitmapCroppingWorkerTask;
    private WeakReference<com.zenmen.imageeditengine.views.cropimage.b> mBitmapLoadingWorkerTask;
    private final CropOverlayView mCropOverlayView;
    private int mDegreesRotated;
    private boolean mFlipHorizontally;
    private boolean mFlipVertically;
    private final Matrix mImageInverseMatrix;
    private final Matrix mImageMatrix;
    private final float[] mImagePoints;
    private int mImageResource;
    private final ImageView mImageView;
    private int mInitialDegreesRotated;
    private int mLayoutHeight;
    private int mLayoutWidth;
    private Uri mLoadedImageUri;
    private int mLoadedSampleSize;
    private int mMaxZoom;
    private b mOnCropImageCompleteListener;
    private d mOnCropOverlayReleasedListener;
    private c mOnSetCropOverlayMovedListener;
    private e mOnSetCropWindowChangeListener;
    private f mOnSetImageUriCompleteListener;
    private final ProgressBar mProgressBar;
    private RectF mRestoreCropWindowRect;
    private int mRestoreDegreesRotated;
    private boolean mSaveBitmapToInstanceState;
    private Uri mSaveInstanceStateBitmapUri;
    private final float[] mScaleImagePoints;
    private ScaleType mScaleType;
    private boolean mShowCropOverlay;
    private boolean mShowProgressBar;
    private boolean mSizeChanged;
    private float mZoom;
    private float mZoomOffsetX;
    private float mZoomOffsetY;

    /* JADX INFO: compiled from: SearchBox */
    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CropOverlayView.b {
        public a() {
        }

        @Override // com.zenmen.imageeditengine.views.cropimage.CropOverlayView.b
        public void a(boolean z) {
            CropImageView.this.handleCropWindowChanged(z, true);
            CropImageView.access$100(CropImageView.this);
            CropImageView.access$200(CropImageView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void k();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ d access$100(CropImageView cropImageView) {
        cropImageView.getClass();
        return null;
    }

    public static /* synthetic */ c access$200(CropImageView cropImageView) {
        cropImageView.getClass();
        return null;
    }

    public static /* synthetic */ float access$432(CropImageView cropImageView, float f2) {
        float f3 = cropImageView.mZoom * f2;
        cropImageView.mZoom = f3;
        return f3;
    }

    private void applyImageMatrix(float f2, float f3, boolean z, boolean z2, boolean z3) {
        RectF cropWindowLimitRect = this.mCropOverlayView.getCropWindowLimitRect(getWidth(), getHeight());
        if (this.mBitmap == null || f2 <= 0.0f || f3 <= 0.0f || cropWindowLimitRect.left <= 0.0f) {
            return;
        }
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        this.mImageInverseMatrix.mapRect(cropWindowRect);
        this.mImageMatrix.reset();
        RectF displayRect = (cropWindowRect.height() == 0.0f && cropWindowRect.width() == 0.0f) ? this.mDegreesRotated % EffectConstants.ROTATION_DEGREES_180 == 0 ? this.mCropOverlayView.getDisplayRect(this.mBitmap.getWidth(), this.mBitmap.getHeight()) : this.mCropOverlayView.getDisplayRect(this.mBitmap.getHeight(), this.mBitmap.getWidth()) : this.mDegreesRotated % EffectConstants.ROTATION_DEGREES_180 == 0 ? this.mCropOverlayView.getDisplayRect((int) cropWindowRect.width(), (int) cropWindowRect.height()) : this.mCropOverlayView.getDisplayRect((int) cropWindowRect.height(), (int) cropWindowRect.width());
        this.mImageMatrix.postTranslate((f2 - this.mBitmap.getWidth()) / 2.0f, (f3 - this.mBitmap.getHeight()) / 2.0f);
        mapImagePointsByImageMatrix();
        int i = this.mDegreesRotated;
        if (i > 0) {
            this.mImageMatrix.postRotate(i, com.zenmen.imageeditengine.views.cropimage.c.q(this.mImagePoints), com.zenmen.imageeditengine.views.cropimage.c.r(this.mImagePoints));
            mapImagePointsByImageMatrix();
        }
        float fMin = Math.min(cropWindowLimitRect.width() / com.zenmen.imageeditengine.views.cropimage.c.x(this.mImagePoints), cropWindowLimitRect.height() / com.zenmen.imageeditengine.views.cropimage.c.t(this.mImagePoints));
        ScaleType scaleType = this.mScaleType;
        if (scaleType == ScaleType.FIT_CENTER || ((scaleType == ScaleType.CENTER_INSIDE && fMin < 1.0f) || (fMin > 1.0f && this.mAutoZoomEnabled))) {
            if (cropWindowRect.width() == 0.0f && cropWindowRect.height() == 0.0f) {
                fMin = displayRect.width() / com.zenmen.imageeditengine.views.cropimage.c.x(this.mImagePoints);
            }
            this.mImageMatrix.postScale(fMin, fMin, com.zenmen.imageeditengine.views.cropimage.c.q(this.mImagePoints), com.zenmen.imageeditengine.views.cropimage.c.r(this.mImagePoints));
            mapImagePointsByImageMatrix();
        }
        this.mImageMatrix.postScale(this.mFlipHorizontally ? -this.mZoom : this.mZoom, this.mFlipVertically ? -this.mZoom : this.mZoom, com.zenmen.imageeditengine.views.cropimage.c.q(this.mImagePoints), com.zenmen.imageeditengine.views.cropimage.c.r(this.mImagePoints));
        mapImagePointsByImageMatrix();
        this.mImageMatrix.mapRect(cropWindowRect);
        if (z) {
            float f4 = displayRect.left - cropWindowRect.left;
            float f5 = displayRect.top - cropWindowRect.top;
            this.mZoomOffsetX = f4;
            this.mZoomOffsetY = f5;
        } else {
            this.mZoomOffsetX = Math.min(Math.max(this.mZoomOffsetX, -cropWindowRect.left), (-cropWindowRect.right) + f2);
            this.mZoomOffsetY = Math.min(Math.max(this.mZoomOffsetY, -cropWindowRect.top), (-cropWindowRect.bottom) + f3);
        }
        this.mImageMatrix.postTranslate(this.mZoomOffsetX, this.mZoomOffsetY);
        if (z3) {
            cropWindowRect.offset(this.mZoomOffsetX, this.mZoomOffsetY);
            this.mCropOverlayView.setCropWindowRect(cropWindowRect);
        }
        mapImagePointsByImageMatrix();
        this.mCropOverlayView.invalidate();
        if (z2) {
            this.mAnimation.a(this.mImagePoints, this.mImageMatrix);
            this.mImageView.startAnimation(this.mAnimation);
        } else {
            this.mImageView.setImageMatrix(this.mImageMatrix);
        }
        if (cropWindowRect.width() == 0.0f && cropWindowRect.height() == 0.0f) {
            this.mCropOverlayView.transferInitCropWindow(this.mImageMatrix);
        }
        updateImageBounds(false);
    }

    private void clearImageInt() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && (this.mImageResource > 0 || this.mLoadedImageUri != null)) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        this.mImageResource = 0;
        this.mLoadedImageUri = null;
        this.mLoadedSampleSize = 1;
        this.mDegreesRotated = 0;
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mImageMatrix.reset();
        this.mSaveInstanceStateBitmapUri = null;
        this.mImageView.setImageBitmap(null);
        setCropOverlayVisibility();
    }

    private static int getOnMeasureSpec(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCropWindowChanged(boolean z, boolean z2) {
        int width = getWidth();
        int height = getHeight();
        if (this.mBitmap == null || width <= 0 || height <= 0) {
            return;
        }
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        RectF cropWindowLimitRect = this.mCropOverlayView.getCropWindowLimitRect(width, height);
        float fWidth = cropWindowLimitRect.width();
        float fHeight = cropWindowLimitRect.height();
        if (z) {
            if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                applyImageMatrix(width, height, false, false, true);
            }
            e eVar = this.mOnSetCropWindowChangeListener;
            if (eVar != null) {
                eVar.k();
                return;
            }
            return;
        }
        if (this.mAutoZoomEnabled) {
            float fMin = this.mZoom * Math.min(fWidth / cropWindowRect.width(), fHeight / cropWindowRect.height());
            if (!this.mAutoZoomEnabled) {
                fMin = 1.0f;
            }
            if (z2) {
                if (this.mAnimation == null) {
                    this.mAnimation = new gr0(this.mImageView, this.mCropOverlayView);
                }
                this.mAnimation.b(this.mImagePoints, this.mImageMatrix);
            }
            this.mZoom = fMin;
            applyImageMatrix(width, height, true, z2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mapImagePointsByImageMatrix() {
        float[] fArr = this.mImagePoints;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.mBitmap.getWidth();
        float[] fArr2 = this.mImagePoints;
        fArr2[3] = 0.0f;
        fArr2[4] = this.mBitmap.getWidth();
        this.mImagePoints[5] = this.mBitmap.getHeight();
        float[] fArr3 = this.mImagePoints;
        fArr3[6] = 0.0f;
        fArr3[7] = this.mBitmap.getHeight();
        this.mImageMatrix.mapPoints(this.mImagePoints);
        float[] fArr4 = this.mScaleImagePoints;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.mImageMatrix.mapPoints(fArr4);
    }

    private void setBitmap(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.mImageView.clearAnimation();
            clearImageInt();
            this.mBitmap = bitmap;
            this.mImageView.setImageBitmap(bitmap);
            this.mLoadedImageUri = uri;
            this.mImageResource = i;
            this.mLoadedSampleSize = i2;
            this.mDegreesRotated = i3;
            applyImageMatrix(getWidth(), getHeight(), true, false, true);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.resetCropOverlayView();
                setCropOverlayVisibility();
            }
        }
    }

    private void setCropOverlayVisibility() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.mShowCropOverlay || this.mBitmap == null) ? 4 : 0);
        }
    }

    private void setProgressBarVisibility() {
        this.mProgressBar.setVisibility(this.mShowProgressBar && ((this.mBitmap == null && this.mBitmapLoadingWorkerTask != null) || this.mBitmapCroppingWorkerTask != null) ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageBounds(boolean z) {
        if (this.mBitmap != null && !z) {
            this.mCropOverlayView.setCropWindowLimits(getWidth(), getHeight(), (this.mLoadedSampleSize * 100.0f) / com.zenmen.imageeditengine.views.cropimage.c.x(this.mScaleImagePoints), (this.mLoadedSampleSize * 100.0f) / com.zenmen.imageeditengine.views.cropimage.c.t(this.mScaleImagePoints));
        }
        this.mCropOverlayView.setBounds(z ? null : this.mImagePoints, getWidth(), getHeight());
    }

    public void clearAspectRatio() {
        this.mCropOverlayView.setAspectRatioX(1);
        this.mCropOverlayView.setAspectRatioY(1);
        setFixedAspectRatio(false);
    }

    public void clearImage() {
        clearImageInt();
        this.mCropOverlayView.setInitialCropWindowRect(null);
    }

    public void flipImageHorizontally() {
        this.mFlipHorizontally = !this.mFlipHorizontally;
        applyImageMatrix(getWidth(), getHeight(), true, false, true);
    }

    public void flipImageVertically() {
        this.mFlipVertically = !this.mFlipVertically;
        applyImageMatrix(getWidth(), getHeight(), true, false, true);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.mCropOverlayView.getAspectRatioX()), Integer.valueOf(this.mCropOverlayView.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        float[] fArr = new float[8];
        float f2 = cropWindowRect.left;
        fArr[0] = f2;
        float f3 = cropWindowRect.top;
        fArr[1] = f3;
        float f4 = cropWindowRect.right;
        fArr[2] = f4;
        fArr[3] = f3;
        fArr[4] = f4;
        float f5 = cropWindowRect.bottom;
        fArr[5] = f5;
        fArr[6] = f2;
        fArr[7] = f5;
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapPoints(fArr);
        for (int i = 0; i < 8; i++) {
            fArr[i] = fArr[i] * this.mLoadedSampleSize;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i = this.mLoadedSampleSize;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        return com.zenmen.imageeditengine.views.cropimage.c.s(getCropPoints(), bitmap.getWidth() * i, i * bitmap.getHeight(), this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY());
    }

    public CropShape getCropShape() {
        return this.mCropOverlayView.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        return getCroppedImage(0, 0, RequestSizeOptions.NONE);
    }

    public void getCroppedImageAsync() {
        getCroppedImageAsync(0, 0, RequestSizeOptions.NONE);
    }

    public Guidelines getGuidelines() {
        return this.mCropOverlayView.getGuidelines();
    }

    public int getImageResource() {
        return this.mImageResource;
    }

    public Uri getImageUri() {
        return this.mLoadedImageUri;
    }

    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public int getRotatedDegrees() {
        return this.mDegreesRotated;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Rect getWholeImageRect() {
        int i = this.mLoadedSampleSize;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public boolean isAutoZoomEnabled() {
        return this.mAutoZoomEnabled;
    }

    public boolean isFixAspectRatio() {
        return this.mCropOverlayView.isFixAspectRatio();
    }

    public boolean isFlippedHorizontally() {
        return this.mFlipHorizontally;
    }

    public boolean isFlippedVertically() {
        return this.mFlipVertically;
    }

    public boolean isSaveBitmapToInstanceState() {
        return this.mSaveBitmapToInstanceState;
    }

    public boolean isShowCropOverlay() {
        return this.mShowCropOverlay;
    }

    public boolean isShowProgressBar() {
        return this.mShowProgressBar;
    }

    public void onImageCroppingAsyncComplete(a.C0928a c0928a) {
        this.mBitmapCroppingWorkerTask = null;
        setProgressBarVisibility();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mLayoutWidth <= 0 || this.mLayoutHeight <= 0) {
            updateImageBounds(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.mLayoutWidth;
        layoutParams.height = this.mLayoutHeight;
        setLayoutParams(layoutParams);
        if (this.mBitmap == null) {
            updateImageBounds(true);
            return;
        }
        float f2 = i3 - i;
        float f3 = i4 - i2;
        applyImageMatrix(f2, f3, true, false, true);
        if (this.mRestoreCropWindowRect == null) {
            if (this.mSizeChanged) {
                this.mSizeChanged = false;
                handleCropWindowChanged(false, false);
                return;
            }
            return;
        }
        int i5 = this.mRestoreDegreesRotated;
        if (i5 != this.mInitialDegreesRotated) {
            this.mDegreesRotated = i5;
            applyImageMatrix(f2, f3, true, false, true);
        }
        this.mImageMatrix.mapRect(this.mRestoreCropWindowRect);
        this.mCropOverlayView.setCropWindowRect(this.mRestoreCropWindowRect);
        handleCropWindowChanged(false, false);
        this.mCropOverlayView.fixCurrentCropWindowRect();
        this.mRestoreCropWindowRect = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int width;
        int height;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            size2 = bitmap.getHeight();
        }
        double width2 = size < this.mBitmap.getWidth() ? ((double) size) / ((double) this.mBitmap.getWidth()) : Double.POSITIVE_INFINITY;
        double height2 = size2 < this.mBitmap.getHeight() ? ((double) size2) / ((double) this.mBitmap.getHeight()) : Double.POSITIVE_INFINITY;
        if (width2 == Double.POSITIVE_INFINITY && height2 == Double.POSITIVE_INFINITY) {
            width = this.mBitmap.getWidth();
            height = this.mBitmap.getHeight();
        } else if (width2 <= height2) {
            height = (int) (((double) this.mBitmap.getHeight()) * width2);
            width = size;
        } else {
            width = (int) (((double) this.mBitmap.getWidth()) * height2);
            height = size2;
        }
        int onMeasureSpec = getOnMeasureSpec(mode, size, width);
        int onMeasureSpec2 = getOnMeasureSpec(mode2, size2, height);
        this.mLayoutWidth = onMeasureSpec;
        this.mLayoutHeight = onMeasureSpec2;
        setMeasuredDimension(onMeasureSpec, onMeasureSpec2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        if (this.mBitmapLoadingWorkerTask == null && this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource == 0) {
            Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
            if (uri != null) {
                String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                if (string != null) {
                    Pair<String, WeakReference<Bitmap>> pair = com.zenmen.imageeditengine.views.cropimage.c.g;
                    Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) com.zenmen.imageeditengine.views.cropimage.c.g.second).get();
                    com.zenmen.imageeditengine.views.cropimage.c.g = null;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        setBitmap(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                    }
                }
                if (this.mLoadedImageUri == null) {
                    setImageUriAsync(uri);
                }
            } else {
                int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                if (i > 0) {
                    setImageResource(i);
                } else {
                    Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                    if (uri2 != null) {
                        setImageUriAsync(uri2);
                    }
                }
            }
            int i2 = bundle.getInt("DEGREES_ROTATED");
            this.mRestoreDegreesRotated = i2;
            this.mDegreesRotated = i2;
            Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
            if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                this.mCropOverlayView.setInitialCropWindowRect(rect);
            }
            RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
            if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                this.mRestoreCropWindowRect = rectF;
            }
            this.mCropOverlayView.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
            this.mAutoZoomEnabled = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
            this.mMaxZoom = bundle.getInt("CROP_MAX_ZOOM");
            this.mFlipHorizontally = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
            this.mFlipVertically = bundle.getBoolean("CROP_FLIP_VERTICALLY");
        }
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.zenmen.imageeditengine.views.cropimage.b bVar;
        if (this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uriD = this.mLoadedImageUri;
        if (this.mSaveBitmapToInstanceState && uriD == null && this.mImageResource < 1) {
            uriD = com.zenmen.imageeditengine.views.cropimage.c.D(getContext(), this.mBitmap, this.mSaveInstanceStateBitmapUri);
            this.mSaveInstanceStateBitmapUri = uriD;
        }
        if (uriD != null && this.mBitmap != null) {
            String string = UUID.randomUUID().toString();
            com.zenmen.imageeditengine.views.cropimage.c.g = new Pair<>(string, new WeakReference(this.mBitmap));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference<com.zenmen.imageeditengine.views.cropimage.b> weakReference = this.mBitmapLoadingWorkerTask;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.b());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uriD);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.mImageResource);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.mLoadedSampleSize);
        bundle.putInt("DEGREES_ROTATED", this.mDegreesRotated);
        bundle.putParcelable("INITIAL_CROP_RECT", this.mCropOverlayView.getInitialCropWindowRect());
        RectF rectF = com.zenmen.imageeditengine.views.cropimage.c.c;
        rectF.set(this.mCropOverlayView.getCropWindowRect());
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.mCropOverlayView.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.mAutoZoomEnabled);
        bundle.putInt("CROP_MAX_ZOOM", this.mMaxZoom);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.mFlipHorizontally);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.mFlipVertically);
        return bundle;
    }

    public void onSetImageUriAsyncComplete(b.a aVar) {
        this.mBitmapLoadingWorkerTask = null;
        setProgressBarVisibility();
        if (aVar.e == null) {
            int i = aVar.d;
            this.mInitialDegreesRotated = i;
            setBitmap(aVar.b, 0, aVar.f11830a, aVar.c, i);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mSizeChanged = i3 > 0 && i4 > 0;
    }

    @Override // com.zenmen.imageeditengine.views.cropimage.CropOverlayView.c
    public void onTouchMove(float f2, float f3) {
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        Matrix matrix = new Matrix();
        matrix.set(this.mImageMatrix);
        matrix.postTranslate(f2, f3);
        float[] fArr = {0.0f, 0.0f, this.mBitmap.getWidth(), 0.0f, this.mBitmap.getWidth(), this.mBitmap.getHeight(), 0.0f, this.mBitmap.getHeight(), 0.0f};
        matrix.mapPoints(fArr);
        RectF rectF = new RectF(com.zenmen.imageeditengine.views.cropimage.c.u(fArr), com.zenmen.imageeditengine.views.cropimage.c.w(fArr), com.zenmen.imageeditengine.views.cropimage.c.v(fArr), com.zenmen.imageeditengine.views.cropimage.c.p(fArr));
        if (rectF.contains(cropWindowRect) || rectF.equals(cropWindowRect)) {
            this.mImageMatrix.postTranslate(f2, f3);
            this.mImageView.setImageMatrix(this.mImageMatrix);
            mapImagePointsByImageMatrix();
            updateImageBounds(false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void resetCropRect() {
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mDegreesRotated = this.mInitialDegreesRotated;
        this.mFlipHorizontally = false;
        this.mFlipVertically = false;
        this.mImageMatrix.reset();
        this.mCropOverlayView.setInitialCropWindowRect(null);
        this.mCropOverlayView.setCropWindowRect(com.zenmen.imageeditengine.views.cropimage.c.b);
        applyImageMatrix(getWidth(), getHeight(), true, false, true);
        this.mCropOverlayView.resetCropWindowRect();
    }

    public void rotateImage(int i) {
        if (this.mBitmap != null) {
            this.mDegreesRotated = (this.mDegreesRotated + (i < 0 ? (i % 360) + 360 : i % 360)) % 360;
            applyImageMatrix(getWidth(), getHeight(), true, false, true);
            handleCropWindowChanged(false, false);
        }
    }

    public void saveCroppedImageAsync(Uri uri) {
        saveCroppedImageAsync(uri, Bitmap.CompressFormat.JPEG, 90, 0, 0, RequestSizeOptions.NONE);
    }

    public void setAspectRatio(int i, int i2) {
        this.mCropOverlayView.setAspectRatioX(i);
        this.mCropOverlayView.setAspectRatioY(i2);
        setFixedAspectRatio(true);
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.mAutoZoomEnabled != z) {
            this.mAutoZoomEnabled = z;
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.mCropOverlayView.setInitialCropWindowRect(rect);
    }

    public void setCropShape(CropShape cropShape) {
        this.mCropOverlayView.setCropShape(cropShape);
    }

    public void setFixedAspectRatio(boolean z) {
        this.mCropOverlayView.setFixedAspectRatio(z);
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.mFlipHorizontally != z) {
            this.mFlipHorizontally = z;
            applyImageMatrix(getWidth(), getHeight(), true, false, true);
        }
    }

    public void setFlippedVertically(boolean z) {
        if (this.mFlipVertically != z) {
            this.mFlipVertically = z;
            applyImageMatrix(getWidth(), getHeight(), true, false, true);
        }
    }

    public void setGuidelines(Guidelines guidelines) {
        this.mCropOverlayView.setGuidelines(guidelines);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mCropOverlayView.setInitialCropWindowRect(null);
        setBitmap(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.mCropOverlayView.setInitialCropWindowRect(null);
            setBitmap(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<com.zenmen.imageeditengine.views.cropimage.b> weakReference = this.mBitmapLoadingWorkerTask;
            com.zenmen.imageeditengine.views.cropimage.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            clearImageInt();
            this.mRestoreCropWindowRect = null;
            this.mRestoreDegreesRotated = 0;
            this.mCropOverlayView.setInitialCropWindowRect(null);
            WeakReference<com.zenmen.imageeditengine.views.cropimage.b> weakReference2 = new WeakReference<>(new com.zenmen.imageeditengine.views.cropimage.b(this, uri));
            this.mBitmapLoadingWorkerTask = weakReference2;
            weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            setProgressBarVisibility();
        }
    }

    public void setMaxCropResultSize(int i, int i2) {
        this.mCropOverlayView.setMaxCropResultSize(i, i2);
    }

    public void setMaxZoom(int i) {
        if (this.mMaxZoom == i || i <= 0) {
            return;
        }
        this.mMaxZoom = i;
        handleCropWindowChanged(false, false);
        this.mCropOverlayView.invalidate();
    }

    public void setMinCropResultSize(int i, int i2) {
        this.mCropOverlayView.setMinCropResultSize(i, i2);
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.mCropOverlayView.setMultiTouchEnabled(z, new g(this, null))) {
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setOnCropWindowChangedListener(e eVar) {
        this.mOnSetCropWindowChangeListener = eVar;
    }

    public void setRotatedDegrees(int i) {
        int i2 = this.mDegreesRotated;
        if (i2 != i) {
            rotateImage(i - i2);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.mSaveBitmapToInstanceState = z;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            this.mZoom = 1.0f;
            this.mZoomOffsetY = 0.0f;
            this.mZoomOffsetX = 0.0f;
            this.mCropOverlayView.resetCropOverlayView();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.mShowCropOverlay != z) {
            this.mShowCropOverlay = z;
            setCropOverlayVisibility();
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.mShowProgressBar != z) {
            this.mShowProgressBar = z;
            setProgressBarVisibility();
        }
    }

    public void setSnapRadius(float f2) {
        if (f2 >= 0.0f) {
            this.mCropOverlayView.setSnapRadius(f2);
        }
    }

    public void startCropWorkerTask(int i, int i2, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i3) {
        CropImageView cropImageView;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mImageView.clearAnimation();
            WeakReference<com.zenmen.imageeditengine.views.cropimage.a> weakReference = this.mBitmapCroppingWorkerTask;
            com.zenmen.imageeditengine.views.cropimage.a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar != null) {
                aVar.cancel(true);
            }
            RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
            int i4 = requestSizeOptions != requestSizeOptions2 ? i : 0;
            int i5 = requestSizeOptions != requestSizeOptions2 ? i2 : 0;
            int width = bitmap.getWidth() * this.mLoadedSampleSize;
            int height = bitmap.getHeight();
            int i6 = this.mLoadedSampleSize;
            int i7 = height * i6;
            if (this.mLoadedImageUri == null || (i6 <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
                cropImageView = this;
                cropImageView.mBitmapCroppingWorkerTask = new WeakReference<>(new com.zenmen.imageeditengine.views.cropimage.a(this, bitmap, getCropPoints(), this.mDegreesRotated, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i4, i5, this.mFlipHorizontally, this.mFlipVertically, requestSizeOptions, uri, compressFormat, i3));
            } else {
                this.mBitmapCroppingWorkerTask = new WeakReference<>(new com.zenmen.imageeditengine.views.cropimage.a(this, this.mLoadedImageUri, getCropPoints(), this.mDegreesRotated, width, i7, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i4, i5, this.mFlipHorizontally, this.mFlipVertically, requestSizeOptions, uri, compressFormat, i3));
                cropImageView = this;
            }
            cropImageView.mBitmapCroppingWorkerTask.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            setProgressBarVisibility();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11823a;

        public g() {
            this.f11823a = 1.0f;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (scaleFactor > 1.0f && CropImageView.this.mZoom > CropImageView.this.mMaxZoom) {
                return true;
            }
            RectF cropWindowRect = CropImageView.this.mCropOverlayView.getCropWindowRect();
            Matrix matrix = new Matrix();
            matrix.set(CropImageView.this.mImageMatrix);
            float[] fArr = {0.0f, 0.0f, CropImageView.this.mBitmap.getWidth(), 0.0f, CropImageView.this.mBitmap.getWidth(), CropImageView.this.mBitmap.getHeight(), 0.0f, CropImageView.this.mBitmap.getHeight(), 0.0f};
            matrix.postScale(scaleFactor, scaleFactor, com.zenmen.imageeditengine.views.cropimage.c.q(CropImageView.this.mImagePoints), com.zenmen.imageeditengine.views.cropimage.c.r(CropImageView.this.mImagePoints));
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(com.zenmen.imageeditengine.views.cropimage.c.u(fArr), com.zenmen.imageeditengine.views.cropimage.c.w(fArr), com.zenmen.imageeditengine.views.cropimage.c.v(fArr), com.zenmen.imageeditengine.views.cropimage.c.p(fArr));
            if (!rectF.contains(cropWindowRect) && !rectF.equals(cropWindowRect)) {
                return true;
            }
            this.f11823a *= scaleFactor;
            CropImageView.this.mImageMatrix.postScale(scaleFactor, scaleFactor, com.zenmen.imageeditengine.views.cropimage.c.q(CropImageView.this.mImagePoints), com.zenmen.imageeditengine.views.cropimage.c.r(CropImageView.this.mImagePoints));
            CropImageView.this.mImageView.setImageMatrix(CropImageView.this.mImageMatrix);
            CropImageView.this.mapImagePointsByImageMatrix();
            CropImageView.this.updateImageBounds(false);
            CropImageView.this.mCropOverlayView.invalidate();
            if (CropImageView.this.mOnSetCropWindowChangeListener != null) {
                CropImageView.this.mOnSetCropWindowChangeListener.k();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f11823a = 1.0f;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            CropImageView.access$432(CropImageView.this, this.f11823a);
        }

        public /* synthetic */ g(CropImageView cropImageView, a aVar) {
            this();
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new Matrix();
        this.mImageInverseMatrix = new Matrix();
        this.mImagePoints = new float[8];
        this.mScaleImagePoints = new float[8];
        this.mSaveBitmapToInstanceState = false;
        this.mShowCropOverlay = true;
        this.mShowProgressBar = true;
        this.mAutoZoomEnabled = true;
        this.mLoadedSampleSize = 1;
        this.mZoom = 1.0f;
        CropImageOptions cropImageOptions = new CropImageOptions();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CropImageView, 0, 0);
            try {
                int i = R$styleable.CropImageView_cropFixAspectRatio;
                cropImageOptions.fixAspectRatio = typedArrayObtainStyledAttributes.getBoolean(i, cropImageOptions.fixAspectRatio);
                int i2 = R$styleable.CropImageView_cropAspectRatioX;
                cropImageOptions.aspectRatioX = typedArrayObtainStyledAttributes.getInteger(i2, cropImageOptions.aspectRatioX);
                cropImageOptions.aspectRatioY = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropAspectRatioY, cropImageOptions.aspectRatioY);
                cropImageOptions.scaleType = ScaleType.values()[typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropScaleType, cropImageOptions.scaleType.ordinal())];
                cropImageOptions.autoZoomEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions.autoZoomEnabled);
                cropImageOptions.multiTouchEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions.multiTouchEnabled);
                cropImageOptions.maxZoom = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropMaxZoom, cropImageOptions.maxZoom);
                cropImageOptions.cropShape = CropShape.values()[typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropShape, cropImageOptions.cropShape.ordinal())];
                cropImageOptions.guidelines = Guidelines.values()[typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropGuidelines, cropImageOptions.guidelines.ordinal())];
                cropImageOptions.snapRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropSnapRadius, cropImageOptions.snapRadius);
                cropImageOptions.touchRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropTouchRadius, cropImageOptions.touchRadius);
                cropImageOptions.initialCropWindowPaddingRatio = typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions.initialCropWindowPaddingRatio);
                cropImageOptions.borderLineThickness = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderLineThickness, cropImageOptions.borderLineThickness);
                cropImageOptions.borderLineColor = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderLineColor, cropImageOptions.borderLineColor);
                int i3 = R$styleable.CropImageView_cropBorderCornerThickness;
                cropImageOptions.borderCornerThickness = typedArrayObtainStyledAttributes.getDimension(i3, cropImageOptions.borderCornerThickness);
                cropImageOptions.borderCornerOffset = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerOffset, cropImageOptions.borderCornerOffset);
                cropImageOptions.borderCornerLength = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerLength, cropImageOptions.borderCornerLength);
                cropImageOptions.borderCornerColor = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderCornerColor, cropImageOptions.borderCornerColor);
                cropImageOptions.guidelinesThickness = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropGuidelinesThickness, cropImageOptions.guidelinesThickness);
                cropImageOptions.guidelinesColor = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropGuidelinesColor, cropImageOptions.guidelinesColor);
                cropImageOptions.backgroundColor = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBackgroundColor, cropImageOptions.backgroundColor);
                cropImageOptions.showCropOverlay = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowCropOverlay, this.mShowCropOverlay);
                cropImageOptions.showProgressBar = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowProgressBar, this.mShowProgressBar);
                cropImageOptions.borderCornerThickness = typedArrayObtainStyledAttributes.getDimension(i3, cropImageOptions.borderCornerThickness);
                cropImageOptions.minCropWindowWidth = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowWidth, cropImageOptions.minCropWindowWidth);
                cropImageOptions.minCropWindowHeight = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowHeight, cropImageOptions.minCropWindowHeight);
                cropImageOptions.minCropResultWidth = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultWidthPX, cropImageOptions.minCropResultWidth);
                cropImageOptions.minCropResultHeight = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultHeightPX, cropImageOptions.minCropResultHeight);
                cropImageOptions.maxCropResultWidth = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultWidthPX, cropImageOptions.maxCropResultWidth);
                cropImageOptions.maxCropResultHeight = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultHeightPX, cropImageOptions.maxCropResultHeight);
                int i4 = R$styleable.CropImageView_cropFlipHorizontally;
                cropImageOptions.flipHorizontally = typedArrayObtainStyledAttributes.getBoolean(i4, cropImageOptions.flipHorizontally);
                cropImageOptions.flipVertically = typedArrayObtainStyledAttributes.getBoolean(i4, cropImageOptions.flipVertically);
                this.mSaveBitmapToInstanceState = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropSaveBitmapToInstanceState, this.mSaveBitmapToInstanceState);
                if (typedArrayObtainStyledAttributes.hasValue(i2) && typedArrayObtainStyledAttributes.hasValue(i2) && !typedArrayObtainStyledAttributes.hasValue(i)) {
                    cropImageOptions.fixAspectRatio = true;
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        cropImageOptions.validate();
        this.mScaleType = cropImageOptions.scaleType;
        this.mAutoZoomEnabled = cropImageOptions.autoZoomEnabled;
        this.mMaxZoom = cropImageOptions.maxZoom;
        this.mShowCropOverlay = cropImageOptions.showCropOverlay;
        this.mShowProgressBar = cropImageOptions.showProgressBar;
        this.mFlipHorizontally = cropImageOptions.flipHorizontally;
        this.mFlipVertically = cropImageOptions.flipVertically;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.ImageView_image);
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) viewInflate.findViewById(R$id.CropOverlayView);
        this.mCropOverlayView = cropOverlayView;
        cropOverlayView.setOnMoveCallback(this);
        cropOverlayView.setCropWindowChangeListener(new a());
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        this.mProgressBar = (ProgressBar) viewInflate.findViewById(R$id.CropProgressBar);
        setProgressBarVisibility();
    }

    public Bitmap getCroppedImage(int i, int i2) {
        return getCroppedImage(i, i2, RequestSizeOptions.RESIZE_INSIDE);
    }

    public void getCroppedImageAsync(int i, int i2) {
        getCroppedImageAsync(i, i2, RequestSizeOptions.RESIZE_INSIDE);
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i) {
        saveCroppedImageAsync(uri, compressFormat, i, 0, 0, RequestSizeOptions.NONE);
    }

    public Bitmap getCroppedImage(int i, int i2, RequestSizeOptions requestSizeOptions) {
        int i3;
        Bitmap bitmap;
        if (this.mBitmap == null) {
            return null;
        }
        this.mImageView.clearAnimation();
        RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
        int i4 = requestSizeOptions != requestSizeOptions2 ? i : 0;
        int i5 = requestSizeOptions != requestSizeOptions2 ? i2 : 0;
        if (this.mLoadedImageUri != null && (this.mLoadedSampleSize > 1 || requestSizeOptions == RequestSizeOptions.SAMPLING)) {
            i3 = i4;
            bitmap = com.zenmen.imageeditengine.views.cropimage.c.d(getContext(), this.mLoadedImageUri, getCropPoints(), this.mDegreesRotated, this.mBitmap.getWidth() * this.mLoadedSampleSize, this.mBitmap.getHeight() * this.mLoadedSampleSize, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i4, i5, this.mFlipHorizontally, this.mFlipVertically).f11832a;
        } else {
            i3 = i4;
            bitmap = com.zenmen.imageeditengine.views.cropimage.c.g(this.mBitmap, getCropPoints(), this.mDegreesRotated, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), this.mFlipHorizontally, this.mFlipVertically).f11832a;
        }
        return com.zenmen.imageeditengine.views.cropimage.c.y(bitmap, i3, i5, requestSizeOptions);
    }

    public void getCroppedImageAsync(int i, int i2, RequestSizeOptions requestSizeOptions) {
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i, int i2, int i3) {
        saveCroppedImageAsync(uri, compressFormat, i, i2, i3, RequestSizeOptions.RESIZE_INSIDE);
    }

    public void setImageBitmap(Bitmap bitmap, ExifInterface exifInterface) {
        Bitmap bitmap2;
        int i;
        if (bitmap == null || exifInterface == null) {
            bitmap2 = bitmap;
            i = 0;
        } else {
            c.b bVarB = com.zenmen.imageeditengine.views.cropimage.c.B(bitmap, exifInterface);
            Bitmap bitmap3 = bVarB.f11833a;
            int i2 = bVarB.b;
            this.mInitialDegreesRotated = i2;
            i = i2;
            bitmap2 = bitmap3;
        }
        this.mCropOverlayView.setInitialCropWindowRect(null);
        setBitmap(bitmap2, 0, null, 1, i);
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i, int i2, int i3, RequestSizeOptions requestSizeOptions) {
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void setOnCropImageCompleteListener(b bVar) {
    }

    public void setOnSetCropOverlayMovedListener(c cVar) {
    }

    public void setOnSetCropOverlayReleasedListener(d dVar) {
    }

    public void setOnSetImageUriCompleteListener(f fVar) {
    }

    public void onTouchDown(float f2, float f3) {
    }

    public void onTouchUp(float f2, float f3) {
    }
}
