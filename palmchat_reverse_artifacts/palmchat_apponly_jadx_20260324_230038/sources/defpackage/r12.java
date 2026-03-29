package defpackage;

import com.google.common.collect.k0;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class r12<E> extends h12<E> implements Set<E> {
    @Override // defpackage.h12, defpackage.p12
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return k0.a(this, obj);
    }

    public int standardHashCode() {
        return k0.d(this);
    }

    @Override // defpackage.h12
    public boolean standardRemoveAll(Collection<?> collection) {
        return k0.j(this, (Collection) dm4.o(collection));
    }
}
