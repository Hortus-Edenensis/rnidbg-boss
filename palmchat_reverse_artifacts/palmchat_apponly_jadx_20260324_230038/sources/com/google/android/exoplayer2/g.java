package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.p;
import defpackage.g86;
import defpackage.n73;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class g implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5875a;
    public final float b;
    public final long c;
    public final float d;
    public final long e;
    public final long f;
    public final float g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public float n;
    public float o;
    public float p;
    public long q;
    public long r;
    public long s;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f5876a = 0.97f;
        public float b = 1.03f;
        public long c = 1000;
        public float d = 1.0E-7f;
        public long e = g86.H0(20);
        public long f = g86.H0(500);
        public float g = 0.999f;

        public g a() {
            return new g(this.f5876a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    public static long d(long j, long j2, float f) {
        return (long) ((j * f) + ((1.0f - f) * j2));
    }

    @Override // com.google.android.exoplayer2.o
    public void a(p.g gVar) {
        this.h = g86.H0(gVar.f5918a);
        this.k = g86.H0(gVar.b);
        this.l = g86.H0(gVar.c);
        float f = gVar.d;
        if (f == -3.4028235E38f) {
            f = this.f5875a;
        }
        this.o = f;
        float f2 = gVar.e;
        if (f2 == -3.4028235E38f) {
            f2 = this.b;
        }
        this.n = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.h = -9223372036854775807L;
        }
        c();
    }

    public final void b(long j) {
        long j2 = this.r + (this.s * 3);
        if (this.m > j2) {
            float fH0 = g86.H0(this.c);
            this.m = n73.j(j2, this.j, this.m - (((long) ((this.p - 1.0f) * fH0)) + ((long) ((this.n - 1.0f) * fH0))));
            return;
        }
        long jR = g86.r(j - ((long) (Math.max(0.0f, this.p - 1.0f) / this.d)), this.m, j2);
        this.m = jR;
        long j3 = this.l;
        if (j3 == -9223372036854775807L || jR <= j3) {
            return;
        }
        this.m = j3;
    }

    public final void c() {
        long j = this.h;
        if (j != -9223372036854775807L) {
            long j2 = this.i;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.k;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.l;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.j == j) {
            return;
        }
        this.j = j;
        this.m = j;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.q = -9223372036854775807L;
    }

    public final void e(long j, long j2) {
        long j3 = j - j2;
        long j4 = this.r;
        if (j4 == -9223372036854775807L) {
            this.r = j3;
            this.s = 0L;
        } else {
            long jMax = Math.max(j3, d(j4, j3, this.g));
            this.r = jMax;
            this.s = d(this.s, Math.abs(j3 - jMax), this.g);
        }
    }

    @Override // com.google.android.exoplayer2.o
    public float getAdjustedPlaybackSpeed(long j, long j2) {
        if (this.h == -9223372036854775807L) {
            return 1.0f;
        }
        e(j, j2);
        if (this.q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.q < this.c) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        b(j);
        long j3 = j - this.m;
        if (Math.abs(j3) < this.e) {
            this.p = 1.0f;
        } else {
            this.p = g86.p((this.d * j3) + 1.0f, this.o, this.n);
        }
        return this.p;
    }

    @Override // com.google.android.exoplayer2.o
    public long getTargetLiveOffsetUs() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.o
    public void notifyRebuffer() {
        long j = this.m;
        if (j == -9223372036854775807L) {
            return;
        }
        long j2 = j + this.f;
        this.m = j2;
        long j3 = this.l;
        if (j3 != -9223372036854775807L && j2 > j3) {
            this.m = j3;
        }
        this.q = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.o
    public void setTargetLiveOffsetOverrideUs(long j) {
        this.i = j;
        c();
    }

    public g(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.f5875a = f;
        this.b = f2;
        this.c = j;
        this.d = f3;
        this.e = j2;
        this.f = j3;
        this.g = f4;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.o = f;
        this.n = f2;
        this.p = 1.0f;
        this.q = -9223372036854775807L;
        this.j = -9223372036854775807L;
        this.m = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
    }
}
