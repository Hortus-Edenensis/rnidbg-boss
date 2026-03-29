package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LxAdAbsDevice implements LxAdIDevice {
    protected final Context mContext;

    public LxAdAbsDevice(Context context) {
        this.mContext = context;
    }

    public boolean ensureIntent(Intent intent) {
        ActivityInfo activityInfo;
        List<ResolveInfo> listQueryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() == 1 && (activityInfo = listQueryIntentActivities.get(0).activityInfo) != null && activityInfo.exported;
    }

    public Intent getAppDetailIntent() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        intent.setFlags(268435456);
        return intent;
    }
}
