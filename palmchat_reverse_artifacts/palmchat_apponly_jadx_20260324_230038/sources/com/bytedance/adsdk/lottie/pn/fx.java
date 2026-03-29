package com.bytedance.adsdk.lottie.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private static float nr(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float u(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int u(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fNr = nr(((i >> 16) & 255) / 255.0f);
        float fNr2 = nr(((i >> 8) & 255) / 255.0f);
        float fNr3 = nr((i & 255) / 255.0f);
        float fNr4 = nr(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fNr5 = fNr2 + ((nr(((i2 >> 8) & 255) / 255.0f) - fNr2) * f);
        float fNr6 = fNr3 + (f * (nr((i2 & 255) / 255.0f) - fNr3));
        return (Math.round(u(fNr + ((fNr4 - fNr) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(u(fNr5) * 255.0f) << 8) | Math.round(u(fNr6) * 255.0f);
    }
}
