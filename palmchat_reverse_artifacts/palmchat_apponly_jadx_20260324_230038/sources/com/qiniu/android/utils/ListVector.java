package com.qiniu.android.utils;

import java.util.Arrays;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ListVector<E> extends Vector<E> {

    /* JADX INFO: compiled from: SearchBox */
    public interface EnumeratorHandler<T> {
        boolean enumerate(T t);
    }

    public ListVector() {
    }

    public synchronized void enumerateObjects(EnumeratorHandler<? super E> enumeratorHandler) {
        if (enumeratorHandler == null) {
            return;
        }
        Object[] objArr = ((Vector) this).elementData;
        int i = ((Vector) this).elementCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (enumeratorHandler.enumerate(objArr[i2])) {
                break;
            }
        }
    }

    public ListVector(int i, int i2) {
        super(i, i2);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized ListVector<E> subList(int i, int i2) {
        ListVector<E> listVector;
        listVector = new ListVector<>();
        if (((Vector) this).elementData.getClass() != Object[].class) {
            Object[] objArrCopyOf = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount, Object[].class);
            ((Vector) listVector).elementData = objArrCopyOf;
            ((Vector) listVector).elementCount = objArrCopyOf.length;
        } else {
            ((Vector) listVector).elementData = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount);
            ((Vector) listVector).elementCount = ((Vector) this).elementCount;
        }
        return listVector;
    }
}
