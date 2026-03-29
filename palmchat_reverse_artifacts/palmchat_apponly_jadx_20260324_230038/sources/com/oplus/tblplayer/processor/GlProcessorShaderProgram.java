package com.oplus.tblplayer.processor;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.ProcessingGlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tblplayer.processor.GlProcessorEffect;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class GlProcessorShaderProgram extends BaseGlShaderProgram implements ProcessingGlShaderProgram {
    private int inputHeight;
    private int inputWidth;

    @Nullable
    private final GlProcessorEffect.Processor processor;

    @Nullable
    private ColorInfo streamColorInfo;
    private final boolean useHighPrecisionColorComponents;

    @Nullable
    private ColorInfo workingColorInfo;

    public GlProcessorShaderProgram(Context context, boolean z, @NonNull GlProcessorEffect.Processor processor) throws VideoFrameProcessingException {
        super(z, 1);
        this.useHighPrecisionColorComponents = z;
        try {
            if (!processor.isColorComponentsSupported(z)) {
                this.processor = null;
            } else {
                processor.init(context, z);
                this.processor = processor;
            }
        } catch (Exception e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void processTexture(GlTextureInfo glTextureInfo, GlTextureInfo glTextureInfo2, long j) throws VideoFrameProcessingException {
        try {
            ((GlProcessorEffect.Processor) Assertions.checkNotNull(this.processor)).processTexture(new GlProcessorEffect.GlFrameInfo(glTextureInfo, this.workingColorInfo), new GlProcessorEffect.GlFrameInfo(glTextureInfo2, this.workingColorInfo), j);
        } catch (Exception e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    @NonNull
    public Size configure(int i, int i2) throws VideoFrameProcessingException {
        try {
            return ((GlProcessorEffect.Processor) Assertions.checkNotNull(this.processor)).configureSize(i, i2);
        } catch (Exception e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.ProcessingGlShaderProgram
    public boolean isColorComponentsSupported(boolean z) {
        return this.processor != null;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(@NonNull GlObjectsProvider glObjectsProvider, @NonNull GlTextureInfo glTextureInfo, long j) {
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
            processTexture(glTextureInfo, glTextureInfoUseTexture, j);
            getInputListener().onInputFrameProcessed(glTextureInfo);
            getOutputListener().onOutputFrameAvailable(glTextureInfoUseTexture, j);
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            onError(VideoFrameProcessingException.from(e));
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            ((GlProcessorEffect.Processor) Assertions.checkNotNull(this.processor)).release();
            super.release();
        } catch (Exception e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.ProcessingGlShaderProgram
    public void setWorkingColorInfo(@NonNull ColorInfo colorInfo, @NonNull ColorInfo colorInfo2) throws VideoFrameProcessingException {
        this.streamColorInfo = colorInfo;
        this.workingColorInfo = colorInfo2;
        try {
            ((GlProcessorEffect.Processor) Assertions.checkNotNull(this.processor)).configureWorkingColorInfo(colorInfo, colorInfo2);
        } catch (Exception e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
    }
}
