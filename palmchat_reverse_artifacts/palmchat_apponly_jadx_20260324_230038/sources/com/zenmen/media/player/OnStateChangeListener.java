package com.zenmen.media.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface OnStateChangeListener {
    void onBufferFinished();

    void onBufferingDone();

    void onBufferingStarted();

    void onCompleted();

    void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo);

    void onPaused();

    void onPrepared(int i, int i2);

    void onSeekCompleted();

    void onStarted();

    void onVideoFirstFrame();

    void onVideoFormatchanged(int i, int i2);
}
