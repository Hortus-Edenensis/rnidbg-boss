package com.unicom.online.account.kernel;

import android.content.Context;
import java.security.Security;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {
    private static volatile f c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11155a;
    public ExecutorService b = Executors.newSingleThreadExecutor();

    private f() {
    }

    public static /* synthetic */ int a(int i) {
        return Math.abs(new Random().nextInt() % i);
    }

    public static String b() {
        return u.a();
    }

    public static String c() {
        return u.b();
    }

    public static String d() {
        if (Security.getProvider("BC") == null) {
            return "Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) is null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Security.getProvider("BC").getVersion());
        return sb.toString();
    }

    public static String e() {
        return u.e;
    }

    public static String f() {
        return "auth.wosms.cn";
    }

    public static String g() {
        u.e = "msv6.wosms.cn";
        return "msv6.wosms.cn";
    }

    public static void h() {
        x.a().b();
    }

    public static void b(Context context) {
        w.b(context);
    }

    public static void c(Context context) {
        w.d(context);
    }

    public static boolean d(Context context) {
        int iB = ad.b(context);
        return iB == 0 || iB == 1;
    }

    public static void e(Context context) {
        v.a(context);
    }

    public static f a() {
        if (c == null) {
            synchronized (f.class) {
                if (c == null) {
                    c = new f();
                }
            }
        }
        return c;
    }

    public static String a(Context context, String str, String str2) {
        return v.a(context, str, str2);
    }

    public static void a(e eVar, String str) {
        ab.d(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", "CU");
            eVar.onResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(boolean z) {
        ab.a(z);
    }

    public static boolean a(Context context) {
        return w.a(context) && w.c(context);
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        return v.a(context, str, str2, str3);
    }

    public static boolean a(String str) {
        if (!str.equalsIgnoreCase("ali.wosms.cn") && !str.equalsIgnoreCase("msv6.wosms.cn") && !str.equalsIgnoreCase("m.zzx.cnklog.com")) {
            return false;
        }
        u.e = str;
        return true;
    }
}
