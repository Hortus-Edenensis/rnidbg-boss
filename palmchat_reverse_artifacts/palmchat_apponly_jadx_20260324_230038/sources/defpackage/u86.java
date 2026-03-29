package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.zm.fda.Z2500.Z0O00.ZZ00Z.O022Z;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class u86 {
    public static String a(String str) {
        Matcher matcher = Pattern.compile("Linux version (\\S+) \\((\\S+?)\\) (?:\\(gcc.+? \\)) (#\\d+) (?:.*?)?((Sun|Mon|Tue|Wed|Thu|Fri|Sat).+)").matcher(str);
        if (!matcher.matches()) {
            v.d("Regex did not match on /proc/version: " + str);
            return "Unavailable";
        }
        if (matcher.groupCount() < 4) {
            v.d("Regex match on /proc/version only returned " + matcher.groupCount() + " groups");
            return "Unavailable";
        }
        return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
    }

    public static zg b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zg zgVar = new zg();
            zgVar.b = applicationInfo.packageName;
            zgVar.c = applicationInfo.processName;
            CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
            zgVar.f22406a = charSequenceLoadLabel != null ? charSequenceLoadLabel.toString() : applicationInfo.packageName;
            if (TextUtils.equals(zgVar.b, context.getPackageName())) {
                zgVar.d = eo.a(context);
                zgVar.e = eo.b(context);
            } else {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                zgVar.e = packageInfo.versionName;
                zgVar.d = packageInfo.versionCode;
            }
            zgVar.h = packageManager.getInstallerPackageName(str);
            zgVar.f = (applicationInfo.flags & 1) != 0;
            return zgVar;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void c(Context context, av avVar) {
        avVar.f1575a = Build.DEVICE;
        avVar.j = Build.DISPLAY;
        avVar.k = Build.TYPE;
        avVar.b = Build.MODEL;
        avVar.c = Build.PRODUCT;
        avVar.f = Build.VERSION.SDK_INT;
        avVar.e = Build.VERSION.RELEASE;
        avVar.i = Build.VERSION.INCREMENTAL;
        avVar.d = Build.BOARD;
        avVar.l = Build.FINGERPRINT;
        avVar.h = d();
        avVar.g = er5.a("gsm.version.baseband", "unknown");
        avVar.n = Build.MANUFACTURER;
    }

    public static String d() {
        try {
            return a(f(O022Z.m));
        } catch (IOException e) {
            v.e("IO Exception when getting kernel version for Device Info screen", e);
            return "Unavailable";
        }
    }

    public static void e(Context context, du5 du5Var) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        du5Var.f17140a = telephonyManager.getPhoneType();
        du5Var.c = telephonyManager.getNetworkOperatorName();
        if (ContextCompat.checkSelfPermission(context, g.c) != 0) {
            return;
        }
        du5Var.b = telephonyManager.getNetworkType();
    }

    public static String f(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str), 256);
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }
}
