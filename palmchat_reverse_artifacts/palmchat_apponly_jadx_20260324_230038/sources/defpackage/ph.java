package defpackage;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ph implements Iterator<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20016a;
    public int b = 0;

    public ph(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.f20016a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < Array.getLength(this.f20016a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.f20016a;
        int i = this.b;
        this.b = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
