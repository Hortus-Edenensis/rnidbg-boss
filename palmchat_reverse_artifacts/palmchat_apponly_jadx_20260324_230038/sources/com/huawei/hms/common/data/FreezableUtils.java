package com.huawei.hms.common.data;

import com.zm.fda.Z0225.O022Z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        O022Z.ZZ00Z.OO22Z oo22z = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return oo22z;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            oo22z.add(it.next().freeze());
        }
        return oo22z;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
