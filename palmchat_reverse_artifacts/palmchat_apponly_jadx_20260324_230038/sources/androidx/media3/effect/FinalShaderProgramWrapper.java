package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.collect.ImmutableList;
import defpackage.cc2;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class FinalShaderProgramWrapper implements GlShaderProgram, GlTextureProducer {
    private static final int SURFACE_INPUT_CAPACITY = 1;
    private static final String TAG = "FinalShaderWrapper";
    private final Context context;

    @Nullable
    private DefaultShaderProgram defaultShaderProgram;
    private final EGLContext eglContext;
    private final EGLDisplay eglDisplay;
    private int inputHeight;
    private int inputWidth;
    private boolean isInputStreamEndedWithPendingAvailableFrames;
    private Listener listener;
    private boolean matrixTransformationsChanged;
    private final ColorInfo outputColorInfo;

    @Nullable
    private EGLSurface outputEglSurface;
    private Size outputSizeBeforeSurfaceTransformation;

    @Nullable
    private SurfaceInfo outputSurfaceInfo;
    private boolean outputSurfaceInfoChanged;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private final EGLSurface placeholderSurface;
    private final boolean renderFramesAutomatically;
    private final int sdrWorkingColorSpace;
    private final LongArrayQueue syncObjects;

    @Nullable
    private final GlTextureProducer.Listener textureOutputListener;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private final VideoFrameProcessor.Listener videoFrameProcessorListener;
    private final Executor videoFrameProcessorListenerExecutor;
    private final List<GlMatrixTransformation> matrixTransformations = new ArrayList();
    private final List<RgbMatrix> rgbMatrices = new ArrayList();
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.FinalShaderProgramWrapper.1
        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onFlush() {
            cc2.a(this);
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            cc2.b(this, glTextureInfo);
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onReadyToAcceptInputFrame() {
            cc2.c(this);
        }
    };
    private final Queue<TimedGlTextureInfo> availableFrames = new ConcurrentLinkedQueue();
    private long redrawFramePresentationTimeUs = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onFrameRendered(long j);

        void onInputStreamProcessed();
    }

    public FinalShaderProgramWrapper(Context context, EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, ColorInfo colorInfo, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, @Nullable GlTextureProducer.Listener listener2, int i, int i2, boolean z) {
        this.context = context;
        this.eglDisplay = eGLDisplay;
        this.eglContext = eGLContext;
        this.placeholderSurface = eGLSurface;
        this.outputColorInfo = colorInfo;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.videoFrameProcessorListenerExecutor = executor;
        this.videoFrameProcessorListener = listener;
        this.textureOutputListener = listener2;
        this.sdrWorkingColorSpace = i2;
        this.renderFramesAutomatically = z;
        this.outputTexturePool = new TexturePool(ColorInfo.isTransferHdr(colorInfo), i);
        this.outputTextureTimestamps = new LongArrayQueue(i);
        this.syncObjects = new LongArrayQueue(i);
    }

    private DefaultShaderProgram createDefaultShaderProgram(int i, int i2, int i3) throws VideoFrameProcessingException {
        ImmutableList.a aVarL = new ImmutableList.a().l(this.matrixTransformations);
        if (i != 0) {
            aVarL.a(new ScaleAndRotateTransformation.Builder().setRotationDegrees(i).build());
        }
        aVarL.a(Presentation.createForWidthAndHeight(i2, i3, 0));
        DefaultShaderProgram defaultShaderProgramCreateApplyingOetf = DefaultShaderProgram.createApplyingOetf(this.context, aVarL.e(), this.rgbMatrices, this.outputColorInfo, this.sdrWorkingColorSpace);
        Size sizeConfigure = defaultShaderProgramCreateApplyingOetf.configure(this.inputWidth, this.inputHeight);
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            SurfaceInfo surfaceInfo2 = (SurfaceInfo) Assertions.checkNotNull(surfaceInfo);
            Assertions.checkState(sizeConfigure.getWidth() == surfaceInfo2.width);
            Assertions.checkState(sizeConfigure.getHeight() == surfaceInfo2.height);
        }
        return defaultShaderProgramCreateApplyingOetf;
    }

    private void destroyOutputEglSurface() {
        if (this.outputEglSurface == null) {
            return;
        }
        try {
            try {
                GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, this.placeholderSurface, 1, 1);
                GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
            } catch (GlUtil.GlException e) {
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1339a.lambda$destroyOutputEglSurface$5(e);
                    }
                });
            }
        } finally {
            this.outputEglSurface = null;
        }
    }

    private boolean ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws VideoFrameProcessingException, GlUtil.GlException {
        boolean z = (this.inputWidth == i && this.inputHeight == i2 && this.outputSizeBeforeSurfaceTransformation != null) ? false : true;
        if (z) {
            this.inputWidth = i;
            this.inputHeight = i2;
            final Size sizeConfigureAndGetOutputSize = MatrixUtils.configureAndGetOutputSize(i, i2, this.matrixTransformations);
            if (!Objects.equals(this.outputSizeBeforeSurfaceTransformation, sizeConfigureAndGetOutputSize)) {
                this.outputSizeBeforeSurfaceTransformation = sizeConfigureAndGetOutputSize;
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1347a.lambda$ensureConfigured$7(sizeConfigureAndGetOutputSize);
                    }
                });
            }
        }
        Assertions.checkNotNull(this.outputSizeBeforeSurfaceTransformation);
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo == null && this.textureOutputListener == null) {
            Assertions.checkState(this.outputEglSurface == null);
            DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
            if (defaultShaderProgram != null) {
                defaultShaderProgram.release();
                this.defaultShaderProgram = null;
            }
            Log.w(TAG, "Output surface and size not set, dropping frame.");
            return false;
        }
        int width = surfaceInfo == null ? this.outputSizeBeforeSurfaceTransformation.getWidth() : surfaceInfo.width;
        SurfaceInfo surfaceInfo2 = this.outputSurfaceInfo;
        int height = surfaceInfo2 == null ? this.outputSizeBeforeSurfaceTransformation.getHeight() : surfaceInfo2.height;
        SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
        if (surfaceInfo3 != null && this.outputEglSurface == null) {
            this.outputEglSurface = glObjectsProvider.createEglSurface(this.eglDisplay, surfaceInfo3.surface, this.outputColorInfo.colorTransfer, surfaceInfo3.isEncoderInputSurface);
        }
        if (this.textureOutputListener != null) {
            this.outputTexturePool.ensureConfigured(glObjectsProvider, width, height);
        }
        DefaultShaderProgram defaultShaderProgram2 = this.defaultShaderProgram;
        if (defaultShaderProgram2 != null && (this.outputSurfaceInfoChanged || z || this.matrixTransformationsChanged)) {
            defaultShaderProgram2.release();
            this.defaultShaderProgram = null;
            this.outputSurfaceInfoChanged = false;
            this.matrixTransformationsChanged = false;
        }
        if (this.defaultShaderProgram == null) {
            SurfaceInfo surfaceInfo4 = this.outputSurfaceInfo;
            this.defaultShaderProgram = createDefaultShaderProgram(surfaceInfo4 == null ? 0 : surfaceInfo4.orientationDegrees, width, height);
            this.outputSurfaceInfoChanged = false;
        }
        return true;
    }

    private int getInputCapacity() {
        if (this.textureOutputListener == null) {
            return 1;
        }
        return this.outputTexturePool.freeTextureCount();
    }

    private boolean isWaitingForRedrawFrame() {
        return this.redrawFramePresentationTimeUs != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroyOutputEglSurface$5(GlUtil.GlException glException) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(glException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureConfigured$7(Size size) {
        this.videoFrameProcessorListener.onOutputSizeChanged(size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$1(long j) {
        this.videoFrameProcessorListener.onOutputFrameAvailableForRendering(j, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$2(long j) {
        this.videoFrameProcessorListener.onOutputFrameAvailableForRendering(j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderFrame$6(Exception exc, long j) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(exc, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOutputSurfaceInfo$4(InterruptedException interruptedException) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(interruptedException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseOutputTextureInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$releaseOutputTexture$0(long j) throws GlUtil.GlException {
        Assertions.checkState(this.textureOutputListener != null);
        while (this.outputTexturePool.freeTextureCount() < this.outputTexturePool.capacity() && this.outputTextureTimestamps.element() <= j) {
            this.outputTexturePool.freeTexture();
            this.outputTextureTimestamps.remove();
            GlUtil.deleteSyncObject(this.syncObjects.remove());
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    private void renderFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j, long j2) {
        if (j2 != -2) {
            try {
            } catch (VideoFrameProcessingException | GlUtil.GlException e) {
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1336a.lambda$renderFrame$6(e, j);
                    }
                });
            }
            if (ensureConfigured(glObjectsProvider, glTextureInfo.width, glTextureInfo.height) && (!isWaitingForRedrawFrame() || j == this.redrawFramePresentationTimeUs)) {
                if (this.outputSurfaceInfo != null) {
                    renderFrameToOutputSurface(glTextureInfo, j, j2);
                } else if (this.textureOutputListener != null) {
                    renderFrameToOutputTexture(glTextureInfo, j);
                }
                this.inputListener.onInputFrameProcessed(glTextureInfo);
                return;
            }
        }
        this.inputListener.onInputFrameProcessed(glTextureInfo);
        if (j2 == -2) {
            ((Listener) Assertions.checkNotNull(this.listener)).onFrameRendered(j);
        }
    }

    private void renderFrameToOutputSurface(GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
        EGLSurface eGLSurface = (EGLSurface) Assertions.checkNotNull(this.outputEglSurface);
        SurfaceInfo surfaceInfo = (SurfaceInfo) Assertions.checkNotNull(this.outputSurfaceInfo);
        DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Assertions.checkNotNull(this.defaultShaderProgram);
        GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, eGLSurface, surfaceInfo.width, surfaceInfo.height);
        GlUtil.clearFocusedBuffers();
        defaultShaderProgram.drawFrame(glTextureInfo.texId, j);
        if (j2 == -3) {
            Assertions.checkState(j != -9223372036854775807L);
            j2 = 1000 * j;
        }
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, eGLSurface, j2);
        EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
        ((Listener) Assertions.checkNotNull(this.listener)).onFrameRendered(j);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_RENDERED_TO_OUTPUT_SURFACE, j);
    }

    private void renderFrameToOutputTexture(GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
        this.outputTextureTimestamps.add(j);
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
        GlUtil.clearFocusedBuffers();
        ((DefaultShaderProgram) Assertions.checkNotNull(this.defaultShaderProgram)).drawFrame(glTextureInfo.texId, j);
        long jCreateGlSyncFence = GlUtil.createGlSyncFence();
        this.syncObjects.add(jCreateGlSyncFence);
        ((GlTextureProducer.Listener) Assertions.checkNotNull(this.textureOutputListener)).onTextureRendered(this, glTextureInfoUseTexture, j, jCreateGlSyncFence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setOutputSurfaceInfoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setOutputSurfaceInfo$3(@Nullable SurfaceInfo surfaceInfo) {
        if (this.textureOutputListener == null && !Objects.equals(this.outputSurfaceInfo, surfaceInfo)) {
            SurfaceInfo surfaceInfo2 = this.outputSurfaceInfo;
            if (surfaceInfo2 != null && (surfaceInfo == null || !surfaceInfo2.surface.equals(surfaceInfo.surface))) {
                destroyOutputEglSurface();
            }
            SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
            this.outputSurfaceInfoChanged = (surfaceInfo3 != null && surfaceInfo != null && surfaceInfo3.width == surfaceInfo.width && surfaceInfo3.height == surfaceInfo.height && surfaceInfo3.orientationDegrees == surfaceInfo.orientationDegrees) ? false : true;
            this.outputSurfaceInfo = surfaceInfo;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (this.textureOutputListener != null) {
            this.outputTexturePool.freeAllTextures();
            this.outputTextureTimestamps.clear();
            this.syncObjects.clear();
        }
        this.availableFrames.clear();
        this.isInputStreamEndedWithPendingAvailableFrames = false;
        DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.flush();
        }
        this.inputListener.onFlush();
        for (int i = 0; i < getInputCapacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    public void prepareToRedraw(long j) {
        this.redrawFramePresentationTimeUs = j;
        for (int i = 0; i < this.availableFrames.size(); i++) {
            this.inputListener.onInputFrameProcessed(this.availableFrames.remove().glTextureInfo);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (!isWaitingForRedrawFrame()) {
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1342a.lambda$queueInputFrame$1(j);
                }
            });
        }
        if (this.textureOutputListener != null) {
            Assertions.checkState(this.outputTexturePool.freeTextureCount() > 0);
            renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
            return;
        }
        if (this.renderFramesAutomatically) {
            renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
        } else {
            this.availableFrames.add(new TimedGlTextureInfo(glTextureInfo, j));
            if (isWaitingForRedrawFrame()) {
                if (j == this.redrawFramePresentationTimeUs) {
                    this.redrawFramePresentationTimeUs = -9223372036854775807L;
                    this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.q0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1345a.lambda$queueInputFrame$2(j);
                        }
                    });
                    renderFrame(glObjectsProvider, glTextureInfo, j, Clock.DEFAULT.nanoTime());
                    this.availableFrames.clear();
                } else {
                    this.inputListener.onInputFrameProcessed(glTextureInfo);
                }
            }
        }
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.release();
        }
        try {
            this.outputTexturePool.deleteAllTextures();
            GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
            GlUtil.checkGlError();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.s0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1350a.lambda$releaseOutputTexture$0(j);
            }
        });
    }

    public void renderOutputFrame(GlObjectsProvider glObjectsProvider, long j) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (this.textureOutputListener != null) {
            return;
        }
        Assertions.checkState(!this.renderFramesAutomatically);
        if (this.availableFrames.isEmpty()) {
            return;
        }
        TimedGlTextureInfo timedGlTextureInfoRemove = this.availableFrames.remove();
        renderFrame(glObjectsProvider, timedGlTextureInfoRemove.glTextureInfo, timedGlTextureInfoRemove.presentationTimeUs, j);
        if (this.availableFrames.isEmpty() && this.isInputStreamEndedWithPendingAvailableFrames) {
            ((Listener) Assertions.checkNotNull(this.listener)).onInputStreamProcessed();
            this.isInputStreamEndedWithPendingAvailableFrames = false;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.inputListener = inputListener;
        for (int i = 0; i < getInputCapacity(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    public void setListener(Listener listener) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.listener = listener;
    }

    public void setMatrixTransformations(List<GlMatrixTransformation> list, List<RgbMatrix> list2) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.matrixTransformations.clear();
        this.matrixTransformations.addAll(list);
        this.rgbMatrices.clear();
        this.rgbMatrices.addAll(list2);
        this.matrixTransformationsChanged = true;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        throw new UnsupportedOperationException();
    }

    public void setOutputSurfaceInfo(@Nullable final SurfaceInfo surfaceInfo) {
        try {
            this.videoFrameProcessingTaskExecutor.invoke(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.t0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f1352a.lambda$setOutputSurfaceInfo$3(surfaceInfo);
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1355a.lambda$setOutputSurfaceInfo$4(e);
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (this.availableFrames.isEmpty()) {
            ((Listener) Assertions.checkNotNull(this.listener)).onInputStreamProcessed();
            this.isInputStreamEndedWithPendingAvailableFrames = false;
        } else {
            Assertions.checkState(!this.renderFramesAutomatically);
            this.isInputStreamEndedWithPendingAvailableFrames = true;
        }
    }
}
