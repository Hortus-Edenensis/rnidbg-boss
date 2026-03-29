package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class p84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f19961a;

    public static final boolean a() {
        Context context = null;
        try {
            if (f19961a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f19961a = method;
                method.setAccessible(true);
            }
            context = (Context) f19961a.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return i27.b().g(context, false);
    }

    public static String b(Context context) {
        i27 i27VarB = i27.b();
        return i27VarB.c(context.getApplicationContext(), i27VarB.b);
    }
}
