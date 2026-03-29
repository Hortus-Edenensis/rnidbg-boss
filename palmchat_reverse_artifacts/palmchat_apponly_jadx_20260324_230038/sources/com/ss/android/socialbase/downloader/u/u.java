package com.ss.android.socialbase.downloader.u;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.jk.iz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private int b;
    private final List<InterfaceC0886u> fx;
    private volatile int iz;
    private final Application.ActivityLifecycleCallbacks n;
    private fx nr;
    private WeakReference<Activity> pn;
    private Application u;
    private volatile boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static final u u = new u();
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0886u {
        @MainThread
        void fx();

        @MainThread
        void nr();
    }

    private Object[] b() {
        Object[] array;
        synchronized (this.fx) {
            array = this.fx.size() > 0 ? this.fx.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        this.iz = 0;
        Object[] objArrB = b();
        if (objArrB != null) {
            for (Object obj : objArrB) {
                ((InterfaceC0886u) obj).fx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        this.iz = 1;
        Object[] objArrB = b();
        if (objArrB != null) {
            for (Object obj : objArrB) {
                ((InterfaceC0886u) obj).nr();
            }
        }
    }

    private boolean x() {
        try {
            Application application = this.u;
            if (application == null) {
                return false;
            }
            application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), iz.b(application));
        } catch (Throwable unused) {
            return false;
        }
    }

    private u() {
        this.fx = new ArrayList();
        this.iz = -1;
        this.x = false;
        this.n = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.u.u.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                u.this.x = true;
                if (u.this.b != 0 || activity == null) {
                    return;
                }
                u.this.b = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = u.this.b;
                u.this.x = false;
                u.this.b = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    u.this.pn();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                u.this.pn = new WeakReference(activity);
                int i = u.this.b;
                u.this.b = activity != null ? activity.hashCode() : i;
                u.this.x = false;
                if (i == 0) {
                    u.this.pn();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == u.this.b) {
                    u.this.b = 0;
                    u.this.iz();
                }
                u.this.x = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }
        };
    }

    public boolean fx() {
        return nr() && !this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean nr() {
        int i = this.iz;
        ?? r0 = i;
        if (i == -1) {
            ?? X = x();
            this.iz = X;
            r0 = X;
        }
        return r0 == 1;
    }

    public static u u() {
        return nr.u;
    }

    public void nr(InterfaceC0886u interfaceC0886u) {
        synchronized (this.fx) {
            this.fx.remove(interfaceC0886u);
        }
    }

    public void u(Context context) {
        if (this.u == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.u == null) {
                    Application application = (Application) context;
                    this.u = application;
                    application.registerActivityLifecycleCallbacks(this.n);
                }
            }
        }
    }

    public void u(fx fxVar) {
        this.nr = fxVar;
    }

    public void u(InterfaceC0886u interfaceC0886u) {
        if (interfaceC0886u == null) {
            return;
        }
        synchronized (this.fx) {
            if (!this.fx.contains(interfaceC0886u)) {
                this.fx.add(interfaceC0886u);
            }
        }
    }
}
