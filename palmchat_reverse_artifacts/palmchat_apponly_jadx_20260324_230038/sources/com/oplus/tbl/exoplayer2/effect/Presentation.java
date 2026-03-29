package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.graphics.Matrix;
import androidx.annotation.FloatRange;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.be3;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class Presentation implements MatrixTransformation {
    private static final float ASPECT_RATIO_UNSET = -1.0f;
    public static final int LAYOUT_SCALE_TO_FIT = 0;
    public static final int LAYOUT_SCALE_TO_FIT_WITH_CROP = 1;
    public static final int LAYOUT_STRETCH_TO_FIT = 2;
    private final int layout;
    private float outputHeight;
    private float outputWidth;
    private float requestedAspectRatio;
    private final int requestedHeightPixels;
    private final int requestedWidthPixels;
    private Matrix transformationMatrix;

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Layout {
    }

    private Presentation(int i, int i2, float f, int i3) {
        Assertions.checkArgument(f == -1.0f || i == -1, "width and aspect ratio should not both be set");
        this.requestedWidthPixels = i;
        this.requestedHeightPixels = i2;
        this.requestedAspectRatio = f;
        this.layout = i3;
        this.outputWidth = -1.0f;
        this.outputHeight = -1.0f;
        this.transformationMatrix = new Matrix();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r0 > r2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r0 > r2) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        r6.transformationMatrix.setScale(r2 / r0, 1.0f);
        r6.outputWidth = r6.outputHeight * r6.requestedAspectRatio;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
    
        r6.transformationMatrix.setScale(1.0f, r0 / r2);
        r0 = r6.outputWidth / r6.requestedAspectRatio;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyAspectRatio() {
        float f;
        float f2;
        float f3 = this.outputWidth;
        float f4 = this.outputHeight;
        float f5 = f3 / f4;
        int i = this.layout;
        if (i == 0) {
            f2 = this.requestedAspectRatio;
        } else if (i == 1) {
            f2 = this.requestedAspectRatio;
        } else {
            if (i != 2) {
                return;
            }
            float f6 = this.requestedAspectRatio;
            if (f6 > f5) {
                this.outputWidth = f4 * f6;
                return;
            }
            f = f3 / f6;
        }
        this.outputHeight = f;
    }

    private static void checkLayout(int i) {
        boolean z = true;
        if (i != 0 && i != 1 && i != 2) {
            z = false;
        }
        Assertions.checkArgument(z, "invalid layout " + i);
    }

    public static Presentation createForAspectRatio(@FloatRange(from = 0.0d, fromInclusive = false) float f, int i) {
        Assertions.checkArgument(f > 0.0f, "aspect ratio " + f + " must be positive");
        checkLayout(i);
        return new Presentation(-1, -1, f, i);
    }

    public static Presentation createForHeight(int i) {
        return new Presentation(-1, i, -1.0f, 0);
    }

    public static Presentation createForWidthAndHeight(int i, int i2, int i3) {
        Assertions.checkArgument(i > 0, "width " + i + " must be positive");
        Assertions.checkArgument(i2 > 0, "height " + i2 + " must be positive");
        checkLayout(i3);
        return new Presentation(i, i2, -1.0f, i3);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public Size configure(int i, int i2) {
        int i3;
        Assertions.checkArgument(i > 0, "inputWidth must be positive");
        Assertions.checkArgument(i2 > 0, "inputHeight must be positive");
        this.transformationMatrix = new Matrix();
        this.outputWidth = i;
        this.outputHeight = i2;
        int i4 = this.requestedWidthPixels;
        if (i4 != -1 && (i3 = this.requestedHeightPixels) != -1) {
            this.requestedAspectRatio = i4 / i3;
        }
        if (this.requestedAspectRatio != -1.0f) {
            applyAspectRatio();
        }
        int i5 = this.requestedHeightPixels;
        if (i5 != -1) {
            int i6 = this.requestedWidthPixels;
            this.outputWidth = i6 != -1 ? i6 : (i5 * this.outputWidth) / this.outputHeight;
            this.outputHeight = i5;
        }
        return new Size(Math.round(this.outputWidth), Math.round(this.outputHeight));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation, com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    public /* synthetic */ float[] getGlMatrixArray(long j) {
        return be3.a(this, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) Assertions.checkStateNotNull(this.transformationMatrix, "configure must be called first");
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        configure(i, i2);
        return ((Matrix) Assertions.checkStateNotNull(this.transformationMatrix)).isIdentity() && i == Math.round(this.outputWidth) && i2 == Math.round(this.outputHeight);
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
