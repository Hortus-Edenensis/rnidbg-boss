package com.oplus.tblplayer.utils;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class UnZipUtil {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnZipUtil";

    private static void extractFile(ZipInputStream zipInputStream, String str) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = zipInputStream.read(bArr);
                    if (i == -1) {
                        bufferedOutputStream.close();
                        return;
                    }
                    bufferedOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (IOException e) {
            Log.e(TAG, "extractFile: IOException occurred: " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unzip(String str, String str2) {
        String str3;
        Log.e(TAG, "unzip: zipFilePath " + str + " destDirectory " + str2);
        File file = new File(str2);
        if (!file.exists()) {
            Log.e(TAG, "unzip: destDir does not exist, creating it");
            if (!file.mkdirs()) {
                str3 = "unzip: failed to create destDir";
            } else if (new File(str).exists()) {
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                zipInputStream.close();
                                return true;
                            }
                            String str4 = str2 + File.separator + nextEntry.getName();
                            Log.d(TAG, "unzip: filePath " + str4);
                            if (!nextEntry.isDirectory()) {
                                extractFile(zipInputStream, str4);
                            } else if (!new File(str4).mkdirs()) {
                                Log.e(TAG, "unzip: failed to create directory " + str4);
                            }
                            zipInputStream.closeEntry();
                        } finally {
                        }
                    }
                } catch (IOException e) {
                    str3 = "unzip: IOException occurred: " + e.getMessage();
                }
            } else {
                str3 = "unzip: zipFilePath does not exist";
            }
        }
        Log.e(TAG, str3);
        return false;
    }
}
