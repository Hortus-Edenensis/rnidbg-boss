package com.tide.protocol.host;

import com.tide.protocol.context.base.IResource;
import com.tide.protocol.host.model.PluginState;
import com.tide.protocol.plugin.base.ITideApplication;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IPluginLoader {
    ITideApplication getCoreApp();

    IDexLoaderManager getDexLoaderManager();

    String getPluginName();

    String getPluginPath();

    PluginState getPluginState();

    IResource getResourceManager();

    ITideApplication initPlugin();

    void preLoadPlugin();

    void setPluginState(PluginState pluginState);
}
