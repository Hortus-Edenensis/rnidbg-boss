package com.oplus.tblplayer.processor;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OverlayBlendTwoTextureShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_overlay_alpha_blend_two_tex_es2.glsl";
    private static final String TAG = "TblBlendTwoTextureShaderProgram";
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_overlay_alpha_blend_two_tex_es2.glsl";
    private final GlProgram mGlProgram;

    public OverlayBlendTwoTextureShaderProgram(Context context, boolean z, @FloatRange(from = 0.0d) float f, boolean z2) throws VideoFrameProcessingException {
        super(z, 1);
        Assertions.checkArgument(0.0f <= f, "Invalid input alpha-scale value: " + f);
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.mGlProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            glProgram.setFloatUniform("uOverlayAlphaScale1", f);
            glProgram.setIntUniform("uEnableColorTransfer", z2 ? 1 : 0);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void changeOverlayTextureAlpha(@FloatRange(from = 0.0d) float f) {
        Assertions.checkArgument(0.0f <= f, "Invalid input alpha-scale value: " + f);
        this.mGlProgram.setFloatUniform("uOverlayAlphaScale1", f);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    @NonNull
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        throw new VideoFrameProcessingException(new UnsupportedOperationException());
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.mGlProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    public Size configure(@NonNull InputFrameInfoPair inputFrameInfoPair) {
        return inputFrameInfoPair.videoInput.originSize;
    }

    public void drawFrame(@NonNull InputFrameInfoPair inputFrameInfoPair) throws VideoFrameProcessingException {
        try {
            this.mGlProgram.use();
            InputFrameInfo inputFrameInfo = inputFrameInfoPair.videoInput;
            InputFrameInfo inputFrameInfo2 = inputFrameInfoPair.alphaOverlayInput;
            this.mGlProgram.setSamplerTexIdUniform("uVideoTexSampler0", inputFrameInfo.textureInfo.texId, 0);
            this.mGlProgram.setSamplerTexIdUniform("uOverlayTexSampler1", inputFrameInfo2.textureInfo.texId, 1);
            this.mGlProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, inputFrameInfoPair.videoInput.presentationTimeUs);
        }
    }
}
