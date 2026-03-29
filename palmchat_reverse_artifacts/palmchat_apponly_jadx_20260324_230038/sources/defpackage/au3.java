package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class au3 extends q94<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final au3 f1572a = new au3();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f1572a;
    }

    @Override // defpackage.q94
    public <S extends Comparable<?>> q94<S> s() {
        return wx4.f21830a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    @Override // defpackage.q94, java.util.Comparator
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        dm4.o(comparable);
        dm4.o(comparable2);
        return comparable.compareTo(comparable2);
    }
}
