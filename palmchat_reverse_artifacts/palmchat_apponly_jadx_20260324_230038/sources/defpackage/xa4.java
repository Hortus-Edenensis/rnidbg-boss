package defpackage;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class xa4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wm1 f21912a = new wm1();

    public static ou a(lb1 lb1Var) throws NotFoundException, FormatException {
        int[] iArrJ;
        if (lb1Var == null || (iArrJ = lb1Var.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrJ) {
            i2 += iP - i3;
            if (i3 > 0) {
                break;
            }
        }
        fe0[] fe0VarArrD = lb1Var.d();
        for (int i4 = 0; i2 > 0 && fe0VarArrD[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i5 = iArrJ[length];
            i += iP - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = fe0VarArrD.length - 1; i > 0 && fe0VarArrD[length2] == null; length2--) {
            i--;
        }
        return lb1Var.a().a(i2, i, lb1Var.k());
    }

    public static void b(jb1 jb1Var, xp[][] xpVarArr) throws NotFoundException {
        int[] iArrA = xpVarArr[0][1].a();
        int iJ = (jb1Var.j() * jb1Var.l()) - r(jb1Var.k());
        if (iArrA.length != 0) {
            if (iArrA[0] != iJ) {
                xpVarArr[0][1].b(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            xpVarArr[0][1].b(iJ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(ht htVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = 0;
        int i7 = i3;
        while (i6 < 2) {
            while (true) {
                if (z) {
                    if (i7 >= i) {
                        if (z == htVar.e(i7, i4)) {
                            if (Math.abs(i3 - i7) > 2) {
                                return i3;
                            }
                            i7 += i5;
                        }
                    }
                } else if (i7 < i2) {
                }
            }
        }
        return i7;
    }

    public static boolean d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f21912a.a(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static xp[][] f(jb1 jb1Var) {
        int iC;
        xp[][] xpVarArr = (xp[][]) Array.newInstance((Class<?>) xp.class, jb1Var.l(), jb1Var.j() + 2);
        for (xp[] xpVarArr2 : xpVarArr) {
            int i = 0;
            while (true) {
                if (i < xpVarArr2.length) {
                    xpVarArr2[i] = new xp();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (kb1 kb1Var : jb1Var.o()) {
            if (kb1Var != null) {
                for (fe0 fe0Var : kb1Var.d()) {
                    if (fe0Var != null && (iC = fe0Var.c()) >= 0 && iC < xpVarArr.length) {
                        xpVarArr[iC][i2].b(fe0Var.e());
                    }
                }
            }
            i2++;
        }
        return xpVarArr;
    }

    public static nw0 g(jb1 jb1Var) throws NotFoundException, ChecksumException, FormatException {
        xp[][] xpVarArrF = f(jb1Var);
        b(jb1Var, xpVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[jb1Var.l() * jb1Var.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < jb1Var.l(); i++) {
            int i2 = 0;
            while (i2 < jb1Var.j()) {
                int i3 = i2 + 1;
                int[] iArrA = xpVarArrF[i][i3].a();
                int iJ = (jb1Var.j() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return h(jb1Var.k(), iArr, ra4.b(arrayList), ra4.b(arrayList3), iArr2);
    }

    public static nw0 h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException, FormatException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return j(iArr, i, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    i5++;
                }
                i2 = i3;
            }
        }
    }

    public static nw0 i(ht htVar, sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4, int i, int i2) throws NotFoundException, ChecksumException, FormatException {
        int i3;
        int i4;
        int i5;
        lb1 lb1VarS = null;
        lb1 lb1VarS2 = null;
        jb1 jb1VarV = null;
        ou ouVar = new ou(htVar, sx4Var, sx4Var2, sx4Var3, sx4Var4);
        for (int i6 = 0; i6 < 2; i6++) {
            if (sx4Var != null) {
                lb1VarS = s(htVar, ouVar, sx4Var, true, i, i2);
            }
            if (sx4Var3 != null) {
                lb1VarS2 = s(htVar, ouVar, sx4Var3, false, i, i2);
            }
            jb1VarV = v(lb1VarS, lb1VarS2);
            if (jb1VarV == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i6 != 0 || jb1VarV.m() == null || (jb1VarV.m().h() >= ouVar.h() && jb1VarV.m().f() <= ouVar.f())) {
                jb1VarV.p(ouVar);
                break;
            }
            ouVar = jb1VarV.m();
        }
        int iJ = jb1VarV.j() + 1;
        jb1VarV.q(0, lb1VarS);
        jb1VarV.q(iJ, lb1VarS2);
        boolean z = lb1VarS != null;
        int iMin = i;
        int iMax = i2;
        for (int i7 = 1; i7 <= iJ; i7++) {
            int i8 = z ? i7 : iJ - i7;
            if (jb1VarV.n(i8) == null) {
                kb1 lb1Var = (i8 == 0 || i8 == iJ) ? new lb1(ouVar, i8 == 0) : new kb1(ouVar);
                jb1VarV.q(i8, lb1Var);
                int i9 = -1;
                int iH = ouVar.h();
                int i10 = -1;
                while (iH <= ouVar.f()) {
                    int iT = t(jb1VarV, i8, iH, z);
                    if (iT >= 0 && iT <= ouVar.e()) {
                        i5 = iT;
                    } else if (i10 != i9) {
                        i5 = i10;
                    } else {
                        i3 = i10;
                        i4 = iH;
                        i10 = i3;
                        iH = i4 + 1;
                        i9 = -1;
                    }
                    i3 = i10;
                    int i11 = iH;
                    fe0 fe0VarK = k(htVar, ouVar.g(), ouVar.e(), z, i5, i11, iMin, iMax);
                    i4 = i11;
                    if (fe0VarK != null) {
                        lb1Var.f(i4, fe0VarK);
                        iMin = Math.min(iMin, fe0VarK.f());
                        iMax = Math.max(iMax, fe0VarK.f());
                        i10 = i5;
                    } else {
                        i10 = i3;
                    }
                    iH = i4 + 1;
                    i9 = -1;
                }
            }
        }
        return g(jb1VarV);
    }

    public static nw0 j(int[] iArr, int i, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int iE = e(iArr, iArr2, i2);
        w(iArr, i2);
        nw0 nw0VarB = aw0.b(iArr, String.valueOf(i));
        nw0VarB.l(Integer.valueOf(iE));
        nw0VarB.k(Integer.valueOf(iArr2.length));
        return nw0VarB;
    }

    public static fe0 k(ht htVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int iA;
        int iC = c(htVar, i, i2, z, i3, i4);
        int[] iArrQ = q(htVar, i, i2, z, iC, i4);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = ae3.d(iArrQ);
        if (z) {
            i7 = iC + iD2;
        } else {
            for (int i8 = 0; i8 < iArrQ.length / 2; i8++) {
                int i9 = iArrQ[i8];
                iArrQ[i8] = iArrQ[(iArrQ.length - 1) - i8];
                iArrQ[(iArrQ.length - 1) - i8] = i9;
            }
            iC -= iD2;
            i7 = iC;
        }
        if (d(iD2, i5, i6) && (iA = ra4.a((iD = qa4.d(iArrQ)))) != -1) {
            return new fe0(iC, i7, n(iD), iA);
        }
        return null;
    }

    public static vp l(lb1 lb1Var, lb1 lb1Var2) {
        vp vpVarI;
        vp vpVarI2;
        if (lb1Var == null || (vpVarI = lb1Var.i()) == null) {
            if (lb1Var2 == null) {
                return null;
            }
            return lb1Var2.i();
        }
        if (lb1Var2 == null || (vpVarI2 = lb1Var2.i()) == null || vpVarI.a() == vpVarI2.a() || vpVarI.b() == vpVarI2.b() || vpVarI.c() == vpVarI2.c()) {
            return vpVarI;
        }
        return null;
    }

    public static int[] m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    public static int n(int i) {
        return o(m(i));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] q(ht htVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else {
                if (i3 >= i2) {
                    break;
                }
                if (i6 >= 8) {
                    break;
                }
                if (htVar.e(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    public static int r(int i) {
        return 2 << i;
    }

    public static lb1 s(ht htVar, ou ouVar, sx4 sx4Var, boolean z, int i, int i2) {
        lb1 lb1Var = new lb1(ouVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iC = (int) sx4Var.c();
            for (int iD = (int) sx4Var.d(); iD <= ouVar.f() && iD >= ouVar.h(); iD += i4) {
                fe0 fe0VarK = k(htVar, 0, htVar.k(), z, iC, iD, i, i2);
                if (fe0VarK != null) {
                    lb1Var.f(iD, fe0VarK);
                    iC = z ? fe0VarK.d() : fe0VarK.b();
                }
            }
            i3++;
        }
        return lb1Var;
    }

    public static int t(jb1 jb1Var, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        fe0 fe0VarB = u(jb1Var, i4) ? jb1Var.n(i4).b(i2) : null;
        if (fe0VarB != null) {
            return z ? fe0VarB.b() : fe0VarB.d();
        }
        fe0 fe0VarC = jb1Var.n(i).c(i2);
        if (fe0VarC != null) {
            return z ? fe0VarC.d() : fe0VarC.b();
        }
        if (u(jb1Var, i4)) {
            fe0VarC = jb1Var.n(i4).c(i2);
        }
        if (fe0VarC != null) {
            return z ? fe0VarC.b() : fe0VarC.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!u(jb1Var, i)) {
                ou ouVarM = jb1Var.m();
                return z ? ouVarM.g() : ouVarM.e();
            }
            for (fe0 fe0Var : jb1Var.n(i).d()) {
                if (fe0Var != null) {
                    return (z ? fe0Var.b() : fe0Var.d()) + (i3 * i5 * (fe0Var.b() - fe0Var.d()));
                }
            }
            i5++;
        }
    }

    public static boolean u(jb1 jb1Var, int i) {
        return i >= 0 && i <= jb1Var.j() + 1;
    }

    public static jb1 v(lb1 lb1Var, lb1 lb1Var2) throws NotFoundException, FormatException {
        vp vpVarL;
        if ((lb1Var == null && lb1Var2 == null) || (vpVarL = l(lb1Var, lb1Var2)) == null) {
            return null;
        }
        return new jb1(vpVarL, ou.l(a(lb1Var), a(lb1Var2)));
    }

    public static void w(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
