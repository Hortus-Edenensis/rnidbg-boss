package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AudioGraph {
    private final AudioProcessingPipeline audioProcessingPipeline;
    private int finishedInputs;
    private boolean isMixerConfigured;
    private boolean isMixerReady;
    private final AudioMixer mixer;
    private long pendingStartTimeUs;
    private final List<InputInfo> inputInfos = new ArrayList();
    private AudioProcessor.AudioFormat mixerAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private ByteBuffer mixerOutput = AudioProcessor.EMPTY_BUFFER;

    /* JADX INFO: compiled from: SearchBox */
    public static final class InputInfo {
        public final AudioGraphInput audioGraphInput;
        public int mixerSourceId = -1;

        public InputInfo(AudioGraphInput audioGraphInput) {
            this.audioGraphInput = audioGraphInput;
        }
    }

    public AudioGraph(AudioMixer.Factory factory, ImmutableList<AudioProcessor> immutableList) {
        this.mixer = factory.create();
        this.audioProcessingPipeline = new AudioProcessingPipeline(immutableList);
    }

    private boolean ensureMixerReady() throws ExportException {
        if (this.isMixerReady) {
            return true;
        }
        if (!this.isMixerConfigured) {
            try {
                this.mixer.configure(this.mixerAudioFormat, -1, this.pendingStartTimeUs);
                this.isMixerConfigured = true;
            } catch (AudioProcessor.UnhandledAudioFormatException e) {
                throw ExportException.createForAudioProcessing(e, "Error while configuring mixer");
            }
        }
        this.isMixerReady = true;
        for (int i = 0; i < this.inputInfos.size(); i++) {
            InputInfo inputInfo = this.inputInfos.get(i);
            if (inputInfo.mixerSourceId == -1) {
                AudioGraphInput audioGraphInput = inputInfo.audioGraphInput;
                try {
                    audioGraphInput.getOutput();
                    long startTimeUs = audioGraphInput.getStartTimeUs();
                    if (startTimeUs == -9223372036854775807L) {
                        this.isMixerReady = false;
                    } else if (startTimeUs != Long.MIN_VALUE) {
                        inputInfo.mixerSourceId = this.mixer.addSource(audioGraphInput.getOutputAudioFormat(), startTimeUs);
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw ExportException.createForAudioProcessing(e2, "Unhandled format while adding source " + inputInfo.mixerSourceId);
                }
            }
        }
        return this.isMixerReady;
    }

    private void feedMixer() throws ExportException {
        for (int i = 0; i < this.inputInfos.size(); i++) {
            feedMixerFromInput(this.inputInfos.get(i));
        }
    }

    private void feedMixerFromInput(InputInfo inputInfo) throws ExportException {
        int i = inputInfo.mixerSourceId;
        if (this.mixer.hasSource(i)) {
            AudioGraphInput audioGraphInput = inputInfo.audioGraphInput;
            if (audioGraphInput.isEnded()) {
                this.mixer.removeSource(i);
                inputInfo.mixerSourceId = -1;
                this.finishedInputs++;
                return;
            }
            try {
                this.mixer.queueInput(i, audioGraphInput.getOutput());
            } catch (AudioProcessor.UnhandledAudioFormatException e) {
                throw ExportException.createForAudioProcessing(e, "AudioGraphInput (sourceId=" + i + ") reconfiguration");
            }
        }
    }

    private void feedProcessingPipelineFromMixer() {
        if (isMixerEnded()) {
            this.audioProcessingPipeline.queueEndOfStream();
        } else {
            this.audioProcessingPipeline.queueInput(this.mixerOutput);
        }
    }

    public static boolean isInputAudioFormatValid(AudioProcessor.AudioFormat audioFormat) {
        return (audioFormat.encoding == -1 || audioFormat.sampleRate == -1 || audioFormat.channelCount == -1) ? false : true;
    }

    private boolean isMixerEnded() {
        return !this.mixerOutput.hasRemaining() && this.finishedInputs >= this.inputInfos.size() && this.mixer.isEnded();
    }

    public void blockInput() {
        for (int i = 0; i < this.inputInfos.size(); i++) {
            this.inputInfos.get(i).audioGraphInput.blockInput();
        }
    }

    public void flush() {
        for (int i = 0; i < this.inputInfos.size(); i++) {
            InputInfo inputInfo = this.inputInfos.get(i);
            inputInfo.mixerSourceId = -1;
            inputInfo.audioGraphInput.flush();
        }
        this.mixer.reset();
        this.isMixerConfigured = false;
        this.isMixerReady = false;
        this.mixerOutput = AudioProcessor.EMPTY_BUFFER;
        this.audioProcessingPipeline.flush();
        this.finishedInputs = 0;
    }

    public ByteBuffer getOutput() throws ExportException {
        if (!ensureMixerReady()) {
            return AudioProcessor.EMPTY_BUFFER;
        }
        if (!this.mixer.isEnded()) {
            feedMixer();
        }
        if (!this.mixerOutput.hasRemaining()) {
            this.mixerOutput = this.mixer.getOutput();
        }
        if (!this.audioProcessingPipeline.isOperational()) {
            return this.mixerOutput;
        }
        feedProcessingPipelineFromMixer();
        return this.audioProcessingPipeline.getOutput();
    }

    public AudioProcessor.AudioFormat getOutputAudioFormat() {
        return this.audioProcessingPipeline.getOutputAudioFormat();
    }

    public boolean isEnded() {
        return this.audioProcessingPipeline.isOperational() ? this.audioProcessingPipeline.isEnded() : isMixerEnded();
    }

    public AudioGraphInput registerInput(EditedMediaItem editedMediaItem, Format format) throws ExportException {
        Assertions.checkArgument(format.pcmEncoding != -1);
        try {
            AudioGraphInput audioGraphInput = new AudioGraphInput(this.mixerAudioFormat, editedMediaItem, format);
            if (Objects.equals(this.mixerAudioFormat, AudioProcessor.AudioFormat.NOT_SET)) {
                AudioProcessor.AudioFormat outputAudioFormat = audioGraphInput.getOutputAudioFormat();
                this.mixerAudioFormat = outputAudioFormat;
                this.audioProcessingPipeline.configure(outputAudioFormat);
                this.audioProcessingPipeline.flush();
            }
            this.inputInfos.add(new InputInfo(audioGraphInput));
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_AUDIO_GRAPH, DebugTraceUtil.EVENT_REGISTER_NEW_INPUT_STREAM, -9223372036854775807L, "%s", format);
            return audioGraphInput;
        } catch (AudioProcessor.UnhandledAudioFormatException e) {
            throw ExportException.createForAudioProcessing(e, "Error while registering input " + this.inputInfos.size());
        }
    }

    public void reset() {
        for (int i = 0; i < this.inputInfos.size(); i++) {
            this.inputInfos.get(i).audioGraphInput.release();
        }
        this.inputInfos.clear();
        this.mixer.reset();
        this.audioProcessingPipeline.reset();
        this.finishedInputs = 0;
        this.mixerOutput = AudioProcessor.EMPTY_BUFFER;
        this.mixerAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    }

    public void setPendingStartTimeUs(long j) {
        this.pendingStartTimeUs = j;
    }

    public void unblockInput() {
        for (int i = 0; i < this.inputInfos.size(); i++) {
            this.inputInfos.get(i).audioGraphInput.unblockInput();
        }
    }
}
