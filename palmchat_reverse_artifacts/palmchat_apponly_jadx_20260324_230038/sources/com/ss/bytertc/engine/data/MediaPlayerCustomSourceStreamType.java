package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MediaPlayerCustomSourceStreamType {
    RAW(0),
    ENCODED(1);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceStreamType$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType;

        static {
            int[] iArr = new int[MediaPlayerCustomSourceStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType = iArr;
            try {
                iArr[MediaPlayerCustomSourceStreamType.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[MediaPlayerCustomSourceStreamType.ENCODED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    MediaPlayerCustomSourceStreamType(int i) {
        this.value = i;
    }

    public static MediaPlayerCustomSourceStreamType fromId(int i) {
        for (MediaPlayerCustomSourceStreamType mediaPlayerCustomSourceStreamType : values()) {
            if (mediaPlayerCustomSourceStreamType.value() == i) {
                return mediaPlayerCustomSourceStreamType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[ordinal()];
        return i != 1 ? i != 2 ? "" : "ENCODED" : "RAW";
    }

    public int value() {
        return this.value;
    }
}
