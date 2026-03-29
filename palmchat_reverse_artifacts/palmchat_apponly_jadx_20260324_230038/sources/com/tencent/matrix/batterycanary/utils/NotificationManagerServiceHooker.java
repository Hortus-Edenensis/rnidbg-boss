package com.tencent.matrix.batterycanary.utils;

import android.app.Notification;
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
public final class NotificationManagerServiceHooker {
    private static final String TAG = "Matrix.battery.NotificationHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: compiled from: SearchBox */
    public interface IListener {
        @AnyThread
        void onCreateNotification(int i, @Nullable Notification notification);

        @AnyThread
        void onCreateNotificationChannel(@Nullable Object obj);
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.matrix.batterycanary.utils.NotificationManagerServiceHooker.1
            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.matrix.batterycanary.utils.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                Notification notification = null;
                obj = null;
                Object obj = null;
                if (!"createNotificationChannels".equals(method.getName())) {
                    if ("enqueueNotificationWithTag".equals(method.getName())) {
                        int iIntValue = -1;
                        for (Object obj2 : objArr) {
                            if (obj2 instanceof Integer) {
                                if (iIntValue == -1) {
                                    iIntValue = ((Integer) obj2).intValue();
                                }
                            } else if (obj2 instanceof Notification) {
                                notification = (Notification) obj2;
                            }
                        }
                        NotificationManagerServiceHooker.dispatchCreateNotification(iIntValue, notification);
                        return;
                    }
                    return;
                }
                if (objArr != null) {
                    for (Object obj3 : objArr) {
                        if (obj3 != null && obj3.getClass().getName().equals("android.content.pm.ParceledListSlice")) {
                            try {
                                Method declaredMethod = obj3.getClass().getDeclaredMethod("getList", new Class[0]);
                                if (declaredMethod != null) {
                                    Object objInvoke = declaredMethod.invoke(obj3, new Object[0]);
                                    if (objInvoke instanceof Iterable) {
                                        Iterator it = ((Iterable) objInvoke).iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            if (next != null && next.getClass().getName().equals("android.app.NotificationChannel")) {
                                                obj = next;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                MatrixLog.w(NotificationManagerServiceHooker.TAG, "try parse args fail: " + e.getMessage(), new Object[0]);
                            }
                        }
                    }
                }
                NotificationManagerServiceHooker.dispatchCreateNotificationChannel(obj);
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("notification", "android.app.INotificationManager", hookCallback);
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
    public static void dispatchCreateNotification(int i, @Nullable Notification notification) {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onCreateNotification(i, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchCreateNotificationChannel(@Nullable Object obj) {
        Iterator<IListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().onCreateNotificationChannel(obj);
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
