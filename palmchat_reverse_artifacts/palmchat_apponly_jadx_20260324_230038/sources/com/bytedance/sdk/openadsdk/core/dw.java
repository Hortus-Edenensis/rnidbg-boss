package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class dw {
    private static volatile Context b;
    private static final AtomicBoolean fx = new AtomicBoolean(false);
    private static volatile com.bytedance.sdk.openadsdk.core.pb.t nr;
    private static volatile qq<com.bytedance.sdk.openadsdk.core.s.u> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application u;

        static {
            try {
                Object objNr = nr();
                u = (Application) objNr.getClass().getMethod("getApplication", new Class[0]).invoke(objNr, new Object[0]);
            } catch (Throwable unused) {
            }
        }

        private static Object nr() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable unused) {
                return null;
            }
        }

        public static Application u() {
            return u;
        }
    }

    public static Context getContext() {
        if (b == null) {
            b = u.u();
        }
        return b;
    }

    public static com.bytedance.sdk.openadsdk.core.pb.t nr() {
        if (nr == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.pb.t.class) {
                if (nr == null) {
                    nr = new com.bytedance.sdk.openadsdk.core.pb.t();
                }
            }
        }
        return nr;
    }

    public static synchronized void u(Context context) {
        if (b == null && context != null) {
            b = context.getApplicationContext();
        }
    }

    public static qq<com.bytedance.sdk.openadsdk.core.s.u> u() {
        if (u == null) {
            synchronized (dw.class) {
                if (u == null) {
                    u = new kj(getContext());
                }
            }
        }
        return u;
    }

    public static Function<SparseArray<Object>, Object> u(int i) {
        return bf.u().u(i);
    }
}
