package com.oplus.tblplayer.monitor.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SysPerformanceCollector {
    public static final int APP_CPU_CSTIME_INDEX = 16;
    public static final int APP_CPU_CUTIME_INDEX = 15;
    public static final String APP_CPU_INFO_FILE = "/stat";
    public static final String APP_CPU_INFO_ROOT_PATH = "/proc/";
    public static final String APP_CPU_INFO_SEPARATOR = " ";
    public static final int APP_CPU_STIME_INDEX = 14;
    public static final int APP_CPU_UTIME_INDEX = 13;
    public static final int BYTES_IN_KB = 1024;
    public static final int MS_IN_ONE_SECOND = 1000;
    public static final int PERCENTAGE_COEFFICIENT = 100;
    public static final String SYS_CPU_CUR_FREQ_FILE = "/cpufreq/scaling_cur_freq";
    public static final String SYS_CPU_INFO_ROOT_PATH = "/sys/devices/system/cpu/cpu";
    public static final String SYS_CPU_MAX_FREQ_FILE = "/cpufreq/cpuinfo_max_freq";
    private static final String TAG = "SysPerformanceCollector";
    private Context mAppContext;
    private long mAppLastUsedJiffies = 0;
    private long mLastCollectAppCpuTime = 0;
    private int mSysConfigHz;

    /* JADX INFO: compiled from: SearchBox */
    public static class SysPerformanceWrapper {
        public int mCpuUsedAll;
        public int mCpuUsedApp;
        public int mMemUsedApp;
    }

    public SysPerformanceCollector(Context context, int i) {
        this.mAppContext = context;
        this.mSysConfigHz = i;
        LogUtil.d(TAG, "SysPerformanceCollector sysConfigHz:" + i);
    }

    private String[] getAppCpuStat(String str) {
        String cpuInfoFile = readCpuInfoFile(str);
        if (!TextUtils.isEmpty(cpuInfoFile)) {
            return cpuInfoFile.split(" ");
        }
        LogUtil.w(TAG, "getAppCpuStat failed, appCpuStat is empty");
        return null;
    }

    private long getAppCpuTime() {
        try {
            String[] appCpuStat = getAppCpuStat(APP_CPU_INFO_ROOT_PATH + Process.myPid() + APP_CPU_INFO_FILE);
            if (appCpuStat != null && appCpuStat.length > 16) {
                return Long.parseLong(appCpuStat[13]) + Long.parseLong(appCpuStat[14]) + Long.parseLong(appCpuStat[15]) + Long.parseLong(appCpuStat[16]);
            }
            LogUtil.w(TAG, "getAppCpuUsage failed, cannot get cpuStatInfo");
            return -1L;
        } catch (Exception e) {
            LogUtil.w(TAG, "getAppCpuUsage encounter exception: " + e.getMessage());
            return 0L;
        }
    }

    private int readCpuInfo(String str) {
        try {
            String cpuInfoFile = readCpuInfoFile(str);
            if (!TextUtils.isEmpty(cpuInfoFile)) {
                return Integer.parseInt(cpuInfoFile);
            }
            LogUtil.w(TAG, "readCpuInfo failed, cpuInfo is empty");
            return -1;
        } catch (NumberFormatException e) {
            LogUtil.w(TAG, "readCpuInfo encounter exception: " + e.getMessage());
            return -1;
        }
    }

    private String readCpuInfoFile(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "readCpuInfoFile failed, filePath is empty";
        } else {
            try {
                File file = new File(str);
                if (file.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    return line;
                }
                LogUtil.w(TAG, "readCpuInfoFile failed, can not read cpuInfoFile, cpuInfoFilePath:" + str);
                return null;
            } catch (Exception e) {
                str2 = "readCpuInfoFile encounter exception: " + e.getMessage();
            }
        }
        LogUtil.w(TAG, str2);
        return null;
    }

    public final int getAppCpuUsage() {
        if (this.mSysConfigHz <= 0) {
            LogUtil.w(TAG, "getAppCpuUsage failed, mSysConfigHz <= 0");
            return -1;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iAvailableProcessors <= 0) {
            LogUtil.w(TAG, "getAppCpuUsage failed, cannot get availableProcessors");
            return -1;
        }
        long appCpuTime = getAppCpuTime();
        if (appCpuTime <= 0) {
            LogUtil.w(TAG, "getAppCpuUsage failed, usedJiffies:" + appCpuTime);
            return -1;
        }
        if (0 == this.mAppLastUsedJiffies || 0 == this.mLastCollectAppCpuTime) {
            this.mAppLastUsedJiffies = appCpuTime;
            this.mLastCollectAppCpuTime = System.currentTimeMillis();
            return 0;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.mLastCollectAppCpuTime) / 1000.0f;
        LogUtil.d(TAG, "getAppCpuUsage intervalTimeInS:" + fCurrentTimeMillis);
        if (0.0f == fCurrentTimeMillis) {
            LogUtil.w(TAG, "getAppCpuUsage failed, intervalTimeInS is 0");
            return 0;
        }
        int i = (int) ((((appCpuTime - this.mAppLastUsedJiffies) * 100) / ((long) this.mSysConfigHz)) / fCurrentTimeMillis);
        this.mAppLastUsedJiffies = appCpuTime;
        this.mLastCollectAppCpuTime = System.currentTimeMillis();
        return i / iAvailableProcessors;
    }

    public final int getCpuUsage() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long cpuInfo = 0;
        long cpuInfo2 = 0;
        for (int i = 0; i < iAvailableProcessors; i++) {
            if (new File(SYS_CPU_INFO_ROOT_PATH + i).exists()) {
                cpuInfo += (long) readCpuInfo(SYS_CPU_INFO_ROOT_PATH + i + SYS_CPU_MAX_FREQ_FILE);
                cpuInfo2 += (long) readCpuInfo(SYS_CPU_INFO_ROOT_PATH + i + SYS_CPU_CUR_FREQ_FILE);
            } else {
                LogUtil.w(TAG, "Can not find cpu info file of processor #" + i);
            }
        }
        if (0 != cpuInfo) {
            return (int) ((cpuInfo2 * 100.0d) / cpuInfo);
        }
        LogUtil.w(TAG, "getCpuUsage failed, cpuMaxFreq is 0");
        return -1;
    }

    public final int getMemUsage() {
        String str;
        if (this.mAppContext == null) {
            str = "getMemUsage abort, mAppContext is null";
        } else {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) this.mAppContext.getSystemService("activity");
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return (int) (((((long) activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss()) * 100) * 1024) / memoryInfo.totalMem);
            }
            str = "getMemUsage failed, cannot get memInfo.totalMem";
        }
        LogUtil.w(TAG, str);
        return -1;
    }

    public SysPerformanceWrapper getSysPerformance() {
        SysPerformanceWrapper sysPerformanceWrapper = new SysPerformanceWrapper();
        sysPerformanceWrapper.mCpuUsedAll = getCpuUsage();
        sysPerformanceWrapper.mCpuUsedApp = getAppCpuUsage();
        sysPerformanceWrapper.mMemUsedApp = getMemUsage();
        return sysPerformanceWrapper;
    }
}
