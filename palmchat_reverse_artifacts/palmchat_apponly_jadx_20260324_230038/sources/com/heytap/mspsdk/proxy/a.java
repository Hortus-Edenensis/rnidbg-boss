package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.exception.MspUnHandledException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.client.BaseServiceClient;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Long, CountDownLatch> f6405a;
    private final Map<Object, d> b;
    private final Object c;

    /* JADX INFO: renamed from: com.heytap.mspsdk.proxy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0398a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6406a = new a();
    }

    private a() {
        this.f6405a = new ConcurrentHashMap<>();
        this.b = DesugarCollections.synchronizedMap(new WeakHashMap());
        this.c = new Object();
    }

    public static a a() {
        return C0398a.f6406a;
    }

    public Object b() {
        return this.c;
    }

    public ConcurrentHashMap<Long, CountDownLatch> c() {
        return this.f6405a;
    }

    public <T> T a(Class<T> cls, Parcelable parcelable, Bundle bundle) {
        return (T) a(cls, null, parcelable, bundle);
    }

    private <T> T a(Class<T> cls, com.heytap.mspsdk.event.b bVar, Parcelable parcelable, Bundle bundle) {
        return (T) a(null, cls, bVar, parcelable, bundle);
    }

    public <T> T a(T t, com.heytap.mspsdk.event.b bVar) {
        return (T) a(t, null, bVar, null, null);
    }

    public <T> T a(Object obj, Class<T> cls, com.heytap.mspsdk.event.b bVar, Parcelable parcelable, Bundle bundle) {
        Class cls2;
        Class cls3;
        d dVar;
        if (obj == null && cls == null) {
            throw new RuntimeException("The instance of 'target' and 'class' is null");
        }
        try {
            if (cls != null) {
                dVar = new d(this, cls, parcelable, bundle, bVar);
                cls3 = cls;
                cls2 = cls3;
            } else {
                cls2 = obj.getClass();
                Class[] interfaces = obj.getClass().getInterfaces();
                if (interfaces == null || interfaces.length <= 0) {
                    throw new RuntimeException("The instance of 'target' doesn't implement an interface, please add 'makeInterface=true' at your moudle's BridgeTarget annotation");
                }
                MspLog.iIgnore("ApiProxy", "interfaces length " + interfaces.length);
                for (Class cls4 : interfaces) {
                    MspLog.iIgnore("ApiProxy", "interfaces clazz name is " + cls4.getSimpleName());
                }
                cls3 = interfaces[0];
                dVar = new d(this, obj, parcelable, bundle, bVar);
            }
            T t = (T) Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls3}, dVar);
            if (cls != null) {
                this.b.put(t, dVar);
            }
            return t;
        } catch (Throwable th) {
            throw new MspUnHandledException(th);
        }
    }

    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof BaseServiceClient) {
                ((BaseServiceClient) obj).destroyClient();
                return;
            }
            if (obj instanceof com.heytap.msp.ipc.a.f) {
                ((com.heytap.msp.ipc.a.f) obj).d();
                return;
            }
            d dVarRemove = this.b.remove(obj);
            if (dVarRemove != null) {
                com.heytap.msp.ipc.a.g gVarB = dVarRemove.b();
                if (gVarB instanceof com.heytap.msp.ipc.a.f) {
                    ((com.heytap.msp.ipc.a.f) gVarB).d();
                }
            }
        } catch (Throwable th) {
            MspLog.w("ApiProxy", th.getMessage());
        }
    }
}
