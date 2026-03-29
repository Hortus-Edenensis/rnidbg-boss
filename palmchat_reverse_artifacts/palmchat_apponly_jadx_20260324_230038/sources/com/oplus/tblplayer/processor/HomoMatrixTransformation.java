package com.oplus.tblplayer.processor;

import android.content.Context;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.processor.HomoMatrixTransformation;
import com.oplus.tblplayer.processor.util.MatrixUtils;
import com.oplus.tblplayer.utils.AssertUtil;
import defpackage.yb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class HomoMatrixTransformation implements GlEffect {
    private static final SamplerTextureMatrixProvider DEFAULT_TEXTURE_MATRIX_PROVIDER = new SamplerTextureMatrixProvider() { // from class: li2
        @Override // com.oplus.tblplayer.processor.HomoMatrixTransformation.SamplerTextureMatrixProvider
        public final Matrix getMatrix(long j) {
            return HomoMatrixTransformation.lambda$static$0(j);
        }
    };
    public final float edgeBlurAmount;
    private int inputHeight;
    private int inputWidth;
    public final boolean isEnableEdgeBlur;
    public final boolean isInverseMatrix;
    public final boolean isNormalizedCoordinates;
    public final boolean isYFlipMatrix;
    private final SamplerTextureMatrixProvider matrixProvider;
    public final int matrixRotationDegrees;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private boolean isNormalizedCoordinates = false;
        private int matrixRotationDegrees = 0;
        private boolean isYFlipMatrix = true;
        private boolean isInverseMatrix = false;
        private boolean isEnableEdgeBlur = true;
        private float mEdgeBlurAmount = 10.0f;
        private SamplerTextureMatrixProvider matrixProvider = HomoMatrixTransformation.DEFAULT_TEXTURE_MATRIX_PROVIDER;

        public HomoMatrixTransformation build() {
            return new HomoMatrixTransformation(this.isNormalizedCoordinates, this.matrixRotationDegrees, this.isYFlipMatrix, this.isInverseMatrix, this.isEnableEdgeBlur, this.mEdgeBlurAmount, this.matrixProvider);
        }

        public Builder setEdgeBlurAmount(float f) {
            if (f <= 150.0f && f >= 0.0f) {
                this.mEdgeBlurAmount = f;
            }
            return this;
        }

        public Builder setEnableEdgeBlur(boolean z) {
            this.isEnableEdgeBlur = z;
            return this;
        }

        public Builder setInverseMatrix(boolean z) {
            this.isInverseMatrix = z;
            return this;
        }

        public Builder setMatrixProvider(SamplerTextureMatrixProvider samplerTextureMatrixProvider) {
            this.matrixProvider = samplerTextureMatrixProvider;
            return this;
        }

        public Builder setMatrixRotationDegrees(int i) {
            this.matrixRotationDegrees = i;
            return this;
        }

        public Builder setNormalizedCoordinates(boolean z) {
            this.isNormalizedCoordinates = z;
            return this;
        }

        public Builder setYFlipMatrix(boolean z) {
            this.isYFlipMatrix = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SamplerTextureMatrixProvider {
        Matrix getMatrix(long j);
    }

    private HomoMatrixTransformation(boolean z, int i, boolean z2, boolean z3, boolean z4, float f, @NonNull SamplerTextureMatrixProvider samplerTextureMatrixProvider) {
        this.isNormalizedCoordinates = z;
        this.matrixRotationDegrees = i;
        this.isYFlipMatrix = z2;
        this.isInverseMatrix = z3;
        this.isEnableEdgeBlur = z4;
        this.edgeBlurAmount = f;
        this.matrixProvider = samplerTextureMatrixProvider;
    }

    @NonNull
    private Matrix getPreprocessedMatrix() {
        AssertUtil.checkArgument(this.inputWidth > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(this.inputHeight > 0, "inputHeight must be positive");
        float f = this.inputWidth / this.inputHeight;
        Matrix matrix = new Matrix();
        int i = this.matrixRotationDegrees;
        if (i != 0) {
            matrix.postRotate(i);
            int i2 = this.matrixRotationDegrees;
            if (i2 == 90) {
                matrix.postTranslate(1.0f, 0.0f);
            } else if (i2 == 180) {
                matrix.postTranslate(1.0f, 1.0f);
            } else if (i2 == 270) {
                matrix.postTranslate(0.0f, 1.0f);
            }
        }
        if (this.isYFlipMatrix) {
            matrix.postScale(1.0f, -1.0f);
            matrix.postTranslate(0.0f, 1.0f);
        }
        if (!this.isNormalizedCoordinates) {
            int i3 = this.matrixRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                matrix.postScale(1.0f / f, f);
            }
            matrix.postScale(this.inputWidth, this.inputHeight);
        }
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Matrix lambda$static$0(long j) {
        return null;
    }

    public Size configure(int i, int i2) {
        AssertUtil.checkArgument(i > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(i2 > 0, "inputHeight must be positive");
        this.inputWidth = i;
        this.inputHeight = i2;
        return new Size(i, i2);
    }

    public float getEdgeBlurAmount() {
        return this.edgeBlurAmount;
    }

    public float[] getEdgeTexelSize() {
        AssertUtil.checkArgument(this.inputWidth > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(this.inputHeight > 0, "inputHeight must be positive");
        return this.isEnableEdgeBlur ? new float[]{1.0f / this.inputWidth, 1.0f / this.inputHeight} : new float[]{0.0f, 0.0f};
    }

    public float[] getGlMatrixArray(long j) {
        Matrix matrix = getMatrix(j);
        if (matrix == null || matrix.isIdentity()) {
            return GlUtil.create4x4IdentityMatrix();
        }
        if (this.isInverseMatrix) {
            matrix = MatrixUtils.inverseMatrix(matrix);
        }
        Matrix matrix2 = new Matrix(matrix);
        Matrix preprocessedMatrix = getPreprocessedMatrix();
        Matrix matrix3 = new Matrix();
        preprocessedMatrix.invert(matrix3);
        matrix2.preConcat(preprocessedMatrix);
        matrix2.postConcat(matrix3);
        return com.oplus.tbl.exoplayer2.effect.MatrixUtils.getGlMatrixArray(matrix2);
    }

    public Matrix getMatrix(long j) {
        return this.matrixProvider.getMatrix(j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public BaseGlShaderProgram toGlShaderProgram(@NonNull Context context, boolean z) throws VideoFrameProcessingException {
        return new TextureMatrixShaderProgram(context, z, this);
    }
}
