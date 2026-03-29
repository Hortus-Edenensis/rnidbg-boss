package androidx.media3.common.audio;

import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.IntRange;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ChannelMixingMatrix {
    private final float[] coefficients;
    private final int inputChannelCount;
    private final boolean isDiagonal;
    private final boolean isIdentity;
    private final boolean isZero;
    private final int outputChannelCount;

    public ChannelMixingMatrix(int i, int i2, float[] fArr) {
        Assertions.checkArgument(i > 0, "Input channel count must be positive.");
        Assertions.checkArgument(i2 > 0, "Output channel count must be positive.");
        Assertions.checkArgument(fArr.length == i * i2, "Coefficient array length is invalid.");
        this.inputChannelCount = i;
        this.outputChannelCount = i2;
        this.coefficients = checkCoefficientsValid(fArr);
        int i3 = 0;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        while (i3 < i) {
            int i4 = 0;
            while (i4 < i2) {
                float mixingCoefficient = getMixingCoefficient(i3, i4);
                boolean z4 = i3 == i4;
                if (mixingCoefficient != 1.0f && z4) {
                    z3 = false;
                }
                if (mixingCoefficient != 0.0f) {
                    z = false;
                    if (!z4) {
                        z2 = false;
                    }
                }
                i4++;
            }
            i3++;
        }
        this.isZero = z;
        boolean z5 = isSquare() && z2;
        this.isDiagonal = z5;
        this.isIdentity = z5 && z3;
    }

    private static float[] checkCoefficientsValid(float[] fArr) {
        for (int i = 0; i < fArr.length; i++) {
            if (fArr[i] < 0.0f) {
                throw new IllegalArgumentException("Coefficient at index " + i + " is negative.");
            }
        }
        return fArr;
    }

    @Deprecated
    public static ChannelMixingMatrix create(@IntRange(from = 1, to = 2) int i, @IntRange(from = 1, to = 2) int i2) {
        return createForConstantGain(i, i2);
    }

    private static float[] createConstantGainMixingCoefficients(int i, int i2) {
        if (i == i2) {
            return initializeIdentityMatrix(i2);
        }
        if (i == 1 && i2 == 2) {
            return new float[]{1.0f, 1.0f};
        }
        if (i == 2 && i2 == 1) {
            return new float[]{0.5f, 0.5f};
        }
        throw new UnsupportedOperationException("Default channel mixing coefficients for " + i + "->" + i2 + " are not yet implemented.");
    }

    private static float[] createConstantPowerMixingCoefficients(int i, int i2) {
        if (i2 == 1) {
            return getConstantPowerCoefficientsToMono(i);
        }
        if (i2 == 2) {
            return getConstantPowerCoefficientsToStereo(i);
        }
        if (i == i2) {
            return initializeIdentityMatrix(i2);
        }
        throw new UnsupportedOperationException("Default constant power channel mixing coefficients for " + i + "->" + i2 + " are not implemented.");
    }

    public static ChannelMixingMatrix createForConstantGain(@IntRange(from = 1, to = 2) int i, @IntRange(from = 1, to = 2) int i2) {
        return new ChannelMixingMatrix(i, i2, createConstantGainMixingCoefficients(i, i2));
    }

    public static ChannelMixingMatrix createForConstantPower(@IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_YEARS) int i, @IntRange(from = 1, to = 2) int i2) {
        return new ChannelMixingMatrix(i, i2, createConstantPowerMixingCoefficients(i, i2));
    }

    private static float[] getConstantPowerCoefficientsToMono(int i) {
        switch (i) {
            case 1:
                return new float[]{1.0f};
            case 2:
                return new float[]{0.7071f, 0.7071f};
            case 3:
                return new float[]{0.7071f, 0.7071f, 1.0f};
            case 4:
                return new float[]{0.7071f, 0.7071f, 0.5f, 0.5f};
            case 5:
                return new float[]{0.7071f, 0.7071f, 1.0f, 0.5f, 0.5f};
            case 6:
                return new float[]{0.7071f, 0.7071f, 1.0f, 0.7071f, 0.5f, 0.5f};
            default:
                throw new UnsupportedOperationException("Default constant power channel mixing coefficients for " + i + "->1 are not implemented.");
        }
    }

    private static float[] getConstantPowerCoefficientsToStereo(int i) {
        switch (i) {
            case 1:
                return new float[]{0.7071f, 0.7071f};
            case 2:
                return new float[]{1.0f, 0.0f, 0.0f, 1.0f};
            case 3:
                return new float[]{1.0f, 0.0f, 0.7071f, 0.0f, 1.0f, 0.7071f};
            case 4:
                return new float[]{1.0f, 0.0f, 0.7071f, 0.0f, 0.0f, 1.0f, 0.0f, 0.7071f};
            case 5:
                return new float[]{1.0f, 0.0f, 0.7071f, 0.7071f, 0.0f, 0.0f, 1.0f, 0.7071f, 0.0f, 0.7071f};
            case 6:
                return new float[]{1.0f, 0.0f, 0.7071f, 0.5f, 0.7071f, 0.0f, 0.0f, 1.0f, 0.7071f, 0.5f, 0.0f, 0.7071f};
            default:
                throw new UnsupportedOperationException("Default constant power channel mixing coefficients for " + i + "->2 are not implemented.");
        }
    }

    private static float[] initializeIdentityMatrix(int i) {
        float[] fArr = new float[i * i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[(i * i2) + i2] = 1.0f;
        }
        return fArr;
    }

    public int getInputChannelCount() {
        return this.inputChannelCount;
    }

    public float getMixingCoefficient(int i, int i2) {
        return this.coefficients[(i * this.outputChannelCount) + i2];
    }

    public int getOutputChannelCount() {
        return this.outputChannelCount;
    }

    public boolean isDiagonal() {
        return this.isDiagonal;
    }

    public boolean isIdentity() {
        return this.isIdentity;
    }

    public boolean isSquare() {
        return this.inputChannelCount == this.outputChannelCount;
    }

    public boolean isZero() {
        return this.isZero;
    }

    public ChannelMixingMatrix scaleBy(float f) {
        float[] fArr = new float[this.coefficients.length];
        int i = 0;
        while (true) {
            float[] fArr2 = this.coefficients;
            if (i >= fArr2.length) {
                return new ChannelMixingMatrix(this.inputChannelCount, this.outputChannelCount, fArr);
            }
            fArr[i] = fArr2[i] * f;
            i++;
        }
    }
}
