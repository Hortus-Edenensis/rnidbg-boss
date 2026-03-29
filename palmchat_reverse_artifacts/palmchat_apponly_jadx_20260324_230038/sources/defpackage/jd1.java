package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class jd1 implements p16 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18385a;
    public Application.ActivityLifecycleCallbacks b;
    public int c;

    public jd1(Context context) {
        this.f18385a = context;
    }

    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Context context = this.f18385a;
        if (context == null) {
            return;
        }
        try {
            if (context.getApplicationContext() instanceof Application) {
                ((Application) this.f18385a.getApplicationContext()).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable th) {
            v.d(th.getMessage());
        }
    }

    public void b() {
        xn1.h().o();
    }

    @Override // defpackage.p16
    public void register() {
        a aVar = new a();
        this.b = aVar;
        a(aVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            jd1 jd1Var = jd1.this;
            if (jd1Var.c <= 0) {
                jd1Var.c = 0;
            }
            jd1Var.c++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            jd1 jd1Var = jd1.this;
            int i = jd1Var.c - 1;
            jd1Var.c = i;
            if (i <= 0) {
                jd1Var.c = 0;
                jd1Var.b();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
