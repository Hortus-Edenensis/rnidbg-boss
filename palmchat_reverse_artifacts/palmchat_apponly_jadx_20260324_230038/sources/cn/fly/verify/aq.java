package cn.fly.verify;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gb f2073a;
    private static gb b;

    static {
        try {
            gb gbVar = new gb(ax.g());
            f2073a = gbVar;
            gbVar.a("FlyVerify_SPDB_V2", 1);
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        return f2073a.a("udd");
    }

    public static HashMap b() {
        Object objD = f2073a.d("key_config");
        if (objD != null) {
            return (HashMap) objD;
        }
        return null;
    }

    public static void c(int i) {
        f2073a.a("key_cache_type", Integer.valueOf(i));
    }

    public static int d() {
        return f2073a.b("logSwitch", 1);
    }

    public static String e() {
        String strA = u().a("cache_log");
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static void f(int i) {
        f2073a.a("cuSwitchData", Integer.valueOf(i));
    }

    public static String g() {
        String strA = f2073a.a("key_dnc");
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static long h() {
        return f2073a.a("key_config_expire_time", 0L);
    }

    public static void i(int i) {
        f2073a.a("slotsEnable", Integer.valueOf(i));
    }

    public static void j(int i) {
        f2073a.a("operatorCode", Integer.valueOf(i));
    }

    public static int k() {
        return f2073a.c("key_cache_type");
    }

    public static int l() {
        return f2073a.b("auto_refresh", 1);
    }

    public static int m() {
        return f2073a.b("cmSwitchData", 1);
    }

    public static int n() {
        return f2073a.b("cuSwitchData", 1);
    }

    public static int o() {
        return f2073a.b("subIdEnable", 1);
    }

    public static int p() {
        return f2073a.b("subIdsEnable", 1);
    }

    public static int q() {
        return f2073a.b("slotsEnable", 1);
    }

    public static String r() {
        return f2073a.b("factoryBlst", (String) null);
    }

    public static int s() {
        return f2073a.b("operatorCode", 0);
    }

    public static int t() {
        return f2073a.b("ignoreSwitchError", 1);
    }

    private static gb u() {
        if (b == null) {
            gb gbVar = new gb(ax.g());
            b = gbVar;
            gbVar.a("FlyVerify_LOG", 1);
        }
        return b;
    }

    public static void a(int i) {
        f2073a.a("logSwitch", Integer.valueOf(i));
    }

    public static void b(int i) {
        f2073a.a("key_oppo_net", Integer.valueOf(i));
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f2073a.a("key_dnc", str);
    }

    public static void d(int i) {
        f2073a.a("auto_refresh", Integer.valueOf(i));
    }

    public static void e(int i) {
        f2073a.a("cmSwitchData", Integer.valueOf(i));
    }

    public static boolean f() {
        try {
            File file = new File(ax.g().getFilesDir() + "/Pers/FlyVerify_LOG_1");
            if (!file.exists() || file.length() <= 209715200) {
                return false;
            }
            return file.delete();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void g(int i) {
        f2073a.a("subIdEnable", Integer.valueOf(i));
    }

    public static void h(int i) {
        f2073a.a("subIdsEnable", Integer.valueOf(i));
    }

    public static boolean i() {
        return f2073a.a("key_preverify_success", false);
    }

    public static boolean j() {
        return f2073a.b("key_use_wo");
    }

    public static void k(int i) {
        f2073a.a("switchTimeout", Integer.valueOf(i));
    }

    public static void l(int i) {
        f2073a.a("ignoreSwitchError", Integer.valueOf(i));
    }

    public static void a(long j) {
        f2073a.a("key_config_expire_time", Long.valueOf(j));
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            u().e("cache_log");
        } else {
            u().a("cache_log", str);
        }
    }

    public static void c(boolean z) {
        f2073a.a("key_auto_pre", Boolean.valueOf(z));
    }

    public static void d(String str) {
        f2073a.a("factoryBlst", str);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            f2073a.e("udd");
        } else {
            f2073a.a("udd", str);
        }
    }

    public static void b(boolean z) {
        f2073a.a("key_use_wo", Boolean.valueOf(z));
    }

    public static boolean c() {
        return f2073a.a("unknown_try", false);
    }

    public static void a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            f2073a.e("key_noup");
        } else {
            f2073a.a("key_noup", arrayList);
        }
    }

    public static void a(HashMap map) {
        if (map == null) {
            f2073a.e("key_config");
        } else {
            f2073a.a("key_config", map);
        }
    }

    public static void a(boolean z) {
        f2073a.a("unknown_try", Boolean.valueOf(z));
    }
}
