package androidx.media3.effect;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import defpackage.zp0;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class GaussianFunction implements ConvolutionFunction1D {
    private final float numStdDev;
    private final float sigma;

    public GaussianFunction(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        Assertions.checkArgument(f > 0.0f && f2 > 0.0f);
        this.sigma = f;
        this.numStdDev = f2;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainEnd() {
        return this.numStdDev * this.sigma;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainStart() {
        return (-this.numStdDev) * this.sigma;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GaussianFunction)) {
            return false;
        }
        GaussianFunction gaussianFunction = (GaussianFunction) obj;
        return Float.compare(gaussianFunction.sigma, this.sigma) == 0 && Float.compare(gaussianFunction.numStdDev, this.numStdDev) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.sigma), Float.valueOf(this.numStdDev));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float value(float f) {
        float fAbs = Math.abs(f);
        float f2 = this.numStdDev;
        float f3 = this.sigma;
        if (fAbs > f2 * f3) {
            return 0.0f;
        }
        float f4 = f / f3;
        return (float) ((Math.exp(((-f4) * f4) / 2.0f) / Math.sqrt(6.283185307179586d)) / ((double) this.sigma));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public /* synthetic */ float width() {
        return zp0.a(this);
    }
}
