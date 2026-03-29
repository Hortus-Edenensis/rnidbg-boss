package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.CallSuper;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class FrameCacheGlShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_TRANSFORMATION_ES2_PATH = "shaders/fragment_shader_transformation_es2.glsl";
    private static final String VERTEX_SHADER_TRANSFORMATION_ES2_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final GlProgram copyProgram;

    @OptIn(markerClass = {UnstableApi.class})
    public FrameCacheGlShaderProgram(Context context, int i, boolean z) throws VideoFrameProcessingException {
        super(z, i);
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_TRANSFORMATION_ES2_PATH, FRAGMENT_SHADER_TRANSFORMATION_ES2_PATH);
            this.copyProgram = glProgram;
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uRgbMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        } catch (GlUtil.GlException | IOException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.copyProgram.use();
            this.copyProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.copyProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @CallSuper
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.copyProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
