package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class x82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w82 f21901a;
    public final int[] b;

    public x82(w82 w82Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f21901a = w82Var;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public x82 a(x82 x82Var) {
        if (!this.f21901a.equals(x82Var.f21901a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return x82Var;
        }
        if (x82Var.g()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = x82Var.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = w82.a(iArr2[i - length], iArr[i]);
        }
        return new x82(this.f21901a, iArr3);
    }

    public x82[] b(x82 x82Var) {
        if (!this.f21901a.equals(x82Var.f21901a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (x82Var.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        x82 x82VarG = this.f21901a.g();
        int iH = this.f21901a.h(x82Var.d(x82Var.f()));
        x82 x82VarA = this;
        while (x82VarA.f() >= x82Var.f() && !x82VarA.g()) {
            int iF = x82VarA.f() - x82Var.f();
            int iJ = this.f21901a.j(x82VarA.d(x82VarA.f()), iH);
            x82 x82VarJ = x82Var.j(iF, iJ);
            x82VarG = x82VarG.a(this.f21901a.b(iF, iJ));
            x82VarA = x82VarA.a(x82VarJ);
        }
        return new x82[]{x82VarG, x82VarA};
    }

    public int c(int i) {
        if (i == 0) {
            return d(0);
        }
        int[] iArr = this.b;
        int length = iArr.length;
        if (i != 1) {
            int iA = iArr[0];
            for (int i2 = 1; i2 < length; i2++) {
                iA = w82.a(this.f21901a.j(i, iA), this.b[i2]);
            }
            return iA;
        }
        int iA2 = 0;
        for (int i3 : iArr) {
            iA2 = w82.a(iA2, i3);
        }
        return iA2;
    }

    public int d(int i) {
        return this.b[(r0.length - 1) - i];
    }

    public int[] e() {
        return this.b;
    }

    public int f() {
        return this.b.length - 1;
    }

    public boolean g() {
        return this.b[0] == 0;
    }

    public x82 h(int i) {
        if (i == 0) {
            return this.f21901a.g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f21901a.j(this.b[i2], i);
        }
        return new x82(this.f21901a, iArr);
    }

    public x82 i(x82 x82Var) {
        if (!this.f21901a.equals(x82Var.f21901a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || x82Var.g()) {
            return this.f21901a.g();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = x82Var.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = w82.a(iArr3[i4], this.f21901a.j(i2, iArr2[i3]));
            }
        }
        return new x82(this.f21901a, iArr3);
    }

    public x82 j(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f21901a.g();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f21901a.j(this.b[i3], i2);
        }
        return new x82(this.f21901a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    sb.append(" - ");
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i = this.f21901a.i(iD);
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
