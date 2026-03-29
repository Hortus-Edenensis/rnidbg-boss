package defpackage;

import android.app.Application;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class gm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Application f17748a;

    static {
        Application application;
        Application application2 = null;
        try {
            try {
                application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
                if (application == null) {
                    try {
                        throw new IllegalStateException("Static initialization of Applications must be on main thread.");
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        try {
                            application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                            e.printStackTrace();
                        }
                        f17748a = application;
                    }
                }
            } catch (Throwable th) {
                th = th;
                application2 = application;
                f17748a = application2;
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            application = null;
        } catch (Throwable th2) {
            th = th2;
            f17748a = application2;
            throw th;
        }
        f17748a = application;
    }

    public static Application a() {
        return f17748a;
    }
}
