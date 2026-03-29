package com.zm.adxsdk.protocol.variant;

import android.content.Context;
import com.zm.adxsdk.protocol.api.WfConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfSdk {
    void init(Context context, WfConfig wfConfig, InitCallback initCallback);
}
