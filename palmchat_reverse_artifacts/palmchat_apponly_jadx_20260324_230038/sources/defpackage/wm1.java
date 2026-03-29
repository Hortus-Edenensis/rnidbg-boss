package defpackage;

import com.google.zxing.ChecksumException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class wm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iq3 f21750a = iq3.f;

    public int a(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        jq3 jq3Var = new jq3(this.f21750a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = jq3Var.b(this.f21750a.c(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        jq3 jq3VarD = this.f21750a.d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iC = this.f21750a.c((iArr.length - 1) - i3);
                iq3 iq3Var = this.f21750a;
                jq3VarD = jq3VarD.g(new jq3(iq3Var, new int[]{iq3Var.j(0, iC), 1}));
            }
        }
        jq3[] jq3VarArrD = d(this.f21750a.b(i, 1), new jq3(this.f21750a, iArr3), i);
        jq3 jq3Var2 = jq3VarArrD[0];
        jq3 jq3Var3 = jq3VarArrD[1];
        int[] iArrB = b(jq3Var2);
        int[] iArrC = c(jq3Var3, jq3Var2, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.f21750a.h(iArrB[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f21750a.j(iArr[length], iArrC[i4]);
        }
        return iArrB.length;
    }

    public final int[] b(jq3 jq3Var) throws ChecksumException {
        int iD = jq3Var.d();
        int[] iArr = new int[iD];
        int i = 0;
        for (int i2 = 1; i2 < this.f21750a.e() && i < iD; i2++) {
            if (jq3Var.b(i2) == 0) {
                iArr[i] = this.f21750a.g(i2);
                i++;
            }
        }
        if (i == iD) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    public final int[] c(jq3 jq3Var, jq3 jq3Var2, int[] iArr) {
        int iD = jq3Var2.d();
        int[] iArr2 = new int[iD];
        for (int i = 1; i <= iD; i++) {
            iArr2[iD - i] = this.f21750a.i(i, jq3Var2.c(i));
        }
        jq3 jq3Var3 = new jq3(this.f21750a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iG = this.f21750a.g(iArr[i2]);
            iArr3[i2] = this.f21750a.i(this.f21750a.j(0, jq3Var.b(iG)), this.f21750a.g(jq3Var3.b(iG)));
        }
        return iArr3;
    }

    public final jq3[] d(jq3 jq3Var, jq3 jq3Var2, int i) throws ChecksumException {
        if (jq3Var.d() < jq3Var2.d()) {
            jq3Var2 = jq3Var;
            jq3Var = jq3Var2;
        }
        jq3 jq3VarF = this.f21750a.f();
        jq3 jq3VarD = this.f21750a.d();
        while (true) {
            jq3 jq3Var3 = jq3Var2;
            jq3Var2 = jq3Var;
            jq3Var = jq3Var3;
            jq3 jq3Var4 = jq3VarD;
            jq3 jq3Var5 = jq3VarF;
            jq3VarF = jq3Var4;
            if (jq3Var.d() < i / 2) {
                int iC = jq3VarF.c(0);
                if (iC == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int iG = this.f21750a.g(iC);
                return new jq3[]{jq3VarF.f(iG), jq3Var.f(iG)};
            }
            if (jq3Var.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            jq3 jq3VarF2 = this.f21750a.f();
            int iG2 = this.f21750a.g(jq3Var.c(jq3Var.d()));
            while (jq3Var2.d() >= jq3Var.d() && !jq3Var2.e()) {
                int iD = jq3Var2.d() - jq3Var.d();
                int i2 = this.f21750a.i(jq3Var2.c(jq3Var2.d()), iG2);
                jq3VarF2 = jq3VarF2.a(this.f21750a.b(iD, i2));
                jq3Var2 = jq3Var2.j(jq3Var.h(iD, i2));
            }
            jq3VarD = jq3VarF2.g(jq3VarF).j(jq3Var5).i();
        }
    }
}
