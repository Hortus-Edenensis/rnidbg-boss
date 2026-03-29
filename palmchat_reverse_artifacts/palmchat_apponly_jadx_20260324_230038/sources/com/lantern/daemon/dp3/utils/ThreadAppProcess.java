package com.lantern.daemon.dp3.utils;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.daemon.dp3.DaemonEntry;
import com.lantern.daemon.dp3.DaemonHelper;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ThreadAppProcess extends Thread {
    public final Context context;
    public final String[] files;
    public final String processName;

    public ThreadAppProcess(Context context, String[] strArr, String str) {
        this.context = context;
        this.files = strArr;
        this.processName = str;
    }

    public static Boolean isLib64(String str) {
        String property = System.getProperty("java.library.path");
        boolean z = false;
        if (!TextUtils.isEmpty(property)) {
            String[] strArrSplit = property.split(":");
            if (strArrSplit == null) {
                strArrSplit = new String[]{property};
            }
            int i = 0;
            while (true) {
                if (i >= strArrSplit.length) {
                    break;
                }
                if (strArrSplit[i].endsWith("lib64")) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setPriority(10);
        try {
            DaemonHelper.DaemonParams daemonParams = DaemonHelper.instance().getDaemonParams();
            EntryParam entryParam = new EntryParam();
            entryParam.files = this.files;
            entryParam.broadcastIntent = daemonParams.broadcastIntent;
            entryParam.instrumentationIntent = daemonParams.instrumentationIntent;
            entryParam.serviceIntent = daemonParams.serviceIntent;
            entryParam.processName = this.processName;
            boolean zExists = new File("/system/bin/app_process32").exists();
            boolean zExists2 = new File("/system/bin/app_process64").exists();
            String str = String.format("export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", daemonParams.nativeLibraryDir);
            String str2 = String.format("export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", daemonParams.nativeLibraryDir);
            String str3 = "app_process32";
            if (isLib64("libcore_daemon.so").booleanValue()) {
                if (zExists2) {
                    if (zExists2) {
                        str3 = "app_process64";
                    } else {
                        zExists2 = new File("/system/bin/app_process").exists();
                        str3 = "app_process";
                    }
                    if (!zExists2) {
                        return;
                    }
                    str = String.format("export _LD_LIBRARY_PATH=/system/lib64/:/vendor/lib64/:%s", daemonParams.nativeLibraryDir);
                    str2 = String.format("export LD_LIBRARY_PATH=/system/lib64/:/vendor/lib64/:%s", daemonParams.nativeLibraryDir);
                } else {
                    if (!zExists) {
                        zExists = new File("/system/bin/app_process").exists();
                        str3 = "app_process";
                    }
                    if (!zExists) {
                        return;
                    }
                }
            }
            try {
                ShellUtils.exec(new File("/"), null, new String[]{"export CLASSPATH=$CLASSPATH:" + daemonParams.publicSourceDir, str, str2, String.format("%s / %s %s --application --nice-name=%s --daemon &", str3, DaemonEntry.class.getName(), entryParam.toString(), this.processName)});
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Utils.setProcessStarted(false);
        }
    }
}
