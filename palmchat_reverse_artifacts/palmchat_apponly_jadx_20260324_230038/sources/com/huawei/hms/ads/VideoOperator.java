package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.GlobalApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public interface VideoOperator {
    float getAspectRatio();

    VideoLifecycleListener getVideoLifecycleListener();

    boolean hasVideo();

    boolean isClickToFullScreenEnabled();

    boolean isCustomizeOperateEnabled();

    boolean isMuted();

    void mute(boolean z);

    void pause();

    void play();

    void setVideoLifecycleListener(VideoLifecycleListener videoLifecycleListener);

    void stop();

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public static abstract class VideoLifecycleListener {
        @GlobalApi
        public VideoLifecycleListener() {
        }

        @GlobalApi
        public void onVideoEnd() {
        }

        @GlobalApi
        public void onVideoPause() {
        }

        @GlobalApi
        public void onVideoPlay() {
        }

        @GlobalApi
        public void onVideoStart() {
        }

        @GlobalApi
        public void onVideoMute(boolean z) {
        }
    }
}
