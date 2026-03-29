package defpackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryMonitorPlugin;
import com.tencent.matrix.batterycanary.monitor.AppStats;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorConfig;
import com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.BlueToothMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LocationMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.TrafficMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WifiMonitorFeature;
import com.tencent.matrix.batterycanary.utils.Consumer;
import com.zenmen.palmchat.battery.bean.AlarmBean;
import com.zenmen.palmchat.battery.bean.AppStatsBean;
import com.zenmen.palmchat.battery.bean.BatteryCanaryConfig;
import com.zenmen.palmchat.battery.bean.BatteryInfoBean;
import com.zenmen.palmchat.battery.bean.BatteryTempBean;
import com.zenmen.palmchat.battery.bean.BluetoothBean;
import com.zenmen.palmchat.battery.bean.CpuFreqBean;
import com.zenmen.palmchat.battery.bean.JiffiesBean;
import com.zenmen.palmchat.battery.bean.LocationBean;
import com.zenmen.palmchat.battery.bean.TrafficStatusBean;
import com.zenmen.palmchat.battery.bean.WakeLockBean;
import com.zenmen.palmchat.battery.bean.WifiBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"LongLogTag"})
public final class ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryMonitorConfig f18818a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callable<String> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            return "Current AppScene";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends AbsMonitorFeature {
        @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
        public void onBackgroundCheck(long j) {
            super.onBackgroundCheck(j);
            this.mCore.getConfig().callback.onTraceEnd(false);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
        public int weight() {
            return Integer.MAX_VALUE;
        }
    }

