package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19138a = "";
    public static String b;
    public static Boolean c;
    public static Pair<String, Integer> d;
    public static final ArrayList<String> e;
    public static final ArrayList<String> f;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        e = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f = arrayList2;
        arrayList.add(g.f7481a);
        arrayList.add(g.b);
        arrayList2.add("android.permission.WAKE_LOCK");
        arrayList2.add("android.permission.VIBRATE");
        arrayList2.add("android.permission.CHANGE_WIFI_STATE");
        arrayList2.add(g.j);
    }

    public static boolean a(Context context) {
        String strD = d(context);
        if (TextUtils.isEmpty(strD)) {
            k63.e("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            ad.C(context, " 未在manifest中配置AppKey", -1);
            return false;
        }
        if (strD.length() == 24) {
            return true;
        }
        k63.e("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + strD + ", Please get your Appkey from JIGUANG web console!");
        ad.C(context, " AppKey:" + strD + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
        return false;
    }

    public static boolean b(Context context) {
        c(context);
        if (gv2.a().g() || gv2.a().e()) {
            String str = context.getPackageName() + wv2.f21809a;
            if (!ad.t(context, str)) {
                k63.e("CheckManifestHelper", "The permission should be defined - " + str);
                return false;
            }
            e.add(str);
        }
        for (String str2 : e) {
            if (!ad.s(context, str2)) {
                k63.e("CheckManifestHelper", "The permissoin is required - " + str2);
                return false;
            }
        }
        for (String str3 : f) {
            if (!ad.t(context, str3)) {
                k63.l("CheckManifestHelper", "We recommend you add the permission - " + str3);
            }
        }
        return true;
    }

    public static String c(Context context) {
        Bundle bundle;
        if (b == null && context != null) {
            try {
                String strI = fv2.i(context);
                b = strI;
                if (strI != null) {
                    k63.b("CheckManifestHelper", "get option channel - " + b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String strE = e(bundle, "JPUSH_CHANNEL");
                        b = strE;
                        if (!TextUtils.isEmpty(strE)) {
                            b = nl5.b(b);
                        }
                    }
                    k63.b("CheckManifestHelper", "manifest:channel - " + b);
                }
            } catch (Throwable unused) {
            }
        }
        return b;
    }

    public static String d(Context context) {
        try {
            if (c == null && !TextUtils.isEmpty(tv2.f21077a)) {
                return tv2.f21077a;
            }
        } catch (Throwable unused) {
            c = Boolean.FALSE;
        }
        g(context);
        return f19138a;
    }

    public static String e(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static Pair<String, Integer> f(Context context) {
        if (d == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String strSubstring = packageInfo.versionName;
                if (strSubstring != null && strSubstring.length() > 30) {
                    strSubstring = strSubstring.substring(0, 30);
                }
                d = new Pair<>(strSubstring, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable unused) {
                k63.b("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return d;
    }

    public static String g(Context context) {
        Bundle bundle;
        if (!TextUtils.isEmpty(f19138a)) {
            return f19138a;
        }
        if (TextUtils.isEmpty(f19138a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String strE = e(bundle, "JPUSH_APPKEY");
                        f19138a = strE;
                        if (!TextUtils.isEmpty(strE)) {
                            f19138a = f19138a.toLowerCase(Locale.getDefault());
                        }
                    }
                } else {
                    k63.a("CheckManifestHelper", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f19138a;
    }

    public static void h(Context context, String str) {
        b = str;
        lg5.h(context, zz2.E().a0(str));
        c(context);
    }
}
