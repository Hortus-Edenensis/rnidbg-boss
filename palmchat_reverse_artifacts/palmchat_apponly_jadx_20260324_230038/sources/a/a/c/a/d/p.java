package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class p implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f1120a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f1120a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // a.a.c.a.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a a(Context context) {
        String str;
        try {
            c.a aVar = new c.a();
            Method method = c;
            Object obj = f1120a;
            if (obj == null || method == null) {
                str = null;
            } else {
                try {
                    Object objInvoke = method.invoke(obj, context);
                    if (objInvoke != null) {
                        str = (String) objInvoke;
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f1105a = str;
            return aVar;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        return (b == null || f1120a == null || c == null) ? false : true;
    }
}
