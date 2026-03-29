package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class gd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17713a;
    public final int b;

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f17713a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof gd1) {
            gd1 gd1Var = (gd1) obj;
            if (this.f17713a == gd1Var.f17713a && this.b == gd1Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f17713a * 32713) + this.b;
    }

    public String toString() {
        return this.f17713a + "x" + this.b;
    }
}
