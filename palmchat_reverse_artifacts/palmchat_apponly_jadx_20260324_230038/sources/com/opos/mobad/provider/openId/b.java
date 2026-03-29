package com.opos.mobad.provider.openId;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.opos.mobad.provider.record.SdKRecord;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static OutOpenIdWrapper f9167a = null;
    private static boolean b = false;
    private static boolean c = true;
    private static int f;
    private static Context g;
    private String d;
    private String e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements InvocationHandler {
        private a() {
        }

        private String b(Class<?> cls, Object obj, String str) {
            if (cls != null && obj != null && !TextUtils.isEmpty(str)) {
                try {
                    return (String) cls.getMethod(str, new Class[0]).invoke(obj, null);
                } catch (Exception unused) {
                }
            }
            return "";
        }

        public void a(Object obj) {
            try {
                boolean zA = a(IdSupplier.class, obj, "isSupported");
                b.a(zA);
                if (IdSupplier.class.isInstance(obj) && zA) {
                    String strB = b(IdSupplier.class, obj, "getOAID");
                    String strB2 = b(IdSupplier.class, obj, "getVAID");
                    if (TextUtils.isEmpty(strB) || strB.matches("^[0-]+$")) {
                        b.a(-30050);
                    } else {
                        SdKRecord.a(b.g).b(strB, strB2);
                        b.this.d = strB;
                    }
                }
                com.opos.cmn.an.f.a.b("IdHelper", "reset mOuid:" + b.this.d + "sSupportMdid:" + b.c);
            } catch (Throwable th) {
                b.a(false);
                b.a(-30051);
                com.opos.cmn.an.f.a.b("IdHelper", "resetOuid fail", th);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            com.opos.cmn.an.f.a.b("IdHelper", "invoke proxy execute");
            if (objArr == null) {
                com.opos.cmn.an.f.a.b("IdHelper", "invoke null");
                b.a(-30042);
                return null;
            }
            if (objArr.length == 1 || objArr.length == 2) {
                a(objArr[objArr.length - 1]);
            } else {
                com.opos.cmn.an.f.a.b("IdHelper", "invoke length err");
                b.a(-30043);
            }
            return Integer.valueOf(objArr.length);
        }

        private boolean a(Class<?> cls, Object obj, String str) {
            if (cls != null && obj != null && !TextUtils.isEmpty(str)) {
                try {
                    return ((Boolean) cls.getMethod(str, new Class[0]).invoke(obj, null)).booleanValue();
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    static {
        boolean z;
        int i;
        try {
            f9167a = new OutOpenIdWrapper(f);
            z = true;
            try {
                int i2 = MdidSdkHelper.SDK_VERSION_CODE;
                b = true;
            } catch (Throwable th) {
                th = th;
                com.opos.cmn.an.f.a.b("IdHelper", "not support openid", th);
                b = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (z && !b) {
            i = -30062;
        } else if (z) {
            return;
        } else {
            i = -30063;
        }
        a(i);
    }

    public b(Context context) {
        this.d = "";
        this.e = "";
        Context applicationContext = context.getApplicationContext();
        g = applicationContext;
        this.d = SdKRecord.a(applicationContext).k();
        this.e = SdKRecord.a(g).l();
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.provider.openId.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(b.g);
            }
        });
    }

    public String a() {
        return (b && c) ? this.d : "";
    }

    public String b() {
        return (b && c) ? this.e : "";
    }

    public boolean c() {
        if (b) {
            return c;
        }
        return false;
    }

    public static void a(int i) {
        f = i;
        f9167a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!b) {
            com.opos.cmn.an.f.a.b("IdHelper", "not support");
            return;
        }
        try {
            int i = MdidSdkHelper.SDK_VERSION_CODE;
            Object objInvoke = MdidSdkHelper.class.getMethod("InitSdk", Context.class, Boolean.TYPE, IIdentifierListener.class).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(IIdentifierListener.class.getClassLoader(), new Class[]{IIdentifierListener.class}, new a()));
            com.opos.cmn.an.f.a.b("IdHelper", "init result:" + objInvoke + ",cost:" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            if (f == 0) {
                a(((Integer) objInvoke).intValue());
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("IdHelper", "initOuid fail", th);
        }
    }

    public static void a(boolean z) {
        c = z & c;
    }
}
