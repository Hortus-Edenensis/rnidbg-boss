package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.MultipleInputVideoGraph;
import androidx.media3.effect.SingleInputVideoGraph;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.TransformationRequest;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.processor.util.EffectConstants;
import defpackage.b25;
import defpackage.er3;
import defpackage.lc6;
import j$.util.Objects;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class VideoSampleExporter extends SampleExporter {
    private final DecoderInputBuffer encoderOutputBuffer;
    private final EncoderWrapper encoderWrapper;
    private volatile long finalFramePresentationTimeUs;
    private boolean hasMuxedTimestampZero;
    private long lastMuxerInputBufferTimestampUs;
    private final VideoGraphWrapper videoGraph;

    /* JADX INFO: compiled from: SearchBox */
    @VisibleForTesting
    public static final class EncoderWrapper {
        private static final String DEFAULT_OUTPUT_MIME_TYPE = "video/hevc";
        private final ImmutableList<Integer> allowedEncodingRotationDegrees;
        private volatile Codec encoder;
        private final Codec.EncoderFactory encoderFactory;
        private SurfaceInfo encoderSurfaceInfo;
        private final FallbackListener fallbackListener;
        private final int hdrModeAfterFallback;
        private final Format inputFormat;

        @Nullable
        private final LogSessionId logSessionId;
        private final List<String> muxerSupportedMimeTypes;
        private volatile int outputRotationDegrees;
        private volatile boolean releaseEncoder;
        private final String requestedOutputMimeType;
        private final TransformationRequest transformationRequest;

        public EncoderWrapper(Codec.EncoderFactory encoderFactory, Format format, ImmutableList<Integer> immutableList, List<String> list, TransformationRequest transformationRequest, FallbackListener fallbackListener, @Nullable LogSessionId logSessionId) {
            Assertions.checkArgument(format.colorInfo != null);
            this.encoderFactory = encoderFactory;
            this.inputFormat = format;
            this.allowedEncodingRotationDegrees = immutableList;
            this.muxerSupportedMimeTypes = list;
            this.transformationRequest = transformationRequest;
            this.fallbackListener = fallbackListener;
            this.logSessionId = logSessionId;
            Pair<String, Integer> requestedOutputMimeTypeAndHdrModeAfterFallback = getRequestedOutputMimeTypeAndHdrModeAfterFallback(format, transformationRequest);
            this.requestedOutputMimeType = (String) requestedOutputMimeTypeAndHdrModeAfterFallback.first;
            this.hdrModeAfterFallback = ((Integer) requestedOutputMimeTypeAndHdrModeAfterFallback.second).intValue();
        }

        private static TransformationRequest createSupportedTransformationRequest(TransformationRequest transformationRequest, boolean z, Format format, Format format2, int i) {
            TransformationRequest.Builder builderBuildUpon = transformationRequest.buildUpon();
            if (transformationRequest.hdrMode != i) {
                builderBuildUpon.setHdrMode(i);
            }
            if (!Objects.equals(format.sampleMimeType, format2.sampleMimeType)) {
                builderBuildUpon.setVideoMimeType(format2.sampleMimeType);
            }
            if (z) {
                int i2 = format.width;
                int i3 = format2.width;
                if (i2 != i3) {
                    builderBuildUpon.setResolution(i3);
                }
            } else {
                int i4 = format.height;
                int i5 = format2.height;
                if (i4 != i5) {
                    builderBuildUpon.setResolution(i5);
                }
            }
            return builderBuildUpon.build();
        }

        private static Pair<String, Integer> getRequestedOutputMimeTypeAndHdrModeAfterFallback(Format format, TransformationRequest transformationRequest) {
            String str = (String) Assertions.checkNotNull(format.sampleMimeType);
            String str2 = transformationRequest.videoMimeType;
            if (str2 != null) {
                str = str2;
            } else if (MimeTypes.isImage(str)) {
                str = "video/hevc";
            }
            return TransformerUtil.getOutputMimeTypeAndHdrModeAfterFallback(transformationRequest.hdrMode, str, format.colorInfo);
        }

        private ColorInfo getSupportedInputColor() {
            return ColorInfo.isTransferHdr(this.inputFormat.colorInfo) && this.hdrModeAfterFallback != 0 ? ColorInfo.SDR_BT709_LIMITED : ColorInfo.SRGB_BT709_FULL.equals(this.inputFormat.colorInfo) ? ColorInfo.SDR_BT709_LIMITED : (ColorInfo) Assertions.checkNotNull(this.inputFormat.colorInfo);
        }

        public int getHdrModeAfterFallback() {
            return this.hdrModeAfterFallback;
        }

        @Nullable
        public ByteBuffer getOutputBuffer() throws ExportException {
            if (this.encoder != null) {
                return this.encoder.getOutputBuffer();
            }
            return null;
        }

        @Nullable
        public MediaCodec.BufferInfo getOutputBufferInfo() throws ExportException {
            if (this.encoder != null) {
                return this.encoder.getOutputBufferInfo();
            }
            return null;
        }

        @Nullable
        public Format getOutputFormat() throws ExportException {
            if (this.encoder == null) {
                return null;
            }
            Format outputFormat = this.encoder.getOutputFormat();
            return (outputFormat == null || this.outputRotationDegrees == 0) ? outputFormat : outputFormat.buildUpon().setRotationDegrees(this.outputRotationDegrees).build();
        }

        @Nullable
        public SurfaceInfo getSurfaceInfo(int i, int i2) throws ExportException {
            if (this.releaseEncoder) {
                return null;
            }
            SurfaceInfo surfaceInfo = this.encoderSurfaceInfo;
            if (surfaceInfo != null) {
                return surfaceInfo;
            }
            if (i < i2) {
                this.outputRotationDegrees = 90;
                i2 = i;
                i = i2;
            }
            if (this.inputFormat.rotationDegrees % EffectConstants.ROTATION_DEGREES_180 == this.outputRotationDegrees % EffectConstants.ROTATION_DEGREES_180) {
                this.outputRotationDegrees = this.inputFormat.rotationDegrees;
            }
            if (!this.allowedEncodingRotationDegrees.contains(Integer.valueOf(this.outputRotationDegrees))) {
                int i3 = (this.outputRotationDegrees + EffectConstants.ROTATION_DEGREES_180) % 360;
                if (this.allowedEncodingRotationDegrees.contains(Integer.valueOf(i3))) {
                    this.outputRotationDegrees = i3;
                } else {
                    this.outputRotationDegrees = this.allowedEncodingRotationDegrees.get(0).intValue();
                    int i4 = i2;
                    i2 = i;
                    i = i4;
                }
            }
            Format formatBuild = new Format.Builder().setWidth(i).setHeight(i2).setRotationDegrees(0).setFrameRate(this.inputFormat.frameRate).setSampleMimeType(this.requestedOutputMimeType).setColorInfo(getSupportedInputColor()).setCodecs(this.inputFormat.codecs).build();
            this.encoder = this.encoderFactory.createForVideoEncoding(formatBuild.buildUpon().setSampleMimeType(SampleExporter.findSupportedMimeTypeForEncoderAndMuxer(formatBuild, this.muxerSupportedMimeTypes)).build(), this.logSessionId);
            Format configurationFormat = this.encoder.getConfigurationFormat();
            this.fallbackListener.onTransformationRequestFinalized(createSupportedTransformationRequest(this.transformationRequest, this.outputRotationDegrees != 0, formatBuild, configurationFormat, this.hdrModeAfterFallback));
            this.encoderSurfaceInfo = new SurfaceInfo(this.encoder.getInputSurface(), configurationFormat.width, configurationFormat.height, this.outputRotationDegrees, true);
            if (this.releaseEncoder) {
                this.encoder.release();
            }
            return this.encoderSurfaceInfo;
        }

        public boolean isEnded() {
            return this.encoder != null && this.encoder.isEnded();
        }

        public void release() {
            if (this.encoder != null) {
                this.encoder.release();
            }
            this.releaseEncoder = true;
        }

        public void releaseOutputBuffer(boolean z) throws ExportException {
            if (this.encoder != null) {
                this.encoder.releaseOutputBuffer(z);
            }
        }

        public void signalEndOfInputStream() throws ExportException {
            if (this.encoder != null) {
                this.encoder.signalEndOfInputStream();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class VideoGraphInput implements GraphInput {
        private final long initialTimestampOffsetUs;
        private final int inputIndex;
        private final AtomicLong mediaItemOffsetUs = new AtomicLong();
        private final VideoGraph videoGraph;

        public VideoGraphInput(VideoGraph videoGraph, int i, long j) {
            this.videoGraph = videoGraph;
            this.inputIndex = i;
            this.initialTimestampOffsetUs = j;
        }

        private static Format applyDecoderRotation(Format format) {
            return format.rotationDegrees % EffectConstants.ROTATION_DEGREES_180 == 0 ? format : format.buildUpon().setWidth(format.height).setHeight(format.width).setRotationDegrees(0).build();
        }

        private static int getInputTypeForMimeType(String str) {
            if (MimeTypes.isImage(str)) {
                return 2;
            }
            if (str.equals("video/raw")) {
                return 3;
            }
            if (MimeTypes.isVideo(str)) {
                return 1;
            }
            throw new IllegalArgumentException("MIME type not supported " + str);
        }

        private static boolean isMediaItemForSurfaceAssetLoader(EditedMediaItem editedMediaItem) {
            String scheme;
            MediaItem.LocalConfiguration localConfiguration = editedMediaItem.mediaItem.localConfiguration;
            if (localConfiguration == null || (scheme = localConfiguration.uri.getScheme()) == null) {
                return false;
            }
            return scheme.equals(SurfaceAssetLoader.MEDIA_ITEM_URI_SCHEME);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public /* synthetic */ DecoderInputBuffer getInputBuffer() {
            return b25.a(this);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public Surface getInputSurface() {
            return this.videoGraph.getInputSurface(this.inputIndex);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int getPendingVideoFrameCount() {
            return this.videoGraph.getPendingInputFrameCount(this.inputIndex);
        }

        @Override // androidx.media3.transformer.OnMediaItemChangedListener
        public void onMediaItemChanged(EditedMediaItem editedMediaItem, long j, @Nullable Format format, boolean z) {
            boolean zIsMediaItemForSurfaceAssetLoader = isMediaItemForSurfaceAssetLoader(editedMediaItem);
            long durationAfterEffectsApplied = editedMediaItem.getDurationAfterEffectsApplied(j);
            if (format != null) {
                Format formatApplyDecoderRotation = applyDecoderRotation(format);
                this.videoGraph.registerInputStream(this.inputIndex, zIsMediaItemForSurfaceAssetLoader ? 4 : getInputTypeForMimeType((String) Assertions.checkNotNull(formatApplyDecoderRotation.sampleMimeType)), formatApplyDecoderRotation, editedMediaItem.effects.videoEffects, this.mediaItemOffsetUs.get() + this.initialTimestampOffsetUs);
            }
            this.mediaItemOffsetUs.addAndGet(durationAfterEffectsApplied);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            return this.videoGraph.queueInputBitmap(this.inputIndex, bitmap, timestampIterator) ? 1 : 2;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public /* synthetic */ boolean queueInputBuffer() {
            return b25.e(this);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int queueInputTexture(int i, long j) {
            return this.videoGraph.queueInputTexture(this.inputIndex, i, j) ? 1 : 2;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public boolean registerVideoFrame(long j) {
            return this.videoGraph.registerInputFrame(this.inputIndex);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
            this.videoGraph.setOnInputFrameProcessedListener(this.inputIndex, onInputFrameProcessedListener);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void setOnInputSurfaceReadyListener(Runnable runnable) {
            this.videoGraph.setOnInputSurfaceReadyListener(this.inputIndex, runnable);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void signalEndOfVideoInput() {
            this.videoGraph.signalEndOfInput(this.inputIndex);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class VideoGraphWrapper implements VideoGraph.Listener {
        private final Consumer<ExportException> errorConsumer;
        private int framesAvailableToRender;
        private int framesInEncoder;
        private final long initialTimestampOffsetUs;
        private final Object lock = new Object();
        private final int maxFramesInEncoder;
        private final boolean renderFramesAutomatically;
        private final VideoGraph videoGraph;

        public VideoGraphWrapper(Context context, VideoGraph.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoCompositorSettings videoCompositorSettings, List<Effect> list, Consumer<ExportException> consumer, long j, int i, boolean z) throws VideoFrameProcessingException {
            this.errorConsumer = consumer;
            this.renderFramesAutomatically = z;
            this.initialTimestampOffsetUs = j;
            this.maxFramesInEncoder = i;
            VideoGraph videoGraphCreate = factory.create(context, colorInfo, debugViewProvider, this, er3.a(), j, z);
            this.videoGraph = videoGraphCreate;
            videoGraphCreate.setCompositionEffects(list);
            videoGraphCreate.setCompositorSettings(videoCompositorSettings);
        }

        private void maybeRenderEarliestOutputFrame() {
            boolean z;
            int i;
            synchronized (this.lock) {
                int i2 = this.framesAvailableToRender;
                if (i2 <= 0 || (i = this.framesInEncoder) >= this.maxFramesInEncoder) {
                    z = false;
                } else {
                    z = true;
                    this.framesInEncoder = i + 1;
                    this.framesAvailableToRender = i2 - 1;
                }
            }
            if (z) {
                this.videoGraph.renderOutputFrame(-3L);
            }
        }

        public GraphInput createInput(int i) throws VideoFrameProcessingException {
            this.videoGraph.registerInput(i);
            return new VideoGraphInput(this.videoGraph, i, this.initialTimestampOffsetUs);
        }

        public boolean hasEncoderReleasedAllBuffersAfterEndOfStream() {
            boolean z = false;
            if (this.renderFramesAutomatically) {
                return false;
            }
            boolean z2 = VideoSampleExporter.this.finalFramePresentationTimeUs != -9223372036854775807L;
            synchronized (this.lock) {
                if (this.framesInEncoder == 0 && z2) {
                    z = true;
                }
            }
            return z;
        }

        public boolean hasProducedFrameWithTimestampZero() {
            return this.videoGraph.hasProducedFrameWithTimestampZero();
        }

        public void initialize() throws VideoFrameProcessingException {
            this.videoGraph.initialize();
        }

        public void onEncoderBufferReleased() {
            if (this.renderFramesAutomatically) {
                return;
            }
            synchronized (this.lock) {
                Assertions.checkState(this.framesInEncoder > 0);
                this.framesInEncoder--;
            }
            maybeRenderEarliestOutputFrame();
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void onEnded(long j) {
            VideoSampleExporter.this.finalFramePresentationTimeUs = j;
            try {
                VideoSampleExporter.this.encoderWrapper.signalEndOfInputStream();
            } catch (ExportException e) {
                this.errorConsumer.accept(e);
            }
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void onError(VideoFrameProcessingException videoFrameProcessingException) {
            this.errorConsumer.accept(ExportException.createForVideoFrameProcessingException(videoFrameProcessingException));
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void onOutputFrameAvailableForRendering(long j, boolean z) {
            if (this.renderFramesAutomatically) {
                return;
            }
            synchronized (this.lock) {
                this.framesAvailableToRender++;
            }
            maybeRenderEarliestOutputFrame();
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public /* synthetic */ void onOutputFrameRateChanged(float f) {
            lc6.d(this, f);
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void onOutputSizeChanged(int i, int i2) {
            SurfaceInfo surfaceInfo;
            try {
                surfaceInfo = VideoSampleExporter.this.encoderWrapper.getSurfaceInfo(i, i2);
            } catch (ExportException e) {
                this.errorConsumer.accept(e);
                surfaceInfo = null;
            }
            this.videoGraph.setOutputSurfaceInfo(surfaceInfo);
        }

        public void release() {
            this.videoGraph.release();
        }
    }

    public VideoSampleExporter(Context context, Format format, TransformationRequest transformationRequest, VideoCompositorSettings videoCompositorSettings, List<Effect> list, VideoFrameProcessor.Factory factory, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper, Consumer<ExportException> consumer, FallbackListener fallbackListener, DebugViewProvider debugViewProvider, long j, boolean z, ImmutableList<Integer> immutableList, int i, @Nullable LogSessionId logSessionId) throws ExportException {
        super(format, muxerWrapper);
        boolean z2 = false;
        boolean z3 = i < 1;
        this.finalFramePresentationTimeUs = -9223372036854775807L;
        this.lastMuxerInputBufferTimestampUs = -9223372036854775807L;
        ColorInfo colorInfo = (ColorInfo) Assertions.checkNotNull(format.colorInfo);
        ColorInfo colorInfoBuild = colorInfo.colorTransfer == 2 ? Objects.equals(format.sampleMimeType, MimeTypes.IMAGE_JPEG_R) ? new ColorInfo.Builder().setColorSpace(6).setColorTransfer(7).setColorRange(1).build() : ColorInfo.SDR_BT709_LIMITED : colorInfo;
        EncoderWrapper encoderWrapper = new EncoderWrapper(encoderFactory, format.buildUpon().setColorInfo(colorInfoBuild).build(), immutableList, muxerWrapper.getSupportedSampleMimeTypes(2), transformationRequest, fallbackListener, logSessionId);
        this.encoderWrapper = encoderWrapper;
        this.encoderOutputBuffer = new DecoderInputBuffer(0);
        if (encoderWrapper.getHdrModeAfterFallback() == 2 && ColorInfo.isTransferHdr(colorInfo)) {
            z2 = true;
        }
        try {
            VideoGraphWrapper videoGraphWrapper = new VideoGraphWrapper(context, z ? new MultipleInputVideoGraph.Factory(factory) : new SingleInputVideoGraph.Factory(factory), z2 ? ColorInfo.SDR_BT709_LIMITED : colorInfoBuild, debugViewProvider, videoCompositorSettings, list, consumer, j, i, z3);
            this.videoGraph = videoGraphWrapper;
            videoGraphWrapper.initialize();
        } catch (VideoFrameProcessingException e) {
            throw ExportException.createForVideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.transformer.SampleExporter
    public GraphInput getInput(EditedMediaItem editedMediaItem, Format format, int i) throws ExportException {
        try {
            return this.videoGraph.createInput(i);
        } catch (VideoFrameProcessingException e) {
            throw ExportException.createForVideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.transformer.SampleExporter
    @Nullable
    public DecoderInputBuffer getMuxerInputBuffer() throws ExportException {
        this.encoderOutputBuffer.data = this.encoderWrapper.getOutputBuffer();
        if (this.encoderOutputBuffer.data == null) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) Assertions.checkNotNull(this.encoderWrapper.getOutputBufferInfo());
        if (bufferInfo.presentationTimeUs == 0 && this.videoGraph.hasProducedFrameWithTimestampZero() == this.hasMuxedTimestampZero && this.finalFramePresentationTimeUs != -9223372036854775807L && bufferInfo.size > 0) {
            bufferInfo.presentationTimeUs = this.finalFramePresentationTimeUs;
        }
        DecoderInputBuffer decoderInputBuffer = this.encoderOutputBuffer;
        decoderInputBuffer.timeUs = bufferInfo.presentationTimeUs;
        decoderInputBuffer.setFlags(bufferInfo.flags);
        this.lastMuxerInputBufferTimestampUs = bufferInfo.presentationTimeUs;
        return this.encoderOutputBuffer;
    }

    @Override // androidx.media3.transformer.SampleExporter
    @Nullable
    public Format getMuxerInputFormat() throws ExportException {
        return this.encoderWrapper.getOutputFormat();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public boolean isMuxerInputEnded() {
        return this.encoderWrapper.isEnded() || this.videoGraph.hasEncoderReleasedAllBuffersAfterEndOfStream();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void release() {
        this.videoGraph.release();
        this.encoderWrapper.release();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void releaseMuxerInputBuffer() throws ExportException {
        if (this.lastMuxerInputBufferTimestampUs == 0) {
            this.hasMuxedTimestampZero = true;
        }
        this.encoderWrapper.releaseOutputBuffer(false);
        this.videoGraph.onEncoderBufferReleased();
    }
}
