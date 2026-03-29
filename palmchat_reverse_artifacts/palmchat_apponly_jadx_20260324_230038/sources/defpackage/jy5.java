package defpackage;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.media3.common.util.TimestampAdjuster;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public long f18534a;

    @GuardedBy("this")
    public long b;

    @GuardedBy("this")
    public long c;
    public final ThreadLocal<Long> d = new ThreadLocal<>();

    public jy5(long j) {
        h(j);
    }

    public static long g(long j) {
        return (j * 1000000) / 90000;
    }

    public static long j(long j) {
        return (j * 90000) / 1000000;
    }

    public static long k(long j) {
        return j(j) % 8589934592L;
    }

    public synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (!f()) {
            long jLongValue = this.f18534a;
            if (jLongValue == TimestampAdjuster.MODE_SHARED) {
                jLongValue = ((Long) vh.e(this.d.get())).longValue();
            }
            this.b = jLongValue - j;
            notifyAll();
        }
        this.c = j;
        return j + this.b;
    }

    public synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.c;
        if (j2 != -9223372036854775807L) {
            long j3 = j(j2);
            long j4 = (4294967296L + j3) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j;
            j += j4 * 8589934592L;
            if (Math.abs(j5 - j3) < Math.abs(j - j3)) {
                j = j5;
            }
        }
        return a(g(j));
    }

    public synchronized long c() {
        long j;
        j = this.f18534a;
        if (j == Long.MAX_VALUE || j == TimestampAdjuster.MODE_SHARED) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long d() {
        long j;
        j = this.c;
        return j != -9223372036854775807L ? j + this.b : c();
    }

    public synchronized long e() {
        return this.b;
    }

    public synchronized boolean f() {
        return this.b != -9223372036854775807L;
    }

    public synchronized void h(long j) {
        this.f18534a = j;
        this.b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public synchronized void i(boolean z, long j, long j2) throws InterruptedException, TimeoutException {
        vh.g(this.f18534a == TimestampAdjuster.MODE_SHARED);
        if (f()) {
            return;
        }
        if (z) {
            this.d.set(Long.valueOf(j));
        } else {
            long jElapsedRealtime = 0;
            long j3 = j2;
            while (!f()) {
                if (j2 == 0) {
                    wait();
                } else {
                    vh.g(j3 > 0);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    wait(j3);
                    jElapsedRealtime += SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (jElapsedRealtime >= j2 && !f()) {
                        throw new TimeoutException("TimestampAdjuster failed to initialize in " + j2 + " milliseconds");
                    }
                    j3 = j2 - jElapsedRealtime;
                }
            }
        }
    }
}
