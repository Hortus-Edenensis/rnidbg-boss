package com.unicom.xiaowo.account.shield.b;

import android.content.Context;
import android.text.TextUtils;
import com.unicom.xiaowo.account.shield.ResultListener;
import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f11186a;
    private int b = 0;
    private boolean c = false;

    private e() {
    }

    public static e a() {
        if (f11186a == null) {
            synchronized (e.class) {
                if (f11186a == null) {
                    f11186a = new e();
                }
            }
        }
        return f11186a;
    }

    public static String b() {
        return "4.4.0AR002B0721";
    }

    private boolean c() {
        try {
            if (com.unicom.xiaowo.account.shield.c.c.a() != null) {
                return true;
            }
            com.unicom.xiaowo.account.shield.c.b.b("sdk load fail");
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean a(Context context, String str, String str2, int i) {
        try {
            Class<?> clsLoadClass = com.unicom.xiaowo.account.shield.c.c.a().loadClass("com.unicom.xiaowo.login.UniAuthHelper");
            clsLoadClass.getMethod("init", Context.class, String.class, String.class, Integer.TYPE).invoke(clsLoadClass.getMethod("getInstance", new Class[0]).invoke(clsLoadClass, new Object[0]), context, str, str2, Integer.valueOf(i));
            return true;
        } catch (Exception e) {
            com.unicom.xiaowo.account.shield.c.b.b("initsdk error:" + e.getMessage());
            com.unicom.xiaowo.account.shield.c.c.a((DexClassLoader) null);
            return false;
        }
    }

    private void a(Context context) {
        InputStream inputStreamD = null;
        try {
            try {
                try {
                    inputStreamD = com.unicom.xiaowo.account.shield.c.c.d(context);
                    byte[] bArrA = com.unicom.xiaowo.account.shield.c.e.a();
                    byte[] bArrA2 = com.unicom.xiaowo.account.shield.c.c.a(inputStreamD);
                    String strA = com.unicom.xiaowo.account.shield.c.c.a(bArrA2);
                    if (TextUtils.isEmpty(strA) || a("4.4.0AR002B0721", strA) != 1 || "4.4.0AR002B0721".compareTo(strA) > 0) {
                        this.b = 0;
                    } else {
                        this.b = 1;
                    }
                    if (this.b == 0) {
                        com.unicom.xiaowo.account.shield.c.c.b(context, bArrA);
                    } else {
                        com.unicom.xiaowo.account.shield.c.c.a(context, bArrA2);
                    }
                    com.unicom.xiaowo.account.shield.c.c.a(context, com.unicom.xiaowo.account.shield.c.c.c(context));
                    if (com.unicom.xiaowo.account.shield.c.c.a() != null) {
                        com.unicom.xiaowo.account.shield.c.b.a("sdk load success");
                    } else {
                        com.unicom.xiaowo.account.shield.c.b.b("sdk load fail");
                    }
                    com.unicom.xiaowo.account.shield.c.c.a(context);
                    if (this.b == 0) {
                        com.unicom.xiaowo.account.shield.c.c.b(context);
                    }
                } catch (Throwable th) {
                    if (inputStreamD != null) {
                        try {
                            inputStreamD.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStreamD == null) {
                    return;
                } else {
                    inputStreamD.close();
                }
            }
            if (inputStreamD != null) {
                inputStreamD.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, String str, String str2) {
        if (context != null) {
            try {
            } catch (Exception e) {
                com.unicom.xiaowo.account.shield.c.b.b(e.getMessage());
                this.c = false;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.c) {
                    com.unicom.xiaowo.account.shield.c.b.a("重复初始化");
                    return this.c;
                }
                a(context);
                boolean zA = a(context, str, str2, this.b);
                if (com.unicom.xiaowo.account.shield.c.c.a() != null && zA) {
                    com.unicom.xiaowo.account.shield.c.b.a("init success");
                    this.c = true;
                    return this.c;
                }
                com.unicom.xiaowo.account.shield.c.b.a("sdk init fail");
                return false;
            }
        }
        com.unicom.xiaowo.account.shield.c.b.a("初始化参数不能为空");
        return false;
    }

    public void a(Context context, int i, int i2, ResultListener resultListener) {
        if (a(context, resultListener)) {
            a(i, i2, new d(this));
        }
    }

    public void a(boolean z) {
        try {
            com.unicom.xiaowo.account.shield.c.b.a(z);
            if (c()) {
                Class<?> clsLoadClass = com.unicom.xiaowo.account.shield.c.c.a().loadClass("com.unicom.xiaowo.login.UniAuthHelper");
                clsLoadClass.getMethod("setLogEnable", Boolean.TYPE).invoke(clsLoadClass.getMethod("getInstance", new Class[0]).invoke(clsLoadClass, new Object[0]), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            com.unicom.xiaowo.account.shield.c.b.b("setLogEnable error:" + e.getMessage());
        }
    }

    private boolean a(Context context, ResultListener resultListener) {
        if (resultListener == null) {
            com.unicom.xiaowo.account.shield.c.b.a("ResultListener不能为空");
            return false;
        }
        if (!this.c) {
            com.unicom.xiaowo.account.shield.c.b.a("sdk初始化失败");
            c.a(resultListener, "sdk初始化失败");
            return false;
        }
        if (!com.unicom.xiaowo.account.shield.c.d.a(context)) {
            c.a(resultListener, "网络未连接");
            return false;
        }
        c.b().a(resultListener);
        return true;
    }

    private int a(String str, String str2) {
        try {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            for (int i = 0; i < 5; i++) {
                int i2 = 5 + i;
                if (bytes[i2] != bytes2[i2]) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private void a(int i, int i2, InvocationHandler invocationHandler) {
        try {
            DexClassLoader dexClassLoaderA = com.unicom.xiaowo.account.shield.c.c.a();
            Class<?> clsLoadClass = dexClassLoaderA.loadClass("com.unicom.xiaowo.login.UniAuthHelper");
            Class<?> clsLoadClass2 = dexClassLoaderA.loadClass("com.unicom.xiaowo.login.ResultListener");
            Object objInvoke = clsLoadClass.getMethod("getInstance", new Class[0]).invoke(clsLoadClass, new Object[0]);
            Class<?> cls = Integer.TYPE;
            clsLoadClass.getMethod("preGetToken", cls, cls, clsLoadClass2).invoke(objInvoke, Integer.valueOf(i), Integer.valueOf(i2), Proxy.newProxyInstance(dexClassLoaderA, new Class[]{clsLoadClass2}, invocationHandler));
        } catch (Exception e) {
            com.unicom.xiaowo.account.shield.c.b.b(e.getMessage());
        }
    }
}
