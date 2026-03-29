package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AudioQuality {
    AUDIO_QUALITY_LOW(0),
    AUDIO_QUALITY_MEDIUM(1),
    AUDIO_QUALITY_HIGH(2),
    AUDIO_QUALITY_ULTRA_HIGH(3);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioQuality$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioQuality;

        static {
            int[] iArr = new int[AudioQuality.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioQuality = iArr;
            try {
                iArr[AudioQuality.AUDIO_QUALITY_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_ULTRA_HIGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    AudioQuality(int i) {
        this.value = i;
    }

    @CalledByNative
    public static AudioQuality fromId(int i) {
        for (AudioQuality audioQuality : values()) {
            if (audioQuality.value() == i) {
                return audioQuality;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioQuality[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "kAudioQualityUltraHigh" : "kAudioQualityHigh" : "kAudioQualityMedium" : "kAudioQualityLow";
    }

    public int value() {
        return this.value;
    }
}
