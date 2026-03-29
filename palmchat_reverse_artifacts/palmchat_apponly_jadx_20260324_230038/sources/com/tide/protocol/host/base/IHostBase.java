package com.tide.protocol.host.base;

import android.content.Context;
import com.tide.protocol.config.ITideHostConfig;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.ITideService;
import com.tide.protocol.host.model.PluginState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IHostBase {
    PluginState getPluginStatus(String str);

    void initPlugin(String str);

    void installToRunPlugin(Context context, String str);

    ITideActivity loadPluginActivity(Context context, String str, String str2);

    ITideService loadPluginService(Context context, String str);

    void preload(Context context, String str);

    void setHostConfig(ITideHostConfig iTideHostConfig);
}
