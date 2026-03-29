package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class x17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Application, String> f21858a = new HashMap();

    public static /* synthetic */ String c() {
        return "AppCode not set. please read the document of OplusTrack SDK.";
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            n87.a("ApkInfoUtil", new kz6(e));
            return "0";
        }
    }

    public static /* synthetic */ String e(PackageInfo packageInfo) {
        return "versionName=" + packageInfo.versionName;
    }

    public static void f(Context context, String str) {
        f21858a.put((Application) context.getApplicationContext(), str);
    }

    public static String g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            n87.a("ApkInfoUtil", new kz6(e));
            return "0";
        }
    }

    public static String h(Context context) {
        String str = "0";
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return "0";
            }
            String str2 = packageInfo.versionName;
            if (str2 == null) {
                return "0";
            }
            try {
                n87.d("ApkInfoUtil", new la7() { // from class: ez6
                    @Override // defpackage.la7
                    public final Object get() {
                        return x17.e(packageInfo);
                    }
                });
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        n87.a("ApkInfoUtil", new kz6(e));
        return str;
    }

    @Nullable
    public static String i(Context context) {
        Application application = (Application) context.getApplicationContext();
        Map<Application, String> map = f21858a;
        String str = map.get(application);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(context.getPackageManager().getApplicationInfo(d(context), 128).metaData.get("AppCode"));
            if (TextUtils.isEmpty(strValueOf)) {
                n87.a("ApkInfoUtil", new la7() { // from class: az6
                    @Override // defpackage.la7
                    public final Object get() {
                        return x17.c();
                    }
                });
            } else {
                map.put(application, strValueOf);
            }
        } catch (Exception e) {
            n87.a("ApkInfoUtil", new kz6(e));
            e.printStackTrace();
        }
        return strValueOf;
    }
}
