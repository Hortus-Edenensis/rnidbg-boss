package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.u.nr.x.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pv6 {

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20115a;

        static {
            int[] iArr = new int[nr.EnumC0320nr.values().length];
            f20115a = iArr;
            try {
                iArr[nr.EnumC0320nr.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20115a[nr.EnumC0320nr.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20115a[nr.EnumC0320nr.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20115a[nr.EnumC0320nr.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20115a[nr.EnumC0320nr.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static nr.EnumC0320nr a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return nr.EnumC0320nr.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return nr.EnumC0320nr.WIFI;
                }
                if (type != 0) {
                    return nr.EnumC0320nr.MOBILE;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return nr.EnumC0320nr.MOBILE_3G;
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return nr.EnumC0320nr.MOBILE;
                    case 13:
                        return nr.EnumC0320nr.MOBILE_4G;
                }
            }
            return nr.EnumC0320nr.NONE;
        } catch (Throwable unused) {
            return nr.EnumC0320nr.MOBILE;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String c(Context context) {
        return d(a(context));
    }

    public static String d(nr.EnumC0320nr enumC0320nr) {
        try {
            int i = a.f20115a[enumC0320nr.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "mobile" : "4g" : "3g" : "2g" : "wifi";
        } catch (Exception unused) {
            return "";
        }
    }
}
