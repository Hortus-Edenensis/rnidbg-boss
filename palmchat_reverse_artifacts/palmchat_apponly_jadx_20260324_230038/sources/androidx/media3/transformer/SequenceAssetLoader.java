package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.ExportResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.my5;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class SequenceAssetLoader implements AssetLoader, AssetLoader.Listener {
    private static final int BLANK_IMAGE_BITMAP_HEIGHT = 1;
    private static final int BLANK_IMAGE_BITMAP_WIDTH = 1;
    private static final float BLANK_IMAGE_FRAME_RATE = 30.0f;
    private static final int RETRY_DELAY_MS = 10;
    private final AssetLoader.Factory assetLoaderFactory;
    private final AssetLoader.CompositionSettings compositionSettings;
    private volatile long currentAssetDurationAfterEffectsAppliedUs;
    private volatile long currentAssetDurationUs;
    private AssetLoader currentAssetLoader;
    private Format currentAudioInputFormat;
    private int currentMediaItemIndex;
    private Format currentVideoInputFormat;
    private boolean decodeAudio;
    private boolean decodeVideo;
    private final List<EditedMediaItem> editedMediaItems;
    private final boolean forceAudioTrack;
    private final boolean forceVideoTrack;
    private final HandlerWrapper handler;
    private boolean isCurrentAssetFirstAsset;
    private final boolean isLooping;
    private volatile boolean isMaxSequenceDurationUsFinal;
    private boolean isTrackCountReported;
    private volatile long maxSequenceDurationUs;
    private final Map<Integer, OnMediaItemChangedListener> mediaItemChangedListenersByTrackType;
    private final AtomicInteger nonEndedTrackCount;
    private final ImmutableList.a<ExportResult.ProcessedInput> processedInputsBuilder;
    private int processedInputsSize;
    private volatile boolean released;
    private final AtomicInteger reportedTrackCount;
    private final Map<Integer, SampleConsumerWrapper> sampleConsumersByTrackType;
    private final AssetLoader.Listener sequenceAssetLoaderListener;
    private volatile boolean sequenceHasAudio;
    private volatile boolean sequenceHasVideo;
    private int sequenceLoopCount;
    private static final Format FORCE_AUDIO_TRACK_FORMAT = new Format.Builder().setSampleMimeType("audio/mp4a-latm").setSampleRate(44100).setChannelCount(2).build();
    private static final Format BLANK_IMAGE_BITMAP_FORMAT = new Format.Builder().setWidth(1).setHeight(1).setSampleMimeType(MimeTypes.IMAGE_RAW).setColorInfo(ColorInfo.SRGB_BT709_FULL).build();

    /* JADX INFO: compiled from: SearchBox */
    public static final class ClippingIterator implements TimestampIterator {
        private final long clippingValue;
        private boolean hasReachedClippingValue;
        private final TimestampIterator iterator;

        public ClippingIterator(TimestampIterator timestampIterator, long j) {
            this.iterator = timestampIterator;
            this.clippingValue = j;
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public TimestampIterator copyOf() {
            return new ClippingIterator(this.iterator.copyOf(), this.clippingValue);
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public /* synthetic */ long getLastTimestampUs() {
            return my5.a(this);
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public boolean hasNext() {
            return !this.hasReachedClippingValue && this.iterator.hasNext();
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public long next() {
            Assertions.checkState(hasNext());
            long next = this.iterator.next();
            if (this.clippingValue <= next) {
                this.hasReachedClippingValue = true;
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class GapInterceptingAssetLoaderFactory implements AssetLoader.Factory {
        private final AssetLoader.Factory factory;

        public GapInterceptingAssetLoaderFactory(AssetLoader.Factory factory) {
            this.factory = factory;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            return editedMediaItem.isGap() ? new GapSignalingAssetLoader(editedMediaItem.durationUs) : this.factory.createAssetLoader(editedMediaItem, looper, listener, compositionSettings);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class GapSignalingAssetLoader implements AssetLoader {
        private final Format audioTrackDecodedFormat;
        private final Format audioTrackFormat;
        private final long durationUs;
        private boolean producedAudio;
        private boolean producedVideo;
        private final boolean shouldProduceAudio;
        private final boolean shouldProduceVideo;

        /* JADX INFO: Access modifiers changed from: private */
        public void outputFormatToSequenceAssetLoader() {
            boolean z = false;
            boolean z2 = true;
            boolean z3 = this.shouldProduceAudio && !this.producedAudio;
            boolean z4 = this.shouldProduceVideo && !this.producedVideo;
            Assertions.checkState(z3 || z4);
            if (z3) {
                try {
                    SampleConsumerWrapper sampleConsumerWrapperOnOutputFormat = SequenceAssetLoader.this.onOutputFormat(this.audioTrackDecodedFormat);
                    if (sampleConsumerWrapperOnOutputFormat == null) {
                        z = true;
                    } else {
                        sampleConsumerWrapperOnOutputFormat.onAudioGapSignalled();
                        this.producedAudio = true;
                    }
                } catch (ExportException e) {
                    SequenceAssetLoader.this.onError(e);
                    return;
                } catch (RuntimeException e2) {
                    SequenceAssetLoader.this.onError(ExportException.createForAssetLoader(e2, 1000));
                    return;
                }
            }
            if (!z4) {
                z2 = z;
            } else if (SequenceAssetLoader.this.onOutputFormat(SequenceAssetLoader.BLANK_IMAGE_BITMAP_FORMAT) != null) {
                SequenceAssetLoader.this.lambda$insertBlankFrames$1(SequenceAssetLoader.getBlankImageBitmap());
                this.producedVideo = true;
                z2 = z;
            }
            if (z2) {
                SequenceAssetLoader.this.handler.postDelayed(new Runnable() { // from class: androidx.media3.transformer.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1513a.outputFormatToSequenceAssetLoader();
                    }
                }, 10L);
            }
        }

        @Override // androidx.media3.transformer.AssetLoader
        public ImmutableMap<Integer, String> getDecoderNames() {
            return ImmutableMap.of();
        }

        @Override // androidx.media3.transformer.AssetLoader
        public int getProgress(ProgressHolder progressHolder) {
            boolean z = this.shouldProduceAudio && !this.producedAudio;
            boolean z2 = this.shouldProduceVideo && !this.producedVideo;
            if (z && z2) {
                progressHolder.progress = 0;
                return 2;
            }
            if (z || z2) {
                progressHolder.progress = 50;
                return 2;
            }
            progressHolder.progress = 99;
            return 2;
        }

        @Override // androidx.media3.transformer.AssetLoader
        public void start() {
            SequenceAssetLoader.this.onDurationUs(this.durationUs);
            SequenceAssetLoader.this.onTrackCount((this.shouldProduceAudio && this.shouldProduceVideo) ? 2 : 1);
            if (this.shouldProduceAudio) {
                SequenceAssetLoader.this.onTrackAdded(this.audioTrackFormat, 2);
            }
            if (this.shouldProduceVideo) {
                SequenceAssetLoader.this.onTrackAdded(SequenceAssetLoader.BLANK_IMAGE_BITMAP_FORMAT, 2);
            }
            outputFormatToSequenceAssetLoader();
        }

        private GapSignalingAssetLoader(long j) {
            this.durationUs = j;
            boolean z = SequenceAssetLoader.this.sequenceHasAudio || SequenceAssetLoader.this.forceAudioTrack;
            this.shouldProduceAudio = z;
            boolean z2 = SequenceAssetLoader.this.sequenceHasVideo || SequenceAssetLoader.this.forceVideoTrack;
            this.shouldProduceVideo = z2;
            Assertions.checkState(z || z2);
            this.audioTrackFormat = new Format.Builder().setSampleMimeType("audio/raw").build();
            this.audioTrackDecodedFormat = new Format.Builder().setSampleMimeType("audio/raw").setSampleRate(44100).setChannelCount(2).setPcmEncoding(2).build();
        }

        @Override // androidx.media3.transformer.AssetLoader
        public void release() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class SampleConsumerWrapper implements SampleConsumer {
        private boolean audioLoopingEnded;
        private final SampleConsumer sampleConsumer;
        private long totalDurationUs;
        private final int trackType;
        private boolean videoLoopingEnded;

        public SampleConsumerWrapper(SampleConsumer sampleConsumer, int i) {
            this.sampleConsumer = sampleConsumer;
            this.trackType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$switchAssetLoader$0() {
            try {
                if (SequenceAssetLoader.this.released) {
                    return;
                }
                SequenceAssetLoader.this.addCurrentProcessedInput();
                this.totalDurationUs += SequenceAssetLoader.this.currentAssetDurationAfterEffectsAppliedUs;
                SequenceAssetLoader.this.currentAssetLoader.release();
                SequenceAssetLoader.this.isCurrentAssetFirstAsset = false;
                SequenceAssetLoader.access$1208(SequenceAssetLoader.this);
                if (SequenceAssetLoader.this.currentMediaItemIndex == SequenceAssetLoader.this.editedMediaItems.size()) {
                    SequenceAssetLoader.this.currentMediaItemIndex = 0;
                    SequenceAssetLoader.access$1408(SequenceAssetLoader.this);
                }
                EditedMediaItem editedMediaItem = (EditedMediaItem) SequenceAssetLoader.this.editedMediaItems.get(SequenceAssetLoader.this.currentMediaItemIndex);
                SequenceAssetLoader sequenceAssetLoader = SequenceAssetLoader.this;
                AssetLoader.Factory factory = sequenceAssetLoader.assetLoaderFactory;
                Looper looper = (Looper) Assertions.checkNotNull(Looper.myLooper());
                SequenceAssetLoader sequenceAssetLoader2 = SequenceAssetLoader.this;
                sequenceAssetLoader.currentAssetLoader = factory.createAssetLoader(editedMediaItem, looper, sequenceAssetLoader2, sequenceAssetLoader2.compositionSettings);
                SequenceAssetLoader.this.currentAssetLoader.start();
            } catch (RuntimeException e) {
                SequenceAssetLoader.this.onError(ExportException.createForAssetLoader(e, 1000));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onAudioGapSignalled() {
            if (SequenceAssetLoader.this.nonEndedTrackCount.decrementAndGet() != 0 || SequenceAssetLoader.this.isLastMediaItemInSequence()) {
                return;
            }
            switchAssetLoader();
        }

        private void switchAssetLoader() {
            SequenceAssetLoader.this.handler.post(new Runnable() { // from class: androidx.media3.transformer.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1514a.lambda$switchAssetLoader$0();
                }
            });
        }

        @Override // androidx.media3.transformer.SampleConsumer
        @Nullable
        public DecoderInputBuffer getInputBuffer() {
            return this.sampleConsumer.getInputBuffer();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public Surface getInputSurface() {
            return this.sampleConsumer.getInputSurface();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int getPendingVideoFrameCount() {
            return this.sampleConsumer.getPendingVideoFrameCount();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            if (SequenceAssetLoader.this.isLooping) {
                long j = -9223372036854775807L;
                while (true) {
                    if (!timestampIterator.hasNext()) {
                        break;
                    }
                    long next = timestampIterator.next();
                    if (this.totalDurationUs + next <= SequenceAssetLoader.this.maxSequenceDurationUs) {
                        j = next;
                    } else {
                        if (!SequenceAssetLoader.this.isMaxSequenceDurationUsFinal) {
                            return 2;
                        }
                        if (j == -9223372036854775807L) {
                            if (this.videoLoopingEnded) {
                                return 2;
                            }
                            this.videoLoopingEnded = true;
                            signalEndOfVideoInput();
                            return 3;
                        }
                        ClippingIterator clippingIterator = new ClippingIterator(timestampIterator.copyOf(), j);
                        this.videoLoopingEnded = true;
                        timestampIterator = clippingIterator;
                    }
                }
            }
            return this.sampleConsumer.queueInputBitmap(bitmap, timestampIterator.copyOf());
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public boolean queueInputBuffer() {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.checkStateNotNull(this.sampleConsumer.getInputBuffer());
            long j = this.totalDurationUs + decoderInputBuffer.timeUs;
            if (SequenceAssetLoader.this.isLooping && (j >= SequenceAssetLoader.this.maxSequenceDurationUs || this.audioLoopingEnded)) {
                if (SequenceAssetLoader.this.isMaxSequenceDurationUsFinal && !this.audioLoopingEnded) {
                    ((ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data)).limit(0);
                    decoderInputBuffer.setFlags(4);
                    Assertions.checkState(this.sampleConsumer.queueInputBuffer());
                    this.audioLoopingEnded = true;
                    SequenceAssetLoader.this.nonEndedTrackCount.decrementAndGet();
                }
                return false;
            }
            if (decoderInputBuffer.isEndOfStream()) {
                SequenceAssetLoader.this.nonEndedTrackCount.decrementAndGet();
                if (!SequenceAssetLoader.this.isLastMediaItemInSequence() || SequenceAssetLoader.this.isLooping) {
                    if (this.trackType == 1 && !SequenceAssetLoader.this.isLooping && SequenceAssetLoader.this.decodeAudio) {
                        Assertions.checkState(this.sampleConsumer.queueInputBuffer());
                    } else {
                        decoderInputBuffer.clear();
                        decoderInputBuffer.timeUs = 0L;
                    }
                    if (SequenceAssetLoader.this.nonEndedTrackCount.get() == 0) {
                        switchAssetLoader();
                    }
                    return true;
                }
            }
            Assertions.checkState(this.sampleConsumer.queueInputBuffer());
            return true;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int queueInputTexture(int i, long j) {
            long j2 = this.totalDurationUs + j;
            if (!SequenceAssetLoader.this.isLooping || j2 < SequenceAssetLoader.this.maxSequenceDurationUs) {
                return this.sampleConsumer.queueInputTexture(i, j);
            }
            if (!SequenceAssetLoader.this.isMaxSequenceDurationUsFinal || this.videoLoopingEnded) {
                return 2;
            }
            this.videoLoopingEnded = true;
            signalEndOfVideoInput();
            return 3;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public boolean registerVideoFrame(long j) {
            long j2 = this.totalDurationUs + j;
            if (!SequenceAssetLoader.this.isLooping || j2 < SequenceAssetLoader.this.maxSequenceDurationUs) {
                return this.sampleConsumer.registerVideoFrame(j);
            }
            if (!SequenceAssetLoader.this.isMaxSequenceDurationUsFinal || this.videoLoopingEnded) {
                return false;
            }
            this.videoLoopingEnded = true;
            signalEndOfVideoInput();
            return false;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
            this.sampleConsumer.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void setOnInputSurfaceReadyListener(Runnable runnable) {
            this.sampleConsumer.setOnInputSurfaceReadyListener(runnable);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void signalEndOfVideoInput() {
            SequenceAssetLoader.this.nonEndedTrackCount.decrementAndGet();
            if (SequenceAssetLoader.this.isLooping ? this.videoLoopingEnded : SequenceAssetLoader.this.isLastMediaItemInSequence()) {
                this.sampleConsumer.signalEndOfVideoInput();
            } else if (SequenceAssetLoader.this.nonEndedTrackCount.get() == 0) {
                switchAssetLoader();
            }
        }
    }

    public SequenceAssetLoader(EditedMediaItemSequence editedMediaItemSequence, AssetLoader.Factory factory, AssetLoader.CompositionSettings compositionSettings, AssetLoader.Listener listener, Clock clock, Looper looper) {
        ImmutableList<EditedMediaItem> immutableList = editedMediaItemSequence.editedMediaItems;
        this.editedMediaItems = immutableList;
        this.isLooping = editedMediaItemSequence.isLooping;
        this.forceAudioTrack = editedMediaItemSequence.forceAudioTrack;
        this.forceVideoTrack = editedMediaItemSequence.forceVideoTrack;
        GapInterceptingAssetLoaderFactory gapInterceptingAssetLoaderFactory = new GapInterceptingAssetLoaderFactory(factory);
        this.assetLoaderFactory = gapInterceptingAssetLoaderFactory;
        this.compositionSettings = compositionSettings;
        this.sequenceAssetLoaderListener = listener;
        this.handler = clock.createHandler(looper, null);
        this.sampleConsumersByTrackType = new HashMap();
        this.mediaItemChangedListenersByTrackType = new HashMap();
        this.processedInputsBuilder = new ImmutableList.a<>();
        this.reportedTrackCount = new AtomicInteger();
        this.nonEndedTrackCount = new AtomicInteger();
        this.isCurrentAssetFirstAsset = true;
        this.currentAssetLoader = gapInterceptingAssetLoaderFactory.createAssetLoader(immutableList.get(0), looper, this, compositionSettings);
    }

    public static /* synthetic */ int access$1208(SequenceAssetLoader sequenceAssetLoader) {
        int i = sequenceAssetLoader.currentMediaItemIndex;
        sequenceAssetLoader.currentMediaItemIndex = i + 1;
        return i;
    }

    public static /* synthetic */ int access$1408(SequenceAssetLoader sequenceAssetLoader) {
        int i = sequenceAssetLoader.sequenceLoopCount;
        sequenceAssetLoader.sequenceLoopCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCurrentProcessedInput() {
        int size = this.sequenceLoopCount * this.editedMediaItems.size();
        int i = this.currentMediaItemIndex;
        if (size + i >= this.processedInputsSize) {
            MediaItem mediaItem = this.editedMediaItems.get(i).mediaItem;
            ImmutableMap<Integer, String> decoderNames = getDecoderNames();
            this.processedInputsBuilder.a(new ExportResult.ProcessedInput(mediaItem, this.currentAssetDurationUs, this.currentAudioInputFormat, this.currentVideoInputFormat, decoderNames.get(1), decoderNames.get(2)));
            this.processedInputsSize++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap getBlankImageBitmap() {
        return Bitmap.createBitmap(new int[]{-16777216}, 1, 1, Bitmap.Config.ARGB_8888);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: insertBlankFrames, reason: merged with bridge method [inline-methods] */
    public void lambda$insertBlankFrames$1(final Bitmap bitmap) {
        SampleConsumerWrapper sampleConsumerWrapper = (SampleConsumerWrapper) Assertions.checkNotNull(this.sampleConsumersByTrackType.get(2));
        if (sampleConsumerWrapper.queueInputBitmap(bitmap, new ConstantRateTimestampIterator(this.currentAssetDurationUs, 30.0f)) != 1) {
            this.handler.postDelayed(new Runnable() { // from class: androidx.media3.transformer.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1510a.lambda$insertBlankFrames$1(bitmap);
                }
            }, 10L);
        } else {
            sampleConsumerWrapper.signalEndOfVideoInput();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastMediaItemInSequence() {
        return this.currentMediaItemIndex == this.editedMediaItems.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputFormat$0() {
        lambda$insertBlankFrames$1(getBlankImageBitmap());
    }

    private void onMediaItemChanged(int i, @Nullable Format format) {
        OnMediaItemChangedListener onMediaItemChangedListener = this.mediaItemChangedListenersByTrackType.get(Integer.valueOf(i));
        if (onMediaItemChangedListener == null) {
            return;
        }
        EditedMediaItem editedMediaItem = this.editedMediaItems.get(this.currentMediaItemIndex);
        long j = (i == 1 && this.isLooping && this.decodeAudio) ? -9223372036854775807L : this.currentAssetDurationUs;
        if (editedMediaItem.isGap() && i == 1) {
            format = null;
        }
        onMediaItemChangedListener.onMediaItemChanged(editedMediaItem, j, format, isLastMediaItemInSequence());
    }

    public void addOnMediaItemChangedListener(OnMediaItemChangedListener onMediaItemChangedListener, int i) {
        Assertions.checkArgument(i == 1 || i == 2);
        Assertions.checkArgument(this.mediaItemChangedListenersByTrackType.get(Integer.valueOf(i)) == null);
        this.mediaItemChangedListenersByTrackType.put(Integer.valueOf(i), onMediaItemChangedListener);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        return this.currentAssetLoader.getDecoderNames();
    }

    public ImmutableList<ExportResult.ProcessedInput> getProcessedInputs() {
        addCurrentProcessedInput();
        return this.processedInputsBuilder.e();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        if (this.isLooping) {
            return 3;
        }
        int progress = this.currentAssetLoader.getProgress(progressHolder);
        int size = this.editedMediaItems.size();
        if (size == 1 || progress == 0) {
            return progress;
        }
        int iPercentInt = Util.percentInt(this.currentMediaItemIndex, size);
        if (progress == 2) {
            iPercentInt += progressHolder.progress / size;
        }
        progressHolder.progress = iPercentInt;
        return 2;
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void onDurationUs(long j) {
        Assertions.checkArgument(j != -9223372036854775807L || isLastMediaItemInSequence(), "Could not retrieve required duration for EditedMediaItem " + this.currentMediaItemIndex);
        this.currentAssetDurationAfterEffectsAppliedUs = this.editedMediaItems.get(this.currentMediaItemIndex).getDurationAfterEffectsApplied(j);
        this.currentAssetDurationUs = j;
        if (this.editedMediaItems.size() != 1 || this.isLooping) {
            return;
        }
        this.sequenceAssetLoaderListener.onDurationUs(this.currentAssetDurationAfterEffectsAppliedUs);
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void onError(ExportException exportException) {
        this.sequenceAssetLoaderListener.onError(exportException);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    @Override // androidx.media3.transformer.AssetLoader.Listener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTrackAdded(Format format, int i) {
        boolean z;
        boolean z2;
        boolean z3 = TransformerUtil.getProcessedTrackType(format.sampleMimeType) == 1;
        Object[] objArr = new Object[2];
        objArr[0] = z3 ? "audio" : "video";
        objArr[1] = format;
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_ASSET_LOADER, DebugTraceUtil.EVENT_INPUT_FORMAT, -9223372036854775807L, "%s:%s", objArr);
        if (z3) {
            this.currentAudioInputFormat = format;
        } else {
            this.currentVideoInputFormat = format;
        }
        if (!this.isCurrentAssetFirstAsset) {
            boolean z4 = z3 ? this.decodeAudio : this.decodeVideo;
            if (z4) {
                Assertions.checkArgument((i & 2) != 0);
            } else {
                Assertions.checkArgument((i & 1) != 0);
            }
            return z4;
        }
        if (this.reportedTrackCount.get() == 1) {
            z = this.forceAudioTrack && !z3;
            if (this.forceVideoTrack && z3) {
                z2 = true;
            }
            if (!this.isTrackCountReported) {
                this.sequenceAssetLoaderListener.onTrackCount(this.reportedTrackCount.get() + ((z || z2) ? 1 : 0));
                this.isTrackCountReported = true;
            }
            boolean zOnTrackAdded = this.sequenceAssetLoaderListener.onTrackAdded(format, i);
            if (z3) {
                this.decodeVideo = zOnTrackAdded;
            } else {
                this.decodeAudio = zOnTrackAdded;
            }
            if (z) {
                this.sequenceAssetLoaderListener.onTrackAdded(FORCE_AUDIO_TRACK_FORMAT, 2);
                this.decodeAudio = true;
            }
            if (z2) {
                this.sequenceAssetLoaderListener.onTrackAdded(BLANK_IMAGE_BITMAP_FORMAT, 2);
                this.decodeVideo = true;
            }
            return zOnTrackAdded;
        }
        z = false;
        z2 = false;
        if (!this.isTrackCountReported) {
        }
        boolean zOnTrackAdded2 = this.sequenceAssetLoaderListener.onTrackAdded(format, i);
        if (z3) {
        }
        if (z) {
        }
        if (z2) {
        }
        return zOnTrackAdded2;
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void onTrackCount(int i) {
        this.reportedTrackCount.set(i);
        this.nonEndedTrackCount.set(i);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.currentAssetLoader.release();
        this.released = true;
    }

    public void setMaxSequenceDurationUs(long j, boolean z) {
        this.maxSequenceDurationUs = j;
        this.isMaxSequenceDurationUsFinal = z;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.currentAssetLoader.start();
        if (this.editedMediaItems.size() > 1 || this.isLooping) {
            this.sequenceAssetLoaderListener.onDurationUs(-9223372036854775807L);
        }
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    @Nullable
    public SampleConsumerWrapper onOutputFormat(Format format) throws ExportException {
        SampleConsumerWrapper sampleConsumerWrapper;
        int processedTrackType = TransformerUtil.getProcessedTrackType(format.sampleMimeType);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_ASSET_LOADER, DebugTraceUtil.EVENT_OUTPUT_FORMAT, -9223372036854775807L, "%s:%s", Util.getTrackTypeString(processedTrackType), format);
        if (this.isCurrentAssetFirstAsset) {
            if (processedTrackType == 2) {
                this.sequenceHasVideo = true;
            } else {
                this.sequenceHasAudio = true;
            }
            SampleConsumer sampleConsumerOnOutputFormat = this.sequenceAssetLoaderListener.onOutputFormat(format);
            if (sampleConsumerOnOutputFormat == null) {
                return null;
            }
            sampleConsumerWrapper = new SampleConsumerWrapper(sampleConsumerOnOutputFormat, processedTrackType);
            this.sampleConsumersByTrackType.put(Integer.valueOf(processedTrackType), sampleConsumerWrapper);
            if (this.reportedTrackCount.get() == 1) {
                if (this.forceAudioTrack && processedTrackType == 2) {
                    this.sampleConsumersByTrackType.put(1, new SampleConsumerWrapper((SampleConsumer) Assertions.checkStateNotNull(this.sequenceAssetLoaderListener.onOutputFormat(FORCE_AUDIO_TRACK_FORMAT.buildUpon().setSampleMimeType("audio/raw").setPcmEncoding(2).build())), 1));
                } else if (this.forceVideoTrack && processedTrackType == 1) {
                    this.sampleConsumersByTrackType.put(2, new SampleConsumerWrapper((SampleConsumer) Assertions.checkStateNotNull(this.sequenceAssetLoaderListener.onOutputFormat(BLANK_IMAGE_BITMAP_FORMAT)), 2));
                }
            }
        } else {
            sampleConsumerWrapper = (SampleConsumerWrapper) Assertions.checkStateNotNull(this.sampleConsumersByTrackType.get(Integer.valueOf(processedTrackType)), processedTrackType == 1 ? "The preceding MediaItem does not contain any audio track. If the sequence starts with an item without audio track (like images), followed by items with audio tracks, then EditedMediaItemSequence.Builder.experimentalSetForceAudioTrack() needs to be set to true." : "The preceding MediaItem does not contain any video track. If the sequence starts with an item without video track (audio only), followed by items with video tracks, then EditedMediaItemSequence.Builder.experimentalSetForceVideoTrack() needs to be set to true.");
        }
        onMediaItemChanged(processedTrackType, format);
        if (this.reportedTrackCount.get() == 1 && this.sampleConsumersByTrackType.size() == 2) {
            if (processedTrackType == 1) {
                onMediaItemChanged(2, BLANK_IMAGE_BITMAP_FORMAT);
                this.nonEndedTrackCount.incrementAndGet();
                this.handler.post(new Runnable() { // from class: androidx.media3.transformer.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1512a.lambda$onOutputFormat$0();
                    }
                });
            } else {
                onMediaItemChanged(1, null);
            }
        }
        return sampleConsumerWrapper;
    }
}
