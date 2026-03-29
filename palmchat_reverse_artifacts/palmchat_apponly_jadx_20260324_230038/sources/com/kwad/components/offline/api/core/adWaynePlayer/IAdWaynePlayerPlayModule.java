package com.kwad.components.offline.api.core.adWaynePlayer;

import android.view.Surface;
import android.view.SurfaceHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IAdWaynePlayerPlayModule {

    /* JADX INFO: compiled from: SearchBox */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnCompletionListener {
        void onCompletion();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnErrorListener {
        boolean onError(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPreparingListener {
        void onPreparing();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnVseReportListener {
        void onVseReport(String str, String str2);
    }

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    boolean isWaynePlayerReady();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(String str, boolean z);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOnVseReportListener(OnVseReportListener onVseReportListener);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
