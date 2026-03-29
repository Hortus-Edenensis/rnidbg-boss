package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, ServiceLoader> f17679a = new HashMap();
    public static final Map<Object, Object> b = new HashMap();

    public static <I, T extends I> I a(Class<I> cls) {
        try {
            I i = (I) b(cls).iterator().next();
            if (i != null) {
                return i;
            }
        } catch (Exception unused) {
        }
        I i2 = (I) b.get(cls);
        if (i2 != null) {
            return i2;
        }
        return null;
    }

    public static <T> ServiceLoader<T> b(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        Map<Class, ServiceLoader> map = f17679a;
        ServiceLoader<T> serviceLoaderLoad = map.get(cls);
        if (serviceLoaderLoad == null) {
            synchronized (map) {
                serviceLoaderLoad = map.get(cls);
                if (serviceLoaderLoad == null) {
                    serviceLoaderLoad = ServiceLoader.load(cls);
                    map.put(cls, serviceLoaderLoad);
                }
            }
        }
        return serviceLoaderLoad;
    }
}
