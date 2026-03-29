package com.oplus.tblplayer.processor;

import android.content.Context;
import android.opengl.GLES20;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tblplayer.utils.AssertUtil;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TextureMatrixShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_apply_homo_matrix_es2.glsl";
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final GlProgram glProgram;
    private final HomoMatrixTransformation matrixTransformation;

    public TextureMatrixShaderProgram(Context context, boolean z, HomoMatrixTransformation homoMatrixTransformation) throws VideoFrameProcessingException {
        super(z, 1);
        this.matrixTransformation = homoMatrixTransformation;
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            glProgram.setFloatsUniform("uTransformationMatrix", GlUtil.create4x4IdentityMatrix());
            glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
            glProgram.setIntUniform("uEnableEdgeBlur", homoMatrixTransformation.isEnableEdgeBlur ? 1 : 0);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        AssertUtil.checkArgument(i > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(i2 > 0, "inputHeight must be positive");
        if (this.matrixTransformation.isEnableEdgeBlur) {
            this.glProgram.setFloatsUniform("uEdgeTexelSize", new float[]{1.0f / i, 1.0f / i2});
            this.glProgram.setFloatUniform("uEdgeBlurAmount", this.matrixTransformation.getEdgeBlurAmount());
        }
        return this.matrixTransformation.configure(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.glProgram.use();
            this.glProgram.setFloatsUniform("uHomographyTransformationMatrix", this.matrixTransformation.getGlMatrixArray(j));
            this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, j);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
