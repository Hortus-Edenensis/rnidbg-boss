package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCVideoFrameObserver {
    private static final String TAG = "RtcVideoFrameObserver";

    @CalledByNative
    public void onLocalScreenFrame(VideoFrame videoFrame) throws Exception {
        try {
            videoFrame.release();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @CalledByNative
    public void onLocalVideoFrame(VideoFrame videoFrame) throws Exception {
        try {
            videoFrame.release();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @CalledByNative
    public void onMergeFrame(String str, String str2, VideoFrame videoFrame) throws Exception {
        try {
            videoFrame.release();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @CalledByNative
    public void onRemoteScreenFrame(String str, String str2, VideoFrame videoFrame) throws Exception {
        try {
            videoFrame.release();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @CalledByNative
    public void onRemoteVideoFrame(String str, String str2, VideoFrame videoFrame) throws Exception {
        try {
            videoFrame.release();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
