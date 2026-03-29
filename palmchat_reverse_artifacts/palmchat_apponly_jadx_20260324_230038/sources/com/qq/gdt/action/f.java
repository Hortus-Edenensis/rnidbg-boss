package com.qq.gdt.action;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.qq.gdt.action.j.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private final d c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10491a = 0;
    private int b = 0;
    private SparseArray d = new SparseArray();

    public f(d dVar) {
        this.c = dVar;
    }

    private void a() {
        o.a("App Enter Background", new Object[0]);
        this.c.m();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity, "PAUSE");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity, "RESUME");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f10491a <= 0) {
            a(activity);
        }
        int i = this.b;
        if (i < 0) {
            this.b = i + 1;
        } else {
            this.f10491a++;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.b--;
            return;
        }
        int i = this.f10491a - 1;
        this.f10491a = i;
        if (i <= 0) {
            a();
        }
    }

    private void a(Activity activity) {
        o.a("App Enter Foreground", new Object[0]);
        this.c.a(activity);
    }

    private void a(Activity activity, String str) {
        if (activity == null) {
            o.c("acitivity == null, can't log " + str);
            return;
        }
        int iHashCode = activity.hashCode();
        this.d.put(iHashCode, Long.valueOf(SystemClock.elapsedRealtime()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(com.umeng.analytics.pro.f.v, activity.getClass().getName());
        } catch (JSONException e) {
            o.c(e.getMessage());
        }
        if ("PAUSE".equals(str)) {
            Object obj = this.d.get(iHashCode);
            try {
                jSONObject.putOpt("duration", Long.valueOf((obj == null || !(obj instanceof Long)) ? -1L : SystemClock.elapsedRealtime() - ((Long) obj).longValue()));
            } catch (JSONException e2) {
                o.c(e2.getMessage());
            }
        }
        GDTAction.logAction(str, jSONObject);
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
}
