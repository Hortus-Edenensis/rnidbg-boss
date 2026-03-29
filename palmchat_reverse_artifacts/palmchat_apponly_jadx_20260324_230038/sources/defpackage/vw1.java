package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class vw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f21542a;
    public boolean c;
    public final tx4 e;
    public final List<tw1> b = new ArrayList();
    public final int[] d = new int[5];

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements Serializable, Comparator<tw1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f21543a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(tw1 tw1Var, tw1 tw1Var2) {
            if (tw1Var2.h() != tw1Var.h()) {
                return tw1Var2.h() - tw1Var.h();
            }
            float fAbs = Math.abs(tw1Var2.i() - this.f21543a);
            float fAbs2 = Math.abs(tw1Var.i() - this.f21543a);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }

        public b(float f) {
            this.f21543a = f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Serializable, Comparator<tw1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f21544a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(tw1 tw1Var, tw1 tw1Var2) {
            float fAbs = Math.abs(tw1Var2.i() - this.f21544a);
            float fAbs2 = Math.abs(tw1Var.i() - this.f21544a);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }

        public c(float f) {
            this.f21544a = f;
        }
    }

    public vw1(ht htVar, tx4 tx4Var) {
        this.f21542a = htVar;
        this.e = tx4Var;
    }

    public static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean g(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public final boolean b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArrH = h();
        int i12 = 0;
        while (i >= i12 && i2 >= i12 && this.f21542a.e(i2 - i12, i - i12)) {
            iArrH[2] = iArrH[2] + 1;
            i12++;
        }
        if (i >= i12 && i2 >= i12) {
            while (i >= i12 && i2 >= i12 && !this.f21542a.e(i2 - i12, i - i12)) {
                int i13 = iArrH[1];
                if (i13 > i3) {
                    break;
                }
                iArrH[1] = i13 + 1;
                i12++;
            }
            if (i >= i12 && i2 >= i12 && iArrH[1] <= i3) {
                while (i >= i12 && i2 >= i12 && this.f21542a.e(i2 - i12, i - i12)) {
                    int i14 = iArrH[0];
                    if (i14 > i3) {
                        break;
                    }
                    iArrH[0] = i14 + 1;
                    i12++;
                }
                if (iArrH[0] > i3) {
                    return false;
                }
                int iH = this.f21542a.h();
                int iK = this.f21542a.k();
                int i15 = 1;
                while (true) {
                    i5 = i + i15;
                    if (i5 >= iH || (i11 = i2 + i15) >= iK || !this.f21542a.e(i11, i5)) {
                        break;
                    }
                    iArrH[2] = iArrH[2] + 1;
                    i15++;
                }
                if (i5 < iH && i2 + i15 < iK) {
                    while (true) {
                        i6 = i + i15;
                        if (i6 >= iH || (i9 = i2 + i15) >= iK || this.f21542a.e(i9, i6) || (i10 = iArrH[3]) >= i3) {
                            break;
                        }
                        iArrH[3] = i10 + 1;
                        i15++;
                    }
                    if (i6 < iH && i2 + i15 < iK && iArrH[3] < i3) {
                        while (true) {
                            int i16 = i + i15;
                            if (i16 >= iH || (i7 = i2 + i15) >= iK || !this.f21542a.e(i7, i16) || (i8 = iArrH[4]) >= i3) {
                                break;
                            }
                            iArrH[4] = i8 + 1;
                            i15++;
                        }
                        int i17 = iArrH[4];
                        if (i17 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i17) - i4) < i4 * 2 && g(iArrH)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        ht htVar = this.f21542a;
        int iK = htVar.k();
        int[] iArrH = h();
        int i8 = i;
        while (i8 >= 0 && htVar.e(i8, i2)) {
            iArrH[2] = iArrH[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !htVar.e(i8, i2)) {
            int i9 = iArrH[1];
            if (i9 > i3) {
                break;
            }
            iArrH[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrH[1] <= i3) {
            while (i8 >= 0 && htVar.e(i8, i2) && (i7 = iArrH[0]) <= i3) {
                iArrH[0] = i7 + 1;
                i8--;
            }
            if (iArrH[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iK && htVar.e(i10, i2)) {
                iArrH[2] = iArrH[2] + 1;
                i10++;
            }
            if (i10 == iK) {
                return Float.NaN;
            }
            while (i10 < iK && !htVar.e(i10, i2) && (i6 = iArrH[3]) < i3) {
                iArrH[3] = i6 + 1;
                i10++;
            }
            if (i10 != iK && iArrH[3] < i3) {
                while (i10 < iK && htVar.e(i10, i2) && (i5 = iArrH[4]) < i3) {
                    iArrH[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrH[4];
                if (i11 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i11) - i4) * 5 < i4 && g(iArrH)) {
                    return a(iArrH, i10);
                }
            }
        }
        return Float.NaN;
    }

    public final float d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        ht htVar = this.f21542a;
        int iH = htVar.h();
        int[] iArrH = h();
        int i8 = i;
        while (i8 >= 0 && htVar.e(i2, i8)) {
            iArrH[2] = iArrH[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !htVar.e(i2, i8)) {
            int i9 = iArrH[1];
            if (i9 > i3) {
                break;
            }
            iArrH[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrH[1] <= i3) {
            while (i8 >= 0 && htVar.e(i2, i8) && (i7 = iArrH[0]) <= i3) {
                iArrH[0] = i7 + 1;
                i8--;
            }
            if (iArrH[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iH && htVar.e(i2, i10)) {
                iArrH[2] = iArrH[2] + 1;
                i10++;
            }
            if (i10 == iH) {
                return Float.NaN;
            }
            while (i10 < iH && !htVar.e(i2, i10) && (i6 = iArrH[3]) < i3) {
                iArrH[3] = i6 + 1;
                i10++;
            }
            if (i10 != iH && iArrH[3] < i3) {
                while (i10 < iH && htVar.e(i2, i10) && (i5 = iArrH[4]) < i3) {
                    iArrH[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrH[4];
                if (i11 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i11) - i4) * 5 < i4 * 2 && g(iArrH)) {
                    return a(iArrH, i10);
                }
            }
        }
        return Float.NaN;
    }

    public final ww1 e(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int iH = this.f21542a.h();
        int iK = this.f21542a.k();
        int i = (iH * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zJ = false;
        while (i2 < iH && !zJ) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < iK) {
                if (this.f21542a.e(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (g(iArr) && i(iArr, i2, i3, z2)) {
                    if (this.c) {
                        zJ = j();
                    } else {
                        int iF = f();
                        int i5 = iArr[2];
                        if (iF > i5) {
                            i2 += (iF - i5) - 2;
                            i3 = iK - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i = 2;
                    i4 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
                i3++;
            }
            if (g(iArr) && i(iArr, i2, iK, z2)) {
                i = iArr[0];
                if (this.c) {
                    zJ = j();
                }
            }
            i2 += i;
        }
        tw1[] tw1VarArrK = k();
        sx4.e(tw1VarArrK);
        return new ww1(tw1VarArrK);
    }

    public final int f() {
        if (this.b.size() <= 1) {
            return 0;
        }
        tw1 tw1Var = null;
        for (tw1 tw1Var2 : this.b) {
            if (tw1Var2.h() >= 2) {
                if (tw1Var != null) {
                    this.c = true;
                    return ((int) (Math.abs(tw1Var.c() - tw1Var2.c()) - Math.abs(tw1Var.d() - tw1Var2.d()))) / 2;
                }
                tw1Var = tw1Var2;
            }
        }
        return 0;
    }

    public final int[] h() {
        int[] iArr = this.d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    public final boolean i(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i2);
        float fD = d(i, iA, iArr[2], i3);
        if (!Float.isNaN(fD)) {
            int i4 = (int) fD;
            float fC = c(iA, i4, iArr[2], i3);
            if (!Float.isNaN(fC) && (!z || b(i4, (int) fC, iArr[2], i3))) {
                float f = i3 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.b.size()) {
                        break;
                    }
                    tw1 tw1Var = this.b.get(i5);
                    if (tw1Var.f(f, fD, fC)) {
                        this.b.set(i5, tw1Var.g(fD, fC, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    tw1 tw1Var2 = new tw1(fC, fD, f);
                    this.b.add(tw1Var2);
                    tx4 tx4Var = this.e;
                    if (tx4Var != null) {
                        tx4Var.a(tw1Var2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        int size = this.b.size();
        float fAbs = 0.0f;
        int i = 0;
        float fI = 0.0f;
        for (tw1 tw1Var : this.b) {
            if (tw1Var.h() >= 2) {
                i++;
                fI += tw1Var.i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = fI / size;
        Iterator<tw1> it = this.b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().i() - f);
        }
        return fAbs <= fI * 0.05f;
    }

    public final tw1[] k() throws NotFoundException {
        int size = this.b.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fI = 0.0f;
        if (size > 3) {
            Iterator<tw1> it = this.b.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                float fI2 = it.next().i();
                f += fI2;
                f2 += fI2 * fI2;
            }
            float f3 = f / size;
            float fSqrt = (float) Math.sqrt((f2 / r0) - (f3 * f3));
            Collections.sort(this.b, new c(f3));
            float fMax = Math.max(0.2f * f3, fSqrt);
            int i = 0;
            while (i < this.b.size() && this.b.size() > 3) {
                if (Math.abs(this.b.get(i).i() - f3) > fMax) {
                    this.b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.b.size() > 3) {
            Iterator<tw1> it2 = this.b.iterator();
            while (it2.hasNext()) {
                fI += it2.next().i();
            }
            Collections.sort(this.b, new b(fI / this.b.size()));
            List<tw1> list = this.b;
            list.subList(3, list.size()).clear();
        }
        return new tw1[]{this.b.get(0), this.b.get(1), this.b.get(2)};
    }
}
