package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ny5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19641a;
    public final T b;

    public ny5(long j, T t) {
        this.b = t;
        this.f19641a = j;
    }

    public long a() {
        return this.f19641a;
    }

    public T b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ny5)) {
            return false;
        }
        ny5 ny5Var = (ny5) obj;
        if (this.f19641a == ny5Var.f19641a) {
            T t = this.b;
            T t2 = ny5Var.b;
            if (t == t2) {
                return true;
            }
            if (t != null && t.equals(t2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f19641a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f19641a), this.b.toString());
    }
}
