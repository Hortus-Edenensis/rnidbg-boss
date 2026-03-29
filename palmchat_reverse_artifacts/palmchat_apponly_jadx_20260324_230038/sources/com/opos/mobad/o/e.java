package com.opos.mobad.o;

import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    private static int a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i = 0;
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Thread thread : allStackTraces.keySet()) {
                if (thread.getName().startsWith("single_thread") || thread.getName().startsWith("comp_thread") || thread.getName().startsWith("io_thread") || thread.getName().startsWith("scheduled_thread")) {
                    i++;
                }
            }
        }
        return i;
    }

    private static int b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("sysContext", "get proc dir fail", th);
            return 0;
        }
    }

    public static String a(@Nullable Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            long jMaxMemory = Runtime.getRuntime().maxMemory();
            long j = Runtime.getRuntime().totalMemory();
            jSONObject.put("dmm", jMaxMemory);
            jSONObject.put("dtm", j);
        } catch (Throwable unused) {
        }
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j2 = memoryInfo.totalMem;
                long j3 = memoryInfo.availMem;
                jSONObject.put("mm", j2);
                jSONObject.put("am", j3);
            } catch (Throwable unused2) {
            }
        }
        try {
            jSONObject.put("limits", a("/proc/self/limits"));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("status", a("/proc/self/status"));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("oposThreads", a());
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("pfd", b("/proc/self/fd"));
        } catch (Throwable unused6) {
        }
        return jSONObject.toString();
    }

    private static String a(String str) {
        return a(str, 50);
    }

    private static String a(String str, int i) {
        BufferedReader bufferedReader;
        int i2;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            i2 = 0;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("sysContext", "get info fail", th);
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String strTrim = line.trim();
                if (strTrim.length() > 0) {
                    i2++;
                    if (i == 0 || i2 <= i) {
                        sb.append("  ");
                        sb.append(strTrim);
                        sb.append("\n");
                    }
                }
                return sb.toString();
            } finally {
            }
            com.opos.cmn.an.f.a.b("sysContext", "get info fail", th);
        }
        if (i > 0 && i2 > i) {
            sb.append("  ......\n");
            sb.append("  (number of records: ");
            sb.append(i2);
            sb.append(")\n");
        }
        bufferedReader.close();
        return sb.toString();
    }
}
