package defpackage;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class lk5 {
    public static final lk5 e = new lk5(wy5.b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19022a;
    public final wy5 b;
    public final int c;
    public final int d;

    public lk5(wy5 wy5Var, int i, int i2, int i3) {
        this.b = wy5Var;
        this.f19022a = i;
        this.c = i2;
        this.d = i3;
    }

    public lk5 a(int i) {
        wy5 wy5VarA = this.b;
        int i2 = this.f19022a;
        int i3 = this.d;
        if (i2 == 4 || i2 == 2) {
            int i4 = th2.c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            wy5VarA = wy5VarA.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.c;
        lk5 lk5Var = new lk5(wy5VarA, i2, i7 + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return lk5Var.c == 2078 ? lk5Var.b(i + 1) : lk5Var;
    }

    public lk5 b(int i) {
        int i2 = this.c;
        return i2 == 0 ? this : new lk5(this.b.b(i - i2, i2), this.f19022a, 0, this.d);
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.f19022a;
    }

    public boolean f(lk5 lk5Var) {
        int i;
        int i2 = this.d + (th2.c[this.f19022a][lk5Var.f19022a] >> 16);
        int i3 = lk5Var.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= lk5Var.d;
    }

    public lk5 g(int i, int i2) {
        int i3 = this.d;
        wy5 wy5VarA = this.b;
        int i4 = this.f19022a;
        if (i != i4) {
            int i5 = th2.c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            wy5VarA = wy5VarA.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new lk5(wy5VarA.a(i2, i8), i, 0, i3 + i8);
    }

    public lk5 h(int i, int i2) {
        wy5 wy5Var = this.b;
        int i3 = this.f19022a;
        int i4 = i3 == 2 ? 4 : 5;
        return new lk5(wy5Var.a(th2.e[i3][i], i4).a(i2, 5), this.f19022a, 0, this.d + i4 + 5);
    }

    public et i(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (wy5 wy5VarD = b(bArr.length).b; wy5VarD != null; wy5VarD = wy5VarD.d()) {
            linkedList.addFirst(wy5VarD);
        }
        et etVar = new et();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((wy5) it.next()).c(etVar, bArr);
        }
        return etVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", th2.b[this.f19022a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
