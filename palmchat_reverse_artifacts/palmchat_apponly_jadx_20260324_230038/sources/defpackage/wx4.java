package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class wx4 extends q94<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wx4 f21830a = new wx4();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f21830a;
    }

    @Override // defpackage.q94
    public <S extends Comparable<?>> q94<S> s() {
        return q94.o();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // defpackage.q94, java.util.Comparator
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        dm4.o(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // defpackage.q94
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable<?>> E d(E e, E e2) {
        return (E) au3.f1572a.e(e, e2);
    }

    @Override // defpackage.q94
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable<?>> E e(E e, E e2) {
        return (E) au3.f1572a.d(e, e2);
    }
}
