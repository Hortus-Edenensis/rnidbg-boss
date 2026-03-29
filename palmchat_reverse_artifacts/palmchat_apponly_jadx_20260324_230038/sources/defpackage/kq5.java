package defpackage;

import defpackage.dz4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@dz4.a
public final class kq5 extends dz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dz4 f18810a;
    public final Object b;

    public kq5(dz4 dz4Var, Object obj) {
        this.f18810a = dz4Var;
        this.b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kq5) {
            return this.f18810a.equals(((kq5) obj).f18810a);
        }
        return false;
    }

    public int hashCode() {
        return this.f18810a.hashCode();
    }

    public String toString() {
        return this.f18810a.toString() + " (with synchronization wrapper)";
    }
}
