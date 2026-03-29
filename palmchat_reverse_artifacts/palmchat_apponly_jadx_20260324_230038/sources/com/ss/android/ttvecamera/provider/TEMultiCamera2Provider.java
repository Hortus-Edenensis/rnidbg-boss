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
import com.ss.android.ttvecamera.provider.TECameraProvider;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 19)
public class TEMultiCamera2Provider extends TECameraProvider {
    ImageReader[] mImageReaders;
    float[] mMVPMatrix;
    Surface[] mSurface;
    SurfaceTexture mSurfaceTexture;
    int mTextureID;

    public TEMultiCamera2Provider(TECameraProviderManager.ProviderSettings providerSettings, TECameraBase tECameraBase) {
        super(providerSettings, tECameraBase);
        this.mMVPMatrix = new float[16];
        SurfaceTexture surfaceTexture = providerSettings.mSurfaceTexture;
        this.mSurfaceTexture = surfaceTexture;
        this.mTextureID = providerSettings.mTextureOES;
        int i = this.mImageReaderCount;
        this.mImageReaders = new ImageReader[i];
        Surface[] surfaceArr = new Surface[surfaceTexture != null ? i + 1 : i];
        this.mSurface = surfaceArr;
        if (surfaceTexture != null) {
            surfaceArr[0] = new Surface(this.mSurfaceTexture);
        }
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        Surface[] surfaceArr = this.mSurface;
        if (surfaceArr != null) {
            return surfaceArr[0];
        }
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface[] getSurfaces() {
        return this.mSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getTextureID() {
        return this.mSurfaceTexture != null ? this.mTextureID : super.getTextureID();
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 8;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        if (list != null && list.size() > 0) {
            this.mSize = TECameraUtils.calcPreviewSize(list, this.mSize);
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            TEFrameSizei tEFrameSizei2 = this.mSize;
            surfaceTexture.setDefaultBufferSize(tEFrameSizei2.width, tEFrameSizei2.height);
        }
        for (int i = 0; i < this.mImageReaderCount; i++) {
            ImageReader[] imageReaderArr = this.mImageReaders;
            TEFrameSizei tEFrameSizei3 = this.mSize;
            imageReaderArr[i] = ImageReader.newInstance(tEFrameSizei3.width, tEFrameSizei3.height, TECameraFrame.pixelFormat2ImageFormat(this.mFormat), 1);
            this.mImageReaders[i].setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.ss.android.ttvecamera.provider.TEMultiCamera2Provider.1
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    Image imageAcquireNextImage = imageReader.acquireNextImage();
                    if (imageAcquireNextImage == null) {
                        return;
                    }
                    TECameraFrame tECameraFrame = new TECameraFrame(imageAcquireNextImage.getWidth(), imageAcquireNextImage.getHeight(), System.currentTimeMillis() * 1000);
                    TEPlane tEPlane = new TEPlane(imageAcquireNextImage.getPlanes());
                    int frameRotation = TEMultiCamera2Provider.this.mCamera.getFrameRotation();
                    TEMultiCamera2Provider tEMultiCamera2Provider = TEMultiCamera2Provider.this;
                    tECameraFrame.initYUVPlans(tEPlane, frameRotation, tEMultiCamera2Provider.mFormat, tEMultiCamera2Provider.mCamera.getFacing());
                    TEMultiCamera2Provider.this.onFrameCaptured(tECameraFrame);
                    imageAcquireNextImage.close();
                }
            }, this.mCamera.getHandler());
            if (this.mSurfaceTexture != null) {
                this.mSurface[i + 1] = this.mImageReaders[i].getSurface();
            } else {
                this.mSurface[i] = this.mImageReaders[i].getSurface();
            }
        }
        return 0;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        Surface[] surfaceArr;
        Surface surface;
        super.release();
        ImageReader[] imageReaderArr = this.mImageReaders;
        if (imageReaderArr != null) {
            for (ImageReader imageReader : imageReaderArr) {
                if (imageReader != null) {
                    imageReader.close();
                }
            }
            this.mImageReaders = null;
        }
        if (this.mSurfaceTexture == null || (surfaceArr = this.mSurface) == null || (surface = surfaceArr[0]) == null) {
            return;
        }
        surface.release();
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture surfaceTexture, boolean z) {
        Surface surface;
        if (this.mSurfaceTexture == null) {
            return;
        }
        Surface[] surfaceArr = this.mSurface;
        if (surfaceArr != null && (surface = surfaceArr[0]) != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        this.mSurfaceTexture = surfaceTexture;
        this.mSurface[0] = new Surface(this.mSurfaceTexture);
        TECameraProvider.CaptureListener captureListener = this.mListener;
        if (captureListener == null || !(captureListener instanceof TECameraProvider.CaptureListenerWithAR)) {
            return;
        }
        ((TECameraProvider.CaptureListenerWithAR) captureListener).onNewSurfaceTexture(this.mSurfaceTexture, z);
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
}
