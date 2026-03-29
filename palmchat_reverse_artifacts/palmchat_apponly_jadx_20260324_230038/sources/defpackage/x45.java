package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class x45 {
    public static final x45 c = new x45(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21874a;
    public final long b;

    public x45(long j, long j2) {
        this.f21874a = j;
        this.b = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x45.class != obj.getClass()) {
            return false;
        }
        x45 x45Var = (x45) obj;
        return this.f21874a == x45Var.f21874a && this.b == x45Var.b;
    }

    public int hashCode() {
        return (((int) this.f21874a) * 31) + ((int) this.b);
    }

    public String toString() {
        return "[timeUs=" + this.f21874a + ", position=" + this.b + "]";
    }
}
