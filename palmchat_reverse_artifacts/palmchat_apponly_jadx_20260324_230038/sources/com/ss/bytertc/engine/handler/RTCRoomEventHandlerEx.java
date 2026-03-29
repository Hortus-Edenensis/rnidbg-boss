package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCRoomEventHandlerEx {
    private static final String TAG = "RtcRoomEventHandlerEx";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandlerEx(RTCRoomImpl rTCRoomImpl) {
        this.mRtcRoom = rTCRoomImpl;
    }

    @CalledByNative
    public void onStreamStateChanged(StreamKey streamKey, int i, String str) {
        LogUtil.d(TAG, "onStreamStateChanged streamIndex: " + streamKey.getStreamIndex());
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onStreamStateChanged(streamKey, i, str);
            }
        } catch (Exception e) {
            LogUtil.d(TAG, "onStreamStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    @CalledByNative
    public void onStreamSubscribed(int i, String str, StreamIndex streamIndex, SubscribeConfig subscribeConfig) {
        LogUtil.d(TAG, "onStreamSubscribed...");
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onStreamSubscribed(i, str, streamIndex, subscribeConfig);
            }
        } catch (Exception e) {
            LogUtil.d(TAG, "onStreamSubscribed callback catch exception.\n" + e.getMessage());
        }
    }

    @CalledByNative
    public void onUserPublishStream(RemoteStreamKey remoteStreamKey, boolean z, int i) {
        LogUtil.d(TAG, "onUserPublishStream streamIndex: " + remoteStreamKey.getStreamIndex());
        try {
            IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
            if (rtcRoomHandlerEx != null) {
                rtcRoomHandlerEx.onUserPublishStream(remoteStreamKey, z, MediaStreamType.valueOf(i));
            }
        } catch (Exception e) {
            LogUtil.d(TAG, "onUserPublishStream callback catch exception.\n" + e.getMessage());
        }
    }

    @CalledByNative
    public void onUserUnpublishStream(RemoteStreamKey remoteStreamKey, int i, int i2) {
        LogUtil.d(TAG, "onUserUnpublishStream streamIndex: " + remoteStreamKey.getStreamIndex());
        if (i2 >= 0) {
            try {
                if (i2 > StreamRemoveReason.STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED.value()) {
                    LogUtil.d(TAG, "onUserUnpublishStream callback reason invalid.\n");
                    i2 = 0;
                }
            } catch (Exception e) {
                LogUtil.d(TAG, "onUserUnpublishStream callback catch exception.\n" + e.getMessage());
                return;
            }
        } else {
            LogUtil.d(TAG, "onUserUnpublishStream callback reason invalid.\n");
            i2 = 0;
        }
        IRTCRoomEventHandlerEx rtcRoomHandlerEx = this.mRtcRoom.getRtcRoomHandlerEx();
        if (rtcRoomHandlerEx != null) {
            rtcRoomHandlerEx.onUserUnpublishStream(remoteStreamKey, MediaStreamType.valueOf(i), StreamRemoveReason.values()[i2]);
        }
    }
}
