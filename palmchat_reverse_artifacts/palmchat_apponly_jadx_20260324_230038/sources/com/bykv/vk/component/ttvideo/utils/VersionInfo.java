package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;
import com.zm.fda.Z2500.Z0O00.ZZ00Z.O022Z;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VersionInfo {
    private static String[] mVersion;

    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {com.igexin.push.core.b.m, com.igexin.push.core.b.m, com.igexin.push.core.b.m, com.igexin.push.core.b.m};
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(O022Z.m);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                    try {
                        strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                if (fileReader != null) {
                                }
                            } catch (Throwable unused3) {
                                if (fileReader != null) {
                                }
                                strArr[1] = Build.VERSION.RELEASE;
                                strArr[2] = Build.MODEL;
                                strArr[3] = Build.DISPLAY;
                                mVersion = strArr;
                                return mVersion;
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                        } else {
                            if (fileReader != null) {
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                        }
                        return mVersion;
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                fileReader = null;
            }
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
