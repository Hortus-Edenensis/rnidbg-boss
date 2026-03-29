package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1816a;
    public final long b;
    public final String c;
    public int d;

    public bt4(@Nullable String str, long j, long j2) {
        this.c = str == null ? "" : str;
        this.f1816a = j;
        this.b = j2;
    }

    @Nullable
    public bt4 a(@Nullable bt4 bt4Var, String str) {
        String strC = c(str);
        if (bt4Var != null && strC.equals(bt4Var.c(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.f1816a;
                if (j2 + j == bt4Var.f1816a) {
                    long j3 = bt4Var.b;
                    return new bt4(strC, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = bt4Var.b;
            if (j4 != -1) {
                long j5 = bt4Var.f1816a;
                if (j5 + j4 == this.f1816a) {
                    return new bt4(strC, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return v56.e(str, this.c);
    }

    public String c(String str) {
        return v56.d(str, this.c);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bt4.class != obj.getClass()) {
            return false;
        }
        bt4 bt4Var = (bt4) obj;
        return this.f1816a == bt4Var.f1816a && this.b == bt4Var.b && this.c.equals(bt4Var.c);
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = ((((527 + ((int) this.f1816a)) * 31) + ((int) this.b)) * 31) + this.c.hashCode();
        }
        return this.d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.c + ", start=" + this.f1816a + ", length=" + this.b + ")";
    }
}
