package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import defpackage.v45;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class o61 implements k64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j64 f19701a;
    public final long b;
    public final long c;
    public final dl5 d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements v45 {
        public b() {
        }

        @Override // defpackage.v45
        public long getDurationUs() {
            return o61.this.d.b(o61.this.f);
        }

        @Override // defpackage.v45
        public v45.a getSeekPoints(long j) {
            return new v45.a(new x45(j, g86.r((o61.this.b + BigInteger.valueOf(o61.this.d.c(j)).multiply(BigInteger.valueOf(o61.this.c - o61.this.b)).divide(BigInteger.valueOf(o61.this.f)).longValue()) - 30000, o61.this.b, o61.this.c - 1)));
        }

        @Override // defpackage.v45
        public boolean isSeekable() {
            return true;
        }
    }

    public o61(dl5 dl5Var, long j, long j2, long j3, long j4, boolean z) {
        vh.a(j >= 0 && j2 > j);
        this.d = dl5Var;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.f19701a = new j64();
    }

    @Override // defpackage.k64
    public long a(ps1 ps1Var) throws IOException {
        int i = this.e;
        if (i == 0) {
            long position = ps1Var.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long jG = g(ps1Var);
                if (jG != -1) {
                    return jG;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(ps1Var);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = h(ps1Var);
        this.e = 4;
        return this.g;
    }

    @Override // defpackage.k64
    @Nullable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f != 0) {
            return new b();
        }
        return null;
    }

    public final long g(ps1 ps1Var) throws IOException {
        if (this.i == this.j) {
            return -1L;
        }
        long position = ps1Var.getPosition();
        if (!this.f19701a.d(ps1Var, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f19701a.a(ps1Var, false);
        ps1Var.resetPeekPosition();
        long j2 = this.h;
        j64 j64Var = this.f19701a;
        long j3 = j64Var.c;
        long j4 = j2 - j3;
        int i = j64Var.h + j64Var.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = ps1Var.getPosition() + ((long) i);
            this.k = this.f19701a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
            this.j = j6;
            return j6;
        }
        long position2 = ps1Var.getPosition() - (((long) i) * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j8 = this.i;
        return g86.r(position2 + ((j4 * (j7 - j8)) / (this.l - this.k)), j8, j7 - 1);
    }

    @VisibleForTesting
    public long h(ps1 ps1Var) throws IOException {
        this.f19701a.b();
        if (!this.f19701a.c(ps1Var)) {
            throw new EOFException();
        }
        this.f19701a.a(ps1Var, false);
        j64 j64Var = this.f19701a;
        ps1Var.skipFully(j64Var.h + j64Var.i);
        long j = this.f19701a.c;
        while (true) {
            j64 j64Var2 = this.f19701a;
            if ((j64Var2.b & 4) == 4 || !j64Var2.c(ps1Var) || ps1Var.getPosition() >= this.c || !this.f19701a.a(ps1Var, true)) {
                break;
            }
            j64 j64Var3 = this.f19701a;
            if (!rs1.e(ps1Var, j64Var3.h + j64Var3.i)) {
                break;
            }
            j = this.f19701a.c;
        }
        return j;
    }

    public final void i(ps1 ps1Var) throws IOException {
        while (true) {
            this.f19701a.c(ps1Var);
            this.f19701a.a(ps1Var, false);
            j64 j64Var = this.f19701a;
            if (j64Var.c > this.h) {
                ps1Var.resetPeekPosition();
                return;
            } else {
                ps1Var.skipFully(j64Var.h + j64Var.i);
                this.i = ps1Var.getPosition();
                this.k = this.f19701a.c;
            }
        }
    }

    @Override // defpackage.k64
    public void startSeek(long j) {
        this.h = g86.r(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
