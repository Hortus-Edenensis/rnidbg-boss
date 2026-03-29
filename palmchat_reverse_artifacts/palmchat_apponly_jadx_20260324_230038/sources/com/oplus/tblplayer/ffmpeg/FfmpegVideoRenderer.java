package com.oplus.tblplayer.ffmpeg;

import android.content.Context;
import android.os.Handler;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManager;
import com.oplus.tbl.exoplayer2.drm.ExoMediaCrypto;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tbl.exoplayer2.video.VideoStuckDetector;
import com.oplus.tblplayer.utils.DetectCodecsCopyrightUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FfmpegVideoRenderer extends SimpleDecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((Util.ceilDivide(1280, 64) * Util.ceilDivide(720, 64)) * BmLocated.HALF_LEFT_BOTTOM) / 2;
    private static final int INITIAL_INPUT_BUFFER_SIZE = 786432;
    private static final int NUM_INPUT_BUFFERS = 4;
    private static final int NUM_OUTPUT_BUFFERS = 4;
    private static final String TAG = "FfmpegVideoRenderer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7686a = 0;
    private Context mAppContext;
    private VideoStuckDetector stuckDetector;

    public FfmpegVideoRenderer() {
    }

    public FfmpegVideoRenderer(long j) {
        super(j);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public FfmpegVideoDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegDecoderException {
        FfmpegUtil.d(TAG, "createDecoder: SW video decoder.");
        if ("video/dolby-vision".equals(format.sampleMimeType)) {
            format = FfmpegUtil.convertDolbyVisionFormat(format);
        }
        return new FfmpegVideoDecoder(4, 4, DEFAULT_INPUT_BUFFER_SIZE, format, this.videoOutputMode, this.videoRenderMode);
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer, com.oplus.tbl.exoplayer2.RendererCapabilities
    public String getName() {
        return null;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeCreateStuckDetector() {
        if (this.stuckDetector != null) {
            return;
        }
        this.stuckDetector = new VideoStuckDetector(1);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeDetectStuck() {
        maybeDetectStuckForStuckDetector();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeDetectStuckForStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.detectStuck();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeEnableStuckDetector(boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.enable(z);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeInitializeStuckDetector(VideoRendererEventListener.EventDispatcher eventDispatcher) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.initialize(eventDispatcher);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeOnDroppedOutputBufferForStuckDetector(int i, boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onDroppedOutputBuffer(i, z);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeOnQueueInputBufferForStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onQueuedInputBuffer();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeOnRenderedOutputBufferForStuckDetector(long j) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onRenderedOutputBuffer(j / 1000);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeOnSetFrameRateForStuckDetector(float f) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onSetFrameRate(f);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeOnSkippedOutputBufferForStuckDetector(int i, boolean z) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.onSkippedOutputBuffer(i, z);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeResetStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.reset();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeStartStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.start();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeStopStuckDetector() {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.stop();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeUpdateDetectorTime(long j) {
        maybeUpdateTimeForStuckDetector(j);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public void maybeUpdateTimeForStuckDetector(long j) {
        VideoStuckDetector videoStuckDetector = this.stuckDetector;
        if (videoStuckDetector == null) {
            return;
        }
        videoStuckDetector.updateTime(j / 1000);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    public int supportsFormatInternal(DrmSessionManager drmSessionManager, Format format) {
        FfmpegUtil.d(TAG, "supportsFormatInternal: format is " + format.toString());
        if ("video/dolby-vision".equals(format.sampleMimeType)) {
            format = FfmpegUtil.convertDolbyVisionFormat(format);
        }
        String str = format.sampleMimeType;
        FfmpegUtil.d(TAG, "supportsFormatInternal: format is " + str);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isVideo(str)) {
            FfmpegUtil.d(TAG, "supportsFormatInternal: libAvailable = " + FfmpegLibrary.isAvailable() + ", isVideo = " + MimeTypes.isVideo(str));
            return 0;
        }
        if (DetectCodecsCopyrightUtil.isUnsupportedVideoCopyrightCodec(str)) {
            FfmpegUtil.e(TAG, "supportsFormatInternal: Format Not COPYRIGHT Support. MIME = " + str + ", Container = " + format.containerMimeType);
            return 5;
        }
        if (FfmpegLibrary.supportsFormat(format)) {
            FfmpegUtil.d(TAG, "supportsFormatInternal: FFmpeg support");
            return 4;
        }
        FfmpegUtil.e(TAG, "supportsFormatInternal: Format Not Support. MIME = " + format.sampleMimeType + ", Container = " + format.containerMimeType);
        return 1;
    }

    public FfmpegVideoRenderer(Context context, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, int i2) {
        super(context, j, handler, videoRendererEventListener, i, i2);
        this.mAppContext = context;
        FfmpegUtil.d(TAG, "SW video renderer init!");
    }
}
