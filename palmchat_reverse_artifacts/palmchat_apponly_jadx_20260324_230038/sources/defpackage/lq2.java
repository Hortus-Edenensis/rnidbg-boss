package defpackage;

import android.content.Context;
import android.util.Log;
import com.zm.fda.oaid.Z200O.ZZ2O0.OO22Z;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class lq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f19055a;
    public static Class<?> b;
    public static Method c;
    public static Method d;
    public static Method e;
    public static Method f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f19055a = cls.newInstance();
            c = b.getMethod("getUDID", Context.class);
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getVAID", Context.class);
            f = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(OO22Z.f16715a, "reflect exception!", e2);
        }
    }

    public static String a(Context context, Method method) {
        Object obj = f19055a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(OO22Z.f16715a, "invoke exception!", e2);
            return null;
        }
    }

    public static boolean b() {
        return (b == null || f19055a == null) ? false : true;
    }

    public static String c(Context context) {
        return a(context, d);
    }
}
