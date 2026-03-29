package com.oplus.tblplayer;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.misc.TimedText;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.upstream.IDataChannel;
import com.oplus.tblplayer.widget.IVideoProcessingView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnFftUpdateListener mOnFftUpdateListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    private IMediaPlayer.OnPlaybackResultListener mOnPlaybackResultListener;
    private IMediaPlayer.OnPlayerEventListener mOnPlayerEventListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
    private IMediaPlayer.OnVideoOverSpecListener mOnVideoOverSpecListener;
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItem(int i, @NonNull MediaUrl mediaUrl) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItems(int i, @NonNull List<MediaUrl> list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean applyTrackSelection(int i, boolean z, ITrackInfo.SelectionOverride selectionOverride) throws IllegalStateException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean clearPlaylist() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoProcessingView(IVideoProcessingView iVideoProcessingView) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void disableVideoCodecWCG() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableDropFramePolicy(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableDynamicWallpaper(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableMiniView(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableVideoCodecUIFirst(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long j, boolean z) throws IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getCurrentMediaItemIndex() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public Report getCurrentReport() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getInternalPlaybackThreadId() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    @Nullable
    public List<MediaUrl> getPlaylist() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaylistSize() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isSoftwareDecoder() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean movePlaylistItem(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public final void notifyOnBufferedUpdate(int i) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferedUpdate(this, i);
        }
    }

    public final void notifyOnBufferingUpdate(int i) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i);
        }
    }

    public final void notifyOnCompletion() {
        IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
    }

    public final void notifyOnDownstreamSizeChanged(int i, int i2, int i3, float f) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onDownstreamSizeChanged(this, i, i2, i3, f);
        }
    }

    public final boolean notifyOnError(int i, int i2, String str) {
        IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        return onErrorListener != null && onErrorListener.onError(this, i, i2, str);
    }

    public final void notifyOnFftUpdated(float[] fArr) {
        IMediaPlayer.OnFftUpdateListener onFftUpdateListener = this.mOnFftUpdateListener;
        if (onFftUpdateListener != null) {
            onFftUpdateListener.onFftUpdated(this, fArr);
        }
    }

    public final boolean notifyOnInfo(int i, Object... objArr) {
        IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        return onInfoListener != null && onInfoListener.onInfo(this, i, objArr);
    }

    public final void notifyOnIsPlayingChanged(boolean z) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onIsPlayingChanged(this, z);
        }
    }

    public final void notifyOnPlaybackResult(Report report) {
        IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener = this.mOnPlaybackResultListener;
        if (onPlaybackResultListener != null) {
            onPlaybackResultListener.onPlaybackResult(this, report);
        }
    }

    public final void notifyOnPlayerStateChanged(int i) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onPlayerStateChanged(this, i);
        }
    }

    public final void notifyOnPrepared() {
        IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
    }

    public final void notifyOnSeekComplete() {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    public final void notifyOnTimedText(TimedText timedText) {
        IMediaPlayer.OnTimedTextListener onTimedTextListener = this.mOnTimedTextListener;
        if (onTimedTextListener != null) {
            onTimedTextListener.onTimedText(this, timedText);
        }
    }

    public final void notifyOnVideoOverSpec() {
        IMediaPlayer.OnVideoOverSpecListener onVideoOverSpecListener = this.mOnVideoOverSpecListener;
        if (onVideoOverSpecListener != null) {
            onVideoOverSpecListener.onVideoOverSpecUpdated(this);
        }
    }

    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, float f) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i, i2, i3, f);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean removePlaylistItem(int i) {
        throw new UnsupportedOperationException();
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnFftUpdateListener = null;
        this.mOnVideoOverSpecListener = null;
        this.mOnTimedTextListener = null;
        this.mOnPlaybackResultListener = null;
        this.mOnPlayerEventListener = null;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioFFTSpeed(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setBcapPostEnhance(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setEndPosition(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setEndPositionUs(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setFfmpegVideoDecoder(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setForegroundMode(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnFftUpdateListener(IMediaPlayer.OnFftUpdateListener onFftUpdateListener) {
        this.mOnFftUpdateListener = onFftUpdateListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        this.mOnPlaybackResultListener = onPlaybackResultListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.mOnTimedTextListener = onTimedTextListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoOverSpecListener(IMediaPlayer.OnVideoOverSpecListener onVideoOverSpecListener) {
        this.mOnVideoOverSpecListener = onVideoOverSpecListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOplusVPPFilterMode(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean setPlaylist(@NonNull List<MediaUrl> list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSeekMode(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoEffects(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoOutputColorInfo(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoOutputResolution(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoOverSpecFlag(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoProcessingView(IVideoProcessingView iVideoProcessingView) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void skipToPlaylistItem(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItem(@NonNull MediaUrl mediaUrl) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean addPlaylistItems(@NonNull List<MediaUrl> list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableDropFramePolicy(boolean z, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void enableMiniView(boolean z, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean removePlaylistItem(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(MediaUrl mediaUrl) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoEffects(List<Effect> list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(@NonNull IDataChannel iDataChannel) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }
}
