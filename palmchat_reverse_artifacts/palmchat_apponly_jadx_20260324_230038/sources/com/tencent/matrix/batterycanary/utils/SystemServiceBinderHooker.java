package com.tencent.matrix.batterycanary.utils;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SystemServiceBinderHooker {
    private static final String TAG = "Matrix.battery.SystemServiceBinderHooker";

    @Nullable
    private IBinder mDelegateServiceBinder;
    private final HookCallback mHookCallback;

    @Nullable
    private IBinder mOriginServiceBinder;
    private final String mServiceClass;
    private final String mServiceName;

    /* JADX INFO: compiled from: SearchBox */
    public static final class BinderProxyHandler implements InvocationHandler {
        private final IBinder mOriginBinder;
        private final Object mServiceManagerProxy;

        public BinderProxyHandler(String str, String str2, HookCallback hookCallback) throws Exception {
            IBinder currentBinder = getCurrentBinder(str);
            this.mOriginBinder = currentBinder;
            this.mServiceManagerProxy = createServiceManagerProxy(str2, currentBinder, hookCallback);
        }

        private static Object createServiceManagerProxy(String str, IBinder iBinder, final HookCallback hookCallback) throws Exception {
            Class<?> cls = Class.forName(str);
            Class<?> cls2 = Class.forName(str + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                throw new IllegalStateException("get service manager ClassLoader fail!");
            }
            final Object objInvoke = cls2.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new InvocationHandler() { // from class: com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.BinderProxyHandler.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    HookCallback hookCallback2 = hookCallback;
                    if (hookCallback2 != null) {
                        hookCallback2.onServiceMethodInvoke(method, objArr);
                        Object objOnServiceMethodIntercept = hookCallback.onServiceMethodIntercept(objInvoke, method, objArr);
                        if (objOnServiceMethodIntercept != null) {
                            return objOnServiceMethodIntercept;
                        }
                    }
                    try {
                        return method.invoke(objInvoke, objArr);
                    } catch (InvocationTargetException e) {
                        StringBuilder sb = new StringBuilder();
                        if (objArr != null) {
                            for (Object obj2 : objArr) {
                                sb.append(obj2);
                                sb.append(", ");
                            }
                        }
                        MatrixLog.printErrStackTrace(SystemServiceBinderHooker.TAG, e, "#invoke method: %s, args: %s, exp: %s", method.getName(), sb.toString(), e.getLocalizedMessage());
                        throw e.getTargetException();
                    }
                }
            });
        }

        public static IBinder getCurrentBinder(String str) throws Exception {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, str);
        }

        public IBinder createProxyBinder() throws Exception {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, this);
            }
            throw new IllegalStateException("Can not get ClassLoader of " + cls.getName());
        }

        public IBinder getOriginBinder() {
            return this.mOriginBinder;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return "queryLocalInterface".equals(method.getName()) ? this.mServiceManagerProxy : method.invoke(this.mOriginBinder, objArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface HookCallback {
        @Nullable
        Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) throws Throwable;

        void onServiceMethodInvoke(Method method, Object[] objArr);
    }

    public SystemServiceBinderHooker(String str, String str2, HookCallback hookCallback) {
        this.mServiceName = str;
        this.mServiceClass = str2;
        this.mHookCallback = hookCallback;
    }

    public boolean doHook() {
        MatrixLog.i(TAG, "doHook: serviceName:%s, serviceClsName:%s", this.mServiceName, this.mServiceClass);
        try {
            BinderProxyHandler binderProxyHandler = new BinderProxyHandler(this.mServiceName, this.mServiceClass, this.mHookCallback);
            IBinder iBinderCreateProxyBinder = binderProxyHandler.createProxyBinder();
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.mServiceName, iBinderCreateProxyBinder);
            this.mDelegateServiceBinder = iBinderCreateProxyBinder;
            this.mOriginServiceBinder = binderProxyHandler.getOriginBinder();
            return true;
        } catch (Throwable th) {
            MatrixLog.e(TAG, "#doHook exp: " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public boolean doUnHook() {
        if (this.mOriginServiceBinder == null) {
            MatrixLog.w(TAG, "#doUnHook mOriginServiceBinder null", new Object[0]);
            return false;
        }
        if (this.mDelegateServiceBinder == null) {
            MatrixLog.w(TAG, "#doUnHook mDelegateServiceBinder null", new Object[0]);
            return false;
        }
        try {
            if (this.mDelegateServiceBinder != BinderProxyHandler.getCurrentBinder(this.mServiceName)) {
                MatrixLog.w(TAG, "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
                return false;
            }
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.mServiceName, this.mOriginServiceBinder);
            return true;
        } catch (Throwable th) {
            MatrixLog.e(TAG, "#doUnHook exp: " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }
}
