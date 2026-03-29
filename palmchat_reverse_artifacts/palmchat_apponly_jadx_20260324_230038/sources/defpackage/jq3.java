package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class jq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iq3 f18479a;
    public final int[] b;

    public jq3(iq3 iq3Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f18479a = iq3Var;
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

    public jq3 a(jq3 jq3Var) {
        if (!this.f18479a.equals(jq3Var.f18479a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return jq3Var;
        }
        if (jq3Var.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = jq3Var.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.f18479a.a(iArr2[i - length], iArr[i]);
        }
        return new jq3(this.f18479a, iArr3);
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        int[] iArr = this.b;
        int length = iArr.length;
        if (i != 1) {
            int iA = iArr[0];
            for (int i2 = 1; i2 < length; i2++) {
                iq3 iq3Var = this.f18479a;
                iA = iq3Var.a(iq3Var.i(i, iA), this.b[i2]);
            }
            return iA;
        }
        int iA2 = 0;
        for (int i3 : iArr) {
            iA2 = this.f18479a.a(iA2, i3);
        }
        return iA2;
    }

    public int c(int i) {
        return this.b[(r0.length - 1) - i];
    }

    public int d() {
        return this.b.length - 1;
    }

    public boolean e() {
        return this.b[0] == 0;
    }

    public jq3 f(int i) {
        if (i == 0) {
            return this.f18479a.f();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f18479a.i(this.b[i2], i);
        }
        return new jq3(this.f18479a, iArr);
    }

    public jq3 g(jq3 jq3Var) {
        if (!this.f18479a.equals(jq3Var.f18479a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || jq3Var.e()) {
            return this.f18479a.f();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = jq3Var.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iq3 iq3Var = this.f18479a;
                iArr3[i4] = iq3Var.a(iArr3[i4], iq3Var.i(i2, iArr2[i3]));
            }
        }
        return new jq3(this.f18479a, iArr3);
    }

    public jq3 h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f18479a.f();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f18479a.i(this.b[i3], i2);
        }
        return new jq3(this.f18479a, iArr);
    }

    public jq3 i() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f18479a.j(0, this.b[i]);
        }
        return new jq3(this.f18479a, iArr);
    }

    public jq3 j(jq3 jq3Var) {
        if (this.f18479a.equals(jq3Var.f18479a)) {
            return jq3Var.e() ? this : a(jq3Var.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
