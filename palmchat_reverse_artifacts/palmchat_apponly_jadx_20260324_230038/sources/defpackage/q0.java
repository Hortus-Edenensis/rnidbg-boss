package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class q0 implements ol2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20145a;

    public q0(Context context) {
        this.f20145a = context;
    }

    public boolean a(Intent intent) {
        ActivityInfo activityInfo;
        List<ResolveInfo> listQueryIntentActivities = this.f20145a.getPackageManager().queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() == 1 && (activityInfo = listQueryIntentActivities.get(0).activityInfo) != null && activityInfo.exported;
    }
}
