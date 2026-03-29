package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITuringDID {
    String getAIDCode();

    String getAIDTicket();

    int getErrorCode();

    long getExpiredTimestamp();

    String getOpenIdTicket();

    String getTAIDTicket();
}
