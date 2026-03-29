package androidx.media3.effect;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.ss.android.ttvecamera.TECameraUtils;
import com.umeng.analytics.pro.dn;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ExternalTextureManager extends TextureManager {
    private static final float EPSILON = 1.0E-9f;
    private static final long SURFACE_TEXTURE_TIMEOUT_MS;
    private static final String TAG = "ExtTexMgr";
    private static final String TIMER_THREAD_NAME = "ExtTexMgr:Timer";
    private boolean automaticReregistration;
    private int availableFrameCount;

    @Nullable
    private FrameInfo currentFrame;
    private boolean currentInputStreamEnded;
    private final boolean experimentalAdjustSurfaceTextureTransformationMatrix;
    private ExternalShaderProgram externalShaderProgram;
    private int externalShaderProgramInputCapacity;
    private final int externalTexId;

    @Nullable
    private Future<?> forceSignalEndOfStreamFuture;
    private final GlObjectsProvider glObjectsProvider;

    @Nullable
    private FrameInfo lastRegisteredFrame;
    private final Queue<FrameInfo> pendingFrames;

    @Nullable
    private volatile RuntimeException releaseAllFramesException;

    @Nullable
    private CountDownLatch releaseAllFramesLatch;
    private final ScheduledExecutorService scheduledExecutorService;
    private volatile boolean shouldRejectIncomingFrames;
    private final Surface surface;
    private final SurfaceTexture surfaceTexture;
    private final float[] textureTransformMatrix;
    private static final int[] TRANSFORMATION_MATRIX_EXPECTED_ZERO_INDICES = {2, 3, 6, 7, 8, 9, 11, 14};
    private static final int[] ADDITIONAL_CANDIDATE_BUFFER_SIZE_GUESSES = {TECameraUtils.CAPTURE_NORMAL, 1088};

    static {
        SURFACE_TEXTURE_TIMEOUT_MS = Util.isRunningOnEmulator() ? 20000L : 500L;
    }

    public ExternalTextureManager(GlObjectsProvider glObjectsProvider, final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z, boolean z2) throws VideoFrameProcessingException {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        this.automaticReregistration = z;
        this.experimentalAdjustSurfaceTextureTransformationMatrix = z2;
        try {
            int iCreateExternalTexture = GlUtil.createExternalTexture();
            this.externalTexId = iCreateExternalTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iCreateExternalTexture);
            this.surfaceTexture = surfaceTexture;
            this.textureTransformMatrix = new float[16];
            this.pendingFrames = new ConcurrentLinkedQueue();
            this.scheduledExecutorService = Util.newSingleThreadScheduledExecutor(TIMER_THREAD_NAME);
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.effect.h0
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    this.f1319a.lambda$new$1(videoFrameProcessingTaskExecutor, surfaceTexture2);
                }
            });
            this.surface = new Surface(surfaceTexture);
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
        if (this.availableFrameCount == this.pendingFrames.size()) {
            return;
        }
        Log.w(TAG, Util.formatInvariant("Forcing EOS after missing %d frames for %d ms, with available frame count: %d", Integer.valueOf(this.pendingFrames.size()), Long.valueOf(SURFACE_TEXTURE_TIMEOUT_MS), Integer.valueOf(this.availableFrameCount)));
        this.currentInputStreamEnded = false;
        this.currentFrame = null;
        this.shouldRejectIncomingFrames = true;
        removeAllSurfaceTextureFrames();
        this.pendingFrames.clear();
        signalEndOfCurrentInputStream();
    }

    private static float guessScaleWithoutSurfaceTextureTrim(float f, int i) {
        int i2 = i;
        for (int i3 = 2; i3 <= 256; i3 *= 2) {
            int i4 = (((i + i3) - 1) / i3) * i3;
            if (scoreForCandidateBufferSize(i4, f, i) < scoreForCandidateBufferSize(i2, f, i)) {
                i2 = i4;
            }
        }
        for (int i5 : ADDITIONAL_CANDIDATE_BUFFER_SIZE_GUESSES) {
            if (i5 >= i && scoreForCandidateBufferSize(i5, f, i) < scoreForCandidateBufferSize(i2, f, i)) {
                i2 = i5;
            }
        }
        return scoreForCandidateBufferSize(i2, f, i) > EPSILON ? f : i / i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws VideoFrameProcessingException, GlUtil.GlException {
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_SURFACE_TEXTURE_INPUT, -9223372036854775807L);
        if (this.automaticReregistration) {
            this.pendingFrames.add((FrameInfo) Assertions.checkNotNull(this.lastRegisteredFrame));
        }
        if (!this.shouldRejectIncomingFrames) {
            if (this.currentInputStreamEnded) {
                restartForceSignalEndOfStreamTimer();
            }
            this.availableFrameCount++;
            maybeQueueFrameToExternalShaderProgram();
            return;
        }
        this.surfaceTexture.updateTexImage();
        this.pendingFrames.poll();
        if (this.releaseAllFramesLatch == null || !this.pendingFrames.isEmpty()) {
            return;
        }
        this.releaseAllFramesLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, SurfaceTexture surfaceTexture) {
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.j0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1324a.lambda$new$0();
            }
        }, false);
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
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
        cancelForceSignalEndOfStreamTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$3() throws VideoFrameProcessingException, GlUtil.GlException {
        this.externalShaderProgramInputCapacity++;
        maybeQueueFrameToExternalShaderProgram();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerInputFrame$5() throws VideoFrameProcessingException, GlUtil.GlException {
        this.shouldRejectIncomingFrames = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseAllRegisteredFrames$7() throws VideoFrameProcessingException, GlUtil.GlException {
        try {
            removeAllSurfaceTextureFrames();
        } catch (RuntimeException e) {
            this.releaseAllFramesException = e;
            Log.e(TAG, "Failed to remove texture frames", e);
            if (this.releaseAllFramesLatch != null) {
                this.releaseAllFramesLatch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartForceSignalEndOfStreamTimer$8() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.g0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f1318a.forceSignalEndOfStream();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSamplingGlShaderProgram$2(GlShaderProgram glShaderProgram) throws VideoFrameProcessingException, GlUtil.GlException {
        this.externalShaderProgramInputCapacity = 0;
        this.externalShaderProgram = (ExternalShaderProgram) glShaderProgram;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalEndOfCurrentInputStream$6() throws VideoFrameProcessingException, GlUtil.GlException {
        if (this.automaticReregistration) {
            this.shouldRejectIncomingFrames = true;
        }
        if (!this.pendingFrames.isEmpty() || this.currentFrame != null) {
            this.currentInputStreamEnded = true;
            restartForceSignalEndOfStreamTimer();
        } else {
            ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
            cancelForceSignalEndOfStreamTimer();
        }
    }

    private void maybeQueueFrameToExternalShaderProgram() {
        if (this.externalShaderProgramInputCapacity == 0 || this.availableFrameCount == 0 || this.currentFrame != null) {
            return;
        }
        this.surfaceTexture.updateTexImage();
        this.availableFrameCount--;
        FrameInfo frameInfoElement = this.pendingFrames.element();
        this.currentFrame = frameInfoElement;
        this.externalShaderProgramInputCapacity--;
        this.surfaceTexture.getTransformMatrix(this.textureTransformMatrix);
        long timestamp = (this.surfaceTexture.getTimestamp() / 1000) + frameInfoElement.offsetToAddUs;
        if (this.experimentalAdjustSurfaceTextureTransformationMatrix) {
            float[] fArr = this.textureTransformMatrix;
            Format format = frameInfoElement.format;
            removeSurfaceTextureScaleFromTransformMatrix(fArr, timestamp, format.width, format.height);
        }
        ((ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram)).setTextureTransformMatrix(this.textureTransformMatrix);
        ExternalShaderProgram externalShaderProgram = (ExternalShaderProgram) Assertions.checkNotNull(this.externalShaderProgram);
        GlObjectsProvider glObjectsProvider = this.glObjectsProvider;
        int i = this.externalTexId;
        Format format2 = frameInfoElement.format;
        externalShaderProgram.queueInputFrame(glObjectsProvider, new GlTextureInfo(i, -1, -1, format2.width, format2.height), timestamp);
        Assertions.checkStateNotNull(this.pendingFrames.remove());
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_QUEUE_FRAME, timestamp);
    }

    private void removeAllSurfaceTextureFrames() {
        while (true) {
            int i = this.availableFrameCount;
            if (i <= 0) {
                break;
            }
            this.availableFrameCount = i - 1;
            this.surfaceTexture.updateTexImage();
            this.pendingFrames.remove();
        }
        if (this.releaseAllFramesLatch == null || !this.pendingFrames.isEmpty()) {
            return;
        }
        this.releaseAllFramesLatch.countDown();
    }

    private static void removeSurfaceTextureScaleFromTransformMatrix(float[] fArr, long j, int i, int i2) {
        byte b;
        byte b2;
        boolean z = (fArr.length != 16) | false;
        for (int i3 : TRANSFORMATION_MATRIX_EXPECTED_ZERO_INDICES) {
            z |= Math.abs(fArr[i3]) > EPSILON;
        }
        boolean z2 = z | (Math.abs(fArr[10] - 1.0f) > EPSILON) | (Math.abs(fArr[15] - 1.0f) > EPSILON);
        byte b3 = 12;
        byte b4 = 4;
        if (Math.abs(fArr[0]) > EPSILON && Math.abs(fArr[5]) > EPSILON) {
            z = (Math.abs(fArr[4]) > EPSILON) | z2 | (Math.abs(fArr[1]) > EPSILON);
            b2 = dn.k;
            b = 0;
            b4 = 5;
        } else if (Math.abs(fArr[1]) <= EPSILON || Math.abs(fArr[4]) <= EPSILON) {
            b = -1;
            b2 = -1;
            b3 = -1;
            b4 = -1;
        } else {
            z = z2 | (Math.abs(fArr[0]) > EPSILON) | (Math.abs(fArr[5]) > EPSILON);
            b2 = 12;
            b = 1;
            b3 = dn.k;
        }
        if (z) {
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Unable to apply SurfaceTexture fix", new Object[0]);
            return;
        }
        float f = fArr[b];
        float f2 = fArr[b3];
        if (Math.abs(f) + EPSILON < 1.0f) {
            float fCopySign = Math.copySign(guessScaleWithoutSurfaceTextureTrim(Math.abs(f), i), f);
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Width scale adjusted.", new Object[0]);
            fArr[b] = fCopySign;
            fArr[b3] = ((f - fCopySign) * 0.5f) + f2;
        }
        float f3 = fArr[b4];
        float f4 = fArr[b2];
        if (Math.abs(f3) + EPSILON < 1.0f) {
            float fCopySign2 = Math.copySign(guessScaleWithoutSurfaceTextureTrim(Math.abs(f3), i2), f3);
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Height scale adjusted.", new Object[0]);
            fArr[b4] = fCopySign2;
            fArr[b2] = ((f3 - fCopySign2) * 0.5f) + f4;
        }
    }

    private void restartForceSignalEndOfStreamTimer() {
        cancelForceSignalEndOfStreamTimer();
        this.forceSignalEndOfStreamFuture = this.scheduledExecutorService.schedule(new Runnable() { // from class: androidx.media3.effect.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1322a.lambda$restartForceSignalEndOfStreamTimer$8();
            }
        }, SURFACE_TEXTURE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private static float scoreForCandidateBufferSize(int i, float f, int i2) {
        float fAbs = 1.0f;
        for (int i3 = 0; i3 <= 2; i3++) {
            float f2 = ((i2 - i3) / i) - f;
            if (Math.abs(f2) < fAbs) {
                fAbs = Math.abs(f2);
            }
        }
        return fAbs;
    }

    @Override // androidx.media3.effect.TextureManager
    public void dropIncomingRegisteredFrames() {
        this.shouldRejectIncomingFrames = true;
    }

    @Override // androidx.media3.effect.TextureManager
    public void flush() throws VideoFrameProcessingException {
        this.externalShaderProgramInputCapacity = 0;
        this.currentFrame = null;
        this.pendingFrames.clear();
        this.lastRegisteredFrame = null;
        super.flush();
    }

    @Override // androidx.media3.effect.TextureManager
    public Surface getInputSurface() {
        return this.surface;
    }

    @Override // androidx.media3.effect.TextureManager
    public int getPendingFrameCount() {
        return this.pendingFrames.size();
    }

    @Override // androidx.media3.effect.TextureManager, androidx.media3.effect.GlShaderProgram.InputListener
    public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.k0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1327a.lambda$onInputFrameProcessed$4();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager, androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.m0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1333a.lambda$onReadyToAcceptInputFrame$3();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void registerInputFrame(FrameInfo frameInfo) {
        this.lastRegisteredFrame = frameInfo;
        if (!this.automaticReregistration) {
            this.pendingFrames.add(frameInfo);
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.l0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1330a.lambda$registerInputFrame$5();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void release() {
        this.surfaceTexture.release();
        this.surface.release();
        this.scheduledExecutorService.shutdownNow();
    }

    @Override // androidx.media3.effect.TextureManager
    public void releaseAllRegisteredFrames() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.releaseAllFramesLatch = countDownLatch;
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.d0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1310a.lambda$releaseAllRegisteredFrames$7();
            }
        });
        try {
            if (!countDownLatch.await(SURFACE_TEXTURE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                Log.w(TAG, "Timeout reached while waiting for latch to be unblocked.");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.w(TAG, "Interrupted when waiting for MediaCodec frames to arrive.");
        }
        this.releaseAllFramesLatch = null;
        if (this.releaseAllFramesException != null) {
            throw this.releaseAllFramesException;
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void setDefaultBufferSize(int i, int i2) {
        this.surfaceTexture.setDefaultBufferSize(i, i2);
    }

    @Override // androidx.media3.effect.TextureManager
    public void setInputFrameInfo(FrameInfo frameInfo, boolean z) {
        this.automaticReregistration = z;
        if (z) {
            this.lastRegisteredFrame = frameInfo;
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            Format format = frameInfo.format;
            surfaceTexture.setDefaultBufferSize(format.width, format.height);
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void setSamplingGlShaderProgram(final GlShaderProgram glShaderProgram) {
        Assertions.checkState(glShaderProgram instanceof ExternalShaderProgram);
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.f0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1315a.lambda$setSamplingGlShaderProgram$2(glShaderProgram);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.e0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1313a.lambda$signalEndOfCurrentInputStream$6();
            }
        });
    }
}
