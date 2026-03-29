package com.baidu.mshield.b.a;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static String[] a(String str) {
        String[] strArr = {"", "", "", ""};
        try {
            File file = new File(str);
            if (file.exists()) {
                if (Build.VERSION.SDK_INT <= 22) {
                    strArr[2] = a(file.lastModified(), "yyyy-MM-dd HH:mm:ss");
                    return strArr;
                }
                for (String str2 : f.a("stat " + file.getAbsolutePath(), false).b.split("\\|")) {
                    if (str2.contains("Device")) {
                        String[] strArrSplit = str2.split("Inode:");
                        if (strArrSplit.length > 1) {
                            String[] strArrSplit2 = strArrSplit[1].split("Links");
                            if (strArrSplit2.length > 0) {
                                strArr[0] = strArrSplit2[0].trim();
                            }
                        }
                    }
                    if (str2.contains("Access") && !str2.contains("Uid")) {
                        com.baidu.mshield.b.c.a.b("access " + str2);
                        String[] strArrSplit3 = str2.split("Access:");
                        if (strArrSplit3.length > 1) {
                            strArr[1] = strArrSplit3[1].trim();
                        }
                    }
                    if (str2.contains("Modify")) {
                        com.baidu.mshield.b.c.a.b("Modify " + str2);
                        String[] strArrSplit4 = str2.split("Modify:");
                        if (strArrSplit4.length > 1) {
                            strArr[2] = strArrSplit4[1].trim();
                        }
                    }
                    if (str2.contains("Change")) {
                        com.baidu.mshield.b.c.a.b("Change " + str2);
                        String[] strArrSplit5 = str2.split("Change:");
                        if (strArrSplit5.length > 1) {
                            strArr[3] = strArrSplit5[1].trim();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return strArr;
    }

    public static String a(long j, String str) {
        if (j >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j));
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return "";
    }
}
