package com.tencent.matrix.plugin;

import android.app.Application;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IPlugin {
    void destroy();

    Application getApplication();

    String getTag();

    void init(Application application, PluginListener pluginListener);

    void onForeground(boolean z);

    void start();

    void stop();
}
