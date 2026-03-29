package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT < 23) {
            return 0L;
        }
        String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (TextUtils.isEmpty(memoryStat)) {
                return 0L;
            }
            return Long.parseLong(memoryStat);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        r5 = java.lang.Long.parseLong(r8.group());
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        BufferedReader bufferedReader;
        StringBuilder sb;
        long j;
        long j2 = -1;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/status")));
            try {
                sb = new StringBuilder();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append('\n');
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused3) {
                }
            }
            return j2;
        }
        String[] strArrSplit = sb.toString().trim().split("\n");
        int length = strArrSplit.length;
        int length2 = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                j = -1;
                break;
            }
            String str = strArrSplit[i];
            if (str.startsWith("VmSize")) {
                Matcher matcher = Pattern.compile("\\d+").matcher(str);
                if (matcher.find()) {
                    break;
                }
                if (bufferedReader != null) {
                }
                return j2;
            }
            i++;
        }
        if (j == -1 && length > 12) {
            try {
                Matcher matcher2 = Pattern.compile("\\d+").matcher(strArrSplit[12]);
                if (matcher2.find()) {
                    j = Long.parseLong(matcher2.group());
                }
            } catch (Throwable unused4) {
                j2 = j;
            }
        }
        try {
            bufferedReader.close();
            return j;
        } catch (Throwable unused5) {
            return j;
        }
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
