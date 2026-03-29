package defpackage;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e25 extends uo {
    @Override // defpackage.uo
    public void c(Context context, int i) {
        try {
            ComponentName componentNameA = t93.a(context);
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", componentNameA.getPackageName());
            intent.putExtra("badge_count_class_name", componentNameA.getClassName());
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.uo
    public void d(Context context, Notification notification, int i) {
    }
}
