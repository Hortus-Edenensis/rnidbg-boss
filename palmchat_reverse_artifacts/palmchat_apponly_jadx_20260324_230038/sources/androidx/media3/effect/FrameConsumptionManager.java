package androidx.media3.effect;

import androidx.annotation.GuardedBy;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import defpackage.cc2;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class FrameConsumptionManager implements GlShaderProgram.InputListener {

    @GuardedBy("this")
    private final Queue<TimedGlTextureInfo> availableFrames = new ArrayDeque();
    private final GlShaderProgram consumingGlShaderProgram;

    @GuardedBy("this")
    private int consumingGlShaderProgramInputCapacity;
    private final GlObjectsProvider glObjectsProvider;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public FrameConsumptionManager(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.glObjectsProvider = glObjectsProvider;
        this.consumingGlShaderProgram = glShaderProgram;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$0(TimedGlTextureInfo timedGlTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, timedGlTextureInfo.glTextureInfo, timedGlTextureInfo.presentationTimeUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$1(GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, glTextureInfo, j);
    }

    public synchronized int getPendingFrameCount() {
        return this.availableFrames.size();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onFlush() {
        this.consumingGlShaderProgramInputCapacity = 0;
        this.availableFrames.clear();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        cc2.b(this, glTextureInfo);
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onReadyToAcceptInputFrame() {
        final TimedGlTextureInfo timedGlTextureInfoPoll = this.availableFrames.poll();
        if (timedGlTextureInfoPoll == null) {
            this.consumingGlShaderProgramInputCapacity++;
            return;
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.x0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1362a.lambda$onReadyToAcceptInputFrame$0(timedGlTextureInfoPoll);
            }
        });
        TimedGlTextureInfo timedGlTextureInfoPeek = this.availableFrames.peek();
        if (timedGlTextureInfoPeek != null && timedGlTextureInfoPeek.presentationTimeUs == Long.MIN_VALUE) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new v0(glShaderProgram));
            this.availableFrames.remove();
        }
    }

    public synchronized void queueInputFrame(final GlTextureInfo glTextureInfo, final long j) {
        if (this.consumingGlShaderProgramInputCapacity > 0) {
            this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.w0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f1360a.lambda$queueInputFrame$1(glTextureInfo, j);
                }
            });
            this.consumingGlShaderProgramInputCapacity--;
        } else {
            this.availableFrames.add(new TimedGlTextureInfo(glTextureInfo, j));
        }
    }

    public synchronized void signalEndOfCurrentStream() {
        if (this.availableFrames.isEmpty()) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new v0(glShaderProgram));
        } else {
            this.availableFrames.add(new TimedGlTextureInfo(GlTextureInfo.UNSET, Long.MIN_VALUE));
        }
    }
}
