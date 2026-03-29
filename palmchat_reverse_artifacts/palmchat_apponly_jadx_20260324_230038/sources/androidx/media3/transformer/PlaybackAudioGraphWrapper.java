package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.transformer.AudioGraphInputAudioSink;
import androidx.media3.transformer.AudioMixer;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class PlaybackAudioGraphWrapper {
    private static final int PRIMARY_SEQUENCE_INDEX = 0;
    private AudioGraph audioGraph;
    private int audioGraphInputsCreated;
    private final AudioSink finalAudioSink;
    private boolean hasRegisteredPrimaryFormat;
    private int inputAudioSinksCreated;
    private boolean isRenderingStarted;
    private final AudioMixer.Factory mixerFactory;
    private long outputFramesWritten;
    private long seekPositionUs;
    private AudioProcessor.AudioFormat outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private ImmutableList<AudioProcessor> effects = ImmutableList.of();

    /* JADX INFO: compiled from: SearchBox */
    public final class SinkController implements AudioGraphInputAudioSink.Controller {
        private final boolean isSequencePrimary;

        public SinkController(int i) {
            this.isSequencePrimary = i == 0;
            PlaybackAudioGraphWrapper.access$008(PlaybackAudioGraphWrapper.this);
        }

        @Override // androidx.media3.transformer.AudioGraphInputAudioSink.Controller
        @Nullable
        public AudioGraphInput getAudioGraphInput(EditedMediaItem editedMediaItem, Format format) throws ExportException {
            if (!this.isSequencePrimary && !PlaybackAudioGraphWrapper.this.hasRegisteredPrimaryFormat) {
                return null;
            }
            AudioGraphInput audioGraphInputRegisterInput = ((AudioGraph) Assertions.checkNotNull(PlaybackAudioGraphWrapper.this.audioGraph)).registerInput(editedMediaItem, format);
            PlaybackAudioGraphWrapper.access$308(PlaybackAudioGraphWrapper.this);
            if (this.isSequencePrimary) {
                PlaybackAudioGraphWrapper.this.hasRegisteredPrimaryFormat = true;
            }
            return audioGraphInputRegisterInput;
        }

        @Override // androidx.media3.transformer.AudioGraphInputAudioSink.Controller
        public long getCurrentPositionUs(boolean z) {
            return PlaybackAudioGraphWrapper.this.finalAudioSink.getCurrentPositionUs(z);
        }

        @Override // androidx.media3.transformer.AudioGraphInputAudioSink.Controller
        public boolean hasPendingData() {
            return PlaybackAudioGraphWrapper.this.finalAudioSink.hasPendingData();
        }
    }

    public PlaybackAudioGraphWrapper(AudioMixer.Factory factory, AudioSink audioSink) {
        this.finalAudioSink = audioSink;
        this.mixerFactory = factory;
    }

    public static /* synthetic */ int access$008(PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
        int i = playbackAudioGraphWrapper.inputAudioSinksCreated;
        playbackAudioGraphWrapper.inputAudioSinksCreated = i + 1;
        return i;
    }

    public static /* synthetic */ int access$308(PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
        int i = playbackAudioGraphWrapper.audioGraphInputsCreated;
        playbackAudioGraphWrapper.audioGraphInputsCreated = i + 1;
        return i;
    }

    private long getBufferPresentationTimeUs() {
        return this.seekPositionUs + Util.sampleCountToDurationUs(this.outputFramesWritten, this.outputAudioFormat.sampleRate);
    }

    public AudioGraphInputAudioSink createInput(int i) {
        return new AudioGraphInputAudioSink(new SinkController(i));
    }

    public void endSeek() {
        ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).unblockInput();
    }

    public boolean processData() throws ExportException, AudioSink.WriteException, AudioSink.InitializationException, AudioSink.ConfigurationException {
        int i = this.inputAudioSinksCreated;
        if (i == 0 || i != this.audioGraphInputsCreated) {
            return false;
        }
        AudioProcessor.AudioFormat audioFormat = this.outputAudioFormat;
        AudioProcessor.AudioFormat audioFormat2 = AudioProcessor.AudioFormat.NOT_SET;
        if (Objects.equals(audioFormat, audioFormat2)) {
            AudioProcessor.AudioFormat outputAudioFormat = ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).getOutputAudioFormat();
            if (Objects.equals(outputAudioFormat, audioFormat2)) {
                return false;
            }
            this.finalAudioSink.configure(Util.getPcmFormat(outputAudioFormat), 0, null);
            this.outputAudioFormat = outputAudioFormat;
        }
        if (((AudioGraph) Assertions.checkNotNull(this.audioGraph)).isEnded()) {
            if (this.finalAudioSink.isEnded()) {
                return false;
            }
            this.finalAudioSink.playToEndOfStream();
            return false;
        }
        ByteBuffer output = ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).getOutput();
        if (!output.hasRemaining()) {
            return false;
        }
        int iRemaining = output.remaining();
        boolean zHandleBuffer = this.finalAudioSink.handleBuffer(output, getBufferPresentationTimeUs(), 1);
        this.outputFramesWritten += (long) ((iRemaining - output.remaining()) / this.outputAudioFormat.bytesPerFrame);
        return zHandleBuffer;
    }

    public void release() {
        AudioGraph audioGraph = this.audioGraph;
        if (audioGraph != null) {
            audioGraph.reset();
        }
        this.finalAudioSink.reset();
        this.finalAudioSink.release();
        this.audioGraphInputsCreated = 0;
        this.inputAudioSinksCreated = 0;
    }

    public void setAudioProcessors(List<AudioProcessor> list) {
        if (this.audioGraph != null) {
            throw new UnsupportedOperationException("Setting AudioProcessors after creating the AudioGraph is not supported");
        }
        ImmutableList<AudioProcessor> immutableListCopyOf = ImmutableList.copyOf((Collection) list);
        this.effects = immutableListCopyOf;
        this.audioGraph = new AudioGraph(this.mixerFactory, immutableListCopyOf);
    }

    public void setVolume(float f) {
        this.finalAudioSink.setVolume(f);
    }

    public void startRendering() {
        this.finalAudioSink.play();
        this.isRenderingStarted = true;
    }

    public void startSeek(long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        stopRendering();
        ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).blockInput();
        ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).setPendingStartTimeUs(j);
        ((AudioGraph) Assertions.checkNotNull(this.audioGraph)).flush();
        this.finalAudioSink.flush();
        this.outputFramesWritten = 0L;
        this.seekPositionUs = j;
    }

    public void stopRendering() {
        if (this.isRenderingStarted) {
            this.finalAudioSink.pause();
            this.isRenderingStarted = false;
        }
    }
}
