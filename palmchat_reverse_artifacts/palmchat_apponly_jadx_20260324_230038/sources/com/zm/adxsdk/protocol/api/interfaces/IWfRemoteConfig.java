package com.zm.adxsdk.protocol.api.interfaces;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfRemoteConfig {
    public static final String KEY = "com.zm.adxsdk.protocol.api.interfaces.IWfRemoteConfig";

    JSONObject getConfig(String str);

    void registerConfig(String str);
}
