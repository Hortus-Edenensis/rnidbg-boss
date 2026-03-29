package androidx.media3.transformer;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class SilentAudioGenerator {
    private static final int DEFAULT_BUFFER_SIZE_FRAMES = 1024;
    public final AudioProcessor.AudioFormat audioFormat;
    private final ByteBuffer internalBuffer;
    private final AtomicLong remainingBytesToOutput;

    public SilentAudioGenerator(AudioProcessor.AudioFormat audioFormat) {
        this.audioFormat = audioFormat;
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(audioFormat.bytesPerFrame * 1024).order(ByteOrder.nativeOrder());
        this.internalBuffer = byteBufferOrder;
        byteBufferOrder.flip();
        this.remainingBytesToOutput = new AtomicLong();
    }

    public void addSilence(long j) {
        this.remainingBytesToOutput.addAndGet(((long) this.audioFormat.bytesPerFrame) * Util.durationUsToSampleCount(j, this.audioFormat.sampleRate));
    }

    public void flush() {
        this.remainingBytesToOutput.set(0L);
        this.internalBuffer.position(0);
        this.internalBuffer.limit(0);
    }

    public ByteBuffer getBuffer() {
        long j = this.remainingBytesToOutput.get();
        if (!this.internalBuffer.hasRemaining()) {
            this.internalBuffer.clear();
            if (j < this.internalBuffer.capacity()) {
                this.internalBuffer.limit((int) j);
            }
            this.remainingBytesToOutput.addAndGet(-this.internalBuffer.remaining());
        }
        return this.internalBuffer;
    }

    public boolean hasRemaining() {
        return this.internalBuffer.hasRemaining() || this.remainingBytesToOutput.get() > 0;
    }
}
