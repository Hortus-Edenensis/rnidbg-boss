package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AudioMixingDualMonoMode {
    AUDIO_MIXING_DUAL_MONO_MODE_AUTO(0),
    AUDIO_MIXING_DUAL_MONO_MODE_L(1),
    AUDIO_MIXING_DUAL_MONO_MODE_R(2),
    AUDIO_MIXING_DUAL_MONO_MODE_MIX(3);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioMixingDualMonoMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode;

        static {
            int[] iArr = new int[AudioMixingDualMonoMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode = iArr;
            try {
                iArr[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_L.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_R.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_MIX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    AudioMixingDualMonoMode(int i) {
        this.value = i;
    }

    @CalledByNative
    public static AudioMixingDualMonoMode fromId(int i) {
        for (AudioMixingDualMonoMode audioMixingDualMonoMode : values()) {
            if (audioMixingDualMonoMode.value() == i) {
                return audioMixingDualMonoMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "AUDIO_MIXING_DUAL_MONO_MODE_MIX" : "AUDIO_MIXING_DUAL_MONO_MODE_R" : "AUDIO_MIXING_DUAL_MONO_MODE_L" : "AUDIO_MIXING_DUAL_MONO_MODE_AUTO";
    }

    public int value() {
        return this.value;
    }
}
