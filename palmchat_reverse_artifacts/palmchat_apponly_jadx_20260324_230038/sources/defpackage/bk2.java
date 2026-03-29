package defpackage;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class bk2 extends oc2 {
    public ht e;

    public bk2(s93 s93Var) {
        super(s93Var);
    }

    public static int[][] i(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2, i);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 4;
            int i7 = i4 - 16;
            if (i6 > i7) {
                i6 = i7;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 4;
                int i10 = i3 - 16;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = (i6 * i3) + i9;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 255;
                while (i12 < 16) {
                    for (int i16 = 0; i16 < 16; i16++) {
                        int i17 = bArr[i11 + i16] & UByte.MAX_VALUE;
                        i13 += i17;
                        if (i17 < i15) {
                            i15 = i17;
                        }
                        if (i17 > i14) {
                            i14 = i17;
                        }
                    }
                    if (i14 - i15 > 24) {
                        while (true) {
                            i12++;
                            i11 += i3;
                            if (i12 < 16) {
                                for (int i18 = 0; i18 < 16; i18++) {
                                    i13 += bArr[i11 + i18] & UByte.MAX_VALUE;
                                }
                            }
                        }
                    }
                    i12++;
                    i11 += i3;
                }
                int i19 = i13 >> 8;
                if (i14 - i15 <= 24) {
                    i19 = i15 / 2;
                    if (i5 > 0 && i8 > 0) {
                        int[] iArr2 = iArr[i5 - 1];
                        int i20 = i8 - 1;
                        int i21 = ((iArr2[i8] + (iArr[i5][i20] * 2)) + iArr2[i20]) / 4;
                        if (i15 < i21) {
                            i19 = i21;
                        }
                    }
                }
                iArr[i5][i8] = i19;
            }
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, ht htVar) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 4;
            int i7 = i4 - 16;
            if (i6 > i7) {
                i6 = i7;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 4;
                int i10 = i3 - 16;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int iK = k(i8, 2, i - 3);
                int iK2 = k(i5, 2, i2 - 3);
                int i11 = 0;
                for (int i12 = -2; i12 <= 2; i12++) {
                    int[] iArr2 = iArr[iK2 + i12];
                    i11 += iArr2[iK - 2] + iArr2[iK - 1] + iArr2[iK] + iArr2[iK + 1] + iArr2[iK + 2];
                }
                l(bArr, i10, i6, i11 / 25, i3, htVar);
            }
        }
    }

    public static int k(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static void l(byte[] bArr, int i, int i2, int i3, int i4, ht htVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 16) {
            for (int i7 = 0; i7 < 16; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    htVar.m(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    @Override // defpackage.ws
    public ws a(s93 s93Var) {
        return new bk2(s93Var);
    }

    @Override // defpackage.oc2, defpackage.ws
    public ht b() throws NotFoundException {
        ht htVar = this.e;
        if (htVar != null) {
            return htVar;
        }
        s93 s93VarE = e();
        int iD = s93VarE.d();
        int iA = s93VarE.a();
        if (iD < 80 || iA < 80) {
            this.e = super.b();
        } else {
            byte[] bArrB = s93VarE.b();
            int i = iD >> 4;
            if ((iD & 15) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = iA >> 4;
            if ((iA & 15) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] iArrI = i(bArrB, i2, i4, iD, iA);
            ht htVar2 = new ht(iD, iA);
            j(bArrB, i2, i4, iD, iA, iArrI, htVar2);
            this.e = htVar2;
        }
        return this.e;
    }
}
