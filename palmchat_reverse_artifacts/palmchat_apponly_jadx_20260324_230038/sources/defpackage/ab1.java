package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ab1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1189a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;

    public ab1(String str, @Nullable String str2, @Nullable String str3) {
        this.f1189a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ab1.class != obj.getClass()) {
            return false;
        }
        ab1 ab1Var = (ab1) obj;
        return g86.c(this.f1189a, ab1Var.f1189a) && g86.c(this.b, ab1Var.b) && g86.c(this.c, ab1Var.c);
    }

    public int hashCode() {
        int iHashCode = this.f1189a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
