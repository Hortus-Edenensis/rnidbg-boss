package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Gainmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class BitmapTextureManager extends TextureManager {
    private boolean currentInputStreamEnded;

    @Nullable
    private GlTextureInfo currentSdrGlTextureInfo;
    private int downstreamShaderProgramCapacity;
    private final GlObjectsProvider glObjectsProvider;
    private boolean isNextFrameInTexture;
    private final Queue<BitmapFrameSequenceInfo> pendingBitmaps;
    private RepeatingGainmapShaderProgram repeatingGainmapShaderProgram;
    private final boolean signalRepeatingSequence;

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

    public BitmapTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z) {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        this.pendingBitmaps = new LinkedBlockingQueue();
        this.signalRepeatingSequence = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$0() throws VideoFrameProcessingException, GlUtil.GlException {
        this.downstreamShaderProgramCapacity++;
        maybeQueueToShaderProgram();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputBitmap$1(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException, GlUtil.GlException {
        setupBitmap(bitmap, frameInfo, timestampIterator);
        this.currentInputStreamEnded = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3() throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
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
            ((RepeatingGainmapShaderProgram) Assertions.checkNotNull(this.repeatingGainmapShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_BITMAP_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
        }
    }

    private void maybeQueueToShaderProgram() throws VideoFrameProcessingException {
        if (this.pendingBitmaps.isEmpty() || this.downstreamShaderProgramCapacity == 0) {
            return;
        }
        BitmapFrameSequenceInfo bitmapFrameSequenceInfoElement = this.pendingBitmaps.element();
        FrameInfo frameInfo = bitmapFrameSequenceInfoElement.frameInfo;
        TimestampIterator timestampIterator = bitmapFrameSequenceInfoElement.inStreamOffsetsUs;
        Assertions.checkState(bitmapFrameSequenceInfoElement.inStreamOffsetsUs.hasNext());
        long next = bitmapFrameSequenceInfoElement.frameInfo.offsetToAddUs + timestampIterator.next();
        if (!this.isNextFrameInTexture) {
            this.isNextFrameInTexture = true;
            updateCurrentGlTextureInfo(frameInfo, bitmapFrameSequenceInfoElement.bitmap);
        }
        this.downstreamShaderProgramCapacity--;
        ((RepeatingGainmapShaderProgram) Assertions.checkNotNull(this.repeatingGainmapShaderProgram)).queueInputFrame(this.glObjectsProvider, (GlTextureInfo) Assertions.checkNotNull(this.currentSdrGlTextureInfo), next);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_QUEUE_BITMAP, next, "%dx%d", Integer.valueOf(frameInfo.format.width), Integer.valueOf(frameInfo.format.height));
        if (bitmapFrameSequenceInfoElement.inStreamOffsetsUs.hasNext()) {
            return;
        }
        this.isNextFrameInTexture = false;
        this.pendingBitmaps.remove().bitmap.recycle();
        if (this.pendingBitmaps.isEmpty() && this.currentInputStreamEnded) {
            ((RepeatingGainmapShaderProgram) Assertions.checkNotNull(this.repeatingGainmapShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_BITMAP_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
            this.currentInputStreamEnded = false;
        }
    }

    private void setupBitmap(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException {
        Assertions.checkArgument(timestampIterator.hasNext(), "Bitmap queued but no timestamps provided.");
        this.pendingBitmaps.add(new BitmapFrameSequenceInfo(bitmap, frameInfo, timestampIterator));
        maybeQueueToShaderProgram();
    }

    private void updateCurrentGlTextureInfo(FrameInfo frameInfo, Bitmap bitmap) throws VideoFrameProcessingException {
        try {
            GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
            if (glTextureInfo != null) {
                glTextureInfo.release();
            }
            int iCreateTexture = GlUtil.createTexture(bitmap);
            Format format = frameInfo.format;
            this.currentSdrGlTextureInfo = new GlTextureInfo(iCreateTexture, -1, -1, format.width, format.height);
            if (Build.VERSION.SDK_INT >= 34 && bitmap.hasGainmap()) {
                ((RepeatingGainmapShaderProgram) Assertions.checkNotNull(this.repeatingGainmapShaderProgram)).setGainmap((Gainmap) Assertions.checkNotNull(bitmap.getGainmap()));
            }
            if (this.signalRepeatingSequence) {
                ((RepeatingGainmapShaderProgram) Assertions.checkNotNull(this.repeatingGainmapShaderProgram)).signalNewRepeatingFrameSequence();
            }
        } catch (GlUtil.GlException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void flush() throws VideoFrameProcessingException {
        this.pendingBitmaps.clear();
        this.isNextFrameInTexture = false;
        this.currentInputStreamEnded = false;
        this.downstreamShaderProgramCapacity = 0;
        GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
        if (glTextureInfo != null) {
            try {
                glTextureInfo.release();
                this.currentSdrGlTextureInfo = null;
            } catch (GlUtil.GlException e) {
                throw VideoFrameProcessingException.from(e);
            }
        }
        super.flush();
    }

    @Override // androidx.media3.effect.TextureManager
    public int getPendingFrameCount() {
        return 0;
    }

    @Override // androidx.media3.effect.TextureManager, androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.a
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1300a.lambda$onReadyToAcceptInputFrame$0();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void queueInputBitmap(final Bitmap bitmap, final FrameInfo frameInfo, final TimestampIterator timestampIterator) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.d
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1309a.lambda$queueInputBitmap$1(bitmap, frameInfo, timestampIterator);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void release() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.b
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1303a.lambda$release$3();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        Assertions.checkState(glShaderProgram instanceof RepeatingGainmapShaderProgram);
        this.downstreamShaderProgramCapacity = 0;
        this.repeatingGainmapShaderProgram = (RepeatingGainmapShaderProgram) glShaderProgram;
    }

    @Override // androidx.media3.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.c
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1306a.lambda$signalEndOfCurrentInputStream$2();
            }
        });
    }
}
