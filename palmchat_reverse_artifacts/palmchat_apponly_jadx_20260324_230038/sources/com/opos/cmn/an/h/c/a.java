package com.opos.cmn.an.h.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f7790a;
    private static TelephonyManager b;

    public static TelephonyManager a(Context context) {
        if (b == null && context != null) {
            b = (TelephonyManager) context.getSystemService("phone");
        }
        return b;
    }

    public static ConnectivityManager b(Context context) {
        if (f7790a == null && context != null) {
            f7790a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f7790a;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerB = b(context);
            if (connectivityManagerB == null || (activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.getType() == 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            return false;
        }
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerB = b(context);
            if (connectivityManagerB == null || (activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo()) == null) {
                return false;
            }
            return NetworkInfo.State.CONNECTED == activeNetworkInfo.getState();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            return false;
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManagerB = b(context);
            if (connectivityManagerB == null || (activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            return false;
        }
    }

    public static String f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return "";
        }
        try {
            ConnectivityManager connectivityManagerB = b(context);
            if (connectivityManagerB == null || (activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            if (activeNetworkInfo.getTypeName() == null) {
                return "";
            }
            if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                sb.append(activeNetworkInfo.getTypeName());
            } else {
                if (Build.VERSION.SDK_INT > 29) {
                    if (!com.opos.cmn.an.h.d.a.a(context, g.c)) {
                        return c(context) ? "mobile" : "";
                    }
                    TelephonyManager telephonyManagerA = a(context);
                    return telephonyManagerA != null ? a(telephonyManagerA.getDataNetworkType()) : "";
                }
                if (activeNetworkInfo.getSubtypeName() == null) {
                    return "";
                }
                sb.append(activeNetworkInfo.getSubtypeName());
            }
            return sb.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            return "";
        }
    }

    public static int g(Context context) {
        NetworkInfo activeNetworkInfo;
        int dataNetworkType = 0;
        if (context != null) {
            try {
                ConnectivityManager connectivityManagerB = b(context);
                if (connectivityManagerB != null && (activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo()) != null) {
                    if (1 == activeNetworkInfo.getType()) {
                        dataNetworkType = -1;
                    } else if (activeNetworkInfo.getType() == 0) {
                        if (Build.VERSION.SDK_INT <= 29) {
                            dataNetworkType = activeNetworkInfo.getSubtype();
                        } else if (com.opos.cmn.an.h.d.a.a(context, g.c)) {
                            TelephonyManager telephonyManagerA = a(context);
                            if (telephonyManagerA != null) {
                                dataNetworkType = telephonyManagerA.getDataNetworkType();
                            }
                        } else if (c(context)) {
                            dataNetworkType = -2;
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            }
        }
        return dataNetworkType;
    }

    public static String h(Context context) {
        String str;
        if (context == null) {
            return "none";
        }
        try {
            int iG = g(context);
            if (iG == -2) {
                str = "mobile";
            } else if (iG == -1) {
                str = "wifi";
            } else if (iG != 20) {
                switch (iG) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2g";
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
                        str = "3g";
                        break;
                    case 13:
                        str = "4g";
                        break;
                    default:
                        return "none";
                }
            } else {
                str = NetworkUtil.NETWORK_CLASS_5G;
            }
            return str;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ConnMgrTool", "", e);
            return "none";
        }
    }

    private static String a(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "NR";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }
}
