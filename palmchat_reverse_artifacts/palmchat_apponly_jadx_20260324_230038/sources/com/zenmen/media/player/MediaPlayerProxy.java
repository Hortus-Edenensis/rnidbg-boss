package com.zenmen.media.player;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import com.zenmen.media.player.ZMMediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class MediaPlayerProxy {
    public static final int HUNDRED = 100;
    public static final int MEDIAINFO_FROM_FILEFORMAT = -1;
    private static final String TAG = "MediaPlayer";
    private OnContextChangeListener mContextChangedListener;
    private IMediaPlayer mCurMediaPlayer;
    private OnLogListener mLogListener;
    private OnStateChangeListener mStateChangeListener;
    private final int K_FREQUENCY_NUMBER = 512;
    private short[] mFreqBuffer = new short[512];
    private PlayStatus mPlayStatus = PlayStatus.STATUS_STOPPED;
    private SurfaceView mSurfaceView = null;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mScreenWidth = 0;
    private int mScreenHeight = 0;
    private boolean mIsMV = false;
    private ZMMediaPlayer.OnMediaPlayerNotifyLogListener mMediaPlayerNotifyLogListener = new ZMMediaPlayer.OnMediaPlayerNotifyLogListener() { // from class: com.zenmen.media.player.MediaPlayerProxy.1
        @Override // com.zenmen.media.player.ZMMediaPlayer.OnMediaPlayerNotifyLogListener
        public void onMediaPlayerNotifyLog(int i, Object obj, Object obj2) {
            if (MediaPlayerProxy.this.mLogListener != null) {
                MediaPlayerProxy.this.mLogListener.onLogEvent(i, obj, obj2);
            }
        }
    };
    private ZMMediaPlayer.OnMediaPlayerNotifyEventListener mMediaPlayerNotifyEventListener = new ZMMediaPlayer.OnMediaPlayerNotifyEventListener() { // from class: com.zenmen.media.player.MediaPlayerProxy.2
        @Override // com.zenmen.media.player.ZMMediaPlayer.OnMediaPlayerNotifyEventListener
        public void onMediaPlayerNotify(int i, int i2, int i3, Object obj) {
            if (i == 11) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onSeekCompleted();
                }
                return;
            }
            if (i == 13) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onVideoFormatchanged(i2, i3);
                    return;
                }
                return;
            }
            if (i == 23) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onBufferFinished();
                    return;
                }
                return;
            }
            if (i == 25) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onVideoFirstFrame();
                    return;
                }
                return;
            }
            if (i == 160) {
                if (MediaPlayerProxy.this.mContextChangedListener != null) {
                    MediaPlayerProxy.this.mContextChangedListener.onContextError(i2, i3);
                    return;
                }
                return;
            }
            if (i == 16) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onBufferingStarted();
                    return;
                }
                return;
            }
            if (i == 17) {
                if (MediaPlayerProxy.this.mStateChangeListener != null) {
                    MediaPlayerProxy.this.mStateChangeListener.onBufferingDone();
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    MediaPlayerProxy.this.mPlayStatus = PlayStatus.STATUS_PREPARED;
                    if (MediaPlayerProxy.this.mStateChangeListener != null) {
                        MediaPlayerProxy.this.mStateChangeListener.onPrepared(i2, i3);
                    }
                    break;
                case 2:
                    MediaPlayerProxy.this.mPlayStatus = PlayStatus.STATUS_PLAYING;
                    if (MediaPlayerProxy.this.mStateChangeListener != null) {
                        MediaPlayerProxy.this.mStateChangeListener.onStarted();
                    }
                    break;
                case 3:
                    MediaPlayerProxy.this.mPlayStatus = PlayStatus.STATUS_STOPPED;
                    if (MediaPlayerProxy.this.mStateChangeListener != null) {
                        MediaPlayerProxy.this.mStateChangeListener.onCompleted();
                    }
                    break;
                case 4:
                    MediaPlayerProxy.this.mPlayStatus = PlayStatus.STATUS_PAUSED;
                    if (MediaPlayerProxy.this.mStateChangeListener != null) {
                        MediaPlayerProxy.this.mStateChangeListener.onPaused();
                    }
                    break;
                case 5:
                    Log.e(MediaPlayerProxy.TAG, "MEDIA_CLOSE: proxysize " + i3);
                    break;
                case 6:
                    if (MediaPlayerProxy.this.mStateChangeListener != null) {
                        MediaPlayerProxy.this.mStateChangeListener.onError(i2, i3, null);
                    }
                    break;
                default:
                    switch (i) {
                        case 150:
                            if (MediaPlayerProxy.this.mContextChangedListener != null) {
                                MediaPlayerProxy.this.mContextChangedListener.onContextStarted(i2);
                            }
                            break;
                        case 151:
                            if (MediaPlayerProxy.this.mContextChangedListener != null) {
                                MediaPlayerProxy.this.mContextChangedListener.onContextFirstFrame(i2);
                            }
                            break;
                        case 152:
                            if (MediaPlayerProxy.this.mContextChangedListener != null) {
                                MediaPlayerProxy.this.mContextChangedListener.onContextStoped(i2);
                            }
                            break;
                        case 153:
                            if (MediaPlayerProxy.this.mContextChangedListener != null) {
                                MediaPlayerProxy.this.mContextChangedListener.onContextEOS(i2);
                            }
                            break;
                        case 154:
                            if (MediaPlayerProxy.this.mContextChangedListener != null) {
                                MediaPlayerProxy.this.mContextChangedListener.onContextArrived(i2, i3);
                            }
                            break;
                    }
                    break;
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMediaDurationUpdateListener {
        void onMediaDurationUpdated(int i);
    }

    public MediaPlayerProxy(String str) {
        this.mCurMediaPlayer = buildZMMediaPlayer(str);
    }

    public static String GetSdkVersion() {
        return ZMMediaPlayer.GetSdkVersion();
    }

    private ZMMediaPlayer buildZMMediaPlayer(String str) {
        try {
            ZMMediaPlayer zMMediaPlayer = new ZMMediaPlayer(null, str);
            zMMediaPlayer.setOnMediaPlayerNotifyEventListener(this.mMediaPlayerNotifyEventListener);
            zMMediaPlayer.setOnMediaPlayerNotifyLogListener(this.mMediaPlayerNotifyLogListener);
            return zMMediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void releaseZMMediaPlayer() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
            this.mCurMediaPlayer = null;
        }
    }

    public int GetVideoHeight(int i) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer == null) {
            return 0;
        }
        return iMediaPlayer.GetVideoHeight(i);
    }

    public int GetVideoWidth(int i) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer == null) {
            return 0;
        }
        return iMediaPlayer.GetVideoWidth(i);
    }

    public boolean IsMute() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            return iMediaPlayer.IsMute();
        }
        return false;
    }

    public void SetImageViewInfo(int i, int i2, int i3, Bitmap bitmap) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.SetImageViewInfo(i, i2, i3, bitmap);
        }
    }

    public int SetMute(boolean z) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            return iMediaPlayer.SetMute(z);
        }
        return 0;
    }

    public boolean SetPlaySpeed(float f) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            return iMediaPlayer.SetPlaySpeed(f);
        }
        return false;
    }

    public int SetVideoFileUrl(String str, int i) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer == null) {
            return -1;
        }
        return iMediaPlayer.SetVideoFileUrl(str, i);
    }

    public void SetVideoProp(int i, int i2, int i3) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.SetVideoProp(i, i2, i3);
        }
    }

    public void SetVideoViewInfo(int i, int i2, int i3, Surface surface) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.SetVideoViewInfo(i, i2, i3, surface);
        }
    }

    public void StopVideoView(int i) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.StopVideoView(i);
        }
    }

    public int duration() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer == null) {
            return 0;
        }
        return iMediaPlayer.duration();
    }

    public float getBufferPercent() {
        PlayStatus playStatus = this.mPlayStatus;
        if (playStatus == PlayStatus.STATUS_PLAYING || playStatus == PlayStatus.STATUS_PAUSED) {
            return this.mCurMediaPlayer.getBufferPercent();
        }
        return 0.0f;
    }

    public PlayStatus getPlayStatus() {
        return this.mPlayStatus;
    }

    public int getPosition() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            return iMediaPlayer.getPosition();
        }
        return 0;
    }

    public boolean isMV() {
        return this.mIsMV;
    }

    public void palySong(String str, String str2) throws Exception {
        stop();
        play(str, str2);
        this.mPlayStatus = PlayStatus.STATUS_STOPPED;
    }

    public void palyVideo(String str, int i) throws Exception {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDataSourceAsync(str, i);
        }
        this.mPlayStatus = PlayStatus.STATUS_STOPPED;
    }

    public void pause(boolean z) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.pause(z);
        }
        this.mPlayStatus = PlayStatus.STATUS_PAUSED;
    }

    public void play(String str) throws Exception {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDataSourceAsync(str, 1);
        }
    }

    public void release() {
        releaseZMMediaPlayer();
        this.mCurMediaPlayer = null;
    }

    public void resume(boolean z) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.resume(z);
            this.mPlayStatus = PlayStatus.STATUS_PLAYING;
        }
    }

    public void setAudioEffectLowDelay(boolean z) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setAudioEffectLowDelay(z);
        }
    }

    public void setCachePath(String str) throws Exception {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setCacheFilePath(str);
        }
    }

    public void setOnContextChangeListener(OnContextChangeListener onContextChangeListener) {
        this.mContextChangedListener = onContextChangeListener;
    }

    public void setOnLogListener(OnLogListener onLogListener) {
        this.mLogListener = onLogListener;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    public void setPlayRange(int i, int i2) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setPlayRange(i, i2);
        }
    }

    public void setPosition(int i, int i2) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            try {
                iMediaPlayer.setPosition(i, i2);
            } catch (IllegalStateException unused) {
                Log.e(TAG, "failed to set position because of IllegalState");
            }
        }
    }

    public void setRenderMode(int i) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.SetRenderMode(i);
        }
    }

    public void setSurface(Surface surface) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setSurface(surface);
        }
    }

    public void setView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setView(surfaceView);
        }
    }

    public void setViewSize(int i, int i2) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setViewSize(i, i2);
        }
        Log.e(TAG, "setViewSize: width" + i + "height" + i2);
    }

    public void setVolume(float f, float f2) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(f, f2);
        }
    }

    public void start() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.play();
            this.mPlayStatus = PlayStatus.STATUS_PLAYING;
        }
    }

    public void stop() {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
        }
        this.mPlayStatus = PlayStatus.STATUS_STOPPED;
    }

    public boolean videoSizeChanged(int i, int i2) {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            return iMediaPlayer.videoSizeChanged(i, i2);
        }
        return false;
    }

    public void play(String str, String str2) throws Exception {
        IMediaPlayer iMediaPlayer = this.mCurMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setCacheFilePath(str2);
            this.mCurMediaPlayer.setDataSourceAsync(str, 0);
        }
    }
}
