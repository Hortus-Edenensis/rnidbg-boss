package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Map<Class<?>, Method>> f18389a = new HashMap();
    public static final Map<Class<?>, Map<Class<?>, Set<Method>>> b = new HashMap();

    public static Map<Class<?>, sn1> a(Object obj) {
        Class<?> cls = obj.getClass();
        HashMap map = new HashMap();
        Map<Class<?>, Map<Class<?>, Method>> map2 = f18389a;
        if (!map2.containsKey(cls)) {
            c(cls);
        }
        Map<Class<?>, Method> map3 = map2.get(cls);
        if (!map3.isEmpty()) {
            for (Map.Entry<Class<?>, Method> entry : map3.entrySet()) {
                map.put(entry.getKey(), new sn1(obj, entry.getValue()));
            }
        }
        return map;
    }

    public static Map<Class<?>, Set<en1>> b(Object obj) {
        Class<?> cls = obj.getClass();
        HashMap map = new HashMap();
        Map<Class<?>, Map<Class<?>, Set<Method>>> map2 = b;
        if (!map2.containsKey(cls)) {
            c(cls);
        }
        Map<Class<?>, Set<Method>> map3 = map2.get(cls);
        if (!map3.isEmpty()) {
            for (Map.Entry<Class<?>, Set<Method>> entry : map3.entrySet()) {
                HashSet hashSet = new HashSet();
                Iterator<Method> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    hashSet.add(new en1(obj, it.next()));
                }
                map.put(entry.getKey(), hashSet);
            }
        }
        return map;
    }

    public static void c(Class<?> cls) {
        Map<Class<?>, Set<Method>> map = new HashMap<>();
        Map<Class<?>, Method> map2 = new HashMap<>();
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge()) {
                if (method.isAnnotationPresent(qm5.class)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation but requires " + parameterTypes.length + " arguments.  Methods must require a single argument.");
                    }
                    Class<?> cls2 = parameterTypes[0];
                    if (cls2.isInterface()) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " which is an interface.  Subscription must be on a concrete class type.");
                    }
                    if ((1 & method.getModifiers()) == 0) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " but is not 'public'.");
                    }
                    Set<Method> hashSet = map.get(cls2);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(cls2, hashSet);
                    }
                    hashSet.add(method);
                } else if (method.isAnnotationPresent(in4.class)) {
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length != 0) {
                        throw new IllegalArgumentException("Method " + method + "has @Produce annotation but requires " + parameterTypes2.length + " arguments.  Methods must require zero arguments.");
                    }
                    if (method.getReturnType() == Void.class) {
                        throw new IllegalArgumentException("Method " + method + " has a return type of void.  Must declare a non-void type.");
                    }
                    Class<?> returnType = method.getReturnType();
                    if (returnType.isInterface()) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " which is an interface.  Producers must return a concrete class type.");
                    }
                    if (returnType.equals(Void.TYPE)) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation but has no return type.");
                    }
                    if ((1 & method.getModifiers()) == 0) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " but is not 'public'.");
                    }
                    if (map2.containsKey(returnType)) {
                        throw new IllegalArgumentException("Producer for type " + returnType + " has already been registered.");
                    }
                    map2.put(returnType, method);
                } else {
                    continue;
                }
            }
        }
        f18389a.put(cls, map2);
        b.put(cls, map);
    }
}
