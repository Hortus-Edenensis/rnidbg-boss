package defpackage;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class i94 extends uo {
    @Override // defpackage.uo
    public void c(Context context, int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.uo
    public void d(Context context, Notification notification, int i) {
    }
}
