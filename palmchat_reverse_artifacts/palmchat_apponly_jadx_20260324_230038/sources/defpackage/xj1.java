package defpackage;

import androidx.annotation.NonNull;
import com.daasuu.ei.Ease;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xj1 {

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21975a;

        static {
            int[] iArr = new int[Ease.values().length];
            f21975a = iArr;
            try {
                iArr[Ease.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21975a[Ease.QUAD_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21975a[Ease.QUAD_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21975a[Ease.QUAD_IN_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21975a[Ease.CUBIC_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21975a[Ease.CUBIC_OUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21975a[Ease.CUBIC_IN_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21975a[Ease.QUART_IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21975a[Ease.QUART_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21975a[Ease.QUART_IN_OUT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21975a[Ease.QUINT_IN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21975a[Ease.QUINT_OUT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f21975a[Ease.QUINT_IN_OUT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f21975a[Ease.SINE_IN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f21975a[Ease.SINE_OUT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f21975a[Ease.SINE_IN_OUT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f21975a[Ease.BACK_IN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f21975a[Ease.BACK_OUT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f21975a[Ease.BACK_IN_OUT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f21975a[Ease.CIRC_IN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f21975a[Ease.CIRC_OUT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f21975a[Ease.CIRC_IN_OUT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f21975a[Ease.BOUNCE_IN.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f21975a[Ease.BOUNCE_OUT.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f21975a[Ease.BOUNCE_IN_OUT.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f21975a[Ease.ELASTIC_IN.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f21975a[Ease.ELASTIC_OUT.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f21975a[Ease.ELASTIC_IN_OUT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f21975a[Ease.EASE_IN_EXPO.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f21975a[Ease.EASE_OUT_EXPO.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f21975a[Ease.EASE_IN_OUT_EXPO.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    public static float a(@NonNull Ease ease, float f) {
        switch (a.f21975a[ease.ordinal()]) {
            case 2:
                return h(f, 2.0d);
            case 3:
                return j(f, 2.0d);
            case 4:
                return i(f, 2.0d);
            case 5:
                return h(f, 3.0d);
            case 6:
                return j(f, 3.0d);
            case 7:
                return i(f, 3.0d);
            case 8:
                return h(f, 4.0d);
            case 9:
                return j(f, 4.0d);
            case 10:
                return i(f, 4.0d);
            case 11:
                return h(f, 5.0d);
            case 12:
                return j(f, 5.0d);
            case 13:
                return i(f, 5.0d);
            case 14:
                return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
            case 15:
                return (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
            case 16:
                return (float) ((Math.cos(((double) f) * 3.141592653589793d) - 1.0d) * (-0.5d));
            case 17:
                return (float) (((double) (f * f)) * ((((double) f) * 2.7d) - 1.7d));
            case 18:
                float f2 = f - 1.0f;
                return (float) ((((double) (f2 * f2)) * ((((double) f2) * 2.7d) + 1.7d)) + 1.0d);
            case 19:
                return b(f, 1.7f);
            case 20:
                return (float) (-(Math.sqrt(1.0f - (f * f)) - 1.0d));
            case 21:
                float f3 = f - 1.0f;
                return (float) Math.sqrt(1.0f - (f3 * f3));
            case 22:
                float f4 = f * 2.0f;
                if (f4 < 1.0f) {
                    return (float) ((Math.sqrt(1.0f - (f4 * f4)) - 1.0d) * (-0.5d));
                }
                float f5 = f4 - 2.0f;
                return (float) ((Math.sqrt(1.0f - (f5 * f5)) + 1.0d) * 0.5d);
            case 23:
                return c(f);
            case 24:
                return d(f);
            case 25:
                return f < 0.5f ? c(f * 2.0f) * 0.5f : (d((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
            case 26:
                return e(f, 1.0d, 0.3d);
            case 27:
                return g(f, 1.0d, 0.3d);
            case 28:
                return f(f, 1.0d, 0.45d);
            case 29:
                return (float) Math.pow(2.0d, (f - 1.0f) * 10.0f);
            case 30:
                return ((float) (-Math.pow(2.0d, f * (-10.0f)))) + 1.0f;
            case 31:
                return f * 2.0f < 1.0f ? ((float) Math.pow(2.0d, (r0 - 1.0f) * 10.0f)) * 0.5f : ((float) ((-Math.pow(2.0d, (r0 - 1.0f) * (-10.0f))) + 2.0d)) * 0.5f;
            default:
                return f;
        }
    }

    public static float b(float f, float f2) {
        double d;
        float f3 = (float) (((double) f2) * 1.525d);
        float f4 = f * 2.0f;
        if (f4 < 1.0f) {
            d = f4 * f4 * (((1.0f + f3) * f4) - f3);
        } else {
            float f5 = f4 - 2.0f;
            d = (f5 * f5 * (((1.0f + f3) * f5) + f3)) + 2.0f;
        }
        return (float) (d * 0.5d);
    }

    public static float c(float f) {
        return 1.0f - d(1.0f - f);
    }

    public static float d(float f) {
        double d;
        double d2;
        double d3;
        double d4 = f;
        if (d4 < 0.36363636363636365d) {
            d3 = 7.5625d * d4 * d4;
        } else {
            if (d4 < 0.7272727272727273d) {
                double d5 = (float) (d4 - 0.5454545454545454d);
                d = 7.5625d * d5 * d5;
                d2 = 0.75d;
            } else if (d4 < 0.9090909090909091d) {
                double d6 = (float) (d4 - 0.8181818181818182d);
                d = 7.5625d * d6 * d6;
                d2 = 0.9375d;
            } else {
                double d7 = (float) (d4 - 0.9545454545454546d);
                d = 7.5625d * d7 * d7;
                d2 = 0.984375d;
            }
            d3 = d + d2;
        }
        return (float) d3;
    }

    public static float e(float f, double d, double d2) {
        if (f == 0.0f || f == 1.0f) {
            return f;
        }
        return (float) (-(d * Math.pow(2.0d, 10.0f * r9) * Math.sin(((((double) (f - 1.0f)) - ((d2 / 6.283185307179586d) * Math.asin(1.0d / d))) * 6.283185307179586d) / d2)));
    }

    public static float f(float f, double d, double d2) {
        double dPow;
        double dAsin = (d2 / 6.283185307179586d) * Math.asin(1.0d / d);
        float f2 = f * 2.0f;
        if (f2 < 1.0f) {
            dPow = d * Math.pow(2.0d, 10.0f * r10) * Math.sin(((((double) (f2 - 1.0f)) - dAsin) * 6.283185307179586d) / d2) * (-0.5d);
        } else {
            dPow = (d * Math.pow(2.0d, (-10.0f) * r10) * Math.sin(((((double) (f2 - 1.0f)) - dAsin) * 6.283185307179586d) / d2) * 0.5d) + 1.0d;
        }
        return (float) dPow;
    }

    public static float g(float f, double d, double d2) {
        if (f == 0.0f || f == 1.0f) {
            return f;
        }
        return (float) ((d * Math.pow(2.0d, (-10.0f) * f) * Math.sin(((((double) f) - ((d2 / 6.283185307179586d) * Math.asin(1.0d / d))) * 6.283185307179586d) / d2)) + 1.0d);
    }

    public static float h(float f, double d) {
        return (float) Math.pow(f, d);
    }

    public static float i(float f, double d) {
        float f2 = f * 2.0f;
        return f2 < 1.0f ? (float) (Math.pow(f2, d) * 0.5d) : (float) (1.0d - (Math.abs(Math.pow(2.0f - f2, d)) * 0.5d));
    }

    public static float j(float f, double d) {
        return (float) (1.0d - Math.pow(1.0f - f, d));
    }
}
