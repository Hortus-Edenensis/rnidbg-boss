package com.ss.bytertc.ktv.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AudioPlayType {
    LOCAL(0),
    REMOTE(1),
    LOCAL_AND_REMOTE(2);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.AudioPlayType$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType;

        static {
            int[] iArr = new int[AudioPlayType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType = iArr;
            try {
                iArr[AudioPlayType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.LOCAL_AND_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    AudioPlayType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static AudioPlayType fromId(int i) {
        for (AudioPlayType audioPlayType : values()) {
            if (audioPlayType.value() == i) {
                return audioPlayType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "AUDIO_PLAY_TYPE_LOCAL_AND_REMOTE" : "AUDIO_PLAY_TYPE_REMOTE" : "AUDIO_PLAY_TYPE_LOCAL";
    }

    public int value() {
        return this.value;
    }
}
