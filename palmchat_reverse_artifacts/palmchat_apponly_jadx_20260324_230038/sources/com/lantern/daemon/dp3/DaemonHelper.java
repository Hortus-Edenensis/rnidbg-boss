package com.lantern.daemon.dp3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import com.lantern.daemon.dp3.account.AccountSync;
import com.lantern.daemon.dp3.utils.BroadcastReceiverA;
import com.lantern.daemon.dp3.utils.BroadcastReceiverF;
import com.lantern.daemon.dp3.utils.StatReceiverJ;
import com.lantern.daemon.dp3.utils.Utils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DaemonHelper {
    public static final String TAG = "DaemonHelper";
    public IDaemonCallback callback;
    public Context context;
    public DaemonParams daemonParams;
    public static DaemonHelper instance = new DaemonHelper();
    public static boolean hasCallback = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class DaemonParams {
        public Intent broadcastIntent;
        public String dir;
        public Intent instrumentationIntent;
        public String nativeLibraryDir;
        public String packageName;
        public String processAssist;
        public String processAssist1;
        public String processDaemon;
        public String publicSourceDir;
        public Intent serviceIntent;
        public IServiceHelper startService;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IDaemonCallback {
        void onAlive(Context context, Map map);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IServiceHelper {
        boolean startBindService(Context context, String str);
    }

    public static DaemonHelper instance() {
        return instance;
    }

    public void bindService(String str, String str2) {
        try {
            if (this.context.getPackageName().equalsIgnoreCase(str)) {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                this.context.bindService(intent, new ServiceConnectionE(this), 65);
            }
        } catch (Exception unused) {
        }
    }

    public DaemonParams getDaemonParams() {
        return this.daemonParams;
    }

    public void init(Context context, boolean z, long j) {
        String strProcessName = ProcessUtils.processName();
        synchronized (this) {
            this.context = context.getApplicationContext();
            if (this.daemonParams == null) {
                DaemonParams daemonParams = new DaemonParams();
                String packageName = context.getPackageName();
                daemonParams.packageName = packageName;
                daemonParams.processDaemon = packageName + ".daemon";
                daemonParams.processAssist = packageName + ":assist";
                daemonParams.processAssist1 = packageName + ":assist1";
                Bundle bundle = new Bundle();
                Intent intent = new Intent();
                daemonParams.instrumentationIntent = intent;
                intent.setComponent(new ComponentName(packageName, ExportInstrumentation.class.getName()));
                daemonParams.instrumentationIntent.putExtras(bundle);
                Intent intent2 = new Intent();
                daemonParams.serviceIntent = intent2;
                intent2.setClassName(packageName, ExportService.class.getName());
                daemonParams.serviceIntent.putExtras(bundle);
                Intent intent3 = new Intent();
                daemonParams.broadcastIntent = intent3;
                intent3.setAction(packageName + ".COREDAEMON_EXPORT_BROADCAST");
                daemonParams.broadcastIntent.setPackage(context.getPackageName());
                daemonParams.broadcastIntent.putExtras(bundle);
                daemonParams.dir = context.getDir("TmpDir", 0).getAbsolutePath();
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
                    daemonParams.nativeLibraryDir = applicationInfo.nativeLibraryDir;
                    daemonParams.publicSourceDir = applicationInfo.publicSourceDir;
                    daemonParams.startService = new ServiceHelper();
                    this.daemonParams = daemonParams;
                } catch (Exception unused) {
                    this.daemonParams = null;
                }
            }
        }
        DaemonParams daemonParams2 = this.daemonParams;
        if (daemonParams2 == null) {
            return;
        }
        try {
            if (daemonParams2.packageName.equals(strProcessName)) {
                BroadcastReceiverA.register(context);
                StatReceiverJ.register(context);
                BroadcastReceiverF.sendBroadcast(context);
            }
            if (z) {
                if (this.daemonParams.packageName.equals(strProcessName)) {
                    DaemonParams daemonParams3 = this.daemonParams;
                    daemonParams3.startService.startBindService(context, daemonParams3.processDaemon);
                    DaemonParams daemonParams4 = this.daemonParams;
                    daemonParams4.startService.startBindService(context, daemonParams4.processAssist);
                    DaemonParams daemonParams5 = this.daemonParams;
                    daemonParams5.startService.startBindService(context, daemonParams5.processAssist1);
                }
                if (this.daemonParams.processDaemon.equals(strProcessName)) {
                    if (Utils.holdFileLock(new String[]{"Service_b87c833c_service_assist", "Service_b87c833c_service_assist1", "Service_b87c833c_native_assist", "Service_b87c833c_native_assist1"}) && Utils.startAppProcess(context, new String[]{"Service_721f8521_native_daemon", "Service_6e3ec5cc_native_daemon"}, "daemon")) {
                        Utils.startDaemon(context, new String[]{"Service_721f8521_service_daemon", "Service_6e3ec5cc_service_daemon"});
                    }
                } else if (this.daemonParams.processAssist.equals(strProcessName)) {
                    if (Utils.holdFileLock(new String[]{"Service_721f8521_service_daemon", "Service_721f8521_service_assist1", "Service_721f8521_native_daemon", "Service_721f8521_native_assist1"}) && Utils.startAppProcess(context, new String[]{"Service_b87c833c_native_assist", "Service_6e3ec5cc_native_assist"}, "assist")) {
                        Utils.startDaemon(context, new String[]{"Service_b87c833c_service_assist", "Service_6e3ec5cc_service_assist"});
                    }
                } else if (this.daemonParams.processAssist1.equals(strProcessName) && !Utils.holdFileLock(new String[]{"Service_6e3ec5cc_service_daemon", "Service_6e3ec5cc_service_assist", "Service_6e3ec5cc_native_daemon", "Service_6e3ec5cc_native_assist"}) && Utils.startAppProcess(context, new String[]{"Service_b87c833c_native_assist1", "Service_721f8521_native_assist1"}, "assist1")) {
                    Utils.startDaemon(context, new String[]{"Service_b87c833c_service_assist1", "Service_721f8521_service_assist1"});
                }
            }
            AccountSync.getInstance().init(context, j);
        } catch (Throwable th) {
            Log.d(TAG, "init: " + th.getMessage());
        }
    }

    public void onAlive(Context context, Map map) {
        synchronized (this) {
            IDaemonCallback iDaemonCallback = this.callback;
            if (iDaemonCallback != null && map != null) {
                if (hasCallback) {
                    return;
                }
                hasCallback = true;
                iDaemonCallback.onAlive(context, map);
            }
        }
    }
}
