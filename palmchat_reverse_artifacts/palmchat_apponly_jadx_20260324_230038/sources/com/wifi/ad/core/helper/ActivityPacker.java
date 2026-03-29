package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ActivityPacker {
    private WeakReference<Activity> mActivityRef;
    private Context mAppContext;

    public ActivityPacker(Activity activity) {
        this.mAppContext = activity.getApplicationContext();
        this.mActivityRef = new WeakReference<>(activity);
    }

    public Activity getActivityIfExist() {
        return this.mActivityRef.get();
    }

    public Context getAppContext() {
        return this.mAppContext;
    }
}
