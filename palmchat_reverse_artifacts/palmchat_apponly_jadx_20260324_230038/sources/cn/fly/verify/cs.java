package cn.fly.verify;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import defpackage.i04;
import defpackage.u67;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cs implements dg<NotificationManager> {
    @Override // cn.fly.verify.dg
    public boolean a(NotificationManager notificationManager, Class<NotificationManager> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (ed.a("025cPdj fdif>ehed$i4diefdiIcdi-diedVe!gk_hdeefg").equals(str) && Build.VERSION.SDK_INT >= 26 && objArr.length == 1 && u67.a(objArr[0])) {
            notificationManager.createNotificationChannel(i04.a(objArr[0]));
            return true;
        }
        if (ed.a("006e!ed0iWdiefdk").equals(str)) {
            if (objArr.length == 2) {
                notificationManager.notify(((Integer) objArr[0]).intValue(), (Notification) objArr[1]);
                return true;
            }
            if (objArr.length == 3) {
                notificationManager.notify((String) objArr[0], ((Integer) objArr[1]).intValue(), (Notification) objArr[2]);
                return true;
            }
        } else {
            if (ed.a("025[dcIfgfifOehed[iQdiefdiQcdi diedDeAgkRhdeefg").equals(str) && Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
                notificationManager.deleteNotificationChannel((String) objArr[0]);
                return true;
            }
            if (ed.a("006cdecfg").equals(str)) {
                if (objArr.length == 1) {
                    notificationManager.cancel(((Integer) objArr[0]).intValue());
                    return true;
                }
                if (objArr.length == 2) {
                    notificationManager.cancel((String) objArr[0], ((Integer) objArr[1]).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
