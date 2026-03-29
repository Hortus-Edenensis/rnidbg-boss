package defpackage;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class e93<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final V f17239a;

    @Nullable
    public final Throwable b;

    public e93(V v) {
        this.f17239a = v;
        this.b = null;
    }

    @Nullable
    public Throwable a() {
        return this.b;
    }

    @Nullable
    public V b() {
        return this.f17239a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e93)) {
            return false;
        }
        e93 e93Var = (e93) obj;
        if (b() != null && b().equals(e93Var.b())) {
            return true;
        }
        if (a() == null || e93Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public e93(Throwable th) {
        this.b = th;
        this.f17239a = null;
    }
}
