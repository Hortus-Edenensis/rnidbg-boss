package com.opos.exoplayer.core.extractor.c;

import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8178a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private long g;
    private long h;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f8178a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public long a(long j) {
        return (Math.max(0L, j - this.g) * 1000000) / ((long) this.c);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return ((this.h / ((long) this.d)) * 1000000) / ((long) this.b);
    }

    public boolean c() {
        return (this.g == 0 || this.h == 0) ? false : true;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.b * this.e * this.f8178a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f8178a;
    }

    public int h() {
        return this.f;
    }

    public void a(long j, long j2) {
        this.g = j;
        this.h = j2;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        long j2 = (((long) this.c) * j) / 1000000;
        long j3 = this.d;
        long jA = y.a((j2 / j3) * j3, 0L, this.h - j3);
        long j4 = this.g + jA;
        long jA2 = a(j4);
        m mVar = new m(jA2, j4);
        if (jA2 < j) {
            long j5 = this.h;
            long j6 = this.d;
            if (jA != j5 - j6) {
                long j7 = j4 + j6;
                return new l.a(mVar, new m(a(j7), j7));
            }
        }
        return new l.a(mVar);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return true;
    }
}
