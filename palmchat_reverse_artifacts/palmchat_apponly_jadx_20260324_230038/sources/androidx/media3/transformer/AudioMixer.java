package androidx.media3.transformer;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface AudioMixer {

    /* JADX INFO: compiled from: SearchBox */
    public interface Factory {
        AudioMixer create();
    }

    int addSource(AudioProcessor.AudioFormat audioFormat, long j) throws AudioProcessor.UnhandledAudioFormatException;

    void configure(AudioProcessor.AudioFormat audioFormat, int i, long j) throws AudioProcessor.UnhandledAudioFormatException;

    ByteBuffer getOutput();

    boolean hasSource(int i);

    boolean isEnded();

    void queueInput(int i, ByteBuffer byteBuffer);

    void removeSource(int i);

    void reset();

    void setEndTimeUs(long j);

    void setSourceVolume(int i, float f);

    boolean supportsSourceAudioFormat(AudioProcessor.AudioFormat audioFormat);
}
