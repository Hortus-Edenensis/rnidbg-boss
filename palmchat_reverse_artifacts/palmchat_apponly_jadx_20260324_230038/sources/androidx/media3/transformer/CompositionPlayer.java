package androidx.media3.transformer;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.SingleInputVideoGraph;
import androidx.media3.effect.TimestampAdjustment;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.ConcatenatingMediaSource2;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MergingMediaSource;
import androidx.media3.exoplayer.source.SilenceMediaSource;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.transformer.CompositionPlayerInternal;
import androidx.media3.transformer.CompositionTrackSelector;
import androidx.media3.transformer.DefaultAudioMixer;
import androidx.media3.transformer.EditedMediaItemSequence;
import com.google.common.collect.ImmutableList;
import defpackage.o46;
import defpackage.ok0;
import defpackage.pk0;
import defpackage.qk0;
import defpackage.r33;
import defpackage.tj4;
import defpackage.xj4;
import defpackage.z42;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UnstableApi
public final class CompositionPlayer extends SimpleBasePlayer implements CompositionPlayerInternal.Listener, PlaybackVideoGraphWrapper.Listener, SurfaceHolder.Callback {
    private static final Player.Commands AVAILABLE_COMMANDS = new Player.Commands.Builder().addAll(1, 2, 3, 5, 8, 4, 11, 12, 16, 17, 15, 27, 22, 24, 32).build();
    private static final int[] SUPPORTED_LISTENER_EVENTS = {4, 5, 10, 11, 1};
    private static final String TAG = "CompositionPlayer";
    private final HandlerWrapper applicationHandler;
    private SimpleBasePlayer.LivePositionSupplier bufferedPositionSupplier;
    private final Clock clock;
    private Composition composition;
    private long compositionDurationUs;
    private final HandlerWrapper compositionInternalListenerHandler;
    private CompositionPlayerInternal compositionPlayerInternal;
    private boolean compositionPlayerInternalPrepared;
    private final Context context;

    @Nullable
    private Surface displaySurface;
    private final boolean enableReplayableCache;
    private final AudioSink finalAudioSink;
    private final ImageDecoder.Factory imageDecoderFactory;
    private final MediaSource.Factory mediaSourceFactory;
    private VideoFrameMetadataListener pendingVideoFrameMetadatListener;
    private boolean playWhenReady;
    private int playWhenReadyChangeReason;
    private PlaybackAudioGraphWrapper playbackAudioGraphWrapper;

    @Nullable
    private PlaybackException playbackException;
    private int playbackState;
    private int playbackSuppressionReason;
    private HandlerThread playbackThread;
    private HandlerWrapper playbackThreadHandler;
    private PlaybackVideoGraphWrapper playbackVideoGraphWrapper;
    private final List<SequencePlayerHolder> playerHolders;
    private ImmutableList<SimpleBasePlayer.MediaItemData> playlist;
    private SimpleBasePlayer.LivePositionSupplier positionSupplier;
    private boolean renderedFirstFrame;
    private int repeatMode;
    private boolean repeatingCompositionSeekInProgress;
    private boolean scrubbingModeEnabled;

    @Nullable
    private SurfaceHolder surfaceHolder;
    private SimpleBasePlayer.LivePositionSupplier totalBufferedDurationSupplier;
    private final VideoGraph.Factory videoGraphFactory;

