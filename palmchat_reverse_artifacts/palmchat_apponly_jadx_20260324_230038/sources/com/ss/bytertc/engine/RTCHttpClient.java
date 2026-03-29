package com.ss.bytertc.engine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface RTCHttpClient {

    /* JADX INFO: compiled from: SearchBox */
    public interface RtcHttpCallback {
        void run(int i, String str);
    }

    void GetAsync(String str, RtcHttpCallback rtcHttpCallback, int i);

    void PostAsync(String str, String str2, RtcHttpCallback rtcHttpCallback, int i);
}
