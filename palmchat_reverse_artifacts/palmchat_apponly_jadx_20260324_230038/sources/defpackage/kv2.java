package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CommitPrefEdits"})
public class kv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f18835a;
    public static HashMap<String, Long> b;

    public static void A(Context context, long j) {
        p(context).edit().putLong("copy_time", j).apply();
    }

    public static void B(Context context, String str) {
        if (nl5.i(str)) {
            return;
        }
        String strG = g(context);
        if (strG != null && !strG.equals(str)) {
            p(context).edit().remove(strG).apply();
        }
        p(context).edit().putString("current_time_key", str).apply();
    }

    public static void C(Context context, String str) {
        p(context).edit().putString("JDeviceIds", str).apply();
    }

    public static void D(Context context, String str) {
        p63.d("JCommonConfig", "update deviceSession");
        p(context).edit().putString("JDevicesession", str).apply();
    }

    public static void E(Context context, String str) {
        if (!str.contains("JApp") || str.equals("JAppMovement")) {
            String strB = b(str, "_blt");
            long jCurrentTimeMillis = System.currentTimeMillis();
            p63.d("JCommonConfig", "update " + str + " lastBusinessTime");
            p(context).edit().putLong(strB, jCurrentTimeMillis).apply();
        }
    }

    public static void F(Context context, String str) {
        p63.d("JCommonConfig", "update " + str + " lastReportTime");
        p(context).edit().putLong(b(str, "_rlt"), System.currentTimeMillis()).apply();
    }

    public static void G(Context context, String str) {
        p(context).edit().putString("JWakeLocalState", str).apply();
    }

    public static void H(Context context, String str) {
        p(context).edit().putString("JNotificationState", str).apply();
    }

    public static void I(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        String strB = b(str, "_ri");
        p63.d("JCommonConfig", "update " + str + " reportInterval:" + j);
        p(context).edit().putLong(strB, j).apply();
    }

    public static void J(Context context, String str, String str2) {
        p(context).edit().putString(b("JType", str), str2).apply();
    }

    public static void K(Context context, String str, int i) {
        p(context).edit().putInt(b("JType", "ktsv_" + str), i).apply();
    }

    public static void L(Context context, boolean z) {
        p(context).edit().putBoolean(b("user_wake", "_aue"), z).apply();
    }

    public static void M(Context context) {
        String strG = g(context);
        p(context).edit().putInt(strG, p(context).getInt(strG, 0) + 1).apply();
    }

    public static void a(Context context) {
        p(context).edit().remove("copy_config").remove("copy_history").remove("copy_time").remove("copy_report_time").apply();
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static String c(Context context) {
        return p(context).getString("copy_config", "");
    }

    public static String d(Context context) {
        return p(context).getString("copy_history", "");
    }

    public static long e(Context context) {
        return p(context).getLong("copy_report_time", 0L);
    }

    public static long f(Context context) {
        return p(context).getLong("copy_time", 0L);
    }

    public static String g(Context context) {
        return p(context).getString("current_time_key", null);
    }

    public static long h(String str, String str2) {
        try {
            return b.get(b(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    public static String i(Context context) {
        return p(context).getString("JDeviceIds", "");
    }

    public static String j(Context context) {
        return p(context).getString("JDevicesession", "");
    }

    public static long k(Context context, String str) {
        return p(context).getLong(b(str, "_blt"), 0L);
    }

    public static long l(Context context, String str) {
        return p(context).getLong(b(str, "_rlt"), 0L);
    }

    public static String m(Context context) {
        return p(context).getString("JWakeLocalState", "");
    }

    public static String n(Context context) {
        return p(context).getString("JNotificationState", "");
    }

    public static long o(Context context, String str) {
        return p(context).getLong(b(str, "_ri"), h(str, "_ri"));
    }

    public static SharedPreferences p(Context context) {
        if (f18835a == null) {
            u(context);
        }
        return f18835a;
    }

    public static String q(Context context, String str) {
        return p(context).getString(b("JType", str), "-1,-1");
    }

    public static int r(Context context, String str) {
        return p(context).getInt(b("JType", "ktsv_" + str), 0);
    }

    public static boolean s(Context context) {
        return p(context).getBoolean(b("user_wake", "_aue"), true);
    }

    public static int t(Context context, String str) {
        if (nl5.i(str)) {
            return Integer.MAX_VALUE;
        }
        return p(context).getInt(str, 0);
    }

    public static void u(Context context) {
        f18835a = context.getSharedPreferences("cn.jiguang.common", 0);
        v();
    }

    public static void v() {
        HashMap<String, Long> map = new HashMap<>();
        b = map;
        map.put(b("JWakeConfigHelper", "_bi"), 3600000L);
        b.put(b("JDevice", "_ri"), 86400000L);
        b.put(b("JWakeReport", "_ri"), 3600000L);
        b.put(b("JDeviceIds", "_ri"), 86400000L);
    }

    public static boolean w(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jL = l(context, str);
        long jO = o(context, str);
        boolean z = jCurrentTimeMillis - jL > jO;
        p63.d("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + jCurrentTimeMillis + ",lastReportTime:" + jL + ",reportInterval:" + jO);
        return z;
    }

    public static void x(Context context, String str) {
        p(context).edit().putString("copy_config", str).apply();
    }

    public static void y(Context context, String str) {
        p(context).edit().putString("copy_history", str).apply();
    }

    public static void z(Context context, long j) {
        p(context).edit().putLong("copy_report_time", j).apply();
    }
}
