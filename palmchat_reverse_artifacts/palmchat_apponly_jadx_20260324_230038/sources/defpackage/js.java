package defpackage;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.batterycanary.monitor.AppStats;
import com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.BlueToothMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LocationMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.TrafficMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WifiMonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.xiaomi.mipush.sdk.Constants;
import com.zenmen.palmchat.battery.bean.AlarmBean;
import com.zenmen.palmchat.battery.bean.AppStatsBean;
import com.zenmen.palmchat.battery.bean.BatteryTempBean;
import com.zenmen.palmchat.battery.bean.BluetoothBean;
import com.zenmen.palmchat.battery.bean.CpuFreqBean;
import com.zenmen.palmchat.battery.bean.JiffiesBean;
import com.zenmen.palmchat.battery.bean.LocationBean;
import com.zenmen.palmchat.battery.bean.ThreadWatchBean;
import com.zenmen.palmchat.battery.bean.TrafficStatusBean;
import com.zenmen.palmchat.battery.bean.WakeLockBean;
import com.zenmen.palmchat.battery.bean.WifiBean;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class js {
    public static AlarmBean a(MonitorFeature.Snapshot.Delta<AlarmMonitorFeature.AlarmSnapshot> delta) {
        AlarmBean alarmBean = new AlarmBean();
        if (delta != null && delta.dlt != 0) {
            alarmBean.during = l(delta.during);
            alarmBean.alarmCount = ((Integer) ((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).totalCount.get()).intValue();
            alarmBean.traceCount = ((Integer) ((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).tracingCount.get()).intValue();
            alarmBean.dupliGroup = ((Integer) ((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).duplicatedGroup.get()).intValue();
            alarmBean.dupliCount = ((Integer) ((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).duplicatedCount.get()).intValue();
        }
        return alarmBean;
    }

    public static AppStatsBean b(AppStats appStats, AppStatMonitorFeature appStatMonitorFeature) {
        AppStatsBean appStatsBean = new AppStatsBean();
        if (appStats != null) {
            AppStatsBean.StatTime statTime = new AppStatsBean.StatTime();
            statTime.time = l(Math.max(1L, appStats.duringMillis));
            statTime.fg = appStats.appFgRatio;
            statTime.bg = appStats.appBgRatio;
            statTime.fgSrv = appStats.appFgSrvRatio;
            statTime.devCharging = appStats.devChargingRatio;
            statTime.devScreenOff = appStats.devSceneOffRatio;
            if (!TextUtils.isEmpty(appStats.sceneTop1)) {
                statTime.sceneTop1 = appStats.sceneTop1 + " / " + appStats.sceneTop1Ratio;
            }
            if (!TextUtils.isEmpty(appStats.sceneTop2)) {
                statTime.sceneTop2 = appStats.sceneTop2 + " / " + appStats.sceneTop2Ratio;
            }
            appStatsBean.statTime = statTime;
        }
        if (appStatMonitorFeature != null) {
            AppStatsBean.RunTime runTime = new AppStatsBean.RunTime();
            AppStatMonitorFeature.AppStatSnapshot appStatSnapshotCurrentAppStatSnapshot = appStatMonitorFeature.currentAppStatSnapshot();
            if (appStatSnapshotCurrentAppStatSnapshot != null) {
                runTime.time = l(((Long) appStatSnapshotCurrentAppStatSnapshot.uptime.get()).longValue());
                runTime.fg = ((Long) appStatSnapshotCurrentAppStatSnapshot.fgRatio.get()).longValue();
                runTime.bg = ((Long) appStatSnapshotCurrentAppStatSnapshot.bgRatio.get()).longValue();
                runTime.fgSrv = ((Long) appStatSnapshotCurrentAppStatSnapshot.fgSrvRatio.get()).longValue();
            }
            appStatsBean.runTime = runTime;
        }
        return appStatsBean;
    }

    public static BatteryTempBean c(MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.BatteryTmpSnapshot> delta) {
        BatteryTempBean batteryTempBean = new BatteryTempBean();
        if (delta != null && delta.dlt != 0 && delta.end != 0) {
            batteryTempBean.during = l(delta.during);
            batteryTempBean.inc = ((Integer) ((DeviceStatMonitorFeature.BatteryTmpSnapshot) delta.dlt).temp.get()).intValue();
            batteryTempBean.cur = ((Integer) ((DeviceStatMonitorFeature.BatteryTmpSnapshot) delta.end).temp.get()).intValue();
        }
        return batteryTempBean;
    }

    public static BluetoothBean d(MonitorFeature.Snapshot.Delta<BlueToothMonitorFeature.BlueToothSnapshot> delta) {
        BluetoothBean bluetoothBean = new BluetoothBean();
        if (delta != null && delta.dlt != 0) {
            bluetoothBean.during = l(delta.during);
            bluetoothBean.regsCount = ((Integer) ((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).regsCount.get()).intValue();
            bluetoothBean.discCount = ((Integer) ((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).discCount.get()).intValue();
            bluetoothBean.scanCount = ((Integer) ((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).scanCount.get()).intValue();
        }
        return bluetoothBean;
    }

    public static CpuFreqBean e(MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.CpuFreqSnapshot> delta) {
        RECORD record;
        RECORD record2;
        CpuFreqBean cpuFreqBean = new CpuFreqBean();
        if (delta != null && (record = delta.dlt) != 0 && (record2 = delta.end) != 0 && ((DeviceStatMonitorFeature.CpuFreqSnapshot) record).cpuFreqs != null && ((DeviceStatMonitorFeature.CpuFreqSnapshot) record2).cpuFreqs != null) {
            cpuFreqBean.during = l(delta.during);
            cpuFreqBean.inc = Arrays.toString(((DeviceStatMonitorFeature.CpuFreqSnapshot) delta.dlt).cpuFreqs.getList().toArray());
            cpuFreqBean.cur = Arrays.toString(((DeviceStatMonitorFeature.CpuFreqSnapshot) delta.end).cpuFreqs.getList().toArray());
        }
        return cpuFreqBean;
    }

    public static JiffiesBean f(MonitorFeature.Snapshot.Delta<JiffiesMonitorFeature.JiffiesSnapshot> delta, AppStats appStats) {
        JiffiesBean jiffiesBean = new JiffiesBean();
        jiffiesBean.pid = Process.myPid();
        if (appStats != null) {
            jiffiesBean.fg = BatteryCanaryUtil.convertAppStat(appStats.getAppStat());
        }
        if (delta != null && delta.dlt != 0) {
            long jMax = Math.max(1L, delta.during / 60000);
            long jLongValue = ((Long) ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).totalJiffies.get()).longValue() / jMax;
            jiffiesBean.during = l(delta.during);
            jiffiesBean.totalJiffies = ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).totalJiffies.get() + " (jiffies)";
            jiffiesBean.avgJiffies = jLongValue + " (jiffies/min)";
            jiffiesBean.threadEntries = ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadEntries.getList().size();
            jiffiesBean.incThreadNum = ((Integer) ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadNum.get()).intValue();
            RECORD record = delta.end;
            if (record != 0) {
                jiffiesBean.curThreadNum = ((Integer) ((JiffiesMonitorFeature.JiffiesSnapshot) record).threadNum.get()).intValue();
            }
            jiffiesBean.overHeat = jLongValue > ((long) ks.b().overHeatCount);
            jiffiesBean.invalid = !delta.isValid();
            RECORD record2 = delta.dlt;
            if (((JiffiesMonitorFeature.JiffiesSnapshot) record2).threadEntries != null) {
                for (JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry threadJiffiesEntry : ((JiffiesMonitorFeature.JiffiesSnapshot) record2).threadEntries.getList().subList(0, Math.min(((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadEntries.getList().size(), ks.b().maxJiffiesLogCount))) {
                    if (threadJiffiesEntry != null) {
                        jiffiesBean.threadJiffies.add(m(true, jMax, threadJiffiesEntry));
                    }
                }
            }
        }
        return jiffiesBean;
    }

    public static LocationBean g(MonitorFeature.Snapshot.Delta<LocationMonitorFeature.LocationSnapshot> delta) {
        LocationBean locationBean = new LocationBean();
        if (delta != null && delta.dlt != 0) {
            locationBean.during = l(delta.during);
            locationBean.scanCount = ((Integer) ((LocationMonitorFeature.LocationSnapshot) delta.dlt).scanCount.get()).intValue();
        }
        return locationBean;
    }

    @SuppressLint({"DefaultLocale"})
    public static ThreadWatchBean h(MonitorFeature.Snapshot.Entry.ListEntry<? extends JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry> listEntry) {
        ThreadWatchBean threadWatchBean = new ThreadWatchBean();
        if (listEntry != null && listEntry.getList() != null && listEntry.getList().size() > 0 && listEntry.isValid()) {
            threadWatchBean.threadJiffiesCount = listEntry.getList().size();
            Iterator it = listEntry.getList().iterator();
            while (it.hasNext()) {
                threadWatchBean.threadJiffies.add(m(false, 0L, (JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry) it.next()));
            }
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                StackTraceElement[] value = entry.getValue();
                String name = key.getName();
                Iterator it2 = listEntry.getList().iterator();
                while (it2.hasNext()) {
                    String str = ((JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry) it2.next()).name;
                    if (str.equalsIgnoreCase(name) || name.contains(str)) {
                        ThreadWatchBean.StackTrace stackTrace = new ThreadWatchBean.StackTrace();
                        stackTrace.threadState = key.getState().toString();
                        stackTrace.threadName = name;
                        long id = key.getId();
                        stackTrace.threadId = id;
                        stackTrace.customMessage = String.format("(%s)%s(%d)", stackTrace.threadState, stackTrace.threadName, Long.valueOf(id));
                        if (value != null && value.length > 0) {
                            StringBuilder sb = new StringBuilder(value.length);
                            for (StackTraceElement stackTraceElement : value) {
                                sb.append(stackTraceElement);
                                sb.append("\n");
                            }
                            stackTrace.stackTrace = sb.toString();
                        }
                        threadWatchBean.stacks.add(stackTrace);
                    }
                }
            }
        }
        return threadWatchBean;
    }

    public static TrafficStatusBean i(MonitorFeature.Snapshot.Delta<TrafficMonitorFeature.RadioStatSnapshot> delta) {
        TrafficStatusBean trafficStatusBean = new TrafficStatusBean();
        if (delta != null && delta.dlt != 0) {
            trafficStatusBean.during = l(delta.during);
            trafficStatusBean.wifiRxBytes = ((Long) ((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).wifiRxBytes.get()).longValue();
            trafficStatusBean.wifiTxBytes = ((Long) ((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).wifiTxBytes.get()).longValue();
            trafficStatusBean.mobileRxBytes = ((Long) ((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).mobileRxBytes.get()).longValue();
            trafficStatusBean.mobileTxBytes = ((Long) ((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).mobileTxBytes.get()).longValue();
        }
        return trafficStatusBean;
    }

    public static WakeLockBean j(MonitorFeature.Snapshot.Delta<WakeLockMonitorFeature.WakeLockSnapshot> delta) {
        WakeLockBean wakeLockBean = new WakeLockBean();
        if (delta != null && delta.dlt != 0) {
            wakeLockBean.during = l(delta.during);
            wakeLockBean.lockCount = ((Integer) ((WakeLockMonitorFeature.WakeLockSnapshot) delta.dlt).totalWakeLockCount.get()).intValue();
            wakeLockBean.timeTotal = ((Long) ((WakeLockMonitorFeature.WakeLockSnapshot) delta.dlt).totalWakeLockTime.get()).longValue();
        }
        return wakeLockBean;
    }

    public static WifiBean k(MonitorFeature.Snapshot.Delta<WifiMonitorFeature.WifiSnapshot> delta) {
        WifiBean wifiBean = new WifiBean();
        if (delta != null && delta.dlt != 0) {
            wifiBean.during = l(delta.during);
            wifiBean.scanCount = ((Integer) ((WifiMonitorFeature.WifiSnapshot) delta.dlt).scanCount.get()).intValue();
            wifiBean.queryCount = ((Integer) ((WifiMonitorFeature.WifiSnapshot) delta.dlt).queryCount.get()).intValue();
        }
        return wifiBean;
    }

    public static String l(long j) {
        return j + "(mls) -- " + (j / 60000) + "(min)";
    }

    @SuppressLint({"DefaultLocale"})
    public static JiffiesBean.ThreadJiffies m(boolean z, long j, JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry threadJiffiesEntry) {
        JiffiesBean.ThreadJiffies threadJiffies = new JiffiesBean.ThreadJiffies();
        threadJiffies.isNewAdded = threadJiffiesEntry.isNewAdded;
        threadJiffies.stat = threadJiffiesEntry.stat;
        threadJiffies.threadName = threadJiffiesEntry.name;
        threadJiffies.threadTid = threadJiffiesEntry.tid;
        threadJiffies.entryJiffies = threadJiffiesEntry.get().longValue();
        if (z) {
            threadJiffies.avgJiffies = threadJiffiesEntry.get().longValue() / j;
            Object[] objArr = new Object[6];
            objArr[0] = threadJiffies.isNewAdded ? "+" : Constants.WAVE_SEPARATOR;
            objArr[1] = threadJiffies.stat;
            objArr[2] = threadJiffies.threadName;
            objArr[3] = Integer.valueOf(threadJiffies.threadTid);
            objArr[4] = Long.valueOf(threadJiffies.avgJiffies);
            objArr[5] = Long.valueOf(threadJiffies.entryJiffies);
            threadJiffies.customMessage = String.format("(%s/%s)%s(%d) -- %d/%d jiffies", objArr);
        } else {
            Object[] objArr2 = new Object[5];
            objArr2[0] = threadJiffies.isNewAdded ? "+" : Constants.WAVE_SEPARATOR;
            objArr2[1] = threadJiffies.stat;
            objArr2[2] = threadJiffies.threadName;
            objArr2[3] = Integer.valueOf(threadJiffies.threadTid);
            objArr2[4] = Long.valueOf(threadJiffies.entryJiffies);
            threadJiffies.customMessage = String.format("(%s/%s)%s(%d) -- %d jiffies", objArr2);
        }
        return threadJiffies;
    }
}
