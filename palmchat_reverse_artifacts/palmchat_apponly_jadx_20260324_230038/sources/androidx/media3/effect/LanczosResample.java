package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.ConvolutionFunction1D;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class LanczosResample implements GlEffect {
    private static final float DEFAULT_RADIUS = 3.0f;
    private static final float NO_OP_THRESHOLD = 0.01f;
    private final boolean assumeLandscapeOrientation;
    private final int longSide;
    private final float radius;
    private final int shortSide;

    /* JADX INFO: compiled from: SearchBox */
    public static class LanczosResampleScaledFunctionProvider implements ConvolutionFunction1D.Provider {
        private static final float SCALE_UNSET = -3.4028235E38f;
        private final boolean assumeLandscapeOrientation;
        private final int longSide;
        private final float radius;
        private float scale;
        private final int shortSide;

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size configure(Size size) {
            Size targetSize = LanczosResample.getTargetSize(size.getWidth(), size.getHeight(), this.longSide, this.shortSide, this.assumeLandscapeOrientation);
            this.scale = LanczosResample.scalingFactorToFit(size.getWidth(), size.getHeight(), targetSize.getWidth(), targetSize.getHeight());
            return new Size(Math.round(size.getWidth() * this.scale), Math.round(size.getHeight() * this.scale));
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D getConvolution(long j) {
            return new ScaledLanczosFunction(this.radius, Math.min(this.scale, 1.0f));
        }

        private LanczosResampleScaledFunctionProvider(@FloatRange(from = 0.0d, fromInclusive = false) float f, @IntRange(from = 1) int i, @IntRange(from = 1) int i2, boolean z) {
            Assertions.checkArgument(f > 0.0f);
            Assertions.checkArgument(i > 0);
            Assertions.checkArgument(i2 > 0);
            this.radius = f;
            this.longSide = i;
            this.shortSide = i2;
            this.assumeLandscapeOrientation = z;
            this.scale = -3.4028235E38f;
        }
    }

    private LanczosResample(float f, int i, int i2, boolean z) {
        this.radius = f;
        this.longSide = i;
        this.shortSide = i2;
        this.assumeLandscapeOrientation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Size getTargetSize(int i, int i2, int i3, int i4, boolean z) {
        return (z || i > i2) ? new Size(i3, i4) : new Size(i4, i3);
    }

    public static LanczosResample scaleToFit(@IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        Assertions.checkArgument(i > 0);
        Assertions.checkArgument(i2 > 0);
        return new LanczosResample(3.0f, i, i2, true);
    }

    public static LanczosResample scaleToFitWithFlexibleOrientation(@IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        Assertions.checkArgument(i > 0);
        Assertions.checkArgument(i2 > 0);
        return i > i2 ? new LanczosResample(3.0f, i, i2, false) : new LanczosResample(3.0f, i2, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float scalingFactorToFit(int i, int i2, int i3, int i4) {
        Assertions.checkArgument(i > 0);
        Assertions.checkArgument(i2 > 0);
        return i2 * i3 <= i4 * i ? i3 / i : i4 / i2;
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        Size targetSize = getTargetSize(i, i2, this.longSide, this.shortSide, this.assumeLandscapeOrientation);
        return Math.abs(scalingFactorToFit(i, i2, targetSize.getWidth(), targetSize.getHeight()) - 1.0f) < 0.01f;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SeparableConvolutionShaderProgram(context, z, new LanczosResampleScaledFunctionProvider(this.radius, this.longSide, this.shortSide, this.assumeLandscapeOrientation));
    }
}
