package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class oa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19725a;
    public long b;
    public String c;
    public long d;
    public long e;

    public oa3() {
        this.c = "";
    }

    public long a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = jCurrentTimeMillis;
        long j = this.f19725a;
        if (j <= 0 || jCurrentTimeMillis <= j) {
            return 0L;
        }
        long j2 = jCurrentTimeMillis - j;
        this.e = j2;
        this.d += j2;
        this.f19725a = 0L;
        ma3.g("%s this:%s ms, total:%s ms", this.c, Long.valueOf(j2), Long.valueOf(this.d));
        return this.e;
    }

    public long b() {
        return this.d;
    }

    public void c() {
        this.f19725a = System.currentTimeMillis();
    }

    public oa3(String str) {
        this.c = str;
    }
}
