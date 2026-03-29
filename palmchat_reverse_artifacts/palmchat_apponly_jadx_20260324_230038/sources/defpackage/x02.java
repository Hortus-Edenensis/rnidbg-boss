package defpackage;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import com.lantern.daemon.notification.InnerService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class x02 {
    public static void a(Service service, int i) {
        if (Build.VERSION.SDK_INT < 25) {
            service.startForeground(i, new Notification());
            Intent intent = new Intent(service, (Class<?>) InnerService.class);
            intent.putExtra("id", i);
            try {
                service.startService(intent);
            } catch (Exception unused) {
            }
        }
    }
}
