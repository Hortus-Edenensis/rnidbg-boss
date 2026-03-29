package com.bytedance.sdk.openadsdk.core.k;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static int b = 2;
    public static int fx = 1;
    public static int nr = 0;
    public static int pn = 3;
    public static int u = -1;
    private int iz = u;
    private long x = 0;
    private long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5291a = 0;
    private final List<iz> jk = new ArrayList();

    public void b(long j) {
        int i = this.iz;
        if (i == u || i != b) {
            return;
        }
        this.iz = fx;
        this.jk.add(new iz(this.n, j));
        this.n = 0L;
    }

    public void fx(long j) {
        int i;
        int i2 = this.iz;
        if (i2 == u || i2 == (i = b) || i2 == pn) {
            return;
        }
        this.iz = i;
        this.n = j;
    }

    public void nr(long j) {
        int i;
        int i2 = this.iz;
        if (i2 == u || i2 == (i = pn)) {
            return;
        }
        this.iz = i;
        this.f5291a = j;
    }

    public void u(long j) {
        this.iz = nr;
        this.x = j;
    }

    public long u(long j, long j2) {
        long j3;
        long j4;
        long jNr;
        long j5 = this.f5291a;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (iz izVar : this.jk) {
            if (izVar.nr() > j) {
                if (j < izVar.u()) {
                    j4 = i;
                    jNr = izVar.nr() - izVar.u();
                } else {
                    j4 = i;
                    jNr = izVar.nr() - j;
                }
                i = (int) (j4 + jNr);
            }
        }
        long j6 = this.x;
        if (j6 < j) {
            long j7 = this.n;
            if (j7 == 0) {
                j7 = this.f5291a;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.n;
        if (j8 == 0) {
            j8 = this.f5291a;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int u() {
        return this.iz;
    }
}
