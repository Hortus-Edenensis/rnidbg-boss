package com.zx.a.I8b7;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.v3;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class h1 {
    public static volatile y1 i;
    public static volatile y1 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Timer f16799a;
    public TimerTask b;
    public volatile int c;
    public volatile int d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public volatile String f;
    public volatile long g;
    public z1 h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h1 f16802a = new h1();
    }

    public final void a(long j2) throws JSONException {
        String strA = l2.a.f16824a.f16823a.a(61);
        if (TextUtils.isEmpty(strA)) {
            i = new y1();
        } else {
            i = new y1(strA);
        }
        StringBuilder sbA = f3.a("read appRt = ");
        sbA.append(i);
        r2.a(sbA.toString());
        i.put(j2 + "#0");
        this.c = i.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() throws JSONException {
        String str;
        List<ResolveInfo> listQueryIntentActivities;
        if (m3.f16830a.getApplicationContext() instanceof Application) {
            Application application = (Application) m3.f16830a.getApplicationContext();
            this.h = new z1();
            this.g = a();
            try {
                PackageManager packageManagerC = w3.c(m3.f16830a);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(m3.g);
                listQueryIntentActivities = packageManagerC.queryIntentActivities(intent, 0);
            } catch (Exception e) {
                r2.a(e);
            }
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                str = "ZX_MainActivity";
            } else {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                if (it.hasNext()) {
                    str = it.next().activityInfo.name;
                }
            }
            this.f = str;
            String strA = l2.a.f16824a.f16823a.a(62);
            if (TextUtils.isEmpty(strA)) {
                j = new y1();
            } else {
                j = new y1(strA);
            }
            StringBuilder sbA = f3.a("read tabRT = ");
            sbA.append(j);
            r2.a(sbA.toString());
            j.put(this.h);
            this.d = j.length();
            application.registerActivityLifecycleCallbacks(new a());
        }
    }

    public static void a(h1 h1Var, long j2) throws Throwable {
        h1Var.getClass();
        try {
            long jA = h1Var.a() - j2;
            int length = i.length() - 1;
            if (length >= 0) {
                i.put(length, j2 + "#" + jA);
            }
            l2 l2Var = l2.a.f16824a;
            u3 u3Var = l2Var.f16823a;
            y1 y1Var = i;
            u3Var.getClass();
            if (y1Var == null) {
                return;
            }
            l2Var.f16823a.a(61, y1Var.toString(), true);
            r2.a("appRt had changed refresh:" + y1Var);
        } catch (Throwable th) {
            StringBuilder sbA = f3.a("dealAppRT ex:");
            sbA.append(th.getMessage());
            r2.b(sbA.toString());
        }
    }

    public static void a(h1 h1Var) throws Throwable {
        y1 y1Var;
        h1Var.getClass();
        try {
            Object objOpt = h1Var.h.opt(h1Var.f);
            long jA = h1Var.a() - h1Var.g;
            if (objOpt != null && (objOpt instanceof y1)) {
                y1Var = (y1) objOpt;
                int iA = y1Var.a(h1Var.g + "");
                if (iA != -1) {
                    y1Var.put(iA, h1Var.g + "#" + jA);
                } else {
                    y1Var.put(h1Var.g + "#" + jA);
                }
            } else {
                y1Var = new y1();
                y1Var.put(h1Var.g + "#" + jA);
            }
            h1Var.h.put(h1Var.f, y1Var);
            int length = j.length() - 1;
            if (length >= 0) {
                j.remove(length);
            }
            j.put(h1Var.h);
            l2 l2Var = l2.a.f16824a;
            u3 u3Var = l2Var.f16823a;
            y1 y1Var2 = j;
            u3Var.getClass();
            if (y1Var2 == null) {
                return;
            }
            l2Var.f16823a.a(62, y1Var2.toString(), true);
            r2.a("TABRt had changed refresh:" + y1Var2);
        } catch (Throwable th) {
            StringBuilder sbA = f3.a("dealTabRT ex:");
            sbA.append(th.getMessage());
            r2.b(sbA.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: com.zx.a.I8b7.h1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1177a implements Runnable {
            public RunnableC1177a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    h1.a(h1.this);
                } catch (Throwable unused) {
                }
            }
        }

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                v3.f.f16875a.e.execute(new RunnableC1177a());
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                h1 h1Var = h1.this;
                h1Var.g = h1Var.a();
                h1.this.f = activity.getClass().getName();
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public final long a() {
        return System.currentTimeMillis() / 1000;
    }
}
