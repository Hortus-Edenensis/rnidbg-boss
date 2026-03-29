package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.provider.TECameraProvider;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TESurfaceTextureProvider extends TECameraProvider {
    float[] mMVPMatrix;
    SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener;
    Surface mSurface;
    SurfaceTexture mSurfaceTexture;
    int mTextureID;

    public TESurfaceTextureProvider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        super(providerSettings, tECameraBase);
        this.mMVPMatrix = new float[16];
        this.mOnFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.ss.android.ttvecamera.provider.TESurfaceTextureProvider.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                TESurfaceTextureProvider tESurfaceTextureProvider = TESurfaceTextureProvider.this;
                if (tESurfaceTextureProvider.mCamera == null) {
                    return;
                }
                surfaceTexture.getTransformMatrix(tESurfaceTextureProvider.mMVPMatrix);
                TEFrameSizei tEFrameSizei = TESurfaceTextureProvider.this.mSize;
                TECameraFrame tECameraFrame = new TECameraFrame(tEFrameSizei.width, tEFrameSizei.height, surfaceTexture.getTimestamp());
                TESurfaceTextureProvider tESurfaceTextureProvider2 = TESurfaceTextureProvider.this;
                int i = tESurfaceTextureProvider2.mTextureID;
                int frameRotation = tESurfaceTextureProvider2.mCamera.getFrameRotation();
                TESurfaceTextureProvider tESurfaceTextureProvider3 = TESurfaceTextureProvider.this;
                tECameraFrame.initTextureFrame(i, frameRotation, tESurfaceTextureProvider3.mMVPMatrix, tESurfaceTextureProvider3.mFormat, tESurfaceTextureProvider3.mCamera.getFacing());
                tECameraFrame.setMetadata(TESurfaceTextureProvider.this.mMetadata);
                TESurfaceTextureProvider.this.onFrameCaptured(tECameraFrame);
            }
        };
        this.mSurfaceTexture = providerSettings.mSurfaceTexture;
        this.mTextureID = providerSettings.mTextureOES;
        this.mSurface = new Surface(this.mSurfaceTexture);
    }

    private void initOnFrameAvailableListener(@NonNull SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.mSurfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, this.mCamera.getHandler());
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getTextureID() {
        return this.mTextureID;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 1;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    @RequiresApi(api = 15)
    public int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        TEFrameSizei previewSize;
        if (list != null && list.size() > 0) {
            TECameraBase.PreviewSizeCallBack previewSizeCallBack = this.mPreviewSizeCallback;
            if (previewSizeCallBack == null || (previewSize = previewSizeCallBack.getPreviewSize(list)) == null) {
                this.mSize = TECameraUtils.calcPreviewSize(list, this.mSize);
            } else {
                this.mSize = previewSize;
            }
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        TEFrameSizei tEFrameSizei2 = this.mSize;
        surfaceTexture.setDefaultBufferSize(tEFrameSizei2.width, tEFrameSizei2.height);
        initOnFrameAvailableListener(this.mOnFrameAvailableListener);
        return 0;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureID);
        this.mSurface = new Surface(this.mSurfaceTexture);
        this.mListener.onNewSurfaceTexture(this.mSurfaceTexture);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        this.mSurfaceTexture = surfaceTexture;
        this.mSurface = new Surface(this.mSurfaceTexture);
        initOnFrameAvailableListener(this.mOnFrameAvailableListener);
        TECameraProvider.CaptureListener captureListener = this.mListener;
        if (captureListener == null || !(captureListener instanceof TECameraProvider.CaptureListenerWithAR)) {
            return;
        }
        ((TECameraProvider.CaptureListenerWithAR) captureListener).onNewSurfaceTexture(this.mSurfaceTexture, z);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void triggerSurfaceTextureOnFrameAvailable() {
        super.triggerSurfaceTextureOnFrameAvailable();
        this.mOnFrameAvailableListener.onFrameAvailable(this.mSurfaceTexture);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    @RequiresApi(api = 21)
    public int init(@NonNull StreamConfigurationMap streamConfigurationMap, TEFrameSizei tEFrameSizei) {
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (this.mCamera.getCameraSettings().mEnableRecordStream) {
            return init(TECameraUtils.getSameFrameSize(TECameraProvider.convertSizes(outputSizes), TECameraProvider.convertSizes(streamConfigurationMap.getOutputSizes(MediaRecorder.class))), tEFrameSizei);
        }
        return init(TECameraProvider.convertSizes(outputSizes), tEFrameSizei);
    }
}
