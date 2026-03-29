package com.tencent.matrix.batterycanary.utils;

import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class LocationManagerServiceHooker {
    private static final String TAG = "Matrix.battery.LocationHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        @AnyThread
        void onRequestLocationUpdates(long j, float f);
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.LocationManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                if ("requestLocationUpdates".equals(method.getName())) {
                    long jLongValue = -1;
                    float fFloatValue = -1.0f;
                    if (objArr != null) {
                        for (Object obj : objArr) {
                            if (obj != null && "android.location.LocationRequest".equals(obj.getClass().getName())) {
                                try {
                                    Method declaredMethod = obj.getClass().getDeclaredMethod("getFastestInterval", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    jLongValue = ((Long) declaredMethod.invoke(obj, new Object[0])).longValue();
                                    Method declaredMethod2 = obj.getClass().getDeclaredMethod("getSmallestDisplacement", new Class[0]);
                                    declaredMethod2.setAccessible(true);
                                    fFloatValue = ((Float) declaredMethod2.invoke(obj, new Object[0])).floatValue();
                                } catch (Throwable th) {
                                    MatrixLog.printErrStackTrace(LocationManagerServiceHooker.TAG, th, "", new Object[0]);
                                }
                            }
                        }
                    }
                    LocationManagerServiceHooker.dispatchRequestLocationUpdates(jLongValue, fFloatValue);
                }
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("location", "android.location.ILocationManager", hookCallback);
    }

    public static synchronized void addListener(IListener iListener) {
        if (iListener == null) {
            return;
        }
        if (sListeners.contains(iListener)) {
            return;
        }
        sListeners.add(iListener);
        checkHook();
    }

    private static void checkHook() {
        if (sTryHook || sListeners.isEmpty()) {
            return;
        }
        MatrixLog.i(TAG, "checkHook hookRet:%b", Boolean.valueOf(sHookHelper.doHook()));
        sTryHook = true;
    }

    private static void checkUnHook() {
        if (sTryHook && sListeners.isEmpty()) {
            MatrixLog.i(TAG, "checkUnHook unHookRet:%b", Boolean.valueOf(sHookHelper.doUnHook()));
            sTryHook = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchRequestLocationUpdates(long j, float f) {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onRequestLocationUpdates(j, f);
        }
    }

    public static synchronized void release() {
        sListeners.clear();
        checkUnHook();
    }

    public static synchronized void removeListener(IListener iListener) {
        if (iListener == null) {
            return;
        }
        sListeners.remove(iListener);
        checkUnHook();
    }
}
