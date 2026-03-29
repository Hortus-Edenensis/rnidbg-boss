package com.zm.fda.oaid.Z200O.ZZ500;

import android.content.Context;
import com.zm.fda.oaid.Z25O0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16718a;
    public Class<?> b;
    public Class<?> c;
    public Class<?> d;

    public ZZ00Z(Context context) {
        try {
            this.f16718a = context;
            this.b = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5taWl0bWRpZC5jb3JlLk1kaWRTZGtIZWxwZXI="));
            this.c = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5zdXBwbGllci5JSWRlbnRpZmllckxpc3RlbmVy"));
            this.d = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5zdXBwbGllci5JZFN1cHBsaWVy"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static ZZ00Z a(Context context) {
        return new ZZ00Z(context);
    }

    public boolean a() {
        return (this.b == null || this.c == null || this.d == null) ? false : true;
    }

    public void a(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (a() && this.f16718a != null) {
            try {
                if (((Integer) this.b.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("SW5pdFNkaw=="), Context.class, Boolean.class, this.c).invoke(null, this.f16718a, Boolean.TRUE, Proxy.newProxyInstance(this.c.getClassLoader(), new Class[]{this.c}, new InvocationHandler() { // from class: hq6
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        return this.f18031a.a(z25o0, obj, method, objArr);
                    }
                }))).intValue() != 0) {
                    z25o0.a("");
                    return;
                }
                return;
            } catch (Throwable th) {
                z25o0.a("");
                th.printStackTrace();
                return;
            }
        }
        z25o0.a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Object a(Z25O0 z25o0, Object obj, Method method, Object[] objArr) {
        String str;
        Object objInvoke = "";
        if (method != null) {
            try {
                if (!com.zm.fda.oaid.Z2500.OO22Z.a("T25TdXBwb3J0").equals(method.getName()) || objArr.length < 2) {
                    str = "";
                } else {
                    str = (String) this.d.getDeclaredMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0T0FJRA=="), new Class[0]).invoke(objArr[1], new Object[0]);
                }
            } catch (Throwable th) {
                th = th;
                str = "";
                th.printStackTrace();
                if (z25o0 != null) {
                }
                return objInvoke;
            }
            try {
                objInvoke = method.invoke(obj, objArr);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        }
        if (z25o0 != null) {
            z25o0.a(str);
        }
        return objInvoke;
    }
}
