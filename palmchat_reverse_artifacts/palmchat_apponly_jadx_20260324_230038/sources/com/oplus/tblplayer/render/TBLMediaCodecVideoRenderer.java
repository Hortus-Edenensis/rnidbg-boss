package com.oplus.tblplayer.render;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecAdapter;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecInfo;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecSelector;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecUtil;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.DropFrameManager;
import com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer;
import com.oplus.tbl.exoplayer2.video.VideoDropFrameManager;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.misc.DeviceModelDetection;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.DetectCodecsCopyrightUtil;
import com.oplus.tblplayer.utils.FormatUtil;
import com.oplus.tblplayer.utils.LogUtil;
import defpackage.rv4;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class TBLMediaCodecVideoRenderer extends MediaCodecVideoRenderer implements FallbackRenderer {
    private static final boolean DEBUG = false;
    private String TAG;
    private int codecVPPFilterMode;
    private boolean disableVideoCodecWCG;
    private DropFrameManager dropFrameManager;
    private final boolean enableCodecVPPFilter;
    private AtomicBoolean fallbackRenderer;
    private float mMaxFrameRate;
    private boolean needConfigureMaxOutputFrameRate;
    private boolean reconfigureFormat;
    private boolean streamingMode;
    private boolean videoCodecUxEnabled;

    /* JADX INFO: compiled from: SearchBox */
    public final class VideoOverSpecificationException extends MediaCodecUtil.DecoderQueryException {
        public VideoOverSpecificationException(Throwable th) {
            super(th);
        }
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, false, false);
    }

    private void maybeConfigureMaxOutputFrameRate(MediaFormat mediaFormat) {
        if (CommonUtil.isQualcommHardware()) {
            if (getDropFrameManager() != null && getDropFrameManager().isAvailable()) {
                LogUtil.d(this.TAG, "config output render frame rate " + this.mMaxFrameRate);
                mediaFormat.setFloat("vendor.qti-ext-dec-output-render-frame-rate.value", this.mMaxFrameRate);
            }
            if (this.needConfigureMaxOutputFrameRate) {
                LogUtil.d(this.TAG, "need config operating rate to increase frequency");
                this.mMaxFrameRate = 120.0f;
                mediaFormat.setInteger("priority", 1);
                mediaFormat.setFloat(IMediaFormat.KEY_OPERATING_RATE, this.mMaxFrameRate);
            }
        }
    }

    private void maybeConfigureMediaCodecForDolbyVision(Format format, MediaFormat mediaFormat) {
        String str = format.sampleMimeType;
        if (str == null || !str.equals("video/dolby-vision")) {
            return;
        }
        mediaFormat.setString("vendor.dolby.codec.transfer.value", "transfer.sdr.high.fidelity");
    }

    private void maybeConfigureMediaCodecForStreaming(MediaFormat mediaFormat) {
        if (this.streamingMode && CommonUtil.isQualcommHardware()) {
            mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
            mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        }
    }

    private void maybeConfigureMediaCodecForUIFirst(MediaFormat mediaFormat) {
        if (this.videoCodecUxEnabled) {
            mediaFormat.setInteger("ux-looper", 1);
            mediaFormat.setLong("calling-uid", Process.myUid());
            LogUtil.w(this.TAG, "enable UI-FIRST function");
        }
    }

    private void maybeConfigureMediaCodecVPPFilter(MediaFormat mediaFormat) {
        if (this.enableCodecVPPFilter) {
            LogUtil.d(this.TAG, "Configure MediaCodec VPP filter, current VPP filter mode is " + this.codecVPPFilterMode);
            mediaFormat.setInteger("vendor.oplus-vpp-filter-enable.value", 1);
            mediaFormat.setInteger("vendor.oplus-draw-curtain-disable.value", 1);
            if ((this.codecVPPFilterMode & 1) != 0) {
                mediaFormat.setInteger("vendor.oplus-sr-enable.value", 1);
            }
            if ((this.codecVPPFilterMode & 2) != 0) {
                mediaFormat.setInteger("vendor.oplus-osie-enable.value", 1);
            }
        }
    }

    private void maybeDisableVideoCodecWCG(MediaFormat mediaFormat) {
        if (this.disableVideoCodecWCG) {
            mediaFormat.setInteger(Constants.DISABLE_VIDEO_CODEC_WCG, 1);
        }
    }

    private void maybeUpdateMediaCodecVPPFilterMode(int i) {
        if (!this.enableCodecVPPFilter || this.codecVPPFilterMode == i) {
            return;
        }
        LogUtil.d(this.TAG, "Update MediaCodec VPP filter mode, current VPP filter mode is " + this.codecVPPFilterMode + ", change to " + i);
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("vendor.oplus-sr-enable.value", (i & 1) != 0 ? 1 : 0);
            bundle.putInt("vendor.oplus-osie-enable.value", (i & 2) != 0 ? 1 : 0);
            codec.setParameters(bundle);
        }
        this.codecVPPFilterMode = i;
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer
    public boolean codecNeedsForceRenderWorkaround() {
        return this.streamingMode;
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        float f2;
        Format formatBuild;
        Format formatMaybeRemoveFfmpegCodecParameters = FormatUtil.maybeRemoveFfmpegCodecParameters(format);
        if (this.reconfigureFormat) {
            LogUtil.w(this.TAG, "Format exceed the renderer's capabilities, will reconfigure.");
            formatBuild = formatMaybeRemoveFfmpegCodecParameters.buildUpon().setFrameRate(-1.0f).build();
            f2 = -1.0f;
        } else {
            f2 = f;
            formatBuild = formatMaybeRemoveFfmpegCodecParameters;
        }
        if (getDropFrameManager() != null) {
            LogUtil.d(this.TAG, "frameRate:" + format.frameRate);
            getDropFrameManager().setRealFps(format.frameRate);
        }
        if (DeviceModelDetection.deviceNeedsConfigureMaxOutputFrameRateWorkaround() && format.frameRate > 115.0f && Util.SDK_INT >= 33) {
            this.needConfigureMaxOutputFrameRate = true;
        }
        super.configureCodec(mediaCodecInfo, mediaCodecAdapter, formatBuild, mediaCrypto, f2);
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer
    public DropFrameManager getDropFrameManager() {
        return this.dropFrameManager;
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer
    public MediaFormat getMediaFormat(Format format, String str, MediaCodecVideoRenderer.CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        MediaFormat mediaFormat = super.getMediaFormat(format, str, codecMaxValues, f, z, i);
        maybeConfigureMediaCodecForStreaming(mediaFormat);
        maybeConfigureMediaCodecForUIFirst(mediaFormat);
        maybeConfigureMediaCodecVPPFilter(mediaFormat);
        maybeConfigureMaxOutputFrameRate(mediaFormat);
        maybeDisableVideoCodecWCG(mediaFormat);
        return mediaFormat;
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer, com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        LogUtil.d(this.TAG, "handleMessage: " + i);
        if (i == 10002) {
            if (obj != null) {
                this.streamingMode = ((Boolean) obj).booleanValue();
                return;
            }
        } else if (i == 10003) {
            if (obj != null) {
                maybeUpdateMediaCodecVPPFilterMode(((Integer) obj).intValue());
                return;
            }
        } else if (i == 10007) {
            if (obj != null) {
                this.videoCodecUxEnabled = ((Boolean) obj).booleanValue();
                return;
            }
        } else if (i == 10008 && obj != null && ((String) obj).equals(Constants.DISABLE_VIDEO_CODEC_WCG)) {
            this.disableVideoCodecWCG = true;
            return;
        }
        super.handleMessage(i, obj);
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public boolean isFallback() {
        return this.fallbackRenderer.get();
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.Renderer
    public boolean isReady() {
        return this.streamingMode || super.isReady();
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public void setFallbackRenderer(boolean z) {
        if (this.fallbackRenderer.get() != z) {
            this.fallbackRenderer.set(z);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer
    public void setJoiningDeadlineMs() {
        if (this.streamingMode) {
            return;
        }
        super.setJoiningDeadlineMs();
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return this.streamingMode || super.shouldForceRenderOutputBuffer(j, j2);
    }

    @Override // com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (!MimeTypes.isVideo(str)) {
            return rv4.a(0);
        }
        if (isFallback()) {
            return rv4.a(0);
        }
        if (DetectCodecsCopyrightUtil.isUnsupportedVideoCopyrightCodec(str)) {
            LogUtil.d(this.TAG, "Video format has no copyright,mime type: " + str);
            return rv4.a(5);
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, format);
        LogUtil.d(this.TAG, "Video format support with mime type: " + str + ", support: " + iSupportsFormat);
        if (FormatUtil.isHDR(format.colorInfo) && DeviceModelDetection.deviceNeedsUnsupportedHDRWorkaround()) {
            LogUtil.d(this.TAG, "Video format with HDR info: " + format.colorInfo);
            throw new VideoOverSpecificationException(new Exception("Device not support HDR 10bit"));
        }
        if (FormatUtil.isUnsupportedDolbyVisionProfile(format)) {
            throw new VideoOverSpecificationException(new Exception("Can not playback dolby-vision videos with profile 20"));
        }
        if ("video/mp4v-es".equals(str) || FormatUtil.isSpecialVideoCodec(format)) {
            return rv4.a(0);
        }
        if (FormatUtil.isFfmpegExtractor(format) && FormatUtil.isVideoPixelFormatHwNotSupported(format)) {
            return rv4.a(0);
        }
        if ((iSupportsFormat & 3) != 3) {
            return iSupportsFormat;
        }
        LogUtil.w(this.TAG, "Format exceed the renderer's capabilities, need reconfigure.");
        this.reconfigureFormat = true;
        return (iSupportsFormat & 32) | (iSupportsFormat & 24) | 4;
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, boolean z2, boolean z3) {
        super(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f, z3);
        this.TAG = "TBLMediaCodecVideoRenderer_ins_" + Thread.currentThread().getId();
        this.reconfigureFormat = false;
        this.needConfigureMaxOutputFrameRate = false;
        this.streamingMode = false;
        this.videoCodecUxEnabled = false;
        this.disableVideoCodecWCG = false;
        this.codecVPPFilterMode = 0;
        this.mMaxFrameRate = 60.0f;
        this.enableCodecVPPFilter = z2;
        this.fallbackRenderer = new AtomicBoolean(false);
        this.dropFrameManager = new VideoDropFrameManager();
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, boolean z2) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, z2, false);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, boolean z2, boolean z3) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, z2, z3);
    }

    private static void logDebug(String str) {
    }
}
