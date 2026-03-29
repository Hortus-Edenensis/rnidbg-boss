package com.zenmen.palmchat.modulemanager.lifecircle;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface LifeCircleCallback {
    boolean filter(Activity activity);

    void onStatusChange(Activity activity, Lifecycle.Event event);
}
