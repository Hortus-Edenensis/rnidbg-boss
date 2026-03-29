package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener;
import com.oplus.tbl.exoplayer2.SurfaceInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.VideoGraph;
import com.oplus.tbl.exoplayer2.effect.DefaultVideoFrameProcessor;
import com.oplus.tbl.exoplayer2.effect.GlTextureProducer;
import com.oplus.tbl.exoplayer2.effect.VideoCompositor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.er3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class MultipleInputVideoGraph implements VideoGraph {
    private static final int COMPOSITOR_TEXTURE_OUTPUT_CAPACITY = 1;
    private static final int PRE_COMPOSITOR_TEXTURE_OUTPUT_CAPACITY = 2;
    private static final long RELEASE_WAIT_TIME_MS = 1000;
    private static final String SHARED_EXECUTOR_NAME = "Transformer:MultipleInputVideoGraph:Thread";
    private final List<Effect> compositionEffects;

    @Nullable
    private VideoFrameProcessor compositionVideoFrameProcessor;
    private boolean compositionVideoFrameProcessorInputStreamRegistered;
    private boolean compositionVideoFrameProcessorInputStreamRegistrationCompleted;
    private boolean compositorEnded;
    private final SparseArray<CompositorOutputTextureRelease> compositorOutputTextureReleases;
    private final Queue<CompositorOutputTextureInfo> compositorOutputTextures;
    private final Context context;
    private final DebugViewProvider debugViewProvider;
    private final GlObjectsProvider glObjectsProvider;
    private volatile boolean hasProducedFrameWithTimestampZero;
    private final long initialTimestampOffsetUs;
    private final ColorInfo inputColorInfo;
    private final VideoGraph.Listener listener;
    private final Executor listenerExecutor;
    private final ColorInfo outputColorInfo;
    private boolean released;
    private final ExecutorService sharedExecutorService;

    @Nullable
    private VideoCompositor videoCompositor;
    private final VideoCompositorSettings videoCompositorSettings;
    private final DefaultVideoFrameProcessor.Factory videoFrameProcessorFactory;
    private long lastRenderedPresentationTimeUs = -9223372036854775807L;
    private final List<VideoFrameProcessor> preProcessors = new ArrayList();

    /* JADX INFO: renamed from: com.oplus.tbl.exoplayer2.effect.MultipleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements VideoFrameProcessor.Listener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnded$1() {
            MultipleInputVideoGraph.this.listener.onEnded(MultipleInputVideoGraph.this.lastRenderedPresentationTimeUs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputSizeChanged$0(int i, int i2) {
            MultipleInputVideoGraph.this.listener.onOutputSizeChanged(i, i2);
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onEnded() {
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7626a.lambda$onEnded$1();
                }
            });
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onError(VideoFrameProcessingException videoFrameProcessingException) {
            MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onInputStreamRegistered(int i, List<Effect> list, FrameInfo frameInfo) {
            MultipleInputVideoGraph.this.compositionVideoFrameProcessorInputStreamRegistrationCompleted = true;
            MultipleInputVideoGraph.this.queueCompositionOutputInternal();
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onOutputFrameAvailableForRendering(long j) {
            if (j == 0) {
                MultipleInputVideoGraph.this.hasProducedFrameWithTimestampZero = true;
            }
            MultipleInputVideoGraph.this.lastRenderedPresentationTimeUs = j;
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onOutputSizeChanged(final int i, final int i2) {
            MultipleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7624a.lambda$onOutputSizeChanged$0(i, i2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CompositorOutputTextureInfo {
        public final GlTextureInfo glTextureInfo;
        public final long presentationTimeUs;

        private CompositorOutputTextureInfo(GlTextureInfo glTextureInfo, long j) {
            this.glTextureInfo = glTextureInfo;
            this.presentationTimeUs = j;
        }

        public /* synthetic */ CompositorOutputTextureInfo(GlTextureInfo glTextureInfo, long j, AnonymousClass1 anonymousClass1) {
            this(glTextureInfo, j);
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
    public static final class SingleContextGlObjectsProvider implements GlObjectsProvider {
        private final GlObjectsProvider glObjectsProvider = new DefaultGlObjectsProvider();
        private EGLContext singleEglContext;

        @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
        public GlTextureInfo createBuffersForTexture(int i, int i2, int i3) throws GlUtil.GlException {
            return this.glObjectsProvider.createBuffersForTexture(i, i2, i3);
        }

        @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
        @RequiresApi(api = 17)
        public EGLContext createEglContext(EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
            if (this.singleEglContext == null) {
                this.singleEglContext = this.glObjectsProvider.createEglContext(eGLDisplay, i, iArr);
            }
            return this.singleEglContext;
        }

        @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
        @RequiresApi(api = 17)
        public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, ColorInfo colorInfo, boolean z) throws GlUtil.GlException {
            return this.glObjectsProvider.createEglSurface(eGLDisplay, obj, colorInfo, z);
        }

        @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
        @RequiresApi(api = 17)
        public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException {
            return this.glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay);
        }
    }

    public MultipleInputVideoGraph(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List<Effect> list, long j) {
        this.context = context;
        this.inputColorInfo = colorInfo;
        this.outputColorInfo = colorInfo2;
        this.debugViewProvider = debugViewProvider;
        this.listener = listener;
        this.listenerExecutor = executor;
        this.videoCompositorSettings = videoCompositorSettings;
        this.compositionEffects = new ArrayList(list);
        this.initialTimestampOffsetUs = j;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Util.newSingleThreadScheduledExecutor(SHARED_EXECUTOR_NAME);
        this.sharedExecutorService = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        SingleContextGlObjectsProvider singleContextGlObjectsProvider = new SingleContextGlObjectsProvider();
        this.glObjectsProvider = singleContextGlObjectsProvider;
        this.videoFrameProcessorFactory = new DefaultVideoFrameProcessor.Factory.Builder().setGlObjectsProvider(singleContextGlObjectsProvider).setExecutorService(scheduledExecutorServiceNewSingleThreadScheduledExecutor).build();
        this.compositorOutputTextures = new ArrayDeque();
        this.compositorOutputTextureReleases = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoFrameProcessingException(final Exception exc) {
        this.listenerExecutor.execute(new Runnable() { // from class: ts3
            @Override // java.lang.Runnable
            public final void run() {
                this.f21061a.lambda$handleVideoFrameProcessingException$2(exc);
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
    public /* synthetic */ void lambda$release$1(InterruptedException interruptedException) {
        this.listener.onError(VideoFrameProcessingException.from(interruptedException));
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
        Assertions.checkStateNotNull(this.compositionVideoFrameProcessor);
        Assertions.checkState(!this.compositorEnded);
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_COMPOSITOR_OUTPUT_TEXTURE_RENDERED, j);
        this.compositorOutputTextures.add(new CompositorOutputTextureInfo(glTextureInfo, j, null));
        this.compositorOutputTextureReleases.put(glTextureInfo.texId, new CompositorOutputTextureRelease(glTextureProducer, j));
        if (this.compositionVideoFrameProcessorInputStreamRegistered) {
            queueCompositionOutputInternal();
        } else {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).registerInputStream(3, this.compositionEffects, new FrameInfo.Builder(this.outputColorInfo, glTextureInfo.width, glTextureInfo.height).build());
            this.compositionVideoFrameProcessorInputStreamRegistered = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueCompositionOutputInternal() {
        CompositorOutputTextureInfo compositorOutputTextureInfoPeek;
        Assertions.checkStateNotNull(this.compositionVideoFrameProcessor);
        if (this.compositionVideoFrameProcessorInputStreamRegistrationCompleted && (compositorOutputTextureInfoPeek = this.compositorOutputTextures.peek()) != null) {
            Assertions.checkState(((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).queueInputTexture(compositorOutputTextureInfoPeek.glTextureInfo.texId, compositorOutputTextureInfoPeek.presentationTimeUs));
            this.compositorOutputTextures.remove();
            if (this.compositorEnded && this.compositorOutputTextures.isEmpty()) {
                ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).signalEndOfInput();
            }
        }
    }

    private void queuePreProcessingOutputToCompositor(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j) {
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_OUTPUT_TEXTURE_RENDERED, j);
        ((VideoCompositor) Assertions.checkNotNull(this.videoCompositor)).queueInputTexture(i, glTextureProducer, glTextureInfo, this.outputColorInfo, j);
    }

    public long getInitialTimestampOffsetUs() {
        return this.initialTimestampOffsetUs;
    }

    public ColorInfo getInputColorInfo() {
        return this.inputColorInfo;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public VideoFrameProcessor getProcessor(int i) {
        Assertions.checkState(i < this.preProcessors.size());
        return this.preProcessors.get(i);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public boolean hasProducedFrameWithTimestampZero() {
        return this.hasProducedFrameWithTimestampZero;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    @RequiresApi(api = 17)
    public void initialize() throws VideoFrameProcessingException {
        Assertions.checkState(this.preProcessors.isEmpty() && this.videoCompositor == null && this.compositionVideoFrameProcessor == null && !this.released);
        DefaultVideoFrameProcessor defaultVideoFrameProcessorCreate = this.videoFrameProcessorFactory.create(this.context, this.debugViewProvider, this.outputColorInfo, true, er3.a(), (VideoFrameProcessor.Listener) new AnonymousClass1());
        this.compositionVideoFrameProcessor = defaultVideoFrameProcessorCreate;
        defaultVideoFrameProcessorCreate.setOnInputFrameProcessedListener(new OnInputFrameProcessedListener() { // from class: xs3
            @Override // com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener
            public final void onInputFrameProcessed(int i, long j) {
                this.f22042a.onCompositionVideoFrameProcessorInputFrameProcessed(i, j);
            }
        });
        this.videoCompositor = new DefaultVideoCompositor(this.context, this.glObjectsProvider, this.videoCompositorSettings, this.sharedExecutorService, new VideoCompositor.Listener() { // from class: com.oplus.tbl.exoplayer2.effect.MultipleInputVideoGraph.2
            @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor.Listener
            public void onEnded() {
                MultipleInputVideoGraph.this.onVideoCompositorEnded();
            }

            @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor.Listener
            public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
            }
        }, new GlTextureProducer.Listener() { // from class: zs3
            @Override // com.oplus.tbl.exoplayer2.effect.GlTextureProducer.Listener
            public final void onTextureRendered(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) {
                this.f22503a.processCompositorOutputTexture(glTextureProducer, glTextureInfo, j, j2);
            }
        }, 1);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    @RequiresApi(api = 17)
    public int registerInput() throws VideoFrameProcessingException {
        Assertions.checkStateNotNull(this.videoCompositor);
        final int iRegisterInputSource = this.videoCompositor.registerInputSource();
        this.preProcessors.add(this.videoFrameProcessorFactory.buildUpon().setTextureOutput(new GlTextureProducer.Listener() { // from class: vs3
            @Override // com.oplus.tbl.exoplayer2.effect.GlTextureProducer.Listener
            public final void onTextureRendered(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
                this.f21517a.lambda$registerInput$0(iRegisterInputSource, glTextureProducer, glTextureInfo, j, j2);
            }
        }, 2).build().create(this.context, DebugViewProvider.NONE, this.outputColorInfo, true, this.listenerExecutor, new VideoFrameProcessor.Listener() { // from class: com.oplus.tbl.exoplayer2.effect.MultipleInputVideoGraph.3
            @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
            public void onEnded() {
                MultipleInputVideoGraph.this.onPreProcessingVideoFrameProcessorEnded(iRegisterInputSource);
            }

            @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
            public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.handleVideoFrameProcessingException(videoFrameProcessingException);
            }

            @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
            public void onOutputFrameAvailableForRendering(long j) {
            }

            @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
            public void onOutputSizeChanged(int i, int i2) {
            }

            @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
            public void onInputStreamRegistered(int i, List<Effect> list, FrameInfo frameInfo) {
            }
        }));
        return iRegisterInputSource;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public void release() {
        if (this.released) {
            return;
        }
        for (int i = 0; i < this.preProcessors.size(); i++) {
            this.preProcessors.get(i).release();
        }
        this.preProcessors.clear();
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
        this.sharedExecutorService.shutdown();
        try {
            this.sharedExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.listenerExecutor.execute(new Runnable() { // from class: bt3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1815a.lambda$release$1(e);
                }
            });
        }
        this.released = true;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        ((VideoFrameProcessor) Assertions.checkNotNull(this.compositionVideoFrameProcessor)).setOutputSurfaceInfo(surfaceInfo);
    }
}
