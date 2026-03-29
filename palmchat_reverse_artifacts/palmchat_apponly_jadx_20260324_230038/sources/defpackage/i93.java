package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class i93<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w83<T> f18129a;

    @Nullable
    public sq<?, ?> b;

    @Nullable
    public T c;

    public i93() {
        this.f18129a = new w83<>();
        this.c = null;
    }

    @Nullable
    public T a(w83<T> w83Var) {
        return this.c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.f18129a.h(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable sq<?, ?> sqVar) {
        this.b = sqVar;
    }

    public i93(@Nullable T t) {
        this.f18129a = new w83<>();
        this.c = t;
    }
}
