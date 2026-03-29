package com.oplus.tbl.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.oplus.tbl.exoplayer2.AudioBecomingNoisyManager;
import com.oplus.tbl.exoplayer2.AudioFocusManager;
import com.oplus.tbl.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.oplus.tbl.exoplayer2.Player;
import com.oplus.tbl.exoplayer2.PlayerMessage;
import com.oplus.tbl.exoplayer2.StreamVolumeManager;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsCollector;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.audio.AudioAttributes;
import com.oplus.tbl.exoplayer2.audio.AudioListener;
import com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener;
import com.oplus.tbl.exoplayer2.audio.AuxEffectInfo;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.device.DeviceInfo;
import com.oplus.tbl.exoplayer2.device.DeviceListener;
import com.oplus.tbl.exoplayer2.effect.PreviewingSingleInputVideoGraph;
import com.oplus.tbl.exoplayer2.extractor.DefaultExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.MetadataOutput;
import com.oplus.tbl.exoplayer2.source.DefaultMediaSourceFactory;
import com.oplus.tbl.exoplayer2.source.LoadEventInfo;
import com.oplus.tbl.exoplayer2.source.MediaLoadData;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.MediaSourceFactory;
import com.oplus.tbl.exoplayer2.source.ShuffleOrder;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.text.Cue;
import com.oplus.tbl.exoplayer2.text.TextOutput;
import com.oplus.tbl.exoplayer2.trackselection.DefaultTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectionArray;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelector;
import com.oplus.tbl.exoplayer2.upstream.BandwidthMeter;
import com.oplus.tbl.exoplayer2.upstream.DefaultBandwidthMeter;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.ConditionVariable;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.PriorityTaskManager;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.oplus.tbl.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.oplus.tbl.exoplayer2.video.VideoFrameMetadataListener;
import com.oplus.tbl.exoplayer2.video.VideoListener;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;
import com.oplus.tbl.exoplayer2.video.spherical.CameraMotionListener;
import defpackage.hd6;
import defpackage.mc;
import defpackage.mk;
import defpackage.vj4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, Player.AudioComponent, Player.DeviceComponent, Player.MetadataComponent, Player.TextComponent, Player.VideoComponent, AnalyticsListener {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player is accessed on the wrong thread. See Exoplayer's introduction to threads in Developers";
    private String TAG;
    private final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;

    @Nullable
    private DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;

    @Nullable
    private Format audioFormat;
    private final CopyOnWriteArraySet<AudioListener> audioListeners;
    private int audioSessionId;
    private float audioVolume;

    @Nullable
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    private final ConditionVariable constructorFinished;
    private int curSeekId;
    private List<Cue> currentCues;
    private final long detachSurfaceTimeoutMs;
    private DeviceInfo deviceInfo;
    private final CopyOnWriteArraySet<DeviceListener> deviceListeners;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isEnablePreview;
    private boolean isPriorityTaskManagerRegistered;
    private boolean isSeeking;

    @Nullable
    private AudioTrack keepSessionIdAudioTrack;
    private final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private boolean pendingPlayWhenReady;
    private final ExoPlayerImpl player;
    private boolean playerReleased;

    @Nullable
    private PriorityTaskManager priorityTaskManager;
    protected final Renderer[] renderers;
    private int seekToType;
    private long seekingTime;
    private boolean skipSilenceEnabled;

    @Nullable
    private final StreamVolumeManager streamVolumeManager;

    @Nullable
    private Surface surface;
    private int surfaceHeight;

    @Nullable
    private SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    private final CopyOnWriteArraySet<TextOutput> textOutputs;

    @Nullable
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;

    @Nullable
    private DecoderCounters videoDecoderCounters;

    @Nullable
    private Format videoFormat;

    @Nullable
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final CopyOnWriteArraySet<VideoListener> videoListeners;
    private int videoScalingMode;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private AudioAttributes audioAttributes;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private final Context context;
        private long detachSurfaceTimeoutMs;
        private boolean deviceVolumeControlEnabled;
        private boolean handleAudioBecomingNoisy;
        private boolean handleAudioFocus;
        private boolean highPerformanceEnabled;
        private LivePlaybackSpeedControl livePlaybackSpeedControl;
        private LoadControl loadControl;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private boolean pauseAtEndOfMediaItems;

        @Nullable
        private PriorityTaskManager priorityTaskManager;
        private long releaseTimeoutMs;
        private final RenderersFactory renderersFactory;
        private SeekParameters seekParameters;
        private boolean skipSilenceEnabled;
        private boolean throwsWhenUsingWrongThread;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;
        private int videoScalingMode;
        private int wakeMode;

        public Builder(Context context) {
            this(context, new DefaultRenderersFactory(context), new DefaultExtractorsFactory());
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = audioAttributes;
            this.handleAudioFocus = z;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter;
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j;
            return this;
        }

        public Builder setDeviceVolumeControlEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.deviceVolumeControlEnabled = z;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z;
            return this;
        }

        public Builder setHighPerformanceEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.highPerformanceEnabled = z;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = livePlaybackSpeedControl;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl;
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactory = mediaSourceFactory;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z;
            return this;
        }

        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = seekParameters;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z;
            return this;
        }

        public Builder setThrowsWhenUsingWrongThread(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.throwsWhenUsingWrongThread = z;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }

        public Builder setVideoScalingMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i;
            return this;
        }

        public Builder setWakeMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i;
            return this;
        }

        public Builder(Context context, RenderersFactory renderersFactory) {
            this(context, renderersFactory, new DefaultExtractorsFactory());
        }

        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this(context, renderersFactory, new DefaultTrackSelector(context), new DefaultMediaSourceFactory(context, extractorsFactory), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context), new AnalyticsCollector(Clock.DEFAULT));
        }

        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.context = context;
            this.renderersFactory = renderersFactory;
            this.trackSelector = trackSelector;
            this.mediaSourceFactory = mediaSourceFactory;
            this.loadControl = loadControl;
            this.bandwidthMeter = bandwidthMeter;
            this.analyticsCollector = analyticsCollector;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500L;
            this.detachSurfaceTimeoutMs = 2000L;
        }

        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this(context, new DefaultRenderersFactory(context), extractorsFactory);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioBecomingNoisyManager.EventListener, AudioFocusManager.PlayerControl, Player.EventListener, StreamVolumeManager.Listener, AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener {
        private ComponentListener() {
        }

        @Override // com.oplus.tbl.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(playWhenReady, i, SimpleExoPlayer.getPlayWhenReadyChangeReason(playWhenReady, i));
        }

        @Override // com.oplus.tbl.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.updatePlayWhenReady(false, -1, 3);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderInitialized(str, j, j2);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderReleased(str);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDisabled(decoderCounters);
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioInputFormatChanged(Format format) {
            mk.e(this, format);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioPositionAdvancing(long j) {
            SimpleExoPlayer.this.analyticsCollector.onAudioPositionAdvancing(j);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onAudioSinkError(exc);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioUnderrun(int i, long j, long j2) {
            SimpleExoPlayer.this.analyticsCollector.onAudioUnderrun(i, j, j2);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onBufferingStucked(BufferingStuckResult bufferingStuckResult) {
            vj4.a(this, bufferingStuckResult);
        }

        @Override // com.oplus.tbl.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            SimpleExoPlayer.this.currentCues = list;
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextOutput) it.next()).onCues(list);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            SimpleExoPlayer.this.analyticsCollector.onDroppedFrames(i, j);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            vj4.b(this, player, events);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            vj4.c(this, z);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public void onExperimentalSleepingForOffloadChanged(boolean z) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public void onIsLoadingChanged(boolean z) {
            SimpleExoPlayer simpleExoPlayer;
            if (SimpleExoPlayer.this.priorityTaskManager != null) {
                boolean z2 = false;
                if (z && !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                    SimpleExoPlayer.this.priorityTaskManager.add(0);
                    simpleExoPlayer = SimpleExoPlayer.this;
                    z2 = true;
                } else {
                    if (z || !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                        return;
                    }
                    SimpleExoPlayer.this.priorityTaskManager.remove(0);
                    simpleExoPlayer = SimpleExoPlayer.this;
                }
                simpleExoPlayer.isPriorityTaskManagerRegistered = z2;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            vj4.f(this, z);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            vj4.g(this, z);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            vj4.h(this, mediaItem, i);
        }

        @Override // com.oplus.tbl.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            SimpleExoPlayer.this.analyticsCollector.onMetadata(metadata);
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            vj4.j(this, playbackParameters);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            vj4.l(this, i);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            vj4.m(this, exoPlaybackException);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            vj4.n(this, z, i);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            vj4.o(this, i);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            SimpleExoPlayer.this.analyticsCollector.onRenderedFirstFrame(surface);
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            vj4.p(this, i);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekCompleted(SeekResult seekResult) {
            vj4.q(this, seekResult);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            vj4.r(this);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            vj4.s(this, z);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(boolean z) {
            if (SimpleExoPlayer.this.skipSilenceEnabled == z) {
                return;
            }
            SimpleExoPlayer.this.skipSilenceEnabled = z;
            SimpleExoPlayer.this.notifySkipSilenceEnabledChanged();
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onStaticMetadataChanged(List list) {
            vj4.t(this, list);
        }

        @Override // com.oplus.tbl.exoplayer2.StreamVolumeManager.Listener
        public void onStreamTypeChanged(int i) {
            if (SimpleExoPlayer.this.streamVolumeManager == null) {
                Log.e(SimpleExoPlayer.this.TAG, "streamVolumeManager == null");
                return;
            }
            DeviceInfo deviceInfoCreateDeviceInfo = SimpleExoPlayer.createDeviceInfo(SimpleExoPlayer.this.streamVolumeManager);
            if (deviceInfoCreateDeviceInfo.equals(SimpleExoPlayer.this.deviceInfo)) {
                return;
            }
            SimpleExoPlayer.this.deviceInfo = deviceInfoCreateDeviceInfo;
            Iterator it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                ((DeviceListener) it.next()).onDeviceInfoChanged(deviceInfoCreateDeviceInfo);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(int i, boolean z) {
            Iterator it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                ((DeviceListener) it.next()).onDeviceVolumeChanged(i, z);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            vj4.u(this, timeline, i);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            vj4.w(this, trackGroupArray, trackSelectionArray);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoCodecError(Exception exc) {
            hd6.c(this, exc);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2, boolean z) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderInitialized(str, j, j2, z);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderReleased(str);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDisabled(decoderCounters);
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long j, int i) {
            SimpleExoPlayer.this.analyticsCollector.onVideoFrameProcessingOffset(j, i);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoInputFormatChanged(Format format) {
            hd6.i(this, format);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            SimpleExoPlayer.this.analyticsCollector.onVideoSizeChanged(i, i2, i3, f);
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                ((VideoListener) it.next()).onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoStucked(VideoStuckResult videoStuckResult) {
            SimpleExoPlayer.this.analyticsCollector.onVideoStucked(videoStuckResult);
        }

        @Override // com.oplus.tbl.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        @Override // com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            SimpleExoPlayer.this.audioFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        @Override // com.oplus.tbl.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            vj4.v(this, timeline, obj, i);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            SimpleExoPlayer.this.videoFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Deprecated
    public SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new Builder(context, renderersFactory).setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector).setUseLazyPreparation(z).setClock(clock).setLooper(looper));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager) {
        if (streamVolumeManager != null) {
            return new DeviceInfo(0, streamVolumeManager.getMinVolume(), streamVolumeManager.getMaxVolume());
        }
        Log.e("DeviceInfo", "streamVolumeManager == null");
        return null;
    }

    private void enableVideoRenderStuckDetector(boolean z) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR).setPayload(Boolean.valueOf(z)).send();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private int initializeKeepSessionIdAudioTrack(int i) {
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.keepSessionIdAudioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        if (this.keepSessionIdAudioTrack == null) {
            this.keepSessionIdAudioTrack = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @OptIn(markerClass = {UnstableApi.class})
    public void maybeNotifySurfaceSizeChanged(int i, int i2) {
        if (i == this.surfaceWidth && i2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        this.analyticsCollector.onSurfaceSizeChanged(i, i2);
        Iterator<VideoListener> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(i, i2);
        }
        if (i == -1 || i2 == -1) {
            return;
        }
        sendRendererMessage(2, 15, new Size(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySkipSilenceEnabledChanged() {
        this.analyticsCollector.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w(this.TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    private void resetVideoRenderStuckDetector() {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(11000).send();
            }
        }
    }

    private void seekToInternal(int i, long j, int i2) {
        this.isSeeking = true;
        this.seekToType = i2;
        this.seekingTime = j;
        int i3 = this.curSeekId + 1;
        this.curSeekId = i3;
        if (i3 > 10000) {
            this.curSeekId = 0;
        }
        Log.d(this.TAG, "SeekToInternal pos:" + j + ", curSeekId:" + this.curSeekId + ", seekType:" + i2);
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i, j, this.curSeekId, i2);
    }

    private void sendRendererMessage(int i, int i2, @Nullable Object obj) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i) {
                this.player.createMessage(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        sendRendererMessage(1, 2, Float.valueOf(this.audioVolume * this.audioFocusManager.getVolumeMultiplier()));
    }

    private void setVideoDecoderOutputBufferRenderer(@Nullable VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        sendRendererMessage(2, 8, videoDecoderOutputBufferRenderer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(@Nullable Surface surface, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        Surface surface2 = this.surface;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered(this.detachSurfaceTimeoutMs);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.player.stop(false, ExoPlaybackException.createForRenderer(new ExoTimeoutException(3)));
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface;
        this.ownsSurface = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        this.player.setPlayWhenReady(z2, i3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.wakeLockManager.setStayAwake(getPlayWhenReady() && !experimentalIsSleepingForOffload());
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        this.constructorFinished.blockUninterruptible();
        if (Looper.myLooper() != getApplicationLooper()) {
            if (this.throwsWhenUsingWrongThread) {
                throw new IllegalStateException(WRONG_THREAD_ERROR_MESSAGE);
            }
            if (this.hasNotifiedFullWrongThreadWarning) {
                return;
            }
            Log.w(this.TAG, WRONG_THREAD_ERROR_MESSAGE);
            this.hasNotifiedFullWrongThreadWarning = true;
        }
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.analyticsCollector.addListener(analyticsListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void addAudioListener(AudioListener audioListener) {
        Assertions.checkNotNull(audioListener);
        this.audioListeners.add(audioListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void addDeviceListener(DeviceListener deviceListener) {
        Assertions.checkNotNull(deviceListener);
        this.deviceListeners.add(deviceListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.player.addListener(eventListener);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void addMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        this.player.addMediaItem(i, mediaItem);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(i, list);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void addMediaSource(int i, MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(i, mediaSource);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void addMediaSources(int i, List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(i, list);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.MetadataComponent
    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Assertions.checkNotNull(metadataOutput);
        this.metadataOutputs.add(metadataOutput);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.TextComponent
    public void addTextOutput(TextOutput textOutput) {
        Assertions.checkNotNull(textOutput);
        this.textOutputs.add(textOutput);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void addVideoListener(VideoListener videoListener) {
        Assertions.checkNotNull(videoListener);
        this.videoListeners.add(videoListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        if (this.cameraMotionListener != cameraMotionListener) {
            return;
        }
        sendRendererMessage(6, 7, null);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void clearMediaItems() {
        verifyApplicationThread();
        this.player.clearMediaItems();
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener != videoFrameMetadataListener) {
            return;
        }
        sendRendererMessage(2, 6, null);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(null, false);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null || surfaceHolder != this.surfaceHolder) {
            return;
        }
        setVideoSurfaceHolder(null);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (!(surfaceView instanceof VideoDecoderGLSurfaceView)) {
            clearVideoSurfaceHolder(surfaceView != null ? surfaceView.getHolder() : null);
        } else if (surfaceView.getHolder() == this.surfaceHolder) {
            setVideoDecoderOutputBufferRenderer(null);
            this.surfaceHolder = null;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        if (textureView == null || textureView != this.textureView) {
            return;
        }
        setVideoTextureView(null);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return this.player.createMessage(target);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            streamVolumeManager.decreaseVolume();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void enableDynamicWallpaper(boolean z) {
        verifyApplicationThread();
        this.player.enableDynamicWallpaper(z);
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(20000).setPayload(Boolean.valueOf(z)).send();
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void enableStuckDetector(boolean z) {
        verifyApplicationThread();
        enableVideoRenderStuckDetector(z);
        this.player.enableBufferingStuckDetector(z);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public boolean experimentalIsSleepingForOffload() {
        verifyApplicationThread();
        return this.player.experimentalIsSleepingForOffload();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        verifyApplicationThread();
        this.player.experimentalSetOffloadSchedulingEnabled(z);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void fastSeekTo(int i, long j, boolean z) {
        if (j < 0) {
            Log.e(this.TAG, "fastSeekTo with invalid positionMs:" + j);
            return;
        }
        Log.d(this.TAG, "fastSeekTo:" + j + ", enablePreview:" + z + ",isEnablePreview:" + this.isEnablePreview);
        boolean z2 = this.isEnablePreview;
        if (z) {
            if (!z2) {
                this.pendingPlayWhenReady = getPlayWhenReady();
                setPlayWhenReady(false);
                this.isEnablePreview = true;
                this.seekingTime = j;
            }
        } else if (z2) {
            this.isEnablePreview = false;
            setPlayWhenReady(this.pendingPlayWhenReady);
        }
        seekToInternal(i, j, z ? 1 : 2);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    @Nullable
    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    @Nullable
    public Format getAudioFormat() {
        return this.audioFormat;
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public Clock getClock() {
        return this.player.getClock();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // com.oplus.tbl.exoplayer2.Player.TextComponent
    public List<Cue> getCurrentCues() {
        verifyApplicationThread();
        return this.currentCues;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getCurrentPosition() {
        int i;
        verifyApplicationThread();
        return (this.isSeeking && ((i = this.seekToType) == 1 || i == 2)) ? this.seekingTime : this.player.getCurrentPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public List<Metadata> getCurrentStaticMetadata() {
        verifyApplicationThread();
        return this.player.getCurrentStaticMetadata();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public int getDeviceVolume() {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            return streamVolumeManager.getVolume();
        }
        return 0;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.player.getPauseAtEndOfMediaItems();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    @Deprecated
    public ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.player.getPlayerError();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getRendererType(int i) {
        verifyApplicationThread();
        return this.player.getRendererType(i);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    @Nullable
    public TrackSelector getTrackSelector() {
        verifyApplicationThread();
        return this.player.getTrackSelector();
    }

    @Nullable
    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    @Nullable
    public Format getVideoFormat() {
        return this.videoFormat;
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public float getVolume() {
        return this.audioVolume;
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void increaseDeviceVolume() {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            streamVolumeManager.increaseVolume();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public boolean isDeviceMuted() {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            return streamVolumeManager.isMuted();
        }
        return false;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public boolean isLoading() {
        verifyApplicationThread();
        return this.player.isLoading();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        verifyApplicationThread();
        this.player.moveMediaItem(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        this.player.moveMediaItems(i, i2, i3);
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
    public void onSeekCompleted(AnalyticsListener.EventTime eventTime, SeekResult seekResult) {
        Log.d(this.TAG, "onSeekCompleted id:" + seekResult.seekId + ", type:" + seekResult.seekType + ", success:" + seekResult.success);
        if (this.isSeeking && seekResult.seekId == this.curSeekId) {
            this.isSeeking = false;
        }
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

    @Override // com.oplus.tbl.exoplayer2.Player
    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int iUpdateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, iUpdateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, iUpdateAudioFocus));
        this.player.prepare();
        resetVideoRenderStuckDetector();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void release() {
        AudioTrack audioTrack;
        verifyApplicationThread();
        if (Util.SDK_INT < 21 && (audioTrack = this.keepSessionIdAudioTrack) != null) {
            audioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        this.audioBecomingNoisyManager.setEnabled(false);
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            streamVolumeManager.release();
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        this.analyticsCollector.release();
        removeSurfaceCallbacks();
        Surface surface = this.surface;
        if (surface != null) {
            if (this.ownsSurface) {
                surface.release();
            }
            this.surface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCues = Collections.emptyList();
        this.playerReleased = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void removeAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.remove(deviceListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void removeMediaItem(int i) {
        verifyApplicationThread();
        this.player.removeMediaItem(i);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        this.player.removeMediaItems(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.MetadataComponent
    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.TextComponent
    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void removeVideoListener(VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void seekTo(int i, long j) {
        if (j >= 0) {
            seekToInternal(i, j, 0);
            return;
        }
        Log.e(this.TAG, "seekTo with invalid positionMs:" + j);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        verifyApplicationThread();
        if (this.playerReleased) {
            return;
        }
        if (!Util.areEqual(this.audioAttributes, audioAttributes)) {
            this.audioAttributes = audioAttributes;
            sendRendererMessage(1, 3, audioAttributes);
            StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
            if (streamVolumeManager != null) {
                streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes.usage));
            }
            this.analyticsCollector.onAudioAttributesChanged(audioAttributes);
            Iterator<AudioListener> it = this.audioListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioAttributesChanged(audioAttributes);
            }
        }
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!z) {
            audioAttributes = null;
        }
        audioFocusManager.setAudioAttributes(audioAttributes);
        boolean playWhenReady = getPlayWhenReady();
        int iUpdateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
        updatePlayWhenReady(playWhenReady, iUpdateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, iUpdateAudioFocus));
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void setAudioSessionId(int i) {
        verifyApplicationThread();
        if (this.audioSessionId == i) {
            return;
        }
        if (i == 0) {
            i = Util.SDK_INT < 21 ? initializeKeepSessionIdAudioTrack(0) : C.generateAudioSessionIdV21(this.applicationContext);
        } else if (Util.SDK_INT < 21) {
            initializeKeepSessionIdAudioTrack(i);
        }
        this.audioSessionId = i;
        sendRendererMessage(1, 102, Integer.valueOf(i));
        sendRendererMessage(2, 102, Integer.valueOf(i));
        this.analyticsCollector.onAudioSessionIdChanged(i);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionIdChanged(i);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 5, auxEffectInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener;
        sendRendererMessage(6, 7, cameraMotionListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            streamVolumeManager.setMuted(z);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player.DeviceComponent
    public void setDeviceVolume(int i) {
        verifyApplicationThread();
        StreamVolumeManager streamVolumeManager = this.streamVolumeManager;
        if (streamVolumeManager != null) {
            streamVolumeManager.setVolume(i);
        }
    }

    public void setDropFramePolicy(int i) {
        verifyApplicationThread();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(12).setPayload(Integer.valueOf(i)).send();
            }
        }
    }

    public void setEndPositionUs(long j) {
        verifyApplicationThread();
        this.player.setEndPositionUs(j);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        verifyApplicationThread();
        this.player.setForegroundMode(z);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        verifyApplicationThread();
        if (this.playerReleased) {
            return;
        }
        this.audioBecomingNoisyManager.setEnabled(z);
    }

    @Deprecated
    public void setHandleWakeLock(boolean z) {
        setWakeMode(z ? 1 : 0);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        verifyApplicationThread();
        this.player.setPauseAtEndOfMediaItems(z);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        int iUpdateAudioFocus = this.audioFocusManager.updateAudioFocus(z, getPlaybackState());
        updatePlayWhenReady(z, iUpdateAudioFocus, getPlayWhenReadyChangeReason(z, iUpdateAudioFocus));
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
        verifyApplicationThread();
        if (Util.areEqual(this.priorityTaskManager, priorityTaskManager)) {
            return;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
        }
        if (priorityTaskManager == null || !isLoading()) {
            this.isPriorityTaskManagerRegistered = false;
        } else {
            priorityTaskManager.add(0);
            this.isPriorityTaskManagerRegistered = true;
        }
        this.priorityTaskManager = priorityTaskManager;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setRepeatMode(int i) {
        verifyApplicationThread();
        this.player.setRepeatMode(i);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(z);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        verifyApplicationThread();
        this.player.setShuffleOrder(shuffleOrder);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void setSkipSilenceEnabled(boolean z) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled == z) {
            return;
        }
        this.skipSilenceEnabled = z;
        sendRendererMessage(1, 101, Boolean.valueOf(z));
        notifySkipSilenceEnabledChanged();
    }

    public void setThrowsWhenUsingWrongThread(boolean z) {
        this.throwsWhenUsingWrongThread = z;
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer
    @RequiresApi(api = 19)
    public void setVideoEffects(List<Effect> list) {
        verifyApplicationThread();
        try {
            PreviewingSingleInputVideoGraph.Factory.class.getConstructor(VideoFrameProcessor.Factory.class);
            sendRendererMessage(2, 13, list);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new IllegalStateException("Could not find required lib-effect dependencies.", e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener;
        sendRendererMessage(2, 6, videoFrameMetadataListener);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoScalingMode(int i) {
        verifyApplicationThread();
        this.videoScalingMode = i;
        sendRendererMessage(2, 4, Integer.valueOf(i));
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surface != null) {
            setVideoDecoderOutputBufferRenderer(null);
        }
        setVideoSurfaceInternal(surface, false);
        int i = surface != null ? -1 : 0;
        maybeNotifySurfaceSizeChanged(i, i);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surfaceHolder != null) {
            setVideoDecoderOutputBufferRenderer(null);
        }
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.componentListener);
            Surface surface = surfaceHolder.getSurface();
            if (surface != null && surface.isValid()) {
                setVideoSurfaceInternal(surface, false);
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
                return;
            }
        }
        setVideoSurfaceInternal(null, false);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (!(surfaceView instanceof VideoDecoderGLSurfaceView)) {
            setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
            return;
        }
        VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer = ((VideoDecoderGLSurfaceView) surfaceView).getVideoDecoderOutputBufferRenderer();
        clearVideoSurface();
        this.surfaceHolder = surfaceView.getHolder();
        setVideoDecoderOutputBufferRenderer(videoDecoderOutputBufferRenderer);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (textureView != null) {
            setVideoDecoderOutputBufferRenderer(null);
        }
        this.textureView = textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                Log.w(this.TAG, "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.componentListener);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                setVideoSurfaceInternal(new Surface(surfaceTexture), true);
                maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
                return;
            }
        }
        setVideoSurfaceInternal(null, true);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.AudioComponent
    public void setVolume(float f) {
        verifyApplicationThread();
        float fConstrainValue = Util.constrainValue(f, 0.0f, 1.0f);
        if (this.audioVolume == fConstrainValue) {
            return;
        }
        this.audioVolume = fConstrainValue;
        sendVolumeToRenderers();
        this.analyticsCollector.onVolumeChanged(fConstrainValue);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(fConstrainValue);
        }
    }

    public void setWakeMode(int i) {
        verifyApplicationThread();
        if (i == 0) {
            this.wakeLockManager.setEnabled(false);
        } else {
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.wakeLockManager.setEnabled(true);
                this.wifiLockManager.setEnabled(true);
                return;
            }
            this.wakeLockManager.setEnabled(true);
        }
        this.wifiLockManager.setEnabled(false);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void stop(boolean z) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        this.player.stop(z);
        this.currentCues = Collections.emptyList();
    }

    public SimpleExoPlayer(Builder builder) {
        this.TAG = "SimpleExoPlayer_ins_" + Thread.currentThread().getId();
        ConditionVariable conditionVariable = new ConditionVariable();
        this.constructorFinished = conditionVariable;
        Context applicationContext = builder.context.getApplicationContext();
        this.applicationContext = applicationContext;
        AnalyticsCollector analyticsCollector = builder.analyticsCollector;
        this.analyticsCollector = analyticsCollector;
        this.priorityTaskManager = builder.priorityTaskManager;
        this.audioAttributes = builder.audioAttributes;
        this.videoScalingMode = builder.videoScalingMode;
        this.skipSilenceEnabled = builder.skipSilenceEnabled;
        this.detachSurfaceTimeoutMs = builder.detachSurfaceTimeoutMs;
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.videoListeners = new CopyOnWriteArraySet<>();
        this.audioListeners = new CopyOnWriteArraySet<>();
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        this.deviceListeners = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(builder.looper);
        Renderer[] rendererArrCreateRenderers = builder.renderersFactory.createRenderers(handler, componentListener, componentListener, componentListener, componentListener);
        this.renderers = rendererArrCreateRenderers;
        this.audioVolume = 1.0f;
        this.audioSessionId = Util.SDK_INT < 21 ? initializeKeepSessionIdAudioTrack(0) : C.generateAudioSessionIdV21(applicationContext);
        this.currentCues = Collections.emptyList();
        this.throwsWhenUsingWrongThread = builder.throwsWhenUsingWrongThread;
        if (analyticsCollector != null) {
            analyticsCollector.addListener(this);
        }
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(rendererArrCreateRenderers, builder.trackSelector, builder.mediaSourceFactory, builder.loadControl, builder.bandwidthMeter, analyticsCollector, builder.useLazyPreparation, builder.seekParameters, builder.livePlaybackSpeedControl, builder.releaseTimeoutMs, builder.pauseAtEndOfMediaItems, builder.highPerformanceEnabled, builder.clock, builder.looper, this);
        this.player = exoPlayerImpl;
        exoPlayerImpl.addListener(componentListener);
        AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(builder.context, handler, componentListener);
        this.audioBecomingNoisyManager = audioBecomingNoisyManager;
        audioBecomingNoisyManager.setEnabled(builder.handleAudioBecomingNoisy);
        AudioFocusManager audioFocusManager = new AudioFocusManager(builder.context, handler, componentListener);
        this.audioFocusManager = audioFocusManager;
        audioFocusManager.setAudioAttributes(builder.handleAudioFocus ? this.audioAttributes : null);
        if (builder.deviceVolumeControlEnabled) {
            StreamVolumeManager streamVolumeManager = new StreamVolumeManager(builder.context, handler, componentListener);
            this.streamVolumeManager = streamVolumeManager;
            streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(this.audioAttributes.usage));
        } else {
            this.streamVolumeManager = null;
        }
        WakeLockManager wakeLockManager = new WakeLockManager(builder.context);
        this.wakeLockManager = wakeLockManager;
        wakeLockManager.setEnabled(builder.wakeMode != 0);
        WifiLockManager wifiLockManager = new WifiLockManager(builder.context);
        this.wifiLockManager = wifiLockManager;
        wifiLockManager.setEnabled(builder.wakeMode == 2);
        this.deviceInfo = createDeviceInfo(this.streamVolumeManager);
        sendRendererMessage(1, 102, Integer.valueOf(this.audioSessionId));
        sendRendererMessage(2, 102, Integer.valueOf(this.audioSessionId));
        sendRendererMessage(1, 3, this.audioAttributes);
        sendRendererMessage(2, 4, Integer.valueOf(this.videoScalingMode));
        sendRendererMessage(1, 101, Boolean.valueOf(this.skipSilenceEnabled));
        conditionVariable.open();
        this.isSeeking = false;
        this.seekingTime = -9223372036854775807L;
        this.curSeekId = -1;
        this.isEnablePreview = false;
        this.pendingPlayWhenReady = false;
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        this.player.addMediaItem(mediaItem);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(list);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(mediaSource);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(list);
    }

    @Override // com.oplus.tbl.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (surface == null || surface != this.surface) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.g(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.oplus.tbl.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        mc.j0(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, j);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, i, j);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, j);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, i, j);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z ? 0 : -1, -9223372036854775807L);
        prepare();
    }

    @Override // com.oplus.tbl.exoplayer2.BasePlayer, com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, z);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, z);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, z);
    }

    @Override // com.oplus.tbl.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, z);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public Player.AudioComponent getAudioComponent() {
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public Player.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public Player.MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public Player.VideoComponent getVideoComponent() {
        return this;
    }
}
