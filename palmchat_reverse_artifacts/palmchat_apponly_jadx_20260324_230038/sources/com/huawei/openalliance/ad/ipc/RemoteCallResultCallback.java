package com.huawei.openalliance.ad.ipc;

import com.huawei.hms.ads.annotation.AllApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface RemoteCallResultCallback<T> {
    void onRemoteCallResult(String str, CallResult<T> callResult);
}
