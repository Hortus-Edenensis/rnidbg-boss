package com.tencent.matrix.batterycanary.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AlarmManagerServiceHooker {
    private static final String TAG = "Matrix.battery.AlarmHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners;
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CancelArgs {
        AlarmManager.OnAlarmListener onAlarmListener;
        PendingIntent operation;

        private CancelArgs() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CancelArgsCompatible {
        private CancelArgsCompatible() {
        }

        public static CancelArgs createCancelArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs args null", new Object[0]);
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i), Build.VERSION.CODENAME, Integer.valueOf(i));
            return createCancelArgsAccordingToArgsLength(objArr);
        }

        private static CancelArgs createCancelArgs1(Object[] objArr) {
            if (objArr.length != 1) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            CancelArgs cancelArgs = new CancelArgs();
            Object obj = objArr[0];
            if (obj == null || (obj instanceof PendingIntent)) {
                cancelArgs.operation = (PendingIntent) obj;
                return cancelArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs1 args idx 0 not PendingIntent, %s", obj);
            return null;
        }

        private static CancelArgs createCancelArgs2(Object[] objArr) {
            if (objArr.length != 2) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            CancelArgs cancelArgs = new CancelArgs();
            Object obj = objArr[0];
            if (obj == null || (obj instanceof PendingIntent)) {
                cancelArgs.operation = (PendingIntent) obj;
                return cancelArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs2 args idx 0 not PendingIntent, %s", obj);
            return null;
        }

        private static CancelArgs createCancelArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            return length != 1 ? createCancelArgs2(objArr) : createCancelArgs1(objArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);

        void onAlarmSet(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SetArgs {
        int flags;
        long intervalMillis;
        AlarmManager.OnAlarmListener onAlarmListener;
        PendingIntent operation;
        long triggerAtMillis;
        int type;
        long windowMillis;

        private SetArgs() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SetArgsCompatible {
        private SetArgsCompatible() {
        }

        public static SetArgs createSetArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args null", new Object[0]);
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i), Build.VERSION.CODENAME, Integer.valueOf(i));
            return createSetArgsAccordingToArgsLength(objArr);
        }

        private static SetArgs createSetArgs11(Object[] objArr) {
            if (objArr.length != 11) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[1];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[2];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[3];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[4];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[5];
            if (!(obj5 instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 5 not Integer, %s", obj5);
                return null;
            }
            setArgs.flags = ((Integer) obj5).intValue();
            Object obj6 = objArr[6];
            if (obj6 == null || (obj6 instanceof PendingIntent)) {
                setArgs.operation = (PendingIntent) obj6;
                return setArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 6 not PendingIntent, %s", obj6);
            return null;
        }

        private static SetArgs createSetArgs3(Object[] objArr) {
            if (objArr.length != 3) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (obj3 == null || (obj3 instanceof PendingIntent)) {
                setArgs.operation = (PendingIntent) obj3;
                return setArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not PendingIntent, %s", obj3);
            return null;
        }

        private static SetArgs createSetArgs4(Object[] objArr) {
            if (objArr.length != 4) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (obj4 == null || (obj4 instanceof PendingIntent)) {
                setArgs.operation = (PendingIntent) obj4;
                return setArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not PendingIntent, %s", obj4);
            return null;
        }

        private static SetArgs createSetArgs7or6(Object[] objArr) {
            if (objArr.length != 7 && objArr.length != 6) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[4];
            if (obj5 == null || (obj5 instanceof PendingIntent)) {
                setArgs.operation = (PendingIntent) obj5;
                return setArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not PendingIntent, %s", obj5);
            return null;
        }

        private static SetArgs createSetArgs8(Object[] objArr) {
            if (objArr.length != 8) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[4];
            if (!(obj5 instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not Integer, %s", obj5);
                return null;
            }
            setArgs.flags = ((Integer) obj5).intValue();
            Object obj6 = objArr[5];
            if (obj6 == null || (obj6 instanceof PendingIntent)) {
                setArgs.operation = (PendingIntent) obj6;
                return setArgs;
            }
            MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 5 not PendingIntent, %s", obj6);
            return null;
        }

        private static SetArgs createSetArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            return length != 3 ? length != 4 ? (length == 6 || length == 7) ? createSetArgs7or6(objArr) : length != 8 ? createSetArgs11(objArr) : createSetArgs8(objArr) : createSetArgs4(objArr) : createSetArgs3(objArr);
        }
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.AlarmManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                MatrixLog.v(AlarmManagerServiceHooker.TAG, "onServiceMethodInvoke: method name %s", method.getName());
                AlarmManagerServiceHooker.dispatchListeners(method, objArr);
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker(NotificationCompat.CATEGORY_ALARM, "android.app.IAlarmManager", hookCallback);
        sListeners = new ArrayList();
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

    private static void dispatchCancel(Object[] objArr) {
        CancelArgs cancelArgsCreateCancelArgs = CancelArgsCompatible.createCancelArgs(objArr);
        if (cancelArgsCreateCancelArgs == null) {
            MatrixLog.w(TAG, "dispatchCancel cancelArgs null", new Object[0]);
            return;
        }
        synchronized (AlarmManagerServiceHooker.class) {
            for (int i = 0; i < sListeners.size(); i++) {
                sListeners.get(i).onAlarmRemove(cancelArgsCreateCancelArgs.operation, cancelArgsCreateCancelArgs.onAlarmListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchListeners(Method method, Object[] objArr) {
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            dispatchSet(objArr);
        } else if (method.getName().equals("remove")) {
            dispatchCancel(objArr);
        }
    }

    private static void dispatchSet(Object[] objArr) {
        SetArgs setArgsCreateSetArgs = SetArgsCompatible.createSetArgs(objArr);
        if (setArgsCreateSetArgs == null) {
            MatrixLog.w(TAG, "dispatchSet setArgs null", new Object[0]);
            return;
        }
        synchronized (AlarmManagerServiceHooker.class) {
            for (int i = 0; i < sListeners.size(); i++) {
                sListeners.get(i).onAlarmSet(setArgsCreateSetArgs.type, setArgsCreateSetArgs.triggerAtMillis, setArgsCreateSetArgs.windowMillis, setArgsCreateSetArgs.intervalMillis, setArgsCreateSetArgs.flags, setArgsCreateSetArgs.operation, setArgsCreateSetArgs.onAlarmListener);
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
