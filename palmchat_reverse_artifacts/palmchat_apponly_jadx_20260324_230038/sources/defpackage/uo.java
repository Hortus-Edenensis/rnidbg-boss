package defpackage;

import android.app.Notification;
import android.content.Context;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class uo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21252a = -1;

    public void a(Context context, int i) {
        LogUtil.d("BadgeOperator", "updateBadgeCount: " + i);
        if (this.f21252a != i) {
            c(context, i);
            this.f21252a = i;
        }
    }

    public void b(Context context, Notification notification, int i) {
        d(context, notification, i);
    }

    public abstract void c(Context context, int i);

    public abstract void d(Context context, Notification notification, int i);
}
