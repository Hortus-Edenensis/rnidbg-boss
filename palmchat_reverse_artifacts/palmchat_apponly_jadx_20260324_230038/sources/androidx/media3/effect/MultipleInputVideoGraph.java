package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.VideoCompositor;
import com.google.common.collect.ImmutableList;
import defpackage.bc6;
import defpackage.er3;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class MultipleInputVideoGraph implements VideoGraph {
    private static final int COMPOSITOR_TEXTURE_OUTPUT_CAPACITY = 1;
    private static final int PRE_COMPOSITOR_TEXTURE_OUTPUT_CAPACITY = 2;
    private static final long RELEASE_WAIT_TIME_MS = 1000;
    private static final String SHARED_EXECUTOR_NAME = "Effect:MultipleInputVideoGraph:Thread";
    private static final String TAG = "MultiInputVG";
    private List<Effect> compositionEffects;

    @Nullable
    private VideoFrameProcessor compositionVideoFrameProcessor;
    private boolean compositorEnded;
    private Size compositorOutputSize;
    private final SparseArray<CompositorOutputTextureRelease> compositorOutputTextureReleases;
    private final Queue<TimedGlTextureInfo> compositorOutputTextures;
    private final Context context;
    private final DebugViewProvider debugViewProvider;
    private final GlObjectsProvider glObjectsProvider;
    private volatile boolean hasProducedFrameWithTimestampZero;
    private long lastRenderedPresentationTimeUs;
    private final VideoGraph.Listener listener;
    private final Executor listenerExecutor;
    private final ColorInfo outputColorInfo;
    private final SparseArray<VideoFrameProcessor> preProcessors;
    private boolean released;
    private final boolean renderFramesAutomatically;
    private final ExecutorService sharedExecutorService;

    @Nullable
    private VideoCompositor videoCompositor;
    private VideoCompositorSettings videoCompositorSettings;
    private final DefaultVideoFrameProcessor.Factory videoFrameProcessorFactory;

    /* JADX INFO: renamed from: androidx.media3.effect.MultipleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements VideoFrameProcessor.Listener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnded$3() {
            MultipleInputVideoGraph.this.listener.onEnded(MultipleInputVideoGraph.this.lastRenderedPresentationTimeUs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFrameAvailableForRendering$2(long j, boolean z) {
            MultipleInputVideoGraph.this.listener.onOutputFrameAvailableForRendering(j, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFrameRateChanged$1(float f) {
            MultipleInputVideoGraph.this.listener.onOutputFrameRateChanged(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputSizeChanged$0(int i, int i2) {
            MultipleInputVideoGraph.this.listener.onOutputSizeChanged(i, i2);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onEnded() {
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.b1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1305a.lambda$onEnded$3();
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onError(VideoFrameProcessingException videoFrameProcessingException) {
            MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onInputStreamRegistered(int i, Format format, List<Effect> list) {
            MultipleInputVideoGraph.this.queueCompositionOutputInternal();
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameAvailableForRendering(final long j, final boolean z) {
            if (j == 0) {
                MultipleInputVideoGraph.this.hasProducedFrameWithTimestampZero = true;
            }
            MultipleInputVideoGraph.this.lastRenderedPresentationTimeUs = j;
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1308a.lambda$onOutputFrameAvailableForRendering$2(j, z);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameRateChanged(final float f) {
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1311a.lambda$onOutputFrameRateChanged$1(f);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputSizeChanged(final int i, final int i2) {
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.a1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1302a.lambda$onOutputSizeChanged$0(i, i2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CompositorOutputTextureRelease {
        private final long presentationTimeUs;
        private final GlTextureProducer textureProducer;

        public CompositorOutputTextureRelease(GlTextureProducer glTextureProducer, long j) {
            this.textureProducer = glTextureProducer;
            this.presentationTimeUs = j;
        }

        public void release() {
            this.textureProducer.releaseOutputTexture(this.presentationTimeUs);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements VideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public Factory() {
            this(new DefaultVideoFrameProcessor.Factory.Builder().build());
        }

        @Override // androidx.media3.common.VideoGraph.Factory
        public boolean supportsMultipleInputs() {
            return true;
        }

        public Factory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // androidx.media3.common.VideoGraph.Factory
        public MultipleInputVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, long j, boolean z) {
            return new MultipleInputVideoGraph(context, this.videoFrameProcessorFactory, colorInfo, debugViewProvider, listener, executor, z, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SingleContextGlObjectsProvider implements GlObjectsProvider {
        private final GlObjectsProvider glObjectsProvider = new DefaultGlObjectsProvider();
        private EGLContext singleEglContext;

        @Override // androidx.media3.common.GlObjectsProvider
        public GlTextureInfo createBuffersForTexture(int i, int i2, int i3) throws GlUtil.GlException {
            return this.glObjectsProvider.createBuffersForTexture(i, i2, i3);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLContext createEglContext(EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
            if (this.singleEglContext == null) {
                this.singleEglContext = this.glObjectsProvider.createEglContext(eGLDisplay, i, iArr);
            }
            return this.singleEglContext;
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i, boolean z) throws GlUtil.GlException {
            return this.glObjectsProvider.createEglSurface(eGLDisplay, obj, i, z);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException {
            return this.glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public void release(EGLDisplay eGLDisplay) throws GlUtil.GlException {
            EGLContext eGLContext = this.singleEglContext;
            if (eGLContext != null) {
                GlUtil.destroyEglContext(eGLDisplay, eGLContext);
            }
        }
    }

    public /* synthetic */ MultipleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, boolean z, AnonymousClass1 anonymousClass1) {
        this(context, factory, colorInfo, debugViewProvider, listener, executor, z);
    }

    private VideoFrameProcessor getProcessor(int i) {
        Assertions.checkState(Util.contains(this.preProcessors, i));
        return this.preProcessors.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoFrameProcessingException(final Exception exc) {
        this.listenerExecutor.execute(new Runnable() { // from class: ct3
            @Override // java.lang.Runnable
            public final void run() {
                this.f16911a.lambda$handleVideoFrameProcessingException$2(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleVideoFrameProcessingException$2(Exception exc) {
        this.listener.onError(exc instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc : VideoFrameProcessingException.from(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerInput$0(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
        queuePreProcessingOutputToCompositor(i, glTextureProducer, glTextureInfo, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1() {
        try {
            this.glObjectsProvider.release(GlUtil.getDefaultEglDisplay());
        } catch (Exception e) {
            Log.e(TAG, "Error releasing GlObjectsProvider", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompositionVideoFrameProcessorInputFrameProcessed(int i, long j) {
        Assertions.checkState(Util.contains(this.compositorOutputTextureReleases, i));
        this.compositorOutputTextureReleases.get(i).release();
        this.compositorOutputTextureReleases.remove(i);
        queueCompositionOutputInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreProcessingVideoFrameProcessorEnded(int i) {
        ((VideoCompositor) Assertions.checkNotNull(this.videoCompositor)).signalEndOfInputSource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoCompositorEnded() {
        this.compositorEnded = true;
        if (this.compositorOutputTextures.isEmpty()) {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).signalEndOfInput();
        } else {
            queueCompositionOutputInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCompositorOutputTexture(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) {
        Assertions.checkState(!this.compositorEnded);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_COMPOSITOR, DebugTraceUtil.EVENT_OUTPUT_TEXTURE_RENDERED, j);
        this.compositorOutputTextures.add(new TimedGlTextureInfo(glTextureInfo, j));
        this.compositorOutputTextureReleases.put(glTextureInfo.texId, new CompositorOutputTextureRelease(glTextureProducer, j));
        queueCompositionOutputInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueCompositionOutputInternal() {
        TimedGlTextureInfo timedGlTextureInfoPeek = this.compositorOutputTextures.peek();
        if (timedGlTextureInfoPeek == null) {
            return;
        }
        VideoFrameProcessor videoFrameProcessor = (VideoFrameProcessor) Assertions.checkStateNotNull(this.compositionVideoFrameProcessor);
        GlTextureInfo glTextureInfo = timedGlTextureInfoPeek.glTextureInfo;
        int i = glTextureInfo.width;
        int i2 = glTextureInfo.height;
        if (i != this.compositorOutputSize.getWidth() || i2 != this.compositorOutputSize.getHeight()) {
            videoFrameProcessor.registerInputStream(3, new Format.Builder().setColorInfo(this.outputColorInfo).setWidth(i).setHeight(i2).build(), this.compositionEffects, 0L);
            this.compositorOutputSize = new Size(i, i2);
        }
        if (videoFrameProcessor.queueInputTexture(timedGlTextureInfoPeek.glTextureInfo.texId, timedGlTextureInfoPeek.presentationTimeUs)) {
            this.compositorOutputTextures.remove();
            if (this.compositorEnded && this.compositorOutputTextures.isEmpty()) {
                videoFrameProcessor.signalEndOfInput();
            }
        }
    }

    private void queuePreProcessingOutputToCompositor(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j) {
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_OUTPUT_TEXTURE_RENDERED, j);
        ((VideoCompositor) Assertions.checkNotNull(this.videoCompositor)).queueInputTexture(i, glTextureProducer, glTextureInfo, this.outputColorInfo, j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void flush() {
        for (int i = 0; i < this.preProcessors.size(); i++) {
            SparseArray<VideoFrameProcessor> sparseArray = this.preProcessors;
            sparseArray.get(sparseArray.keyAt(i)).flush();
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public Surface getInputSurface(int i) {
        return getProcessor(i).getInputSurface();
    }

    @Override // androidx.media3.common.VideoGraph
    public int getPendingInputFrameCount(int i) {
        return getProcessor(i).getPendingInputFrameCount();
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean hasProducedFrameWithTimestampZero() {
        return this.hasProducedFrameWithTimestampZero;
    }

    @Override // androidx.media3.common.VideoGraph
    public void initialize() throws VideoFrameProcessingException {
        Assertions.checkState(this.preProcessors.size() == 0 && this.videoCompositor == null && this.compositionVideoFrameProcessor == null && !this.released);
        DefaultVideoFrameProcessor defaultVideoFrameProcessorCreate = this.videoFrameProcessorFactory.create(this.context, this.debugViewProvider, this.outputColorInfo, this.renderFramesAutomatically, er3.a(), (VideoFrameProcessor.Listener) new AnonymousClass1());
        this.compositionVideoFrameProcessor = defaultVideoFrameProcessorCreate;
        defaultVideoFrameProcessorCreate.setOnInputFrameProcessedListener(new OnInputFrameProcessedListener() { // from class: us3
            @Override // androidx.media3.common.OnInputFrameProcessedListener
            public final void onInputFrameProcessed(int i, long j) {
                this.f21281a.onCompositionVideoFrameProcessorInputFrameProcessed(i, j);
            }
        });
        DefaultVideoCompositor defaultVideoCompositor = new DefaultVideoCompositor(this.context, this.glObjectsProvider, this.sharedExecutorService, new VideoCompositor.Listener() { // from class: androidx.media3.effect.MultipleInputVideoGraph.2
            @Override // androidx.media3.effect.VideoCompositor.Listener
            public void onEnded() {
                MultipleInputVideoGraph.this.onVideoCompositorEnded();
            }

            @Override // androidx.media3.effect.VideoCompositor.Listener
            public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
            }
        }, new GlTextureProducer.Listener() { // from class: ws3
            @Override // androidx.media3.effect.GlTextureProducer.Listener
            public final void onTextureRendered(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) {
                this.f21789a.processCompositorOutputTexture(glTextureProducer, glTextureInfo, j, j2);
            }
        }, 1);
        this.videoCompositor = defaultVideoCompositor;
        defaultVideoCompositor.setVideoCompositorSettings(this.videoCompositorSettings);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputBitmap(int i, Bitmap bitmap, TimestampIterator timestampIterator) {
        return getProcessor(i).queueInputBitmap(bitmap, timestampIterator);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputTexture(int i, int i2, long j) {
        return getProcessor(i).queueInputTexture(i2, j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void redraw() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInput(@IntRange(from = 0) final int i) throws VideoFrameProcessingException {
        Assertions.checkState(!Util.contains(this.preProcessors, i));
        ((VideoCompositor) Assertions.checkNotNull(this.videoCompositor)).registerInputSource(i);
        this.preProcessors.put(i, this.videoFrameProcessorFactory.buildUpon().setTextureOutput(new GlTextureProducer.Listener() { // from class: ys3
            @Override // androidx.media3.effect.GlTextureProducer.Listener
            public final void onTextureRendered(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
                this.f22263a.lambda$registerInput$0(i, glTextureProducer, glTextureInfo, j, j2);
            }
        }, 2).build().create(this.context, DebugViewProvider.NONE, this.outputColorInfo, true, this.listenerExecutor, new VideoFrameProcessor.Listener() { // from class: androidx.media3.effect.MultipleInputVideoGraph.3
            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void onEnded() {
                MultipleInputVideoGraph.this.onPreProcessingVideoFrameProcessorEnded(i);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public /* synthetic */ void onInputStreamRegistered(int i2, Format format, List list) {
                bc6.c(this, i2, format, list);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public /* synthetic */ void onOutputFrameAvailableForRendering(long j, boolean z) {
                bc6.d(this, j, z);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public /* synthetic */ void onOutputFrameRateChanged(float f) {
                bc6.e(this, f);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public /* synthetic */ void onOutputSizeChanged(int i2, int i3) {
                bc6.f(this, i2, i3);
            }
        }));
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean registerInputFrame(int i) {
        return getProcessor(i).registerInputFrame();
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInputStream(int i, int i2, Format format, List<Effect> list, long j) {
        getProcessor(i).registerInputStream(i2, format, list, j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void release() {
        if (this.released) {
            return;
        }
        for (int i = 0; i < this.preProcessors.size(); i++) {
            SparseArray<VideoFrameProcessor> sparseArray = this.preProcessors;
            sparseArray.get(sparseArray.keyAt(i)).release();
        }
        VideoCompositor videoCompositor = this.videoCompositor;
        if (videoCompositor != null) {
            videoCompositor.release();
            this.videoCompositor = null;
        }
        VideoFrameProcessor videoFrameProcessor = this.compositionVideoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
            this.compositionVideoFrameProcessor = null;
        }
        this.sharedExecutorService.submit(new Runnable() { // from class: at3
            @Override // java.lang.Runnable
            public final void run() {
                this.f1566a.lambda$release$1();
            }
        });
        this.sharedExecutorService.shutdown();
        try {
            this.sharedExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.e(TAG, "Thread interrupted while waiting for executor service termination");
        }
        this.released = true;
    }

    @Override // androidx.media3.common.VideoGraph
    public void renderOutputFrame(long j) {
        ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).renderOutputFrame(j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositionEffects(List<Effect> list) {
        this.compositionEffects = list;
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        this.videoCompositorSettings = videoCompositorSettings;
        VideoCompositor videoCompositor = this.videoCompositor;
        if (videoCompositor != null) {
            videoCompositor.setVideoCompositorSettings(videoCompositorSettings);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputFrameProcessedListener(int i, OnInputFrameProcessedListener onInputFrameProcessedListener) {
        getProcessor(i).setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputSurfaceReadyListener(int i, Runnable runnable) {
        getProcessor(i).setOnInputSurfaceReadyListener(runnable);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).setOutputSurfaceInfo(surfaceInfo);
    }

    @Override // androidx.media3.common.VideoGraph
    public void signalEndOfInput(int i) {
        getProcessor(i).signalEndOfInput();
    }

    private MultipleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, boolean z) {
        Assertions.checkArgument(factory instanceof DefaultVideoFrameProcessor.Factory);
        this.context = context;
        this.outputColorInfo = colorInfo;
        this.debugViewProvider = debugViewProvider;
        this.listener = listener;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z;
        this.lastRenderedPresentationTimeUs = -9223372036854775807L;
        this.preProcessors = new SparseArray<>();
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Util.newSingleThreadScheduledExecutor(SHARED_EXECUTOR_NAME);
        this.sharedExecutorService = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        SingleContextGlObjectsProvider singleContextGlObjectsProvider = new SingleContextGlObjectsProvider();
        this.glObjectsProvider = singleContextGlObjectsProvider;
        this.videoFrameProcessorFactory = ((DefaultVideoFrameProcessor.Factory) factory).buildUpon().setGlObjectsProvider(singleContextGlObjectsProvider).setExecutorService(scheduledExecutorServiceNewSingleThreadScheduledExecutor).build();
        this.compositorOutputTextures = new ArrayDeque();
        this.compositorOutputTextureReleases = new SparseArray<>();
        this.compositorOutputSize = Size.UNKNOWN;
        this.compositionEffects = ImmutableList.of();
        this.videoCompositorSettings = VideoCompositorSettings.DEFAULT;
    }
}
