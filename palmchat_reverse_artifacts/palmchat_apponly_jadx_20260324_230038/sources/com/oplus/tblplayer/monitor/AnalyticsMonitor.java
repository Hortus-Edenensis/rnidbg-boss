package com.oplus.tblplayer.monitor;

import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.BufferingStuckResult;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.PlaybackParameters;
import com.oplus.tbl.exoplayer2.Player;
import com.oplus.tbl.exoplayer2.Renderer;
import com.oplus.tbl.exoplayer2.SeekResult;
import com.oplus.tbl.exoplayer2.SimpleExoPlayer;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.audio.AudioAttributes;
import com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.MetadataRenderer;
import com.oplus.tbl.exoplayer2.source.LoadEventInfo;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.source.TrackGroup;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.text.TextRenderer;
import com.oplus.tbl.exoplayer2.trackselection.DefaultTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.MappingTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelection;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectionArray;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.NetSpeedUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import defpackage.mc;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class AnalyticsMonitor implements AnalyticsListener, ErrorCode {
    private static final String TAG = "AnalyticsMonitor";
    private long alreadyPreCacheBytes;
    private boolean audioRendererHasFailed;
    private boolean hasRenderFirstFrame;
    private TrackGroupArray lastSeenTrackGroupArray;
    private SimpleExoPlayer mExoPlayer;
    private MediaInfo mMediaInfo;
    private MediaUrl mMediaUrl;
    private Report.Builder mReportBuilder;
    private boolean rebuffering;
    private long rebufferingStartTimeMs;
    private long startTimeMs;
    private long totalRebufferCount;
    private long totalRebufferTimeMs;
    private DefaultTrackSelector trackSelector;
    private boolean videoRendererHasFailed;
    private long firstRenderTimeMs = 0;
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;
    private boolean isStarted = false;

    public AnalyticsMonitor(SimpleExoPlayer simpleExoPlayer, DefaultTrackSelector defaultTrackSelector) {
        this.mExoPlayer = simpleExoPlayer;
        this.trackSelector = defaultTrackSelector;
    }

    private static String getAdaptiveSupportString(int i, int i2) {
        return i < 2 ? "N/A" : i2 != 0 ? i2 != 8 ? i2 != 16 ? Constants.STRING_VALUE_UNSET : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static String getFormatSupportString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Constants.STRING_VALUE_UNSET : "NO_UNSUPPORTED_COPYRIGHT_TYPE" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    public static float getFrameLossRate(DecoderCounters decoderCounters) {
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

    private static String getTrackStatusString(@Nullable TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true);
    }

    private synchronized int getTrackTypeRendererSupport(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i) {
        int typeSupport = mappedTrackInfo.getTypeSupport(i);
        int i2 = 1;
        if (typeSupport != 0) {
            if (typeSupport == 1) {
                i2 = 2;
            } else if (typeSupport == 4 || typeSupport == 3) {
                Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mExoPlayer, Renderer[].class, "renderers");
                if (this.videoRendererHasFailed || rendererArr == null) {
                    i2 = 4;
                } else {
                    for (int i3 = 0; i3 < mappedTrackInfo.getRendererCount(); i3++) {
                        if (i == mappedTrackInfo.getRendererType(i3)) {
                            if (rendererArr[i3] instanceof MediaCodecRenderer) {
                                if (mappedTrackInfo.getRendererSupport(i3) == 4) {
                                    return 3;
                                }
                            } else if (mappedTrackInfo.getRendererSupport(i3) == 4) {
                                return 5;
                            }
                        }
                    }
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    private void maybeAdvanceRebufferCount(boolean z) {
        if (checkSessionStateValid() && z) {
            LogUtil.d(TAG, "maybeAdvanceRebufferCount");
            this.totalRebufferCount++;
            this.totalRebufferTimeMs += SystemClock.elapsedRealtime() - this.rebufferingStartTimeMs;
        }
    }

    private synchronized void maybeUpdateRebufferInfo(boolean z, int i) {
        if (checkSessionStateValid() && this.hasRenderFirstFrame) {
            if (z && i == 2 && !this.rebuffering) {
                this.rebuffering = true;
                this.rebufferingStartTimeMs = SystemClock.elapsedRealtime();
            } else if (i == 3 && this.rebuffering) {
                maybeAdvanceRebufferCount(true);
                this.rebuffering = false;
            }
        }
    }

    private synchronized void maybeUpdateRenderedFirstFrame(long j) {
        if (checkSessionStateValid() && !this.hasRenderFirstFrame) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMs;
            this.firstRenderTimeMs = jElapsedRealtime;
            this.mReportBuilder.setRenderedFirstFrameTimeMs(jElapsedRealtime);
            this.hasRenderFirstFrame = true;
            LogUtil.d(TAG, "RenderedFirstFrameTimeMs[" + this.firstRenderTimeMs + "]");
        }
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            LogUtil.d(TAG, str + metadata.get(i));
        }
    }

    private void printTrackGroupInfo(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionArray trackSelectionArray) {
        String str;
        int i;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        if (mappedTrackInfo2 == null) {
            str = "printTrackGroupInfo: mappedTrackInfo is null";
        } else {
            LogUtil.d(TAG, "printTrackGroupInfo: [");
            int rendererCount = mappedTrackInfo.getRendererCount();
            int i2 = 0;
            while (true) {
                String str2 = "  ]";
                if (i2 >= rendererCount) {
                    break;
                }
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i2);
                TrackSelection trackSelection = trackSelectionArray.get(i2);
                if (trackGroups.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    i = rendererCount;
                    sb.append("  Renderer:");
                    sb.append(i2);
                    sb.append(" [");
                    LogUtil.d(TAG, sb.toString());
                    int i3 = 0;
                    while (i3 < trackGroups.length) {
                        TrackGroup trackGroup = trackGroups.get(i3);
                        TrackGroupArray trackGroupArray = trackGroups;
                        String str3 = str2;
                        LogUtil.d(TAG, "    Group:" + i3 + ", adaptive_supported=" + getAdaptiveSupportString(trackGroup.length, mappedTrackInfo2.getAdaptiveSupport(i2, i3, false)) + " [");
                        int i4 = 0;
                        while (i4 < trackGroup.length) {
                            LogUtil.d(TAG, "      " + getTrackStatusString(trackSelection, trackGroup, i4) + " Track:" + i4 + ", " + Format.toLogString(trackGroup.getFormat(i4)) + ", supported=" + getFormatSupportString(mappedTrackInfo2.getTrackSupport(i2, i3, i4)));
                            i4++;
                            mappedTrackInfo2 = mappedTrackInfo;
                        }
                        LogUtil.d(TAG, "    ]");
                        i3++;
                        mappedTrackInfo2 = mappedTrackInfo;
                        trackGroups = trackGroupArray;
                        str2 = str3;
                    }
                    String str4 = str2;
                    if (trackSelection != null) {
                        for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                            Metadata metadata = trackSelection.getFormat(i5).metadata;
                            if (metadata != null) {
                                LogUtil.d(TAG, "    Metadata [");
                                printMetadata(metadata, "      ");
                                LogUtil.d(TAG, "    ]");
                                break;
                            }
                        }
                        LogUtil.d(TAG, str4);
                    } else {
                        LogUtil.d(TAG, str4);
                    }
                } else {
                    i = rendererCount;
                }
                i2++;
                mappedTrackInfo2 = mappedTrackInfo;
                rendererCount = i;
            }
            TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
            if (unmappedTrackGroups.length > 0) {
                LogUtil.d(TAG, "  Renderer:None [");
                for (int i6 = 0; i6 < unmappedTrackGroups.length; i6++) {
                    LogUtil.d(TAG, "    Group:" + i6 + " [");
                    TrackGroup trackGroup2 = unmappedTrackGroups.get(i6);
                    for (int i7 = 0; i7 < trackGroup2.length; i7++) {
                        LogUtil.d(TAG, "      " + getTrackStatusString(false) + " Track:" + i7 + ", " + Format.toLogString(trackGroup2.getFormat(i7)) + ", supported=" + getFormatSupportString(0));
                    }
                    LogUtil.d(TAG, "    ]");
                }
                LogUtil.d(TAG, "  ]");
            }
            str = "]";
        }
        LogUtil.d(TAG, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean checkSessionStateValid() {
        boolean z;
        if (this.isStarted) {
            z = this.mReportBuilder != null;
        }
        return z;
    }

    public synchronized Report endSession(boolean z, boolean z2) {
        LogUtil.d(TAG, "endSession: checkState is " + checkSessionStateValid());
        if (!checkSessionStateValid()) {
            return null;
        }
        maybeAdvanceRebufferCount(this.rebuffering);
        Report reportBuild = this.mReportBuilder.setAliveDuration(SystemClock.elapsedRealtime() - this.startTimeMs).setMediaInfo(this.mMediaInfo).setRebufferCount(this.totalRebufferCount, this.totalRebufferTimeMs).setVideoFLR(getFrameLossRate(this.mExoPlayer.getVideoDecoderCounters())).build();
        if (!z) {
            reset();
        } else if (!z2) {
            this.isStarted = false;
        }
        return reportBuild;
    }

    public void formatMediaInfo(int i, Format format) {
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo == null || format == null) {
            return;
        }
        if (i == 1) {
            mediaInfo.audioSampleRate = format.sampleRate;
            mediaInfo.audioMimeType = format.sampleMimeType;
        } else if (i == 2) {
            mediaInfo.width = format.width;
            mediaInfo.height = format.height;
            mediaInfo.videoMimeType = format.sampleMimeType;
            mediaInfo.videoFps = format.frameRate;
        }
    }

    public MediaInfo getMediaInfo() {
        return this.mMediaInfo;
    }

    public long getNetSpeed(int i) {
        if (!checkSessionStateValid()) {
            return 0L;
        }
        long totalRxBytes = NetSpeedUtil.getTotalRxBytes(i);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.lastTimeStamp;
        if (j <= 0) {
            return 0L;
        }
        long j2 = ((totalRxBytes - this.lastTotalRxBytes) * 1000) / j;
        this.lastTimeStamp = jElapsedRealtime;
        this.lastTotalRxBytes = totalRxBytes;
        return j2;
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        mc.a(this, eventTime, audioAttributes);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        mc.b(this, eventTime, str, j);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        mc.c(this, eventTime, str);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        mc.d(this, eventTime, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        mc.e(this, eventTime, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        mc.f(this, eventTime, format);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
        mc.h(this, eventTime, j);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
        mc.i(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        mc.j(this, eventTime, exc);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        mc.k(this, eventTime, i, j, j2);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        mc.l(this, eventTime, i, j, j2);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onBufferingStucked(AnalyticsListener.EventTime eventTime, BufferingStuckResult bufferingStuckResult) {
        mc.m(this, eventTime, bufferingStuckResult);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        LogUtil.d(TAG, "onDecoderDisabled: " + LogUtil.getDecoderCountersString(decoderCounters));
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        mc.o(this, eventTime, i, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        LogUtil.d(TAG, "onDecoderInitialized: decoderName = " + str + " initializationDurationMs " + j);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        LogUtil.d(TAG, "onDecoderInputFormatChanged: " + Format.toLogString(format));
        if (checkSessionStateValid()) {
            formatMediaInfo(i, format);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        mc.r(this, eventTime, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        mc.s(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        mc.t(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        mc.u(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        mc.v(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        mc.w(this, eventTime, exc);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        mc.x(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        mc.y(this, eventTime, i, j);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
        mc.z(this, player, events);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        mc.A(this, eventTime, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        mc.B(this, eventTime, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        mc.C(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        mc.D(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        mc.E(this, eventTime, loadEventInfo, mediaLoadData, iOException, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        mc.F(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        mc.G(this, eventTime, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        mc.H(this, eventTime, mediaItem, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        mc.I(this, eventTime, metadata);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        mc.J(this, eventTime, z, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        mc.K(this, eventTime, playbackParameters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        mc.L(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        mc.M(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        mc.N(this, eventTime, exoPlaybackException);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
        mc.O(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        LogUtil.d(TAG, "onPlayerStateChanged: playWhenReady = " + z + ", state = " + LogUtil.getExoPlayerStateString(i));
        maybeUpdateRebufferInfo(z, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        mc.Q(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, @Nullable Surface surface) {
        LogUtil.d(TAG, "onRenderedFirstFrame: " + surface);
        maybeUpdateRenderedFirstFrame(eventTime.realtimeMs);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        mc.S(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekCompleted(AnalyticsListener.EventTime eventTime, SeekResult seekResult) {
        mc.T(this, eventTime, seekResult);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        mc.U(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        mc.V(this, eventTime);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        mc.W(this, eventTime, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        mc.X(this, eventTime, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onStaticMetadataChanged(AnalyticsListener.EventTime eventTime, List list) {
        mc.Y(this, eventTime, list);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        mc.Z(this, eventTime, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        mc.a0(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        MediaInfo mediaInfo;
        if (!checkSessionStateValid() || trackGroupArray == this.lastSeenTrackGroupArray) {
            return;
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null && (mediaInfo = this.mMediaInfo) != null) {
            mediaInfo.videoRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 2);
            this.mMediaInfo.audioRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 1);
        }
        this.lastSeenTrackGroupArray = trackGroupArray;
        printTrackGroupInfo(currentMappedTrackInfo, trackSelectionArray);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        mc.c0(this, eventTime, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, boolean z) {
        mc.d0(this, eventTime, str, j, z);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        mc.e0(this, eventTime, str);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        mc.f0(this, eventTime, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        mc.g0(this, eventTime, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
        mc.h0(this, eventTime, j, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        mc.i0(this, eventTime, format);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        mc.k0(this, eventTime, i, i2, i3, f);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoStucked(AnalyticsListener.EventTime eventTime, VideoStuckResult videoStuckResult) {
        mc.l0(this, eventTime, videoStuckResult);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        mc.m0(this, eventTime, f);
    }

    public synchronized void reset() {
        this.totalRebufferTimeMs = 0L;
        this.totalRebufferCount = 0L;
        this.rebuffering = false;
        this.alreadyPreCacheBytes = 0L;
        this.mReportBuilder = null;
        this.mMediaUrl = null;
        this.mMediaInfo = null;
        this.startTimeMs = 0L;
        this.firstRenderTimeMs = 0L;
        this.hasRenderFirstFrame = false;
        this.isStarted = false;
        this.lastTimeStamp = 0L;
        this.lastTotalRxBytes = 0L;
        this.audioRendererHasFailed = false;
        this.videoRendererHasFailed = false;
    }

    public synchronized void startSession(MediaUrl mediaUrl) {
        LogUtil.d(TAG, "startSession: checkSessionStateValid is " + checkSessionStateValid());
        if (!checkSessionStateValid() && mediaUrl != null) {
            reset();
            MediaUrl mediaUrl2 = (MediaUrl) Util.castNonNull(mediaUrl);
            this.mMediaUrl = mediaUrl2;
            this.mMediaInfo = new MediaInfo(mediaUrl2.getUri().toString(), this.mMediaUrl.inferContentType());
            this.mReportBuilder = new Report.Builder();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.startTimeMs = jElapsedRealtime;
            this.lastTimeStamp = jElapsedRealtime;
            this.lastTotalRxBytes = NetSpeedUtil.getTotalRxBytes(Process.myUid());
            this.isStarted = true;
        }
    }

    public synchronized void updateCurrentEventInfo(int i, long j, long j2) {
        if (checkSessionStateValid()) {
            this.mReportBuilder.setCurrentPlaybackState(i).setCurrentPlaybackPositionMs(j).setTotalBufferedDurationMs(j2);
        }
    }

    public synchronized void updateFirstReadingFromCache(boolean z) {
        if (checkSessionStateValid()) {
            this.mReportBuilder.setFirstReadingFromCache(z);
        }
    }

    public synchronized void updatePlaybackErrorInfo(int i, Renderer[] rendererArr, ExoPlaybackException exoPlaybackException) {
        if (checkSessionStateValid()) {
            String str = MediaInfo.RENDERER_TYPE_NONE;
            if (exoPlaybackException.type == 1) {
                int i2 = exoPlaybackException.rendererIndex;
                Renderer renderer = null;
                if (rendererArr != null && i2 >= 0 && i2 < rendererArr.length) {
                    renderer = rendererArr[i2];
                }
                if (renderer != null) {
                    if (renderer instanceof TBLMediaCodecVideoRenderer) {
                        str = MediaInfo.RENDERER_TYPE_MC_VIDEO;
                        this.videoRendererHasFailed = true;
                    } else if (renderer instanceof MediaCodecAudioRenderer) {
                        str = MediaInfo.RENDERER_TYPE_MC_AUDIO;
                        this.audioRendererHasFailed = true;
                    } else {
                        str = renderer instanceof TextRenderer ? "TEXT" : renderer instanceof MetadataRenderer ? MediaInfo.RENDERER_TYPE_METADATA : MediaInfo.RENDERER_TYPE_UNKNOWN;
                    }
                }
            }
            this.mReportBuilder.setErrorCode(i).setException(exoPlaybackException).setErrorRenderer(str);
        }
    }

    private static String getTrackStatusString(boolean z) {
        return z ? "[Y]" : "[ ]";
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.g(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.j0(this, eventTime, format, decoderReuseEvaluation);
    }
}
