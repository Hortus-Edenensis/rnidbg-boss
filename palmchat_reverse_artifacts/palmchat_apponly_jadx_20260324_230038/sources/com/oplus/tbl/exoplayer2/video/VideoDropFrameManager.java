package com.oplus.tbl.exoplayer2.video;

import com.oplus.tbl.exoplayer2.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class VideoDropFrameManager implements DropFrameManager {
    private static final String TAG = "VideoDropFrameManager";
    private static final float UNSET_FPS = -1.0f;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_120FPS = 6;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_24FPS = 1;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_30FPS = 2;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_60FPS = 4;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_90FPS = 5;
    public static final int VIDEO_DROP_FRAME_POLICY_FORCE_HALF_FPS = 3;
    public static final int VIDEO_DROP_FRAME_POLICY_NONE = 0;
    private int dropFramePolicy = 0;
    private float realFps = -1.0f;
    private float dstFps = -1.0f;
    private long lastRenderIndex = -1;
    private long willRenderIndex = -1;

    private void updateDstFpsInternal() {
        float f;
        float f2 = this.realFps;
        if (f2 <= 0.0f) {
            Log.d(TAG, "UpdateDstFpsInternal invalid realFps:" + this.realFps);
            return;
        }
        switch (this.dropFramePolicy) {
            case 1:
                if (f2 > 24.0f) {
                    this.dstFps = 24.0f;
                    return;
                }
                return;
            case 2:
                if (f2 <= 31.0f) {
                    return;
                } else {
                    f = 30.0f;
                }
                break;
            case 3:
                f = f2 / 2.0f;
                break;
            case 4:
                if (f2 <= 61.0f) {
                    return;
                } else {
                    f = 60.0f;
                }
                break;
            case 5:
                if (f2 <= 91.0f) {
                    return;
                } else {
                    f = 90.0f;
                }
                break;
            case 6:
                if (f2 <= 121.0f) {
                    return;
                } else {
                    f = 120.0f;
                }
                break;
            default:
                f = -1.0f;
                break;
        }
        this.dstFps = f;
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public long adjustPresentTimeUs(long j) {
        if (this.dropFramePolicy == 0) {
            return j;
        }
        float f = this.realFps;
        if (f <= 0.0f) {
            return j;
        }
        float f2 = this.dstFps;
        return (f2 <= 0.0f || f <= f2) ? j : (long) (((Math.round((j * ((double) f2)) / 1000000.0d) * 1000) * 1000) / this.dstFps);
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public boolean canRender(long j) {
        float f = this.realFps;
        if (f <= 0.0f) {
            return true;
        }
        float f2 = this.dstFps;
        if (f2 <= 0.0f) {
            return true;
        }
        switch (this.dropFramePolicy) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                if (f > f2) {
                    long jRound = Math.round((j * ((double) f2)) / 1000000.0d);
                    this.willRenderIndex = jRound;
                    if (jRound != this.lastRenderIndex) {
                    }
                }
                break;
            case 3:
                if (Math.round((j * ((double) f)) / 1000000.0d) % 2 == 0) {
                }
                break;
        }
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public void doRender() {
        this.lastRenderIndex = this.willRenderIndex;
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public void initialize(int i) {
        Log.d(TAG, "Initialize policy:" + i);
        if (i == this.dropFramePolicy) {
            Log.d(TAG, "initialize with same policy:" + i);
            return;
        }
        this.dstFps = -1.0f;
        this.dropFramePolicy = i;
        this.willRenderIndex = -1L;
        this.lastRenderIndex = -1L;
        updateDstFpsInternal();
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public boolean isAvailable() {
        return (this.dropFramePolicy == 0 || this.dstFps == -1.0f) ? false : true;
    }

    @Override // com.oplus.tbl.exoplayer2.video.DropFrameManager
    public void setRealFps(float f) {
        if (f > 0.0f && f != this.realFps) {
            this.realFps = f;
            this.dstFps = -1.0f;
            updateDstFpsInternal();
        } else {
            Log.d(TAG, "SetRealFps invalid fps:" + f);
        }
    }
}
