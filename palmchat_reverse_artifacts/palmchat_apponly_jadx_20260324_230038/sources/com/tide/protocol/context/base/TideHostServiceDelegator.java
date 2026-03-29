package com.tide.protocol.context.base;

import android.content.Intent;
import android.content.res.Configuration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface TideHostServiceDelegator {
    void callSuperOnConfigurationChanged(Configuration configuration);

    void callSuperOnCreate();

    void callSuperOnDestroy();

    void callSuperOnLowMemory();

    void callSuperOnRebind(Intent intent);

    void callSuperOnStart(Intent intent, int i);

    int callSuperOnStartCommand(Intent intent, int i, int i2);

    void callSuperOnTaskRemoved(Intent intent);

    void callSuperOnTrimMemory(int i);

    boolean callSuperOnUnbind(Intent intent);
}
