package org.apache.cordova;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DirectoryManager {
    private static final String LOG_TAG = "DirectoryManager";

    private static File constructFilePaths(String str, String str2) {
        if (str2.startsWith(str)) {
            return new File(str2);
        }
        return new File(str + "/" + str2);
    }

    private static long freeSpaceCalculation(String str) {
        StatFs statFs = new StatFs(str);
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
    }

    public static long getFreeDiskSpace(boolean z) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
        }
        if (z) {
            return freeSpaceCalculation("/");
        }
        return -1L;
    }

    public static String getTempDirectoryPath(Context context) {
        File cacheDir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            cacheDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache/");
        } else {
            cacheDir = context.getCacheDir();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir.getAbsolutePath();
    }

    public static boolean testFileExists(String str) {
        if (!testSaveLocationExists() || str.equals("")) {
            return false;
        }
        return constructFilePaths(Environment.getExternalStorageDirectory().toString(), str).exists();
    }

    public static boolean testSaveLocationExists() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
