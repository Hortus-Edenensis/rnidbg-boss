package com.zenmen.media.player;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import defpackage.sy5;
import defpackage.vw5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MagicTextureMediaPlayer extends TextureView implements TextureView.SurfaceTextureListener, IMagicMediaPlayer {
    private static final int STATE_ERROR = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_INIT = 1;
    private static final int STATE_PAUSE = 4;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_STOP = 5;
    private static final String TAG = "MagicMediaPlayer";
    private static ExecutorService sExecutor = vw5.b("MagicTextureMediaPlayer", 5);
    private String cachePath;
    private String defaulturl;
    private boolean fixedSize;
    private float leftVolume;
    private boolean loop;
    private int mCurrentOrientation;
    private int mHeight;
    private OnLogListener mLogListener;
    private boolean mNeedPlayerAuto;
    private OnStateChangeListener mOnStateChangeListener;
    private MediaPlayerProxy mPlayProxy;
    private int mPlayerState;
    private int mRenderMode;
    private OnStateChangeListener mStateChangeListener;
    private Surface mSurface;
    private boolean mSurfaceChanged;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private AtomicBoolean mUriSet;
    private VideoStateChangeListener mVideoStateChangeListener;
    private Integer mViewOrientation;
    private AtomicBoolean mViewSet;
    private int mWidth;
    private int mode;
    private int position;
    private int realHeight;
    private int realWidth;
    private boolean resumable;
    private float rightVolume;
    private int seekn;
    private int videoOriHeight;
    private int videoOriWidth;

    public MagicTextureMediaPlayer(Context context) {
        super(context);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.resumable = true;
        this.mNeedPlayerAuto = false;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.realWidth = 0;
        this.realHeight = 0;
        this.fixedSize = false;
        this.mRenderMode = 0;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.2
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferFinished();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingDone-----");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingDone();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingStarted++++++");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    if (MagicTextureMediaPlayer.this.loop) {
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(false);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayProxy.resume(false);
                    } else {
                        MagicTextureMediaPlayer.this.mNeedPlayerAuto = false;
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(true);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayerState = 4;
                        if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                            MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                        }
                    }
                    if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                        MagicTextureMediaPlayer.this.mOnStateChangeListener.onCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicTextureMediaPlayer.TAG, "onError:" + i);
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i);
                }
                if (i == -58) {
                    Log.e(MagicTextureMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                    sy5.e(MagicTextureMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onError(i, i2, mediaPlayerNotificationInfo);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPaused();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i, int i2) {
                Log.i(MagicTextureMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicTextureMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicTextureMediaPlayer.TAG, "nDuration " + MagicTextureMediaPlayer.this.mPlayProxy.duration());
                MagicTextureMediaPlayer.this.mPlayerState = 2;
                Log.i(MagicTextureMediaPlayer.TAG, "onPrepared  mNeedPlayerAuto=" + MagicTextureMediaPlayer.this.mNeedPlayerAuto + " mSurfaceChanged=" + MagicTextureMediaPlayer.this.mSurfaceChanged);
                if (MagicTextureMediaPlayer.this.mNeedPlayerAuto && MagicTextureMediaPlayer.this.mSurfaceChanged) {
                    MagicTextureMediaPlayer.this.start();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPrepared(i, i2);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onSeekCompleted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicTextureMediaPlayer.this);
                }
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    MagicTextureMediaPlayer.this.mPlayProxy.setVolume(MagicTextureMediaPlayer.this.leftVolume, MagicTextureMediaPlayer.this.rightVolume);
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFirstFrame();
                }
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoFirstFrame(MagicTextureMediaPlayer.this);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i, int i2) {
                int i3;
                int i4;
                Log.e(MagicTextureMediaPlayer.TAG, "onVideoFormatchanged width" + i + " height=" + i2);
                LogUtil.d("logextract", "formatChanged: w = " + i + ", h = " + i2);
                if (MagicTextureMediaPlayer.this.videoOriWidth <= 0 || MagicTextureMediaPlayer.this.videoOriHeight <= 0 || !MagicTextureMediaPlayer.this.fixedSize) {
                    if (MagicTextureMediaPlayer.this.realWidth <= 0 || MagicTextureMediaPlayer.this.realHeight <= 0) {
                        i3 = i;
                        i4 = i2;
                    } else {
                        i3 = MagicTextureMediaPlayer.this.realWidth;
                        i4 = MagicTextureMediaPlayer.this.realHeight;
                    }
                    if (i3 == 0 || i4 == 0) {
                        return;
                    }
                    if (MagicTextureMediaPlayer.this.mWidth == i3 && MagicTextureMediaPlayer.this.mHeight == i4) {
                        return;
                    }
                    MagicTextureMediaPlayer.this.mWidth = i3;
                    MagicTextureMediaPlayer.this.mHeight = i4;
                } else {
                    if (MagicTextureMediaPlayer.this.mWidth == MagicTextureMediaPlayer.this.videoOriWidth && MagicTextureMediaPlayer.this.mHeight == MagicTextureMediaPlayer.this.videoOriHeight) {
                        return;
                    }
                    MagicTextureMediaPlayer magicTextureMediaPlayer = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer.mWidth = magicTextureMediaPlayer.videoOriWidth;
                    MagicTextureMediaPlayer magicTextureMediaPlayer2 = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer2.mHeight = magicTextureMediaPlayer2.videoOriHeight;
                }
                MagicTextureMediaPlayer.this.mSurfaceChanged = MagicTextureMediaPlayer.this.setVideoViewSize();
                if (Build.VERSION.SDK_INT < 26) {
                    MagicTextureMediaPlayer.this.mSurfaceChanged = true;
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFormatchanged(i, i2);
                }
            }
        };
        this.mode = 1;
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.3
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i, Object obj, Object obj2) {
            }
        };
        this.mCurrentOrientation = 1;
        this.mViewOrientation = null;
        init();
    }

    private void extractSize() {
        this.realWidth = 0;
        this.realHeight = 0;
        final String str = this.defaulturl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sExecutor.submit(new Runnable() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (str.equals(MagicTextureMediaPlayer.this.defaulturl)) {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(str);
                            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                            String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                            mediaMetadataRetriever.release();
                            if (strExtractMetadata3.equals("90") || strExtractMetadata3.equals("270")) {
                                MagicTextureMediaPlayer.this.realWidth = Integer.valueOf(strExtractMetadata2).intValue();
                                MagicTextureMediaPlayer.this.realHeight = Integer.valueOf(strExtractMetadata).intValue();
                            } else {
                                MagicTextureMediaPlayer.this.realWidth = Integer.valueOf(strExtractMetadata).intValue();
                                MagicTextureMediaPlayer.this.realHeight = Integer.valueOf(strExtractMetadata2).intValue();
                            }
                            LogUtil.d("logextract", "extractSize: w = " + MagicTextureMediaPlayer.this.realWidth + ", h = " + MagicTextureMediaPlayer.this.realHeight);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        MediaPlayerProxy mediaPlayerProxy2 = new MediaPlayerProxy(str);
        this.mPlayProxy = mediaPlayerProxy2;
        mediaPlayerProxy2.setOnLogListener(this.mLogListener);
        this.mPlayProxy.setOnStateChangeListener(this.mStateChangeListener);
        setSurfaceTextureListener(this);
        this.mPlayerState = 1;
    }

    private void setDataSource() {
        synchronized (this.mUriSet) {
            if (this.mViewSet.get() && !this.mUriSet.get() && this.defaulturl != null) {
                try {
                    int i = TextUtils.isEmpty(this.cachePath) ? 1 : 0;
                    Log.i(TAG, "##########3setDataSource###########" + this.defaulturl + " flag=" + i);
                    this.mPlayProxy.palyVideo(this.defaulturl, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mUriSet.set(true);
            }
        }
    }

    private void setVideoSink(SurfaceTexture surfaceTexture) {
        synchronized (this.mViewSet) {
            if (!this.mViewSet.get()) {
                Log.i(TAG, "##########setVideoSink###########");
                Surface surface = new Surface(surfaceTexture);
                this.mSurface = surface;
                try {
                    MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
                    if (mediaPlayerProxy != null) {
                        mediaPlayerProxy.setSurface(surface);
                    }
                } catch (Exception unused) {
                }
                this.mViewSet.set(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setVideoViewSize() {
        int i;
        int iMax;
        int iMin;
        int i2;
        int i3 = this.mSurfaceWidth;
        if (i3 == 0 || (i = this.mSurfaceHeight) == 0 || this.mWidth == 0 || this.mHeight == 0) {
            return false;
        }
        if (this.fixedSize) {
            if (getParent() instanceof AspectRatioFrameLayout) {
                AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) getParent();
                int width = aspectRatioFrameLayout.getWidth();
                int height = aspectRatioFrameLayout.getHeight();
                int i4 = this.mWidth;
                if (i4 > 0 && (i2 = this.mHeight) > 0 && width > 0 && height > 0) {
                    aspectRatioFrameLayout.setAspectRatio((i4 * 1.0f) / i2);
                    aspectRatioFrameLayout.setResizeMode(this.mode);
                }
            }
            return true;
        }
        Integer num = this.mViewOrientation;
        if (num != null) {
            if (num.intValue() == 1) {
                iMin = Math.max(this.mSurfaceWidth, this.mSurfaceHeight);
                iMax = Math.min(this.mSurfaceWidth, this.mSurfaceHeight);
            } else {
                iMax = Math.max(this.mSurfaceWidth, this.mSurfaceHeight);
                iMin = Math.min(this.mSurfaceWidth, this.mSurfaceHeight);
            }
        } else if (this.mCurrentOrientation == 1) {
            iMin = Math.max(i3, i);
            iMax = Math.min(this.mSurfaceWidth, this.mSurfaceHeight);
        } else {
            iMax = Math.max(i3, i);
            iMin = Math.min(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Log.e(TAG, "LayoutParams: nMaxOutW " + iMax + " nMaxOutH " + iMin);
        int i5 = this.mHeight;
        int i6 = iMax * i5;
        int i7 = this.mWidth;
        if (i6 > i7 * iMin) {
            iMax = (i7 * iMin) / i5;
        } else {
            iMin = (i5 * iMax) / i7;
        }
        Log.e(TAG, "LayoutParams: w: " + iMax + " h: " + iMin);
        if (layoutParams.width == iMax || layoutParams.height == iMin || this.mRenderMode == 3) {
            return true;
        }
        Log.e(TAG, "LayoutParams: reset w= " + iMax + " h=" + iMin);
        layoutParams.width = iMax;
        layoutParams.height = iMin;
        setLayoutParams(layoutParams);
        return false;
    }

    public void forceSeek(long j) {
        try {
            MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
            if (mediaPlayerProxy == null || j < 0) {
                return;
            }
            mediaPlayerProxy.setPosition((int) j, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDuration() {
        try {
            return this.mPlayProxy.duration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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

    public boolean isPaused() {
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        return mediaPlayerProxy != null && mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PAUSED;
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
        this.mCurrentOrientation = getResources().getConfiguration().orientation;
        setVideoViewSize();
        if (getResources().getConfiguration().orientation != 2) {
            int i = getResources().getConfiguration().orientation;
        }
        Log.i(TAG, "onConfigurationChanged++++++");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(TAG, "onSurfaceTextureAvailable " + i + "  " + i2);
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        this.mCurrentOrientation = getResources().getConfiguration().orientation;
        if (this.mPlayProxy != null) {
            setVideoSink(surfaceTexture);
        } else {
            Log.e(TAG, "onSurfaceTextureAvailable mPlayProxy=null ");
        }
        if (this.position <= 0) {
            setDataSource();
            return;
        }
        try {
            Log.i(TAG, "Surface Created, set resumeVideo");
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.i(TAG, "SurfaceTexture Destroyed...");
        this.mViewSet.set(false);
        try {
            MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
            if (mediaPlayerProxy != null && (mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING || this.mPlayProxy.getPlayStatus() == PlayStatus.STATUS_PAUSED)) {
                this.mPlayProxy.setSurface(null);
                this.mPlayProxy.pause(false);
                this.mPlayerState = 4;
                this.position = this.mPlayProxy.getPosition();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(TAG, "onSurfaceTextureSizeChanged...width:" + i + " height:" + i2);
        if (this.mSurfaceChanged) {
            return;
        }
        this.mSurfaceChanged = true;
        if (this.mNeedPlayerAuto && this.mPlayerState == 2) {
            start();
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void pause() {
        Log.i(TAG, "pause");
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
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        this.position = 0;
        this.mPlayerState = 0;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void seek(long j) {
        try {
            if (this.mPlayProxy == null || j >= r0.duration() || j < 0) {
                return;
            }
            this.mPlayProxy.setPosition((int) j, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCachePath(String str) {
        Log.i(TAG, "setCachePath" + str);
        this.cachePath = str;
        try {
            Log.i(TAG, "##########setCachePath###########" + str);
            this.mPlayProxy.setCachePath(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFixedSize(boolean z) {
        this.fixedSize = z;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setLoop(boolean z) {
        this.loop = z;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    public void setOriginSize(int i, int i2) {
        this.videoOriWidth = i;
        this.videoOriHeight = i2;
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.setRenderMode(i);
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setResumable(boolean z) {
        this.resumable = z;
    }

    public void setSpeed(float f) {
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.SetPlaySpeed(f);
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideo(String str) {
        Log.i(TAG, "setVideo" + str);
        this.defaulturl = str;
        extractSize();
        setDataSource();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoStateChangeListener(VideoStateChangeListener videoStateChangeListener) {
        this.mVideoStateChangeListener = videoStateChangeListener;
    }

    public void setVieOrientation(int i) {
        this.mViewOrientation = Integer.valueOf(i);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVolume(float f, float f2) {
        try {
            this.leftVolume = f;
            this.rightVolume = f2;
            MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
            if (mediaPlayerProxy != null) {
                mediaPlayerProxy.setVolume(f, f2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void start() {
        Log.i(TAG, "start mPlayerState ##" + this.mPlayerState + " mSurfaceChanged=" + this.mSurfaceChanged);
        try {
            if (this.mPlayerState != 1 && this.mSurfaceChanged) {
                Log.i(TAG, "actual start 2");
                int i = this.mPlayerState;
                if (i == 2 || i == 5) {
                    MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
                    if (mediaPlayerProxy != null) {
                        mediaPlayerProxy.start();
                    }
                    this.mPlayerState = 3;
                }
                if (this.mPlayerState == 4) {
                    MediaPlayerProxy mediaPlayerProxy2 = this.mPlayProxy;
                    if (mediaPlayerProxy2 != null) {
                        mediaPlayerProxy2.resume(false);
                    }
                    this.mPlayerState = 3;
                }
                this.mNeedPlayerAuto = false;
                return;
            }
            this.mNeedPlayerAuto = true;
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void stop() {
        Log.i(TAG, "stop");
        this.mNeedPlayerAuto = false;
        try {
            this.mPlayProxy.stop();
            this.position = 0;
        } catch (Exception unused) {
        }
        this.mPlayerState = 5;
    }

    public MagicTextureMediaPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.resumable = true;
        this.mNeedPlayerAuto = false;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.realWidth = 0;
        this.realHeight = 0;
        this.fixedSize = false;
        this.mRenderMode = 0;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.2
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferFinished();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingDone-----");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingDone();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingStarted++++++");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    if (MagicTextureMediaPlayer.this.loop) {
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(false);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayProxy.resume(false);
                    } else {
                        MagicTextureMediaPlayer.this.mNeedPlayerAuto = false;
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(true);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayerState = 4;
                        if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                            MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                        }
                    }
                    if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                        MagicTextureMediaPlayer.this.mOnStateChangeListener.onCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicTextureMediaPlayer.TAG, "onError:" + i);
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i);
                }
                if (i == -58) {
                    Log.e(MagicTextureMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                    sy5.e(MagicTextureMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onError(i, i2, mediaPlayerNotificationInfo);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPaused();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i, int i2) {
                Log.i(MagicTextureMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicTextureMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicTextureMediaPlayer.TAG, "nDuration " + MagicTextureMediaPlayer.this.mPlayProxy.duration());
                MagicTextureMediaPlayer.this.mPlayerState = 2;
                Log.i(MagicTextureMediaPlayer.TAG, "onPrepared  mNeedPlayerAuto=" + MagicTextureMediaPlayer.this.mNeedPlayerAuto + " mSurfaceChanged=" + MagicTextureMediaPlayer.this.mSurfaceChanged);
                if (MagicTextureMediaPlayer.this.mNeedPlayerAuto && MagicTextureMediaPlayer.this.mSurfaceChanged) {
                    MagicTextureMediaPlayer.this.start();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPrepared(i, i2);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onSeekCompleted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicTextureMediaPlayer.this);
                }
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    MagicTextureMediaPlayer.this.mPlayProxy.setVolume(MagicTextureMediaPlayer.this.leftVolume, MagicTextureMediaPlayer.this.rightVolume);
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFirstFrame();
                }
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoFirstFrame(MagicTextureMediaPlayer.this);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i, int i2) {
                int i3;
                int i4;
                Log.e(MagicTextureMediaPlayer.TAG, "onVideoFormatchanged width" + i + " height=" + i2);
                LogUtil.d("logextract", "formatChanged: w = " + i + ", h = " + i2);
                if (MagicTextureMediaPlayer.this.videoOriWidth <= 0 || MagicTextureMediaPlayer.this.videoOriHeight <= 0 || !MagicTextureMediaPlayer.this.fixedSize) {
                    if (MagicTextureMediaPlayer.this.realWidth <= 0 || MagicTextureMediaPlayer.this.realHeight <= 0) {
                        i3 = i;
                        i4 = i2;
                    } else {
                        i3 = MagicTextureMediaPlayer.this.realWidth;
                        i4 = MagicTextureMediaPlayer.this.realHeight;
                    }
                    if (i3 == 0 || i4 == 0) {
                        return;
                    }
                    if (MagicTextureMediaPlayer.this.mWidth == i3 && MagicTextureMediaPlayer.this.mHeight == i4) {
                        return;
                    }
                    MagicTextureMediaPlayer.this.mWidth = i3;
                    MagicTextureMediaPlayer.this.mHeight = i4;
                } else {
                    if (MagicTextureMediaPlayer.this.mWidth == MagicTextureMediaPlayer.this.videoOriWidth && MagicTextureMediaPlayer.this.mHeight == MagicTextureMediaPlayer.this.videoOriHeight) {
                        return;
                    }
                    MagicTextureMediaPlayer magicTextureMediaPlayer = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer.mWidth = magicTextureMediaPlayer.videoOriWidth;
                    MagicTextureMediaPlayer magicTextureMediaPlayer2 = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer2.mHeight = magicTextureMediaPlayer2.videoOriHeight;
                }
                MagicTextureMediaPlayer.this.mSurfaceChanged = MagicTextureMediaPlayer.this.setVideoViewSize();
                if (Build.VERSION.SDK_INT < 26) {
                    MagicTextureMediaPlayer.this.mSurfaceChanged = true;
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFormatchanged(i, i2);
                }
            }
        };
        this.mode = 1;
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.3
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i, Object obj, Object obj2) {
            }
        };
        this.mCurrentOrientation = 1;
        this.mViewOrientation = null;
        init();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoAlpha(float f) {
    }

    public MagicTextureMediaPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPlayProxy = null;
        this.seekn = 0;
        this.resumable = true;
        this.mNeedPlayerAuto = false;
        this.mPlayerState = 0;
        this.mUriSet = new AtomicBoolean(false);
        this.mViewSet = new AtomicBoolean(false);
        this.mSurfaceChanged = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.realWidth = 0;
        this.realHeight = 0;
        this.fixedSize = false;
        this.mRenderMode = 0;
        this.loop = true;
        this.mStateChangeListener = new OnStateChangeListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.2
            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferFinished() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferFinished();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingDone() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingDone-----");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingDone();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onBufferingStarted() {
                Log.i(MagicTextureMediaPlayer.TAG, "onBufferingStarted++++++");
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onBufferingStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onCompleted() {
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    if (MagicTextureMediaPlayer.this.loop) {
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(false);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayProxy.resume(false);
                    } else {
                        MagicTextureMediaPlayer.this.mNeedPlayerAuto = false;
                        MagicTextureMediaPlayer.this.mPlayProxy.pause(true);
                        MagicTextureMediaPlayer.this.mPlayProxy.setPosition(0, 0);
                        MagicTextureMediaPlayer.this.mPlayerState = 4;
                        if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                            MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoCompleted();
                        }
                    }
                    if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                        MagicTextureMediaPlayer.this.mOnStateChangeListener.onCompleted();
                    }
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onError(int i2, int i22, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
                Log.i(MagicTextureMediaPlayer.TAG, "onError:" + i2);
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoError(null, i2);
                }
                if (i2 == -58) {
                    Log.e(MagicTextureMediaPlayer.TAG, "OnError: File not supported, please handle it in UI side.");
                    sy5.e(MagicTextureMediaPlayer.this.getContext(), R$string.video_des_play_error_not_support, 1).g();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onError(i2, i22, mediaPlayerNotificationInfo);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPaused() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPaused();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onPrepared(int i2, int i22) {
                Log.i(MagicTextureMediaPlayer.TAG, "#############onPrepared##############");
                if (MagicTextureMediaPlayer.this.mPlayProxy == null) {
                    return;
                }
                Log.i(MagicTextureMediaPlayer.TAG, "nDuration " + MagicTextureMediaPlayer.this.mPlayProxy.duration());
                MagicTextureMediaPlayer.this.mPlayerState = 2;
                Log.i(MagicTextureMediaPlayer.TAG, "onPrepared  mNeedPlayerAuto=" + MagicTextureMediaPlayer.this.mNeedPlayerAuto + " mSurfaceChanged=" + MagicTextureMediaPlayer.this.mSurfaceChanged);
                if (MagicTextureMediaPlayer.this.mNeedPlayerAuto && MagicTextureMediaPlayer.this.mSurfaceChanged) {
                    MagicTextureMediaPlayer.this.start();
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onPrepared(i2, i22);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onSeekCompleted() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onSeekCompleted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onStarted() {
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoStarted(MagicTextureMediaPlayer.this);
                }
                if (MagicTextureMediaPlayer.this.mPlayProxy != null) {
                    MagicTextureMediaPlayer.this.mPlayProxy.setVolume(MagicTextureMediaPlayer.this.leftVolume, MagicTextureMediaPlayer.this.rightVolume);
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onStarted();
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFirstFrame() {
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFirstFrame();
                }
                if (MagicTextureMediaPlayer.this.mVideoStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mVideoStateChangeListener.onVideoFirstFrame(MagicTextureMediaPlayer.this);
                }
            }

            @Override // com.zenmen.media.player.OnStateChangeListener
            public void onVideoFormatchanged(int i2, int i22) {
                int i3;
                int i4;
                Log.e(MagicTextureMediaPlayer.TAG, "onVideoFormatchanged width" + i2 + " height=" + i22);
                LogUtil.d("logextract", "formatChanged: w = " + i2 + ", h = " + i22);
                if (MagicTextureMediaPlayer.this.videoOriWidth <= 0 || MagicTextureMediaPlayer.this.videoOriHeight <= 0 || !MagicTextureMediaPlayer.this.fixedSize) {
                    if (MagicTextureMediaPlayer.this.realWidth <= 0 || MagicTextureMediaPlayer.this.realHeight <= 0) {
                        i3 = i2;
                        i4 = i22;
                    } else {
                        i3 = MagicTextureMediaPlayer.this.realWidth;
                        i4 = MagicTextureMediaPlayer.this.realHeight;
                    }
                    if (i3 == 0 || i4 == 0) {
                        return;
                    }
                    if (MagicTextureMediaPlayer.this.mWidth == i3 && MagicTextureMediaPlayer.this.mHeight == i4) {
                        return;
                    }
                    MagicTextureMediaPlayer.this.mWidth = i3;
                    MagicTextureMediaPlayer.this.mHeight = i4;
                } else {
                    if (MagicTextureMediaPlayer.this.mWidth == MagicTextureMediaPlayer.this.videoOriWidth && MagicTextureMediaPlayer.this.mHeight == MagicTextureMediaPlayer.this.videoOriHeight) {
                        return;
                    }
                    MagicTextureMediaPlayer magicTextureMediaPlayer = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer.mWidth = magicTextureMediaPlayer.videoOriWidth;
                    MagicTextureMediaPlayer magicTextureMediaPlayer2 = MagicTextureMediaPlayer.this;
                    magicTextureMediaPlayer2.mHeight = magicTextureMediaPlayer2.videoOriHeight;
                }
                MagicTextureMediaPlayer.this.mSurfaceChanged = MagicTextureMediaPlayer.this.setVideoViewSize();
                if (Build.VERSION.SDK_INT < 26) {
                    MagicTextureMediaPlayer.this.mSurfaceChanged = true;
                }
                if (MagicTextureMediaPlayer.this.mOnStateChangeListener != null) {
                    MagicTextureMediaPlayer.this.mOnStateChangeListener.onVideoFormatchanged(i2, i22);
                }
            }
        };
        this.mode = 1;
        this.mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicTextureMediaPlayer.3
            @Override // com.zenmen.media.player.OnLogListener
            public void onLogEvent(int i2, Object obj, Object obj2) {
            }
        };
        this.mCurrentOrientation = 1;
        this.mViewOrientation = null;
        init();
    }
}
