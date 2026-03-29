package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    private static final SparseArray<HashMap> u = new SparseArray<>();

    public static <T> T nr(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = u.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.remove(str);
    }

    public static <T> void u(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        int iHashCode = cls.hashCode();
        SparseArray<HashMap> sparseArray = u;
        HashMap map = sparseArray.get(iHashCode);
        if (map == null) {
            map = new HashMap();
            sparseArray.put(iHashCode, map);
        }
        map.put(str, t);
    }

    public static <T> void u(String str) {
        int size = u.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HashMap> sparseArray = u;
            HashMap map = sparseArray.get(sparseArray.keyAt(i));
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static <T> T u(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = u.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.get(str);
    }
}
