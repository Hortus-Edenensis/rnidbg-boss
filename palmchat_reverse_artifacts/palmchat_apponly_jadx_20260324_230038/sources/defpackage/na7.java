package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class na7 {
    public static String a() {
        try {
            String str = Build.BRAND;
            return (TextUtils.isEmpty(str) || str.equals("unknown")) ? Build.MANUFACTURER : str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return false;
        }
        try {
            int iMyPid = Process.myPid();
            String str = "";
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == iMyPid) {
                        str = next.processName;
                        break;
                    }
                }
                return str.equals(context.getPackageName());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean d(Context context, Intent intent) {
        if (intent != null && context != null) {
            try {
                List<ResolveInfo> listQueryIntentServices = context.getApplicationContext().getPackageManager().queryIntentServices(intent, 0);
                if (listQueryIntentServices != null) {
                    return listQueryIntentServices.size() > 0;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? false : true;
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(b(str, null));
    }

    public static String g(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "" : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean h(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean i(Context context, String str) {
        Object systemService = context.getSystemService("usagestats");
        if (systemService == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - 30000;
        try {
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Long.TYPE;
            List list = (List) cls.getMethod("queryUsageStats", Integer.TYPE, cls2, cls2).invoke(systemService, 4, Long.valueOf(j), Long.valueOf(jCurrentTimeMillis));
            if (list != null && list.size() > 0) {
                for (Object obj : list) {
                    obj.getClass().getDeclaredField("mLaunchCount").getInt(obj);
                    if (((String) obj.getClass().getDeclaredField("mPackageName").get(obj)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            File externalFilesDir = context.getExternalFilesDir("wfc");
            if (externalFilesDir != null && externalFilesDir.exists()) {
                for (File file : externalFilesDir.listFiles()) {
                    if (file.getName().equalsIgnoreCase("debug")) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean k(Context context) {
        return ((AudioManager) context.getApplicationContext().getSystemService("audio")).isMusicActive();
    }

    public static int l(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean m(Context context) {
        return h(context, new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
    }

    public static boolean n(Context context) {
        if (!m(context)) {
            return true;
        }
        try {
            Object systemService = context.getSystemService("appops");
            return ((Integer) systemService.getClass().getMethod("checkOpNoThrow", String.class, Integer.TYPE, String.class).invoke(systemService, "android:get_usage_stats", Integer.valueOf(Process.myUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
