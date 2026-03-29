package com.lantern.core.database;

import android.app.ActivityManager;
import android.content.Context;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DataStoreUtils {
    private static Long getAvailMemory(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Long.valueOf((memoryInfo.availMem / 1024) / 1024);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getCurrentKeyTime() {
        Date time = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(time);
    }

    public static boolean isLackDiskSpace(Context context) {
        return getAvailMemory(context).longValue() <= 10;
    }
}
