package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MediaPlayerCustomSourceMode {
    PUSH(0),
    PULL(1);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode;

        static {
            int[] iArr = new int[MediaPlayerCustomSourceMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode = iArr;
            try {
                iArr[MediaPlayerCustomSourceMode.PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[MediaPlayerCustomSourceMode.PULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    MediaPlayerCustomSourceMode(int i) {
        this.value = i;
    }

    public static MediaPlayerCustomSourceMode fromId(int i) {
        for (MediaPlayerCustomSourceMode mediaPlayerCustomSourceMode : values()) {
            if (mediaPlayerCustomSourceMode.value() == i) {
                return mediaPlayerCustomSourceMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[ordinal()];
        return i != 1 ? i != 2 ? "" : "PULL" : "PUSH";
    }

    public int value() {
        return this.value;
    }
}
