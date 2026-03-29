package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gw2 extends iv2 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile gw2 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17824a;
    public JSONObject b;
    public String c;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends yw2 {
        public Context c;

        @Override // defpackage.yw2
        public void a() {
            try {
                Context context = this.c;
                hw2.q(context, hw2.f(context));
            } catch (Throwable th) {
                p63.f("JDevice", "RegisterAction failed:" + th.getMessage());
            }
        }

        public b(Context context) {
            this.c = context;
            this.f22293a = "JDevice#RegisterAction";
        }
    }

    public static String t(Context context) {
        String packageName;
        PackageInfo packageInfo;
        String str = "";
        try {
            String strF = rv2.f(context);
            String strE = rv2.e(context);
            try {
                packageName = context.getPackageName();
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                } catch (Throwable th) {
                    th = th;
                    p63.f("JDevice", "getPackageManager failed:" + th.getMessage());
                    packageInfo = null;
                }
            } catch (Throwable th2) {
                th = th2;
                packageName = "";
            }
            String str2 = packageInfo == null ? "" : packageInfo.versionName;
            String strValueOf = packageInfo == null ? "" : String.valueOf(packageInfo.versionCode);
            String strR = rv2.r();
            String strValueOf2 = String.valueOf(rv2.t());
            StringBuilder sb = new StringBuilder();
            sb.append(strF);
            sb.append(",");
            if (TextUtils.isEmpty(strE)) {
                strE = "";
            }
            sb.append(strE);
            sb.append(",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(",");
            if (TextUtils.isEmpty(strValueOf)) {
                strValueOf = "";
            }
            sb.append(strValueOf);
            sb.append(",");
            if (TextUtils.isEmpty(strR)) {
                strR = "";
            }
            sb.append(strR);
            sb.append(",");
            if (TextUtils.isEmpty(strValueOf2)) {
                strValueOf2 = "";
            }
            sb.append(strValueOf2);
            sb.append(",");
            if (!TextUtils.isEmpty(packageName)) {
                str = packageName;
            }
            sb.append(str);
            return sb.toString();
        } catch (Throwable th3) {
            p63.f("JDevice", "getCurrentCondition throwable: " + th3.getMessage());
            return null;
        }
    }

    public static gw2 v() {
        if (d == null) {
            synchronized (gw2.class) {
                if (d == null) {
                    d = new gw2();
                }
            }
        }
        return d;
    }

    @Override // defpackage.iv2
    public void e(Context context, String str) {
        JSONObject jSONObjectU = u(context);
        this.b = jSONObjectU;
        if (jSONObjectU == null) {
            p63.f("JDevice", "collect failed");
            return;
        }
        p63.a("JDevice", "collect success:" + this.b);
    }

    @Override // defpackage.iv2
    public String i(Context context) {
        this.f17824a = context;
        return "JDevice";
    }

    @Override // defpackage.iv2
    public boolean p(Context context, String str) {
        if (!kv2.w(context, str)) {
            return false;
        }
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            p63.f("JDevice", "there are no data to report");
            return false;
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        this.c = rv2.I(string + t(context));
        String strJ = kv2.j(context);
        if (TextUtils.isEmpty(this.c) || TextUtils.equals(this.c, strJ)) {
            p63.a("JDevice", "device detail is not change");
            return false;
        }
        p63.a("JDevice", "device detail is change");
        return super.p(context, str);
    }

    @Override // defpackage.iv2
    public void r(Context context, String str) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            p63.a("JDevice", "there are no data to report");
            return;
        }
        rv2.b(context, jSONObject, "device_info");
        rv2.D(context, this.b, new zb1(context, this.c, str));
        this.b = null;
    }

    public void s(Context context) {
        rv2.F(new b(context));
    }

    public final JSONObject u(Context context) {
        String str;
        String str2;
        String str3;
        if (context == null) {
            p63.f("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            try {
                String strE = hw2.e();
                try {
                    String strI = hw2.i(context);
                    Locale locale = Locale.ENGLISH;
                    String str4 = String.format(locale, "%.1f", Double.valueOf(hw2.k(context)));
                    String str5 = String.format(locale, Build.VERSION.RELEASE, new Object[0]);
                    String str6 = String.format(locale, Build.MODEL, new Object[0]);
                    String str7 = String.format(locale, Build.BRAND, new Object[0]);
                    String str8 = String.format(locale, Build.PRODUCT, new Object[0]);
                    String str9 = String.format(locale, Build.FINGERPRINT, new Object[0]);
                    String string = context.getResources().getConfiguration().locale.toString();
                    String str10 = String.format(locale, lv2.b, new Object[0]);
                    long rawOffset = ((long) TimeZone.getDefault().getRawOffset()) / 3600000;
                    if (rawOffset > 0) {
                        str3 = "+" + rawOffset;
                    } else if (rawOffset < 0) {
                        str3 = "-" + rawOffset;
                    } else {
                        str3 = "" + rawOffset;
                    }
                    long jH = hw2.h(context);
                    String str11 = str3;
                    try {
                        long j = hw2.j(context);
                        str2 = "JDevice";
                        try {
                            int iC = hw2.c();
                            String strD = hw2.d();
                            int iB = hw2.b();
                            String strC = lw2.c(context);
                            String strD2 = rv2.d(context);
                            JSONArray jSONArrayL = hw2.l(context);
                            JSONObject jSONObject = new JSONObject();
                            if (TextUtils.isEmpty(strE)) {
                                strE = "";
                            }
                            jSONObject.put("cpu_info", strE);
                            jSONObject.put("cpu_count", iC);
                            jSONObject.put("cpu_max_freq", iB);
                            jSONObject.put("cpu_hardware", strD);
                            jSONObject.put("ram", jH);
                            jSONObject.put("rom", j);
                            if (TextUtils.isEmpty(strI)) {
                                strI = "";
                            }
                            jSONObject.put("resolution", strI);
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "";
                            }
                            jSONObject.put("screensize", str4);
                            if (TextUtils.isEmpty(str5)) {
                                str5 = "";
                            }
                            jSONObject.put("os_version", str5);
                            if (TextUtils.isEmpty(str6)) {
                                str6 = "";
                            }
                            jSONObject.put(WkParams.MODEL, str6);
                            if (TextUtils.isEmpty(str7)) {
                                str7 = "";
                            }
                            jSONObject.put("brand", str7);
                            if (TextUtils.isEmpty(str8)) {
                                str8 = "";
                            }
                            jSONObject.put("product", str8);
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, TextUtils.isEmpty(str9) ? "" : str9);
                            jSONObject.put("language", TextUtils.isEmpty(string) ? "" : string);
                            jSONObject.put("manufacturer", TextUtils.isEmpty(str10) ? "" : str10);
                            jSONObject.put(bt.M, TextUtils.isEmpty(str11) ? "" : str11);
                            String strG = ww2.g();
                            if (TextUtils.isEmpty(strG)) {
                                strG = "";
                            }
                            jSONObject.put("romversion", strG);
                            TextUtils.isEmpty("");
                            jSONObject.put("mac", "");
                            jSONObject.put("meid", TextUtils.isEmpty(strC) ? "" : strC);
                            jSONObject.put("sim_slots", jSONArrayL);
                            jSONObject.put("android_id", TextUtils.isEmpty(strD2) ? "" : strD2);
                            JSONObject jSONObjectA = gq2.a(context);
                            if (jSONObjectA != null) {
                                jSONObject.put(OapsKey.KEY_IDS, jSONObjectA);
                            }
                            return jSONObject;
                        } catch (JSONException e) {
                            e = e;
                            str = str2;
                            p63.f(str, "package json exception: " + e.getMessage());
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            p63.f(str2, "getDeviceInfo exception: " + th.getMessage());
                            return null;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        str2 = "JDevice";
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = "JDevice";
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str2 = "JDevice";
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "JDevice";
            }
        } catch (JSONException e4) {
            e = e4;
            str = "JDevice";
        }
    }

    public Object w(Context context) {
        return u(context);
    }
}
