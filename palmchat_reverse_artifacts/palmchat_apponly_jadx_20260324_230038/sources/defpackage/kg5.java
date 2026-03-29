package defpackage;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class kg5 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? q94.o() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        dm4.o(comparator);
        dm4.o(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof jg5)) {
                return false;
            }
            comparator2 = ((jg5) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
