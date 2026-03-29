package com.zenmen.media.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface VideoStateChangeListener {
    void onVideoCompleted();

    void onVideoError(IMagicMediaPlayer iMagicMediaPlayer, int i);

    void onVideoFirstFrame(IMagicMediaPlayer iMagicMediaPlayer);

    void onVideoStarted(IMagicMediaPlayer iMagicMediaPlayer);

    void onVideoStopped(IMagicMediaPlayer iMagicMediaPlayer);
}
