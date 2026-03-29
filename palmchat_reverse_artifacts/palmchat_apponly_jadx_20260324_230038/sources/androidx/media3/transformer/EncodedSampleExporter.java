package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.decoder.DecoderInputBuffer;
import defpackage.b25;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class EncodedSampleExporter extends SampleExporter implements GraphInput {

    @VisibleForTesting
    static final long ALLOCATION_SIZE_TARGET_BYTES = 2097152;
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    @VisibleForTesting
    static final int MAX_INPUT_BUFFER_COUNT = 200;

    @VisibleForTesting
    static final int MIN_INPUT_BUFFER_COUNT = 10;
    private final Queue<DecoderInputBuffer> availableInputBuffers;
    private final Format format;
    private boolean hasReachedAllocationTarget;
    private final long initialTimestampOffsetUs;
    private volatile boolean inputEnded;
    private long mediaItemOffsetUs;

    @Nullable
    private DecoderInputBuffer nextInputBuffer;
    private final AtomicLong nextMediaItemOffsetUs;
    private final Queue<DecoderInputBuffer> pendingInputBuffers;
    private long totalBufferSizeBytes;

    public EncodedSampleExporter(Format format, TransformationRequest transformationRequest, MuxerWrapper muxerWrapper, FallbackListener fallbackListener, long j) {
        super(format, muxerWrapper);
        this.format = format;
        this.initialTimestampOffsetUs = j;
        this.nextMediaItemOffsetUs = new AtomicLong();
        this.availableInputBuffers = new ConcurrentLinkedQueue();
        this.pendingInputBuffers = new ConcurrentLinkedQueue();
        fallbackListener.onTransformationRequestFinalized(transformationRequest);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    @Nullable
    public DecoderInputBuffer getInputBuffer() {
        if (this.nextInputBuffer == null) {
            DecoderInputBuffer decoderInputBufferPoll = this.availableInputBuffers.poll();
            this.nextInputBuffer = decoderInputBufferPoll;
            if (!this.hasReachedAllocationTarget) {
                if (decoderInputBufferPoll == null) {
                    DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(2);
                    this.nextInputBuffer = decoderInputBuffer;
                    decoderInputBuffer.data = EMPTY_BUFFER;
                } else {
                    this.totalBufferSizeBytes -= (long) ((ByteBuffer) Assertions.checkNotNull(decoderInputBufferPoll.data)).capacity();
                }
            }
        }
        return this.nextInputBuffer;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ Surface getInputSurface() {
        return b25.b(this);
    }

    @Override // androidx.media3.transformer.SampleExporter
    @Nullable
    public DecoderInputBuffer getMuxerInputBuffer() {
        return this.pendingInputBuffers.peek();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public Format getMuxerInputFormat() {
        return this.format;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ int getPendingVideoFrameCount() {
        return b25.c(this);
    }

    @Override // androidx.media3.transformer.SampleExporter
    public boolean isMuxerInputEnded() {
        return this.inputEnded && this.pendingInputBuffers.isEmpty();
    }

    @Override // androidx.media3.transformer.OnMediaItemChangedListener
    public void onMediaItemChanged(EditedMediaItem editedMediaItem, long j, @Nullable Format format, boolean z) {
        this.mediaItemOffsetUs = this.nextMediaItemOffsetUs.get();
        this.nextMediaItemOffsetUs.addAndGet(j);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public /* synthetic */ int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        return b25.d(this, bitmap, timestampIterator);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public boolean queueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.checkNotNull(this.nextInputBuffer);
        this.nextInputBuffer = null;
        if (decoderInputBuffer.isEndOfStream()) {
            this.inputEnded = true;
        } else {
            decoderInputBuffer.timeUs += this.mediaItemOffsetUs + this.initialTimestampOffsetUs;
            this.pendingInputBuffers.add(decoderInputBuffer);
        }
        if (!this.hasReachedAllocationTarget) {
            int size = this.availableInputBuffers.size() + this.pendingInputBuffers.size();
            long jCapacity = this.totalBufferSizeBytes + ((long) ((ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data)).capacity());
            this.totalBufferSizeBytes = jCapacity;
            this.hasReachedAllocationTarget = size >= 10 && (size >= 200 || jCapacity >= 2097152);
        }
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

    @Override // androidx.media3.transformer.SampleExporter
    public void releaseMuxerInputBuffer() {
        DecoderInputBuffer decoderInputBufferRemove = this.pendingInputBuffers.remove();
        decoderInputBufferRemove.clear();
        decoderInputBufferRemove.timeUs = 0L;
        this.availableInputBuffers.add(decoderInputBufferRemove);
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

    @Override // androidx.media3.transformer.SampleExporter
    public void release() {
    }

    @Override // androidx.media3.transformer.SampleExporter
    public GraphInput getInput(EditedMediaItem editedMediaItem, Format format, int i) {
        return this;
    }
}
