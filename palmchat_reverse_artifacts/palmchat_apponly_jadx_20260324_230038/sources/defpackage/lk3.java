package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.b f19020a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public lk3(i.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        vh.a(!z4 || z2);
        vh.a(!z3 || z2);
        if (!z || (!z2 && !z3 && !z4)) {
            z5 = true;
        }
        vh.a(z5);
        this.f19020a = bVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public lk3 a(long j) {
        return j == this.c ? this : new lk3(this.f19020a, this.b, j, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public lk3 b(long j) {
        return j == this.b ? this : new lk3(this.f19020a, j, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lk3.class != obj.getClass()) {
            return false;
        }
        lk3 lk3Var = (lk3) obj;
        return this.b == lk3Var.b && this.c == lk3Var.c && this.d == lk3Var.d && this.e == lk3Var.e && this.f == lk3Var.f && this.g == lk3Var.g && this.h == lk3Var.h && this.i == lk3Var.i && g86.c(this.f19020a, lk3Var.f19020a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f19020a.hashCode()) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
