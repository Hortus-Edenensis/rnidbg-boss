package com.oplus.tblplayer.processor;

import android.content.Context;
import android.graphics.Matrix;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.MatrixTransformation;
import com.oplus.tbl.exoplayer2.effect.r0;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.utils.AssertUtil;
import defpackage.be3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class ScaleTransformation implements MatrixTransformation {
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

        public ScaleTransformation build() {
            return new ScaleTransformation(this.scaleX, this.scaleY, this.rotationDegrees);
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

    private ScaleTransformation(float f, float f2, float f3) {
        this.scaleX = f;
        this.scaleY = f2;
        this.rotationDegrees = f3;
        Matrix matrix = new Matrix();
        this.transformationMatrix = matrix;
        matrix.postScale(f, f2);
        matrix.postRotate(f3);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public Size configure(int i, int i2) {
        AssertUtil.checkArgument(i > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(i2 > 0, "inputHeight must be positive");
        this.adjustedTransformationMatrix = new Matrix(this.transformationMatrix);
        return new Size(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public /* synthetic */ float[] getGlMatrixArray(long j) {
        return be3.a(this, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) AssertUtil.checkStateNotNull(this.adjustedTransformationMatrix, "configure must be called first");
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        Size sizeConfigure = configure(i, i2);
        return ((Matrix) AssertUtil.checkStateNotNull(this.adjustedTransformationMatrix)).isIdentity() && i == sizeConfigure.getWidth() && i2 == sizeConfigure.getHeight();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return r0.b(this, context, z);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
