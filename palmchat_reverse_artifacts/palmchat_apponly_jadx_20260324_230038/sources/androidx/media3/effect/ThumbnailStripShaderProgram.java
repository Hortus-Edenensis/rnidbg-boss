package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ThumbnailStripShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_copy_es2.glsl";
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_thumbnail_strip_es2.glsl";
    private boolean clearedGlBuffer;
    private final GlProgram glProgram;
    private final ThumbnailStripEffect thumbnailStripEffect;

    public ThumbnailStripShaderProgram(Context context, boolean z, ThumbnailStripEffect thumbnailStripEffect) throws VideoFrameProcessingException {
        super(z, 1);
        this.thumbnailStripEffect = thumbnailStripEffect;
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        } catch (GlUtil.GlException | IOException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        ThumbnailStripEffect thumbnailStripEffect = this.thumbnailStripEffect;
        return new Size(thumbnailStripEffect.stripWidth, thumbnailStripEffect.stripHeight);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        if (!this.clearedGlBuffer) {
            try {
                GlUtil.clearFocusedBuffers();
                this.clearedGlBuffer = true;
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e, j);
            }
        }
        long jMsToUs = Util.msToUs(this.thumbnailStripEffect.getNextTimestampMs());
        if (this.thumbnailStripEffect.isDone() || j < jMsToUs) {
            return;
        }
        try {
            this.glProgram.use();
            this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.glProgram.setIntUniform("uIndex", this.thumbnailStripEffect.getNextThumbnailIndex());
            this.glProgram.setIntUniform("uCount", this.thumbnailStripEffect.getNumberOfThumbnails());
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
            this.thumbnailStripEffect.onThumbnailDrawn();
        } catch (GlUtil.GlException e2) {
            throw new VideoFrameProcessingException(e2, j);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public boolean shouldClearTextureBuffer() {
        return false;
    }
}
