package com.tide.protocol.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TdFileUtils {
    public static final String FILE_OAT = "oat";
    public static final String OUT_ODEX = "tidex";
    public static final String PLUGIN_FILE = "td";
    public static final String PLUGIN_FILE_TAIL = ".jar";
    private static final String TAG = "TdFileUtils";

    public static boolean copyFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            TdLogUtils.error("copyFile fail cause " + th.getMessage());
            return false;
        }
    }

    public static boolean deleteDirectoryContents(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            if (!file2.delete()) {
                z = false;
            }
        }
        return z;
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        file.delete();
        return true;
    }

    public static boolean deleteFileAndParentDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        boolean zDeleteRecursively = deleteRecursively(file);
        File parentFile = file.getParentFile();
        return (parentFile != null && parentFile.isDirectory() && parentFile.list().length == 0) ? parentFile.delete() && zDeleteRecursively : zDeleteRecursively;
    }

    public static boolean deleteOatFolder(String str) {
        File parentFile;
        if (!TextUtils.isEmpty(str) && (parentFile = new File(str).getParentFile()) != null && parentFile.isDirectory()) {
            File file = new File(parentFile, FILE_OAT);
            if (file.exists()) {
                return deleteFileAndParentDir(file.getAbsolutePath());
            }
        }
        return false;
    }

    private static boolean deleteRecursively(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                deleteRecursively(file2);
            }
        }
        return file.delete();
    }

    public static String getDexOutputDir(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(context.getDir(OUT_ODEX, 0), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static InputStream getFileByteStream(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPluginBaseDir(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            TdLogUtils.error(TAG, "getPluginBaseDir params is empty");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(PLUGIN_FILE);
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getPrivatePluginPath(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TdLogUtils.error(TAG, "getPrivatePluginPath params is empty");
            return null;
        }
        String pluginBaseDir = getPluginBaseDir(context, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(pluginBaseDir);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(PLUGIN_FILE_TAIL);
        return sb.toString();
    }

    public static String getRandomID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }
}
