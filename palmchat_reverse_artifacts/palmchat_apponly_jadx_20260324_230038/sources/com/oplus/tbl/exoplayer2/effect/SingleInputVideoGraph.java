package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.SurfaceInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.VideoGraph;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.er3;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class SingleInputVideoGraph implements VideoGraph {
    public static final int SINGLE_INPUT_INDEX = 0;
    private final Context context;
    private final DebugViewProvider debugViewProvider;
    private volatile boolean hasProducedFrameWithTimestampZero;
    private final long initialTimestampOffsetUs;
    private final ColorInfo inputColorInfo;
    private boolean isEnded;
    private final VideoGraph.Listener listener;
    private final Executor listenerExecutor;
    private final ColorInfo outputColorInfo;

    @Nullable
    private SurfaceInfo outputSurfaceInfo;

    @Nullable
    private final Presentation presentation;
    private boolean released;
    private final boolean renderFramesAutomatically;

    @Nullable
    private VideoFrameProcessor videoFrameProcessor;
    private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

    public SingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, ColorInfo colorInfo2, VideoGraph.Listener listener, DebugViewProvider debugViewProvider, Executor executor, VideoCompositorSettings videoCompositorSettings, boolean z, @Nullable Presentation presentation, long j) {
        Assertions.checkState(VideoCompositorSettings.DEFAULT.equals(videoCompositorSettings), "SingleInputVideoGraph does not use VideoCompositor, and therefore cannot apply VideoCompositorSettings");
        this.context = context;
        this.videoFrameProcessorFactory = factory;
        this.inputColorInfo = colorInfo;
        this.outputColorInfo = colorInfo2;
        this.listener = listener;
        this.debugViewProvider = debugViewProvider;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z;
        this.presentation = presentation;
        this.initialTimestampOffsetUs = j;
    }

    public long getInitialTimestampOffsetUs() {
        return this.initialTimestampOffsetUs;
    }

    public ColorInfo getInputColorInfo() {
        return this.inputColorInfo;
    }

    @Nullable
    public Presentation getPresentation() {
        return this.presentation;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public VideoFrameProcessor getProcessor(int i) {
        return (VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public boolean hasProducedFrameWithTimestampZero() {
        return this.hasProducedFrameWithTimestampZero;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public int registerInput() throws VideoFrameProcessingException {
        Assertions.checkStateNotNull(Boolean.valueOf(this.videoFrameProcessor == null && !this.released));
        VideoFrameProcessor videoFrameProcessorCreate = this.videoFrameProcessorFactory.create(this.context, this.debugViewProvider, this.outputColorInfo, this.renderFramesAutomatically, er3.a(), new AnonymousClass1());
        this.videoFrameProcessor = videoFrameProcessorCreate;
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            videoFrameProcessorCreate.setOutputSurfaceInfo(surfaceInfo);
        }
        return 0;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public void release() {
        if (this.released) {
            return;
        }
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
            this.videoFrameProcessor = null;
        }
        this.released = true;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo) {
        this.outputSurfaceInfo = surfaceInfo;
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.setOutputSurfaceInfo(surfaceInfo);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph
    public void initialize() {
    }

    /* JADX INFO: renamed from: com.oplus.tbl.exoplayer2.effect.SingleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements VideoFrameProcessor.Listener {
        private long lastProcessedFramePresentationTimeUs;

        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnded$3() {
            SingleInputVideoGraph.this.listener.onEnded(this.lastProcessedFramePresentationTimeUs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$2(VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listener.onError(videoFrameProcessingException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFrameAvailableForRendering$1(long j) {
            SingleInputVideoGraph.this.listener.onOutputFrameAvailableForRendering(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputSizeChanged$0(int i, int i2) {
            SingleInputVideoGraph.this.listener.onOutputSizeChanged(i, i2);
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onEnded() {
            if (SingleInputVideoGraph.this.isEnded) {
                onError(new VideoFrameProcessingException("onEnded() received multiple times"));
            } else {
                SingleInputVideoGraph.this.isEnded = true;
                SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7635a.lambda$onEnded$3();
                    }
                });
            }
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7631a.lambda$onError$2(videoFrameProcessingException);
                }
            });
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onOutputFrameAvailableForRendering(final long j) {
            if (SingleInputVideoGraph.this.isEnded) {
                onError(new VideoFrameProcessingException("onOutputFrameAvailableForRendering() received after onEnded()"));
                return;
            }
            if (j == 0) {
                SingleInputVideoGraph.this.hasProducedFrameWithTimestampZero = true;
            }
            this.lastProcessedFramePresentationTimeUs = j;
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7633a.lambda$onOutputFrameAvailableForRendering$1(j);
                }
            });
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onOutputSizeChanged(final int i, final int i2) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.effect.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7629a.lambda$onOutputSizeChanged$0(i, i2);
                }
            });
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Listener
        public void onInputStreamRegistered(int i, List<Effect> list, FrameInfo frameInfo) {
        }
    }
}
