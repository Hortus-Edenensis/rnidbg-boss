package com.opos.process.bridge.provider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ThreadLocalUtil {
    private static final ThreadLocal<Map<String, Object>> THREAD_CONTEXT = new MapThreadLocal();

    /* JADX INFO: compiled from: SearchBox */
    public static class MapThreadLocal extends ThreadLocal<Map<String, Object>> {
        private MapThreadLocal() {
        }

        @Override // java.lang.ThreadLocal
        public Map<String, Object> initialValue() {
            return new HashMap<String, Object>(8) { // from class: com.opos.process.bridge.provider.ThreadLocalUtil.MapThreadLocal.1
                private static final long serialVersionUID = 3637958959138295593L;

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public Object put(String str, Object obj) {
                    return super.put(str, obj);
                }
            };
        }
    }

    private ThreadLocalUtil() {
    }

    public static void clear() {
        THREAD_CONTEXT.remove();
    }

    public static Object get(String str) {
        return getContextMap().get(str);
    }

    private static Map<String, Object> getContextMap() {
        return THREAD_CONTEXT.get();
    }

    public static void put(String str, Object obj) {
        getContextMap().put(str, obj);
    }

    public static Object remove(String str) {
        return getContextMap().remove(str);
    }

    public static void put(Map<String, Object> map) {
        for (String str : map.keySet()) {
            put(str, map.get(str));
        }
    }

    public static void remove() {
        getContextMap().clear();
    }

    public static void remove(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }
}
