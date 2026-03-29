package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class cu2 implements du2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16917a;
    public int b;

    public int a() {
        return (this.b - this.f16917a) + 1;
    }

    @Override // defpackage.du2
    public int a0() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof du2)) {
            return -1;
        }
        du2 du2Var = (du2) obj;
        int start = this.f16917a - du2Var.getStart();
        return start != 0 ? start : this.b - du2Var.a0();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof du2)) {
            return false;
        }
        du2 du2Var = (du2) obj;
        return this.f16917a == du2Var.getStart() && this.b == du2Var.a0();
    }

    @Override // defpackage.du2
    public int getStart() {
        return this.f16917a;
    }

    public int hashCode() {
        return (this.f16917a % 100) + (this.b % 100);
    }

    public String toString() {
        return this.f16917a + ":" + this.b;
    }
}
