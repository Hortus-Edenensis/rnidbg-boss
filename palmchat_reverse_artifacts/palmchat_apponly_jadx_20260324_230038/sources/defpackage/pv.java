package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class pv<F, T> extends q94<F> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u42<F, ? extends T> f20099a;
    public final q94<T> b;

    public pv(u42<F, ? extends T> u42Var, q94<T> q94Var) {
        this.f20099a = (u42) dm4.o(u42Var);
        this.b = (q94) dm4.o(q94Var);
    }

    @Override // defpackage.q94, java.util.Comparator
    public int compare(F f, F f2) {
        return this.b.compare(this.f20099a.apply(f), this.f20099a.apply(f2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof pv)) {
            return false;
        }
        pv pvVar = (pv) obj;
        return this.f20099a.equals(pvVar.f20099a) && this.b.equals(pvVar.b);
    }

    public int hashCode() {
        return m54.b(this.f20099a, this.b);
    }

    public String toString() {
        return this.b + ".onResultOf(" + this.f20099a + ")";
    }
}
