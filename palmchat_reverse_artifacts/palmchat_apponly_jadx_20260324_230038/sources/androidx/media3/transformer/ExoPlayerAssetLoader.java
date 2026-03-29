package androidx.media3.transformer;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoTimeoutException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.ExoPlayerAssetLoader;
import com.google.common.collect.ImmutableMap;
import defpackage.uv4;
import defpackage.xj4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ExoPlayerAssetLoader implements AssetLoader {
    private static final String TAG = "ExoPlayerAssetLoader";
    private final Context context;
    private final CapturingDecoderFactory decoderFactory;
    private final EditedMediaItem editedMediaItem;
    private final ExoPlayer player;
    private int progressState;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements AssetLoader.Factory {
        private final Clock clock;
        private final Context context;
        private final Codec.DecoderFactory decoderFactory;

        @Nullable
        private final LogSessionId logSessionId;

        @Nullable
        private final MediaSource.Factory mediaSourceFactory;

        @Nullable
        private final TrackSelector.Factory trackSelectorFactory;

        public Factory(Context context, Codec.DecoderFactory decoderFactory, Clock clock) {
            this(context, decoderFactory, clock, null, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$createAssetLoader$0(DefaultTrackSelector.Parameters parameters, Context context) {
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
            defaultTrackSelector.setParameters(parameters);
            return defaultTrackSelector;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            MediaSource.Factory defaultMediaSourceFactory;
            TrackSelector.Factory factory;
            MediaSource.Factory factory2 = this.mediaSourceFactory;
            if (factory2 == null) {
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                if (editedMediaItem.flattenForSlowMotion) {
                    defaultExtractorsFactory.setMp4ExtractorFlags(4);
                }
                defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.context, defaultExtractorsFactory);
            } else {
                defaultMediaSourceFactory = factory2;
            }
            TrackSelector.Factory factory3 = this.trackSelectorFactory;
            if (factory3 == null) {
                final DefaultTrackSelector.Parameters parametersBuild = new DefaultTrackSelector.Parameters.Builder(this.context).setForceHighestSupportedBitrate(true).setConstrainAudioChannelCountToDeviceCapabilities(false).build();
                factory = new TrackSelector.Factory() { // from class: wp1
                    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.Factory
                    public final TrackSelector createTrackSelector(Context context) {
                        return ExoPlayerAssetLoader.Factory.lambda$createAssetLoader$0(parametersBuild, context);
                    }
                };
            } else {
                factory = factory3;
            }
            return new ExoPlayerAssetLoader(this.context, editedMediaItem, defaultMediaSourceFactory, this.decoderFactory, compositionSettings.hdrMode, looper, listener, this.clock, factory, this.logSessionId);
        }

        public Factory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, MediaSource.Factory factory) {
            this(context, decoderFactory, clock, factory, null, null);
        }

        public Factory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, @Nullable MediaSource.Factory factory, @Nullable TrackSelector.Factory factory2, @Nullable LogSessionId logSessionId) {
            this.context = context;
            this.decoderFactory = decoderFactory;
            this.clock = clock;
            this.mediaSourceFactory = factory;
            this.trackSelectorFactory = factory2;
            this.logSessionId = logSessionId;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class PlayerListener implements Player.Listener {
        private final AssetLoader.Listener assetLoaderListener;

        public PlayerListener(AssetLoader.Listener listener) {
            this.assetLoaderListener = listener;
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            xj4.a(this, audioAttributes);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAudioSessionIdChanged(int i) {
            xj4.b(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            xj4.c(this, commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onCues(CueGroup cueGroup) {
            xj4.d(this, cueGroup);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            xj4.f(this, deviceInfo);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            xj4.g(this, i, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            xj4.h(this, player, events);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            xj4.i(this, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            xj4.j(this, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            xj4.k(this, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            xj4.l(this, j);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            xj4.m(this, mediaItem, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            xj4.n(this, mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMetadata(Metadata metadata) {
            xj4.o(this, metadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            xj4.p(this, z, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            xj4.q(this, playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            xj4.r(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            xj4.s(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            Throwable cause = playbackException.getCause();
            if ((cause instanceof ExoTimeoutException) && ((ExoTimeoutException) cause).timeoutOperation == 1) {
                Log.e(ExoPlayerAssetLoader.TAG, "Releasing the player timed out.", playbackException);
            } else {
                this.assetLoaderListener.onError(ExportException.createForAssetLoader(playbackException, ((Integer) Assertions.checkNotNull(ExportException.NAME_TO_ERROR_CODE.getOrDefault(playbackException.getErrorCodeName(), 1000))).intValue()));
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            xj4.u(this, playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            xj4.v(this, z, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            xj4.w(this, mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            xj4.x(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onRenderedFirstFrame() {
            xj4.z(this);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            xj4.A(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            xj4.B(this, j);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            xj4.C(this, j);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            xj4.D(this, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            xj4.E(this, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            xj4.F(this, i, i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTimelineChanged(Timeline timeline, int i) {
            try {
                if (ExoPlayerAssetLoader.this.progressState != 1) {
                    return;
                }
                Timeline.Window window = new Timeline.Window();
                timeline.getWindow(0, window);
                if (window.isPlaceholder) {
                    return;
                }
                long j = window.durationUs;
                ExoPlayerAssetLoader.this.progressState = (j <= 0 || j == -9223372036854775807L) ? 3 : 2;
                this.assetLoaderListener.onDurationUs(window.durationUs);
            } catch (RuntimeException e) {
                this.assetLoaderListener.onError(ExportException.createForAssetLoader(e, 1000));
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            xj4.H(this, trackSelectionParameters);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r3v9, types: [androidx.media3.transformer.AssetLoader$Listener] */
        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(Tracks tracks) {
            try {
                ?? IsTypeSelected = tracks.isTypeSelected(1);
                ?? r0 = IsTypeSelected;
                if (tracks.isTypeSelected(2)) {
                    r0 = IsTypeSelected + 1;
                }
                ExoPlayerAssetLoader.maybeWarnUnsupportedTrackTypes(tracks);
                if (r0 > 0) {
                    this.assetLoaderListener.onTrackCount(r0);
                    ExoPlayerAssetLoader.this.player.play();
                    return;
                }
                String str = "The asset loader has no audio or video track to output.";
                if (TransformerUtil.isImage(ExoPlayerAssetLoader.this.context, ExoPlayerAssetLoader.this.editedMediaItem.mediaItem)) {
                    str = "The asset loader has no audio or video track to output. Try setting an image duration on input image MediaItems.";
                }
                this.assetLoaderListener.onError(ExportException.createForAssetLoader(new IllegalStateException(str), 1001));
            } catch (RuntimeException e) {
                this.assetLoaderListener.onError(ExportException.createForAssetLoader(e, 1000));
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            xj4.J(this, videoSize);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onVolumeChanged(float f) {
            xj4.K(this, f);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onCues(List list) {
            xj4.e(this, list);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            xj4.y(this, positionInfo, positionInfo2, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class RenderersFactoryImpl implements RenderersFactory {
        private final AssetLoader.Listener assetLoaderListener;
        private final Codec.DecoderFactory decoderFactory;
        private final boolean flattenForSlowMotion;
        private final int hdrMode;

        @Nullable
        private final LogSessionId logSessionId;
        private final TransformerMediaClock mediaClock = new TransformerMediaClock();
        private final boolean removeAudio;
        private final boolean removeVideo;

        public RenderersFactoryImpl(boolean z, boolean z2, boolean z3, Codec.DecoderFactory decoderFactory, int i, AssetLoader.Listener listener, @Nullable LogSessionId logSessionId) {
            this.removeAudio = z;
            this.removeVideo = z2;
            this.flattenForSlowMotion = z3;
            this.decoderFactory = decoderFactory;
            this.hdrMode = i;
            this.assetLoaderListener = listener;
            this.logSessionId = logSessionId;
        }

        @Override // androidx.media3.exoplayer.RenderersFactory
        public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            ArrayList arrayList = new ArrayList();
            if (!this.removeAudio) {
                arrayList.add(new ExoAssetLoaderAudioRenderer(this.decoderFactory, this.mediaClock, this.assetLoaderListener, this.logSessionId));
            }
            if (!this.removeVideo) {
                arrayList.add(new ExoAssetLoaderVideoRenderer(this.flattenForSlowMotion, this.decoderFactory, this.hdrMode, this.mediaClock, this.assetLoaderListener, this.logSessionId));
            }
            return (Renderer[]) arrayList.toArray(new Renderer[0]);
        }

        @Override // androidx.media3.exoplayer.RenderersFactory
        public /* synthetic */ Renderer createSecondaryRenderer(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            return uv4.a(this, renderer, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void maybeWarnUnsupportedTrackTypes(Tracks tracks) {
        for (int i = 0; i < tracks.getGroups().size(); i++) {
            int type = tracks.getGroups().get(i).getType();
            if (type != 1 && type != 2) {
                Log.w(TAG, "Unsupported track type: " + type);
            }
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        ImmutableMap.b bVar = new ImmutableMap.b();
        String audioDecoderName = this.decoderFactory.getAudioDecoderName();
        if (audioDecoderName != null) {
            bVar.h(1, audioDecoderName);
        }
        String videoDecoderName = this.decoderFactory.getVideoDecoderName();
        if (videoDecoderName != null) {
            bVar.h(2, videoDecoderName);
        }
        return bVar.d();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        if (this.progressState == 2) {
            long duration = this.player.getDuration();
            progressHolder.progress = Util.percentInt(Math.min(this.player.getCurrentPosition(), duration), duration);
        }
        return this.progressState;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.player.release();
        this.progressState = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.player.setMediaItem(this.editedMediaItem.mediaItem);
        this.player.prepare();
        this.progressState = 1;
    }

    private ExoPlayerAssetLoader(Context context, EditedMediaItem editedMediaItem, MediaSource.Factory factory, Codec.DecoderFactory decoderFactory, int i, Looper looper, AssetLoader.Listener listener, Clock clock, TrackSelector.Factory factory2, @Nullable LogSessionId logSessionId) {
        this.context = context;
        this.editedMediaItem = editedMediaItem;
        CapturingDecoderFactory capturingDecoderFactory = new CapturingDecoderFactory(decoderFactory);
        this.decoderFactory = capturingDecoderFactory;
        TrackSelector trackSelectorCreateTrackSelector = factory2.createTrackSelector(context);
        ExoPlayer.Builder usePlatformDiagnostics = new ExoPlayer.Builder(context, new RenderersFactoryImpl(editedMediaItem.removeAudio, editedMediaItem.removeVideo, editedMediaItem.flattenForSlowMotion, capturingDecoderFactory, i, listener, logSessionId)).setMediaSourceFactory(factory).setTrackSelector(trackSelectorCreateTrackSelector).setLoadControl(new DefaultLoadControl.Builder().setBufferDurationsMs(50000, 50000, 100, 200).build()).setLooper(looper).setUsePlatformDiagnostics(false);
        if (decoderFactory instanceof DefaultDecoderFactory) {
            usePlatformDiagnostics.experimentalSetDynamicSchedulingEnabled(((DefaultDecoderFactory) decoderFactory).isDynamicSchedulingEnabled());
        }
        if (clock != Clock.DEFAULT) {
            usePlatformDiagnostics.setClock(clock);
        }
        ExoPlayer exoPlayerBuild = usePlatformDiagnostics.build();
        this.player = exoPlayerBuild;
        exoPlayerBuild.addListener(new PlayerListener(listener));
        this.progressState = 0;
    }
}
