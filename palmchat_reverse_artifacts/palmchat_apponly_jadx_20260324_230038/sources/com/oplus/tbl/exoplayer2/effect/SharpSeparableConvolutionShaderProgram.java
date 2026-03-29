package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.graphics.Matrix;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
final class SharpSeparableConvolutionShaderProgram extends SeparableConvolutionShaderProgram {
    private final GlProgram sharpTransformGlProgram;
    private final float[] sharpTransformMatrixValues;

    public SharpSeparableConvolutionShaderProgram(Context context, boolean z, SeparableConvolution separableConvolution, float f, float f2) throws VideoFrameProcessingException {
        super(context, z, separableConvolution, 1.0f / f, 1.0f / f2);
        try {
            this.sharpTransformGlProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_copy_es2.glsl");
            Matrix matrix = new Matrix();
            matrix.setScale(f, f2);
            this.sharpTransformMatrixValues = MatrixUtils.getGlMatrixArray(matrix);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolutionShaderProgram
    public void onBlurRendered(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.sharpTransformGlProgram.use();
        this.sharpTransformGlProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
        this.sharpTransformGlProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        this.sharpTransformGlProgram.setFloatsUniform("uTransformationMatrix", this.sharpTransformMatrixValues);
        this.sharpTransformGlProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        this.sharpTransformGlProgram.bindAttributesAndUniforms();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolutionShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.sharpTransformGlProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
