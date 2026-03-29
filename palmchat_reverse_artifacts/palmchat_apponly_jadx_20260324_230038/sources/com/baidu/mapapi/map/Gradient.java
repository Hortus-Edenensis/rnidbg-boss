package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Gradient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3619a;
    private final int[] b;
    private final float[] c;
    float[] d;

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3620a;
        private final int b;
        private final float c;

        private b(int i, int i2, float f) {
            this.f3620a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private HashMap<Integer, b> a() {
        HashMap<Integer, b> map = new HashMap<>();
        if (this.c[0] != 0.0f) {
            map.put(0, new b(Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0])), this.b[0], this.f3619a * this.c[0]));
        }
        for (int i = 1; i < this.b.length; i++) {
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf((int) (this.f3619a * this.c[i2]));
            int[] iArr = this.b;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float f = this.f3619a;
            float[] fArr = this.c;
            map.put(numValueOf, new b(i3, i4, (fArr[i] - fArr[i2]) * f));
        }
        float[] fArr2 = this.c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer numValueOf2 = Integer.valueOf((int) (this.f3619a * fArr2[length]));
            int i5 = this.b[length];
            map.put(numValueOf2, new b(i5, i5, this.f3619a * (1.0f - this.c[length])));
        }
        return map;
    }

    public float[] b() {
        float[] fArr = this.d;
        if (fArr != null) {
            return fArr;
        }
        this.d = new float[this.f3619a];
        int i = 0;
        while (i < this.f3619a) {
            int i2 = i + 1;
            this.d[i] = i2 * 0.001f;
            i = i2;
        }
        return this.d;
    }

    public int[] getColors() {
        return this.b;
    }

    public float[] getStartPoints() {
        return this.c;
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        int[] iArrA = com.baidu.platform.comapi.util.d.a(iArr);
        if (iArrA == null || fArr == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
        }
        if (iArrA.length != fArr.length) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
        }
        if (iArrA.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (fArr[i2] <= fArr[i2 - 1]) {
                throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
            }
        }
        this.f3619a = i;
        int[] iArr2 = new int[iArrA.length];
        this.b = iArr2;
        float[] fArr2 = new float[fArr.length];
        this.c = fArr2;
        System.arraycopy(iArrA, 0, iArr2, 0, iArrA.length);
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
    }

    public int[] a(double d) {
        HashMap<Integer, b> mapA = a();
        int[] iArr = new int[this.f3619a];
        b bVar = mapA.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.f3619a; i2++) {
            if (mapA.containsKey(Integer.valueOf(i2))) {
                bVar = mapA.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(bVar.f3620a, bVar.b, (i2 - i) / bVar.c);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.f3619a; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (((double) Color.alpha(i4)) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }

    private static int a(int i, int i2, float f) {
        int iAlpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        float f2 = fArr[0];
        float f3 = fArr2[0];
        if (f2 - f3 > 180.0f) {
            fArr2[0] = f3 + 360.0f;
        } else if (f3 - f2 > 180.0f) {
            fArr[0] = f2 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            float f4 = fArr2[i3];
            float f5 = fArr[i3];
            fArr3[i3] = ((f4 - f5) * f) + f5;
        }
        return Color.HSVToColor(iAlpha, fArr3);
    }
}
