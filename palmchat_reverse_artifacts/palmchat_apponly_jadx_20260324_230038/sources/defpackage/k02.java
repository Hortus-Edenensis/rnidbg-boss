package defpackage;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class k02<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional<Iterable<E>> f18543a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends k02<E> {
        public final /* synthetic */ Iterable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.b.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class b<T> extends k02<T> {
        public final /* synthetic */ Iterable[] b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends i1<Iterator<? extends T>> {
            public a(int i) {
                super(i);
            }

            @Override // defpackage.i1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i) {
                return b.this.b[i].iterator();
            }
        }

        public b(Iterable[] iterableArr) {
            this.b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return cv2.e(new a(this.b.length));
        }
    }

    public k02() {
        this.f18543a = Optional.absent();
    }

    public static <T> k02<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    public static <T> k02<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            dm4.o(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> k02<E> d(Iterable<E> iterable) {
        return iterable instanceof k02 ? (k02) iterable : new a(iterable, iterable);
    }

    public final k02<E> c(em4<? super E> em4Var) {
        return d(bv2.e(e(), em4Var));
    }

    public final Iterable<E> e() {
        return this.f18543a.or(this);
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return bv2.s(e());
    }

    public k02(Iterable<E> iterable) {
        this.f18543a = Optional.of(iterable);
    }
}
