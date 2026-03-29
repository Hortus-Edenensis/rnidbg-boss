package androidx.media3.transformer;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioMixingUtil;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultAudioMixer implements AudioMixer {
    private static final int DEFAULT_BUFFER_SIZE_MS = 500;
    private int bufferSizeFrames;
    private final boolean clipFloatOutput;
    private long endPosition;
    private long inputLimit;
    private long maxPositionOfRemovedSources;
    private long mixerStartTimeUs;
    private MixingBuffer[] mixingBuffers;
    private int nextSourceId;
    private AudioProcessor.AudioFormat outputAudioFormat;
    private long outputPosition;
    private final boolean outputSilenceWithNoSources;
    private final SparseArray<SourceInfo> sources;
    private final boolean useConstantPowerMixingMatrices;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements AudioMixer.Factory {
        private final boolean clipFloatOutput;
        private final boolean outputSilenceWithNoSources;
        private final boolean useConstantPowerMixingMatrices;

        public Factory() {
            this(false, true, false);
        }

        public Factory(boolean z, boolean z2) {
            this(z, z2, false);
        }

        @Override // androidx.media3.transformer.AudioMixer.Factory
        public DefaultAudioMixer create() {
            return new DefaultAudioMixer(this.outputSilenceWithNoSources, this.clipFloatOutput, this.useConstantPowerMixingMatrices);
        }

        public Factory(boolean z, boolean z2, boolean z3) {
            this.outputSilenceWithNoSources = z;
            this.clipFloatOutput = z2;
            this.useConstantPowerMixingMatrices = z3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MixingBuffer {
        public final ByteBuffer buffer;
        public final long limit;
        public final long position;

        public MixingBuffer(ByteBuffer byteBuffer, long j, long j2) {
            this.buffer = byteBuffer;
            this.position = j;
            this.limit = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class SourceInfo {
        private final AudioProcessor.AudioFormat audioFormat;
        private final ChannelMixingMatrix baseChannelMixingMatrix;
        private ChannelMixingMatrix channelMixingMatrix;
        public long position;

        public SourceInfo(AudioProcessor.AudioFormat audioFormat, ChannelMixingMatrix channelMixingMatrix, long j) {
            this.audioFormat = audioFormat;
            this.baseChannelMixingMatrix = channelMixingMatrix;
            this.position = j;
            this.channelMixingMatrix = channelMixingMatrix;
        }

        public void discardTo(ByteBuffer byteBuffer, long j) {
            Assertions.checkArgument(j >= this.position);
            byteBuffer.position(byteBuffer.position() + (((int) (j - this.position)) * this.audioFormat.bytesPerFrame));
            this.position = j;
        }

        public ChannelMixingMatrix getChannelMixingMatrix() {
            return this.channelMixingMatrix;
        }

        public long getPositionAfterBuffer(ByteBuffer byteBuffer) {
            return this.position + ((long) (byteBuffer.remaining() / this.audioFormat.bytesPerFrame));
        }

        public void mixTo(ByteBuffer byteBuffer, long j, ByteBuffer byteBuffer2, AudioProcessor.AudioFormat audioFormat) {
            Assertions.checkArgument(j >= this.position);
            AudioMixingUtil.mix(byteBuffer, this.audioFormat, byteBuffer2, audioFormat, this.channelMixingMatrix, (int) (j - this.position), true, DefaultAudioMixer.this.clipFloatOutput);
            this.position = j;
        }

        public void setVolume(float f) {
            this.channelMixingMatrix = this.baseChannelMixingMatrix.scaleBy(f);
        }
    }

    private MixingBuffer allocateMixingBuffer(long j) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(this.bufferSizeFrames * this.outputAudioFormat.bytesPerFrame).order(ByteOrder.nativeOrder());
        byteBufferOrder.mark();
        return new MixingBuffer(byteBufferOrder, j, j + ((long) this.bufferSizeFrames));
    }

    private void checkStateIsConfigured() {
        Assertions.checkState(!this.outputAudioFormat.equals(AudioProcessor.AudioFormat.NOT_SET), "Audio mixer is not configured.");
    }

    private SourceInfo getSourceById(int i) {
        Assertions.checkState(Util.contains(this.sources, i), "Source not found.");
        return this.sources.get(i);
    }

    private void updateInputFrameLimit() {
        this.inputLimit = Math.min(this.endPosition, this.outputPosition + ((long) this.bufferSizeFrames));
    }

    @Override // androidx.media3.transformer.AudioMixer
    public int addSource(AudioProcessor.AudioFormat audioFormat, long j) throws AudioProcessor.UnhandledAudioFormatException {
        checkStateIsConfigured();
        if (!supportsSourceAudioFormat(audioFormat)) {
            throw new AudioProcessor.UnhandledAudioFormatException("Can not add source. MixerFormat=" + this.outputAudioFormat, audioFormat);
        }
        long jDurationUsToSampleCount = Util.durationUsToSampleCount(j - this.mixerStartTimeUs, audioFormat.sampleRate);
        int i = this.nextSourceId;
        this.nextSourceId = i + 1;
        this.sources.append(i, new SourceInfo(audioFormat, this.useConstantPowerMixingMatrices ? ChannelMixingMatrix.createForConstantPower(audioFormat.channelCount, this.outputAudioFormat.channelCount) : ChannelMixingMatrix.createForConstantGain(audioFormat.channelCount, this.outputAudioFormat.channelCount), jDurationUsToSampleCount));
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_AUDIO_MIXER, DebugTraceUtil.EVENT_REGISTER_NEW_INPUT_STREAM, j, "source(%s):%s", Integer.valueOf(i), audioFormat);
        return i;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void configure(AudioProcessor.AudioFormat audioFormat, int i, long j) throws AudioProcessor.UnhandledAudioFormatException {
        Assertions.checkState(this.outputAudioFormat.equals(AudioProcessor.AudioFormat.NOT_SET), "Audio mixer already configured.");
        if (i == -1) {
            i = 500;
        }
        Assertions.checkArgument(i > 0);
        if (!AudioMixingUtil.canMix(audioFormat)) {
            throw new AudioProcessor.UnhandledAudioFormatException("Can not mix to this AudioFormat.", audioFormat);
        }
        this.outputAudioFormat = audioFormat;
        this.bufferSizeFrames = (i * audioFormat.sampleRate) / 1000;
        this.mixerStartTimeUs = j;
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_AUDIO_MIXER, DebugTraceUtil.EVENT_OUTPUT_FORMAT, j, "%s", audioFormat);
        this.mixingBuffers = new MixingBuffer[]{allocateMixingBuffer(0L), allocateMixingBuffer(this.bufferSizeFrames)};
        updateInputFrameLimit();
    }

    @Override // androidx.media3.transformer.AudioMixer
    public ByteBuffer getOutput() {
        checkStateIsConfigured();
        if (isEnded()) {
            return AudioProcessor.EMPTY_BUFFER;
        }
        long jMin = this.endPosition;
        if (this.sources.size() == 0) {
            jMin = Math.min(jMin, this.maxPositionOfRemovedSources);
        }
        for (int i = 0; i < this.sources.size(); i++) {
            jMin = Math.min(jMin, this.sources.valueAt(i).position);
        }
        if (jMin <= this.outputPosition) {
            return AudioProcessor.EMPTY_BUFFER;
        }
        MixingBuffer mixingBuffer = this.mixingBuffers[0];
        long jMin2 = Math.min(jMin, mixingBuffer.limit);
        ByteBuffer byteBufferDuplicate = mixingBuffer.buffer.duplicate();
        byteBufferDuplicate.position(((int) (this.outputPosition - mixingBuffer.position)) * this.outputAudioFormat.bytesPerFrame).limit(((int) (jMin2 - mixingBuffer.position)) * this.outputAudioFormat.bytesPerFrame);
        ByteBuffer byteBufferOrder = byteBufferDuplicate.slice().order(ByteOrder.nativeOrder());
        if (jMin2 == mixingBuffer.limit) {
            MixingBuffer[] mixingBufferArr = this.mixingBuffers;
            MixingBuffer mixingBuffer2 = mixingBufferArr[1];
            mixingBufferArr[0] = mixingBuffer2;
            mixingBufferArr[1] = allocateMixingBuffer(mixingBuffer2.limit);
        }
        this.outputPosition = jMin2;
        updateInputFrameLimit();
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_AUDIO_MIXER, DebugTraceUtil.EVENT_PRODUCED_OUTPUT, -9223372036854775807L, "bytesOutput=%s", Integer.valueOf(byteBufferOrder.remaining()));
        return byteBufferOrder;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public boolean hasSource(int i) {
        checkStateIsConfigured();
        return Util.contains(this.sources, i);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public boolean isEnded() {
        checkStateIsConfigured();
        long j = this.outputPosition;
        return j >= this.endPosition || (j >= this.maxPositionOfRemovedSources && this.sources.size() == 0);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void queueInput(int i, ByteBuffer byteBuffer) {
        checkStateIsConfigured();
        if (byteBuffer.hasRemaining()) {
            SourceInfo sourceById = getSourceById(i);
            if (sourceById.position >= this.inputLimit) {
                return;
            }
            long jMin = Math.min(sourceById.getPositionAfterBuffer(byteBuffer), this.inputLimit);
            if (sourceById.getChannelMixingMatrix().isZero()) {
                sourceById.discardTo(byteBuffer, jMin);
                return;
            }
            long j = sourceById.position;
            long j2 = this.outputPosition;
            if (j < j2) {
                sourceById.discardTo(byteBuffer, Math.min(jMin, j2));
                if (sourceById.position == jMin) {
                    return;
                }
            }
            for (MixingBuffer mixingBuffer : this.mixingBuffers) {
                long j3 = sourceById.position;
                if (j3 < mixingBuffer.limit) {
                    int i2 = ((int) (j3 - mixingBuffer.position)) * this.outputAudioFormat.bytesPerFrame;
                    ByteBuffer byteBuffer2 = mixingBuffer.buffer;
                    byteBuffer2.position(byteBuffer2.position() + i2);
                    sourceById.mixTo(byteBuffer, Math.min(jMin, mixingBuffer.limit), mixingBuffer.buffer, this.outputAudioFormat);
                    mixingBuffer.buffer.reset();
                    if (sourceById.position == jMin) {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void removeSource(int i) {
        checkStateIsConfigured();
        this.maxPositionOfRemovedSources = Math.max(this.maxPositionOfRemovedSources, getSourceById(i).position);
        this.sources.delete(i);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void reset() {
        this.sources.clear();
        this.nextSourceId = 0;
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.bufferSizeFrames = -1;
        this.mixingBuffers = new MixingBuffer[0];
        this.mixerStartTimeUs = -9223372036854775807L;
        this.inputLimit = -1L;
        this.outputPosition = 0L;
        this.endPosition = Long.MAX_VALUE;
        this.maxPositionOfRemovedSources = this.outputSilenceWithNoSources ? Long.MAX_VALUE : 0L;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void setEndTimeUs(long j) {
        checkStateIsConfigured();
        Assertions.checkArgument(j >= this.mixerStartTimeUs, "End time must be at least the configured start time.");
        this.endPosition = Util.durationUsToSampleCount(j - this.mixerStartTimeUs, this.outputAudioFormat.sampleRate);
        updateInputFrameLimit();
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void setSourceVolume(int i, float f) {
        checkStateIsConfigured();
        Assertions.checkArgument(f >= 0.0f, "Volume must be non-negative.");
        getSourceById(i).setVolume(f);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public boolean supportsSourceAudioFormat(AudioProcessor.AudioFormat audioFormat) {
        checkStateIsConfigured();
        return AudioMixingUtil.canMix(audioFormat, this.outputAudioFormat);
    }

    private DefaultAudioMixer(boolean z, boolean z2, boolean z3) {
        this.outputSilenceWithNoSources = z;
        this.clipFloatOutput = z2;
        this.useConstantPowerMixingMatrices = z3;
        this.sources = new SparseArray<>();
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.bufferSizeFrames = -1;
        this.mixingBuffers = new MixingBuffer[0];
        this.mixerStartTimeUs = -9223372036854775807L;
        this.inputLimit = -1L;
        this.endPosition = Long.MAX_VALUE;
        if (z) {
            this.maxPositionOfRemovedSources = Long.MAX_VALUE;
        }
    }
}
