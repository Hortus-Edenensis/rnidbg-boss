package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.lantern.auth.app.FunDC;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.provider.TECameraProvider;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraProviderManager {
    public static final String TAG = "TECameraProviderManager";
    private TECameraProvider mProvider;

    public void createProvider(@NonNull ProviderSettings providerSettings, @NonNull TECameraBase tECameraBase) {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            tECameraProvider.release();
        }
        TECameraFrame.ETEPixelFormat eTEPixelFormat = providerSettings.mFormat;
        if (eTEPixelFormat == TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Recorder) {
            this.mProvider = new TERecorderProvider(providerSettings, tECameraBase);
        } else if (eTEPixelFormat == TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES) {
            this.mProvider = new TESurfaceTextureProvider(providerSettings, tECameraBase);
        } else if (!(tECameraBase instanceof TECamera2)) {
            this.mProvider = new TECallbackWithBufferProvider(providerSettings, tECameraBase);
        } else if (providerSettings.mImageReaderCount > 0) {
            this.mProvider = new TEMultiCamera2Provider(providerSettings, tECameraBase);
        } else {
            this.mProvider = new TEImageReaderProvider(providerSettings, tECameraBase);
        }
        tECameraBase.setProviderManager(this);
    }

    public TEFrameSizei getPictureSize() {
        return !this.mProvider.isPreview() ? this.mProvider.mSize : new TEFrameSizei(FunDC.ID_AUTH_1080, TECameraUtils.CAPTURE_NORMAL);
    }

    public TEFrameSizei getPreviewSize() {
        if (this.mProvider.isPreview()) {
            return this.mProvider.getSize();
        }
        return null;
    }

    public Surface getPreviewSurface() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            return tECameraProvider.getSurface();
        }
        return null;
    }

    public Surface[] getPreviewSurfaces() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            return tECameraProvider.getSurfaces();
        }
        return null;
    }

    public TECameraProvider getProvider() {
        return this.mProvider;
    }

    public int getProviderType() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            return tECameraProvider.getType();
        }
        return 0;
    }

    public SurfaceTexture getSurfaceTexture() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            return tECameraProvider.getSurfaceTexture();
        }
        return null;
    }

    public Surface getVideoSurface() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            return tECameraProvider.getRecorderSurface();
        }
        return null;
    }

    public int initProvider(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        TECameraProvider tECameraProvider = this.mProvider;
        return tECameraProvider != null ? tECameraProvider.init(list, tEFrameSizei) : TECameraResult.TER_INVALID_HANDLER;
    }

    public void removeProvider() {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider != null) {
            tECameraProvider.release();
            this.mProvider = null;
        }
    }

    public void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack previewSizeCallBack) {
        TECameraProvider tECameraProvider = this.mProvider;
        if (tECameraProvider == null) {
            TELogUtils.e(TAG, "provider is null!");
        } else {
            tECameraProvider.setPreviewSizeCallback(previewSizeCallBack);
        }
    }

    public int initProvider(@NonNull Camera.Parameters parameters, TEFrameSizei tEFrameSizei) {
        TECameraProvider tECameraProvider = this.mProvider;
        return (tECameraProvider == null || tECameraProvider == null) ? TECameraResult.TER_INVALID_HANDLER : tECameraProvider.init(parameters, tEFrameSizei);
    }

    public int initProvider(@NonNull StreamConfigurationMap streamConfigurationMap, TEFrameSizei tEFrameSizei) {
        TECameraProvider tECameraProvider = this.mProvider;
        return (tECameraProvider == null || tECameraProvider == null) ? TECameraResult.TER_INVALID_HANDLER : tECameraProvider.init(streamConfigurationMap, tEFrameSizei);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ProviderSettings {
        public TECameraFrame.ETEPixelFormat mFormat;
        public int mImageReaderCount;
        public boolean mIsPreview;
        public TECameraProvider.CaptureListener mListener;
        public Surface mRecorderSurface;
        public TEFrameSizei mSize;
        public SurfaceTexture mSurfaceTexture;
        public int mTextureOES;

        public ProviderSettings(TEFrameSizei tEFrameSizei, @NonNull TECameraProvider.CaptureListener captureListener, boolean z, SurfaceTexture surfaceTexture, int i) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mSize = tEFrameSizei;
            this.mListener = captureListener;
            this.mSurfaceTexture = surfaceTexture;
            this.mTextureOES = i;
            this.mIsPreview = z;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES;
        }

        public void copyFrom(@NonNull ProviderSettings providerSettings) {
            this.mIsPreview = providerSettings.mIsPreview;
            this.mSize = providerSettings.mSize;
            this.mListener = providerSettings.mListener;
            this.mSurfaceTexture = providerSettings.mSurfaceTexture;
            this.mTextureOES = providerSettings.mTextureOES;
            this.mImageReaderCount = providerSettings.mImageReaderCount;
        }

        public boolean isSame(ProviderSettings providerSettings) {
            if (providerSettings != null && this.mIsPreview == providerSettings.mIsPreview) {
                TEFrameSizei tEFrameSizei = this.mSize;
                int i = tEFrameSizei.width;
                TEFrameSizei tEFrameSizei2 = providerSettings.mSize;
                if (i == tEFrameSizei2.width && tEFrameSizei.height == tEFrameSizei2.height && this.mListener == providerSettings.mListener && this.mSurfaceTexture == providerSettings.mSurfaceTexture && this.mTextureOES == providerSettings.mTextureOES && this.mImageReaderCount == providerSettings.mImageReaderCount) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "ProviderSettings: [mIsPreview = " + this.mIsPreview + ", mSize = " + this.mSize + ", mListener = " + this.mListener + ", mSurfaceTexture = " + this.mSurfaceTexture + ", mTextureOES = " + this.mTextureOES + ", mImageReaderCount = " + this.mImageReaderCount + "]";
        }

        public ProviderSettings(TEFrameSizei tEFrameSizei, @NonNull TECameraProvider.CaptureListener captureListener, boolean z, SurfaceTexture surfaceTexture, int i, Surface surface) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mSize = tEFrameSizei;
            this.mListener = captureListener;
            this.mSurfaceTexture = surfaceTexture;
            this.mTextureOES = i;
            this.mIsPreview = z;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Recorder;
            this.mRecorderSurface = surface;
        }

        public ProviderSettings(TEFrameSizei tEFrameSizei, @NonNull TECameraProvider.CaptureListener captureListener, boolean z, SurfaceTexture surfaceTexture, TECameraFrame.ETEPixelFormat eTEPixelFormat) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            TECameraFrame.ETEPixelFormat eTEPixelFormat2 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mSize = tEFrameSizei;
            this.mListener = captureListener;
            this.mSurfaceTexture = surfaceTexture;
            this.mIsPreview = z;
            this.mFormat = eTEPixelFormat;
        }

        public ProviderSettings(TEFrameSizei tEFrameSizei, @NonNull TECameraProvider.CaptureListener captureListener, boolean z, TECameraFrame.ETEPixelFormat eTEPixelFormat) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            TECameraFrame.ETEPixelFormat eTEPixelFormat2 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mSize = tEFrameSizei;
            this.mListener = captureListener;
            this.mFormat = eTEPixelFormat;
            this.mIsPreview = z;
        }

        public ProviderSettings(TEFrameSizei tEFrameSizei, @NonNull TECameraProvider.CaptureListener captureListener, boolean z, SurfaceTexture surfaceTexture, TECameraFrame.ETEPixelFormat eTEPixelFormat, int i) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            TECameraFrame.ETEPixelFormat eTEPixelFormat2 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mSize = tEFrameSizei;
            this.mListener = captureListener;
            this.mSurfaceTexture = surfaceTexture;
            this.mIsPreview = z;
            this.mFormat = eTEPixelFormat;
            this.mImageReaderCount = i;
        }

        public ProviderSettings(@NonNull ProviderSettings providerSettings) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mIsPreview = providerSettings.mIsPreview;
            this.mSize = providerSettings.mSize;
            this.mListener = providerSettings.mListener;
            this.mSurfaceTexture = providerSettings.mSurfaceTexture;
            this.mTextureOES = providerSettings.mTextureOES;
            this.mImageReaderCount = providerSettings.mImageReaderCount;
        }
    }
}
