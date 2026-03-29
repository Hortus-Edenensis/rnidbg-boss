package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class oi7 {
    public static final String[] c = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19781a;
    public JSONObject b = new JSONObject();

    public oi7(Context context) {
        this.f19781a = context;
    }

    public static oi7 i(Context context) {
        oi7 oi7Var = new oi7(context);
        JSONObject jSONObjectJ = oi7Var.j();
        oi7Var.m(jSONObjectJ);
        oi7Var.c(jSONObjectJ);
        oi7Var.a(jSONObjectJ);
        oi7Var.h(jSONObjectJ);
        oi7Var.d(jSONObjectJ);
        oi7Var.n(jSONObjectJ);
        oi7Var.g(jSONObjectJ);
        return oi7Var;
    }

    public final void a(JSONObject jSONObject) {
        try {
            String language = this.f19781a.getResources().getConfiguration().locale.getLanguage();
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

    public final String b() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    public final void c(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.f19781a.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    public final void d(JSONObject jSONObject) {
        try {
            jSONObject.put(bt.Q, pv6.c(this.f19781a));
        } catch (JSONException unused) {
        }
    }

    public final String e() {
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
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e) {
            mf7.a(e);
            return "unknown";
        }
    }

    public JSONObject f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.b.put("user_id", str);
            }
        } catch (JSONException unused) {
        }
        return this.b;
    }

    public final void g(JSONObject jSONObject) {
        Map<String, Object> mapC;
        Object obj;
        fl7 fl7VarJ = uh7.j();
        if (fl7VarJ == null || jSONObject == null || (mapC = fl7VarJ.c()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapC.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapC.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        } catch (Exception e) {
            mf7.a(e);
        }
    }

    public final void h(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (ad7.b()) {
                sb.append("MIUI-");
            } else if (ad7.a()) {
                sb.append("FLYME-");
            } else {
                String strE = ad7.e();
                if (ad7.f(strE)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strE)) {
                    sb.append(strE);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", mh7.m());
        } catch (Throwable unused) {
        }
    }

    public JSONObject j() {
        return this.b;
    }

    public JSONObject k(String str) {
        try {
            this.b.put("device_id", str);
        } catch (JSONException unused) {
        }
        return this.b;
    }

    public JSONObject l(@Nullable Map<String, Object> map) {
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
                    this.b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.b.put("udid", map.get("iid"));
            this.b.remove("iid");
        }
        return this.b;
    }

    @SuppressLint({"MissingPermission"})
    public final void m(JSONObject jSONObject) {
        int i;
        try {
            ApplicationInfo applicationInfo = this.f19781a.getPackageManager().getPackageInfo(this.f19781a.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null && (i = applicationInfo.labelRes) > 0) {
                jSONObject.put(bt.s, this.f19781a.getString(i));
            }
            jSONObject.put("sdk_version", 138);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.18-cloud");
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("os_version", b());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(bt.F, Build.BRAND);
            jSONObject.put(bt.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", e());
        } catch (Exception unused) {
        }
    }

    public final void n(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f19781a.getSystemService("phone");
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
        } catch (Exception unused) {
        }
    }
}
