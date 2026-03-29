package com.tencent.matrix.trace.hacker;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.tencent.matrix.trace.config.IssueFixConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ActivityThreadHacker {
    private static final String TAG = "Matrix.ActivityThreadHacker";
    private static final int VERSION_CODES_O_MR1 = 27;
    private static long sApplicationCreateBeginTime;
    private static long sApplicationCreateEndTime;
    public static AppMethodBeat.IndexRecord sLastLaunchActivityMethodIndex = new AppMethodBeat.IndexRecord();
    public static AppMethodBeat.IndexRecord sApplicationCreateBeginMethodIndex = new AppMethodBeat.IndexRecord();
    public static int sApplicationCreateScene = Integer.MIN_VALUE;
    private static final HashSet<IApplicationCreateListener> listeners = new HashSet<>();
    private static boolean sIsCreatedByLaunchActivity = false;

    /* JADX INFO: compiled from: SearchBox */
    public static final class HackCallback implements Handler.Callback {
        private static final int CREATE_SERVICE = 114;
        private static final int EXECUTE_TRANSACTION = 159;
        private static final int LAUNCH_ACTIVITY = 100;
        private static final int RECEIVER = 113;
        private static final int RELAUNCH_ACTIVITY = 126;
        private static final int SERIVCE_ARGS = 115;
        private static final int SLEEPING = 137;
        private static final int STOP_ACTIVITY_HIDE = 104;
        private static final int STOP_ACTIVITY_SHOW = 103;
        private static final int STOP_SERVICE = 116;
        private static int hasPrint = Integer.MAX_VALUE;
        private static boolean isCreated = false;
        private final Handler.Callback mOriginalCallback;
        private Method method = null;

        public HackCallback(Handler.Callback callback) {
            this.mOriginalCallback = callback;
        }

        @RequiresApi(api = 21)
        private void fix() {
            try {
                Field declaredField = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    ((ConcurrentLinkedQueue) declaredField.get(null)).clear();
                    MatrixLog.i(ActivityThreadHacker.TAG, "Fix SP ANR sPendingWorkFinishers.clear successful", new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR ClassNotFoundException = " + e.getMessage(), new Object[0]);
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR IllegalAccessException =" + e2.getMessage(), new Object[0]);
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR NoSuchFieldException = " + e3.getMessage(), new Object[0]);
                e3.printStackTrace();
            } catch (Exception e4) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR Exception = " + e4.getMessage(), new Object[0]);
                e4.printStackTrace();
            }
        }

        private boolean isLaunchActivity(Message message) {
            if (Build.VERSION.SDK_INT <= 27) {
                int i = message.what;
                return i == 100 || i == 126;
            }
            if (message.what == 159 && message.obj != null) {
                try {
                    if (this.method == null) {
                        Method declaredMethod = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                        this.method = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    List list = (List) this.method.invoke(message.obj, new Object[0]);
                    if (!list.isEmpty()) {
                        return list.get(0).getClass().getName().endsWith(".LaunchActivityItem");
                    }
                } catch (Exception e) {
                    MatrixLog.e(ActivityThreadHacker.TAG, "[isLaunchActivity] %s", e);
                }
            }
            return message.what == 100;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i;
            int i2;
            if (IssueFixConfig.getsInstance().isEnableFixSpApply() && Build.VERSION.SDK_INT <= 25 && ((i2 = message.what) == 115 || i2 == 116 || i2 == 103 || i2 == 104 || i2 == 137)) {
                MatrixLog.i(ActivityThreadHacker.TAG, "Fix SP ANR is enabled", new Object[0]);
                fix();
            }
            if (!AppMethodBeat.isRealTrace()) {
                Handler.Callback callback = this.mOriginalCallback;
                return callback != null && callback.handleMessage(message);
            }
            boolean zIsLaunchActivity = isLaunchActivity(message);
            if (hasPrint > 0) {
                MatrixLog.i(ActivityThreadHacker.TAG, "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s SDK_INT=%s", Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(zIsLaunchActivity), Integer.valueOf(Build.VERSION.SDK_INT));
                hasPrint--;
            }
            if (!isCreated && (zIsLaunchActivity || (i = message.what) == 114 || i == 113)) {
                long unused = ActivityThreadHacker.sApplicationCreateEndTime = SystemClock.uptimeMillis();
                ActivityThreadHacker.sApplicationCreateScene = message.what;
                isCreated = true;
                boolean unused2 = ActivityThreadHacker.sIsCreatedByLaunchActivity = zIsLaunchActivity;
                MatrixLog.i(ActivityThreadHacker.TAG, "application create end, sApplicationCreateScene:%d, isLaunchActivity:%s", Integer.valueOf(message.what), Boolean.valueOf(zIsLaunchActivity));
                synchronized (ActivityThreadHacker.listeners) {
                    Iterator it = ActivityThreadHacker.listeners.iterator();
                    while (it.hasNext()) {
                        ((IApplicationCreateListener) it.next()).onApplicationCreateEnd();
                    }
                }
            }
            Handler.Callback callback2 = this.mOriginalCallback;
            return callback2 != null && callback2.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IApplicationCreateListener {
        void onApplicationCreateEnd();
    }

    public static void addListener(IApplicationCreateListener iApplicationCreateListener) {
        HashSet<IApplicationCreateListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.add(iApplicationCreateListener);
        }
    }

    public static long getApplicationCost() {
        return sApplicationCreateEndTime - sApplicationCreateBeginTime;
    }

    public static long getEggBrokenTime() {
        return sApplicationCreateBeginTime;
    }

    public static void hackSysHandlerCallback() {
        try {
            sApplicationCreateBeginTime = SystemClock.uptimeMillis();
            sApplicationCreateBeginMethodIndex = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<? super Object> superclass = obj2.getClass().getSuperclass();
            if (superclass != null) {
                Field declaredField3 = superclass.getDeclaredField("mCallback");
                declaredField3.setAccessible(true);
                declaredField3.set(obj2, new HackCallback((Handler.Callback) declaredField3.get(obj2)));
            }
            MatrixLog.i(TAG, "hook system handler completed. start:%s SDK_INT:%s", Long.valueOf(sApplicationCreateBeginTime), Integer.valueOf(Build.VERSION.SDK_INT));
        } catch (Exception e) {
            MatrixLog.e(TAG, "hook system handler err! %s", e.getCause().toString());
        }
    }

    public static boolean isCreatedByLaunchActivity() {
        return sIsCreatedByLaunchActivity;
    }

    public static void removeListener(IApplicationCreateListener iApplicationCreateListener) {
        HashSet<IApplicationCreateListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.remove(iApplicationCreateListener);
        }
    }
}
