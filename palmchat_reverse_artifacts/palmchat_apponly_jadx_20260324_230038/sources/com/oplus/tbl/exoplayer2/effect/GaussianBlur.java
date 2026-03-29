package com.oplus.tbl.exoplayer2.effect;

import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public final class GaussianBlur extends SeparableConvolution {
    private final float numStandardDeviations;
    private final float sigma;

    public GaussianBlur(float f) {
        this(f, 2.0f);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolution
    public ConvolutionFunction1D getConvolution(long j) {
        return new GaussianFunction(this.sigma, this.numStandardDeviations);
    }

    public GaussianBlur(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.sigma = f;
        this.numStandardDeviations = f2;
    }
}
