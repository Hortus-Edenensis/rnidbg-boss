package defpackage;

import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class at1 extends l54.a {
    public static l54<at1> e;
    public float c;
    public float d;

    static {
        l54<at1> l54VarA = l54.a(256, new at1(0.0f, 0.0f));
        e = l54VarA;
        l54VarA.g(0.5f);
    }

    public at1() {
    }

    public static at1 b(float f, float f2) {
        at1 at1Var = (at1) e.b();
        at1Var.c = f;
        at1Var.d = f2;
        return at1Var;
    }

    public static void c(at1 at1Var) {
        e.c(at1Var);
    }

    @Override // l54.a
    public l54.a a() {
        return new at1(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof at1)) {
            return false;
        }
        at1 at1Var = (at1) obj;
        return this.c == at1Var.c && this.d == at1Var.d;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.c) ^ Float.floatToIntBits(this.d);
    }

    public String toString() {
        return this.c + "x" + this.d;
    }

    public at1(float f, float f2) {
        this.c = f;
        this.d = f2;
    }
}
