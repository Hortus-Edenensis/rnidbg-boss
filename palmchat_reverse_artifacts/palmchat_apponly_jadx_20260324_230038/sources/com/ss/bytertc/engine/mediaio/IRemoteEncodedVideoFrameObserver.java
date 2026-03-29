package com.ss.bytertc.engine.mediaio;

import com.ss.bytertc.engine.data.RemoteStreamKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IRemoteEncodedVideoFrameObserver {
    public abstract void onRemoteEncodedVideoFrame(RemoteStreamKey remoteStreamKey, RTCEncodedVideoFrame rTCEncodedVideoFrame);
}
