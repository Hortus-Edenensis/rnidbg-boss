package com.tencent.turingfd.sdk.ams.ad;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.throw, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cthrow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f10776a = new WeakHashMap<>();
    public static final AtomicReference<Cdo> b = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.throw$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo extends com.tencent.turingfd.sdk.ams.ad.Cdo implements Cnew, Dew {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f10777a = new AtomicBoolean(false);
        public final Cconst b;

        public Cdo(Cconst cconst) {
            this.b = cconst;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            this.f10777a.set(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Window window;
            if (activity != null && (window = activity.getWindow()) != null) {
                String name = activity.getClass().getName();
                try {
                    WeakHashMap<Activity, Object> weakHashMap = Cthrow.f10776a;
                    if (!weakHashMap.containsKey(activity)) {
                        weakHashMap.put(activity, null);
                        Window.Callback callback = window.getCallback();
                        if (callback != null && !(callback instanceof Olive)) {
                            window.setCallback(new Olive(callback, name, this));
                        }
                        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnPreDrawListener(new Csuper(window, this, name));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f10777a.set(false);
        }
    }
}
