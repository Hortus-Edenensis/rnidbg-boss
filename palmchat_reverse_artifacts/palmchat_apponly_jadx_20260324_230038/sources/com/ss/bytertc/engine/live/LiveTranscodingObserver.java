package com.ss.bytertc.engine.live;

import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.VideoFrame;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LiveTranscodingObserver {
    private Map<String, ILiveTranscodingObserver> mLiveTransObserver = new HashMap();
    private Map<String, Boolean> mSupportClientPushStream = new HashMap();

    @CalledByNative
    public boolean isSupportClientPushStream(String str) {
        Map<String, Boolean> map = this.mSupportClientPushStream;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        return this.mSupportClientPushStream.get(str).booleanValue();
    }

    @CalledByNative
    public void onCacheSyncVideoFrames(String str, String[] strArr, VideoFrame[] videoFrameArr, byte[][] bArr, int i) {
        Map<String, ILiveTranscodingObserver> map = this.mLiveTransObserver;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.mLiveTransObserver.get(str).onCacheSyncVideoFrames(str, strArr, videoFrameArr, bArr, i);
    }

    @CalledByNative
    public void onMixingAudioFrame(String str, byte[] bArr, int i, long j) {
        Map<String, ILiveTranscodingObserver> map = this.mLiveTransObserver;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.mLiveTransObserver.get(str).onMixingAudioFrame(str, bArr, i, j);
    }

    @CalledByNative
    public void onMixingDataFrame(String str, byte[] bArr, long j) {
        Map<String, ILiveTranscodingObserver> map = this.mLiveTransObserver;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.mLiveTransObserver.get(str).onMixingDataFrame(str, bArr, j);
    }

    @CalledByNative
    public void onMixingVideoFrame(String str, VideoFrame videoFrame) {
        Map<String, ILiveTranscodingObserver> map = this.mLiveTransObserver;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.mLiveTransObserver.get(str).onMixingVideoFrame(str, videoFrame);
    }

    @CalledByNative
    public void onStreamMixingEvent(ByteRTCStreamMixingEvent byteRTCStreamMixingEvent, String str, ByteRTCTranscoderErrorCode byteRTCTranscoderErrorCode, ByteRTCStreamMixingType byteRTCStreamMixingType) {
        Map<String, ILiveTranscodingObserver> map = this.mLiveTransObserver;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.mLiveTransObserver.get(str).onStreamMixingEvent(byteRTCStreamMixingEvent, str, byteRTCTranscoderErrorCode, byteRTCStreamMixingType);
    }

    public void setUserObserver(String str, ILiveTranscodingObserver iLiveTranscodingObserver) {
        if (this.mLiveTransObserver == null) {
            this.mLiveTransObserver = new HashMap();
        }
        if (this.mSupportClientPushStream == null) {
            this.mSupportClientPushStream = new HashMap();
        }
        this.mLiveTransObserver.put(str, iLiveTranscodingObserver);
        if (iLiveTranscodingObserver != null) {
            this.mSupportClientPushStream.put(str, Boolean.valueOf(iLiveTranscodingObserver.isSupportClientPushStream()));
        } else {
            this.mSupportClientPushStream.put(str, Boolean.FALSE);
        }
    }
}
