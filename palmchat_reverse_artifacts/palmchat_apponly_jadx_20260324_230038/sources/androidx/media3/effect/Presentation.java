package androidx.media3.effect;

import android.content.Context;
import android.graphics.Matrix;
import androidx.annotation.FloatRange;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Presentation implements MatrixTransformation {
    private static final float ASPECT_RATIO_UNSET = -1.0f;
    public static final int LAYOUT_SCALE_TO_FIT = 0;
    public static final int LAYOUT_SCALE_TO_FIT_WITH_CROP = 1;
    public static final int LAYOUT_STRETCH_TO_FIT = 2;
    private final int layout;
    private float outputHeight;
    private float outputWidth;
    private final boolean preservePortraitWhenApplicable;
    private float requestedAspectRatio;
    private final int requestedHeightPixels;
    private final int requestedWidthPixels;
    private final int textureMinFilter;
    private Matrix transformationMatrix;

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Layout {
    }

    private Presentation(int i, int i2, float f, int i3, int i4, boolean z) {
        Assertions.checkArgument(f == -1.0f || i == -1, "width and aspect ratio should not both be set");
        this.requestedWidthPixels = i;
        this.requestedHeightPixels = i2;
        this.requestedAspectRatio = f;
        this.layout = i3;
        this.textureMinFilter = i4;
        this.preservePortraitWhenApplicable = z;
        this.outputWidth = -1.0f;
        this.outputHeight = -1.0f;
        this.transformationMatrix = new Matrix();
    }

    private void applyAspectRatio() {
        float f = this.outputWidth;
        float f2 = this.outputHeight;
        float f3 = f / f2;
        int i = this.layout;
        if (i == 0) {
            float f4 = this.requestedAspectRatio;
            if (f4 > f3) {
                this.transformationMatrix.setScale(f3 / f4, 1.0f);
                this.outputWidth = this.outputHeight * this.requestedAspectRatio;
                return;
            } else {
                this.transformationMatrix.setScale(1.0f, f4 / f3);
                this.outputHeight = this.outputWidth / this.requestedAspectRatio;
                return;
            }
        }
        if (i == 1) {
            float f5 = this.requestedAspectRatio;
            if (f5 > f3) {
                this.transformationMatrix.setScale(1.0f, f5 / f3);
                this.outputHeight = this.outputWidth / this.requestedAspectRatio;
                return;
            } else {
                this.transformationMatrix.setScale(f3 / f5, 1.0f);
                this.outputWidth = this.outputHeight * this.requestedAspectRatio;
                return;
            }
        }
        if (i == 2) {
            float f6 = this.requestedAspectRatio;
            if (f6 > f3) {
                this.outputWidth = f2 * f6;
            } else {
                this.outputHeight = f / f6;
            }
        }
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
        return new Presentation(-1, -1, f, i, C.TEXTURE_MIN_FILTER_LINEAR, false);
    }

    public static Presentation createForHeight(int i) {
        return new Presentation(-1, i, -1.0f, 0, C.TEXTURE_MIN_FILTER_LINEAR, false);
    }

    public static Presentation createForShortSide(int i) {
        Assertions.checkArgument(i > 0, "shortSide " + i + " must be positive");
        return new Presentation(-1, i, -1.0f, 0, C.TEXTURE_MIN_FILTER_LINEAR, true);
    }

    public static Presentation createForWidthAndHeight(int i, int i2, int i3) {
        Assertions.checkArgument(i > 0, "width " + i + " must be positive");
        Assertions.checkArgument(i2 > 0, "height " + i2 + " must be positive");
        checkLayout(i3);
        return new Presentation(i, i2, -1.0f, i3, C.TEXTURE_MIN_FILTER_LINEAR, false);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
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
            if (i6 != -1) {
                this.outputWidth = i6;
                this.outputHeight = i5;
            } else if (!this.preservePortraitWhenApplicable || i2 <= i) {
                this.outputWidth = (i5 * this.outputWidth) / this.outputHeight;
                this.outputHeight = i5;
            } else {
                this.outputHeight = (i5 * this.outputHeight) / this.outputWidth;
                this.outputWidth = i5;
            }
        }
        return new Size(Math.round(this.outputWidth), Math.round(this.outputHeight));
    }

    public Presentation copyWithTextureMinFilter(int i) {
        Assertions.checkArgument(i == 9729 || i == 9987);
        return new Presentation(this.requestedWidthPixels, this.requestedHeightPixels, this.requestedAspectRatio, this.layout, i, this.preservePortraitWhenApplicable);
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
    public int getGlTextureMinFilter() {
        return this.textureMinFilter;
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) Assertions.checkStateNotNull(this.transformationMatrix, "configure must be called first");
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        configure(i, i2);
        return ((Matrix) Assertions.checkStateNotNull(this.transformationMatrix)).isIdentity() && i == Math.round(this.outputWidth) && i2 == Math.round(this.outputHeight);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return y0.c(this, context, z);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
