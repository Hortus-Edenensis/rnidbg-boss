package defpackage;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hq2 {
    public static String a(Context context) {
        try {
            Class<?> clsB = b(context, rv2.h("KIHhQylffktk79IAY9r8iabG5YlYSM/WswW6fWtc2r2WbTdKR65l5atPPp2u96wd"));
            Object objNewInstance = clsB.newInstance();
            Method method = clsB.getMethod(rv2.h("Oi3ZFT8+schQHSyFZbsdUg=="), Context.class);
            Method method2 = clsB.getMethod(rv2.h("fIdCW1auJ/CZh7w78TbJVQ=="), Context.class);
            Object objInvoke = clsB.getMethod(rv2.h("cBEuCuv+AtdlTcgTe9OgSQ=="), Context.class).invoke(objNewInstance, context);
            Object objInvoke2 = method2.invoke(objNewInstance, context);
            Object objInvoke3 = method.invoke(objNewInstance, context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("joad", objInvoke3);
            jSONObject.put("jvad", objInvoke2);
            jSONObject.put("jaad", objInvoke);
            return jSONObject.toString();
        } catch (Throwable th) {
            p63.g("IdProvider", "getIds failed:" + th.getMessage());
            return "";
        }
    }

    public static Class<?> b(Context context, String str) throws ClassNotFoundException {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e) {
                p63.f("IdProvider", "loadClass error, " + e.getMessage());
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            p63.f("IdProvider", String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e2);
        }
    }
}
