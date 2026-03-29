package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TEPlane;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 19)
public class TEImageReaderProvider extends TECameraProvider {
    ImageReader mImageReader;

    public TEImageReaderProvider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        super(providerSettings, tECameraBase);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            return imageReader.getSurface();
        }
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 2;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        if (list != null && list.size() > 0) {
            this.mSize = TECameraUtils.calcPreviewSize(list, this.mSize);
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            imageReader.close();
        }
        TEFrameSizei tEFrameSizei2 = this.mSize;
        ImageReader imageReaderNewInstance = ImageReader.newInstance(tEFrameSizei2.width, tEFrameSizei2.height, TECameraFrame.pixelFormat2ImageFormat(this.mFormat), 1);
        this.mImageReader = imageReaderNewInstance;
        imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.ss.android.ttvecamera.provider.TEImageReaderProvider.1
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader2) {
                Image imageAcquireLatestImage = imageReader2.acquireLatestImage();
                try {
                    if (imageAcquireLatestImage == null) {
                        return;
                    }
                    try {
                        TECameraFrame tECameraFrame = new TECameraFrame(imageAcquireLatestImage.getWidth(), imageAcquireLatestImage.getHeight(), System.currentTimeMillis() * 1000);
                        TEPlane tEPlane = new TEPlane(imageAcquireLatestImage.getPlanes());
                        int frameRotation = TEImageReaderProvider.this.mCamera.getFrameRotation();
                        TEImageReaderProvider tEImageReaderProvider = TEImageReaderProvider.this;
                        tECameraFrame.initYUVPlans(tEPlane, frameRotation, tEImageReaderProvider.mFormat, tEImageReaderProvider.mCamera.getFacing());
                        TEImageReaderProvider.this.onFrameCaptured(tECameraFrame);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    imageAcquireLatestImage.close();
                }
            }
        }, this.mCamera.getHandler());
        return 0;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            imageReader.close();
            this.mImageReader = null;
        }
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    @RequiresApi(api = 21)
    public int init(@NonNull StreamConfigurationMap streamConfigurationMap, TEFrameSizei tEFrameSizei) {
        int[] outputFormats = streamConfigurationMap.getOutputFormats();
        int iPixelFormat2ImageFormat = TECameraFrame.pixelFormat2ImageFormat(this.mFormat);
        int length = outputFormats.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = outputFormats[i2];
            if (i3 == iPixelFormat2ImageFormat) {
                i = i3;
                break;
            }
            i2++;
        }
        if (i == 0) {
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            i = 35;
        }
        return init(TECameraProvider.convertSizes(streamConfigurationMap.getOutputSizes(i)), tEFrameSizei);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
    }
}
