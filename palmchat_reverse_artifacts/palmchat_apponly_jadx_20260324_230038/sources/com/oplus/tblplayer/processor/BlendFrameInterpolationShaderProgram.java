package com.oplus.tblplayer.processor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.FrameCacheGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.OverlayMatrixProvider;
import com.oplus.tbl.exoplayer2.effect.OverlaySettings;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import defpackage.bc2;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class BlendFrameInterpolationShaderProgram extends FrameCacheGlShaderProgram {
    private static final String TAG = "DefaultInterpolationShaderProgram";
    private int framesReceived;
    private long lastQueuedPresentationTimeUs;
    private long previousPresentationTimeUs;

    @Nullable
    private GlTextureInfo previousTexture;
    private final long targetFrameDeltaUs;
    private final boolean useHdr;
    private final AlphaBlendingGlProgram wrappedGlShaderProgram;

    /* JADX INFO: compiled from: SearchBox */
    public static final class AlphaBlendingGlProgram extends BaseGlShaderProgram {
        private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_alpha_scale_es2.glsl";
        private static final String TAG = "CompositorGlProgram";
        private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
        private final OverlaySettings alphaBlendingOverlaySettings;
        private final Context context;
        private final OverlaySettings defaultOverlaySettings;
        private GlProgram glProgram;
        private final OverlayMatrixProvider overlayMatrixProvider;

        public AlphaBlendingGlProgram(Context context, boolean z) throws VideoFrameProcessingException {
            super(z, 1);
            this.context = context;
            this.overlayMatrixProvider = new OverlayMatrixProvider();
            this.defaultOverlaySettings = new OverlaySettings.Builder().build();
            this.alphaBlendingOverlaySettings = new OverlaySettings.Builder().setAlphaScale(0.5f).build();
            try {
                GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
                this.glProgram = glProgram;
                glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
                this.glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
            } catch (GlUtil.GlException | IOException e) {
                throw new VideoFrameProcessingException(e);
            }
        }

        private void blendOntoFocusedTexture(GlTextureInfo glTextureInfo, OverlaySettings overlaySettings) throws GlUtil.GlException {
            GlProgram glProgram = (GlProgram) Assertions.checkNotNull(this.glProgram);
            glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
            glProgram.setFloatsUniform("uTransformationMatrix", this.overlayMatrixProvider.getTransformationMatrix(new Size(glTextureInfo.width, glTextureInfo.height), overlaySettings));
            glProgram.setFloatUniform("uAlphaScale", overlaySettings.alphaScale);
            glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        }

        @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
        public Size configure(int i, int i2) throws VideoFrameProcessingException {
            return new Size(i, i2);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
        public void drawFrame(int i, long j) throws VideoFrameProcessingException {
            throw new VideoFrameProcessingException(new UnsupportedOperationException());
        }

        @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
        public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        }

        @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
        public void release() throws VideoFrameProcessingException {
            super.release();
            try {
                GlProgram glProgram = this.glProgram;
                if (glProgram != null) {
                    glProgram.delete();
                }
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        }

        public void drawFrame(GlTextureInfo glTextureInfo, GlTextureInfo glTextureInfo2, GlTextureInfo glTextureInfo3) throws VideoFrameProcessingException, GlUtil.GlException {
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo3.fboId, glTextureInfo3.width, glTextureInfo3.height);
            this.overlayMatrixProvider.configure(new Size(glTextureInfo3.width, glTextureInfo3.height));
            GlUtil.clearFocusedBuffers();
            ((GlProgram) Assertions.checkNotNull(this.glProgram)).use();
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
            GlUtil.checkGlError();
            blendOntoFocusedTexture(glTextureInfo, this.defaultOverlaySettings);
            blendOntoFocusedTexture(glTextureInfo2, this.alphaBlendingOverlaySettings);
            GLES20.glDisable(3042);
            GlUtil.checkGlError();
        }

        public void queueInputFrame(GlObjectsProvider glObjectsProvider, List<GlTextureInfo> list, long j) {
        }
    }

    public BlendFrameInterpolationShaderProgram(Context context, boolean z, float f) throws VideoFrameProcessingException {
        super(context, 1, z);
        this.wrappedGlShaderProgram = new AlphaBlendingGlProgram(context, z);
        this.useHdr = z;
        this.targetFrameDeltaUs = (long) (1000000.0f / f);
        this.lastQueuedPresentationTimeUs = -9223372036854775807L;
        this.previousPresentationTimeUs = -9223372036854775807L;
    }

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
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
            GlUtil.clearFocusedBuffers();
            this.wrappedGlShaderProgram.drawFrame(glTextureInfo2, glTextureInfo, glTextureInfoUseTexture);
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
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
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
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        this.wrappedGlShaderProgram.releaseOutputFrame(glTextureInfo);
        super.releaseOutputFrame(glTextureInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        super.setErrorListener(executor, errorListener);
        this.wrappedGlShaderProgram.setErrorListener(executor, errorListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        super.setInputListener(inputListener);
        this.wrappedGlShaderProgram.setInputListener(new GlShaderProgram.InputListener() { // from class: com.oplus.tblplayer.processor.BlendFrameInterpolationShaderProgram.1
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
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        super.setOutputListener(outputListener);
        this.wrappedGlShaderProgram.setOutputListener(outputListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        reset();
    }
}
