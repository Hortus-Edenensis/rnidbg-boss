package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class SimpleFrameDroppingShaderProgram extends PassthroughShaderProgram {
    private int framesReceived;
    private final int n;

    public SimpleFrameDroppingShaderProgram(float f, float f2) {
        int iRound = Math.round(f / f2);
        this.n = iRound;
        Assertions.checkArgument(iRound >= 1, "The input frame rate should be greater than the target frame rate.");
    }

    @Override // com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void flush() {
        super.flush();
        this.framesReceived = 0;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        if (this.framesReceived % this.n == 0) {
            super.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        } else {
            getInputListener().onInputFrameProcessed(glTextureInfo);
            getInputListener().onReadyToAcceptInputFrame();
        }
        this.framesReceived++;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        this.framesReceived = 0;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        this.framesReceived = 0;
    }
}
