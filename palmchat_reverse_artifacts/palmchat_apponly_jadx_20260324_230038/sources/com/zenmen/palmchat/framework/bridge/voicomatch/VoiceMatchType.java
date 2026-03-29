package com.zenmen.palmchat.framework.bridge.voicomatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public enum VoiceMatchType {
    NORMAL(1000),
    FAST(1001),
    SAME_CITY(1002),
    INVITE_VIDEO(1003);

    public int type;

    VoiceMatchType(int i) {
        this.type = i;
    }

    public static VoiceMatchType buildFromType(int i) {
        for (VoiceMatchType voiceMatchType : values()) {
            if (voiceMatchType.type == i) {
                return voiceMatchType;
            }
        }
        return NORMAL;
    }
}
