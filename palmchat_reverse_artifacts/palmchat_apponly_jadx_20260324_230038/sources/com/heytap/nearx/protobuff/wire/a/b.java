package com.heytap.nearx.protobuff.wire.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static IllegalStateException a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }

    public static <T> List<T> b(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof c) {
            list = ((c) list).f6420a;
        }
        if (list == Collections.emptyList() || (list instanceof a)) {
            return list;
        }
        a aVar = new a(list);
        if (!aVar.contains(null)) {
            return aVar;
        }
        throw new IllegalArgumentException(str + ".contains(null)");
    }

    public static <T> List<T> a() {
        return new c(Collections.emptyList());
    }

    public static <K, V> Map<K, V> b() {
        return new LinkedHashMap();
    }

    public static <T> List<T> a(String str, List<T> list) {
        if (list != null) {
            return (list == Collections.emptyList() || (list instanceof a)) ? new c(list) : new ArrayList(list);
        }
        throw new NullPointerException(str + " == null");
    }

    public static <K, V> Map<K, V> a(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(str + " == null");
        }
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (linkedHashMap.containsKey(null)) {
            throw new IllegalArgumentException(str + ".containsKey(null)");
        }
        if (!linkedHashMap.containsValue(null)) {
            return Collections.unmodifiableMap(linkedHashMap);
        }
        throw new IllegalArgumentException(str + ".containsValue(null)");
    }

    public static void a(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static void a(Map<?, ?> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (entry.getValue() == null) {
                throw new NullPointerException("Value for key " + entry.getKey() + " is null");
            }
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
