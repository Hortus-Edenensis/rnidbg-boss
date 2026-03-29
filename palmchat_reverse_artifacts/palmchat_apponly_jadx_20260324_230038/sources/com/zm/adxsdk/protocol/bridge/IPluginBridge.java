package com.zm.adxsdk.protocol.bridge;

import com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IPluginBridge {
    long getPluginVersionCode();

    String getPluginVersionName();

    IWfLoadManager getWfLoadManager();
}
