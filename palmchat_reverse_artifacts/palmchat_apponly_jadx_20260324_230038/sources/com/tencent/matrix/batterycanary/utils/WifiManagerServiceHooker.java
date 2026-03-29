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
public final class WifiManagerServiceHooker {
    private static final String TAG = "Matrix.battery.WifiHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        @AnyThread
        void onGetScanResults();

        @AnyThread
        void onStartScan();
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.WifiManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                if ("startScan".equals(method.getName())) {
                    WifiManagerServiceHooker.dispatchStartScan();
                } else if ("getScanResults".equals(method.getName())) {
                    WifiManagerServiceHooker.dispatchGetScanResults();
                }
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("wifi", "android.net.wifi.IWifiManager", hookCallback);
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
    public static void dispatchGetScanResults() {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onGetScanResults();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchStartScan() {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartScan();
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
