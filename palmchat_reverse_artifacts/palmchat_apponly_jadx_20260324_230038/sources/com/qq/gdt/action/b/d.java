package com.qq.gdt.action.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class d<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f10464a;
    private final B b;

    private d(A a2, B b) {
        this.f10464a = a2;
        this.b = b;
    }

    public static <A, B> d<A, B> a(A a2, B b) {
        return new d<>(a2, b);
    }

    public B b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        A a2 = this.f10464a;
        if (a2 == null) {
            if (dVar.f10464a != null) {
                return false;
            }
        } else if (!a2.equals(dVar.f10464a)) {
            return false;
        }
        B b = this.b;
        B b2 = dVar.b;
        if (b == null) {
            if (b2 != null) {
                return false;
            }
        } else if (!b.equals(b2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f10464a;
        int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b = this.b;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.f10464a + " , second = " + this.b;
    }

    public A a() {
        return this.f10464a;
    }
}
