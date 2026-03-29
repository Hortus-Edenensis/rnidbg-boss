package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19974a;
    public long b;
    public String c;
    public long d;
    public long e;

    public pa3(String str) {
        this.c = str;
    }

    public long a() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.b = jUptimeMillis;
        long j = this.f19974a;
        if (j <= 0 || jUptimeMillis <= j) {
            return 0L;
        }
        long j2 = jUptimeMillis - j;
        this.e = j2;
        this.d += j2;
        this.f19974a = 0L;
        ma3.g("%s this:%s ms, total:%s ms", this.c, Long.valueOf(j2), Long.valueOf(this.d));
        return this.e;
    }

    public long b() {
        return this.d;
    }

    public void c() {
        this.f19974a = SystemClock.uptimeMillis();
    }
}
