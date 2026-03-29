package com.oplus.tblplayer.remote;

import android.net.Uri;
import android.os.IBinder;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.oplus.tblplayer.AbstractMediaPlayer;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class RemotePlayerProxy extends AbstractMediaPlayer {
    private static final String TAG = "RemotePlayerProxy";
    private ArrayList<Pair<Integer, Object[]>> mPendingTaskStack;
    protected IBinder mRemotePlayer;
    protected RemoteSurfaceCache mSurfaceCache = new RemoteSurfaceCache(this);

    private void setShouldNotify(int i, int i2) {
        invokeRemoteMethod(34, Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(TextureView textureView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoTextureView(textureView);
        }
    }

    public abstract <T> T execRemoteMethod(int i, T t, Object... objArr);

    public synchronized boolean flushPendingTaskStack() {
        ArrayList<Pair<Integer, Object[]>> arrayList;
        LogUtil.d(TAG, "flushPendingTaskStack");
        if (this.mRemotePlayer != null && (arrayList = this.mPendingTaskStack) != null) {
            for (Pair<Integer, Object[]> pair : arrayList) {
                invokeRemoteMethod(((Integer) pair.first).intValue(), (Object[]) pair.second);
            }
            this.mPendingTaskStack = null;
        }
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        return ((Integer) invokeRemoteMethodNotPending(20, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        return ((Long) invokeRemoteMethodNotPending(28, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        return ((Long) invokeRemoteMethodNotPending(36, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        LogUtil.d(TAG, "getCurrentPosition");
        return ((Long) invokeRemoteMethodNotPending(14, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public String getDataSource() {
        return (String) invokeRemoteMethodNotPending(6, null, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        LogUtil.d(TAG, "getDuration");
        return ((Long) invokeRemoteMethodNotPending(15, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public MediaInfo getMediaInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        return ((Integer) invokeRemoteMethodNotPending(42, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        LogUtil.d(TAG, "getSpeed");
        return ((Float) invokeRemoteMethodNotPending(39, Float.valueOf(1.0f), new Object[0])).floatValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        return ((Integer) invokeRemoteMethodNotPending(31, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return ((Integer) invokeRemoteMethodNotPending(25, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return ((Integer) invokeRemoteMethodNotPending(24, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        return ((Integer) invokeRemoteMethodNotPending(30, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getVolume() {
        return 0.0f;
    }

    public synchronized void insertPendingTaskStack(int i, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("insertPendingTaskStack: need pending task method is ");
        sb.append(i - 1);
        LogUtil.d(TAG, sb.toString());
        if (this.mPendingTaskStack == null) {
            this.mPendingTaskStack = new ArrayList<>();
        }
        this.mPendingTaskStack.add(new Pair<>(Integer.valueOf(i), objArr));
    }

    public Object invokeRemoteMethod(int i, Object... objArr) {
        if (shouldPending()) {
            insertPendingTaskStack(i, objArr);
        } else if (shouldInvoke()) {
            return execRemoteMethod(i, null, objArr);
        }
        return null;
    }

    public <T> T invokeRemoteMethodNotPending(int i, T t, Object... objArr) {
        return shouldInvoke() ? (T) execRemoteMethod(i, t, objArr) : t;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        return ((Boolean) invokeRemoteMethodNotPending(28, Boolean.FALSE, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        return ((Boolean) invokeRemoteMethodNotPending(37, Boolean.FALSE, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        return ((Boolean) invokeRemoteMethodNotPending(13, Boolean.TRUE, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        return ((Boolean) invokeRemoteMethodNotPending(12, Boolean.FALSE, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        return ((Boolean) invokeRemoteMethodNotPending(38, Boolean.FALSE, new Object[0])).booleanValue();
    }

    public void onRelease() {
        LogUtil.d(TAG, "onRelease");
        resetListeners();
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.release();
            this.mSurfaceCache = null;
        }
        ArrayList<Pair<Integer, Object[]>> arrayList = this.mPendingTaskStack;
        if (arrayList != null) {
            arrayList.clear();
            this.mPendingTaskStack = null;
        }
        this.mRemotePlayer = null;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws IllegalStateException {
        LogUtil.d(TAG, "pause");
        invokeRemoteMethod(10, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        LogUtil.d(TAG, "prepareAsync");
        invokeRemoteMethod(7, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        LogUtil.d(TAG, "release");
        invokeRemoteMethod(16, new Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        LogUtil.d(TAG, "reset");
        invokeRemoteMethod(17, new Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        LogUtil.d(TAG, "seekTo");
        invokeRemoteMethod(11, Long.valueOf(j));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int i) {
        invokeRemoteMethod(19, Integer.valueOf(i));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        LogUtil.d(TAG, "setDataSource: uri is " + uri);
        invokeRemoteMethod(2, uri);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        invokeRemoteMethod(23, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z) {
        invokeRemoteMethod(27, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int i) {
        invokeRemoteMethod(40, new Object[0]);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
        setShouldNotify(4, 4);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
        setShouldNotify(2, 2);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        setShouldNotify(32, 32);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
        setShouldNotify(64, 64);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        super.setOnPlaybackResultListener(onPlaybackResultListener);
        setShouldNotify(256, 256);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
        super.setOnPlayerEventListener(onPlayerEventListener);
        setShouldNotify(512, 512);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        setShouldNotify(1, 1);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
        setShouldNotify(8, 8);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        super.setOnTimedTextListener(onTimedTextListener);
        setShouldNotify(128, 128);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        setShouldNotify(16, 16);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        LogUtil.d(TAG, "setScreenOnWhilePlaying");
        invokeRemoteMethod(29, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(Surface surface) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(TextureView textureView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float f) {
        invokeRemoteMethod(18, Float.valueOf(f));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int i) {
        invokeRemoteMethod(26, Integer.valueOf(i));
    }

    public abstract boolean shouldInvoke();

    public abstract boolean shouldPending();

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws IllegalStateException {
        LogUtil.d(TAG, "start");
        invokeRemoteMethod(8, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws IllegalStateException {
        LogUtil.d(TAG, "stop");
        invokeRemoteMethod(9, new Object[0]);
    }

    public void updateSurface(Surface surface) {
        LogUtil.d(TAG, "updateSurface: surface is " + surface);
        invokeRemoteMethod(35, surface);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        invokeRemoteMethod(3, uri, map);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        LogUtil.d(TAG, "setDataSource: path is " + str);
        invokeRemoteMethod(1, str);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurface() {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }
}
