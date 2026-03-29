package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingAudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.SpeedChangingAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.common.collect.ImmutableList;
import defpackage.b25;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AudioGraphInput implements GraphInput {
    private static final long MAX_AUDIO_DRIFT_ALLOWED_US = 2000;
    private static final int MAX_INPUT_BUFFER_COUNT = 10;
    private AudioProcessingPipeline audioProcessingPipeline;
    private final Queue<DecoderInputBuffer> availableInputBuffers;

    @Nullable
    private DecoderInputBuffer currentInputBufferBeingOutput;
    private long currentItemExpectedInputDurationUs;
    private long currentItemInputBytesRead;
    private boolean currentItemSilenceAppended;
    private boolean inputBlocked;
    private boolean isCurrentItemLast;
    private final AudioProcessor.AudioFormat outputAudioFormat;
    private final Queue<DecoderInputBuffer> pendingInputBuffers;
    private final Queue<MediaItemChange> pendingMediaItemChanges;
    private boolean processedFirstMediaItemChange;
    private boolean queueEndOfStreamAfterSilence;
    private boolean receivedEndOfStreamFromInput;
    private SilentAudioGenerator silentAudioGenerator;
    private final AtomicLong startTimeUs;

    /* JADX INFO: compiled from: SearchBox */
    public static final class MediaItemChange {
        public final long durationUs;
        public final EditedMediaItem editedMediaItem;

        @Nullable
        public final Format format;
        public final boolean isLast;

        public MediaItemChange(EditedMediaItem editedMediaItem, long j, @Nullable Format format, boolean z) {
            this.editedMediaItem = editedMediaItem;
            this.durationUs = j;
            this.format = format;
            this.isLast = z;
        }
    }

    public AudioGraphInput(AudioProcessor.AudioFormat audioFormat, EditedMediaItem editedMediaItem, Format format) throws AudioProcessor.UnhandledAudioFormatException {
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(format);
        Assertions.checkArgument(AudioGraph.isInputAudioFormatValid(audioFormat2), audioFormat2);
        this.availableInputBuffers = new ConcurrentLinkedQueue();
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
        for (int i = 0; i < 10; i++) {
            DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(2);
            decoderInputBuffer.data = byteBufferOrder;
            this.availableInputBuffers.add(decoderInputBuffer);
        }
        this.pendingInputBuffers = new ConcurrentLinkedQueue();
        this.pendingMediaItemChanges = new ConcurrentLinkedQueue();
        this.silentAudioGenerator = new SilentAudioGenerator(audioFormat2);
        AudioProcessingPipeline audioProcessingPipelineConfigureProcessing = configureProcessing(editedMediaItem, format, audioFormat2, audioFormat);
        this.audioProcessingPipeline = audioProcessingPipelineConfigureProcessing;
        audioProcessingPipelineConfigureProcessing.flush();
        AudioProcessor.AudioFormat outputAudioFormat = this.audioProcessingPipeline.getOutputAudioFormat();
        this.outputAudioFormat = outputAudioFormat;
        Assertions.checkArgument(outputAudioFormat.encoding == 2, outputAudioFormat);
        this.startTimeUs = new AtomicLong(-9223372036854775807L);
        this.currentItemExpectedInputDurationUs = -9223372036854775807L;
    }

    private void appendSilence() {
        this.silentAudioGenerator.addSilence(this.currentItemExpectedInputDurationUs - currentItemActualInputDurationUs());
        this.currentItemSilenceAppended = true;
        if (this.isCurrentItemLast) {
            this.queueEndOfStreamAfterSilence = true;
        }
    }

    private void clearAndAddToAvailableBuffers(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.clear();
        decoderInputBuffer.timeUs = 0L;
        this.availableInputBuffers.add(decoderInputBuffer);
    }

    private void configureForPendingMediaItemChange() throws AudioProcessor.UnhandledAudioFormatException {
        AudioProcessor.AudioFormat audioFormat;
        MediaItemChange mediaItemChange = (MediaItemChange) Assertions.checkStateNotNull(this.pendingMediaItemChanges.poll());
        this.currentItemInputBytesRead = 0L;
        this.isCurrentItemLast = mediaItemChange.isLast;
        this.currentItemSilenceAppended = false;
        if (mediaItemChange.format != null) {
            this.currentItemExpectedInputDurationUs = mediaItemChange.durationUs;
            audioFormat = new AudioProcessor.AudioFormat(mediaItemChange.format);
            this.silentAudioGenerator = new SilentAudioGenerator(audioFormat);
        } else {
            if (mediaItemChange.editedMediaItem.effects.audioProcessors.isEmpty()) {
                this.currentItemExpectedInputDurationUs = mediaItemChange.editedMediaItem.getDurationAfterEffectsApplied(mediaItemChange.durationUs);
            } else {
                this.currentItemExpectedInputDurationUs = mediaItemChange.durationUs;
            }
            AudioProcessor.AudioFormat audioFormat2 = this.silentAudioGenerator.audioFormat;
            this.startTimeUs.compareAndSet(-9223372036854775807L, 0L);
            appendSilence();
            audioFormat = audioFormat2;
        }
        if (this.processedFirstMediaItemChange) {
            this.audioProcessingPipeline = configureProcessing(mediaItemChange.editedMediaItem, mediaItemChange.format, audioFormat, this.outputAudioFormat);
        }
        this.audioProcessingPipeline.flush();
        this.receivedEndOfStreamFromInput = false;
        this.processedFirstMediaItemChange = true;
    }

    private static AudioProcessingPipeline configureProcessing(EditedMediaItem editedMediaItem, @Nullable Format format, AudioProcessor.AudioFormat audioFormat, AudioProcessor.AudioFormat audioFormat2) throws AudioProcessor.UnhandledAudioFormatException {
        int i;
        int i2;
        Metadata metadata;
        ImmutableList.a aVar = new ImmutableList.a();
        if (editedMediaItem.flattenForSlowMotion && format != null && (metadata = format.metadata) != null) {
            aVar.a(new SpeedChangingAudioProcessor(new SegmentSpeedProvider(metadata)));
        }
        aVar.l(editedMediaItem.effects.audioProcessors);
        if (audioFormat2.sampleRate != -1) {
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            sonicAudioProcessor.setOutputSampleRateHz(audioFormat2.sampleRate);
            aVar.a(sonicAudioProcessor);
        }
        int i3 = audioFormat2.channelCount;
        if (i3 == 1 || i3 == 2) {
            ChannelMixingAudioProcessor channelMixingAudioProcessor = new ChannelMixingAudioProcessor();
            channelMixingAudioProcessor.putChannelMixingMatrix(ChannelMixingMatrix.createForConstantGain(1, audioFormat2.channelCount));
            channelMixingAudioProcessor.putChannelMixingMatrix(ChannelMixingMatrix.createForConstantGain(2, audioFormat2.channelCount));
            aVar.a(channelMixingAudioProcessor);
        }
        AudioProcessingPipeline audioProcessingPipeline = new AudioProcessingPipeline(aVar.e());
        AudioProcessor.AudioFormat audioFormatConfigure = audioProcessingPipeline.configure(audioFormat);
        int i4 = audioFormat2.sampleRate;
        if ((i4 == -1 || i4 == audioFormatConfigure.sampleRate) && (((i = audioFormat2.channelCount) == -1 || i == audioFormatConfigure.channelCount) && ((i2 = audioFormat2.encoding) == -1 || i2 == audioFormatConfigure.encoding))) {
            return audioProcessingPipeline;
        }
        throw new AudioProcessor.UnhandledAudioFormatException("Audio can not be modified to match downstream format", audioFormat);
    }

    private long currentItemActualInputDurationUs() {
        long j = this.currentItemInputBytesRead;
        AudioProcessor.AudioFormat audioFormat = this.silentAudioGenerator.audioFormat;
        return Util.sampleCountToDurationUs(j / ((long) audioFormat.bytesPerFrame), audioFormat.sampleRate);
    }

    private ByteBuffer feedOutputFromInput() {
        if (this.silentAudioGenerator.hasRemaining()) {
            return this.silentAudioGenerator.getBuffer();
        }
        DecoderInputBuffer decoderInputBuffer = this.currentInputBufferBeingOutput;
        if (decoderInputBuffer != null) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkStateNotNull(decoderInputBuffer.data);
            if (byteBuffer.hasRemaining()) {
                return byteBuffer;
            }
            clearAndAddToAvailableBuffers((DecoderInputBuffer) Assertions.checkStateNotNull(this.currentInputBufferBeingOutput));
            this.currentInputBufferBeingOutput = null;
        }
        DecoderInputBuffer decoderInputBufferPoll = this.pendingInputBuffers.poll();
        if (decoderInputBufferPoll == null) {
            if (!this.pendingMediaItemChanges.isEmpty() && shouldAppendSilence()) {
                appendSilence();
            }
            return AudioProcessor.EMPTY_BUFFER;
        }
        ByteBuffer byteBuffer2 = decoderInputBufferPoll.data;
        this.receivedEndOfStreamFromInput = decoderInputBufferPoll.isEndOfStream();
        if (byteBuffer2 != null && byteBuffer2.hasRemaining() && !this.receivedEndOfStreamFromInput) {
            this.currentInputBufferBeingOutput = decoderInputBufferPoll;
            this.currentItemInputBytesRead += (long) byteBuffer2.remaining();
            return byteBuffer2;
        }
        clearAndAddToAvailableBuffers(decoderInputBufferPoll);
        if (this.receivedEndOfStreamFromInput && shouldAppendSilence()) {
            appendSilence();
        }
        return AudioProcessor.EMPTY_BUFFER;
    }

    private boolean feedProcessingPipelineFromInput() {
        if (this.silentAudioGenerator.hasRemaining()) {
            ByteBuffer buffer = this.silentAudioGenerator.getBuffer();
            this.audioProcessingPipeline.queueInput(buffer);
            if (buffer.hasRemaining()) {
                return false;
            }
            if (this.silentAudioGenerator.hasRemaining()) {
                return true;
            }
            this.audioProcessingPipeline.queueEndOfStream();
            return false;
        }
        DecoderInputBuffer decoderInputBufferPeek = this.pendingInputBuffers.peek();
        if (decoderInputBufferPeek == null) {
            if (!this.pendingMediaItemChanges.isEmpty()) {
                if (shouldAppendSilence()) {
                    appendSilence();
                    return true;
                }
                this.audioProcessingPipeline.queueEndOfStream();
            }
            return false;
        }
        if (decoderInputBufferPeek.isEndOfStream()) {
            if (shouldAppendSilence()) {
                appendSilence();
                clearAndAddToAvailableBuffers(this.pendingInputBuffers.remove());
                return true;
            }
            this.audioProcessingPipeline.queueEndOfStream();
            this.receivedEndOfStreamFromInput = true;
            clearAndAddToAvailableBuffers(this.pendingInputBuffers.remove());
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBufferPeek.data);
        long jRemaining = byteBuffer.remaining();
        this.audioProcessingPipeline.queueInput(byteBuffer);
        this.currentItemInputBytesRead += jRemaining - ((long) byteBuffer.remaining());
        if (byteBuffer.hasRemaining()) {
            return false;
        }
        clearAndAddToAvailableBuffers(this.pendingInputBuffers.remove());
        return true;
    }

    private ByteBuffer getOutputInternal() {
        if (!this.processedFirstMediaItemChange) {
            return AudioProcessor.EMPTY_BUFFER;
        }
        if (!this.audioProcessingPipeline.isOperational()) {
            return feedOutputFromInput();
        }
        while (feedProcessingPipelineFromInput()) {
        }
        return this.audioProcessingPipeline.getOutput();
    }

    private boolean hasDataToOutput() {
        ByteBuffer byteBuffer;
        if (!this.processedFirstMediaItemChange) {
            return false;
        }
        DecoderInputBuffer decoderInputBuffer = this.currentInputBufferBeingOutput;
        if ((decoderInputBuffer == null || (byteBuffer = decoderInputBuffer.data) == null || !byteBuffer.hasRemaining()) && !this.silentAudioGenerator.hasRemaining() && this.pendingInputBuffers.isEmpty()) {
            return this.audioProcessingPipeline.isOperational() && !this.audioProcessingPipeline.isEnded();
        }
        return true;
    }

    private boolean shouldAppendSilence() {
        if (!this.currentItemSilenceAppended) {
            long j = this.currentItemExpectedInputDurationUs;
            if (j != -9223372036854775807L && j - currentItemActualInputDurationUs() > 2000) {
                return true;
            }
        }
        return false;
    }

    public void blockInput() {
        this.inputBlocked = true;
    }

    public void flush() {
        this.pendingMediaItemChanges.clear();
        this.processedFirstMediaItemChange = true;
        if (!this.availableInputBuffers.isEmpty()) {
            clearAndAddToAvailableBuffers(this.availableInputBuffers.remove());
        }
        DecoderInputBuffer decoderInputBuffer = this.currentInputBufferBeingOutput;
        if (decoderInputBuffer != null) {
            clearAndAddToAvailableBuffers(decoderInputBuffer);
            this.currentInputBufferBeingOutput = null;
        }
        while (!this.pendingInputBuffers.isEmpty()) {
            clearAndAddToAvailableBuffers(this.pendingInputBuffers.remove());
        }
        Assertions.checkState(this.availableInputBuffers.size() == 10);
        this.silentAudioGenerator.flush();
        this.audioProcessingPipeline.flush();
        this.receivedEndOfStreamFromInput = false;
        this.queueEndOfStreamAfterSilence = false;
        this.startTimeUs.set(-9223372036854775807L);
        this.currentItemExpectedInputDurationUs = -9223372036854775807L;
        this.currentItemInputBytesRead = 0L;
        this.currentItemSilenceAppended = false;
        this.isCurrentItemLast = false;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    @Nullable
    public DecoderInputBuffer getInputBuffer() {
        if (this.inputBlocked || !this.pendingMediaItemChanges.isEmpty()) {
            return null;
        }
        return this.availableInputBuffers.peek();
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ Surface getInputSurface() {
        return b25.b(this);
    }

    public ByteBuffer getOutput() throws AudioProcessor.UnhandledAudioFormatException {
        ByteBuffer outputInternal = getOutputInternal();
        if (outputInternal.hasRemaining()) {
            return outputInternal;
        }
        if (!hasDataToOutput() && !this.pendingMediaItemChanges.isEmpty()) {
            configureForPendingMediaItemChange();
        }
        return AudioProcessor.EMPTY_BUFFER;
    }

    public AudioProcessor.AudioFormat getOutputAudioFormat() {
        return this.outputAudioFormat;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ int getPendingVideoFrameCount() {
        return b25.c(this);
    }

    public long getStartTimeUs() {
        return this.startTimeUs.get();
    }

    public boolean isEnded() {
        if (hasDataToOutput() || !this.pendingMediaItemChanges.isEmpty()) {
            return false;
        }
        if (this.currentItemExpectedInputDurationUs == -9223372036854775807L) {
            return this.receivedEndOfStreamFromInput || this.queueEndOfStreamAfterSilence;
        }
        if (this.isCurrentItemLast) {
            return this.receivedEndOfStreamFromInput || this.queueEndOfStreamAfterSilence;
        }
        return false;
    }

    @Override // androidx.media3.transformer.OnMediaItemChangedListener
    public void onMediaItemChanged(EditedMediaItem editedMediaItem, long j, @Nullable Format format, boolean z) {
        if (format == null) {
            Assertions.checkState(j != -9223372036854775807L, "Could not generate silent audio because duration is unknown.");
        } else {
            Assertions.checkState(MimeTypes.isAudio(format.sampleMimeType));
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format);
            Assertions.checkState(AudioGraph.isInputAudioFormatValid(audioFormat), audioFormat);
        }
        this.pendingMediaItemChanges.add(new MediaItemChange(editedMediaItem, j, format, z));
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        return b25.d(this, bitmap, timestampIterator);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public boolean queueInputBuffer() {
        if (this.inputBlocked) {
            return false;
        }
        Assertions.checkState(this.pendingMediaItemChanges.isEmpty());
        DecoderInputBuffer decoderInputBufferRemove = this.availableInputBuffers.remove();
        this.pendingInputBuffers.add(decoderInputBufferRemove);
        this.startTimeUs.compareAndSet(-9223372036854775807L, decoderInputBufferRemove.timeUs);
        return true;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ int queueInputTexture(int i, long j) {
        return b25.f(this, i, j);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ boolean registerVideoFrame(long j) {
        return b25.g(this, j);
    }

    public void release() {
        this.audioProcessingPipeline.reset();
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        b25.h(this, onInputFrameProcessedListener);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ void setOnInputSurfaceReadyListener(Runnable runnable) {
        b25.i(this, runnable);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ void signalEndOfVideoInput() {
        b25.j(this);
    }

    public void unblockInput() {
        this.inputBlocked = false;
    }
}
