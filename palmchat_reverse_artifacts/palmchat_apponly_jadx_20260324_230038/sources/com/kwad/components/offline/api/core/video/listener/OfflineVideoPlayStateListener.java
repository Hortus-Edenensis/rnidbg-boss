package com.kwad.components.offline.api.core.video.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface OfflineVideoPlayStateListener extends OfflineMediaPlayStateListener {
    void onVideoPlayBufferingPaused();

    void onVideoPlayBufferingPlaying();
}
