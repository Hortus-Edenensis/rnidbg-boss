package com.zm.fissionsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.zm.adxsdk.protocol.lifecycle.ActivityLifecycleCallback;
import com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class zZZ2W implements IActivityLifecycle {
    public static final String e = "LifecycleMonitor";
    public static zZZ2W f;
    public static List<Activity> g = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<ActivityLifecycleCallback> f16760a = Collections.newSetFromMap(new ConcurrentHashMap());
    public Activity b = null;
    public boolean c = false;
    public Application.ActivityLifecycleCallbacks d = new C1175zZZ2W();

    /* JADX INFO: renamed from: com.zm.fissionsdk.zZZ2W$zZZ2W, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1175zZZ2W implements Application.ActivityLifecycleCallbacks {
        public C1175zZZ2W() {
        }

        public final void a() {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onAppToBackground();
                }
            }
        }

        public final void b() {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onAppToForeground();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityCreated(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityDestroyed(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityPaused(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityResumed(activity);
                }
            }
            zZZ2W.this.b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivitySaveInstanceState(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            zZZ2W.g.add(activity);
            if (zZZ2W.g.size() == 1) {
                WVVzW.a(zZZ2W.e, "应用进入前台");
                zZZ2W.this.c = false;
                b();
            }
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityStarted(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            zZZ2W.g.remove(activity);
            if (zZZ2W.g.size() == 0) {
                WVVzW.a(zZZ2W.e, "应用进入后台");
                zZZ2W.this.c = true;
                a();
                zZZ2W.this.b = null;
            }
            for (ActivityLifecycleCallback activityLifecycleCallback : zZZ2W.this.f16760a) {
                if (activityLifecycleCallback != null) {
                    activityLifecycleCallback.onActivityStopped(activity);
                }
            }
        }
    }

    public static zZZ2W b() {
        if (f == null) {
            synchronized (zZZ2W.class) {
                if (f == null) {
                    f = new zZZ2W();
                }
            }
        }
        return f;
    }

    @Override // com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle
    public Activity getTopStackActivity() {
        WVVzW.a(e, "getTopStackActivity mCurrentActivity:" + this.b);
        return this.b;
    }

    @Override // com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle
    public boolean isAppToBackground() {
        WVVzW.a(e, "isAppToBackground mAppToBackGround:" + this.c);
        return this.c;
    }

    @Override // com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle
    public void register(ActivityLifecycleCallback activityLifecycleCallback) {
        WVVzW.a(e, "register listener:" + activityLifecycleCallback);
        if (activityLifecycleCallback == null) {
            return;
        }
        this.f16760a.add(activityLifecycleCallback);
    }

    @Override // com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle
    public void unregister(ActivityLifecycleCallback activityLifecycleCallback) {
        WVVzW.a(e, "unregister listener:" + activityLifecycleCallback);
        if (activityLifecycleCallback != null && this.f16760a.contains(activityLifecycleCallback)) {
            this.f16760a.remove(activityLifecycleCallback);
        }
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.d);
            WVVzW.a(e, "init");
        } catch (Throwable th) {
            th.printStackTrace();
            WVVzW.a(e, "init error");
        }
    }
}
