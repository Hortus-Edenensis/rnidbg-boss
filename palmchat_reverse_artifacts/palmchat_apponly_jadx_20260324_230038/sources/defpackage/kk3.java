package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class kk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18710a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public kk3(Object obj) {
        this(obj, -1L);
    }

    public kk3 a(Object obj) {
        return this.f18710a.equals(obj) ? this : new kk3(obj, this.b, this.c, this.d, this.e);
    }

    public boolean b() {
        return this.b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kk3)) {
            return false;
        }
        kk3 kk3Var = (kk3) obj;
        return this.f18710a.equals(kk3Var.f18710a) && this.b == kk3Var.b && this.c == kk3Var.c && this.d == kk3Var.d && this.e == kk3Var.e;
    }

    public int hashCode() {
        return ((((((((527 + this.f18710a.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }

    public kk3(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public kk3(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }

    public kk3(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public kk3(kk3 kk3Var) {
        this.f18710a = kk3Var.f18710a;
        this.b = kk3Var.b;
        this.c = kk3Var.c;
        this.d = kk3Var.d;
        this.e = kk3Var.e;
    }

    public kk3(Object obj, int i, int i2, long j, int i3) {
        this.f18710a = obj;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }
}
