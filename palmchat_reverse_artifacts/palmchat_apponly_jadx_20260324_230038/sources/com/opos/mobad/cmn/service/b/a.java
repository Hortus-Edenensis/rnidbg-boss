package com.opos.mobad.cmn.service.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8729a;
    private final AtomicInteger b = new AtomicInteger(0);
    private Application.ActivityLifecycleCallbacks c = null;
    private CopyOnWriteArrayList<InterfaceC0731a> d;

    /* JADX INFO: renamed from: com.opos.mobad.cmn.service.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0731a {
        void a();

        void b();
    }

    private a() {
        this.d = null;
        this.d = new CopyOnWriteArrayList<>();
    }

    public static a a() {
        a aVar = f8729a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f8729a;
                if (aVar == null) {
                    aVar = new a();
                    f8729a = aVar;
                }
            }
        }
        return aVar;
    }

    private void b() {
        if (this.c != null) {
            return;
        }
        this.c = new Application.ActivityLifecycleCallbacks() { // from class: com.opos.mobad.cmn.service.b.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
                a.this.a(true);
                a.this.b.incrementAndGet();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
                a.this.b.decrementAndGet();
                a.this.a(false);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            }
        };
    }

    private void c() {
        CopyOnWriteArrayList<InterfaceC0731a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (InterfaceC0731a interfaceC0731a : this.d) {
            if (interfaceC0731a != null) {
                interfaceC0731a.a();
            }
        }
    }

    private void d() {
        CopyOnWriteArrayList<InterfaceC0731a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (InterfaceC0731a interfaceC0731a : this.d) {
            if (interfaceC0731a != null) {
                interfaceC0731a.b();
            }
        }
    }

    public void b(Context context) {
        Application application;
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "destroy()");
        if (context == null || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.c = null;
        }
        CopyOnWriteArrayList<InterfaceC0731a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.d = null;
        }
    }

    public void a(Context context) {
        Application application;
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "init()");
        if (context == null || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        b();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        if (activityLifecycleCallbacks != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void b(InterfaceC0731a interfaceC0731a) {
        if (interfaceC0731a == null) {
            return;
        }
        this.d.remove(interfaceC0731a);
    }

    public void a(InterfaceC0731a interfaceC0731a) {
        if (interfaceC0731a == null || this.d.contains(interfaceC0731a)) {
            return;
        }
        this.d.add(interfaceC0731a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i = this.b.get();
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "checkStatus() count=", Integer.valueOf(i));
        if (i <= 0) {
            if (z) {
                c();
            } else {
                d();
            }
        }
    }
}
