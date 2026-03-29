package com.ss.bytertc.engine.handler;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglBase14;
import com.bytedance.realx.video.NV12Buffer;
import com.bytedance.realx.video.NV21Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.data.VideoFrameType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.handler.RTCVideoProcessor;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.utils.TextureBufferImpl;
import com.ss.bytertc.engine.utils.TextureHelper;
import com.ss.bytertc.engine.video.IVideoProcessor;
import com.ss.bytertc.engine.video.MultiVideoFrameWrapper;
import com.ss.bytertc.engine.video.impl.WebrtcWrapperVideoFrame;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCVideoProcessor {
    private static final String TAG = "RTCVideoProcessor";
    private IVideoProcessor mCustomVideoPreprocessor;
    private final Handler mHandler;
    private boolean mIsDisposed;
    private TextureHelperRef mTxtHelperRef = null;
    private boolean mNeedRecreateTextureHelper = false;
    VideoPixelFormat mRequiredFormat = VideoPixelFormat.UNKNOWN;
    private EglBase14 mEglbase = null;
    private EglBase14.Context mSharedContext = null;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.handler.RTCVideoProcessor$1, reason: invalid class name */
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
            try {
                $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.I420.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TextureHelperRef {
        TextureHelper mTextureHelper;
        private int refCount = 1;

        public TextureHelperRef(TextureHelper textureHelper) {
            this.mTextureHelper = textureHelper;
        }

        public static TextureHelperRef create(int i, int i2, EglBase eglBase) {
            TextureHelper textureHelperCreate = TextureHelper.create("RTCVideoProcessorTextureHelper", eglBase.getEglBaseContext(), i, i2);
            if (textureHelperCreate == null) {
                return null;
            }
            return new TextureHelperRef(textureHelperCreate);
        }

        public void release() {
            TextureHelper textureHelper;
            synchronized (this) {
                int i = this.refCount - 1;
                this.refCount = i;
                if (i == 0 && (textureHelper = this.mTextureHelper) != null) {
                    textureHelper.dispose();
                    this.mTextureHelper = null;
                }
            }
        }

        public void retain() {
            synchronized (this) {
                this.refCount++;
            }
        }
    }

    public RTCVideoProcessor() {
        this.mIsDisposed = false;
        this.mIsDisposed = false;
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public static boolean check_require_format(VideoPixelFormat videoPixelFormat) {
        return videoPixelFormat == VideoPixelFormat.UNKNOWN || videoPixelFormat == VideoPixelFormat.I420 || videoPixelFormat == VideoPixelFormat.TEXTURE_2D;
    }

    public static boolean check_src_format(VideoPixelFormat videoPixelFormat) {
        return videoPixelFormat == VideoPixelFormat.TEXTURE_OES || videoPixelFormat == VideoPixelFormat.TEXTURE_2D || videoPixelFormat == VideoPixelFormat.I420;
    }

    public static VideoPixelFormat get_frame_format(VideoFrame videoFrame) {
        VideoPixelFormat videoPixelFormat = VideoPixelFormat.UNKNOWN;
        if (videoFrame.getBuffer() instanceof VideoFrame.TextureBuffer) {
            return ((VideoFrame.TextureBuffer) videoFrame.getBuffer()).getType() == VideoFrame.TextureBuffer.Type.OES ? VideoPixelFormat.TEXTURE_OES : VideoPixelFormat.TEXTURE_2D;
        }
        return videoFrame.getBuffer() instanceof NV21Buffer ? VideoPixelFormat.NV21 : videoFrame.getBuffer() instanceof NV12Buffer ? VideoPixelFormat.NV21 : videoFrame.getBuffer() instanceof VideoFrame.I420Buffer ? VideoPixelFormat.I420 : videoPixelFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$byteTextureFrame2WebrtcTextureFrame$4(com.ss.bytertc.engine.video.VideoFrame videoFrame, TextureHelperRef textureHelperRef) {
        videoFrame.release();
        textureHelperRef.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$byteTextureFrame2WebrtcTextureFrame$5(int i, TextureHelperRef textureHelperRef) {
        this.mTxtHelperRef.mTextureHelper.queueTexture(i);
        textureHelperRef.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.ss.bytertc.engine.video.VideoFrame lambda$processVideoFrameInternal$3(VideoFrame videoFrame, IVideoProcessor iVideoProcessor) throws Exception {
        com.ss.bytertc.engine.video.VideoFrame videoFrameProcessVideoFrame;
        WebrtcWrapperVideoFrame webrtcWrapperVideoFrame = new WebrtcWrapperVideoFrame(videoFrame, EGL14.eglGetCurrentContext());
        try {
            videoFrameProcessVideoFrame = iVideoProcessor.processVideoFrame(webrtcWrapperVideoFrame);
        } catch (Exception e) {
            LogUtil.e(TAG, " failed to exec user's processVideoFrame callback", e);
            videoFrameProcessVideoFrame = null;
        }
        if (videoFrameProcessVideoFrame == null) {
            LogUtil.e(TAG, "return frame if null.");
            return null;
        }
        if (videoFrameProcessVideoFrame.getFrameType() == VideoFrameType.GL_TEXTURE) {
            GLES20.glFinish();
        }
        if (webrtcWrapperVideoFrame != videoFrameProcessVideoFrame) {
            webrtcWrapperVideoFrame.release();
        }
        return videoFrameProcessVideoFrame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerLocalVideoProcessor$1(VideoPixelFormat videoPixelFormat, IVideoProcessor iVideoProcessor) {
        IVideoProcessor customVideoPreprocessor = getCustomVideoPreprocessor();
        if (customVideoPreprocessor != null && this.mEglbase != null) {
            customVideoPreprocessor.onGLEnvRelease();
        }
        this.mRequiredFormat = videoPixelFormat;
        this.mCustomVideoPreprocessor = iVideoProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toTexture2DFrame$6(int i, TextureHelperRef textureHelperRef) {
        this.mTxtHelperRef.mTextureHelper.queueTexture(i);
        textureHelperRef.release();
    }

    public VideoFrame byteTextureFrame2WebrtcTextureFrame(final com.ss.bytertc.engine.video.VideoFrame videoFrame) {
        if (videoFrame.getFrameType() != VideoFrameType.GL_TEXTURE) {
            return null;
        }
        updateTextureHelper(videoFrame.getWidth(), videoFrame.getHeight());
        if (this.mTxtHelperRef == null) {
            LogUtil.e(TAG, "texture helper is invalid, ToVideoFrame failed.");
            return null;
        }
        if (videoFrame.hasReleaseCallback()) {
            VideoFrame.TextureBuffer.Type type = VideoFrame.TextureBuffer.Type.RGB;
            if (videoFrame.getPixelFormat() == VideoPixelFormat.TEXTURE_OES) {
                type = VideoFrame.TextureBuffer.Type.OES;
            }
            VideoFrame.TextureBuffer.Type type2 = type;
            Matrix matrixConvertMatrixToAndroidGraphicsMatrix = videoFrame.getTextureMatrix() != null ? RendererCommon.convertMatrixToAndroidGraphicsMatrix(videoFrame.getTextureMatrix()) : new Matrix();
            this.mTxtHelperRef.retain();
            final TextureHelperRef textureHelperRef = this.mTxtHelperRef;
            TextureBufferImpl textureBufferImpl = new TextureBufferImpl(videoFrame.getWidth(), videoFrame.getHeight(), type2, videoFrame.getTextureID(), matrixConvertMatrixToAndroidGraphicsMatrix, this.mTxtHelperRef.mTextureHelper, new Runnable() { // from class: com.ss.bytertc.engine.handler.b
                @Override // java.lang.Runnable
                public final void run() {
                    RTCVideoProcessor.lambda$byteTextureFrame2WebrtcTextureFrame$4(videoFrame, textureHelperRef);
                }
            });
            textureBufferImpl.setEglBaseContext(this.mTxtHelperRef.mTextureHelper.getEglBaseContext());
            return new VideoFrame(textureBufferImpl, videoFrame.getRotation().value(), videoFrame.getTimeStampUs());
        }
        final int iDequeueTexture = this.mTxtHelperRef.mTextureHelper.dequeueTexture();
        if (iDequeueTexture == 0) {
            LogUtil.e(TAG, "failed to get a texture, ToVideoFrame failed.");
            return null;
        }
        try {
            this.mTxtHelperRef.mTextureHelper.drawTexture(videoFrame.getPixelFormat() == VideoPixelFormat.TEXTURE_OES ? 11 : 10, videoFrame.getTextureID(), iDequeueTexture);
            VideoFrame.TextureBuffer.Type type3 = VideoFrame.TextureBuffer.Type.RGB;
            Matrix matrixConvertMatrixToAndroidGraphicsMatrix2 = videoFrame.getTextureMatrix() != null ? RendererCommon.convertMatrixToAndroidGraphicsMatrix(videoFrame.getTextureMatrix()) : new Matrix();
            this.mTxtHelperRef.retain();
            final TextureHelperRef textureHelperRef2 = this.mTxtHelperRef;
            TextureBufferImpl textureBufferImpl2 = new TextureBufferImpl(videoFrame.getWidth(), videoFrame.getHeight(), type3, iDequeueTexture, matrixConvertMatrixToAndroidGraphicsMatrix2, this.mTxtHelperRef.mTextureHelper, new Runnable() { // from class: com.ss.bytertc.engine.handler.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10643a.lambda$byteTextureFrame2WebrtcTextureFrame$5(iDequeueTexture, textureHelperRef2);
                }
            });
            textureBufferImpl2.setEglBaseContext(this.mTxtHelperRef.mTextureHelper.getEglBaseContext());
            videoFrame.release();
            return new VideoFrame(textureBufferImpl2, videoFrame.getRotation().value(), videoFrame.getTimeStampUs());
        } catch (RuntimeException unused) {
            LogUtil.e(TAG, "failed to draw to target texture, ToVideoFrame failed.");
            this.mTxtHelperRef.mTextureHelper.queueTexture(iDequeueTexture);
            return null;
        }
    }

    public void dispose() {
        this.mIsDisposed = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: rr4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20558a.lambda$dispose$0();
            }
        });
        this.mHandler.getLooper().quit();
        TextureHelperRef textureHelperRef = this.mTxtHelperRef;
        if (textureHelperRef != null) {
            textureHelperRef.release();
        }
    }

    public IVideoProcessor getCustomVideoPreprocessor() {
        return this.mCustomVideoPreprocessor;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    @CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiVideoFrameWrapper processVideoFrame(final VideoFrame videoFrame) {
        VideoFrame texture2DFrame;
        if (this.mIsDisposed) {
            LogUtil.e(TAG, "engine is invalid, processVideoFrame failed.");
            return null;
        }
        IVideoProcessor customVideoPreprocessor = getCustomVideoPreprocessor();
        if (customVideoPreprocessor == null) {
            LogUtil.e(TAG, "custom video preprocessor is invalid, processVideoFrame failed.");
            return null;
        }
        VideoPixelFormat videoPixelFormat = get_frame_format(videoFrame);
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: sr4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20829a.lambda$processVideoFrame$2(videoFrame);
            }
        });
        VideoPixelFormat videoPixelFormat2 = this.mRequiredFormat;
        if (videoPixelFormat2 == VideoPixelFormat.UNKNOWN) {
            if (check_src_format(videoPixelFormat)) {
                texture2DFrame = videoFrame;
            } else {
                VideoFrame.I420Buffer i420 = videoFrame.getBuffer().toI420();
                if (i420 == null) {
                    LogUtil.e(TAG, "fail to convert frame to i420");
                    return null;
                }
                texture2DFrame = new VideoFrame(i420, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getFlipState());
            }
        } else if (videoPixelFormat2 != videoPixelFormat) {
            if (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[videoPixelFormat2.ordinal()] != 1) {
                LogUtil.e(TAG, "src format should be TEXTURE_2D.");
                return null;
            }
            texture2DFrame = toTexture2DFrame(videoPixelFormat, videoFrame);
            if (texture2DFrame == null) {
                return null;
            }
        }
        MultiVideoFrameWrapper multiVideoFrameWrapperProcessVideoFrameInternal = processVideoFrameInternal(customVideoPreprocessor, texture2DFrame);
        if (texture2DFrame != videoFrame) {
            texture2DFrame.release();
        }
        return multiVideoFrameWrapperProcessVideoFrameInternal;
    }

    public MultiVideoFrameWrapper processVideoFrameInternal(final IVideoProcessor iVideoProcessor, final VideoFrame videoFrame) {
        com.ss.bytertc.engine.video.VideoFrame videoFrame2;
        try {
            videoFrame2 = (com.ss.bytertc.engine.video.VideoFrame) ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Callable() { // from class: tr4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return RTCVideoProcessor.lambda$processVideoFrameInternal$3(videoFrame, iVideoProcessor);
                }
            });
            try {
                if (videoFrame2 == null) {
                    LogUtil.e(TAG, "custom video process return null, processVideoFrameInternal failed.");
                    return null;
                }
                if (videoFrame2.getFrameType() == VideoFrameType.GL_TEXTURE) {
                    return new MultiVideoFrameWrapper(byteTextureFrame2WebrtcTextureFrame(videoFrame2));
                }
                if (videoFrame2.getFrameType() == VideoFrameType.RAW_MEMORY) {
                    return new MultiVideoFrameWrapper(videoFrame2);
                }
                LogUtil.e(TAG, "custom video process processed_frame type unknown, processVideoFrameInternal failed.");
                return null;
            } catch (RuntimeException e) {
                e = e;
                LogUtil.e(TAG, " failed to do custom video process", e);
                if (videoFrame2 != null) {
                    videoFrame2.release();
                }
                return null;
            }
        } catch (RuntimeException e2) {
            e = e2;
            videoFrame2 = null;
        }
    }

    public int registerLocalVideoProcessor(final IVideoProcessor iVideoProcessor, final VideoPixelFormat videoPixelFormat) {
        if (check_require_format(videoPixelFormat)) {
            ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: ur4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21278a.lambda$registerLocalVideoProcessor$1(videoPixelFormat, iVideoProcessor);
                }
            });
            return 0;
        }
        LogUtil.e(TAG, "custom video preprocessor setRequiredFormat failed.");
        return -1;
    }

    /* JADX INFO: renamed from: releaseEGL, reason: merged with bridge method [inline-methods] */
    public void lambda$dispose$0() {
        if (this.mEglbase == null) {
            return;
        }
        IVideoProcessor customVideoPreprocessor = getCustomVideoPreprocessor();
        if (customVideoPreprocessor != null) {
            customVideoPreprocessor.onGLEnvRelease();
        }
        this.mEglbase.makeCurrent();
        this.mEglbase.release();
        this.mEglbase = null;
    }

    public VideoFrame toTexture2DFrame(VideoPixelFormat videoPixelFormat, VideoFrame videoFrame) {
        if (videoPixelFormat == VideoPixelFormat.TEXTURE_2D) {
            videoFrame.retain();
            return videoFrame;
        }
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        updateTextureHelper(buffer.getWidth(), buffer.getHeight());
        TextureHelperRef textureHelperRef = this.mTxtHelperRef;
        if (textureHelperRef == null) {
            LogUtil.e(TAG, "texture helper is invalid, toTexture2DFrame failed.");
            return null;
        }
        final int iDequeueTexture = textureHelperRef.mTextureHelper.dequeueTexture();
        if (iDequeueTexture == 0) {
            LogUtil.e(TAG, "failed to get a texture, toTexture2DFrame failed.");
            return null;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[videoPixelFormat.ordinal()];
            if (i == 2) {
                VideoFrame.TextureBuffer textureBuffer = (VideoFrame.TextureBuffer) buffer;
                this.mTxtHelperRef.mTextureHelper.drawTexture(11, textureBuffer.getTextureId(), iDequeueTexture, textureBuffer.nativeGetTransFormMatrix());
            } else if (i != 3) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                if (i420 == null) {
                    LogUtil.e(TAG, "fail to convert frame to i420");
                    return null;
                }
                this.mTxtHelperRef.mTextureHelper.yuvToTexture(i420, iDequeueTexture);
                i420.release();
            } else {
                this.mTxtHelperRef.mTextureHelper.yuvToTexture((VideoFrame.I420Buffer) buffer, iDequeueTexture);
            }
            Matrix matrix = new Matrix();
            this.mTxtHelperRef.retain();
            final TextureHelperRef textureHelperRef2 = this.mTxtHelperRef;
            TextureBufferImpl textureBufferImpl = new TextureBufferImpl(buffer.getWidth(), buffer.getHeight(), VideoFrame.TextureBuffer.Type.RGB, iDequeueTexture, matrix, this.mTxtHelperRef.mTextureHelper, new Runnable() { // from class: com.ss.bytertc.engine.handler.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10641a.lambda$toTexture2DFrame$6(iDequeueTexture, textureHelperRef2);
                }
            });
            textureBufferImpl.setEglBaseContext(this.mTxtHelperRef.mTextureHelper.getEglBaseContext());
            return new VideoFrame(textureBufferImpl, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getFlipState());
        } catch (RuntimeException unused) {
            LogUtil.e(TAG, "failed to draw, toTexture2DFrame failed.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX INFO: renamed from: updateEGLEnv, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lambda$processVideoFrame$2(VideoFrame videoFrame) {
        boolean z;
        if (videoFrame == null) {
            return;
        }
        if (this.mIsDisposed) {
            LogUtil.e(TAG, "engine is invalid, initEGL failed.");
            throw new RuntimeException("engine is invalid, initEGL failed.");
        }
        int[] iArr = {12352, 4, 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 8, 12326, 8, 12344};
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        if (buffer instanceof VideoFrame.TextureBuffer) {
            EglBase14.Context context = new EglBase14.Context(((VideoFrame.TextureBuffer) buffer).getEglContext());
            EglBase14.Context context2 = this.mSharedContext;
            if (context.getNativeEglContext() != (context2 != null ? context2.getNativeEglContext() : 0L)) {
                this.mSharedContext = context;
                z = true;
            } else {
                z = false;
            }
        }
        if (this.mEglbase == null) {
            z = true;
        }
        IVideoProcessor customVideoPreprocessor = getCustomVideoPreprocessor();
        if (z) {
            try {
                if (this.mEglbase != null) {
                    if (customVideoPreprocessor != null) {
                        customVideoPreprocessor.onGLEnvRelease();
                    }
                    this.mEglbase.release();
                    this.mEglbase = null;
                }
                EglBase14 eglBase14 = new EglBase14(this.mSharedContext, iArr);
                this.mEglbase = eglBase14;
                eglBase14.createDummyPbufferSurface();
                this.mEglbase.makeCurrent();
                this.mNeedRecreateTextureHelper = true;
                if (customVideoPreprocessor != null) {
                    customVideoPreprocessor.onGLEnvInitiated();
                }
            } catch (RuntimeException e) {
                this.mEglbase.release();
                this.mEglbase = null;
                LogUtil.e(TAG, " failed to create mEglbase", e);
            }
        }
    }

    public void updateTextureHelper(int i, int i2) {
        if (this.mIsDisposed) {
            return;
        }
        TextureHelperRef textureHelperRef = this.mTxtHelperRef;
        if ((textureHelperRef == null || this.mNeedRecreateTextureHelper || textureHelperRef.mTextureHelper.getWidth() != i || this.mTxtHelperRef.mTextureHelper.getHeight() != i2) && this.mEglbase != null) {
            TextureHelperRef textureHelperRef2 = this.mTxtHelperRef;
            if (textureHelperRef2 != null) {
                textureHelperRef2.release();
            }
            this.mTxtHelperRef = TextureHelperRef.create(i, i2, this.mEglbase);
            this.mNeedRecreateTextureHelper = false;
        }
    }
}
