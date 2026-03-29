package com.opos.cmn.an.h.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.opos.cmn.an.d.b;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ActivityManager f7788a = null;
    private static volatile String b = "";

    public static ActivityManager a(Context context) {
        if (f7788a == null && context != null) {
            f7788a = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        }
        return f7788a;
    }

    public static boolean b(Context context) {
        try {
            if (a(context, context.getPackageName())) {
                return c(context);
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            return false;
        }
    }

    public static boolean c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z = false;
        try {
            ActivityManager activityManagerA = a(context);
            if (activityManagerA != null && (runningAppProcesses = activityManagerA.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.pid == Process.myPid()) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
        }
        return z;
    }

    public static boolean a(Context context, String str) {
        ComponentName componentName;
        try {
            ActivityManager activityManagerA = a(context);
            if (activityManagerA == null || b.a(str)) {
                return false;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManagerA.getRunningTasks(1);
            if (runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null) {
                return false;
            }
            return componentName.getPackageName().equals(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            return false;
        }
    }
}
