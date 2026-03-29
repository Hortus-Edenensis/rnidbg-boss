package com.ss.bytertc.engine.utils;

import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.data.VideoFrameType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.video.builder.GLTextureVideoFrameBuilder;
import defpackage.sb6;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoFrameConverter {
    private static final String TAG = "VideoFrameConverter";
    private long gl420ConverterNativeHandle;
    private long glNativeHandle;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private TextureHelper mI420TextureConverter;
    private boolean mIsStart;
    private TextureHelper mTextureHelper;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.utils.VideoFrameConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat;

        static {
            int[] iArr = new int[VideoPixelFormat.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat = iArr;
            try {
                iArr[VideoPixelFormat.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.TEXTURE_OES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public VideoFrameConverter() {
        this.mIsStart = false;
        HandlerThread handlerThread = new HandlerThread("video-frame-converter");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mIsStart = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert2WebrtcTextureFrame$0(int i) {
        this.mTextureHelper.queueTexture(i);
    }

    private void updateEglContext(EGLContext eGLContext, int i, int i2) {
        if (this.mTextureHelper == null) {
            this.mTextureHelper = TextureHelper.create("EGL14TextureHelper", eGLContext, i, i2);
            this.glNativeHandle = getNativeEglContext(eGLContext);
            LogUtil.i(TAG, "create  egl14 texture helper");
            return;
        }
        if (this.glNativeHandle == getNativeEglContext(eGLContext) && this.mTextureHelper.getWidth() == i && this.mTextureHelper.getHeight() == i2) {
            return;
        }
        this.glNativeHandle = getNativeEglContext(eGLContext);
        this.mTextureHelper.dispose();
        this.mTextureHelper = TextureHelper.create("EGL14TextureHelper", eGLContext, i, i2);
        LogUtil.i(TAG, "update egl14Context nativeHandle:" + this.glNativeHandle + " ,eglContext:" + eGLContext + "frame size width:" + i + "height :" + i2);
    }

    private boolean updateInnerI420Converter(EGLContext eGLContext, int i, int i2) {
        if (this.mI420TextureConverter == null) {
            this.mI420TextureConverter = TextureHelper.create("EGLBaseTextureHelper", eGLContext, i, i2);
            this.gl420ConverterNativeHandle = getNativeEglContext(eGLContext);
            LogUtil.i(TAG, "create EglBase 420 texture converter");
            return true;
        }
        if (this.gl420ConverterNativeHandle == getNativeEglContext(eGLContext)) {
            return true;
        }
        this.gl420ConverterNativeHandle = getNativeEglContext(eGLContext);
        this.mI420TextureConverter.dispose();
        this.mI420TextureConverter = TextureHelper.create("EGL14TextureConverter", eGLContext, i, i2);
        LogUtil.i(TAG, "update egl14texture converter nativeHandle:" + this.glNativeHandle + " ,eglContext:" + eGLContext);
        return true;
    }

    public VideoFrame allocateVideoFrame(com.ss.bytertc.engine.video.VideoFrame videoFrame, TextureHelper textureHelper, Runnable runnable) {
        VideoFrame.TextureBuffer.Type type;
        if (videoFrame.getFrameType() == VideoFrameType.RAW_MEMORY) {
            LogUtil.w(TAG, "allocateVideoFrame only glTexture format is avaliable");
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[videoFrame.getPixelFormat().ordinal()];
        if (i == 1) {
            type = VideoFrame.TextureBuffer.Type.RGB;
        } else {
            if (i != 2) {
                LogUtil.w(TAG, "texture format is not support");
                return null;
            }
            type = VideoFrame.TextureBuffer.Type.OES;
        }
        TextureBufferImpl textureBufferImpl = new TextureBufferImpl(videoFrame.getWidth(), videoFrame.getHeight(), type, videoFrame.getTextureID(), RendererCommon.convertMatrixToAndroidGraphicsMatrix(videoFrame.getTextureMatrix()), textureHelper, runnable);
        textureBufferImpl.setEglBaseContext(textureHelper.getEglBaseContext());
        return new VideoFrame(textureBufferImpl, videoFrame.getRotation().value(), videoFrame.getTimeStampUs() * 1000);
    }

    public synchronized VideoFrame convert2WebrtcI420Frame(com.ss.bytertc.engine.video.VideoFrame videoFrame) {
        if (videoFrame == null) {
            LogUtil.w(TAG, "convert2WebrtcI420Frame frame is null");
            return null;
        }
        if (videoFrame.getFrameType() != VideoFrameType.GL_TEXTURE) {
            LogUtil.w(TAG, "convert2WebrtcI420Frame: pushExternalVideoFrame VideoFrame type is not available");
            return null;
        }
        if (videoFrame.getEGLContext() != null && updateInnerI420Converter(videoFrame.getEGLContext(), videoFrame.getWidth(), videoFrame.getHeight())) {
            TextureHelper textureHelper = this.mI420TextureConverter;
            if (textureHelper == null) {
                return null;
            }
            VideoFrame videoFrameAllocateVideoFrame = allocateVideoFrame(videoFrame, textureHelper, null);
            VideoFrame videoFrame2 = new VideoFrame(videoFrameAllocateVideoFrame.getBuffer().toI420(), videoFrameAllocateVideoFrame.getRotation(), videoFrameAllocateVideoFrame.getTimestampNs());
            videoFrameAllocateVideoFrame.release();
            return videoFrame2;
        }
        LogUtil.e(TAG, "video frame  error frame eglContext14:" + videoFrame.getEGLContext() + " isStart:" + this.mIsStart);
        return null;
    }

    public synchronized VideoFrame convert2WebrtcTextureFrame(com.ss.bytertc.engine.video.VideoFrame videoFrame) {
        int i;
        VideoFrame videoFrameAllocateVideoFrame = null;
        if (videoFrame == null) {
            LogUtil.w(TAG, "convert2VideoFrame frame is null");
            return null;
        }
        if (videoFrame.getFrameType() != VideoFrameType.GL_TEXTURE) {
            LogUtil.w(TAG, "pushExternalVideoFrame VideoFrame type is not available");
            return null;
        }
        if (videoFrame.getEGLContext() != null) {
            updateEglContext(videoFrame.getEGLContext(), videoFrame.getWidth(), videoFrame.getHeight());
        }
        if (this.mTextureHelper != null) {
            if (videoFrame.hasReleaseCallback()) {
                videoFrameAllocateVideoFrame = allocateVideoFrame(videoFrame, this.mTextureHelper, new sb6(videoFrame));
            } else {
                final int iDequeueTexture = this.mTextureHelper.dequeueTexture();
                if (iDequeueTexture == 0) {
                    return null;
                }
                VideoPixelFormat pixelFormat = videoFrame.getPixelFormat();
                VideoPixelFormat videoPixelFormat = VideoPixelFormat.TEXTURE_2D;
                if (pixelFormat == videoPixelFormat) {
                    i = 10;
                } else {
                    if (videoFrame.getPixelFormat() != VideoPixelFormat.TEXTURE_OES) {
                        return null;
                    }
                    i = 11;
                }
                this.mTextureHelper.drawTexture(i, videoFrame.getTextureID(), iDequeueTexture);
                GLTextureVideoFrameBuilder gLTextureVideoFrameBuilder = new GLTextureVideoFrameBuilder(videoPixelFormat);
                gLTextureVideoFrameBuilder.setColorSpace(videoFrame.getColorSpace()).setTextureID(iDequeueTexture).setEGLContext(videoFrame.getEGLContext()).setTextureMatrix(videoFrame.getTextureMatrix()).setWidth(videoFrame.getWidth()).setHeight(videoFrame.getHeight()).setRotation(videoFrame.getRotation()).setTimeStampUs(videoFrame.getTimeStampUs()).setReleaseCallback(new Runnable() { // from class: ub6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21186a.lambda$convert2WebrtcTextureFrame$0(iDequeueTexture);
                    }
                });
                com.ss.bytertc.engine.video.VideoFrame videoFrameBuild = gLTextureVideoFrameBuilder.build();
                TextureHelper textureHelper = this.mTextureHelper;
                Objects.requireNonNull(videoFrameBuild);
                videoFrameAllocateVideoFrame = allocateVideoFrame(videoFrameBuild, textureHelper, new sb6(videoFrameBuild));
            }
        }
        return videoFrameAllocateVideoFrame;
    }

    public synchronized void dispose() {
        TextureHelper textureHelper = this.mTextureHelper;
        if (textureHelper != null) {
            textureHelper.dispose();
        }
        TextureHelper textureHelper2 = this.mI420TextureConverter;
        if (textureHelper2 != null) {
            textureHelper2.dispose();
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.mIsStart = false;
    }

    public long getNativeEglContext(javax.microedition.khronos.egl.EGLContext eGLContext) {
        return 0L;
    }

    public TextureHelper getTextureHelper() {
        return this.mTextureHelper;
    }

    public synchronized void post(Runnable runnable) {
        if (this.mIsStart) {
            TextureHelper textureHelper = this.mTextureHelper;
            if (textureHelper != null) {
                textureHelper.post(runnable);
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    private long getNativeEglContext(EGLContext eGLContext) {
        return eGLContext.getNativeHandle();
    }
}
