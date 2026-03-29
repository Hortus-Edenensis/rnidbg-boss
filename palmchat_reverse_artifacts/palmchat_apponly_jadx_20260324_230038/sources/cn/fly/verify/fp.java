package cn.fly.verify;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static fp f2358a;
    private HashSet<b> b = new HashSet<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(Activity activity);

        void a(Activity activity, Bundle bundle);

        void b(Activity activity);

        void b(Activity activity, Bundle bundle);

        void c(Activity activity);

        void d(Activity activity);

        void e(Activity activity);
    }

    private fp(Context context) {
        b(context);
    }

    public static synchronized fp a(Context context) {
        if (f2358a == null) {
            f2358a = new fp(context);
        }
        return f2358a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Activity activity) {
        a(new a() { // from class: cn.fly.verify.fp.4
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.b(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Activity activity) {
        a(new a() { // from class: cn.fly.verify.fp.5
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.c(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Activity activity) {
        a(new a() { // from class: cn.fly.verify.fp.6
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.d(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final Activity activity) {
        a(new a() { // from class: cn.fly.verify.fp.7
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.e(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity) {
        a(new a() { // from class: cn.fly.verify.fp.3
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.a(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Activity activity, final Bundle bundle) {
        a(new a() { // from class: cn.fly.verify.fp.8
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.b(activity, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final Bundle bundle) {
        a(new a() { // from class: cn.fly.verify.fp.2
            @Override // cn.fly.verify.fp.a
            public void a(b bVar) {
                bVar.a(activity, bundle);
            }
        });
    }

    private void b(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: cn.fly.verify.fp.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    fp.this.a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    fp.this.e(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    fp.this.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    fp.this.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    fp.this.b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    fp.this.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    fp.this.d(activity);
                }
            });
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    private void a(a aVar) {
        b[] bVarArr;
        try {
            synchronized (this.b) {
                HashSet<b> hashSet = this.b;
                bVarArr = (b[]) hashSet.toArray(new b[hashSet.size()]);
            }
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    aVar.a(bVar);
                }
            }
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    public void a(b bVar) {
        synchronized (this.b) {
            this.b.add(bVar);
        }
    }
}
