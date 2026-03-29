package com.baidu.mshield.x0.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4054a;

    public static void a(Context context, long j) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                d.a(th);
            }
            alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public static int b(Context context) {
        try {
            String strC = new com.baidu.mshield.x0.l.a(context).c("plc33");
            if (!TextUtils.isEmpty(strC)) {
                return new JSONObject(strC).optJSONObject("5").optInt("t", 60);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 60;
    }

    public static void c(Context context) {
        int iB = new com.baidu.mshield.x0.l.a(context).b();
        if (iB == 0) {
            iB = 24;
        }
        a(context, "com.baidu.mshield.x0.detect.app.fr", ((long) iB) * 3600000, 1);
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            alarmManager.cancel(PendingIntent.getBroadcast(context, 100, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, boolean z) {
        f4054a = z;
        a(context, new com.baidu.mshield.x0.l.a(context));
        c(context);
        f4054a = false;
    }

    public static void a(Context context, String str, long j, int i) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            a aVar = new a();
            aVar.f4053a = str;
            aVar.c = jCurrentTimeMillis;
            aVar.b = i;
            a aVarA = com.baidu.mshield.x0.f.a.a(context).a(str);
            if (aVarA != null) {
                long j2 = aVarA.c;
                long jN = new com.baidu.mshield.x0.l.a(context).n();
                if (!f4054a && j2 >= jN) {
                    aVar.c = j2;
                }
            }
            com.baidu.mshield.x0.f.a.a(context).a(aVar);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.l.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.mshield.x0.l.a(context);
        }
        a(context, "com.baidu.mshield.x0.timer.pp.action", ((long) aVar.m()) * 60000, 0);
    }
}
