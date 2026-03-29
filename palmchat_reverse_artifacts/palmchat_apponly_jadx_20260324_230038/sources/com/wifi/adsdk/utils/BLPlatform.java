package com.wifi.adsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.kuaishou.weapon.p0.g;
import com.oplus.tblplayer.misc.MediaInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BLPlatform {
    public static final int DEVICEINFO_UNKNOWN = -1;
    private static final int INVALID = 0;
    private static final String KEY_MAGIC_UI_VERSION = "ro.build.version.magic";
    private static final String KEY_ROM_VERSION = "ro.build.display.id";
    public static final String MEMTOTAL = "MemTotal";
    private static final String MEM_INFO_PATH = "/proc/meminfo";
    public static final String OPPO_APPSTORE_PN = "com.heytap.market";
    public static final String VIVO_APPSTORE_PN = "com.bbk.appstore";
    public static final String VIVO_BROWSER_PN = "com.vivo.browser";
    private static int appVerCode = -1;
    private static String appVerName = "";
    private static ArrayList<String> mInstalledAppPackages;
    private static TelephonyManager mTelManager;
    private static NetworkInfo networkInfo;
    private static Point sizeScreenPoint;
    private static TelephonyManager telephonyManager;

    public static String convertIsp(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (telephonyManager == null) {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            }
            TelephonyManager telephonyManager2 = telephonyManager;
            if (telephonyManager2 != null) {
                return telephonyManager2.getSimOperator();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int convertIspToNativeCode(Context context, String str) {
        if (context == null) {
            return 0;
        }
        str.hashCode();
        switch (str) {
        }
        return 0;
    }

    private static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return "unknow";
        }
    }

    public static String getAndroidID(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "" : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getAndroidVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static String getAppStoreVersion(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode + "";
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static int getAppVersionCode(Context context) {
        int i = appVerCode;
        if (i != -1) {
            return i;
        }
        try {
            appVerCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
        }
        return appVerCode;
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(appVerName)) {
            return appVerName;
        }
        try {
            appVerName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
        }
        return appVerName;
    }

    public static String getBootMark() {
        FileInputStream fileInputStream;
        String strTrim = "";
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    strTrim = new BufferedReader(new InputStreamReader(fileInputStream)).readLine().trim();
                    try {
                        strTrim = strTrim.substring(0, 36);
                    } catch (Throwable unused2) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (IOException unused3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                    return strTrim;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        return strTrim;
    }

    public static String getDeviceMAC(Context context) {
        return MacUtil.getMacAdress(context);
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static int getDeviceMode() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION);
            if (!TextUtils.isEmpty(str) && (str.contains("MagicUI") || str.contains("MagicOS"))) {
                return 2;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("EmotionUI")) {
                    return -1;
                }
            }
            return 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getHonorHuaweiType() {
        return !TextUtils.isEmpty(LxAdOSUtils.getProp(LxAdEmuiDevice.PROP_VERSION)) ? Build.MANUFACTURER.equalsIgnoreCase("HONOR") ? "HONOR" : "HUAWEI" : "OTHER";
    }

    public static String getHonorRomVersion() {
        return get(KEY_ROM_VERSION);
    }

    public static ArrayList<String> getInstalledApplications(Context context) {
        ArrayList<String> arrayList = mInstalledAppPackages;
        if (arrayList != null && !arrayList.isEmpty()) {
            return mInstalledAppPackages;
        }
        mInstalledAppPackages = new ArrayList<>();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(128)) {
                int i = packageInfo.applicationInfo.flags;
                if ((i & 128) != 0 || (i & 1) == 0) {
                    mInstalledAppPackages.add(packageInfo.packageName);
                }
            }
            return mInstalledAppPackages;
        } catch (Exception unused) {
            return mInstalledAppPackages;
        }
    }

    public static String getMagicUiVersion() {
        return get(KEY_MAGIC_UI_VERSION);
    }

    public static long getMemFree(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    private static long getMemInfoType(String str) {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(MEM_INFO_PATH), 4096);
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
            } while (!line.contains(str));
            bufferedReader.close();
            return Integer.valueOf(line.split("\\s+")[1]).intValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int getNetworkType(Context context) {
        try {
            if (networkInfo == null) {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            NetworkInfo networkInfo2 = networkInfo;
            if (networkInfo2 != null) {
                return networkInfo2.getType() == 0 ? getNetworkTypeLevel(networkInfo) : networkInfo.getType() == 1 ? 100 : 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getNetworkTypeLevel(NetworkInfo networkInfo2) {
        if (networkInfo2 == null || !networkInfo2.isConnected() || networkInfo2.getType() != 0) {
            return 0;
        }
        String subtypeName = networkInfo2.getSubtypeName();
        int subtype = networkInfo2.getSubtype();
        if (subtype == 20) {
            return 5;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 0;
        }
    }

    private static String getOPPOROMVersion() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {LxAdOppoDevice.PROP_VERSION, "ro.oppo.version", "ro.build.version.coloros"};
            for (int i = 0; i < 3; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        } catch (Exception unused) {
        }
        String str2 = Build.DISPLAY;
        return !TextUtils.isEmpty(str2) ? str2 : MediaInfo.RENDERER_TYPE_UNKNOWN;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPhoneIMEI(Context context) {
        if (!hasPermission(g.c, context)) {
            return "";
        }
        String deviceId = null;
        try {
            TelephonyManager telephonyManager2 = getTelephonyManager(context);
            if (telephonyManager2 != null) {
                deviceId = telephonyManager2.getDeviceId();
            }
        } catch (Exception unused) {
        }
        return deviceId != null ? deviceId : "";
    }

    public static long getRamSize(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            activityManager.getProcessMemoryInfo(new int[]{0});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / 1024;
        } catch (Throwable unused) {
            return getMemInfoType(MEMTOTAL);
        }
    }

    public static long getRomSize(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1024;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static Point getScreenSize(Context context) {
        Point point = sizeScreenPoint;
        if (point != null) {
            return point;
        }
        sizeScreenPoint = new Point();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point2);
            Point point3 = sizeScreenPoint;
            point3.x = point2.x;
            point3.y = point2.y;
        } catch (Exception unused) {
        }
        return sizeScreenPoint;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getSysRom() {
        try {
            if (!isVivoPhone()) {
                return isOppo() ? getOPPOROMVersion() : isHonor() ? getHonorRomVersion() : "unknow";
            }
            return getSysVersionNameString() + getSysVersionNameCodeString();
        } catch (Exception unused) {
            return "unknow";
        }
    }

    private static String getSysVersionNameCodeString() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.version").getInputStream()));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return line;
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private static String getSysVersionNameString() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.name").getInputStream()));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return line;
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (mTelManager == null) {
            mTelManager = (TelephonyManager) context.getSystemService("phone");
        }
        return mTelManager;
    }

    public static String getUpdateMark() {
        try {
            int i = Build.VERSION.SDK_INT;
            StructStat structStatStat = Os.stat("/data/data");
            if (i < 27) {
                return structStatStat.st_atime + ".0";
            }
            StructTimespec structTimespec = structStatStat.st_atim;
            return structTimespec.tv_sec + "." + structTimespec.tv_nsec;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean hasPermission(String str, Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }

    public static boolean isHonor() {
        return "HONOR".equals(getHonorHuaweiType());
    }

    public static boolean isOppo() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.toLowerCase().contains("oppo");
    }

    public static boolean isVivoPhone() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public static void startTextActivity(String str, String str2, Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) LxAdAllTextActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (TextUtils.isEmpty(str)) {
                str = "暂无内容";
            }
            intent.putExtra("url", str);
            intent.putExtra("title", str2);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
