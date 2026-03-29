package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.iz;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application u;

        static {
            try {
                Object objNr = nr();
                u = (Application) objNr.getClass().getMethod("getApplication", new Class[0]).invoke(objNr, new Object[0]);
                iz.b("MyApplication", "application get success");
            } catch (Throwable th) {
                iz.pn("MyApplication", "application get failed", th);
            }
        }

        private static Object nr() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                iz.pn("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application u() {
            return u;
        }
    }

    public static Context getContext() {
        if (u == null) {
            setContext(null);
        }
        return u;
    }

    public static synchronized void setContext(Context context) {
        if (u == null) {
            if (context != null) {
                u = context.getApplicationContext();
            } else if (u.u() != null) {
                try {
                    Application applicationU = u.u();
                    u = applicationU;
                    if (applicationU != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
