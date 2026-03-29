package com.oplus.tblplayer.ffmpeg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.BaseRenderer;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.FormatHolder;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderException;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;
import com.oplus.tbl.exoplayer2.drm.DrmInitData;
import com.oplus.tbl.exoplayer2.drm.DrmSession;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManager;
import com.oplus.tbl.exoplayer2.drm.ExoMediaCrypto;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.DropFrameManager;
import com.oplus.tbl.exoplayer2.video.DummySurface;
import com.oplus.tbl.exoplayer2.video.VideoDropFrameManager;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.Constants;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SimpleDecoderVideoRenderer extends BaseRenderer {
    private static final boolean DEBUG = true;
    private static final ImmutableList<DrmInitData.SchemeData> DRM_SCHEME_DATAS;
    private static final UUID DRM_SCHEME_UUID;
    private static final Format FORMAT_WITH_DRM_INIT_DATA;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "SimpleDecoderVideoRenderer";
    public static final int VIDEO_OUTPUT_MODE_NONE = -1;
    public static final int VIDEO_OUTPUT_MODE_SURFACE_YUV = 1;
    public static final int VIDEO_OUTPUT_MODE_YUV = 0;
    public static final int VIDEO_RENDER_MODE_NONE = -1;
    public static final int VIDEO_RENDER_MODE_OPENGL = 1;
    public static final int VIDEO_RENDER_MODE_SURFACE = 0;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private FfmpegVideoDecoder decoder;
    private DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private DrmSession drmSession;
    private final DrmSessionManager drmSessionManager;
    private DropFrameManager dropFrameManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private long fastRendererTimeUs;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private boolean forceRenderFrame;
    protected final FormatHolder formatHolder;
    private long initialPositionUs;
    private FfmpegVideoInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastPresentTimeUs;
    private long lastRenderTimeUs;
    private Context mAppContext;
    protected final int maxDroppedFramesToNotify;
    private boolean needDropFrame;
    private FrameOutputBuffer nextOutputBuffer;
    private FrameOutputBuffer outputBuffer;
    private int outputHeight;
    private boolean outputStreamEnded;
    private int outputWidth;
    private DrmSession pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private boolean shouldDropOutputBuffer;
    private Surface surface;
    protected int videoOutputMode;
    protected int videoRenderMode;
    private boolean waitingForKeys;

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoOutputMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoRenderMode {
    }

    static {
        UUID uuidNameUUIDFromBytes = UUID.nameUUIDFromBytes(createByteArray(0, 0, 0));
        DRM_SCHEME_UUID = uuidNameUUIDFromBytes;
        ImmutableList<DrmInitData.SchemeData> immutableListOf = ImmutableList.of(new DrmInitData.SchemeData(uuidNameUUIDFromBytes, "video/mp4", createByteArray(0, 0, 0)));
        DRM_SCHEME_DATAS = immutableListOf;
        FORMAT_WITH_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(immutableListOf)).build();
    }

    public SimpleDecoderVideoRenderer() {
        this(0L);
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
    }

    public static byte[] createByteArray(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            Assertions.checkState(i2 >= 0 && i2 <= 255);
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0157, code lost:
    
        if (shouldDropOutputBuffer(r1, r7, r18, -9223372036854775807L) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean drainOutputBuffer(long j) throws FfmpegDecoderException, ExoPlaybackException {
        String str;
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j;
        }
        if (this.outputBuffer == null) {
            FrameOutputBuffer frameOutputBuffer = this.nextOutputBuffer;
            if (frameOutputBuffer != null) {
                this.outputBuffer = frameOutputBuffer;
                this.nextOutputBuffer = null;
            } else {
                this.outputBuffer = this.decoder.dequeueOutputBuffer();
            }
            FrameOutputBuffer frameOutputBuffer2 = this.outputBuffer;
            if (frameOutputBuffer2 == null) {
                FfmpegUtil.d(TAG, "drainOutputBuffer: no buffers");
                return false;
            }
            DecoderCounters decoderCounters = this.decoderCounters;
            int i = decoderCounters.skippedOutputBufferCount;
            int i2 = frameOutputBuffer2.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = i + i2;
            this.buffersInCodecCount -= i2;
        }
        if (this.nextOutputBuffer == null) {
            this.nextOutputBuffer = this.decoder.dequeueOutputBuffer();
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
                renderToEndOfStream();
            }
            return false;
        }
        long j2 = this.outputBuffer.timeUs;
        if (j2 >= this.initialPositionUs) {
            this.needDropFrame = false;
        }
        this.lastPresentTimeUs = j2;
        if (this.needDropFrame) {
            long j3 = this.fastRendererTimeUs;
            if (j3 == -9223372036854775807L || j3 > j2) {
                str = "need drop timeUs: " + this.lastPresentTimeUs;
            } else if (this.surface != this.dummySurface) {
                if (this.forceRenderFrame) {
                    this.forceRenderFrame = false;
                } else {
                    FrameOutputBuffer frameOutputBuffer3 = this.nextOutputBuffer;
                    long j4 = (frameOutputBuffer3 == null || frameOutputBuffer3.isEndOfStream()) ? -9223372036854775807L : this.nextOutputBuffer.timeUs;
                    long jAdjustPresentTimeUs = this.outputBuffer.timeUs;
                    if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
                        if (getDropFrameManager().canRender(jAdjustPresentTimeUs)) {
                            jAdjustPresentTimeUs = getDropFrameManager().adjustPresentTimeUs(jAdjustPresentTimeUs);
                        } else {
                            str = "can't render curOutputBufferTimeUs:" + jAdjustPresentTimeUs;
                        }
                    }
                    long j5 = jAdjustPresentTimeUs;
                    long j6 = this.outputBuffer.timeUs - j;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                    if (this.shouldDropOutputBuffer) {
                        if ((shouldDropBuffersToKeyframe(j6) && maybeDropBuffersToKeyframe(j)) || (getState() == 2 && shouldForceRenderOutputBuffer(j5, jElapsedRealtime - this.lastRenderTimeUs))) {
                            this.forceRenderFrame = true;
                            return false;
                        }
                    }
                    if (this.renderedFirstFrame && (getState() != 2 || j6 > 30000)) {
                        return false;
                    }
                }
                renderBuffer();
            } else {
                if (!isBufferLate(j2 - j)) {
                    return false;
                }
                this.forceRenderFrame = false;
                skipBuffer();
            }
            FfmpegUtil.d(TAG, str);
            dropBuffer();
        }
        this.buffersInCodecCount--;
        return true;
    }

    private void dropBuffer() {
        FfmpegUtil.d(TAG, "dropBuffer");
        updateDroppedBufferCounters(1, false);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private boolean feedInputBuffer() throws DecoderException, ExoPlaybackException {
        int source;
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            FfmpegVideoInputBuffer ffmpegVideoInputBufferDequeueInputBuffer = ffmpegVideoDecoder.dequeueInputBuffer();
            this.inputBuffer = ffmpegVideoInputBufferDequeueInputBuffer;
            if (ffmpegVideoInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        if (this.waitingForKeys) {
            source = -4;
        } else {
            try {
                source = readSource(this.formatHolder, this.inputBuffer, false);
            } catch (OutOfMemoryError e) {
                FfmpegUtil.e(TAG, "read source out of memory", e);
                throw createRendererException(e, this.inputFormat);
            }
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        boolean zShouldWaitForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        this.waitingForKeys = zShouldWaitForKeys;
        if (zShouldWaitForKeys) {
            return false;
        }
        this.inputBuffer.flip();
        queueInputBuffer(this.decoder, this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private void flushDecoder() throws ExoPlaybackException {
        this.waitingForKeys = false;
        this.forceRenderFrame = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        FrameOutputBuffer frameOutputBuffer = this.outputBuffer;
        if (frameOutputBuffer != null) {
            frameOutputBuffer.release();
            this.outputBuffer = null;
        }
        FrameOutputBuffer frameOutputBuffer2 = this.nextOutputBuffer;
        if (frameOutputBuffer2 != null) {
            frameOutputBuffer2.release();
            this.nextOutputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    private boolean maybeDropBuffersToKeyframe(long j) throws ExoPlaybackException {
        int iSkipSource = skipSource(j);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource, true);
        flushDecoder();
        return true;
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto;
        if (this.decoder != null) {
            return;
        }
        DrmSession drmSession = this.pendingDrmSession;
        this.drmSession = drmSession;
        if (drmSession != null) {
            mediaCrypto = drmSession.getMediaCrypto();
            if (mediaCrypto == null && this.drmSession.getError() == null) {
                return;
            }
        } else {
            mediaCrypto = null;
        }
        FfmpegUtil.d(TAG, "maybeInitDecoder: createVideoDecoder");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        TraceUtil.beginSection("createVideoDecoder");
        try {
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
        } catch (FfmpegDecoderException e) {
            FfmpegUtil.e(TAG, "crate decoder failed " + e.getMessage());
            if (e.getMessage().contains(Constants.UNSUPPORTED_AVC1_BRAND_LABEL) || e.getMessage().contains(Constants.DECODER_INIT_FAILED)) {
                throw createRendererException(e, this.inputFormat);
            }
        }
        if (getDropFrameManager() != null) {
            FfmpegUtil.d(TAG, "frameRate:" + this.inputFormat.frameRate);
            getDropFrameManager().setRealFps(this.inputFormat.frameRate);
        }
        TraceUtil.endSection();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        if (this.decoder != null) {
            if (this.surface == null) {
                if (this.dummySurface == null) {
                    this.dummySurface = DummySurface.newInstanceV17(this.mAppContext, false);
                }
                this.surface = this.dummySurface;
            }
            this.eventDispatcher.decoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime, false);
            this.decoderCounters.decoderInitCount++;
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeNotifyVideoSizeChanged(int i, int i2) {
        if (this.reportedWidth == i && this.reportedHeight == i2) {
            return;
        }
        FfmpegUtil.d(TAG, "maybeNotifyVideoSizeChanged: [" + i + " x " + i2 + "]");
        this.reportedWidth = i;
        this.reportedHeight = i2;
        this.eventDispatcher.videoSizeChanged(i, i2, 0, 1.0f);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, 0, 1.0f);
    }

    private void onInputFormatChanged(Format format) throws ExoPlaybackException {
        FfmpegUtil.d(TAG, "onInputFormatChanged: " + Integer.toHexString(hashCode()));
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        if (!Util.areEqual(format.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.inputFormat.drmInitData != null) {
                DrmSessionManager drmSessionManager = this.drmSessionManager;
                if (drmSessionManager == null) {
                    throw createRendererException(new IllegalStateException("Media requires a DrmSessionManager"), this.inputFormat);
                }
                DrmSession drmSessionAcquireSession = drmSessionManager.acquireSession(Looper.myLooper(), null, FORMAT_WITH_DRM_INIT_DATA);
                this.pendingDrmSession = drmSessionAcquireSession;
                if (drmSessionAcquireSession == this.drmSession) {
                    this.drmSessionManager.release();
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        DrmSession drmSession = this.pendingDrmSession;
        DrmSession drmSession2 = this.drmSession;
        if (drmSession != drmSession2 || (drmSession == null && drmSession2 == null)) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat, null);
        maybeOnSetFrameRateForStuckDetector(this.inputFormat.frameRate);
    }

    private void releaseDecoder() {
        FfmpegUtil.d(TAG, "releaseDecoder: ");
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.nextOutputBuffer = null;
        if (this.surface != null) {
            ffmpegVideoDecoder.updateRenderSurface(null);
        }
        this.decoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.forceRenderFrame = false;
        this.buffersInCodecCount = 0;
        Surface surface = this.dummySurface;
        if (surface != null) {
            if (this.surface == surface) {
                this.surface = null;
            }
            surface.release();
            this.dummySurface = null;
        }
    }

    private void renderBuffer() throws ExoPlaybackException {
        int i;
        FfmpegUtil.d(TAG, "renderBuffer start");
        if (this.surface == null) {
            dropBuffer();
            return;
        }
        FrameOutputBuffer frameOutputBuffer = this.outputBuffer;
        int i2 = frameOutputBuffer.width;
        if (i2 != this.outputWidth || frameOutputBuffer.height != this.outputHeight) {
            if (this.videoRenderMode == 1 && ((i = this.inputFormat.rotationDegrees) == 90 || i == 270)) {
                this.outputWidth = frameOutputBuffer.height;
                this.outputHeight = i2;
            } else {
                this.outputWidth = i2;
                this.outputHeight = frameOutputBuffer.height;
            }
            FfmpegUtil.d(TAG, "renderBuffer: videoSizeChanged [" + this.outputWidth + " x " + this.outputHeight + "]");
        }
        maybeNotifyVideoSizeChanged(this.outputWidth, this.outputHeight);
        try {
            FrameOutputBuffer frameOutputBuffer2 = this.outputBuffer;
            int i3 = frameOutputBuffer2.mode;
            if (i3 == 1 || (i3 == 0 && frameOutputBuffer2.data != null)) {
                this.decoder.renderToSurface(frameOutputBuffer2, this.surface);
                this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
            }
            FfmpegUtil.d(TAG, "renderBuffer end");
            maybeOnRenderedOutputBufferForStuckDetector(this.outputBuffer.timeUs);
            this.outputBuffer.release();
            this.outputBuffer = null;
            if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
                getDropFrameManager().doRender();
            }
            this.consecutiveDroppedFrameCount = 0;
            this.decoderCounters.renderedOutputBufferCount++;
            maybeNotifyRenderedFirstFrame();
        } catch (FfmpegDecoderException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    private void renderToEndOfStream() throws ExoPlaybackException {
        this.needDropFrame = false;
        maybeNotifyRenderedFirstFrame();
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else if (this.decoder != null) {
                surface = DummySurface.newInstanceV17(this.mAppContext, false);
                this.dummySurface = surface;
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
        int state = getState();
        if (state == 1 || state == 2) {
            FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
            if (ffmpegVideoDecoder == null || surface == null) {
                FfmpegUtil.i(TAG, "setSurface: Don't release SW decoder");
            } else {
                ffmpegVideoDecoder.updateRenderSurface(surface);
            }
        }
        if (surface == null || surface == this.dummySurface) {
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (state == 2) {
            setJoiningDeadlineMs();
        }
    }

    private boolean shouldDropBuffersToKeyframe(long j) {
        return isBufferVeryLate(j);
    }

    private boolean shouldDropOutputBuffer(long j, long j2, long j3, long j4) {
        return isBufferLate(j - j3) && !(j4 == -9223372036854775807L && j2 == -9223372036854775807L);
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        DrmSession drmSession = this.drmSession;
        if (drmSession == null || (!z && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = drmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw createRendererException(this.drmSession.getError(), this.inputFormat);
    }

    private void skipBuffer() {
        this.decoderCounters.skippedOutputBufferCount++;
        FfmpegUtil.d(TAG, "skipBuffer: " + this.decoderCounters.skippedOutputBufferCount);
        maybeOnSkippedOutputBufferForStuckDetector(1, false);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private void updateDroppedBufferCounters(int i, boolean z) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        int i2 = this.consecutiveDroppedFrameCount + i;
        this.consecutiveDroppedFrameCount = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
        maybeOnDroppedOutputBufferForStuckDetector(i, z);
    }

    public abstract FfmpegVideoDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegDecoderException;

    public DropFrameManager getDropFrameManager() {
        return this.dropFrameManager;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public long getLastPresentTimeUs() {
        return this.lastPresentTimeUs;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public boolean getRenderedFirstFrame() {
        return this.renderedFirstFrame;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
            return;
        }
        if (i == 4) {
            return;
        }
        if (i == 12) {
            if (getDropFrameManager() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("MSG_SET_DROP_FRAME_POLICY:");
                Integer num = (Integer) obj;
                sb.append(num.intValue());
                FfmpegUtil.d(TAG, sb.toString());
                getDropFrameManager().initialize(num.intValue());
                return;
            }
            return;
        }
        if (i == 11000) {
            maybeResetStuckDetector();
            return;
        }
        if (i == 11001) {
            maybeEnableStuckDetector(((Boolean) obj).booleanValue());
        } else if (i != 10006) {
            super.handleMessage(i, obj);
        } else if (obj != null) {
            this.shouldDropOutputBuffer = ((Boolean) obj).booleanValue();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isAbnormalSurface() {
        Surface surface = this.surface;
        return surface == null || surface == this.dummySurface;
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (this.waitingForKeys) {
            return false;
        }
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || ((surface = this.dummySurface) != null && this.surface == surface)))) {
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

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.inputFormat = null;
        this.waitingForKeys = false;
        this.outputWidth = -1;
        this.outputHeight = -1;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            releaseDecoder();
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.release();
                }
                try {
                    DrmSession drmSession = this.pendingDrmSession;
                    if (drmSession != null && drmSession != this.drmSession) {
                        this.drmSessionManager.release();
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    DrmSession drmSession2 = this.pendingDrmSession;
                    if (drmSession2 != null && drmSession2 != this.drmSession) {
                        this.drmSessionManager.release();
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.release();
                }
                try {
                    DrmSession drmSession3 = this.pendingDrmSession;
                    if (drmSession3 != null && drmSession3 != this.drmSession) {
                        this.drmSessionManager.release();
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    DrmSession drmSession4 = this.pendingDrmSession;
                    if (drmSession4 != null && drmSession4 != this.drmSession) {
                        this.drmSessionManager.release();
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        DecoderCounters decoderCounters = new DecoderCounters();
        this.decoderCounters = decoderCounters;
        this.eventDispatcher.enabled(decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        FfmpegUtil.d(TAG, "onPositionReset: " + j);
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
        maybeUpdateDetectorTime(j);
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionResetInGop(long j, boolean z) throws ExoPlaybackException {
        if (this.lastPresentTimeUs < j) {
            this.needDropFrame = true;
            clearRenderedFirstFrame();
            this.initialPositionUs = -9223372036854775807L;
            this.fastRendererTimeUs = -9223372036854775807L;
            maybeUpdateDetectorTime(j);
            return;
        }
        FfmpegUtil.d(TAG, "invalid positionUs:" + j + ",lastPresentTimeUs:" + this.lastPresentTimeUs);
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onSetFastRendererPosition(long j, boolean z) {
        FfmpegUtil.d(TAG, "onSetFastRendererPosition positionUs:" + j);
        this.fastRendererTimeUs = j;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        maybeStartStuckDetector();
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStopped() {
        maybeStopStuckDetector();
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
    }

    public void queueInputBuffer(SimpleDecoder<FfmpegVideoInputBuffer, ? extends FrameOutputBuffer, ? extends FfmpegDecoderException> simpleDecoder, FfmpegVideoInputBuffer ffmpegVideoInputBuffer) throws DecoderException {
        simpleDecoder.queueInputBuffer(ffmpegVideoInputBuffer);
        maybeOnQueueInputBufferForStuckDetector();
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            FfmpegUtil.d(TAG, Integer.toHexString(hashCode()) + " outputStreamEnded");
            return;
        }
        if (this.inputFormat == null) {
            this.flagsOnlyBuffer.clear();
            int source = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                maybeUpdateDetectorTime(j);
                TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(j)) {
                }
                while (feedInputBuffer()) {
                }
                TraceUtil.endSection();
                maybeDetectStuck();
                this.decoderCounters.ensureUpdated();
            } catch (FfmpegDecoderException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return j == Long.MIN_VALUE && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @Override // com.oplus.tbl.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) throws ExoPlaybackException {
        if (!FfmpegLibrary.isAvailable()) {
            FfmpegUtil.e(TAG, "CoreLibrary not available");
            return 0;
        }
        int iSupportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
        if (iSupportsFormatInternal <= 2) {
            return iSupportsFormatInternal;
        }
        return iSupportsFormatInternal | (Util.SDK_INT >= 21 ? 32 : 0) | 8;
    }

    public abstract int supportsFormatInternal(DrmSessionManager drmSessionManager, Format format);

    public SimpleDecoderVideoRenderer(long j) {
        this(null, j, null, null, 0, 0);
    }

    public SimpleDecoderVideoRenderer(Context context, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, int i2) {
        this(context, j, handler, videoRendererEventListener, i, null, false);
        if (i2 != 1) {
            this.videoRenderMode = 0;
            if (i2 == 2) {
                this.videoOutputMode = 0;
            }
            FfmpegUtil.dfmt(TAG, "videoSoftRenderMode: videoRenderMode %s, videoOutputMode %s.", FfmpegUtil.getVideoSoftRenderModeString(i2), FfmpegUtil.getVideoOutPutModeString(this.videoOutputMode));
        }
        this.videoRenderMode = 1;
        this.videoOutputMode = 1;
        FfmpegUtil.dfmt(TAG, "videoSoftRenderMode: videoRenderMode %s, videoOutputMode %s.", FfmpegUtil.getVideoSoftRenderModeString(i2), FfmpegUtil.getVideoOutPutModeString(this.videoOutputMode));
    }

    public SimpleDecoderVideoRenderer(Context context, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, DrmSessionManager drmSessionManager, boolean z) {
        super(2);
        this.shouldDropOutputBuffer = true;
        this.mAppContext = context;
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatHolder = new FormatHolder();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        VideoRendererEventListener.EventDispatcher eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.eventDispatcher = eventDispatcher;
        this.decoderReinitializationState = 0;
        this.initialPositionUs = -9223372036854775807L;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.needDropFrame = false;
        this.dropFrameManager = new VideoDropFrameManager();
        maybeCreateStuckDetector();
        maybeInitializeStuckDetector(eventDispatcher);
    }

    public void maybeCreateStuckDetector() {
    }

    public void maybeDetectStuck() {
    }

    public void maybeDetectStuckForStuckDetector() {
    }

    public void maybeOnQueueInputBufferForStuckDetector() {
    }

    public void maybeResetStuckDetector() {
    }

    public void maybeStartStuckDetector() {
    }

    public void maybeStopStuckDetector() {
    }

    public void maybeEnableStuckDetector(boolean z) {
    }

    public void maybeInitializeStuckDetector(VideoRendererEventListener.EventDispatcher eventDispatcher) {
    }

    public void maybeOnRenderedOutputBufferForStuckDetector(long j) {
    }

    public void maybeOnSetFrameRateForStuckDetector(float f) {
    }

    public void maybeUpdateDetectorTime(long j) {
    }

    public void maybeUpdateTimeForStuckDetector(long j) {
    }

    public void maybeOnDroppedOutputBufferForStuckDetector(int i, boolean z) {
    }

    public void maybeOnSkippedOutputBufferForStuckDetector(int i, boolean z) {
    }
}
