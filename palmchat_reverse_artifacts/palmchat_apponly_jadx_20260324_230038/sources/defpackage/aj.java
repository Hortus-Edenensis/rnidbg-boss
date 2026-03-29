package defpackage;

import java.util.AbstractList;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aj<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<T> f1235a;

    public aj(AtomicReferenceArray<T> atomicReferenceArray) {
        this.f1235a = atomicReferenceArray;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f1235a.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1235a.length();
    }
}
