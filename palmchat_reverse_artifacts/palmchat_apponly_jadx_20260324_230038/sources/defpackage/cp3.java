package defpackage;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cp3 extends uo {
    @Override // defpackage.uo
    public void d(Context context, Notification notification, int i) {
        if (notification == null) {
            return;
        }
        try {
            Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
            obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.uo
    public void c(Context context, int i) {
    }
}
