package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class yr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22253a = 0;
    public a b = a.NUMERIC;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f22253a;
    }

    public void b(int i) {
        this.f22253a += i;
    }

    public boolean c() {
        return this.b == a.ALPHA;
    }

    public boolean d() {
        return this.b == a.ISO_IEC_646;
    }

    public void e() {
        this.b = a.ALPHA;
    }

    public void f() {
        this.b = a.ISO_IEC_646;
    }

    public void g() {
        this.b = a.NUMERIC;
    }

    public void h(int i) {
        this.f22253a = i;
    }
}
