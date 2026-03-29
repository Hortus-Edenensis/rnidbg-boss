package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class jm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f18434a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] a(et etVar, int i, int i2) {
        int[] iArr = new int[i2];
        int iK = etVar.k() / i;
        for (int i3 = 0; i3 < iK; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= etVar.g((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    public static void b(ht htVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    htVar.m(i5, i4);
                    htVar.m(i5, i6);
                    htVar.m(i4, i5);
                    htVar.m(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        htVar.m(i7, i7);
        int i8 = i7 + 1;
        htVar.m(i8, i7);
        htVar.m(i7, i8);
        int i9 = i + i2;
        htVar.m(i9, i7);
        htVar.m(i9, i8);
        htVar.m(i9, i9 - 1);
    }

    public static void c(ht htVar, boolean z, int i, et etVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (etVar.g(i3)) {
                    htVar.m(i4, i2 - 5);
                }
                if (etVar.g(i3 + 7)) {
                    htVar.m(i2 + 5, i4);
                }
                if (etVar.g(20 - i3)) {
                    htVar.m(i4, i2 + 5);
                }
                if (etVar.g(27 - i3)) {
                    htVar.m(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (etVar.g(i3)) {
                htVar.m(i5, i2 - 7);
            }
            if (etVar.g(i3 + 10)) {
                htVar.m(i2 + 7, i5);
            }
            if (etVar.g(29 - i3)) {
                htVar.m(i5, i2 + 7);
            }
            if (etVar.g(39 - i3)) {
                htVar.m(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static ln d(byte[] bArr, int i, int i2) {
        et etVarH;
        boolean z;
        int iAbs;
        int i3;
        int i4;
        int i5;
        et etVarA = new th2(bArr).a();
        int iK = ((etVarA.k() * i) / 100) + 11;
        int iK2 = etVarA.k() + iK;
        int i6 = 0;
        int i7 = 1;
        if (i2 == 0) {
            et etVarH2 = null;
            int i8 = 0;
            int i9 = 0;
            while (i8 <= 32) {
                boolean z2 = i8 <= 3;
                int i10 = z2 ? i8 + 1 : i8;
                int i11 = i(i10, z2);
                if (iK2 <= i11) {
                    int i12 = f18434a[i10];
                    if (i9 != i12) {
                        etVarH2 = h(etVarA, i12);
                    } else {
                        i12 = i9;
                    }
                    int i13 = i11 - (i11 % i12);
                    if ((!z2 || etVarH2.k() <= (i12 << 6)) && etVarH2.k() + iK <= i13) {
                        etVarH = etVarH2;
                        z = z2;
                        iAbs = i10;
                        i3 = i11;
                        i4 = i12;
                    } else {
                        i9 = i12;
                    }
                }
                i8++;
                i6 = 0;
                i7 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i2 < 0;
        iAbs = Math.abs(i2);
        if (iAbs > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
        }
        i3 = i(iAbs, z);
        i4 = f18434a[iAbs];
        int i14 = i3 - (i3 % i4);
        etVarH = h(etVarA, i4);
        if (etVarH.k() + iK > i14) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && etVarH.k() > (i4 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        et etVarE = e(etVarH, i3, i4);
        int iK3 = etVarH.k() / i4;
        et etVarF = f(z, iAbs, iK3);
        int i15 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[i17] = i17;
            }
            i5 = i15;
        } else {
            int i18 = i15 / 2;
            i5 = i15 + 1 + (((i18 - 1) / 15) * 2);
            int i19 = i5 / 2;
            for (int i20 = 0; i20 < i18; i20++) {
                iArr[(i18 - i20) - i7] = (i19 - r14) - 1;
                iArr[i18 + i20] = (i20 / 15) + i20 + i19 + i7;
            }
        }
        ht htVar = new ht(i5);
        int i21 = 0;
        int i22 = 0;
        while (i21 < iAbs) {
            int i23 = ((iAbs - i21) << i16) + (z ? 9 : 12);
            int i24 = 0;
            while (i24 < i23) {
                int i25 = i24 << 1;
                while (i6 < i16) {
                    if (etVarE.g(i22 + i25 + i6)) {
                        int i26 = i21 << 1;
                        htVar.m(iArr[i26 + i6], iArr[i26 + i24]);
                    }
                    if (etVarE.g((i23 << 1) + i22 + i25 + i6)) {
                        int i27 = i21 << 1;
                        htVar.m(iArr[i27 + i24], iArr[((i15 - 1) - i27) - i6]);
                    }
                    if (etVarE.g((i23 << 2) + i22 + i25 + i6)) {
                        int i28 = (i15 - 1) - (i21 << 1);
                        htVar.m(iArr[i28 - i6], iArr[i28 - i24]);
                    }
                    if (etVarE.g((i23 * 6) + i22 + i25 + i6)) {
                        int i29 = i21 << 1;
                        htVar.m(iArr[((i15 - 1) - i29) - i24], iArr[i29 + i6]);
                    }
                    i6++;
                    i16 = 2;
                }
                i24++;
                i6 = 0;
                i16 = 2;
            }
            i22 += i23 << 3;
            i21++;
            i6 = 0;
            i16 = 2;
        }
        c(htVar, z, i5, etVarF);
        if (z) {
            b(htVar, i5 / 2, 5);
        } else {
            int i30 = i5 / 2;
            b(htVar, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i32 < (i15 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i5; i33 += 2) {
                    int i34 = i30 - i31;
                    htVar.m(i34, i33);
                    int i35 = i30 + i31;
                    htVar.m(i35, i33);
                    htVar.m(i33, i34);
                    htVar.m(i33, i35);
                }
                i32 += 15;
                i31 += 16;
            }
        }
        ln lnVar = new ln();
        lnVar.c(z);
        lnVar.f(i5);
        lnVar.d(iAbs);
        lnVar.b(iK3);
        lnVar.e(htVar);
        return lnVar;
    }

    public static et e(et etVar, int i, int i2) {
        int iK = etVar.k() / i2;
        ou4 ou4Var = new ou4(g(i2));
        int i3 = i / i2;
        int[] iArrA = a(etVar, i2, i3);
        ou4Var.b(iArrA, i3 - iK);
        et etVar2 = new et();
        etVar2.c(0, i % i2);
        for (int i4 : iArrA) {
            etVar2.c(i4, i2);
        }
        return etVar2;
    }

    public static et f(boolean z, int i, int i2) {
        et etVar = new et();
        if (z) {
            etVar.c(i - 1, 2);
            etVar.c(i2 - 1, 6);
            return e(etVar, 28, 4);
        }
        etVar.c(i - 1, 5);
        etVar.c(i2 - 1, 11);
        return e(etVar, 40, 4);
    }

    public static w82 g(int i) {
        if (i == 4) {
            return w82.k;
        }
        if (i == 6) {
            return w82.j;
        }
        if (i == 8) {
            return w82.n;
        }
        if (i == 10) {
            return w82.i;
        }
        if (i == 12) {
            return w82.h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    public static et h(et etVar, int i) {
        et etVar2 = new et();
        int iK = etVar.k();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iK) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iK || etVar.g(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                etVar2.c(i7, i);
            } else if (i7 == 0) {
                etVar2.c(i4 | 1, i);
            } else {
                etVar2.c(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return etVar2;
    }

    public static int i(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
