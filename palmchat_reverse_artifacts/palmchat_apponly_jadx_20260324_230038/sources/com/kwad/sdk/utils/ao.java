package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ao {
    private static int beS = 0;
    private static boolean beT = false;
    private static String beU = "";

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo dn(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m68do(Context context) {
        try {
            NetworkInfo networkInfoDn = dn(context);
            if (networkInfoDn != null && networkInfoDn.isConnected()) {
                int type = networkInfoDn.getType();
                if (type == 0) {
                    String subtypeName = networkInfoDn.getSubtypeName();
                    return TextUtils.isEmpty(subtypeName) ? networkInfoDn.getTypeName() : subtypeName;
                }
                if (type == 1) {
                    return networkInfoDn.getTypeName();
                }
            }
        } catch (Exception unused) {
        }
        return "unknown";
    }

    public static int dp(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.c)) {
            try {
                NetworkInfo networkInfoDn = dn(context);
                if (!(networkInfoDn != null && networkInfoDn.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoDn.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int iN = n(context, telephonyManager.getNetworkType());
                    if (iN == 20) {
                        return 5;
                    }
                    switch (iN) {
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2 A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x0039, B:15:0x003c, B:48:0x009f, B:49:0x00a2, B:50:0x00a5, B:51:0x00a8, B:52:0x00ab, B:17:0x0040, B:20:0x004a, B:23:0x0054, B:26:0x005e, B:29:0x0068, B:32:0x0073, B:35:0x007b, B:38:0x0083, B:41:0x008b, B:44:0x0093, B:54:0x00b0, B:56:0x00b4, B:58:0x00ba, B:60:0x00c0, B:63:0x00c7, B:65:0x00cd, B:66:0x00d0, B:68:0x00d6, B:69:0x00d9, B:53:0x00ae), top: B:81:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5 A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x0039, B:15:0x003c, B:48:0x009f, B:49:0x00a2, B:50:0x00a5, B:51:0x00a8, B:52:0x00ab, B:17:0x0040, B:20:0x004a, B:23:0x0054, B:26:0x005e, B:29:0x0068, B:32:0x0073, B:35:0x007b, B:38:0x0083, B:41:0x008b, B:44:0x0093, B:54:0x00b0, B:56:0x00b4, B:58:0x00ba, B:60:0x00c0, B:63:0x00c7, B:65:0x00cd, B:66:0x00d0, B:68:0x00d6, B:69:0x00d9, B:53:0x00ae), top: B:81:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a8 A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x0039, B:15:0x003c, B:48:0x009f, B:49:0x00a2, B:50:0x00a5, B:51:0x00a8, B:52:0x00ab, B:17:0x0040, B:20:0x004a, B:23:0x0054, B:26:0x005e, B:29:0x0068, B:32:0x0073, B:35:0x007b, B:38:0x0083, B:41:0x008b, B:44:0x0093, B:54:0x00b0, B:56:0x00b4, B:58:0x00ba, B:60:0x00c0, B:63:0x00c7, B:65:0x00cd, B:66:0x00d0, B:68:0x00d6, B:69:0x00d9, B:53:0x00ae), top: B:81:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x0039, B:15:0x003c, B:48:0x009f, B:49:0x00a2, B:50:0x00a5, B:51:0x00a8, B:52:0x00ab, B:17:0x0040, B:20:0x004a, B:23:0x0054, B:26:0x005e, B:29:0x0068, B:32:0x0073, B:35:0x007b, B:38:0x0083, B:41:0x008b, B:44:0x0093, B:54:0x00b0, B:56:0x00b4, B:58:0x00ba, B:60:0x00c0, B:63:0x00c7, B:65:0x00cd, B:66:0x00d0, B:68:0x00d6, B:69:0x00d9, B:53:0x00ae), top: B:81:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(Context context, String str, boolean z) {
        byte b;
        if (context == null || beS > 0 || beT) {
            return beS;
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (z) {
            beS = 0;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 22) {
                String simOperator = telephonyManager.getSimOperator();
                int iHashCode = simOperator.hashCode();
                if (iHashCode != 49679502) {
                    switch (iHashCode) {
                        case 49679470:
                            b = !simOperator.equals("46000") ? (byte) -1 : (byte) 0;
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                b = 4;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                b = 1;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                b = 7;
                                break;
                            }
                            break;
                        default:
                            switch (iHashCode) {
                                case 49679475:
                                    if (simOperator.equals("46005")) {
                                        b = 8;
                                        break;
                                    }
                                    break;
                                case 49679476:
                                    if (simOperator.equals("46006")) {
                                        b = 5;
                                        break;
                                    }
                                    break;
                                case 49679477:
                                    if (simOperator.equals("46007")) {
                                        b = 2;
                                        break;
                                    }
                                    break;
                                case 49679478:
                                    if (simOperator.equals("46008")) {
                                        b = 3;
                                        break;
                                    }
                                    break;
                                case 49679479:
                                    if (simOperator.equals("46009")) {
                                        b = 6;
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            beS = 1;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            beS = 3;
                            break;
                        case 7:
                        case 8:
                        case 9:
                            beS = 2;
                            break;
                        default:
                            beS = 0;
                            break;
                    }
                } else {
                    if (simOperator.equals("46011")) {
                        b = 9;
                    }
                    switch (b) {
                    }
                }
                int i = beS;
                beT = i == 0;
                return i;
            }
        }
        if (beS == 0 && !TextUtils.isEmpty(str)) {
            if (str.startsWith("46000") || str.startsWith("46002")) {
                beS = 1;
            } else if (str.startsWith("46001")) {
                beS = 3;
            } else if (str.startsWith("46003")) {
                beS = 2;
            }
        }
        int i2 = beS;
        beT = i2 == 0;
        return i2;
    }

    public static String f(Context context, boolean z) {
        if (z) {
            return "";
        }
        if (!TextUtils.isEmpty(beU)) {
            return beU;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                beU = telephonyManager.getSimOperator();
            } catch (Exception unused) {
            }
        }
        return beU;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoDn = dn(context);
            if (networkInfoDn == null) {
                return -1;
            }
            return networkInfoDn.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    private static boolean hs(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean ht(String str) {
        return t(str, 3000);
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoDn = dn(context);
            if (networkInfoDn != null && networkInfoDn.isConnected()) {
                if (networkInfoDn.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoDn = dn(context);
            if (networkInfoDn != null) {
                if (networkInfoDn.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoDn = dn(context);
            if (networkInfoDn != null && networkInfoDn.isConnected()) {
                return 1 == networkInfoDn.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i) {
        ServiceState serviceState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion < 29 || i2 < 29) {
                try {
                    serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            } else {
                serviceState = telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i;
            }
            if (bb.Ta()) {
                Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            }
            if (hs(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    @WorkerThread
    private static boolean t(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
