package com.google.common.base;

import defpackage.dm4;
import defpackage.j1;
import defpackage.nm4;
import defpackage.qo5;
import defpackage.u42;
import defpackage.v0;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f6056a;

        /* JADX INFO: renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0368a extends j1<T> {
            public final Iterator<? extends Optional<? extends T>> c;

            public C0368a() {
                this.c = (Iterator) dm4.o(a.this.f6056a.iterator());
            }

            @Override // defpackage.j1
            public T a() {
                while (this.c.hasNext()) {
                    Optional<? extends T> next = this.c.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f6056a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0368a();
        }
    }

    public static <T> Optional<T> absent() {
        return v0.b();
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new nm4(t);
    }

    public static <T> Optional<T> of(T t) {
        return new nm4(dm4.o(t));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        dm4.o(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(T t);

    public abstract T or(qo5<? extends T> qo5Var);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(u42<? super T, V> u42Var);
}
