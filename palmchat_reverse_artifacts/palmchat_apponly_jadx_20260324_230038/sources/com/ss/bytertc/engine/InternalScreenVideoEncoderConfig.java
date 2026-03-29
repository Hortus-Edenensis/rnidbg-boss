package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.ScreenVideoEncoderConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class InternalScreenVideoEncoderConfig {
    public InternalScreenVideoEncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxBitrate;
    public int minBitrate;
    public int width;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.InternalScreenVideoEncoderConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$ScreenVideoEncoderConfig$EncoderPreference;

        static {
            int[] iArr = new int[ScreenVideoEncoderConfig.EncoderPreference.values().length];
            $SwitchMap$com$ss$bytertc$engine$ScreenVideoEncoderConfig$EncoderPreference = iArr;
            try {
                iArr[ScreenVideoEncoderConfig.EncoderPreference.MaintainFramerate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$ScreenVideoEncoderConfig$EncoderPreference[ScreenVideoEncoderConfig.EncoderPreference.MaintainQuality.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum InternalScreenVideoEncoderPreference {
        SCREEN_VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE(1),
        SCREEN_VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY(2);

        private int value;

        InternalScreenVideoEncoderPreference(int i) {
            this.value = i;
        }

        @CalledByNative("InternalScreenVideoEncoderPreference")
        public int getIntValue() {
            return this.value;
        }
    }

    public InternalScreenVideoEncoderConfig(ScreenVideoEncoderConfig screenVideoEncoderConfig) {
        this.minBitrate = 0;
        this.encodePreference = InternalScreenVideoEncoderPreference.SCREEN_VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        this.width = screenVideoEncoderConfig.width;
        this.height = screenVideoEncoderConfig.height;
        this.frameRate = screenVideoEncoderConfig.frameRate;
        this.maxBitrate = screenVideoEncoderConfig.maxBitrate;
        this.minBitrate = screenVideoEncoderConfig.minBitrate;
        this.encodePreference = ConvertEnumValue(screenVideoEncoderConfig.encodePreference);
    }

    private InternalScreenVideoEncoderPreference ConvertEnumValue(ScreenVideoEncoderConfig.EncoderPreference encoderPreference) {
        InternalScreenVideoEncoderPreference internalScreenVideoEncoderPreference = InternalScreenVideoEncoderPreference.SCREEN_VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$ScreenVideoEncoderConfig$EncoderPreference[encoderPreference.ordinal()];
        return (i == 1 || i != 2) ? internalScreenVideoEncoderPreference : InternalScreenVideoEncoderPreference.SCREEN_VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY;
    }

    @CalledByNative
    public InternalScreenVideoEncoderPreference getEncoderPreference() {
        return this.encodePreference;
    }

    @CalledByNative
    public int getFrameRate() {
        return this.frameRate;
    }

    @CalledByNative
    public int getHeight() {
        return this.height;
    }

    @CalledByNative
    public int getMaxKBps() {
        return this.maxBitrate;
    }

    @CalledByNative
    public int getMinKBps() {
        return this.minBitrate;
    }

    @CalledByNative
    public int getWidth() {
        return this.width;
    }
}
