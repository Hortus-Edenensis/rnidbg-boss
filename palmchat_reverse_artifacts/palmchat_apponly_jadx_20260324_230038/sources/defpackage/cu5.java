package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cu5 {
    public static String a(Context context) {
        String strC;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                strC = "wifi";
            } else {
                if (activeNetworkInfo.getType() != 0) {
                    return "unknown";
                }
                strC = c(activeNetworkInfo.getSubtype());
            }
            return strC;
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    public static int b(Context context) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        if ("wifi".equals(strA)) {
            return 1;
        }
        if ("2g".equals(strA)) {
            return 2;
        }
        if ("3g".equals(strA)) {
            return 3;
        }
        if ("4g".equals(strA)) {
            return 4;
        }
        return NetworkUtil.NETWORK_CLASS_5G.equals(strA) ? 5 : 0;
    }

    public static String c(int i) {
        k63.j("TeleonyManagerUtils", "getNetworkClass networkType:" + i);
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                switch (i) {
                    case 16:
                        return "2g";
                    case 17:
                        return "3g";
                    case 18:
                    case 19:
                        return "4g";
                    case 20:
                        return NetworkUtil.NETWORK_CLASS_5G;
                    default:
                        return "unknown";
                }
        }
    }

    public static String d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }
}
