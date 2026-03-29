package a.a.b.a.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import defpackage.pn;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1085a = 1;
    public static Timer b = null;
    public static boolean c = true;
    public static final g e = new g();
    public static final a d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            g.c = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            g.c = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (g.c || a.a.b.a.b.b.f1073a == null) {
                return;
            }
            JSONObject params = new JSONObject();
            try {
                int i = g.f1085a;
                g.f1085a = i + 1;
                params.put("play_session_num", i);
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullParameter("Convert:PlaySession", "tag");
            Intrinsics.checkNotNullParameter("play_session send", "msg");
            if (pn.d.a().getEnableLog()) {
                Log.d("Convert:PlaySession", "play_session send");
            }
            Intrinsics.checkNotNullParameter("play_session", "label");
            Intrinsics.checkNotNullParameter(params, "params");
            a.a.b.a.b.b bVar = new a.a.b.a.b.b("play_session");
            bVar.g = null;
            bVar.h = params;
            bVar.a("Convert:PlaySession");
        }
    }

    public final synchronized void a(long j) {
        Timer timer = b;
        if (timer != null) {
            timer.cancel();
        }
        Intrinsics.checkNotNullParameter("Convert:PlaySession", "tag");
        Intrinsics.checkNotNullParameter("cancelPlaySessionEvent", "msg");
        pn pnVar = pn.d;
        if (pnVar.a().getEnableLog()) {
            Log.d("Convert:PlaySession", "cancelPlaySessionEvent");
        }
        b = new Timer();
        b bVar = new b();
        Timer timer2 = b;
        if (timer2 != null) {
            timer2.schedule(bVar, j, 60000L);
        }
        Intrinsics.checkNotNullParameter("Convert:PlaySession", "tag");
        Intrinsics.checkNotNullParameter("startPlaySessionEvent", "msg");
        if (pnVar.a().getEnableLog()) {
            Log.d("Convert:PlaySession", "startPlaySessionEvent");
        }
    }
}
