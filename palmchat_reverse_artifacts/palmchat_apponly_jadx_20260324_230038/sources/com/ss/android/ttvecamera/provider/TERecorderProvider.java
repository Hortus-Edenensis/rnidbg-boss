package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TERecorderProvider extends TECameraProvider {
    private static final String TAG = "TERecorderProvider";
    private float[] mMVPMatrix;
    private Surface mPreviewSurface;
    private Surface mRecorderSurface;
    private SurfaceTexture mSurfaceTexture;
    int mTextureID;

    public TERecorderProvider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        super(providerSettings, tECameraBase);
        this.mMVPMatrix = new float[16];
        this.mSurfaceTexture = providerSettings.mSurfaceTexture;
        this.mTextureID = providerSettings.mTextureOES;
        this.mPreviewSurface = new Surface(providerSettings.mSurfaceTexture);
        this.mRecorderSurface = providerSettings.mRecorderSurface;
        Log.d(TAG, "constructor");
    }

    private void initOnFrameAvailableListener(@NonNull SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.mSurfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, this.mCamera.getHandler());
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getRecorderSurface() {
        return this.mRecorderSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        Log.d(TAG, "get preview surface");
        return this.mPreviewSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 16;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        if (list != null && list.size() > 0) {
            this.mSize = TECameraUtils.calcPreviewSize(list, this.mSize);
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        TEFrameSizei tEFrameSizei2 = this.mSize;
        surfaceTexture.setDefaultBufferSize(tEFrameSizei2.width, tEFrameSizei2.height);
        initOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.ss.android.ttvecamera.provider.TERecorderProvider.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                TERecorderProvider tERecorderProvider = TERecorderProvider.this;
                if (tERecorderProvider.mCamera == null) {
                    return;
                }
                surfaceTexture2.getTransformMatrix(tERecorderProvider.mMVPMatrix);
                TEFrameSizei tEFrameSizei3 = TERecorderProvider.this.mSize;
                TECameraFrame tECameraFrame = new TECameraFrame(tEFrameSizei3.width, tEFrameSizei3.height, surfaceTexture2.getTimestamp());
                TERecorderProvider tERecorderProvider2 = TERecorderProvider.this;
                int i = tERecorderProvider2.mTextureID;
                int frameRotation = tERecorderProvider2.mCamera.getFrameRotation();
                float[] fArr = TERecorderProvider.this.mMVPMatrix;
                TERecorderProvider tERecorderProvider3 = TERecorderProvider.this;
                tECameraFrame.initTextureFrame(i, frameRotation, fArr, tERecorderProvider3.mFormat, tERecorderProvider3.mCamera.getFacing());
                TERecorderProvider.this.onFrameCaptured(tECameraFrame);
            }
        });
        return 0;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
        Surface surface = this.mPreviewSurface;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureID);
        this.mPreviewSurface = new Surface(this.mSurfaceTexture);
        this.mListener.onNewSurfaceTexture(this.mSurfaceTexture);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        Surface surface = this.mPreviewSurface;
        if (surface != null) {
            surface.release();
            this.mPreviewSurface = null;
        }
        Surface surface2 = this.mRecorderSurface;
        if (surface2 != null) {
            surface2.release();
            this.mRecorderSurface = null;
        }
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    @RequiresApi(api = 21)
    public int init(@NonNull StreamConfigurationMap streamConfigurationMap, TEFrameSizei tEFrameSizei) {
        return init(TECameraProvider.convertSizes(streamConfigurationMap.getOutputSizes(SurfaceTexture.class)), tEFrameSizei);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
    }
}
