package defpackage;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ax6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1603a = "ax6";

    public static void a(Context context, Intent intent) {
        b(context, intent, 0);
    }

    public static void b(Context context, Intent intent, int i) {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("getApplicationThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke2 = declaredMethod.invoke(objInvoke, new Object[0]);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("getInstrumentation", new Class[0]);
            declaredMethod2.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) declaredMethod2.invoke(objInvoke, new Object[0]);
            instrumentation.getClass().getDeclaredMethod("execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class).invoke(instrumentation, context, objInvoke2, null, null, intent, Integer.valueOf(i), null);
        } catch (Throwable th) {
            Log.e(f1603a, "startActivityForResult:", th);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                Log.e(f1603a, "startActivity: ", e);
            }
        }
    }
}
