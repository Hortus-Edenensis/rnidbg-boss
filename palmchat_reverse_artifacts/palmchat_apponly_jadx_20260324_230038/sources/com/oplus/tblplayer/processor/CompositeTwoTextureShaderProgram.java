package com.oplus.tblplayer.processor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.Size;
import java.io.IOException;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CompositeTwoTextureShaderProgram extends BaseGlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_composite_two_tex_alpha_scale_es2.glsl";
    private static final String TAG = "CompositeTwoTextureShaderProgram";
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_composite_two_tex_es2.glsl";
    private float alphaScale;
    private final GlProgram glProgram;

    public CompositeTwoTextureShaderProgram(Context context, boolean z, @FloatRange(from = 0.0d) float f) throws VideoFrameProcessingException {
        super(z, 1);
        Assertions.checkArgument(0.0f <= f, "Invalid input alpha-scale value: " + f);
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            this.alphaScale = f;
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void blendOntoOutputTexture(int i, float f) throws GlUtil.GlException {
        this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
        this.glProgram.setFloatUniform("uAlphaScale", f);
        this.glProgram.bindAttributesAndUniforms();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }

    private void changeOverlayTextureAlpha(@FloatRange(from = 0.0d) float f) {
        Assertions.checkArgument(0.0f <= f, "Invalid input alpha-scale value: " + f);
        this.alphaScale = f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    @NonNull
    public Size configure(int i, int i2) throws VideoFrameProcessingException {
        return new Size(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        throw new VideoFrameProcessingException(new UnsupportedOperationException());
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @SuppressLint({HttpHeaders.RANGE})
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            GlProgram glProgram = this.glProgram;
            if (glProgram != null) {
                glProgram.delete();
            }
        } catch (GlUtil.GlException e) {
            Log.e(TAG, "Error releasing GL Program", e);
        }
    }

    public void drawFrame(@NonNull InputFrameInfoPair inputFrameInfoPair, GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        InputFrameInfo inputFrameInfo = inputFrameInfoPair.videoInput;
        InputFrameInfo inputFrameInfo2 = inputFrameInfoPair.alphaOverlayInput;
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
        GlUtil.clearFocusedBuffers();
        ((GlProgram) Assertions.checkNotNull(this.glProgram)).use();
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GlUtil.checkGlError();
        blendOntoOutputTexture(inputFrameInfo.textureInfo.texId, 1.0f);
        blendOntoOutputTexture(inputFrameInfo2.textureInfo.texId, this.alphaScale);
        GLES20.glDisable(3042);
        GlUtil.checkGlError();
    }
}
