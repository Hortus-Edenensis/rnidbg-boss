package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.wifi.adsdk.utils.BLPlatform;
import defpackage.qr6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class br {
    private static String bfZ = null;
    private static String bga = "";
    private static boolean bgb = false;
    private static String bgc = "";
    private static String bgd = "";
    private static int bge = 0;
    private static boolean bgf = false;
    private static int bgg = 0;
    private static boolean bgh = false;
    private static String bgm;
    private static String bgn;
    private static int bgv;
    private static long bgw;
    private static final String[] bgi = {"", ""};
    private static String bgj = "";
    private static String bgk = "";
    private static String bgl = "";
    private static int bgo = -1;
    private static boolean bgp = false;
    private static boolean bgq = false;
    private static boolean bgr = false;
    private static boolean bgs = false;
    private static boolean bgt = false;
    private static boolean bgu = false;
    private static String bgx = "";
    private static String bgy = "";
    public static String bgz = "";
    private static final List<String> bgA = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long TE() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains(BLPlatform.MEMTOTAL));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long TG() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long TH() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long TI() {
        long jFreeMemory;
        try {
            jFreeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (jFreeMemory > 0) {
            return jFreeMemory;
        }
        return 0L;
    }

    public static int TJ() {
        int i = bgv;
        if (i > 0) {
            return i;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        bgv = iAvailableProcessors;
        return iAvailableProcessors;
    }

    public static String TK() {
        return Build.MODEL;
    }

    public static synchronized long TL() {
        long j;
        j = (!bc.usePhoneStateDisable() || (TextUtils.isEmpty(bc.getDevImei()) && bc.getDevImeis() == null)) ? 0L : 1L;
        if (bc.readLocationDisable() && bc.Tf() != null) {
            j |= 64;
        }
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId())) {
            j |= 2;
        }
        if (bc.useMacAddressDisable() && !TextUtils.isEmpty(bc.getDevMacAddress())) {
            j |= 4;
        }
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            j |= 2048;
        }
        if (bc.readInstalledPackagesDisable()) {
            if (bc.getDevInstalledPackages() != null) {
                j |= 16;
            }
        }
        return j;
    }

    public static String TM() {
        return Build.BRAND;
    }

    public static String TN() {
        return Build.CPU_ABI;
    }

    public static synchronized long TO() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static synchronized long TP() {
        return Build.TIME;
    }

    public static synchronized String TQ() {
        return Build.FINGERPRINT;
    }

    public static synchronized String TR() {
        if (!TextUtils.isEmpty(bfZ)) {
            return bfZ;
        }
        String radioVersion = Build.getRadioVersion();
        bfZ = radioVersion;
        return radioVersion;
    }

    public static synchronized String TS() {
        return bb.getName();
    }

    public static synchronized String TT() {
        return bb.getVersion();
    }

    public static String TU() {
        return Build.MANUFACTURER;
    }

    public static int TV() {
        if (bgo == -1) {
            bgo = em(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return bgo;
    }

    public static String TW() {
        if (TextUtils.isEmpty(bgn)) {
            try {
                bgn = System.getProperty("os.arch");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return bgn;
    }

    public static int TX() {
        return Build.VERSION.SDK_INT;
    }

    public static String TY() {
        Enumeration<NetworkInterface> networkInterfaces;
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(bgz)) {
            return bgz;
        }
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (Throwable unused) {
        }
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                    String hostAddress = inetAddressNextElement.getHostAddress();
                    bgz = hostAddress;
                    return hostAddress;
                }
                return "";
            }
        }
        return "";
    }

    private static String TZ() {
        String strH = ag.h("ksadsdk_pref", "random_android_id", "");
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        String strUa = Ua();
        if (TextUtils.isEmpty(strUa)) {
            return "";
        }
        hP(strUa);
        ag.a("ksadsdk_pref", "random_android_id", strUa, true);
        return strUa;
    }

    private static String Ua() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Ub() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String strH = ag.h("ksadsdk_pref", "android_id", (String) null);
        ag.i(strH, "ksadsdk_pref", "android_id");
        return strH;
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String cr(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z && TextUtils.isEmpty(ef(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dj() : appOAID;
    }

    @SuppressLint({"HardwareIds"})
    public static String dB(Context context) {
        if (!TextUtils.isEmpty(bgl) || context == null || bgs) {
            return bgl;
        }
        if (bc.usePhoneStateDisable()) {
            return bc.getDevAndroidId();
        }
        if (!s.RH()) {
            return bgl;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            bgl = string;
            if (!hO(string)) {
                bgl = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(bgl)) {
            bgs = true;
        }
        return bgl;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dF(Context context) {
        if (context != null) {
            if (!bgq && TextUtils.isEmpty(bgj) && SystemUtil.dZ(context) && !bc.usePhoneStateDisable() && s.RO()) {
                try {
                    bgj = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                } catch (Exception unused) {
                }
                bgq = TextUtils.isEmpty(bgj);
                return bgj;
            }
        }
        return bgj;
    }

    public static long ea(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int ed(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long ee(Context context) throws Throwable {
        long j = bgw;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long jTE = memoryInfo.totalMem;
            if (jTE <= 0) {
                jTE = TE();
            }
            bgw = jTE;
            return jTE;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String ef(@Nullable Context context) {
        boolean zDZ;
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        if (bgp) {
            return bgc;
        }
        if (TextUtils.isEmpty(bgc) && context != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return bgc;
            }
            if (bc.usePhoneStateDisable()) {
                return bgc;
            }
            if (!s.RN()) {
                return bgc;
            }
            try {
                zDZ = SystemUtil.dZ(context);
                if (zDZ) {
                    try {
                        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        bgc = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            bgp = true;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zDZ) {
                            bgp = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zDZ = false;
            }
            return bgc;
        }
        return bgc;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String eg(@Nullable Context context) {
        boolean zDZ;
        if (bgu) {
            return bgd;
        }
        if (TextUtils.isEmpty(bgd) && context != null) {
            if (bc.usePhoneStateDisable()) {
                return bgd;
            }
            if (!s.RM()) {
                return bgl;
            }
            try {
                zDZ = SystemUtil.dZ(context);
                if (zDZ) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                String meid = telephonyManager.getMeid();
                                bgd = meid;
                                if (TextUtils.isEmpty(meid)) {
                                    bgu = true;
                                }
                            } else if (telephonyManager.getPhoneType() == 2) {
                                String deviceId = telephonyManager.getDeviceId();
                                bgd = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                    bgu = true;
                                }
                            } else {
                                bgd = null;
                                bgu = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zDZ) {
                            bgu = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zDZ = false;
            }
            return bgd;
        }
        return bgd;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] eh(@Nullable Context context) {
        if (bc.usePhoneStateDisable() && bc.getDevImeis() != null) {
            return bc.getDevImeis();
        }
        if (bgt) {
            return bgi;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return bgi;
        }
        String[] strArr = bgi;
        boolean z = false;
        if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
            if (bc.usePhoneStateDisable()) {
                return strArr;
            }
            if (!s.RN()) {
                return strArr;
            }
            try {
                boolean zDZ = SystemUtil.dZ(context);
                if (zDZ) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            if (i >= 26) {
                                int iMin = Math.min(ei(context), 2);
                                for (int i2 = 0; i2 < iMin; i2++) {
                                    bgi[i2] = telephonyManager.getImei(i2);
                                }
                                String[] strArr2 = bgi;
                                if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                    bgt = true;
                                }
                            } else if (telephonyManager.getPhoneType() == 1) {
                                if (i >= 23) {
                                    int iMin2 = Math.min(ei(context), 2);
                                    for (int i3 = 0; i3 < iMin2; i3++) {
                                        bgi[i3] = telephonyManager.getDeviceId(i3);
                                    }
                                } else {
                                    strArr[0] = telephonyManager.getDeviceId();
                                    strArr[1] = null;
                                }
                                String[] strArr3 = bgi;
                                if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                    bgt = true;
                                }
                            } else {
                                strArr[0] = null;
                                strArr[1] = null;
                                bgt = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        z = zDZ;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        if (z) {
                            bgt = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return bgi;
        }
        return strArr;
    }

    public static synchronized int ei(Context context) {
        if (bgf || bge > 0 || Build.VERSION.SDK_INT < 23 || context == null || bc.usePhoneStateDisable()) {
            return bge;
        }
        try {
            bge = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
        } catch (Exception unused) {
        }
        int i = bge;
        bgf = i == 0;
        return i;
    }

    @SuppressLint({"MissingPermission"})
    public static int ej(Context context) {
        if (context == null || bgg > 0 || bgh || Build.VERSION.SDK_INT < 22 || !SystemUtil.dZ(context) || bc.usePhoneStateDisable()) {
            return bgg;
        }
        try {
            bgg = qr6.a(context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        int i = bgg;
        bgh = i != 0;
        return i;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String ek(Context context) {
        if (!TextUtils.isEmpty(bgk) || context == null) {
            return bgk;
        }
        if (bgr) {
            return bgk;
        }
        if (bc.usePhoneStateDisable()) {
            return bgk;
        }
        if (!s.RP()) {
            return bgk;
        }
        try {
            if (SystemUtil.dZ(context)) {
                bgk = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            bgk = null;
        }
        if (TextUtils.isEmpty(bgk)) {
            bgr = true;
        }
        String str = TextUtils.isEmpty(bgk) ? "" : bgk;
        bgk = str;
        return str;
    }

    public static synchronized int el(Context context) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return ((AudioManager) context.getSystemService("audio")).getRingerMode();
    }

    private static boolean em(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String en(@Nullable Context context) {
        if (TextUtils.isEmpty(bga) && context != null && !bgb) {
            if (bc.useMacAddressDisable()) {
                String devMacAddress = bc.getDevMacAddress();
                bga = devMacAddress;
                return devMacAddress;
            }
            if (!s.RI()) {
                return bga;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    bga = connectionInfo.getMacAddress();
                }
                if (hM(bga)) {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b : hardwareAddress) {
                                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                bga = sb.toString();
                            }
                        }
                    }
                }
                if (hM(bga)) {
                    bga = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                }
                if (!hM(bga)) {
                    bga = bga.toUpperCase(Locale.US);
                }
            } catch (Exception unused) {
                bgb = true;
            }
            bgb = hM(bga);
            return bga;
        }
        return bga;
    }

    @Nullable
    public static List<String> eo(@NonNull Context context) {
        String[] list;
        if (d.cA(context)) {
            return new ArrayList();
        }
        if (!ep(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean ep(@NonNull Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30) {
                return false;
            }
            if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.j) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Pair<Boolean, Boolean> eq(Context context) {
        boolean z;
        boolean zIsEnabled;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            zIsEnabled = accessibilityManager.isEnabled();
            try {
                z = accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty() ? false : true;
            } catch (Throwable th) {
                th = th;
                z = zIsEnabled;
                z = false;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            return new Pair<>(Boolean.valueOf(zIsEnabled), Boolean.valueOf(z));
        } catch (Throwable th3) {
            th = th3;
            z = z;
            z = zIsEnabled;
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z));
        }
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(bgm)) {
            return bgm;
        }
        String strUb = Ub();
        if (!TextUtils.isEmpty(strUb)) {
            String str = "ANDROID_" + strUb;
            bgm = str;
            return str;
        }
        String strDB = dB(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(strDB) && !hN(strDB) && hO(strDB)) {
            String str2 = "ANDROID_" + strDB;
            bgm = str2;
            return str2;
        }
        String strTZ = TZ();
        if (!TextUtils.isEmpty(strTZ)) {
            String str3 = "ANDROID_" + strTZ;
            bgm = str3;
            return str3;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            return (bounds.height() - insets.top) - insets.bottom;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            return (bounds.width() - insets.left) - insets.right;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean hM(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean hN(String str) {
        return bgA.contains(str.toLowerCase(Locale.US));
    }

    private static boolean hO(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void hP(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ag.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String hQ(String str) {
        StructStat structStatStat;
        String strValueOf;
        if (!TextUtils.isEmpty(bgy) || TextUtils.isEmpty(str)) {
            return bgy;
        }
        int i = Build.VERSION.SDK_INT;
        try {
            structStatStat = Os.stat(str);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (structStatStat == null) {
            return bgy;
        }
        String strValueOf2 = "";
        if (i >= 27) {
            if (structStatStat.st_atim == null) {
                strValueOf = "";
            } else {
                strValueOf2 = String.valueOf(structStatStat.st_atim.tv_sec);
                strValueOf = String.valueOf(structStatStat.st_atim.tv_nsec);
            }
            bgy = strValueOf2 + "." + strValueOf;
        } else {
            long j = structStatStat.st_atime;
            if (j != 0) {
                strValueOf2 = String.valueOf(j);
            }
            bgy = strValueOf2;
        }
        return bgy;
    }

    public static String z(@Nullable Context context, boolean z) {
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        String strEf = ef(context);
        return (TextUtils.isEmpty(strEf) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Di() : strEf;
    }
}
