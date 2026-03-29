package cn.fly.verify;

import android.content.Context;
import cn.fly.verify.ce;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cl extends ce {
    public cl(Context context) {
        super(context);
    }

    private String a(Context context, Object obj, Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    @Override // cn.fly.verify.ce
    public ce.b b() {
        Class<?> cls;
        Object objNewInstance;
        Method method = null;
        try {
            cls = Class.forName(ed.a("034cVeddffd9deVdcdjeddidcfddidcfddidfLjgEfdeidcgldjeddddidcZfUdjeidf.jg"));
            try {
                objNewInstance = cls.newInstance();
            } catch (Throwable th) {
                th = th;
                en.a().a(th);
                objNewInstance = null;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        if (cls != null && objNewInstance != null) {
            try {
                method = cls.getMethod(ed.a("007AeeXfiZggeleifk"), Context.class);
            } catch (Throwable th3) {
                en.a().a(th3);
            }
        }
        ce.b bVar = new ce.b();
        bVar.b = a(this.f2142a, objNewInstance, method);
        bVar.f2144a = (cls == null || objNewInstance == null) ? false : true;
        return bVar;
    }
}
