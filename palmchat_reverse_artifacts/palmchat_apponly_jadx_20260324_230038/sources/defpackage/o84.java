package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class o84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19712a;
    public String b;
    public String c;
    public int d;

    public o84(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.f19712a = j;
    }

    public void c(String str) {
        this.b = str;
    }

    public boolean d() {
        return this.f19712a > System.currentTimeMillis();
    }

    public void e() {
        this.f19712a = 0L;
    }
}
