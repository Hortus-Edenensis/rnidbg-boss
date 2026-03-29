package com.wifi.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.lantern.auth.server.WkParams;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.utils.SmidHelper;
import defpackage.ac1;
import defpackage.me1;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class MdaParamUtils {
    private static final String BAD_CHAR_PATTERN = "\u0000|\u0001|\u0002|\u0003|\u0004|\u0005|\u0006|\u0007";
    private static final String BAD_MAC = "\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000";
    private static final String BAD_MAC_REPLACE = "00:00:00:00:00:00";
    public static final int NETWORK_TYPE_NR = 20;
    public static final int SDK_VERSION_Q = 29;
    private static WifiManager _wifiManager;
    private static String udid;

    @SuppressLint({"MissingPermission"})
    private static int adjustNetworkType(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 29 || context.checkSelfPermission(g.c) != 0) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i;
            }
            if (isServiceStateFiveGAvailable(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    public static String checkBSSID(String str) {
        return (BAD_MAC.equals(str) || BAD_MAC_REPLACE.equals(str)) ? "" : str;
    }

    public static String checkSSID(String str) {
        String strRemoveDoubleQuotes = removeDoubleQuotes(str);
        return !isValidSSID(strRemoveDoubleQuotes) ? "" : strRemoveDoubleQuotes.replaceAll(BAD_CHAR_PATTERN, "*");
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
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

    @Deprecated
    public static String getAndroidIdDirect(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            string = null;
        }
        return string != null ? string : "";
    }

    public static String getConcreteNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(context, getActiveNetworkInfo(context));
        }
        return null;
    }

    private static WifiInfo getConnectionInfo(WifiManager wifiManager) {
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getIMEI(Context context) {
        return null;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getNetOperator(Context context) {
        try {
            String networkOperator = getTelephonyManager(context).getNetworkOperator();
            return TextUtils.isEmpty(networkOperator) ? "" : networkOperator;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() == 0 ? "g" : activeNetworkInfo.getType() == 1 ? RXScreenCaptureService.KEY_WIDTH : "" : "";
    }

    public static String getSimCountryIso(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager.getSimCountryIso() == null ? "" : telephonyManager.getSimCountryIso();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getSsid(Context context) {
        WifiInfo connectionInfo;
        return (!RXScreenCaptureService.KEY_WIDTH.equals(getNetworkType(context)) || (connectionInfo = getConnectionInfo(getWifiManager(context))) == null) ? "" : checkSSID(connectionInfo.getSSID());
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static String getUhid() {
        if (udid == null) {
            udid = getUhidImp();
        }
        return udid;
    }

    private static String getUhidImp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", ac1.p);
            jSONObject.put(WkParams.OSVER, Build.VERSION.SDK_INT);
            jSONObject.put("os", "android");
            jSONObject.put("screen", me1.e());
            jSONObject.put("dudid", SmidHelper.o());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static WifiManager getWifiManager(Context context) {
        if (_wifiManager == null && context != null) {
            _wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        }
        return _wifiManager;
    }

    private static boolean isServiceStateFiveGAvailable(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    public static boolean isValidBSSID(String str) {
        return (str == null || str.length() == 0 || str.equals(BAD_MAC_REPLACE)) ? false : true;
    }

    public static boolean isValidSSID(String str) {
        return (str == null || str.length() == 0 || str.equals("<unknown ssid>") || str.equals("0x")) ? false : true;
    }

    public static String removeDoubleQuotes(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) <= 1 || str.charAt(0) != '\"') {
            return str;
        }
        int i = length - 1;
        return str.charAt(i) == '\"' ? str.substring(1, i) : str;
    }

    public static String getNetworkType(Context context, NetworkInfo networkInfo) {
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
                            if (adjustNetworkType(context, subtype) != 20) {
                                return "g4";
                            }
                            break;
                        default:
                            String subtypeName = networkInfo.getSubtypeName();
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "g3" : "g1";
                    }
                }
                return "g5";
            }
        }
        return null;
    }
}
