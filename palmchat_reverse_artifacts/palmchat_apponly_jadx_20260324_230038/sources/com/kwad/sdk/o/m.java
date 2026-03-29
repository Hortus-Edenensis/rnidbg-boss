package com.kwad.sdk.o;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class m {
    private static Application bjg;

    public static void C(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private static boolean UR() {
        if (f.UK().Tn()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static Application US() {
        UR();
        Application applicationUT = UT();
        if (j.UP()) {
            bjg = (Application) j.wrapContextIfNeed(applicationUT);
        }
        return bjg;
    }

    private static Application UT() {
        Application application = bjg;
        if (application != null) {
            return application;
        }
        Context contextRe = ServiceProvider.Re();
        if (contextRe instanceof Application) {
            Application application2 = (Application) contextRe;
            bjg = application2;
            return application2;
        }
        Context applicationContext = contextRe.getApplicationContext();
        if (applicationContext instanceof Application) {
            Application application3 = (Application) applicationContext;
            bjg = application3;
            return application3;
        }
        Context contextEt = aW(applicationContext) ? j.et(applicationContext) : k.aW(applicationContext) ? k.et(applicationContext) : contextRe.getApplicationContext();
        if (contextEt instanceof Application) {
            bjg = (Application) contextEt;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Ji().getApplication();
            if (application4 != null) {
                bjg = application4;
            } else if (contextEt instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) contextEt).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    bjg = (Application) baseContext;
                }
            }
        }
        if (bjg == null) {
            bjg = UU();
        }
        Application applicationEy = ey(bjg);
        bjg = applicationEy;
        return applicationEy;
    }

    private static Application UU() {
        Application application = (Application) z.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) z.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static boolean UV() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() || f.UK().UL();
    }

    public static View a(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup, boolean z) {
        return eB(context).inflate(i, viewGroup, z);
    }

    private static Context aU(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    private static boolean aW(Context context) {
        return context instanceof b;
    }

    public static void b(Application application) {
        if (bjg == null) {
            bjg = application;
        }
    }

    public static Context eA(Context context) {
        try {
            if (k.aW(context)) {
                context = k.aV(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (ez(context)) {
                return context;
            }
            for (int i = 0; i < 5; i++) {
                if (k.aW(context)) {
                    context = k.aV(context);
                }
                if (context instanceof b) {
                    context = ((b) context).getDelegatedContext();
                }
                if (ez(context)) {
                    return context;
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return context;
    }

    public static LayoutInflater eB(Context context) {
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        if (!k.aW(contextWrapContextIfNeed)) {
            return LayoutInflater.from(contextWrapContextIfNeed);
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextWrapContextIfNeed);
        a(layoutInflaterFrom);
        return layoutInflaterFrom;
    }

    @NonNull
    private static Context ev(Context context) {
        if (j.UP() && !aW(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
        } else if (!j.UP() && !k.aW(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
        }
        return context;
    }

    @NonNull
    public static Context ew(Context context) {
        if (UR() && UV() && !ez(context)) {
            return ex(aW(context) ? j.es(context) : k.unwrapContextIfNeed(context));
        }
        return context;
    }

    private static Context ex(Context context) {
        if (k.aW(context) || (context instanceof b)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
        }
        return context;
    }

    private static Application ey(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() + "--isInnerDex:" + f.UK().UL()));
        return null;
    }

    public static boolean ez(Context context) {
        return (aW(context) || k.aW(context)) ? false : true;
    }

    @Nullable
    public static Activity getActivityFromContext(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context contextEw = ew(context);
        if (contextEw instanceof Activity) {
            return (Activity) contextEw;
        }
        com.kwad.sdk.core.c.b.Ji();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object objA = z.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
        if (objA != null) {
            return ((Integer) objA).intValue();
        }
        return 0;
    }

    public static View inflate(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup) {
        return eB(context).inflate(i, viewGroup);
    }

    public static void r(Activity activity) {
        k.onDestroy(activity);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        if (UR() && UV()) {
            return ev(j.UP() ? j.wrapContextIfNeed(context) : k.wrapContextIfNeed(context));
        }
        return context;
    }

    public static LayoutInflater a(Context context, Context context2) {
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(aU(context)).cloneInContext(context2);
        a(layoutInflaterCloneInContext);
        return layoutInflaterCloneInContext;
    }

    private static void a(LayoutInflater layoutInflater) {
        z.a(layoutInflater, "mFactory", (Object) null);
        z.a(layoutInflater, "mFactory2", (Object) null);
    }
}
