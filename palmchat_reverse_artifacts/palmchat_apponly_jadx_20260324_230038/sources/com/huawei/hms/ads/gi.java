package com.huawei.hms.ads;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import defpackage.sz3;
import defpackage.tz3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class gi {
    private static final String I = "BaseNotification";
    private static final String Z = "hwpps";
    protected Context Code;
    NotificationManager V;

    public gi(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = (NotificationManager) applicationContext.getSystemService("notification");
    }

    private String F() {
        return "hwpps";
    }

    private Notification.Builder V() {
        Notification.Builder builder = new Notification.Builder(this.Code);
        builder.setContentTitle(Z());
        builder.setContentText(C());
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setContentIntent(S());
        builder.setAutoCancel(true);
        ApplicationInfo applicationInfo = this.Code.getApplicationInfo();
        if (applicationInfo != null) {
            builder.setSmallIcon(applicationInfo.icon);
        }
        return builder;
    }

    public String B() {
        return I;
    }

    public abstract String C();

    public abstract int Code();

    public abstract void Code(Notification.Builder builder);

    public void I() {
        Notification.Builder builderV = V();
        Code(builderV);
        if (Build.VERSION.SDK_INT >= 26) {
            tz3.a();
            NotificationChannel notificationChannelA = sz3.a(F(), B(), 3);
            notificationChannelA.setShowBadge(false);
            notificationChannelA.enableLights(false);
            builderV.setChannelId(F());
            this.V.createNotificationChannel(notificationChannelA);
        }
        this.V.notify(Code(), builderV.build());
    }

    public abstract PendingIntent S();

    public abstract String Z();
}
