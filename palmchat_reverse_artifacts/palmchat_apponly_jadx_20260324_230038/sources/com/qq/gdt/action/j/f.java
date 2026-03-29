package com.qq.gdt.action.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {
    public static <T> List<List<T>> a(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2 * i;
            if (i3 >= list.size()) {
                return arrayList;
            }
            arrayList.add(list.subList(i3, Math.min(i3 + i, list.size())));
            i2++;
        }
    }

    public static boolean b(Collection<?> collection) {
        return !a(collection);
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
