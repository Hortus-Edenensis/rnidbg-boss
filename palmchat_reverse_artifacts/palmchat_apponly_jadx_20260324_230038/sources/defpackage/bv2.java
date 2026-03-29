package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class bv2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class a<T> extends k02<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ em4 c;

        public a(Iterable iterable, em4 em4Var) {
            this.b = iterable;
            this.c = em4Var;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return cv2.k(this.b.iterator(), this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class b<T> extends k02<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ u42 c;

        public b(Iterable iterable, u42 u42Var) {
            this.b = iterable;
            this.c = u42Var;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return cv2.A(this.b.iterator(), this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class c<T> extends k02<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f1826a = true;
            public final /* synthetic */ Iterator b;
            public final /* synthetic */ c c;

            public a(c cVar, Iterator it) {
                this.b = it;
                this.c = cVar;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t = (T) this.b.next();
                this.f1826a = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                sg0.e(!this.f1826a);
                this.b.remove();
            }
        }

        public c(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            cv2.b(it, this.c);
            return new a(this, it);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : cv2.a(collection, ((Iterable) dm4.o(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, em4<? super T> em4Var) {
        return cv2.c(iterable.iterator(), em4Var);
    }

    public static <E> Collection<E> c(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : d43.j(iterable.iterator());
    }

    public static <T> Iterable<T> d(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return k02.a(iterable, iterable2);
    }

    public static <T> Iterable<T> e(Iterable<T> iterable, em4<? super T> em4Var) {
        dm4.o(iterable);
        dm4.o(em4Var);
        return new a(iterable, em4Var);
    }

    public static <T> T f(Iterable<? extends T> iterable, T t) {
        return (T) cv2.o(iterable.iterator(), t);
    }

    public static <T> T g(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) cv2.m(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) i(list);
    }

    public static <T> T h(Iterable<? extends T> iterable, T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) i(d43.a(iterable));
            }
        }
        return (T) cv2.n(iterable.iterator(), t);
    }

    public static <T> T i(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T j(Iterable<T> iterable) {
        return (T) cv2.p(iterable.iterator());
    }

    public static boolean k(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> boolean l(Iterable<T> iterable, em4<? super T> em4Var) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? m((List) iterable, (em4) dm4.o(em4Var)) : cv2.v(iterable.iterator(), em4Var);
    }

    public static <T> boolean m(List<T> list, em4<? super T> em4Var) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!em4Var.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (IllegalArgumentException unused) {
                        p(list, em4Var, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        p(list, em4Var, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    public static int n(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : cv2.y(iterable.iterator());
    }

    public static <T> Iterable<T> o(Iterable<T> iterable, int i) {
        dm4.o(iterable);
        dm4.e(i >= 0, "number to skip cannot be negative");
        return new c(iterable, i);
    }

    public static <T> void p(List<T> list, em4<? super T> em4Var, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (em4Var.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    public static Object[] q(Iterable<?> iterable) {
        return c(iterable).toArray();
    }

    public static <T> T[] r(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) c(iterable).toArray(tArr);
    }

    public static String s(Iterable<?> iterable) {
        return cv2.z(iterable.iterator());
    }

    public static <F, T> Iterable<T> t(Iterable<F> iterable, u42<? super F, ? extends T> u42Var) {
        dm4.o(iterable);
        dm4.o(u42Var);
        return new b(iterable, u42Var);
    }
}
