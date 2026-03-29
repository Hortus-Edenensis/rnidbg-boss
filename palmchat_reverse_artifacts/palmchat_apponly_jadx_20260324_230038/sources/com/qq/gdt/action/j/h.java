package com.qq.gdt.action.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.qq.gdt.action.e.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10531a;
    private static String b;
    private static final Map<String, Integer> c = new HashMap<String, Integer>() { // from class: com.qq.gdt.action.j.h.1
        {
            put("46000", 1);
            put("46002", 1);
            put("46007", 1);
            put("46008", 1);
            put("46001", 2);
            put("46006", 2);
            put("46009", 2);
            put("46003", 3);
            put("46005", 3);
            put("46011", 3);
        }
    };

    public static String a() {
        String strB = b();
        return v.a(strB) ? strB : u.a(strB.toLowerCase());
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String c() {
        if (v.a(f10531a)) {
            try {
                String line = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (line.contains("x86")) {
                    f10531a = "x86";
                } else if (line.contains("x86_64")) {
                    f10531a = "x86_64";
                } else if (line.contains("armeabi-v7a")) {
                    f10531a = "armeabi-v7a";
                } else {
                    f10531a = line.contains("arm64-v8a") ? "arm64-v8a" : "armeabi";
                }
            } catch (Exception unused) {
            }
        }
        return f10531a;
    }

    public static d.b d(Context context) {
        return com.qq.gdt.action.e.d.b(context);
    }

    public static d.a e(Context context) {
        return com.qq.gdt.action.e.d.a(context, false);
    }

    public static String f() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError | Exception unused) {
            return "";
        }
    }

    public static JSONArray g(Context context) {
        Set<String> setY;
        JSONArray jSONArray = new JSONArray();
        try {
            setY = com.qq.gdt.action.b.a(context).y();
        } catch (Throwable unused) {
            o.a("get firstInstallTime error", new Object[0]);
        }
        if (setY != null && !setY.isEmpty()) {
            PackageManager packageManager = context.getPackageManager();
            for (String str : setY) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("package_name", str);
                    jSONObject.putOpt("install_time", Long.valueOf(packageInfo.firstInstallTime));
                    jSONArray.put(jSONObject);
                } catch (PackageManager.NameNotFoundException unused2) {
                    o.a(v.a("package %s not exist", str), new Object[0]);
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        try {
            if (!v.a(b)) {
                return b;
            }
            Context contextG = com.qq.gdt.action.d.a().g();
            com.qq.gdt.action.d.a();
            String strB = com.qq.gdt.action.e.b.b(contextG, com.qq.gdt.action.d.w());
            b = strB;
            return strB;
        } catch (Throwable th) {
            o.a("getImei e " + th, new Object[0]);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        try {
            return com.qq.gdt.action.d.a().g().getPackageName();
        } catch (Throwable th) {
            o.a("Get package name encountered exception: " + th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static Integer e() {
        try {
            String strA = com.qq.gdt.action.e.g.a();
            if (v.a(strA)) {
                return 0;
            }
            for (Map.Entry<String, Integer> entry : c.entrySet()) {
                if (strA.startsWith(entry.getKey())) {
                    return entry.getValue();
                }
            }
        } catch (Throwable th) {
            o.a("Get carrier encounter exception: " + th.getMessage(), new Object[0]);
        }
        return 0;
    }

    public static void f(Context context) {
        com.qq.gdt.action.e.d.a(context);
    }
}
