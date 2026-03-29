package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface RiskDetectResp {
    String getDeviceToken();

    long getErrorCode();

    long getStagePackTimeMillis();

    long getStageReqTimeMillis();

    boolean isDowngrade();
}
