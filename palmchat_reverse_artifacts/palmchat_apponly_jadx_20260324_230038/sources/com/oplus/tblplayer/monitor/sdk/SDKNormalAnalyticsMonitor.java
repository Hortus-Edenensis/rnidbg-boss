package com.oplus.tblplayer.monitor.sdk;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.SimpleExoPlayer;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.monitor.ErrorCodeProvider;
import com.oplus.tblplayer.monitor.sdk.NormalReport;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SDKNormalAnalyticsMonitor extends ISDKAnalyticsMonitor {
    private static final int NO_VALUE_INTEGER = 0;
    private static final long NO_VALUE_LONG = 0;
    private static final String NO_VALUE_STRING = "NULL";
    private static final String TAG = "SDKNormalAnalyticsMonitor";
    private long alreadyPreCacheBytes;
    private NormalReport.Builder builder;
    private Context context;
    private MediaUrl mMediaUrl;
    private SimpleExoPlayer player;
    private boolean reBuffering;
    private long reBufferingStartTimeMs;
    private long totalNetworkReadBytes;
    private boolean isStarted = false;
    private long startTimeMs = 0;
    private int errorCode = 0;
    private long loadTimeMs = 0;
    private long aliveDurationMs = 0;
    private long reBufferingCount = 0;
    private long reBufferingTimeMs = 0;
    private boolean hasRenderFirstFrame = false;
    private SDKNetSpeed sdkNetSpeed = new SDKNetSpeed();

    public SDKNormalAnalyticsMonitor(@NonNull SimpleExoPlayer simpleExoPlayer, Context context) {
        this.player = simpleExoPlayer;
        this.context = context;
    }

    private static float getFrameLossRate(DecoderCounters decoderCounters) {
        float f = 0.0f;
        if (decoderCounters != null) {
            try {
                decoderCounters.ensureUpdated();
                LogUtil.d(TAG, "VideoDecoderCounters: " + LogUtil.getDecoderCountersString(decoderCounters));
                long j = (long) decoderCounters.droppedBufferCount;
                long j2 = ((long) decoderCounters.renderedOutputBufferCount) + j;
                if (j2 > 0 && j > 0) {
                    f = j / j2;
                }
            } catch (Exception unused) {
            }
        }
        return Math.round(f * 1000.0f) / 1000.0f;
    }

    private String getNetworkType() {
        int networkType = Util.getNetworkType(this.context);
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? "OTHER" : "4G" : "3G" : "2G" : "WIFI" : "OFFLINE";
    }

    private NormalReport getReport() {
        NormalReport.Builder builder = this.builder;
        MediaUrl mediaUrl = this.mMediaUrl;
        NormalReport.Builder mediaDuration = builder.setMediaUrl(mediaUrl != null ? mediaUrl.toString() : NO_VALUE_STRING).setMediaDuration(this.player.getDuration());
        MediaUrl mediaUrl2 = this.mMediaUrl;
        mediaDuration.setContentType(mediaUrl2 != null ? mediaUrl2.inferContentType() : 3).setLive(this.player.isCurrentWindowDynamic());
        DecoderCounters videoDecoderCounters = this.player.getVideoDecoderCounters();
        this.aliveDurationMs = System.currentTimeMillis() - this.startTimeMs;
        this.builder.setErrorCode(this.errorCode).setAliveDurationMs(this.aliveDurationMs).setCurPositionMs(this.player.getContentPosition()).setReBufferingCount(this.reBufferingCount).setReBufferingTimeMs(this.reBufferingTimeMs).setVideoFLR(getFrameLossRate(videoDecoderCounters)).setDecoderMode(getDecoderType(this.player));
        this.builder.setNetType(getNetworkType()).setDownloadSpeed(this.sdkNetSpeed.getNetSpeed()).setSupportPreCache(Globals.isPreCacheEnable()).setMaxCacheFileSize(Globals.getMaxCacheFileSize()).setMaxCacheDirSize(Globals.getMaxCacheDirSize()).setAlreadyPreCachedBytes(this.alreadyPreCacheBytes).setTotalCachedBytes(CacheInfoGetter.getCachedBytes(this.mMediaUrl.getCustomCacheKey(), this.mMediaUrl.getUri())).setTotalBytesTransferred(this.totalNetworkReadBytes).setTotalBufferedDurationMs(this.player.getTotalBufferedDuration());
        return this.builder.build();
    }

    private boolean isValidState() {
        return this.isStarted && this.builder != null;
    }

    private void maybeAdvanceReBufferCount(boolean z) {
        if (z) {
            LogUtil.d(TAG, "maybeAdvanceReBufferCount");
            this.reBufferingCount++;
            this.reBufferingTimeMs += System.currentTimeMillis() - this.reBufferingStartTimeMs;
        }
    }

    private void reset() {
        this.isStarted = false;
        this.errorCode = 0;
        this.mMediaUrl = null;
        this.hasRenderFirstFrame = false;
        this.startTimeMs = 0L;
        this.loadTimeMs = 0L;
        this.aliveDurationMs = 0L;
        this.reBufferingCount = 0L;
        this.reBufferingTimeMs = 0L;
        this.reBuffering = false;
        this.reBufferingStartTimeMs = 0L;
        this.totalNetworkReadBytes = 0L;
        this.alreadyPreCacheBytes = 0L;
    }

    public synchronized NormalReport endMonitor() {
        NormalReport report;
        if (isValidState()) {
            report = getReport();
            reset();
        } else {
            report = null;
        }
        return report;
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (z) {
            this.totalNetworkReadBytes += (long) i;
        }
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        Format format;
        Format format2;
        if (!isValidState()) {
            LogUtil.d(TAG, "onDownstreamFormatChanged isValidState false");
            return;
        }
        int i = mediaLoadData.trackType;
        String str = NO_VALUE_STRING;
        if (i != 2 || (format2 = mediaLoadData.trackFormat) == null) {
            if (i != 1 || (format = mediaLoadData.trackFormat) == null) {
                return;
            }
            NormalReport.Builder audioBitrate = this.builder.setSampleRate(format.sampleRate).setAudioBitrate(mediaLoadData.trackFormat.bitrate);
            String str2 = mediaLoadData.trackFormat.sampleMimeType;
            if (str2 != null) {
                str = str2;
            }
            audioBitrate.setAudioMimeType(str);
            return;
        }
        NormalReport.Builder videoBitrate = this.builder.setWidth(format2.width).setHeight(mediaLoadData.trackFormat.height).setFps(mediaLoadData.trackFormat.frameRate).setVideoBitrate(mediaLoadData.trackFormat.bitrate);
        String str3 = mediaLoadData.trackFormat.sampleMimeType;
        if (str3 == null) {
            str3 = NO_VALUE_STRING;
        }
        NormalReport.Builder videoMimeType = videoBitrate.setVideoMimeType(str3);
        String str4 = mediaLoadData.trackFormat.containerMimeType;
        if (str4 != null) {
            str = str4;
        }
        videoMimeType.setContainerMimeType(str);
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        int exception;
        int i;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            exception = ErrorCodeProvider.parseException((exoPlaybackException.type != 1 || (i = exoPlaybackException.rendererIndex) < 0 || i >= simpleExoPlayer.getRendererCount()) ? -1 : this.player.getRendererType(exoPlaybackException.rendererIndex), exoPlaybackException);
        } else {
            exception = ErrorCode.REASON_OTHERS;
        }
        this.errorCode = exception;
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        if (this.hasRenderFirstFrame) {
            if (z && i == 2 && !this.reBuffering) {
                this.reBuffering = true;
                this.reBufferingStartTimeMs = System.currentTimeMillis();
            } else if (i == 3 && this.reBuffering) {
                maybeAdvanceReBufferCount(true);
                this.reBuffering = false;
            }
        }
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, @Nullable Surface surface) {
        LogUtil.d(TAG, "onRenderedFirstFrame: " + surface);
        if (!isValidState() || this.hasRenderFirstFrame) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTimeMs;
        this.loadTimeMs = jCurrentTimeMillis;
        this.builder.setLoadTimeMs(jCurrentTimeMillis);
        this.hasRenderFirstFrame = true;
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        if (isValidState()) {
            this.builder.setWidth(i).setHeight(i2);
        } else {
            LogUtil.d(TAG, "onVideoSizeChanged isValidState false");
        }
    }

    public synchronized void startMonitor(MediaUrl mediaUrl) {
        if (!isValidState() && mediaUrl != null) {
            reset();
            this.mMediaUrl = mediaUrl;
            this.builder = NormalReport.newBuilder();
            this.startTimeMs = System.currentTimeMillis();
            this.alreadyPreCacheBytes = CacheInfoGetter.getCachedBytes(this.mMediaUrl.getCustomCacheKey(), this.mMediaUrl.getUri());
            this.isStarted = true;
        }
    }
}
