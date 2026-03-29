package com.opos.exoplayer.core.extractor.mp3;

import com.opos.exoplayer.core.extractor.j;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.extractor.mp3.Mp3Extractor;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class a implements Mp3Extractor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8195a;
    private final int b;
    private final long c;
    private final int d;
    private final long e;

    public a(long j, long j2, j jVar) {
        long jA;
        this.f8195a = j2;
        this.b = jVar.c;
        this.d = jVar.f;
        if (j == -1) {
            this.c = -1L;
            jA = -9223372036854775807L;
        } else {
            this.c = j - j2;
            jA = a(j);
        }
        this.e = jA;
    }

    @Override // com.opos.exoplayer.core.extractor.mp3.Mp3Extractor.b
    public long a(long j) {
        return ((Math.max(0L, j - this.f8195a) * 1000000) * 8) / ((long) this.d);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return this.c != -1;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        long j2 = this.c;
        if (j2 == -1) {
            return new l.a(new m(0L, this.f8195a));
        }
        long j3 = (((long) this.d) * j) / 8000000;
        long j4 = this.b;
        long jA = y.a((j3 / j4) * j4, 0L, j2 - j4);
        long j5 = this.f8195a + jA;
        long jA2 = a(j5);
        m mVar = new m(jA2, j5);
        if (jA2 < j) {
            long j6 = this.c;
            long j7 = this.b;
            if (jA != j6 - j7) {
                long j8 = j5 + j7;
                return new l.a(mVar, new m(a(j8), j8));
            }
        }
        return new l.a(mVar);
    }
}
