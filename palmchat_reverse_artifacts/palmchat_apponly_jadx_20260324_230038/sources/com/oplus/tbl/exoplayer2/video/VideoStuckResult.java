package com.oplus.tbl.exoplayer2.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class VideoStuckResult {
    public static final int VIDEO_STUCK_DECODER_CAPABILITY_LOW = 21;
    public static final int VIDEO_STUCK_INPUT_AVERAGE_FPS_LOW = 11;
    public static final int VIDEO_STUCK_INPUT_QUEUE_FPS_LOW = 12;
    public static final int VIDEO_STUCK_NONE = 0;
    public static final int VIDEO_STUCK_RENDER_DROP_TO_KEYFRAME_COUNT_OVERFLOW = 32;
    public static final int VIDEO_STUCK_RENDER_DROP_TO_KEYFRAME_FRAMES_OVERFLOW = 33;
    public static final int VIDEO_STUCK_RENDER_FPS_LOW = 31;
    public static final int VIDEO_STUCK_RENDER_PTS_UNEVEN = 35;
    public static final int VIDEO_STUCK_RENDER_TIME_UNEVEN = 34;
    public static final int VIDEO_STUCK_SOURCE_FPS_LOW = 1;
    public int decoderType;
    public int inputFps;
    public int outputFps;
    public int renderFps;
    public long stuckDurationMs;
    public long stuckTimeMs;
    public int stuckType;

    public VideoStuckResult(int i, int i2, long j, long j2, int i3, int i4, int i5) {
        this.stuckType = i;
        this.decoderType = i2;
        this.stuckTimeMs = j;
        this.stuckDurationMs = j2;
        this.inputFps = i3;
        this.outputFps = i4;
        this.renderFps = i5;
    }

    public static VideoStuckResult createResult(int i, int i2, long j, long j2) {
        return createResult(i, i2, j, j2, 0, 0, 0);
    }

    public String toString() {
        return "VideoStuckResult{stuckType=" + this.stuckType + ", decoderType=" + this.decoderType + ", stuckTimeMs=" + this.stuckTimeMs + ", stuckDurationMs=" + this.stuckDurationMs + ", inputFps=" + this.inputFps + ", outputFps=" + this.outputFps + ", renderFps=" + this.renderFps + '}';
    }

    public static VideoStuckResult createResult(int i, int i2, long j, long j2, int i3, int i4, int i5) {
        return new VideoStuckResult(i, i2, j, j2, i3, i4, i5);
    }
}
