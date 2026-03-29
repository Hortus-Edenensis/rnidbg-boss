package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.x;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b07 {
    public static volatile b07 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1620a;
    public String b = "sdk-and-lite";
    public String c;

    public b07() {
        String strA = fu6.a();
        if (fu6.c()) {
            return;
        }
        this.b += '_' + strA;
    }

    public static String b(ru6 ru6Var, Context context, boolean z) {
        if (z) {
            return "00";
        }
        try {
            WifiInfo wifiInfoE = rz6.e(ru6Var, context);
            return wifiInfoE != null ? wifiInfoE.getBSSID() : "00";
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "lacking_per_2", th);
            return "00";
        }
    }

    public static String c(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static synchronized void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(j07.e().c()).edit().putString("trideskey", str).apply();
        hu6.b = str;
    }

    public static synchronized b07 e() {
        if (d == null) {
            d = new b07();
        }
        return d;
    }

    public static String f(ru6 ru6Var, Context context, boolean z) {
        if (z) {
            return "-1";
        }
        try {
            WifiInfo wifiInfoE = rz6.e(ru6Var, context);
            return wifiInfoE != null ? wifiInfoE.getSSID() : "-1";
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "lacking_per_1", th);
            return "-1";
        }
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(x.aQ);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String i() {
        return "-1;-1";
    }

    public static String j() {
        return "1";
    }

    public static String k() {
        Context contextC = j07.e().c();
        SharedPreferences sharedPreferences = contextC.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imei", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strH = TextUtils.isEmpty(su6.a(contextC).g()) ? h() : l37.a(contextC).b();
        sharedPreferences.edit().putString("virtual_imei", strH).apply();
        return strH;
    }

    public static String l() {
        String strC;
        Context contextC = j07.e().c();
        SharedPreferences sharedPreferences = contextC.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imsi", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(su6.a(contextC).g())) {
            String strD = j07.e().d();
            strC = (TextUtils.isEmpty(strD) || strD.length() < 18) ? h() : strD.substring(3, 18);
        } else {
            strC = l37.a(contextC).c();
        }
        String str = strC;
        sharedPreferences.edit().putString("virtual_imsi", str).apply();
        return str;
    }

    public String a(ru6 ru6Var, su6 su6Var, boolean z) {
        Context contextC = j07.e().c();
        l37 l37VarA = l37.a(contextC);
        if (TextUtils.isEmpty(this.f1620a)) {
            this.f1620a = "Msp/15.8.10 (" + qh7.S() + x.aQ + qh7.P() + x.aQ + qh7.I(contextC) + x.aQ + qh7.R(contextC) + x.aQ + qh7.T(contextC) + x.aQ + c(contextC);
        }
        String strB = l37.e(contextC).b();
        String strC = qh7.C(contextC);
        String strJ = j();
        String strC2 = l37VarA.c();
        String strB2 = l37VarA.b();
        String strL = l();
        String strK = k();
        if (su6Var != null) {
            this.c = su6Var.f();
        }
        String strReplace = Build.MANUFACTURER.replace(x.aQ, " ");
        String strReplace2 = Build.MODEL.replace(x.aQ, " ");
        boolean zF = j07.f();
        String strF = l37VarA.f();
        String strF2 = f(ru6Var, contextC, z);
        String strB3 = b(ru6Var, contextC, z);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1620a);
        sb.append(x.aQ);
        sb.append(strB);
        sb.append(x.aQ);
        sb.append(strC);
        sb.append(x.aQ);
        sb.append(strJ);
        sb.append(x.aQ);
        sb.append(strC2);
        sb.append(x.aQ);
        sb.append(strB2);
        sb.append(x.aQ);
        sb.append(this.c);
        sb.append(x.aQ);
        sb.append(strReplace);
        sb.append(x.aQ);
        sb.append(strReplace2);
        sb.append(x.aQ);
        sb.append(zF);
        sb.append(x.aQ);
        sb.append(strF);
        sb.append(x.aQ);
        sb.append(i());
        sb.append(x.aQ);
        sb.append(this.b);
        sb.append(x.aQ);
        sb.append(strL);
        sb.append(x.aQ);
        sb.append(strK);
        sb.append(x.aQ);
        sb.append(strF2);
        sb.append(x.aQ);
        sb.append(strB3);
        if (su6Var != null) {
            String strB4 = rz6.b(ru6Var, contextC, su6.a(contextC).g(), rz6.d(ru6Var, contextC));
            if (!TextUtils.isEmpty(strB4)) {
                sb.append(";;;");
                sb.append(strB4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
