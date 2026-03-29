package com.tencent.matrix.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DeviceUtil {
    private static final String CPU_FILE_PATH_0 = "/sys/devices/system/cpu/";
    private static final String CPU_FILE_PATH_1 = "/sys/devices/system/cpu/possible";
    private static final String CPU_FILE_PATH_2 = "/sys/devices/system/cpu/present";
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.tencent.matrix.util.DeviceUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static final String DEVICE_CPU = "cpu_app";
    public static final String DEVICE_MACHINE = "machine";
    private static final String DEVICE_MEMORY = "mem";
    private static final String DEVICE_MEMORY_FREE = "mem_free";
    private static final int INVALID = 0;
    private static final long MB = 1048576;
    private static final String MEMORY_FILE_PATH = "/proc/meminfo";
    private static final String TAG = "Matrix.DeviceUtil";
    private static LEVEL sLevelCache;
    private static long sLowMemoryThresold;
    private static int sMemoryClass;
    private static long sTotalMemory;

    /* JADX INFO: compiled from: SearchBox */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return sb.toString();
                    }
                    sb.append(line);
                    sb.append('\n');
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double getAppCpuRate() throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        long j;
        Throwable th2;
        long j2;
        RandomAccessFile randomAccessFile2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        RandomAccessFile randomAccessFile3 = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/stat", t.k);
            try {
                try {
                    String[] strArrSplit = randomAccessFile.readLine().split(" ");
                    j = Long.parseLong(strArrSplit[2]) + Long.parseLong(strArrSplit[3]) + Long.parseLong(strArrSplit[4]) + Long.parseLong(strArrSplit[5]) + Long.parseLong(strArrSplit[6]) + Long.parseLong(strArrSplit[7]) + Long.parseLong(strArrSplit[8]);
                    try {
                        randomAccessFile.close();
                    } catch (Exception e) {
                        MatrixLog.i(TAG, "close process reader %s", e.toString());
                    }
                } catch (Exception e2) {
                    e = e2;
                    MatrixLog.i(TAG, "RandomAccessFile(Process Stat) reader fail, error: %s", e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            MatrixLog.i(TAG, "close process reader %s", e3.toString());
                        }
                    }
                    j = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile3 = randomAccessFile;
                if (randomAccessFile3 != null) {
                    throw th;
                }
                try {
                    randomAccessFile3.close();
                    throw th;
                } catch (Exception e4) {
                    MatrixLog.i(TAG, "close process reader %s", e4.toString());
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th4) {
            th = th4;
            if (randomAccessFile3 != null) {
            }
        }
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + getAppId() + SysPerformanceCollector.APP_CPU_INFO_FILE, t.k);
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th5) {
            th2 = th5;
        }
        try {
            String[] strArrSplit2 = randomAccessFile2.readLine().split(" ");
            j2 = Long.parseLong(strArrSplit2[13]) + Long.parseLong(strArrSplit2[14]);
            try {
                randomAccessFile2.close();
            } catch (Exception e7) {
                MatrixLog.i(TAG, "close app reader %s", e7.toString());
            }
        } catch (Exception e8) {
            e = e8;
            randomAccessFile3 = randomAccessFile2;
            MatrixLog.i(TAG, "RandomAccessFile(App Stat) reader fail, error: %s", e.toString());
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                } catch (Exception e9) {
                    MatrixLog.i(TAG, "close app reader %s", e9.toString());
                }
            }
            j2 = 0;
        } catch (Throwable th6) {
            th2 = th6;
            randomAccessFile3 = randomAccessFile2;
            if (randomAccessFile3 == null) {
                throw th2;
            }
            try {
                randomAccessFile3.close();
                throw th2;
            } catch (Exception e10) {
                MatrixLog.i(TAG, "close app reader %s", e10.toString());
                throw th2;
            }
        }
        double d = 0 != j ? (j2 / j) * 100.0d : 0.0d;
        MatrixLog.i(TAG, "getAppCpuRate cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + ",rate:" + d, new Object[0]);
        return d;
    }

    private static int getAppId() {
        return Process.myPid();
    }

    public static Debug.MemoryInfo getAppMemory(Context context) {
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{getAppId()});
            if (processMemoryInfo.length > 0) {
                return processMemoryInfo[0];
            }
            return null;
        } catch (Exception e) {
            MatrixLog.i(TAG, "getProcessMemoryInfo fail, error: %s", e.toString());
            return null;
        }
    }

    public static long getAvailMemory(Context context) {
        return Runtime.getRuntime().freeMemory() / 1024;
    }

    private static int getCoresFromCPUFiles(String str) {
        File[] fileArrListFiles = new File(str).listFiles(CPU_FILTER);
        if (fileArrListFiles == null) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    private static int getCoresFromFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            if (line != null && line.matches("0-[\\d]+$")) {
                int i = Integer.parseInt(line.substring(2)) + 1;
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e2.toString());
                }
                return i;
            }
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e3.toString());
            }
            return 0;
        } catch (IOException e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e5.toString());
                }
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e6.toString());
                }
            }
            throw th;
        }
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static JSONObject getDeviceInfo(JSONObject jSONObject, Application application) {
        try {
            jSONObject.put(DEVICE_MACHINE, getLevel(application));
            jSONObject.put(DEVICE_CPU, getAppCpuRate());
            jSONObject.put(DEVICE_MEMORY, getTotalMemory(application));
            jSONObject.put(DEVICE_MEMORY_FREE, getMemFree(application));
        } catch (JSONException e) {
            MatrixLog.e(TAG, "[JSONException for stack, error: %s", e);
        }
        return jSONObject;
    }

    public static LEVEL getLevel(Context context) throws Throwable {
        LEVEL level = sLevelCache;
        if (level != null) {
            return level;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long totalMemory = getTotalMemory(context);
        int numOfCores = getNumOfCores();
        MatrixLog.i(TAG, "[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(totalMemory), Integer.valueOf(numOfCores));
        if (totalMemory >= 8589934592L) {
            sLevelCache = LEVEL.BEST;
        } else if (totalMemory >= 6442450944L) {
            sLevelCache = LEVEL.HIGH;
        } else if (totalMemory >= 4294967296L) {
            sLevelCache = LEVEL.MIDDLE;
        } else if (totalMemory >= 2147483648L) {
            if (numOfCores >= 4) {
                sLevelCache = LEVEL.MIDDLE;
            } else if (numOfCores > 0) {
                sLevelCache = LEVEL.LOW;
            }
        } else if (totalMemory >= 0) {
            sLevelCache = LEVEL.BAD;
        } else {
            sLevelCache = LEVEL.UN_KNOW;
        }
        MatrixLog.i(TAG, "getLevel, cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + ", level:" + sLevelCache, new Object[0]);
        return sLevelCache;
    }

    public static long getLowMemoryThresold(Context context) {
        long j = sLowMemoryThresold;
        if (0 != j) {
            return j;
        }
        getTotalMemory(context);
        return sLowMemoryThresold;
    }

    public static long getMemFree(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static int getMemoryClass(Context context) {
        int i = sMemoryClass;
        if (i != 0) {
            return i * 1024;
        }
        getTotalMemory(context);
        return sMemoryClass * 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    private static int getNumOfCores() throws Throwable {
        int coresFromFile;
        try {
            coresFromFile = getCoresFromFile(CPU_FILE_PATH_1);
            if (coresFromFile == 0) {
                coresFromFile = getCoresFromFile(CPU_FILE_PATH_2);
            }
            if (coresFromFile == 0) {
                coresFromFile = getCoresFromCPUFiles(CPU_FILE_PATH_0);
            }
        } catch (Exception unused) {
            coresFromFile = 0;
        }
        if (coresFromFile == 0) {
            return 1;
        }
        return coresFromFile;
    }

    public static String getStringFromFile(String str) throws Exception {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String strConvertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                return strConvertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static long getTotalMemory(Context context) {
        long j = sTotalMemory;
        if (0 != j) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        activityManager.getMemoryInfo(memoryInfo);
        sTotalMemory = memoryInfo.totalMem;
        sLowMemoryThresold = memoryInfo.threshold;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory == Long.MAX_VALUE) {
            sMemoryClass = activityManager.getMemoryClass();
        } else {
            sMemoryClass = (int) (jMaxMemory / 1048576);
        }
        MatrixLog.i(TAG, "getTotalMemory cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + ", total_mem:" + sTotalMemory + ", LowMemoryThresold:" + sLowMemoryThresold + ", Memory Class:" + sMemoryClass, new Object[0]);
        return sTotalMemory;
    }

    public static long getVmSize() {
        try {
            String[] strArrSplit = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(getAppId()))).trim().split("\n");
            for (String str : strArrSplit) {
                if (str.startsWith("VmSize")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
            }
            if (strArrSplit.length > 12) {
                Matcher matcher2 = Pattern.compile("\\d+").matcher(strArrSplit[12]);
                if (matcher2.find()) {
                    return Long.parseLong(matcher2.group());
                }
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public static boolean is64BitRuntime() {
        String str = Build.CPU_ABI;
        return "arm64-v8a".equalsIgnoreCase(str) || "x86_64".equalsIgnoreCase(str) || "mips64".equalsIgnoreCase(str);
    }

    public static boolean isLowMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }
}
