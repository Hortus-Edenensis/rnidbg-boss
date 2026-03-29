package com.ss.bytertc.engine.type;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AudioSceneType {
    AUDIO_SCENE_DEFAULT(0),
    AUDIO_SCENE_CHATROOM(1),
    AUDIO_SCENE_HIGH_QUALITY_CHATROOM(2),
    AUDIO_SCENE_LOW_LATENCY(3);

    public final int value;

    AudioSceneType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static AudioSceneType fromId(int i) {
        for (AudioSceneType audioSceneType : values()) {
            if (audioSceneType.value() == i) {
                return audioSceneType;
            }
        }
        return AUDIO_SCENE_DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
