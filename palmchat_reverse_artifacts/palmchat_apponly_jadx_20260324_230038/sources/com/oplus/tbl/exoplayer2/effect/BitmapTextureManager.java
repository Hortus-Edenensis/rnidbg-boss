package com.oplus.tbl.exoplayer2.effect;

import android.graphics.Bitmap;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.TimestampIterator;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class BitmapTextureManager extends TextureManager {
    private static final String UNSUPPORTED_IMAGE_CONFIGURATION = "Unsupported Image Configuration: No more than 8 bits of precision should be used for each RGB channel.";
    private GlTextureInfo currentGlTextureInfo;
    private boolean currentInputStreamEnded;
    private int downstreamShaderProgramCapacity;
    private final GlObjectsProvider glObjectsProvider;
    private boolean isNextFrameInTexture;
    private final Queue<BitmapFrameSequenceInfo> pendingBitmaps;
    private GlShaderProgram shaderProgram;
    private boolean useHdr;

    /* JADX INFO: compiled from: SearchBox */
    public static final class BitmapFrameSequenceInfo {
        public final Bitmap bitmap;
        private final FrameInfo frameInfo;
        private final TimestampIterator inStreamOffsetsUs;

        public BitmapFrameSequenceInfo(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) {
            this.bitmap = bitmap;
            this.frameInfo = frameInfo;
            this.inStreamOffsetsUs = timestampIterator;
        }
    }

    public BitmapTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        this.pendingBitmaps = new LinkedBlockingQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$0() throws VideoFrameProcessingException, GlUtil.GlException {
        this.downstreamShaderProgramCapacity++;
        maybeQueueToShaderProgram();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputBitmap$1(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator, boolean z) throws VideoFrameProcessingException, GlUtil.GlException {
        setupBitmap(bitmap, frameInfo, timestampIterator, z);
        this.currentInputStreamEnded = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3() throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfo = this.currentGlTextureInfo;
        if (glTextureInfo != null) {
            glTextureInfo.release();
        }
        this.pendingBitmaps.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalEndOfCurrentInputStream$2() throws VideoFrameProcessingException, GlUtil.GlException {
        if (!this.pendingBitmaps.isEmpty()) {
            this.currentInputStreamEnded = true;
        } else {
            ((GlShaderProgram) Assertions.checkNotNull(this.shaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_BITMAP_TEXTURE_MANAGER_SIGNAL_EOS, Long.MIN_VALUE);
        }
    }

    private void maybeQueueToShaderProgram() throws VideoFrameProcessingException {
        if (this.pendingBitmaps.isEmpty() || this.downstreamShaderProgramCapacity == 0) {
            return;
        }
        BitmapFrameSequenceInfo bitmapFrameSequenceInfo = (BitmapFrameSequenceInfo) Assertions.checkNotNull(this.pendingBitmaps.peek());
        FrameInfo frameInfo = bitmapFrameSequenceInfo.frameInfo;
        TimestampIterator timestampIterator = bitmapFrameSequenceInfo.inStreamOffsetsUs;
        Assertions.checkState(bitmapFrameSequenceInfo.inStreamOffsetsUs.hasNext());
        long next = bitmapFrameSequenceInfo.frameInfo.offsetToAddUs + timestampIterator.next();
        if (!this.isNextFrameInTexture) {
            this.isNextFrameInTexture = true;
            updateCurrentGlTextureInfo(frameInfo, bitmapFrameSequenceInfo.bitmap);
        }
        this.downstreamShaderProgramCapacity--;
        ((GlShaderProgram) Assertions.checkNotNull(this.shaderProgram)).queueInputFrame(this.glObjectsProvider, (GlTextureInfo) Assertions.checkNotNull(this.currentGlTextureInfo), next);
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_QUEUE_BITMAP, next, "%dx%d", Integer.valueOf(frameInfo.width), Integer.valueOf(frameInfo.height));
        if (bitmapFrameSequenceInfo.inStreamOffsetsUs.hasNext()) {
            return;
        }
        this.isNextFrameInTexture = false;
        this.pendingBitmaps.remove().bitmap.recycle();
        if (this.pendingBitmaps.isEmpty() && this.currentInputStreamEnded) {
            ((GlShaderProgram) Assertions.checkNotNull(this.shaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_BITMAP_TEXTURE_MANAGER_SIGNAL_EOS, Long.MIN_VALUE);
            this.currentInputStreamEnded = false;
        }
    }

    private void setupBitmap(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator, boolean z) throws VideoFrameProcessingException {
        if (Util.SDK_INT >= 26) {
            Assertions.checkState(!((Bitmap.Config) Assertions.checkNotNull(bitmap.getConfig())).equals(Bitmap.Config.RGBA_F16), UNSUPPORTED_IMAGE_CONFIGURATION);
        }
        this.useHdr = z;
        Assertions.checkArgument(timestampIterator.hasNext(), "Bitmap queued but no timestamps provided.");
        this.pendingBitmaps.add(new BitmapFrameSequenceInfo(bitmap, frameInfo, timestampIterator));
        maybeQueueToShaderProgram();
    }

    private void updateCurrentGlTextureInfo(FrameInfo frameInfo, Bitmap bitmap) throws VideoFrameProcessingException {
        try {
            GlTextureInfo glTextureInfo = this.currentGlTextureInfo;
            if (glTextureInfo != null) {
                glTextureInfo.release();
            }
            this.currentGlTextureInfo = new GlTextureInfo(GlUtil.createTexture(bitmap), -1, -1, frameInfo.width, frameInfo.height);
        } catch (GlUtil.GlException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void flush() {
        this.pendingBitmaps.clear();
        super.flush();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public int getPendingFrameCount() {
        return 0;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager, com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.b
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7586a.lambda$onReadyToAcceptInputFrame$0();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void queueInputBitmap(final Bitmap bitmap, final FrameInfo frameInfo, final TimestampIterator timestampIterator, final boolean z) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.a
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7583a.lambda$queueInputBitmap$1(bitmap, frameInfo, timestampIterator, z);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void release() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.d
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7592a.lambda$release$3();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        this.downstreamShaderProgramCapacity = 0;
        this.shaderProgram = glShaderProgram;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.c
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7589a.lambda$signalEndOfCurrentInputStream$2();
            }
        });
    }
}
