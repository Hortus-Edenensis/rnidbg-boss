package com.google.common.base;

import defpackage.dm4;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.p(this.reference, wrapper.reference);
            }
            return false;
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.q(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        private Wrapper(Equivalence<? super T> equivalence, T t) {
            this.equivalence = (Equivalence) dm4.o(equivalence);
            this.reference = t;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends Equivalence<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6054a = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f6054a;
        }

        @Override // com.google.common.base.Equivalence
        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends Equivalence<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6055a = new c();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f6055a;
        }

        @Override // com.google.common.base.Equivalence
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static Equivalence<Object> o() {
        return b.f6054a;
    }

    public static Equivalence<Object> s() {
        return c.f6055a;
    }

    public abstract boolean a(T t, T t2);

    public abstract int b(T t);

    public final boolean p(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return a(t, t2);
    }

    public final int q(T t) {
        if (t == null) {
            return 0;
        }
        return b(t);
    }
}
