package com.ss.bytertc.engine.live;

import android.opengl.EGL14;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.video.impl.WebrtcWrapperVideoFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ChorusCacheSyncObserver {
    private IChorusCacheSyncObserver observer = null;

    @CalledByNative
    public void onSyncEvent(ChorusCacheSyncEvent chorusCacheSyncEvent, ChorusCacheSyncError chorusCacheSyncError) {
        IChorusCacheSyncObserver iChorusCacheSyncObserver = this.observer;
        if (iChorusCacheSyncObserver != null) {
            iChorusCacheSyncObserver.onSyncEvent(chorusCacheSyncEvent, chorusCacheSyncError);
        }
    }

    @CalledByNative
    public void onSyncedUsersChanged(int i, String[] strArr) {
        IChorusCacheSyncObserver iChorusCacheSyncObserver = this.observer;
        if (iChorusCacheSyncObserver != null) {
            iChorusCacheSyncObserver.onSyncedUsersChanged(i, strArr);
        }
    }

    @CalledByNative
    public void onSyncedVideoFrames(int i, String[] strArr, VideoFrame[] videoFrameArr) {
        if (this.observer != null) {
            WebrtcWrapperVideoFrame[] webrtcWrapperVideoFrameArr = new WebrtcWrapperVideoFrame[i];
            for (int i2 = 0; i2 < i; i2++) {
                VideoFrame videoFrame = videoFrameArr[i2];
                if (videoFrame != null) {
                    webrtcWrapperVideoFrameArr[i2] = videoFrame.getBuffer().getBufferType() == 4 ? new WebrtcWrapperVideoFrame(videoFrameArr[i2], EGL14.eglGetCurrentContext()) : new WebrtcWrapperVideoFrame(videoFrameArr[i2], null);
                    videoFrameArr[i2].release();
                }
            }
            this.observer.onSyncedVideoFrames(i, strArr, webrtcWrapperVideoFrameArr);
        }
    }

    public void setUserObserver(IChorusCacheSyncObserver iChorusCacheSyncObserver) {
        if (iChorusCacheSyncObserver != null) {
            this.observer = iChorusCacheSyncObserver;
        }
    }
}
