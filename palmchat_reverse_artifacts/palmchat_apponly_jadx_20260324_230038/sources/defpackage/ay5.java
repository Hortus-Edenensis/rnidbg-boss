package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ay5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1609a;
    public long b;
    public boolean c;

    public boolean a() {
        return this.c;
    }

    public void b() {
        this.c = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f1609a;
        long j2 = jCurrentTimeMillis - j;
        if (j2 > 0 && j > 0) {
            this.b += j2;
        }
        this.f1609a = 0L;
    }

    public void c() {
        this.f1609a = System.currentTimeMillis();
        this.c = true;
    }

    public void d() {
        this.f1609a = 0L;
        this.b = 0L;
    }
}
