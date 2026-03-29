package com.oplus.tbl.exoplayer2.effect;

import android.opengl.GLES20;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.o46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class OverlayShaderProgram extends BaseGlShaderProgram {
    private final GlProgram glProgram;
    private final ImmutableList<TextureOverlay> overlays;
    private final SamplerOverlayMatrixProvider samplerOverlayMatrixProvider;

    public OverlayShaderProgram(boolean z, ImmutableList<TextureOverlay> immutableList) throws VideoFrameProcessingException {
        super(z, 1);
        Assertions.checkArgument(!z, "OverlayShaderProgram does not support HDR colors yet.");
        Assertions.checkArgument(immutableList.size() <= 15, "OverlayShaderProgram does not support more than 15 overlays in the same instance.");
        this.overlays = immutableList;
        this.samplerOverlayMatrixProvider = new SamplerOverlayMatrixProvider();
        try {
            GlProgram glProgram = new GlProgram(createVertexShader(immutableList.size()), createFragmentShader(immutableList.size()));
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private static String createFragmentShader(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("#version 100\n");
        sb.append("precision mediump float;\n");
        sb.append("uniform sampler2D uVideoTexSampler0;\n");
        sb.append("varying vec2 vVideoTexSamplingCoord0;\n");
        sb.append("// Manually implementing the CLAMP_TO_BORDER texture wrapping option\n");
        sb.append("// (https://open.gl/textures) since it's not implemented until OpenGL ES 3.2.\n");
        sb.append("vec4 getClampToBorderOverlayColor(\n");
        sb.append("    sampler2D texSampler, vec2 texSamplingCoord, float alphaScale){\n");
        sb.append("  if (texSamplingCoord.x > 1.0 || texSamplingCoord.x < 0.0\n");
        sb.append("      || texSamplingCoord.y > 1.0 || texSamplingCoord.y < 0.0) {\n");
        sb.append("    return vec4(0.0, 0.0, 0.0, 0.0);\n");
        sb.append("  } else {\n");
        sb.append("    vec4 overlayColor = vec4(texture2D(texSampler, texSamplingCoord));\n");
        sb.append("    overlayColor.a = alphaScale * overlayColor.a;\n");
        sb.append("    return overlayColor;\n");
        sb.append("  }\n");
        sb.append("}\n");
        sb.append("\n");
        sb.append("vec4 getMixColor(vec4 videoColor, vec4 overlayColor) {\n");
        sb.append("  vec4 outputColor;\n");
        sb.append("  outputColor.rgb = overlayColor.rgb * overlayColor.a\n");
        sb.append("      + videoColor.rgb * (1.0 - overlayColor.a);\n");
        sb.append("  outputColor.a = overlayColor.a + videoColor.a * (1.0 - overlayColor.a);\n");
        sb.append("  return outputColor;\n");
        sb.append("}\n");
        sb.append("\n");
        sb.append("float srgbEotfSingleChannel(float srgb) {\n");
        sb.append("  return srgb <= 0.04045 ? srgb / 12.92 : pow((srgb + 0.055) / 1.055, 2.4);\n");
        sb.append("}\n");
        sb.append("// sRGB EOTF.\n");
        sb.append("vec3 applyEotf(const vec3 srgb) {\n");
        sb.append("// Reference implementation:\n");
        sb.append("// https://cs.android.com/android/platform/superproject/+/master:frameworks/native/libs/renderengine/gl/ProgramCache.cpp;drc=de09f10aa504fd8066370591a00c9ff1cafbb7fa;l=235\n");
        sb.append("  return vec3(\n");
        sb.append("    srgbEotfSingleChannel(srgb.r),\n");
        sb.append("    srgbEotfSingleChannel(srgb.g),\n");
        sb.append("    srgbEotfSingleChannel(srgb.b)\n");
        sb.append("  );\n");
        sb.append("}\n");
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(Util.formatInvariant("uniform sampler2D uOverlayTexSampler%d;\n", Integer.valueOf(i2)));
            sb.append(Util.formatInvariant("uniform float uOverlayAlphaScale%d;\n", Integer.valueOf(i2)));
            sb.append(Util.formatInvariant("varying vec2 vOverlayTexSamplingCoord%d;\n", Integer.valueOf(i2)));
        }
        sb.append("void main() {\n");
        sb.append("  vec4 videoColor = vec4(texture2D(uVideoTexSampler0, vVideoTexSamplingCoord0));\n");
        sb.append("  vec4 fragColor = videoColor;\n");
        for (int i3 = 1; i3 <= i; i3++) {
            sb.append(Util.formatInvariant("  vec4 electricalOverlayColor%d = getClampToBorderOverlayColor(\n", Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("    uOverlayTexSampler%d, vOverlayTexSamplingCoord%d, uOverlayAlphaScale%d);\n", Integer.valueOf(i3), Integer.valueOf(i3), Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("  vec4 opticalOverlayColor%d = vec4(\n", Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("    applyEotf(electricalOverlayColor%d.rgb), electricalOverlayColor%d.a);\n", Integer.valueOf(i3), Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("  fragColor = getMixColor(fragColor, opticalOverlayColor%d);\n", Integer.valueOf(i3)));
        }
        sb.append("  gl_FragColor = fragColor;\n");
        sb.append("}\n");
        return sb.toString();
    }

    private static String createVertexShader(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("#version 100\n");
        sb.append("attribute vec4 aFramePosition;\n");
        sb.append("varying vec2 vVideoTexSamplingCoord0;\n");
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(Util.formatInvariant("uniform mat4 uTransformationMatrix%s;\n", Integer.valueOf(i2)));
            sb.append(Util.formatInvariant("uniform mat4 uVertexTransformationMatrix%s;\n", Integer.valueOf(i2)));
            sb.append(Util.formatInvariant("varying vec2 vOverlayTexSamplingCoord%s;\n", Integer.valueOf(i2)));
        }
        sb.append("vec2 getTexSamplingCoord(vec2 ndcPosition){\n");
        sb.append("  return vec2(ndcPosition.x * 0.5 + 0.5, ndcPosition.y * 0.5 + 0.5);\n");
        sb.append("}\n");
        sb.append("void main() {\n");
        sb.append("  gl_Position = aFramePosition;\n");
        sb.append("  vVideoTexSamplingCoord0 = getTexSamplingCoord(aFramePosition.xy);\n");
        for (int i3 = 1; i3 <= i; i3++) {
            sb.append(Util.formatInvariant("  vec4 aOverlayPosition%d = \n", Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("  uVertexTransformationMatrix%s * uTransformationMatrix%s * aFramePosition;\n", Integer.valueOf(i3), Integer.valueOf(i3)));
            sb.append(Util.formatInvariant("  vOverlayTexSamplingCoord%d = getTexSamplingCoord(aOverlayPosition%d.xy);\n", Integer.valueOf(i3), Integer.valueOf(i3)));
        }
        sb.append("}\n");
        return sb.toString();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        Size size = new Size(i, i2);
        this.samplerOverlayMatrixProvider.configure(size);
        o46<TextureOverlay> it = this.overlays.iterator();
        while (it.hasNext()) {
            it.next().configure(size);
        }
        return size;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.glProgram.use();
            for (int i2 = 1; i2 <= this.overlays.size(); i2++) {
                TextureOverlay textureOverlay = this.overlays.get(i2 - 1);
                this.glProgram.setSamplerTexIdUniform(Util.formatInvariant("uOverlayTexSampler%d", Integer.valueOf(i2)), textureOverlay.getTextureId(j), i2);
                this.glProgram.setFloatsUniform(Util.formatInvariant("uVertexTransformationMatrix%d", Integer.valueOf(i2)), textureOverlay.getVertexTransformation(j));
                OverlaySettings overlaySettings = textureOverlay.getOverlaySettings(j);
                this.glProgram.setFloatsUniform(Util.formatInvariant("uTransformationMatrix%d", Integer.valueOf(i2)), this.samplerOverlayMatrixProvider.getTransformationMatrix(textureOverlay.getTextureSize(j), overlaySettings));
                this.glProgram.setFloatUniform(Util.formatInvariant("uOverlayAlphaScale%d", Integer.valueOf(i2)), overlaySettings.alphaScale);
            }
            this.glProgram.setSamplerTexIdUniform("uVideoTexSampler0", i, 0);
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, j);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.glProgram.delete();
            for (int i = 0; i < this.overlays.size(); i++) {
                this.overlays.get(i).release();
            }
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
