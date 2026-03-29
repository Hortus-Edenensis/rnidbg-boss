package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bt2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1814a = 0;
    public long b;
    public String c;
    public int d;
    public int e;
    public long f;
    public byte[] g;
    public long h;
    public long i;
    public boolean j;

    public bt2(long j, String str, int i, int i2, long j2, long j3, byte[] bArr) {
        this.b = j;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = j2;
        this.i = j3;
        this.g = bArr;
        if (j3 > 0) {
            this.j = true;
        }
    }

    public void a() {
        this.f1814a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.f1814a + ", requestId=" + this.b + ", sdkType='" + this.c + "', command=" + this.d + ", ver=" + this.e + ", rid=" + this.f + ", reqeustTime=" + this.h + ", timeout=" + this.i + '}';
    }
}
