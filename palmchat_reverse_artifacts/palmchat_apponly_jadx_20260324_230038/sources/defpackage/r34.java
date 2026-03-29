package defpackage;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"InlinedApi"})
@Deprecated
public final class r34 {
    public static void a(Context context, String str, @StringRes int i, @StringRes int i2, int i3) {
        if (g86.f17680a >= 26) {
            NotificationManager notificationManager = (NotificationManager) vh.e((NotificationManager) context.getSystemService("notification"));
            tz3.a();
            NotificationChannel notificationChannelA = sz3.a(str, context.getString(i), i3);
            if (i2 != 0) {
                notificationChannelA.setDescription(context.getString(i2));
            }
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }
}
