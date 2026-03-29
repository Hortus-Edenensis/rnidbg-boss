package com.heytap.nearx.protobuff.wire;

import com.heytap.nearx.protobuff.wire.e;
import com.heytap.nearx.protobuff.wire.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class h<E extends i> extends e<E> {
    private final Class<E> r;
    private Method s;

    public h(Class<E> cls) {
        super(a.VARINT, cls);
        this.r = cls;
    }

    @Override // com.heytap.nearx.protobuff.wire.e
    public int a(E e) {
        return g.c(e.a());
    }

    @Override // com.heytap.nearx.protobuff.wire.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public E a(f fVar) throws IOException {
        int iF = fVar.f();
        try {
            E e = (E) b().invoke(null, Integer.valueOf(iF));
            if (e != null) {
                return e;
            }
            throw new e.a(iF, this.r);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && ((h) obj).r == this.r;
    }

    public int hashCode() {
        return this.r.hashCode();
    }

    private Method b() {
        Method method = this.s;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.r.getMethod("fromValue", Integer.TYPE);
            this.s = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.heytap.nearx.protobuff.wire.e
    public void a(g gVar, E e) throws IOException {
        gVar.g(e.a());
    }
}
