package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class cm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2016a;
    public int b;
    public long c;
    public int d;

    public cm0() {
        this.b = 1;
        this.d = -1;
    }

    public long a() {
        return this.c;
    }

    public String b() {
        return this.f2016a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public void e(long j) {
        this.c = j;
    }

    public void f(String str) {
        this.f2016a = str;
    }

    public void g(int i) {
        this.b = i;
    }

    public void h(int i) {
        this.d = i;
    }

    public cm0(String str, int i, long j, int i2) {
        this.f2016a = str;
        this.b = i;
        this.c = j;
        this.d = i2;
    }

    public cm0(String str, int i, long j) {
        this(str, i, j, -1);
    }
}
