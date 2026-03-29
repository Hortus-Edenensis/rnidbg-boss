package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20212a;
    public long b;
    public String c;
    public long d;
    public long e;

    public qa3(String str) {
        this.c = str;
    }

    public long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.b = jElapsedRealtime;
        long j = this.f20212a;
        if (j <= 0 || jElapsedRealtime <= j) {
            return 0L;
        }
        long j2 = jElapsedRealtime - j;
        this.e = j2;
        this.d += j2;
        this.f20212a = 0L;
        ma3.g("%s this:%s ms, total:%s ms", this.c, Long.valueOf(j2), Long.valueOf(this.d));
        return this.e;
    }

    public long b() {
        return this.d;
    }

    public void c() {
        this.f20212a = SystemClock.elapsedRealtime();
    }
}
