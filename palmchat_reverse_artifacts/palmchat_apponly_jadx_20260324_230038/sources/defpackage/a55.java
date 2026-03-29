package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class a55 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final bt4 f1156a;
    public final long b;
    public final long c;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends a55 {
        public final long d;
        public final long e;

        @Nullable
        public final List<d> f;
        public final long g;
        public final long h;

        @VisibleForTesting
        public final long i;

        public a(@Nullable bt4 bt4Var, long j, long j2, long j3, long j4, @Nullable List<d> list, long j5, long j6, long j7) {
            super(bt4Var, j, j2);
            this.d = j3;
            this.e = j4;
            this.f = list;
            this.i = j5;
            this.g = j6;
            this.h = j7;
        }

        public long c(long j, long j2) {
            long jG = g(j);
            return jG != -1 ? jG : (int) (i((j2 - this.h) + this.i, j) - d(j, j2));
        }

        public long d(long j, long j2) {
            if (g(j) == -1) {
                long j3 = this.g;
                if (j3 != -9223372036854775807L) {
                    return Math.max(e(), i((j2 - this.h) - j3, j));
                }
            }
            return e();
        }

        public long e() {
            return this.d;
        }

        public long f(long j, long j2) {
            if (this.f != null) {
                return -9223372036854775807L;
            }
            long jD = d(j, j2) + c(j, j2);
            return (j(jD) + h(jD, j)) - this.i;
        }

        public abstract long g(long j);

        public final long h(long j, long j2) {
            List<d> list = this.f;
            if (list != null) {
                return (list.get((int) (j - this.d)).b * 1000000) / this.b;
            }
            long jG = g(j2);
            return (jG == -1 || j != (e() + jG) - 1) ? (this.e * 1000000) / this.b : j2 - j(j);
        }

        public long i(long j, long j2) {
            long jE = e();
            long jG = g(j2);
            if (jG == 0) {
                return jE;
            }
            if (this.f == null) {
                long j3 = this.d + (j / ((this.e * 1000000) / this.b));
                return j3 < jE ? jE : jG == -1 ? j3 : Math.min(j3, (jE + jG) - 1);
            }
            long j4 = (jG + jE) - 1;
            long j5 = jE;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long j7 = j(j6);
                if (j7 < j) {
                    j5 = j6 + 1;
                } else {
                    if (j7 <= j) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == jE ? j5 : j4;
        }

        public final long j(long j) {
            List<d> list = this.f;
            return g86.U0(list != null ? list.get((int) (j - this.d)).f1157a - this.c : (j - this.d) * this.e, 1000000L, this.b);
        }

        public abstract bt4 k(ow4 ow4Var, long j);

        public boolean l() {
            return this.f != null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends a {

        @Nullable
        public final List<bt4> j;

        public b(bt4 bt4Var, long j, long j2, long j3, long j4, @Nullable List<d> list, long j5, @Nullable List<bt4> list2, long j6, long j7) {
            super(bt4Var, j, j2, j3, j4, list, j5, j6, j7);
            this.j = list2;
        }

        @Override // a55.a
        public long g(long j) {
            return this.j.size();
        }

        @Override // a55.a
        public bt4 k(ow4 ow4Var, long j) {
            return this.j.get((int) (j - this.d));
        }

        @Override // a55.a
        public boolean l() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends a {

        @Nullable
        public final z56 j;

        @Nullable
        public final z56 k;
        public final long l;

        public c(bt4 bt4Var, long j, long j2, long j3, long j4, long j5, @Nullable List<d> list, long j6, @Nullable z56 z56Var, @Nullable z56 z56Var2, long j7, long j8) {
            super(bt4Var, j, j2, j3, j5, list, j6, j7, j8);
            this.j = z56Var;
            this.k = z56Var2;
            this.l = j4;
        }

        @Override // defpackage.a55
        @Nullable
        public bt4 a(ow4 ow4Var) {
            z56 z56Var = this.j;
            if (z56Var == null) {
                return super.a(ow4Var);
            }
            m mVar = ow4Var.b;
            return new bt4(z56Var.a(mVar.f5892a, 0L, mVar.h, 0L), 0L, -1L);
        }

        @Override // a55.a
        public long g(long j) {
            if (this.f != null) {
                return r0.size();
            }
            long j2 = this.l;
            if (j2 != -1) {
                return (j2 - this.d) + 1;
            }
            if (j != -9223372036854775807L) {
                return us.a(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.b)), BigInteger.valueOf(this.e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // a55.a
        public bt4 k(ow4 ow4Var, long j) {
            List<d> list = this.f;
            long j2 = list != null ? list.get((int) (j - this.d)).f1157a : (j - this.d) * this.e;
            z56 z56Var = this.k;
            m mVar = ow4Var.b;
            return new bt4(z56Var.a(mVar.f5892a, j, mVar.h, j2), 0L, -1L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1157a;
        public final long b;

        public d(long j, long j2) {
            this.f1157a = j;
            this.b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f1157a == dVar.f1157a && this.b == dVar.b;
        }

        public int hashCode() {
            return (((int) this.f1157a) * 31) + ((int) this.b);
        }
    }

    public a55(@Nullable bt4 bt4Var, long j, long j2) {
        this.f1156a = bt4Var;
        this.b = j;
        this.c = j2;
    }

    @Nullable
    public bt4 a(ow4 ow4Var) {
        return this.f1156a;
    }

    public long b() {
        return g86.U0(this.c, 1000000L, this.b);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends a55 {
        public final long d;
        public final long e;

        public e(@Nullable bt4 bt4Var, long j, long j2, long j3, long j4) {
            super(bt4Var, j, j2);
            this.d = j3;
            this.e = j4;
        }

        @Nullable
        public bt4 c() {
            long j = this.e;
            if (j <= 0) {
                return null;
            }
            return new bt4(null, this.d, j);
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
