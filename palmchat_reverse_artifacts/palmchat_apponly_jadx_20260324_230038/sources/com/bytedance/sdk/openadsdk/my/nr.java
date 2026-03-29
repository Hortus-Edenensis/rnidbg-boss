package com.bytedance.sdk.openadsdk.my;

import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr<E> extends SparseArray<E> {
    private final SparseArray<Object> u;

    public nr(SparseArray<Object> sparseArray) {
        this.u = sparseArray;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        if (super.contains(i)) {
            return true;
        }
        SparseArray<Object> sparseArray = this.u;
        return sparseArray != null && sparseArray.indexOfKey(i) >= 0;
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        Object obj;
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null && (obj = sparseArray.get(i, null)) != null) {
            e2 = (E) obj;
        }
        return e2 != null ? e2 : e;
    }

    public SparseArray<Object> u() {
        return this.u;
    }
}
