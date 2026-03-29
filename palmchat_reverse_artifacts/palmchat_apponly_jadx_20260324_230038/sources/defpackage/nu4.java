package defpackage;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nu4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w82 f19615a;

    public nu4(w82 w82Var) {
        this.f19615a = w82Var;
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        x82 x82Var = new x82(this.f19615a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            w82 w82Var = this.f19615a;
            int iC = x82Var.c(w82Var.c(w82Var.d() + i2));
            iArr2[(i - 1) - i2] = iC;
            if (iC != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        x82[] x82VarArrD = d(this.f19615a.b(i, 1), new x82(this.f19615a, iArr2), i);
        x82 x82Var2 = x82VarArrD[0];
        x82 x82Var3 = x82VarArrD[1];
        int[] iArrB = b(x82Var2);
        int[] iArrC = c(x82Var3, iArrB);
        for (int i3 = 0; i3 < iArrB.length; i3++) {
            int length = (iArr.length - 1) - this.f19615a.i(iArrB[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = w82.a(iArr[length], iArrC[i3]);
        }
    }

    public final int[] b(x82 x82Var) throws ReedSolomonException {
        int iF = x82Var.f();
        if (iF == 1) {
            return new int[]{x82Var.d(1)};
        }
        int[] iArr = new int[iF];
        int i = 0;
        for (int i2 = 1; i2 < this.f19615a.f() && i < iF; i2++) {
            if (x82Var.c(i2) == 0) {
                iArr[i] = this.f19615a.h(i2);
                i++;
            }
        }
        if (i == iF) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    public final int[] c(x82 x82Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iH = this.f19615a.h(iArr[i]);
            int iJ = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iJ2 = this.f19615a.j(iArr[i2], iH);
                    iJ = this.f19615a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i] = this.f19615a.j(x82Var.c(iH), this.f19615a.h(iJ));
            if (this.f19615a.d() != 0) {
                iArr2[i] = this.f19615a.j(iArr2[i], iH);
            }
        }
        return iArr2;
    }

    public final x82[] d(x82 x82Var, x82 x82Var2, int i) throws ReedSolomonException {
        if (x82Var.f() < x82Var2.f()) {
            x82Var2 = x82Var;
            x82Var = x82Var2;
        }
        x82 x82VarG = this.f19615a.g();
        x82 x82VarE = this.f19615a.e();
        do {
            x82 x82Var3 = x82Var2;
            x82Var2 = x82Var;
            x82Var = x82Var3;
            x82 x82Var4 = x82VarE;
            x82 x82Var5 = x82VarG;
            x82VarG = x82Var4;
            if (x82Var.f() < i / 2) {
                int iD = x82VarG.d(0);
                if (iD == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iH = this.f19615a.h(iD);
                return new x82[]{x82VarG.h(iH), x82Var.h(iH)};
            }
            if (x82Var.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            x82 x82VarG2 = this.f19615a.g();
            int iH2 = this.f19615a.h(x82Var.d(x82Var.f()));
            while (x82Var2.f() >= x82Var.f() && !x82Var2.g()) {
                int iF = x82Var2.f() - x82Var.f();
                int iJ = this.f19615a.j(x82Var2.d(x82Var2.f()), iH2);
                x82VarG2 = x82VarG2.a(this.f19615a.b(iF, iJ));
                x82Var2 = x82Var2.a(x82Var.j(iF, iJ));
            }
            x82VarE = x82VarG2.i(x82VarG).a(x82Var5);
        } while (x82Var2.f() < x82Var.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }
}
