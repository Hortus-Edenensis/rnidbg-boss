package com.oplus.tbl.exoplayer2.effect;

import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class TexIdTextureManager extends TextureManager {
    private FrameConsumptionManager frameConsumptionManager;
    private OnInputFrameProcessedListener frameProcessedListener;
    private final GlObjectsProvider glObjectsProvider;
    private FrameInfo inputFrameInfo;

    public TexIdTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputFrameProcessed$0(GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        ((OnInputFrameProcessedListener) Assertions.checkNotNull(this.frameProcessedListener)).onInputFrameProcessed(glTextureInfo.texId, GlUtil.createGlSyncFence());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputTexture$1(int i, FrameInfo frameInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        ((FrameConsumptionManager) Assertions.checkNotNull(this.frameConsumptionManager)).queueInputFrame(new GlTextureInfo(i, -1, -1, frameInfo.width, frameInfo.height), j);
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_VFP_QUEUE_TEXTURE, j, "%dx%d", Integer.valueOf(frameInfo.width), Integer.valueOf(frameInfo.height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalEndOfCurrentInputStream$2() throws VideoFrameProcessingException, GlUtil.GlException {
        ((FrameConsumptionManager) Assertions.checkNotNull(this.frameConsumptionManager)).signalEndOfCurrentStream();
        DebugTraceUtil.logEvent(DebugTraceUtil.EVENT_TEX_ID_TEXTURE_MANAGER_SIGNAL_EOS, Long.MIN_VALUE);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public synchronized void flush() {
        ((FrameConsumptionManager) Assertions.checkNotNull(this.frameConsumptionManager)).onFlush();
        super.flush();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public int getPendingFrameCount() {
        return ((FrameConsumptionManager) Assertions.checkNotNull(this.frameConsumptionManager)).getPendingFrameCount();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager, com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    @RequiresApi(api = 17)
    public void onInputFrameProcessed(final GlTextureInfo glTextureInfo) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.b1
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7588a.lambda$onInputFrameProcessed$0(glTextureInfo);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager, com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        Assertions.checkNotNull(this.frameConsumptionManager);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
        final FrameConsumptionManager frameConsumptionManager = this.frameConsumptionManager;
        Objects.requireNonNull(frameConsumptionManager);
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.z0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                frameConsumptionManager.onReadyToAcceptInputFrame();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void queueInputTexture(final int i, final long j) {
        final FrameInfo frameInfo = (FrameInfo) Assertions.checkNotNull(this.inputFrameInfo);
        Assertions.checkNotNull(this.frameProcessedListener);
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.a1
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7585a.lambda$queueInputTexture$1(i, frameInfo, j);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setInputFrameInfo(FrameInfo frameInfo) {
        this.inputFrameInfo = frameInfo;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        this.frameProcessedListener = onInputFrameProcessedListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        this.frameConsumptionManager = new FrameConsumptionManager(this.glObjectsProvider, glShaderProgram, this.videoFrameProcessingTaskExecutor);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.c1
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7591a.lambda$signalEndOfCurrentInputStream$2();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureManager
    public void release() {
    }
}
