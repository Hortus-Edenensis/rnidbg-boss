package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import com.google.common.collect.ImmutableList;
import defpackage.bc6;
import defpackage.er3;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class SingleInputVideoGraph implements VideoGraph {
    private final Context context;
    private final DebugViewProvider debugViewProvider;
    private volatile boolean hasProducedFrameWithTimestampZero;
    private final VideoGraph.Listener listener;
    private final Executor listenerExecutor;
    private final ColorInfo outputColorInfo;

    @Nullable
    private SurfaceInfo outputSurfaceInfo;
    private boolean released;
    private final boolean renderFramesAutomatically;

    @Nullable
    private VideoFrameProcessor videoFrameProcessor;
    private final VideoFrameProcessor.Factory videoFrameProcessorFactory;
    private ImmutableList<Effect> compositionEffects = ImmutableList.of();
    private int inputIndex = -1;

    /* JADX INFO: renamed from: androidx.media3.effect.SingleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements VideoFrameProcessor.Listener {
        private long lastProcessedFramePresentationTimeUs;

        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnded$4() {
            SingleInputVideoGraph.this.listener.onEnded(this.lastProcessedFramePresentationTimeUs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$3(VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listener.onError(videoFrameProcessingException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFrameAvailableForRendering$2(long j, boolean z) {
            SingleInputVideoGraph.this.listener.onOutputFrameAvailableForRendering(j, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFrameRateChanged$1(float f) {
            SingleInputVideoGraph.this.listener.onOutputFrameRateChanged(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputSizeChanged$0(int i, int i2) {
            SingleInputVideoGraph.this.listener.onOutputSizeChanged(i, i2);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onEnded() {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1328a.lambda$onEnded$4();
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.i1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1323a.lambda$onError$3(videoFrameProcessingException);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public /* synthetic */ void onInputStreamRegistered(int i, Format format, List list) {
            bc6.c(this, i, format, list);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameAvailableForRendering(final long j, final boolean z) {
            if (j == 0) {
                SingleInputVideoGraph.this.hasProducedFrameWithTimestampZero = true;
            }
            this.lastProcessedFramePresentationTimeUs = j;
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.l1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1331a.lambda$onOutputFrameAvailableForRendering$2(j, z);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameRateChanged(final float f) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1320a.lambda$onOutputFrameRateChanged$1(f);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputSizeChanged(final int i, final int i2) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.j1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1325a.lambda$onOutputSizeChanged$0(i, i2);
                }
            });
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
            return false;
        }

        public Factory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // androidx.media3.common.VideoGraph.Factory
        public SingleInputVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, long j, boolean z) {
            return new SingleInputVideoGraph(context, this.videoFrameProcessorFactory, colorInfo, listener, debugViewProvider, executor, z);
        }
    }

    public SingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, VideoGraph.Listener listener, DebugViewProvider debugViewProvider, Executor executor, boolean z) {
        this.context = context;
        this.videoFrameProcessorFactory = factory;
        this.outputColorInfo = colorInfo;
        this.listener = listener;
        this.debugViewProvider = debugViewProvider;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z;
    }

    @Override // androidx.media3.common.VideoGraph
    public void flush() {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.flush();
    }

    @Override // androidx.media3.common.VideoGraph
    public Surface getInputSurface(int i) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.getInputSurface();
    }

    @Override // androidx.media3.common.VideoGraph
    public int getPendingInputFrameCount(int i) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.getPendingInputFrameCount();
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean hasProducedFrameWithTimestampZero() {
        return this.hasProducedFrameWithTimestampZero;
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputBitmap(int i, Bitmap bitmap, TimestampIterator timestampIterator) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.queueInputBitmap(bitmap, timestampIterator);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputTexture(int i, int i2, long j) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.queueInputTexture(i2, j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void redraw() {
        ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).redraw();
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInput(int i) throws VideoFrameProcessingException {
        Assertions.checkStateNotNull(Boolean.valueOf(this.videoFrameProcessor == null && !this.released));
        Assertions.checkState(this.inputIndex == -1, "This VideoGraph supports only one input.");
        this.inputIndex = i;
        VideoFrameProcessor videoFrameProcessorCreate = this.videoFrameProcessorFactory.create(this.context, this.debugViewProvider, this.outputColorInfo, this.renderFramesAutomatically, er3.a(), new AnonymousClass1());
        this.videoFrameProcessor = videoFrameProcessorCreate;
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            videoFrameProcessorCreate.setOutputSurfaceInfo(surfaceInfo);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean registerInputFrame(int i) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.registerInputFrame();
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInputStream(int i, int i2, Format format, List<Effect> list, long j) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.registerInputStream(i2, format, new ImmutableList.a().l(list).l(this.compositionEffects).e(), j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void release() {
        if (this.released) {
            return;
        }
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
        }
        this.released = true;
    }

    @Override // androidx.media3.common.VideoGraph
    public void renderOutputFrame(long j) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.renderOutputFrame(j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositionEffects(List<Effect> list) {
        this.compositionEffects = ImmutableList.copyOf((Collection) list);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        Assertions.checkArgument(videoCompositorSettings.equals(VideoCompositorSettings.DEFAULT), "SingleInputVideoGraph does not use VideoCompositor, and therefore cannot apply VideoCompositorSettings");
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputFrameProcessedListener(int i, OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputSurfaceReadyListener(int i, Runnable runnable) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.setOnInputSurfaceReadyListener(runnable);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        this.outputSurfaceInfo = surfaceInfo;
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.setOutputSurfaceInfo(surfaceInfo);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public void signalEndOfInput(int i) {
        Assertions.checkStateNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.signalEndOfInput();
    }

    @Override // androidx.media3.common.VideoGraph
    public void initialize() {
    }
}
