package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class pk6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f20035a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public pk6(ht htVar) throws NotFoundException {
        this(htVar, 10, htVar.k() / 2, htVar.h() / 2);
    }

    public final sx4[] a(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4) {
        float fC = sx4Var.c();
        float fD = sx4Var.d();
        float fC2 = sx4Var2.c();
        float fD2 = sx4Var2.d();
        float fC3 = sx4Var3.c();
        float fD3 = sx4Var3.d();
        float fC4 = sx4Var4.c();
        float fD4 = sx4Var4.d();
        return fC < ((float) this.c) / 2.0f ? new sx4[]{new sx4(fC4 - 1.0f, fD4 + 1.0f), new sx4(fC2 + 1.0f, fD2 + 1.0f), new sx4(fC3 - 1.0f, fD3 - 1.0f), new sx4(fC + 1.0f, fD - 1.0f)} : new sx4[]{new sx4(fC4 + 1.0f, fD4 + 1.0f), new sx4(fC2 + 1.0f, fD2 - 1.0f), new sx4(fC3 - 1.0f, fD3 + 1.0f), new sx4(fC - 1.0f, fD - 1.0f)};
    }

    public final boolean b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f20035a.e(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f20035a.e(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public sx4[] c() throws NotFoundException {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (z2) {
            boolean zB = true;
            boolean z8 = false;
            while (true) {
                if ((!zB && z3) || i2 >= this.c) {
                    break;
                }
                zB = b(i3, i4, i2, false);
                if (zB) {
                    i2++;
                    z3 = true;
                    z8 = true;
                } else if (!z3) {
                    i2++;
                }
            }
            if (i2 < this.c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z4) || i4 >= this.b) {
                        break;
                    }
                    zB2 = b(i, i2, i4, true);
                    if (zB2) {
                        i4++;
                        z4 = true;
                        z8 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
                if (i4 < this.b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z5) || i < 0) {
                            break;
                        }
                        zB3 = b(i3, i4, i, false);
                        if (zB3) {
                            i--;
                            z5 = true;
                            z8 = true;
                        } else if (!z5) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z2 = z8;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z7) || i3 < 0) {
                                break;
                            }
                            zB4 = b(i, i2, i3, true);
                            if (zB4) {
                                i3--;
                                z2 = true;
                                z7 = true;
                            } else if (!z7) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                            if (z2) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        sx4 sx4VarD = null;
        sx4 sx4VarD2 = null;
        for (int i6 = 1; i6 < i5; i6++) {
            sx4VarD2 = d(i, i4 - i6, i + i6, i4);
            if (sx4VarD2 != null) {
                break;
            }
        }
        if (sx4VarD2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        sx4 sx4VarD3 = null;
        for (int i7 = 1; i7 < i5; i7++) {
            sx4VarD3 = d(i, i3 + i7, i + i7, i3);
            if (sx4VarD3 != null) {
                break;
            }
        }
        if (sx4VarD3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        sx4 sx4VarD4 = null;
        for (int i8 = 1; i8 < i5; i8++) {
            sx4VarD4 = d(i2, i3 + i8, i2 - i8, i3);
            if (sx4VarD4 != null) {
                break;
            }
        }
        if (sx4VarD4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i9 = 1; i9 < i5; i9++) {
            sx4VarD = d(i2, i4 - i9, i2 - i9, i4);
            if (sx4VarD != null) {
                break;
            }
        }
        if (sx4VarD != null) {
            return a(sx4VarD, sx4VarD2, sx4VarD4, sx4VarD3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final sx4 d(float f, float f2, float f3, float f4) {
        int iC = ae3.c(ae3.a(f, f2, f3, f4));
        float f5 = iC;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iC; i++) {
            float f8 = i;
            int iC2 = ae3.c((f8 * f6) + f);
            int iC3 = ae3.c((f8 * f7) + f2);
            if (this.f20035a.e(iC2, iC3)) {
                return new sx4(iC2, iC3);
            }
        }
        return null;
    }

    public pk6(ht htVar, int i, int i2, int i3) throws NotFoundException {
        this.f20035a = htVar;
        int iH = htVar.h();
        this.b = iH;
        int iK = htVar.k();
        this.c = iK;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iH || i6 >= iK) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
