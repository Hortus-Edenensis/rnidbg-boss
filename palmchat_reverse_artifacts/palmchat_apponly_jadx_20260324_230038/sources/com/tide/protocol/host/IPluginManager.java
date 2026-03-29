package com.tide.protocol.host;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IPluginManager {
    IPluginLoader getPluginLoader(String str);

    void initPlugin(String str);

    void preloadPlugin(String str, String str2);
}
