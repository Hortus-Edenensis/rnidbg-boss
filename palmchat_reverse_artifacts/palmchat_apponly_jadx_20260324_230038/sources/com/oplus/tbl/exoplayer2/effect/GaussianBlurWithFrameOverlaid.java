package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public final class GaussianBlurWithFrameOverlaid extends SeparableConvolution {
    private final float numStandardDeviations;
    private final float scaleSharpX;
    private final float scaleSharpY;
    private final float sigma;

    public GaussianBlurWithFrameOverlaid(float f, float f2, float f3) {
        this(f, 2.0f, f2, f3);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolution
    public ConvolutionFunction1D getConvolution(long j) {
        return new GaussianFunction(this.sigma, this.numStandardDeviations);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolution, com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SharpSeparableConvolutionShaderProgram(context, z, this, this.scaleSharpX, this.scaleSharpY);
    }

    public GaussianBlurWithFrameOverlaid(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2, float f3, float f4) {
        this.sigma = f;
        this.numStandardDeviations = f2;
        this.scaleSharpX = f3;
        this.scaleSharpY = f4;
    }
}
