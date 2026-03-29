package defpackage;

import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ub3 extends l54.a {
    public static l54<ub3> e;
    public double c;
    public double d;

    static {
        l54<ub3> l54VarA = l54.a(64, new ub3(0.0d, 0.0d));
        e = l54VarA;
        l54VarA.g(0.5f);
    }

    public ub3(double d, double d2) {
        this.c = d;
        this.d = d2;
    }

    public static ub3 b(double d, double d2) {
        ub3 ub3Var = (ub3) e.b();
        ub3Var.c = d;
        ub3Var.d = d2;
        return ub3Var;
    }

    public static void c(ub3 ub3Var) {
        e.c(ub3Var);
    }

    @Override // l54.a
    public l54.a a() {
        return new ub3(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.c + ", y: " + this.d;
    }
}
