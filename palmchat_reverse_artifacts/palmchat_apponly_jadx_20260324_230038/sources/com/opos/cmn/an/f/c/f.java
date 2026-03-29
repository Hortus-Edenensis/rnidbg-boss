package com.opos.cmn.an.f.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.ads.ex;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.opos.cmn.an.f.b.g;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7777a = b("ZGVidWcuY29tLm9wb3MuY21uLmxvZw==");
    private static final String b = b("ZGVidWcu");
    private static final String c = b("Lm9wb3MubG9n");
    private static volatile Boolean d = null;
    private static volatile Boolean e = null;
    private static volatile Boolean f = null;
    private static volatile String g = "";
    private static volatile Boolean h = null;
    private static final String[] i = {"Y29tLmhleXRhcC5icm93c2Vy", "Y29tLmFuZHJvaWQuYnJvd3Nlcg==", "Y29tLmNvbG9yb3MuYnJvd3Nlcg==", "Y29tLmNvbG9yb3Mud2VhdGhlcjI="};

    private static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 29 || context == null) {
            return "";
        }
        try {
            g.a(context);
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void c() {
        if (b() || j()) {
            f = Boolean.TRUE;
        }
    }

    public static boolean d() {
        if (f == null) {
            return false;
        }
        return f.booleanValue();
    }

    public static boolean e() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String f() {
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        g = g();
        if (TextUtils.isEmpty(g)) {
            g = h();
        }
        if (TextUtils.isEmpty(g)) {
            g = i();
        }
        return g;
    }

    public static String g() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String h() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String i() {
        String line = null;
        if (TextUtils.isEmpty(null)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/cmdline"));
                try {
                    line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line)) {
                        line = line.trim();
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception unused) {
            }
        }
        return line;
    }

    public static synchronized boolean j() {
        boolean z = false;
        if (e != null && h != null) {
            if (e.booleanValue()) {
                if (h.booleanValue()) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public static String a(com.opos.cmn.an.f.b.b.d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(dVar.f7761a);
        sb.append("][");
        sb.append(a(dVar.g));
        sb.append("][");
        sb.append(Process.myPid());
        sb.append("][");
        sb.append(dVar.f);
        sb.append(":");
        sb.append(dVar.e);
        sb.append("]:");
        if (dVar.h == 2) {
            Object[] objArr = (Object[]) dVar.b;
            int length = objArr.length;
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    sb.append(objArr[i2]);
                    if (i2 < length - 1) {
                        sb.append(",");
                    }
                }
            }
        } else {
            sb.append(dVar.b);
        }
        if (dVar.c != null) {
            sb.append("\n");
            sb.append(Log.getStackTraceString(dVar.c));
        }
        return sb.toString();
    }

    public static String b(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? a(str.getBytes()) : "";
    }

    public static void c(Context context) {
        if (e == null) {
            boolean z = false;
            try {
                String packageName = context.getPackageName();
                String strA = a(b + packageName + c);
                if (!TextUtils.isEmpty(strA) && strA.contentEquals(ex.Code)) {
                    z = true;
                }
                c(packageName);
            } catch (Throwable unused) {
            }
            e = Boolean.valueOf(z);
        }
    }

    public static String a(String str) {
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return "";
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            return str2 != null ? str2 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized boolean b() {
        if (d == null) {
            return false;
        }
        return d.booleanValue();
    }

    private static void c(String str) {
        Boolean bool;
        String[] strArr = i;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                bool = Boolean.FALSE;
                break;
            } else {
                if (str.equals(b(strArr[i2]))) {
                    bool = Boolean.TRUE;
                    break;
                }
                i2++;
            }
        }
        h = bool;
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        boolean z;
        String strA;
        if (d == null) {
            try {
                strA = a(f7777a);
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(strA)) {
                z = strA.contentEquals(ex.Code);
            }
            d = Boolean.valueOf(z);
        }
    }

    public static void a(Context context) {
        if (f == null) {
            boolean z = false;
            try {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            f = Boolean.valueOf(z);
        }
    }
}
