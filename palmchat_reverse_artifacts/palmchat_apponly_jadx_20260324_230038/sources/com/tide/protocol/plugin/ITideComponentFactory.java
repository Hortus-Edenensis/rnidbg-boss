package com.tide.protocol.plugin;

import android.content.Context;
import android.content.Intent;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.ITideBroadcastReceiver;
import com.tide.protocol.context.ITideContentProvider;
import com.tide.protocol.context.ITideService;
import com.tide.protocol.plugin.base.ITideApplication;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideComponentFactory {
    ITideActivity instantiateActivity(String str);

    ITideApplication instantiateApplication(String str, Context context);

    ITideContentProvider instantiateProvider(String str);

    ITideBroadcastReceiver instantiateReceiver(String str, Intent intent);

    ITideService instantiateService(String str);

    ITideService instantiateService(String str, Intent intent);
}
