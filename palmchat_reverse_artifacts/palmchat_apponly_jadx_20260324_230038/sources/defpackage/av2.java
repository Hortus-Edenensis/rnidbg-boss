package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class av2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1577a;
    public int b;

    public av2() {
        this(0, 0);
    }

    public boolean a(int i) {
        return i >= c() && i <= d();
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f1577a;
    }

    public int d() {
        return (c() + b()) - 1;
    }

    public av2(int i, int i2) {
        this.f1577a = i;
        this.b = i2;
    }
}
