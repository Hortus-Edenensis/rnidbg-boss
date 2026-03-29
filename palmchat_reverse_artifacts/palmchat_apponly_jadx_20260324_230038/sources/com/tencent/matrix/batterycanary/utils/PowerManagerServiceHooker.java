package com.tencent.matrix.batterycanary.utils;

import android.os.Build;
import android.os.IBinder;
import android.os.WorkSource;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PowerManagerServiceHooker {
    private static final String TAG = "Matrix.battery.PowerHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public static final class AcquireWakeLockArgs {
        int flags;
        String historyTag;
        String packageName;
        String tag;
        IBinder token;
        WorkSource ws;

        private AcquireWakeLockArgs() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class AcquireWakeLockArgsCompatible {
        private AcquireWakeLockArgsCompatible() {
        }

        public static AcquireWakeLockArgs createAcquireWakeLockArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i), Build.VERSION.CODENAME, Integer.valueOf(i));
            return createAcquireWakeLockArgsAccordingToArgsLength(objArr);
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgs4(Object[] objArr) {
            if (objArr.length != 4) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            AcquireWakeLockArgs acquireWakeLockArgs = new AcquireWakeLockArgs();
            Object obj = objArr[2];
            if (obj != null && !(obj instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj);
                return null;
            }
            acquireWakeLockArgs.tag = (String) obj;
            Object obj2 = objArr[3];
            if (obj2 != null && !(obj2 instanceof WorkSource)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", obj2);
                return null;
            }
            acquireWakeLockArgs.ws = (WorkSource) obj2;
            Object obj3 = objArr[0];
            if (obj3 instanceof Integer) {
                acquireWakeLockArgs.flags = ((Integer) obj3).intValue();
                Object obj4 = objArr[1];
                if (!(obj4 instanceof IBinder)) {
                    MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", obj4);
                    return null;
                }
                acquireWakeLockArgs.token = (IBinder) obj4;
            } else {
                if (!(obj3 instanceof IBinder)) {
                    MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", obj3);
                    return null;
                }
                acquireWakeLockArgs.token = (IBinder) obj3;
                Object obj5 = objArr[1];
                if (!(obj5 instanceof Integer)) {
                    MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", obj5);
                    return null;
                }
                acquireWakeLockArgs.flags = ((Integer) obj5).intValue();
            }
            return acquireWakeLockArgs;
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgs6or5(Object[] objArr) {
            if (objArr.length != 6 && objArr.length != 5) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            AcquireWakeLockArgs acquireWakeLockArgs = new AcquireWakeLockArgs();
            Object obj = objArr[0];
            if (!(obj instanceof IBinder)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", obj);
                return null;
            }
            acquireWakeLockArgs.token = (IBinder) obj;
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Integer)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", obj2);
                return null;
            }
            acquireWakeLockArgs.flags = ((Integer) obj2).intValue();
            Object obj3 = objArr[2];
            if (obj3 != null && !(obj3 instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj3);
                return null;
            }
            acquireWakeLockArgs.tag = (String) obj3;
            Object obj4 = objArr[3];
            if (obj4 != null && !(obj4 instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 3 not String, %s", obj4);
                return null;
            }
            acquireWakeLockArgs.packageName = (String) obj4;
            Object obj5 = objArr[4];
            if (obj5 != null && !(obj5 instanceof WorkSource)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", obj5);
                return null;
            }
            acquireWakeLockArgs.ws = (WorkSource) obj5;
            if (objArr.length == 5) {
                return acquireWakeLockArgs;
            }
            Object obj6 = objArr[5];
            if (obj6 == null || (obj6 instanceof String)) {
                acquireWakeLockArgs.historyTag = (String) obj6;
                return acquireWakeLockArgs;
            }
            MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 5 not String, %s", obj6);
            return null;
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            return length != 4 ? createAcquireWakeLockArgs6or5(objArr) : createAcquireWakeLockArgs4(objArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        void onAcquireWakeLock(IBinder iBinder, int i, String str, String str2, @Nullable WorkSource workSource, @Nullable String str3);

        void onReleaseWakeLock(IBinder iBinder, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReleaseWakeLockArgs {
        int flags;
        IBinder token;

        private ReleaseWakeLockArgs() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReleaseWakeLockArgsCompatible {
        private ReleaseWakeLockArgsCompatible() {
        }

        public static ReleaseWakeLockArgs createReleaseWakeLockArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i), Build.VERSION.CODENAME, Integer.valueOf(i));
            return createReleaseWakeLockArgsAccordingToArgsLength(objArr);
        }

        private static ReleaseWakeLockArgs createReleaseWakeLockArgs2(Object[] objArr) {
            if (objArr.length != 2) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            ReleaseWakeLockArgs releaseWakeLockArgs = new ReleaseWakeLockArgs();
            Object obj = objArr[0];
            if (!(obj instanceof IBinder)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", obj);
                return null;
            }
            releaseWakeLockArgs.token = (IBinder) obj;
            Object obj2 = objArr[1];
            if (obj2 instanceof Integer) {
                releaseWakeLockArgs.flags = ((Integer) obj2).intValue();
                return releaseWakeLockArgs;
            }
            MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", obj2);
            return null;
        }

        private static ReleaseWakeLockArgs createReleaseWakeLockArgsAccordingToArgsLength(Object[] objArr) {
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
            return createReleaseWakeLockArgs2(objArr);
        }
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.PowerManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                MatrixLog.v(PowerManagerServiceHooker.TAG, "onServiceMethodInvoke: method name %s", method.getName());
                PowerManagerServiceHooker.dispatchListeners(method, objArr);
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("power", "android.os.IPowerManager", hookCallback);
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

    private static void dispatchAcquireWakeLock(Object[] objArr) {
        AcquireWakeLockArgs acquireWakeLockArgsCreateAcquireWakeLockArgs = AcquireWakeLockArgsCompatible.createAcquireWakeLockArgs(objArr);
        if (acquireWakeLockArgsCreateAcquireWakeLockArgs == null) {
            MatrixLog.w(TAG, "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (PowerManagerServiceHooker.class) {
            for (int i = 0; i < sListeners.size(); i++) {
                sListeners.get(i).onAcquireWakeLock(acquireWakeLockArgsCreateAcquireWakeLockArgs.token, acquireWakeLockArgsCreateAcquireWakeLockArgs.flags, acquireWakeLockArgsCreateAcquireWakeLockArgs.tag, acquireWakeLockArgsCreateAcquireWakeLockArgs.packageName, acquireWakeLockArgsCreateAcquireWakeLockArgs.ws, acquireWakeLockArgsCreateAcquireWakeLockArgs.historyTag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchListeners(Method method, Object[] objArr) {
        if (method.getName().equals("acquireWakeLock")) {
            dispatchAcquireWakeLock(objArr);
        } else if (method.getName().equals("releaseWakeLock")) {
            dispatchReleaseWakeLock(objArr);
        }
    }

    private static void dispatchReleaseWakeLock(Object[] objArr) {
        ReleaseWakeLockArgs releaseWakeLockArgsCreateReleaseWakeLockArgs = ReleaseWakeLockArgsCompatible.createReleaseWakeLockArgs(objArr);
        if (releaseWakeLockArgsCreateReleaseWakeLockArgs == null) {
            MatrixLog.w(TAG, "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (PowerManagerServiceHooker.class) {
            for (int i = 0; i < sListeners.size(); i++) {
                sListeners.get(i).onReleaseWakeLock(releaseWakeLockArgsCreateReleaseWakeLockArgs.token, releaseWakeLockArgsCreateReleaseWakeLockArgs.flags);
            }
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
