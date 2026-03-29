package com.zm.adxsdk.protocol.lifecycle;

import android.app.Activity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IActivityLifecycle {
    Activity getTopStackActivity();

    boolean isAppToBackground();

    void register(ActivityLifecycleCallback activityLifecycleCallback);

    void unregister(ActivityLifecycleCallback activityLifecycleCallback);
}
