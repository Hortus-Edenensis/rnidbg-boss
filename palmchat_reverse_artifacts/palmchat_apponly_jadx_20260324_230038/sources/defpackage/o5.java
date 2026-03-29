package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.api.JCoreManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class o5 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19695a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        k63.a("ActivityLifecycle", "onActivityCreated:" + activity.getClass().getCanonicalName());
        try {
            JAnalyticsAction jAnalyticsAction = tv2.b;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchStatus(activity, "onCreate");
            }
        } catch (Throwable unused) {
            k63.a("ActivityLifecycle", "onActivityCreated failed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            k63.g("ActivityLifecycle", "onActivityPaused:" + activity.getClass().getCanonicalName());
            JAnalyticsAction jAnalyticsAction = tv2.b;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchPause(activity);
            }
            if (tv2.g) {
                return;
            }
            fp4.g().m(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            k63.g("ActivityLifecycle", "onActivityResumed:" + activity.getClass().getCanonicalName());
            JAnalyticsAction jAnalyticsAction = tv2.b;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchResume(activity);
            }
            if (tv2.g) {
                return;
            }
            fp4.g().n(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            k63.a("ActivityLifecycle", "onActivityStarted:" + activity.getClass().getCanonicalName());
        }
        try {
            if (f19695a == 0) {
                k63.a("ActivityLifecycle", "isForeground");
                if (activity != null) {
                    JCoreManager.onEvent(activity.getApplicationContext(), "JCore", 66, null, null, Boolean.TRUE);
                }
                JAnalyticsAction jAnalyticsAction = tv2.b;
                if (jAnalyticsAction != null) {
                    jAnalyticsAction.dispatchStatus(activity, "onStart");
                }
            }
            f19695a++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            k63.a("ActivityLifecycle", "onActivityStopped:" + activity.getClass().getCanonicalName());
            int i = f19695a;
            if (i > 0) {
                f19695a = i - 1;
            }
            if (f19695a == 0) {
                k63.a("ActivityLifecycle", "is not Foreground");
                JCoreManager.onEvent(tv2.a(activity), "JCore", 66, null, null, Boolean.FALSE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
