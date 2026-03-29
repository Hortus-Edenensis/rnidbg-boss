package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class DefaultShaderProgram extends BaseGlShaderProgram implements ExternalShaderProgram {
    private static final String FRAGMENT_SHADER_OETF_ES3_PATH = "shaders/fragment_shader_oetf_es3.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_EXTERNAL_YUV_ES3_PATH = "shaders/fragment_shader_transformation_external_yuv_es3.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_HDR_INTERNAL_ES3_PATH = "shaders/fragment_shader_transformation_hdr_internal_es3.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_PATH = "shaders/fragment_shader_transformation_es2.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_SDR_EXTERNAL_PATH = "shaders/fragment_shader_transformation_sdr_external_es2.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_SDR_INTERNAL_PATH = "shaders/fragment_shader_transformation_sdr_internal_es2.glsl";
    private static final String FRAGMENT_SHADER_TRANSFORMATION_SDR_OETF_ES2_PATH = "shaders/fragment_shader_transformation_sdr_oetf_es2.glsl";
    private static final int GL_FALSE = 0;
    private static final int GL_TRUE = 1;
    private static final String TAG = "DefaultShaderProgram";
    private static final String VERTEX_SHADER_TRANSFORMATION_ES3_PATH = "shaders/vertex_shader_transformation_es3.glsl";
    private static final String VERTEX_SHADER_TRANSFORMATION_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final float[] compositeRgbMatrixArray;
    private final float[] compositeTransformationMatrixArray;
    private final GlProgram glProgram;
    private final ImmutableList<GlMatrixTransformation> matrixTransformations;
    private int outputColorTransfer;
    private final ImmutableList<RgbMatrix> rgbMatrices;
    private final float[][] rgbMatrixCache;
    private final float[] tempResultMatrix;
    private final float[][] transformationMatrixCache;
    private final boolean useHdr;
    private ImmutableList<float[]> visiblePolygon;
    private static final ImmutableList<float[]> NDC_SQUARE = ImmutableList.of(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});
    private static final float[] BT2020_FULL_RANGE_YUV_TO_RGB_COLOR_TRANSFORM_MATRIX = {1.0f, 1.0f, 1.0f, 0.0f, -0.1646f, 1.8814f, 1.4746f, -0.5714f, 0.0f};
    private static final float[] BT2020_LIMITED_RANGE_YUV_TO_RGB_COLOR_TRANSFORM_MATRIX = {1.1689f, 1.1689f, 1.1689f, 0.0f, -0.1881f, 2.1502f, 1.6853f, -0.653f, 0.0f};

    private DefaultShaderProgram(GlProgram glProgram, ImmutableList<GlMatrixTransformation> immutableList, ImmutableList<RgbMatrix> immutableList2, int i, boolean z) {
        super(z, 1);
        this.glProgram = glProgram;
        this.outputColorTransfer = i;
        this.matrixTransformations = immutableList;
        this.rgbMatrices = immutableList2;
        this.useHdr = z;
        int[] iArr = {immutableList.size(), 16};
        Class cls = Float.TYPE;
        this.transformationMatrixCache = (float[][]) Array.newInstance((Class<?>) cls, iArr);
        this.rgbMatrixCache = (float[][]) Array.newInstance((Class<?>) cls, immutableList2.size(), 16);
        this.compositeTransformationMatrixArray = GlUtil.create4x4IdentityMatrix();
        this.compositeRgbMatrixArray = GlUtil.create4x4IdentityMatrix();
        this.tempResultMatrix = new float[16];
        this.visiblePolygon = NDC_SQUARE;
    }

    public static DefaultShaderProgram create(Context context, List<GlMatrixTransformation> list, List<RgbMatrix> list2, boolean z) throws VideoFrameProcessingException {
        return new DefaultShaderProgram(createGlProgram(context, VERTEX_SHADER_TRANSFORMATION_PATH, FRAGMENT_SHADER_TRANSFORMATION_PATH), ImmutableList.copyOf((Collection) list), ImmutableList.copyOf((Collection) list2), 1, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DefaultShaderProgram createApplyingOetf(Context context, List<GlMatrixTransformation> list, List<RgbMatrix> list2, ColorInfo colorInfo, int i) throws VideoFrameProcessingException {
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
        boolean z = true;
        boolean z2 = i == 2;
        GlProgram glProgramCreateGlProgram = createGlProgram(context, zIsTransferHdr ? VERTEX_SHADER_TRANSFORMATION_ES3_PATH : VERTEX_SHADER_TRANSFORMATION_PATH, zIsTransferHdr ? FRAGMENT_SHADER_OETF_ES3_PATH : z2 ? FRAGMENT_SHADER_TRANSFORMATION_SDR_OETF_ES2_PATH : FRAGMENT_SHADER_TRANSFORMATION_PATH);
        int i2 = colorInfo.colorTransfer;
        if (zIsTransferHdr) {
            if (i2 != 7 && i2 != 6) {
                z = false;
            }
            Assertions.checkArgument(z);
            glProgramCreateGlProgram.setIntUniform("uOutputColorTransfer", i2);
        } else if (z2) {
            if (i2 != 3 && i2 != 10) {
            }
            Assertions.checkArgument(z);
            glProgramCreateGlProgram.setIntUniform("uOutputColorTransfer", i2);
        }
        return new DefaultShaderProgram(glProgramCreateGlProgram, ImmutableList.copyOf((Collection) list), ImmutableList.copyOf((Collection) list2), colorInfo.colorTransfer, zIsTransferHdr);
    }

    private static GlProgram createGlProgram(Context context, String str, String str2) throws VideoFrameProcessingException {
        try {
            GlProgram glProgram = new GlProgram(context, str, str2);
            glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
            return glProgram;
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    public static DefaultShaderProgram createWithExternalSampler(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, int i) throws VideoFrameProcessingException {
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
        GlProgram glProgramCreateGlProgram = createGlProgram(context, zIsTransferHdr ? VERTEX_SHADER_TRANSFORMATION_ES3_PATH : VERTEX_SHADER_TRANSFORMATION_PATH, zIsTransferHdr ? FRAGMENT_SHADER_TRANSFORMATION_EXTERNAL_YUV_ES3_PATH : FRAGMENT_SHADER_TRANSFORMATION_SDR_EXTERNAL_PATH);
        if (zIsTransferHdr) {
            if (!GlUtil.isYuvTargetExtensionSupported()) {
                throw new VideoFrameProcessingException("The EXT_YUV_target extension is required for HDR editing input.");
            }
            glProgramCreateGlProgram.setFloatsUniform("uYuvToRgbColorTransform", colorInfo.colorRange == 1 ? BT2020_FULL_RANGE_YUV_TO_RGB_COLOR_TRANSFORM_MATRIX : BT2020_LIMITED_RANGE_YUV_TO_RGB_COLOR_TRANSFORM_MATRIX);
            glProgramCreateGlProgram.setIntUniform("uInputColorTransfer", colorInfo.colorTransfer);
        }
        return createWithSampler(glProgramCreateGlProgram, colorInfo, colorInfo2, i);
    }

    public static DefaultShaderProgram createWithInternalSampler(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, int i, int i2) throws VideoFrameProcessingException {
        Assertions.checkState(colorInfo.colorTransfer != 2 || i2 == 2);
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
        GlProgram glProgramCreateGlProgram = createGlProgram(context, zIsTransferHdr ? VERTEX_SHADER_TRANSFORMATION_ES3_PATH : VERTEX_SHADER_TRANSFORMATION_PATH, zIsTransferHdr ? FRAGMENT_SHADER_TRANSFORMATION_HDR_INTERNAL_ES3_PATH : FRAGMENT_SHADER_TRANSFORMATION_SDR_INTERNAL_PATH);
        glProgramCreateGlProgram.setIntUniform("uInputColorTransfer", colorInfo.colorTransfer);
        return createWithSampler(glProgramCreateGlProgram, colorInfo, colorInfo2, i);
    }

    private static DefaultShaderProgram createWithSampler(GlProgram glProgram, ColorInfo colorInfo, ColorInfo colorInfo2, int i) {
        Log.d(TAG, "createWithSampler: inputColorInfo = " + colorInfo.toLogString());
        Log.d(TAG, "createWithSampler: outputColorInfo = " + colorInfo2.toLogString());
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
        int i2 = colorInfo2.colorTransfer;
        if (zIsTransferHdr) {
            glProgram.setIntUniform("uApplyHdrToSdrToneMapping", colorInfo2.colorSpace != 6 ? 1 : 0);
            Assertions.checkArgument(i2 != -1);
            if (i2 == 3) {
                i2 = 10;
            }
        } else {
            glProgram.setIntUniform("uSdrWorkingColorSpace", i);
            Assertions.checkArgument(i2 == 3 || i2 == 1);
        }
        glProgram.setIntUniform("uOutputColorTransfer", i2);
        return new DefaultShaderProgram(glProgram, ImmutableList.of(), ImmutableList.of(), colorInfo2.colorTransfer, zIsTransferHdr);
    }

    private void updateCompositeRgbMatrixArray(long j) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.rgbMatrices.size(), 16);
        for (int i = 0; i < this.rgbMatrices.size(); i++) {
            fArr[i] = this.rgbMatrices.get(i).getMatrix(j, this.useHdr);
        }
        if (updateMatrixCache(this.rgbMatrixCache, fArr)) {
            GlUtil.setToIdentity(this.compositeRgbMatrixArray);
            for (int i2 = 0; i2 < this.rgbMatrices.size(); i2++) {
                Matrix.multiplyMM(this.tempResultMatrix, 0, this.rgbMatrices.get(i2).getMatrix(j, this.useHdr), 0, this.compositeRgbMatrixArray, 0);
                float[] fArr2 = this.tempResultMatrix;
                System.arraycopy(fArr2, 0, this.compositeRgbMatrixArray, 0, fArr2.length);
            }
        }
    }

    private void updateCompositeTransformationMatrixAndVisiblePolygon(long j) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.matrixTransformations.size(), 16);
        for (int i = 0; i < this.matrixTransformations.size(); i++) {
            fArr[i] = this.matrixTransformations.get(i).getGlMatrixArray(j);
        }
        if (updateMatrixCache(this.transformationMatrixCache, fArr)) {
            GlUtil.setToIdentity(this.compositeTransformationMatrixArray);
            this.visiblePolygon = NDC_SQUARE;
            for (float[] fArr2 : this.transformationMatrixCache) {
                Matrix.multiplyMM(this.tempResultMatrix, 0, fArr2, 0, this.compositeTransformationMatrixArray, 0);
                float[] fArr3 = this.tempResultMatrix;
                System.arraycopy(fArr3, 0, this.compositeTransformationMatrixArray, 0, fArr3.length);
                ImmutableList<float[]> immutableListClipConvexPolygonToNdcRange = MatrixUtils.clipConvexPolygonToNdcRange(MatrixUtils.transformPoints(fArr2, this.visiblePolygon));
                this.visiblePolygon = immutableListClipConvexPolygonToNdcRange;
                if (immutableListClipConvexPolygonToNdcRange.size() < 3) {
                    return;
                }
            }
            Matrix.invertM(this.tempResultMatrix, 0, this.compositeTransformationMatrixArray, 0);
            this.visiblePolygon = MatrixUtils.transformPoints(this.tempResultMatrix, this.visiblePolygon);
        }
    }

    private static boolean updateMatrixCache(float[][] fArr, float[][] fArr2) {
        boolean z = false;
        for (int i = 0; i < fArr.length; i++) {
            float[] fArr3 = fArr[i];
            float[] fArr4 = fArr2[i];
            if (!Arrays.equals(fArr3, fArr4)) {
                Assertions.checkState(fArr4.length == 16, "A 4x4 transformation matrix must have 16 elements");
                System.arraycopy(fArr4, 0, fArr3, 0, fArr4.length);
                z = true;
            }
        }
        return z;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return MatrixUtils.configureAndGetOutputSize(i, i2, this.matrixTransformations);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        updateCompositeRgbMatrixArray(j);
        updateCompositeTransformationMatrixAndVisiblePolygon(j);
        if (this.visiblePolygon.size() < 3) {
            return;
        }
        try {
            this.glProgram.use();
            this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.glProgram.setFloatsUniform("uTransformationMatrix", this.compositeTransformationMatrixArray);
            this.glProgram.setFloatsUniform("uRgbMatrix", this.compositeRgbMatrixArray);
            this.glProgram.setBufferAttribute("aFramePosition", GlUtil.createVertexBuffer(this.visiblePolygon), 4);
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(6, 0, this.visiblePolygon.size());
            GlUtil.checkGlError();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, j);
        }
    }

    public int getOutputColorTransfer() {
        return this.outputColorTransfer;
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

    public void setOutputColorTransfer(int i) {
        Assertions.checkState(this.outputColorTransfer != 1);
        this.outputColorTransfer = i;
        this.glProgram.setIntUniform("uOutputColorTransfer", i);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.ExternalShaderProgram
    public void setTextureTransformMatrix(float[] fArr) {
        this.glProgram.setFloatsUniform("uTexTransformationMatrix", fArr);
    }
}
