package com.ss.bytertc.engine.type;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VoiceChangerType {
    VOICE_CHANGER_ORIGINAL(0),
    VOICE_CHANGER_GIANT(1),
    VOICE_CHANGER_CHIPMUNK(2),
    VOICE_CHANGER_MINIONST(3),
    VOICE_CHANGER_VIBRATO(4),
    VOICE_CHANGER_ROBOT(5);

    private final int value;

    VoiceChangerType(int i) {
        this.value = i;
    }

    public static VoiceChangerType fromId(int i) {
        for (VoiceChangerType voiceChangerType : values()) {
            if (voiceChangerType.value() == i) {
                return voiceChangerType;
            }
        }
        return VOICE_CHANGER_ORIGINAL;
    }

    public int value() {
        return this.value;
    }
}
