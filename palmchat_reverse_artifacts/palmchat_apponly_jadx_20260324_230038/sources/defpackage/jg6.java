package defpackage;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.vivo.push.PushClientConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class jg6 extends uo {
    @Override // defpackage.uo
    public void c(Context context, int i) {
        try {
            ComponentName componentNameA = t93.a(context);
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", componentNameA.getPackageName());
            intent.putExtra(PushClientConstants.TAG_CLASS_NAME, componentNameA.getClassName());
            intent.putExtra("notificationNum", i);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.addFlags(16777216);
            }
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.uo
    public void d(Context context, Notification notification, int i) {
    }
}
