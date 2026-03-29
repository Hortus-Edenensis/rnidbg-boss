package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class pb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f19985a;
    public tx4 b;

    public pb1(ht htVar) {
        this.f19985a = htVar;
    }

    public static int c(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, float f) throws NotFoundException {
        int iC = ((ae3.c(sx4.b(sx4Var, sx4Var2) / f) + ae3.c(sx4.b(sx4Var, sx4Var3) / f)) / 2) + 7;
        int i = iC & 3;
        if (i == 0) {
            return iC + 1;
        }
        if (i == 2) {
            return iC - 1;
        }
        if (i != 3) {
            return iC;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static oh4 d(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4, int i) {
        float fC;
        float fD;
        float f;
        float f2 = i - 3.5f;
        if (sx4Var4 != null) {
            fC = sx4Var4.c();
            fD = sx4Var4.d();
            f = f2 - 3.0f;
        } else {
            fC = (sx4Var2.c() - sx4Var.c()) + sx4Var3.c();
            fD = (sx4Var2.d() - sx4Var.d()) + sx4Var3.d();
            f = f2;
        }
        return oh4.b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, sx4Var.c(), sx4Var.d(), sx4Var2.c(), sx4Var2.d(), fC, fD, sx4Var3.c(), sx4Var3.d());
    }

    public static ht h(ht htVar, oh4 oh4Var, int i) throws NotFoundException {
        return od2.b().d(htVar, i, i, oh4Var);
    }

    public final float a(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3) {
        return (b(sx4Var, sx4Var2) + b(sx4Var, sx4Var3)) / 2.0f;
    }

    public final float b(sx4 sx4Var, sx4 sx4Var2) {
        float fJ = j((int) sx4Var.c(), (int) sx4Var.d(), (int) sx4Var2.c(), (int) sx4Var2.d());
        float fJ2 = j((int) sx4Var2.c(), (int) sx4Var2.d(), (int) sx4Var.c(), (int) sx4Var.d());
        return Float.isNaN(fJ) ? fJ2 / 7.0f : Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    public final qb1 e(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        tx4 tx4Var = map == null ? null : (tx4) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.b = tx4Var;
        return g(new vw1(this.f19985a, tx4Var).e(map));
    }

    public final m9 f(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f19985a.k() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f19985a.h() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new n9(this.f19985a, iMax, iMax2, iMin, iMin2, f, this.b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final qb1 g(ww1 ww1Var) throws NotFoundException, FormatException {
        m9 m9VarF;
        tw1 tw1VarB = ww1Var.b();
        tw1 tw1VarC = ww1Var.c();
        tw1 tw1VarA = ww1Var.a();
        float fA = a(tw1VarB, tw1VarC, tw1VarA);
        if (fA < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(tw1VarB, tw1VarC, tw1VarA, fA);
        t96 t96VarG = t96.g(iC);
        int iE = t96VarG.e() - 7;
        if (t96VarG.d().length > 0) {
            float fC = (tw1VarC.c() - tw1VarB.c()) + tw1VarA.c();
            float fD = (tw1VarC.d() - tw1VarB.d()) + tw1VarA.d();
            float f = 1.0f - (3.0f / iE);
            int iC2 = (int) (tw1VarB.c() + ((fC - tw1VarB.c()) * f));
            int iD = (int) (tw1VarB.d() + (f * (fD - tw1VarB.d())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    m9VarF = f(fA, iC2, iD, i);
                    break;
                } catch (NotFoundException unused) {
                }
            }
            m9VarF = null;
        } else {
            m9VarF = null;
        }
        return new qb1(h(this.f19985a, d(tw1VarB, tw1VarC, tw1VarA, m9VarF, iC), iC), m9VarF == null ? new sx4[]{tw1VarA, tw1VarB, tw1VarC} : new sx4[]{tw1VarA, tw1VarB, tw1VarC, m9VarF});
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r15 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        return defpackage.ae3.b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float i(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        pb1 pb1Var;
        boolean z;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = (-iAbs) / 2;
        int i12 = i5 < i7 ? 1 : -1;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 + i12;
        int i15 = i5;
        int i16 = i6;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z3 ? i16 : i15;
            int i19 = z3 ? i15 : i16;
            if (i17 == i10) {
                pb1Var = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                pb1Var = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == pb1Var.f19985a.e(i18, i19)) {
                if (i17 == 2) {
                    return ae3.b(i15, i16, i5, i6);
                }
                i17++;
            }
            i11 += iAbs2;
            if (i11 > 0) {
                if (i16 == i8) {
                    break;
                }
                i16 += i13;
                i11 -= iAbs;
            }
            i15 += i12;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
    }

    public final float j(int i, int i2, int i3, int i4) {
        float fK;
        float fH;
        float fI = i(i, i2, i3, i4);
        int iK = i - (i3 - i);
        int iH = 0;
        if (iK < 0) {
            fK = i / (i - iK);
            iK = 0;
        } else if (iK >= this.f19985a.k()) {
            fK = ((this.f19985a.k() - 1) - i) / (iK - i);
            iK = this.f19985a.k() - 1;
        } else {
            fK = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fK));
        if (i5 < 0) {
            fH = f / (i2 - i5);
        } else if (i5 >= this.f19985a.h()) {
            fH = ((this.f19985a.h() - 1) - i2) / (i5 - i2);
            iH = this.f19985a.h() - 1;
        } else {
            iH = i5;
            fH = 1.0f;
        }
        return (fI + i(i, i2, (int) (i + ((iK - i) * fH)), iH)) - 1.0f;
    }
}
