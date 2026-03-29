package com.oplus.tblplayer.processor;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tblplayer.processor.GlProcessorEffect;
import defpackage.ac2;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultOotfGlProcessor implements GlProcessorEffect.Processor {
    private static final String FRAGMENT_SHADER_OOTF_ES3_PATH = "shaders/fragment_shader_transformation_ootf_es3.glsl";
    private static final String TAG = "DefaultOotfGlProcessor";
    private static final String VERTEX_SHADER_TRANSFORMATION_ES3_PATH = "shaders/vertex_shader_transformation_es3.glsl";
    private GlProgram glProgram;
    private int intermediateColorSpace = 10;
    private ColorInfo streamColorInfo;
    private boolean useHighPrecisionColorComponents;
    private ColorInfo workingColorInfo;

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public /* synthetic */ Size configureSize(int i, int i2) {
        return ac2.a(this, i, i2);
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public void configureWorkingColorInfo(ColorInfo colorInfo, ColorInfo colorInfo2) throws Exception {
        this.streamColorInfo = (ColorInfo) Assertions.checkNotNull(colorInfo);
        this.workingColorInfo = (ColorInfo) Assertions.checkNotNull(colorInfo2);
        Log.d(TAG, "configureWorkingColorInfo: " + colorInfo.toLogString());
        Log.d(TAG, "configureWorkingColorInfo: " + colorInfo2.toLogString());
        Assertions.checkArgument(colorInfo2.colorTransfer == 1);
        this.glProgram.setIntUniform("uInputColorSpace", colorInfo.colorSpace);
        this.glProgram.setIntUniform("uInputColorTransfer", colorInfo.colorTransfer);
        this.glProgram.setIntUniform("uIntermediateColorSpace", this.intermediateColorSpace);
        this.glProgram.setIntUniform("uOutputColorSpace", colorInfo2.colorSpace);
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public void init(Context context, boolean z) throws Exception {
        Assertions.checkArgument(z, "Only supports HDR texture processing");
        this.useHighPrecisionColorComponents = z;
        try {
            GlProgram glProgram = new GlProgram(context, VERTEX_SHADER_TRANSFORMATION_ES3_PATH, FRAGMENT_SHADER_OOTF_ES3_PATH);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            this.glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            this.glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public boolean isColorComponentsSupported(boolean z) {
        Log.d(TAG, "isColorComponentsSupported: " + z);
        return z;
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public void processTexture(GlProcessorEffect.GlFrameInfo glFrameInfo, GlProcessorEffect.GlFrameInfo glFrameInfo2, long j) throws Exception {
        try {
            this.glProgram.use();
            this.glProgram.setSamplerTexIdUniform("uTexSampler", glFrameInfo.getTextureId(), 0);
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, j);
        }
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public void release() throws Exception {
        try {
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tblplayer.processor.GlProcessorEffect.Processor
    public /* synthetic */ void processTexture(List list, GlProcessorEffect.GlFrameInfo glFrameInfo, long j) throws Exception {
        ac2.c(this, list, glFrameInfo, j);
    }
}
