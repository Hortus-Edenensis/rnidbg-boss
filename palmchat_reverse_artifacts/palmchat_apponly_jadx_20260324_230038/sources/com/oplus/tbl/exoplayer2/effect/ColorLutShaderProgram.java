package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class ColorLutShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_lut_es2.glsl";
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final ColorLut colorLut;
    private final GlProgram glProgram;

    @OptIn(markerClass = {UnstableApi.class})
    public ColorLutShaderProgram(Context context, ColorLut colorLut, boolean z) throws VideoFrameProcessingException {
        super(z, 1);
        Assertions.checkArgument(!z, "ColorLutShaderProgram does not support HDR colors.");
        this.colorLut = colorLut;
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.glProgram.use();
            this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.glProgram.setSamplerTexIdUniform("uColorLut", this.colorLut.getLutTextureId(j), 1);
            this.glProgram.setFloatUniform("uColorLutLength", this.colorLut.getLength(j));
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.colorLut.release();
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
