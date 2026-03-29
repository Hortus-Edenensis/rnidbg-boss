package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.collect.ImmutableList;
import defpackage.er3;
import defpackage.qe6;
import defpackage.ze3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class SequenceRenderersFactory implements RenderersFactory {
    private static final int DEFAULT_FRAME_RATE = 30;
    private SequenceAudioRenderer audioRenderer;
    private final Context context;

    @Nullable
    private final ImageDecoder.Factory imageDecoderFactory;
    private SequenceImageRenderer imageRenderer;
    private final int inputIndex;
    private final PlaybackAudioGraphWrapper playbackAudioGraphWrapper;
    private SequenceVideoRenderer primaryVideoRenderer;
    private SequenceVideoRenderer secondaryVideoRenderer;
    private final boolean videoPrewarmingEnabled;

    @Nullable
    private final VideoSink videoSink;

    /* JADX INFO: compiled from: SearchBox */
    public static final class SequenceAudioRenderer extends MediaCodecAudioRenderer {
        private final AudioGraphInputAudioSink audioSink;

        @Nullable
        private EditedMediaItem pendingEditedMediaItem;
        private long pendingOffsetToCompositionTimeUs;
        private final PlaybackAudioGraphWrapper playbackAudioGraphWrapper;
        private EditedMediaItemSequence sequence;

        public SequenceAudioRenderer(Context context, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioGraphInputAudioSink audioGraphInputAudioSink, PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
            super(context, MediaCodecSelector.DEFAULT, handler, audioRendererEventListener, audioGraphInputAudioSink);
            this.audioSink = audioGraphInputAudioSink;
            this.playbackAudioGraphWrapper = playbackAudioGraphWrapper;
        }

        private void onMediaItemChanged() {
            Assertions.checkStateNotNull(this.sequence);
            EditedMediaItem editedMediaItem = (EditedMediaItem) Assertions.checkStateNotNull(this.pendingEditedMediaItem);
            this.audioSink.onMediaItemChanged(editedMediaItem, this.pendingOffsetToCompositionTimeUs, SequenceRenderersFactory.isLastInSequence(getTimeline(), this.sequence, editedMediaItem));
        }

        @Override // androidx.media3.exoplayer.audio.MediaCodecAudioRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
            super.onPositionReset(j, z);
            onMediaItemChanged();
        }

        @Override // androidx.media3.exoplayer.audio.MediaCodecAudioRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        public void onProcessedStreamChange() {
            super.onProcessedStreamChange();
            onMediaItemChanged();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
            Assertions.checkState(getTimeline().getWindowCount() == 1);
            int indexOfPeriod = getTimeline().getIndexOfPeriod(mediaPeriodId.periodUid);
            Assertions.checkStateNotNull(this.sequence);
            this.pendingEditedMediaItem = EditedMediaItemSequence.getEditedMediaItem(this.sequence, indexOfPeriod);
            this.pendingOffsetToCompositionTimeUs = SequenceRenderersFactory.getOffsetToCompositionTimeUs(this.sequence, indexOfPeriod, j2);
            super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public void render(long j, long j2) throws ExoPlaybackException {
            super.render(j, j2);
            do {
                try {
                } catch (AudioSink.ConfigurationException | AudioSink.InitializationException | AudioSink.WriteException | ExportException e) {
                    throw createRendererException(e, null, 5002);
                }
            } while (this.playbackAudioGraphWrapper.processData());
        }

        public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
            this.sequence = editedMediaItemSequence;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SequenceImageRenderer extends ImageRenderer {
        private EditedMediaItem currentEditedMediaItem;
        private boolean inputStreamPending;
        private boolean mayRenderStartOfStream;
        private int nextFirstFrameReleaseInstruction;

        @Nullable
        private ExoPlaybackException pendingExoPlaybackException;
        private EditedMediaItemSequence sequence;
        private long streamStartPositionUs;
        private ConstantRateTimestampIterator timestampIterator;
        private ImmutableList<Effect> videoEffects;
        private final VideoSink videoSink;
        private Renderer.WakeupListener wakeupListener;

        public SequenceImageRenderer(ImageDecoder.Factory factory, VideoSink videoSink) {
            super(factory, ImageOutput.NO_OP);
            this.videoSink = videoSink;
            this.videoEffects = ImmutableList.of();
            this.streamStartPositionUs = -9223372036854775807L;
        }

        private ConstantRateTimestampIterator createTimestampIterator(long j) {
            return new ConstantRateTimestampIterator(j, getStreamOffsetUs() + ((EditedMediaItem) Assertions.checkNotNull(this.currentEditedMediaItem)).getPresentationDurationUs(), 30.0f);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
        public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
            if (i == 11) {
                this.wakeupListener = (Renderer.WakeupListener) Assertions.checkNotNull(obj);
            } else {
                super.handleMessage(i, obj);
            }
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public boolean isEnded() {
            ConstantRateTimestampIterator constantRateTimestampIterator;
            return super.isEnded() && this.videoSink.isEnded() && ((constantRateTimestampIterator = this.timestampIterator) == null || !constantRateTimestampIterator.hasNext());
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public boolean isReady() {
            return this.mayRenderStartOfStream ? this.videoSink.isReady(super.isReady()) : super.isReady();
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer
        public boolean maybeInitializeProcessingPipeline() throws ExoPlaybackException {
            if (this.videoSink.isInitialized()) {
                return true;
            }
            Format formatBuild = new Format.Builder().build();
            try {
                return this.videoSink.initialize(formatBuild);
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, formatBuild, 7000);
            }
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
            super.onEnabled(z, z2);
            this.mayRenderStartOfStream = z2;
            this.nextFirstFrameReleaseInstruction = !z2 ? 1 : 0;
            this.videoSink.setListener(new VideoSink.Listener() { // from class: androidx.media3.transformer.SequenceRenderersFactory.SequenceImageRenderer.1
                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public /* synthetic */ void onError(VideoSink.VideoSinkException videoSinkException) {
                    qe6.a(this, videoSinkException);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public /* synthetic */ void onFirstFrameRendered() {
                    qe6.b(this);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public void onFrameAvailableForRendering() {
                    if (SequenceImageRenderer.this.wakeupListener != null) {
                        SequenceImageRenderer.this.wakeupListener.onWakeup();
                    }
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public /* synthetic */ void onFrameDropped() {
                    qe6.d(this);
                }

                @Override // androidx.media3.exoplayer.video.VideoSink.Listener
                public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                    qe6.e(this, videoSize);
                }
            }, er3.a());
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
            if (!z) {
                this.videoSink.flush(true);
                this.timestampIterator = createTimestampIterator(j);
            }
            super.onPositionReset(j, z);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onReset() {
            super.onReset();
            this.pendingExoPlaybackException = null;
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
            Assertions.checkStateNotNull(this.sequence);
            Assertions.checkState(getTimeline().getWindowCount() == 1);
            this.streamStartPositionUs = j;
            int indexOfPeriod = getTimeline().getIndexOfPeriod(mediaPeriodId.periodUid);
            this.currentEditedMediaItem = EditedMediaItemSequence.getEditedMediaItem(this.sequence, indexOfPeriod);
            this.videoSink.setBufferTimestampAdjustmentUs(SequenceRenderersFactory.getOffsetToCompositionTimeUs(this.sequence, indexOfPeriod, j2));
            this.timestampIterator = createTimestampIterator(j);
            this.videoEffects = ((EditedMediaItem) Assertions.checkNotNull(this.currentEditedMediaItem)).effects.videoEffects;
            this.inputStreamPending = true;
            super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer
        public boolean processOutputBuffer(long j, long j2, Bitmap bitmap, long j3) {
            if (this.inputStreamPending) {
                Assertions.checkState(this.streamStartPositionUs != -9223372036854775807L);
                this.videoSink.onInputStreamChanged(2, new Format.Builder().setSampleMimeType(MimeTypes.IMAGE_RAW).setWidth(bitmap.getWidth()).setHeight(bitmap.getHeight()).setColorInfo(ColorInfo.SRGB_BT709_FULL).setFrameRate(30.0f).build(), this.streamStartPositionUs, this.nextFirstFrameReleaseInstruction, this.videoEffects);
                this.nextFirstFrameReleaseInstruction = 2;
                this.inputStreamPending = false;
            }
            if (!this.videoSink.handleInputBitmap(bitmap, (TimestampIterator) Assertions.checkStateNotNull(this.timestampIterator))) {
                return false;
            }
            this.videoSink.signalEndOfCurrentInputStream();
            if (SequenceRenderersFactory.isLastInSequence(getTimeline(), (EditedMediaItemSequence) Assertions.checkNotNull(this.sequence), (EditedMediaItem) Assertions.checkNotNull(this.currentEditedMediaItem))) {
                this.videoSink.signalEndOfInput();
            }
            return true;
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public void render(long j, long j2) throws ExoPlaybackException {
            ExoPlaybackException exoPlaybackException = this.pendingExoPlaybackException;
            if (exoPlaybackException != null) {
                this.pendingExoPlaybackException = null;
                throw exoPlaybackException;
            }
            super.render(j, j2);
            try {
                this.videoSink.render(j, j2);
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, 7001);
            }
        }

        public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
            this.sequence = editedMediaItemSequence;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class SequenceVideoRenderer extends MediaCodecVideoRenderer {
        private final BufferingVideoSink bufferingVideoSink;

        @Nullable
        private EditedMediaItem currentEditedMediaItem;
        private long offsetToCompositionTimeUs;
        private ImmutableList<Effect> pendingEffects;
        private boolean requestMediaCodecToneMapping;
        private EditedMediaItemSequence sequence;

        public SequenceVideoRenderer(Context context, Handler handler, VideoRendererEventListener videoRendererEventListener, BufferingVideoSink bufferingVideoSink) {
            super(new MediaCodecVideoRenderer.Builder(context).setMediaCodecSelector(MediaCodecSelector.DEFAULT).setCodecAdapterFactory(ze3.a(context)).setAllowedJoiningTimeMs(5000L).setEnableDecoderFallback(false).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(50).setAssumedMinimumCodecOperatingRate(30.0f).setVideoSink(bufferingVideoSink));
            this.bufferingVideoSink = bufferingVideoSink;
            this.pendingEffects = ImmutableList.of();
        }

        private void activateBufferingVideoSink() {
            if (this.bufferingVideoSink.getVideoSink() != null) {
                return;
            }
            VideoSink videoSink = (VideoSink) Assertions.checkNotNull(SequenceRenderersFactory.this.videoSink);
            this.bufferingVideoSink.setVideoSink(videoSink);
            MediaCodecAdapter codec = getCodec();
            if (!SequenceRenderersFactory.this.isVideoPrewarmingEnabled() || !videoSink.isInitialized() || codec == null || codecNeedsSetOutputSurfaceWorkaround(((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).name)) {
                return;
            }
            setOutputSurfaceV23(codec, videoSink.getInputSurface());
        }

        private void deactivateBufferingVideoSink() {
            if (SequenceRenderersFactory.this.isVideoPrewarmingEnabled()) {
                this.bufferingVideoSink.setVideoSink(null);
                this.bufferingVideoSink.clearPendingOperations();
                MediaCodecAdapter codec = getCodec();
                if (codec == null) {
                    return;
                }
                if (codecNeedsSetOutputSurfaceWorkaround(((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).name)) {
                    releaseCodec();
                } else {
                    setOutputSurfaceV23(codec, this.bufferingVideoSink.getInputSurface());
                }
            }
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public void changeVideoSinkInputStream(VideoSink videoSink, int i, Format format, int i2) {
            videoSink.onInputStreamChanged(i, format, getOutputStreamStartPositionUs(), i2, this.pendingEffects);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public long getBufferTimestampAdjustmentUs() {
            return this.offsetToCompositionTimeUs;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public MediaFormat getMediaFormat(Format format, String str, MediaCodecVideoRenderer.CodecMaxValues codecMaxValues, float f, boolean z, int i) {
            MediaFormat mediaFormat = super.getMediaFormat(format, str, codecMaxValues, f, z, i);
            if (this.requestMediaCodecToneMapping && Build.VERSION.SDK_INT >= 31) {
                mediaFormat.setInteger("color-transfer-request", 3);
            }
            return mediaFormat;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
        public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
            if (i == 17) {
                return;
            }
            super.handleMessage(i, obj);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onDisabled() {
            super.onDisabled();
            deactivateBufferingVideoSink();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
            if (z2) {
                activateBufferingVideoSink();
            }
            super.onEnabled(z, z2);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onStarted() {
            activateBufferingVideoSink();
            super.onStarted();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
            Assertions.checkStateNotNull(this.sequence);
            Assertions.checkState(getTimeline().getWindowCount() == 1);
            int indexOfPeriod = getTimeline().getIndexOfPeriod(mediaPeriodId.periodUid);
            this.currentEditedMediaItem = EditedMediaItemSequence.getEditedMediaItem(this.sequence, indexOfPeriod);
            this.offsetToCompositionTimeUs = SequenceRenderersFactory.getOffsetToCompositionTimeUs(this.sequence, indexOfPeriod, j2);
            this.pendingEffects = ((EditedMediaItem) Assertions.checkNotNull(this.currentEditedMediaItem)).effects.videoEffects;
            super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        public void renderToEndOfStream() {
            Assertions.checkStateNotNull(this.sequence);
            super.renderToEndOfStream();
            if (SequenceRenderersFactory.isLastInSequence(getTimeline(), this.sequence, (EditedMediaItem) Assertions.checkNotNull(this.currentEditedMediaItem))) {
                this.bufferingVideoSink.signalEndOfInput();
            }
        }

        public void setRequestMediaCodecToneMapping(boolean z) {
            this.requestMediaCodecToneMapping = z;
        }

        public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
            this.sequence = editedMediaItemSequence;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
            if (SequenceRenderersFactory.this.isVideoPrewarmingEnabled() && this.bufferingVideoSink.getVideoSink() == null && codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
                return false;
            }
            return super.shouldInitCodec(mediaCodecInfo);
        }
    }

    private SequenceRenderersFactory(Context context, PlaybackAudioGraphWrapper playbackAudioGraphWrapper, @Nullable VideoSink videoSink, @Nullable ImageDecoder.Factory factory, int i, boolean z) {
        this.context = context;
        this.playbackAudioGraphWrapper = playbackAudioGraphWrapper;
        this.videoSink = videoSink;
        this.imageDecoderFactory = factory;
        this.inputIndex = i;
        this.videoPrewarmingEnabled = z;
    }

    public static SequenceRenderersFactory create(Context context, PlaybackAudioGraphWrapper playbackAudioGraphWrapper, VideoSink videoSink, ImageDecoder.Factory factory, int i, boolean z) {
        return new SequenceRenderersFactory(context, playbackAudioGraphWrapper, videoSink, factory, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getOffsetToCompositionTimeUs(EditedMediaItemSequence editedMediaItemSequence, int i, long j) {
        long presentationDurationUs = -j;
        if (i == 0) {
            presentationDurationUs -= editedMediaItemSequence.editedMediaItems.get(0).mediaItem.clippingConfiguration.startPositionUs;
        }
        for (int i2 = 0; i2 < i; i2++) {
            presentationDurationUs += EditedMediaItemSequence.getEditedMediaItem(editedMediaItemSequence, i2).getPresentationDurationUs();
        }
        return presentationDurationUs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLastInSequence(Timeline timeline, EditedMediaItemSequence editedMediaItemSequence, EditedMediaItem editedMediaItem) {
        return editedMediaItem == EditedMediaItemSequence.getEditedMediaItem(editedMediaItemSequence, timeline.getPeriodCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ChecksSdkIntAtLeast(api = 23)
    public boolean isVideoPrewarmingEnabled() {
        return this.videoPrewarmingEnabled && Build.VERSION.SDK_INT >= 23;
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        if (this.audioRenderer == null) {
            this.audioRenderer = new SequenceAudioRenderer(this.context, handler, audioRendererEventListener, this.playbackAudioGraphWrapper.createInput(this.inputIndex), this.playbackAudioGraphWrapper);
        }
        arrayList.add(this.audioRenderer);
        if (this.videoSink != null) {
            if (this.primaryVideoRenderer == null) {
                Context context = this.context;
                this.primaryVideoRenderer = new SequenceVideoRenderer(context, handler, videoRendererEventListener, new BufferingVideoSink(context));
            }
            arrayList.add(this.primaryVideoRenderer);
            if (this.imageRenderer == null) {
                this.imageRenderer = new SequenceImageRenderer((ImageDecoder.Factory) Assertions.checkStateNotNull(this.imageDecoderFactory), this.videoSink);
            }
            arrayList.add(this.imageRenderer);
        }
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    @Nullable
    public Renderer createSecondaryRenderer(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        if (!isVideoPrewarmingEnabled() || !(renderer instanceof SequenceVideoRenderer)) {
            return null;
        }
        if (this.secondaryVideoRenderer == null) {
            Context context = this.context;
            this.secondaryVideoRenderer = new SequenceVideoRenderer(context, handler, videoRendererEventListener, new BufferingVideoSink(context));
        }
        return this.secondaryVideoRenderer;
    }

    public void setRequestMediaCodecToneMapping(boolean z) {
        SequenceVideoRenderer sequenceVideoRenderer = this.primaryVideoRenderer;
        if (sequenceVideoRenderer != null) {
            sequenceVideoRenderer.setRequestMediaCodecToneMapping(z);
        }
        SequenceVideoRenderer sequenceVideoRenderer2 = this.secondaryVideoRenderer;
        if (sequenceVideoRenderer2 != null) {
            sequenceVideoRenderer2.setRequestMediaCodecToneMapping(z);
        }
    }

    public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
        SequenceAudioRenderer sequenceAudioRenderer = this.audioRenderer;
        if (sequenceAudioRenderer != null) {
            sequenceAudioRenderer.setSequence(editedMediaItemSequence);
        }
        SequenceVideoRenderer sequenceVideoRenderer = this.primaryVideoRenderer;
        if (sequenceVideoRenderer != null) {
            sequenceVideoRenderer.setSequence(editedMediaItemSequence);
        }
        SequenceVideoRenderer sequenceVideoRenderer2 = this.secondaryVideoRenderer;
        if (sequenceVideoRenderer2 != null) {
            sequenceVideoRenderer2.setSequence(editedMediaItemSequence);
        }
        SequenceImageRenderer sequenceImageRenderer = this.imageRenderer;
        if (sequenceImageRenderer != null) {
            sequenceImageRenderer.setSequence(editedMediaItemSequence);
        }
    }
}
