package com.huawei.hms.ads;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ek implements Interpolator {
    float B;
    float C;
    float S;
    float Z;

    public ek(float f, float f2, float f3, float f4) {
        this.Z = f;
        this.B = f2;
        this.C = f3;
        this.S = f4;
        fh.Code("CubicBezierInterpolator", toString());
    }

    private float I(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.Z) + (f3 * f * f * this.C) + (f * f * f);
    }

    public float Code(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.B) + (f3 * f * f * this.S) + (f * f * f);
    }

    public long V(float f) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fI = I(j3 * 2.5E-4f);
            if (fI < f) {
                j = j3 + 1;
            } else {
                if (fI <= f) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return Code(V(f) * 2.5E-4f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CubicBezierInterpolator");
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.Z);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.B);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.C);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.S);
        return stringBuffer.toString();
    }
}
