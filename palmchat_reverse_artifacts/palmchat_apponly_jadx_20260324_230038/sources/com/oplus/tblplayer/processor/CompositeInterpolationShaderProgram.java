package com.oplus.tblplayer.processor;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.FrameCacheGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import defpackage.bc2;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CompositeInterpolationShaderProgram extends FrameCacheGlShaderProgram {
    private static final String TAG = "CompositeInterpolationShaderProgram";
    private int framesReceived;
    private long lastQueuedPresentationTimeUs;
    private long previousPresentationTimeUs;

    @Nullable
    private GlTextureInfo previousTexture;
    private final long targetFrameDeltaUs;
    private final boolean useHdr;
    private final CompositeTwoTextureShaderProgram wrappedGlShaderProgram;

    public CompositeInterpolationShaderProgram(Context context, boolean z, @FloatRange(from = 0.0d) float f, float f2) throws VideoFrameProcessingException {
        super(context, 1, z);
        this.wrappedGlShaderProgram = new CompositeTwoTextureShaderProgram(context, z, f);
        this.useHdr = z;
        this.targetFrameDeltaUs = (long) (1000000.0f / f2);
        this.lastQueuedPresentationTimeUs = -9223372036854775807L;
        this.previousPresentationTimeUs = -9223372036854775807L;
    }

    @SuppressLint({"LongLogTag"})
    private void copyTextureToPreviousFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            if (this.previousTexture == null) {
                this.previousTexture = glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(glTextureInfo.width, glTextureInfo.height, this.useHdr), glTextureInfo.width, glTextureInfo.height);
            }
            GlTextureInfo glTextureInfoCreateBuffersForTexture = (GlTextureInfo) Assertions.checkNotNull(this.previousTexture);
            if (glTextureInfoCreateBuffersForTexture.height != glTextureInfo.height || glTextureInfoCreateBuffersForTexture.width != glTextureInfo.width) {
                glTextureInfoCreateBuffersForTexture.release();
                glTextureInfoCreateBuffersForTexture = glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(glTextureInfo.width, glTextureInfo.height, this.useHdr), glTextureInfo.width, glTextureInfo.height);
            }
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoCreateBuffersForTexture.fboId, glTextureInfoCreateBuffersForTexture.width, glTextureInfoCreateBuffersForTexture.height);
            GlUtil.clearFocusedBuffers();
            drawFrame(glTextureInfo.texId, j);
            this.previousPresentationTimeUs = j;
            this.previousTexture = glTextureInfoCreateBuffersForTexture;
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            onError(e);
        }
    }

    @SuppressLint({"LongLogTag"})
    private void queueAlphaBlendingFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            GlTextureInfo glTextureInfo2 = (GlTextureInfo) Assertions.checkNotNull(this.previousTexture);
            Size sizeConfigure = this.wrappedGlShaderProgram.configure(glTextureInfo2.width, glTextureInfo2.height);
            this.wrappedGlShaderProgram.outputTexturePool.ensureConfigured(glObjectsProvider, sizeConfigure.getWidth(), sizeConfigure.getHeight());
            GlTextureInfo glTextureInfoUseTexture = this.wrappedGlShaderProgram.outputTexturePool.useTexture();
            this.wrappedGlShaderProgram.drawFrame(new InputFrameInfoPair(new InputFrameInfo(glTextureInfo2, j), new InputFrameInfo(glTextureInfo, j)), glTextureInfoUseTexture);
            this.wrappedGlShaderProgram.getOutputListener().onOutputFrameAvailable(glTextureInfoUseTexture, j);
            this.lastQueuedPresentationTimeUs = j;
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            this.wrappedGlShaderProgram.onError(e);
        }
    }

    @SuppressLint({"LongLogTag"})
    private void queuePreviousFrame(GlObjectsProvider glObjectsProvider) {
        try {
            GlTextureInfo glTextureInfo = (GlTextureInfo) Assertions.checkNotNull(this.previousTexture);
            Size sizeConfigure = configure(glTextureInfo.width, glTextureInfo.height);
            this.outputTexturePool.ensureConfigured(glObjectsProvider, sizeConfigure.getWidth(), sizeConfigure.getHeight());
            GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
            GlUtil.clearFocusedBuffers();
            drawFrame(glTextureInfo.texId, this.previousPresentationTimeUs);
            getOutputListener().onOutputFrameAvailable(glTextureInfoUseTexture, this.previousPresentationTimeUs);
            this.lastQueuedPresentationTimeUs = this.previousPresentationTimeUs;
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            onError(e);
        }
    }

    private void reset() {
        try {
            GlTextureInfo glTextureInfo = this.previousTexture;
            if (glTextureInfo != null) {
                glTextureInfo.release();
                this.previousTexture = null;
            }
        } catch (GlUtil.GlException e) {
            onError(e);
        }
        this.lastQueuedPresentationTimeUs = -9223372036854775807L;
        this.previousPresentationTimeUs = -9223372036854775807L;
        this.framesReceived = 0;
    }

    private boolean shouldQueueInterpolationFrame(long j) {
        return this.previousTexture != null;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void flush() {
        super.flush();
        this.wrappedGlShaderProgram.flush();
        reset();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @SuppressLint({"LongLogTag"})
    public void queueInputFrame(@NonNull GlObjectsProvider glObjectsProvider, @NonNull GlTextureInfo glTextureInfo, long j) {
        this.framesReceived++;
        if (shouldQueueInterpolationFrame(j)) {
            long j2 = this.previousPresentationTimeUs;
            queueAlphaBlendingFrame(glObjectsProvider, glTextureInfo, j2 + ((j - j2) / 2));
        }
        copyTextureToPreviousFrame(glObjectsProvider, glTextureInfo, j);
        queuePreviousFrame(glObjectsProvider);
        getInputListener().onInputFrameProcessed(glTextureInfo);
        if (this.outputTexturePool.freeTextureCount() > 0) {
            getInputListener().onReadyToAcceptInputFrame();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.FrameCacheGlShaderProgram, com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        this.wrappedGlShaderProgram.release();
        try {
            GlTextureInfo glTextureInfo = this.previousTexture;
            if (glTextureInfo != null) {
                glTextureInfo.release();
                this.previousTexture = null;
            }
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void releaseOutputFrame(@NonNull GlTextureInfo glTextureInfo) {
        this.wrappedGlShaderProgram.releaseOutputFrame(glTextureInfo);
        super.releaseOutputFrame(glTextureInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(@NonNull Executor executor, @NonNull GlShaderProgram.ErrorListener errorListener) {
        super.setErrorListener(executor, errorListener);
        this.wrappedGlShaderProgram.setErrorListener(executor, errorListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(@NonNull GlShaderProgram.InputListener inputListener) {
        super.setInputListener(inputListener);
        this.wrappedGlShaderProgram.setInputListener(new GlShaderProgram.InputListener() { // from class: com.oplus.tblplayer.processor.CompositeInterpolationShaderProgram.1
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
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setOutputListener(@NonNull GlShaderProgram.OutputListener outputListener) {
        super.setOutputListener(outputListener);
        this.wrappedGlShaderProgram.setOutputListener(outputListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        reset();
    }
}
