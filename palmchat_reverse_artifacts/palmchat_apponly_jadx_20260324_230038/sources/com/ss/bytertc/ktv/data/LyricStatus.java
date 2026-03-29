package com.ss.bytertc.ktv.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum LyricStatus {
    NONE(0),
    KRC(1),
    LRC(2),
    KRC_AND_LRC(4);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.LyricStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus;

        static {
            int[] iArr = new int[LyricStatus.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus = iArr;
            try {
                iArr[LyricStatus.KRC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.LRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.KRC_AND_LRC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    LyricStatus(int i) {
        this.value = i;
    }

    @CalledByNative
    public static LyricStatus fromId(int i) {
        for (LyricStatus lyricStatus : values()) {
            if (lyricStatus.value() == i) {
                return lyricStatus;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "LYRIC_STATUS_NONE" : "LYRIC_STATUS_KRC_AND_LRC" : "LYRIC_STATUS_LRC" : "LYRIC_STATUS_KRC";
    }

    public int value() {
        return this.value;
    }
}
