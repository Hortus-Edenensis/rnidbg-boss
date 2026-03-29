package com.bytedance.sdk.openadsdk.core.y;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Application.ActivityLifecycleCallbacks {
    public static long fx = 0;
    public static long nr = 0;
    public static boolean u = false;
    private volatile InterfaceC0306u b;
    private volatile nr iz;
    private Handler k;
    private volatile WeakReference<Activity> my;
    private volatile Application.ActivityLifecycleCallbacks pn;
    private volatile WeakReference<Activity> s;
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final HashSet<Integer> n = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.u>> f5415a = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<nr> jk = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<InterfaceC0306u> t = new CopyOnWriteArrayList<>();
    private final ArrayList<String> l = new ArrayList<>();
    private SparseArray<Set<Runnable>> mv = new SparseArray<>();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class fx implements InterfaceC0306u {
        @Override // com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
        public void u() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
        public void u(String str, Window window) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
        public void nr(String str, Window window) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void nr();

        void u();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.y.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0306u {
        void nr(String str, Window window);

        void u();

        void u(String str, Window window);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.n.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.pn != null) {
            this.pn.onActivityDestroyed(activity);
        }
        Iterator<InterfaceC0306u> it = this.t.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.f5415a != null && this.f5415a.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.u> weakReference : this.f5415a) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().u(activity);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.s != null && this.s.get() == activity) {
            this.s = null;
        }
        if (activity != null) {
            int iHashCode = activity.hashCode();
            synchronized (this.mv) {
                Set<Runnable> set = this.mv.get(iHashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.mv.remove(iHashCode);
                }
            }
        }
    }

    private boolean iz() {
        Function<SparseArray<Object>, Object> functionV = com.bytedance.sdk.openadsdk.core.n.o().v();
        if (functionV != null) {
            try {
                Object objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).nr());
                if (objApply != null) {
                    return ((Boolean) objApply).booleanValue();
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return this.x.get();
    }

    private void n() {
        if (com.bytedance.sdk.openadsdk.core.n.o().ja()) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.nr(new com.bytedance.sdk.component.jk.a("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.y.u.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
                long j = fxVarU.get("save_jump_success_time", 0L);
                if (j <= 0) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                if (jCurrentTimeMillis >= 86400000 || jCurrentTimeMillis <= 0) {
                    return;
                }
                String str = fxVarU.get("save_jump_success_ad_tag", "");
                String str2 = fxVarU.get("save_dpl_success_materialmeta", "");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                fxVarU.remove("save_dpl_success_materialmeta");
                com.bytedance.sdk.openadsdk.core.s.b.u(jCurrentTimeMillis, str, str2);
            }
        });
    }

    private Handler pn() {
        if (this.k == null) {
            if (com.bytedance.sdk.openadsdk.core.dw.nr().bo()) {
                this.k = com.bytedance.sdk.component.utils.jk.fx();
            } else {
                this.k = com.bytedance.sdk.component.utils.jk.nr();
            }
        }
        return this.k;
    }

    private void x() {
        if (!com.bytedance.sdk.openadsdk.core.n.o().ja() && nr()) {
            com.bytedance.sdk.component.jk.x.fx(new com.bytedance.sdk.component.jk.a("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.y.u.6
                @Override // java.lang.Runnable
                public void run() {
                    u.u = false;
                    u.fx = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.qq.s.u().u(u.nr / 1000, u.fx / 1000, !com.bytedance.sdk.openadsdk.core.bg.nr.get() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.bg.nr.set(false);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
        if (this.pn != null) {
            this.pn.onActivityCreated(activity, bundle);
        }
        Iterator<InterfaceC0306u> it = this.t.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam final Activity activity) {
        pn().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.u.5
            @Override // java.lang.Runnable
            public void run() {
                u.this.b(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam final Activity activity) {
        pn().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.u.3
            @Override // java.lang.Runnable
            public void run() {
                u.this.fx(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@ForbidWrapParam final Activity activity) {
        pn().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.nr(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.u(activity, name, window);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        pn().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.u.4
            @Override // java.lang.Runnable
            public void run() {
                u.this.nr(activity, name, window);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(@ForbidWrapParam Activity activity) {
        if (this.pn != null) {
            this.pn.onActivityPaused(activity);
        }
        Iterator<InterfaceC0306u> it = this.t.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (com.bytedance.sdk.openadsdk.core.n.o().ja() || activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.nr.u().fx(activity.getComponentName().getClassName());
    }

    private void nr(boolean z) {
        try {
            if (z) {
                if (this.iz != null) {
                    this.iz.nr();
                }
                for (nr nrVar : this.jk) {
                    if (nrVar != null) {
                        nrVar.nr();
                    }
                }
                return;
            }
            if (this.iz != null) {
                this.iz.u();
            }
            for (nr nrVar2 : this.jk) {
                if (nrVar2 != null) {
                    nrVar2.u();
                }
            }
        } catch (Exception unused) {
        }
    }

    public WeakReference<Activity> u() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@ForbidWrapParam Activity activity, String str, Window window) {
        if (this.x.get()) {
            nr(true);
        }
        if (!this.l.contains(activity.toString())) {
            this.l.add(activity.toString());
            this.x.set(false);
            com.bytedance.sdk.openadsdk.u.nr.nr.pn();
        }
        if (this.my != null && this.my.get() != null && this.my.get() == activity) {
            n();
        }
        if (this.b != null) {
            this.b.u(str, window);
        }
        if (this.pn != null) {
            this.pn.onActivityStarted(activity);
        }
        for (InterfaceC0306u interfaceC0306u : this.t) {
            if (interfaceC0306u != null) {
                interfaceC0306u.u(str, window);
            }
        }
        y.pn(activity);
    }

    public void fx(nr nrVar) {
        this.iz = nrVar;
    }

    public void fx() {
        if (this.b != null) {
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.n.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.b != null) {
            this.b.u();
        }
        if (this.pn != null) {
            this.pn.onActivityResumed(activity);
        }
        for (InterfaceC0306u interfaceC0306u : this.t) {
            if (interfaceC0306u != null) {
                interfaceC0306u.u();
            }
        }
        com.bytedance.sdk.component.a.fx.u.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), Integer.parseInt("1371"));
        if (!u) {
            nr = System.currentTimeMillis();
            u = true;
        }
        com.bytedance.sdk.openadsdk.core.gi.u();
        this.s = new WeakReference<>(activity);
        if (com.bytedance.sdk.openadsdk.core.n.o().ja()) {
            return;
        }
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.y.nr.u().u(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        k.u().u(activity.getIntent());
    }

    public void b() {
        com.bytedance.sdk.openadsdk.core.y.nr.u().nr();
    }

    public boolean u(boolean z) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.s;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    public boolean u(@ForbidWrapParam Activity activity) {
        return activity != null && this.n.contains(Integer.valueOf(activity.hashCode()));
    }

    public void u(InterfaceC0306u interfaceC0306u) {
        this.b = interfaceC0306u;
    }

    public void u(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.pn = activityLifecycleCallbacks;
    }

    public void u(com.bytedance.sdk.component.adexpress.u uVar) {
        this.f5415a.add(new WeakReference<>(uVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(@ForbidWrapParam Activity activity, String str, Window window) {
        if (this.l.contains(activity.toString())) {
            this.l.remove(activity.toString());
            if (this.l.size() == 0) {
                this.x.set(true);
                com.bytedance.sdk.openadsdk.u.nr.nr.b();
                nr(false);
            }
        }
        this.my = new WeakReference<>(activity);
        if (this.b != null) {
            this.b.nr(str, window);
        }
        if (this.pn != null) {
            this.pn.onActivityStopped(activity);
        }
        for (InterfaceC0306u interfaceC0306u : this.t) {
            if (interfaceC0306u != null) {
                interfaceC0306u.nr(str, window);
            }
        }
        x();
        ((com.bytedance.sdk.component.b.a) com.bytedance.sdk.openadsdk.ats.fx.u("kv_store_factory")).store();
    }

    public void u(nr nrVar) {
        if (this.jk.contains(nrVar)) {
            return;
        }
        this.jk.add(nrVar);
    }

    public boolean u(Activity activity, Runnable runnable) {
        boolean zAdd;
        if (activity == null) {
            return false;
        }
        int iHashCode = activity.hashCode();
        synchronized (this.mv) {
            Set<Runnable> hashSet = this.mv.get(iHashCode);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mv.put(iHashCode, hashSet);
            }
            zAdd = hashSet.add(runnable);
        }
        return zAdd;
    }

    public boolean nr() {
        return iz();
    }

    public boolean nr(com.bytedance.sdk.component.adexpress.u uVar) {
        return this.f5415a.remove(new WeakReference(uVar));
    }

    public void nr(InterfaceC0306u interfaceC0306u) {
        if (this.t.contains(interfaceC0306u)) {
            return;
        }
        this.t.add(interfaceC0306u);
    }

    public void nr(nr nrVar) {
        if (nrVar != null) {
            this.jk.remove(nrVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }
}
