package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.CallSuper;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class FrameCacheGlShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_TRANSFORMATION_ES2_PATH = "shaders/fragment_shader_transformation_es2.glsl";
    private static final String VERTEX_SHADER_TRANSFORMATION_ES2_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final GlProgram copyProgram;

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

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
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

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
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
