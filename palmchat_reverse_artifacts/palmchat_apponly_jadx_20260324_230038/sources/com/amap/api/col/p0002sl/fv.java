package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fv {
    private static boolean A = false;
    private static String B = "";
    private static boolean C = false;
    private static String D = "";
    private static String E = "";
    private static String F = "";
    private static boolean G = false;
    private static boolean H = false;
    private static String I = "";
    private static boolean J = false;
    private static boolean K = false;
    private static long L = 0;
    private static int M = 0;
    private static String N = null;
    private static String O = "";
    private static boolean P = true;
    private static boolean Q = false;
    private static String R = "";
    private static boolean S = false;
    private static int T = -1;
    private static boolean U = false;
    private static int V = -1;
    private static boolean W = false;
    private static volatile b X = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f2802a = "";
    static String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static a g = null;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k = null;
    private static boolean l = false;
    private static String m = "";
    private static volatile boolean n = false;
    private static String o = "";
    private static boolean p = false;
    private static boolean q = true;
    private static String r = null;
    private static IBinder s = null;
    private static boolean t = false;
    private static boolean u = false;
    private static String v = "";
    private static String w = "";
    private static boolean x = false;
    private static boolean y = false;
    private static String z = "";

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        id a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Context f2805a;
        private static BroadcastReceiver b;
        private static ConnectivityManager c;
        private static NetworkRequest d;
        private static ConnectivityManager.NetworkCallback e;

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || b != null) {
                    return;
                }
                b = new BroadcastReceiver() { // from class: com.amap.api.col.2sl.fv.b.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        if (ge.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                            fv.q();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ge.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(b, intentFilter);
                return;
            }
            if (fv.b(context, ge.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                c = connectivityManager;
                if (connectivityManager != null) {
                    d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.amap.api.col.2sl.fv.b.2
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            fv.q();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            super.onLost(network);
                            fv.q();
                        }
                    };
                    e = networkCallback;
                    c.registerNetworkCallback(d, networkCallback);
                    f2805a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String A(Context context) {
        String strC = ge.c("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!strC.equalsIgnoreCase(str)) {
            String strC2 = ge.c("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!strC2.equalsIgnoreCase(str2) && !ge.c("IUkVETUk=").equalsIgnoreCase(str) && !ge.c("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (ge.c("Idml2bw").equalsIgnoreCase(str) || ge.c("Idml2bw").equalsIgnoreCase(str2)) {
                    return z(context);
                }
                if (ge.c("IaHVhd2Vp").equalsIgnoreCase(str) || ge.c("IaHVhd2Vp").equalsIgnoreCase(str2) || ge.c("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return a(context, 2);
                }
                if (ge.c("Mc2Ftc3VuZw").equalsIgnoreCase(str) || ge.c("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return a(context, 4);
                }
                if (ge.c("IT1BQTw").equalsIgnoreCase(str) || ge.c("IT1BQTw").equalsIgnoreCase(str2) || ge.c("MT25lUGx1cw").equalsIgnoreCase(str) || ge.c("MT25lUGx1cw").equalsIgnoreCase(str2) || ge.c("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return a(context, 5);
                }
                p = true;
                return o;
            }
        }
        return y(context);
    }

    private static String B(Context context) {
        if (!TextUtils.isEmpty(I)) {
            return I;
        }
        try {
            String strB = hm.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(strB)) {
                I = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor editorA = hm.a(context, "open_common");
                hm.a(editorA, "a1", ge.b(I));
                hm.a(editorA);
            } else {
                I = ge.c(strB);
            }
            return I;
        } catch (Throwable unused) {
            return I;
        }
    }

    private static String C(Context context) {
        if (S) {
            return R;
        }
        L(context);
        TelephonyManager telephonyManagerG = G(context);
        if (telephonyManagerG == null) {
            return R;
        }
        String simOperatorName = telephonyManagerG.getSimOperatorName();
        R = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            R = telephonyManagerG.getNetworkOperatorName();
        }
        S = true;
        return R;
    }

    private static int D(Context context) {
        if (U) {
            return T;
        }
        L(context);
        if (context == null || !b(context, ge.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return T;
        }
        ConnectivityManager connectivityManagerE = E(context);
        if (connectivityManagerE == null) {
            return T;
        }
        NetworkInfo activeNetworkInfo = connectivityManagerE.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            U = true;
            return T;
        }
        int type = activeNetworkInfo.getType();
        T = type;
        U = true;
        return type;
    }

    private static ConnectivityManager E(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int F(Context context) {
        if (W) {
            return V;
        }
        L(context);
        if (!b(context, ge.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return V;
        }
        ConnectivityManager connectivityManagerE = E(context);
        if (connectivityManagerE == null) {
            return V;
        }
        NetworkInfo activeNetworkInfo = connectivityManagerE.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            V = activeNetworkInfo.getSubtype();
            W = true;
        }
        return V;
    }

    private static TelephonyManager G(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String H(Context context) {
        String strI;
        if (!c) {
            return "";
        }
        try {
            strI = I(context);
        } catch (Throwable unused) {
            strI = null;
        }
        if (TextUtils.isEmpty(strI)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = ge.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(fw.a(ge.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), fw.b(strI), bytes), "UTF-8");
        } catch (Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static String I(Context context) {
        String strJ;
        try {
            strJ = J(context);
        } catch (Throwable unused) {
            strJ = "";
        }
        return !TextUtils.isEmpty(strJ) ? strJ : context == null ? "" : context.getSharedPreferences(ge.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(fz.a(ge.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String J(Context context) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        String[] strArrSplit;
        String strA = fz.a(ge.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String strK = K(context);
        if (TextUtils.isEmpty(strK)) {
            return "";
        }
        File file = new File(strK + File.separator + ge.c("KYmFja3Vwcw"), ge.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, t.k);
                try {
                    bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
            }
            while (true) {
                try {
                    int i2 = randomAccessFile.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Throwable unused3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    a(byteArrayOutputStream2);
                }
                a(randomAccessFile);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            if (!TextUtils.isEmpty(str) && str.contains(ge.c("SIw")) && (strArrSplit = str.split(ge.c("SIw"))) != null && strArrSplit.length == 2 && TextUtils.equals(strA, strArrSplit[0])) {
                String str2 = strArrSplit[1];
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return str2;
            }
            a(byteArrayOutputStream);
            a(randomAccessFile);
        }
        return "";
    }

    private static String K(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static synchronized b L(Context context) {
        if (X == null) {
            if (context == null) {
                return null;
            }
            b bVar = new b();
            X = bVar;
            bVar.a(context.getApplicationContext());
        }
        return X;
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(e)) {
                return e;
            }
            a aVar = g;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static a c() {
        return g;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String strN = n();
            return strN.length() < 5 ? "" : strN.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return "";
    }

    public static String f() {
        return "";
    }

    public static String g() {
        return "";
    }

    public static String h() {
        return z;
    }

    public static String[] i() {
        return new String[]{"", ""};
    }

    public static int j(Context context) {
        try {
            return D(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo k(Context context) {
        ConnectivityManager connectivityManagerE;
        if (b(context, ge.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManagerE = E(context)) != null) {
            return connectivityManagerE.getActiveNetworkInfo();
        }
        return null;
    }

    public static String l(Context context) {
        try {
            NetworkInfo networkInfoK = k(context);
            if (networkInfoK == null) {
                return null;
            }
            return networkInfoK.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String m() {
        return "";
    }

    public static String n() {
        return "";
    }

    public static long o() {
        long j2 = L;
        if (j2 != 0) {
            return j2;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            L = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (Throwable unused) {
        }
        return L;
    }

    public static String p(Context context) {
        try {
            String strK = k();
            try {
                if (TextUtils.isEmpty(strK)) {
                    strK = a(context);
                }
                if (TextUtils.isEmpty(strK)) {
                    strK = f(context);
                }
                if (TextUtils.isEmpty(strK)) {
                    strK = e(context);
                }
                if (TextUtils.isEmpty(strK)) {
                    strK = g();
                }
                return TextUtils.isEmpty(strK) ? B(context) : strK;
            } catch (Throwable unused) {
                return strK;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String q(Context context) {
        return k() + "#" + a(context) + "#" + p(context);
    }

    public static /* synthetic */ boolean r() {
        t = true;
        return true;
    }

    public static String s(Context context) {
        try {
            return C(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t(Context context) {
        try {
            if (TextUtils.isEmpty(m)) {
                m = gm.a(context);
            }
        } catch (Throwable unused) {
        }
        return m;
    }

    private static String v(Context context) {
        try {
            String strB = hm.b(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(strB) ? hm.b(context, "Alvin2", "UTDID", "") : strB;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String w(Context context) {
        FileInputStream fileInputStream;
        XmlPullParser xmlPullParserNewPullParser;
        int eventType;
        try {
            File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
            xmlPullParserNewPullParser = Xml.newPullParser();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
            boolean z2 = false;
            for (eventType = xmlPullParserNewPullParser.getEventType(); 1 != eventType; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        z2 = false;
                    } else if (eventType == 4 && z2) {
                        String text = xmlPullParserNewPullParser.getText();
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return text;
                    }
                } else if (xmlPullParserNewPullParser.getAttributeCount() > 0) {
                    int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                    for (int i2 = 0; i2 < attributeCount; i2++) {
                        String attributeValue = xmlPullParserNewPullParser.getAttributeValue(i2);
                        if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                            z2 = true;
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String x(Context context) {
        try {
            if (!TextUtils.isEmpty(r)) {
                return r;
            }
            byte[] bArrDigest = MessageDigest.getInstance(ge.c("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
            }
            String string = stringBuffer.toString();
            if (!TextUtils.isEmpty(string)) {
                r = string;
            }
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String y(Context context) {
        try {
            Class<?> cls = Class.forName(ge.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object objInvoke = cls.getMethod(ge.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (objInvoke != null) {
                String str = (String) objInvoke;
                o = str;
                return str;
            }
        } catch (Throwable th) {
            ha.a(th, "oa", "xm");
            p = true;
        }
        return o;
    }

    private static String z(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(ge.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    int columnCount = cursorQuery.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        }
                        if (ge.c("IdmFsdWU").equals(cursorQuery.getColumnName(i2))) {
                            o = cursorQuery.getString(i2);
                            break;
                        }
                        i2++;
                    }
                }
                cursorQuery.close();
            }
        } catch (Throwable th) {
            p = true;
            ha.a(th, "oa", "vivo");
        }
        return o;
    }

    public static int c(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String e(final Context context) {
        if (!q || p) {
            return "";
        }
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        if (t) {
            return o;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            jc.a().b(new jd() { // from class: com.amap.api.col.2sl.fv.2
                @Override // com.amap.api.col.p0002sl.jd
                public final void a() {
                    fv.A(context);
                    fv.r();
                }
            });
            return o;
        }
        t = true;
        return A(context);
    }

    public static String f(Context context) {
        String str;
        if (u) {
            String str2 = f2802a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f2802a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f2802a;
        }
        if (b(context, ge.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f2802a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f2802a)) {
            u = true;
            return f2802a;
        }
        try {
            String strV = v(context);
            f2802a = strV;
            if (!TextUtils.isEmpty(strV)) {
                u = true;
                return f2802a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f2802a = w(context);
            u = true;
        } catch (Throwable unused3) {
        }
        String str3 = f2802a;
        return str3 == null ? "" : str3;
    }

    public static String g(Context context) {
        try {
            TelephonyManager telephonyManagerG = G(context);
            if (telephonyManagerG == null) {
                return "";
            }
            String networkOperator = telephonyManagerG.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h(Context context) {
        TelephonyManager telephonyManagerG;
        if (C) {
            return B;
        }
        try {
            L(context);
            telephonyManagerG = G(context);
        } catch (Throwable unused) {
        }
        if (telephonyManagerG == null) {
            return B;
        }
        String networkOperator = telephonyManagerG.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            B = networkOperator.substring(3);
            C = true;
            return B;
        }
        C = true;
        return B;
    }

    public static int i(Context context) {
        try {
            return F(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String j() {
        return i;
    }

    public static String m(Context context) {
        String str;
        String str2;
        try {
            str = D;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return D;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i3 > i2) {
            str2 = i2 + "*" + i3;
        } else {
            str2 = i3 + "*" + i2;
        }
        D = str2;
        return D;
    }

    public static String n(Context context) {
        try {
            if (!b(context, ge.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O;
            }
            TelephonyManager telephonyManagerG = G(context);
            return telephonyManagerG == null ? "" : telephonyManagerG.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void q() {
        T = -1;
        U = false;
        V = -1;
        W = false;
        R = "";
        S = false;
        B = "";
        C = false;
    }

    public static int r(Context context) {
        int i2 = M;
        if (i2 != 0) {
            return i2;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i3 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        M = i3;
        return i3;
    }

    public static void a(String str) {
        k = str;
    }

    public static void l() {
        try {
            gz.a();
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        return k;
    }

    public static String k() {
        return E;
    }

    public static void a(a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    public static String b(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(final Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (context == null) {
            return "";
        }
        String strH = H(context);
        b = strH;
        if (!TextUtils.isEmpty(strH)) {
            return b;
        }
        if (c() == null || n) {
            return "";
        }
        n = true;
        jc.a().b(new jd() { // from class: com.amap.api.col.2sl.fv.1
            @Override // com.amap.api.col.p0002sl.jd
            public final void a() {
                try {
                    Map<String, String> mapB = fv.g.b();
                    String strA = fv.g.a(fv.f(context), "", "", fv.n());
                    if (TextUtils.isEmpty(strA)) {
                        return;
                    }
                    hx.a();
                    String strA2 = fv.g.a(context, new String(hx.c(fv.g.a(strA.getBytes(), mapB)).f2902a));
                    if (TextUtils.isEmpty(strA2)) {
                        return;
                    }
                    fv.b = strA2;
                } catch (Throwable unused) {
                }
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String o(Context context) {
        ConnectivityManager connectivityManagerE;
        NetworkInfo activeNetworkInfo;
        try {
            return (!b(context, ge.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (connectivityManagerE = E(context)) == null || (activeNetworkInfo = connectivityManagerE.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String p() {
        if (!TextUtils.isEmpty(N)) {
            return N;
        }
        String property = System.getProperty("os.arch");
        N = property;
        return property;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3 A[Catch: all -> 0x00f0, TRY_ENTER, TryCatch #0 {all -> 0x00f0, blocks: (B:3:0x0001, B:7:0x000f, B:9:0x0014, B:12:0x004f, B:17:0x0060, B:19:0x0068, B:21:0x006e, B:32:0x00c3, B:33:0x00c6, B:37:0x00d4, B:39:0x00d9, B:40:0x00df, B:41:0x00e0, B:42:0x00e7, B:43:0x00ed, B:10:0x002d, B:11:0x003d, B:36:0x00cb, B:31:0x00b5, B:26:0x007e, B:27:0x009f, B:28:0x00a9), top: B:48:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, int i2) {
        boolean z2;
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(ge.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(ge.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(ge.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), ge.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i2 != 5) {
                    p = true;
                    return o;
                }
                intent.setClassName(ge.c("YY29tLmhleXRhcC5vcGVuaWQ"), ge.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(ge.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            c cVar = new c();
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(o)) {
                    i3++;
                    if (s != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        if (i2 == 2) {
                            parcelObtain.writeInterfaceToken(ge.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                        } else if (i2 == 4) {
                            parcelObtain.writeInterfaceToken(ge.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                        } else if (i2 != 5) {
                            z2 = false;
                            if (!z2) {
                                try {
                                    s.transact(1, parcelObtain, parcelObtain2, 0);
                                    parcelObtain2.readException();
                                    o = parcelObtain2.readString();
                                    parcelObtain2.recycle();
                                } finally {
                                    try {
                                    } catch (Throwable th) {
                                    }
                                }
                                parcelObtain.recycle();
                            } else {
                                parcelObtain2.recycle();
                                parcelObtain.recycle();
                            }
                        } else {
                            parcelObtain.writeInterfaceToken(ge.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                            parcelObtain.writeString(context.getPackageName());
                            parcelObtain.writeString(x(context));
                            parcelObtain.writeString(ge.c("IT1VJRA"));
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    }
                    Thread.sleep(15L);
                }
                context.unbindService(cVar);
                s = null;
            }
            return o;
        } catch (Throwable th2) {
            ha.a(th2, "oa", String.valueOf(i2));
            p = true;
            return o;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = fv.s = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void a(boolean z2) {
        q = z2;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
