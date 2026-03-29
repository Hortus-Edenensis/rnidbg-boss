package androidx.media3.transformer;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.AudioSink;
import defpackage.bm;
import j$.util.Objects;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AudioGraphInputAudioSink implements AudioSink {
    private final Controller controller;

    @Nullable
    private EditedMediaItemInfo currentEditedMediaItemInfo;

    @Nullable
    private Format currentInputFormat;
    private long inputPositionUs;
    private boolean inputStreamEnded;
    private long offsetToCompositionTimeUs;

    @Nullable
    private AudioGraphInput outputGraphInput;
    private boolean signalledEndOfStream;

    /* JADX INFO: compiled from: SearchBox */
    public interface Controller {
        @Nullable
        AudioGraphInput getAudioGraphInput(EditedMediaItem editedMediaItem, Format format) throws ExportException;

        long getCurrentPositionUs(boolean z);

        boolean hasPendingData();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EditedMediaItemInfo {
        public final EditedMediaItem editedMediaItem;
        public final boolean isLastInSequence;

        public EditedMediaItemInfo(EditedMediaItem editedMediaItem, boolean z) {
            this.editedMediaItem = editedMediaItem;
            this.isLastInSequence = z;
        }
    }

    public AudioGraphInputAudioSink(Controller controller) {
        this.controller = controller;
    }

    private long getCompositionPlayerPositionUs() {
        long currentPositionUs = this.controller.getCurrentPositionUs(this.inputStreamEnded);
        return currentPositionUs != Long.MIN_VALUE ? currentPositionUs - this.offsetToCompositionTimeUs : currentPositionUs;
    }

    private boolean handleBufferInternal(ByteBuffer byteBuffer, long j, int i) {
        Assertions.checkStateNotNull(this.currentInputFormat);
        Assertions.checkState(!this.signalledEndOfStream);
        AudioGraphInput audioGraphInput = (AudioGraphInput) Assertions.checkNotNull(this.outputGraphInput);
        DecoderInputBuffer inputBuffer = audioGraphInput.getInputBuffer();
        if (inputBuffer == null) {
            return false;
        }
        inputBuffer.ensureSpaceForWrite(byteBuffer.remaining());
        ((ByteBuffer) Assertions.checkNotNull(inputBuffer.data)).put(byteBuffer).flip();
        inputBuffer.timeUs = j != Long.MIN_VALUE ? this.offsetToCompositionTimeUs + j : Long.MIN_VALUE;
        inputBuffer.setFlags(i);
        boolean zQueueInputBuffer = audioGraphInput.queueInputBuffer();
        if (zQueueInputBuffer) {
            this.inputPositionUs = j + Util.sampleCountToDurationUs(r2 / Util.getPcmFrameSize(r9.pcmEncoding, r9.channelCount), ((Format) Assertions.checkNotNull(this.currentInputFormat)).sampleRate);
        }
        return zQueueInputBuffer;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void configure(Format format, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        Assertions.checkArgument(supportsFormat(format));
        EditedMediaItem editedMediaItem = ((EditedMediaItemInfo) Assertions.checkStateNotNull(this.currentEditedMediaItemInfo)).editedMediaItem;
        Assertions.checkArgument(iArr == null);
        this.currentInputFormat = format;
        AudioGraphInput audioGraphInput = this.outputGraphInput;
        if (audioGraphInput != null) {
            audioGraphInput.onMediaItemChanged(editedMediaItem, -9223372036854775807L, format, false);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        this.inputStreamEnded = false;
        this.signalledEndOfStream = false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    @Nullable
    public AudioAttributes getAudioAttributes() {
        return null;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long getAudioTrackBufferSizeUs() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        return isEnded() ? this.inputPositionUs : getCompositionPlayerPositionUs();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ AudioOffloadSupport getFormatOffloadSupport(Format format) {
        return bm.a(this, format);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int getFormatSupport(Format format) {
        return (Objects.equals(format.sampleMimeType, "audio/raw") && format.pcmEncoding == 2) ? 2 : 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException {
        Assertions.checkState(!this.inputStreamEnded);
        EditedMediaItem editedMediaItem = ((EditedMediaItemInfo) Assertions.checkStateNotNull(this.currentEditedMediaItemInfo)).editedMediaItem;
        if (this.outputGraphInput == null) {
            try {
                AudioGraphInput audioGraphInput = this.controller.getAudioGraphInput(editedMediaItem, (Format) Assertions.checkStateNotNull(this.currentInputFormat));
                if (audioGraphInput == null) {
                    return false;
                }
                this.outputGraphInput = audioGraphInput;
                audioGraphInput.onMediaItemChanged(editedMediaItem, -9223372036854775807L, this.currentInputFormat, false);
            } catch (ExportException e) {
                throw new AudioSink.InitializationException("Error creating AudioGraphInput", 0, this.currentInputFormat, false, e);
            }
        }
        return handleBufferInternal(byteBuffer, j, 0);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean hasPendingData() {
        return this.controller.hasPendingData();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean isEnded() {
        return this.currentInputFormat == null ? this.inputStreamEnded : this.inputStreamEnded && getCompositionPlayerPositionUs() >= this.inputPositionUs;
    }

    public void onMediaItemChanged(EditedMediaItem editedMediaItem, long j, boolean z) {
        this.currentEditedMediaItemInfo = new EditedMediaItemInfo(editedMediaItem, z);
        this.offsetToCompositionTimeUs = j;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void playToEndOfStream() {
        this.inputStreamEnded = true;
        if (this.currentInputFormat == null || this.signalledEndOfStream || !((EditedMediaItemInfo) Assertions.checkStateNotNull(this.currentEditedMediaItemInfo)).isLastInSequence) {
            return;
        }
        this.signalledEndOfStream = handleBufferInternal(AudioProcessor.EMPTY_BUFFER, Long.MIN_VALUE, 4);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void release() {
        bm.b(this);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        flush();
        this.currentInputFormat = null;
        this.currentEditedMediaItemInfo = null;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setClock(Clock clock) {
        bm.c(this, clock);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setOffloadDelayPadding(int i, int i2) {
        bm.d(this, i, i2);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setOffloadMode(int i) {
        bm.e(this, i);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setOutputStreamOffsetUs(long j) {
        bm.f(this, j);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setPlayerId(PlayerId playerId) {
        bm.g(this, playerId);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        bm.h(this, audioDeviceInfo);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean supportsFormat(Format format) {
        return getFormatSupport(format) == 2;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void disableTunneling() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void enableTunnelingV21() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void handleDiscontinuity() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void play() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setAudioSessionId(int i) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f) {
    }
}
