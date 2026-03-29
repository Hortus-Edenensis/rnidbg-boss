package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18069a = "hx3";
    public static String b = null;
    public static NetworkInfo c = null;
    public static long d = 3000;
    public static long e;

    public static NetworkInfo a() {
        if (c == null || Math.abs(e - System.currentTimeMillis()) > d) {
            e = System.currentTimeMillis();
            c = b();
        }
        return c;
    }

    public static NetworkInfo b() {
        try {
            return ((ConnectivityManager) c.b().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        return d(false);
    }

    public static String d(boolean z) {
        NetworkInfo networkInfoA = a();
        if (networkInfoA != null && networkInfoA.isConnected()) {
            if (networkInfoA.getType() == 1) {
                if (!z) {
                    return "WIFI";
                }
                return "WIFI_" + l();
            }
            if (networkInfoA.getType() == 0) {
                return networkInfoA.getSubtypeName();
            }
        }
        return "NONE";
    }

    public static String e() {
        if (TextUtils.isEmpty(b)) {
            o();
        }
        return b;
    }

    public static int f() {
        int iG = g();
        if (iG == 1) {
            return 3;
        }
        if (iG == 2) {
            return 4;
        }
        if (iG == 3) {
            return 5;
        }
        if (iG != 4) {
            return iG != 10 ? 0 : 2;
        }
        return 6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g() {
        int i;
        NetworkInfo networkInfoA = a();
        if (networkInfoA != null && networkInfoA.isConnected()) {
            int i2 = 1;
            if (networkInfoA.getType() == 1) {
                i = 10;
            } else if (networkInfoA.getType() == 0) {
                String subtypeName = networkInfoA.getSubtypeName();
                switch (networkInfoA.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i2 = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        i2 = 3;
                        break;
                    case 13:
                        i2 = 4;
                        break;
                    default:
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                        }
                        break;
                }
                i = i2;
            }
            LogUtil.i(f18069a, "Network Type : " + i);
            return i;
        }
        LogUtil.i(f18069a, "Network not available ");
        i = 0;
        LogUtil.i(f18069a, "Network Type : " + i);
        return i;
    }

    public static String h() {
        int iG = g();
        return iG != 1 ? iG != 2 ? iG != 3 ? iG != 4 ? iG != 10 ? "NONE" : "WIFI" : "4G" : "3G" : "2G" : "UNKNOW";
    }

    public static String i(Context context) {
        String networkOperator = PrivInfoManager.INSTANCE.getNetworkOperator();
        return networkOperator == null ? "" : networkOperator;
    }

    public static int j(Context context) {
        String networkOperator = PrivInfoManager.INSTANCE.getNetworkOperator();
        if (networkOperator != null) {
            if (networkOperator.equals("46000") || networkOperator.equals("46002")) {
                return 1;
            }
            if (networkOperator.equals("46001")) {
                return 3;
            }
            if (networkOperator.equals("46003")) {
                return 2;
            }
        }
        return 0;
    }

    public static String k() {
        if (r75.l()) {
            return PrivInfoManager.INSTANCE.getBssid();
        }
        return null;
    }

    public static String l() {
        return PrivInfoManager.INSTANCE.getSsid();
    }

    public static boolean m(Context context) {
        return g() > 0;
    }

    public static boolean n() {
        return g() == 10;
    }

    public static void o() {
        c = null;
        b = c();
    }
}
