package a.a.a.a.b;

import a.a.a.a.a.a.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1069a;
    public final boolean b;

    public c() {
        this(null, false, 3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f1069a, cVar.f1069a) && this.b == cVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        f fVar = this.f1069a;
        int iHashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        boolean z = this.b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "ZaidConfig(uaidConfig=" + this.f1069a + ", enableFeatureV2=" + this.b + ")";
    }

    public c(f uaidConfig, boolean z) {
        Intrinsics.checkNotNullParameter(uaidConfig, "uaidConfig");
        this.f1069a = uaidConfig;
        this.b = z;
    }

    public /* synthetic */ c(f fVar, boolean z, int i) {
        this((i & 1) != 0 ? new f(false, null, null, null, 15) : null, (i & 2) != 0 ? false : z);
    }
}
