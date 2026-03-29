package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ku0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18830a;
    public final int b;

    public ku0(int i, int i2) {
        this.f18830a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f18830a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ku0)) {
            return false;
        }
        ku0 ku0Var = (ku0) obj;
        return this.f18830a == ku0Var.f18830a && this.b == ku0Var.b;
    }

    public final int hashCode() {
        return this.f18830a ^ this.b;
    }

    public final String toString() {
        return this.f18830a + "(" + this.b + ')';
    }
}
