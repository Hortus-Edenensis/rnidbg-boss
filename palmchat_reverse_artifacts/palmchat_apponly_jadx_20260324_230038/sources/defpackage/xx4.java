package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class xx4<T> extends q94<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q94<? super T> f22078a;

    public xx4(q94<? super T> q94Var) {
        this.f22078a = (q94) dm4.o(q94Var);
    }

    @Override // defpackage.q94, java.util.Comparator
    public int compare(T t, T t2) {
        return this.f22078a.compare(t2, t);
    }

    @Override // defpackage.q94
    public <E extends T> E d(E e, E e2) {
        return (E) this.f22078a.e(e, e2);
    }

    @Override // defpackage.q94
    public <E extends T> E e(E e, E e2) {
        return (E) this.f22078a.d(e, e2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof xx4) {
            return this.f22078a.equals(((xx4) obj).f22078a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f22078a.hashCode();
    }

    @Override // defpackage.q94
    public <S extends T> q94<S> s() {
        return this.f22078a;
    }

    public String toString() {
        return this.f22078a + ".reverse()";
    }
}
