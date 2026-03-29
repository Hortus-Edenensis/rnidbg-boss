package com.zm.fda.oaid.Z200O.ZZ500;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.ex;
import com.zm.fda.oaid.Z25O0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {
    public static final int e = 1008614;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16716a;
    public Class<?> b;
    public Class<?> c;
    public Class<?> d;

    public O022Z(Context context) {
        try {
            this.f16716a = context;
            this.b = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5taWl0bWRpZC5jb3JlLk1kaWRTZGtIZWxwZXI="));
            this.c = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5taWl0bWRpZC5pbnRlcmZhY2VzLklJZGVudGlmaWVyTGlzdGVuZXI="));
            this.d = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5taWl0bWRpZC5pbnRlcmZhY2VzLklkU3VwcGxpZXI="));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static O022Z a(Context context) {
        return new O022Z(context);
    }

    public boolean a() {
        return (this.b == null || this.c == null || this.d == null) ? false : true;
    }

    public void a(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (a() && this.f16716a != null) {
            Object objNewProxyInstance = Proxy.newProxyInstance(this.c.getClassLoader(), new Class[]{this.c}, new InvocationHandler() { // from class: g44
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return this.f17646a.a(z25o0, obj, method, objArr);
                }
            });
            String strA = com.zm.fda.oaid.Z2500.OO22Z.a("SW5pdFNkaw==");
            try {
                int iIntValue = ((Integer) this.b.getMethod(strA, Context.class, Boolean.TYPE, this.c).invoke(null, this.f16716a, Boolean.TRUE, objNewProxyInstance)).intValue();
                if (iIntValue != 0) {
                    z25o0.a("");
                }
                Log.e("MsaReflectionHelper2", "InitSdk res:" + iIntValue);
                return;
            } catch (Throwable th) {
                Log.e("MsaReflectionHelper2", th.getMessage(), th);
                try {
                    Method method = this.b.getMethod(strA, Context.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, this.c);
                    Boolean bool = Boolean.FALSE;
                    int iIntValue2 = ((Integer) method.invoke(null, this.f16716a, bool, Boolean.TRUE, bool, bool, objNewProxyInstance)).intValue();
                    if (iIntValue2 != 0) {
                        z25o0.a("");
                    }
                    Log.e("MsaReflectionHelper2", "InitSdk res:" + iIntValue2);
                    return;
                } catch (Throwable unused) {
                    z25o0.a("");
                    Log.e("MsaReflectionHelper2", th.getMessage(), th);
                    return;
                }
            }
        }
        z25o0.a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a(Z25O0 z25o0, Object obj, Method method, Object[] objArr) {
        Object obj2;
        String str;
        String str2;
        Object objInvoke;
        String str3 = "";
        if (method == null || !"OnSupport".equals(method.getName()) || objArr.length < 1) {
            obj2 = "";
            str = str3;
        } else {
            try {
                Object obj3 = objArr[0];
                Method declaredMethod = this.d.getDeclaredMethod(com.zm.fda.oaid.Z2500.OO22Z.a("aXNTdXBwb3J0ZWQ="), new Class[0]);
                Method declaredMethod2 = this.d.getDeclaredMethod(com.zm.fda.oaid.Z2500.OO22Z.a("aXNMaW1pdGVk"), new Class[0]);
                Method declaredMethod3 = this.d.getDeclaredMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0T0FJRA=="), new Class[0]);
                try {
                    String str4 = (String) declaredMethod.invoke(obj3, new Object[0]);
                    String str5 = (String) declaredMethod2.invoke(obj3, new Object[0]);
                    if (TextUtils.equals(str4, ex.Code) && TextUtils.equals(str5, ex.V)) {
                        str2 = (String) declaredMethod3.invoke(obj3, new Object[0]);
                        try {
                            Log.d("MsaReflectionHelper2", "oaid:" + str2);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                objInvoke = str3;
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                                objInvoke = str3;
                            }
                        }
                    } else {
                        Log.d("MsaReflectionHelper2", " get oaid err");
                        str2 = "";
                    }
                    objInvoke = method.invoke(obj, objArr);
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "";
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "";
            }
            obj2 = objInvoke;
            str = str2;
        }
        if (z25o0 != null) {
            z25o0.a(str);
        }
        return obj2;
    }
}
