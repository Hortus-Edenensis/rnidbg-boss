package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d43 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<F> f16971a;
        public final u42<? super F, ? extends T> b;

        /* JADX INFO: renamed from: d43$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1181a extends y06<F, T> {
            public C1181a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // defpackage.x06
            public T a(F f) {
                return a.this.b.apply(f);
            }
        }

        public a(List<F> list, u42<? super F, ? extends T> u42Var) {
            this.f16971a = (List) dm4.o(list);
            this.b = (u42) dm4.o(u42Var);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.b.apply(this.f16971a.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f16971a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new C1181a(this.f16971a.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.b.apply(this.f16971a.remove(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            this.f16971a.subList(i, i2).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f16971a.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<F> f16972a;
        public final u42<? super F, ? extends T> b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends y06<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // defpackage.x06
            public T a(F f) {
                return b.this.b.apply(f);
            }
        }

        public b(List<F> list, u42<? super F, ? extends T> u42Var) {
            this.f16972a = (List) dm4.o(list);
            this.b = (u42) dm4.o(u42Var);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f16972a.isEmpty();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.f16972a.listIterator(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            this.f16972a.subList(i, i2).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f16972a.size();
        }
    }

    public static <T> List<T> a(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static int b(int i) {
        sg0.b(i, "arraySize");
        return ku2.o(((long) i) + 5 + ((long) (i / 10)));
    }

    public static boolean c(List<?> list, Object obj) {
        if (obj == dm4.o(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return cv2.g(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!m54.a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (m54.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int e(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int f(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (m54.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int g(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> h() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> i(Iterable<? extends E> iterable) {
        dm4.o(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : j(iterable.iterator());
    }

    public static <E> ArrayList<E> j(Iterator<? extends E> it) {
        ArrayList<E> arrayListH = h();
        cv2.a(arrayListH, it);
        return arrayListH;
    }

    @SafeVarargs
    public static <E> ArrayList<E> k(E... eArr) {
        dm4.o(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> l(int i) {
        sg0.b(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <E> ArrayList<E> m(int i) {
        return new ArrayList<>(b(i));
    }

    public static <F, T> List<T> n(List<F> list, u42<? super F, ? extends T> u42Var) {
        return list instanceof RandomAccess ? new a(list, u42Var) : new b(list, u42Var);
    }
}
