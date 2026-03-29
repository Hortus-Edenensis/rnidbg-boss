package com.zenmen.media.player;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.zenmen.palmchat.framework.R$string;
import defpackage.sy5;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MagicMediaPlayer extends SurfaceView implements SurfaceHolder.Callback, IMagicMediaPlayer {
    private static final int STATE_ERROR = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_INIT = 1;
    private static final int STATE_PAUSE = 4;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_STOP = 5;
    private static final String TAG = "MagicMediaPlayer";
    private String defaulturl;
    private float leftVolume;
    private boolean loop;
    private OnLogListener mLogListener;
    private boolean mLowDelay;
    private boolean mNeedPlayerAuto;
    private boolean mOnlineSrc;
    private MediaPlayerProxy mPlayProxy;
    private int mPlayerState;
    private OnStateChangeListener mStateChangeListener;
    private boolean mSurfaceChanged;
    private AtomicBoolean mUriSet;
    private VideoStateChangeListener mVideoStateChangeListener;
    private AtomicBoolean mViewSet;
    private boolean mVisibility;
    private int position;
    private boolean resumable;
    private float rightVolume;
    private int seekn;

    public MagicMediaPlayer(Context context) {
        super(context);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.mOnlineSrc = false;
        this.mLowDelay = true;
        this.mVisibility = true;
        this.mNeedPlayerAuto = false;
        this.resumable = true;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.1
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingDone-----");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingStarted++++++");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.loop) {
                        MagicMediaPlayer.this.mPlayProxy.pause(false);
                        MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicMediaPlayer.this.mPlayProxy.resume(false);
                        return;
                    }
                    MagicMediaPlayer.this.mNeedPlayerAuto = false;
                    MagicMediaPlayer.this.mPlayProxy.pause(true);
                    MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                    MagicMediaPlayer.this.mPlayerState = 4;
                    if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                        MagicMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicMediaPlayer.TAG, "onError:" + i);
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i);
                }
                if (i != -58) {
                    return;
                }
                Log.e(MagicMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                sy5.e(MagicMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i, int i2) {
                Log.i(MagicMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicMediaPlayer.TAG, "nDuration " + MagicMediaPlayer.this.mPlayProxy.duration());
                MagicMediaPlayer.this.mPlayerState = 2;
                if (MagicMediaPlayer.this.mNeedPlayerAuto && MagicMediaPlayer.this.mSurfaceChanged) {
                    MagicMediaPlayer.this.start();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicMediaPlayer.this);
                }
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    MagicMediaPlayer.this.mPlayProxy.setVolume(MagicMediaPlayer.this.leftVolume, MagicMediaPlayer.this.rightVolume);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i, int i2) {
                Log.e(MagicMediaPlayer.TAG, "onVideoFormatchanged:");
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.mPlayProxy.videoSizeChanged(i, i2)) {
                        MagicMediaPlayer.this.mSurfaceChanged = false;
                    } else {
                        MagicMediaPlayer.this.mSurfaceChanged = true;
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
            }
        };
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.2
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i, Object obj, Object obj2) {
                LogWrapper.log(i, (String) obj, (String) obj2);
            }
        };
        init();
    }

    private void init() {
        ApplicationInfo applicationInfo = getContext().getApplicationInfo();
        Log.i(TAG, "native library dir = " + applicationInfo.nativeLibraryDir);
        String str = applicationInfo.nativeLibraryDir;
        Log.i(TAG, "onCreate" + this.position + "mPlayProxy :" + this.mPlayProxy);
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.release();
            this.mPlayProxy = null;
        }
        this.mPlayProxy = new MediaPlayerProxy(str);
        getHolder().addCallback(this);
        this.mPlayProxy.setOnLogListener(this.mLogListener);
        this.mPlayProxy.setOnStateChangeListener(this.mStateChangeListener);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.mPlayProxy.setViewSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mOnlineSrc = false;
        this.mPlayerState = 1;
    }

    private void setDataSource() {
        synchronized (this.mUriSet) {
            if (this.mViewSet.get() && !this.mUriSet.get() && this.defaulturl != null) {
                try {
                    Log.i(TAG, "##########3setDataSource###########" + this.defaulturl);
                    this.mPlayProxy.palyVideo(this.defaulturl, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mUriSet.set(true);
            }
        }
    }

    private void setVideoSink(SurfaceView surfaceView) {
        synchronized (this.mViewSet) {
            if (!this.mViewSet.get()) {
                Log.i(TAG, "##########setVideoSink###########");
                this.mPlayProxy.setView(this);
                this.mViewSet.set(true);
            }
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public int getPosition() {
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getPosition();
        }
        return 0;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public String getVideoPath() {
        return this.defaulturl;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public boolean isPlaying() {
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        return mediaPlayerProxy != null && mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void mute(boolean z) {
        setVolume(z ? 0.0f : 1.0f, z ? 0.0f : 1.0f);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation != 2) {
            int i = getResources().getConfiguration().orientation;
        }
        Log.i(TAG, "onConfigurationChanged++++++");
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void pause() {
        try {
            int i = this.mPlayerState;
            if (i == 3) {
                this.mNeedPlayerAuto = false;
                this.mPlayProxy.pause(true);
                this.mPlayerState = 4;
            } else if (i == 4) {
                this.mPlayProxy.resume(true);
                this.mPlayerState = 3;
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void release() {
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.release();
            this.mPlayProxy = null;
        }
        this.position = 0;
        this.mPlayerState = 0;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void seek(long j) {
        try {
            if (j >= this.mPlayProxy.duration() || j < 0) {
                return;
            }
            this.mPlayProxy.setPosition((int) j, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setLoop(boolean z) {
        this.loop = z;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setResumable(boolean z) {
        this.resumable = z;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideo(String str) {
        Log.i(TAG, "setVideo" + str);
        this.defaulturl = str;
        setDataSource();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoStateChangeListener(VideoStateChangeListener videoStateChangeListener) {
        this.mVideoStateChangeListener = videoStateChangeListener;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVolume(float f, float f2) {
        try {
            this.leftVolume = f;
            this.rightVolume = f2;
            this.mPlayProxy.setVolume(f, f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void start() {
        Log.i(TAG, "start mPlayerState ##" + this.mPlayerState);
        if (this.mPlayerState == 1 || !this.mSurfaceChanged) {
            this.mNeedPlayerAuto = true;
            return;
        }
        Log.i(TAG, "actual start 2");
        int i = this.mPlayerState;
        if (i == 2 || i == 4 || i == 5) {
            this.mPlayProxy.start();
            this.mPlayerState = 3;
        }
        this.mNeedPlayerAuto = false;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void stop() {
        this.mNeedPlayerAuto = false;
        try {
            this.mPlayProxy.stop();
            this.position = 0;
        } catch (Exception unused) {
        }
        this.mPlayerState = 5;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.i(TAG, "surfaceChanged");
        Log.i(TAG, "surfaceChanged...width:" + i2 + " height:" + i3);
        if (this.mSurfaceChanged) {
            return;
        }
        this.mSurfaceChanged = true;
        if (this.mNeedPlayerAuto && this.mPlayerState == 2) {
            start();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i(TAG, "Surface Created... position:" + this.position);
        setVideoSink(this);
        if (this.position <= 0) {
            setDataSource();
            return;
        }
        try {
            Log.i(TAG, "Surface Created, set resume");
            if (this.mPlayProxy.getPlayStatus() == PlayStatus.STATUS_PAUSED) {
                this.mPlayProxy.setPosition(this.position, 1);
                if (this.resumable) {
                    this.mPlayProxy.resume(false);
                }
            } else if (this.defaulturl != null && this.mPlayProxy.getPlayStatus() != PlayStatus.STATUS_PLAYING) {
                try {
                    this.mPlayProxy.palyVideo(this.defaulturl, 1);
                    this.mPlayProxy.setPosition(this.position, 1);
                } catch (Exception unused) {
                }
            }
            this.position = 0;
        } catch (Exception unused2) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i(TAG, "Surface Destroyed...");
        this.mViewSet.set(false);
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            if (mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING || this.mPlayProxy.getPlayStatus() == PlayStatus.STATUS_PAUSED) {
                this.mPlayProxy.setView(null);
                this.mPlayProxy.pause(false);
                this.mPlayerState = 4;
                this.position = this.mPlayProxy.getPosition();
                Log.i(TAG, "Surface Destroyed, set pause, and position:" + this.position);
            }
        }
    }

    public MagicMediaPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.mOnlineSrc = false;
        this.mLowDelay = true;
        this.mVisibility = true;
        this.mNeedPlayerAuto = false;
        this.resumable = true;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.1
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingDone-----");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingStarted++++++");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.loop) {
                        MagicMediaPlayer.this.mPlayProxy.pause(false);
                        MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicMediaPlayer.this.mPlayProxy.resume(false);
                        return;
                    }
                    MagicMediaPlayer.this.mNeedPlayerAuto = false;
                    MagicMediaPlayer.this.mPlayProxy.pause(true);
                    MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                    MagicMediaPlayer.this.mPlayerState = 4;
                    if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                        MagicMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicMediaPlayer.TAG, "onError:" + i);
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i);
                }
                if (i != -58) {
                    return;
                }
                Log.e(MagicMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                sy5.e(MagicMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i, int i2) {
                Log.i(MagicMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicMediaPlayer.TAG, "nDuration " + MagicMediaPlayer.this.mPlayProxy.duration());
                MagicMediaPlayer.this.mPlayerState = 2;
                if (MagicMediaPlayer.this.mNeedPlayerAuto && MagicMediaPlayer.this.mSurfaceChanged) {
                    MagicMediaPlayer.this.start();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicMediaPlayer.this);
                }
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    MagicMediaPlayer.this.mPlayProxy.setVolume(MagicMediaPlayer.this.leftVolume, MagicMediaPlayer.this.rightVolume);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i, int i2) {
                Log.e(MagicMediaPlayer.TAG, "onVideoFormatchanged:");
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.mPlayProxy.videoSizeChanged(i, i2)) {
                        MagicMediaPlayer.this.mSurfaceChanged = false;
                    } else {
                        MagicMediaPlayer.this.mSurfaceChanged = true;
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
            }
        };
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.2
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i, Object obj, Object obj2) {
                LogWrapper.log(i, (String) obj, (String) obj2);
            }
        };
        init();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoAlpha(float f) {
    }

    public MagicMediaPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.mOnlineSrc = false;
        this.mLowDelay = true;
        this.mVisibility = true;
        this.mNeedPlayerAuto = false;
        this.resumable = true;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.1
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingDone-----");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicMediaPlayer.TAG, "onBufferingStarted++++++");
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.loop) {
                        MagicMediaPlayer.this.mPlayProxy.pause(false);
                        MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicMediaPlayer.this.mPlayProxy.resume(false);
                        return;
                    }
                    MagicMediaPlayer.this.mNeedPlayerAuto = false;
                    MagicMediaPlayer.this.mPlayProxy.pause(true);
                    MagicMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                    MagicMediaPlayer.this.mPlayerState = 4;
                    if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                        MagicMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i2, int i22, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicMediaPlayer.TAG, "onError:" + i2);
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i2);
                }
                if (i2 != -58) {
                    return;
                }
                Log.e(MagicMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                sy5.e(MagicMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i2, int i22) {
                Log.i(MagicMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicMediaPlayer.TAG, "nDuration " + MagicMediaPlayer.this.mPlayProxy.duration());
                MagicMediaPlayer.this.mPlayerState = 2;
                if (MagicMediaPlayer.this.mNeedPlayerAuto && MagicMediaPlayer.this.mSurfaceChanged) {
                    MagicMediaPlayer.this.start();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicMediaPlayer.this);
                }
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    MagicMediaPlayer.this.mPlayProxy.setVolume(MagicMediaPlayer.this.leftVolume, MagicMediaPlayer.this.rightVolume);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i2, int i22) {
                Log.e(MagicMediaPlayer.TAG, "onVideoFormatchanged:");
                if (MagicMediaPlayer.this.mPlayProxy != null) {
                    if (MagicMediaPlayer.this.mPlayProxy.videoSizeChanged(i2, i22)) {
                        MagicMediaPlayer.this.mSurfaceChanged = false;
                    } else {
                        MagicMediaPlayer.this.mSurfaceChanged = true;
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
            }
        };
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicMediaPlayer.2
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i2, Object obj, Object obj2) {
                LogWrapper.log(i2, (String) obj, (String) obj2);
            }
        };
        init();
    }
}
