package com.oplus.tblplayer.monitor.sdk;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.BufferingStuckResult;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.SimpleExoPlayer;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.monitor.sdk.StuckReport;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SDKStuckAnalyticsMonitor extends ISDKAnalyticsMonitor {
    private static final String NO_VALUE_STRING = "NULL";
    private static final String TAG = "SDKStuckAnalyticsMonitor";
    private long alreadyPreCacheBytes;
    private StuckReport.Builder builder;
    private Context context;
    private boolean hasStuck;
    private MediaUrl mMediaUrl;
    private SimpleExoPlayer player;
    private long reBufferCount;
    private long reBufferTimeMs;
    private boolean reBuffering;
    private long reBufferingStartTimeMs;
    private SysPerformanceCollector sysPerformanceCollector;
    private long totalNetworkReadBytes;
    private boolean isStarted = false;
    private boolean hasRenderFirstFrame = false;
    private boolean lastPlayWhenReady = false;
    private SDKNetSpeed sdkNetSpeed = new SDKNetSpeed();

    public SDKStuckAnalyticsMonitor(@NonNull SimpleExoPlayer simpleExoPlayer, Context context) {
        this.sysPerformanceCollector = null;
        this.player = simpleExoPlayer;
        this.context = context;
        this.sysPerformanceCollector = new SysPerformanceCollector(context, new PlatformJNI().getSysHz());
    }

    private String getNetworkType() {
        int networkType = Util.getNetworkType(this.context);
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? "OTHER" : "4G" : "3G" : "2G" : "WIFI" : "OFFLINE";
    }

    private int getWifiRssi() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) this.context.getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return -200;
        }
        return connectionInfo.getRssi();
    }

    private boolean isValidState() {
        return this.isStarted && this.builder != null;
    }

    private void maybeAdvanceReBufferCount(boolean z) {
        if (z) {
            LogUtil.d(TAG, "maybeAdvanceReBufferCount");
            this.reBufferCount++;
            this.reBufferTimeMs += System.currentTimeMillis() - this.reBufferingStartTimeMs;
        }
    }

    private void reset() {
        this.builder = null;
        this.isStarted = false;
        this.mMediaUrl = null;
        this.reBufferCount = 0L;
        this.reBufferTimeMs = 0L;
        this.reBuffering = false;
        this.totalNetworkReadBytes = 0L;
        this.alreadyPreCacheBytes = 0L;
        this.hasRenderFirstFrame = false;
        this.sdkNetSpeed.reset();
    }

    public synchronized StuckReport buildStuckReport() {
        if (isValidState() && this.hasStuck) {
            StuckReport.Builder builder = this.builder;
            MediaUrl mediaUrl = this.mMediaUrl;
            StuckReport.Builder mediaUrl2 = builder.setMediaUrl(mediaUrl != null ? mediaUrl.toString() : NO_VALUE_STRING);
            MediaUrl mediaUrl3 = this.mMediaUrl;
            mediaUrl2.setContentType(mediaUrl3 != null ? mediaUrl3.inferContentType() : 3).setMediaDuration(this.player.getDuration()).setLive(this.player.isCurrentWindowDynamic()).setAppCpuRatio(this.sysPerformanceCollector.getAppCpuUsage()).setTotalCpuRatio(this.sysPerformanceCollector.getCpuUsage()).setMemoryUsage(this.sysPerformanceCollector.getMemUsage());
            this.builder.setNetType(getNetworkType()).setSupportPreCache(Globals.isPreCacheEnable()).setMaxCacheFileSize(Globals.getMaxCacheFileSize()).setMaxCacheDirSize(Globals.getMaxCacheDirSize()).setAlreadyPreCachedBytes(this.alreadyPreCacheBytes).setTotalCachedBytes(CacheInfoGetter.getCachedBytes(this.mMediaUrl.getCustomCacheKey(), this.mMediaUrl.getUri())).setTotalBytesTransferred(this.totalNetworkReadBytes).setTotalBufferedDurationMs(this.player.getTotalBufferedDuration()).setReBufferCount(this.reBufferCount).setReBufferTimeMs(this.reBufferTimeMs);
            this.hasStuck = false;
            return this.builder.build();
        }
        LogUtil.d(TAG, "buildStuckReport isValidState false");
        return null;
    }

    public synchronized StuckReport endMonitor() {
        StuckReport stuckReportBuildStuckReport;
        if (isValidState()) {
            stuckReportBuildStuckReport = buildStuckReport();
            reset();
        } else {
            stuckReportBuildStuckReport = null;
        }
        return stuckReportBuildStuckReport;
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        if (isValidState()) {
            this.builder.setDownloadSpeed(j2);
        }
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onBufferingStucked(AnalyticsListener.EventTime eventTime, BufferingStuckResult bufferingStuckResult) {
        LogUtil.d(TAG, "onBufferingStucked result" + bufferingStuckResult);
        if (!isValidState() || bufferingStuckResult == null) {
            LogUtil.d(TAG, "onBufferingStucked isValidState or result null");
            return;
        }
        this.builder.setStuckType(0).setStuckCode(bufferingStuckResult.stuckType).setDecoderMode(getDecoderType(this.player)).setStuckTimeMs(bufferingStuckResult.stuckTimeMs).setStuckDurationMs(bufferingStuckResult.stuckDurationMs).setVideoInputFps(0).setVideoOutputFps(0).setVideoRenderFps(0);
        this.builder.setDownloadSpeed(this.sdkNetSpeed.getNetSpeed());
        this.hasStuck = true;
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
            StuckReport.Builder audioBitrate = this.builder.setSampleRate(format.sampleRate).setAudioBitrate(mediaLoadData.trackFormat.bitrate);
            String str2 = mediaLoadData.trackFormat.sampleMimeType;
            if (str2 != null) {
                str = str2;
            }
            audioBitrate.setAudioMimeType(str);
            return;
        }
        StuckReport.Builder videoBitrate = this.builder.setWidth(format2.width).setHeight(mediaLoadData.trackFormat.height).setFps(mediaLoadData.trackFormat.frameRate).setVideoBitrate(mediaLoadData.trackFormat.bitrate);
        String str3 = mediaLoadData.trackFormat.sampleMimeType;
        if (str3 == null) {
            str3 = NO_VALUE_STRING;
        }
        StuckReport.Builder videoMimeType = videoBitrate.setVideoMimeType(str3);
        String str4 = mediaLoadData.trackFormat.containerMimeType;
        if (str4 != null) {
            str = str4;
        }
        videoMimeType.setContainerMimeType(str);
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
            if (z != this.lastPlayWhenReady) {
                if (z) {
                    this.sdkNetSpeed.reset();
                }
                this.lastPlayWhenReady = z;
            }
        }
    }

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, @Nullable Surface surface) {
        LogUtil.d(TAG, "onRenderedFirstFrame: " + surface);
        if (!isValidState() || this.hasRenderFirstFrame) {
            return;
        }
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

    @Override // com.oplus.tblplayer.monitor.sdk.ISDKAnalyticsMonitor, com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onVideoStucked(AnalyticsListener.EventTime eventTime, VideoStuckResult videoStuckResult) {
        LogUtil.d(TAG, "onVideoStucked result" + videoStuckResult);
        if (!isValidState() || videoStuckResult == null) {
            LogUtil.d(TAG, "onVideoStucked isValidState or result null");
            return;
        }
        this.builder.setStuckType(1).setStuckCode(videoStuckResult.stuckType).setDecoderMode(videoStuckResult.decoderType).setStuckTimeMs(videoStuckResult.stuckTimeMs).setStuckDurationMs(videoStuckResult.stuckDurationMs).setVideoInputFps(videoStuckResult.inputFps).setVideoOutputFps(videoStuckResult.outputFps).setVideoRenderFps(videoStuckResult.renderFps);
        this.builder.setDownloadSpeed(this.sdkNetSpeed.getNetSpeed());
        this.hasStuck = true;
    }

    public synchronized void startMonitor(MediaUrl mediaUrl) {
        if (!isValidState() && mediaUrl != null) {
            reset();
            this.mMediaUrl = mediaUrl;
            this.builder = StuckReport.newBuilder();
            this.alreadyPreCacheBytes = CacheInfoGetter.getCachedBytes(this.mMediaUrl.getCustomCacheKey(), this.mMediaUrl.getUri());
            this.isStarted = true;
            this.sysPerformanceCollector.getAppCpuUsage();
        }
    }
}
