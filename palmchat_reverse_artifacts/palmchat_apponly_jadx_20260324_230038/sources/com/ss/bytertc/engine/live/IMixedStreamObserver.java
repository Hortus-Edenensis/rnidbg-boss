package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.VideoFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IMixedStreamObserver {
    boolean isSupportClientPushStream();

    void onCacheSyncVideoFrames(String str, String[] strArr, VideoFrame[] videoFrameArr, byte[][] bArr, int i);

    void onMixingAudioFrame(String str, byte[] bArr, int i, long j);

    void onMixingDataFrame(String str, byte[] bArr, long j);

    void onMixingEvent(ByteRTCStreamMixingEvent byteRTCStreamMixingEvent, String str, ByteRTCTranscoderErrorCode byteRTCTranscoderErrorCode, MixedStreamType mixedStreamType);

    void onMixingVideoFrame(String str, VideoFrame videoFrame);
}
