package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ew6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<e47> f17382a;
    public Application.ActivityLifecycleCallbacks b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            List<e47> list = ew6.this.f17382a;
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<e47> it = ew6.this.f17382a.iterator();
            while (it.hasNext()) {
                it.next().a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            List<e47> list = ew6.this.f17382a;
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<e47> it = ew6.this.f17382a.iterator();
            while (it.hasNext()) {
                it.next().b(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
