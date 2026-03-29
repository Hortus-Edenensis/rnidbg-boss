package defpackage;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class q94<T> implements Comparator<T> {
    public static <T> q94<T> b(Comparator<T> comparator) {
        return comparator instanceof q94 ? (q94) comparator : new gj0(comparator);
    }

    public static <C extends Comparable> q94<C> o() {
        return au3.f1572a;
    }

    public <U extends T> q94<U> a(Comparator<? super U> comparator) {
        return new tk0(this, (Comparator) dm4.o(comparator));
    }

    public <E extends T> ImmutableList<E> c(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E d(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E e(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <T2 extends T> q94<Map.Entry<T2, ?>> p() {
        return (q94<Map.Entry<T2, ?>>) q(u.k());
    }

    public <F> q94<F> q(u42<F, ? extends T> u42Var) {
        return new pv(u42Var, this);
    }

    public <S extends T> q94<S> s() {
        return new xx4(this);
    }

    public <E extends T> List<E> t(Iterable<E> iterable) {
        Object[] objArrQ = bv2.q(iterable);
        Arrays.sort(objArrQ, this);
        return d43.i(Arrays.asList(objArrQ));
    }
}
