package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nz6 {
    public static long A = -1;
    public static volatile nz6 B = null;
    public static boolean v = true;
    public static boolean w = false;
    public static boolean x = false;
    public static int y = 1;
    public static boolean z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f19646a;
    public Context b;
    public String h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public String n;
    public long o;
    public String p;
    public long q;
    public int u;
    public List<String> c = new ArrayList();
    public List<Long> d = new ArrayList();
    public List<String> e = new ArrayList();
    public List<Long> f = new ArrayList();
    public LinkedList<b> g = new LinkedList<>();
    public boolean r = false;
    public long s = -1;
    public int t = 50;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19648a;
        public String b;
        public long c;

        public b(String str, String str2, long j) {
            this.b = str2;
            this.c = j;
            this.f19648a = str;
        }

        public String toString() {
            return w07.a().format(new Date(this.c)) + " : " + this.f19648a + ' ' + this.b;
        }
    }

    public nz6(Application application) {
        this.b = application;
        this.f19646a = application;
        try {
            V();
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ int I(nz6 nz6Var) {
        int i = nz6Var.u;
        nz6Var.u = i + 1;
        return i;
    }

    public static /* synthetic */ int S(nz6 nz6Var) {
        int i = nz6Var.u;
        nz6Var.u = i - 1;
        return i;
    }

    public static void i() {
        z = true;
    }

    public static int n() {
        int i = y;
        return i == 1 ? z ? 2 : 1 : i;
    }

    public static long s() {
        return A;
    }

    public static nz6 y() {
        if (B == null) {
            synchronized (nz6.class) {
                if (B == null) {
                    B = new nz6(x97.n());
                }
            }
        }
        return B;
    }

    public long B() {
        return SystemClock.uptimeMillis() - this.s;
    }

    public boolean H() {
        return this.r;
    }

    public JSONObject J() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", h(this.h, this.i));
            jSONObject.put("last_start_activity", h(this.j, this.k));
            jSONObject.put("last_resume_activity", h(this.l, this.m));
            jSONObject.put("last_pause_activity", h(this.n, this.o));
            jSONObject.put("last_stop_activity", h(this.p, this.q));
            jSONObject.put("alive_activities", X());
            jSONObject.put("finish_activities", Z());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String K() {
        return String.valueOf(this.l);
    }

    public JSONArray N() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            jSONArray.put(((b) it.next()).toString());
        }
        return jSONArray;
    }

    public final void V() {
        if (this.f19646a != null) {
            this.f19646a.registerActivityLifecycleCallbacks(new a());
        }
    }

    public final JSONArray X() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.c.size(); i++) {
                try {
                    jSONArray.put(h(this.c.get(i), this.d.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final JSONArray Z() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.e;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.e.size(); i++) {
                try {
                    jSONArray.put(h(this.e.get(i), this.f.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final b e(String str, String str2, long j) {
        b bVarPoll;
        if (this.g.size() >= this.t) {
            bVarPoll = this.g.poll();
            if (bVarPoll != null) {
                this.g.add(bVarPoll);
            }
        } else {
            bVarPoll = null;
        }
        if (bVarPoll != null) {
            return bVarPoll;
        }
        b bVar = new b(str, str2, j);
        this.g.add(bVar);
        return bVar;
    }

    public final JSONObject h(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void k(String str, long j, String str2) {
        try {
            b bVarE = e(str, str2, j);
            bVarE.b = str2;
            bVarE.f19648a = str;
            bVarE.c = j;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            nz6.this.h = activity.getClass().getName();
            nz6.this.i = System.currentTimeMillis();
            boolean unused = nz6.w = bundle != null;
            boolean unused2 = nz6.x = true;
            nz6.this.c.add(nz6.this.h);
            nz6.this.d.add(Long.valueOf(nz6.this.i));
            nz6 nz6Var = nz6.this;
            nz6Var.k(nz6Var.h, nz6.this.i, "onCreate");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            int iIndexOf = nz6.this.c.indexOf(name);
            if (iIndexOf > -1 && iIndexOf < nz6.this.c.size()) {
                nz6.this.c.remove(iIndexOf);
                nz6.this.d.remove(iIndexOf);
            }
            nz6.this.e.add(name);
            long jCurrentTimeMillis = System.currentTimeMillis();
            nz6.this.f.add(Long.valueOf(jCurrentTimeMillis));
            nz6.this.k(name, jCurrentTimeMillis, "onDestroy");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            nz6.this.n = activity.getClass().getName();
            nz6.this.o = System.currentTimeMillis();
            nz6.S(nz6.this);
            if (nz6.this.u == 0) {
                nz6.this.r = false;
                boolean unused = nz6.x = false;
                nz6.this.s = SystemClock.uptimeMillis();
            } else if (nz6.this.u < 0) {
                nz6.this.u = 0;
                nz6.this.r = false;
                boolean unused2 = nz6.x = false;
                nz6.this.s = SystemClock.uptimeMillis();
            }
            nz6 nz6Var = nz6.this;
            nz6Var.k(nz6Var.n, nz6.this.o, "onPause");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            int i;
            nz6.this.l = activity.getClass().getName();
            nz6.this.m = System.currentTimeMillis();
            nz6.I(nz6.this);
            if (!nz6.this.r) {
                nz6.this.r = true;
                if (nz6.v) {
                    boolean unused = nz6.v = false;
                    int unused2 = nz6.y = 1;
                    long unused3 = nz6.A = nz6.this.m;
                }
                if (nz6.this.l.equals(nz6.this.n)) {
                    if (!nz6.x || nz6.w) {
                        i = nz6.x ? 4 : 3;
                    }
                    int unused4 = nz6.y = i;
                    long unused5 = nz6.A = nz6.this.m;
                }
            }
            nz6 nz6Var = nz6.this;
            nz6Var.k(nz6Var.l, nz6.this.m, "onResume");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            nz6.this.j = activity.getClass().getName();
            nz6.this.k = System.currentTimeMillis();
            nz6 nz6Var = nz6.this;
            nz6Var.k(nz6Var.j, nz6.this.k, "onStart");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            nz6.this.p = activity.getClass().getName();
            nz6.this.q = System.currentTimeMillis();
            nz6 nz6Var = nz6.this;
            nz6Var.k(nz6Var.p, nz6.this.q, "onStop");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
