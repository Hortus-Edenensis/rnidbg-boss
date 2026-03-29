package com.opos.cmn.i;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    public static void a(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        a(activity, false);
        window.clearFlags(4194304);
    }

    public static void b(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null || !a((Context) activity)) {
            return;
        }
        a(activity, true);
        window.addFlags(4194304);
    }

    public static void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "setShowWhenLocked =" + z);
        if (z) {
            if (Build.VERSION.SDK_INT > 27) {
                activity.setShowWhenLocked(true);
            }
            activity.getWindow().addFlags(524288);
        } else {
            if (Build.VERSION.SDK_INT > 27) {
                activity.setShowWhenLocked(false);
            }
            activity.getWindow().clearFlags(524288);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(KeyguardManager keyguardManager, Activity activity, final a aVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            if (i <= 28) {
                a(activity);
            }
            keyguardManager.requestDismissKeyguard(activity, new KeyguardManager.KeyguardDismissCallback() { // from class: com.opos.cmn.i.g.2
                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissCancelled() {
                    super.onDismissCancelled();
                    com.opos.cmn.an.f.a.b("KeyguardUtils", "onDismissCancelled");
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissError() {
                    super.onDismissError();
                    com.opos.cmn.an.f.a.b("KeyguardUtils", "onDismissError");
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissSucceeded() {
                    super.onDismissSucceeded();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        }
    }

    public static void a(Context context, Window window) {
        if (context == null || window == null) {
            return;
        }
        try {
            if (a(context) && Build.VERSION.SDK_INT <= 25) {
                window.addFlags(524288);
                window.addFlags(4194304);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("KeyguardUtils", "", (Throwable) e);
        }
    }

    private static final void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static boolean a(final Activity activity, final a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return a(aVar);
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "requestKeyguard activity =" + activity);
        if (activity == null || activity.isDestroyed()) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        final KeyguardManager keyguardManager = (KeyguardManager) activity.getSystemService("keyguard");
        if (keyguardManager == null) {
            if (aVar != null) {
                aVar.b();
            }
            return false;
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "request dismiss keyguard");
        a(new Runnable() { // from class: com.opos.cmn.i.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.b(keyguardManager, activity, aVar);
            }
        });
        return true;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager == null) {
            com.opos.cmn.an.f.a.a("KeyguardUtils", "null keyguard");
            return false;
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "isKeyguardLocked -" + keyguardManager.isKeyguardLocked());
        return keyguardManager.isKeyguardLocked();
    }

    public static boolean a(a aVar) {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("android.view.IOppoWindowManagerImpl");
            Object objNewInstance = cls.newInstance();
            com.opos.cmn.an.f.a.b("KeyguardUtils", "object:" + objNewInstance);
            Method declaredMethod = cls.getDeclaredMethod("requestKeyguard", String.class);
            com.opos.cmn.an.f.a.b("KeyguardUtils", "method:" + declaredMethod);
            declaredMethod.invoke(objNewInstance, "unlockOrShowSecurity");
            com.opos.cmn.an.f.a.b("KeyguardUtils", "call over");
            z = true;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("KeyguardUtils", "", th);
        }
        if (z) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.b();
        }
        return z;
    }
}
