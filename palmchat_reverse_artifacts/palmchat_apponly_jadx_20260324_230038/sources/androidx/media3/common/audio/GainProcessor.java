package androidx.media3.common.audio;

import androidx.annotation.IntRange;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import j$.util.Objects;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class GainProcessor extends BaseAudioProcessor {
    private final GainProvider gainProvider;
    private long readFrames;

    /* JADX INFO: compiled from: SearchBox */
    public interface GainProvider {
        float getGainFactorAtSamplePosition(@IntRange(from = 0) long j, @IntRange(from = 1) int i);

        long isUnityUntil(@IntRange(from = 0) long j, @IntRange(from = 1) int i);
    }

    public GainProcessor(GainProvider gainProvider) {
        this.gainProvider = (GainProvider) Assertions.checkNotNull(gainProvider);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return (!super.isActive() || Objects.equals(this.inputAudioFormat, AudioProcessor.AudioFormat.NOT_SET) || this.gainProvider.isUnityUntil(0L, this.inputAudioFormat.sampleRate) == Long.MIN_VALUE) ? false : true;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i == 2 || i == 4) {
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException("Invalid PCM encoding. Expected 16 bit PCM or float PCM.", audioFormat);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public void onFlush() {
        this.readFrames = 0L;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public void onReset() {
        this.readFrames = 0L;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        Assertions.checkState(!Objects.equals(this.inputAudioFormat, AudioProcessor.AudioFormat.NOT_SET), "Audio processor must be configured and flushed before calling queueInput().");
        if (byteBuffer.hasRemaining()) {
            Assertions.checkArgument(byteBuffer.remaining() % this.inputAudioFormat.bytesPerFrame == 0, "Queued an incomplete frame.");
            ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(byteBuffer.remaining());
            while (byteBuffer.hasRemaining()) {
                float gainFactorAtSamplePosition = this.gainProvider.getGainFactorAtSamplePosition(this.readFrames, this.inputAudioFormat.sampleRate);
                if (gainFactorAtSamplePosition != 1.0f) {
                    int i = 0;
                    while (true) {
                        AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
                        if (i >= audioFormat.channelCount) {
                            this.readFrames++;
                            break;
                        }
                        int i2 = audioFormat.encoding;
                        if (i2 == 2) {
                            byteBufferReplaceOutputBuffer.putShort((short) (byteBuffer.getShort() * gainFactorAtSamplePosition));
                        } else {
                            if (i2 != 4) {
                                throw new IllegalStateException("Unexpected PCM encoding: " + this.inputAudioFormat.encoding);
                            }
                            byteBufferReplaceOutputBuffer.putFloat(byteBuffer.getFloat() * gainFactorAtSamplePosition);
                        }
                        i++;
                    }
                } else {
                    int iLimit = byteBuffer.limit();
                    long jIsUnityUntil = this.gainProvider.isUnityUntil(this.readFrames, this.inputAudioFormat.sampleRate);
                    Assertions.checkState(jIsUnityUntil != -9223372036854775807L, "Expected a valid end boundary for unity region.");
                    if (jIsUnityUntil != Long.MIN_VALUE) {
                        byteBuffer.limit(Math.min(iLimit, ((int) ((jIsUnityUntil - this.readFrames) * ((long) this.inputAudioFormat.bytesPerFrame))) + byteBuffer.position()));
                    }
                    this.readFrames += (long) (byteBuffer.remaining() / this.inputAudioFormat.bytesPerFrame);
                    byteBufferReplaceOutputBuffer.put(byteBuffer);
                    byteBuffer.limit(iLimit);
                }
            }
            byteBufferReplaceOutputBuffer.flip();
        }
    }
}
