package com.tide.protocol.host;

import android.content.Context;
import com.tide.protocol.config.ITideHostConfig;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.ITideService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IHostApp {
    IPluginManager getPluginManager();

    String getProxyActivityClass(String str, String str2);

    String getProxyServiceClass(String str, String str2);

    void initPlugin(String str);

    void installToRunPlugin(Context context, String str, String str2);

    ITideActivity loadPluginActivity(Context context, String str, String str2);

    ITideService loadPluginService(Context context, String str, String str2);

    void preload(Context context, String str, String str2);

    void setHostConfig(ITideHostConfig iTideHostConfig);
}
