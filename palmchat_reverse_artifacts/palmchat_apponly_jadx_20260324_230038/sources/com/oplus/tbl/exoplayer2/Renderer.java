package com.oplus.tbl.exoplayer2;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.PlayerMessage;
import com.oplus.tbl.exoplayer2.source.SampleStream;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.MediaClock;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface Renderer extends PlayerMessage.Target {
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_ENABLE_DYNAMIC_WALLPAPER = 20000;
    public static final int MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR = 11001;
    public static final int MSG_RESET_VIDEO_RENDER_STUCK_DETECTOR = 11000;
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    public static final int MSG_SET_AUDIO_SESSION_ID = 102;
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    public static final int MSG_SET_CHANGE_FRAME_RATE_STRATEGY = 14;
    public static final int MSG_SET_DROP_FRAME_POLICY = 12;
    public static final int MSG_SET_SCALING_MODE = 4;
    public static final int MSG_SET_SKIP_SILENCE_ENABLED = 101;
    public static final int MSG_SET_SURFACE = 1;
    public static final int MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER = 8;
    public static final int MSG_SET_VIDEO_EFFECTS = 13;
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    public static final int MSG_SET_VIDEO_OUTPUT_COLOR_INFO = 30000;
    public static final int MSG_SET_VIDEO_OUTPUT_RESOLUTION = 15;
    public static final int MSG_SET_VOLUME = 2;
    public static final int MSG_SET_WAKEUP_LISTENER = 103;
    public static final int MSG_SURFACE_VIEW_DESTROY = 11002;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;

    @Deprecated
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;

    @Deprecated
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;

    @Deprecated
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WakeupListener {
        void onSleep(long j);

        void onWakeup();
    }

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException;

    boolean firstVideoFrameRendered();

    RendererCapabilities getCapabilities();

    int getLastSeekType();

    @Nullable
    MediaClock getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    @Nullable
    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    void init(int i, Clock clock);

    boolean isAbnormalSurface();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReachEndPosition(long j);

    boolean isReady();

    long lastPresentTimeUs();

    void maybeThrowStreamError() throws IOException;

    void release();

    void render(long j, long j2) throws ExoPlaybackException;

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws ExoPlaybackException;

    void resetPositionInGop(long j) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setEndRendererPosition(long j);

    void setFastRendererPosition(long j) throws ExoPlaybackException;

    void setIndex(int i);

    void setLastSeekType(int i);

    void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException;

    void start() throws ExoPlaybackException;

    void stop();
}
