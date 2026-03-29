package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECallbackWithBufferProvider extends TECameraProvider {
    private static final int MAX_PREVIEW_DATA_CHECK_TIMES = 3;
    private static final String TAG = "TECallbackWithBufferProvider";
    private byte[][] mCallbackBytebuffer;
    private int mCallbackBytebufferSize;
    Camera.PreviewCallback mPreviewCallback;
    private int mPreviewCheckTimes;
    private SurfaceTexture mSurfaceTexture;

    public TECallbackWithBufferProvider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        super(providerSettings, tECameraBase);
        this.mPreviewCheckTimes = 0;
        this.mCallbackBytebuffer = null;
        this.mCallbackBytebufferSize = 0;
        this.mSurfaceTexture = providerSettings.mSurfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPreviewData(byte[] bArr) {
        TEFrameSizei tEFrameSizei;
        int i;
        boolean z;
        int length = bArr != null ? bArr.length : 0;
        if (length > 0 && (tEFrameSizei = this.mSize) != null && (i = this.mPreviewCheckTimes) < 3) {
            this.mPreviewCheckTimes = i + 1;
            int i2 = tEFrameSizei.width * tEFrameSizei.height;
            if (i2 > length) {
                TELogUtils.e(TAG, "checkPreviewData failed: mSize: " + this.mSize + ", length: " + length);
                return false;
            }
            int i3 = i2 / 300;
            int i4 = i3 / 2;
            byte b = bArr[0];
            byte b2 = bArr[i2];
            for (int i5 = 0; i5 < 300; i5++) {
                int i6 = i5 * i3;
                int i7 = (i5 * i4) + i2;
                if (i6 >= length || i7 >= length) {
                    break;
                }
                if (b != bArr[i6] || b2 != bArr[i7]) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public byte[][] getBuffers(int i) {
        TEFrameSizei tEFrameSizei = this.mSize;
        int i2 = ((tEFrameSizei.width * tEFrameSizei.height) * 3) / 2;
        String str = TAG;
        TELogUtils.d(str, "getBuffers current bufferSize: " + i2 + " mCallbackBytebufferSize:" + this.mCallbackBytebufferSize);
        int i3 = this.mCallbackBytebufferSize;
        if (i2 > i3 || i3 == 0) {
            this.mCallbackBytebuffer = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, i2);
            TELogUtils.d(str, "new mCallbackBytebuffer size :" + i2);
            this.mCallbackBytebufferSize = i2;
        }
        return this.mCallbackBytebuffer;
    }

    public Camera.PreviewCallback getPreviewCallback() {
        return this.mPreviewCallback;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 4;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    @RequiresApi(api = 15)
    public int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        if (list != null && list.size() > 0) {
            this.mSize = TECameraUtils.calcPreviewSize(list, tEFrameSizei);
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            TEFrameSizei tEFrameSizei2 = this.mSize;
            surfaceTexture.setDefaultBufferSize(tEFrameSizei2.width, tEFrameSizei2.height);
        }
        this.mPreviewCallback = new Camera.PreviewCallback() { // from class: com.ss.android.ttvecamera.provider.TECallbackWithBufferProvider.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                if (TECallbackWithBufferProvider.this.checkPreviewData(bArr)) {
                    TEFrameSizei tEFrameSizei3 = TECallbackWithBufferProvider.this.mSize;
                    TECameraFrame tECameraFrame = new TECameraFrame(tEFrameSizei3.width, tEFrameSizei3.height, System.currentTimeMillis() * 1000);
                    tECameraFrame.initBufferFrame(bArr, TECallbackWithBufferProvider.this.mCamera.getFrameRotation(), TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21, TECallbackWithBufferProvider.this.mCamera.getCameraSettings().mFacing);
                    TECallbackWithBufferProvider.this.onFrameCaptured(tECameraFrame);
                }
                if (camera != null) {
                    camera.addCallbackBuffer(bArr);
                }
            }
        };
        return 0;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(@NonNull Camera.Parameters parameters, TEFrameSizei tEFrameSizei) {
        return init(TECameraProvider.convertSizes(parameters.getSupportedPreviewSizes()), tEFrameSizei);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
    }
}
