package com.tide.protocol.service;

import com.tide.protocol.host.model.PluginUpdateInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IPluginUpdate {
    void checkUpdate(String str);

    void downloadPlugin(PluginUpdateInfo pluginUpdateInfo, String str);
}
