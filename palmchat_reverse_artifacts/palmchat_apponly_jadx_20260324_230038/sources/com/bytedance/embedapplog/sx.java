package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<Integer> f5063a = new HashSet<>(8);
    private static String b = null;
    private static long fx = 0;
    private static String iz = null;
    private static sf nr = null;
    private static long pn = 0;
    private static int u = 0;
    private static int x = -1;
    private final iz n;

    public sx(iz izVar) {
        this.n = izVar;
    }

    public static sf u(String str, String str2, long j, String str3) {
        sf sfVar = new sf();
        if (TextUtils.isEmpty(str2)) {
            sfVar.s = str;
        } else {
            sfVar.s = str + ":" + str2;
        }
        sfVar.nr = j;
        sfVar.l = -1L;
        if (str3 == null) {
            str3 = "";
        }
        sfVar.mv = str3;
        xg.u(sfVar);
        return sfVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f5063a.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f5063a.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        sf sfVar = nr;
        if (sfVar != null) {
            b = sfVar.s;
            long jCurrentTimeMillis = System.currentTimeMillis();
            fx = jCurrentTimeMillis;
            u(nr, jCurrentTimeMillis);
            nr = null;
            if (activity.isChild()) {
                return;
            }
            x = -1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        sf sfVarU = u(activity.getClass().getName(), "", System.currentTimeMillis(), b);
        nr = sfVarU;
        sfVarU.bg = !f5063a.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            x = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            ti.nr(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        u++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (b != null) {
            int i = u - 1;
            u = i;
            if (i <= 0) {
                b = null;
                iz = null;
                pn = 0L;
                fx = 0L;
            }
        }
    }

    public static sf u(sf sfVar, long j) {
        sf sfVar2 = (sf) sfVar.clone();
        sfVar2.nr = j;
        long j2 = j - sfVar.nr;
        if (j2 >= 0) {
            sfVar2.l = j2;
        } else {
            ti.nr((Throwable) null);
        }
        xg.u(sfVar2);
        return sfVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
