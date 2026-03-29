package com.opos.mobad.downloader.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.opos.mobad.downloader.a.c;
import defpackage.sz3;
import defpackage.tz3;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f8764a;
    private NotificationCompat.Builder b;
    private Notification c;
    private Notification d;
    private RemoteViews e;
    private Context f;
    private f g;
    private HashSet<Integer> h = new HashSet<>();

    public a(Context context, e eVar) {
        this.f = context;
        this.f8764a = (NotificationManager) context.getSystemService("notification");
        this.c = a(eVar, eVar.b, true, false);
        this.d = Build.VERSION.SDK_INT >= 23 ? a(eVar, true, false, true) : a(eVar, false, true, true);
        this.g = new f(this.f);
    }

    private Notification a(e eVar, boolean z, boolean z2, boolean z3) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f);
        this.b = builder;
        builder.setSmallIcon(eVar.f8769a);
        this.b.setAutoCancel(z);
        this.b.setOngoing(z2);
        this.b.setOnlyAlertOnce(true);
        this.b.setContentTitle(z3 ? "应用下载完成" : "应用下载");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            tz3.a();
            NotificationChannel notificationChannelA = sz3.a(eVar.c, eVar.d, eVar.e);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setLockscreenVisibility(-1);
            notificationChannelA.setSound(null, null);
            notificationChannelA.setShowBadge(false);
            if (i >= 29) {
                notificationChannelA.setImportance(2);
            }
            this.b.setChannelId(eVar.c);
            this.f8764a.createNotificationChannel(notificationChannelA);
        }
        return this.b.build();
    }

    private void b(int i) {
        Notification notification = this.c;
        notification.contentView = this.e;
        this.f8764a.notify(i, notification);
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a() {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelAllNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.clear();
        }
        NotificationManager notificationManager = this.f8764a;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        this.g.a();
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a(int i) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.remove(Integer.valueOf(i));
        }
        NotificationManager notificationManager = this.f8764a;
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
        f fVar = this.g;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    private void a(int i, PendingIntent pendingIntent) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "show showNotificationCancelable:" + i + ",intent:" + pendingIntent);
        if (pendingIntent != null) {
            this.d.deleteIntent = pendingIntent;
        }
        Notification notification = this.d;
        notification.contentView = this.e;
        this.f8764a.notify(i, notification);
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a(int i, c.a aVar) {
        int i2 = aVar.c;
        String str = aVar.f8766a;
        String str2 = aVar.b;
        Intent intent = aVar.e;
        Intent intent2 = aVar.f;
        if (i2 == 105) {
            a(str, str2, i2, intent, intent2, aVar.g, i, aVar.d);
        } else {
            a(str, str2, i2, intent, intent2, i, aVar.d);
        }
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, int i2, int i3) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews remoteViewsA = this.g.a(str, str2, i, i3, i2);
        int i4 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (this.h.contains(Integer.valueOf(i2))) {
            int i5 = i4 | 134217728;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i5));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
        } else {
            int i6 = i4 | 268435456;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i6));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i6));
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.e = remoteViewsA;
        b(i2);
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, Intent intent3, int i2, int i3) {
        PendingIntent service;
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews remoteViewsA = this.g.a(str, str2, i, i3, i2);
        int i4 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (!this.h.contains(Integer.valueOf(i2))) {
            int i5 = i4 | 268435456;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i5));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
            service = PendingIntent.getService(this.f, i2, intent3, i5);
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        } else {
            int i6 = i4 | 134217728;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i6));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.downloader.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i6));
            service = PendingIntent.getService(this.f, i2, intent3, i6);
        }
        this.e = remoteViewsA;
        a(i2, service);
    }
}
