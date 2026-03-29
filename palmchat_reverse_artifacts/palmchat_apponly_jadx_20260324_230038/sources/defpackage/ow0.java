package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ow0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19886a;
    public final m b;
    public final m c;
    public final int d;
    public final int e;

    public ow0(String str, m mVar, m mVar2, int i, int i2) {
        vh.a(i == 0 || i2 == 0);
        this.f19886a = vh.d(str);
        this.b = (m) vh.e(mVar);
        this.c = (m) vh.e(mVar2);
        this.d = i;
        this.e = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ow0.class != obj.getClass()) {
            return false;
        }
        ow0 ow0Var = (ow0) obj;
        return this.d == ow0Var.d && this.e == ow0Var.e && this.f19886a.equals(ow0Var.f19886a) && this.b.equals(ow0Var.b) && this.c.equals(ow0Var.c);
    }

    public int hashCode() {
        return ((((((((527 + this.d) * 31) + this.e) * 31) + this.f19886a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
