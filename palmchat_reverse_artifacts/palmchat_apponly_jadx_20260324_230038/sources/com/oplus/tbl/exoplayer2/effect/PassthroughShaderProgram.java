package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.bc2;
import defpackage.dc2;
import defpackage.er3;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class PassthroughShaderProgram implements GlShaderProgram {
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram.1
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
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram.2
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onCurrentOutputStreamEnded() {
            dc2.a(this);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            dc2.b(this, glTextureInfo, j);
        }
    };
    private GlShaderProgram.ErrorListener errorListener = new GlShaderProgram.ErrorListener() { // from class: pc4
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.ErrorListener
        public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
            PassthroughShaderProgram.lambda$new$0(videoFrameProcessingException);
        }
    };
    private Executor errorListenerExecutor = er3.a();
    private int texIdInUse = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$1(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void flush() {
        this.texIdInUse = -1;
        this.inputListener.onFlush();
        this.inputListener.onReadyToAcceptInputFrame();
    }

    public final GlShaderProgram.InputListener getInputListener() {
        return this.inputListener;
    }

    public final void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: nc4
            @Override // java.lang.Runnable
            public final void run() {
                this.f19490a.lambda$onError$1(exc);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        this.texIdInUse = glTextureInfo.texId;
        this.outputListener.onOutputFrameAvailable(glTextureInfo, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.texIdInUse = -1;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        Assertions.checkState(glTextureInfo.texId == this.texIdInUse);
        this.texIdInUse = -1;
        this.inputListener.onInputFrameProcessed(glTextureInfo);
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.texIdInUse == -1) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }
}
