package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16905a;
    public final String b;
    public final int c;
    public final int d;

    public cs(String str, String str2, int i, int i2) {
        this.f16905a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        return this.c == csVar.c && this.d == csVar.d && m54.a(this.f16905a, csVar.f16905a) && m54.a(this.b, csVar.b);
    }

    public int hashCode() {
        return m54.b(this.f16905a, this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
    }
}
