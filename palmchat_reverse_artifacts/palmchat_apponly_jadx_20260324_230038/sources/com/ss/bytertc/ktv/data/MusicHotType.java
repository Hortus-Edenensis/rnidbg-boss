package com.ss.bytertc.ktv.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MusicHotType {
    CONTENT_CENTER(1),
    PROJECT(2);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.MusicHotType$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$MusicHotType;

        static {
            int[] iArr = new int[MusicHotType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$MusicHotType = iArr;
            try {
                iArr[MusicHotType.CONTENT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$MusicHotType[MusicHotType.PROJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    MusicHotType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static MusicHotType fromId(int i) {
        for (MusicHotType musicHotType : values()) {
            if (musicHotType.value() == i) {
                return musicHotType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$MusicHotType[ordinal()];
        return i != 1 ? i != 2 ? "" : "PROJECT_RANK" : "CONTENT_CENTER_RANK";
    }

    public int value() {
        return this.value;
    }
}
