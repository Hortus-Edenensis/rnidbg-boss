package com.oplus.tblplayer.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static File getDirectoryByName(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        File externalFilesDir = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                externalFilesDir = applicationContext.getExternalFilesDir(str);
            } catch (Exception unused) {
                LogUtil.e("FileUtil", " get external files dir failed. ");
            }
        }
        return externalFilesDir == null ? applicationContext.getDir(str, 0) : externalFilesDir;
    }

    public static File getDirectoryByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        return null;
    }
}
