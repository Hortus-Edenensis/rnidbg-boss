package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class eu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17365a;
    public String b;
    public String c;
    public int d;

    public eu6(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.f17365a = j;
    }

    public void c(String str) {
        this.b = str;
    }

    public boolean d() {
        return this.f17365a > System.currentTimeMillis();
    }

    public void e() {
        this.f17365a = 0L;
    }
}
