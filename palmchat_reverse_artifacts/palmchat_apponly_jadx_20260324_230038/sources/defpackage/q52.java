package defpackage;

import com.google.common.collect.BoundType;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class q52<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<? super T> f20182a;
    public final boolean b;
    public final T c;
    public final BoundType d;
    public final boolean e;
    public final T f;
    public final BoundType g;

    public q52(Comparator<? super T> comparator, boolean z, T t, BoundType boundType, boolean z2, T t2, BoundType boundType2) {
        this.f20182a = (Comparator) dm4.o(comparator);
        this.b = z;
        this.e = z2;
        this.c = t;
        this.d = (BoundType) dm4.o(boundType);
        this.f = t2;
        this.g = (BoundType) dm4.o(boundType2);
        if (z) {
            comparator.compare((Object) a44.a(t), (Object) a44.a(t));
        }
        if (z2) {
            comparator.compare((Object) a44.a(t2), (Object) a44.a(t2));
        }
        if (z && z2) {
            int iCompare = comparator.compare((Object) a44.a(t), (Object) a44.a(t2));
            boolean z3 = true;
            dm4.k(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (iCompare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                if (boundType == boundType3 && boundType2 == boundType3) {
                    z3 = false;
                }
                dm4.d(z3);
            }
        }
    }

    public static <T> q52<T> A(Comparator<? super T> comparator, T t, BoundType boundType) {
        return new q52<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    public static <T> q52<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new q52<>(comparator, false, null, boundType, false, null, boundType);
    }

    public static <T> q52<T> d(Comparator<? super T> comparator, T t, BoundType boundType) {
        return new q52<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    public Comparator<? super T> b() {
        return this.f20182a;
    }

    public boolean c(T t) {
        return (z(t) || y(t)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q52)) {
            return false;
        }
        q52 q52Var = (q52) obj;
        return this.f20182a.equals(q52Var.f20182a) && this.b == q52Var.b && this.e == q52Var.e && o().equals(q52Var.o()) && s().equals(q52Var.s()) && m54.a(p(), q52Var.p()) && m54.a(u(), q52Var.u());
    }

    public int hashCode() {
        return m54.b(this.f20182a, p(), o(), u(), s());
    }

    public BoundType o() {
        return this.d;
    }

    public T p() {
        return this.c;
    }

    public BoundType s() {
        return this.g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20182a);
        sb.append(":");
        BoundType boundType = this.d;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.b ? this.c : "-∞");
        sb.append(',');
        sb.append(this.e ? this.f : "∞");
        sb.append(this.g == boundType2 ? ']' : ')');
        return sb.toString();
    }

    public T u() {
        return this.f;
    }

    public boolean v() {
        return this.b;
    }

    public boolean w() {
        return this.e;
    }

    public q52<T> x(q52<T> q52Var) {
        int iCompare;
        int iCompare2;
        T t;
        BoundType boundType;
        BoundType boundType2;
        int iCompare3;
        BoundType boundType3;
        dm4.o(q52Var);
        dm4.d(this.f20182a.equals(q52Var.f20182a));
        boolean z = this.b;
        T tP = p();
        BoundType boundTypeO = o();
        if (!v()) {
            z = q52Var.b;
            tP = q52Var.p();
            boundTypeO = q52Var.o();
        } else if (q52Var.v() && ((iCompare = this.f20182a.compare(p(), q52Var.p())) < 0 || (iCompare == 0 && q52Var.o() == BoundType.OPEN))) {
            tP = q52Var.p();
            boundTypeO = q52Var.o();
        }
        boolean z2 = z;
        boolean z3 = this.e;
        T tU = u();
        BoundType boundTypeS = s();
        if (!w()) {
            z3 = q52Var.e;
            tU = q52Var.u();
            boundTypeS = q52Var.s();
        } else if (q52Var.w() && ((iCompare2 = this.f20182a.compare(u(), q52Var.u())) > 0 || (iCompare2 == 0 && q52Var.s() == BoundType.OPEN))) {
            tU = q52Var.u();
            boundTypeS = q52Var.s();
        }
        boolean z4 = z3;
        T t2 = tU;
        if (z2 && z4 && ((iCompare3 = this.f20182a.compare(tP, t2)) > 0 || (iCompare3 == 0 && boundTypeO == (boundType3 = BoundType.OPEN) && boundTypeS == boundType3))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            t = t2;
        } else {
            t = tP;
            boundType = boundTypeO;
            boundType2 = boundTypeS;
        }
        return new q52<>(this.f20182a, z2, t, boundType, z4, t2, boundType2);
    }

    public boolean y(T t) {
        if (!w()) {
            return false;
        }
        int iCompare = this.f20182a.compare(t, a44.a(u()));
        return ((iCompare == 0) & (s() == BoundType.OPEN)) | (iCompare > 0);
    }

    public boolean z(T t) {
        if (!v()) {
            return false;
        }
        int iCompare = this.f20182a.compare(t, a44.a(p()));
        return ((iCompare == 0) & (o() == BoundType.OPEN)) | (iCompare < 0);
    }
}
