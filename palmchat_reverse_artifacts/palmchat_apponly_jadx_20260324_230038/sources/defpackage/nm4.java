package defpackage;

import com.google.common.base.Optional;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nm4<T> extends Optional<T> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f19559a;

    public nm4(T t) {
        this.f19559a = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.f19559a);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof nm4) {
            return this.f19559a.equals(((nm4) obj).f19559a);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.f19559a;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.f19559a.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        dm4.p(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.f19559a;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.f19559a;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.f19559a + ")";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(u42<? super T, V> u42Var) {
        return new nm4(dm4.p(u42Var.apply(this.f19559a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        dm4.o(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(qo5<? extends T> qo5Var) {
        dm4.o(qo5Var);
        return this.f19559a;
    }
}
