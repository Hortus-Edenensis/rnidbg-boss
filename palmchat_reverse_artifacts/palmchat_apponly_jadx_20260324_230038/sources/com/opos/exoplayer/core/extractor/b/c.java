package com.opos.exoplayer.core.extractor.b;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f8164a = new f();
    private final long b;
    private final long c;
    private final i d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements l {
        private b() {
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public long b() {
            return c.this.d.a(c.this.f);
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public l.a b(long j) {
            if (j == 0) {
                return new l.a(new m(0L, c.this.b));
            }
            long jB = c.this.d.b(j);
            c cVar = c.this;
            return new l.a(new m(j, cVar.a(cVar.b, jB, 30000L)));
        }
    }

    public c(long j, long j2, i iVar, int i, long j3) {
        com.opos.exoplayer.core.util.a.a(j >= 0 && j2 > j);
        this.d = iVar;
        this.b = j;
        this.c = j2;
        if (i != j2 - j) {
            this.e = 0;
        } else {
            this.f = j3;
            this.e = 3;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.b.g
    public long a(long j) {
        int i = this.e;
        com.opos.exoplayer.core.util.a.a(i == 3 || i == 2);
        this.h = j != 0 ? this.d.b(j) : 0L;
        this.e = 2;
        b();
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j, long j2, long j3) {
        long j4 = this.c;
        long j5 = this.b;
        long j6 = j + (((j2 * (j4 - j5)) / this.f) - j3);
        if (j6 >= j5) {
            j5 = j6;
        }
        return j5 >= j4 ? j4 - 1 : j5;
    }

    public void b() {
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    public long c(com.opos.exoplayer.core.extractor.f fVar) throws com.opos.exoplayer.core.m, EOFException {
        b(fVar);
        this.f8164a.a();
        while ((this.f8164a.b & 4) != 4 && fVar.c() < this.c) {
            this.f8164a.a(fVar, false);
            f fVar2 = this.f8164a;
            fVar.b(fVar2.e + fVar2.f);
        }
        return this.f8164a.c;
    }

    public long a(long j, com.opos.exoplayer.core.extractor.f fVar) throws IOException {
        if (this.i == this.j) {
            return -(this.k + 2);
        }
        long jC = fVar.c();
        if (!a(fVar, this.j)) {
            long j2 = this.i;
            if (j2 != jC) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f8164a.a(fVar, false);
        fVar.a();
        f fVar2 = this.f8164a;
        long j3 = fVar2.c;
        long j4 = j - j3;
        int i = fVar2.e + fVar2.f;
        if (j4 >= 0 && j4 <= 72000) {
            fVar.b(i);
            return -(this.f8164a.c + 2);
        }
        if (j4 < 0) {
            this.j = jC;
            this.l = j3;
        } else {
            long j5 = i;
            long jC2 = fVar.c() + j5;
            this.i = jC2;
            this.k = this.f8164a.c;
            if ((this.j - jC2) + j5 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                fVar.b(i);
                return -(this.k + 2);
            }
        }
        long j6 = this.j;
        long j7 = this.i;
        if (j6 - j7 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
            this.j = j7;
            return j7;
        }
        long jC3 = fVar.c() - (((long) i) * (j4 > 0 ? 1L : 2L));
        long j8 = this.j;
        long j9 = this.i;
        return Math.min(Math.max(jC3 + ((j4 * (j8 - j9)) / (this.l - this.k)), j9), this.j - 1);
    }

    public void b(com.opos.exoplayer.core.extractor.f fVar) throws EOFException {
        if (!a(fVar, this.c)) {
            throw new EOFException();
        }
    }

    @Override // com.opos.exoplayer.core.extractor.b.g
    public long a(com.opos.exoplayer.core.extractor.f fVar) throws IOException {
        int i = this.e;
        if (i == 0) {
            long jC = fVar.c();
            this.g = jC;
            this.e = 1;
            long j = this.c - 65307;
            if (j > jC) {
                return j;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j2 = this.h;
            long jA = 0;
            if (j2 != 0) {
                long jA2 = a(j2, fVar);
                if (jA2 >= 0) {
                    return jA2;
                }
                jA = a(fVar, this.h, -(jA2 + 2));
            }
            this.e = 3;
            return -(jA + 2);
        }
        this.f = c(fVar);
        this.e = 3;
        return this.g;
    }

    public long a(com.opos.exoplayer.core.extractor.f fVar, long j, long j2) throws com.opos.exoplayer.core.m, EOFException {
        this.f8164a.a(fVar, false);
        while (true) {
            f fVar2 = this.f8164a;
            if (fVar2.c >= j) {
                fVar.a();
                return j2;
            }
            fVar.b(fVar2.e + fVar2.f);
            f fVar3 = this.f8164a;
            long j3 = fVar3.c;
            fVar3.a(fVar, false);
            j2 = j3;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b c() {
        if (this.f != 0) {
            return new b();
        }
        return null;
    }

    public boolean a(com.opos.exoplayer.core.extractor.f fVar, long j) {
        int i;
        long jMin = Math.min(j + 3, this.c);
        int iC = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i2 = 0;
            if (fVar.c() + ((long) iC) > jMin && (iC = (int) (jMin - fVar.c())) < 4) {
                return false;
            }
            fVar.b(bArr, 0, iC, false);
            while (true) {
                i = iC - 3;
                if (i2 < i) {
                    if (bArr[i2] == 79 && bArr[i2 + 1] == 103 && bArr[i2 + 2] == 103 && bArr[i2 + 3] == 83) {
                        fVar.b(i2);
                        return true;
                    }
                    i2++;
                }
            }
            fVar.b(i);
        }
    }
}
