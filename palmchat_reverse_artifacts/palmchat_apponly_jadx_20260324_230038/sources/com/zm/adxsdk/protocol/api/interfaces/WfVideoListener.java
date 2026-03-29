package com.zm.adxsdk.protocol.api.interfaces;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface WfVideoListener {
    void onVideoComplete();

    void onVideoContinuePlay();

    void onVideoError(int i, String str);

    void onVideoPause();

    void onVideoPlay();
}
