package com.oplus.tbl.exoplayer2.effect;

import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.bc2;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class FrameConsumptionManager implements GlShaderProgram.InputListener {

    @GuardedBy("this")
    private final Queue<Pair<GlTextureInfo, Long>> availableFrames = new ArrayDeque();
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
    public /* synthetic */ void lambda$onReadyToAcceptInputFrame$0(Pair pair) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, (GlTextureInfo) pair.first, ((Long) pair.second).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$1(GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, glTextureInfo, j);
    }

    public synchronized int getPendingFrameCount() {
        return this.availableFrames.size();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public synchronized void onFlush() {
        this.consumingGlShaderProgramInputCapacity = 0;
        this.availableFrames.clear();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        bc2.b(this, glTextureInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    @OptIn(markerClass = {UnstableApi.class})
    public synchronized void onReadyToAcceptInputFrame() {
        final Pair<GlTextureInfo, Long> pairPoll = this.availableFrames.poll();
        if (pairPoll == null) {
            this.consumingGlShaderProgramInputCapacity++;
            return;
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.q0
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7621a.lambda$onReadyToAcceptInputFrame$0(pairPoll);
            }
        });
        Pair<GlTextureInfo, Long> pairPeek = this.availableFrames.peek();
        if (pairPeek != null && ((Long) pairPeek.second).longValue() == Long.MIN_VALUE) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new p0(glShaderProgram));
            this.availableFrames.remove();
        }
    }

    public synchronized void queueInputFrame(final GlTextureInfo glTextureInfo, final long j) {
        if (this.consumingGlShaderProgramInputCapacity > 0) {
            this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.o0
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f7617a.lambda$queueInputFrame$1(glTextureInfo, j);
                }
            });
            this.consumingGlShaderProgramInputCapacity--;
        } else {
            this.availableFrames.add(Pair.create(glTextureInfo, Long.valueOf(j)));
        }
    }

    public synchronized void signalEndOfCurrentStream() {
        if (this.availableFrames.isEmpty()) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new p0(glShaderProgram));
        } else {
            this.availableFrames.add(Pair.create(GlTextureInfo.UNSET, Long.MIN_VALUE));
        }
    }
}
