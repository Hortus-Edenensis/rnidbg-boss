package defpackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class sl7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20777a = null;
    public static Class<?> b = null;
    public static Field c = null;
    public static Field d = null;
    public static boolean e = false;

    @Nullable
    public static String a(Context context) {
        String str = f20777a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            f20777a = hg7.d(context);
        } catch (Throwable unused) {
        }
        String str2 = f20777a;
        return str2 == null ? "" : str2;
    }

    public static boolean b(Context context) {
        return false;
    }

    public static int c(Context context) {
        Class<?> clsM = m(context);
        if (d == null && clsM != null) {
            try {
                d = clsM.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    public static void d(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", hm7.a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static boolean e(Context context) {
        String strA = a(context);
        if (strA != null && strA.contains(":")) {
            return false;
        }
        if (strA == null || !strA.equals(context.getPackageName())) {
            return strA != null && strA.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    @NonNull
    public static String f(Context context) {
        Class<?> clsM = m(context);
        if (c == null && clsM != null) {
            try {
                c = clsM.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = c;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static long g(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * 1024;
    }

    @Nullable
    public static ActivityManager.ProcessErrorStateInfo h(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    public static void i(@NonNull Context context, @NonNull JSONObject jSONObject) {
        try {
            j(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                d(jSONObject, activityManager);
            }
            k(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    public static void j(@NonNull JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", g(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", g(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", g(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", g(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", g(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", g(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", g(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", g(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", qi7.c(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", g(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", qi7.b(memoryInfo));
        jSONObject2.put("totalSharedDirty", g(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", g(qi7.a(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static void k(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    public static boolean l(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                if (packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Nullable
    public static Class<?> m(Context context) {
        if (b == null && !e) {
            try {
                b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            e = true;
        }
        return b;
    }
}
