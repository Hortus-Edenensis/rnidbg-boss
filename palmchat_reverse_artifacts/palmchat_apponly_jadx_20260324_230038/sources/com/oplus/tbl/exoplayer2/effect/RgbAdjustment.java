package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.Matrix;
import androidx.annotation.FloatRange;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class RgbAdjustment implements RgbMatrix {
    private final float[] rgbMatrix;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private float redScale = 1.0f;
        private float greenScale = 1.0f;
        private float blueScale = 1.0f;

        public RgbAdjustment build() {
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            Matrix.scaleM(fArrCreate4x4IdentityMatrix, 0, this.redScale, this.greenScale, this.blueScale);
            return new RgbAdjustment(fArrCreate4x4IdentityMatrix);
        }

        public Builder setBlueScale(@FloatRange(from = 0.0d) float f) {
            Assertions.checkArgument(0.0f <= f, "Blue scale needs to be non-negative.");
            this.blueScale = f;
            return this;
        }

        public Builder setGreenScale(@FloatRange(from = 0.0d) float f) {
            Assertions.checkArgument(0.0f <= f, "Green scale needs to be non-negative.");
            this.greenScale = f;
            return this;
        }

        public Builder setRedScale(@FloatRange(from = 0.0d) float f) {
            Assertions.checkArgument(0.0f <= f, "Red scale needs to be non-negative.");
            this.redScale = f;
            return this;
        }
    }

    private RgbAdjustment(float[] fArr) {
        this.rgbMatrix = fArr;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.RgbMatrix
    public float[] getMatrix(long j, boolean z) {
        return this.rgbMatrix;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return Arrays.equals(this.rgbMatrix, GlUtil.create4x4IdentityMatrix());
    }

    @Override // com.oplus.tbl.exoplayer2.effect.RgbMatrix, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return u0.a(this, context, z);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.RgbMatrix, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
