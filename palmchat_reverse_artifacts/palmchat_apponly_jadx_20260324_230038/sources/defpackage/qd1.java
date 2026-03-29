package defpackage;

import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class qd1<C extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20230a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends qd1<Integer> implements Serializable {
        public static final b b = new b();
        private static final long serialVersionUID = 0;

        public b() {
            super(true);
        }

        private Object readResolve() {
            return b;
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Integer s() {
            return Integer.MIN_VALUE;
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public Integer t(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public Integer u(Integer num, long j) {
            sg0.c(j, "distance");
            return Integer.valueOf(ku2.e(num.longValue() + j));
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public Integer v(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public long a(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Integer p() {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends qd1<Long> implements Serializable {
        public static final c b = new c();
        private static final long serialVersionUID = 0;

        public c() {
            super(true);
        }

        private Object readResolve() {
            return b;
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Long s() {
            return Long.MIN_VALUE;
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public Long t(Long l) {
            long jLongValue = l.longValue();
            if (jLongValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public Long u(Long l, long j) {
            sg0.c(j, "distance");
            long jLongValue = l.longValue() + j;
            if (jLongValue < 0) {
                dm4.e(l.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public Long v(Long l) {
            long jLongValue = l.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public long a(Long l, Long l2) {
            long jLongValue = l2.longValue() - l.longValue();
            if (l2.longValue() > l.longValue() && jLongValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l2.longValue() >= l.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // defpackage.qd1
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Long p() {
            return Long.MAX_VALUE;
        }
    }

    public static qd1<Integer> b() {
        return b.b;
    }

    public static qd1<Long> o() {
        return c.b;
    }

    public abstract long a(C c2, C c3);

    public abstract C p();

    public abstract C s();

    public abstract C t(C c2);

    public abstract C u(C c2, long j);

    public abstract C v(C c2);

    public qd1() {
        this(false);
    }

    public qd1(boolean z) {
        this.f20230a = z;
    }
}
