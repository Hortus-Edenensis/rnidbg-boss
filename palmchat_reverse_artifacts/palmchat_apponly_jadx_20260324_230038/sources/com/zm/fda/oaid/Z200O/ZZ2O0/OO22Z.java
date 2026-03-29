package com.zm.fda.oaid.Z200O.ZZ2O0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16715a = "IdentifierManager";
    public static Object b;
    public static Class<?> c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;

    static {
        try {
            Class<?> cls = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA=="));
            c = cls;
            b = cls.newInstance();
            d = c.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0VURJRA=="), Context.class);
            e = c.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0T0FJRA=="), Context.class);
            f = c.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0VkFJRA=="), Context.class);
            g = c.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0QUFJRA=="), Context.class);
        } catch (Exception e2) {
            Log.e(f16715a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, d);
    }

    public static String d(Context context) {
        return a(context, f);
    }

    public static String a(Context context) {
        return a(context, g);
    }

    public static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            return objInvoke != null ? (String) objInvoke : "";
        } catch (Exception e2) {
            Log.e(f16715a, "invoke exception!", e2);
            return "";
        }
    }
}
