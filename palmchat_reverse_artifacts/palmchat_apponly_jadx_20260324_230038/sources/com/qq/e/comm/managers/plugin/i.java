package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f10444a;

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = f10444a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        boolean zEndsWith = str2.endsWith("_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(zEndsWith ? "" : "_");
        sb.append(d.a(str2));
        return sb.toString();
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(f10444a)) {
            return f10444a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            f10444a = Application.getProcessName();
            return f10444a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        f10444a = next.processName;
                        return f10444a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }
}
