package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class gc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17711a;
    public long b;

    public gc7(String str, long j) {
        this.f17711a = str;
        this.b = j;
    }

    public boolean a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        if (jCurrentTimeMillis >= j) {
            be7.a("invalid");
            return false;
        }
        if (Math.abs(j - jCurrentTimeMillis) <= lx6.j(str)) {
            return true;
        }
        be7.a("invalid");
        return false;
    }
}
