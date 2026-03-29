package androidx.media3.effect;

import androidx.annotation.Nullable;
import defpackage.zp0;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ScaledLanczosFunction implements ConvolutionFunction1D {
    private final float radius;
    private final float scale;

    public ScaledLanczosFunction(float f, float f2) {
        this.radius = f;
        this.scale = f2;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainEnd() {
        return this.radius / this.scale;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainStart() {
        return (-this.radius) / this.scale;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledLanczosFunction)) {
            return false;
        }
        ScaledLanczosFunction scaledLanczosFunction = (ScaledLanczosFunction) obj;
        return Float.compare(scaledLanczosFunction.radius, this.radius) == 0 && Float.compare(scaledLanczosFunction.scale, this.scale) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.radius), Float.valueOf(this.scale));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float value(float f) {
        float f2 = f * this.scale;
        if (Math.abs(f2) < 1.0E-5d) {
            return 1.0f;
        }
        float fAbs = Math.abs(f2);
        float f3 = this.radius;
        if (fAbs > f3) {
            return 0.0f;
        }
        double d = f2;
        double d2 = 3.141592653589793d * d;
        return (float) (((((double) f3) * Math.sin(d2)) * Math.sin(d2 / ((double) this.radius))) / ((9.869604401089358d * d) * d));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public /* synthetic */ float width() {
        return zp0.a(this);
    }
}
