package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class GaussianBlurWithFrameOverlaid extends SeparableConvolution {
    private final float numStandardDeviations;
    private final float scaleSharpX;
    private final float scaleSharpY;
    private final float sigma;

    public GaussianBlurWithFrameOverlaid(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2, float f3, float f4) {
        this.sigma = f;
        this.numStandardDeviations = f2;
        this.scaleSharpX = f3;
        this.scaleSharpY = f4;
    }

    @Override // androidx.media3.effect.SeparableConvolution
    public ConvolutionFunction1D getConvolution(long j) {
        return new GaussianFunction(this.sigma, this.numStandardDeviations);
    }

    @Override // androidx.media3.effect.SeparableConvolution, androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SharpSeparableConvolutionShaderProgram(context, z, this, this.scaleSharpX, this.scaleSharpY);
    }

    public GaussianBlurWithFrameOverlaid(float f, float f2, float f3) {
        this(f, 2.0f, f2, f3);
    }
}
