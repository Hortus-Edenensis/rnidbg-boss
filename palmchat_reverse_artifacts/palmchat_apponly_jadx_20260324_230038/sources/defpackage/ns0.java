package defpackage;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ns0<C extends Comparable> implements Comparable<ns0<C>>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f19587a;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19588a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f19588a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19588a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends ns0<Comparable<?>> {
        public static final b b = new b();
        private static final long serialVersionUID = 0;

        public b() {
            super("");
        }

        private Object readResolve() {
            return b;
        }

        @Override // defpackage.ns0
        public BoundType A() {
            throw new IllegalStateException();
        }

        @Override // defpackage.ns0
        public ns0<Comparable<?>> B(BoundType boundType, qd1<Comparable<?>> qd1Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.ns0
        public ns0<Comparable<?>> C(BoundType boundType, qd1<Comparable<?>> qd1Var) {
            throw new IllegalStateException();
        }

        @Override // defpackage.ns0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // defpackage.ns0, java.lang.Comparable
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public int compareTo(ns0<Comparable<?>> ns0Var) {
            return ns0Var == this ? 0 : 1;
        }

        @Override // defpackage.ns0
        public void s(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // defpackage.ns0
        public void t(StringBuilder sb) {
            sb.append("+∞)");
        }

        public String toString() {
            return "+∞";
        }

        @Override // defpackage.ns0
        public Comparable<?> u() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // defpackage.ns0
        public Comparable<?> v(qd1<Comparable<?>> qd1Var) {
            return qd1Var.p();
        }

        @Override // defpackage.ns0
        public boolean w(Comparable<?> comparable) {
            return false;
        }

        @Override // defpackage.ns0
        public Comparable<?> x(qd1<Comparable<?>> qd1Var) {
            throw new AssertionError();
        }

        @Override // defpackage.ns0
        public BoundType z() {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<C extends Comparable> extends ns0<C> {
        private static final long serialVersionUID = 0;

        public c(C c) {
            super((Comparable) dm4.o(c));
        }

        @Override // defpackage.ns0
        public BoundType A() {
            return BoundType.CLOSED;
        }

        @Override // defpackage.ns0
        public ns0<C> B(BoundType boundType, qd1<C> qd1Var) {
            int i = a.f19588a[boundType.ordinal()];
            if (i == 1) {
                Comparable comparableT = qd1Var.t(this.f19587a);
                return comparableT == null ? ns0.o() : ns0.p(comparableT);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // defpackage.ns0
        public ns0<C> C(BoundType boundType, qd1<C> qd1Var) {
            int i = a.f19588a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            Comparable comparableT = qd1Var.t(this.f19587a);
            return comparableT == null ? ns0.b() : ns0.p(comparableT);
        }

        @Override // defpackage.ns0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((ns0) obj);
        }

        @Override // defpackage.ns0
        public int hashCode() {
            return ~this.f19587a.hashCode();
        }

        @Override // defpackage.ns0
        public ns0<C> q(qd1<C> qd1Var) {
            Comparable comparableX = x(qd1Var);
            return comparableX != null ? ns0.p(comparableX) : ns0.b();
        }

        @Override // defpackage.ns0
        public void s(StringBuilder sb) {
            sb.append('(');
            sb.append(this.f19587a);
        }

        @Override // defpackage.ns0
        public void t(StringBuilder sb) {
            sb.append(this.f19587a);
            sb.append(']');
        }

        public String toString() {
            return "/" + this.f19587a + "\\";
        }

        @Override // defpackage.ns0
        public C v(qd1<C> qd1Var) {
            return this.f19587a;
        }

        @Override // defpackage.ns0
        public boolean w(C c) {
            return Range.compareOrThrow(this.f19587a, c) < 0;
        }

        @Override // defpackage.ns0
        public C x(qd1<C> qd1Var) {
            return (C) qd1Var.t(this.f19587a);
        }

        @Override // defpackage.ns0
        public BoundType z() {
            return BoundType.OPEN;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends ns0<Comparable<?>> {
        public static final d b = new d();
        private static final long serialVersionUID = 0;

        public d() {
            super("");
        }

        private Object readResolve() {
            return b;
        }

        @Override // defpackage.ns0
        public BoundType A() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.ns0
        public ns0<Comparable<?>> B(BoundType boundType, qd1<Comparable<?>> qd1Var) {
            throw new IllegalStateException();
        }

        @Override // defpackage.ns0
        public ns0<Comparable<?>> C(BoundType boundType, qd1<Comparable<?>> qd1Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.ns0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // defpackage.ns0
        public ns0<Comparable<?>> q(qd1<Comparable<?>> qd1Var) {
            try {
                return ns0.p(qd1Var.s());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // defpackage.ns0, java.lang.Comparable
        /* JADX INFO: renamed from: r */
        public int compareTo(ns0<Comparable<?>> ns0Var) {
            return ns0Var == this ? 0 : -1;
        }

        @Override // defpackage.ns0
        public void s(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // defpackage.ns0
        public void t(StringBuilder sb) {
            throw new AssertionError();
        }

        public String toString() {
            return "-∞";
        }

        @Override // defpackage.ns0
        public Comparable<?> u() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // defpackage.ns0
        public Comparable<?> v(qd1<Comparable<?>> qd1Var) {
            throw new AssertionError();
        }

        @Override // defpackage.ns0
        public boolean w(Comparable<?> comparable) {
            return true;
        }

        @Override // defpackage.ns0
        public Comparable<?> x(qd1<Comparable<?>> qd1Var) {
            return qd1Var.s();
        }

        @Override // defpackage.ns0
        public BoundType z() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<C extends Comparable> extends ns0<C> {
        private static final long serialVersionUID = 0;

        public e(C c) {
            super((Comparable) dm4.o(c));
        }

        @Override // defpackage.ns0
        public BoundType A() {
            return BoundType.OPEN;
        }

        @Override // defpackage.ns0
        public ns0<C> B(BoundType boundType, qd1<C> qd1Var) {
            int i = a.f19588a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            Comparable comparableV = qd1Var.v(this.f19587a);
            return comparableV == null ? ns0.o() : new c(comparableV);
        }

        @Override // defpackage.ns0
        public ns0<C> C(BoundType boundType, qd1<C> qd1Var) {
            int i = a.f19588a[boundType.ordinal()];
            if (i == 1) {
                Comparable comparableV = qd1Var.v(this.f19587a);
                return comparableV == null ? ns0.b() : new c(comparableV);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // defpackage.ns0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((ns0) obj);
        }

        @Override // defpackage.ns0
        public int hashCode() {
            return this.f19587a.hashCode();
        }

        @Override // defpackage.ns0
        public void s(StringBuilder sb) {
            sb.append('[');
            sb.append(this.f19587a);
        }

        @Override // defpackage.ns0
        public void t(StringBuilder sb) {
            sb.append(this.f19587a);
            sb.append(')');
        }

        public String toString() {
            return "\\" + this.f19587a + "/";
        }

        @Override // defpackage.ns0
        public C v(qd1<C> qd1Var) {
            return (C) qd1Var.v(this.f19587a);
        }

        @Override // defpackage.ns0
        public boolean w(C c) {
            return Range.compareOrThrow(this.f19587a, c) <= 0;
        }

        @Override // defpackage.ns0
        public C x(qd1<C> qd1Var) {
            return this.f19587a;
        }

        @Override // defpackage.ns0
        public BoundType z() {
            return BoundType.CLOSED;
        }
    }

    public ns0(C c2) {
        this.f19587a = c2;
    }

    public static <C extends Comparable> ns0<C> b() {
        return b.b;
    }

    public static <C extends Comparable> ns0<C> c(C c2) {
        return new c(c2);
    }

    public static <C extends Comparable> ns0<C> o() {
        return d.b;
    }

    public static <C extends Comparable> ns0<C> p(C c2) {
        return new e(c2);
    }

    public abstract BoundType A();

    public abstract ns0<C> B(BoundType boundType, qd1<C> qd1Var);

    public abstract ns0<C> C(BoundType boundType, qd1<C> qd1Var);

    public boolean equals(Object obj) {
        if (!(obj instanceof ns0)) {
            return false;
        }
        try {
            return compareTo((ns0) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: r */
    public int compareTo(ns0<C> ns0Var) {
        if (ns0Var == o()) {
            return 1;
        }
        if (ns0Var == b()) {
            return -1;
        }
        int iCompareOrThrow = Range.compareOrThrow(this.f19587a, ns0Var.f19587a);
        return iCompareOrThrow != 0 ? iCompareOrThrow : Boolean.compare(this instanceof c, ns0Var instanceof c);
    }

    public abstract void s(StringBuilder sb);

    public abstract void t(StringBuilder sb);

    public C u() {
        return this.f19587a;
    }

    public abstract C v(qd1<C> qd1Var);

    public abstract boolean w(C c2);

    public abstract C x(qd1<C> qd1Var);

    public abstract BoundType z();

    public ns0<C> q(qd1<C> qd1Var) {
        return this;
    }
}
