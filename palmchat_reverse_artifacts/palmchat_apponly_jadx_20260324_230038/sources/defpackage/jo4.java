package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jo4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18453a;
    public final a b;
    public final int c;
    public final boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b[] f18454a;

        public a(b... bVarArr) {
            this.f18454a = bVarArr;
        }

        public b a(int i) {
            return this.f18454a[i];
        }

        public int b() {
            return this.f18454a.length;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18455a;
        public final int b;
        public final float[] c;
        public final float[] d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.f18455a = i;
            vh.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.c = fArr;
            this.d = fArr2;
            this.b = i2;
        }

        public int a() {
            return this.c.length / 3;
        }
    }

    public jo4(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public static jo4 a(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        int i5;
        int i6;
        int i7;
        float[] fArr;
        int i8 = i;
        int i9 = i2;
        vh.a(f > 0.0f);
        vh.a(i8 >= 1);
        vh.a(i9 >= 1);
        vh.a(f2 > 0.0f && f2 <= 180.0f);
        vh.a(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f5 = radians / i8;
        float f6 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f7 = radians / 2.0f;
            float f8 = (i12 * f5) - f7;
            int i15 = i12 + 1;
            float f9 = (i15 * f5) - f7;
            int i16 = 0;
            while (i16 < i10) {
                float f10 = f8;
                int i17 = i15;
                int i18 = 0;
                int i19 = 2;
                while (i18 < i19) {
                    if (i18 == 0) {
                        f4 = f10;
                        i4 = i10;
                    } else {
                        i4 = i10;
                        f4 = f9;
                    }
                    float f11 = i16 * f6;
                    float f12 = f6;
                    int i20 = i13 + 1;
                    int i21 = i16;
                    double d = f;
                    float f13 = f5;
                    double d2 = (f11 + 3.1415927f) - (radians2 / 2.0f);
                    int i22 = i18;
                    double d3 = f4;
                    float[] fArr4 = fArr3;
                    float f14 = f9;
                    fArr2[i13] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                    int i23 = i20 + 1;
                    int i24 = i12;
                    fArr2[i20] = (float) (d * Math.sin(d3));
                    int i25 = i23 + 1;
                    fArr2[i23] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    int i26 = i14 + 1;
                    fArr4[i14] = f11 / radians2;
                    int i27 = i26 + 1;
                    fArr4[i26] = ((i24 + i22) * f13) / radians;
                    if (i21 == 0 && i22 == 0) {
                        i5 = i2;
                        i6 = i21;
                        i7 = i22;
                    } else {
                        i5 = i2;
                        i6 = i21;
                        i7 = i22;
                        if (i6 != i5 || i7 != 1) {
                            fArr = fArr4;
                        }
                        i14 = i27;
                        i13 = i25;
                        int i28 = i7 + 1;
                        fArr3 = fArr;
                        i12 = i24;
                        i10 = i4;
                        f6 = f12;
                        f5 = f13;
                        f9 = f14;
                        i19 = 2;
                        i9 = i5;
                        i16 = i6;
                        i18 = i28;
                    }
                    System.arraycopy(fArr2, i25 - 3, fArr2, i25, 3);
                    i25 += 3;
                    fArr = fArr4;
                    System.arraycopy(fArr, i27 - 2, fArr, i27, 2);
                    i27 += 2;
                    i14 = i27;
                    i13 = i25;
                    int i282 = i7 + 1;
                    fArr3 = fArr;
                    i12 = i24;
                    i10 = i4;
                    f6 = f12;
                    f5 = f13;
                    f9 = f14;
                    i19 = 2;
                    i9 = i5;
                    i16 = i6;
                    i18 = i282;
                }
                int i29 = i16;
                int i30 = i9;
                int i31 = i29 + 1;
                f8 = f10;
                i15 = i17;
                i10 = i10;
                f6 = f6;
                f9 = f9;
                i9 = i30;
                i16 = i31;
            }
            i8 = i;
            i12 = i15;
        }
        return new jo4(new a(new b(0, fArr2, fArr3, 1)), i3);
    }

    public static jo4 b(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public jo4(a aVar, a aVar2, int i) {
        this.f18453a = aVar;
        this.b = aVar2;
        this.c = i;
        this.d = aVar == aVar2;
    }
}
