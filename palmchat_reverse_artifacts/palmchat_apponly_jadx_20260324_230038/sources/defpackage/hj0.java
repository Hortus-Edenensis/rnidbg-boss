package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class hj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hj0 f17977a = new a();
    public static final hj0 b = new b(-1);
    public static final hj0 c = new b(1);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends hj0 {
        public a() {
            super(null);
        }

        @Override // defpackage.hj0
        public hj0 d(int i, int i2) {
            return l(Integer.compare(i, i2));
        }

        @Override // defpackage.hj0
        public hj0 e(long j, long j2) {
            return l(Long.compare(j, j2));
        }

        @Override // defpackage.hj0
        public hj0 f(Comparable<?> comparable, Comparable<?> comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // defpackage.hj0
        public <T> hj0 g(T t, T t2, Comparator<T> comparator) {
            return l(comparator.compare(t, t2));
        }

        @Override // defpackage.hj0
        public hj0 h(boolean z, boolean z2) {
            return l(Boolean.compare(z, z2));
        }

        @Override // defpackage.hj0
        public hj0 i(boolean z, boolean z2) {
            return l(Boolean.compare(z2, z));
        }

        @Override // defpackage.hj0
        public int j() {
            return 0;
        }

        public hj0 l(int i) {
            return i < 0 ? hj0.b : i > 0 ? hj0.c : hj0.f17977a;
        }
    }

    public /* synthetic */ hj0(a aVar) {
        this();
    }

    public static hj0 k() {
        return f17977a;
    }

    public abstract hj0 d(int i, int i2);

    public abstract hj0 e(long j, long j2);

    public abstract hj0 f(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> hj0 g(T t, T t2, Comparator<T> comparator);

    public abstract hj0 h(boolean z, boolean z2);

    public abstract hj0 i(boolean z, boolean z2);

    public abstract int j();

    public hj0() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends hj0 {
        public final int d;

        public b(int i) {
            super(null);
            this.d = i;
        }

        @Override // defpackage.hj0
        public int j() {
            return this.d;
        }

        @Override // defpackage.hj0
        public hj0 d(int i, int i2) {
            return this;
        }

        @Override // defpackage.hj0
        public hj0 e(long j, long j2) {
            return this;
        }

        @Override // defpackage.hj0
        public hj0 f(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // defpackage.hj0
        public hj0 h(boolean z, boolean z2) {
            return this;
        }

        @Override // defpackage.hj0
        public hj0 i(boolean z, boolean z2) {
            return this;
        }

        @Override // defpackage.hj0
        public <T> hj0 g(T t, T t2, Comparator<T> comparator) {
            return this;
        }
    }
}
