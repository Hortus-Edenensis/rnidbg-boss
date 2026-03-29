package com.lantern.daemon.dp3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ProcessUtils {
    public static String receiverPermission;

    public static void bindService(Context context, Intent intent, Class cls) {
        if (cls == null) {
            return;
        }
        if (intent == null) {
            intent = new Intent(context, (Class<?>) cls);
        } else {
            intent.setClass(context, cls);
        }
        context.bindService(intent, new ServiceConnectionI(), 1);
    }

    public static String processName() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/cmdline")));
            String strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return strTrim;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        com.lantern.daemon.dp3.ProcessUtils.receiverPermission = r2.name;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String receiverPermission(Context context) {
        String str;
        synchronized (ProcessUtils.class) {
            if (TextUtils.isEmpty(receiverPermission)) {
                try {
                    PermissionInfo[] permissionInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).permissions;
                    int i = 0;
                    while (true) {
                        if (i >= permissionInfoArr.length) {
                            break;
                        }
                        PermissionInfo permissionInfo = permissionInfoArr[i];
                        if (!TextUtils.isEmpty(permissionInfo.name) && permissionInfo.name.endsWith(".LIBCOREDAEMON_BROADCAST_PERMISSIONS")) {
                            break;
                        }
                        i++;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            str = receiverPermission;
        }
        return str;
    }

    public static void startBindService(Context context, Class cls) {
        try {
            context.startService(new Intent(context, (Class<?>) cls));
        } catch (Exception e) {
            Log.d(DaemonHelper.TAG, "startBindService: " + e.getMessage());
        }
        try {
            bindService(context, null, cls);
        } catch (Exception e2) {
            Log.d(DaemonHelper.TAG, "startBindService: " + e2.getMessage());
        }
    }
}
