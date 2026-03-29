package com.qq.gdt.action.j;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f10528a = null;
    private static String b = "";
    private static String c = "";
    private static boolean d = false;

    public static String a() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            return objInvoke instanceof String ? (String) objInvoke : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/cmdline")));
            try {
                String strTrim = bufferedReader.readLine().replace((char) 0, ' ').trim();
                try {
                    bufferedReader.close();
                    return strTrim;
                } catch (Exception e) {
                    e.printStackTrace();
                    return strTrim;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static boolean d() {
        try {
            String strA = a(com.qq.gdt.action.d.a().g());
            boolean zEquals = h.d().equals(strA);
            o.a("isMainProcess = " + zEquals + " getApplicationContext().getPackageName() = " + com.qq.gdt.action.d.a().g().getPackageName() + " processName = " + strA, new Object[0]);
            return zEquals;
        } catch (Exception e) {
            o.a("isMainProcess exception = " + e, new Object[0]);
            return false;
        }
    }

    public static Context e() {
        if (f10528a == null) {
            synchronized (d.class) {
                if (f10528a == null) {
                    try {
                        Class<?> cls = Class.forName("android.app.ActivityThread");
                        Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                        f10528a = (Context) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
                        o.a(" AppInfoUtil getContext CONTEXT_INSTANCE = " + f10528a, new Object[0]);
                        com.qq.gdt.action.h.a.a(AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
                    } catch (Throwable th) {
                        com.qq.gdt.action.h.a.a(2102);
                        o.a(" AppInfoUtil getContext ex = " + th, new Object[0]);
                    }
                }
            }
        }
        return f10528a;
    }

    public static String f() {
        return c;
    }

    public static String a(Context context) {
        try {
            if (!v.a(b)) {
                return b;
            }
            String strA = a();
            b = strA;
            if (!v.a(strA)) {
                return b;
            }
            String strB = b();
            b = strB;
            if (!v.a(strB)) {
                return b;
            }
            String strC = c();
            b = strC;
            return strC;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static synchronized String b(Context context) {
        if (!d && TextUtils.isEmpty(c)) {
            com.qq.gdt.action.h.a.a(2900);
            if (context == null) {
                o.a("readFirstApkFile context is null", new Object[0]);
                com.qq.gdt.action.h.a.a(2901);
                return c;
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                File file = new File(applicationInfo.sourceDir);
                if (file.exists()) {
                    c = a(file);
                    o.a("readFirstApkFile Apk file " + applicationInfo.sourceDir + " file2MD5 = " + c, new Object[0]);
                    d = true;
                    if (TextUtils.isEmpty(c)) {
                        com.qq.gdt.action.h.a.a(2903);
                    } else {
                        com.qq.gdt.action.h.a.a(2902);
                    }
                } else {
                    o.a("readFirstApkFile package:" + applicationInfo.packageName + " Apk file " + applicationInfo.sourceDir + " doesn't exist", new Object[0]);
                    com.qq.gdt.action.h.a.a(2905);
                }
            } catch (Exception e) {
                o.a("readFirstApkFile", e);
                com.qq.gdt.action.h.a.a(2904);
            }
            com.qq.gdt.action.h.a.a(2906);
            return c;
        }
        return c;
    }

    private static String a(File file) {
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i2 = b2 & UByte.MAX_VALUE;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception e) {
            o.a("file2MD5", e);
            return "";
        }
    }
}
