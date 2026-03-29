package com.bytedance.realx.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bytedance.realx.RXVideoSurfaceController;
import com.bytedance.realx.base.RXDeviceInfoAndroid;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase14;
import com.bytedance.realx.video.EncodedImage;
import com.bytedance.realx.video.VideoEncoder;
import com.bytedance.realx.video.memory.NativeRXByteMemory;
import com.bytedance.realx.video.memory.NativeRXOpenGLMemory;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import com.bytedance.realx.video.memory.RXVideoMemoryInterface;
import com.huawei.hms.ads.ex;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@TargetApi(21)
class HardwareVideoEncoder implements VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int DTS_OFFSET_FRAME_NUM = 7;
    private static final String KEY_HISI_EXT_CODEC_MAX_QP = "vendor.hisi.hisi-ext-codec-max-qp";
    private static final String KEY_HISI_EXT_CODEC_MIN_QP = "vendor.hisi.hisi-ext-codec-min-qp";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES = "vendor.hisi.hisi-ext-codec-non-ref-p-frames";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED = "vendor.hisi.hisi-ext-codec-non-ref-p-frames-supported";
    private static final String KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD = "vendor.hisi.hisi-ext-codec-qp-regulation-supported";
    private static final String KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE = "vendor.hisi.hisi-ext-codec-vendor-configure";
    private static final String KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT = "realx.force.surface.input";
    private static final int MAX_VIDEO_FRAMERATE = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final int RESTART_ENCODER_TIME_THRESHOLD_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private int adjustedBitrate;
    private boolean automaticResizeOn;
    private VideoEncoder.BitrateMode bitrateMode;
    private VideoEncoder.Callback callback;

    @Nullable
    private MediaCodecWrapper codec;
    private final RXVideoCodecDesc codecDesc;
    private final String codecName;

    @Nullable
    private ByteBuffer configBuffer;
    private final Deque<Long> dtsQueue;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private boolean encodedFirstFrame;
    private long firstFrameDiffUs;
    private Boolean forceSurfaceInput;
    private final long forcedKeyFrameNs;
    private int height;
    private boolean isNeedSurfaceInputWorkaround;
    private Boolean isTextureBuffer;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

    @Nullable
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private HashMap<String, String> privateParams;
    private volatile boolean running;
    private VideoEncoder.ScaleMode scaleMode;
    private VideoEncoder.Settings settings;
    private EglBase14.Context sharedContext;

    @Nullable
    private volatile Exception shutdownException;
    private final Integer surfaceColorFormat;
    private int svcRealLayerNum;

    @Nullable
    private EglBase14 textureEglBase;

    @Nullable
    private Surface textureInputSurface;
    private int updateBitrate;
    private long updateBitrateTimestamp;
    private boolean useSurfaceMode;
    private HashMap<String, String> vpassPrivateParams;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private GlRectDrawer textureDrawer = new GlRectDrawer();
    private VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();

    /* JADX INFO: renamed from: com.bytedance.realx.video.HardwareVideoEncoder$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile;

        static {
            int[] iArr = new int[RXVideoCodecProfile.values().length];
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile = iArr;
            try {
                iArr[RXVideoCodecProfile.ProfileHigh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedHigh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileBaseline.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedBaseline.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileMain.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10HDR10.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum YuvFormat {
        I420 { // from class: com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat.1
            @Override // com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, RXVideoFrameInterface rXVideoFrameInterface) {
                RXVideoMemoryInterface andRetainVideoFrameMemory;
                if (rXVideoFrameInterface == null || (andRetainVideoFrameMemory = rXVideoFrameInterface.getAndRetainVideoFrameMemory()) == null) {
                    return;
                }
                if (andRetainVideoFrameMemory.getPixelFormat() == RXPixelFormat.kI420 && (andRetainVideoFrameMemory instanceof NativeRXByteMemory)) {
                    NativeRXByteMemory nativeRXByteMemory = (NativeRXByteMemory) andRetainVideoFrameMemory;
                    YuvHelper.I420Copy(nativeRXByteMemory.getPlaneData(0), nativeRXByteMemory.getPlaneLineSize(0), nativeRXByteMemory.getPlaneData(1), nativeRXByteMemory.getPlaneLineSize(1), nativeRXByteMemory.getPlaneData(2), nativeRXByteMemory.getPlaneLineSize(2), byteBuffer, rXVideoFrameInterface.getWidth(), rXVideoFrameInterface.getHeight());
                } else {
                    RXVideoFrameInterface i420 = rXVideoFrameInterface.toI420();
                    if (i420 == null) {
                        andRetainVideoFrameMemory.release();
                        return;
                    }
                    RXVideoMemoryInterface andRetainVideoFrameMemory2 = i420.getAndRetainVideoFrameMemory();
                    if (andRetainVideoFrameMemory2 == null) {
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else if (!(andRetainVideoFrameMemory2 instanceof NativeRXByteMemory)) {
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else {
                        NativeRXByteMemory nativeRXByteMemory2 = (NativeRXByteMemory) andRetainVideoFrameMemory2;
                        YuvHelper.I420Copy(nativeRXByteMemory2.getPlaneData(0), nativeRXByteMemory2.getPlaneLineSize(0), nativeRXByteMemory2.getPlaneData(1), nativeRXByteMemory2.getPlaneLineSize(1), nativeRXByteMemory2.getPlaneData(2), nativeRXByteMemory2.getPlaneLineSize(2), byteBuffer, i420.getWidth(), i420.getHeight());
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                    }
                }
                andRetainVideoFrameMemory.release();
            }
        },
        NV12 { // from class: com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat.2
            @Override // com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, RXVideoFrameInterface rXVideoFrameInterface) {
                RXVideoMemoryInterface andRetainVideoFrameMemory;
                if (rXVideoFrameInterface == null || (andRetainVideoFrameMemory = rXVideoFrameInterface.getAndRetainVideoFrameMemory()) == null) {
                    return;
                }
                if (andRetainVideoFrameMemory.getPixelFormat() == RXPixelFormat.kNv12 && (andRetainVideoFrameMemory instanceof NativeRXByteMemory)) {
                    NativeRXByteMemory nativeRXByteMemory = (NativeRXByteMemory) andRetainVideoFrameMemory;
                    YuvHelper.NV12Copy(nativeRXByteMemory.getPlaneData(0), nativeRXByteMemory.getPlaneLineSize(0), nativeRXByteMemory.getPlaneData(1), nativeRXByteMemory.getPlaneLineSize(1), byteBuffer, rXVideoFrameInterface.getWidth(), rXVideoFrameInterface.getHeight());
                } else {
                    RXVideoFrameInterface i420 = rXVideoFrameInterface.toI420();
                    if (i420 == null) {
                        andRetainVideoFrameMemory.release();
                        return;
                    }
                    RXVideoMemoryInterface andRetainVideoFrameMemory2 = i420.getAndRetainVideoFrameMemory();
                    if (andRetainVideoFrameMemory2 == null) {
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else if (!(andRetainVideoFrameMemory2 instanceof NativeRXByteMemory)) {
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else {
                        NativeRXByteMemory nativeRXByteMemory2 = (NativeRXByteMemory) andRetainVideoFrameMemory2;
                        YuvHelper.I420ToNV12(nativeRXByteMemory2.getPlaneData(0), nativeRXByteMemory2.getPlaneLineSize(0), nativeRXByteMemory2.getPlaneData(1), nativeRXByteMemory2.getPlaneLineSize(1), nativeRXByteMemory2.getPlaneData(2), nativeRXByteMemory2.getPlaneLineSize(2), byteBuffer, i420.getWidth(), i420.getHeight());
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                    }
                }
                andRetainVideoFrameMemory.release();
            }
        };

        public abstract void fillBuffer(ByteBuffer byteBuffer, RXVideoFrameInterface rXVideoFrameInterface);

        public static YuvFormat valueOf(int i) {
            if (i == 19) {
                return I420;
            }
            if (i == 21 || i == 2141391872 || i == 2141391876) {
                return NV12;
            }
            throw new IllegalArgumentException("Unsupported colorFormat: " + i);
        }
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, RXVideoCodecDesc rXVideoCodecDesc, Integer num, Integer num2, int i, int i2) throws Throwable {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = threadChecker;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.privateParams = new HashMap<>();
        this.vpassPrivateParams = new HashMap<>();
        this.forceSurfaceInput = null;
        this.isNeedSurfaceInputWorkaround = false;
        this.svcRealLayerNum = 1;
        this.encodedFirstFrame = false;
        this.firstFrameDiffUs = 0L;
        this.dtsQueue = new LinkedBlockingDeque();
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecDesc = rXVideoCodecDesc;
        this.surfaceColorFormat = num;
        this.yuvColorFormat = num2;
        this.yuvFormat = YuvFormat.valueOf(num2.intValue());
        this.keyFrameIntervalSec = i;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(i2);
        String strGetCpuModel = RXDeviceInfoAndroid.GetCpuModel();
        String strGetDeviceModel = RXDeviceInfoAndroid.GetDeviceModel();
        if (strGetCpuModel != null) {
            this.isNeedSurfaceInputWorkaround = strGetCpuModel.contains("MT6785V/CC") || (strGetCpuModel.contains("MT6833V/ZA") && !"RMX3610".equalsIgnoreCase(strGetDeviceModel)) || strGetCpuModel.contains("MT6833V/PNZA") || strGetCpuModel.contains("MT6853V/ZA") || strGetCpuModel.contains("MT6893Z_C/CZA");
        }
        threadChecker.detachThread();
    }

    private void caculateDts(long j, EncodedImage.Builder builder) {
        if (isBFrameEnabled()) {
            Long lPollLast = this.dtsQueue.pollLast();
            if (lPollLast == null) {
                RXLogging.e(TAG, "dtsQueue is empty.");
                return;
            }
            if (!this.encodedFirstFrame) {
                this.encodedFirstFrame = true;
                this.firstFrameDiffUs = j - lPollLast.longValue();
                RXLogging.w(TAG, "firstFrameDiffUs: " + this.firstFrameDiffUs + " " + j);
            }
            Long lValueOf = Long.valueOf((lPollLast.longValue() + this.firstFrameDiffUs) - ((long) ((1000000 / this.settings.targetFps) * 7)));
            long jLongValue = j - lValueOf.longValue();
            if (lValueOf.longValue() >= 0 && jLongValue >= 0) {
                if (jLongValue == 0) {
                    jLongValue = 1;
                }
                builder.setCompositionTimeUs(jLongValue);
            } else {
                RXLogging.e(TAG, "ctsUs < 0; " + jLongValue + " " + lValueOf);
            }
        }
    }

    private boolean canUseSurface() {
        return this.surfaceColorFormat != null;
    }

    private Thread createOutputThread() {
        return new Thread("video_encoded_thread") { // from class: com.bytedance.realx.video.HardwareVideoEncoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
                HardwareVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private VideoCodecStatus encodeByteBuffer(RXVideoFrameInterface rXVideoFrameInterface) {
        this.encodeThreadChecker.checkIsOnValidThread();
        int height = ((rXVideoFrameInterface.getHeight() * rXVideoFrameInterface.getWidth()) * 3) / 2;
        long timestampNs = rXVideoFrameInterface.getTimestampNs() / 1000;
        try {
            int iDequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
            if (iDequeueInputBuffer == -1) {
                RXLogging.i(TAG, "Dropped frame, no input buffers available");
                return VideoCodecStatus.NO_OUTPUT;
            }
            try {
                fillInputBuffer(this.codec.getInputBuffers()[iDequeueInputBuffer], rXVideoFrameInterface);
                try {
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, height, timestampNs, 0);
                    return VideoCodecStatus.OK;
                } catch (Exception e) {
                    RXLogging.e(TAG, "queueInputBuffer failed", e);
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            } catch (Exception e2) {
                RXLogging.e(TAG, "getInputBuffers failed", e2);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (Exception e3) {
            RXLogging.e(TAG, "dequeueInputBuffer failed", e3);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus encodeTextureBuffer(RXVideoFrameInterface rXVideoFrameInterface) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError != 0) {
                RXLogging.e(TAG, "got egl err:" + iGlGetError);
            }
            rXVideoFrameInterface.setRotation(RXVideoRotation.VIDEO_ROTATION_0);
            this.videoFrameDrawer.drawFrame(rXVideoFrameInterface, this.textureDrawer, null);
            this.textureEglBase.swapBuffers(rXVideoFrameInterface.getTimestampNs());
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.e(TAG, "encodeTexture failed", e);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus initEncodeInternal() {
        MediaFormat outputFormat;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1L;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.dtsQueue.clear();
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.codecDesc.getStandard().mimeType(), this.width, this.height);
                initMediaFormat(mediaFormatCreateVideoFormat);
                RXLogging.w(TAG, "Format: " + mediaFormatCreateVideoFormat);
                this.codec.configure(mediaFormatCreateVideoFormat, null, null, 1);
                if (isSvcEnabled() && (outputFormat = this.codec.getOutputFormat()) != null) {
                    this.svcRealLayerNum = parseRealLayerNum(outputFormat);
                    RXLogging.w(TAG, "" + this.svcRealLayerNum + "，output format after configure: " + outputFormat.toString());
                }
                if (RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
                    this.textureInputSurface = this.codec.createInputSurface();
                    RXVideoSurfaceController.getInstance().setSurface(this.textureInputSurface);
                } else if (this.useSurfaceMode) {
                    this.textureInputSurface = this.codec.createInputSurface();
                    EglBase14 eglBase14 = new EglBase14(this.sharedContext, EglBase.CONFIG_RECORDABLE);
                    this.textureEglBase = eglBase14;
                    eglBase14.createSurface(this.textureInputSurface);
                    this.textureEglBase.makeCurrent();
                }
                this.codec.start();
                VideoEncoder.Settings settings = this.settings;
                setExtCodecForHisi(settings.maxQp, settings.minQp);
                VideoEncoder.Settings settings2 = this.settings;
                if (settings2.encodeMode == VideoEncoder.EncodeMode.LIVE) {
                    updateBitrate(settings2.targetBps);
                }
                this.running = true;
                this.outputThreadChecker.detachThread();
                Thread threadCreateOutputThread = createOutputThread();
                this.outputThread = threadCreateOutputThread;
                threadCreateOutputThread.start();
                return VideoCodecStatus.OK;
            } catch (Exception e) {
                RXLogging.e(TAG, "initEncodeInternal failed", e);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (Exception e2) {
            RXLogging.e(TAG, "Cannot create media encoder " + this.codecName, e2);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private void initMediaFormat(MediaFormat mediaFormat) {
        int iIntValue = (this.useSurfaceMode ? this.surfaceColorFormat : this.yuvColorFormat).intValue();
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        setIntegerParam(mediaFormat, "bitrate", Integer.valueOf(this.settings.targetBps));
        setIntegerParam(mediaFormat, IMediaFormat.KEY_COLOR_FORMAT, Integer.valueOf(iIntValue));
        setIntegerParam(mediaFormat, IMediaFormat.KEY_FRAME_RATE, Integer.valueOf(this.settings.targetFps));
        int i = this.settings.targetKeyFrameIntervalMs;
        if (i <= 0) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_I_FRAME_INTERVAL, Integer.valueOf(this.keyFrameIntervalSec));
        } else {
            int i2 = i / 1000;
            if (i2 <= 1) {
                i2 = 1;
            }
            setIntegerParam(mediaFormat, IMediaFormat.KEY_I_FRAME_INTERVAL, Integer.valueOf(i2));
        }
        setBitrateMode(mediaFormat);
        setBFrameNumber(mediaFormat);
        if (this.settings.encodeMode == VideoEncoder.EncodeMode.LIVE) {
            setProfileForLive(mediaFormat);
        } else {
            setProfileForRTC(mediaFormat);
            setColorSpace(mediaFormat);
        }
        setSVCNumber(mediaFormat);
        if (standard != RXVideoCodecStandard.VP8 && this.settings.enableQpSetting) {
            if (this.codecName.contains("OMX.hisi.")) {
                setIntegerParam(mediaFormat, KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE, 1);
            }
            setIPFrameMinMaxQP(mediaFormat);
            if (isBFrameEnabled()) {
                setBFrameMinMaxQP(mediaFormat);
            }
        }
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            RXLogging.w(TAG, "set android hardware encoder private param with Key:" + entry.getKey() + " Value:" + entry.getValue());
            if (isNumeric(entry.getValue())) {
                mediaFormat.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
            } else if (entry.getValue().length() > 0) {
                mediaFormat.setString(entry.getKey(), entry.getValue());
            }
        }
    }

    private boolean isBFrameEnabled() {
        return Build.VERSION.SDK_INT >= 29 && this.settings.bFrameNum > 0;
    }

    private boolean isDeviceSupportResetBitrate() {
        return !"M2007J17C".equalsIgnoreCase(RXDeviceInfoAndroid.GetDeviceModel());
    }

    private boolean isForceUseSurfaceInput(int i) {
        if ((this.codecName.toLowerCase().contains("qti") || this.codecName.toLowerCase().contains("qcom")) && isBFrameEnabled()) {
            return true;
        }
        Boolean bool = this.forceSurfaceInput;
        if ((bool == null || !bool.booleanValue() || this.isNeedSurfaceInputWorkaround) ? false : true) {
            return true;
        }
        return this.isNeedSurfaceInputWorkaround && i % 16 != 0;
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("[0-9]+");
    }

    private boolean isSvcEnabled() {
        return this.settings.temporalLayerNum > 1;
    }

    private int parseRealLayerNum(MediaFormat mediaFormat) {
        String string = mediaFormat.getString(IMediaFormat.KEY_TEMPORAL_LAYERING);
        if (TextUtils.isEmpty(string) || string.length() < 17) {
            RXLogging.w(TAG, "output temporal str is: " + string);
            return 1;
        }
        String strSubstring = string.substring(16, 17);
        if (isNumeric(strSubstring)) {
            try {
                int i = Integer.parseInt(strSubstring);
                if (i <= this.settings.temporalLayerNum && i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                RXLogging.e(TAG, e.toString());
            }
        }
        RXLogging.e(TAG, "temporal layer invalid: " + string);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e) {
            RXLogging.e(TAG, "Media encoder stop failed", e);
        }
        try {
            this.codec.release();
        } catch (Exception e2) {
            RXLogging.e(TAG, "Media encoder release failed", e2);
            this.shutdownException = e2;
        }
        this.configBuffer = null;
        RXLogging.i(TAG, "Release on output thread done");
    }

    private VideoCodecStatus resetCodec(int i, int i2, boolean z) {
        this.encodeThreadChecker.checkIsOnValidThread();
        VideoCodecStatus videoCodecStatusRelease = release();
        if (videoCodecStatusRelease != VideoCodecStatus.OK) {
            return videoCodecStatusRelease;
        }
        this.width = i;
        this.height = i2;
        this.useSurfaceMode = z;
        this.settings.targetBps = this.updateBitrate;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        return initEncodeInternal();
    }

    private void resetCodecWhenBitrateChange() {
        if ((isDeviceSupportResetBitrate() || this.updateBitrate == this.settings.targetBps || SystemClock.elapsedRealtime() - this.updateBitrateTimestamp < 5000) ? false : true) {
            resetCodec(this.width, this.height, this.useSurfaceMode);
        }
    }

    private void setBFrameMinMaxQP(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 31) {
            setIntegerParam(mediaFormat, "video-qp-b-max", Integer.valueOf(this.settings.maxQp));
            setIntegerParam(mediaFormat, "video-qp-b-min", Integer.valueOf(this.settings.minQp));
        }
        if (this.codecName.toLowerCase().contains("qti")) {
            setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-b-min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-b-max", Integer.valueOf(this.settings.maxQp));
        }
    }

    private void setBFrameNumber(MediaFormat mediaFormat) {
        if (isBFrameEnabled()) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_MAX_B_FRAMES, 1);
        } else {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_MAX_B_FRAMES, 0);
        }
    }

    private void setBitrateMode(MediaFormat mediaFormat) {
        this.codec.getCodecInfo();
        VideoEncoder.BitrateMode bitrateMode = VideoEncoder.BitrateMode.CBR;
        VideoEncoder.BitrateMode bitrateMode2 = this.settings.bitrateMode;
        if (bitrateMode == bitrateMode2 || VideoEncoder.BitrateMode.AUTO == bitrateMode2) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_BITRATE_MODE, 2);
        } else {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_BITRATE_MODE, 1);
        }
    }

    private void setExtCodecForHisi(int i, int i2) {
        MediaCodecWrapper mediaCodecWrapper;
        MediaFormat outputFormat;
        if (!this.codecName.contains("OMX.hisi.") || (mediaCodecWrapper = this.codec) == null) {
            return;
        }
        try {
            outputFormat = mediaCodecWrapper.getOutputFormat();
        } catch (Exception e) {
            RXLogging.e(TAG, "getOutputFormat failed", e);
            outputFormat = null;
        }
        if (outputFormat == null) {
            return;
        }
        RXLogging.i(TAG, "output format before start: " + outputFormat.toString());
        boolean z = false;
        boolean z2 = outputFormat.containsKey(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) && outputFormat.getInteger(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) == 1;
        if (outputFormat.containsKey(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) && outputFormat.getInteger(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) == 1) {
            z = true;
        }
        Bundle bundle = new Bundle();
        if (z && isSvcEnabled() && this.svcRealLayerNum <= 1) {
            bundle.putInt(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES, 1);
            this.svcRealLayerNum = 2;
            RXLogging.w(TAG, "support Non Ref PFrame.");
        }
        if (z2) {
            bundle.putInt(KEY_HISI_EXT_CODEC_MAX_QP, i);
            bundle.putInt(KEY_HISI_EXT_CODEC_MIN_QP, i2);
        }
        if (z || z2) {
            try {
                this.codec.setParameters(bundle);
            } catch (Exception e2) {
                RXLogging.e(TAG, "setExtCodecForHisi failed", e2);
            }
        }
    }

    private void setIPFrameMinMaxQP(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 31) {
            setIntegerParam(mediaFormat, "video-qp-i-min", Integer.valueOf(this.settings.minIQp));
            setIntegerParam(mediaFormat, "video-qp-i-max", Integer.valueOf(this.settings.maxIQp));
            setIntegerParam(mediaFormat, "video-qp-p-min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(mediaFormat, "video-qp-p-max", Integer.valueOf(this.settings.maxQp));
        }
        setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(mediaFormat, "vendor.qti-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(mediaFormat, "vendor.rtc-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(mediaFormat, "vendor.rtc-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(mediaFormat, "vendor.rtc-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(mediaFormat, "vendor.rtc-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(mediaFormat, "vendor.rtc-ext-enc-low-latency.enable", 1);
        if (this.codecName.toLowerCase().contains("exynos")) {
            setIntegerParam(mediaFormat, "vendor.sec-ext-enc-qp-range.I-minQP", Integer.valueOf(this.settings.minIQp));
            setIntegerParam(mediaFormat, "vendor.sec-ext-enc-qp-range.I-maxQP", Integer.valueOf(this.settings.maxIQp));
            setIntegerParam(mediaFormat, "vendor.sec-ext-enc-qp-range.P-maxQP", Integer.valueOf(this.settings.maxQp));
            setIntegerParam(mediaFormat, "vendor.sec-ext-enc-qp-range.P-minQP", Integer.valueOf(this.settings.minQp));
        }
        if (this.codecName.toLowerCase().contains("mtk")) {
            setIntegerParam(mediaFormat, "vendor.mtk.venc.dynamic.qpbound.min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(mediaFormat, "vendor.mtk.venc.dynamic.qpbound.max", Integer.valueOf(this.settings.maxQp));
        }
    }

    private void setIntegerParam(MediaFormat mediaFormat, String str, Integer num) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(str)) {
                if (isNumeric(entry.getValue())) {
                    mediaFormat.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
                    RXLogging.w(TAG, "the encoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                    this.privateParams.remove(str);
                    return;
                }
                this.privateParams.remove(str);
                if (entry.getValue().length() <= 0) {
                    RXLogging.w(TAG, "the encoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                    return;
                }
                RXLogging.w(TAG, "the encoder params " + entry.getKey() + " set by vpaas is invalid with value:" + entry.getValue() + ",skip it");
            }
        }
        RXLogging.w(TAG, "encoder int params has been set with Key:" + str + " Value:" + num);
        mediaFormat.setInteger(str, num.intValue());
    }

    private void setProfileForLive(MediaFormat mediaFormat) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel;
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        MediaCodecInfo codecInfo = this.codec.getCodecInfo();
        RXVideoCodecProfile profile = this.codecDesc.getProfile();
        int systemProfile = 1;
        if (standard != RXVideoCodecStandard.H264) {
            if (standard == RXVideoCodecStandard.ByteVC1) {
                try {
                    systemProfile = profile.toSystemProfile();
                } catch (Exception e) {
                    RXLogging.w(TAG, "" + e);
                }
                mediaFormat.setInteger(IMediaFormat.KEY_PROFILE, systemProfile);
                mediaFormat.setInteger("level", 256);
                return;
            }
            return;
        }
        try {
            systemProfile = profile.toSystemProfile();
        } catch (Exception e2) {
            RXLogging.w(TAG, "" + e2);
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecInfo.getCapabilitiesForType(standard.mimeType()).profileLevels;
        int length = codecProfileLevelArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                codecProfileLevel = null;
                break;
            }
            codecProfileLevel = codecProfileLevelArr[i];
            if (systemProfile == codecProfileLevel.profile) {
                break;
            } else {
                i++;
            }
        }
        if (codecProfileLevel == null) {
            RXLogging.w(TAG, "not set profile");
        } else {
            mediaFormat.setInteger(IMediaFormat.KEY_PROFILE, codecProfileLevel.profile);
            mediaFormat.setInteger("level", codecProfileLevel.level);
        }
    }

    private void setProfileForRTC(MediaFormat mediaFormat) {
        RXLogging.w(TAG, "close setting profile:" + this.settings.closeSetProfile);
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        if (this.settings.closeSetProfile) {
            return;
        }
        if (standard == RXVideoCodecStandard.H264) {
            RXVideoCodecProfile profile = this.codecDesc.getProfile();
            int i = AnonymousClass2.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[profile.ordinal()];
            if (i == 1 || i == 2) {
                RXLogging.w(TAG, "setting high profile ");
                setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 8);
                setIntegerParam(mediaFormat, "level", 256);
                return;
            } else {
                if (i == 3 || i == 4 || i == 5) {
                    RXLogging.w(TAG, "setting baseline profile ");
                    setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 1);
                    setIntegerParam(mediaFormat, "level", 256);
                    return;
                }
                RXLogging.w(TAG, "Unknown profile level id: " + profile + "default to baseline profile");
                setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 1);
                setIntegerParam(mediaFormat, "level", 256);
                return;
            }
        }
        if (standard != RXVideoCodecStandard.ByteVC1) {
            if (standard == RXVideoCodecStandard.VP8) {
                setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 1);
                return;
            }
            return;
        }
        RXVideoCodecProfile profile2 = this.codecDesc.getProfile();
        int i2 = AnonymousClass2.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[profile2.ordinal()];
        if (i2 == 6) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 1);
            setIntegerParam(mediaFormat, "level", 8);
            return;
        }
        if (i2 == 7) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 2);
            setIntegerParam(mediaFormat, "level", 8);
            return;
        }
        if (i2 == 8) {
            setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 4096);
            setIntegerParam(mediaFormat, "level", 8);
            return;
        }
        RXLogging.w(TAG, "Unknown profile level id: " + profile2 + "default to Main profile");
        setIntegerParam(mediaFormat, IMediaFormat.KEY_PROFILE, 1);
        setIntegerParam(mediaFormat, "level", 8);
    }

    private void setSVCNumber(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT < 25 || !isSvcEnabled()) {
            return;
        }
        setStringParam(mediaFormat, IMediaFormat.KEY_TEMPORAL_LAYERING, "android.generic." + this.settings.temporalLayerNum);
    }

    private void setStringParam(MediaFormat mediaFormat, String str, String str2) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(str)) {
                if (entry.getValue().length() > 0) {
                    mediaFormat.setString(entry.getKey(), entry.getValue());
                    RXLogging.w(TAG, "the encoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                } else {
                    RXLogging.w(TAG, "the encoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                }
                this.privateParams.remove(str);
                return;
            }
        }
        RXLogging.w(TAG, "encoder string params has been set with Key:" + str + " Value:" + str2);
        mediaFormat.setString(str, str2);
    }

    private boolean shouldForceKeyFrame(long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long j2 = this.forcedKeyFrameNs;
        return j2 > 0 && j > this.lastKeyFrameNs + j2;
    }

    private VideoCodecStatus updateBitrate(int i) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.updateBitrate = i;
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i);
            this.codec.setParameters(bundle);
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.e(TAG, "updateBitrate failed", e);
            return VideoCodecStatus.ERROR;
        }
    }

    public void deliverEncodedImage() {
        ByteBuffer byteBufferSlice;
        try {
            this.outputThreadChecker.checkIsOnValidThread();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
                if (iDequeueOutputBuffer == -2) {
                    RXLogging.i(TAG, "output format changed: " + this.codec.getOutputFormat().toString());
                    return;
                }
                if (iDequeueOutputBuffer == -1) {
                    return;
                }
                if (iDequeueOutputBuffer != -3 && iDequeueOutputBuffer < 0) {
                    RXLogging.e(TAG, "should not be here: index:" + iDequeueOutputBuffer);
                    return;
                }
                ByteBuffer byteBuffer = this.codec.getOutputBuffers()[iDequeueOutputBuffer];
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                int i = bufferInfo.flags;
                if ((i & 2) != 0) {
                    RXLogging.i(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.configBuffer = byteBufferAllocateDirect;
                    byteBufferAllocateDirect.put(byteBuffer);
                } else {
                    boolean z = true;
                    if ((i & 1) == 0) {
                        z = false;
                    }
                    if (z) {
                        RXLogging.i(TAG, "Sync frame generated");
                    }
                    if (z && (this.codecDesc.getStandard() == RXVideoCodecStandard.H264 || this.codecDesc.getStandard() == RXVideoCodecStandard.ByteVC1)) {
                        RXLogging.i(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                        byteBufferSlice = ByteBuffer.allocateDirect(bufferInfo.size + this.configBuffer.capacity());
                        this.configBuffer.rewind();
                        byteBufferSlice.put(this.configBuffer);
                        byteBufferSlice.put(byteBuffer);
                        byteBufferSlice.rewind();
                    } else {
                        byteBufferSlice = byteBuffer.slice();
                    }
                    EncodedImage.Builder frameType = EncodedImage.builder().setEncodedWidth(this.width).setEncodedHeight(this.height).setCaptureTimeNs(bufferInfo.presentationTimeUs * 1000).setBuffer(byteBufferSlice).setSvcLayerNum(this.svcRealLayerNum).setFrameType(z ? EncodedImage.FrameType.kIntra : EncodedImage.FrameType.kPredicted);
                    caculateDts(bufferInfo.presentationTimeUs, frameType);
                    this.callback.onEncodedFrame(frameType.createEncodedImage(), new VideoEncoder.CodecSpecificInfo(this.codecDesc.getStandard()));
                }
                this.codec.releaseOutputBuffer(iDequeueOutputBuffer, false);
            } catch (Exception e) {
                if (System.currentTimeMillis() - jCurrentTimeMillis < 100) {
                    RXLogging.e(TAG, "deliverOutput failed", e);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (IllegalStateException unused) {
            RXLogging.e(TAG, "the encoded image is last encoder data, drop it");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    @Override // com.bytedance.realx.video.VideoEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoCodecStatus encode(RXVideoFrameInterface rXVideoFrameInterface, boolean z) {
        this.encodeThreadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error(TAG);
        if (this.codec == null) {
            return VideoCodecStatus.UNINITIALIZED;
        }
        RXVideoMemoryInterface andRetainVideoFrameMemory = rXVideoFrameInterface.getAndRetainVideoFrameMemory();
        if (andRetainVideoFrameMemory == null) {
            return VideoCodecStatus.MEMORY;
        }
        boolean z2 = andRetainVideoFrameMemory instanceof NativeRXOpenGLMemory;
        Boolean bool = this.isTextureBuffer;
        if (bool == null || bool.booleanValue() != z2) {
            this.isTextureBuffer = Boolean.valueOf(z2);
            RXLogging.e(TAG, "isTextureBuffer: " + this.isTextureBuffer);
        }
        int width = rXVideoFrameInterface.getWidth();
        int height = rXVideoFrameInterface.getHeight();
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = canUseSurface() && (z2 || isForceUseSurfaceInput(width));
        if (z5 && z2) {
            EglBase14.Context context = new EglBase14.Context(((NativeRXOpenGLMemory) andRetainVideoFrameMemory).getEGLContext());
            if (this.sharedContext == null || context.getNativeEglContext() != this.sharedContext.getNativeEglContext()) {
                this.sharedContext = context;
            }
        } else {
            z3 = false;
        }
        andRetainVideoFrameMemory.release();
        if (z5 != this.useSurfaceMode) {
            VideoCodecStatus videoCodecStatusResetCodec = resetCodec(width, height, z5);
            if (videoCodecStatusResetCodec != VideoCodecStatus.OK) {
                return videoCodecStatusResetCodec;
            }
        } else {
            z4 = z3;
        }
        if (z4 && this.useSurfaceMode && !RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
            RXLogging.w(TAG, "egl env changed, create new shared context from the new videoframe egl context");
            this.textureDrawer.release();
            this.videoFrameDrawer.release();
            this.textureDrawer = new GlRectDrawer();
            this.videoFrameDrawer = new VideoFrameDrawer();
            EglBase14 eglBase14 = this.textureEglBase;
            if (eglBase14 != null) {
                eglBase14.release();
                this.textureEglBase = null;
            }
            EglBase14 eglBase142 = new EglBase14(this.sharedContext, EglBase.CONFIG_RECORDABLE);
            this.textureEglBase = eglBase142;
            eglBase142.createSurface(this.textureInputSurface);
            try {
                this.textureEglBase.makeCurrent();
            } catch (Exception e) {
                RXLogging.e(TAG, "egl makeCurrent failed", e);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        }
        resetCodecWhenBitrateChange();
        if (z) {
            RXLogging.i(TAG, "Request key frame");
        }
        if (z || shouldForceKeyFrame(rXVideoFrameInterface.getTimestampNs())) {
            requestKeyFrame(rXVideoFrameInterface.getTimestampNs());
        }
        if (isBFrameEnabled()) {
            this.dtsQueue.push(Long.valueOf(rXVideoFrameInterface.getTimestampUs()));
        }
        VideoCodecStatus videoCodecStatusEncodeTextureBuffer = this.useSurfaceMode ? encodeTextureBuffer(rXVideoFrameInterface) : encodeByteBuffer(rXVideoFrameInterface);
        if (videoCodecStatusEncodeTextureBuffer != VideoCodecStatus.OK && isBFrameEnabled()) {
            this.dtsQueue.pollFirst();
        }
        return videoCodecStatusEncodeTextureBuffer;
    }

    public void fillInputBuffer(ByteBuffer byteBuffer, RXVideoFrameInterface rXVideoFrameInterface) {
        this.yuvFormat.fillBuffer(byteBuffer, rXVideoFrameInterface);
    }

    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn) {
            RXVideoCodecStandard standard = this.codecDesc.getStandard();
            RXVideoCodecStandard rXVideoCodecStandard = RXVideoCodecStandard.VP8;
            if (standard == rXVideoCodecStandard) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (this.codecDesc.getStandard() == rXVideoCodecStandard) {
                return new VideoEncoder.ScalingSettings(24, 37);
            }
        }
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.sharedContext = settings.sharedContext;
        this.callback = callback;
        this.automaticResizeOn = true;
        this.width = settings.width;
        this.height = settings.height;
        this.scaleMode = settings.scaleMode;
        this.bitrateMode = settings.bitrateMode;
        this.updateBitrate = settings.targetBps;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.settings = settings;
        if (RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
            RXLogging.e(TAG, "using pass surface mode");
            this.useSurfaceMode = true;
        } else {
            this.useSurfaceMode = canUseSurface() && settings.useSurfaceMode && this.sharedContext != null;
            if (isForceUseSurfaceInput(this.width)) {
                this.useSurfaceMode = true;
            }
        }
        RXLogging.w(TAG, "initEncode, codec name:" + this.codecName + ", with resolution:" + this.width + " x " + this.height + ". @ " + settings.targetBps + "bps. Fps: " + settings.targetFps + " Use surface mode: " + this.useSurfaceMode + " initUseSurfaceMode: " + settings.useSurfaceMode + " settings.bitrateMode:" + settings.bitrateMode + " qp_min:" + settings.minQp + " qp_max:" + settings.maxQp + " qp_i_min:" + settings.minIQp + " qp_i_max:" + settings.maxIQp);
        return initEncodeInternal();
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus release() {
        VideoCodecStatus videoCodecStatus;
        this.encodeThreadChecker.checkIsOnValidThread();
        RXLogging.w(TAG, "hardware video encoder release start.");
        if (this.outputThread == null) {
            videoCodecStatus = VideoCodecStatus.OK;
        } else {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                RXLogging.e(TAG, "Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                RXLogging.e(TAG, "Media encoder release exception", this.shutdownException);
                videoCodecStatus = VideoCodecStatus.ERROR;
            } else {
                videoCodecStatus = VideoCodecStatus.OK;
            }
        }
        RXLogging.w(TAG, "Media encoder release ok.");
        this.textureDrawer.release();
        RXLogging.w(TAG, "textureDrawer release ok.");
        this.videoFrameDrawer.release();
        RXLogging.w(TAG, "videoFrameDrawer release ok.");
        EglBase14 eglBase14 = this.textureEglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.textureEglBase = null;
        }
        RXLogging.w(TAG, "textureEglBase release ok.");
        Surface surface = this.textureInputSurface;
        if (surface != null) {
            surface.release();
            this.textureInputSurface = null;
        }
        RXLogging.w(TAG, "textureInputSurface release ok.");
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        RXLogging.w(TAG, "hardware video encoder release end.");
        return videoCodecStatus;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus requestKeyFrame() {
        requestKeyFrame(System.currentTimeMillis());
        return VideoCodecStatus.OK;
    }

    public void setColorSpace(MediaFormat mediaFormat) {
        if (!this.useSurfaceMode && this.codecName.contains("OMX.hisi.") && this.settings.rangeId == 0 && (this.yuvColorFormat.intValue() == 19 || this.yuvColorFormat.intValue() == 21)) {
            RXLogging.w(TAG, "kirin chips skip setting MediaFormat COLOR_RANGE");
        } else if (this.settings.rangeId == 1) {
            RXLogging.w(TAG, "setting MediaFormat COLOR_RANGE_FULL");
            setIntegerParam(mediaFormat, IMediaFormat.KEY_COLOR_RANGE, 1);
        } else {
            RXLogging.w(TAG, "setting MediaFormat COLOR_RANGE_LIMITED");
            setIntegerParam(mediaFormat, IMediaFormat.KEY_COLOR_RANGE, 2);
        }
        setIntegerParam(mediaFormat, IMediaFormat.KEY_COLOR_STANDARD, 4);
        setIntegerParam(mediaFormat, IMediaFormat.KEY_COLOR_TRANSFER, 3);
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setPrivateParam(String str, String str2) {
        RXLogging.w(TAG, "got android hardware encoder setPrivateParam with key:" + str + " value:" + str2);
        str.hashCode();
        if (str.equals(KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT)) {
            this.forceSurfaceInput = Boolean.valueOf(ex.Code.equalsIgnoreCase(str2));
        } else {
            this.vpassPrivateParams.put(str, str2);
        }
        return VideoCodecStatus.OK;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setRateAllocation(int i, int i2) {
        this.encodeThreadChecker.checkIsOnValidThread();
        updateBitrate(i);
        return VideoCodecStatus.OK;
    }

    private void requestKeyFrame(long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.codec.setParameters(bundle);
            this.lastKeyFrameNs = j;
        } catch (Exception e) {
            RXLogging.e(TAG, "requestKeyFrame failed", e);
        }
    }
}
