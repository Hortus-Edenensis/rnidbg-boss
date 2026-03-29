package defpackage;

import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bp5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f1797a;
    public final int b;
    public final int c;
    public final int d;

    public bp5(Surface surface, int i, int i2) {
        this(surface, i, i2, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bp5)) {
            return false;
        }
        bp5 bp5Var = (bp5) obj;
        return this.b == bp5Var.b && this.c == bp5Var.c && this.d == bp5Var.d && this.f1797a.equals(bp5Var.f1797a);
    }

    public int hashCode() {
        return (((((this.f1797a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public bp5(Surface surface, int i, int i2, int i3) {
        vh.b(i3 == 0 || i3 == 90 || i3 == 180 || i3 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.f1797a = surface;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
