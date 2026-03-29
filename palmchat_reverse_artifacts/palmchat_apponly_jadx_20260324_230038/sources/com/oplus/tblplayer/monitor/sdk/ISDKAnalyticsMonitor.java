package com.oplus.tblplayer.monitor.sdk;

import android.view.Surface;
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
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.source.LoadEventInfo;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectionArray;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;
import com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer;
import com.oplus.tblplayer.utils.ReflectUtil;
import defpackage.mc;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ISDKAnalyticsMonitor implements AnalyticsListener, TransferListener {
    public int getDecoderType(SimpleExoPlayer simpleExoPlayer) {
        if (simpleExoPlayer == null) {
            return 2;
        }
        int rendererCount = simpleExoPlayer.getRendererCount();
        Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(simpleExoPlayer, Renderer[].class, "renderers");
        if (rendererCount > 0 && rendererArr != null) {
            for (int i = 0; i < rendererCount; i++) {
                Renderer renderer = rendererArr[i];
                if (renderer.getState() >= 1 && renderer.getTrackType() == 2) {
                    if (renderer instanceof MediaCodecVideoRenderer) {
                        return 0;
                    }
                    return renderer instanceof SimpleDecoderVideoRenderer ? 1 : 2;
                }
            }
        }
        return 2;
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
    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        mc.n(this, eventTime, i, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        mc.o(this, eventTime, i, decoderCounters);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        mc.p(this, eventTime, i, str, j);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        mc.q(this, eventTime, i, format);
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
    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        mc.P(this, eventTime, z, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        mc.Q(this, eventTime, i);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        mc.R(this, eventTime, surface);
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
    public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        mc.b0(this, eventTime, trackGroupArray, trackSelectionArray);
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

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.g(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.j0(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
    }
}
