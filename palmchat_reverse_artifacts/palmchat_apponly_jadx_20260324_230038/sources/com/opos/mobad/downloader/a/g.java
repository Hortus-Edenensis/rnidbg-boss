package com.opos.mobad.downloader.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.downloader.a.c;
import defpackage.sz3;
import defpackage.tz3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f8772a;
    private e b;
    private Context c;

    public g(Context context, e eVar) {
        this.c = context;
        this.f8772a = (NotificationManager) context.getSystemService("notification");
        this.b = eVar;
    }

    private Notification a(int i, e eVar, c.a aVar) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.c).setSmallIcon(eVar.f8769a).setAutoCancel(false).setOnlyAlertOnce(true).setSmallIcon(eVar.f8769a).setContentTitle(aVar.f8766a);
        a(i, contentTitle, aVar);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            tz3.a();
            NotificationChannel notificationChannelA = sz3.a(eVar.c, eVar.d, eVar.e);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setLockscreenVisibility(-1);
            notificationChannelA.setSound(null, null);
            notificationChannelA.setShowBadge(false);
            if (i2 >= 29) {
                notificationChannelA.setImportance(2);
            }
            contentTitle.setChannelId(eVar.c);
            this.f8772a.createNotificationChannel(notificationChannelA);
        }
        return contentTitle.build();
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a() {
        this.f8772a.cancelAll();
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a(int i) {
        this.f8772a.cancel(i);
    }

    private void a(int i, NotificationCompat.Builder builder, c.a aVar) {
        Resources resources;
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = (Build.VERSION.SDK_INT >= 23 ? 67108864 : 0) | 134217728;
        PendingIntent activity = aVar.c == 105 ? PendingIntent.getActivity(this.c, i, aVar.e, i3) : PendingIntent.getService(this.c, i, aVar.e, i3);
        PendingIntent service = PendingIntent.getService(this.c, i, aVar.g, i3);
        switch (aVar.c) {
            case 102:
                sb.append(this.c.getResources().getString(R.string.download_status_new_downloading_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setOngoing(true);
                builder.setProgress(100, aVar.d, false);
                break;
            case 103:
                sb.append(this.c.getResources().getString(R.string.download_status_new_pause_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 105:
                resources = this.c.getResources();
                i2 = R.string.download_status_new_complete_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 106:
                resources = this.c.getResources();
                i2 = R.string.download_status_new_fail_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 107:
                sb.append(this.c.getResources().getString(R.string.download_status_waiting_txt));
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
        }
        builder.setContentText(sb);
    }

    @Override // com.opos.mobad.downloader.a.c
    public void a(int i, c.a aVar) {
        this.f8772a.notify(i, a(i, this.b, aVar));
    }
}
