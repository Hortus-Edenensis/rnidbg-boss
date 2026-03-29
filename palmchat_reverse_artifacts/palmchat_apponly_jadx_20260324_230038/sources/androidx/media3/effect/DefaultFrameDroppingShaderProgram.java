package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class DefaultFrameDroppingShaderProgram extends FrameCacheGlShaderProgram {
    private int framesReceived;
    private long lastQueuedPresentationTimeUs;
    private long previousPresentationTimeUs;

    @Nullable
    private GlTextureInfo previousTexture;
    private final long targetFrameDeltaUs;
    private final boolean useHdr;

    public DefaultFrameDroppingShaderProgram(Context context, boolean z, float f) throws VideoFrameProcessingException {
        super(context, 1, z);
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
            }
        } catch (GlUtil.GlException e) {
            onError(e);
        }
        this.lastQueuedPresentationTimeUs = -9223372036854775807L;
        this.previousPresentationTimeUs = -9223372036854775807L;
        this.framesReceived = 0;
    }

    private boolean shouldQueuePreviousFrame(long j) {
        if (this.framesReceived == 2) {
            return false;
        }
        long j2 = this.previousPresentationTimeUs;
        long j3 = this.lastQueuedPresentationTimeUs;
        return Math.abs((j2 - j3) - this.targetFrameDeltaUs) < Math.abs((j - j3) - this.targetFrameDeltaUs);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        super.flush();
        reset();
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        int i = this.framesReceived + 1;
        this.framesReceived = i;
        if (i == 1) {
            copyTextureToPreviousFrame(glObjectsProvider, glTextureInfo, j);
            queuePreviousFrame(glObjectsProvider);
            getInputListener().onInputFrameProcessed(glTextureInfo);
            getInputListener().onReadyToAcceptInputFrame();
            return;
        }
        if (shouldQueuePreviousFrame(j)) {
            queuePreviousFrame(glObjectsProvider);
        }
        copyTextureToPreviousFrame(glObjectsProvider, glTextureInfo, j);
        getInputListener().onInputFrameProcessed(glTextureInfo);
        if (this.outputTexturePool.freeTextureCount() > 0) {
            getInputListener().onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.FrameCacheGlShaderProgram, androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            GlTextureInfo glTextureInfo = this.previousTexture;
            if (glTextureInfo != null) {
                glTextureInfo.release();
            }
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        reset();
    }
}
