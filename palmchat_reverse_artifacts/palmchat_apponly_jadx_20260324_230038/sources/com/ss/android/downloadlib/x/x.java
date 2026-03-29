package com.ss.android.downloadlib.x;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    public static long u(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return u(file, file.lastModified(), 0);
    }

    private static long u(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, u(file2, j, i2));
                }
            }
        }
        return j;
    }
}
