package com.tencent.matrix.batterycanary.utils;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanSettings;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class BluetoothManagerServiceHooker {
    private static final String TAG = "Matrix.battery.BluetoothHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        @AnyThread
        void onRegisterScanner();

        @AnyThread
        void onStartDiscovery();

        @BinderThread
        @TargetApi(21)
        void onStartScan(int i, @Nullable ScanSettings scanSettings);

        @AnyThread
        @TargetApi(21)
        void onStartScanForIntent(@Nullable ScanSettings scanSettings);
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) throws Throwable {
                if ("registerAdapter".equals(method.getName())) {
                    Object objInvoke = method.invoke(obj, objArr);
                    Object objProxyBluetooth = BluetoothManagerServiceHooker.proxyBluetooth(objInvoke);
                    return objProxyBluetooth == null ? objInvoke : objProxyBluetooth;
                }
                if (!"getBluetoothGatt".equals(method.getName())) {
                    return null;
                }
                Object objInvoke2 = method.invoke(obj, objArr);
                Object objProxyBluetoothGatt = BluetoothManagerServiceHooker.proxyBluetoothGatt(objInvoke2);
                return objProxyBluetoothGatt == null ? objInvoke2 : objProxyBluetoothGatt;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("bluetooth_manager", "android.bluetooth.IBluetoothManager", hookCallback);
    }

    @TargetApi(21)
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
    public static void dispatchRegisterScanner() {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onRegisterScanner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchStartDiscovery() {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartDiscovery();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchStartScan(int i, ScanSettings scanSettings) {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartScan(i, scanSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchStartScanForIntent(ScanSettings scanSettings) {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartScanForIntent(scanSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object proxyBluetooth(final Object obj) {
        try {
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, Class.forName("android.bluetooth.IBluetooth")}, new InvocationHandler() { // from class: com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj2, Method method, Object[] objArr) {
                    if ("startDiscovery".equals(method.getName())) {
                        BluetoothManagerServiceHooker.dispatchStartDiscovery();
                    }
                    try {
                        return BluetoothManagerServiceHooker.safeInvocationReturn(obj, method, objArr);
                    } catch (Throwable th) {
                        MatrixLog.printErrStackTrace(BluetoothManagerServiceHooker.TAG, th, "invokeBluetooth fail", new Object[0]);
                        return null;
                    }
                }
            });
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "proxyBluetooth fail", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object proxyBluetoothGatt(final Object obj) {
        try {
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, Class.forName("android.bluetooth.IBluetoothGatt")}, new InvocationHandler() { // from class: com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj2, Method method, Object[] objArr) {
                    ScanSettings scanSettings;
                    ScanSettings scanSettings2;
                    if ("registerScanner".equals(method.getName())) {
                        BluetoothManagerServiceHooker.dispatchRegisterScanner();
                    } else if ("startScan".equals(method.getName())) {
                        if (objArr.length > 0) {
                            Object obj3 = objArr[0];
                            iIntValue = obj3 instanceof Integer ? ((Integer) obj3).intValue() : -1;
                            scanSettings2 = null;
                            for (Object obj4 : objArr) {
                                if (obj4 instanceof ScanSettings) {
                                    scanSettings2 = (ScanSettings) obj4;
                                }
                            }
                        } else {
                            scanSettings2 = null;
                        }
                        BluetoothManagerServiceHooker.dispatchStartScan(iIntValue, scanSettings2);
                    } else if ("startScanForIntent".equals(method.getName())) {
                        if (objArr != null) {
                            scanSettings = null;
                            for (Object obj5 : objArr) {
                                if (obj5 instanceof ScanSettings) {
                                    scanSettings = (ScanSettings) obj5;
                                }
                            }
                        } else {
                            scanSettings = null;
                        }
                        BluetoothManagerServiceHooker.dispatchStartScanForIntent(scanSettings);
                    }
                    try {
                        return BluetoothManagerServiceHooker.safeInvocationReturn(obj, method, objArr);
                    } catch (Throwable th) {
                        MatrixLog.printErrStackTrace(BluetoothManagerServiceHooker.TAG, th, "invokeBluetoothGatt fail", new Object[0]);
                        return null;
                    }
                }
            });
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "proxyBluetoothGatt fail", new Object[0]);
            return null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static Object safeInvocationReturn(Object obj, Method method, Object[] objArr) {
        Object objInvoke;
        try {
            objInvoke = method.invoke(obj, objArr);
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "reflect invocation fail", new Object[0]);
            objInvoke = null;
        }
        if (objInvoke != null) {
            return objInvoke;
        }
        Class<?> returnType = method.getReturnType();
        if (returnType == null || !returnType.isPrimitive()) {
            return null;
        }
        if (returnType == Byte.TYPE || returnType == Short.TYPE || returnType == Integer.TYPE) {
            return 0;
        }
        if (returnType == Long.TYPE) {
            return 0L;
        }
        if (returnType == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (returnType == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (returnType == Character.TYPE) {
            return (char) 0;
        }
        if (returnType == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        return null;
    }
}
