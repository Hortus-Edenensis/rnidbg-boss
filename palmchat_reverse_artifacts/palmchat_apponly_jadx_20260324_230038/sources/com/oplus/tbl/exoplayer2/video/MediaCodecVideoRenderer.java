package com.oplus.tbl.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.FormatHolder;
import com.oplus.tbl.exoplayer2.FrameTimeRecorder;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecAdapter;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecInfo;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecSelector;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecUtil;
import com.oplus.tbl.exoplayer2.mediacodec.MediaFormatUtil;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.util.VideoSize;
import com.oplus.tbl.exoplayer2.video.CompositingVideoSinkProvider;
import com.oplus.tbl.exoplayer2.video.VideoFrameReleaseControl;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tbl.exoplayer2.video.VideoSink;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import defpackage.er3;
import defpackage.rv4;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final long BUFFER_NORMAL_RELEASE_DURATION_US = 10000;
    private static final int DEFAULT_HEIGHT = 0;
    private static final float DEFAULT_PIXEL_WIDTH_HEIGHT_RATIO = 1.0f;
    private static final int DEFAULT_UNAPPLIED_ROTATION_DEGREES = 0;
    private static final int DEFAULT_WIDTH = 0;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_BUFFERS_NEED_TO_DROP = 3;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {TECameraUtils.CAPTURE_NORMAL, 1600, 1440, 1280, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 540, TECameraSettings.FPS_480};
    private static final long TOLERANCE_OFFSET_US = 1000;
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private String TAG;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;

    @Nullable
    private Surface dummySurface;
    private AtomicBoolean dynamicWallpaperEnabled;
    private boolean enableVideoEffect;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private long fastRendererTimeUs;

    @Nullable
    private VideoFrameMetadataListener frameMetadataListener;
    private VideoFrameReleaseOldHelper frameReleaseHelper;
    private boolean hasEffects;
    private boolean hasInitializedPlayback;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private boolean isFormatExceededSpec;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastFrameReleaseTimeNs;
    private long lastRenderRealtimeUs;
    private long mExpectedPresentationTimeEndUs;
    private boolean mIsReachedEndPosition;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private boolean needDropFrame;

    @Nullable
    private Size outputResolution;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private VideoStuckDetector stuckDetector;

    @Nullable
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;

    @Nullable
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;
    private VideoFrameReleaseControl videoFrameReleaseControl;
    private VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo;

    @Nullable
    private VideoSink videoSink;
    private VideoSinkProvider videoSinkProvider;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public final class OnFrameRenderedListenerV23 implements Handler.Callback, MediaCodecAdapter.OnFrameRenderedListener {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = handlerCreateHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, handlerCreateHandlerForCurrentLooper);
        }

        private void handleFrameRendered(long j) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener || mediaCodecVideoRenderer.getCodec() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util.SDK_INT >= 30) {
                handleFrameRendered(j);
            } else {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
            }
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f, false);
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    @RequiresApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger(IMediaFormat.KEY_AUDIO_SESSION_ID, i);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            Method dump skipped, instruction units count: 3034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        int i3;
        int iCeilDivide;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iCeilDivide = i * i2;
                i3 = 2;
                break;
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iCeilDivide = i * i2;
                break;
            case "video/avc":
                String str2 = Util.MODEL;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(Util.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !mediaCodecInfo.secure)))) {
                    iCeilDivide = Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 16 * 16;
                    i3 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i6, i4);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, format.frameRate)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                try {
                    int iCeilDivide = Util.ceilDivide(i4, 16) * 16;
                    int iCeilDivide2 = Util.ceilDivide(i5, 16) * 16;
                    if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i7 = z ? iCeilDivide2 : iCeilDivide;
                        if (!z) {
                            iCeilDivide = iCeilDivide2;
                        }
                        return new Point(i7, iCeilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += format.initializationData.get(i).length;
        }
        return format.maxInputSize + length;
    }

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    private void maybeDetectStuckForStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.detectStuck();
    }

    private void maybeEnableStuckDetector(boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.enable(z);
    }

    private void maybeInitializeStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.initialize(this.eventDispatcher);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i == -1 && this.currentHeight == -1) {
            return;
        }
        if (this.reportedWidth == i && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeOnDroppedOutputBufferForStuckDetector(int i, boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onDroppedOutputBuffer(i, z);
    }

    private void maybeOnQueueInputBufferForStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onQueuedInputBuffer();
    }

    private void maybeOnRenderedOutputBufferForStuckDetector(long j) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onRenderedOutputBuffer(j / 1000);
    }

    private void maybeOnSetFrameRateForStuckDetector(float f) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onSetFrameRate(f);
    }

    private void maybeOnSkippedOutputBufferForStuckDetector(int i, boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onSkippedOutputBuffer(i, z);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Surface surface = this.surface;
        if (surface == null || !this.haveReportedFirstFrameRenderedForCurrentSurface) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(surface);
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void maybeResetStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.reset();
    }

    private void maybeStartStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.start();
    }

    private void maybeStopStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.stop();
    }

    private void maybeUpdateOnFrameRenderedListener() {
        MediaCodecAdapter codec;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    private void maybeUpdateTimeForStuckDetector(long j) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.updateTime(j / 1000);
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    private void notifyRenderedFirstFrame() {
        this.eventDispatcher.renderedFirstFrame(this.surface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @RequiresApi(29)
    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(IMediaFormat.KEY_HDR10_PLUS_INFO, bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        boolean z;
        Log.d(this.TAG, "setSurface is " + surface);
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface == surface) {
            if (surface == null || surface == this.dummySurface) {
                return;
            }
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
            return;
        }
        this.surface = surface;
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.setOutputSurface(surface);
        } else {
            this.frameReleaseHelper.onSurfaceChanged(surface);
        }
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null && (!(z = this.enableVideoEffect) || (z && !this.videoSinkProvider.isInitialized()))) {
            if (Util.SDK_INT < 23 || surface == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                setOutputSurfaceV23(codec, surface);
            }
        }
        if (surface == null || surface == this.dummySurface) {
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            if (this.enableVideoEffect && this.videoSinkProvider.isInitialized()) {
                this.videoSinkProvider.clearOutputSurfaceInfo();
            }
        } else {
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                if (this.enableVideoEffect) {
                    this.videoFrameReleaseControl.join();
                } else {
                    setJoiningDeadlineMs();
                }
            }
        }
        if (this.enableVideoEffect) {
            maybeUpdateOnFrameRenderedListener();
        }
    }

    private void setVideoSinkProvider(VideoSinkProvider videoSinkProvider) {
        if (videoSinkProvider == null) {
            Log.d(this.TAG, "will create a new VideoSinkProvider.");
            videoSinkProvider = new CompositingVideoSinkProvider.Builder(this.context).build();
        }
        this.videoSinkProvider = videoSinkProvider;
        if (this.videoSinkProvider.getVideoFrameReleaseControl() == null) {
            this.videoSinkProvider.setVideoFrameReleaseControl(new VideoFrameReleaseControl(this.context, this, this.allowedJoiningTimeMs));
            this.videoFrameReleaseControl = (VideoFrameReleaseControl) Assertions.checkStateNotNull(this.videoSinkProvider.getVideoFrameReleaseControl());
            this.videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
        }
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void updateRenderedBufferCounter(long j) {
        this.decoderCounters.renderedOutputBufferCount++;
        maybeOnRenderedOutputBufferForStuckDetector(j);
    }

    private void updateSkippedBufferCounters(int i, boolean z) {
        this.decoderCounters.skippedOutputBufferCount += i;
        maybeOnSkippedOutputBufferForStuckDetector(i, z);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i = decoderReuseEvaluationCanReuseCodec.discardReasons;
        int i2 = format2.width;
        CodecMaxValues codecMaxValues = this.codecMaxValues;
        if (i2 > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i |= 64;
        }
        int i3 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i3 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i3);
    }

    public boolean codecNeedsForceRenderWorkaround() {
        return false;
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.surface == null) {
            if (!shouldUseDummySurface(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        VideoSink videoSink = this.videoSink;
        mediaCodecAdapter.configure(mediaFormat, videoSink != null ? videoSink.getInputSurface() : this.surface, mediaCrypto, 0);
        if (Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodecAdapter);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.surface);
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        if (this.enableVideoEffect) {
            updateDroppedBufferCounters(0, 1);
        } else {
            updateDroppedBufferCounters(1, false);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void enableMayRenderStartOfStream() {
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
        }
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            Format formatBuild = formatArr[i];
            if (format.colorInfo != null && formatBuild.colorInfo == null) {
                formatBuild = formatBuild.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, formatBuild).result != 0) {
                int i2 = formatBuild.width;
                z |= i2 == -1 || formatBuild.height == -1;
                iMax = Math.max(iMax, i2);
                iMax2 = Math.max(iMax2, formatBuild.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, formatBuild));
            }
        }
        if (z) {
            Log.w(this.TAG, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, iMax, iMax2));
                Log.w(this.TAG, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f2 = format2.frameRate;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, z, this.tunneling);
    }

    public DropFrameManager getDropFrameManager() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public long getLastPresentTimeUs() {
        return this.lastBufferPresentationTimeUs;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, IMediaFormat.KEY_FRAME_RATE, format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, IMediaFormat.KEY_ROTATION, format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, IMediaFormat.KEY_PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger(IMediaFormat.KEY_MAX_WIDTH, codecMaxValues.width);
        mediaFormat.setInteger(IMediaFormat.KEY_MAX_HEIGHT, codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, IMediaFormat.KEY_MAX_INPUT_SIZE, codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat(IMediaFormat.KEY_OPERATING_RATE, f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer, com.oplus.tbl.exoplayer2.RendererCapabilities
    public String getName() {
        return this.TAG;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public boolean getRenderedFirstFrame() {
        return this.renderedFirstFrameAfterReset;
    }

    public Surface getSurface() {
        return this.surface;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29(getCodec(), bArr);
                    }
                }
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i == 1) {
            setSurface((Surface) obj);
        }
        if (i == 4) {
            this.scalingMode = ((Integer) Assertions.checkNotNull(obj)).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i == 6) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            this.frameMetadataListener = videoFrameMetadataListener;
            if (this.enableVideoEffect) {
                this.videoSinkProvider.setVideoFrameMetadataListener(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i == 102) {
            int iIntValue = ((Integer) Assertions.checkNotNull(obj)).intValue();
            if (this.tunnelingAudioSessionId != iIntValue) {
                this.tunnelingAudioSessionId = iIntValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 20000) {
            this.dynamicWallpaperEnabled.set(((Boolean) obj).booleanValue());
            return;
        }
        if (i == 30000) {
            if (!this.enableVideoEffect || this.videoSinkProvider == null) {
                return;
            }
            Log.d(this.TAG, " VideoEffect MSG_SET_VIDEO_OUTPUT_COLOR_INFO ");
            this.videoSinkProvider.setOutputColorInfo(true, ((Integer) Assertions.checkNotNull(obj)).intValue());
            return;
        }
        if (i == 11000) {
            maybeResetStuckDetector();
            return;
        }
        if (i == 11001) {
            maybeEnableStuckDetector(((Boolean) obj).booleanValue());
            return;
        }
        switch (i) {
            case 12:
                if (getDropFrameManager() != null) {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("MSG_SET_DROP_FRAME_POLICY:");
                    Integer num = (Integer) obj;
                    sb.append(num.intValue());
                    Log.d(str, sb.toString());
                    getDropFrameManager().initialize(num.intValue());
                }
                break;
            case 13:
                if (this.enableVideoEffect) {
                    setVideoSinkProvider(this.videoSinkProvider);
                    setVideoEffects((List) Assertions.checkNotNull(obj));
                    Log.d(this.TAG, "VideoEffect has success setting.");
                }
                break;
            case 14:
                if (this.enableVideoEffect) {
                    this.videoFrameReleaseControl.setChangeFrameRateStrategy(((Integer) Assertions.checkNotNull(obj)).intValue());
                }
                break;
            case 15:
                if (this.enableVideoEffect) {
                    this.outputResolution = (Size) Assertions.checkNotNull(obj);
                    Log.d(this.TAG, "VideoEffect MSG_SET_VIDEO_OUTPUT_RESOLUTION width " + this.outputResolution.getWidth() + " height " + this.outputResolution.getHeight());
                    if (this.videoSinkProvider.isInitialized() && ((Size) Assertions.checkNotNull(this.outputResolution)).getWidth() != 0 && ((Size) Assertions.checkNotNull(this.outputResolution)).getHeight() != 0 && (surface = this.surface) != null) {
                        this.videoSinkProvider.setOutputSurfaceInfo(surface, (Size) Assertions.checkNotNull(this.outputResolution));
                        break;
                    }
                }
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isAbnormalSurface() {
        Surface surface = this.surface;
        return surface == null || surface == this.dummySurface;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean isBufferFull() {
        return codecNeedsForceRenderWorkaround() ? this.buffersInCodecCount > 1 : this.dynamicWallpaperEnabled.get() && this.buffersInCodecCount >= 3;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isEnded() {
        VideoSink videoSink;
        return super.isEnded() && ((videoSink = this.videoSink) == null || videoSink.isEnded());
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isReachEndPosition(long j) {
        return this.mIsReachedEndPosition;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        Surface surface2;
        VideoSink videoSink;
        boolean z = false;
        if (this.enableVideoEffect) {
            if (super.isReady() && ((videoSink = this.videoSink) == null || videoSink.isReady())) {
                z = true;
            }
            if (z && (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling)) {
                return true;
            }
            return this.videoFrameReleaseControl.isReady(z);
        }
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void maybeDetectStuck() {
        maybeDetectStuckForStuckDetector();
    }

    public boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        VideoSink videoSink;
        int iSkipSource = skipSource(j);
        if (iSkipSource == 0) {
            return false;
        }
        if (this.enableVideoEffect) {
            DecoderCounters decoderCounters = this.decoderCounters;
            if (z) {
                decoderCounters.skippedInputBufferCount += iSkipSource;
                decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
            } else {
                decoderCounters.droppedToKeyframeCount++;
                updateDroppedBufferCounters(iSkipSource, this.buffersInCodecCount);
            }
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            int i = this.buffersInCodecCount + iSkipSource;
            if (z) {
                updateSkippedBufferCounters(i, true);
            } else {
                updateDroppedBufferCounters(i, true);
            }
        }
        flushOrReinitializeCodec();
        if (this.enableVideoEffect && (videoSink = this.videoSink) != null) {
            videoSink.flush();
            Log.d(this.TAG, "VideoEffect VideoSink DropBuffersToKeyframe and flush");
        }
        return true;
    }

    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (this.renderedFirstFrameAfterReset) {
            return;
        }
        this.renderedFirstFrameAfterReset = true;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.eventDispatcher.renderedFirstFrame(this.surface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void maybeUpdateDetectorTime(long j) {
        maybeUpdateTimeForStuckDetector(j);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2, this.isFormatExceededSpec);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.onDisabled();
        } else {
            this.frameReleaseHelper.onDisabled();
        }
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            if (this.enableVideoEffect) {
                this.eventDispatcher.videoSizeChanged(0, 0, 0, 1.0f);
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState((z3 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.onEnabled(z2);
        } else {
            this.frameReleaseHelper.onEnabled();
        }
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onInit() {
        if (this.enableVideoEffect) {
            super.onInit();
            Clock clock = getClock();
            this.videoFrameReleaseControl.setClock(clock);
            this.videoSinkProvider.setClock(clock);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, decoderReuseEvaluationOnInputFormatChanged);
        maybeOnSetFrameRateForStuckDetector(formatHolder.format.frameRate);
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        int integer;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        int i = format.displayWidth;
        int i2 = format.displayHeight;
        if (this.tunneling) {
            this.currentWidth = format.width;
            integer = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            this.currentWidth = z ? (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : mediaFormat.getInteger("width");
            integer = z ? (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1 : mediaFormat.getInteger("height");
        }
        this.currentHeight = integer;
        float f = format.pixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if (Util.SDK_INT >= 21) {
            int i3 = format.rotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i4;
                this.currentPixelWidthHeightRatio = 1.0f / f;
                i2 = i;
                i = i2;
            }
        } else {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        }
        if (!this.enableVideoEffect) {
            this.frameReleaseHelper.onFormatChanged(format.frameRate);
            return;
        }
        this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        if (this.videoSink == null || mediaFormat == null) {
            return;
        }
        onReadyToRegisterVideoSinkInputStream();
        ((VideoSink) Assertions.checkNotNull(this.videoSink)).registerInputStream(1, format.buildUpon().setWidth(this.currentWidth).setHeight(this.currentHeight).setDisplayWidth(i).setDisplayHeight(i2).setRotationDegrees(this.currentUnappliedRotationDegrees).setPixelWidthHeightRatio(this.currentPixelWidthHeightRatio).build());
        Log.d(this.TAG, "VideoEffect FormatChanged:" + format);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        if (!this.enableVideoEffect) {
            super.onPositionReset(j, z);
            clearRenderedFirstFrame();
            this.frameReleaseHelper.onPositionReset();
            this.lastBufferPresentationTimeUs = -9223372036854775807L;
            this.initialPositionUs = -9223372036854775807L;
            this.fastRendererTimeUs = -9223372036854775807L;
            this.consecutiveDroppedFrameCount = 0;
            if (z) {
                setJoiningDeadlineMs();
            } else {
                this.joiningDeadlineMs = -9223372036854775807L;
            }
            maybeUpdateDetectorTime(j);
            return;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush();
        }
        super.onPositionReset(j, z);
        if (this.videoSinkProvider.isInitialized()) {
            this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
        }
        this.videoFrameReleaseControl.reset();
        if (z) {
            this.videoFrameReleaseControl.join();
        }
        maybeUpdateOnFrameRenderedListener();
        clearRenderedFirstFrame();
        this.lastBufferPresentationTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionResetInGop(long j, boolean z) {
        if (this.lastBufferPresentationTimeUs < j) {
            this.needDropFrame = true;
            clearRenderedFirstFrame();
            this.initialPositionUs = -9223372036854775807L;
            this.fastRendererTimeUs = -9223372036854775807L;
            maybeUpdateDetectorTime(j);
            return;
        }
        Log.d(this.TAG, "invalid positionUs:" + j + ",lastBufferPresentationTimeUs:" + this.lastBufferPresentationTimeUs);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
        if (codecNeedsForceRenderWorkaround()) {
            FrameTimeRecorder.getInstance().recordQueuedCodecFrameTime(j, 2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.onProcessedStreamChange();
            maybeUpdateOnFrameRenderedListener();
            if (this.videoSinkProvider.isInitialized()) {
                this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
            }
        }
    }

    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.tunneling;
        if (!z) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && z) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
        if (codecNeedsForceRenderWorkaround()) {
            FrameTimeRecorder.getInstance().recordQueuedCodecFrameTime(decoderInputBuffer.timeUs, 1);
        }
        maybeOnQueueInputBufferForStuckDetector();
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onReadyToInitializeCodec(Format format) throws ExoPlaybackException {
        Size size;
        if (this.enableVideoEffect) {
            if (this.hasEffects && !this.hasInitializedPlayback && !this.videoSinkProvider.isInitialized()) {
                try {
                    this.videoSinkProvider.initialize(format);
                    this.videoSinkProvider.setStreamOffsetUs(getOutputStreamOffsetUs());
                    VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
                    if (videoFrameMetadataListener != null) {
                        this.videoSinkProvider.setVideoFrameMetadataListener(videoFrameMetadataListener);
                    }
                    Surface surface = this.surface;
                    if (surface != null && (size = this.outputResolution) != null) {
                        this.videoSinkProvider.setOutputSurfaceInfo(surface, size);
                    }
                } catch (VideoSink.VideoSinkException e) {
                    throw createRendererException(e, format, 7000);
                }
            }
            if (this.videoSink == null && this.videoSinkProvider.isInitialized()) {
                VideoSink sink = this.videoSinkProvider.getSink();
                this.videoSink = sink;
                sink.setListener(new VideoSink.Listener() { // from class: com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer.1
                    @Override // com.oplus.tbl.exoplayer2.video.VideoSink.Listener
                    public void onError(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
                        MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                        mediaCodecVideoRenderer.setPendingPlaybackException(mediaCodecVideoRenderer.createRendererException(videoSinkException, videoSinkException.format, 7001));
                    }

                    @Override // com.oplus.tbl.exoplayer2.video.VideoSink.Listener
                    public void onFirstFrameRendered(VideoSink videoSink) {
                        Assertions.checkStateNotNull(MediaCodecVideoRenderer.this.surface);
                        MediaCodecVideoRenderer.this.maybeNotifyRenderedFirstFrame();
                        Log.d(MediaCodecVideoRenderer.this.TAG, "VideoEffect render first frame");
                    }

                    @Override // com.oplus.tbl.exoplayer2.video.VideoSink.Listener
                    public void onFrameDropped(VideoSink videoSink) {
                        MediaCodecVideoRenderer.this.updateDroppedBufferCounters(0, 1);
                    }

                    @Override // com.oplus.tbl.exoplayer2.video.VideoSink.Listener
                    public void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize) {
                        Log.d(MediaCodecVideoRenderer.this.TAG, "VideoEffect VideoSizeChanged width " + videoSize.width + " height " + videoSize.height);
                    }
                }, er3.a());
            }
            this.hasInitializedPlayback = true;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onRelease() {
        super.onRelease();
        VideoSinkProvider videoSinkProvider = this.videoSinkProvider;
        if (videoSinkProvider != null) {
            videoSinkProvider.release();
        }
        if (this.mExpectedPresentationTimeEndUs != -9223372036854775807L) {
            this.mExpectedPresentationTimeEndUs = -9223372036854775807L;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            super.onReset();
            boolean z = this.enableVideoEffect;
            if (z) {
                this.hasInitializedPlayback = false;
                if (z) {
                    VideoSink videoSink = this.videoSink;
                    if (videoSink != null) {
                        videoSink.flush();
                    }
                    VideoSinkProvider videoSinkProvider = this.videoSinkProvider;
                    if (videoSinkProvider != null) {
                        videoSinkProvider.release();
                        this.videoSinkProvider = null;
                        this.videoSink = null;
                        this.videoFrameReleaseControl.reset();
                        this.videoFrameReleaseControl = null;
                        this.videoFrameReleaseInfo = null;
                    }
                    maybeUpdateOnFrameRenderedListener();
                    clearRenderedFirstFrame();
                    this.lastBufferPresentationTimeUs = -9223372036854775807L;
                    this.initialPositionUs = -9223372036854775807L;
                    this.fastRendererTimeUs = -9223372036854775807L;
                    this.consecutiveDroppedFrameCount = 0;
                }
            }
            Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                surface.release();
                this.dummySurface = null;
            }
            if (this.mExpectedPresentationTimeEndUs != -9223372036854775807L) {
                this.mExpectedPresentationTimeEndUs = -9223372036854775807L;
            }
        } catch (Throwable th) {
            if (this.enableVideoEffect) {
                this.hasInitializedPlayback = false;
                if (this.enableVideoEffect) {
                    VideoSink videoSink2 = this.videoSink;
                    if (videoSink2 != null) {
                        videoSink2.flush();
                    }
                    VideoSinkProvider videoSinkProvider2 = this.videoSinkProvider;
                    if (videoSinkProvider2 != null) {
                        videoSinkProvider2.release();
                        this.videoSinkProvider = null;
                        this.videoSink = null;
                        this.videoFrameReleaseControl.reset();
                        this.videoFrameReleaseControl = null;
                        this.videoFrameReleaseInfo = null;
                    }
                    maybeUpdateOnFrameRenderedListener();
                    clearRenderedFirstFrame();
                    this.lastBufferPresentationTimeUs = -9223372036854775807L;
                    this.initialPositionUs = -9223372036854775807L;
                    this.fastRendererTimeUs = -9223372036854775807L;
                    this.consecutiveDroppedFrameCount = 0;
                }
            }
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                surface2.release();
                this.dummySurface = null;
            }
            if (this.mExpectedPresentationTimeEndUs != -9223372036854775807L) {
                this.mExpectedPresentationTimeEndUs = -9223372036854775807L;
            }
            throw th;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onSetFastRendererPosition(long j, boolean z) {
        Log.d(this.TAG, "onSetFastRendererPosition positionUs:" + j + ", initialPositionUs:" + this.initialPositionUs);
        this.fastRendererTimeUs = j;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.onStarted();
        } else {
            this.frameReleaseHelper.onStarted();
        }
        maybeStartStuckDetector();
        this.mIsReachedEndPosition = false;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStopped() {
        maybeStopStuckDetector();
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        if (this.enableVideoEffect) {
            this.videoFrameReleaseControl.onStopped();
        } else {
            this.frameReleaseHelper.onStopped();
        }
        super.onStopped();
        this.mIsReachedEndPosition = false;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        boolean z3;
        long jAdjustPresentTimeUs = j3;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j;
        }
        if (jAdjustPresentTimeUs >= this.initialPositionUs) {
            this.needDropFrame = false;
        }
        if (jAdjustPresentTimeUs != this.lastBufferPresentationTimeUs) {
            if (this.enableVideoEffect) {
                this.videoFrameReleaseControl.onNextFrame(jAdjustPresentTimeUs);
            } else {
                this.frameReleaseHelper.onNextFrame(jAdjustPresentTimeUs);
            }
            this.lastBufferPresentationTimeUs = jAdjustPresentTimeUs;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j4 = jAdjustPresentTimeUs - outputStreamOffsetUs;
        if ((z && !z2) || this.needDropFrame) {
            long j5 = this.fastRendererTimeUs;
            if (j5 == -9223372036854775807L || j5 > this.lastBufferPresentationTimeUs) {
                Log.d(this.TAG, "needDropFrame:" + this.needDropFrame + ", preTimeUs:" + j4 + ",initTimeUs:" + this.initialPositionUs);
                skipOutputBuffer(mediaCodecAdapter, i, j4);
                return true;
            }
        }
        if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
            if (!getDropFrameManager().canRender(jAdjustPresentTimeUs)) {
                Log.d(this.TAG, "can't render bufferPresentationTimeUs:" + jAdjustPresentTimeUs);
                skipOutputBuffer(mediaCodecAdapter, i, j4);
                return true;
            }
            jAdjustPresentTimeUs = getDropFrameManager().adjustPresentTimeUs(jAdjustPresentTimeUs);
            j4 = jAdjustPresentTimeUs - outputStreamOffsetUs;
        }
        double playbackSpeed = getPlaybackSpeed();
        boolean z4 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j6 = (long) ((jAdjustPresentTimeUs - j) / playbackSpeed);
        if (z4) {
            j6 -= jElapsedRealtime - j2;
        }
        if (this.surface == this.dummySurface && (!(z3 = this.enableVideoEffect) || (z3 && !this.videoSinkProvider.isInitialized()))) {
            if (!isBufferLate(j6)) {
                return false;
            }
            skipOutputBuffer(mediaCodecAdapter, i, j4);
            updateVideoFrameProcessingOffsetCounters(j6);
            return true;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j, j2);
                long jRegisterInputFrame = this.videoSink.registerInputFrame(j4, z2);
                if (jRegisterInputFrame == -9223372036854775807L) {
                    return false;
                }
                renderOutputBuffer(mediaCodecAdapter, i, j4, jRegisterInputFrame);
                return true;
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, 7001);
            }
        }
        long j7 = jElapsedRealtime - this.lastRenderRealtimeUs;
        if (!(this.joiningDeadlineMs == -9223372036854775807L && j >= outputStreamOffsetUs && ((this.renderedFirstFrameAfterEnable ? !this.renderedFirstFrameAfterReset : !(!z4 && !this.mayRenderFirstFrameAfterEnableIfNotStarted)) || (z4 && shouldForceRenderOutputBuffer(j6, j7))))) {
            if (!z4 || j == this.initialPositionUs) {
                return false;
            }
            long jNanoTime = System.nanoTime();
            long jAdjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((j6 * 1000) + jNanoTime);
            long j8 = (jAdjustReleaseTime - jNanoTime) / 1000;
            boolean z5 = this.joiningDeadlineMs != -9223372036854775807L;
            if (shouldDropBuffersToKeyframe(j8, j2, z2) && maybeDropBuffersToKeyframe(j, z5)) {
                return false;
            }
            if (shouldDropOutputBuffer(j8, j2, z2)) {
                if (z5) {
                    skipOutputBuffer(mediaCodecAdapter, i, j4);
                } else {
                    dropOutputBuffer(mediaCodecAdapter, i, j4);
                }
                updateVideoFrameProcessingOffsetCounters(j8);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j8 >= DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US) {
                    return false;
                }
                notifyFrameMetadataListener(j4, jAdjustReleaseTime, format);
                renderOutputBufferV21(mediaCodecAdapter, i, j4, jAdjustReleaseTime);
                updateVideoFrameProcessingOffsetCounters(j8);
                return true;
            }
            if (j8 >= 30000) {
                return false;
            }
            if (j8 > 11000) {
                try {
                    Thread.sleep((j8 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            notifyFrameMetadataListener(j4, jAdjustReleaseTime, format);
            renderOutputBuffer(mediaCodecAdapter, i, j4);
            updateVideoFrameProcessingOffsetCounters(j8);
            return true;
        }
        long jNanoTime2 = System.nanoTime();
        notifyFrameMetadataListener(j4, jNanoTime2, format);
        if (Util.SDK_INT >= 21 && !codecNeedsForceRenderWorkaround()) {
            renderOutputBufferV21(mediaCodecAdapter, i, j4, jNanoTime2);
        } else if (codecNeedsForceRenderWorkaround()) {
            int frameCountBuffered = FrameTimeRecorder.getInstance().getFrameCountBuffered() + FrameTimeRecorder.getInstance().getFrameCountQueuedInCodec();
            if (frameCountBuffered >= 3 && j7 < 10000) {
                Log.d(this.TAG, "need to drop buffer " + j4 + " for total count " + frameCountBuffered);
                dropOutputBuffer(mediaCodecAdapter, i, j4);
                FrameTimeRecorder.getInstance().recordReleaseFrameTime(j4);
                FrameTimeRecorder.getInstance().calculateFrameElapsedTime(j4);
                updateVideoFrameProcessingOffsetCounters(j6);
                return true;
            }
            if (j7 <= 10000) {
                return false;
            }
            renderOutputBuffer(mediaCodecAdapter, i, j4);
            FrameTimeRecorder.getInstance().recordReleaseFrameTime(j4);
            FrameTimeRecorder.getInstance().calculateFrameElapsedTime(j4);
        } else {
            renderOutputBuffer(mediaCodecAdapter, i, j4);
        }
        Log.d(this.TAG, "lastBufferPresentationTimeUs:" + this.lastBufferPresentationTimeUs + ",elapsedSinceLastRenderUs:" + j7);
        updateVideoFrameProcessingOffsetCounters(j6);
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.Renderer
    @CallSuper
    public void render(long j, long j2) throws ExoPlaybackException {
        super.render(j, j2);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j, j2);
                VideoSinkProvider videoSinkProvider = this.videoSinkProvider;
                if (videoSinkProvider == null || !videoSinkProvider.isReachedEndPosition()) {
                    return;
                }
                this.mIsReachedEndPosition = true;
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, 7001);
            }
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        if (!this.enableVideoEffect) {
            maybeNotifyVideoSizeChanged();
        }
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
            getDropFrameManager().doRender();
        }
        updateRenderedBufferCounter(j);
        this.consecutiveDroppedFrameCount = 0;
        if (this.enableVideoEffect) {
            maybeNotifyVideoSizeChanged();
            if (this.videoSink != null) {
                return;
            }
        }
        maybeNotifyRenderedFirstFrame();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    @RequiresApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        if (!this.enableVideoEffect) {
            maybeNotifyVideoSizeChanged();
        }
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
            getDropFrameManager().doRender();
        }
        updateRenderedBufferCounter(j);
        this.consecutiveDroppedFrameCount = 0;
        if (this.enableVideoEffect) {
            maybeNotifyVideoSizeChanged();
            if (this.videoSink == null) {
                maybeNotifyRenderedFirstFrame();
            }
        }
        long j3 = this.mExpectedPresentationTimeEndUs;
        if (j3 == -9223372036854775807L || j < j3 - 1000 || this.mIsReachedEndPosition) {
            return;
        }
        if (this.enableVideoEffect && !this.videoSinkProvider.isReachedEndPosition()) {
            return;
        }
        this.mIsReachedEndPosition = true;
        this.mExpectedPresentationTimeEndUs = -9223372036854775807L;
        Log.d(this.TAG, " Render is reached " + j);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws ExoPlaybackException {
        maybeNotifyRenderedFirstFrame();
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.Renderer
    public void setEndRendererPosition(long j) {
        VideoSinkProvider videoSinkProvider;
        Log.d(this.TAG, "set end render position " + j);
        this.mExpectedPresentationTimeEndUs = j;
        if (!this.enableVideoEffect || (videoSinkProvider = this.videoSinkProvider) == null) {
            return;
        }
        videoSinkProvider.setExpectedEndPresentationTimeUs(j);
    }

    public void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    @RequiresApi(23)
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        if (!this.enableVideoEffect) {
            this.frameReleaseHelper.onPlaybackSpeed(f);
            return;
        }
        this.videoFrameReleaseControl.setPlaybackSpeed(f);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f);
        }
    }

    public void setVideoEffects(List<Effect> list) {
        this.videoSinkProvider.setVideoEffects(list);
        this.hasEffects = true;
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldDropFrame(long j, long j2, boolean z) {
        return shouldDropOutputBuffer(j, j2, z);
    }

    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldForceReleaseFrame(long j, long j2) {
        return shouldForceRenderOutputBuffer(j, j2);
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean shouldIgnoreFrame(long j, long j2, long j3, boolean z, boolean z2) throws ExoPlaybackException {
        return shouldDropBuffersToKeyframe(j, j3, z) && maybeDropBuffersToKeyframe(j2, z2);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateSkippedBufferCounters(1, false);
    }

    @Override // com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        int i = 0;
        if (!MimeTypes.isVideo(str)) {
            return rv4.a(0);
        }
        boolean z = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return rv4.a(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return rv4.a(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        if ("video/av01".equals(str) && !mediaCodecInfo.name.startsWith("c2.qti.av1.decoder") && !mediaCodecInfo.name.startsWith("c2.mtk.av1.decoder")) {
            return rv4.a(1);
        }
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        int i3 = zIsFormatSupported ? 4 : 3;
        if (i3 == 3) {
            this.isFormatExceededSpec = true;
        }
        return rv4.b(i3, i2, i);
    }

    public void updateDroppedBufferCounters(int i, int i2) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        int i4 = this.consecutiveDroppedFrameCount + i3;
        this.consecutiveDroppedFrameCount = i4;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i4, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i5 = this.maxDroppedFramesToNotify;
        if (i5 <= 0 || this.droppedFrames < i5) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, float f, boolean z2) {
        this(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, f, z2, null);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str;
        String str2 = format.sampleMimeType;
        if (str2 == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str2, z, z2), format);
        if ("video/dolby-vision".equals(str2) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue != 16 && iIntValue != 32 && iIntValue != 256) {
                str = iIntValue == 512 ? "video/avc" : "video/hevc";
            }
            decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(str, z, z2));
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    private void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        if (Util.SDK_INT >= 21) {
            renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
        } else {
            renderOutputBuffer(mediaCodecAdapter, i, j);
        }
    }

    public void updateDroppedBufferCounters(int i, boolean z) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        int i2 = this.consecutiveDroppedFrameCount + i;
        this.consecutiveDroppedFrameCount = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i3 = this.maxDroppedFramesToNotify;
        if (i3 > 0 && this.droppedFrames >= i3) {
            maybeNotifyDroppedFrames();
        }
        maybeOnDroppedOutputBufferForStuckDetector(i, z);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, float f, boolean z2, @Nullable VideoSinkProvider videoSinkProvider) {
        super(2, factory, mediaCodecSelector, z, f);
        this.TAG = "MediaCodecVideoRenderer_ins_" + Thread.currentThread().getId();
        this.frameReleaseHelper = null;
        this.videoSinkProvider = null;
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.mIsReachedEndPosition = false;
        this.mExpectedPresentationTimeEndUs = -9223372036854775807L;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
        this.needDropFrame = false;
        this.isFormatExceededSpec = false;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.dynamicWallpaperEnabled = new AtomicBoolean(false);
        this.stuckDetector = new VideoStuckDetector(0);
        maybeInitializeStuckDetector();
        if (z2) {
            this.enableVideoEffect = z2;
            setVideoSinkProvider(videoSinkProvider);
        } else {
            this.frameReleaseHelper = new VideoFrameReleaseOldHelper(applicationContext);
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i);
    }

    public void onReadyToRegisterVideoSinkInputStream() {
    }
}
