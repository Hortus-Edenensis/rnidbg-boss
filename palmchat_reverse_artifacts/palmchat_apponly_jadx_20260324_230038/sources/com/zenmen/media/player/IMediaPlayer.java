package com.zenmen.media.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IMediaPlayer {
    public static final int render_mode_auto = 0;
    public static final int render_mode_letterbox = 1;
    public static final int render_mode_pan_scan = 3;
    public static final int render_mode_pillarbox = 2;

    int GetVideoHeight(int i);

    int GetVideoWidth(int i);

    boolean IsMute();

    void SetHostMetadata(String str);

    void SetImageViewInfo(int i, int i2, int i3, Bitmap bitmap);

    int SetMute(boolean z);

    boolean SetPlaySpeed(float f);

    void SetRenderMode(int i);

    int SetVideoFileUrl(String str, int i);

    void SetVideoProp(int i, int i2, int i3);

    void SetVideoViewInfo(int i, int i2, int i3, Surface surface);

    void StopVideoView(int i);

    int bufferedBandPercent();

    int bufferedBandWidth();

    int bufferedPercent();

    int duration();

    float getBufferPercent();

    int getBufferSize();

    int getCurFreq(short[] sArr, int i);

    int getCurFreqAndWave(short[] sArr, short[] sArr2, int i);

    int getCurWave(short[] sArr, int i);

    int getFileSize();

    int getPosition();

    void pause(boolean z);

    int play();

    void release();

    void resume(boolean z);

    void setActiveNetWorkType(int i);

    void setAudioEffectLowDelay(boolean z);

    void setCacheFilePath(String str);

    void setChannelBalance(float f);

    void setDataSourceAsync(String str, int i) throws Exception;

    void setDecoderType(int i);

    void setHostAddr(String str);

    void setPlayRange(int i, int i2);

    int setPosition(int i, int i2);

    void setProxyServerConfig(String str, int i, String str2, boolean z);

    void setProxyServerConfigByDomain(String str, int i, String str2, boolean z);

    void setSurface(Surface surface);

    void setView(SurfaceView surfaceView);

    void setViewSize(int i, int i2);

    void setVolume(float f, float f2);

    void stop();

    boolean videoSizeChanged(int i, int i2);
}
