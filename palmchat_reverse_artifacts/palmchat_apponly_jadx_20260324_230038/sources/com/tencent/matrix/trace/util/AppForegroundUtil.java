package com.tencent.matrix.trace.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.platform.comapi.map.MapController;
import com.oplus.tblplayer.Constants;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AppForegroundUtil {
    INSTANCE;

    private static final String TAG = "Matrix.AppActiveDelegate";
    private String currentFragmentName;
    private Handler handler;
    private boolean isAppForeground = false;
    private String visibleScene = MapController.DEFAULT_LAYER_TAG;
    private Controller controller = new Controller();
    private boolean isInit = false;

    AppForegroundUtil() {
    }

    public static String getTopActivityName() {
        ArrayMap arrayMap;
        System.currentTimeMillis();
        try {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                arrayMap = (ArrayMap) declaredField.get(objInvoke);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (arrayMap.size() < 1) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return ((Activity) declaredField3.get(obj)).getClass().getName();
                }
            }
            return null;
        } finally {
            System.currentTimeMillis();
        }
    }

    private static boolean isActivityInterestingToUser() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() < 1) {
                return false;
            }
            for (Object obj : arrayMap.values()) {
                Field declaredField2 = obj.getClass().getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isInterestingToUser() {
        return isActivityInterestingToUser();
    }

    private static boolean isServiceInterestingToUser() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mServices");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() < 1) {
                return false;
            }
            for (Object obj : arrayMap.values()) {
                obj.getClass();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchBackground(String str) {
        this.isAppForeground = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchForeground(String str) {
        this.isAppForeground = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScene(Activity activity) {
        this.visibleScene = activity.getClass().getName();
    }

    public String getCurrentFragmentName() {
        return this.currentFragmentName;
    }

    public String getVisibleScene() {
        return this.visibleScene;
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
    }

    public boolean isAppForeground() {
        return this.isAppForeground;
    }

    public void setCurrentFragmentName(String str) {
        this.currentFragmentName = str;
        updateScene(str);
    }

    private void updateScene(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = Constants.STRING_VALUE_UNSET;
        }
        sb.append(str);
        this.visibleScene = sb.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class Controller implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        private Controller() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            AppForegroundUtil.this.updateScene(activity);
            AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
            appForegroundUtil.onDispatchForeground(appForegroundUtil.getVisibleScene());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (AppForegroundUtil.getTopActivityName() == null) {
                AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
                appForegroundUtil.onDispatchBackground(appForegroundUtil.getVisibleScene());
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i == 20 && AppForegroundUtil.this.isAppForeground) {
                AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
                appForegroundUtil.onDispatchBackground(appForegroundUtil.visibleScene);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
