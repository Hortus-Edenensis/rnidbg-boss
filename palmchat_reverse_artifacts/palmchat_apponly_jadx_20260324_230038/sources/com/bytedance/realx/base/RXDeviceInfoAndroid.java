package com.bytedance.realx.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.umeng.analytics.pro.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RXDeviceInfoAndroid {
    public static final int BUFFER_SIZE = 8192;
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.bytedance.realx.base.RXDeviceInfoAndroid.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(bt.w)) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String CPU_MANUFACTURER_PATTERN = "Hardware[\\s]*:[\\s]*([\\S\\s]*)\n";
    public static final int DEVICE_INFO_UNKNOWN = -1;
    private static final int ERROR_RESULT = -1;
    private static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
    private static String RomVersion = "";
    private static final String TAG = "DeviceInfo";
    private static String sCpuModel = "";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream, java.lang.Process] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String GetCpuModel() throws Throwable {
        Process processStart;
        StringBuilder sb;
        if (!sCpuModel.isEmpty()) {
            return sCpuModel;
        }
        String strGroup = "";
        ?? inputStream = 0;
        inputStream = 0;
        try {
            try {
                processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
                try {
                    inputStream = processStart.getInputStream();
                    if (inputStream != 0) {
                        Scanner scanner = new Scanner((InputStream) inputStream, "UTF-8");
                        if (scanner.findWithinHorizon(CPU_MANUFACTURER_PATTERN, 3000) != null) {
                            MatchResult matchResultMatch = scanner.match();
                            if (matchResultMatch.groupCount() > 0) {
                                try {
                                    strGroup = matchResultMatch.group(1);
                                } catch (NumberFormatException e) {
                                    Log.i(TAG, "GetCpuModel NumberFormatException:" + e.getMessage());
                                }
                            }
                        }
                        scanner.close();
                    }
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            Log.i(TAG, "GetCpuModel close input stream fail:" + e2.getMessage());
                        }
                    }
                    try {
                        processStart.destroy();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("GetCpuModel close process fail:");
                        sb.append(e.getMessage());
                        Log.i(TAG, sb.toString());
                    }
                } catch (IOException e4) {
                    e = e4;
                    Log.i(TAG, "GetCpuModel IOException:" + e.getMessage());
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            Log.i(TAG, "GetCpuModel close input stream fail:" + e5.getMessage());
                        }
                    }
                    if (processStart != null) {
                        try {
                            processStart.destroy();
                        } catch (Exception e6) {
                            e = e6;
                            sb = new StringBuilder();
                            sb.append("GetCpuModel close process fail:");
                            sb.append(e.getMessage());
                            Log.i(TAG, sb.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                        Log.i(TAG, "GetCpuModel close input stream fail:" + e7.getMessage());
                    }
                }
                if (0 != 0) {
                    throw th;
                }
                try {
                    inputStream.destroy();
                    throw th;
                } catch (Exception e8) {
                    Log.i(TAG, "GetCpuModel close process fail:" + e8.getMessage());
                    throw th;
                }
            }
        } catch (IOException e9) {
            e = e9;
            processStart = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
        }
        if (strGroup.isEmpty() && Build.VERSION.SDK_INT >= 31) {
            strGroup = Build.SOC_MODEL;
        }
        sCpuModel = strGroup;
        return strGroup;
    }

    public static String GetDeviceBrand() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str;
    }

    public static String GetDeviceModel() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    private static int extractValue(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public static String getAndroidBuildId() {
        return Build.ID;
    }

    public static String getAppRootPath() {
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            return applicationContext == null ? "" : applicationContext.getFilesDir().getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildRelease() {
        return Build.VERSION.RELEASE;
    }

    public static String getBuildType() {
        return Build.TYPE;
    }

    public static int getCPUMaxFrequency() {
        int i = -1;
        int iIntValue = -1;
        for (int i2 = 0; i2 < getNumberOfCPUCores(); i2++) {
            try {
                File file = new File(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i2 + SysPerformanceCollector.SYS_CPU_MAX_FREQ_FILE);
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            int i3 = fileInputStream.read(bArr);
                            if (i3 == -1 || i3 > 128) {
                                throw new NumberFormatException();
                            }
                            int i4 = 0;
                            while (Character.isDigit(bArr[i4]) && i4 < 128) {
                                i4++;
                            }
                            Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i4, "UTF-8")));
                            if (numValueOf.intValue() > iIntValue) {
                                iIntValue = numValueOf.intValue();
                            }
                        } catch (NumberFormatException e) {
                            Log.e(TAG, "getCPUMaxFrequency failed!", e);
                        }
                    } finally {
                        fileInputStream.close();
                    }
                }
            } catch (IOException unused) {
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int fileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (fileForValue > iIntValue) {
                    iIntValue = fileForValue;
                }
                fileInputStream2.close();
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        i = iIntValue;
        return i / 1000;
    }

    private static int getCoresFromFileInfo(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int coresFromFileString = getCoresFromFileString(line);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return coresFromFileString;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return -1;
                }
                try {
                    fileInputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    public static String getCpuName() throws Throwable {
        String strGetCpuModel = GetCpuModel();
        if (strGetCpuModel != null && !strGetCpuModel.isEmpty()) {
            return strGetCpuModel + x.aQ + Build.HARDWARE;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return Build.HARDWARE;
        }
        return Build.SOC_MODEL + x.aQ + Build.HARDWARE;
    }

    public static int getCpuThreads() {
        return getNumberOfCPUCores();
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getGpuName() {
        String gPURenderer = Build.VERSION.SDK_INT >= 22 ? GPUUtil.getGPURenderer() : GPUUtil.getGPURendererFallback();
        return gPURenderer == null ? "null-null" : gPURenderer;
    }

    public static int getMemSize() {
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            if (applicationContext == null) {
                return -1;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
            if (activityManager == null) {
                return -1;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return (int) Math.ceil((((memoryInfo.totalMem * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
        } catch (Exception e) {
            e.printStackTrace();
            return (int) Math.ceil(((((-1) * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
        }
    }

    public static int getNumberOfCPUCores() {
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo != -1) {
                return coresFromFileInfo;
            }
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
            if (fileArrListFiles != null) {
                return fileArrListFiles.length;
            }
            return -1;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static String getRomVersionName() {
        if (TextUtils.isEmpty(RomVersion)) {
            RomVersion = RXDeviceUtil.getPhoneSystem(Build.BRAND);
        }
        return RomVersion;
    }

    public static String getSdkVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getSystemDefaultLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r7 = r1[1];
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0045 -> B:65:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getValueFromCpuInfoFile(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/cpuinfo");
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, Charset.defaultCharset()));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line != null) {
                                    if (line.contains(":")) {
                                        String[] strArrSplit = line.split(":");
                                        if (strArrSplit.length > 1 && strArrSplit[0].contains(str)) {
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileInputStream == null) {
                                    throw th;
                                }
                                try {
                                    fileInputStream.close();
                                    throw th;
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        fileInputStream.close();
                        break;
                    } catch (Exception e6) {
                        e = e6;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return str2;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                byte b = bArr[i2];
                if (b == 10 || i2 == 0) {
                    if (b == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < i; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            break;
                        }
                        if (i4 == str.length() - 1) {
                            return extractValue(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }
}
