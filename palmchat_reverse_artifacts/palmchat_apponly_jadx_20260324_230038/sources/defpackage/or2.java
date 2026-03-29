package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class or2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19817a;
    public final int b;

    public or2(int i, int i2) {
        this.f19817a = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f19817a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f19817a);
        sb.append("x");
        sb.append(this.b);
        return sb.toString();
    }
}
