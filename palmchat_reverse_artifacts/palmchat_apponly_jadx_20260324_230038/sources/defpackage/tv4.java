package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class tv4 {
    public static final tv4 b = new tv4(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21081a;

    public tv4(boolean z) {
        this.f21081a = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && tv4.class == obj.getClass() && this.f21081a == ((tv4) obj).f21081a;
    }

    public int hashCode() {
        return !this.f21081a ? 1 : 0;
    }
}
