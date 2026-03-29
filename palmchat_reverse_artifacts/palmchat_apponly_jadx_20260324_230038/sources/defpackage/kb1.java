package defpackage;

import java.util.Formatter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ou f18614a;
    public final fe0[] b;

    public kb1(ou ouVar) {
        this.f18614a = new ou(ouVar);
        this.b = new fe0[(ouVar.f() - ouVar.h()) + 1];
    }

    public final ou a() {
        return this.f18614a;
    }

    public final fe0 b(int i) {
        return this.b[e(i)];
    }

    public final fe0 c(int i) {
        fe0 fe0Var;
        fe0 fe0Var2;
        fe0 fe0VarB = b(i);
        if (fe0VarB != null) {
            return fe0VarB;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iE = e(i) - i2;
            if (iE >= 0 && (fe0Var2 = this.b[iE]) != null) {
                return fe0Var2;
            }
            int iE2 = e(i) + i2;
            fe0[] fe0VarArr = this.b;
            if (iE2 < fe0VarArr.length && (fe0Var = fe0VarArr[iE2]) != null) {
                return fe0Var;
            }
        }
        return null;
    }

    public final fe0[] d() {
        return this.b;
    }

    public final int e(int i) {
        return i - this.f18614a.h();
    }

    public final void f(int i, fe0 fe0Var) {
        this.b[e(i)] = fe0Var;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i = 0;
        for (fe0 fe0Var : this.b) {
            if (fe0Var == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i));
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(fe0Var.c()), Integer.valueOf(fe0Var.e()));
                i++;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
