package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ui7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f21224a;
    public Context b;
    public String g;
    public long h;
    public String i;
    public long j;
    public String k;
    public long l;
    public String m;
    public long n;
    public String o;
    public long p;
    public List<String> c = new ArrayList();
    public List<Long> d = new ArrayList();
    public List<String> e = new ArrayList();
    public List<Long> f = new ArrayList();
    public int q = 0;
    public boolean r = false;
    public final Application.ActivityLifecycleCallbacks s = new a();

    public ui7(@NonNull Context context) {
        this.b = context;
        if (context instanceof Application) {
            this.f21224a = (Application) context;
        }
        t();
    }

    public static /* synthetic */ y07 c() {
        return null;
    }

    public static /* synthetic */ int j(ui7 ui7Var) {
        int i = ui7Var.q;
        ui7Var.q = i - 1;
        return i;
    }

    public static /* synthetic */ int q(ui7 ui7Var) {
        int i = ui7Var.q;
        ui7Var.q = i + 1;
        return i;
    }

    public final JSONArray B() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.e;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.e.size(); i++) {
                try {
                    jSONArray.put(y(this.e.get(i), this.f.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public boolean i() {
        return this.r;
    }

    public final JSONArray k() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.c.size(); i++) {
                try {
                    jSONArray.put(y(this.c.get(i), this.d.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public JSONArray p() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                        jSONObject.put("description", runningTaskInfo.description);
                        jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                        jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                        jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                        jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    public final void t() {
        Application application = this.f21224a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.s);
        }
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", y(this.g, this.h));
            jSONObject.put("last_start_activity", y(this.i, this.j));
            jSONObject.put("last_resume_activity", y(this.k, this.l));
            jSONObject.put("last_pause_activity", y(this.m, this.n));
            jSONObject.put("last_stop_activity", y(this.o, this.p));
            jSONObject.put("alive_activities", k());
            jSONObject.put("finish_activities", B());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject y(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ui7 ui7Var = ui7.this;
            ui7.c();
            ui7Var.g = activity.getClass().getName();
            ui7.this.h = System.currentTimeMillis();
            ui7.this.c.add(ui7.this.g);
            ui7.this.d.add(Long.valueOf(ui7.this.h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            ui7.c();
            String name = activity.getClass().getName();
            int iIndexOf = ui7.this.c.indexOf(name);
            if (iIndexOf >= 0 && iIndexOf < ui7.this.c.size()) {
                ui7.this.c.remove(iIndexOf);
                ui7.this.d.remove(iIndexOf);
            }
            ui7.this.e.add(name);
            ui7.this.f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ui7 ui7Var = ui7.this;
            ui7.c();
            ui7Var.m = activity.getClass().getName();
            ui7.this.n = System.currentTimeMillis();
            ui7.j(ui7.this);
            if (ui7.this.q <= 0) {
                ui7.this.r = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ui7 ui7Var = ui7.this;
            ui7.c();
            ui7Var.k = activity.getClass().getName();
            ui7.this.l = System.currentTimeMillis();
            ui7.this.r = true;
            ui7.q(ui7.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ui7 ui7Var = ui7.this;
            ui7.c();
            ui7Var.i = activity.getClass().getName();
            ui7.this.j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ui7 ui7Var = ui7.this;
            ui7.c();
            ui7Var.o = activity.getClass().getName();
            ui7.this.p = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
