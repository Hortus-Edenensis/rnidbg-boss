package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener;
import com.oplus.tbl.exoplayer2.SurfaceInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.effect.FinalShaderProgramWrapper;
import com.oplus.tbl.exoplayer2.effect.GlTextureProducer;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.ConditionVariable;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.TimestampIterator;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.bv2;
import defpackage.qa1;
import j$.util.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class DefaultVideoFrameProcessor implements VideoFrameProcessor {
    private static final String TAG = "DefaultFrameProcessor";
    public static final int WORKING_COLOR_SPACE_DEFAULT = 0;
    public static final int WORKING_COLOR_SPACE_LINEAR = 2;
    public static final int WORKING_COLOR_SPACE_ORIGINAL = 1;
    private final Context context;
    private final EGLContext eglContext;
    private final EGLDisplay eglDisplay;
    private final FinalShaderProgramWrapper finalShaderProgramWrapper;
    private final GlObjectsProvider glObjectsProvider;
    private volatile boolean inputStreamEnded;
    private final ConditionVariable inputStreamRegisteredCondition;
    private final InputSwitcher inputSwitcher;
    private final ColorInfo intermediateColorInfo;
    private final VideoFrameProcessor.Listener listener;
    private final Executor listenerExecutor;
    private volatile FrameInfo nextInputFrameInfo;
    private final ColorInfo outputColorInfo;

    @Nullable
    @GuardedBy("lock")
    private InputStreamInfo pendingInputStreamInfo;

    @GuardedBy("lock")
    private boolean registeredFirstInputStream;
    private final boolean renderFramesAutomatically;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private final List<Effect> activeEffects = new ArrayList();
    private final Object lock = new Object();
    private final List<GlShaderProgram> intermediateGlShaderPrograms = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements VideoFrameProcessor.Factory {
        private static final String THREAD_NAME = "Effect:DefaultVideoFrameProcessor:GlThread";

        @Nullable
        private final ExecutorService executorService;
        private final GlObjectsProvider glObjectsProvider;
        private final int sdrWorkingColorSpace;
        private final int textureOutputCapacity;

        @Nullable
        private final GlTextureProducer.Listener textureOutputListener;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder {

            @Nullable
            private ExecutorService executorService;
            private GlObjectsProvider glObjectsProvider;
            private int sdrWorkingColorSpace;
            private int textureOutputCapacity;
            private GlTextureProducer.Listener textureOutputListener;

            public Builder() {
                this.sdrWorkingColorSpace = 0;
            }

            public Factory build() {
                int i = this.sdrWorkingColorSpace;
                GlObjectsProvider defaultGlObjectsProvider = this.glObjectsProvider;
                if (defaultGlObjectsProvider == null) {
                    defaultGlObjectsProvider = new DefaultGlObjectsProvider();
                }
                return new Factory(i, defaultGlObjectsProvider, this.executorService, this.textureOutputListener, this.textureOutputCapacity);
            }

            public Builder setExecutorService(@Nullable ExecutorService executorService) {
                this.executorService = executorService;
                return this;
            }

            public Builder setGlObjectsProvider(GlObjectsProvider glObjectsProvider) {
                this.glObjectsProvider = glObjectsProvider;
                return this;
            }

            public Builder setSdrWorkingColorSpace(int i) {
                this.sdrWorkingColorSpace = i;
                return this;
            }

            public Builder setTextureOutput(GlTextureProducer.Listener listener, @IntRange(from = 1) int i) {
                this.textureOutputListener = listener;
                Assertions.checkArgument(i >= 1);
                this.textureOutputCapacity = i;
                return this;
            }

            private Builder(Factory factory) {
                this.sdrWorkingColorSpace = factory.sdrWorkingColorSpace;
                this.executorService = factory.executorService;
                this.glObjectsProvider = factory.glObjectsProvider;
                this.textureOutputListener = factory.textureOutputListener;
                this.textureOutputCapacity = factory.textureOutputCapacity;
            }
        }

        private Factory(int i, GlObjectsProvider glObjectsProvider, @Nullable ExecutorService executorService, @Nullable GlTextureProducer.Listener listener, int i2) {
            this.sdrWorkingColorSpace = i;
            this.glObjectsProvider = glObjectsProvider;
            this.executorService = executorService;
            this.textureOutputListener = listener;
            this.textureOutputCapacity = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ DefaultVideoFrameProcessor lambda$create$0(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener) throws Exception {
            return DefaultVideoFrameProcessor.createOpenGlObjectsAndFrameProcessor(context, debugViewProvider, colorInfo, this.sdrWorkingColorSpace, z, videoFrameProcessingTaskExecutor, executor, listener, this.glObjectsProvider, this.textureOutputListener, this.textureOutputCapacity);
        }

        public Builder buildUpon() {
            return new Builder();
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Factory
        @RequiresApi(api = 17)
        public DefaultVideoFrameProcessor create(final Context context, final DebugViewProvider debugViewProvider, final ColorInfo colorInfo, final boolean z, final Executor executor, final VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            ExecutorService executorServiceNewSingleThreadExecutor = this.executorService;
            boolean z2 = executorServiceNewSingleThreadExecutor == null;
            if (executorServiceNewSingleThreadExecutor == null) {
                executorServiceNewSingleThreadExecutor = Util.newSingleThreadExecutor(THREAD_NAME);
            }
            Objects.requireNonNull(listener);
            final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorServiceNewSingleThreadExecutor, z2, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: com.oplus.tbl.exoplayer2.effect.v
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.ErrorListener
                public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                    listener.onError(videoFrameProcessingException);
                }
            });
            try {
                return (DefaultVideoFrameProcessor) executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: com.oplus.tbl.exoplayer2.effect.w
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f7630a.lambda$create$0(context, debugViewProvider, colorInfo, z, videoFrameProcessingTaskExecutor, executor, listener);
                    }
                }).get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new VideoFrameProcessingException(e);
            } catch (ExecutionException e2) {
                throw new VideoFrameProcessingException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class InputStreamInfo {
        public final List<Effect> effects;
        public final FrameInfo frameInfo;
        public final int inputType;

        public InputStreamInfo(int i, List<Effect> list, FrameInfo frameInfo) {
            this.inputType = i;
            this.effects = list;
            this.frameInfo = frameInfo;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ReleaseOutputTextureCallback {
        void release(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface WorkingColorSpace {
    }

    @RequiresApi(api = 17)
    private DefaultVideoFrameProcessor(Context context, GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, EGLContext eGLContext, InputSwitcher inputSwitcher, final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, final VideoFrameProcessor.Listener listener, final Executor executor, FinalShaderProgramWrapper finalShaderProgramWrapper, boolean z, ColorInfo colorInfo, ColorInfo colorInfo2) {
        this.context = context;
        this.glObjectsProvider = glObjectsProvider;
        this.eglDisplay = eGLDisplay;
        this.eglContext = eGLContext;
        this.inputSwitcher = inputSwitcher;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.listener = listener;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z;
        this.outputColorInfo = colorInfo;
        this.intermediateColorInfo = colorInfo2;
        this.finalShaderProgramWrapper = finalShaderProgramWrapper;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.inputStreamRegisteredCondition = conditionVariable;
        conditionVariable.open();
        finalShaderProgramWrapper.setOnInputStreamProcessedListener(new FinalShaderProgramWrapper.OnInputStreamProcessedListener() { // from class: com.oplus.tbl.exoplayer2.effect.s
            @Override // com.oplus.tbl.exoplayer2.effect.FinalShaderProgramWrapper.OnInputStreamProcessedListener
            public final void onInputStreamProcessed() {
                this.f7623a.lambda$new$1(executor, listener, videoFrameProcessingTaskExecutor);
            }
        });
    }

    private FrameInfo adjustForPixelWidthHeightRatio(FrameInfo frameInfo) {
        FrameInfo.Builder height;
        float f = frameInfo.pixelWidthHeightRatio;
        if (f > 1.0f) {
            height = new FrameInfo.Builder(frameInfo).setWidth((int) (frameInfo.width * frameInfo.pixelWidthHeightRatio));
        } else {
            if (f >= 1.0f) {
                return frameInfo;
            }
            height = new FrameInfo.Builder(frameInfo).setHeight((int) (frameInfo.height / frameInfo.pixelWidthHeightRatio));
        }
        return height.setPixelWidthHeightRatio(1.0f).build();
    }

    private static void chainShaderProgramsWithListeners(GlObjectsProvider glObjectsProvider, List<GlShaderProgram> list, FinalShaderProgramWrapper finalShaderProgramWrapper, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, VideoFrameProcessor.Listener listener, Executor executor) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(finalShaderProgramWrapper);
        int i = 0;
        while (i < arrayList.size() - 1) {
            GlShaderProgram glShaderProgram = (GlShaderProgram) arrayList.get(i);
            i++;
            GlShaderProgram glShaderProgram2 = (GlShaderProgram) arrayList.get(i);
            ChainingGlShaderProgramListener chainingGlShaderProgramListener = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
            glShaderProgram.setOutputListener(chainingGlShaderProgramListener);
            Objects.requireNonNull(listener);
            glShaderProgram.setErrorListener(executor, new qa1(listener));
            glShaderProgram2.setInputListener(chainingGlShaderProgramListener);
        }
    }

    @RequiresApi(17)
    private static void checkColors(ColorInfo colorInfo, ColorInfo colorInfo2) throws VideoFrameProcessingException {
        if (ColorInfo.isTransferHdr(colorInfo)) {
            Assertions.checkArgument(colorInfo.colorSpace == 6);
        }
        if (ColorInfo.isTransferHdr(colorInfo) || ColorInfo.isTransferHdr(colorInfo2)) {
            try {
                if (GlUtil.getContextMajorVersion() != 3) {
                    throw new VideoFrameProcessingException("OpenGL ES 3.0 context support is required for HDR input or output.");
                }
            } catch (GlUtil.GlException e) {
                throw VideoFrameProcessingException.from(e);
            }
        }
        Assertions.checkArgument(colorInfo.isDataSpaceValid());
        Assertions.checkArgument(colorInfo.colorTransfer != 1);
        Assertions.checkArgument(colorInfo2.isDataSpaceValid());
        Assertions.checkArgument(colorInfo2.colorTransfer != 1);
        int i = colorInfo.colorSpace;
        if (i != 10) {
            if (i == colorInfo2.colorSpace && ColorInfo.isTransferHdr(colorInfo) == ColorInfo.isTransferHdr(colorInfo2)) {
                return;
            }
            Assertions.checkArgument(colorInfo.colorSpace == 6);
            Assertions.checkArgument(colorInfo2.colorSpace != 6);
            Assertions.checkArgument(ColorInfo.isTransferHdr(colorInfo));
            int i2 = colorInfo2.colorTransfer;
            Assertions.checkArgument(i2 == 10 || i2 == 3);
        }
    }

    @RequiresApi(17)
    private void configureEffects(final InputStreamInfo inputStreamInfo, boolean z) throws VideoFrameProcessingException {
        checkColors(inputStreamInfo.frameInfo.colorInfo, this.outputColorInfo);
        if (z || !this.activeEffects.equals(inputStreamInfo.effects)) {
            if (!this.intermediateGlShaderPrograms.isEmpty()) {
                for (int i = 0; i < this.intermediateGlShaderPrograms.size(); i++) {
                    this.intermediateGlShaderPrograms.get(i).release();
                }
                this.intermediateGlShaderPrograms.clear();
            }
            this.intermediateGlShaderPrograms.addAll(createGlShaderPrograms(this.context, inputStreamInfo.effects, this.outputColorInfo, this.finalShaderProgramWrapper));
            configureIntermediateGlShaderPrograms(this.intermediateGlShaderPrograms, inputStreamInfo.frameInfo, this.intermediateColorInfo, this.outputColorInfo);
            this.inputSwitcher.setDownstreamShaderProgram((GlShaderProgram) bv2.f(this.intermediateGlShaderPrograms, this.finalShaderProgramWrapper));
            chainShaderProgramsWithListeners(this.glObjectsProvider, this.intermediateGlShaderPrograms, this.finalShaderProgramWrapper, this.videoFrameProcessingTaskExecutor, this.listener, this.listenerExecutor);
            this.activeEffects.clear();
            this.activeEffects.addAll(inputStreamInfo.effects);
        }
        this.inputSwitcher.switchToInput(inputStreamInfo.inputType, inputStreamInfo.frameInfo);
        this.inputStreamRegisteredCondition.open();
        this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f7625a.lambda$configureEffects$5(inputStreamInfo);
            }
        });
    }

    private static void configureIntermediateGlShaderPrograms(List<GlShaderProgram> list, FrameInfo frameInfo, ColorInfo colorInfo, ColorInfo colorInfo2) throws VideoFrameProcessingException {
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo2);
        Iterator<GlShaderProgram> it = list.iterator();
        while (it.hasNext()) {
            GlShaderProgram next = it.next();
            if (next instanceof ProcessingGlShaderProgram) {
                ProcessingGlShaderProgram processingGlShaderProgram = (ProcessingGlShaderProgram) next;
                if (processingGlShaderProgram.isColorComponentsSupported(zIsTransferHdr)) {
                    processingGlShaderProgram.setWorkingColorInfo(frameInfo.colorInfo, colorInfo);
                } else {
                    Log.w(TAG, processingGlShaderProgram + " not support color components and needs to be removed.");
                    it.remove();
                }
            }
        }
    }

    @RequiresApi(api = 17)
    private static EGLContext createFocusedEglContext(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
        EGLContext eGLContextCreateEglContext = glObjectsProvider.createEglContext(eGLDisplay, i, iArr);
        glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContextCreateEglContext, eGLDisplay);
        return eGLContextCreateEglContext;
    }

    @RequiresApi(api = 17)
    private static EGLContext createFocusedEglContextWithFallback(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int[] iArr) throws GlUtil.GlException {
        if (Util.SDK_INT < 29) {
            return createFocusedEglContext(glObjectsProvider, eGLDisplay, 2, iArr);
        }
        try {
            return createFocusedEglContext(glObjectsProvider, eGLDisplay, 3, iArr);
        } catch (GlUtil.GlException unused) {
            return createFocusedEglContext(glObjectsProvider, eGLDisplay, 2, iArr);
        }
    }

    private static ImmutableList<GlShaderProgram> createGlShaderPrograms(Context context, List<Effect> list, ColorInfo colorInfo, FinalShaderProgramWrapper finalShaderProgramWrapper) throws VideoFrameProcessingException {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList.a aVar2 = new ImmutableList.a();
        ImmutableList.a aVar3 = new ImmutableList.a();
        for (int i = 0; i < list.size(); i++) {
            Effect effect = list.get(i);
            Assertions.checkArgument(effect instanceof GlEffect, "DefaultVideoFrameProcessor only supports GlEffects");
            GlEffect glEffect = (GlEffect) effect;
            if (glEffect instanceof GlMatrixTransformation) {
                aVar2.a((GlMatrixTransformation) glEffect);
            } else if (glEffect instanceof RgbMatrix) {
                aVar3.a((RgbMatrix) glEffect);
            } else {
                ImmutableList immutableListE = aVar2.e();
                ImmutableList immutableListE2 = aVar3.e();
                boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
                if (!immutableListE.isEmpty() || !immutableListE2.isEmpty()) {
                    aVar.a(DefaultShaderProgram.create(context, immutableListE, immutableListE2, zIsTransferHdr));
                    aVar2 = new ImmutableList.a();
                    aVar3 = new ImmutableList.a();
                }
                aVar.a(glEffect.toGlShaderProgram(context, zIsTransferHdr));
            }
        }
        finalShaderProgramWrapper.setMatrixTransformations(aVar2.e(), aVar3.e());
        return aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public static DefaultVideoFrameProcessor createOpenGlObjectsAndFrameProcessor(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, int i, boolean z, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlObjectsProvider glObjectsProvider, @Nullable GlTextureProducer.Listener listener2, int i2) throws VideoFrameProcessingException, GlUtil.GlException {
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        EGLContext eGLContextCreateFocusedEglContextWithFallback = createFocusedEglContextWithFallback(glObjectsProvider, defaultEglDisplay, ColorInfo.isTransferHdr(colorInfo) ? GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_1010102 : GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888);
        ColorInfo colorInfoBuild = (ColorInfo.isTransferHdr(colorInfo) || i == 2) ? colorInfo.buildUpon().setColorTransfer(1).setHdrStaticInfo(null).build() : colorInfo;
        Objects.requireNonNull(listener);
        return new DefaultVideoFrameProcessor(context, glObjectsProvider, defaultEglDisplay, eGLContextCreateFocusedEglContextWithFallback, new InputSwitcher(context, colorInfoBuild, glObjectsProvider, videoFrameProcessingTaskExecutor, executor, new qa1(listener), i), videoFrameProcessingTaskExecutor, listener, executor, new FinalShaderProgramWrapper(context, defaultEglDisplay, eGLContextCreateFocusedEglContextWithFallback, debugViewProvider, colorInfo, videoFrameProcessingTaskExecutor, executor, listener, listener2, i2, i, z), z, colorInfo, colorInfoBuild);
    }

    private static String getInputTypeString(int i) {
        if (i == 1) {
            return "Surface";
        }
        if (i == 2) {
            return Registry.BUCKET_BITMAP;
        }
        if (i == 3) {
            return "Texture ID";
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureEffects$5(InputStreamInfo inputStreamInfo) {
        this.listener.onInputStreamRegistered(inputStreamInfo.inputType, inputStreamInfo.effects, inputStreamInfo.frameInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(InputStreamInfo inputStreamInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        configureEffects(inputStreamInfo, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Executor executor, final VideoFrameProcessor.Listener listener, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        if (this.inputStreamEnded) {
            Objects.requireNonNull(listener);
            executor.execute(new Runnable() { // from class: oa1
                @Override // java.lang.Runnable
                public final void run() {
                    listener.onEnded();
                }
            });
            DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_SIGNAL_ENDED, Long.MIN_VALUE);
        } else {
            synchronized (this.lock) {
                final InputStreamInfo inputStreamInfo = this.pendingInputStreamInfo;
                if (inputStreamInfo != null) {
                    videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.p
                        @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                        public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                            this.f7618a.lambda$new$0(inputStreamInfo);
                        }
                    });
                    this.pendingInputStreamInfo = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerInputStream$2(InterruptedException interruptedException) {
        this.listener.onError(VideoFrameProcessingException.from(interruptedException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerInputStream$3(InputStreamInfo inputStreamInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        configureEffects(inputStreamInfo, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderOutputFrame$4(long j) throws VideoFrameProcessingException, GlUtil.GlException {
        this.finalShaderProgramWrapper.renderOutputFrame(this.glObjectsProvider, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public void releaseGlObjects() {
        try {
            try {
                this.inputSwitcher.release();
                for (int i = 0; i < this.intermediateGlShaderPrograms.size(); i++) {
                    this.intermediateGlShaderPrograms.get(i).release();
                }
                this.finalShaderProgramWrapper.release();
            } catch (Exception e) {
                Log.e(TAG, "Error releasing shader program", e);
            }
            try {
                GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
            } catch (GlUtil.GlException e2) {
                Log.e(TAG, "Error releasing GL context", e2);
            }
        } catch (Throwable th) {
            try {
                GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
            } catch (GlUtil.GlException e3) {
                Log.e(TAG, "Error releasing GL context", e3);
            }
            throw th;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public void flush() {
        if (this.inputSwitcher.hasActiveInput()) {
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                TextureManager textureManagerActiveTextureManager = this.inputSwitcher.activeTextureManager();
                textureManagerActiveTextureManager.releaseAllRegisteredFrames();
                this.videoFrameProcessingTaskExecutor.flush();
                textureManagerActiveTextureManager.setOnFlushCompleteListener(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.q
                    @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        countDownLatch.countDown();
                    }
                });
                VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
                final FinalShaderProgramWrapper finalShaderProgramWrapper = this.finalShaderProgramWrapper;
                Objects.requireNonNull(finalShaderProgramWrapper);
                videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.r
                    @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        finalShaderProgramWrapper.flush();
                    }
                });
                countDownLatch.await();
                textureManagerActiveTextureManager.setOnFlushCompleteListener(null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public Surface getInputSurface() {
        return this.inputSwitcher.getInputSurface();
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public int getPendingInputFrameCount() {
        if (this.inputSwitcher.hasActiveInput()) {
            return this.inputSwitcher.activeTextureManager().getPendingFrameCount();
        }
        return 0;
    }

    @VisibleForTesting
    public VideoFrameProcessingTaskExecutor getTaskExecutor() {
        return this.videoFrameProcessingTaskExecutor;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public boolean queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        if (!this.inputStreamRegisteredCondition.isOpen()) {
            return false;
        }
        FrameInfo frameInfo = (FrameInfo) Assertions.checkNotNull(this.nextInputFrameInfo);
        this.inputSwitcher.activeTextureManager().queueInputBitmap(bitmap, new FrameInfo.Builder(frameInfo).setOffsetToAddUs(frameInfo.offsetToAddUs).build(), timestampIterator, false);
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public boolean queueInputTexture(int i, long j) {
        if (!this.inputStreamRegisteredCondition.isOpen()) {
            return false;
        }
        this.inputSwitcher.activeTextureManager().queueInputTexture(i, j);
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public boolean registerInputFrame() {
        Assertions.checkState(!this.inputStreamEnded);
        Assertions.checkStateNotNull(this.nextInputFrameInfo, "registerInputStream must be called before registering input frames");
        if (!this.inputStreamRegisteredCondition.isOpen()) {
            return false;
        }
        TraceUtil.beginSection("registerInputFrame");
        this.inputSwitcher.activeTextureManager().registerInputFrame(this.nextInputFrameInfo);
        TraceUtil.endSection();
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    @RequiresApi(api = 17)
    public void registerInputStream(int i, List<Effect> list, FrameInfo frameInfo) {
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_REGISTER_NEW_INPUT_STREAM, frameInfo.offsetToAddUs, "InputType %s - %dx%d", getInputTypeString(i), Integer.valueOf(frameInfo.width), Integer.valueOf(frameInfo.height));
        this.nextInputFrameInfo = adjustForPixelWidthHeightRatio(frameInfo);
        try {
            this.inputStreamRegisteredCondition.block();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.listenerExecutor.execute(new Runnable() { // from class: ma1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19174a.lambda$registerInputStream$2(e);
                }
            });
        }
        synchronized (this.lock) {
            final InputStreamInfo inputStreamInfo = new InputStreamInfo(i, list, frameInfo);
            if (this.registeredFirstInputStream) {
                this.pendingInputStreamInfo = inputStreamInfo;
                this.inputStreamRegisteredCondition.close();
                this.inputSwitcher.activeTextureManager().signalEndOfCurrentInputStream();
            } else {
                this.registeredFirstInputStream = true;
                this.inputStreamRegisteredCondition.close();
                this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.o
                    @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                        this.f7616a.lambda$registerInputStream$3(inputStreamInfo);
                    }
                });
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    @RequiresApi(api = 17)
    public void release() {
        try {
            this.videoFrameProcessingTaskExecutor.release(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.n
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f7614a.releaseGlObjects();
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public void renderOutputFrame(final long j) {
        Assertions.checkState(!this.renderFramesAutomatically, "Calling this method is not allowed when renderFramesAutomatically is enabled");
        this.videoFrameProcessingTaskExecutor.submitWithHighPriority(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.u
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7627a.lambda$renderOutputFrame$4(j);
            }
        });
    }

    public void setInputDefaultBufferSize(int i, int i2) {
        this.inputSwitcher.setInputDefaultBufferSize(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        this.inputSwitcher.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        this.finalShaderProgramWrapper.setOutputSurfaceInfo(surfaceInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor
    public void signalEndOfInput() {
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_RECEIVE_END_OF_INPUT, Long.MIN_VALUE);
        Assertions.checkState(!this.inputStreamEnded);
        this.inputStreamEnded = true;
        this.inputSwitcher.signalEndOfInputStream();
    }
}
