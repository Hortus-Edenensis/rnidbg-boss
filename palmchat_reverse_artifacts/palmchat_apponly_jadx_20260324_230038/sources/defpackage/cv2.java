package defpackage;

import defpackage.cv2;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class cv2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class a<T> extends o46<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f16919a;

        public a(Iterator it) {
            this.f16919a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16919a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f16919a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class b<T> extends k1<T> {
        public final /* synthetic */ Iterator c;
        public final /* synthetic */ em4 d;

        public b(Iterator it, em4 em4Var) {
            this.c = it;
            this.d = em4Var;
        }

        @Override // defpackage.k1
        public T a() {
            while (this.c.hasNext()) {
                T t = (T) this.c.next();
                if (this.d.apply(t)) {
                    return t;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* JADX INFO: compiled from: SearchBox */
    public class c<F, T> extends x06<F, T> {
        public final /* synthetic */ u42 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, u42 u42Var) {
            super(it);
            this.b = u42Var;
        }

        @Override // defpackage.x06
        public T a(F f) {
            return (T) this.b.apply(f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d<T> extends i1<T> {
        public static final p46<Object> d = new d(new Object[0], 0);
        public final T[] c;

        public d(T[] tArr, int i) {
            super(tArr.length, i);
            this.c = tArr;
        }

        @Override // defpackage.i1
        public T a(int i) {
            return this.c[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends T> f16920a;
        public Iterator<? extends T> b = cv2.h();
        public Iterator<? extends Iterator<? extends T>> c;
        public Deque<Iterator<? extends Iterator<? extends T>>> d;

        public e(Iterator<? extends Iterator<? extends T>> it) {
            this.c = (Iterator) dm4.o(it);
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.c;
                if (it != null && it.hasNext()) {
                    return this.c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.c = this.d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) dm4.o(this.b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.b = next;
                if (next instanceof e) {
                    e eVar = (e) next;
                    this.b = eVar.b;
                    if (this.d == null) {
                        this.d = new ArrayDeque();
                    }
                    this.d.addFirst(this.c);
                    if (eVar.d != null) {
                        while (!eVar.d.isEmpty()) {
                            this.d.addFirst(eVar.d.removeLast());
                        }
                    }
                    this.c = eVar.c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.b;
            this.f16920a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f16920a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f16920a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum f implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            sg0.e(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g<T> extends o46<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<zf4<T>> f16921a;

        public g(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f16921a = new PriorityQueue(2, new Comparator() { // from class: dv2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return cv2.g.b(comparator, (zf4) obj, (zf4) obj2);
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f16921a.add(cv2.s(it));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, zf4 zf4Var, zf4 zf4Var2) {
            return comparator.compare(zf4Var.peek(), zf4Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f16921a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            zf4<T> zf4VarRemove = this.f16921a.remove();
            T next = zf4VarRemove.next();
            if (zf4VarRemove.hasNext()) {
                this.f16921a.add(zf4VarRemove);
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h<E> implements zf4<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f16922a;
        public boolean b;
        public E c;

        public h(Iterator<? extends E> it) {
            this.f16922a = (Iterator) dm4.o(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b || this.f16922a.hasNext();
        }

        @Override // defpackage.zf4, java.util.Iterator
        public E next() {
            if (!this.b) {
                return this.f16922a.next();
            }
            E e = (E) a44.a(this.c);
            this.b = false;
            this.c = null;
            return e;
        }

        @Override // defpackage.zf4
        public E peek() {
            if (!this.b) {
                this.c = this.f16922a.next();
                this.b = true;
            }
            return (E) a44.a(this.c);
        }

        @Override // java.util.Iterator
        public void remove() {
            dm4.u(!this.b, "Can't remove after you've peeked at next");
            this.f16922a.remove();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i<T> extends o46<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f16923a;
        public boolean b;

        public i(T t) {
            this.f16923a = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b) {
                throw new NoSuchElementException();
            }
            this.b = true;
            return this.f16923a;
        }
    }

    public static <F, T> Iterator<T> A(Iterator<F> it, u42<? super F, ? extends T> u42Var) {
        dm4.o(u42Var);
        return new c(it, u42Var);
    }

    public static <T> o46<T> B(Iterator<? extends T> it) {
        dm4.o(it);
        return it instanceof o46 ? (o46) it : new a(it);
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        dm4.o(collection);
        dm4.o(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static int b(Iterator<?> it, int i2) {
        dm4.o(it);
        int i3 = 0;
        dm4.e(i2 >= 0, "numberToAdvance must be nonnegative");
        while (i3 < i2 && it.hasNext()) {
            it.next();
            i3++;
        }
        return i3;
    }

    public static <T> boolean c(Iterator<T> it, em4<? super T> em4Var) {
        return q(it, em4Var) != -1;
    }

    public static void d(Iterator<?> it) {
        dm4.o(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new e(it);
    }

    public static boolean f(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !m54.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> o46<T> h() {
        return i();
    }

    public static <T> p46<T> i() {
        return (p46<T>) d.d;
    }

    public static <T> Iterator<T> j() {
        return f.INSTANCE;
    }

    public static <T> o46<T> k(Iterator<T> it, em4<? super T> em4Var) {
        dm4.o(it);
        dm4.o(em4Var);
        return new b(it, em4Var);
    }

    public static <T> T l(Iterator<T> it, em4<? super T> em4Var) {
        dm4.o(it);
        dm4.o(em4Var);
        while (it.hasNext()) {
            T next = it.next();
            if (em4Var.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T m(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T n(Iterator<? extends T> it, T t) {
        return it.hasNext() ? (T) m(it) : t;
    }

    public static <T> T o(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T p(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(Typography.greater);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int q(Iterator<T> it, em4<? super T> em4Var) {
        dm4.p(em4Var, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (em4Var.apply(it.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> o46<T> r(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        dm4.p(iterable, "iterators");
        dm4.p(comparator, "comparator");
        return new g(iterable, comparator);
    }

    public static <T> zf4<T> s(Iterator<? extends T> it) {
        return it instanceof h ? (h) it : new h(it);
    }

    public static <T> T t(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean u(Iterator<?> it, Collection<?> collection) {
        dm4.o(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean v(Iterator<T> it, em4<? super T> em4Var) {
        dm4.o(em4Var);
        boolean z = false;
        while (it.hasNext()) {
            if (em4Var.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean w(Iterator<?> it, Collection<?> collection) {
        dm4.o(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> o46<T> x(T t) {
        return new i(t);
    }

    public static int y(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return ku2.o(j);
    }

    public static String z(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
