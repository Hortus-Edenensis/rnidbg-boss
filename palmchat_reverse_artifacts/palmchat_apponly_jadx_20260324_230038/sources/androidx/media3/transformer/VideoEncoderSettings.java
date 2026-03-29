package androidx.media3.transformer;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class VideoEncoderSettings {
    public static final VideoEncoderSettings DEFAULT = new Builder().build();
    public static final float DEFAULT_I_FRAME_INTERVAL_SECONDS = 1.0f;
    public static final int NO_VALUE = -1;
    public static final int RATE_UNSET = -2;
    public final int bitrate;
    public final int bitrateMode;
    public final float iFrameIntervalSeconds;
    public final int level;
    public final int maxBFrames;
    public final int numBidirectionalTemporalLayers;
    public final int numNonBidirectionalTemporalLayers;
    public final int operatingRate;
    public final int priority;
    public final int profile;
    public final long repeatPreviousFrameIntervalUs;

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @SuppressLint({"InlinedApi"})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BitrateMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private int bitrate;
        private int bitrateMode;
        private float iFrameIntervalSeconds;
        private int level;
        private int maxBFrames;
        private int numBidirectionalTemporalLayers;
        private int numNonBidirectionalTemporalLayers;
        private int operatingRate;
        private int priority;
        private int profile;
        private long repeatPreviousFrameIntervalUs;

        public VideoEncoderSettings build() {
            return new VideoEncoderSettings(this.bitrate, this.bitrateMode, this.profile, this.level, this.iFrameIntervalSeconds, this.operatingRate, this.priority, this.repeatPreviousFrameIntervalUs, this.maxBFrames, this.numNonBidirectionalTemporalLayers, this.numBidirectionalTemporalLayers);
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setBitrateMode(int i) {
            boolean z = true;
            if (i != 1 && i != 2) {
                z = false;
            }
            Assertions.checkArgument(z);
            this.bitrateMode = i;
            return this;
        }

        public Builder setEncoderPerformanceParameters(int i, int i2) {
            this.operatingRate = i;
            this.priority = i2;
            return this;
        }

        public Builder setEncodingProfileLevel(int i, int i2) {
            this.profile = i;
            this.level = i2;
            return this;
        }

        public Builder setMaxBFrames(int i) {
            this.maxBFrames = i;
            return this;
        }

        public Builder setRepeatPreviousFrameIntervalUs(long j) {
            this.repeatPreviousFrameIntervalUs = j;
            return this;
        }

        public Builder setTemporalLayers(int i, int i2) {
            this.numNonBidirectionalTemporalLayers = i;
            this.numBidirectionalTemporalLayers = i2;
            return this;
        }

        public Builder setiFrameIntervalSeconds(float f) {
            this.iFrameIntervalSeconds = f;
            return this;
        }

        public Builder() {
            this.bitrate = -1;
            this.bitrateMode = 1;
            this.profile = -1;
            this.level = -1;
            this.iFrameIntervalSeconds = 1.0f;
            this.operatingRate = -1;
            this.priority = -1;
            this.repeatPreviousFrameIntervalUs = -1L;
            this.maxBFrames = -1;
            this.numNonBidirectionalTemporalLayers = -1;
            this.numBidirectionalTemporalLayers = -1;
        }

        private Builder(VideoEncoderSettings videoEncoderSettings) {
            this.bitrate = videoEncoderSettings.bitrate;
            this.bitrateMode = videoEncoderSettings.bitrateMode;
            this.profile = videoEncoderSettings.profile;
            this.level = videoEncoderSettings.level;
            this.iFrameIntervalSeconds = videoEncoderSettings.iFrameIntervalSeconds;
            this.operatingRate = videoEncoderSettings.operatingRate;
            this.priority = videoEncoderSettings.priority;
            this.repeatPreviousFrameIntervalUs = videoEncoderSettings.repeatPreviousFrameIntervalUs;
            this.maxBFrames = videoEncoderSettings.maxBFrames;
            this.numNonBidirectionalTemporalLayers = videoEncoderSettings.numNonBidirectionalTemporalLayers;
            this.numBidirectionalTemporalLayers = videoEncoderSettings.numBidirectionalTemporalLayers;
        }
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoEncoderSettings)) {
            return false;
        }
        VideoEncoderSettings videoEncoderSettings = (VideoEncoderSettings) obj;
        return this.bitrate == videoEncoderSettings.bitrate && this.bitrateMode == videoEncoderSettings.bitrateMode && this.profile == videoEncoderSettings.profile && this.level == videoEncoderSettings.level && this.iFrameIntervalSeconds == videoEncoderSettings.iFrameIntervalSeconds && this.operatingRate == videoEncoderSettings.operatingRate && this.priority == videoEncoderSettings.priority && this.repeatPreviousFrameIntervalUs == videoEncoderSettings.repeatPreviousFrameIntervalUs && this.maxBFrames == videoEncoderSettings.maxBFrames && this.numNonBidirectionalTemporalLayers == videoEncoderSettings.numNonBidirectionalTemporalLayers && this.numBidirectionalTemporalLayers == videoEncoderSettings.numBidirectionalTemporalLayers;
    }

    public int hashCode() {
        int iFloatToIntBits = (((((((((((((217 + this.bitrate) * 31) + this.bitrateMode) * 31) + this.profile) * 31) + this.level) * 31) + Float.floatToIntBits(this.iFrameIntervalSeconds)) * 31) + this.operatingRate) * 31) + this.priority) * 31;
        long j = this.repeatPreviousFrameIntervalUs;
        return ((((((iFloatToIntBits + ((int) (j ^ (j >>> 32)))) * 31) + this.maxBFrames) * 31) + this.numNonBidirectionalTemporalLayers) * 31) + this.numBidirectionalTemporalLayers;
    }

    public String toString() {
        return "VideoEncoderSettings{bitrate=" + this.bitrate + ", bitrateMode=" + this.bitrateMode + ", profile=" + this.profile + ", level=" + this.level + ", iFrameIntervalSeconds=" + this.iFrameIntervalSeconds + ", operatingRate=" + this.operatingRate + ", priority=" + this.priority + ", repeatPreviousFrameIntervalUs=" + this.repeatPreviousFrameIntervalUs + ", maxBFrames=" + this.maxBFrames + ", numNonBidirectionalTemporalLayers=" + this.numNonBidirectionalTemporalLayers + ", numBidirectionalTemporalLayers=" + this.numBidirectionalTemporalLayers + '}';
    }

    private VideoEncoderSettings(int i, int i2, int i3, int i4, float f, int i5, int i6, long j, int i7, int i8, int i9) {
        this.bitrate = i;
        this.bitrateMode = i2;
        this.profile = i3;
        this.level = i4;
        this.iFrameIntervalSeconds = f;
        this.operatingRate = i5;
        this.priority = i6;
        this.repeatPreviousFrameIntervalUs = j;
        this.maxBFrames = i7;
        this.numNonBidirectionalTemporalLayers = i8;
        this.numBidirectionalTemporalLayers = i9;
    }
}
