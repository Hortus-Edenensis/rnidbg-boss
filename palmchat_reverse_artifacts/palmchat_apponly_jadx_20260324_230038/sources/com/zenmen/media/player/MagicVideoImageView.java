package com.zenmen.media.player;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.zenmen.palmchat.R;
import defpackage.me1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MagicVideoImageView extends RoundedImageView implements IMagicMediaPlayer {
    public static final int CENTER = 2;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private static final String TAG = "MagicVideoSurfaceView";
    static MediaPlayerProxy mPlayProxy;
    private int mCornerRadius;
    private VideoStateChangeListener mListener;
    private int mSide;
    private int mVideoContext;
    private String mVideoPath;
    static AtomicBoolean mProxyCreated = new AtomicBoolean(false);
    static OnLogListener mLogListener = new OnLogListener() { // from class: com.zenmen.media.player.MagicVideoImageView.1
        @Override // com.zenmen.media.player.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
        }
    };
    static OnContextChangeListener mContextChangeListener = new OnContextChangeListener() { // from class: com.zenmen.media.player.MagicVideoImageView.2
        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextArrived(int i, int i2) {
            MagicVideoImageView magicVideoImageView = MagicVideoImageView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoImageView != null) {
                magicVideoImageView.render(i2);
            }
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextError(int i, int i2) {
            Log.e(MagicVideoImageView.TAG, "MEDIA_CONTEXT_ERROR: context " + i + " ErrorCode:" + i2);
            MagicVideoImageView magicVideoImageView = MagicVideoImageView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoImageView == null || magicVideoImageView.mListener == null) {
                return;
            }
            magicVideoImageView.mListener.onVideoError(magicVideoImageView, i2);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextFirstFrame(int i) {
            Log.e(MagicVideoImageView.TAG, "MEDIA_CONTEXT_FIRSTFRAME: context " + i);
            MagicVideoImageView magicVideoImageView = MagicVideoImageView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoImageView == null || magicVideoImageView.mListener == null) {
                return;
            }
            magicVideoImageView.mListener.onVideoFirstFrame(magicVideoImageView);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextStarted(int i) {
            Log.e(MagicVideoImageView.TAG, "MEDIA_CONTEXT_START: context " + i);
            MagicVideoImageView magicVideoImageView = MagicVideoImageView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoImageView == null || magicVideoImageView.mListener == null) {
                return;
            }
            magicVideoImageView.mListener.onVideoStarted(magicVideoImageView);
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextStoped(int i) {
            Log.e(MagicVideoImageView.TAG, "MEDIA_CONTEXT_STOP: context " + i);
            MagicVideoImageView magicVideoImageView = MagicVideoImageView.mVideoViewMap.get(Integer.valueOf(i));
            if (magicVideoImageView != null) {
                if (magicVideoImageView.mListener != null) {
                    magicVideoImageView.mListener.onVideoStopped(magicVideoImageView);
                }
                MagicVideoImageView.mVideoViewMap.remove(Integer.valueOf(i));
            }
        }

        @Override // com.zenmen.media.player.OnContextChangeListener
        public void onContextEOS(int i) {
        }
    };
    static Map<Integer, MagicVideoImageView> mVideoViewMap = new HashMap();

    public MagicVideoImageView(Context context) {
        super(context);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(null);
    }

    private boolean checkPlaying() {
        return this.mVideoContext != 0;
    }

    private boolean checkPrepared() {
        return mProxyCreated.get() && this.mVideoPath != null;
    }

    private void destroyPlayer() {
        this.mVideoContext = _stop();
    }

    private void playerStart() {
        int i = this.mSide;
        setCorner(i != 0 ? i != 1 ? 15 : 11 : 14, this.mCornerRadius);
        int i_start = _start();
        this.mVideoContext = i_start;
        mVideoViewMap.put(Integer.valueOf(i_start), this);
        Log.e(TAG, "[playerStart] " + this.mVideoContext);
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
            this.mCornerRadius = me1.b(getContext(), typedArrayObtainStyledAttributes.getInt(1, 10)) / 2;
            typedArrayObtainStyledAttributes.recycle();
        }
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
            setMeidaPlayer(mPlayProxy);
        }
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public boolean isPlaying() {
        MediaPlayerProxy mediaPlayerProxy = mPlayProxy;
        return mediaPlayerProxy != null && mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideo(String str) {
        Log.i(TAG, "===================>SetVideoFileUrl =" + str);
        this.mVideoPath = str;
        setUrl(str);
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

    public MagicVideoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(attributeSet);
    }

    public MagicVideoImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoContext = 0;
        this.mVideoPath = null;
        this.mSide = 2;
        this.mCornerRadius = 10;
        init(attributeSet);
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
