package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {
    private static String C;
    public static String F;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static String o;
    private static String t;
    private static String u;
    public static Context x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comjni.util.a f4014a = new com.baidu.mapsdkplatform.comjni.util.a();
    private static String b = com.huawei.hms.ads.dynamic.a.t;
    private static String p = "baidu";
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String v = "-1";
    private static String w = "-1";
    public static float y = 1.0f;
    private static String z = "";
    private static Map<String, String> A = new HashMap();
    private static String B = "";
    private static boolean D = false;
    private static boolean E = false;

    public static void a(boolean z2) {
        Context context = x;
        if (context == null) {
            return;
        }
        MH.setAppStatus(context, z2);
    }

    public static void b(boolean z2) {
        if (E == z2) {
            return;
        }
        E = z2;
        Context context = x;
        if (context == null) {
            return;
        }
        MH.setAgreePolicy(context, z2);
        if (!D && z2) {
            p();
            D = true;
        }
        v();
    }

    private static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String apiVersion = VersionInfo.getApiVersion();
            h = apiVersion;
            if (apiVersion != null && !apiVersion.equals("")) {
                h = h.replace('_', '.');
            }
            i = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            h = "1.0.0";
            i = 1;
        }
    }

    private static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            j = defaultDisplay.getWidth();
            k = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        y = displayMetrics.density;
        l = (int) displayMetrics.xdpi;
        m = (int) displayMetrics.ydpi;
        int i2 = displayMetrics.densityDpi;
        n = i2;
        if (i2 == 0) {
            n = 160;
        }
    }

    public static void e(Context context) {
        x = context;
    }

    public static String f() {
        return o;
    }

    public static String g() {
        return c;
    }

    public static String h() {
        if (A == null) {
            return null;
        }
        if (TextUtils.isEmpty(z)) {
            A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(c()));
        }
        A.put(bt.af, o());
        Date date = new Date();
        long time = date.getTime() + ((long) (date.getSeconds() * 1000));
        A.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf((time / 1000) + ((time % 1000) / 1000.0d)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : A.entrySet()) {
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static String i() {
        return B;
    }

    public static String j() {
        return e;
    }

    public static String k() {
        return d;
    }

    public static int l() {
        return j;
    }

    public static int m() {
        return k;
    }

    public static String n() {
        return h;
    }

    private static String o() {
        String strGzfi;
        Context context = x;
        if (context == null || (strGzfi = MH.gzfi(context, null, 3041, null, null)) == null || strGzfi.length() <= 0) {
            return "";
        }
        if (!strGzfi.equals(C)) {
            C = strGzfi;
            SysUpdateObservable.getInstance().updateZid(C);
        }
        return strGzfi;
    }

    private static boolean p() {
        if (x == null) {
            return false;
        }
        HashMap map = new HashMap();
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.arrayValue();
        byte[] bArrA = a(x);
        if (bArrA != null) {
            for (byte b2 : bArrA) {
                jsonBuilder.value((int) b2);
            }
        }
        jsonBuilder.endArrayValue();
        map.put(EngineImpl.KEY_CUID, z);
        map.put("p", x.getPackageName());
        map.put("s", jsonBuilder.getJson());
        map.put("arv", f);
        map.put("arl", g);
        map.put("mod", d);
        map.put("ws", o);
        if (Initializer.getCommonInfo() != null) {
            map.put("oid", Initializer.getCommonInfo().getOAID());
        }
        MH.init(x, map);
        return true;
    }

    private static void q() {
        o = "0";
    }

    public static String r() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue(bt.w, q);
        jsonBuilder.putStringValue("resid", b);
        jsonBuilder.putStringValue("channel", p);
        jsonBuilder.putStringValue("glr", r);
        jsonBuilder.putStringValue("glv", s);
        jsonBuilder.putStringValue("mb", k());
        jsonBuilder.putStringValue("sv", n());
        jsonBuilder.putStringValue("os", j());
        jsonBuilder.key("dpi_x").value(d());
        jsonBuilder.key("dpi_y").value(d());
        jsonBuilder.putStringValue(TKDownloadReason.KSAD_TK_NET, o);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, z);
        jsonBuilder.putStringValue(bt.af, o());
        if (x == null) {
            x = JNIInitializer.getCachedContext();
        }
        Context context = x;
        if (context != null) {
            jsonBuilder.putStringValue(t.r, context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(l());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.endObject();
        String json = jsonBuilder.getJson();
        B = json;
        return json;
    }

    public static void s() {
        com.baidu.mapsdkplatform.comjni.util.a aVar = f4014a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void t() {
        F = null;
    }

    public static void u() {
        s();
    }

    public static void v() {
        A.put(TKDownloadReason.KSAD_TK_NET, AppMD5.encodeUrlParamsValue(f()));
        A.put("appid", AppMD5.encodeUrlParamsValue(v));
        A.put("bduid", "");
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        if (Initializer.isAgreePrivacyMode()) {
            e = AnalyticsConstants.SDK_TYPE + Build.VERSION.SDK;
            f = Build.VERSION.RELEASE;
            d = Build.MODEL;
            g = String.valueOf(Build.VERSION.SDK_INT);
        } else {
            e = AnalyticsConstants.SDK_TYPE;
            f = "";
            d = "";
            g = "";
        }
        HashMap map = new HashMap();
        map.put("arv", f);
        map.put("arl", g);
        map.put("mod", d);
        map.put("ws", o);
        if (D) {
            a((HashMap<String, String>) map);
        }
        jsonBuilder.putStringValue(bt.w, q);
        jsonBuilder.putStringValue("resid", b);
        jsonBuilder.putStringValue("channel", p);
        jsonBuilder.putStringValue("glr", r);
        jsonBuilder.putStringValue("glv", s);
        jsonBuilder.putStringValue("mb", k());
        jsonBuilder.putStringValue("sv", n());
        jsonBuilder.putStringValue("os", j());
        jsonBuilder.key("dpi_x").value(d());
        jsonBuilder.key("dpi_y").value(d());
        jsonBuilder.putStringValue(TKDownloadReason.KSAD_TK_NET, o);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, z);
        Context context = x;
        if (context != null) {
            jsonBuilder.putStringValue(t.r, context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(l());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.putStringValue("appid", v);
        jsonBuilder.putStringValue("duid", w);
        jsonBuilder.putStringValue(bt.af, o());
        if (!TextUtils.isEmpty(F)) {
            jsonBuilder.putStringValue("token", F);
        }
        jsonBuilder.endObject();
        SysUpdateObservable.getInstance().updatePhoneInfo(jsonBuilder.getJson());
    }

    public static String e() {
        return t;
    }

    public static String a() {
        return F;
    }

    public static byte[] a(Context context) {
        Signature[] apkContentsSigners;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                apkContentsSigners = signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getSigningCertificateHistory();
            } else {
                apkContentsSigners = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            }
            if (apkContentsSigners != null && apkContentsSigners.length > 0) {
                return apkContentsSigners[0].toByteArray();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static void b(Context context) {
        x = context;
        if (context.getFilesDir() != null) {
            t = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            u = context.getCacheDir().getAbsolutePath();
        }
        MH.setAgreePolicy(x, E);
        if (Initializer.isAgreePrivacyMode()) {
            e = AnalyticsConstants.SDK_TYPE + Build.VERSION.SDK;
            f = Build.VERSION.RELEASE;
            d = Build.MODEL;
            g = String.valueOf(Build.VERSION.SDK_INT);
            if (!D) {
                p();
                D = true;
            }
        } else {
            e = AnalyticsConstants.SDK_TYPE;
            f = "";
            d = "";
            g = "";
        }
        c = context.getPackageName();
        c(context);
        d(context);
        q();
        A.put(bt.af, o());
        A.put("resid", AppMD5.encodeUrlParamsValue(b));
        A.put("channel", AppMD5.encodeUrlParamsValue(b()));
        A.put("mb", AppMD5.encodeUrlParamsValue(k()));
        A.put("sv", AppMD5.encodeUrlParamsValue(n()));
        A.put("os", AppMD5.encodeUrlParamsValue(j()));
        A.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(d()), Integer.valueOf(d()))));
        if (!TextUtils.isEmpty(z)) {
            A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(z));
        }
        Context context2 = x;
        if (context2 != null) {
            A.put(t.r, AppMD5.encodeUrlParamsValue(context2.getPackageName()));
        }
        A.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(m()))));
        com.baidu.mapsdkplatform.comjni.util.a aVar = f4014a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static String c() {
        String cuid;
        try {
            cuid = LBSAuthManager.getInstance(x).getCUID();
            if (!TextUtils.isEmpty(cuid) && !cuid.equals(z)) {
                z = cuid;
                if (A != null) {
                    A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(c()));
                }
                SysUpdateObservable.getInstance().updateCuid(z);
                HashMap map = new HashMap();
                map.put(EngineImpl.KEY_CUID, z);
                MH.ud(x, map);
            }
        } catch (Exception unused) {
            cuid = "";
        }
        return cuid == null ? "" : cuid;
    }

    public static int d() {
        return n;
    }

    private static boolean a(HashMap<String, String> map) {
        Context context = x;
        if (context == null) {
            return false;
        }
        MH.ud(context, map);
        return true;
    }

    public static void a(String str) {
        o = str;
        v();
    }

    public static void a(String str, String str2) {
        v = str2;
        w = str;
        v();
    }

    public static String b() {
        return p;
    }
}
