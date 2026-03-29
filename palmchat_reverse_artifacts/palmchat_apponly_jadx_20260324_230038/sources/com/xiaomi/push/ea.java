package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.dz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class ea implements dz.a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f357a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f11531a = 0;

    public ea(Context context) {
        this.f358a = null;
        this.f358a = context;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f358a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            this.f357a = PendingIntent.getBroadcast(this.f358a, 0, intent, 33554432);
        } else {
            this.f357a = PendingIntent.getBroadcast(this.f358a, 0, intent, 0);
        }
        if (i >= 31 && !j.m651a(this.f358a)) {
            alarmManager.set(2, j, this.f357a);
        } else if (i >= 23) {
            aw.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f357a);
        } else {
            a(alarmManager, j, this.f357a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a(boolean z) {
        long jM747a = com.xiaomi.push.service.m.a(this.f358a).m747a();
        if (z || this.f11531a != 0) {
            if (z) {
                a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f11531a == 0) {
                this.f11531a = jElapsedRealtime + (jM747a - (jElapsedRealtime % jM747a));
            } else if (this.f11531a <= jElapsedRealtime) {
                this.f11531a += jM747a;
                if (this.f11531a < jElapsedRealtime) {
                    this.f11531a = jElapsedRealtime + jM747a;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.an.q);
            intent.setPackage(this.f358a.getPackageName());
            a(intent, this.f11531a);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a() {
        if (this.f357a != null) {
            try {
                ((AlarmManager) this.f358a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f357a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f357a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.f11531a = 0L;
                throw th;
            }
            this.f357a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.f11531a = 0L;
        }
        this.f11531a = 0L;
    }

    @Override // com.xiaomi.push.dz.a
    /* JADX INFO: renamed from: a */
    public boolean mo396a() {
        return this.f11531a != 0;
    }
}
