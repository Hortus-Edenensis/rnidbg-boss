package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.PassthroughShaderProgram;
import defpackage.cc2;
import defpackage.ec2;
import defpackage.er3;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class PassthroughShaderProgram implements GlShaderProgram {
    private boolean released;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.PassthroughShaderProgram.1
        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onFlush() {
            cc2.a(this);
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            cc2.b(this, glTextureInfo);
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onReadyToAcceptInputFrame() {
            cc2.c(this);
        }
    };
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.PassthroughShaderProgram.2
        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onCurrentOutputStreamEnded() {
            ec2.a(this);
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            ec2.b(this, glTextureInfo, j);
        }
    };
    private GlShaderProgram.ErrorListener errorListener = new GlShaderProgram.ErrorListener() { // from class: oc4
        @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
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

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.texIdInUse = -1;
        this.inputListener.onFlush();
        this.inputListener.onReadyToAcceptInputFrame();
    }

    public final GlShaderProgram.InputListener getInputListener() {
        return this.inputListener;
    }

    public final void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: qc4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20226a.lambda$onError$1(exc);
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        this.texIdInUse = glTextureInfo.texId;
        this.outputListener.onOutputFrameAvailable(glTextureInfo, j);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.released = true;
        this.texIdInUse = -1;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        Assertions.checkState(glTextureInfo.texId == this.texIdInUse || this.released);
        this.texIdInUse = -1;
        this.inputListener.onInputFrameProcessed(glTextureInfo);
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.texIdInUse == -1) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }
}
