package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ie7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f18154a;
    public static String b = "com." + e() + ".instant.platform";
    public static String c = "com." + e() + ".instant.platform.tv";

    public static String a() {
        return "1.4.0_22030b1_230523";
    }

    public static String b(Context context) {
        if (f(context)) {
            int iM = m(context);
            int iN = n(context);
            int iO = o(context);
            if (-1 != iM && -1 != iN && -1 != iO) {
                StringBuilder sb = new StringBuilder();
                sb.append(iN);
                sb.append("/");
                sb.append(iM);
                sb.append("/");
                sb.append(iO);
                try {
                    return URLEncoder.encode(sb.toString(), "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    return sb.toString();
                }
            }
        }
        return "-1";
    }

    public static boolean c(Context context, int i) {
        return m(context) >= i;
    }

    public static boolean d(Context context, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null) {
            String queryParameter = uri.getQueryParameter("min");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    int i = Integer.parseInt(queryParameter);
                    if (i >= 100) {
                        return c(context, i);
                    }
                    return false;
                } catch (NumberFormatException e) {
                    h87.d("VersionUtil", e);
                }
            }
        }
        return false;
    }

    public static String e() {
        return bw6.a("bmVhcm1l");
    }

    public static boolean f(Context context) {
        return !TextUtils.isEmpty(j(context));
    }

    public static boolean g(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("min")) {
            return true;
        }
        Uri uri = Uri.parse(str);
        return uri != null && (TextUtils.isEmpty(uri.getQueryParameter("min")) || d(context, str));
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(j(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            h87.d("VersionUtil", e);
            return -1;
        }
    }

    public static boolean i(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128) != null;
        } catch (Exception e) {
            h87.d("VersionUtil", e);
            return false;
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(f18154a)) {
            return f18154a;
        }
        f18154a = p(context);
        return f18154a;
    }

    public static int k(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(bt.ad)) != null && (obj instanceof Integer)) {
                return Integer.parseInt(String.valueOf(obj).substring(0, 4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String l(Context context) {
        int iK = k(context);
        int iN = n(context);
        int iO = o(context);
        if (-1 == iK || -1 == iN || -1 == iO) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(iN);
        sb.append("/");
        sb.append(iK);
        sb.append("/");
        sb.append(iO);
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return sb.toString();
        }
    }

    public static int m(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("platformVersion")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            h87.d("VersionUtil", e);
        }
        return -1;
    }

    public static int n(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(bt.ad)) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            h87.d("VersionUtil", e);
        }
        return -1;
    }

    public static int o(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("biz_version")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            h87.d("VersionUtil", e);
        }
        return -1;
    }

    public static String p(Context context) {
        return uv6.a() ? i(context, "com.oplus.instant.platform") ? "com.oplus.instant.platform" : i(context, b) ? b : "" : uv6.b() ? i(context, "com.oplus.instant.platform.tv") ? "com.oplus.instant.platform.tv" : i(context, c) ? c : "" : "";
    }
}
