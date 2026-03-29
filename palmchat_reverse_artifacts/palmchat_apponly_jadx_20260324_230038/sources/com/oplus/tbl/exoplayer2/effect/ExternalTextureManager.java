package com.oplus.tbl.exoplayer2.effect;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class ExternalTextureManager extends TextureManager {
    private static final long SURFACE_TEXTURE_TIMEOUT_MS;
    private static final long SURFACE_TEXTURE_WAIT_DELAY_MS = 10;
    private static final String TAG = "ExtTexMgr";
    private static final String TIMER_THREAD_NAME = "ExtTexMgr:Timer";
    private int availableFrameCount;

    @Nullable
    private FrameInfo currentFrame;
    private boolean currentInputStreamEnded;
    private ExternalShaderProgram externalShaderProgram;
    private final AtomicInteger externalShaderProgramInputCapacity;
    private final int externalTexId;
    private long firstTryToRemoveAllFramesTimeMs;

    @Nullable
    private Future<?> forceSignalEndOfStreamFuture;
    private final GlObjectsProvider glObjectsProvider;
    private final Queue<FrameInfo> pendingFrames;
    private final ScheduledExecutorService scheduledExecutorService;
    private boolean shouldRejectIncomingFrames;
    private final Surface surface;
    private final SurfaceTexture surfaceTexture;
    private final float[] textureTransformMatrix;

    static {
        SURFACE_TEXTURE_TIMEOUT_MS = Util.isRunningOnEmulator() ? 10000L : 500L;
    }

    public ExternalTextureManager(GlObjectsProvider glObjectsProvider, final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) throws VideoFrameProcessingException {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        try {
            int iCreateExternalTexture = GlUtil.createExternalTexture();
            this.externalTexId = iCreateExternalTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iCreateExternalTexture);
            this.surfaceTexture = surfaceTexture;
            this.textureTransformMatrix = new float[16];
            this.pendingFrames = new ConcurrentLinkedQueue();
            this.scheduledExecutorService = Util.newSingleThreadScheduledExecutor(TIMER_THREAD_NAME);
            this.externalShaderProgramInputCapacity = new AtomicInteger();
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.oplus.tbl.exoplayer2.effect.h0
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    this.f7603a.lambda$new$1(videoFrameProcessingTaskExecutor, surfaceTexture2);
                }
            });
            this.surface = new Surface(surfaceTexture);
            this.firstTryToRemoveAllFramesTimeMs = -9223372036854775807L;
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void cancelForceSignalEndOfStreamTimer() {
        Future<?> future = this.forceSignalEndOfStreamFuture;
        if (future != null) {
            future.cancel(false);
        }
        this.forceSignalEndOfStreamFuture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceSignalEndOfStream() {
        Log.w(TAG, Util.formatInvariant("Forcing EOS after missing %d frames for %d ms, with available frame count: %d", Integer.valueOf(this.pendingFrames.size()), Long.valueOf(SURFACE_TEXTURE_TIMEOUT_MS), Integer.valueOf(this.availableFrameCount)));
        this.currentInputStreamEnded = false;
        this.currentFrame = null;
        this.shouldRejectIncomingFrames = true;
        removeAllSurfaceTextureFrames();
        this.pendingFrames.clear();
        signalEndOfCurrentInputStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws VideoFrameProcessingException, GlUtil.GlException {
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_SURFACE_TEXTURE_INPUT, -9223372036854775807L);
        if (!this.shouldRejectIncomingFrames) {
            if (this.currentInputStreamEnded) {
                restartForceSignalEndOfStreamTimer();
            }
            this.availableFrameCount++;
            maybeQueueFrameToExternalShaderProgram();
            return;
        }
        this.surfaceTexture.updateTexImage();
        Log.w(TAG, "Dropping frame received on SurfaceTexture after forcing EOS: " + (this.surfaceTexture.getTimestamp() / 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, SurfaceTexture surfaceTexture) {
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.e0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7596a.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputFrameProcessed$4() throws VideoFrameProcessingException, GlUtil.GlException {
        this.currentFrame = null;
        if (!this.currentInputStreamEnded || !this.pendingFrames.isEmpty()) {
            maybeQueueFrameToExternalShaderProgram();
            return;
        }
        this.currentInputStreamEnded = false;
        ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).signalEndOfCurrentInputStream();
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_EXTERNAL_TEXTURE_MANAGER_SIGNAL_EOS, Long.MIN_VALUE);
        cancelForceSignalEndOfStreamTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$3() throws VideoFrameProcessingException, GlUtil.GlException {
        this.externalShaderProgramInputCapacity.incrementAndGet();
        maybeQueueFrameToExternalShaderProgram();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerInputFrame$5() throws VideoFrameProcessingException, GlUtil.GlException {
        this.shouldRejectIncomingFrames = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseAllFramesFromMediaCodec$9(final CountDownLatch countDownLatch) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.c0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7590a.lambda$releaseAllFramesFromMediaCodec$8(countDownLatch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartForceSignalEndOfStreamTimer$7() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.g0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f7601a.forceSignalEndOfStream();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalEndOfCurrentInputStream$6() throws VideoFrameProcessingException, GlUtil.GlException {
        if (!this.pendingFrames.isEmpty() || this.currentFrame != null) {
            this.currentInputStreamEnded = true;
            restartForceSignalEndOfStreamTimer();
        } else {
            ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_EXTERNAL_TEXTURE_MANAGER_SIGNAL_EOS, Long.MIN_VALUE);
            cancelForceSignalEndOfStreamTimer();
        }
    }

    private void maybeQueueFrameToExternalShaderProgram() {
        if (this.externalShaderProgramInputCapacity.get() == 0 || this.availableFrameCount == 0 || this.currentFrame != null) {
            return;
        }
        this.surfaceTexture.updateTexImage();
        this.availableFrameCount--;
        FrameInfo frameInfoPeek = this.pendingFrames.peek();
        this.currentFrame = frameInfoPeek;
        FrameInfo frameInfo = (FrameInfo) Assertions.checkStateNotNull(frameInfoPeek);
        this.externalShaderProgramInputCapacity.decrementAndGet();
        this.surfaceTexture.getTransformMatrix(this.textureTransformMatrix);
        ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).setTextureTransformMatrix(this.textureTransformMatrix);
        long timestamp = (this.surfaceTexture.getTimestamp() / 1000) + frameInfo.offsetToAddUs;
        TraceUtil.beginSection("queueInputFrame");
        ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).queueInputFrame(this.glObjectsProvider, new GlTextureInfo(this.externalTexId, -1, -1, frameInfo.width, frameInfo.height), timestamp);
        TraceUtil.endSection();
        Assertions.checkStateNotNull(this.pendingFrames.remove());
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_QUEUE_FRAME, timestamp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseAllFramesFromMediaCodec, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$releaseAllRegisteredFrames$2(final CountDownLatch countDownLatch) {
        removeAllSurfaceTextureFrames();
        if (this.pendingFrames.isEmpty() || (this.firstTryToRemoveAllFramesTimeMs != -9223372036854775807L && Clock.DEFAULT.currentTimeMillis() - this.firstTryToRemoveAllFramesTimeMs >= SURFACE_TEXTURE_TIMEOUT_MS)) {
            this.firstTryToRemoveAllFramesTimeMs = -9223372036854775807L;
            countDownLatch.countDown();
        } else {
            if (this.firstTryToRemoveAllFramesTimeMs == -9223372036854775807L) {
                this.firstTryToRemoveAllFramesTimeMs = Clock.DEFAULT.currentTimeMillis();
            }
            this.scheduledExecutorService.schedule(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7599a.lambda$releaseAllFramesFromMediaCodec$9(countDownLatch);
                }
            }, SURFACE_TEXTURE_WAIT_DELAY_MS, TimeUnit.MILLISECONDS);
        }
    }

    private void removeAllSurfaceTextureFrames() {
        while (true) {
            int i = this.availableFrameCount;
            if (i <= 0) {
                return;
            }
            this.availableFrameCount = i - 1;
            this.surfaceTexture.updateTexImage();
            this.pendingFrames.remove();
        }
    }

    private void restartForceSignalEndOfStreamTimer() {
        cancelForceSignalEndOfStreamTimer();
        this.forceSignalEndOfStreamFuture = this.scheduledExecutorService.schedule(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f7636a.lambda$restartForceSignalEndOfStreamTimer$7();
            }
        }, SURFACE_TEXTURE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void flush() {
        this.externalShaderProgramInputCapacity.set(0);
        this.currentFrame = null;
        this.pendingFrames.clear();
        super.flush();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public Surface getInputSurface() {
        return this.surface;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public int getPendingFrameCount() {
        return this.pendingFrames.size();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager, com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.b0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7587a.lambda$onInputFrameProcessed$4();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager, com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.y
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7634a.lambda$onReadyToAcceptInputFrame$3();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void registerInputFrame(FrameInfo frameInfo) {
        this.pendingFrames.add(frameInfo);
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.x
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7632a.lambda$registerInputFrame$5();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void release() {
        this.surfaceTexture.release();
        this.surface.release();
        this.scheduledExecutorService.shutdownNow();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void releaseAllRegisteredFrames() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.a0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7584a.lambda$releaseAllRegisteredFrames$2(countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.w(TAG, "Interrupted when waiting for MediaCodec frames to arrive.");
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setDefaultBufferSize(int i, int i2) {
        this.surfaceTexture.setDefaultBufferSize(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        Assertions.checkState(glShaderProgram instanceof ExternalShaderProgram);
        this.externalShaderProgram = (ExternalShaderProgram) glShaderProgram;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.d0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7593a.lambda$signalEndOfCurrentInputStream$6();
            }
        });
    }
}
