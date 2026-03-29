package com.lantern.daemon.dp3.utils;

import android.content.Context;
import android.util.Log;
import com.lantern.daemon.dp3.DaemonHelper;
import com.lantern.daemon.dp3.DaemonNative;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Utils {
    public static boolean daemonStarted = false;
    public static boolean processStarted = false;

    public static boolean holdFileLock(String[] strArr) {
        try {
            File file = new File(DaemonHelper.instance().getDaemonParams().dir);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (String str : strArr) {
                File file2 = new File(file, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                if (DaemonNative.naHoldFileLock(file2.getAbsolutePath()) != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.d(DaemonHelper.TAG, "holdFileLock: " + e.getMessage());
            return false;
        }
    }

    public static boolean setDaemonStarted(boolean z) {
        daemonStarted = z;
        return z;
    }

    public static boolean setProcessStarted(boolean z) {
        processStarted = z;
        return z;
    }

    public static boolean startAppProcess(Context context, String[] strArr, String str) {
        try {
            File file = new File(DaemonHelper.instance().getDaemonParams().dir);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] strArr2 = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                File file2 = new File(file, strArr[i]);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                strArr2[i] = file2.getAbsolutePath();
            }
            startAppProcessThreads(context, strArr2, str);
            return true;
        } catch (Exception e) {
            Log.d(DaemonHelper.TAG, "holdFileLock: " + e.getMessage());
            return false;
        }
    }

    public static void startAppProcessThreads(Context context, String[] strArr, String str) {
        synchronized (Utils.class) {
            if (!processStarted) {
                try {
                    processStarted = true;
                    new ThreadAppProcess(context, strArr, str).start();
                } catch (Throwable th) {
                    Log.d(DaemonHelper.TAG, "holdFileLock: " + th.getMessage());
                }
            }
        }
    }

    public static boolean startDaemon(Context context, String[] strArr) {
        try {
            File file = new File(DaemonHelper.instance().getDaemonParams().dir);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] strArr2 = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                File file2 = new File(file, strArr[i]);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                strArr2[i] = file2.getAbsolutePath();
            }
            startDaemonThreads(context, strArr2);
            return true;
        } catch (Exception e) {
            Log.d(DaemonHelper.TAG, "holdFileLock: " + e.getMessage());
            return false;
        }
    }

    public static void startDaemonThreads(Context context, String[] strArr) {
        synchronized (Utils.class) {
            if (!daemonStarted) {
                try {
                    daemonStarted = true;
                    new ThreadDaemon(context, strArr).start();
                } catch (Throwable th) {
                    Log.d(DaemonHelper.TAG, "holdFileLock: " + th.getMessage());
                }
            }
        }
    }
}
