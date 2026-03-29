package com.oplus.tblplayer.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.RequiresApi;
import com.oplus.tblplayer.AbstractMediaPlayer;
import com.oplus.tblplayer.android.misc.AndroidTrackInfo;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.SurfaceCache;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLAndroidPlayer extends AbstractMediaPlayer implements SurfaceCache.OnUpdateSurfaceCallback {
    private static final String TAG = "TBLAndroidPlayer";
    private static MediaInfo sMediaInfo;
    private Context mAppContext;
    private String mDataSource;
    private final Object mInitLock;
    private final TBLMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;
    private SurfaceCache mSurfaceCache;
    private float mVolume;

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(23)
    public static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mMediaDataSource.close();
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            return this.mMediaDataSource.readAt(j, bArr, i, i2);
        }
    }

    public TBLAndroidPlayer(Context context) {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        this.mVolume = 1.0f;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        this.mAppContext = context;
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new TBLMediaPlayerListenerHolder(this);
        this.mSurfaceCache = new SurfaceCache(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                LogUtil.e(TAG, "release media data source failed" + e.getMessage());
            }
            this.mMediaDataSource = null;
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public boolean applyTrackSelection(int i, boolean z, ITrackInfo.SelectionOverride selectionOverride) throws IllegalStateException, IllegalArgumentException {
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurface() {
        this.mSurfaceCache.clearVideoSurface();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceCache.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(TextureView textureView) {
        this.mSurfaceCache.clearVideoTextureView(textureView);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e) {
            LogUtil.e(TAG, "getCurrentPosition" + e.getMessage());
            return 0L;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        try {
            return this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e) {
            LogUtil.e(TAG, "getDuration" + e.getMessage());
            return 0L;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.videoDecoder = "android";
            mediaInfo.videoRendererSupport = 3;
            mediaInfo.audioDecoder = "android";
            mediaInfo.audioRendererSupport = 3;
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        return 0;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    @RequiresApi(api = 23)
    public float getSpeed() {
        return this.mInternalMediaPlayer.getPlaybackParams().getSpeed();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getVolume() {
        return this.mVolume;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e) {
            LogUtil.e(TAG, "isPlaying" + e.getMessage());
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        SurfaceCache surfaceCache = this.mSurfaceCache;
        if (surfaceCache != null) {
            surfaceCache.release();
            this.mSurfaceCache = null;
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e) {
            LogUtil.e(TAG, "reset" + e.getMessage());
        }
        SurfaceCache surfaceCache = this.mSurfaceCache;
        if (surfaceCache != null) {
            surfaceCache.release();
            this.mSurfaceCache = null;
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(this.mAppContext, uri);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    @RequiresApi(api = 23)
    public void setPlaybackRate(float f) {
        if (AssertUtil.checkState(this.mInternalMediaPlayer != null)) {
            PlaybackParams playbackParams = this.mInternalMediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mInternalMediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int i) {
        this.mInternalMediaPlayer.setVideoScalingMode(i);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceCache.setVideoSurfaceView(surfaceView);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(TextureView textureView) {
        this.mSurfaceCache.setVideoTextureView(textureView);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float f) {
        this.mVolume = f;
        this.mInternalMediaPlayer.setVolume(f, f);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int i) {
        this.mInternalMediaPlayer.setWakeMode(this.mAppContext, i);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @Override // com.oplus.tblplayer.utils.SurfaceCache.OnUpdateSurfaceCallback
    public void updateSurface(Surface surface) {
        setSurface(surface);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(this.mAppContext, uri, map);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(MediaUrl mediaUrl) throws IOException {
        setDataSource(mediaUrl.getUri(), mediaUrl.getHeaders());
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor, j, j2);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mDataSource = str;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(uri.getPath());
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int i) {
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setSeekMode(int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class TBLMediaPlayerListenerHolder implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<TBLAndroidPlayer> mWeakMediaPlayer;

        public TBLMediaPlayerListenerHolder(TBLAndroidPlayer tBLAndroidPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(tBLAndroidPlayer);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            TBLAndroidPlayer.this.notifyOnBufferingUpdate(i);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            TBLAndroidPlayer.this.notifyOnCompletion();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() != null) {
                if (TBLAndroidPlayer.this.notifyOnError(i, i, i2 + "")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && TBLAndroidPlayer.this.notifyOnInfo(i, Integer.valueOf(i2));
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            TBLAndroidPlayer.this.notifyOnPrepared();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            TBLAndroidPlayer.this.notifyOnSeekComplete();
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            TBLAndroidPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1.0f);
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long j, boolean z) throws IllegalStateException {
    }
}
