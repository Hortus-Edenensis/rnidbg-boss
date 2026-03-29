package com.oplus.tblplayer.processor;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.MatrixTransformation;
import com.oplus.tbl.exoplayer2.effect.r0;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.utils.AssertUtil;
import defpackage.be3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class CropEffect implements MatrixTransformation {
    private static final float OFFSET_NDC = 1.0f;
    private final float mBottom;
    private final float mLeft;
    private final float mRight;
    private final float mTop;
    private Matrix mTransformationMatrix;

    public CropEffect(float f, float f2, float f3, float f4) {
        AssertUtil.checkArgument(f2 > f, "right value " + f2 + " should be greater than left value " + f);
        AssertUtil.checkArgument(f4 > f3, "top value " + f4 + " should be greater than bottom value " + f3);
        this.mLeft = f;
        this.mRight = f2;
        this.mBottom = f3;
        this.mTop = f4;
        this.mTransformationMatrix = new Matrix();
    }

    @RequiresApi(api = 21)
    public static CropEffect createCropEffect(@NonNull Size size, @NonNull Size size2) {
        AssertUtil.checkArgument(size.getWidth() > 0 && size.getHeight() > 0, "Input size must be positive.");
        AssertUtil.checkArgument(size2.getWidth() > 0 && size2.getHeight() > 0, "Output size must be positive.");
        AssertUtil.checkArgument(size.getWidth() >= size2.getWidth() && size.getHeight() >= size2.getHeight(), "Output size must be smaller than input size.");
        float width = size.getWidth();
        float f = width / 2.0f;
        float height = size.getHeight();
        float f2 = height / 2.0f;
        float width2 = size2.getWidth() / 2.0f;
        float height2 = size2.getHeight() / 2.0f;
        return new CropEffect((((f - width2) / width) * 2.0f) - 1.0f, (((f + width2) / width) * 2.0f) - 1.0f, 1.0f - (((f2 + height2) / height) * 2.0f), 1.0f - (((f2 - height2) / height) * 2.0f));
    }

    @RequiresApi(api = 21)
    public static CropEffect createCropEffectFromRect(@NonNull Size size, int i, @NonNull Rect rect) {
        if (i == 90 || i == 270) {
            size = new Size(size.getHeight(), size.getWidth());
        }
        return createCropEffectFromRectF(size, new RectF(rect));
    }

    @RequiresApi(api = 21)
    public static CropEffect createCropEffectFromRectF(@NonNull Size size, @NonNull RectF rectF) {
        AssertUtil.checkArgument(size.getWidth() > 0 && size.getHeight() > 0, "Input size must be positive.");
        AssertUtil.checkArgument(rectF.left >= 0.0f && rectF.right <= ((float) size.getWidth()), "Crop rect horizontal coordinates must be within image width.");
        AssertUtil.checkArgument(rectF.top >= 0.0f && rectF.bottom <= ((float) size.getHeight()), "Crop rect vertical coordinates must be within image height.");
        AssertUtil.checkArgument(rectF.right > rectF.left, "Crop rect right coordinate must be greater than left coordinate.");
        AssertUtil.checkArgument(rectF.bottom > rectF.top, "Crop rect bottom coordinate must be greater than bottom top.");
        float width = size.getWidth();
        float height = size.getHeight();
        return new CropEffect(((rectF.left / width) * 2.0f) - 1.0f, ((rectF.right / width) * 2.0f) - 1.0f, 1.0f - ((rectF.bottom / height) * 2.0f), 1.0f - ((rectF.top / height) * 2.0f));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public com.oplus.tbl.exoplayer2.util.Size configure(int i, int i2) {
        AssertUtil.checkArgument(i > 0, "inputWidth must be positive");
        AssertUtil.checkArgument(i2 > 0, "inputHeight must be positive");
        Matrix matrix = new Matrix();
        this.mTransformationMatrix = matrix;
        float f = this.mLeft;
        if (f == -1.0f && this.mRight == 1.0f && this.mBottom == -1.0f && this.mTop == 1.0f) {
            return new com.oplus.tbl.exoplayer2.util.Size(i, i2);
        }
        float f2 = this.mRight;
        float f3 = (f2 - f) / 2.0f;
        float f4 = this.mTop;
        float f5 = this.mBottom;
        float f6 = (f4 - f5) / 2.0f;
        matrix.postTranslate(-((f + f2) / 2.0f), -((f5 + f4) / 2.0f));
        this.mTransformationMatrix.postScale(1.0f / f3, 1.0f / f6);
        return new com.oplus.tbl.exoplayer2.util.Size(Math.round(i * f3), Math.round(i2 * f6));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public /* synthetic */ float[] getGlMatrixArray(long j) {
        return be3.a(this, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) AssertUtil.checkStateNotNull(this.mTransformationMatrix, "configure must be called first");
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        com.oplus.tbl.exoplayer2.util.Size sizeConfigure = configure(i, i2);
        return ((Matrix) AssertUtil.checkStateNotNull(this.mTransformationMatrix)).isIdentity() && i == sizeConfigure.getWidth() && i2 == sizeConfigure.getHeight();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return r0.b(this, context, z);
    }

    @RequiresApi(api = 21)
    public static CropEffect createCropEffectFromRect(@NonNull Size size, @NonNull Rect rect) {
        return createCropEffectFromRectF(size, new RectF(rect));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
