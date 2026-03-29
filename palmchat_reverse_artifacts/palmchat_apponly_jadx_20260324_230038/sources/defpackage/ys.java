package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import defpackage.v45;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class ys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22257a;
    public final f b;

    @Nullable
    public c c;
    public final int d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements v45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f22258a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.f22258a = dVar;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        public long f(long j) {
            return this.f22258a.timeUsToTargetTime(j);
        }

        @Override // defpackage.v45
        public long getDurationUs() {
            return this.b;
        }

        @Override // defpackage.v45
        public v45.a getSeekPoints(long j) {
            return new v45.a(new x45(j, c.h(this.f22258a.timeUsToTargetTime(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // defpackage.v45
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22259a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f22259a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = h(j2, j3, j4, j5, j6, j7);
        }

        public static long h(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return g86.r(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        public final long i() {
            return this.g;
        }

        public final long j() {
            return this.f;
        }

        public final long k() {
            return this.h;
        }

        public final long l() {
            return this.f22259a;
        }

        public final long m() {
            return this.b;
        }

        public final void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        public final void o(long j, long j2) {
            this.e = j;
            this.g = j2;
            n();
        }

        public final void p(long j, long j2) {
            this.d = j;
            this.f = j2;
            n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        long timeUsToTargetTime(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22260a;
        public final long b;
        public final long c;

        public e(int i, long j, long j2) {
            this.f22260a = i;
            this.b = j;
            this.c = j2;
        }

        public static e d(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e e(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e f(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        e a(ps1 ps1Var, long j) throws IOException;

        void onSeekFinished();
    }

    public ys(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.b = fVar;
        this.d = i;
        this.f22257a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    public c a(long j) {
        return new c(j, this.f22257a.f(j), this.f22257a.c, this.f22257a.d, this.f22257a.e, this.f22257a.f, this.f22257a.g);
    }

    public final v45 b() {
        return this.f22257a;
    }

    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        while (true) {
            c cVar = (c) vh.i(this.c);
            long j = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j <= this.d) {
                e(false, j);
                return g(ps1Var, j, vk4Var);
            }
            if (!i(ps1Var, jK)) {
                return g(ps1Var, jK, vk4Var);
            }
            ps1Var.resetPeekPosition();
            e eVarA = this.b.a(ps1Var, cVar.m());
            int i = eVarA.f22260a;
            if (i == -3) {
                e(false, jK);
                return g(ps1Var, jK, vk4Var);
            }
            if (i == -2) {
                cVar.p(eVarA.b, eVarA.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(ps1Var, eVarA.c);
                    e(true, eVarA.c);
                    return g(ps1Var, eVarA.c, vk4Var);
                }
                cVar.o(eVarA.b, eVarA.c);
            }
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e(boolean z, long j) {
        this.c = null;
        this.b.onSeekFinished();
        f(z, j);
    }

    public final int g(ps1 ps1Var, long j, vk4 vk4Var) {
        if (j == ps1Var.getPosition()) {
            return 0;
        }
        vk4Var.f21468a = j;
        return 1;
    }

    public final void h(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.l() != j) {
            this.c = a(j);
        }
    }

    public final boolean i(ps1 ps1Var, long j) throws IOException {
        long position = j - ps1Var.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ps1Var.skipFully((int) position);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements d {
        @Override // ys.d
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    public void f(boolean z, long j) {
    }
}
