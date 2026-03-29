package defpackage;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class gj0<T> extends q94<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<T> f17737a;

    public gj0(Comparator<T> comparator) {
        this.f17737a = (Comparator) dm4.o(comparator);
    }

    @Override // defpackage.q94, java.util.Comparator
    public int compare(T t, T t2) {
        return this.f17737a.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gj0) {
            return this.f17737a.equals(((gj0) obj).f17737a);
        }
        return false;
    }

    public int hashCode() {
        return this.f17737a.hashCode();
    }

    public String toString() {
        return this.f17737a.toString();
    }
}
