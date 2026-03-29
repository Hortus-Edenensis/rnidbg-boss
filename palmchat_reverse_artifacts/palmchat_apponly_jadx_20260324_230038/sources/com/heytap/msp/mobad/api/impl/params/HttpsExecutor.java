package com.heytap.msp.mobad.api.impl.params;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface HttpsExecutor {
    NetResponse execute(Context context, long j, NetRequest netRequest) throws Exception;

    void shutDown(long j) throws Exception;
}
