package com.oplus.tblplayer.processor;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.MatrixTransformation;
import com.oplus.tbl.exoplayer2.effect.r0;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tblplayer.utils.AssertUtil;
import defpackage.be3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class EdgeEffect implements MatrixTransformation {
    private static final float OFFSET_NDC = 1.0f;
    private final int outputHeight;
    private final Rect outputRect;
    private final int outputWidth;
    private Matrix transformationMatrix;

    private EdgeEffect(int i, int i2, Rect rect) {
        AssertUtil.checkArgument(rect.left >= 0 && rect.right <= i && rect.top >= 0 && rect.bottom <= i2, "Rect must be within the output dimensions");
        this.outputWidth = i;
        this.outputHeight = i2;
        this.outputRect = rect;
        this.transformationMatrix = new Matrix();
    }

    public static GlEffect createForPresentationRect(int i, int i2, Rect rect) {
        return new EdgeEffect(i, i2, rect);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    @NonNull
    public Size configure(int i, int i2) {
        boolean z = false;
        AssertUtil.checkArgument(i > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(i2 > 0, "inputHeight must be positive");
        if (Math.abs(i - this.outputRect.width()) <= 1 && Math.abs(i2 - this.outputRect.height()) <= 1) {
            z = true;
        }
        AssertUtil.checkArgument(z, "Input dimensions must be approximately the same as the Rect dimensions");
        Matrix matrix = new Matrix();
        this.transformationMatrix = matrix;
        Rect rect = this.outputRect;
        int i3 = this.outputWidth;
        float f = ((rect.left * 2.0f) / i3) - 1.0f;
        float f2 = ((rect.right * 2.0f) / i3) - 1.0f;
        int i4 = this.outputHeight;
        float f3 = (-((rect.top * 2.0f) / i4)) + 1.0f;
        float f4 = (-((rect.bottom * 2.0f) / i4)) + 1.0f;
        matrix.postScale((f2 - f) / 2.0f, (f3 - f4) / 2.0f);
        this.transformationMatrix.postTranslate((f + f2) / 2.0f, (f3 + f4) / 2.0f);
        return new Size(this.outputWidth, this.outputHeight);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public /* synthetic */ float[] getGlMatrixArray(long j) {
        return be3.a(this, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation
    @NonNull
    public Matrix getMatrix(long j) {
        return (Matrix) AssertUtil.checkStateNotNull(this.transformationMatrix, "configure must be called first");
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        configure(i, i2);
        return ((Matrix) AssertUtil.checkStateNotNull(this.transformationMatrix)).isIdentity() && i == this.outputWidth && i2 == this.outputHeight;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return r0.b(this, context, z);
    }

    public static GlEffect createForPresentationRect(@NonNull android.util.Size size, int i, Rect rect) {
        if (i == 90 || i == 270) {
            size = new android.util.Size(size.getHeight(), size.getWidth());
        }
        return createForPresentationRect(size, rect);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }

    public static GlEffect createForPresentationRect(@NonNull android.util.Size size, Rect rect) {
        return new EdgeEffect(size.getWidth(), size.getHeight(), rect);
    }
}