    public static BatteryMonitorPlugin a(BatteryCanaryConfig batteryCanaryConfig) {
        if (f18818a != null) {
            throw new IllegalStateException("Duplicated init!");
        }
        BatteryMonitorConfig.Builder builder = new BatteryMonitorConfig.Builder();
        builder.enableAmsHook(true).setOverHeatCount(1024).setSceneSupplier(new a());
        if (batteryCanaryConfig.isMonitorThread()) {
            int backgroundLoopCheckTime = batteryCanaryConfig.getBackgroundLoopCheckTime();
            int foregroundLoopCheckTime = batteryCanaryConfig.getForegroundLoopCheckTime();
            builder.enable(JiffiesMonitorFeature.class).enableStatPidProc(true).greyJiffiesTime(3000L).enableBackgroundMode(backgroundLoopCheckTime > 0).backgroundLoopCheckTime(((long) backgroundLoopCheckTime) * 1000).enableForegroundMode(foregroundLoopCheckTime > 0).foregroundLoopCheckTime(((long) foregroundLoopCheckTime) * 1000).setBgThreadWatchingLimit(batteryCanaryConfig.getBgThreadWatchingLimit()).setFgThreadWatchingLimit(batteryCanaryConfig.getFgThreadWatchingLimit()).setMaxJiffiesLogCount(batteryCanaryConfig.getMaxJiffiesLogCount()).setThreadRunTimeWatchingLimit(batteryCanaryConfig.getThreadRunTimeWatchingLimit());
        }
        if (batteryCanaryConfig.isMonitorDevStat()) {
            builder.enable(DeviceStatMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorAppStat()) {
            builder.enable(AppStatMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorAlarm()) {
            builder.enable(AlarmMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorWakeLock()) {
            builder.enable(WakeLockMonitorFeature.class).wakelockTimeout(((long) batteryCanaryConfig.getWakelockTimeout()) * 1000).wakelockWarnCount(batteryCanaryConfig.getWakelockWarnCount());
        }
        if (batteryCanaryConfig.isMonitorWifi()) {
            builder.enable(WifiMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorLocation()) {
            builder.enable(LocationMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorBluetooth()) {
            builder.enable(BlueToothMonitorFeature.class);
        }
        if (batteryCanaryConfig.isMonitorTraffic()) {
            builder.enable(TrafficMonitorFeature.class);
        }
        if (LogUtil.isDDBG()) {
            builder.enable(LooperTaskMonitorFeature.class).addLooperWatchList("all").useThreadClock(false).enableAggressive(true);
        }
        f18818a = builder.enable(b.class).setCallback(new c()).build();
        return new BatteryMonitorPlugin(f18818a);
    }

    public static BatteryMonitorConfig b() {
        BatteryMonitorConfig batteryMonitorConfig = f18818a;
        if (batteryMonitorConfig != null) {
            return batteryMonitorConfig;
        }
        throw new IllegalStateException("BatteryCanary has not yet init!");
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends BatteryMonitorCallback.BatteryPrinter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JiffiesBean f18819a;
        public AlarmBean b;
        public WakeLockBean c;
        public BluetoothBean d;
        public WifiBean e;
        public LocationBean f;
        public AppStatsBean g;
        public BatteryTempBean h;
        public CpuFreqBean i;
        public TrafficStatusBean j;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Consumer<BatteryMonitorCallback.BatteryPrinter.Printer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppStats f18820a;

            public a(AppStats appStats) {
                this.f18820a = appStats;
            }

            @Override // com.tencent.matrix.batterycanary.utils.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(BatteryMonitorCallback.BatteryPrinter.Printer printer) {
                TrafficMonitorFeature.RadioStatSnapshot radioStatSnapshotCurrentRadioSnapshot;
                if (((BatteryMonitorCallback.BatteryPrinter) c.this).mTrafficFeat == null || ((BatteryMonitorCallback.BatteryPrinter) c.this).mLastTrafficSnapshot == null || (radioStatSnapshotCurrentRadioSnapshot = ((BatteryMonitorCallback.BatteryPrinter) c.this).mTrafficFeat.currentRadioSnapshot(Matrix.with().getApplication())) == null) {
                    return;
                }
                MonitorFeature.Snapshot.Delta<TrafficMonitorFeature.RadioStatSnapshot> deltaDiff = radioStatSnapshotCurrentRadioSnapshot.diff(((BatteryMonitorCallback.BatteryPrinter) c.this).mLastTrafficSnapshot);
                c.this.i(deltaDiff);
                c.this.j(deltaDiff, this.f18820a, printer);
            }
        }

        public final void f() {
            String str;
            BatteryInfoBean batteryInfoBean = new BatteryInfoBean();
            batteryInfoBean.jiffies = this.f18819a;
            batteryInfoBean.alarm = this.b;
            batteryInfoBean.wakeLock = this.c;
            batteryInfoBean.bluetooth = this.d;
            batteryInfoBean.wifi = this.e;
            batteryInfoBean.location = this.f;
            batteryInfoBean.cpuFreq = this.i;
            batteryInfoBean.batteryTemp = this.h;
            batteryInfoBean.trafficStatus = this.j;
            batteryInfoBean.appStats = this.g;
            ms.f(h().toJson(batteryInfoBean), null);
            try {
                JiffiesBean jiffiesBean = this.f18819a;
                if (jiffiesBean == null || (str = jiffiesBean.avgJiffies) == null) {
                    return;
                }
                qt4.b().d(Long.parseLong(str.replace(" (jiffies/min)", "")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void g() {
            this.f18819a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.i = null;
            this.h = null;
            this.j = null;
            this.g = null;
        }

        public final Gson h() {
            return new GsonBuilder().registerTypeAdapter(BatteryInfoBean.class, new BatteryInfoBean.BatteryInfoBeanJsonSerializer()).registerTypeAdapter(JiffiesBean.class, new JiffiesBean.JiffiesBeanJsonSerializer()).registerTypeAdapter(JiffiesBean.ThreadJiffies.class, new JiffiesBean.ThreadJiffiesJsonSerializer()).setPrettyPrinting().create();
        }

        public void i(@NonNull MonitorFeature.Snapshot.Delta<TrafficMonitorFeature.RadioStatSnapshot> delta) {
            this.j = js.i(delta);
        }

        public final void j(MonitorFeature.Snapshot.Delta<?> delta, AppStats appStats, BatteryMonitorCallback.BatteryPrinter.Printer printer) {
            if (delta.dlt instanceof TrafficMonitorFeature.RadioStatSnapshot) {
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("wifi_rx_bytes", String.valueOf(((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).wifiRxBytes.get()));
                printer.writeLine("wifi_tx_bytes", String.valueOf(((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).wifiTxBytes.get()));
                printer.writeLine("mobile_rx_bytes", String.valueOf(((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).mobileRxBytes.get()));
                printer.writeLine("mobile_tx_bytes", String.valueOf(((TrafficMonitorFeature.RadioStatSnapshot) delta.dlt).mobileTxBytes.get()));
            }
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onCanaryDump(AppStats appStats) {
            g();
            super.onCanaryDump(appStats);
            f();
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportAlarm(@NonNull MonitorFeature.Snapshot.Delta<AlarmMonitorFeature.AlarmSnapshot> delta) {
            this.b = js.a(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportBlueTooth(@NonNull MonitorFeature.Snapshot.Delta<BlueToothMonitorFeature.BlueToothSnapshot> delta) {
            this.d = js.d(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportCpuFreq(@NonNull MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.CpuFreqSnapshot> delta) {
            this.i = js.e(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportJiffies(@NonNull MonitorFeature.Snapshot.Delta<JiffiesMonitorFeature.JiffiesSnapshot> delta) {
            this.f18819a = js.f(delta, getAppStats());
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportLocation(@NonNull MonitorFeature.Snapshot.Delta<LocationMonitorFeature.LocationSnapshot> delta) {
            this.f = js.g(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportTemperature(@NonNull MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.BatteryTmpSnapshot> delta) {
            this.h = js.c(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportWakeLock(@NonNull MonitorFeature.Snapshot.Delta<WakeLockMonitorFeature.WakeLockSnapshot> delta) {
            this.c = js.j(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onReportWifi(@NonNull MonitorFeature.Snapshot.Delta<WifiMonitorFeature.WifiSnapshot> delta) {
            this.e = js.k(delta);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter, com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesListener
        public void onWatchingThreads(MonitorFeature.Snapshot.Entry.ListEntry<? extends JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry> listEntry) {
            super.onWatchingThreads(listEntry);
            ms.g(new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(js.h(listEntry)), null);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onWritingAppStatSection(AppStats appStats) {
            AppStatMonitorFeature appStatMonitorFeature;
            if (appStats == null || (appStatMonitorFeature = this.mAppStatFeat) == null) {
                return;
            }
            this.g = js.b(appStats, appStatMonitorFeature);
            super.onWritingAppStatSection(appStats);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter
        public void onWritingSections(AppStats appStats) {
            super.onWritingSections(appStats);
            if (this.mTrafficFeat == null || this.mLastTrafficSnapshot == null) {
                return;
            }
            createSection("traffic_stats", new a(appStats));
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter, com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockListener
        public void onWakeLockTimeout(WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord wakeLockRecord, long j) {
        }
    }
}
