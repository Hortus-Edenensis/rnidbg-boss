package com.bytedance.sdk.openadsdk.fx;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean u = false;
    private InterfaceC0308u b;
    private volatile WeakReference<Activity> fx;
    private int nr = 0;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.fx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0308u {
        void nr();

        void u();
    }

    public Activity nr() {
        if (this.fx == null) {
            return null;
        }
        return this.fx.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.fx = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.nr++;
        u = false;
        InterfaceC0308u interfaceC0308u = this.b;
        if (interfaceC0308u != null) {
            interfaceC0308u.nr();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.nr - 1;
        this.nr = i;
        if (i == 0) {
            u = true;
            InterfaceC0308u interfaceC0308u = this.b;
            if (interfaceC0308u != null) {
                interfaceC0308u.u();
            }
        }
    }

    public Boolean u() {
        return Boolean.valueOf(u);
    }

    public void u(InterfaceC0308u interfaceC0308u) {
        this.b = interfaceC0308u;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
