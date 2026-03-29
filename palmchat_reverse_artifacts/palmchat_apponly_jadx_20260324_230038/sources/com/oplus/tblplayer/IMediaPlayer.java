package com.oplus.tblplayer;

import android.media.AudioAttributes;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.misc.TimedText;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.upstream.IDataChannel;
import com.oplus.tblplayer.widget.IVideoProcessingView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IMediaPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_NOT_PLAYING = 804;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BINAURAL_CAPTURE_VIDEO = 20009;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_DETECTED_STREAMING_STUCK = 20011;
    public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
    public static final int MEDIA_INFO_HIGH_VIDEO_SPEC = 20010;
    public static final int MEDIA_INFO_HTTP_ORIGINAL_TRANSFERRED = 20005;
    public static final int MEDIA_INFO_HTTP_REDIRECTING = 20006;
    public static final int MEDIA_INFO_HTTP_REDIRECT_TRANSFERRED = 20004;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_PERIOD_TRANSITION = 20002;
    public static final int MEDIA_INFO_PLAYLIST_UPDATE = 20008;
    public static final int MEDIA_INFO_RENDERED_FIRST_FRAME = 20003;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_STREAMING_NORMAL_REPORT = 20012;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_TRACK_UPDATE = 20007;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_AUDIO_COPYRIGHT_CODEC = 30002;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_UNSUPPORTED_VIDEO_COPYRIGHT_CODEC = 30001;
    public static final int MEDIA_INFO_VIDEO_HDR_INFO = 20001;
    public static final int MEDIA_INFO_VIDEO_NOT_PLAYING = 805;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int SEEK_CLOSEST = 3;
    public static final int SEEK_CLOSEST_SYNC = 2;
    public static final int SEEK_NEXT_SYNC = 1;
    public static final int SEEK_PREVIOUS_SYNC = 0;
    public static final int STATE_COMPLETED = 128;
    public static final int STATE_END = 256;
    public static final int STATE_ERROR = 0;
    public static final int STATE_IDLE = 1;
    public static final int STATE_INITIALIZED = 2;
    public static final int STATE_PAUSED = 32;
    public static final int STATE_PREPARED = 8;
    public static final int STATE_PREPARING = 4;
    public static final int STATE_STARTED = 16;
    public static final int STATE_STOPPED = 64;
    public static final int VIDEO_EFFECTS_COMPOSITE_FRAMEINTERPOLATION = 2;
    public static final int VIDEO_EFFECTS_DEFAULT_FRAMEINTERPOLATION = 0;
    public static final int VIDEO_EFFECTS_OVERLAY_FRAMEINTERPOLATION = 1;
    public static final int VIDEO_EFFECTS_PASSTHROUGH = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final int Video_DROP_FRAME_POLICY_FORCE_120FPS = 6;
    public static final int Video_DROP_FRAME_POLICY_FORCE_24FPS = 1;
    public static final int Video_DROP_FRAME_POLICY_FORCE_30FPS = 2;
    public static final int Video_DROP_FRAME_POLICY_FORCE_60FPS = 4;
    public static final int Video_DROP_FRAME_POLICY_FORCE_90FPS = 5;
    public static final int Video_DROP_FRAME_POLICY_FORCE_HALF_FPS = 3;
    public static final int Video_DROP_FRAME_POLICY_NONE = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnBufferingUpdateListener {
        void onBufferedUpdate(IMediaPlayer iMediaPlayer, int i);

        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int i, int i2, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnFftUpdateListener {
        void onFftUpdated(IMediaPlayer iMediaPlayer, float[] fArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i, Object... objArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPlaybackResultListener {
        boolean onPlaybackResult(IMediaPlayer iMediaPlayer, Report report);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPlayerEventListener {
        void onDownstreamSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f);

        void onIsPlayingChanged(IMediaPlayer iMediaPlayer, boolean z);

        void onPlayerStateChanged(IMediaPlayer iMediaPlayer, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnTimedTextListener {
        void onTimedText(IMediaPlayer iMediaPlayer, TimedText timedText);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnVideoOverSpecListener {
        void onVideoOverSpecUpdated(IMediaPlayer iMediaPlayer);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerState {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SeekMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoDropFramePolicy {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoEffectsMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    boolean addPlaylistItem(@IntRange(from = 0) int i, @NonNull MediaUrl mediaUrl);

    boolean addPlaylistItem(@NonNull MediaUrl mediaUrl);

    boolean addPlaylistItems(@IntRange(from = 0) int i, @NonNull List<MediaUrl> list);

    boolean addPlaylistItems(@NonNull List<MediaUrl> list);

    boolean applyTrackSelection(int i, boolean z, ITrackInfo.SelectionOverride selectionOverride) throws IllegalStateException, IllegalArgumentException;

    boolean clearPlaylist();

    void clearVideoProcessingView(IVideoProcessingView iVideoProcessingView);

    void clearVideoSurface();

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    void disableVideoCodecWCG();

    void enableDropFramePolicy(boolean z);

    void enableDropFramePolicy(boolean z, int i);

    void enableDynamicWallpaper(boolean z);

    void enableMiniView(boolean z);

    void enableMiniView(boolean z, int i);

    void enableVideoCodecUIFirst(boolean z);

    void fastSeekTo(long j, boolean z) throws IllegalStateException;

    int getAudioSessionId();

    long getBufferForPlaybackMs();

    long getContentBufferedPosition();

    int getCurrentMediaItemIndex();

    long getCurrentPosition();

    Report getCurrentReport();

    String getDataSource();

    long getDuration();

    long getInternalPlaybackThreadId();

    MediaInfo getMediaInfo();

    long getNetSpeed();

    int getPlaybackState();

    @Nullable
    List<MediaUrl> getPlaylist();

    int getPlaylistSize();

    float getSpeed();

    ITrackInfo[] getTrackInfo() throws IllegalStateException;

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    float getVolume();

    boolean isLooping();

    boolean isPause();

    boolean isPlayable();

    boolean isPlaying();

    boolean isSoftwareDecoder();

    boolean isStop();

    boolean movePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2);

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    boolean removePlaylistItem(@IntRange(from = 0) int i);

    boolean removePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2);

    void reset();

    void seekTo(long j) throws IllegalStateException;

    void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException;

    void setAudioFFTSpeed(int i);

    void setAudioStreamType(int i);

    void setBcapPostEnhance(boolean z);

    void setDataSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDataSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDataSource(MediaUrl mediaUrl) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDataSource(@NonNull IDataChannel iDataChannel) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setEndPosition(long j);

    void setEndPositionUs(long j);

    void setFfmpegVideoDecoder(boolean z);

    void setForegroundMode(boolean z);

    void setKeepInBackground(boolean z);

    void setLogEnabled(boolean z);

    void setLooping(boolean z);

    void setNetworkType(int i);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnFftUpdateListener(OnFftUpdateListener onFftUpdateListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPlaybackResultListener(OnPlaybackResultListener onPlaybackResultListener);

    void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnTimedTextListener(OnTimedTextListener onTimedTextListener);

    void setOnVideoOverSpecListener(OnVideoOverSpecListener onVideoOverSpecListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOplusVPPFilterMode(int i);

    void setPlaybackRate(float f);

    boolean setPlaylist(@NonNull List<MediaUrl> list);

    void setScreenOnWhilePlaying(boolean z);

    void setSeekMode(int i);

    void setSurface(Surface surface);

    void setVideoEffects(int i);

    void setVideoEffects(List<Effect> list);

    void setVideoOutputColorInfo(boolean z);

    void setVideoOutputResolution(int i, int i2);

    void setVideoOverSpecFlag(boolean z);

    void setVideoProcessingView(IVideoProcessingView iVideoProcessingView);

    void setVideoScalingMode(int i);

    void setVideoSurfaceView(SurfaceView surfaceView);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float f);

    void setWakeMode(int i);

    void skipToPlaylistItem(@IntRange(from = 0) int i);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
