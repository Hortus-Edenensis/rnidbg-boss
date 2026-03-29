package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IRTCRoomEventHandlerEx {
    public void onStreamStateChanged(StreamKey streamKey, int i, String str) {
    }

    public void onUserPublishStream(RemoteStreamKey remoteStreamKey, boolean z, MediaStreamType mediaStreamType) {
    }

    public void onUserUnpublishStream(RemoteStreamKey remoteStreamKey, MediaStreamType mediaStreamType, StreamRemoveReason streamRemoveReason) {
    }

    public void onStreamSubscribed(int i, String str, StreamIndex streamIndex, SubscribeConfig subscribeConfig) {
    }
}
