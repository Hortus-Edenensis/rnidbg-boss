package com.oplus.tblplayer.configure;

import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LoadConfig {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS_FOR_DYNAMIC_WALLPAPER = 10000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_BUFFER_FOR_START_PLAYBACK_MS = 500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_LOW_MEMORY_MIN_BUFFER_MS = 15000;
    public static final int DEFAULT_LOW_MEMORY_TARGET_BUFFER_SIZE = 37748736;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;
    public final long backBufferDurationUs;
    public final long bufferForPlaybackAfterRebufferUs;
    public final long bufferForPlaybackUs;
    public final long maxBufferUs;
    public final long minBufferUs;
    public final boolean prioritizeTimeOverSizeThresholds;
    public final boolean retainBackBufferFromKeyframe;
    public final int targetBufferBytesOverwrite;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private int backBufferDurationMs;
        private int bufferForPlaybackAfterRebufferMs;
        private int bufferForPlaybackMs;
        private boolean buildCalled;
        private int maxBufferMs;
        private int minBufferMs;
        private boolean prioritizeTimeOverSizeThresholds;
        private boolean retainBackBufferFromKeyframe;
        private int targetBufferBytes;

        public Builder() {
            this.minBufferMs = 50000;
            this.maxBufferMs = 50000;
            this.bufferForPlaybackMs = 2500;
            this.bufferForPlaybackAfterRebufferMs = 5000;
            this.targetBufferBytes = -1;
            this.prioritizeTimeOverSizeThresholds = false;
            this.backBufferDurationMs = 0;
            this.retainBackBufferFromKeyframe = false;
        }

        public LoadConfig build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new LoadConfig(this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }

        public Builder setBackBuffer(int i, boolean z) {
            Assertions.checkState(!this.buildCalled);
            LoadConfig.assertGreaterOrEqual(i, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = i;
            this.retainBackBufferFromKeyframe = z;
            return this;
        }

        public Builder setBufferDurationsMs(int i, int i2, int i3, int i4) {
            Assertions.checkState(!this.buildCalled);
            LoadConfig.assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
            LoadConfig.assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            LoadConfig.assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
            LoadConfig.assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            LoadConfig.assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
            this.minBufferMs = i;
            this.maxBufferMs = i2;
            this.bufferForPlaybackMs = i3;
            this.bufferForPlaybackAfterRebufferMs = i4;
            return this;
        }

        public Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.prioritizeTimeOverSizeThresholds = z;
            return this;
        }

        public Builder setTargetBufferBytes(int i) {
            Assertions.checkState(!this.buildCalled);
            this.targetBufferBytes = i;
            return this;
        }

        private Builder(@NonNull LoadConfig loadConfig) {
            this.minBufferMs = (int) C.usToMs(loadConfig.minBufferUs);
            this.maxBufferMs = (int) C.usToMs(loadConfig.maxBufferUs);
            this.bufferForPlaybackMs = (int) C.usToMs(loadConfig.bufferForPlaybackUs);
            this.bufferForPlaybackAfterRebufferMs = (int) C.usToMs(loadConfig.bufferForPlaybackAfterRebufferUs);
            this.targetBufferBytes = loadConfig.targetBufferBytesOverwrite;
            this.prioritizeTimeOverSizeThresholds = loadConfig.prioritizeTimeOverSizeThresholds;
            this.backBufferDurationMs = (int) C.usToMs(loadConfig.backBufferDurationUs);
            this.retainBackBufferFromKeyframe = loadConfig.retainBackBufferFromKeyframe;
        }
    }

    private LoadConfig(int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i6, 0, "backBufferDurationMs", "0");
        this.minBufferUs = C.msToUs(i);
        this.maxBufferUs = C.msToUs(i2);
        this.bufferForPlaybackUs = C.msToUs(i3);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs(i4);
        this.targetBufferBytesOverwrite = i5;
        this.prioritizeTimeOverSizeThresholds = z;
        this.backBufferDurationUs = C.msToUs(i6);
        this.retainBackBufferFromKeyframe = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertGreaterOrEqual(int i, int i2, String str, String str2) {
        Assertions.checkArgument(i >= i2, str + " cannot be less than " + str2);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public String toString() {
        return "LoadConfig{minBufferUs=" + this.minBufferUs + ", maxBufferUs=" + this.maxBufferUs + ", bufferForPlaybackUs=" + this.bufferForPlaybackUs + ", bufferForPlaybackAfterRebufferUs=" + this.bufferForPlaybackAfterRebufferUs + ", targetBufferBytesOverwrite=" + this.targetBufferBytesOverwrite + ", prioritizeTimeOverSizeThresholds=" + this.prioritizeTimeOverSizeThresholds + ", backBufferDurationUs=" + this.backBufferDurationUs + ", retainBackBufferFromKeyframe=" + this.retainBackBufferFromKeyframe + "}";
    }
}
