package com.zm.fda.Z0225;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.utils.EventLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z implements Application.ActivityLifecycleCallbacks {
    public static final String g = "ActivityLifecycleManager";
    public static List<Activity> h = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16657a;
    public Context b;
    public Calendar c;
    public Calendar d;
    public Set<com.zm.fda.Z0225.OO22Z> e;
    public boolean f;

    /* JADX INFO: renamed from: com.zm.fda.Z0225.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C1165ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ZZ00Z f16658a = new ZZ00Z();
    }

    public static ZZ00Z a() {
        return C1165ZZ00Z.f16658a;
    }

    private void c() {
        EventLog.d(g, "onAppToBackground");
        for (com.zm.fda.Z0225.OO22Z oo22z : this.e) {
            if (oo22z != null) {
                oo22z.a();
            }
        }
    }

    private void d() {
        EventLog.d(g, "onAppToForeground");
        for (com.zm.fda.Z0225.OO22Z oo22z : this.e) {
            if (oo22z != null) {
                oo22z.b();
            }
        }
    }

    private void e() {
        if (com.zm.fda.O022Z.b() && !a(ZZ050.a(this.b, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.i, 0L))) {
            com.zm.fda.O022Z.a().track(ZZ00Z.OO22Z.f16680a);
            ZZ050.b(this.b, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.i, System.currentTimeMillis());
        }
    }

    public void b(com.zm.fda.Z0225.OO22Z oo22z) {
        if (oo22z != null && this.e.contains(oo22z)) {
            this.e.remove(oo22z);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        h.add(activity);
        if (h.size() == 1) {
            this.f = false;
            d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        h.remove(activity);
        if (h.size() == 0) {
            this.f = true;
            c();
        }
    }

    public ZZ00Z() {
        this.e = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f = false;
    }

    public void a(Context context) {
        if (context == null || this.f16657a) {
            return;
        }
        this.b = context;
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
            this.f16657a = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean b() {
        return this.f;
    }

    public void a(com.zm.fda.Z0225.OO22Z oo22z) {
        if (oo22z == null) {
            return;
        }
        this.e.add(oo22z);
    }

    private boolean a(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.d == null) {
            this.d = Calendar.getInstance();
        }
        if (this.c == null) {
            this.c = Calendar.getInstance();
        }
        this.d.setTimeInMillis(j);
        this.c.setTimeInMillis(jCurrentTimeMillis);
        Calendar calendar = this.d;
        return calendar != null && this.c != null && calendar.get(1) == this.c.get(1) && this.d.get(6) == this.c.get(6);
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
