package com.baidu.mshield.b.a;

import android.os.Build;
import android.os.Process;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {
    public static String a() {
        try {
            String[] strArr = Build.SUPPORTED_ABIS;
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(',');
            }
            return sb.toString().substring(0, r0.length() - 1);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static int b() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        com.baidu.mshield.b.c.a.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c() {
        File file;
        Throwable th;
        BufferedReader bufferedReader;
        String line;
        if (Build.VERSION.SDK_INT > 22) {
            return Process.is64Bit();
        }
        try {
            file = new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/maps");
        } catch (Throwable th2) {
            com.baidu.mshield.b.c.a.a(th2);
        }
        if (file.exists()) {
            try {
            } catch (IOException e) {
                com.baidu.mshield.b.c.a.a(e);
            }
            if (!file.isDirectory()) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
                do {
                    try {
                        line = bufferedReader.readLine();
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            com.baidu.mshield.b.c.a.a(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return false;
                        } finally {
                        }
                    }
                    if (line == null) {
                        bufferedReader.close();
                    }
                    return false;
                } while (!line.contains("/system/lib64/libc.so"));
                bufferedReader.close();
                return true;
            }
        }
        return false;
    }
}
