package com.umeng.innner.umcrash;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UMCrashUtil {
    private static final int MAX_THREAD_TRACE_LENGTH = 20480;
    private static final String TAG = "UMCrashUtil";

    public static Map<String, String> getAllThreadTraces() {
        HashMap map = new HashMap();
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces == null) {
                return null;
            }
            Thread thread = Looper.getMainLooper().getThread();
            if (!allStackTraces.containsKey(thread)) {
                allStackTraces.put(thread, thread.getStackTrace());
            }
            long id = Thread.currentThread().getId();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                if (id != entry.getKey().getId()) {
                    int i = 0;
                    sb.setLength(0);
                    if (entry.getValue() != null && entry.getValue().length != 0) {
                        StackTraceElement[] value = entry.getValue();
                        int length = value.length;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            StackTraceElement stackTraceElement = value[i];
                            if (sb.length() >= 20480) {
                                sb.append("\n[Stack trace size must be less than :");
                                sb.append(20480);
                                sb.append("!]");
                                break;
                            }
                            sb.append("  at ");
                            sb.append(stackTraceElement.toString());
                            sb.append("\n");
                            i++;
                        }
                        map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }
}
