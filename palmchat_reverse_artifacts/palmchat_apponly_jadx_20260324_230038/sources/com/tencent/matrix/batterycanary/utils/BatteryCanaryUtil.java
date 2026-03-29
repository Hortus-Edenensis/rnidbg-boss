package com.tencent.matrix.batterycanary.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryMonitorPlugin;
import com.tencent.matrix.util.MatrixLog;
import com.umeng.ccg.a;
import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class BatteryCanaryUtil {
    private static final int DEFAULT_AMS_CACHE_MILLIS = 5000;
    private static final int DEFAULT_MAX_STACK_LAYER = 10;
    public static final int ONE_MIN = 60000;
    private static final String TAG = "Matrix.battery.Utils";
    static Proxy sCacheStub = new Proxy() { // from class: com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.1
        private Proxy.ExpireRef mLastAppStat;
        private Proxy.ExpireRef mLastDevStat;
        private String mPackageName;
        private String mProcessName;

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public int getAppStat(Context context, boolean z) {
            if (z) {
                return 1;
            }
            Proxy.ExpireRef expireRef = this.mLastAppStat;
            if (expireRef != null && !expireRef.isExpired()) {
                return this.mLastAppStat.value;
            }
            Proxy.ExpireRef expireRef2 = new Proxy.ExpireRef(BatteryCanaryUtil.getAppStatImmediately(context, false), 5000L);
            this.mLastAppStat = expireRef2;
            return expireRef2.value;
        }

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public int getDevStat(Context context) {
            Proxy.ExpireRef expireRef = this.mLastDevStat;
            if (expireRef != null && !expireRef.isExpired()) {
                return this.mLastDevStat.value;
            }
            Proxy.ExpireRef expireRef2 = new Proxy.ExpireRef(BatteryCanaryUtil.getDeviceStatImmediately(context), 5000L);
            this.mLastDevStat = expireRef2;
            return expireRef2.value;
        }

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public String getPackageName() {
            if (!TextUtils.isEmpty(this.mPackageName)) {
                return this.mPackageName;
            }
            BatteryMonitorPlugin batteryMonitorPlugin = (BatteryMonitorPlugin) Matrix.with().getPluginByClass(BatteryMonitorPlugin.class);
            if (batteryMonitorPlugin == null) {
                throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
            }
            String packageName = batteryMonitorPlugin.getPackageName();
            this.mPackageName = packageName;
            return packageName;
        }

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public String getProcessName() {
            if (!TextUtils.isEmpty(this.mProcessName)) {
                return this.mProcessName;
            }
            BatteryMonitorPlugin batteryMonitorPlugin = (BatteryMonitorPlugin) Matrix.with().getPluginByClass(BatteryMonitorPlugin.class);
            if (batteryMonitorPlugin == null) {
                throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
            }
            String processName = batteryMonitorPlugin.getProcessName();
            this.mProcessName = processName;
            return processName;
        }

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public void updateAppStat(int i) {
            synchronized (this) {
                this.mLastAppStat = new Proxy.ExpireRef(i, 5000L);
            }
        }

        @Override // com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.Proxy
        public void updateDevStat(int i) {
            synchronized (this) {
                this.mLastDevStat = new Proxy.ExpireRef(i, 5000L);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface Proxy {

        /* JADX INFO: compiled from: SearchBox */
        public static final class ExpireRef {
            final long aliveMillis;
            final long lastMillis = SystemClock.uptimeMillis();
            final int value;

            public ExpireRef(int i, long j) {
                this.value = i;
                this.aliveMillis = j;
            }

            public boolean isExpired() {
                return SystemClock.uptimeMillis() - this.lastMillis >= this.aliveMillis;
            }
        }

        int getAppStat(Context context, boolean z);

        int getDevStat(Context context);

        String getPackageName();

        String getProcessName();

        void updateAppStat(int i);

        void updateDevStat(int i);
    }

    @Nullable
    public static String cat(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, t.k);
            try {
                String line = randomAccessFile.readLine();
                randomAccessFile.close();
                return line;
            } finally {
            }
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "cat file fail", new Object[0]);
            return null;
        }
    }

    public static long computeAvgByMinute(long j, long j2) {
        return j2 < 60000 ? (j / Math.max(1L, (j2 * 100) / 60000)) * 100 : j / Math.max(1L, j2 / 60000);
    }

    public static String convertAppStat(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "unknown" : "fgSrv" : OapsKey.KEY_BG : "fg";
    }

    public static String convertDevStat(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "doze" : a.g : "non_charge" : "charging";
    }

    public static String getAlarmTypeString(int i) {
        if (i == 0) {
            return "RTC_WAKEUP";
        }
        if (i == 1) {
            return "RTC";
        }
        if (i == 2) {
            return "ELAPSED_REALTIME_WAKEUP";
        }
        if (i != 3) {
            return null;
        }
        return "ELAPSED_REALTIME";
    }

    public static int getAppStat(Context context, boolean z) {
        return sCacheStub.getAppStat(context, z);
    }

    public static int getAppStatImmediately(Context context, boolean z) {
        if (z) {
            return 1;
        }
        return hasForegroundService(context) ? 3 : 2;
    }

    public static int getBatteryTemperature(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return 0;
            }
            return intentRegisterReceiver.getIntExtra("temperature", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int[] getCpuCurrentFreq() {
        int[] iArr = new int[getNumCores()];
        for (int i = 0; i < getNumCores(); i++) {
            iArr[i] = 0;
            String strCat = cat(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i + SysPerformanceCollector.SYS_CPU_CUR_FREQ_FILE);
            if (!TextUtils.isEmpty(strCat)) {
                try {
                    iArr[i] = Integer.parseInt(strCat) / 1000;
                } catch (Exception unused) {
                }
            }
        }
        return iArr;
    }

    public static int getDeviceStat(Context context) {
        return sCacheStub.getDevStat(context);
    }

    public static int getDeviceStatImmediately(Context context) {
        if (isDeviceCharging(context)) {
            return 1;
        }
        if (isDeviceScreenOn(context)) {
            return isDeviceOnPowerSave(context) ? 4 : 2;
        }
        return 3;
    }

    private static int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String getPackageName() {
        return sCacheStub.getPackageName();
    }

    public static String getProcessName() {
        return sCacheStub.getProcessName();
    }

    public static Proxy getProxy() {
        return sCacheStub;
    }

    public static String getThrowableStack(Throwable th) {
        return th == null ? "" : stackTraceToString(th.getStackTrace());
    }

    public static long getUTCTriggerAtMillis(long j, int i) {
        return (i == 1 || i == 0) ? j : (j + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    }

    public static boolean hasForegroundService(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null) {
                return false;
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (!TextUtils.isEmpty(runningServiceInfo.process) && runningServiceInfo.process.startsWith(context.getPackageName()) && runningServiceInfo.foreground) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDeviceCharging(Context context) {
        return isDeviceChargingV1(context);
    }

    public static boolean isDeviceChargingV1(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return false;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDeviceChargingV2(Context context) {
        BatteryManager batteryManager;
        if (Build.VERSION.SDK_INT >= 23 && (batteryManager = (BatteryManager) context.getSystemService("batterymanager")) != null) {
            return batteryManager.isCharging();
        }
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return false;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("plugged", -1);
            return intExtra == 1 || intExtra == 2 || intExtra == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDeviceOnPowerSave(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDeviceScreenOn(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isInteractive();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<ActivityManager.RunningServiceInfo> listForegroundServices(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        List<ActivityManager.RunningServiceInfo> listEmptyList = Collections.emptyList();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) != null) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (!TextUtils.isEmpty(runningServiceInfo.process) && runningServiceInfo.process.startsWith(context.getPackageName()) && runningServiceInfo.foreground) {
                        if (listEmptyList.isEmpty()) {
                            listEmptyList = new ArrayList();
                        }
                        listEmptyList.add(runningServiceInfo);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return listEmptyList;
    }

    public static String polishStack(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("\n\t");
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        for (String str3 : strArrSplit) {
            if (!TextUtils.isEmpty(str3)) {
                if (!zIsEmpty && str3.startsWith(str2)) {
                    zIsEmpty = true;
                }
                if (zIsEmpty) {
                    arrayList.add(str3.trim());
                }
            }
        }
        return TextUtils.join(x.aQ, arrayList.subList(0, Math.min(5, arrayList.size())));
    }

    public static void setProxy(Proxy proxy) {
        sCacheStub = proxy;
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!className.contains("com.tencent.matrix") && !className.contains("java.lang.reflect") && !className.contains("$Proxy2") && !className.contains("android.os")) {
                arrayList.add(stackTraceElement);
            }
        }
        String packageName = getPackageName();
        if (arrayList.size() > 10 && !TextUtils.isEmpty(packageName)) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(packageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 10) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((StackTraceElement) it.next());
            sb.append('\n');
        }
        return sb.toString();
    }
}
