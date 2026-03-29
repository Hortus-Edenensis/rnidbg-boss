package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class qw6 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20343a;
    public boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final qw6 f20344a = new qw6();
    }

    public qw6() {
        this.f20343a = 0;
    }

    public static qw6 a() {
        return b.f20344a;
    }

    public synchronized void b(Application application) {
        if (!this.b) {
            application.registerActivityLifecycleCallbacks(this);
            this.b = true;
        }
    }

    public final boolean c() {
        return this.f20343a == 1;
    }

    public final boolean d() {
        return this.f20343a == 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (c()) {
            ec7.a().g(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f20343a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f20343a--;
        if (d()) {
            ec7.a().f(activity.getApplicationContext());
        }
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
