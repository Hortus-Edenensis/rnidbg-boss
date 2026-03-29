package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class wz6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f21845a;

    public static final boolean a() {
        Context context = null;
        try {
            if (f21845a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f21845a = method;
                method.setAccessible(true);
            }
            context = (Context) f21845a.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return jc7.b().g(context, false);
    }

    public static String b(Context context) {
        jc7 jc7VarB = jc7.b();
        return jc7VarB.c(context.getApplicationContext(), jc7VarB.b);
    }
}
