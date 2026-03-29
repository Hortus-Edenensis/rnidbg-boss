package com.oplus.tbl.exoplayer2.effect;

import androidx.annotation.CallSuper;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.bc2;
import defpackage.dc2;
import defpackage.er3;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class BaseGlShaderProgram implements GlShaderProgram {
    public final TexturePool outputTexturePool;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram.1
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
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram.2
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onCurrentOutputStreamEnded() {
            dc2.a(this);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            dc2.b(this, glTextureInfo, j);
        }
    };
    private GlShaderProgram.ErrorListener errorListener = new GlShaderProgram.ErrorListener() { // from class: kq
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.ErrorListener
        public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
            BaseGlShaderProgram.lambda$new$0(videoFrameProcessingException);
        }
    };
    private Executor errorListenerExecutor = er3.a();
    private int inputWidth = -1;
    private int inputHeight = -1;

    public BaseGlShaderProgram(boolean z, int i) {
        this.outputTexturePool = new TexturePool(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$2(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$1(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    public abstract Size configure(int i, int i2) throws VideoFrameProcessingException;

    public abstract void drawFrame(int i, long j) throws VideoFrameProcessingException;

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @CallSuper
    public void flush() {
        this.outputTexturePool.freeAllTextures();
        this.inputListener.onFlush();
        for (int i = 0; i < this.outputTexturePool.capacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    public final GlShaderProgram.InputListener getInputListener() {
        return this.inputListener;
    }

    public final GlShaderProgram.OutputListener getOutputListener() {
        return this.outputListener;
    }

    public final void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: oq
            @Override // java.lang.Runnable
            public final void run() {
                this.f19807a.lambda$onError$2(exc);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            if (this.inputWidth != glTextureInfo.width || this.inputHeight != glTextureInfo.height || !this.outputTexturePool.isConfigured()) {
                int i = glTextureInfo.width;
                this.inputWidth = i;
                int i2 = glTextureInfo.height;
                this.inputHeight = i2;
                Size sizeConfigure = configure(i, i2);
                this.outputTexturePool.ensureConfigured(glObjectsProvider, sizeConfigure.getWidth(), sizeConfigure.getHeight());
            }
            GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
            if (shouldClearTextureBuffer()) {
                GlUtil.clearFocusedBuffers();
            }
            drawFrame(glTextureInfo.texId, j);
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            this.outputListener.onOutputFrameAvailable(glTextureInfoUseTexture, j);
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            this.errorListenerExecutor.execute(new Runnable() { // from class: mq
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19289a.lambda$queueInputFrame$1(e);
                }
            });
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @CallSuper
    public void release() throws VideoFrameProcessingException {
        try {
            this.outputTexturePool.deleteAllTextures();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.outputTexturePool.isUsingTexture(glTextureInfo)) {
            this.outputTexturePool.freeTexture(glTextureInfo);
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        for (int i = 0; i < this.outputTexturePool.freeTextureCount(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    public boolean shouldClearTextureBuffer() {
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }
}
