package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.lantern.auth.server.WkParams;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class q37 {
    public static final String[] c = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    public static String d = null;
    public static int e = -1;
    public static int f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20174a;
    public JSONObject b = new JSONObject();

    public q37(Context context) {
        this.f20174a = context;
    }

    public static q37 a(Context context) {
        q37 q37Var = new q37(context);
        q37Var.t(q37Var.s());
        return q37Var;
    }

    public static q37 b(Context context, long j) {
        q37 q37VarA;
        xi7 xi7VarD = xi7.d();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject jSONObjectC = xi7VarD.c(j);
        if (jSONObjectC == null || jSONObjectC.length() == 0) {
            q37VarA = a(x97.m());
            q37VarA.m();
            try {
                q37VarA.s().put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            q37VarA = new q37(x97.m());
        }
        h(q37VarA);
        q37VarA.l(jSONObjectC);
        return q37VarA;
    }

    public static q37 c(q37 q37Var) {
        e(q37Var.s());
        return q37Var;
    }

    public static void e(JSONObject jSONObject) {
        y(jSONObject);
        z(jSONObject);
    }

    public static boolean f() {
        if (e == -1) {
            e = u().contains("64") ? 1 : 0;
        }
        return e == 1;
    }

    public static q37 g(Context context) {
        q37 q37VarA = a(context);
        c(q37VarA);
        h(q37VarA);
        q37VarA.m();
        q37VarA.o();
        q37VarA.q();
        return q37VarA;
    }

    public static void h(q37 q37Var) {
        if (q37Var == null) {
            return;
        }
        i(q37Var.s());
    }

    public static void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        x(jSONObject);
        v(jSONObject);
        w(jSONObject);
        try {
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("device_id", x97.h().a());
            jSONObject.put("os_version", k());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str = Build.MODEL;
            String str2 = Build.BRAND;
            if (str == null) {
                str = str2;
            } else if (str2 != null && !str.contains(str2)) {
                str = str2 + ' ' + str;
            }
            jSONObject.put("device_model", str);
            jSONObject.put(bt.F, str2);
            jSONObject.put(bt.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", u());
            Context contextM = x97.m();
            String packageName = contextM.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = contextM.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i = applicationInfo.labelRes;
                jSONObject.put(bt.s, i > 0 ? contextM.getString(i) : contextM.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean j() {
        if (f == -1) {
            f = u().contains(WkParams.COUNTCODE) ? 1 : 0;
        }
        return f == 1;
    }

    public static String k() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    public static boolean n(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean p(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0 || (jSONObject.opt("app_version") == null && jSONObject.opt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME) == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean r(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String strOptString = jSONObject.optString("aid");
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            try {
                return Integer.parseInt(strOptString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static String u() {
        if (d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i >= strArr.length) {
                            break;
                        }
                        sb.append(strArr[i]);
                        if (i != strArr.length - 1) {
                            sb.append(", ");
                        }
                        i++;
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    d = "unknown";
                }
                d = sb.toString();
            } catch (Exception e2) {
                kj7.g(e2);
                d = "unknown";
            }
        }
        return d;
    }

    public static void v(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = x97.m().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    public static void w(JSONObject jSONObject) {
        try {
            String language = x97.m().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put(bt.M, rawOffset);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0005, B:6:0x000d, B:16:0x0035, B:18:0x0040, B:19:0x0049, B:7:0x0011, B:10:0x001a, B:12:0x0024, B:13:0x0029, B:15:0x002f), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void x(JSONObject jSONObject) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if (i77.f()) {
                str = "MIUI-";
            } else {
                if (!i77.h()) {
                    String strA = i77.a();
                    if (i77.b(strA)) {
                        sb.append("EMUI-");
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        sb.append(strA);
                        str = "-";
                    }
                    sb.append(Build.VERSION.INCREMENTAL);
                    if (sb.length() > 0) {
                        jSONObject.put("rom", sb.toString());
                    }
                    jSONObject.put("rom_version", gk7.a());
                }
                str = "FLYME-";
            }
            sb.append(str);
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
            }
            jSONObject.put("rom_version", gk7.a());
        } catch (Throwable unused) {
        }
    }

    public static void y(JSONObject jSONObject) {
        try {
            jSONObject.put(bt.Q, yi7.a(x97.m()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void z(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) x97.m().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(bt.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject d(Map<String, Object> map) {
        try {
            if (map == null) {
                return this.b;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.b.has(entry.getKey())) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : c) {
                if (map.containsKey(str)) {
                    try {
                        this.b.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                    } catch (Throwable unused) {
                        this.b.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                try {
                    this.b.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
                } catch (Throwable unused2) {
                }
            }
            if (map.containsKey("iid")) {
                this.b.put("udid", map.get("iid"));
                this.b.remove("iid");
            }
            if (map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
                this.b.put("app_version", map.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                this.b.remove(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            }
        } catch (Throwable unused3) {
        }
        return this.b;
    }

    public JSONObject l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.b;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                this.b.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.b;
    }

    public JSONObject m() {
        return d(x97.a().b());
    }

    public JSONObject o() {
        try {
            this.b.put("device_id", x97.h().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.b;
    }

    public JSONObject q() {
        try {
            long jH = x97.a().h();
            if (jH > 0) {
                this.b.put("user_id", jH);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.b;
    }

    public JSONObject s() {
        return this.b;
    }

    @SuppressLint({"MissingPermission"})
    public final void t(JSONObject jSONObject) {
        try {
            jSONObject.put("sdk_version", 153);
            jSONObject.put("sdk_version_name", "0.0.1-rc.3");
        } catch (Exception unused) {
        }
    }
}
