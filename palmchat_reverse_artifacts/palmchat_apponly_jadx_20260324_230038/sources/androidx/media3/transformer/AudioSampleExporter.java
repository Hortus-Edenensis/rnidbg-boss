package androidx.media3.transformer;

import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import androidx.media3.transformer.Codec;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AudioSampleExporter extends SampleExporter {
    private final AudioGraph audioGraph;
    private final Codec encoder;
    private final AudioProcessor.AudioFormat encoderInputAudioFormat;
    private final DecoderInputBuffer encoderInputBuffer;
    private final DecoderInputBuffer encoderOutputBuffer;
    private long encoderTotalInputBytes;
    private final AudioGraphInput firstInput;
    private final Format firstInputFormat;
    private boolean returnedFirstInput;

    public AudioSampleExporter(Format format, Format format2, TransformationRequest transformationRequest, EditedMediaItem editedMediaItem, ImmutableList<AudioProcessor> immutableList, AudioMixer.Factory factory, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper, FallbackListener fallbackListener, @Nullable LogSessionId logSessionId) throws ExportException {
        super(format, muxerWrapper);
        SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
        AudioGraph audioGraph = new AudioGraph(factory, new ImmutableList.a().l(immutableList).a(sonicAudioProcessor).e());
        this.audioGraph = audioGraph;
        this.firstInputFormat = format2;
        AudioGraphInput audioGraphInputRegisterInput = audioGraph.registerInput(editedMediaItem, format2);
        AudioProcessor.AudioFormat outputAudioFormat = audioGraph.getOutputAudioFormat();
        Assertions.checkState(!outputAudioFormat.equals(AudioProcessor.AudioFormat.NOT_SET));
        Format.Builder builder = new Format.Builder();
        String str = transformationRequest.audioMimeType;
        Format formatBuild = builder.setSampleMimeType(str == null ? (String) Assertions.checkNotNull(format.sampleMimeType) : str).setSampleRate(outputAudioFormat.sampleRate).setChannelCount(outputAudioFormat.channelCount).setPcmEncoding(outputAudioFormat.encoding).setCodecs(format2.codecs).build();
        Codec codecCreateForAudioEncoding = encoderFactory.createForAudioEncoding(formatBuild.buildUpon().setSampleMimeType(SampleExporter.findSupportedMimeTypeForEncoderAndMuxer(formatBuild, muxerWrapper.getSupportedSampleMimeTypes(1))).build(), logSessionId);
        this.encoder = codecCreateForAudioEncoding;
        AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(codecCreateForAudioEncoding.getInputFormat());
        if (audioFormat.sampleRate != outputAudioFormat.sampleRate) {
            audioGraph.reset();
            sonicAudioProcessor.setOutputSampleRateHz(audioFormat.sampleRate);
            audioGraphInputRegisterInput = audioGraph.registerInput(editedMediaItem, format2);
            outputAudioFormat = audioGraph.getOutputAudioFormat();
        }
        this.firstInput = audioGraphInputRegisterInput;
        this.encoderInputAudioFormat = outputAudioFormat;
        this.encoderInputBuffer = new DecoderInputBuffer(0);
        this.encoderOutputBuffer = new DecoderInputBuffer(0);
        fallbackListener.onTransformationRequestFinalized(createFallbackTransformationRequest(transformationRequest, formatBuild, codecCreateForAudioEncoding.getConfigurationFormat()));
    }

    private static TransformationRequest createFallbackTransformationRequest(TransformationRequest transformationRequest, Format format, Format format2) {
        return Objects.equals(format.sampleMimeType, format2.sampleMimeType) ? transformationRequest : transformationRequest.buildUpon().setAudioMimeType(format2.sampleMimeType).build();
    }

    private void feedEncoder(ByteBuffer byteBuffer) throws ExportException {
        ByteBuffer byteBuffer2 = (ByteBuffer) Assertions.checkNotNull(this.encoderInputBuffer.data);
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + byteBuffer2.capacity()));
        byteBuffer2.put(byteBuffer);
        this.encoderInputBuffer.timeUs = getOutputAudioDurationUs();
        this.encoderTotalInputBytes += (long) byteBuffer2.position();
        this.encoderInputBuffer.setFlags(0);
        this.encoderInputBuffer.flip();
        byteBuffer.limit(iLimit);
        this.encoder.queueInputBuffer(this.encoderInputBuffer);
    }

    private long getOutputAudioDurationUs() {
        long j = this.encoderTotalInputBytes;
        AudioProcessor.AudioFormat audioFormat = this.encoderInputAudioFormat;
        return ((j / ((long) audioFormat.bytesPerFrame)) * 1000000) / ((long) audioFormat.sampleRate);
    }

    private void queueEndOfStreamToEncoder() throws ExportException {
        Assertions.checkState(((ByteBuffer) Assertions.checkNotNull(this.encoderInputBuffer.data)).position() == 0);
        this.encoderInputBuffer.timeUs = getOutputAudioDurationUs();
        this.encoderInputBuffer.addFlag(4);
        this.encoderInputBuffer.flip();
        this.encoder.queueInputBuffer(this.encoderInputBuffer);
    }

    @Override // androidx.media3.transformer.SampleExporter
    @Nullable
    public DecoderInputBuffer getMuxerInputBuffer() throws ExportException {
        this.encoderOutputBuffer.data = this.encoder.getOutputBuffer();
        DecoderInputBuffer decoderInputBuffer = this.encoderOutputBuffer;
        if (decoderInputBuffer.data == null) {
            return null;
        }
        decoderInputBuffer.timeUs = ((MediaCodec.BufferInfo) Assertions.checkNotNull(this.encoder.getOutputBufferInfo())).presentationTimeUs;
        this.encoderOutputBuffer.setFlags(1);
        return this.encoderOutputBuffer;
    }

    @Override // androidx.media3.transformer.SampleExporter
    @Nullable
    public Format getMuxerInputFormat() throws ExportException {
        return this.encoder.getOutputFormat();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public boolean isMuxerInputEnded() {
        return this.encoder.isEnded();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public boolean processDataUpToMuxer() throws ExportException {
        ByteBuffer output = this.audioGraph.getOutput();
        if (!this.encoder.maybeDequeueInputBuffer(this.encoderInputBuffer)) {
            return false;
        }
        if (this.audioGraph.isEnded()) {
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_AUDIO_GRAPH, DebugTraceUtil.EVENT_OUTPUT_ENDED, Long.MIN_VALUE);
            queueEndOfStreamToEncoder();
            return false;
        }
        if (!output.hasRemaining()) {
            return false;
        }
        feedEncoder(output);
        return true;
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void release() {
        this.audioGraph.reset();
        this.encoder.release();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void releaseMuxerInputBuffer() throws ExportException {
        this.encoder.releaseOutputBuffer(false);
    }

    @Override // androidx.media3.transformer.SampleExporter
    public AudioGraphInput getInput(EditedMediaItem editedMediaItem, Format format, int i) throws ExportException {
        if (this.returnedFirstInput) {
            return this.audioGraph.registerInput(editedMediaItem, format);
        }
        this.returnedFirstInput = true;
        Assertions.checkState(format.equals(this.firstInputFormat));
        return this.firstInput;
    }
}
