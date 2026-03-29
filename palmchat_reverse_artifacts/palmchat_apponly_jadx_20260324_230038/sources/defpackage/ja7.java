package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ja7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f18366a = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};
    public static final String[] b = {"VmLck:", "VmRSS:", "VmSize:", "VmExe:", "VmStk:", "VmLib", "Threads:"};

    public static Map<String, Long> a() {
        HashMap map = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method != null) {
                String[] strArr = f18366a;
                int length = strArr.length;
                long[] jArr = new long[length];
                jArr[0] = 30;
                jArr[1] = -30;
                method.invoke(null, new String("/proc/meminfo"), strArr, jArr);
                for (int i = 0; i < length; i++) {
                    map.put(f18366a[i], Long.valueOf(jArr[i]));
                }
            }
            return map;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }
}
