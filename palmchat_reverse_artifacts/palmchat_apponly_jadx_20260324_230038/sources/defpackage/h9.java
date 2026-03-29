package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.service.AlarmReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h9 {
    public static void a(Context context) {
        try {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 0));
        } catch (Throwable unused) {
            k63.l("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    public static void b(Context context) {
        tt5.u().R();
        long jS = tt5.u().s() * 1000;
        long jCurrentTimeMillis = System.currentTimeMillis() + jS;
        k63.g("AlarmHelper", "Reset heartbeat alarm, wait " + jS + "ms.");
        try {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setWindow(0, jCurrentTimeMillis, 0L, PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 0));
        } catch (Throwable th) {
            k63.n("AlarmHelper", "can't trigger alarm cause by exception:" + th);
        }
    }
}
