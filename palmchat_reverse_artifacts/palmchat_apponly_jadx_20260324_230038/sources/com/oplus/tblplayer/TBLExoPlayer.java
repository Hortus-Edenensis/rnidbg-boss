package com.oplus.tblplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.BufferingStuckResult;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DefaultRenderersFactory;
import com.oplus.tbl.exoplayer2.DefaultStreamingSpeedControl;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.FrameTimeRecorder;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.PlaybackParameters;
import com.oplus.tbl.exoplayer2.Player;
import com.oplus.tbl.exoplayer2.Renderer;
import com.oplus.tbl.exoplayer2.SeekParameters;
import com.oplus.tbl.exoplayer2.SeekResult;
import com.oplus.tbl.exoplayer2.SimpleExoPlayer;
import com.oplus.tbl.exoplayer2.StreamingStuckResult;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.audio.AudioAttributes;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram;
import com.oplus.tbl.exoplayer2.ext.okhttp.OkHttpDataSourceFactory;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.source.BehindLiveWindowException;
import com.oplus.tbl.exoplayer2.source.ConcatenatingMediaSource;
import com.oplus.tbl.exoplayer2.source.LoadEventInfo;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.ProgressiveMediaSource;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.DefaultTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.MappingTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectionArray;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.DefaultBandwidthMeter;
import com.oplus.tbl.exoplayer2.upstream.DefaultDataSourceFactory;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.MediaCodecVideoRenderer;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;
import com.oplus.tblplayer.TBLExoPlayer;
import com.oplus.tblplayer.TBLLoadControl;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.config.PlayerConfiguration;
import com.oplus.tblplayer.configure.LoadConfig;
import com.oplus.tblplayer.managers.SlowMotionManager;
import com.oplus.tblplayer.managers.TBLSourceManager;
import com.oplus.tblplayer.misc.DeviceModelDetection;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.misc.TBLTrackInfo;
import com.oplus.tblplayer.misc.TrackInfoProvider;
import com.oplus.tblplayer.monitor.AnalyticsMonitor;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.monitor.ErrorCodeProvider;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.monitor.sdk.NormalReport;
import com.oplus.tblplayer.monitor.sdk.SDKAnalyticsMonitorManager;
import com.oplus.tblplayer.monitor.sdk.StuckReport;
import com.oplus.tblplayer.processor.FrameInterpolationEffect;
import com.oplus.tblplayer.render.FallbackRenderer;
import com.oplus.tblplayer.render.RollupRenderer;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import com.oplus.tblplayer.render.TBLRenderersFactory;
import com.oplus.tblplayer.uploader.DcsUploader;
import com.oplus.tblplayer.upstream.FileDescriptorDataSource;
import com.oplus.tblplayer.upstream.IDataChannel;
import com.oplus.tblplayer.upstream.RedirectTransferListener;
import com.oplus.tblplayer.upstream.TBLAes128DataSource;
import com.oplus.tblplayer.upstream.TBLAesCipherDataSourceFactory;
import com.oplus.tblplayer.upstream.TBLBandwidthMeter;
import com.oplus.tblplayer.upstream.TBLEncryptDataSourceFactory;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.FormatUtil;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import com.oplus.tblplayer.widget.IVideoProcessingView;
import defpackage.yb2;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLExoPlayer extends AbstractMediaPlayer implements Constants {
    private static final String AES_CIPHER_DATA_SOURCE = "AesCipherDataSource";
    private static final String CLEAR_VIDEO_OVER_SPEC_FLAG = "clear_video_over_spec_flag";
    private static final String SET_VIDEO_OVER_SPEC_FLAG = "set_video_over_spec_flag";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player is accessed on the wrong thread. See Exoplayer's introduction to threads in Developers";
    private String TAG;
    private int dropFramePolicy;
    private final List<MediaItem> exoPlayerPlaylist;
    private final List<FallbackRenderer> fallbackRenderers;
    private boolean hasNotifyPlaybackResult;
    private boolean hasRetryPlayback;
    private boolean isBuffering;
    private boolean isGetReportAtActiveMode;
    private boolean isMiniViewEnabled;
    private boolean isRetryPlayback;
    private boolean isSoftwareDecoder;
    private boolean isVideoFormatExceededSpec;
    private int lastBufferedPercent;
    private int loadingState;
    private int loopingTransition;
    protected Context mAppContext;
    protected TBLBandwidthMeter mBandwidthMeter;
    protected int mCurrentState;
    protected Handler mEventHandler;
    protected InnerAnalyticsListener mInnerListener;
    protected SimpleExoPlayer mInternalPlayer;
    private boolean mIsStreamingMode;
    protected TBLLoadControl mLoadControl;
    protected AnalyticsMonitor mMonitor;
    private volatile boolean mNeedFfmpegVideoDecoderWorkaround;
    protected DefaultRenderersFactory mRenderersFactory;
    protected SDKAnalyticsMonitorManager mSDKAnalyticsMonitorManager;
    protected SlowMotionManager mSlowMotion;
    protected DefaultTrackSelector mTrackSelector;
    protected MediaSource mediaSource;
    protected MediaUrl mediaUrl;
    private final List<MediaUrl> mediaUrlList;
    private boolean pendingSeek;
    private boolean pendingStart;

    @NonNull
    protected PlayerConfiguration playerConfiguration;
    private boolean renderedFirstFrame;
    private final List<RollupRenderer> rollupRenderers;
    protected TrafficStatisticMonitor trafficMonitor;
    private int videoBitrate;
    private float videoFramerate;
    private int videoHeight;
    private int videoWidth;

    /* JADX INFO: compiled from: SearchBox */
    public class InnerAnalyticsListener implements AnalyticsListener, CacheDataSource.EventListener, TBLLoadControl.EventListener {
        private final CopyOnWriteArraySet<AnalyticsListener> listeners = new CopyOnWriteArraySet<>();

        public InnerAnalyticsListener() {
        }

        public void addListener(AnalyticsListener analyticsListener) {
            this.listeners.add(analyticsListener);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioAttributesChanged(eventTime, audioAttributes);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioDecoderInitialized(eventTime, str, j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioDecoderReleased(eventTime, str);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioDisabled(eventTime, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioEnabled(eventTime, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioInputFormatChanged(eventTime, format);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioPositionAdvancing(eventTime, j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioSessionIdChanged(eventTime, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioSinkError(eventTime, exc);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioUnderrun(eventTime, i, j, j2);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onBandwidthEstimate(eventTime, i, j, j2);
            }
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onBufferedPercentChanged(int i) {
            if (TBLExoPlayer.this.loadingState == 1) {
                TBLExoPlayer.this.maybeNotifyBufferedUpdate(1);
            }
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onBufferingPercentChanged(int i) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onBufferingPercentChanged: percent is " + i);
            if (TBLExoPlayer.this.isBuffering) {
                TBLExoPlayer.this.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onBufferingStucked(AnalyticsListener.EventTime eventTime, BufferingStuckResult bufferingStuckResult) {
            StuckReport stuckReport;
            LogUtil.d(TBLExoPlayer.this.TAG, "onBufferingStucked: " + bufferingStuckResult);
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onBufferingStucked(eventTime, bufferingStuckResult);
            }
            SDKAnalyticsMonitorManager sDKAnalyticsMonitorManager = TBLExoPlayer.this.mSDKAnalyticsMonitorManager;
            if (sDKAnalyticsMonitorManager == null || (stuckReport = sDKAnalyticsMonitorManager.getStuckReport()) == null) {
                return;
            }
            DcsUploader.report(TBLExoPlayer.this.mAppContext, stuckReport);
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource.EventListener
        public void onCacheIgnored(int i) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onCacheIgnored: CacheIgnoredReason is " + i);
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource.EventListener
        public void onCachedBytesRead(long j, long j2) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onCachedBytesRead: " + j2);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDecoderDisabled(eventTime, i, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDecoderEnabled(eventTime, i, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDecoderInitialized(eventTime, i, str, j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDecoderInputFormatChanged(eventTime, i, format);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDownstreamFormatChanged(@NonNull AnalyticsListener.EventTime eventTime, @NonNull MediaLoadData mediaLoadData) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDownstreamFormatChanged(eventTime, mediaLoadData);
            }
            if (TBLExoPlayer.this.isPlayable()) {
                TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
                if ((tBLExoPlayer.mCurrentState & 4) != 0) {
                    tBLExoPlayer.maybeUpdatePlaybackState(8);
                    TBLExoPlayer.this.notifyOnPrepared();
                    if (TBLExoPlayer.this.pendingStart && !TBLExoPlayer.this.mInternalPlayer.getPlayWhenReady()) {
                        TBLExoPlayer.this.mInternalPlayer.setPlayWhenReady(true);
                        TBLExoPlayer.this.pendingStart = false;
                    }
                }
            }
            Format format = mediaLoadData.trackFormat;
            if (format != null) {
                int i = mediaLoadData.trackType;
                if (i != 2) {
                    if (i == 1) {
                        int formatTagForSpecialVideo = FormatUtil.getFormatTagForSpecialVideo(format);
                        if (formatTagForSpecialVideo == 1 || formatTagForSpecialVideo == 2) {
                            LogUtil.i(TBLExoPlayer.this.TAG, "Notify binaural capture " + formatTagForSpecialVideo + "-pass video info.");
                            TBLExoPlayer.this.notifyOnInfo(20009, Integer.valueOf(formatTagForSpecialVideo));
                            return;
                        }
                        return;
                    }
                    return;
                }
                TBLExoPlayer.this.videoHeight = format.height;
                TBLExoPlayer.this.videoWidth = mediaLoadData.trackFormat.width;
                TBLExoPlayer.this.videoFramerate = mediaLoadData.trackFormat.frameRate;
                TBLExoPlayer.this.videoBitrate = mediaLoadData.trackFormat.averageBitrate;
                Format format2 = mediaLoadData.trackFormat;
                int i2 = format2.rotationDegrees;
                float f = format2.pixelWidthHeightRatio;
                LogUtil.dfmt(TBLExoPlayer.this.TAG, "notifyOnDownstreamSizeChanged: [%d, %d, %d, %f]", Integer.valueOf(TBLExoPlayer.this.videoWidth), Integer.valueOf(TBLExoPlayer.this.videoHeight), Integer.valueOf(i2), Float.valueOf(f));
                TBLExoPlayer tBLExoPlayer2 = TBLExoPlayer.this;
                tBLExoPlayer2.notifyOnDownstreamSizeChanged(tBLExoPlayer2.videoWidth, TBLExoPlayer.this.videoHeight, i2, f);
                if (TBLExoPlayer.this.isSoftwareDecoder || TBLExoPlayer.this.isVideoFormatExceededSpec) {
                    TBLExoPlayer.this.maybeNotifyVideoHighSpecInfo();
                }
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmKeysLoaded(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmKeysRemoved(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmKeysRestored(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmSessionAcquired(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmSessionManagerError(eventTime, exc);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDrmSessionReleased(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDroppedVideoFrames(eventTime, i, j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onEvents(Player player, AnalyticsListener.Events events) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onEvents(player, events);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource.EventListener
        public void onFirstReadingFromCache(long j) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onFirstReadingFromCache: " + j);
            ((AnalyticsMonitor) AssertUtil.checkNotNull(TBLExoPlayer.this.mMonitor)).updateFirstReadingFromCache(true);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onIsLoadingChanged(@NonNull AnalyticsListener.EventTime eventTime, boolean z) {
            int i;
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIsLoadingChanged(eventTime, z);
            }
            TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
            if (!z) {
                if (tBLExoPlayer.loadingState != 2) {
                    tBLExoPlayer = TBLExoPlayer.this;
                    i = 0;
                }
                TBLExoPlayer.this.maybeResumeForLiveWindow(z);
            }
            i = 1;
            tBLExoPlayer.maybeNotifyBufferedUpdate(i);
            TBLExoPlayer.this.maybeResumeForLiveWindow(z);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onIsPlayingChanged(@NonNull AnalyticsListener.EventTime eventTime, boolean z) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIsPlayingChanged(eventTime, z);
            }
            TBLExoPlayer.this.notifyOnIsPlayingChanged(z);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onLoadCanceled(eventTime, loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onLoadCompleted(@NonNull AnalyticsListener.EventTime eventTime, @NonNull LoadEventInfo loadEventInfo, @NonNull MediaLoadData mediaLoadData) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onLoadCompleted(eventTime, loadEventInfo, mediaLoadData);
            }
            TBLExoPlayer.this.maybeNotifyBufferedUpdate(2);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onLoadError(@NonNull AnalyticsListener.EventTime eventTime, @NonNull LoadEventInfo loadEventInfo, @NonNull MediaLoadData mediaLoadData, @NonNull IOException iOException, boolean z) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onLoadError: wasCanceled is " + z + iOException.getMessage());
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onLoadError(eventTime, loadEventInfo, mediaLoadData, iOException, z);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onLoadStarted(eventTime, loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onLoadingChanged(eventTime, z);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onMediaItemTransition(eventTime, mediaItem, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onMetadata(eventTime, metadata);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayWhenReadyChanged(eventTime, z, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackParametersChanged(eventTime, playbackParameters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackStateChanged(eventTime, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackSuppressionReasonChanged(eventTime, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlayerError(@NonNull AnalyticsListener.EventTime eventTime, @NonNull ExoPlaybackException exoPlaybackException) {
            int iMaybeUpdatePlaybackErrorInfo;
            LogUtil.e(TBLExoPlayer.this.TAG, "Playback error. Is playable " + TBLExoPlayer.this.isPlayable(), exoPlaybackException);
            if (TBLExoPlayer.this.isPlayable()) {
                TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
                tBLExoPlayer.hasRetryPlayback = tBLExoPlayer.maybeRetryForPlaybackError(exoPlaybackException);
                LogUtil.d(TBLExoPlayer.this.TAG, "hasRetryPlayback " + TBLExoPlayer.this.hasRetryPlayback);
                if (TBLExoPlayer.this.hasRetryPlayback) {
                    return;
                }
                Iterator<AnalyticsListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerError(eventTime, exoPlaybackException);
                }
                TBLExoPlayer tBLExoPlayer2 = TBLExoPlayer.this;
                if (tBLExoPlayer2.playerConfiguration.activeReportModeEnabled) {
                    iMaybeUpdatePlaybackErrorInfo = tBLExoPlayer2.maybeUpdatePlaybackErrorInfo(exoPlaybackException);
                    TBLExoPlayer.this.maybeUpdatePlaybackState(0);
                } else {
                    tBLExoPlayer2.maybeUpdatePlaybackState(0);
                    iMaybeUpdatePlaybackErrorInfo = TBLExoPlayer.this.maybeUpdatePlaybackErrorInfo(exoPlaybackException);
                }
                LogUtil.d(TBLExoPlayer.this.TAG, "Unable to retry or retry also failed and error code is " + iMaybeUpdatePlaybackErrorInfo);
                TBLExoPlayer.this.notifyOnError(exoPlaybackException.type, iMaybeUpdatePlaybackErrorInfo, exoPlaybackException.getMessage());
                TBLExoPlayer.this.isGetReportAtActiveMode = false;
                TBLExoPlayer.this.maybeAnalyticsMonitorReport();
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerReleased(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPlayerStateChanged(@NonNull AnalyticsListener.EventTime eventTime, boolean z, int i) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onPlayerStateChanged: playWhenReady = " + z + ", state = " + LogUtil.getExoPlayerStateString(i));
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(eventTime, z, i);
            }
            TBLExoPlayer.this.maybeNotifyBuffingInfo(z, i);
            TBLExoPlayer.this.handleInternalPlayerStateChanged(z, i);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onPositionDiscontinuity(@NonNull AnalyticsListener.EventTime eventTime, int i) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onPositionDiscontinuity: " + LogUtil.getDiscontinuityReasonString(i));
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPositionDiscontinuity(eventTime, i);
            }
            if (TBLExoPlayer.this.isPlayable()) {
                if (i == 0) {
                    TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
                    tBLExoPlayer.notifyOnInfo(20002, Integer.valueOf(TBLExoPlayer.access$2804(tBLExoPlayer)));
                } else if ((i == 1 || i == 2) && TBLExoPlayer.this.mInternalPlayer.getPlaybackState() == 4) {
                    TBLExoPlayer.this.renderedFirstFrame = false;
                }
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onRenderedFirstFrame(@NonNull AnalyticsListener.EventTime eventTime, @Nullable Surface surface) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRenderedFirstFrame(eventTime, surface);
            }
            if (TBLExoPlayer.this.renderedFirstFrame) {
                return;
            }
            LogUtil.d(TBLExoPlayer.this.TAG, "onRenderedFirstFrame: will notify has rendered first frame.");
            TBLExoPlayer.this.maybeEnableSlowMotion(true);
            TBLExoPlayer.this.notifyOnInfo(20003, Long.valueOf(eventTime.realtimeMs));
            TBLExoPlayer.this.renderedFirstFrame = true;
            if (TBLExoPlayer.this.isMiniViewEnabled) {
                LogUtil.d(TBLExoPlayer.this.TAG, "disable audio render");
                TBLExoPlayer.this.setTrackRendererDisable(1, true);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(eventTime, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onSeekCompleted(@NonNull AnalyticsListener.EventTime eventTime, @NonNull SeekResult seekResult) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekCompleted(eventTime, seekResult);
            }
            TBLExoPlayer.this.notifyOnSeekComplete();
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekProcessed(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekStarted(eventTime);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeChanged(eventTime, z);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSkipSilenceEnabledChanged(eventTime, z);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onStaticMetadataChanged(AnalyticsListener.EventTime eventTime, List<Metadata> list) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onStaticMetadataChanged(eventTime, list);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onSurfaceSizeChanged(@NonNull AnalyticsListener.EventTime eventTime, int i, int i2) {
            LogUtil.dfmt(TBLExoPlayer.this.TAG, "onSurfaceSizeChanged: [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSurfaceSizeChanged(eventTime, i, i2);
            }
            TBLExoPlayer.this.renderedFirstFrame = false;
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onTimelineChanged(@NonNull AnalyticsListener.EventTime eventTime, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onTimelineChanged(eventTime, i);
            }
            if (TBLExoPlayer.this.isPlayable()) {
                TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
                if (tBLExoPlayer.mediaSource instanceof ConcatenatingMediaSource) {
                    LogUtil.d(tBLExoPlayer.TAG, "onTimelineChanged: " + i);
                    TBLExoPlayer tBLExoPlayer2 = TBLExoPlayer.this;
                    if (tBLExoPlayer2.isExoPlayerMediaItemsChanged(tBLExoPlayer2.mInternalPlayer.getCurrentTimeline())) {
                        TBLExoPlayer tBLExoPlayer3 = TBLExoPlayer.this;
                        tBLExoPlayer3.updatePlaylist(tBLExoPlayer3.mInternalPlayer.getCurrentTimeline());
                    }
                }
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onTracksChanged(@NonNull AnalyticsListener.EventTime eventTime, @NonNull TrackGroupArray trackGroupArray, @NonNull TrackSelectionArray trackSelectionArray) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onTracksChanged(eventTime, trackGroupArray, trackSelectionArray);
            }
            if (!TBLExoPlayer.this.isPlayable() || trackGroupArray == TrackGroupArray.EMPTY) {
                return;
            }
            if (Globals.isDetectCodecsCopyrightEnabled() && (currentMappedTrackInfo = TBLExoPlayer.this.mTrackSelector.getCurrentMappedTrackInfo()) != null) {
                int typeSupport = currentMappedTrackInfo.getTypeSupport(2);
                boolean z = true;
                int typeSupport2 = currentMappedTrackInfo.getTypeSupport(1);
                LogUtil.d(TBLExoPlayer.this.TAG, "videoRendererSupport " + typeSupport + ", audioRendererSupport " + typeSupport2);
                if ((typeSupport != 2 || typeSupport2 != 2) && (typeSupport != 0 || typeSupport2 != 1)) {
                    z = false;
                }
                if (z) {
                    LogUtil.d(TBLExoPlayer.this.TAG, "audio/video codec both have problem, stop.");
                    TBLExoPlayer.this.mInternalPlayer.stop();
                    TBLExoPlayer.this.maybeUpdatePlaybackState(0);
                    TBLExoPlayer.this.notifyOnError(0, ErrorCode.REASON_UNSUPPORT_FORMAT, "unsupported audio/video codec, unsupported file format");
                    return;
                }
                if (typeSupport == 2) {
                    LogUtil.d(TBLExoPlayer.this.TAG, "Video codec has copyright problem,notify.");
                    TBLExoPlayer.this.notifyOnInfo(30001, null);
                }
                if (typeSupport2 == 2) {
                    LogUtil.d(TBLExoPlayer.this.TAG, "Audio codec has copyright problem,notify.");
                    TBLExoPlayer.this.notifyOnInfo(30002, null);
                }
            }
            TBLExoPlayer.this.notifyOnInfo(20007, null);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onUpstreamDiscarded(eventTime, mediaLoadData);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, boolean z) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoDecoderInitialized(eventTime, str, j, z);
            }
            if (str.toUpperCase().contains("FFMPEG")) {
                TBLExoPlayer.this.isSoftwareDecoder = true;
                TBLExoPlayer.this.maybeNotifyVideoHighSpecInfo();
                return;
            }
            if (z && DeviceModelDetection.deviceNeedsNotifyHighSpecWorkaround()) {
                TBLExoPlayer.this.isVideoFormatExceededSpec = true;
                TBLExoPlayer.this.maybeNotifyVideoHighSpecInfo();
            }
            TBLExoPlayer.this.isSoftwareDecoder = false;
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoDecoderReleased(eventTime, str);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoDisabled(eventTime, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoEnabled(eventTime, decoderCounters);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoFrameProcessingOffset(eventTime, j, i);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoInputFormatChanged(eventTime, format);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoSizeChanged(@NonNull AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoSizeChanged(eventTime, i, i2, i3, f);
            }
            TBLExoPlayer.this.videoWidth = i;
            TBLExoPlayer.this.videoHeight = i2;
            LogUtil.dfmt(TBLExoPlayer.this.TAG, "onVideoSizeChanged: [%d, %d, %d, %f]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f));
            TBLExoPlayer.this.notifyOnVideoSizeChanged(i, i2, i3, f);
            if (i3 > 0) {
                TBLExoPlayer.this.notifyOnInfo(10001, Integer.valueOf(i3));
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoStucked(AnalyticsListener.EventTime eventTime, VideoStuckResult videoStuckResult) {
            StuckReport stuckReport;
            LogUtil.d(TBLExoPlayer.this.TAG, "onVideoStucked:" + videoStuckResult);
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoStucked(eventTime, videoStuckResult);
            }
            SDKAnalyticsMonitorManager sDKAnalyticsMonitorManager = TBLExoPlayer.this.mSDKAnalyticsMonitorManager;
            if (sDKAnalyticsMonitorManager == null || (stuckReport = sDKAnalyticsMonitorManager.getStuckReport()) == null) {
                return;
            }
            DcsUploader.report(TBLExoPlayer.this.mAppContext, stuckReport);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVolumeChanged(eventTime, f);
            }
        }

        public void removeListener(AnalyticsListener analyticsListener) {
            this.listeners.remove(analyticsListener);
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
        public void onVideoInputFormatChanged(@NonNull AnalyticsListener.EventTime eventTime, @NonNull Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
            }
            TBLExoPlayer.this.maybeNotifyHdrInfo(format);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class TrafficStatisticMonitor implements RedirectTransferListener {
        private Report report;
        private AtomicBoolean transferEnded = new AtomicBoolean(true);
        private AtomicLong totalBytesTransferred = new AtomicLong(0);

        public TrafficStatisticMonitor() {
        }

        private boolean isMaybePostReportPlayerState(int i) {
            return (i & 449) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$maybePostReport$3() {
            TBLExoPlayer.this.notifyOnPlaybackResult(((Report) AssertUtil.checkNotNull(getReport())).copyWithBytesTransferred(getBytesTransferred()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$maybePostReport$4() {
            TBLExoPlayer.this.notifyOnPlaybackResult(((Report) AssertUtil.checkNotNull(getReport())).copyWithBytesTransferred(getBytesTransferred()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOriginalTransferred$1(String[] strArr) {
            TBLExoPlayer.this.notifyOnInfo(20005, strArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRedirectTransferred$0(List list) {
            TBLExoPlayer.this.notifyOnInfo(20004, list.toArray());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRedirecting$2(String[] strArr) {
            TBLExoPlayer.this.notifyOnInfo(20006, strArr);
        }

        private void maybePostReport() {
            Handler handler;
            Runnable runnable;
            if (TBLExoPlayer.this.playerConfiguration.activeReportModeEnabled) {
                if (getReport() == null || !isTransferEnded() || TBLExoPlayer.this.hasNotifyPlaybackResult || !isMaybePostReportPlayerState(TBLExoPlayer.this.mCurrentState)) {
                    return;
                }
                TBLExoPlayer.this.hasNotifyPlaybackResult = true;
                handler = TBLExoPlayer.this.mEventHandler;
                runnable = new Runnable() { // from class: com.oplus.tblplayer.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7681a.lambda$maybePostReport$3();
                    }
                };
            } else {
                if (getReport() == null || !isTransferEnded()) {
                    return;
                }
                handler = TBLExoPlayer.this.mEventHandler;
                runnable = new Runnable() { // from class: com.oplus.tblplayer.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7682a.lambda$maybePostReport$4();
                    }
                };
            }
            handler.post(runnable);
        }

        public long getBytesTransferred() {
            return this.totalBytesTransferred.get();
        }

        public synchronized Report getReport() {
            return this.report;
        }

        public boolean isTransferEnded() {
            return this.transferEnded.get();
        }

        @Override // com.oplus.tblplayer.upstream.RedirectTransferListener
        public void onBytesDiscarded(DataSource dataSource, long j, boolean z) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onBytesDiscarded: " + j);
            if (z) {
                this.totalBytesTransferred.getAndAdd(j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
        public void onBytesTransferred(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z, int i) {
            if (TBLExoPlayer.this.isPlayable() && z) {
                this.totalBytesTransferred.getAndAdd(i);
            }
        }

        @Override // com.oplus.tblplayer.upstream.RedirectTransferListener
        public void onOriginalTransferred(DataSource dataSource, int i, final String... strArr) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onOriginalTransferred: " + i);
            TBLExoPlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7684a.lambda$onOriginalTransferred$1(strArr);
                }
            });
        }

        @Override // com.oplus.tblplayer.upstream.RedirectTransferListener
        public void onRedirectTransferred(DataSource dataSource, int i, String... strArr) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onRedirectTransferred: " + i);
            final ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            arrayList.add(Boolean.valueOf(i == 1));
            TBLExoPlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7683a.lambda$onRedirectTransferred$0(arrayList);
                }
            });
        }

        @Override // com.oplus.tblplayer.upstream.RedirectTransferListener
        public void onRedirecting(DataSource dataSource, int i, final String... strArr) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onRedirecting: " + i);
            TBLExoPlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7680a.lambda$onRedirecting$2(strArr);
                }
            });
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
        public void onTransferEnd(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onTransferEnd: ");
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
        public void onTransferInitializing(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onTransferInitializing: ");
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
        public void onTransferStart(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
            LogUtil.d(TBLExoPlayer.this.TAG, "onTransferStart: ");
        }

        @Override // com.oplus.tblplayer.upstream.RedirectTransferListener
        public void onTransferState(DataSource dataSource, boolean z) {
            this.transferEnded.set(z);
            maybePostReport();
        }

        public synchronized void setReport(Report report) {
            this.report = report;
        }
    }

    public TBLExoPlayer(Context context) {
        this(context, PlayerConfiguration.DEFAULT);
    }

    public static /* synthetic */ int access$2804(TBLExoPlayer tBLExoPlayer) {
        int i = tBLExoPlayer.loopingTransition + 1;
        tBLExoPlayer.loopingTransition = i;
        return i;
    }

    private void configPlayerWithStreamingMode() {
        verifyApplicationThread("configPlayerWithStreamingMode");
        if (this.mInternalPlayer != null) {
            if (this.mLoadControl != null) {
                this.mLoadControl.setLoadConfig(new LoadConfig.Builder().setBufferDurationsMs(50000, 50000, 0, 0).build());
                this.mInternalPlayer.createMessage(this.mLoadControl).setType(10002).setPayload(Boolean.TRUE).send();
            }
            Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers");
            if (rendererArr != null) {
                for (Renderer renderer : rendererArr) {
                    this.mInternalPlayer.createMessage(renderer).setType(10002).setPayload(Boolean.TRUE).send();
                }
            }
        }
    }

    @Nullable
    private Renderer getRendererByIndex(int i) {
        Renderer[] rendererArr;
        if (!isPlayable()) {
            return null;
        }
        LogUtil.d(this.TAG, "get renderer by index " + i + " renderer count " + this.mInternalPlayer.getRendererCount());
        if (i < 0 || i >= this.mInternalPlayer.getRendererCount() || (rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers")) == null) {
            return null;
        }
        LogUtil.d(this.TAG, "will return renderer for index " + i);
        return rendererArr[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInternalPlayerStateChanged(boolean z, int i) {
        int i2;
        int i3;
        LogUtil.d(this.TAG, "handleInternalPlayerStateChanged: ExoPlayer playWhenReady = " + z + ", playbackState = " + LogUtil.getExoPlayerStateString(i));
        if (isPlayable()) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i == 4 && (i3 = this.mCurrentState) != 0 && (i3 & 128) == 0) {
                        if (z) {
                            this.mInternalPlayer.setPlayWhenReady(false);
                        }
                        maybeUpdatePlaybackState(128);
                        this.isGetReportAtActiveMode = false;
                        maybeAnalyticsMonitorReport();
                        notifyOnCompletion();
                        return;
                    }
                    return;
                }
                this.hasRetryPlayback = false;
                int i4 = this.mCurrentState;
                if ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO) == 0) {
                    return;
                }
                if (z) {
                    maybeUpdatePlaybackState(16);
                    return;
                } else if ((i4 & 16) == 0) {
                    return;
                } else {
                    i2 = 32;
                }
            } else {
                if (this.hasRetryPlayback) {
                    LogUtil.w(this.TAG, "Retrying playback with ignore idle state for error.");
                    return;
                }
                if (z) {
                    this.mInternalPlayer.setPlayWhenReady(false);
                }
                int i5 = this.mCurrentState;
                if (i5 == 0 || (i5 & 322) != 0) {
                    return;
                } else {
                    i2 = 64;
                }
            }
            maybeUpdatePlaybackState(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExoPlayerMediaItemsChanged(Timeline timeline) {
        if (timeline == null) {
            return false;
        }
        if (this.exoPlayerPlaylist.size() != timeline.getWindowCount()) {
            return true;
        }
        Timeline.Window window = new Timeline.Window();
        int windowCount = timeline.getWindowCount();
        for (int i = 0; i < windowCount; i++) {
            timeline.getWindow(i, window);
            if (!ObjectsCompat.equals(this.exoPlayerPlaylist.get(i), window.mediaItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeedNotifyPlaybackResult() {
        return (this.isGetReportAtActiveMode || this.hasNotifyPlaybackResult) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeAnalyticsMonitorReport() {
        AnalyticsMonitor analyticsMonitor;
        TrafficStatisticMonitor trafficStatisticMonitor;
        Report reportCopyWithBytesTransferred;
        if (this.mInternalPlayer != null && (analyticsMonitor = this.mMonitor) != null && analyticsMonitor.checkSessionStateValid()) {
            this.mMonitor.updateCurrentEventInfo(this.mCurrentState, this.mInternalPlayer.getCurrentPosition(), this.mInternalPlayer.getTotalBufferedDuration());
            Report reportEndSession = this.mMonitor.endSession(this.playerConfiguration.activeReportModeEnabled, this.isGetReportAtActiveMode);
            if (reportEndSession != null && (trafficStatisticMonitor = this.trafficMonitor) != null) {
                if (this.playerConfiguration.activeReportModeEnabled) {
                    trafficStatisticMonitor.setReport((Report) AssertUtil.checkNotNull(reportEndSession.copyWithBytesTransferred(trafficStatisticMonitor.getBytesTransferred())));
                    if (this.trafficMonitor.isTransferEnded() && isNeedNotifyPlaybackResult()) {
                        this.hasNotifyPlaybackResult = true;
                        reportCopyWithBytesTransferred = reportEndSession.copyWithBytesTransferred(this.trafficMonitor.getBytesTransferred());
                        notifyOnPlaybackResult(reportCopyWithBytesTransferred);
                    }
                } else if (trafficStatisticMonitor.isTransferEnded()) {
                    reportCopyWithBytesTransferred = reportEndSession.copyWithBytesTransferred(this.trafficMonitor.getBytesTransferred());
                    notifyOnPlaybackResult(reportCopyWithBytesTransferred);
                } else {
                    this.trafficMonitor.setReport((Report) AssertUtil.checkNotNull(reportEndSession));
                }
            }
        }
        maybeAnalyticsSDKMonitor();
    }

    private synchronized void maybeAnalyticsSDKMonitor() {
        SDKAnalyticsMonitorManager sDKAnalyticsMonitorManager;
        NormalReport normalReportEndMonitor;
        if (this.mInternalPlayer != null && (sDKAnalyticsMonitorManager = this.mSDKAnalyticsMonitorManager) != null && sDKAnalyticsMonitorManager.isValidState() && (normalReportEndMonitor = this.mSDKAnalyticsMonitorManager.endMonitor()) != null) {
            DcsUploader.report(this.mAppContext, normalReportEndMonitor);
        }
    }

    private synchronized void maybeCloseFileDescriptor() {
        MediaUrl.FileDescriptorProperties fileDescriptorProperties;
        MediaUrl mediaUrl = this.mediaUrl;
        if (mediaUrl != null && mediaUrl.isFileDescriptor() && (fileDescriptorProperties = this.mediaUrl.playbackProperties.fdProperties) != null) {
            try {
                fileDescriptorProperties.pfd.close();
            } catch (IOException e) {
                LogUtil.e(this.TAG, "Close copied file descriptor failed: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeEnableSlowMotion(boolean z) {
        if (!z || !isPlayable()) {
            if (this.mSlowMotion != null) {
                LogUtil.d(this.TAG, "SlowMotion stop.");
                this.mSlowMotion.stop();
                this.mSlowMotion = null;
                return;
            }
            return;
        }
        MediaUrl mediaUrl = this.mediaUrl;
        if (mediaUrl == null || !CommonUtil.isSlowMotionHsr(mediaUrl.getOverrideExtension())) {
            return;
        }
        if (this.mInternalPlayer.getVideoFormat() != null) {
            this.mSlowMotion = SlowMotionManager.create(this.mAppContext, this, this.mediaUrl.getOverrideExtension(), SlowMotionManager.INVALID_FPS, 30, this.mInternalPlayer.getDuration());
        }
        if (this.mSlowMotion != null) {
            setTrackRendererDisable(1, true);
            LogUtil.d(this.TAG, "SlowMotion start.");
            this.mSlowMotion.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeNotifyBufferedUpdate(int i) {
        if (isPlayable()) {
            if (this.loadingState != i) {
                this.loadingState = i;
            }
            Timeline currentTimeline = this.mInternalPlayer.getCurrentTimeline();
            if (currentTimeline != null && !currentTimeline.isEmpty()) {
                int bufferedPercentage = this.loadingState == 2 ? 100 : this.mInternalPlayer.getBufferedPercentage();
                if (this.mInternalPlayer.getDuration() == -9223372036854775807L) {
                    LogUtil.d(this.TAG, "notifyOnBufferedUpdate: duration unset, buffered position is " + this.mInternalPlayer.getBufferedPosition());
                } else if (this.lastBufferedPercent != bufferedPercentage) {
                    LogUtil.d(this.TAG, "notifyOnBufferedUpdate: percent = " + bufferedPercentage);
                    this.lastBufferedPercent = bufferedPercentage;
                }
                notifyOnBufferedUpdate(bufferedPercentage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyBuffingInfo(boolean z, int i) {
        LogUtil.d(this.TAG, "maybeNotifyBuffingInfo: playWhenReady is " + z + ",playbackState " + LogUtil.getExoPlayerStateString(i));
        if (isPlayable()) {
            if (!this.isBuffering) {
                if (i == 2) {
                    this.isBuffering = true;
                    notifyOnInfo(701, Integer.valueOf(this.mInternalPlayer.getBufferedPercentage()));
                    return;
                }
                return;
            }
            if (i == 3 || i == 4) {
                this.isBuffering = false;
                notifyOnInfo(702, Integer.valueOf(this.mInternalPlayer.getBufferedPercentage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyHdrInfo(Format format) {
        ColorInfo colorInfo;
        if (!((this.mCurrentState & 28) != 0) || format == null || (colorInfo = format.colorInfo) == null) {
            return;
        }
        int i = colorInfo.colorTransfer;
        if (i == 6 || i == 7) {
            LogUtil.d(this.TAG, "maybeNotifyHdrInfo: " + format.colorInfo);
            notifyOnInfo(20001, Integer.valueOf(format.colorInfo.colorTransfer));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyStreamingNormalReport(StreamingStuckResult streamingStuckResult) {
        notifyOnInfo(IMediaPlayer.MEDIA_INFO_STREAMING_NORMAL_REPORT, streamingStuckResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyStreamingStuck(StreamingStuckResult streamingStuckResult) {
        notifyOnInfo(20011, streamingStuckResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyVideoHighSpecInfo() {
        int i;
        LogUtil.d(this.TAG, "Notify videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", framerate: " + this.videoFramerate + ", bitrate: " + this.videoBitrate);
        int i2 = this.videoHeight;
        boolean z = i2 > 0 && (i = this.videoWidth) > 0 && i2 * i > 2088960;
        float f = this.videoFramerate;
        boolean z2 = f > 59.0f && f < 481.0f;
        boolean z3 = this.videoBitrate > 24000000;
        if (z || z2 || z3) {
            notifyOnInfo(20010, Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Float.valueOf(this.videoFramerate), Integer.valueOf(this.videoBitrate));
        }
    }

    private synchronized void maybeResetErrorRenderers() {
        List<FallbackRenderer> list = this.fallbackRenderers;
        if (list != null && !list.isEmpty()) {
            Iterator<FallbackRenderer> it = this.fallbackRenderers.iterator();
            while (it.hasNext()) {
                it.next().setFallbackRenderer(false);
            }
            LogUtil.d(this.TAG, "Reset all fallback renderer");
            this.fallbackRenderers.clear();
        }
        List<RollupRenderer> list2 = this.rollupRenderers;
        if (list2 != null && !list2.isEmpty()) {
            Iterator<RollupRenderer> it2 = this.rollupRenderers.iterator();
            while (it2.hasNext()) {
                it2.next().setRollupRenderer(false);
            }
            LogUtil.d(this.TAG, "Reset all rollup renderer");
            this.rollupRenderers.clear();
        }
    }

    private synchronized void maybeResetMediaInfo(boolean z) {
        if (this.mediaUrl != null) {
            this.isBuffering = false;
            this.hasRetryPlayback = false;
            this.pendingStart = false;
            this.pendingSeek = false;
            this.loadingState = 0;
            this.lastBufferedPercent = 0;
            this.loopingTransition = 0;
            this.renderedFirstFrame = false;
            this.isSoftwareDecoder = false;
            this.isVideoFormatExceededSpec = false;
        }
        if (z) {
            maybeCloseFileDescriptor();
            this.mediaUrl = null;
            this.videoWidth = -1;
            this.videoHeight = -1;
            this.videoFramerate = -1.0f;
            this.videoBitrate = -1;
            maybeResetErrorRenderers();
            this.exoPlayerPlaylist.clear();
            this.mediaUrlList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeResumeForLiveWindow(boolean z) {
        if (!z) {
            if (isPlayable() && this.mInternalPlayer.isCurrentWindowLive()) {
                this.mInternalPlayer.seekToDefaultPosition();
            }
        }
    }

    private boolean maybeRetryForBehindLiveWindow(@NonNull ExoPlaybackException exoPlaybackException) {
        if (!isPlayable() || exoPlaybackException.type != 0) {
            return false;
        }
        for (Throwable sourceException = exoPlaybackException.getSourceException(); sourceException != null; sourceException = sourceException.getCause()) {
            if (sourceException instanceof BehindLiveWindowException) {
                this.mInternalPlayer.seekToDefaultPosition();
                this.mInternalPlayer.prepare();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryForPlaybackError(@NonNull ExoPlaybackException exoPlaybackException) {
        String str;
        String str2;
        this.isRetryPlayback = true;
        LogUtil.d(this.TAG, "onPlayerError: error type is " + LogUtil.getErrorTypeString(exoPlaybackException) + ", isRetryPlayback " + this.isRetryPlayback + ", error renderer index is " + exoPlaybackException.rendererIndex + " " + exoPlaybackException.getMessage());
        if (maybeRetryWithBackupSource(exoPlaybackException)) {
            str = this.TAG;
            str2 = "onPlayerError: will retry player with backup source.";
        } else {
            if (!maybeRetryForBehindLiveWindow(exoPlaybackException)) {
                if (!maybeRetryWithoutErrorRenderer(exoPlaybackException)) {
                    return false;
                }
                LogUtil.w(this.TAG, "onPlayerError: will retry player with disable error renderer.");
                Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers");
                if (rendererArr != null) {
                    for (Renderer renderer : rendererArr) {
                        this.mInternalPlayer.createMessage(renderer).setType(10006).setPayload(Boolean.FALSE).send();
                    }
                }
                return true;
            }
            str = this.TAG;
            str2 = "onPlayerError: will retry player for BehindLiveWindow exception.";
        }
        LogUtil.w(str, str2);
        return true;
    }

    private boolean maybeRetryWithBackupSource(@NonNull ExoPlaybackException exoPlaybackException) {
        MediaUrl mediaUrl;
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        sb.append(isPlayable() ? " is playable now " : "");
        sb.append(exoPlaybackException.type == 0 ? " error type is source" : "");
        sb.append(this.mediaUrl != null ? " media url is not null " : "");
        MediaUrl mediaUrl2 = this.mediaUrl;
        if (mediaUrl2 != null && mediaUrl2.hasNextBackupSource()) {
            str2 = " has next backup source ";
        }
        sb.append(str2);
        LogUtil.d(str, sb.toString());
        if (!isPlayable() || exoPlaybackException.type != 0 || (mediaUrl = this.mediaUrl) == null || !mediaUrl.hasNextBackupSource()) {
            return false;
        }
        MediaUrl.PlaybackProperties playbackPropertiesNextBackupSource = this.mediaUrl.nextBackupSource();
        MediaUrl mediaUrlBuild = new MediaUrl.Builder(playbackPropertiesNextBackupSource.uri, playbackPropertiesNextBackupSource.headers).build();
        LogUtil.d(this.TAG, "Maybe retry backup source with : " + playbackPropertiesNextBackupSource);
        DataSource.Factory factoryBuildDataSourceFactory = buildDataSourceFactory(mediaUrlBuild);
        PlayerConfiguration playerConfiguration = this.playerConfiguration;
        this.mInternalPlayer.prepare(TBLSourceManager.buildMediaSource(factoryBuildDataSourceFactory, mediaUrlBuild, playerConfiguration.extractorMode, playerConfiguration.exoTsExtractorTimestampSearchBytes), false, true);
        this.mInternalPlayer.enableStuckDetector(Globals.isSdkStuckEnabled());
        return true;
    }

    private boolean maybeRetryWithoutErrorRenderer(@NonNull ExoPlaybackException exoPlaybackException) {
        Renderer[] rendererArr;
        LogUtil.d(this.TAG, "isPlayable " + isPlayable());
        if (isPlayable()) {
            if (this.fallbackRenderers == null || this.rollupRenderers == null) {
                String str = this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(this.fallbackRenderers == null ? " fall back renderer is null " : "");
                sb.append(this.rollupRenderers == null ? "rollup renderer is null " : "");
                LogUtil.d(str, sb.toString());
            } else {
                if (this.playerConfiguration.rendererMode != 0) {
                    LogUtil.d(this.TAG, "rendererMode is not auto");
                    return false;
                }
                if (exoPlaybackException.getCause() instanceof TBLMediaCodecVideoRenderer.VideoOverSpecificationException) {
                    LogUtil.d(this.TAG, "video playback exceeds the specification");
                    return false;
                }
                int i = exoPlaybackException.rendererIndex;
                if (i < 0 && i >= this.mInternalPlayer.getRendererCount()) {
                    LogUtil.d(this.TAG, " renderer index is error");
                    return false;
                }
                if (exoPlaybackException.type == 1) {
                    Renderer rendererByIndex = getRendererByIndex(exoPlaybackException.rendererIndex);
                    String str2 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("renderer is ");
                    sb2.append(rendererByIndex == null ? com.igexin.push.core.b.m : rendererByIndex);
                    sb2.append(", error.rendererIndex ");
                    sb2.append(exoPlaybackException.rendererIndex);
                    sb2.append(", needFfmpegVideoDecoderWorkaround ");
                    sb2.append(this.mNeedFfmpegVideoDecoderWorkaround);
                    LogUtil.d(str2, sb2.toString());
                    boolean z = rendererByIndex instanceof FallbackRenderer;
                    if (z || ((rendererByIndex instanceof MediaCodecVideoRenderer) && this.mNeedFfmpegVideoDecoderWorkaround)) {
                        String str3 = this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(" renderer instanceof ");
                        sb3.append(z ? "FallbackRenderer" : "MediaCodecVideoRenderer");
                        LogUtil.d(str3, sb3.toString());
                        if ((rendererByIndex instanceof RollupRenderer) && ((RollupRenderer) rendererByIndex).isRollup()) {
                            LogUtil.w(this.TAG, "maybeRetryRenderer: already tried ffmpeg audio decoder, exit");
                            return false;
                        }
                        LogUtil.d(this.TAG, "Maybe retry soft renderer, unless is dolby video and need notify error.");
                        if (FormatUtil.isNeedNotifyErrorWithDolbyVideos(exoPlaybackException.rendererFormat)) {
                            LogUtil.w(this.TAG, "Playback dolby videos error with mediacodec,do not retry ffmpeg decoder");
                            return false;
                        }
                        LogUtil.w(this.TAG, "maybeRetryRenderer: will fallback renderer: " + rendererByIndex.getClass().getSimpleName(), exoPlaybackException.getCause());
                        FallbackRenderer fallbackRenderer = (FallbackRenderer) rendererByIndex;
                        fallbackRenderer.setFallbackRenderer(true);
                        this.fallbackRenderers.add(fallbackRenderer);
                    }
                    this.mInternalPlayer.retry();
                    return true;
                }
                if (exoPlaybackException.type == 1 && exoPlaybackException.toString().contains("FfmpegAudioDecoderException") && (rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers")) != null) {
                    for (Renderer renderer : rendererArr) {
                        if (renderer instanceof RollupRenderer) {
                            LogUtil.w(this.TAG, "maybeRetryRenderer: will rollup renderer: " + renderer.getClass().getSimpleName());
                            RollupRenderer rollupRenderer = (RollupRenderer) renderer;
                            rollupRenderer.setRollupRenderer(true);
                            this.rollupRenderers.add(rollupRenderer);
                            this.mInternalPlayer.retry();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int maybeUpdatePlaybackErrorInfo(@NonNull ExoPlaybackException exoPlaybackException) {
        int i;
        if (!AssertUtil.checkState((this.mInternalPlayer == null || this.mMonitor == null) ? false : true)) {
            return ErrorCode.REASON_OTHERS;
        }
        Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers");
        int exception = ErrorCodeProvider.parseException((exoPlaybackException.type != 1 || (i = exoPlaybackException.rendererIndex) < 0 || i >= this.mInternalPlayer.getRendererCount()) ? -1 : this.mInternalPlayer.getRendererType(exoPlaybackException.rendererIndex), exoPlaybackException);
        this.mMonitor.updatePlaybackErrorInfo(exception, rendererArr, exoPlaybackException);
        return exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeUpdatePlaybackState(int i) {
        if (this.mCurrentState != i) {
            LogUtil.i(this.TAG, "maybeUpdatePlaybackState: current state : " + LogUtil.getPlayerStateString(this.mCurrentState) + ", target state : " + LogUtil.getPlayerStateString(i));
            this.mCurrentState = i;
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD) != 0) {
                maybeEnableSlowMotion(false);
                maybeResetMediaInfo((i & 64) == 0);
            }
            notifyOnPlayerStateChanged(this.mCurrentState);
        }
    }

    private void requiredDynamicLoader() {
        if (Globals.getDynamicLibrariesPath() == null || !LibraryLoaderDynamic.getNativeLibrariesLoaded().isEmpty()) {
            return;
        }
        LibraryLoaderDynamic.loadSoDynamicFile(LibraryLoaderDynamic.findSoDir(Globals.getDynamicLibrariesPath(), "libffmpeg.so"));
        LibraryLoaderDynamic.loadSoDynamicFile(LibraryLoaderDynamic.findSoDir(Globals.getDynamicLibrariesPath(), "libffmpegJNI.so"));
        LibraryLoaderDynamic.loadSoDynamicFile(LibraryLoaderDynamic.findSoDir(Globals.getDynamicLibrariesPath(), "libPlatformJNI.so"));
    }

    private void sendRendererMessage(int i, int i2, @Nullable Object obj) {
        Renderer[] rendererArr;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers")) == null) {
            return;
        }
        for (Renderer renderer : rendererArr) {
            if (renderer.getTrackType() == i) {
                this.mInternalPlayer.createMessage(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackRendererDisable(int i, boolean z) {
        if (isPlayable()) {
            LogUtil.d(this.TAG, "setTrackRendererDisable: trackType " + LogUtil.getTrackTypeString(i) + ", disable " + z);
            for (int i2 = 0; i2 < this.mInternalPlayer.getRendererCount(); i2++) {
                if (this.mInternalPlayer.getRendererType(i2) == i) {
                    DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
                    defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setRendererDisabled(i2, z).build());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaylist(Timeline timeline) {
        if (timeline != null) {
            this.mediaUrlList.clear();
            this.exoPlayerPlaylist.clear();
            Timeline.Window window = new Timeline.Window();
            int windowCount = timeline.getWindowCount();
            for (int i = 0; i < windowCount; i++) {
                timeline.getWindow(i, window);
                MediaItem mediaItem = window.mediaItem;
                if (mediaItem.playbackProperties != null) {
                    this.exoPlayerPlaylist.add(mediaItem);
                    this.mediaUrlList.add(MediaUrl.fromUri((Uri) Util.castNonNull(mediaItem.playbackProperties.uri)));
                }
            }
            notifyOnInfo(20008, null);
        }
    }

    private void verifyApplicationThread(String str) {
        if (Globals.isEnableVerifyThread() && !Globals.shouldIgnoreVerifyThread(str) && this.mInternalPlayer != null && Looper.myLooper() != this.mInternalPlayer.getApplicationLooper()) {
            throw new IllegalStateException(WRONG_THREAD_ERROR_MESSAGE);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItem(int i, @NonNull MediaUrl mediaUrl) {
        MediaSource mediaSource;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource)) {
            return false;
        }
        MediaUrl mediaUrl2 = (MediaUrl) Assertions.checkNotNull(mediaUrl);
        ConcatenatingMediaSource concatenatingMediaSource = (ConcatenatingMediaSource) this.mediaSource;
        int iConstrainValue = Util.constrainValue(i, 0, concatenatingMediaSource.getSize());
        DataSource.Factory factoryBuildDataSourceFactory = buildDataSourceFactory(mediaUrl2);
        PlayerConfiguration playerConfiguration = this.playerConfiguration;
        MediaSource mediaSourceBuildMediaSource = TBLSourceManager.buildMediaSource(factoryBuildDataSourceFactory, mediaUrl2, playerConfiguration.extractorMode, playerConfiguration.exoTsExtractorTimestampSearchBytes);
        LogUtil.d(this.TAG, "addPlaylistItem: index " + iConstrainValue + ", url " + mediaUrl2);
        concatenatingMediaSource.addMediaSource(iConstrainValue, mediaSourceBuildMediaSource);
        return true;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItems(@IntRange(from = 0) int i, @NonNull List<MediaUrl> list) {
        MediaSource mediaSource;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaUrl mediaUrl = (MediaUrl) Util.castNonNull(list.get(i2));
            DataSource.Factory factoryBuildDataSourceFactory = buildDataSourceFactory(mediaUrl);
            PlayerConfiguration playerConfiguration = this.playerConfiguration;
            arrayList.add(TBLSourceManager.buildMediaSource(factoryBuildDataSourceFactory, mediaUrl, playerConfiguration.extractorMode, playerConfiguration.exoTsExtractorTimestampSearchBytes));
        }
        ConcatenatingMediaSource concatenatingMediaSource = (ConcatenatingMediaSource) this.mediaSource;
        int iConstrainValue = Util.constrainValue(i, 0, concatenatingMediaSource.getSize());
        LogUtil.d(this.TAG, "addPlayListItems: index is" + iConstrainValue + "playlist is " + list);
        concatenatingMediaSource.addMediaSources(iConstrainValue, arrayList);
        return true;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean applyTrackSelection(int i, boolean z, ITrackInfo.SelectionOverride selectionOverride) throws IllegalStateException, IllegalArgumentException {
        AssertUtil.checkArgument(TrackInfoProvider.isValidTrackType(i));
        if (!AssertUtil.checkState(isPlayable())) {
            return false;
        }
        DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector == null ? null : defaultTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            LogUtil.w(this.TAG, "Mapped track info is null, do nothing.");
            return false;
        }
        int rendererIndexByType = TrackInfoProvider.getRendererIndexByType(i, currentMappedTrackInfo);
        if (rendererIndexByType == -1) {
            return false;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(rendererIndexByType);
        DefaultTrackSelector.ParametersBuilder parametersBuilderBuildUponParameters = this.mTrackSelector.buildUponParameters();
        parametersBuilderBuildUponParameters.setRendererDisabled(rendererIndexByType, z);
        if (selectionOverride != null) {
            parametersBuilderBuildUponParameters.setSelectionOverride(rendererIndexByType, trackGroups, TrackInfoProvider.toSelectorOverride(selectionOverride));
        } else {
            parametersBuilderBuildUponParameters.clearSelectionOverrides(rendererIndexByType);
        }
        this.mTrackSelector.setParameters(parametersBuilderBuildUponParameters);
        return true;
    }

    public void attachAnalyticsListener() {
        InnerAnalyticsListener innerAnalyticsListener = new InnerAnalyticsListener();
        this.mInnerListener = innerAnalyticsListener;
        this.mInternalPlayer.addAnalyticsListener(innerAnalyticsListener);
        this.mLoadControl.addEventListener(this.mEventHandler, this.mInnerListener);
    }

    public void attachAnalyticsMonitor() {
        AnalyticsMonitor analyticsMonitor = new AnalyticsMonitor(this.mInternalPlayer, this.mTrackSelector);
        this.mMonitor = analyticsMonitor;
        InnerAnalyticsListener innerAnalyticsListener = this.mInnerListener;
        if (innerAnalyticsListener != null) {
            innerAnalyticsListener.addListener(analyticsMonitor);
        } else {
            this.mInternalPlayer.addAnalyticsListener(analyticsMonitor);
        }
    }

    public void attachSDKMonitor() {
        SDKAnalyticsMonitorManager sDKAnalyticsMonitorManager = new SDKAnalyticsMonitorManager(this.mInternalPlayer, this.mAppContext);
        this.mSDKAnalyticsMonitorManager = sDKAnalyticsMonitorManager;
        if (sDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor() != null) {
            InnerAnalyticsListener innerAnalyticsListener = this.mInnerListener;
            if (innerAnalyticsListener != null) {
                innerAnalyticsListener.addListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            } else {
                this.mInternalPlayer.addAnalyticsListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            }
            TBLBandwidthMeter tBLBandwidthMeter = this.mBandwidthMeter;
            if (tBLBandwidthMeter != null) {
                tBLBandwidthMeter.addChildTransferListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            }
        }
        if (this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor() != null) {
            InnerAnalyticsListener innerAnalyticsListener2 = this.mInnerListener;
            if (innerAnalyticsListener2 != null) {
                innerAnalyticsListener2.addListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            } else {
                this.mInternalPlayer.addAnalyticsListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            }
            TBLBandwidthMeter tBLBandwidthMeter2 = this.mBandwidthMeter;
            if (tBLBandwidthMeter2 != null) {
                tBLBandwidthMeter2.addChildTransferListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            }
        }
    }

    public DataSource.Factory buildDataSourceFactory(@NonNull MediaUrl mediaUrl) {
        HttpDataSource.Factory factoryBuildHttpDataSourceFactory;
        MediaUrl.FileDescriptorProperties fileDescriptorProperties;
        if (mediaUrl.isFileDescriptor() && (fileDescriptorProperties = mediaUrl.playbackProperties.fdProperties) != null) {
            LogUtil.d(this.TAG, "build DataSourceFactory for file descriptor.");
            return FileDescriptorDataSource.getFactory(fileDescriptorProperties.pfd.getFileDescriptor(), fileDescriptorProperties.offset, fileDescriptorProperties.length);
        }
        String userAgent = ((MediaUrl) AssertUtil.checkNotNull(mediaUrl)).getUserAgent() != null ? mediaUrl.getUserAgent() : Globals.getUserAgent();
        if (Globals.isOkhttpEnable()) {
            LogUtil.d(this.TAG, "Build DataSourceFactory for Okhttp.");
            if (Globals.isPreferRedirectAddress()) {
                factoryBuildHttpDataSourceFactory = TBLSourceManager.buildTBLOkHttpDataSourceFactory(userAgent, Globals.getOkhttpCallFactory(), Globals.getOkhttpCacheControl(), this.trafficMonitor, true, Globals.isPreferSubrangeRequest(), (TBLSourceManager.shouldRequirePreCache(mediaUrl) && Globals.isPreCacheEnable()) ? Globals.getGlobalPreCache() : null);
            } else {
                factoryBuildHttpDataSourceFactory = TBLSourceManager.buildOkHttpDataSourceFactory(userAgent, Globals.getOkhttpCallFactory(), Globals.getOkhttpCacheControl(), this.trafficMonitor);
            }
        } else {
            LogUtil.d(this.TAG, "Build DataSourceFactory for Http.");
            factoryBuildHttpDataSourceFactory = TBLSourceManager.buildHttpDataSourceFactory(userAgent, this.trafficMonitor);
        }
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildHttpDataSourceFactory.setDefaultRequestProperties((Map) Util.castNonNull(mediaUrl.getHeaders()));
        }
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(this.mAppContext, factoryBuildHttpDataSourceFactory);
        MediaUrl.CipherConfiguration cipherConfiguration = mediaUrl.cipherConfiguration;
        if (cipherConfiguration != null) {
            LogUtil.d(this.TAG, "Build DataSourceFactory for AesCipher");
            return cipherConfiguration.transformation.equals(AES_CIPHER_DATA_SOURCE) ? new TBLAesCipherDataSourceFactory(new String(cipherConfiguration.encryptionKey), this.mAppContext, new DefaultBandwidthMeter(), new OkHttpDataSourceFactory(new OkHttpClient(), Util.getUserAgent(this.mAppContext, "aes cipher"))) : this.playerConfiguration.encryptDataSourceEnabled ? new TBLEncryptDataSourceFactory(mediaUrl.getUri(), cipherConfiguration.transformation, cipherConfiguration.encryptionKey, cipherConfiguration.encryptionIv) : new TBLAes128DataSource.Factory(defaultDataSourceFactory, cipherConfiguration.encryptionKey, cipherConfiguration.encryptionIv);
        }
        if (TBLSourceManager.shouldRequirePreCache(mediaUrl) && Globals.isPreCacheEnable() && !this.isRetryPlayback) {
            LogUtil.d(this.TAG, "Playback maybe require pre-cache.");
            return TBLSourceManager.buildCacheDataSourceFactory(defaultDataSourceFactory, Globals.getGlobalPreCache(), this.mInnerListener);
        }
        LogUtil.d(this.TAG, "Playback do not require pre-cache.");
        return defaultDataSourceFactory;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean clearPlaylist() {
        MediaSource mediaSource;
        LogUtil.d(this.TAG, "clearPlaylist");
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource)) {
            return false;
        }
        ((ConcatenatingMediaSource) mediaSource).clear();
        return true;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void clearVideoProcessingView(IVideoProcessingView iVideoProcessingView) {
        LogUtil.d(this.TAG, "clearVideoProcessingView: " + iVideoProcessingView);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (!AssertUtil.checkState((simpleExoPlayer == null || simpleExoPlayer.getVideoComponent() == null) ? false : true) || iVideoProcessingView == null) {
            return;
        }
        iVideoProcessingView.setVideoComponent(null);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurface() {
        verifyApplicationThread("clearVideoSurface");
        LogUtil.d(this.TAG, "clearVideoSurface");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.clearVideoSurface();
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread("clearVideoSurfaceView");
        LogUtil.d(this.TAG, "clearVideoSurfaceView");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(TextureView textureView) {
        verifyApplicationThread("clearVideoTextureView");
        LogUtil.d(this.TAG, "clearVideoTextureView");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.clearVideoTextureView(textureView);
        }
    }

    public SimpleExoPlayer createInternalPlayer() {
        this.mTrackSelector = new DefaultTrackSelector(this.mAppContext);
        Context context = this.mAppContext;
        PlayerConfiguration playerConfiguration = this.playerConfiguration;
        this.mRenderersFactory = new TBLRenderersFactory(context, playerConfiguration.rendererMode, playerConfiguration.oplusVPPFilterEnabled, playerConfiguration.videoEffectModeEnabled, playerConfiguration.videoSoftRenderMode);
        int maxBufferMs = 50000;
        int minBufferMs = this.playerConfiguration.lowMemoryModeEnabled ? 15000 : 50000;
        if (Globals.isCustomLoadControlConfigEnable()) {
            maxBufferMs = Globals.getMaxBufferMs();
            minBufferMs = Globals.getMinBufferMs();
            if (maxBufferMs < minBufferMs) {
                minBufferMs = maxBufferMs;
            }
            LogUtil.d(this.TAG, "Customized maxBufferMs " + maxBufferMs + ", minBufferMs " + minBufferMs);
        }
        PlayerConfiguration playerConfiguration2 = this.playerConfiguration;
        boolean z = false;
        int i = 500;
        int i2 = 5000;
        if (playerConfiguration2.loadBufferConfigEnable) {
            int i3 = playerConfiguration2.maxBufferMs;
            int i4 = playerConfiguration2.minBufferMs;
            if (i3 < i4 || i4 < playerConfiguration2.bufferForPlaybackMs || i4 < playerConfiguration2.bufferForPlaybackAfterRebufferMs) {
                LogUtil.e(this.TAG, "Unsupported Customized load config in playerConfiguration,use default");
            } else {
                i = playerConfiguration2.bufferForPlaybackMs;
                i2 = playerConfiguration2.bufferForPlaybackAfterRebufferMs;
                maxBufferMs = i3;
                minBufferMs = i4;
                z = true;
            }
            LogUtil.d(this.TAG, "Customized: maxBufferMs " + maxBufferMs + ",minBufferMs " + minBufferMs + ",reBufferMs " + i2 + ",startBufferMs " + i);
        }
        this.mLoadControl = new TBLLoadControl(new LoadConfig.Builder().setBufferDurationsMs(minBufferMs, maxBufferMs, i, i2).setPrioritizeTimeOverSizeThresholds(z).setTargetBufferBytes(this.playerConfiguration.lowMemoryModeEnabled ? LoadConfig.DEFAULT_LOW_MEMORY_TARGET_BUFFER_SIZE : -1).build());
        this.mBandwidthMeter = TBLBandwidthMeter.getSingletonInstance(this.mAppContext);
        return new SimpleExoPlayer.Builder(this.mAppContext, this.mRenderersFactory).setTrackSelector(this.mTrackSelector).setPriorityTaskManager(Globals.getPriorityTaskManager()).setLoadControl(this.mLoadControl).setBandwidthMeter(this.mBandwidthMeter).setHighPerformanceEnabled(this.playerConfiguration.highPerformanceEnabled).setDeviceVolumeControlEnabled(this.playerConfiguration.deviceVolumeControlEnabled).setDetachSurfaceTimeoutMs(this.playerConfiguration.detachSurfaceTimeOutMs).build();
    }

    public void detachAnalyticsMonitor() {
        AnalyticsMonitor analyticsMonitor = this.mMonitor;
        if (analyticsMonitor == null) {
            return;
        }
        InnerAnalyticsListener innerAnalyticsListener = this.mInnerListener;
        if (innerAnalyticsListener != null) {
            innerAnalyticsListener.removeListener(analyticsMonitor);
        } else {
            this.mInternalPlayer.removeAnalyticsListener(analyticsMonitor);
        }
    }

    public void detachSDKMonitor() {
        SDKAnalyticsMonitorManager sDKAnalyticsMonitorManager = this.mSDKAnalyticsMonitorManager;
        if (sDKAnalyticsMonitorManager == null) {
            return;
        }
        if (sDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor() != null) {
            InnerAnalyticsListener innerAnalyticsListener = this.mInnerListener;
            if (innerAnalyticsListener != null) {
                innerAnalyticsListener.removeListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            } else {
                this.mInternalPlayer.removeAnalyticsListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            }
            TBLBandwidthMeter tBLBandwidthMeter = this.mBandwidthMeter;
            if (tBLBandwidthMeter != null) {
                tBLBandwidthMeter.removeChildTransferListener(this.mSDKAnalyticsMonitorManager.getSDKStuckAnalyticsMonitor());
            }
        }
        if (this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor() != null) {
            InnerAnalyticsListener innerAnalyticsListener2 = this.mInnerListener;
            if (innerAnalyticsListener2 != null) {
                innerAnalyticsListener2.removeListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            } else {
                this.mInternalPlayer.removeAnalyticsListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            }
            TBLBandwidthMeter tBLBandwidthMeter2 = this.mBandwidthMeter;
            if (tBLBandwidthMeter2 != null) {
                tBLBandwidthMeter2.removeChildTransferListener(this.mSDKAnalyticsMonitorManager.getSDKNormalAnalyticsMonitor());
            }
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void disableVideoCodecWCG() {
        verifyApplicationThread("disableVideoCodecWCG");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            sendRendererMessage(2, 10008, Constants.DISABLE_VIDEO_CODEC_WCG);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableDropFramePolicy(boolean z) {
        enableDropFramePolicy(true, z ? 4 : 0);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableDynamicWallpaper(boolean z) {
        verifyApplicationThread("enableDynamicWallpaper");
        LogUtil.d(this.TAG, "enableDynamicWallpaper enable :" + z);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            if (this.mLoadControl != null) {
                this.mInternalPlayer.createMessage(this.mLoadControl).setType(10001).setPayload(new LoadConfig.Builder().setBufferDurationsMs(50000, 50000, 500, 5000).setBackBuffer(z ? 10000 : 0, false).build()).send();
            }
            this.mInternalPlayer.enableDynamicWallpaper(z);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableMiniView(boolean z) {
        enableMiniView(z, 4);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableVideoCodecUIFirst(boolean z) {
        Renderer[] rendererArr;
        verifyApplicationThread("enableVideoCodecUIFirst");
        LogUtil.d(this.TAG, "enableVideoCodecUIFirst: enable " + z);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || (rendererArr = (Renderer[]) ReflectUtil.getField(simpleExoPlayer, Renderer[].class, "renderers")) == null) {
            return;
        }
        for (Renderer renderer : rendererArr) {
            this.mInternalPlayer.createMessage(renderer).setType(10007).setPayload(Boolean.TRUE).send();
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long j, boolean z) throws IllegalStateException {
        verifyApplicationThread("fastSeekTo");
        LogUtil.d(this.TAG, "fastSeekTo: positionMs is " + j);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            SlowMotionManager slowMotionManager = this.mSlowMotion;
            if (slowMotionManager != null) {
                j = slowMotionManager.adaptPosition(j, true);
            }
            this.pendingSeek = (this.mCurrentState & 131) != 0;
            this.mInternalPlayer.fastSeekTo(j, z);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        verifyApplicationThread("getAudioSessionId");
        LogUtil.d(this.TAG, "getAudioSessionId ");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.getAudioSessionId();
        }
        return -1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        LogUtil.d(this.TAG, "getBufferForPlaybackMs");
        if (AssertUtil.checkState(this.mLoadControl != null)) {
            return C.usToMs(this.mLoadControl.getBufferForPlaybackUs());
        }
        return -1L;
    }

    public int getBufferedPercentage() {
        verifyApplicationThread("getBufferedPercentage");
        if (!AssertUtil.checkState(this.mInternalPlayer != null)) {
            return -1;
        }
        if (this.mSlowMotion == null) {
            return this.mInternalPlayer.getBufferedPercentage();
        }
        long contentBufferedPosition = getContentBufferedPosition();
        long duration = getDuration();
        if (contentBufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((contentBufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        verifyApplicationThread("getContentBufferedPosition");
        LogUtil.d(this.TAG, "getContentBufferedPosition ");
        if (!AssertUtil.checkState(this.mInternalPlayer != null)) {
            return -1L;
        }
        long contentBufferedPosition = this.mInternalPlayer.getContentBufferedPosition();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(contentBufferedPosition, false) : contentBufferedPosition;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public int getCurrentMediaItemIndex() {
        verifyApplicationThread("getCurrentMediaItemIndex");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.getCurrentWindowIndex();
        }
        return -1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        verifyApplicationThread("getCurrentPosition");
        if (!AssertUtil.checkState(this.mInternalPlayer != null)) {
            return -1L;
        }
        long currentPosition = this.mInternalPlayer.getCurrentPosition();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(currentPosition, false) : currentPosition;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public Report getCurrentReport() {
        verifyApplicationThread("getCurrentReport");
        LogUtil.d(this.TAG, "getCurrentReport ");
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || !this.playerConfiguration.activeReportModeEnabled || !((AnalyticsMonitor) AssertUtil.checkNotNull(this.mMonitor)).checkSessionStateValid()) {
            return null;
        }
        this.isGetReportAtActiveMode = true;
        maybeAnalyticsMonitorReport();
        return this.trafficMonitor.report;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public String getDataSource() {
        MediaUrl mediaUrl;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaUrl = this.mediaUrl) == null) {
            return null;
        }
        return mediaUrl.getUri().toString();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        verifyApplicationThread("getDuration");
        if (!AssertUtil.checkState(this.mInternalPlayer != null)) {
            return -1L;
        }
        long duration = this.mInternalPlayer.getDuration();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(duration, false) : duration;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public long getInternalPlaybackThreadId() {
        Object field;
        HandlerThread handlerThread;
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            try {
                Object field2 = ReflectUtil.getField(this.mInternalPlayer, Class.forName("com.oplus.tbl.exoplayer2.ExoPlayerImpl"), "player");
                if (field2 != null && (field = ReflectUtil.getField(field2, Class.forName("com.oplus.tbl.exoplayer2.ExoPlayerImplInternal"), "internalPlayer")) != null && (handlerThread = (HandlerThread) ReflectUtil.getField(field, HandlerThread.class, "internalPlaybackThread")) != null) {
                    int threadId = handlerThread.getThreadId();
                    LogUtil.d(this.TAG, "getInternalPlaybackThreadId: " + threadId);
                    return threadId;
                }
            } catch (ClassNotFoundException e) {
                LogUtil.e(this.TAG, "Get internal playback thread failed. " + e.getMessage());
            }
        }
        return -1L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (AssertUtil.checkState(this.mInternalPlayer != null) && ((AnalyticsMonitor) AssertUtil.checkNotNull(this.mMonitor)).checkSessionStateValid()) {
            return this.mMonitor.getMediaInfo();
        }
        return null;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        verifyApplicationThread("getNetSpeed");
        LogUtil.d(this.TAG, "getNetSpeed ");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return ((AnalyticsMonitor) AssertUtil.checkNotNull(this.mMonitor)).getNetSpeed(this.mAppContext.getApplicationInfo().uid);
        }
        return -1L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        LogUtil.d(this.TAG, " getPlaybackState " + this.mCurrentState);
        return this.mCurrentState;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    @Nullable
    public List<MediaUrl> getPlaylist() {
        MediaSource mediaSource;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource) || this.mediaUrlList.isEmpty()) {
            return null;
        }
        return new ArrayList(this.mediaUrlList);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public int getPlaylistSize() {
        verifyApplicationThread("getPlaylistSize");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.getMediaItemCount();
        }
        return -1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        verifyApplicationThread("getSpeed");
        LogUtil.d(this.TAG, "getSpeed ");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.getPlaybackParameters().speed;
        }
        return -1.0f;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public ITrackInfo[] getTrackInfo() throws IllegalStateException {
        if (!AssertUtil.checkState(isPlayable())) {
            return null;
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            LogUtil.w(this.TAG, "Mapped track info is null, do nothing.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        for (int i = 0; i < rendererCount; i++) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            DefaultTrackSelector.Parameters parameters = this.mTrackSelector.getParameters();
            TBLTrackInfo tBLTrackInfoCreateTrackInfo = TrackInfoProvider.createTrackInfo(i, parameters.getRendererDisabled(i), currentMappedTrackInfo, parameters.getSelectionOverride(i, trackGroups));
            if (tBLTrackInfoCreateTrackInfo != null) {
                arrayList.add(tBLTrackInfoCreateTrackInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (ITrackInfo[]) arrayList.toArray(new ITrackInfo[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        int i = this.mCurrentState;
        if (AssertUtil.checkState(this.mInternalPlayer != null && (i != 0 && (i & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL) == 0))) {
            return this.videoHeight;
        }
        return -1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        int i = this.mCurrentState;
        if (AssertUtil.checkState(this.mInternalPlayer != null && (i != 0 && (i & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL) == 0))) {
            return this.videoWidth;
        }
        return -1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getVolume() {
        verifyApplicationThread("getVolume");
        LogUtil.d(this.TAG, "getVolume ");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.getVolume();
        }
        return -1.0f;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        verifyApplicationThread("isLooping");
        LogUtil.d(this.TAG, "isLooping ");
        return AssertUtil.checkState(this.mInternalPlayer != null) && this.mInternalPlayer.getRepeatMode() != 0;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        verifyApplicationThread("isPause");
        if (!AssertUtil.checkState(this.mInternalPlayer != null)) {
            return false;
        }
        int playbackState = this.mInternalPlayer.getPlaybackState();
        return !this.mInternalPlayer.getPlayWhenReady() && (playbackState == 3 || playbackState == 2);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        int i;
        return (this.mInternalPlayer == null || (i = this.mCurrentState) == 0 || (i & 257) != 0) ? false : true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        verifyApplicationThread("isPlaying");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.mInternalPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean isSoftwareDecoder() {
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            return this.isSoftwareDecoder;
        }
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        verifyApplicationThread("isStop");
        return !AssertUtil.checkState(this.mInternalPlayer != null) || this.mInternalPlayer.getPlaybackState() == 1;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean movePlaylistItem(int i, int i2) {
        MediaSource mediaSource;
        ConcatenatingMediaSource concatenatingMediaSource;
        int size;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource) || i >= (size = (concatenatingMediaSource = (ConcatenatingMediaSource) mediaSource).getSize()) || i2 >= size) {
            return false;
        }
        if (i == i2) {
            return true;
        }
        LogUtil.d(this.TAG, "move play list item from index" + i + "to index" + i2);
        concatenatingMediaSource.moveMediaSource(i, i2);
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws IllegalStateException {
        verifyApplicationThread("pause");
        LogUtil.d(this.TAG, "pause");
        int i = this.mCurrentState;
        if ((i & 160) != 0) {
            return;
        }
        if (AssertUtil.checkState(this.mInternalPlayer != null && ((i & 16) != 0), "pause called in state %s", LogUtil.getPlayerStateString(i))) {
            this.mInternalPlayer.setPlayWhenReady(false);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        verifyApplicationThread("prepareAsync");
        int i = this.mCurrentState;
        if (AssertUtil.checkState(this.mInternalPlayer != null && ((i & 66) != 0 || i == 0), "prepareAsync called in state %s", LogUtil.getPlayerStateString(i))) {
            LogUtil.d(this.TAG, "prepareAsync: do prepare");
            boolean z = this.pendingSeek;
            maybeResetMediaInfo(false);
            maybeResetErrorRenderers();
            ((AnalyticsMonitor) AssertUtil.checkNotNull(this.mMonitor)).startSession(this.mediaUrl);
            ((SDKAnalyticsMonitorManager) AssertUtil.checkNotNull(this.mSDKAnalyticsMonitorManager)).startMonitor(this.mediaUrl);
            this.hasNotifyPlaybackResult = false;
            this.mInternalPlayer.setPlayWhenReady(false);
            TraceUtil.beginSection("TBLExoPlayer.prepareAsync");
            this.mInternalPlayer.prepare(this.mediaSource, !z, true);
            this.mInternalPlayer.enableStuckDetector(Globals.isSdkStuckEnabled());
            TraceUtil.endSection();
            maybeUpdatePlaybackState(4);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        verifyApplicationThread("release");
        LogUtil.d(this.TAG, "release");
        if (this.mInternalPlayer != null) {
            this.isGetReportAtActiveMode = false;
            maybeAnalyticsMonitorReport();
            this.mInternalPlayer.removeAnalyticsListener(this.mInnerListener);
            detachSDKMonitor();
            detachAnalyticsMonitor();
            maybeUpdatePlaybackState(256);
            this.mEventHandler.removeCallbacksAndMessages(null);
            this.mInternalPlayer.release();
            this.mInternalPlayer = null;
        }
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            slowMotionManager.stop();
            this.mSlowMotion = null;
        }
        if (this.mIsStreamingMode) {
            FrameTimeRecorder.getInstance().shutdown();
        }
        this.mNeedFfmpegVideoDecoderWorkaround = false;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean removePlaylistItem(@IntRange(from = 0) int i) {
        MediaSource mediaSource;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource)) {
            return false;
        }
        ConcatenatingMediaSource concatenatingMediaSource = (ConcatenatingMediaSource) mediaSource;
        if (concatenatingMediaSource.getSize() <= i) {
            return false;
        }
        LogUtil.d(this.TAG, "removePlaylistItem: index is " + i);
        concatenatingMediaSource.removeMediaSource(i);
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        verifyApplicationThread("reset");
        LogUtil.d(this.TAG, "reset");
        int i = this.mCurrentState;
        if ((i & 1) != 0) {
            return;
        }
        if (AssertUtil.checkState(this.mInternalPlayer != null, "reset called in state %s", LogUtil.getPlayerStateString(i))) {
            this.isGetReportAtActiveMode = false;
            maybeAnalyticsMonitorReport();
            maybeUpdatePlaybackState(1);
            if (this.mInternalPlayer.getPlaybackState() != 1) {
                this.mInternalPlayer.stop(true);
            }
        }
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            slowMotionManager.stop();
            this.mSlowMotion = null;
        }
        this.mNeedFfmpegVideoDecoderWorkaround = false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        verifyApplicationThread("seekTo");
        LogUtil.d(this.TAG, "seekTo: positionMs is " + j);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            SlowMotionManager slowMotionManager = this.mSlowMotion;
            if (slowMotionManager != null) {
                j = slowMotionManager.adaptPosition(j, true);
            }
            this.pendingSeek = (this.mCurrentState & 131) != 0;
            this.mInternalPlayer.seekTo(j);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int i) {
        verifyApplicationThread("setAudioStreamType");
        LogUtil.d(this.TAG, "setAudioStreamType: streamType " + LogUtil.getStreamTypeString(i));
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(Util.getAudioUsageForStreamType(i)).setContentType(Util.getAudioContentTypeForStreamType(i)).build(), false);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setBcapPostEnhance(boolean z) {
        verifyApplicationThread("setBcapPostEnhance");
        LogUtil.d(this.TAG, "setBcapPostEnhance: enable " + z);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            sendRendererMessage(1, 10005, Boolean.valueOf(z));
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri) {
        setMediaUrlInternal(this.playerConfiguration.retryWithHttpUrl ? new MediaUrl.Builder((Uri) Assertions.checkNotNull(uri)).addBackupSourceUrl(uri).build() : new MediaUrl.Builder((Uri) Assertions.checkNotNull(uri)).build());
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        verifyApplicationThread("setDisplay");
        LogUtil.d(this.TAG, "setDisplay: " + surfaceHolder);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setEndPosition(long j) {
        LogUtil.d(this.TAG, "setEndPosition " + j);
        verifyApplicationThread("setEndPosition");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setEndPositionUs(C.msToUs(j));
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setEndPositionUs(long j) {
        LogUtil.d(this.TAG, "setEndPositionUs " + j);
        verifyApplicationThread("setEndPositionUs");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setEndPositionUs(j);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setFfmpegVideoDecoder(boolean z) {
        verifyApplicationThread("setFfmpegVideoDecoder");
        LogUtil.d(this.TAG, "setFfmpegVideoDecoder " + z);
        this.mNeedFfmpegVideoDecoderWorkaround = z;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setForegroundMode(boolean z) {
        verifyApplicationThread("setForegroundMode");
        LogUtil.d(this.TAG, "setForegroundMode: " + z);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setForegroundMode(z);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z) {
        verifyApplicationThread("setLooping");
        LogUtil.d(this.TAG, "setLooping: looping is " + z);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            if (z) {
                this.mInternalPlayer.setRepeatMode(1);
            } else {
                this.mInternalPlayer.setRepeatMode(0);
            }
        }
    }

    public synchronized void setMediaUrlInternal(@NonNull MediaUrl mediaUrl) {
        int i = this.mCurrentState;
        if (AssertUtil.checkState((i & 1) != 0 || i == 0, "setDataSource called in state %s", LogUtil.getPlayerStateString(i))) {
            LogUtil.d(this.TAG, "setDataSource: uri is " + mediaUrl.getUri());
            this.mediaUrl = (MediaUrl) Assertions.checkNotNull(mediaUrl);
            this.trafficMonitor = new TrafficStatisticMonitor();
            DataSource.Factory factoryBuildDataSourceFactory = buildDataSourceFactory(mediaUrl);
            PlayerConfiguration playerConfiguration = this.playerConfiguration;
            this.mediaSource = TBLSourceManager.buildMediaSource(factoryBuildDataSourceFactory, mediaUrl, playerConfiguration.extractorMode, playerConfiguration.exoTsExtractorTimestampSearchBytes);
            maybeUpdatePlaybackState(2);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOplusVPPFilterMode(int i) {
        verifyApplicationThread("setOplusVPPFilterMode");
        LogUtil.d(this.TAG, "setOplusVPPFilterMode: " + LogUtil.getVPPFilterFlags(i));
        if (AssertUtil.checkState(this.mInternalPlayer != null) && this.playerConfiguration.oplusVPPFilterEnabled) {
            sendRendererMessage(2, 10003, Integer.valueOf(i));
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float f) {
        verifyApplicationThread("setPlaybackRate");
        LogUtil.d(this.TAG, "setPlaybackRate: speed " + f);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setPlaybackParameters(new PlaybackParameters(f));
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean setPlaylist(@NonNull List<MediaUrl> list) {
        int i = this.mCurrentState;
        if (!AssertUtil.checkState((i & 1) != 0 || i == 0, "setPlaylist called in state %s", LogUtil.getPlayerStateString(i)) || list.isEmpty()) {
            return false;
        }
        LogUtil.d(this.TAG, "setPlaylist: playlist is " + list);
        this.trafficMonitor = new TrafficStatisticMonitor();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaUrl mediaUrl = (MediaUrl) Util.castNonNull(list.get(i2));
            DataSource.Factory factoryBuildDataSourceFactory = buildDataSourceFactory(mediaUrl);
            PlayerConfiguration playerConfiguration = this.playerConfiguration;
            arrayList.add(TBLSourceManager.buildMediaSource(factoryBuildDataSourceFactory, mediaUrl, playerConfiguration.extractorMode, playerConfiguration.exoTsExtractorTimestampSearchBytes));
        }
        this.mediaUrl = (MediaUrl) Util.castNonNull(list.get(0));
        this.mediaSource = new ConcatenatingMediaSource((MediaSource[]) arrayList.toArray(new MediaSource[0]));
        maybeUpdatePlaybackState(2);
        return true;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setSeekMode(int i) {
        verifyApplicationThread("setSeekMode");
        LogUtil.d(this.TAG, "setSeekMode: " + LogUtil.getSeekModeString(i));
        AssertUtil.checkArgument(i >= 0 && i <= 3, "Illegal seek mode: " + i);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setSeekParameters(i != 0 ? i != 1 ? i != 2 ? SeekParameters.DEFAULT : SeekParameters.CLOSEST_SYNC : SeekParameters.NEXT_SYNC : SeekParameters.PREVIOUS_SYNC);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(Surface surface) {
        verifyApplicationThread("setSurface");
        LogUtil.d(this.TAG, "setSurface: surface is " + surface);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoEffects(int i) {
        String str;
        String str2;
        verifyApplicationThread("setVideoEffects");
        int i2 = this.mCurrentState;
        if (AssertUtil.checkState((i2 & 66) != 0 || i2 == 0, "setVideoEffects called in state %s", LogUtil.getPlayerStateString(i2)) && this.mInternalPlayer != null && this.playerConfiguration.videoEffectModeEnabled) {
            LogUtil.d(this.TAG, "setVideoEffects: do setVideoEffects mode " + i);
            if (i == 0) {
                this.mInternalPlayer.setVideoEffects(ImmutableList.of(FrameInterpolationEffect.createBlendFrameInterpolationEffect(1, 60.0f)));
                str = this.TAG;
                str2 = "VIDEO_EFFECTS_DEFAULT_FRAMEINTERPOLATION ";
            } else if (i == 1) {
                this.mInternalPlayer.setVideoEffects(ImmutableList.of(FrameInterpolationEffect.createBlendFrameInterpolationEffect(2, 60.0f)));
                str = this.TAG;
                str2 = "VIDEO_EFFECTS_OVERLAY_FRAMEINTERPOLATION ";
            } else if (i == 2) {
                this.mInternalPlayer.setVideoEffects(ImmutableList.of(FrameInterpolationEffect.createBlendFrameInterpolationEffect(3, 60.0f)));
                str = this.TAG;
                str2 = "VIDEO_EFFECTS_COMPOSITE_FRAMEINTERPOLATION ";
            } else {
                if (i != 3) {
                    return;
                }
                this.mInternalPlayer.setVideoEffects(ImmutableList.of(new GlEffect() { // from class: com.oplus.tblplayer.TBLExoPlayer.2
                    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
                    public /* synthetic */ boolean isNoOp(int i3, int i4) {
                        return yb2.a(this, i3, i4);
                    }

                    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
                    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
                        return new PassthroughShaderProgram();
                    }
                }));
                str = this.TAG;
                str2 = "VIDEO_EFFECTS_PASSTHROUGH ";
            }
            LogUtil.d(str, str2);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoOutputColorInfo(boolean z) {
        verifyApplicationThread("setVideoOutputColorInfo");
        if (AssertUtil.checkState(this.mInternalPlayer != null) && this.playerConfiguration.videoEffectModeEnabled && z) {
            LogUtil.d(this.TAG, "setVideoOutputColorInfo,new output ColorInfoMode");
            Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(Assertions.checkNotNull(this.mInternalPlayer), Renderer[].class, "renderers");
            if (rendererArr != null) {
                for (Renderer renderer : rendererArr) {
                    if (renderer instanceof MediaCodecVideoRenderer) {
                        this.mInternalPlayer.createMessage(renderer).setType(30000).setPayload(0).send();
                    }
                }
            }
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoOutputResolution(int i, int i2) {
        verifyApplicationThread("setVideoOutputResolution ");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            LogUtil.d(this.TAG, "setVideoOutputResolution: " + i + " * " + i2);
            if (i <= 0 || i2 <= 0) {
                return;
            }
            Size size = new Size(i, i2);
            Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(Assertions.checkNotNull(this.mInternalPlayer), Renderer[].class, "renderers");
            if (rendererArr != null) {
                for (Renderer renderer : rendererArr) {
                    if (renderer instanceof MediaCodecVideoRenderer) {
                        this.mInternalPlayer.createMessage(renderer).setType(15).setPayload(size).send();
                    }
                }
            }
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoProcessingView(IVideoProcessingView iVideoProcessingView) {
        LogUtil.d(this.TAG, "setVideoProcessingView: " + iVideoProcessingView);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (!AssertUtil.checkState((simpleExoPlayer == null || simpleExoPlayer.getVideoComponent() == null) ? false : true) || iVideoProcessingView == null) {
            return;
        }
        iVideoProcessingView.setVideoComponent(this.mInternalPlayer.getVideoComponent());
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int i) {
        verifyApplicationThread("setVideoScalingMode");
        LogUtil.d(this.TAG, "setVideoScalingMode: mode is " + LogUtil.getVideoScalingModeString(i));
        AssertUtil.checkArgument(i == 1 || i == 2, "Scaling mode " + i + " is not supported");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVideoScalingMode(i);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread("setVideoSurfaceView");
        LogUtil.d(this.TAG, "setVideoSurfaceView");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(TextureView textureView) {
        verifyApplicationThread("setVideoTextureView");
        LogUtil.d(this.TAG, "setVideoTextureView");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float f) {
        verifyApplicationThread("setVolume");
        LogUtil.d(this.TAG, "setVolume: " + f);
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            this.mInternalPlayer.setVolume(f);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void skipToPlaylistItem(int i) {
        verifyApplicationThread("skipToPlaylistItem");
        if (AssertUtil.checkState(this.mInternalPlayer != null)) {
            LogUtil.d(this.TAG, "skipToPlaylistItem: index is " + i + ", count is " + this.mInternalPlayer.getMediaItemCount());
            if (i < 0 || i >= this.mInternalPlayer.getMediaItemCount() || i == this.mInternalPlayer.getCurrentWindowIndex()) {
                return;
            }
            this.pendingSeek = (this.mCurrentState & 131) != 0;
            this.mInternalPlayer.seekTo(i, 0L);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws IllegalStateException {
        verifyApplicationThread("start");
        LogUtil.d(this.TAG, "start");
        int i = this.mCurrentState;
        if ((i & 16) != 0) {
            return;
        }
        if ((i & 4) != 0) {
            this.pendingStart = true;
            return;
        }
        if (AssertUtil.checkState(this.mInternalPlayer != null && ((i & 168) != 0), "start called in state %s", LogUtil.getPlayerStateString(i))) {
            if ((this.mCurrentState & 128) != 0) {
                if (this.pendingSeek) {
                    this.pendingSeek = false;
                } else {
                    LogUtil.d(this.TAG, "start called in completed state, will seek to 0.");
                    maybeResetMediaInfo(false);
                    this.mInternalPlayer.seekTo(0L);
                }
            }
            ((AnalyticsMonitor) AssertUtil.checkNotNull(this.mMonitor)).startSession(this.mediaUrl);
            ((SDKAnalyticsMonitorManager) AssertUtil.checkNotNull(this.mSDKAnalyticsMonitorManager)).startMonitor(this.mediaUrl);
            this.hasNotifyPlaybackResult = false;
            TraceUtil.beginSection("TBLExoPlayer.start");
            this.mInternalPlayer.setPlayWhenReady(true);
            TraceUtil.endSection();
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws IllegalStateException {
        verifyApplicationThread("stop");
        LogUtil.d(this.TAG, "stop");
        int i = this.mCurrentState;
        if ((i & 65) != 0) {
            return;
        }
        if (AssertUtil.checkState(this.mInternalPlayer != null && ((i & 188) != 0), "stop called in state %s", LogUtil.getPlayerStateString(i))) {
            this.isGetReportAtActiveMode = false;
            maybeAnalyticsMonitorReport();
            this.hasRetryPlayback = false;
            this.mInternalPlayer.stop();
        }
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            slowMotionManager.stop();
            this.mSlowMotion = null;
        }
    }

    public TBLExoPlayer(Context context, @NonNull PlayerConfiguration playerConfiguration) {
        this.TAG = "TBLExoPlayer_ins_" + Thread.currentThread().getId();
        this.mediaUrl = null;
        this.mediaSource = null;
        this.videoWidth = -1;
        this.videoHeight = -1;
        this.videoFramerate = -1.0f;
        this.videoBitrate = -1;
        this.isBuffering = false;
        this.loadingState = 0;
        this.pendingStart = false;
        this.renderedFirstFrame = false;
        this.pendingSeek = false;
        this.isRetryPlayback = false;
        this.hasRetryPlayback = false;
        this.isMiniViewEnabled = false;
        this.dropFramePolicy = 0;
        this.isSoftwareDecoder = false;
        this.mIsStreamingMode = false;
        this.isVideoFormatExceededSpec = false;
        this.hasNotifyPlaybackResult = false;
        this.isGetReportAtActiveMode = true;
        this.mNeedFfmpegVideoDecoderWorkaround = false;
        LogUtil.d(this.TAG, "TBLExoPlayer: create");
        this.mAppContext = context.getApplicationContext();
        this.mEventHandler = new Handler(Util.getCurrentOrMainLooper());
        this.playerConfiguration = (PlayerConfiguration) Assertions.checkNotNull(playerConfiguration);
        TraceUtil.beginSection("TBLExoPlayer.createPlayer");
        this.mInternalPlayer = createInternalPlayer();
        TraceUtil.endSection();
        AssertUtil.checkState(this.mInternalPlayer != null, "Create internal player failed.");
        this.mCurrentState = 1;
        attachAnalyticsListener();
        attachAnalyticsMonitor();
        attachSDKMonitor();
        this.fallbackRenderers = new ArrayList(2);
        this.rollupRenderers = new ArrayList(2);
        this.exoPlayerPlaylist = new ArrayList();
        this.mediaUrlList = new ArrayList();
        enableDropFramePolicy(true);
        requiredDynamicLoader();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItem(@NonNull MediaUrl mediaUrl) {
        return addPlaylistItem(Integer.MAX_VALUE, mediaUrl);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItems(@NonNull List<MediaUrl> list) {
        return addPlaylistItems(Integer.MAX_VALUE, list);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableDropFramePolicy(boolean z, int i) {
        verifyApplicationThread("enableDropFramePolicy");
        LogUtil.d(this.TAG, "enableDropFramePolicy: enable: " + z + ", policy: " + LogUtil.getVideoDropFramePolicyString(i));
        if (i == this.dropFramePolicy) {
            LogUtil.d(this.TAG, "set same drop frame policy, do nothing");
            return;
        }
        this.dropFramePolicy = i;
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            if (!z) {
                i = 0;
            }
            simpleExoPlayer.setDropFramePolicy(i);
        }
        if (z) {
            return;
        }
        this.dropFramePolicy = 0;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void enableMiniView(boolean z, int i) {
        verifyApplicationThread("enableMiniView");
        LogUtil.d(this.TAG, "enableMiniView: enable: " + z + ", policy:" + LogUtil.getVideoDropFramePolicyString(i));
        if (this.isMiniViewEnabled == z && i == this.dropFramePolicy) {
            LogUtil.d(this.TAG, "set same miniview status, do nothing");
            return;
        }
        this.isMiniViewEnabled = z;
        this.dropFramePolicy = i;
        if (this.mCurrentState != 4) {
            setTrackRendererDisable(1, z);
        }
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            TBLLoadControl tBLLoadControl = this.mLoadControl;
            if (tBLLoadControl != null) {
                simpleExoPlayer.createMessage(tBLLoadControl).setType(10004).setPayload(Boolean.valueOf(this.isMiniViewEnabled)).send();
            }
            this.mInternalPlayer.setDropFramePolicy(this.isMiniViewEnabled ? this.dropFramePolicy : 0);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean removePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        MediaSource mediaSource;
        ConcatenatingMediaSource concatenatingMediaSource;
        int size;
        if (!AssertUtil.checkState(this.mInternalPlayer != null) || (mediaSource = this.mediaSource) == null || !(mediaSource instanceof ConcatenatingMediaSource) || i >= (size = (concatenatingMediaSource = (ConcatenatingMediaSource) mediaSource).getSize()) || i2 > size) {
            return false;
        }
        if (i == i2) {
            return true;
        }
        LogUtil.d(this.TAG, "remove playlist item from index " + i + "to index" + i2);
        concatenatingMediaSource.removeMediaSourceRange(i, i2);
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri, Map<String, String> map) {
        setMediaUrlInternal((this.playerConfiguration.retryWithHttpUrl ? new MediaUrl.Builder((Uri) Assertions.checkNotNull(uri)).setHeaders(map).addBackupSourceUrl(uri) : new MediaUrl.Builder((Uri) Assertions.checkNotNull(uri)).setHeaders(map)).build());
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoEffects(List<Effect> list) {
        verifyApplicationThread("setVideoEffects");
        if (AssertUtil.checkState(this.mInternalPlayer != null) && this.playerConfiguration.videoEffectModeEnabled) {
            LogUtil.d(this.TAG, "setVideoEffects: videoEffects " + list.toString());
            this.mInternalPlayer.setVideoEffects(list);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(MediaUrl mediaUrl) {
        setMediaUrlInternal((MediaUrl) Assertions.checkNotNull(mediaUrl));
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(@NonNull final IDataChannel iDataChannel) {
        int i = this.mCurrentState;
        if (AssertUtil.checkState((i & 1) != 0 || i == 0, "setDataSource called in state %s", LogUtil.getPlayerStateString(i))) {
            LogUtil.d(this.TAG, "setDataSource with data channel: " + iDataChannel);
            this.mediaUrl = (MediaUrl) Assertions.checkNotNull(MediaUrl.fromUri(Uri.EMPTY));
            this.trafficMonitor = new TrafficStatisticMonitor();
            configPlayerWithStreamingMode();
            this.mIsStreamingMode = true;
            this.mediaSource = new ProgressiveMediaSource.Factory(new DataSource.Factory() { // from class: kr5
                @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
                public final DataSource createDataSource() {
                    return TBLExoPlayer.lambda$setDataSource$0(iDataChannel);
                }
            }, (ExtractorsFactory) Util.castNonNull((ExtractorsFactory) ReflectUtil.getConstField("com.oplus.tblplayer.streaming.FrameStreamingExtractor", ExtractorsFactory.class, "FACTORY"))).createMediaSource(MediaItem.fromUri(this.mediaUrl.getUri()).buildUpon().setTag(new DefaultStreamingSpeedControl()).build());
            maybeUpdatePlaybackState(2);
            FrameTimeRecorder.getInstance().setOnDetectedStuckListener(new FrameTimeRecorder.StuckDetectListener() { // from class: com.oplus.tblplayer.TBLExoPlayer.1
                @Override // com.oplus.tbl.exoplayer2.FrameTimeRecorder.StuckDetectListener
                public void detectedStuck(StreamingStuckResult streamingStuckResult) {
                    LogUtil.d(TBLExoPlayer.this.TAG, "DetectedStuck " + streamingStuckResult);
                    TBLExoPlayer.this.maybeNotifyStreamingStuck(streamingStuckResult);
                }

                @Override // com.oplus.tbl.exoplayer2.FrameTimeRecorder.StuckDetectListener
                public void normalReport(StreamingStuckResult streamingStuckResult) {
                    LogUtil.d(TBLExoPlayer.this.TAG, "normalReport " + streamingStuckResult);
                    TBLExoPlayer.this.maybeNotifyStreamingNormalReport(streamingStuckResult);
                }
            });
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        setDataSource(fileDescriptor, 0L, Long.MAX_VALUE);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        AssertUtil.checkNotNull(fileDescriptor);
        AssertUtil.checkArgumentNonnegative(j);
        AssertUtil.checkArgumentNonnegative(j2);
        setMediaUrlInternal(new MediaUrl.Builder(Uri.EMPTY).setFileDescriptor(ParcelFileDescriptor.dup(fileDescriptor), j, j2).build());
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(String str) {
        setDataSource(Uri.parse((String) Assertions.checkNotNull(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DataSource lambda$setDataSource$0(IDataChannel iDataChannel) {
        return iDataChannel;
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setAudioFFTSpeed(int i) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int i) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoOverSpecFlag(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int i) {
    }
}
