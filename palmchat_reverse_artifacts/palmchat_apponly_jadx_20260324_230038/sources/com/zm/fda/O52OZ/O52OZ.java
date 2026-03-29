package com.zm.fda.O52OZ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zm.fda.utils.EventLog;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O52OZ {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16626a = 20;
    public static final int b = 29;
    public static final int c = -1;
    public static final int d = 0;
    public static final int e = 1;

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        if (context != null) {
            return a(context, a(context));
        }
        return null;
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        WifiInfo connectionInfo;
        return (context == null || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null || connectionInfo.getMacAddress() == null) ? "" : connectionInfo.getMacAddress();
    }

    public static int d(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            if (EventLog.isDebugEnable()) {
                EventLog.d("fob_fda", "getNetworkType: " + activeNetworkInfo.getType());
            }
            if (activeNetworkInfo.getType() == 0) {
                return 0;
            }
            return activeNetworkInfo.getType() == 1 ? 1 : -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return RXScreenCaptureService.KEY_WIDTH;
            }
            if (networkInfo.getType() == 0) {
                int subtype = networkInfo.getSubtype();
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "g2";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "g3";
                        case 13:
                            if (a(context, subtype) != 20) {
                                return "g4";
                            }
                            break;
                        default:
                            String subtypeName = networkInfo.getSubtypeName();
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return "g1";
                            }
                            break;
                    }
                }
                return "g5";
            }
        }
        return null;
    }

    public static int a(Context context, int i) {
        ServiceState serviceState;
        if (context == null || Build.VERSION.SDK_INT < 29 || context.checkSelfPermission(g.c) != 0) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int iA = a();
            if (iA == -1) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iA));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i;
            }
            if (a(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    public static int a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }
}
