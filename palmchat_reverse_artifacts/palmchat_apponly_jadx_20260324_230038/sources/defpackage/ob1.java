package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ob1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f19732a = {0, 4, 1, 5};
    public static final int[] b = {6, 2, 7, 3};
    public static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void a(sx4[] sx4VarArr, sx4[] sx4VarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            sx4VarArr[iArr[i]] = sx4VarArr2[i];
        }
    }

    public static sa4 b(xs xsVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        ht htVarA = xsVar.a();
        List<sx4[]> listC = c(z, htVarA);
        if (listC.isEmpty()) {
            htVarA = htVarA.clone();
            htVarA.l();
            listC = c(z, htVarA);
        }
        return new sa4(htVarA, listC);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (defpackage.sx4[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<sx4[]> c(boolean z, ht htVar) {
        int iC;
        float fD;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                if (iMax >= htVar.h()) {
                    break loop0;
                }
                sx4[] sx4VarArrF = f(htVar, iMax, i);
                if (sx4VarArrF[0] != null || sx4VarArrF[3] != null) {
                    arrayList.add(sx4VarArrF);
                    if (!z) {
                        break loop0;
                    }
                    sx4 sx4Var = sx4VarArrF[2];
                    if (sx4Var != null) {
                        iC = (int) sx4Var.c();
                        fD = sx4VarArrF[2].d();
                    } else {
                        iC = (int) sx4VarArrF[4].c();
                        fD = sx4VarArrF[4].d();
                    }
                    iMax = (int) fD;
                    i = iC;
                    z2 = true;
                } else {
                    break;
                }
            }
            iMax += 5;
        }
        return arrayList;
    }

    public static int[] d(ht htVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i4 = 0;
        while (htVar.e(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (htVar.e(i, i2) ^ z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                int i8 = length - 1;
                if (i6 != i8) {
                    i6++;
                } else {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    public static sx4[] e(ht htVar, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        sx4[] sx4VarArr = new sx4[4];
        int[] iArr2 = new int[iArr.length];
        int i9 = i3;
        while (true) {
            if (i9 >= i) {
                z = false;
                break;
            }
            int[] iArrD = d(htVar, i4, i9, i2, false, iArr, iArr2);
            if (iArrD != null) {
                int i10 = i9;
                int[] iArr3 = iArrD;
                int i11 = i10;
                while (true) {
                    if (i11 <= 0) {
                        i8 = i11;
                        break;
                    }
                    int i12 = i11 - 1;
                    int[] iArrD2 = d(htVar, i4, i12, i2, false, iArr, iArr2);
                    if (iArrD2 == null) {
                        i8 = i12 + 1;
                        break;
                    }
                    iArr3 = iArrD2;
                    i11 = i12;
                }
                float f = i8;
                sx4VarArr[0] = new sx4(iArr3[0], f);
                sx4VarArr[1] = new sx4(iArr3[1], f);
                i9 = i8;
                z = true;
            } else {
                i9 += 5;
            }
        }
        int i13 = i9 + 1;
        if (z) {
            int[] iArr4 = {(int) sx4VarArr[0].c(), (int) sx4VarArr[1].c()};
            int i14 = i13;
            int i15 = 0;
            while (true) {
                if (i14 >= i) {
                    i6 = i15;
                    i7 = i14;
                    break;
                }
                i6 = i15;
                i7 = i14;
                int[] iArrD3 = d(htVar, iArr4[0], i14, i2, false, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i15 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i15 = i6 + 1;
                }
                i14 = i7 + 1;
            }
            i13 = i7 - (i6 + 1);
            float f2 = i13;
            sx4VarArr[2] = new sx4(iArr4[0], f2);
            sx4VarArr[3] = new sx4(iArr4[1], f2);
        }
        if (i13 - i9 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                sx4VarArr[i5] = null;
            }
        }
        return sx4VarArr;
    }

    public static sx4[] f(ht htVar, int i, int i2) {
        int iH = htVar.h();
        int iK = htVar.k();
        sx4[] sx4VarArr = new sx4[8];
        a(sx4VarArr, e(htVar, iH, iK, i, i2, c), f19732a);
        sx4 sx4Var = sx4VarArr[4];
        if (sx4Var != null) {
            i2 = (int) sx4Var.c();
            i = (int) sx4VarArr[4].d();
        }
        a(sx4VarArr, e(htVar, iH, iK, i, i2, d), b);
        return sx4VarArr;
    }

    public static float g(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
