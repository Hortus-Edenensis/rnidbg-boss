package com.zenmen.media.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IMagicMediaPlayer {
    int getPosition();

    String getVideoPath();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void release();

    void seek(long j);

    void setLoop(boolean z);

    void setResumable(boolean z);

    void setVideo(String str);

    void setVideoAlpha(float f);

    void setVideoStateChangeListener(VideoStateChangeListener videoStateChangeListener);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
