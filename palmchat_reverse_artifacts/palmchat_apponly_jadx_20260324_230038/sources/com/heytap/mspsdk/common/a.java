package com.heytap.mspsdk.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.heytap.mspsdk.log.MspLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f6382a;

    /* JADX INFO: renamed from: com.heytap.mspsdk.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0396a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6383a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0396a.f6383a;
    }

    private static Activity c() {
        StringBuilder sb;
        MspLog.d("ActivityLifeCallBack", "get activity from reflect");
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getActivityReflect: ");
            sb.append(e.getMessage());
            MspLog.e("ActivityLifeCallBack", sb.toString());
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getActivityReflect: ");
            sb.append(e.getMessage());
            MspLog.e("ActivityLifeCallBack", sb.toString());
        } catch (NoSuchFieldException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("getActivityReflect: ");
            sb.append(e.getMessage());
            MspLog.e("ActivityLifeCallBack", sb.toString());
        } catch (NoSuchMethodException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append("getActivityReflect: ");
            sb.append(e.getMessage());
            MspLog.e("ActivityLifeCallBack", sb.toString());
        } catch (InvocationTargetException e5) {
            e = e5;
            sb = new StringBuilder();
            sb.append("getActivityReflect: ");
            sb.append(e.getMessage());
            MspLog.e("ActivityLifeCallBack", sb.toString());
        }
        for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(obj);
            }
            return null;
        }
        return null;
    }

    public Activity b() {
        Activity activity = this.f6382a;
        return activity == null ? c() : activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityCreated " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f6382a = null;
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityPaused " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f6382a = activity;
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityResumed " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityStopped " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
