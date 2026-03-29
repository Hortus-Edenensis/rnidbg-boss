package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ne5 {
    public static final ne5 c = new ne5(-1, -1);
    public static final ne5 d = new ne5(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19499a;
    public final int b;

    public ne5(int i, int i2) {
        vh.a((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0));
        this.f19499a = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f19499a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ne5)) {
            return false;
        }
        ne5 ne5Var = (ne5) obj;
        return this.f19499a == ne5Var.f19499a && this.b == ne5Var.b;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.f19499a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f19499a + "x" + this.b;
    }
}