    @Nullable
    private Object videoOutput;
    private Size videoOutputSize;
    private final boolean videoPrewarmingEnabled;
    private final SparseBooleanArray videoTracksSelected;
    private float volume;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private AudioSink audioSink;
        private boolean built;
        private final Context context;
        private boolean enableReplayableCache;
        private GlObjectsProvider glObjectsProvider;
        private ImageDecoder.Factory imageDecoderFactory;
        private Looper looper;
        private MediaSource.Factory mediaSourceFactory;
        private VideoGraph.Factory videoGraphFactory;
        private boolean videoPrewarmingEnabled = true;
        private Clock clock = Clock.DEFAULT;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
            this.mediaSourceFactory = new DefaultMediaSourceFactory(context);
            this.imageDecoderFactory = new BitmapFactoryImageDecoder.Factory(context).setMaxOutputSize(4096);
        }

        public CompositionPlayer build() {
            Assertions.checkState(!this.built);
            if (this.looper == null) {
                this.looper = (Looper) Assertions.checkStateNotNull(Looper.myLooper());
            }
            if (this.audioSink == null) {
                this.audioSink = new DefaultAudioSink.Builder(this.context).build();
            }
            if (this.videoGraphFactory == null) {
                DefaultVideoFrameProcessor.Factory.Builder enableReplayableCache = new DefaultVideoFrameProcessor.Factory.Builder().setEnableReplayableCache(this.enableReplayableCache);
                GlObjectsProvider glObjectsProvider = this.glObjectsProvider;
                if (glObjectsProvider != null) {
                    enableReplayableCache.setGlObjectsProvider(glObjectsProvider);
                }
                this.videoGraphFactory = new SingleInputVideoGraph.Factory(enableReplayableCache.build());
            }
            CompositionPlayer compositionPlayer = new CompositionPlayer(this);
            DefaultAnalyticsCollector defaultAnalyticsCollector = new DefaultAnalyticsCollector(this.clock);
            defaultAnalyticsCollector.setPlayer(compositionPlayer, this.looper);
            defaultAnalyticsCollector.addListener(new EventLogger(CompositionPlayer.TAG));
            compositionPlayer.addListener(defaultAnalyticsCollector);
            this.built = true;
            return compositionPlayer;
        }

        public Builder experimentalSetEnableReplayableCache(boolean z) {
            this.enableReplayableCache = z;
            return this;
        }

        public Builder setAudioSink(AudioSink audioSink) {
            this.audioSink = audioSink;
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setGlObjectsProvider(GlObjectsProvider glObjectsProvider) {
            this.glObjectsProvider = glObjectsProvider;
            return this;
        }

        public Builder setImageDecoderFactory(ImageDecoder.Factory factory) {
            this.imageDecoderFactory = factory;
            return this;
        }

        public Builder setLooper(Looper looper) {
            this.looper = looper;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.mediaSourceFactory = factory;
            return this;
        }

        public Builder setVideoGraphFactory(VideoGraph.Factory factory) {
            this.videoGraphFactory = factory;
            return this;
        }

        @VisibleForTesting
        public Builder setVideoPrewarmingEnabled(boolean z) {
            this.videoPrewarmingEnabled = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CompositionFrameTimingEvaluator implements VideoFrameReleaseControl.FrameTimingEvaluator {
        private static final long FRAME_LATE_THRESHOLD_US = -30000;
        private static final long FRAME_RELEASE_THRESHOLD_US = 100000;

        private CompositionFrameTimingEvaluator() {
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean shouldDropFrame(long j, long j2, boolean z) {
            return j < FRAME_LATE_THRESHOLD_US && !z;
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean shouldForceReleaseFrame(long j, long j2) {
            return j < FRAME_LATE_THRESHOLD_US && j2 > 100000;
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean shouldIgnoreFrame(long j, long j2, long j3, boolean z, boolean z2) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class PlayerListener implements Player.Listener {
        private final int playerIndex;

        public PlayerListener(int i) {
            this.playerIndex = i;
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
        public void onEvents(Player player, Player.Events events) {
            if (events.containsAny(CompositionPlayer.SUPPORTED_LISTENER_EVENTS)) {
                CompositionPlayer.this.invalidateState();
            }
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
        public void onPlayWhenReadyChanged(boolean z, int i) {
            CompositionPlayer.this.playWhenReadyChangeReason = i;
            if (i == 5 && CompositionPlayer.this.repeatMode != 0 && this.playerIndex == 0) {
                CompositionPlayer.this.repeatCompositionPlayback();
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            xj4.q(this, playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackStateChanged(int i) {
            CompositionPlayer.this.updatePlaybackState();
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            xj4.s(this, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            CompositionPlayer.this.maybeUpdatePlaybackError("error from player " + this.playerIndex, playbackException, playbackException.errorCode);
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
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            xj4.G(this, timeline, i);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            xj4.H(this, trackSelectionParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            xj4.I(this, tracks);
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
    public final class SequencePlayerHolder {
        public final ExoPlayer player;
        public final SequenceRenderersFactory renderersFactory;
        public final CompositionTrackSelector trackSelector;

        public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
            this.renderersFactory.setSequence(editedMediaItemSequence);
            this.trackSelector.setSequence(editedMediaItemSequence);
        }

        private SequencePlayerHolder(Context context, Looper looper, Looper looper2, Clock clock, SequenceRenderersFactory sequenceRenderersFactory, int i) {
            CompositionTrackSelector compositionTrackSelector = new CompositionTrackSelector(context, new CompositionTrackSelector.Listener() { // from class: androidx.media3.transformer.q
                @Override // androidx.media3.transformer.CompositionTrackSelector.Listener
                public final void onVideoTrackSelection(boolean z, int i2) {
                    CompositionPlayer.access$1900(compositionPlayer, z, i2);
                }
            }, i);
            this.trackSelector = compositionTrackSelector;
            ExoPlayer.Builder builderExperimentalSetDynamicSchedulingEnabled = new ExoPlayer.Builder(context).setLooper(looper).setPlaybackLooper(looper2).setRenderersFactory(sequenceRenderersFactory).setHandleAudioBecomingNoisy(true).setClock(clock).experimentalSetDynamicSchedulingEnabled(true);
            builderExperimentalSetDynamicSchedulingEnabled.setTrackSelector(compositionTrackSelector);
            this.player = builderExperimentalSetDynamicSchedulingEnabled.build();
            this.renderersFactory = sequenceRenderersFactory;
        }
    }

    public static /* synthetic */ void access$1900(CompositionPlayer compositionPlayer, boolean z, int i) {
        compositionPlayer.onVideoTrackSelection(z, i);
    }

    private void clearVideoSurfaceInternal() {
        this.displaySurface = null;
        CompositionPlayerInternal compositionPlayerInternal = this.compositionPlayerInternal;
        if (compositionPlayerInternal != null) {
            compositionPlayerInternal.clearOutputSurface();
        }
    }

    private static EditedMediaItem clipToDuration(EditedMediaItem editedMediaItem, long j) {
        MediaItem.ClippingConfiguration clippingConfiguration = editedMediaItem.mediaItem.clippingConfiguration;
        return editedMediaItem.buildUpon().setMediaItem(editedMediaItem.mediaItem.buildUpon().setClippingConfiguration(clippingConfiguration.buildUpon().setEndPositionUs(clippingConfiguration.startPositionUs + j).build()).build()).build();
    }

    private static MediaSource createMediaSourceWithSilence(MediaSource.Factory factory, EditedMediaItem editedMediaItem) {
        ClippingMediaSource clippingMediaSourceBuild = new ClippingMediaSource.Builder(new SilenceMediaSource(editedMediaItem.durationUs)).setStartPositionUs(editedMediaItem.mediaItem.clippingConfiguration.startPositionUs).setEndPositionUs(editedMediaItem.mediaItem.clippingConfiguration.endPositionUs).build();
        return editedMediaItem.isGap() ? clippingMediaSourceBuild : new MergingMediaSource(factory.createMediaSource(editedMediaItem.mediaItem), clippingMediaSourceBuild);
    }

    private ImmutableList<SimpleBasePlayer.MediaItemData> createPlaylist() {
        Assertions.checkNotNull(Boolean.valueOf(this.compositionDurationUs != -9223372036854775807L));
        return ImmutableList.of(new SimpleBasePlayer.MediaItemData.Builder("CompositionTimeline").setMediaItem(MediaItem.EMPTY).setDurationUs(this.compositionDurationUs).build());
    }

    private static MediaSource createPrimarySequenceMediaSource(EditedMediaItemSequence editedMediaItemSequence, MediaSource.Factory factory) {
        ConcatenatingMediaSource2.Builder builder = new ConcatenatingMediaSource2.Builder();
        for (int i = 0; i < editedMediaItemSequence.editedMediaItems.size(); i++) {
            EditedMediaItem editedMediaItem = editedMediaItemSequence.editedMediaItems.get(i);
            Assertions.checkArgument(editedMediaItem.durationUs != -9223372036854775807L);
            long presentationDurationUs = editedMediaItem.getPresentationDurationUs();
            builder.add(wrapWithVideoEffectsBasedMediaSources(createMediaSourceWithSilence(factory, editedMediaItem), editedMediaItem.effects.videoEffects, presentationDurationUs), Util.usToMs(presentationDurationUs));
        }
        return builder.build();
    }

    private static MediaSource createSecondarySequenceMediaSource(EditedMediaItemSequence editedMediaItemSequence, MediaSource.Factory factory, long j) {
        ConcatenatingMediaSource2.Builder builder = new ConcatenatingMediaSource2.Builder();
        int size = 0;
        if (!editedMediaItemSequence.isLooping) {
            while (size < editedMediaItemSequence.editedMediaItems.size()) {
                EditedMediaItem editedMediaItem = editedMediaItemSequence.editedMediaItems.get(size);
                builder.add(createMediaSourceWithSilence(factory, editedMediaItem), Util.usToMs(editedMediaItem.getPresentationDurationUs()));
                size++;
            }
            return builder.build();
        }
        long j2 = 0;
        while (true) {
            if (j2 >= j) {
                break;
            }
            EditedMediaItem editedMediaItem2 = editedMediaItemSequence.editedMediaItems.get(size);
            long presentationDurationUs = editedMediaItem2.getPresentationDurationUs();
            long j3 = j2 + presentationDurationUs;
            if (j3 > j) {
                builder.add(createMediaSourceWithSilence(factory, clipToDuration(editedMediaItem2, j - j2)));
                break;
            }
            builder.add(createMediaSourceWithSilence(factory, editedMediaItem2), Util.usToMs(presentationDurationUs));
            size = (size + 1) % editedMediaItemSequence.editedMediaItems.size();
            j2 = j3;
        }
        return builder.build();
    }

    private static Composition deactivateSpeedAdjustingVideoEffects(Composition composition) {
        ArrayList arrayList = new ArrayList();
        o46<EditedMediaItemSequence> it = composition.sequences.iterator();
        while (it.hasNext()) {
            EditedMediaItemSequence next = it.next();
            ArrayList arrayList2 = new ArrayList();
            o46<EditedMediaItem> it2 = next.editedMediaItems.iterator();
            while (it2.hasNext()) {
                EditedMediaItem next2 = it2.next();
                ImmutableList<Effect> immutableList = next2.effects.videoEffects;
                ArrayList arrayList3 = new ArrayList();
                o46<Effect> it3 = immutableList.iterator();
                while (it3.hasNext()) {
                    Effect next3 = it3.next();
                    if (next3 instanceof TimestampAdjustment) {
                        arrayList3.add(new InactiveTimestampAdjustment(((TimestampAdjustment) next3).speedProvider));
                    } else {
                        arrayList3.add(next3);
                    }
                }
                arrayList2.add(next2.buildUpon().setEffects(new Effects(next2.effects.audioProcessors, arrayList3)).build());
            }
            arrayList.add(new EditedMediaItemSequence.Builder(arrayList2).setIsLooping(next.isLooping).experimentalSetForceAudioTrack(next.forceAudioTrack).experimentalSetForceVideoTrack(next.forceVideoTrack).build());
        }
        return composition.buildUpon().setSequences(arrayList).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getBufferedPositionMs() {
        if (this.playerHolders.isEmpty()) {
            return 0L;
        }
        long jMin = 2147483647L;
        for (int i = 0; i < this.playerHolders.size(); i++) {
            int playbackState = this.playerHolders.get(i).player.getPlaybackState();
            if (playbackState == 3 || playbackState == 2) {
                jMin = Math.min(jMin, this.playerHolders.get(i).player.getBufferedPosition());
            }
        }
        if (jMin == 2147483647L) {
            return 0L;
        }
        return jMin;
    }

    private static long getCompositionDurationUs(Composition composition) {
        Assertions.checkState(!composition.sequences.isEmpty());
        long jMax = -2147483648L;
        for (int i = 0; i < composition.sequences.size(); i++) {
            EditedMediaItemSequence editedMediaItemSequence = composition.sequences.get(i);
            if (!editedMediaItemSequence.isLooping) {
                jMax = Math.max(jMax, getSequenceDurationUs(editedMediaItemSequence));
            }
        }
        return jMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getContentPositionMs() {
        long jMax = 0;
        if (this.playerHolders.isEmpty()) {
            return 0L;
        }
        for (int i = 0; i < this.playerHolders.size(); i++) {
            jMax = Math.max(jMax, this.playerHolders.get(i).player.getContentPosition());
        }
        return jMax;
    }

    private boolean getRenderedFirstFrameAndReset() {
        boolean z = this.renderedFirstFrame;
        this.renderedFirstFrame = false;
        return z;
    }

    private static long getSequenceDurationUs(EditedMediaItemSequence editedMediaItemSequence) {
        long presentationDurationUs = 0;
        for (int i = 0; i < editedMediaItemSequence.editedMediaItems.size(); i++) {
            presentationDurationUs += editedMediaItemSequence.editedMediaItems.get(i).getPresentationDurationUs();
        }
        Assertions.checkState(presentationDurationUs > 0, String.valueOf(presentationDurationUs));
        return presentationDurationUs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getTotalBufferedDurationMs() {
        if (this.playerHolders.isEmpty()) {
            return 0L;
        }
        long jMin = 2147483647L;
        for (int i = 0; i < this.playerHolders.size(); i++) {
            int playbackState = this.playerHolders.get(i).player.getPlaybackState();
            if (playbackState == 3 || playbackState == 2) {
                jMin = Math.min(jMin, this.playerHolders.get(i).player.getTotalBufferedDuration());
            }
        }
        if (jMin == 2147483647L) {
            return 0L;
        }
        return jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$experimentalRedrawLastFrame$0() {
        ((PlaybackVideoGraphWrapper) Assertions.checkNotNull(this.playbackVideoGraphWrapper)).getSink(0).redraw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$2(VideoFrameProcessingException videoFrameProcessingException) {
        maybeUpdatePlaybackError("Error processing video frames", videoFrameProcessingException, 7001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFirstFrameRendered$1() {
        this.renderedFirstFrame = true;
        invalidateState();
    }

    private void maybeSetOutputSurfaceInfo(int i, int i2) {
        CompositionPlayerInternal compositionPlayerInternal;
        Surface surface = this.displaySurface;
        if (i == 0 || i2 == 0 || surface == null || (compositionPlayerInternal = this.compositionPlayerInternal) == null) {
            return;
        }
        compositionPlayerInternal.setOutputSurfaceInfo(surface, new Size(i, i2));
    }

    private r33<?> maybeSetVideoOutput() {
        Object obj = this.videoOutput;
        if (obj == null || this.composition == null) {
            return z42.f();
        }
        if (obj instanceof SurfaceHolder) {
            setVideoSurfaceHolderInternal((SurfaceHolder) obj);
        } else if (obj instanceof SurfaceView) {
            setVideoSurfaceHolderInternal(((SurfaceView) obj).getHolder());
        } else {
            if (!(obj instanceof Surface)) {
                throw new IllegalStateException(this.videoOutput.getClass().toString());
            }
            setVideoSurfaceInternal((Surface) obj, (Size) Assertions.checkNotNull(this.videoOutputSize, "VideoOutputSize must be set when using Surface output"));
        }
        return z42.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdatePlaybackError(String str, Exception exc, int i) {
        if (this.playbackException != null) {
            Log.w(TAG, str, exc);
            return;
        }
        this.playbackException = new PlaybackException(str, exc, i);
        for (int i2 = 0; i2 < this.playerHolders.size(); i2++) {
            this.playerHolders.get(i2).player.stop();
        }
        updatePlaybackState();
        invalidateState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoTrackSelection(boolean z, int i) {
        this.videoTracksSelected.put(i, z);
        if (this.videoTracksSelected.size() == ((Composition) Assertions.checkNotNull(this.composition)).sequences.size()) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.videoTracksSelected.size(); i3++) {
                SparseBooleanArray sparseBooleanArray = this.videoTracksSelected;
                if (sparseBooleanArray.get(sparseBooleanArray.keyAt(i3))) {
                    i2++;
                }
            }
            ((PlaybackVideoGraphWrapper) Assertions.checkNotNull(this.playbackVideoGraphWrapper)).setTotalVideoInputCount(i2);
        }
    }

    private void prepareCompositionPlayerInternal() {
        if (this.compositionPlayerInternalPrepared) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CompositionPlaybackThread", -16);
        this.playbackThread = handlerThread;
        handlerThread.start();
        this.playbackThreadHandler = this.clock.createHandler(this.playbackThread.getLooper(), null);
        this.playbackAudioGraphWrapper = new PlaybackAudioGraphWrapper(new DefaultAudioMixer.Factory(), (AudioSink) Assertions.checkNotNull(this.finalAudioSink));
        PlaybackVideoGraphWrapper playbackVideoGraphWrapperBuild = new PlaybackVideoGraphWrapper.Builder(this.context, new VideoFrameReleaseControl(this.context, new CompositionFrameTimingEvaluator(), 0L)).setVideoGraphFactory((VideoGraph.Factory) Assertions.checkNotNull(this.videoGraphFactory)).setClock(this.clock).setEnableReplayableCache(this.enableReplayableCache).build();
        this.playbackVideoGraphWrapper = playbackVideoGraphWrapperBuild;
        playbackVideoGraphWrapperBuild.addListener(this);
        CompositionPlayerInternal compositionPlayerInternal = new CompositionPlayerInternal(this.playbackThread.getLooper(), this.clock, this.playbackAudioGraphWrapper, this.playbackVideoGraphWrapper, this, this.compositionInternalListenerHandler);
        this.compositionPlayerInternal = compositionPlayerInternal;
        compositionPlayerInternal.setVolume(this.volume);
        this.compositionPlayerInternalPrepared = true;
    }

    private void removeSurfaceCallbacks() {
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void repeatCompositionPlayback() {
        this.repeatingCompositionSeekInProgress = true;
        seekToDefaultPosition();
    }

    private void resetLivePositionSuppliers() {
        this.positionSupplier.disconnect(getContentPositionMs());
        this.bufferedPositionSupplier.disconnect(getBufferedPositionMs());
        this.totalBufferedDurationSupplier.disconnect(getTotalBufferedDurationMs());
        this.positionSupplier = new SimpleBasePlayer.LivePositionSupplier(new ok0(this));
        this.bufferedPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new pk0(this));
        this.totalBufferedDurationSupplier = new SimpleBasePlayer.LivePositionSupplier(new qk0(this));
    }

    private void setCompositionInternal(Composition composition) {
        long j;
        long j2;
        prepareCompositionPlayerInternal();
        ((CompositionPlayerInternal) Assertions.checkNotNull(this.compositionPlayerInternal)).setComposition(composition);
        this.compositionDurationUs = getCompositionDurationUs(composition);
        long sequenceDurationUs = getSequenceDurationUs((EditedMediaItemSequence) Assertions.checkNotNull(composition.sequences.get(0)));
        int i = 0;
        while (i < composition.sequences.size()) {
            EditedMediaItemSequence editedMediaItemSequence = composition.sequences.get(i);
            if (this.playerHolders.size() <= i) {
                j = sequenceDurationUs;
                this.playerHolders.add(new SequencePlayerHolder(this.context, getApplicationLooper(), ((HandlerThread) Assertions.checkStateNotNull(this.playbackThread)).getLooper(), this.clock, SequenceRenderersFactory.create(this.context, (PlaybackAudioGraphWrapper) Assertions.checkStateNotNull(this.playbackAudioGraphWrapper), ((PlaybackVideoGraphWrapper) Assertions.checkStateNotNull(this.playbackVideoGraphWrapper)).getSink(i), this.imageDecoderFactory, i, this.videoPrewarmingEnabled), i));
            } else {
                j = sequenceDurationUs;
            }
            SequencePlayerHolder sequencePlayerHolder = this.playerHolders.get(i);
            sequencePlayerHolder.setSequence(editedMediaItemSequence);
            sequencePlayerHolder.renderersFactory.setRequestMediaCodecToneMapping(composition.hdrMode == 1);
            ExoPlayer exoPlayer = sequencePlayerHolder.player;
            exoPlayer.addListener(new PlayerListener(i));
            exoPlayer.addAnalyticsListener(new EventLogger("CompositionPlayer-" + i));
            exoPlayer.setPauseAtEndOfMediaItems(true);
            if (i == 0) {
                exoPlayer.setMediaSource(createPrimarySequenceMediaSource(editedMediaItemSequence, this.mediaSourceFactory));
                VideoFrameMetadataListener videoFrameMetadataListener = this.pendingVideoFrameMetadatListener;
                if (videoFrameMetadataListener != null) {
                    exoPlayer.setVideoFrameMetadataListener(videoFrameMetadataListener);
                }
                j2 = j;
            } else {
                j2 = j;
                exoPlayer.setMediaSource(createSecondarySequenceMediaSource(editedMediaItemSequence, this.mediaSourceFactory, j2));
            }
            if (i == 0) {
                invalidateState();
                this.playlist = createPlaylist();
            }
            if (this.playbackState != 1) {
                exoPlayer.stop();
                exoPlayer.prepare();
            }
            i++;
            sequenceDurationUs = j2;
        }
    }

    private void setVideoSurfaceHolderInternal(SurfaceHolder surfaceHolder) {
        removeSurfaceCallbacks();
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            clearVideoSurfaceInternal();
            return;
        }
        Size size = new Size(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
        this.videoOutputSize = size;
        setVideoSurfaceInternal(surface, size);
    }

    private void setVideoSurfaceInternal(Surface surface, Size size) {
        this.displaySurface = surface;
        maybeSetOutputSurfaceInfo(size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackState() {
        if (this.playerHolders.isEmpty() || this.playbackException != null) {
            this.playbackState = 1;
            return;
        }
        int i = this.playbackState;
        this.playbackSuppressionReason = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.playerHolders.size(); i5++) {
            if (this.playerHolders.get(i5).player.getPlaybackSuppressionReason() != 0) {
                this.playbackSuppressionReason = this.playerHolders.get(i5).player.getPlaybackSuppressionReason();
            }
            int playbackState = this.playerHolders.get(i5).player.getPlaybackState();
            if (playbackState == 1) {
                i2++;
            } else if (playbackState == 2) {
                i3++;
            } else if (playbackState == 3) {
                continue;
            } else {
                if (playbackState != 4) {
                    throw new IllegalStateException(String.valueOf(playbackState));
                }
                i4++;
            }
        }
        if (i2 > 0) {
            this.playbackState = 1;
            return;
        }
        if (i3 > 0) {
            this.playbackState = 2;
            if (i == 3 && this.playWhenReady) {
                for (int i6 = 0; i6 < this.playerHolders.size(); i6++) {
                    this.playerHolders.get(i6).player.setPlayWhenReady(false);
                }
                ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).stopRendering();
                return;
            }
            return;
        }
        if (i4 == this.playerHolders.size()) {
            this.playbackState = 4;
            ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).stopRendering();
            return;
        }
        this.playbackState = 3;
        if (i == 3 || !this.playWhenReady) {
            return;
        }
        for (int i7 = 0; i7 < this.playerHolders.size(); i7++) {
            this.playerHolders.get(i7).player.setPlayWhenReady(true);
        }
        ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).startRendering();
    }

    private static MediaSource wrapWithVideoEffectsBasedMediaSources(MediaSource mediaSource, ImmutableList<Effect> immutableList, long j) {
        o46<Effect> it = immutableList.iterator();
        while (it.hasNext()) {
            Effect next = it.next();
            if (next instanceof InactiveTimestampAdjustment) {
                mediaSource = new SpeedChangingMediaSource(mediaSource, ((InactiveTimestampAdjustment) next).speedProvider, j);
            }
        }
        return mediaSource;
    }

    public void experimentalRedrawLastFrame() {
        Assertions.checkState(this.enableReplayableCache);
        HandlerWrapper handlerWrapper = this.playbackThreadHandler;
        if (handlerWrapper == null || this.playbackVideoGraphWrapper == null) {
            return;
        }
        handlerWrapper.post(new Runnable() { // from class: sk0
            @Override // java.lang.Runnable
            public final void run() {
                this.f20765a.lambda$experimentalRedrawLastFrame$0();
            }
        });
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public SimpleBasePlayer.State getState() {
        SimpleBasePlayer.State.Builder playbackSuppressionReason = new SimpleBasePlayer.State.Builder().setAvailableCommands(AVAILABLE_COMMANDS).setPlaybackState(this.playbackState).setPlayerError(this.playbackException).setPlayWhenReady(this.playWhenReady, this.playWhenReadyChangeReason).setRepeatMode(this.repeatMode).setVolume(this.volume).setContentPositionMs(this.positionSupplier).setContentBufferedPositionMs(this.bufferedPositionSupplier).setTotalBufferedDurationMs(this.totalBufferedDurationSupplier).setNewlyRenderedFirstFrame(getRenderedFirstFrameAndReset()).setPlaybackSuppressionReason(this.playbackSuppressionReason);
        if (this.repeatingCompositionSeekInProgress) {
            playbackSuppressionReason.setPositionDiscontinuity(0, -9223372036854775807L);
            this.repeatingCompositionSeekInProgress = false;
        }
        ImmutableList<SimpleBasePlayer.MediaItemData> immutableList = this.playlist;
        if (immutableList != null) {
            playbackSuppressionReason.setPlaylist(immutableList);
        }
        return playbackSuppressionReason.build();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleClearVideoOutput(@Nullable Object obj) {
        Assertions.checkArgument(Objects.equals(obj, this.videoOutput));
        this.videoOutput = null;
        if (this.composition == null) {
            return z42.f();
        }
        removeSurfaceCallbacks();
        clearVideoSurfaceInternal();
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handlePrepare() {
        Assertions.checkStateNotNull(this.composition, "No composition set");
        if (this.playbackState != 1) {
            return z42.f();
        }
        for (int i = 0; i < this.playerHolders.size(); i++) {
            this.playerHolders.get(i).player.prepare();
        }
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleRelease() {
        if (this.composition == null) {
            return z42.f();
        }
        Assertions.checkState(((HandlerThread) Assertions.checkStateNotNull(this.playbackThread)).isAlive());
        for (int i = 0; i < this.playerHolders.size(); i++) {
            this.playerHolders.get(i).player.release();
        }
        ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).release();
        removeSurfaceCallbacks();
        this.compositionInternalListenerHandler.removeCallbacksAndMessages(null);
        this.displaySurface = null;
        ((HandlerThread) Assertions.checkStateNotNull(this.playbackThread)).quitSafely();
        this.applicationHandler.removeCallbacksAndMessages(null);
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleSeek(int i, long j, int i2) {
        resetLivePositionSuppliers();
        CompositionPlayerInternal compositionPlayerInternal = (CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal);
        compositionPlayerInternal.startSeek(j);
        for (int i3 = 0; i3 < this.playerHolders.size(); i3++) {
            this.playerHolders.get(i3).player.seekTo(j);
        }
        compositionPlayerInternal.endSeek();
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleSetPlayWhenReady(boolean z) {
        this.playWhenReady = z;
        this.playWhenReadyChangeReason = 1;
        if (this.playbackState == 3) {
            if (z) {
                ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).startRendering();
            } else {
                ((CompositionPlayerInternal) Assertions.checkStateNotNull(this.compositionPlayerInternal)).stopRendering();
            }
            for (int i = 0; i < this.playerHolders.size(); i++) {
                this.playerHolders.get(i).player.setPlayWhenReady(z);
            }
        }
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleSetRepeatMode(int i) {
        Assertions.checkArgument(i != 1);
        this.repeatMode = i;
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleSetVideoOutput(Object obj) {
        if ((obj instanceof SurfaceHolder) || (obj instanceof SurfaceView)) {
            this.videoOutput = obj;
            return maybeSetVideoOutput();
        }
        throw new UnsupportedOperationException(obj.getClass() + ". Use CompositionPlayer.setVideoSurface() for Surface output.");
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleSetVolume(float f) {
        float fConstrainValue = Util.constrainValue(f, 0.0f, 1.0f);
        this.volume = fConstrainValue;
        CompositionPlayerInternal compositionPlayerInternal = this.compositionPlayerInternal;
        if (compositionPlayerInternal != null) {
            compositionPlayerInternal.setVolume(fConstrainValue);
        }
        return z42.f();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    public r33<?> handleStop() {
        for (int i = 0; i < this.playerHolders.size(); i++) {
            this.playerHolders.get(i).player.stop();
        }
        return z42.f();
    }

    public boolean isScrubbingModeEnabled() {
        return this.scrubbingModeEnabled;
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        this.applicationHandler.post(new Runnable() { // from class: nk0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19524a.lambda$onError$2(videoFrameProcessingException);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void onFirstFrameRendered() {
        this.applicationHandler.post(new Runnable() { // from class: rk0
            @Override // java.lang.Runnable
            public final void run() {
                this.f20495a.lambda$onFirstFrameRendered$1();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public /* synthetic */ void onFrameAvailableForRendering() {
        tj4.c(this);
    }

    public void setComposition(Composition composition) {
        verifyApplicationThread();
        Assertions.checkArgument(!composition.sequences.isEmpty());
        Composition compositionDeactivateSpeedAdjustingVideoEffects = deactivateSpeedAdjustingVideoEffects(composition);
        if (compositionDeactivateSpeedAdjustingVideoEffects.sequences.size() > 1 && !this.videoGraphFactory.supportsMultipleInputs()) {
            Log.w(TAG, "Setting multi-sequence Composition with single input video graph.");
        }
        setCompositionInternal(compositionDeactivateSpeedAdjustingVideoEffects);
        this.composition = compositionDeactivateSpeedAdjustingVideoEffects;
        maybeSetVideoOutput();
    }

    public void setScrubbingModeEnabled(boolean z) {
        this.scrubbingModeEnabled = z;
        for (int i = 0; i < this.playerHolders.size(); i++) {
            this.playerHolders.get(i).player.setScrubbingModeEnabled(z);
        }
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        if (this.playerHolders.isEmpty()) {
            this.pendingVideoFrameMetadatListener = videoFrameMetadataListener;
        } else {
            this.playerHolders.get(0).player.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }
    }

    public void setVideoSurface(Surface surface, Size size) {
        this.videoOutput = surface;
        this.videoOutputSize = size;
        setVideoSurfaceInternal(surface, size);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        maybeSetOutputSurfaceInfo(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.videoOutputSize = new Size(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
        setVideoSurfaceInternal(surfaceHolder.getSurface(), this.videoOutputSize);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        clearVideoSurfaceInternal();
    }

    private CompositionPlayer(Builder builder) {
        super((Looper) Assertions.checkNotNull(builder.looper), builder.clock);
        this.context = builder.context;
        Clock clock = builder.clock;
        this.clock = clock;
        this.applicationHandler = clock.createHandler(builder.looper, null);
        this.finalAudioSink = (AudioSink) Assertions.checkNotNull(builder.audioSink);
        this.mediaSourceFactory = builder.mediaSourceFactory;
        this.imageDecoderFactory = builder.imageDecoderFactory;
        this.videoGraphFactory = (VideoGraph.Factory) Assertions.checkNotNull(builder.videoGraphFactory);
        this.videoPrewarmingEnabled = builder.videoPrewarmingEnabled;
        this.compositionInternalListenerHandler = clock.createHandler(builder.looper, null);
        this.enableReplayableCache = builder.enableReplayableCache;
        this.videoTracksSelected = new SparseBooleanArray();
        this.playerHolders = new ArrayList();
        this.compositionDurationUs = -9223372036854775807L;
        this.playbackState = 1;
        this.volume = 1.0f;
        this.positionSupplier = new SimpleBasePlayer.LivePositionSupplier(new ok0(this));
        this.bufferedPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new pk0(this));
        this.totalBufferedDurationSupplier = new SimpleBasePlayer.LivePositionSupplier(new qk0(this));
    }

    @Override // androidx.media3.transformer.CompositionPlayerInternal.Listener
    public void onError(String str, Exception exc, int i) {
        maybeUpdatePlaybackError(str, exc, i);
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void onFrameDropped() {
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
    }
}
