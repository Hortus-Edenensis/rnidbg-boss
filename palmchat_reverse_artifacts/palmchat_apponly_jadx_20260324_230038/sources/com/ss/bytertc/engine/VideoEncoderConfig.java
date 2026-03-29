package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoEncoderConfig {
    public EncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxBitrate;
    public int minBitrate;
    public int width;

    /* JADX INFO: compiled from: SearchBox */
    public enum CodecMode {
        CODEC_MODE_AUTO(0),
        CODEC_MODE_HARDWARE(1),
        CODEC_MODE_SOFTWARE(2);

        private int value;

        CodecMode(int i) {
            this.value = i;
        }

        public static CodecMode convertFromInt(int i) {
            return values()[i];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum EncoderPreference {
        DISABLED(0),
        MAINTAIN_FRAMERATE(1),
        MAINTAIN_QUALITY(2),
        BALANCE(3);

        private int value;

        EncoderPreference(int i) {
            this.value = i;
        }

        public static EncoderPreference convertFromInt(int i) {
            return values()[i];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum VideoCodecType {
        CODEC_TYPE_AUTO(0),
        CODEC_TYPE_H264(1),
        CODEC_TYPE_BYTEVC1(2);

        private int value;

        VideoCodecType(int i) {
            this.value = i;
        }

        public static VideoCodecType convertFromInt(int i) {
            return values()[i];
        }

        public int getValue() {
            return this.value;
        }
    }

    public VideoEncoderConfig() {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
    }

    @CalledByNative
    private static VideoEncoderConfig create(int i, int i2, int i3, int i4, int i5) {
        return new VideoEncoderConfig(i, i2, i3, i4, i5);
    }

    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "VideoEncoderConfig{width=" + this.width + "height=" + this.height + ", frameRate=" + this.frameRate + ", maxBitrate=" + this.maxBitrate + ", minBitrate=" + this.minBitrate + ", encodePreference=" + this.encodePreference + '}';
    }

    public VideoEncoderConfig(int i, int i2, int i3, int i4, int i5) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = i;
        this.height = i2;
        this.frameRate = i3;
        this.maxBitrate = i4;
        this.minBitrate = i5;
    }

    public VideoEncoderConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = i;
        this.height = i2;
        this.frameRate = i3;
        this.maxBitrate = i4;
        this.minBitrate = i5;
        this.encodePreference = EncoderPreference.convertFromInt(i8);
    }
}
