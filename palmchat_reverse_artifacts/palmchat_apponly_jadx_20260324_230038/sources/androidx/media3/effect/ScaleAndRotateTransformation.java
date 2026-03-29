package androidx.media3.effect;

import android.content.Context;
import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ScaleAndRotateTransformation implements MatrixTransformation {
    private Matrix adjustedTransformationMatrix;
    public final float rotationDegrees;
    public final float scaleX;
    public final float scaleY;
    private final Matrix transformationMatrix;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private float scaleX = 1.0f;
        private float scaleY = 1.0f;
        private float rotationDegrees = 0.0f;

        public ScaleAndRotateTransformation build() {
            return new ScaleAndRotateTransformation(this.scaleX, this.scaleY, this.rotationDegrees);
        }

        public Builder setRotationDegrees(float f) {
            float f2 = f % 360.0f;
            this.rotationDegrees = f2;
            if (f2 < 0.0f) {
                this.rotationDegrees = f2 + 360.0f;
            }
            return this;
        }

        public Builder setScale(float f, float f2) {
            this.scaleX = f;
            this.scaleY = f2;
            return this;
        }
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public Size configure(int i, int i2) {
        Assertions.checkArgument(i > 0, "inputWidth must be positive");
        Assertions.checkArgument(i2 > 0, "inputHeight must be positive");
        this.adjustedTransformationMatrix = new Matrix(this.transformationMatrix);
        if (this.transformationMatrix.isIdentity()) {
            return new Size(i, i2);
        }
        float f = i;
        float f2 = i2;
        float f3 = f / f2;
        this.adjustedTransformationMatrix.preScale(f3, 1.0f);
        this.adjustedTransformationMatrix.postScale(1.0f / f3, 1.0f);
        float[][] fArr = {new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}};
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < 4; i3++) {
            float[] fArr2 = fArr[i3];
            this.adjustedTransformationMatrix.mapPoints(fArr2);
            fMin = Math.min(fMin, fArr2[0]);
            fMax = Math.max(fMax, fArr2[0]);
            fMin2 = Math.min(fMin2, fArr2[1]);
            fMax2 = Math.max(fMax2, fArr2[1]);
        }
        float f4 = (fMax - fMin) / 2.0f;
        float f5 = (fMax2 - fMin2) / 2.0f;
        this.adjustedTransformationMatrix.postScale(1.0f / f4, 1.0f / f5);
        return new Size(Math.round(f * f4), Math.round(f2 * f5));
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.MatrixTransformation, androidx.media3.effect.GlMatrixTransformation
    public /* synthetic */ float[] getGlMatrixArray(long j) {
        return z0.a(this, j);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public /* synthetic */ int getGlTextureMinFilter() {
        return y0.b(this);
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) Assertions.checkStateNotNull(this.adjustedTransformationMatrix, "configure must be called first");
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        Size sizeConfigure = configure(i, i2);
        return ((Matrix) Assertions.checkStateNotNull(this.adjustedTransformationMatrix)).isIdentity() && i == sizeConfigure.getWidth() && i2 == sizeConfigure.getHeight();
    }

    @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return y0.c(this, context, z);
    }

    private ScaleAndRotateTransformation(float f, float f2, float f3) {
        this.scaleX = f;
        this.scaleY = f2;
        this.rotationDegrees = f3;
        Matrix matrix = new Matrix();
        this.transformationMatrix = matrix;
        matrix.postScale(f, f2);
        matrix.postRotate(f3);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
