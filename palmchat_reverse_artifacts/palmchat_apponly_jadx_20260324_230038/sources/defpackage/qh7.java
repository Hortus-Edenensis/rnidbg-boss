package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.app.EnvUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import com.zm.fda.Z2500.Z0O00.ZZ00Z.O022Z;
import defpackage.vt6;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class qh7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f20251a = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20252a;

        public a(Activity activity) {
            this.f20252a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20252a.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20253a;
        public final /* synthetic */ ConditionVariable b;

        public b(Runnable runnable, ConditionVariable conditionVariable) {
            this.f20253a = runnable;
            this.b = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f20253a.run();
            } finally {
                this.b.open();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f20254a;
        public final int b;
        public final String c;

        public c(PackageInfo packageInfo, int i, String str) {
            this.f20254a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a() {
            return this.f20254a.versionCode < this.b;
        }

        public boolean b(ru6 ru6Var) {
            Signature[] signatureArr = this.f20254a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String strJ = qh7.j(ru6Var, signature.toByteArray());
                if (strJ != null && !TextUtils.equals(strJ, this.c)) {
                    xt6.g(ru6Var, "biz", "PublicKeyUnmatch", String.format("Got %s, expected %s", strJ, this.c));
                    return true;
                }
            }
            return false;
        }
    }

    public static int A(int i) {
        return i / 100000;
    }

    public static String B() {
        if (EnvUtils.a()) {
            return "com.eg.android.AlipayGphoneRC";
        }
        try {
            return fu6.d.get(0).f21529a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    public static String C(Context context) {
        return "-1;-1";
    }

    public static String D(String str, String str2) {
        String string = Settings.Secure.getString(((Application) j07.e().c()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static Map<String, String> E(ru6 ru6Var, String str) {
        HashMap map = new HashMap(4);
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str.length() - 1) {
            for (String str2 : str.substring(iIndexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                int iIndexOf2 = str2.indexOf(61, 1);
                if (iIndexOf2 != -1 && iIndexOf2 < str2.length() - 1) {
                    map.put(str2.substring(0, iIndexOf2), Q(ru6Var, str2.substring(iIndexOf2 + 1)));
                }
            }
        }
        return map;
    }

    public static Map<String, String> F(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int iIndexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER, 1);
            if (-1 != iIndexOf) {
                map.put(str2.substring(0, iIndexOf), URLDecoder.decode(str2.substring(iIndexOf + 1)));
            }
        }
        return map;
    }

    public static boolean G(ru6 ru6Var) {
        if (ru6Var == null || TextUtils.isEmpty(ru6Var.g)) {
            return false;
        }
        return ru6Var.g.toLowerCase().contains("auth");
    }

    public static String H(ru6 ru6Var, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e) {
            xt6.g(ru6Var, "biz", "rflex", e.getClass().getSimpleName());
            return null;
        }
    }

    public static String I(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String J(String str) {
        return (EnvUtils.a() && TextUtils.equals(str, "com.eg.android.AlipayGphoneRC")) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static int K(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(b[i]))) {
                return i;
            }
        }
        return 0;
    }

    public static DisplayMetrics L(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String M() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(O022Z.m), 256);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(line);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static boolean N(ru6 ru6Var, String str) {
        try {
            int iO = O(str);
            xt6.b(ru6Var, "biz", "bindExt", "" + iO);
            return vt6.I().x() && (iO & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int O(String str) {
        try {
            String strS = vt6.I().s();
            if (TextUtils.isEmpty(strS)) {
                return 0;
            }
            return (D(strS, "").contains(str) ? 2 : 0) | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static String P() {
        String strM = M();
        int iIndexOf = strM.indexOf("-");
        if (iIndexOf != -1) {
            strM = strM.substring(0, iIndexOf);
        }
        int iIndexOf2 = strM.indexOf("\n");
        if (iIndexOf2 != -1) {
            strM = strM.substring(0, iIndexOf2);
        }
        return "Linux " + strM;
    }

    public static String Q(ru6 ru6Var, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            xt6.c(ru6Var, "biz", "H5PayDataAnalysisError", e);
            return "";
        }
    }

    public static String R(Context context) {
        String strA = lh7.a(context);
        return strA.substring(0, strA.indexOf("://"));
    }

    public static String S() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String T(Context context) {
        DisplayMetrics displayMetricsL = L(context);
        return displayMetricsL.widthPixels + "*" + displayMetricsL.heightPixels;
    }

    public static boolean U(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static int V() {
        try {
            return Process.myUid();
        } catch (Throwable th) {
            w97.d(th);
            return -200;
        }
    }

    public static String W(Context context) {
        return " (" + S() + x.aQ + P() + x.aQ + I(context) + x.aQ + x.aQ + T(context) + ")(sdk android)";
    }

    public static String X(String str) {
        return m(str, true);
    }

    public static JSONObject Y(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static boolean Z() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static int a() {
        String strD = j07.e().d();
        if (TextUtils.isEmpty(strD)) {
            return -1;
        }
        String strReplaceAll = strD.replaceAll(ContainerUtils.KEY_VALUE_DELIMITER, "");
        if (strReplaceAll.length() >= 5) {
            strReplaceAll = strReplaceAll.substring(0, 5);
        }
        int iB = (int) (b(strReplaceAll) % 10000);
        return iB < 0 ? iB * (-1) : iB;
    }

    public static boolean a0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.alipay.android.app", 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static long b(String str) {
        return c(str, 6);
    }

    public static String b0(String str) {
        try {
            Uri uri = Uri.parse(str);
            return String.format("%s%s", uri.getAuthority(), uri.getPath());
        } catch (Throwable th) {
            w97.d(th);
            return "-";
        }
    }

    public static long c(String str, int i) {
        int iPow = (int) Math.pow(2.0d, i);
        int length = str.length();
        long j = 0;
        int i2 = 0;
        int i3 = length;
        while (i2 < length) {
            int i4 = i2 + 1;
            j += ((long) Integer.parseInt(String.valueOf(K(str.substring(i2, i4))))) * ((long) Math.pow(iPow, i3 - 1));
            i3--;
            i2 = i4;
        }
        return j;
    }

    public static boolean c0() {
        try {
            String[] strArrSplit = vt6.I().p().split("\\|");
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : strArrSplit) {
                if (TextUtils.equals(str, str2) || TextUtils.equals(str2, "all")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            w97.d(th);
            return false;
        }
    }

    public static ActivityInfo d(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            w97.d(th);
            return null;
        }
    }

    public static PackageInfo e(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static <T> T f(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String g(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (iNextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (iNextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static String h(ru6 ru6Var) {
        return H(ru6Var, "ro.build.fingerprint");
    }

    public static String i(ru6 ru6Var, Context context) {
        try {
            String strA = ff7.a(ru6Var, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            try {
                ff7.c(ru6Var, context, "alipay_cashier_ap_fi", cu6.b("FU", System.currentTimeMillis(), new z87(), (short) 0, new ic7()).a());
                String strA2 = ff7.a(ru6Var, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(strA2)) {
                    return strA2;
                }
                xt6.g(ru6Var, "biz", "e_regen_empty", "");
                return "";
            } catch (Exception e) {
                xt6.g(ru6Var, "biz", "e_gen", e.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e2) {
            xt6.c(ru6Var, "biz", "e_gen_err", e2);
            return "";
        }
    }

    public static String j(ru6 ru6Var, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e) {
            xt6.c(ru6Var, "auth", "GetPublicKeyFromSignEx", e);
            return null;
        }
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, String str3) {
        try {
            int iIndexOf = str3.indexOf(str) + str.length();
            if (iIndexOf <= str.length()) {
                return "";
            }
            int iIndexOf2 = !TextUtils.isEmpty(str2) ? str3.indexOf(str2, iIndexOf) : 0;
            return iIndexOf2 < 1 ? str3.substring(iIndexOf) : str3.substring(iIndexOf, iIndexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m(String str, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(x.dW);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            if (!z || bArrDigest.length <= 16) {
                return n(bArrDigest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(bArrDigest, 0, bArr, 0, 16);
            return n(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String n(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & 15, 16));
        }
        return sb.toString();
    }

    public static Map<String, String> o(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            return map;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, jSONObject.optString(next));
            } catch (Throwable th) {
                w97.d(th);
            }
        }
        return map;
    }

    public static c p(ru6 ru6Var, Context context, String str, int i, String str2) {
        PackageInfo packageInfoE;
        if (EnvUtils.a() && "com.eg.android.AlipayGphone".equals(str)) {
            str = "com.eg.android.AlipayGphoneRC";
        }
        try {
            packageInfoE = e(context, str);
        } catch (Throwable th) {
            xt6.g(ru6Var, "auth", "GetPackageInfoEx", th.getMessage());
            packageInfoE = null;
        }
        if (w(ru6Var, packageInfoE)) {
            return r(packageInfoE, i, str2);
        }
        return null;
    }

    public static c q(ru6 ru6Var, Context context, List<vt6.b> list) {
        c cVarP;
        if (list == null) {
            return null;
        }
        for (vt6.b bVar : list) {
            if (bVar != null && (cVarP = p(ru6Var, context, bVar.f21529a, bVar.b, bVar.c)) != null && !cVarP.b(ru6Var) && !cVarP.a()) {
                return cVarP;
            }
        }
        return null;
    }

    public static c r(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i, str);
    }

    public static JSONObject s(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static void t(String str, String str2, Context context, ru6 ru6Var) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || G(ru6Var) || !vt6.I().C()) {
            return;
        }
        try {
            Intent intent = new Intent("android.app.intent.action.APP_EXCEPTION_OCCUR");
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            xt6.b(ru6Var, "biz", "AppNotify", str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2);
        } catch (Exception unused) {
        }
    }

    public static boolean u(long j, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        if (j > 0) {
            return conditionVariable.block(j);
        }
        conditionVariable.block();
        return true;
    }

    public static boolean v(ru6 ru6Var, Context context, List<vt6.b> list, boolean z) {
        try {
            for (vt6.b bVar : list) {
                if (bVar != null) {
                    String str = bVar.f21529a;
                    if (EnvUtils.a() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = "com.eg.android.AlipayGphoneRC";
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z) {
                                return true;
                            }
                            xt6.b(ru6Var, "biz", "PgWltVer", packageInfo.packageName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + packageInfo.versionName);
                            return true;
                        }
                        continue;
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "CheckLaunchAppExistEx", th);
            return false;
        }
    }

    public static boolean w(ru6 ru6Var, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            xt6.g(ru6Var, "auth", "NotIncludeSignatures", str);
        }
        return z;
    }

    public static boolean x(ru6 ru6Var, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith("alipay.com")) {
                return true;
            }
            return host.endsWith("alipay.net");
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "ckUrlErr", th);
            return false;
        }
    }

    public static boolean y(ru6 ru6Var, String str, Activity activity) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                c cVarQ = q(ru6Var, activity, fu6.d);
                if (cVarQ != null && !cVarQ.a() && !cVarQ.b(ru6Var)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, k(HttpHost.DEFAULT_SCHEME_NAME, "://m.alipay.com/?action=h5quit"))) {
            xz6.c(xz6.a());
            activity.finish();
            return true;
        }
        if (!str.startsWith("sdklite://h5quit?result=")) {
            return false;
        }
        try {
            String strSubstring2 = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
            int i = Integer.parseInt(strSubstring2.substring(strSubstring2.lastIndexOf("&end_code=") + 10));
            if (i == com.alipay.sdk.m.j.c.SUCCEEDED.b() || i == com.alipay.sdk.m.j.c.PAY_WAITTING.b()) {
                if (hu6.c) {
                    StringBuilder sb = new StringBuilder();
                    String strDecode = URLDecoder.decode(str);
                    String strDecode2 = URLDecoder.decode(strDecode);
                    String str2 = strDecode2.substring(strDecode2.indexOf("sdklite://h5quit?result=") + 24, strDecode2.lastIndexOf("&end_code=")).split("&return_url=")[0];
                    int iIndexOf = strDecode.indexOf("&return_url=") + 12;
                    sb.append(str2);
                    sb.append("&return_url=");
                    sb.append(strDecode.substring(iIndexOf, strDecode.indexOf(ContainerUtils.FIELD_DELIMITER, iIndexOf)));
                    sb.append(strDecode.substring(strDecode.indexOf(ContainerUtils.FIELD_DELIMITER, iIndexOf)));
                    strSubstring = sb.toString();
                } else {
                    String strDecode3 = URLDecoder.decode(str);
                    strSubstring = strDecode3.substring(strDecode3.indexOf("sdklite://h5quit?result=") + 24, strDecode3.lastIndexOf("&end_code="));
                }
                com.alipay.sdk.m.j.c cVarB = com.alipay.sdk.m.j.c.b(i);
                xz6.c(xz6.b(cVarB.b(), cVarB.a(), strSubstring));
            } else {
                com.alipay.sdk.m.j.c cVarB2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
                xz6.c(xz6.b(cVarB2.b(), cVarB2.a(), ""));
            }
        } catch (Exception unused2) {
            xz6.c(xz6.h());
        }
        activity.runOnUiThread(new a(activity));
        return true;
    }

    public static boolean z(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f20251a;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
