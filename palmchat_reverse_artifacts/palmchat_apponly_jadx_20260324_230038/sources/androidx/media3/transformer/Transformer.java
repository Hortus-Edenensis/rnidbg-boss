package androidx.media3.transformer;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.muxer.Muxer;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.AudioMixer;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.DefaultAudioMixer;
import androidx.media3.transformer.DefaultDecoderFactory;
import androidx.media3.transformer.DefaultEncoderFactory;
import androidx.media3.transformer.DefaultMuxer;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.EditedMediaItemSequence;
import androidx.media3.transformer.EditingMetricsCollector;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.InAppFragmentedMp4Muxer;
import androidx.media3.transformer.InAppMp4Muxer;
import androidx.media3.transformer.MuxerWrapper;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import androidx.media3.transformer.TransformerInternal;
import androidx.media3.transformer.TransmuxTranscodeHelper;
import androidx.media3.transformer.WatchdogTimer;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.processor.util.EffectConstants;
import defpackage.pj4;
import defpackage.r33;
import defpackage.x42;
import defpackage.z42;
import j$.util.Objects;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Transformer {
    public static final long DEFAULT_MAX_DELAY_BETWEEN_MUXER_SAMPLES_MS;
    private static final String EXPORTER_NAME = "androidx.media3:media3-transformer:1.8.0";
    public static final int PROGRESS_STATE_AVAILABLE = 2;
    public static final int PROGRESS_STATE_NOT_STARTED = 0;
    public static final int PROGRESS_STATE_UNAVAILABLE = 3;
    public static final int PROGRESS_STATE_WAITING_FOR_AVAILABILITY = 1;
    private static final int TRANSFORMER_STATE_COPY_OUTPUT = 4;
    private static final int TRANSFORMER_STATE_PROCESS_AUDIO = 3;
    private static final int TRANSFORMER_STATE_PROCESS_FULL_INPUT = 0;
    private static final int TRANSFORMER_STATE_PROCESS_MEDIA_START = 5;
    private static final int TRANSFORMER_STATE_PROCESS_REMAINING_VIDEO = 2;
    private static final int TRANSFORMER_STATE_REMUX_PROCESSED_VIDEO = 1;
    private static final int TRANSFORMER_STATE_REMUX_REMAINING_MEDIA = 6;
    private final ImmutableList<Integer> allowedEncodingRotationDegrees;
    private final HandlerWrapper applicationHandler;

    @Nullable
    private final AssetLoader.Factory assetLoaderFactory;
    private final AudioMixer.Factory audioMixerFactory;
    private final ImmutableList<AudioProcessor> audioProcessors;
    private final Clock clock;
    private final ComponentListener componentListener;
    private Composition composition;
    private final Context context;
    private r33<Void> copyOutputFuture;
    private final DebugViewProvider debugViewProvider;
    private EditingMetricsCollector editingMetricsCollector;
    private final Codec.EncoderFactory encoderFactory;
    private final ExportResult.Builder exportResultBuilder;

    @Nullable
    private WatchdogTimer exportWatchdogTimer;
    private final boolean fileStartsOnVideoFrameEnabled;
    private r33<TransmuxTranscodeHelper.ResumeMetadata> getResumeMetadataFuture;
    private final ListenerSet<Listener> listeners;
    private final Looper looper;
    private final long maxDelayBetweenMuxerSamplesMs;
    private final int maxFramesInEncoder;

    @Nullable
    private Mp4Info mediaItemInfo;

    @Nullable
    private final EditingMetricsCollector.MetricsReporter.Factory metricsReporterFactory;
    private final boolean mp4EditListTrimEnabled;
    private final Muxer.Factory muxerFactory;
    private String oldFilePath;
    private String outputFilePath;
    private final boolean removeAudio;
    private final boolean removeVideo;

    @Nullable
    private MuxerWrapper remuxingMuxerWrapper;
    private TransmuxTranscodeHelper.ResumeMetadata resumeMetadata;
    private final TransformationRequest transformationRequest;

    @Nullable
    private TransformerInternal transformerInternal;
    private int transformerState;
    private final boolean trimOptimizationEnabled;
    private final boolean usePlatformDiagnostics;
    private final ImmutableList<Effect> videoEffects;
    private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private static final ImmutableList<Integer> ALL_ROTATION_DEGREES = ImmutableList.of(0, 90, (int) Integer.valueOf(EffectConstants.ROTATION_DEGREES_180), 270);
        private ImmutableList<Integer> allowedEncodingRotationDegrees;
        private AssetLoader.Factory assetLoaderFactory;
        private String audioMimeType;
        private AudioMixer.Factory audioMixerFactory;
        private final ImmutableList<AudioProcessor> audioProcessors;
        private Clock clock;
        private final Context context;
        private DebugViewProvider debugViewProvider;
        private Codec.EncoderFactory encoderFactory;
        private boolean fileStartsOnVideoFrameEnabled;
        private ListenerSet<Listener> listeners;
        private Looper looper;
        private long maxDelayBetweenMuxerSamplesMs;
        private int maxFramesInEncoder;
        private EditingMetricsCollector.MetricsReporter.Factory metricsReporterFactory;
        private boolean mp4EditListTrimEnabled;
        private Muxer.Factory muxerFactory;
        private boolean removeAudio;
        private boolean removeVideo;
        private TransformationRequest transformationRequest;
        private boolean trimOptimizationEnabled;
        private boolean usePlatformDiagnostics;
        private final ImmutableList<Effect> videoEffects;
        private VideoFrameProcessor.Factory videoFrameProcessorFactory;
        private String videoMimeType;

        private void checkSampleMimeType(String str) {
            Assertions.checkState(this.muxerFactory.getSupportedSampleMimeTypes(MimeTypes.getTrackType(str)).contains(str), "Unsupported sample MIME type " + str);
        }

        public Builder addListener(Listener listener) {
            this.listeners.add(listener);
            return this;
        }

        public Transformer build() {
            TransformationRequest transformationRequest = this.transformationRequest;
            TransformationRequest.Builder builder = transformationRequest == null ? new TransformationRequest.Builder() : transformationRequest.buildUpon();
            String str = this.audioMimeType;
            if (str != null) {
                builder.setAudioMimeType(str);
            }
            String str2 = this.videoMimeType;
            if (str2 != null) {
                builder.setVideoMimeType(str2);
            }
            TransformationRequest transformationRequestBuild = builder.build();
            this.transformationRequest = transformationRequestBuild;
            String str3 = transformationRequestBuild.audioMimeType;
            if (str3 != null) {
                checkSampleMimeType(str3);
            }
            String str4 = this.transformationRequest.videoMimeType;
            if (str4 != null) {
                checkSampleMimeType(str4);
            }
            Assertions.checkState(!this.mp4EditListTrimEnabled || this.muxerFactory.supportsWritingNegativeTimestampsInEditList(), String.format("Muxer.Factory %s does not support writing negative timestamps to an edit list.", this.muxerFactory));
            return new Transformer(this.context, this.transformationRequest, this.audioProcessors, this.videoEffects, this.removeAudio, this.removeVideo, this.trimOptimizationEnabled, this.mp4EditListTrimEnabled, this.allowedEncodingRotationDegrees, this.fileStartsOnVideoFrameEnabled, this.usePlatformDiagnostics, this.maxDelayBetweenMuxerSamplesMs, this.maxFramesInEncoder, this.listeners, this.assetLoaderFactory, this.audioMixerFactory, this.videoFrameProcessorFactory, this.encoderFactory, this.muxerFactory, this.looper, this.debugViewProvider, this.clock, this.metricsReporterFactory);
        }

        public Builder experimentalSetMaxFramesInEncoder(int i) {
            Assertions.checkArgument(i > 0 || i == -1);
            this.maxFramesInEncoder = i;
            return this;
        }

        public Builder experimentalSetMp4EditListTrimEnabled(boolean z) {
            this.mp4EditListTrimEnabled = z;
            return this;
        }

        public Builder experimentalSetTrimOptimizationEnabled(boolean z) {
            this.trimOptimizationEnabled = z;
            return this;
        }

        public Builder removeAllListeners() {
            this.listeners.clear();
            return this;
        }

        public Builder removeListener(Listener listener) {
            this.listeners.remove(listener);
            return this;
        }

        public Builder setAssetLoaderFactory(AssetLoader.Factory factory) {
            this.assetLoaderFactory = factory;
            return this;
        }

        public Builder setAudioMimeType(String str) {
            String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
            Assertions.checkArgument(MimeTypes.isAudio(strNormalizeMimeType), "Not an audio MIME type: " + strNormalizeMimeType);
            this.audioMimeType = strNormalizeMimeType;
            return this;
        }

        public Builder setAudioMixerFactory(AudioMixer.Factory factory) {
            this.audioMixerFactory = factory;
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            this.clock = clock;
            this.listeners = this.listeners.copy(this.looper, clock, new ListenerSet.IterationFinishedEvent() { // from class: c16
                @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
                public final void invoke(Object obj, FlagSet flagSet) {
                    Transformer.Builder.lambda$setClock$2((Transformer.Listener) obj, flagSet);
                }
            });
            return this;
        }

        public Builder setDebugViewProvider(DebugViewProvider debugViewProvider) {
            this.debugViewProvider = debugViewProvider;
            return this;
        }

        public Builder setEncoderFactory(Codec.EncoderFactory encoderFactory) {
            this.encoderFactory = encoderFactory;
            return this;
        }

        public Builder setEnsureFileStartsOnVideoFrameEnabled(boolean z) {
            this.fileStartsOnVideoFrameEnabled = z;
            return this;
        }

        public Builder setLooper(Looper looper) {
            this.looper = looper;
            this.listeners = this.listeners.copy(looper, new ListenerSet.IterationFinishedEvent() { // from class: e16
                @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
                public final void invoke(Object obj, FlagSet flagSet) {
                    Transformer.Builder.lambda$setLooper$1((Transformer.Listener) obj, flagSet);
                }
            });
            return this;
        }

        public Builder setMaxDelayBetweenMuxerSamplesMs(long j) {
            this.maxDelayBetweenMuxerSamplesMs = j;
            return this;
        }

        @VisibleForTesting
        public Builder setMetricsReporterFactory(EditingMetricsCollector.MetricsReporter.Factory factory) {
            this.metricsReporterFactory = factory;
            return this;
        }

        public Builder setMuxerFactory(Muxer.Factory factory) {
            this.muxerFactory = factory;
            return this;
        }

        public Builder setPortraitEncodingEnabled(boolean z) {
            this.allowedEncodingRotationDegrees = z ? ImmutableList.of(0) : ALL_ROTATION_DEGREES;
            return this;
        }

        public Builder setUsePlatformDiagnostics(boolean z) {
            this.usePlatformDiagnostics = z;
            return this;
        }

        public Builder setVideoFrameProcessorFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
            return this;
        }

        public Builder setVideoMimeType(String str) {
            String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
            Assertions.checkArgument(MimeTypes.isVideo(strNormalizeMimeType), "Not a video MIME type: " + strNormalizeMimeType);
            this.videoMimeType = strNormalizeMimeType;
            return this;
        }

        public Builder(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.context = applicationContext;
            this.maxDelayBetweenMuxerSamplesMs = Transformer.DEFAULT_MAX_DELAY_BETWEEN_MUXER_SAMPLES_MS;
            this.maxFramesInEncoder = -1;
            this.audioProcessors = ImmutableList.of();
            this.videoEffects = ImmutableList.of();
            this.audioMixerFactory = new DefaultAudioMixer.Factory();
            this.videoFrameProcessorFactory = new DefaultVideoFrameProcessor.Factory.Builder().build();
            this.encoderFactory = new DefaultEncoderFactory.Builder(applicationContext).build();
            this.muxerFactory = new DefaultMuxer.Factory();
            Looper currentOrMainLooper = Util.getCurrentOrMainLooper();
            this.looper = currentOrMainLooper;
            this.debugViewProvider = DebugViewProvider.NONE;
            Clock clock = Clock.DEFAULT;
            this.clock = clock;
            this.listeners = new ListenerSet<>(currentOrMainLooper, clock, new ListenerSet.IterationFinishedEvent() { // from class: d16
                @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
                public final void invoke(Object obj, FlagSet flagSet) {
                    Transformer.Builder.lambda$new$0((Transformer.Listener) obj, flagSet);
                }
            });
            if (Build.VERSION.SDK_INT >= 35) {
                this.usePlatformDiagnostics = true;
                this.metricsReporterFactory = new EditingMetricsCollector.DefaultMetricsReporter.Factory(context);
            }
            this.allowedEncodingRotationDegrees = ALL_ROTATION_DEGREES;
        }

        private Builder(Transformer transformer) {
            this.context = transformer.context;
            this.audioMimeType = transformer.transformationRequest.audioMimeType;
            this.videoMimeType = transformer.transformationRequest.videoMimeType;
            this.transformationRequest = transformer.transformationRequest;
            this.audioProcessors = transformer.audioProcessors;
            this.videoEffects = transformer.videoEffects;
            this.removeAudio = transformer.removeAudio;
            this.removeVideo = transformer.removeVideo;
            this.trimOptimizationEnabled = transformer.trimOptimizationEnabled;
            this.mp4EditListTrimEnabled = transformer.mp4EditListTrimEnabled;
            this.allowedEncodingRotationDegrees = transformer.allowedEncodingRotationDegrees;
            this.fileStartsOnVideoFrameEnabled = transformer.fileStartsOnVideoFrameEnabled;
            this.usePlatformDiagnostics = transformer.usePlatformDiagnostics;
            this.maxDelayBetweenMuxerSamplesMs = transformer.maxDelayBetweenMuxerSamplesMs;
            this.maxFramesInEncoder = transformer.maxFramesInEncoder;
            this.listeners = transformer.listeners;
            this.assetLoaderFactory = transformer.assetLoaderFactory;
            this.audioMixerFactory = transformer.audioMixerFactory;
            this.videoFrameProcessorFactory = transformer.videoFrameProcessorFactory;
            this.encoderFactory = transformer.encoderFactory;
            this.muxerFactory = transformer.muxerFactory;
            this.looper = transformer.looper;
            this.debugViewProvider = transformer.debugViewProvider;
            this.clock = transformer.clock;
            this.metricsReporterFactory = transformer.metricsReporterFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(Listener listener, FlagSet flagSet) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setClock$2(Listener listener, FlagSet flagSet) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setLooper$1(Listener listener, FlagSet flagSet) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onCompleted(Composition composition, ExportResult exportResult);

        void onError(Composition composition, ExportResult exportResult, ExportException exportException);

        void onFallbackApplied(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressState {
    }

    static {
        MediaLibraryInfo.registerModule("media3.transformer");
        DEFAULT_MAX_DELAY_BETWEEN_MUXER_SAMPLES_MS = Util.isRunningOnEmulator() ? 25000L : 10000L;
    }

    private boolean canCollectEditingMetrics() {
        return Build.VERSION.SDK_INT >= 35 && this.usePlatformDiagnostics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyOutput() {
        this.transformerState = 4;
        r33<Void> r33VarCopyFileAsync = TransmuxTranscodeHelper.copyFileAsync(new File((String) Assertions.checkNotNull(this.oldFilePath)), new File((String) Assertions.checkNotNull(this.outputFilePath)));
        this.copyOutputFuture = r33VarCopyFileAsync;
        x42<Void> x42Var = new x42<Void>() { // from class: androidx.media3.transformer.Transformer.2
            @Override // defpackage.x42
            public void onFailure(Throwable th) {
                Transformer.this.onExportCompletedWithError(ExportException.createForUnexpected(new IOException("Copy output task failed for the resumed export", th)));
            }

            @Override // defpackage.x42
            public void onSuccess(Void r1) {
                Transformer.this.onExportCompletedWithSuccess();
            }
        };
        HandlerWrapper handlerWrapper = this.applicationHandler;
        Objects.requireNonNull(handlerWrapper);
        z42.a(r33VarCopyFileAsync, x42Var, new pj4(handlerWrapper));
    }

    private int getTrimOptimizationProgress(ProgressHolder progressHolder) {
        int progress;
        if (this.mediaItemInfo == null) {
            return 1;
        }
        long j = ((Composition) Assertions.checkNotNull(this.composition)).sequences.get(0).editedMediaItems.get(0).mediaItem.clippingConfiguration.startPositionUs;
        Mp4Info mp4Info = this.mediaItemInfo;
        float f = (mp4Info.firstSyncSampleTimestampUsAfterTimeUs - j) / mp4Info.durationUs;
        if (this.transformerState == 5) {
            TransformerInternal transformerInternal = this.transformerInternal;
            if (transformerInternal == null || (progress = transformerInternal.getProgress(progressHolder)) == 0 || progress == 1) {
                return 1;
            }
            if (progress == 2) {
                progressHolder.progress = Math.round(progressHolder.progress * f);
                return 2;
            }
            if (progress == 3) {
                return 3;
            }
            throw new IllegalStateException();
        }
        float f2 = 100.0f * f;
        TransformerInternal transformerInternal2 = this.transformerInternal;
        if (transformerInternal2 == null) {
            progressHolder.progress = Math.round(f2);
            return 2;
        }
        int progress2 = transformerInternal2.getProgress(progressHolder);
        if (progress2 == 0 || progress2 == 1) {
            progressHolder.progress = Math.round(f2);
            return 2;
        }
        if (progress2 == 2) {
            progressHolder.progress = Math.round(f2 + ((1.0f - f) * progressHolder.progress));
            return 2;
        }
        if (progress2 == 3) {
            return 3;
        }
        throw new IllegalStateException();
    }

    private void initialize(Composition composition, String str) {
        maybeInitializeExportWatchdogTimer();
        this.composition = composition;
        this.outputFilePath = str;
        this.exportResultBuilder.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExportResumed() {
        int i = this.transformerState;
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExportTrimOptimization() {
        int i = this.transformerState;
        return i == 5 || i == 6;
    }

    private boolean isMultiAsset() {
        return ((Composition) Assertions.checkNotNull(this.composition)).sequences.size() > 1 || this.composition.sequences.get(0).editedMediaItems.size() > 1;
    }

    private boolean isSingleAssetTrimming() {
        if (isMultiAsset()) {
            return false;
        }
        return !((Composition) Assertions.checkNotNull(this.composition)).sequences.get(0).editedMediaItems.get(0).mediaItem.clippingConfiguration.equals(MediaItem.ClippingConfiguration.UNSET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeInitializeExportWatchdogTimer$0() {
        ((TransformerInternal) Assertions.checkNotNull(this.transformerInternal)).endWithException(ExportException.createForMuxer(new IllegalStateException(Util.formatInvariant("Abort: no output sample written in the last %d milliseconds. DebugTrace: %s", Long.valueOf(this.maxDelayBetweenMuxerSamplesMs), DebugTraceUtil.generateTraceSummary())), ExportException.ERROR_CODE_MUXING_TIMEOUT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onExportCompletedWithError$2(ExportResult exportResult, ExportException exportException, Listener listener) {
        listener.onError((Composition) Assertions.checkNotNull(this.composition), exportResult, exportException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onExportCompletedWithSuccess$1(ExportResult exportResult, Listener listener) {
        listener.onCompleted((Composition) Assertions.checkNotNull(this.composition), exportResult);
    }

    private void maybeInitializeExportWatchdogTimer() {
        long j = this.maxDelayBetweenMuxerSamplesMs;
        if (j == -9223372036854775807L) {
            return;
        }
        WatchdogTimer watchdogTimer = new WatchdogTimer(j, new WatchdogTimer.Listener() { // from class: z06
            @Override // androidx.media3.transformer.WatchdogTimer.Listener
            public final void onTimeout() {
                this.f22314a.lambda$maybeInitializeExportWatchdogTimer$0();
            }
        });
        this.exportWatchdogTimer = watchdogTimer;
        watchdogTimer.start();
    }

    private void maybeStopExportWatchdogTimer() {
        WatchdogTimer watchdogTimer = this.exportWatchdogTimer;
        if (watchdogTimer != null) {
            watchdogTimer.stop();
            this.exportWatchdogTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExportCompletedWithError(final ExportException exportException) {
        maybeStopExportWatchdogTimer();
        final ExportResult exportResultBuild = this.exportResultBuilder.build();
        this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: b16
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                this.f1626a.lambda$onExportCompletedWithError$2(exportResultBuild, exportException, (Transformer.Listener) obj);
            }
        });
        this.listeners.flushEvents();
        if (canCollectEditingMetrics()) {
            ProgressHolder progressHolder = new ProgressHolder();
            ((EditingMetricsCollector) Assertions.checkNotNull(this.editingMetricsCollector)).onExportError(getProgress(progressHolder) == 2 ? progressHolder.progress : -1, exportException, exportResultBuild);
        }
        this.transformerState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExportCompletedWithSuccess() {
        maybeStopExportWatchdogTimer();
        final ExportResult exportResultBuild = this.exportResultBuilder.build();
        this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: a16
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                this.f1137a.lambda$onExportCompletedWithSuccess$1(exportResultBuild, (Transformer.Listener) obj);
            }
        });
        this.listeners.flushEvents();
        if (canCollectEditingMetrics()) {
            ((EditingMetricsCollector) Assertions.checkNotNull(this.editingMetricsCollector)).onExportSuccess(exportResultBuild);
        }
        this.transformerState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAudio() {
        this.transformerState = 3;
        startInternal(TransmuxTranscodeHelper.createAudioTranscodeAndVideoTransmuxComposition((Composition) Assertions.checkNotNull(this.composition), (String) Assertions.checkNotNull(this.outputFilePath)), new MuxerWrapper((String) Assertions.checkNotNull(this.oldFilePath), this.muxerFactory, this.componentListener, 0, false, null, shouldApplyMp4EditListTrim()), this.componentListener, 0L, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFullInput() {
        this.transformerState = 0;
        startInternal((Composition) Assertions.checkNotNull(this.composition), new MuxerWrapper((String) Assertions.checkNotNull(this.outputFilePath), this.muxerFactory, this.componentListener, 0, false, null, false), this.componentListener, 0L, false);
    }

    private void processMediaBeforeFirstSyncSampleAfterTrimStartTime() {
        this.transformerState = 5;
        final EditedMediaItem editedMediaItem = ((Composition) Assertions.checkNotNull(this.composition)).sequences.get(0).editedMediaItems.get(0);
        MediaItem mediaItem = editedMediaItem.mediaItem;
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.clippingConfiguration;
        final long j = clippingConfiguration.startPositionUs;
        final long j2 = clippingConfiguration.endPositionUs;
        r33<Mp4Info> mp4Info = TransmuxTranscodeHelper.getMp4Info(this.context, ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri.toString(), j);
        x42<Mp4Info> x42Var = new x42<Mp4Info>() { // from class: androidx.media3.transformer.Transformer.3
            @Override // defpackage.x42
            public void onFailure(Throwable th) {
                Transformer.this.exportResultBuilder.setOptimizationResult(5);
                Transformer.this.processFullInput();
            }

            @Override // defpackage.x42
            public void onSuccess(Mp4Info mp4Info2) {
                Format format;
                int i;
                long j3 = mp4Info2.firstSyncSampleTimestampUsAfterTimeUs;
                if (j3 == -9223372036854775807L) {
                    Transformer.this.exportResultBuilder.setOptimizationResult(4);
                    Transformer.this.processFullInput();
                    return;
                }
                if (j3 != Long.MIN_VALUE) {
                    long j4 = j2;
                    if (j4 == Long.MIN_VALUE || j4 >= j3) {
                        Format format2 = mp4Info2.audioFormat;
                        long jSampleCountToDurationUs = (format2 == null || (i = format2.sampleRate) == -1) ? 0L : Util.sampleCountToDurationUs(1024L, i);
                        long j5 = mp4Info2.firstSyncSampleTimestampUsAfterTimeUs;
                        if (j5 == mp4Info2.firstVideoSampleTimestampUs) {
                            Transformer transformer = Transformer.this;
                            transformer.composition = TransmuxTranscodeHelper.buildUponCompositionForTrimOptimization(transformer.composition, j, j2, mp4Info2.durationUs, true, false);
                            Transformer.this.exportResultBuilder.setOptimizationResult(2);
                            Transformer.this.processFullInput();
                            return;
                        }
                        if (j5 - j <= jSampleCountToDurationUs || mp4Info2.isFirstVideoSampleAfterTimeUsSyncSample) {
                            Transformer transformer2 = Transformer.this;
                            transformer2.composition = TransmuxTranscodeHelper.buildUponCompositionForTrimOptimization(transformer2.composition, mp4Info2.firstSyncSampleTimestampUsAfterTimeUs, j2, mp4Info2.durationUs, true, false);
                            Transformer.this.exportResultBuilder.setOptimizationResult(2);
                            Transformer.this.processFullInput();
                            return;
                        }
                        Transformer.this.remuxingMuxerWrapper = new MuxerWrapper((String) Assertions.checkNotNull(Transformer.this.outputFilePath), Transformer.this.muxerFactory, Transformer.this.componentListener, 1, false, mp4Info2.videoFormat, false);
                        if (TransformerUtil.shouldTranscodeVideo((Format) Assertions.checkNotNull(mp4Info2.videoFormat), Transformer.this.composition, 0, Transformer.this.transformationRequest, Transformer.this.encoderFactory, Transformer.this.remuxingMuxerWrapper) || ((format = mp4Info2.audioFormat) != null && TransformerUtil.shouldTranscodeAudio(format, Transformer.this.composition, 0, Transformer.this.transformationRequest, Transformer.this.encoderFactory, Transformer.this.remuxingMuxerWrapper))) {
                            Transformer.this.remuxingMuxerWrapper = null;
                            Transformer.this.exportResultBuilder.setOptimizationResult(3);
                            Transformer.this.processFullInput();
                            return;
                        } else {
                            Transformer.this.mediaItemInfo = mp4Info2;
                            TransformerUtil.maybeSetMuxerWrapperAdditionalRotationDegrees(Transformer.this.remuxingMuxerWrapper, editedMediaItem.effects.videoEffects, (Format) Assertions.checkNotNull(mp4Info2.videoFormat));
                            Composition compositionBuildUponCompositionForTrimOptimization = TransmuxTranscodeHelper.buildUponCompositionForTrimOptimization(Transformer.this.composition, j, mp4Info2.firstSyncSampleTimestampUsAfterTimeUs, mp4Info2.durationUs, false, true);
                            Transformer transformer3 = Transformer.this;
                            transformer3.startInternal(compositionBuildUponCompositionForTrimOptimization, (MuxerWrapper) Assertions.checkNotNull(transformer3.remuxingMuxerWrapper), Transformer.this.componentListener, 0L, false);
                            return;
                        }
                    }
                }
                Transformer.this.exportResultBuilder.setOptimizationResult(2);
                Transformer.this.processFullInput();
            }
        };
        HandlerWrapper handlerWrapper = this.applicationHandler;
        Objects.requireNonNull(handlerWrapper);
        z42.a(mp4Info, x42Var, new pj4(handlerWrapper));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRemainingVideo() {
        this.transformerState = 2;
        Composition compositionBuildUponComposition = TransmuxTranscodeHelper.buildUponComposition((Composition) Assertions.checkNotNull(this.composition), true, false, this.resumeMetadata);
        Assertions.checkNotNull(this.remuxingMuxerWrapper);
        this.remuxingMuxerWrapper.changeToAppendMode();
        startInternal(compositionBuildUponComposition, this.remuxingMuxerWrapper, this.componentListener, ((TransmuxTranscodeHelper.ResumeMetadata) Assertions.checkNotNull(this.resumeMetadata)).lastSyncSampleTimestampUs, false);
    }

    private void remuxProcessedVideo() {
        this.transformerState = 1;
        r33<TransmuxTranscodeHelper.ResumeMetadata> resumeMetadataAsync = TransmuxTranscodeHelper.getResumeMetadataAsync(this.context, (String) Assertions.checkNotNull(this.oldFilePath), (Composition) Assertions.checkNotNull(this.composition));
        this.getResumeMetadataFuture = resumeMetadataAsync;
        x42<TransmuxTranscodeHelper.ResumeMetadata> x42Var = new x42<TransmuxTranscodeHelper.ResumeMetadata>() { // from class: androidx.media3.transformer.Transformer.1
            @Override // defpackage.x42
            public void onFailure(Throwable th) {
                Transformer.this.processFullInput();
            }

            @Override // defpackage.x42
            public void onSuccess(TransmuxTranscodeHelper.ResumeMetadata resumeMetadata) {
                long j = resumeMetadata.lastSyncSampleTimestampUs;
                if (j == -9223372036854775807L || j == 0) {
                    Transformer.this.processFullInput();
                    return;
                }
                Transformer.this.resumeMetadata = resumeMetadata;
                Transformer.this.remuxingMuxerWrapper = new MuxerWrapper((String) Assertions.checkNotNull(Transformer.this.outputFilePath), Transformer.this.muxerFactory, Transformer.this.componentListener, 1, false, resumeMetadata.videoFormat, false);
                Transformer transformer = Transformer.this;
                transformer.startInternal(TransmuxTranscodeHelper.createVideoOnlyComposition(transformer.oldFilePath, resumeMetadata.lastSyncSampleTimestampUs), (MuxerWrapper) Assertions.checkNotNull(Transformer.this.remuxingMuxerWrapper), Transformer.this.componentListener, 0L, true);
            }
        };
        HandlerWrapper handlerWrapper = this.applicationHandler;
        Objects.requireNonNull(handlerWrapper);
        z42.a(resumeMetadataAsync, x42Var, new pj4(handlerWrapper));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remuxRemainingMedia() {
        this.transformerState = 6;
        EditedMediaItem editedMediaItem = ((Composition) Assertions.checkNotNull(this.composition)).sequences.get(0).editedMediaItems.get(0);
        Mp4Info mp4Info = (Mp4Info) Assertions.checkNotNull(this.mediaItemInfo);
        MediaItem.ClippingConfiguration clippingConfiguration = editedMediaItem.mediaItem.clippingConfiguration;
        long j = clippingConfiguration.startPositionUs;
        Composition compositionBuildUponCompositionForTrimOptimization = TransmuxTranscodeHelper.buildUponCompositionForTrimOptimization(this.composition, mp4Info.firstSyncSampleTimestampUsAfterTimeUs, clippingConfiguration.endPositionUs, mp4Info.durationUs, true, true);
        Assertions.checkNotNull(this.remuxingMuxerWrapper);
        this.remuxingMuxerWrapper.changeToAppendMode();
        startInternal(compositionBuildUponCompositionForTrimOptimization, this.remuxingMuxerWrapper, this.componentListener, mp4Info.firstSyncSampleTimestampUsAfterTimeUs - j, false);
    }

    private boolean shouldApplyMp4EditListTrim() {
        return this.mp4EditListTrimEnabled && isSingleAssetTrimming();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal(Composition composition, MuxerWrapper muxerWrapper, ComponentListener componentListener, long j, boolean z) {
        Assertions.checkState(this.transformerInternal == null, "There is already an export in progress.");
        TransformationRequest transformationRequestBuild = this.transformationRequest;
        if (composition.hdrMode != 0) {
            transformationRequestBuild = transformationRequestBuild.buildUpon().setHdrMode(composition.hdrMode).build();
        }
        TransformationRequest transformationRequest = transformationRequestBuild;
        if (canCollectEditingMetrics()) {
            Muxer.Factory factory = this.muxerFactory;
            String str = "androidx.media3:media3-muxer:1.8.0";
            if (!(factory instanceof InAppMp4Muxer.Factory) && !(factory instanceof InAppFragmentedMp4Muxer.Factory)) {
                str = factory instanceof DefaultMuxer.Factory ? DefaultMuxer.MUXER_NAME : null;
            }
            EditingMetricsCollector.MetricsReporter metricsReporterCreate = ((EditingMetricsCollector.MetricsReporter.Factory) Assertions.checkNotNull(this.metricsReporterFactory)).create();
            logSessionId = metricsReporterCreate instanceof EditingMetricsCollector.DefaultMetricsReporter ? ((EditingMetricsCollector.DefaultMetricsReporter) metricsReporterCreate).getLogSessionId() : null;
            this.editingMetricsCollector = new EditingMetricsCollector(metricsReporterCreate, EXPORTER_NAME, str);
        }
        LogSessionId logSessionId = logSessionId;
        FallbackListener fallbackListener = new FallbackListener(composition, this.listeners, this.applicationHandler, transformationRequest);
        AssetLoader.Factory defaultAssetLoaderFactory = this.assetLoaderFactory;
        if (z || defaultAssetLoaderFactory == null) {
            Context context = this.context;
            defaultAssetLoaderFactory = new DefaultAssetLoaderFactory(context, new DefaultDecoderFactory.Builder(context).build(), this.clock, logSessionId);
        }
        DebugTraceUtil.reset();
        TransformerInternal transformerInternal = new TransformerInternal(this.context, composition, transformationRequest, defaultAssetLoaderFactory, this.audioMixerFactory, this.videoFrameProcessorFactory, this.encoderFactory, this.allowedEncodingRotationDegrees, this.maxFramesInEncoder, muxerWrapper, componentListener, fallbackListener, this.applicationHandler, this.debugViewProvider, this.clock, j, logSessionId, shouldApplyMp4EditListTrim());
        this.transformerInternal = transformerInternal;
        transformerInternal.start();
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != this.looper) {
            throw new IllegalStateException("Transformer is accessed on the wrong thread.");
        }
    }

    public void addListener(Listener listener) {
        verifyApplicationThread();
        this.listeners.add(listener);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public void cancel() {
        verifyApplicationThread();
        TransformerInternal transformerInternal = this.transformerInternal;
        if (transformerInternal == null) {
            maybeStopExportWatchdogTimer();
            return;
        }
        try {
            transformerInternal.cancel();
            r33<TransmuxTranscodeHelper.ResumeMetadata> r33Var = this.getResumeMetadataFuture;
            if (r33Var != null && !r33Var.isDone()) {
                this.getResumeMetadataFuture.cancel(false);
            }
            r33<Void> r33Var2 = this.copyOutputFuture;
            if (r33Var2 != null && !r33Var2.isDone()) {
                this.copyOutputFuture.cancel(false);
            }
            maybeStopExportWatchdogTimer();
        } finally {
            ProgressHolder progressHolder = new ProgressHolder();
            int progress = getProgress(progressHolder);
            this.transformerInternal = null;
            if (canCollectEditingMetrics()) {
                ((EditingMetricsCollector) Assertions.checkNotNull(this.editingMetricsCollector)).onExportCancelled(progress == 2 ? progressHolder.progress : -1);
            }
        }
    }

    public Looper getApplicationLooper() {
        return this.looper;
    }

    public int getProgress(ProgressHolder progressHolder) {
        verifyApplicationThread();
        if (isExportResumed()) {
            return 3;
        }
        if (isExportTrimOptimization()) {
            return getTrimOptimizationProgress(progressHolder);
        }
        TransformerInternal transformerInternal = this.transformerInternal;
        if (transformerInternal == null) {
            return 0;
        }
        return transformerInternal.getProgress(progressHolder);
    }

    public void removeAllListeners() {
        verifyApplicationThread();
        this.listeners.clear();
    }

    public void removeListener(Listener listener) {
        verifyApplicationThread();
        this.listeners.remove(listener);
    }

    public void resume(Composition composition, String str, String str2) {
        verifyApplicationThread();
        initialize(composition, str);
        this.oldFilePath = str2;
        remuxProcessedVideo();
    }

    public void start(Composition composition, String str) {
        verifyApplicationThread();
        initialize(composition, str);
        if (this.trimOptimizationEnabled && isSingleAssetTrimming()) {
            processMediaBeforeFirstSyncSampleAfterTrimStartTime();
        } else {
            startInternal(composition, new MuxerWrapper(str, this.muxerFactory, this.componentListener, 0, this.fileStartsOnVideoFrameEnabled, null, shouldApplyMp4EditListTrim()), this.componentListener, 0L, false);
        }
    }

    private Transformer(Context context, TransformationRequest transformationRequest, ImmutableList<AudioProcessor> immutableList, ImmutableList<Effect> immutableList2, boolean z, boolean z2, boolean z3, boolean z4, ImmutableList<Integer> immutableList3, boolean z5, boolean z6, long j, int i, ListenerSet<Listener> listenerSet, @Nullable AssetLoader.Factory factory, AudioMixer.Factory factory2, VideoFrameProcessor.Factory factory3, Codec.EncoderFactory encoderFactory, Muxer.Factory factory4, Looper looper, DebugViewProvider debugViewProvider, Clock clock, @Nullable EditingMetricsCollector.MetricsReporter.Factory factory5) {
        Assertions.checkState((z && z2) ? false : true, "Audio and video cannot both be removed.");
        this.context = context;
        this.transformationRequest = transformationRequest;
        this.audioProcessors = immutableList;
        this.videoEffects = immutableList2;
        this.removeAudio = z;
        this.removeVideo = z2;
        this.trimOptimizationEnabled = z3;
        this.mp4EditListTrimEnabled = z4;
        this.allowedEncodingRotationDegrees = immutableList3;
        this.fileStartsOnVideoFrameEnabled = z5;
        this.usePlatformDiagnostics = z6;
        this.maxDelayBetweenMuxerSamplesMs = j;
        this.maxFramesInEncoder = i;
        this.listeners = listenerSet;
        this.assetLoaderFactory = factory;
        this.audioMixerFactory = factory2;
        this.videoFrameProcessorFactory = factory3;
        this.encoderFactory = encoderFactory;
        this.muxerFactory = factory4;
        this.looper = looper;
        this.debugViewProvider = debugViewProvider;
        this.clock = clock;
        this.metricsReporterFactory = factory5;
        this.transformerState = 0;
        this.applicationHandler = clock.createHandler(looper, null);
        this.componentListener = new ComponentListener();
        this.exportResultBuilder = new ExportResult.Builder();
    }

    public void start(EditedMediaItem editedMediaItem, String str) {
        start(new Composition.Builder(new EditedMediaItemSequence.Builder(editedMediaItem).build(), new EditedMediaItemSequence[0]).build(), str);
    }

    public void start(MediaItem mediaItem, String str) {
        start(new EditedMediaItem.Builder(mediaItem).setRemoveAudio(this.removeAudio).setRemoveVideo(this.removeVideo).setEffects(new Effects(this.audioProcessors, this.videoEffects)).build(), str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class ComponentListener implements TransformerInternal.Listener, MuxerWrapper.Listener {
        private ComponentListener() {
        }

        @Override // androidx.media3.transformer.TransformerInternal.Listener
        public void onCompleted(ImmutableList<ExportResult.ProcessedInput> immutableList, @Nullable String str, @Nullable String str2) {
            Transformer.this.exportResultBuilder.addProcessedInputs(immutableList);
            if (str != null) {
                Transformer.this.exportResultBuilder.setAudioEncoderName(str);
            }
            if (str2 != null) {
                Transformer.this.exportResultBuilder.setVideoEncoderName(str2);
            }
            Transformer.this.transformerInternal = null;
            if (Transformer.this.transformerState == 1) {
                Transformer.this.processRemainingVideo();
                return;
            }
            if (Transformer.this.transformerState == 2) {
                Transformer.this.remuxingMuxerWrapper = null;
                Transformer.this.processAudio();
                return;
            }
            if (Transformer.this.transformerState == 3) {
                Transformer.this.copyOutput();
                return;
            }
            if (Transformer.this.transformerState == 5) {
                Transformer.this.remuxRemainingMedia();
            } else {
                if (Transformer.this.transformerState != 6) {
                    Transformer.this.onExportCompletedWithSuccess();
                    return;
                }
                Transformer.this.mediaItemInfo = null;
                Transformer.this.exportResultBuilder.setOptimizationResult(1);
                Transformer.this.onExportCompletedWithSuccess();
            }
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void onEnded(long j, long j2) {
            Transformer.this.exportResultBuilder.setDurationMs(j).setFileSizeBytes(j2);
            ((TransformerInternal) Assertions.checkNotNull(Transformer.this.transformerInternal)).endWithCompletion();
        }

        @Override // androidx.media3.transformer.TransformerInternal.Listener
        public void onError(ImmutableList<ExportResult.ProcessedInput> immutableList, @Nullable String str, @Nullable String str2, ExportException exportException) {
            if (exportException.errorCode == 7003 && (Transformer.this.isExportTrimOptimization() || Transformer.this.isExportResumed())) {
                Transformer.this.remuxingMuxerWrapper = null;
                Transformer.this.transformerInternal = null;
                Transformer.this.exportResultBuilder.reset();
                Transformer.this.exportResultBuilder.setOptimizationResult(6);
                Transformer.this.processFullInput();
                return;
            }
            Transformer.this.exportResultBuilder.addProcessedInputs(immutableList);
            if (str != null) {
                Transformer.this.exportResultBuilder.setAudioEncoderName(str);
            }
            if (str2 != null) {
                Transformer.this.exportResultBuilder.setVideoEncoderName(str2);
            }
            Transformer.this.exportResultBuilder.setExportException(exportException);
            Transformer.this.onExportCompletedWithError(exportException);
            Transformer.this.transformerInternal = null;
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void onSampleWrittenOrDropped() {
            if (Transformer.this.exportWatchdogTimer != null) {
                Transformer.this.exportWatchdogTimer.reset();
            } else {
                Assertions.checkState(Transformer.this.maxDelayBetweenMuxerSamplesMs == -9223372036854775807L);
            }
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void onTrackEnded(int i, Format format, int i2, int i3) {
            if (i == 1) {
                Transformer.this.exportResultBuilder.setAudioMimeType(format.sampleMimeType).setAverageAudioBitrate(i2);
                if (format.channelCount != -1) {
                    Transformer.this.exportResultBuilder.setChannelCount(format.channelCount);
                }
                if (format.sampleRate != -1) {
                    Transformer.this.exportResultBuilder.setSampleRate(format.sampleRate);
                    return;
                }
                return;
            }
            if (i == 2) {
                Transformer.this.exportResultBuilder.setVideoMimeType(format.sampleMimeType).setAverageVideoBitrate(i2).setColorInfo(format.colorInfo).setVideoFrameCount(i3);
                if (format.height != -1) {
                    Transformer.this.exportResultBuilder.setHeight(format.height);
                }
                if (format.width != -1) {
                    Transformer.this.exportResultBuilder.setWidth(format.width);
                }
            }
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void onError(ExportException exportException) {
            ((TransformerInternal) Assertions.checkNotNull(Transformer.this.transformerInternal)).endWithException(exportException);
        }
    }
}
