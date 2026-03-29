package defpackage;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class mb1 {
    public static final int[] g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f19181a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19182a;
        public final int b;

        public a(int i, int i2) {
            this.f19182a = i;
            this.b = i2;
        }

        public int a() {
            return this.f19182a;
        }

        public int b() {
            return this.b;
        }

        public sx4 c() {
            return new sx4(a(), b());
        }

        public String toString() {
            return "<" + this.f19182a + ' ' + this.b + Typography.greater;
        }
    }

    public mb1(ht htVar) {
        this.f19181a = htVar;
    }

    public static float b(a aVar, a aVar2) {
        return ae3.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    public static float c(sx4 sx4Var, sx4 sx4Var2) {
        return ae3.a(sx4Var.c(), sx4Var.d(), sx4Var2.c(), sx4Var2.d());
    }

    public static sx4[] d(sx4[] sx4VarArr, float f, float f2) {
        float f3 = f2 / (f * 2.0f);
        float fC = sx4VarArr[0].c() - sx4VarArr[2].c();
        float fD = sx4VarArr[0].d() - sx4VarArr[2].d();
        float fC2 = (sx4VarArr[0].c() + sx4VarArr[2].c()) / 2.0f;
        float fD2 = (sx4VarArr[0].d() + sx4VarArr[2].d()) / 2.0f;
        float f4 = fC * f3;
        float f5 = fD * f3;
        sx4 sx4Var = new sx4(fC2 + f4, fD2 + f5);
        sx4 sx4Var2 = new sx4(fC2 - f4, fD2 - f5);
        float fC3 = sx4VarArr[1].c() - sx4VarArr[3].c();
        float fD3 = sx4VarArr[1].d() - sx4VarArr[3].d();
        float fC4 = (sx4VarArr[1].c() + sx4VarArr[3].c()) / 2.0f;
        float fD4 = (sx4VarArr[1].d() + sx4VarArr[3].d()) / 2.0f;
        float f6 = fC3 * f3;
        float f7 = f3 * fD3;
        return new sx4[]{sx4Var, new sx4(fC4 + f6, fD4 + f7), sx4Var2, new sx4(fC4 - f6, fD4 - f7)};
    }

    public static int h(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new nu4(w82.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static int m(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public mn a(boolean z) throws NotFoundException {
        sx4[] sx4VarArrF = f(k());
        if (z) {
            sx4 sx4Var = sx4VarArrF[0];
            sx4VarArrF[0] = sx4VarArrF[2];
            sx4VarArrF[2] = sx4Var;
        }
        e(sx4VarArrF);
        ht htVar = this.f19181a;
        int i = this.f;
        return new mn(q(htVar, sx4VarArrF[i % 4], sx4VarArrF[(i + 1) % 4], sx4VarArrF[(i + 2) % 4], sx4VarArrF[(i + 3) % 4]), l(sx4VarArrF), this.b, this.d, this.c);
    }

    public final void e(sx4[] sx4VarArr) throws NotFoundException {
        long j;
        long j2;
        if (!o(sx4VarArr[0]) || !o(sx4VarArr[1]) || !o(sx4VarArr[2]) || !o(sx4VarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = this.e * 2;
        int[] iArr = {r(sx4VarArr[0], sx4VarArr[1], i), r(sx4VarArr[1], sx4VarArr[2], i), r(sx4VarArr[2], sx4VarArr[3], i), r(sx4VarArr[3], sx4VarArr[0], i)};
        this.f = m(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.f + i2) % 4];
            if (this.b) {
                j = j3 << 7;
                j2 = (i3 >> 1) & 127;
            } else {
                j = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int iH = h(j3, this.b);
        if (this.b) {
            this.c = (iH >> 6) + 1;
            this.d = (iH & 63) + 1;
        } else {
            this.c = (iH >> 11) + 1;
            this.d = (iH & 2047) + 1;
        }
    }

    public final sx4[] f(a aVar) throws NotFoundException {
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.e < 9) {
            a aVarJ = j(aVar2, z, 1, -1);
            a aVarJ2 = j(aVar3, z, 1, 1);
            a aVarJ3 = j(aVar4, z, -1, 1);
            a aVarJ4 = j(aVar5, z, -1, -1);
            if (this.e > 2) {
                double dB = (b(aVarJ4, aVarJ) * this.e) / (b(aVar5, aVar2) * (this.e + 2));
                if (dB < 0.75d || dB > 1.25d || !p(aVarJ, aVarJ2, aVarJ3, aVarJ4)) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar5 = aVarJ4;
            aVar2 = aVarJ;
            aVar3 = aVarJ2;
            aVar4 = aVarJ3;
        }
        int i = this.e;
        if (i != 5 && i != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.b = i == 5;
        sx4[] sx4VarArr = {new sx4(aVar2.a() + 0.5f, aVar2.b() - 0.5f), new sx4(aVar3.a() + 0.5f, aVar3.b() + 0.5f), new sx4(aVar4.a() - 0.5f, aVar4.b() + 0.5f), new sx4(aVar5.a() - 0.5f, aVar5.b() - 0.5f)};
        int i2 = this.e;
        return d(sx4VarArr, (i2 * 2) - 3, i2 * 2);
    }

    public final int g(a aVar, a aVar2) {
        float fB = b(aVar, aVar2);
        float fA = (aVar2.a() - aVar.a()) / fB;
        float fB2 = (aVar2.b() - aVar.b()) / fB;
        float fA2 = aVar.a();
        float fB3 = aVar.b();
        boolean zE = this.f19181a.e(aVar.a(), aVar.b());
        int i = 0;
        for (int i2 = 0; i2 < fB; i2++) {
            fA2 += fA;
            fB3 += fB2;
            if (this.f19181a.e(ae3.c(fA2), ae3.c(fB3)) != zE) {
                i++;
            }
        }
        float f = i / fB;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zE ? 1 : -1;
        }
        return 0;
    }

    public final int i() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    public final a j(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!n(iA, iB) || this.f19181a.e(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (n(i3, i4) && this.f19181a.e(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (n(i5, i4) && this.f19181a.e(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    public final a k() {
        sx4 sx4VarC;
        sx4 sx4Var;
        sx4 sx4Var2;
        sx4 sx4Var3;
        sx4 sx4VarC2;
        sx4 sx4VarC3;
        sx4 sx4VarC4;
        sx4 sx4VarC5;
        try {
            sx4[] sx4VarArrC = new pk6(this.f19181a).c();
            sx4Var2 = sx4VarArrC[0];
            sx4Var3 = sx4VarArrC[1];
            sx4Var = sx4VarArrC[2];
            sx4VarC = sx4VarArrC[3];
        } catch (NotFoundException unused) {
            int iK = this.f19181a.k() / 2;
            int iH = this.f19181a.h() / 2;
            int i = iK + 7;
            int i2 = iH - 7;
            sx4 sx4VarC6 = j(new a(i, i2), false, 1, -1).c();
            int i3 = iH + 7;
            sx4 sx4VarC7 = j(new a(i, i3), false, 1, 1).c();
            int i4 = iK - 7;
            sx4 sx4VarC8 = j(new a(i4, i3), false, -1, 1).c();
            sx4VarC = j(new a(i4, i2), false, -1, -1).c();
            sx4Var = sx4VarC8;
            sx4Var2 = sx4VarC6;
            sx4Var3 = sx4VarC7;
        }
        int iC = ae3.c((((sx4Var2.c() + sx4VarC.c()) + sx4Var3.c()) + sx4Var.c()) / 4.0f);
        int iC2 = ae3.c((((sx4Var2.d() + sx4VarC.d()) + sx4Var3.d()) + sx4Var.d()) / 4.0f);
        try {
            sx4[] sx4VarArrC2 = new pk6(this.f19181a, 15, iC, iC2).c();
            sx4VarC2 = sx4VarArrC2[0];
            sx4VarC3 = sx4VarArrC2[1];
            sx4VarC4 = sx4VarArrC2[2];
            sx4VarC5 = sx4VarArrC2[3];
        } catch (NotFoundException unused2) {
            int i5 = iC + 7;
            int i6 = iC2 - 7;
            sx4VarC2 = j(new a(i5, i6), false, 1, -1).c();
            int i7 = iC2 + 7;
            sx4VarC3 = j(new a(i5, i7), false, 1, 1).c();
            int i8 = iC - 7;
            sx4VarC4 = j(new a(i8, i7), false, -1, 1).c();
            sx4VarC5 = j(new a(i8, i6), false, -1, -1).c();
        }
        return new a(ae3.c((((sx4VarC2.c() + sx4VarC5.c()) + sx4VarC3.c()) + sx4VarC4.c()) / 4.0f), ae3.c((((sx4VarC2.d() + sx4VarC5.d()) + sx4VarC3.d()) + sx4VarC4.d()) / 4.0f));
    }

    public final sx4[] l(sx4[] sx4VarArr) {
        return d(sx4VarArr, this.e * 2, i());
    }

    public final boolean n(int i, int i2) {
        return i >= 0 && i < this.f19181a.k() && i2 > 0 && i2 < this.f19181a.h();
    }

    public final boolean o(sx4 sx4Var) {
        return n(ae3.c(sx4Var.c()), ae3.c(sx4Var.d()));
    }

    public final boolean p(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iG = g(aVar8, aVar5);
        return iG != 0 && g(aVar5, aVar6) == iG && g(aVar6, aVar7) == iG && g(aVar7, aVar8) == iG;
    }

    public final ht q(ht htVar, sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4) throws NotFoundException {
        od2 od2VarB = od2.b();
        int i = i();
        float f = i / 2.0f;
        int i2 = this.e;
        float f2 = f - i2;
        float f3 = f + i2;
        return od2VarB.c(htVar, i, i, f2, f2, f3, f2, f3, f3, f2, f3, sx4Var.c(), sx4Var.d(), sx4Var2.c(), sx4Var2.d(), sx4Var3.c(), sx4Var3.d(), sx4Var4.c(), sx4Var4.d());
    }

    public final int r(sx4 sx4Var, sx4 sx4Var2, int i) {
        float fC = c(sx4Var, sx4Var2);
        float f = fC / i;
        float fC2 = sx4Var.c();
        float fD = sx4Var.d();
        float fC3 = ((sx4Var2.c() - sx4Var.c()) * f) / fC;
        float fD2 = (f * (sx4Var2.d() - sx4Var.d())) / fC;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.f19181a.e(ae3.c((f2 * fC3) + fC2), ae3.c((f2 * fD2) + fD))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
