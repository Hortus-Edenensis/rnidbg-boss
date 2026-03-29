package com.ss.bytertc.engine.video.impl;

import android.opengl.EGLContext;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.ColorSpace;
import com.ss.bytertc.engine.data.VideoContentType;
import com.ss.bytertc.engine.data.VideoFrameType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.video.VideoFrame;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WebrtcWrapperVideoFrame extends VideoFrame {
    private final NativeBufferVideoFrame cppFrameWrapper;
    private final EGLContext eglContext;
    private VideoFrameType frameType;
    private VideoPixelFormat pixelFormat;
    private VideoFrame.Buffer videoBuffer;
    private final com.bytedance.realx.video.VideoFrame webrtcVideoFrame;

    @CalledByNative
    public WebrtcWrapperVideoFrame(VideoFrame.Buffer buffer, EGLContext eGLContext, long j) {
        this.videoBuffer = null;
        this.cppFrameWrapper = new NativeBufferVideoFrame(j);
        this.webrtcVideoFrame = null;
        this.eglContext = eGLContext;
        setReleaseCallback(new Runnable() { // from class: xj6
            @Override // java.lang.Runnable
            public final void run() {
                this.f21990a.lambda$new$0();
            }
        });
        init(buffer, eGLContext);
    }

    private void init(VideoFrame.Buffer buffer, EGLContext eGLContext) {
        if (buffer.getBufferType() != 4) {
            this.frameType = VideoFrameType.RAW_MEMORY;
            this.videoBuffer = buffer.toI420();
            this.pixelFormat = VideoPixelFormat.I420;
            return;
        }
        this.frameType = VideoFrameType.GL_TEXTURE;
        this.videoBuffer = buffer;
        buffer.retain();
        if (((VideoFrame.TextureBuffer) this.videoBuffer).getType() == VideoFrame.TextureBuffer.Type.RGB) {
            this.pixelFormat = VideoPixelFormat.TEXTURE_2D;
        } else {
            this.pixelFormat = VideoPixelFormat.TEXTURE_OES;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.cppFrameWrapper.release();
        VideoFrame.Buffer buffer = this.videoBuffer;
        if (buffer != null) {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(com.bytedance.realx.video.VideoFrame videoFrame) {
        videoFrame.release();
        VideoFrame.Buffer buffer = this.videoBuffer;
        if (buffer != null) {
            buffer.release();
        }
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public CameraId getCameraId() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getCameraId();
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public ColorSpace getColorSpace() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getColorSpace();
        }
        if (this.webrtcVideoFrame != null) {
            return ColorSpace.BT601_LIMITED_RANGE;
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public VideoContentType getContentType() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        return nativeBufferVideoFrame != null ? nativeBufferVideoFrame.getContentType() : VideoContentType.NORMAL_FRAME;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public ByteBuffer getExternalDataInfo() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getExternalDataInfo();
        }
        com.bytedance.realx.video.VideoFrame videoFrame = this.webrtcVideoFrame;
        if (videoFrame != null) {
            return videoFrame.getExtendedData();
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public VideoFrameType getFrameType() {
        return this.frameType;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public int getHeight() {
        VideoFrame.Buffer buffer = this.videoBuffer;
        if (buffer != null) {
            return buffer.getHeight();
        }
        return 0;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public int getNumberOfPlanes() {
        return this.pixelFormat == VideoPixelFormat.I420 ? 3 : 0;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public VideoPixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public ByteBuffer getPlaneData(int i) {
        VideoFrame.Buffer buffer;
        if (this.frameType == VideoFrameType.GL_TEXTURE || (buffer = this.videoBuffer) == null) {
            return null;
        }
        VideoFrame.I420Buffer i420Buffer = (VideoFrame.I420Buffer) buffer;
        if (i == 0) {
            return i420Buffer.getDataY();
        }
        if (i == 1) {
            return i420Buffer.getDataU();
        }
        if (i == 2) {
            return i420Buffer.getDataV();
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public int getPlaneStride(int i) {
        VideoFrame.Buffer buffer;
        if (this.frameType == VideoFrameType.GL_TEXTURE || (buffer = this.videoBuffer) == null) {
            return 0;
        }
        VideoFrame.I420Buffer i420Buffer = (VideoFrame.I420Buffer) buffer;
        if (i == 0) {
            return i420Buffer.getStrideY();
        }
        if (i == 1) {
            return i420Buffer.getStrideU();
        }
        if (i == 2) {
            return i420Buffer.getStrideV();
        }
        return 0;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public VideoRotation getRotation() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getRotation();
        }
        com.bytedance.realx.video.VideoFrame videoFrame = this.webrtcVideoFrame;
        if (videoFrame != null) {
            return VideoRotation.fromId(videoFrame.getRotation());
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public ByteBuffer getSupplementaryInfo() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getSupplementaryInfo();
        }
        return null;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public int getTextureID() {
        VideoFrame.Buffer buffer;
        if (this.frameType == VideoFrameType.RAW_MEMORY || (buffer = this.videoBuffer) == null) {
            return 0;
        }
        return ((VideoFrame.TextureBuffer) buffer).getTextureId();
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public float[] getTextureMatrix() {
        VideoFrame.Buffer buffer;
        if (this.frameType == VideoFrameType.RAW_MEMORY || (buffer = this.videoBuffer) == null) {
            return null;
        }
        return ((VideoFrame.TextureBuffer) buffer).nativeGetTransFormMatrix();
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public long getTimeStampUs() {
        NativeBufferVideoFrame nativeBufferVideoFrame = this.cppFrameWrapper;
        if (nativeBufferVideoFrame != null) {
            return nativeBufferVideoFrame.getTimeStampUs();
        }
        com.bytedance.realx.video.VideoFrame videoFrame = this.webrtcVideoFrame;
        if (videoFrame != null) {
            return videoFrame.getTimestampNs() / 1000;
        }
        return 0L;
    }

    @Override // com.ss.bytertc.engine.video.VideoFrame
    public int getWidth() {
        VideoFrame.Buffer buffer = this.videoBuffer;
        if (buffer != null) {
            return buffer.getWidth();
        }
        return 0;
    }

    public WebrtcWrapperVideoFrame(final com.bytedance.realx.video.VideoFrame videoFrame, EGLContext eGLContext) {
        this.videoBuffer = null;
        this.cppFrameWrapper = null;
        this.webrtcVideoFrame = videoFrame;
        this.eglContext = eGLContext;
        videoFrame.retain();
        setReleaseCallback(new Runnable() { // from class: yj6
            @Override // java.lang.Runnable
            public final void run() {
                this.f22210a.lambda$new$1(videoFrame);
            }
        });
        init(videoFrame.getBuffer(), eGLContext);
    }
}
