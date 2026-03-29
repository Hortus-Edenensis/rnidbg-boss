package com.zenmen.media.player;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.zenmen.palmchat.R;
import defpackage.me1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MagicVideoTextureView extends TextureView implements TextureView.SurfaceTextureListener, IMagicMediaPlayer {
    public static final int CENTER = 2;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private static final String TAG = "MagicVideoTextureView";
    static MediaPlayerProxy mPlayProxy;
    private boolean mAudioMute;
    private int mCornerRadius;
    private VideoStateChangeListener mListener;
    private int mSide;
    private Surface mSurface;
    private int mVideoContext;
    private String mVideoPath;
    private int surfaceHeight;
    private int surfaceWidth;
    static AtomicBoolean mProxyCreated = new AtomicBoolean(false);
    static OnLogListener mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicVideoTextureView.1
        @Override // com.zenmen.media.player.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
            LogWrapper.log(i, (String) obj, (String) obj2);
        }
    };
    static OnContextChangeListener mContextChangeListener = new OnContextChangeListener() { // from class: com.zenmen.media.player.MagicVideoTextureView.2
        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextError(int i, int i2) {
            Log.e(MagicVideoTextureView.TAG, "MEDIA_CONTEXT_ERROR: context " + i + " ErrorCode:" + i2);
            MagicVideoTextureView magicVideoTextureView = MagicVideoTextureView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoTextureView == null || magicVideoTextureView.mListener == null) {
                return;
            }
            magicVideoTextureView.mListener.onVideoError(magicVideoTextureView, i2);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextFirstFrame(int i) {
            Log.e(MagicVideoTextureView.TAG, "MEDIA_CONTEXT_FIRSTFRAME: context " + i);
            MagicVideoTextureView magicVideoTextureView = MagicVideoTextureView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoTextureView == null || magicVideoTextureView.mListener == null) {
                return;
            }
            magicVideoTextureView.mListener.onVideoFirstFrame(magicVideoTextureView);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextStarted(int i) {
            Log.e(MagicVideoTextureView.TAG, "MEDIA_CONTEXT_START: context " + i);
            MagicVideoTextureView magicVideoTextureView = MagicVideoTextureView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoTextureView == null || magicVideoTextureView.mListener == null) {
                return;
            }
            magicVideoTextureView.mListener.onVideoStarted(magicVideoTextureView);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextStoped(int i) {
            Log.e(MagicVideoTextureView.TAG, "MEDIA_CONTEXT_STOP: context " + i);
            MagicVideoTextureView magicVideoTextureView = MagicVideoTextureView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoTextureView != null) {
                if (magicVideoTextureView.mListener != null) {
                    magicVideoTextureView.mListener.onVideoStopped(magicVideoTextureView);
                }
                MagicVideoTextureView.mVideoViewMap.remove(Integer.valueOf(i));
            }
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextEOS(int i) {
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextArrived(int i, int i2) {
        }
    };
    static Map<Integer, MagicVideoTextureView> mVideoViewMap = new HashMap();

    public MagicVideoTextureView(Context context) {
        super(context);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mAudioMute = false;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(null);
        setSurfaceTextureListener(this);
    }

    private boolean checkPlaying() {
        return this.mVideoContext != 0;
    }

    private boolean checkPrepared() {
        return (!mProxyCreated.get() || this.mVideoPath == null || this.mSurface == null) ? false : true;
    }

    private void destroyPlayer() {
        mPlayProxy.StopVideoView(this.mVideoContext);
        this.mVideoContext = 0;
    }

    private void playerStart() {
        int iSetVideoFileUrl = mPlayProxy.SetVideoFileUrl(this.mVideoPath, 0);
        this.mVideoContext = iSetVideoFileUrl;
        mVideoViewMap.put(Integer.valueOf(iSetVideoFileUrl), this);
        Log.e(TAG, "[playerStart] " + this.mVideoContext);
        int i = this.mSide;
        mPlayProxy.SetVideoProp(this.mVideoContext, i != 0 ? i != 1 ? 15 : 11 : 14, this.mCornerRadius);
        mPlayProxy.SetVideoViewInfo(this.mVideoContext, this.surfaceWidth, this.surfaceHeight, this.mSurface);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public int getPosition() {
        MediaPlayerProxy mediaPlayerProxy = mPlayProxy;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getPosition();
        }
        return 0;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ChatItemSide);
            this.mSide = typedArrayObtainStyledAttributes.getInt(3, 2);
            this.mCornerRadius = me1.b(getContext(), typedArrayObtainStyledAttributes.getInt(1, 10));
            typedArrayObtainStyledAttributes.recycle();
        }
        setOpaque(false);
        synchronized (mProxyCreated) {
            Context context = getContext();
            if (!mProxyCreated.get()) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Log.i(TAG, "native library dir = " + applicationInfo.nativeLibraryDir);
                String str = applicationInfo.nativeLibraryDir;
                MediaPlayerProxy mediaPlayerProxy = mPlayProxy;
                if (mediaPlayerProxy != null) {
                    mediaPlayerProxy.release();
                    mPlayProxy = null;
                }
                MediaPlayerProxy mediaPlayerProxy2 = new MediaPlayerProxy(str);
                mPlayProxy = mediaPlayerProxy2;
                mediaPlayerProxy2.setOnLogListener(mLogListener);
                mPlayProxy.setOnContextChangeListener(mContextChangeListener);
                mProxyCreated.set(true);
            }
            if (context instanceof Activity) {
                ((Activity) context).getWindow().setFlags(16777216, 16777216);
            }
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public boolean isPlaying() {
        MediaPlayerProxy mediaPlayerProxy = mPlayProxy;
        return mediaPlayerProxy != null && mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(TAG, "MainActivity::onSurfaceTextureAvailable() tName:" + Thread.currentThread().getName());
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        this.mSurface = new Surface(surfaceTexture);
        if (!checkPrepared() || checkPlaying()) {
            return;
        }
        Log.i(TAG, "onSurfaceTextureAvailable SetVideoFileUrl set video file Url " + this.mVideoPath);
        playerStart();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.i(TAG, "GLViewMediaActivity::onSurfaceTextureDestroyed() tName:" + Thread.currentThread().getName());
        destroyPlayer();
        this.mSurface.release();
        this.mSurface = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(TAG, "onSurfaceTextureSizeChanged SetVideoFileUrl set video file Url " + this.mVideoPath);
        boolean zCheckPlaying = checkPlaying();
        if (zCheckPlaying) {
            destroyPlayer();
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        this.mSurface = new Surface(surfaceTexture);
        if (zCheckPlaying && checkPrepared()) {
            Log.i(TAG, "surface change SetVideoFileUrl set video file Url " + this.mVideoPath);
            playerStart();
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideo(String str) {
        Log.i(TAG, "===================>SetVideoFileUrl =" + str);
        this.mVideoPath = str;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoAlpha(float f) {
        setAlpha(f);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoStateChangeListener(VideoStateChangeListener videoStateChangeListener) {
        this.mListener = videoStateChangeListener;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void start() {
        if (checkPlaying() || !checkPrepared()) {
            return;
        }
        playerStart();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void stop() {
        if (this.mVideoContext != 0) {
            destroyPlayer();
        }
    }

    public MagicVideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mAudioMute = false;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(attributeSet);
        setSurfaceTextureListener(this);
    }

    public MagicVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mAudioMute = false;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(attributeSet);
        setSurfaceTextureListener(this);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void pause() {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void release() {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void mute(boolean z) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void seek(long j) {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setLoop(boolean z) {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setResumable(boolean z) {
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVolume(float f, float f2) {
    }
}
