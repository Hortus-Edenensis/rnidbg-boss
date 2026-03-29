package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1754a;
    public final float b;

    public bn(int i, float f) {
        this.f1754a = i;
        this.b = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bn.class != obj.getClass()) {
            return false;
        }
        bn bnVar = (bn) obj;
        return this.f1754a == bnVar.f1754a && Float.compare(bnVar.b, this.b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f1754a) * 31) + Float.floatToIntBits(this.b);
    }
}
