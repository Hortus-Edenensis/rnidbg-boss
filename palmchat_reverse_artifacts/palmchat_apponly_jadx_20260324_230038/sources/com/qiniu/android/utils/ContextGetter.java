package com.qiniu.android.utils;

import android.app.Application;
import android.content.Context;
import com.qiniu.android.storage.GlobalConfiguration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ContextGetter {
    private static Context context = applicationContext();

    public static Context applicationContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        Context context3 = GlobalConfiguration.appContext;
        if (context3 != null) {
            return context3;
        }
        Application applicationUsingReflection = getApplicationUsingReflection();
        if (applicationUsingReflection != null) {
            context = applicationUsingReflection.getApplicationContext();
        }
        return context;
    }

    private static Application getApplicationUsingReflection() {
        Application application;
        Exception e;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            application = (Application) cls.getMethod("currentApplication", new Class[0]).invoke(null, null);
            if (application != null) {
                return application;
            }
            try {
                return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return application;
            }
        } catch (Exception e3) {
            application = null;
            e = e3;
        }
    }
}
