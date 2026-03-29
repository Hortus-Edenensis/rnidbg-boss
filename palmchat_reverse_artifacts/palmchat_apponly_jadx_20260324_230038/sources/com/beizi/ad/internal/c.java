package com.beizi.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.lance.a.r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static boolean C = false;
    private static boolean D = false;
    public static String g = null;
    public static String h = "";
    public static String i = "";
    private static String k = "USED_AD_UNIT_IDS_KEY";
    private static c l = null;
    private static String m = "BeiZiImpl";
    public List<String> c;
    public Context j;
    private boolean u;
    private boolean v;
    private DisplayMetrics z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4377a = false;
    public String b = null;
    public boolean d = false;
    public String e = "";
    public HashMap<String, String> f = new HashMap<>();
    private HashSet<String> n = new HashSet<>();
    private HashSet<String> o = new HashSet<>();
    private HashSet<String> p = new HashSet<>();
    private HashSet<String> q = new HashSet<>();
    private HashSet<String> r = new HashSet<>();
    private HashSet<String> s = new HashSet<>();
    private int t = -1;
    private Handler w = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
        }
    };
    private Handler x = null;
    private HandlerThread y = null;
    private boolean A = false;
    private boolean B = false;
    private int E = 0;
    private List<a> F = new ArrayList();

    public static /* synthetic */ int a(c cVar) {
        int i2 = cVar.E;
        cVar.E = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.E;
        cVar.E = i2 - 1;
        return i2;
    }

    private void j() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public String e() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        return d() + "/mb/sdk0/json";
    }

    public void f() {
        try {
            ((Application) this.j.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.internal.c.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Log.e("openDeeplink", "count:" + c.this.E + ";onActivityDestroyed" + activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        if (c.this.F == null || c.this.F.size() <= 0) {
                            return;
                        }
                        Iterator it = c.this.F.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.b();
                            }
                            it.remove();
                        }
                        c.this.F.clear();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    c.a(c.this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        c.c(c.this);
                        if (c.this.E < 0) {
                            c.this.E = 0;
                        }
                        if (c.this.E != 0 || c.this.F == null || c.this.F.size() <= 0) {
                            return;
                        }
                        Iterator it = c.this.F.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.a();
                            }
                            it.remove();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> g() {
        return this.c;
    }

    public int h() {
        return this.t;
    }

    public boolean i() {
        if (this.v) {
            return this.u;
        }
        this.v = true;
        boolean zA = r.a();
        this.u = zA;
        return zA;
    }

    public String b() {
        return g;
    }

    public Context c() {
        return this.j;
    }

    public String d() {
        String strB = com.beizi.ad.lance.a.b.b("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(strB) ? "" : this.f4377a ? strB.replace("http:", "https:") : strB;
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            if (l == null) {
                l = new c();
            }
            cVar = l;
        }
        return cVar;
    }

    public String b(String str) {
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(str);
        bVar.b(n.a());
        bVar.a(false);
        return new com.beizi.ad.v2.e.b().a(bVar);
    }

    public void a(Context context, String str) {
        synchronized (c.class) {
            try {
                if (context != null) {
                    Log.i("lance", "SDK_VERSION:5.2.2.0");
                    this.j = context.getApplicationContext();
                    try {
                        g = str;
                        com.beizi.ad.internal.a.a.a().b();
                        f();
                    } catch (Throwable unused) {
                    }
                    this.z = context.getResources().getDisplayMetrics();
                    this.B = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        j();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(a aVar) {
        this.F.add(aVar);
    }

    public void a(List<String> list) {
        this.c = list;
    }

    public void a(Context context) {
        this.j = context;
    }
}
