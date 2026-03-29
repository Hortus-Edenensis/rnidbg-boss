package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class TECameraProvider {
    public static final int PROVIDER_TYPE_BUFFER_CALLBACK = 4;
    public static final int PROVIDER_TYPE_IMAGE_READER = 2;
    public static final int PROVIDER_TYPE_RECORDER = 16;
    public static final int PROVIDER_TYPE_SURFACE_AND_IMAGE = 8;
    public static final int PROVIDER_TYPE_SURFACE_TEXTURE = 1;
    public static final int PROVIDER_TYPE_UNKNOWN = 0;
    TECameraBase mCamera;
    TECameraFrame.ETEPixelFormat mFormat;
    public int mImageReaderCount;
    boolean mIsPreview;
    CaptureListener mListener;
    public TECameraFrame.Metadata mMetadata;
    TEFrameSizei mSize;
    protected TECameraBase.PreviewSizeCallBack mPreviewSizeCallback = null;
    private CaptureListener mEmptyCaptureListener = new CaptureListener() { // from class: com.ss.android.ttvecamera.provider.TECameraProvider.1
        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onFrameCaptured(TECameraFrame tECameraFrame) {
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onNewSurfaceTexture(SurfaceTexture surfaceTexture) {
        }
    };
    private CaptureListener mEmptyCaptureListenerWithAR = new CaptureListenerWithAR() { // from class: com.ss.android.ttvecamera.provider.TECameraProvider.2
        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListenerWithAR, com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onNewSurfaceTexture(SurfaceTexture surfaceTexture) {
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListenerWithAR
        public void onNewSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListenerWithAR
        public void onExtFrameDataAttached(Object obj) {
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListenerWithAR, com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onFrameCaptured(TECameraFrame tECameraFrame) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface CaptureListener {
        void onFrameCaptured(TECameraFrame tECameraFrame);

        void onNewSurfaceTexture(SurfaceTexture surfaceTexture);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CaptureListenerWithAR extends CaptureListener {
        void onExtFrameDataAttached(Object obj);

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        void onFrameCaptured(TECameraFrame tECameraFrame);

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        void onNewSurfaceTexture(SurfaceTexture surfaceTexture);

        void onNewSurfaceTexture(SurfaceTexture surfaceTexture, boolean z);
    }

    public TECameraProvider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        this.mSize = new TEFrameSizei();
        this.mIsPreview = true;
        this.mImageReaderCount = 1;
        this.mFormat = providerSettings.mFormat;
        this.mListener = providerSettings.mListener;
        this.mSize = providerSettings.mSize;
        this.mCamera = tECameraBase;
        this.mIsPreview = providerSettings.mIsPreview;
        this.mImageReaderCount = providerSettings.mImageReaderCount;
    }

    public static List<TEFrameSizei> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            arrayList.add(new TEFrameSizei(size.width, size.height));
        }
        return arrayList;
    }

    public TECameraFrame.Metadata getMetadata() {
        return this.mMetadata;
    }

    public Surface getRecorderSurface() {
        return null;
    }

    public TEFrameSizei getSize() {
        return this.mSize;
    }

    public abstract Surface getSurface();

    public abstract SurfaceTexture getSurfaceTexture();

    public Surface[] getSurfaces() {
        return null;
    }

    public int getTextureID() {
        return -1;
    }

    public abstract int getType();

    public int init(@NonNull StreamConfigurationMap streamConfigurationMap, TEFrameSizei tEFrameSizei) {
        return -1;
    }

    public abstract int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei);

    public boolean isPreview() {
        return this.mIsPreview;
    }

    public void onExtFrameDataAttached(Object obj) {
        CaptureListener captureListener = this.mListener;
        if (captureListener == null || !(captureListener instanceof CaptureListenerWithAR)) {
            return;
        }
        ((CaptureListenerWithAR) captureListener).onExtFrameDataAttached(obj);
    }

    public void onFrameCaptured(TECameraFrame tECameraFrame) {
        CaptureListener captureListener = this.mListener;
        if (captureListener != null) {
            captureListener.onFrameCaptured(tECameraFrame);
        }
    }

    public abstract void reAllocateSurfaceTexture();

    public void release() {
        if (this.mListener instanceof CaptureListenerWithAR) {
            this.mListener = this.mEmptyCaptureListenerWithAR;
        } else {
            this.mListener = this.mEmptyCaptureListener;
        }
    }

    public void setFormat(TECameraFrame.ETEPixelFormat eTEPixelFormat) {
        this.mFormat = eTEPixelFormat;
    }

    public void setMetadata(TECameraFrame.Metadata metadata) {
        this.mMetadata = metadata;
    }

    public void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack previewSizeCallBack) {
        this.mPreviewSizeCallback = previewSizeCallBack;
    }

    public void setSize(int i, int i2) {
        TEFrameSizei tEFrameSizei = this.mSize;
        tEFrameSizei.width = i;
        tEFrameSizei.height = i2;
    }

    public abstract void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z);

    public int init(@NonNull Camera.Parameters parameters, TEFrameSizei tEFrameSizei) {
        return init(convertSizes(parameters.getSupportedPreviewSizes()), tEFrameSizei);
    }

    @RequiresApi(api = 21)
    public static List<TEFrameSizei> convertSizes(Size[] sizeArr) {
        if (sizeArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    public void triggerSurfaceTextureOnFrameAvailable() {
    }
}
