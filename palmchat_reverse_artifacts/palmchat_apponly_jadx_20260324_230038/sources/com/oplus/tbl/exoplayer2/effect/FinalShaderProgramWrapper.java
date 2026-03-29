package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.SurfaceInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlTextureProducer;
import com.oplus.tbl.exoplayer2.effect.ScaleAndRotateTransformation;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.LongArrayQueue;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.bc2;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class FinalShaderProgramWrapper implements GlShaderProgram, GlTextureProducer {
    private static final int SURFACE_INPUT_CAPACITY = 1;
    private static final String TAG = "FinalShaderWrapper";
    private final Context context;

    @Nullable
    private SurfaceView debugSurfaceView;

    @Nullable
    private SurfaceViewWrapper debugSurfaceViewWrapper;
    private final DebugViewProvider debugViewProvider;

    @Nullable
    private DefaultShaderProgram defaultShaderProgram;
    private final EGLContext eglContext;
    private final EGLDisplay eglDisplay;
    private int inputHeight;
    private int inputWidth;
    private boolean mIsInputStreamEndedWithPendingAvailableFrames;
    private boolean matrixTransformationsChanged;

    @Nullable
    private OnInputStreamProcessedListener onInputStreamProcessedListener;
    private final ColorInfo outputColorInfo;

    @Nullable
    @GuardedBy("this")
    private EGLSurface outputEglSurface;
    private int outputHeight;
    private Size outputSizeBeforeSurfaceTransformation;

    @Nullable
    @GuardedBy("this")
    private SurfaceInfo outputSurfaceInfo;

    @GuardedBy("this")
    private boolean outputSurfaceInfoChanged;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private int outputWidth;
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
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: com.oplus.tbl.exoplayer2.effect.FinalShaderProgramWrapper.1
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onFlush() {
            bc2.a(this);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            bc2.b(this, glTextureInfo);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onReadyToAcceptInputFrame() {
            bc2.c(this);
        }
    };
    private final Queue<Pair<GlTextureInfo, Long>> availableFrames = new ConcurrentLinkedQueue();

    /* JADX INFO: compiled from: SearchBox */
    public interface OnInputStreamProcessedListener {
        void onInputStreamProcessed();
    }

    public FinalShaderProgramWrapper(Context context, EGLDisplay eGLDisplay, EGLContext eGLContext, DebugViewProvider debugViewProvider, ColorInfo colorInfo, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, @Nullable GlTextureProducer.Listener listener2, int i, int i2, boolean z) {
        this.context = context;
        this.eglDisplay = eGLDisplay;
        this.eglContext = eGLContext;
        this.debugViewProvider = debugViewProvider;
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

    private synchronized DefaultShaderProgram createDefaultShaderProgram(int i, int i2, int i3) throws VideoFrameProcessingException {
        DefaultShaderProgram defaultShaderProgramCreateApplyingOetf;
        ImmutableList.a aVarL = new ImmutableList.a().l(this.matrixTransformations);
        if (i != 0) {
            aVarL.a(new ScaleAndRotateTransformation.Builder().setRotationDegrees(i).build());
        }
        aVarL.a(Presentation.createForWidthAndHeight(i2, i3, 0));
        defaultShaderProgramCreateApplyingOetf = DefaultShaderProgram.createApplyingOetf(this.context, aVarL.e(), this.rgbMatrices, this.outputColorInfo, this.sdrWorkingColorSpace);
        Size sizeConfigure = defaultShaderProgramCreateApplyingOetf.configure(this.inputWidth, this.inputHeight);
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            SurfaceInfo surfaceInfo2 = (SurfaceInfo) Assertions.checkNotNull(surfaceInfo);
            Assertions.checkState(sizeConfigure.getWidth() == surfaceInfo2.width);
            Assertions.checkState(sizeConfigure.getHeight() == surfaceInfo2.height);
        }
        return defaultShaderProgramCreateApplyingOetf;
    }

    @RequiresApi(api = 17)
    private synchronized boolean ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws VideoFrameProcessingException, GlUtil.GlException {
        boolean z = (this.inputWidth == i && this.inputHeight == i2 && this.outputSizeBeforeSurfaceTransformation != null) ? false : true;
        if (z) {
            this.inputWidth = i;
            this.inputHeight = i2;
            final Size sizeConfigureAndGetOutputSize = MatrixUtils.configureAndGetOutputSize(i, i2, this.matrixTransformations);
            if (!Util.areEqual(this.outputSizeBeforeSurfaceTransformation, sizeConfigureAndGetOutputSize)) {
                this.outputSizeBeforeSurfaceTransformation = sizeConfigureAndGetOutputSize;
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7611a.lambda$ensureConfigured$4(sizeConfigureAndGetOutputSize);
                    }
                });
            }
        }
        Assertions.checkNotNull(this.outputSizeBeforeSurfaceTransformation);
        if (this.outputSurfaceInfoChanged) {
            GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
            this.outputEglSurface = null;
        }
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo == null && this.textureOutputListener == null) {
            DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
            if (defaultShaderProgram != null) {
                defaultShaderProgram.release();
                this.defaultShaderProgram = null;
            }
            return false;
        }
        this.outputWidth = surfaceInfo == null ? this.outputSizeBeforeSurfaceTransformation.getWidth() : surfaceInfo.width;
        SurfaceInfo surfaceInfo2 = this.outputSurfaceInfo;
        this.outputHeight = surfaceInfo2 == null ? this.outputSizeBeforeSurfaceTransformation.getHeight() : surfaceInfo2.height;
        SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
        if (surfaceInfo3 != null && this.outputEglSurface == null) {
            this.outputEglSurface = glObjectsProvider.createEglSurface(this.eglDisplay, surfaceInfo3.surface, this.outputColorInfo, this.renderFramesAutomatically);
        }
        if (this.textureOutputListener != null) {
            this.outputTexturePool.ensureConfigured(glObjectsProvider, this.outputWidth, this.outputHeight);
        }
        SurfaceView debugPreviewSurfaceView = this.debugViewProvider.getDebugPreviewSurfaceView(this.outputWidth, this.outputHeight);
        if (debugPreviewSurfaceView != null && !Util.areEqual(this.debugSurfaceView, debugPreviewSurfaceView)) {
            this.debugSurfaceViewWrapper = new SurfaceViewWrapper(this.eglDisplay, this.eglContext, debugPreviewSurfaceView, this.outputColorInfo);
        }
        this.debugSurfaceView = debugPreviewSurfaceView;
        DefaultShaderProgram defaultShaderProgram2 = this.defaultShaderProgram;
        if (defaultShaderProgram2 != null && (this.outputSurfaceInfoChanged || z || this.matrixTransformationsChanged)) {
            defaultShaderProgram2.release();
            this.defaultShaderProgram = null;
            this.outputSurfaceInfoChanged = false;
            this.matrixTransformationsChanged = false;
        }
        if (this.defaultShaderProgram == null) {
            SurfaceInfo surfaceInfo4 = this.outputSurfaceInfo;
            this.defaultShaderProgram = createDefaultShaderProgram(surfaceInfo4 == null ? 0 : surfaceInfo4.orientationDegrees, this.outputWidth, this.outputHeight);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureConfigured$4(Size size) {
        this.videoFrameProcessorListener.onOutputSizeChanged(size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$0(long j) {
        this.videoFrameProcessorListener.onOutputFrameAvailableForRendering(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderFrame$3(Exception exc, long j) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(exc, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderFrameToDebugSurface$5(DefaultShaderProgram defaultShaderProgram, SurfaceViewWrapper surfaceViewWrapper, GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        GlUtil.clearFocusedBuffers();
        if (this.sdrWorkingColorSpace != 2) {
            defaultShaderProgram.drawFrame(glTextureInfo.texId, j);
            return;
        }
        int outputColorTransfer = defaultShaderProgram.getOutputColorTransfer();
        defaultShaderProgram.setOutputColorTransfer(surfaceViewWrapper.colorInfo.colorTransfer);
        defaultShaderProgram.drawFrame(glTextureInfo.texId, j);
        defaultShaderProgram.setOutputColorTransfer(outputColorTransfer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOutputSurfaceInfo$2(GlUtil.GlException glException) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(glException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseOutputTextureInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$releaseOutputTexture$1(long j) throws GlUtil.GlException {
        Assertions.checkState(this.textureOutputListener != null);
        while (this.outputTexturePool.freeTextureCount() < this.outputTexturePool.capacity() && this.outputTextureTimestamps.element() <= j) {
            this.outputTexturePool.freeTexture();
            this.outputTextureTimestamps.remove();
            GlUtil.deleteSyncObject(this.syncObjects.remove());
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @RequiresApi(api = 18)
    private synchronized void renderFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j, long j2) {
        if (j2 != -2) {
            try {
            } catch (VideoFrameProcessingException | GlUtil.GlException e) {
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7609a.lambda$renderFrame$3(e, j);
                    }
                });
            }
            if (ensureConfigured(glObjectsProvider, glTextureInfo.width, glTextureInfo.height)) {
                TraceUtil.beginSection("renderFrameToOutput");
                SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
                if (surfaceInfo != null && surfaceInfo.surface != null) {
                    renderFrameToOutputSurface(glTextureInfo, j, j2);
                } else if (this.textureOutputListener != null) {
                    renderFrameToOutputTexture(glTextureInfo, j);
                }
                TraceUtil.endSection();
                if (this.debugSurfaceViewWrapper != null && this.defaultShaderProgram != null) {
                    renderFrameToDebugSurface(glObjectsProvider, glTextureInfo, j);
                }
                this.inputListener.onInputFrameProcessed(glTextureInfo);
                return;
            }
        }
        this.inputListener.onInputFrameProcessed(glTextureInfo);
    }

    @RequiresApi(api = 17)
    private void renderFrameToDebugSurface(GlObjectsProvider glObjectsProvider, final GlTextureInfo glTextureInfo, final long j) {
        final DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Assertions.checkNotNull(this.defaultShaderProgram);
        final SurfaceViewWrapper surfaceViewWrapper = (SurfaceViewWrapper) Assertions.checkNotNull(this.debugSurfaceViewWrapper);
        try {
            ((SurfaceViewWrapper) Assertions.checkNotNull(surfaceViewWrapper)).maybeRenderToSurfaceView(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.j0
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f7607a.lambda$renderFrameToDebugSurface$5(defaultShaderProgram, surfaceViewWrapper, glTextureInfo, j);
                }
            }, glObjectsProvider);
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            Log.d(TAG, "Error rendering to debug preview", e);
        }
    }

    @RequiresApi(api = 18)
    private synchronized void renderFrameToOutputSurface(GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
        EGLSurface eGLSurface = (EGLSurface) Assertions.checkNotNull(this.outputEglSurface);
        SurfaceInfo surfaceInfo = (SurfaceInfo) Assertions.checkNotNull(this.outputSurfaceInfo);
        DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Assertions.checkNotNull(this.defaultShaderProgram);
        GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, eGLSurface, surfaceInfo.width, surfaceInfo.height);
        GlUtil.clearFocusedBuffers();
        TraceUtil.beginSection("drawFrame");
        defaultShaderProgram.drawFrame(glTextureInfo.texId, j);
        TraceUtil.endSection();
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (j2 == -1) {
            j2 = System.nanoTime();
        }
        EGLExt.eglPresentationTimeANDROID(eGLDisplay, eGLSurface, j2);
        EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_RENDERED_TO_OUTPUT_SURFACE, j);
    }

    @RequiresApi(api = 17)
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

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void flush() {
        if (this.textureOutputListener != null) {
            this.outputTexturePool.freeAllTextures();
            this.outputTextureTimestamps.clear();
            this.syncObjects.clear();
        }
        this.availableFrames.clear();
        this.mIsInputStreamEndedWithPendingAvailableFrames = false;
        DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.flush();
        }
        this.inputListener.onFlush();
        for (int i = 0; i < getInputCapacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @RequiresApi(api = 18)
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7613a.lambda$queueInputFrame$0(j);
            }
        });
        if (this.textureOutputListener != null) {
            Assertions.checkState(this.outputTexturePool.freeTextureCount() > 0);
            renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
        } else {
            if (this.renderFramesAutomatically) {
                renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
            } else {
                this.availableFrames.add(Pair.create(glTextureInfo, Long.valueOf(j)));
            }
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @RequiresApi(api = 17)
    public synchronized void release() throws VideoFrameProcessingException {
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

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlTextureProducer
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.i0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7605a.lambda$releaseOutputTexture$1(j);
            }
        });
    }

    @RequiresApi(api = 18)
    public void renderOutputFrame(GlObjectsProvider glObjectsProvider, long j) {
        if (this.textureOutputListener != null) {
            return;
        }
        Assertions.checkState(!this.renderFramesAutomatically);
        Pair<GlTextureInfo, Long> pairRemove = this.availableFrames.remove();
        renderFrame(glObjectsProvider, (GlTextureInfo) pairRemove.first, ((Long) pairRemove.second).longValue(), j);
        if (this.availableFrames.isEmpty() && this.mIsInputStreamEndedWithPendingAvailableFrames) {
            ((OnInputStreamProcessedListener) Assertions.checkNotNull(this.onInputStreamProcessedListener)).onInputStreamProcessed();
            this.mIsInputStreamEndedWithPendingAvailableFrames = false;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        for (int i = 0; i < getInputCapacity(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    public void setMatrixTransformations(List<GlMatrixTransformation> list, List<RgbMatrix> list2) {
        this.matrixTransformations.clear();
        this.matrixTransformations.addAll(list);
        this.rgbMatrices.clear();
        this.rgbMatrices.addAll(list2);
        this.matrixTransformationsChanged = true;
    }

    public void setOnInputStreamProcessedListener(@Nullable OnInputStreamProcessedListener onInputStreamProcessedListener) {
        this.onInputStreamProcessedListener = onInputStreamProcessedListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        SurfaceInfo surfaceInfo2;
        if (this.textureOutputListener != null) {
            return;
        }
        if (Util.areEqual(this.outputSurfaceInfo, surfaceInfo)) {
            return;
        }
        if (surfaceInfo == null || (surfaceInfo2 = this.outputSurfaceInfo) == null || surfaceInfo2.surface.equals(surfaceInfo.surface)) {
            SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
            this.outputSurfaceInfoChanged = (surfaceInfo3 == null && surfaceInfo != null && surfaceInfo3.width == surfaceInfo.width && surfaceInfo3.height == surfaceInfo.height && surfaceInfo3.orientationDegrees == surfaceInfo.orientationDegrees) ? false : true;
            this.outputSurfaceInfo = surfaceInfo;
            return;
        }
        try {
            GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
        } catch (GlUtil.GlException e) {
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7615a.lambda$setOutputSurfaceInfo$2(e);
                }
            });
        }
        this.outputEglSurface = null;
        SurfaceInfo surfaceInfo32 = this.outputSurfaceInfo;
        if (surfaceInfo32 == null) {
            this.outputSurfaceInfoChanged = (surfaceInfo32 == null && surfaceInfo != null && surfaceInfo32.width == surfaceInfo.width && surfaceInfo32.height == surfaceInfo.height && surfaceInfo32.orientationDegrees == surfaceInfo.orientationDegrees) ? false : true;
            this.outputSurfaceInfo = surfaceInfo;
            return;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        if (this.availableFrames.isEmpty()) {
            ((OnInputStreamProcessedListener) Assertions.checkNotNull(this.onInputStreamProcessedListener)).onInputStreamProcessed();
            this.mIsInputStreamEndedWithPendingAvailableFrames = false;
        } else {
            Assertions.checkState(!this.renderFramesAutomatically);
            this.mIsInputStreamEndedWithPendingAvailableFrames = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SurfaceViewWrapper implements SurfaceHolder.Callback {
        public final ColorInfo colorInfo;
        private final EGLContext eglContext;
        private final EGLDisplay eglDisplay;

        @Nullable
        @GuardedBy("this")
        private EGLSurface eglSurface;
        private int height;

        @Nullable
        @GuardedBy("this")
        private Surface surface;
        private int width;

        public SurfaceViewWrapper(EGLDisplay eGLDisplay, EGLContext eGLContext, SurfaceView surfaceView, ColorInfo colorInfo) {
            this.eglDisplay = eGLDisplay;
            this.eglContext = eGLContext;
            int i = colorInfo.colorTransfer;
            if (i == 7 && Util.SDK_INT < 34) {
                i = 6;
            }
            this.colorInfo = colorInfo.buildUpon().setColorTransfer(i).build();
            surfaceView.getHolder().addCallback(this);
            this.surface = surfaceView.getHolder().getSurface();
            this.width = surfaceView.getWidth();
            this.height = surfaceView.getHeight();
        }

        @RequiresApi(api = 17)
        public synchronized void maybeRenderToSurfaceView(VideoFrameProcessingTaskExecutor.Task task, GlObjectsProvider glObjectsProvider) throws VideoFrameProcessingException, GlUtil.GlException {
            Surface surface = this.surface;
            if (surface == null) {
                return;
            }
            if (this.eglSurface == null) {
                this.eglSurface = glObjectsProvider.createEglSurface(this.eglDisplay, surface, this.colorInfo, false);
            }
            EGLSurface eGLSurface = this.eglSurface;
            GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, eGLSurface, this.width, this.height);
            task.run();
            EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
            GLES20.glFinish();
        }

        @Override // android.view.SurfaceHolder.Callback
        public synchronized void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.width = i2;
            this.height = i3;
            Surface surface = surfaceHolder.getSurface();
            Surface surface2 = this.surface;
            if (surface2 == null || !surface2.equals(surface)) {
                this.surface = surface;
                this.eglSurface = null;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public synchronized void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.surface = null;
            this.eglSurface = null;
            this.width = -1;
            this.height = -1;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }
}
