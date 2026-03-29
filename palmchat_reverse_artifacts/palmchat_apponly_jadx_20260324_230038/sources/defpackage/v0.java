package defpackage;

import com.google.common.base.Optional;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class v0<T> extends Optional<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0<Object> f21332a = new v0<>();
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> b() {
        return f21332a;
    }

    private Object readResolve() {
        return f21332a;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        return (T) dm4.p(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(u42<? super T, V> u42Var) {
        dm4.o(u42Var);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) dm4.o(optional);
    }

    @Override // com.google.common.base.Optional
    public T or(qo5<? extends T> qo5Var) {
        return (T) dm4.p(qo5Var.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
