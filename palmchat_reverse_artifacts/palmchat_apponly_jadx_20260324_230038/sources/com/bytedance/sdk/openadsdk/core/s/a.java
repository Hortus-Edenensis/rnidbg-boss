package com.bytedance.sdk.openadsdk.core.s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(String str);

        void u(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB == null) {
            return;
        }
        uVarB.u((Application.ActivityLifecycleCallbacks) null);
    }

    public void u(final u uVar) {
        com.bytedance.sdk.openadsdk.core.y.u uVarB;
        if (uVar == null || (uVarB = com.bytedance.sdk.openadsdk.core.n.o().b()) == null) {
            return;
        }
        uVarB.u(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.openadsdk.core.s.a.1
            private WeakReference<Object> fx;

            private boolean u(@ForbidWrapParam Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.fx) == null || activity != weakReference.get()) ? false : true;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
                a.this.u();
                uVar.u("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
                a.this.u();
                uVar.u("destroy");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@ForbidWrapParam Activity activity) {
                this.fx = new WeakReference<>(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@ForbidWrapParam Activity activity) {
                a.this.u();
                uVar.u();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@ForbidWrapParam Activity activity) {
                a.this.u();
                uVar.u("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@ForbidWrapParam Activity activity) {
                a.this.u();
                uVar.u(u(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
            }
        });
    }
}
